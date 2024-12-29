# Usar a imagem oficial do Node.js 18 como base
FROM node:18

# Definir o diretório de trabalho dentro do container
WORKDIR /usr/src/app

# Copiar o package.json e package-lock.json primeiro para instalar as dependências
COPY ./api-node/package*.json ./

# Instalar as dependências do projeto
RUN npm install

# Copiar o restante do código da aplicação para o container
COPY ./api-node .

# Expor a porta que a aplicação irá rodar (por padrão, o Node.js geralmente usa a porta 3000)
EXPOSE 3000

# Definir o comando para iniciar a aplicação Node.js
CMD ["npm", "start"]
