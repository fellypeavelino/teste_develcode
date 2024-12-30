# teste_develcode
projeto springboot

# Sistema de Pedido de Compra

Este projeto é composto por dois microsserviços: `checkout` e `payment_gateway`, que trabalham juntos para criar e processar pedidos de compra. O pedido é cancelado automaticamente caso o pagamento falhe.


## Instruções para Inicialização

### Pré-requisitos

- **Docker** e **Docker Compose** instalados.
- Java 17+ para o microsserviço `checkout`.
- Node.js 18+ para o microsserviço `payment_gateway`.

### Passo a Passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu_usuario/teste_develcode.git
   cd teste_develcode

## Endpoints

### 1. **POST /api/pedidos**

Esse endpoint cria um pedido de compra.

#### Requisição

- **URL**: `/api/pedidos`
- **Método**: `POST`
- **Headers**: 
  - `Content-Type`: `application/json`
- **Body** (JSON):

```json pay-load
{
  "descricao": "Pedido teste",
  "valor": 100.0
}
```

#### Resposta

```json reponse 
{
    "id": 21,
    "descricao": "Pedido teste",
    "valor": 100.0,
    "status": "APROVADO",
    "dataCriacao": "2024-12-29T18:53:19.3248308"
}
```