/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develcode.develcode.service;

import com.develcode.develcode.dto.PaymentRequest;
import com.develcode.develcode.dto.PaymentResponse;
import com.develcode.develcode.entity.Pedido;
import com.develcode.develcode.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author felly
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PaymentGatewayService paymentGatewayClient;
    
    public Pedido criarPedido(Pedido pedido) {
        pedido.setStatus("PENDENTE");
        Pedido novoPedido = pedidoRepository.save(pedido);

        // Enviar pedido ao serviço de pagamento
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setPedidoId(novoPedido.getId());
        paymentRequest.setValor(novoPedido.getValor());

        PaymentResponse paymentResponse = paymentGatewayClient.processPaymentCurl(paymentRequest);

        // Atualizar status com base no pagamento
        if (paymentResponse.isSucesso()) {
            novoPedido.setStatus("APROVADO");
        } else {
            novoPedido.setStatus("CANCELADO");
        }

        return pedidoRepository.save(novoPedido);
    }
}
