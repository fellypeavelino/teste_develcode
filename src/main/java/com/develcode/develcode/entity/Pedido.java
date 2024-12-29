/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.develcode.develcode.entity;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

import jakarta.persistence.Id;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
/**
 *
 * @author felly
 */
@Entity
@Data
@Table
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo 'descricao' não pode ser nulo.")
    private String descricao;
    @NotNull(message = "O campo 'valor' não pode ser nulo.")
    private Double valor;
    
    private String status; // PENDENTE, APROVADO, CANCELADO

    private LocalDateTime dataCriacao = LocalDateTime.now();
}
