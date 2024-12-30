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

/**
 * @swagger
 * /process-payment:
 *   post:
 *     summary: Processa um pagamento
 *     description: Endpoint que processa pagamentos para pedidos. Requer o cabeçalho Authorization.
 *     requestBody:
 *       required: true
 *       content:
 *         application/json:
 *           schema:
 *             type: object
 *             properties:
 *               orderId:
 *                 type: integer
 *                 description: ID único do pedido.
 *                 example: 12345
 *               amount:
 *                 type: number
 *                 description: Valor total do pagamento.
 *                 example: 100.50
 *     responses:
 *       200:
 *         description: Pagamento processado com sucesso.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 *                   example: Payment processed successfully
 *       400:
 *         description: Cabeçalho Authorization está ausente.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 *                   example: Authorization header is missing
 *       401:
 *         description: Token de autorização inválido.
 *         content:
 *           application/json:
 *             schema:
 *               type: object
 *               properties:
 *                 message:
 *                   type: string
 *                   example: Invalid Authorization token
 */
app.post('/process-payment', (req, res) => {
    const { pedidoId, valor } = req.body;
    // Captura o valor do cabeçalho Authorization
    const authorizationHeader = req.headers['authorization'];

    if (!authorizationHeader) {
        return res.status(400).json({ message: 'Authorization header is missing' });
    }

    console.log('Authorization:', authorizationHeader);

    // Valida o valor do cabeçalho Authorization
    if (authorizationHeader !== 'develcode') {
        return res.status(401).json({ message: 'Invalid Authorization token' });
    }

    // Simular processamento de pagamento
    const sucesso = Math.random() > 0.5; // 50% de chance de sucesso
    console.log(sucesso,  pedidoId, valor );
    res.json({ sucesso });
});

app.listen(3000, () => {
    console.log('Payment Gateway rodando na porta 3000');
});

