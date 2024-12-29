/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.develcode.develcode.repository;

import com.develcode.develcode.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author felly
 */
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    
}
