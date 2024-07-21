# ChatGPT Service [![Java CI with Maven](https://github.com/daily-coding-problem/chatgpt-springboot-starter/actions/workflows/maven.yml/badge.svg)](https://github.com/daily-coding-problem/chatgpt-springboot-starter/actions/workflows/maven.yml)

![Docker](https://img.shields.io/badge/-Docker-2496ED?style=flat-square&logo=Docker&logoColor=white)
![Linux](https://img.shields.io/badge/-Linux-FCC624?style=flat-square&logo=linux&logoColor=black)
![Java](https://img.shields.io/badge/-Java-007396?style=flat-square&logo=java&logoColor=white)
![Spring](https://img.shields.io/badge/-Spring-6DB33F?style=flat-square&logo=spring&logoColor=white)

ChatGPT Service is a modular service that exposes an API to interact with ChatGPT.

## Table of Contents

- [Features](#features)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Configuration](#configuration)
- [Usage](#usage)
- [License](#license)

## Features

- **API Endpoints**: Provides endpoints to send interact with ChatGPT.
- **Docker Support**: Can be run in a Docker container.
- **Logging**: Logs information to the console.
- **Testing**: Includes unit tests for the service.

## Prerequisites

Before you begin, ensure you have met the following requirements:

- Docker and Docker Compose installed on your machine.
- Java 22 or higher installed on your machine.
- Maven installed on your machine.

## Installation

**Clone the Repository**

```sh
git clone https://github.com/daily-coding-problem/chatgpt-springboot-starter.git
cd chatgpt-springboot-starter
```

**Install Dependencies**

```sh
mvn -ntp dependency:go-offline
```

**Setup Docker**

If you would like to use Docker, ensure Docker and Docker Compose are installed on your machine. If not, follow the installation guides for [Docker](https://docs.docker.com/get-docker/) and [Docker Compose](https://docs.docker.com/compose/install/).

**Build Docker Images**

```sh
docker compose build chatgpt-service
```

## Configuration

**Environment Variables**

Create a `.env` file in the project root with the content found in the [`.env.example`](/.env.example) file.

## Usage

Start the service with Docker:

```sh
docker compose up -d chatgpt-service && docker compose logs -f chatgpt-service
```

Or without Docker:

```sh
mvn spring-boot:run
```

## Running Tests

Run the tests with the following command:

```sh
mvn test -Dspring.profiles.active=test
```

### Test the GitHub Actions via _Docker_

To test the GitHub Actions via _Docker_, execute the following:

```sh
docker compose down -v && docker compose up --build github-action-maven-test
```

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
