# RESTful API for Communication Platform

![Java](https://img.shields.io/badge/Java-17-orange) ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green) [![LinkedIn](https://img.shields.io/badge/Connect%20on-LinkedIn-blue)](https://www.linkedin.com/in/gabrieudev) ![GPL License](https://img.shields.io/badge/License-GPL-blue)

Welcome to my solution for the challenge of creating a **RESTful API for a communication platform**. 

Please select your preferred language:

- [English](README.md)
- [Português (Brasil)](README.pt-br.md)

See the details about the proposed challenge in the selection process at [PROBLEM.md](PROBLEM.md).

## Table of Contents

- [Introduction](#introduction)
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Contributions](#contributions)
- [Contact](#contact)

## Introduction

This project was created as part of a backend challenge proposed in a selection process by the company Magalu, where it is necessary to develop a RESTful API for a communication platform.

## Features

- Scheduling communication delivery.
- Checking the status of a schedule.
- Integration with MySQL database.
- Documentation with Swagger.

## Technologies

- ![Java](https://img.shields.io/badge/Java-17-orange): Programming language.
- ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3-green): Framework used for building applications.
- ![MySQL](https://img.shields.io/badge/MySQL-Database-blue): Relational database.

## Getting Started

Follow these steps to run the project on your machine:

1. Clone the repository: `git clone https://github.com/gabrieudev/magalu.git`
2. Navigate to the project directory: `cd <path>`
3. Navigate to the docker directory: `cd docker`
4. Run the docker compose file to create and start the MySQL container: `docker compose up`
5. Go back to the initial directory: `cd <path>`
6. Build the project: `./mvnw clean install` (for Windows: `mvnw.cmd clean install`)
7. Run the application: `./mvnw spring-boot:run` (for Windows: `mvnw.cmd spring-boot:run`)

## Endpoints

- `POST /communications`: Schedules a communication delivery.
- `GET /communications/{communicationId}`: Gets details of a communication by id.
- `GET /communications`: Gets details of all communications.
- `PUT /communications/{communicationId}`: Updates a communication.
- `DELETE /communications/{communicationId}`: Deletes a communication.

Access the full documentation at the `/swagger-ui.html` endpoint.

## Contributions

Contributions are very welcome! If you would like to contribute, fork the repository and create a pull request.

## Contact

If you have any suggestions or questions, please contact me on [LinkedIn](https://www.linkedin.com/in/gabrieudev)

---

**License:** This project is licensed under the terms of the [GNU General Public License (GPL)](LICENSE).