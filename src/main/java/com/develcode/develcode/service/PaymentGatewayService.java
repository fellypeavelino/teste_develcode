/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.develcode.develcode.service;

import com.develcode.develcode.dto.PaymentRequest;
import com.develcode.develcode.dto.PaymentResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author felly
 */
@Service
public class PaymentGatewayService {
    
    private static final String PAYMENT_GATEWAY_URL = "http://localhost:3000/process-payment";
    @Autowired
    private IPaymentGatewayClient paymentGatewayClient;
    
    public PaymentResponse processPayment (PaymentRequest paymentRequest) {
        return paymentGatewayClient.processPayment(paymentRequest);
    }
    

    private OkHttpClient client = new OkHttpClient();

    private ObjectMapper objectMapper = new ObjectMapper();

    public PaymentResponse processPaymentCurl(PaymentRequest paymentRequest) {
        try {
            // Serializa o PaymentRequest para JSON
            String jsonBody = objectMapper.writeValueAsString(paymentRequest);

            // Configura o corpo da requisição
            MediaType mediaType = MediaType.parse("application/json");
            RequestBody body = RequestBody.create(mediaType, jsonBody);

            // Cria a requisição HTTP
            Request request = new Request.Builder()
                    .url(PAYMENT_GATEWAY_URL)
                    .post(body)
                    .build();

            // Envia a requisição e obtém a resposta
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    // Converte o JSON de resposta em um PaymentResponse
                    return objectMapper.readValue(response.body().string(), PaymentResponse.class);
                } else {
                    throw new RuntimeException("Erro ao processar pagamento: Código " + response.code());
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro na comunicação com o gateway de pagamento", e);
        }
    }
}
