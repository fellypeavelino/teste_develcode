/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develcode.develcode;

/**
 *
 * @author felly
 */
import com.develcode.develcode.controller.PedidoController;
import com.develcode.develcode.dto.PedidoDTO;
import com.develcode.develcode.entity.Pedido;
import com.develcode.develcode.service.PedidoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {

    @Mock
    private PedidoService pedidoService;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    private PedidoController pedidoController;

    @Test
    public void testCriarPedido_Sucesso() {
        // Mock do DTO de entrada
        PedidoDTO pedidoDTO = new PedidoDTO();
        pedidoDTO.setDescricao("Pedido Teste");
        pedidoDTO.setValor(100.0);

        // Mock do retorno do serviço
        Pedido pedidoMock = new Pedido();
        pedidoMock.setId(1L);
        pedidoMock.setDescricao("Pedido Teste");
        pedidoMock.setValor(100.0);
        pedidoMock.setStatus("APROVADO");

        when(pedidoService.criarPedido(any(Pedido.class))).thenReturn(pedidoMock);
        when(modelMapper.map(any(PedidoDTO.class), eq(Pedido.class))).thenReturn(pedidoMock);

        // Execução do teste
        ResponseEntity<Pedido> response = pedidoController.criarPedido(pedidoDTO);

        // Verificações
        assertNotNull(response);
        assertEquals(201, response.getStatusCodeValue()); // Verificando o status 201
        assertNotNull(response.getBody());
        assertEquals("Pedido Teste", response.getBody().getDescricao());
        assertEquals(100.0, response.getBody().getValor());
        assertEquals("APROVADO", response.getBody().getStatus());

        verify(pedidoService, times(1)).criarPedido(any(Pedido.class));
        verify(modelMapper, times(1)).map(any(PedidoDTO.class), eq(Pedido.class));
    }

}
