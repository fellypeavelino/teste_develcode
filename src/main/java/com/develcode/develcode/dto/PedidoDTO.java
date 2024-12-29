/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develcode.develcode.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

/**
 *
 * @author felly
 */
@Data
public class PedidoDTO {
    @NotNull(message = "O campo 'descricao' não pode ser nulo.")
    private String descricao;
    @NotNull(message = "O campo 'valor' não pode ser nulo.")
    private Double valor;
}
