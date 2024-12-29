/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.develcode.develcode.service;

import com.develcode.develcode.dto.PaymentRequest;
import com.develcode.develcode.dto.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author felly
 */
@FeignClient(name = "paymentGateway", url = "http://localhost:3000")
public interface IPaymentGatewayClient {
    @PostMapping("/process-payment")
    PaymentResponse processPayment(@RequestBody PaymentRequest request);
}
