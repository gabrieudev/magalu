# API RESTful para plataforma de comunicação

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Seja bem vindo(a) à minha resolução do desafio de elaborar uma **API RESTful para plataforma de comunicação**. Veja os detalhes sobre o desafio proposto no processo seletivo em [PROBLEM.pt-br.md](PROBLEM.pt-br.md).

## Tabela de conteúdos

- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
- [Tecnologias](#tecnologias)
- [Iniciando](#iniciando)
- [Endpoints](#endpoints)
- [Contribuições](#contribuições)
- [Contato](#contato)

## Introdução

Este projeto foi criado à partir de um desafio backend, proposto em um processo seletivo da empresa Magalu, onde é necessário elaborar uma API RESTful para uma plataforma de comunicação.

## Funcionalidades

- Agendamento de envio de comunicação.
- Consulta de status do agendamento.
- Integração com o banco de dados MySQL.
- Documentação com Swagger.

## Tecnologias

- ![Java](https://img.shields.io/badge/Java-17-orange): Linguagem de programação.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework usado para a construção de aplicações.
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue): Banco de dados relacional.

## Iniciando

Siga esses passos para executar o projeto na sua máquina:

1. Clone o repositório: `git clone https://github.com/gabrieudev/magalu.git`
2. Navegue para o diretório do projeto: `cd <caminho>`
3. Navegue para o diretório docker: `cd docker`
4. Execute o arquivo docker compose para criar e inicializar o container MySQL: `docker compose up`
5. Volte para o diretório inicial: `cd <caminho>`
6. Construa o projeto: `./mvnw clean install` (para Windows: `mvnw.cmd clean install`)
7. Execute a aplicação: `./mvnw spring-boot:run` (para Windows: `mvnw.cmd spring-boot:run`)

## Endpoints

- `POST /communications`: Faz o agendamneto de envio de uma comunicação.
- `GET /communications/{communicationId}`: Obtém detalhes de uma comunicação por id.
- `GET /communications`: Obtém detalhes de todas comunicações.
- `PUT /communications/{communicationId}`: Atualiza uma comunicação.
- `DELETE /communications/{communicationId}`: Deleta uma comunicação.

Acesse a documentação completa no endpoint `/swagger-ui.html`

## Contribuições

Contribuições são muito bem vindas! Caso queira contribuir, faça um fork do repositório e crie um pull request.

## Contato

Caso tenha alguma sugestão ou dúvida, entre em contato comigo em [LinkedIn](https://www.linkedin.com/in/gabrieudev)

---

**Licença:** Esse projeto é licenciado sob os termos da [GNU General Public License (GPL)](LICENSE).
