# teste_develcode
projeto springboot

# Sistema de Pedido de Compra

Este projeto é composto por dois microsserviços: `checkout` e `payment_gateway`, que trabalham juntos para criar e processar pedidos de compra. O pedido é cancelado automaticamente caso o pagamento falhe.

## Endpoints

### 1. **POST /checkout/criarPedido**

Esse endpoint cria um pedido de compra.

#### Requisição

- **URL**: `/checkout/criarPedido`
- **Método**: `POST`
- **Headers**: 
  - `Content-Type`: `application/json`
- **Body** (JSON):

```json pay-load
{
  "descricao": "Pedido teste",
  "valor": 100.0
}

```json reponse 
{
    "id": 21,
    "descricao": "Pedido teste",
    "valor": 100.0,
    "status": "APROVADO",
    "dataCriacao": "2024-12-29T18:53:19.3248308"
}