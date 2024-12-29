/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */
const express = require('express');
const app = express();
const swaggerUi = require('swagger-ui-express');
const swaggerJsDoc = require('swagger-jsdoc');

// Configuração do Swagger
const swaggerOptions = {
    definition: {
        openapi: "3.0.0",
        info: {
            title: "API Documentation",
            version: "1.0.0",
            description: "API para exemplo"
        },
        servers: [
            {
                url: "http://localhost:3000",
            },
        ],
    },
    apis: ["./routes/*.js"], // Arquivos que contêm definições de rota
};

const swaggerDocs = swaggerJsDoc(swaggerOptions);
app.use('/api-docs', swaggerUi.serve, swaggerUi.setup(swaggerDocs));

app.use(express.json());

app.post('/process-payment', (req, res) => {
    const { pedidoId, valor } = req.body;

    // Simular processamento de pagamento
    const sucesso = Math.random() > 0.5; // 50% de chance de sucesso
    console.log(sucesso,  pedidoId, valor );
    res.json({ sucesso });
});

app.listen(3000, () => {
    console.log('Payment Gateway rodando na porta 3000');
});

