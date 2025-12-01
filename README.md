# MicroServicesFlightApp

A sample microservices-based flight booking system built with Spring Boot and Maven. This repository contains a set of cooperating services, an API gateway, configuration server, service registry, and supporting utilities used for development, testing, and deployment.

**Status:** Example/assignment project — use for learning and experimentation.

---

**Table of Contents**

- Project Overview
- Tech Stack
- Repository Structure
- Prerequisites
- Build & Run (individual services)
- Run with Docker Compose
- Testing
- SonarQube / Code Quality
- Contributing
- Troubleshooting
- License

---

## Project Overview

This project demonstrates a microservices architecture for a flight booking scenario. Services are separated by responsibility (flight, passenger, ticketing, email notifications) and communicate through well-defined APIs. The repository includes:

- API Gateway (`api-gateway`) — central entry point for external clients
- Configuration Server (`ConfigServer`) — centralizes configuration for services
- Service Registry (`service-registry`) — enables service discovery (Eureka/Consul style)
- `flight-service` — manages flights and schedules
- `passenger-service` — manages passenger information
- `ticket-service` — handles booking and ticket lifecycle
- `email-service` — sends email notifications

Each service is a standalone Spring Boot application with its own `pom.xml` and can be run independently or together via `docker-compose`.

## Tech Stack

- Java (11+ recommended)
- Spring Boot
- Maven (wrapper included)
- Docker & Docker Compose
- SonarQube (project contains `sonar-project.properties`)

## Repository Structure

Top-level folders (each is a Maven module / Spring Boot app):

- `api-gateway/`
- `ConfigServer/`
- `service-registry/`
- `flight-service/`
- `passenger-service/`
- `ticket-service/`
- `email-service/`
- project root contains `docker-compose.yml`, `pom.xml`, and CI/quality configs

## Prerequisites

- Java 11 or newer installed and `JAVA_HOME` set
- Docker & Docker Compose (if running via containers)
- Git (to clone the repo)

## Build & Run (individual services)

On Windows PowerShell, you can use the included Maven wrapper to build or run an individual service.

Build all modules:

```powershell
.\mvnw.cmd clean package -DskipTests
```

Run a single service (example: `flight-service`):

```powershell
cd flight-service
.\mvnw.cmd spring-boot:run
```

You can also run multiple modules from the project root using Maven `-pl` and `-am` options:

```powershell
.\mvnw.cmd -pl flight-service,ticket-service -am spring-boot:run
```

## Run with Docker Compose

The repository contains a `docker-compose.yml` that can build and start all services together.

Build and start services (recommended on a machine with Docker):

```powershell
docker-compose up --build
```

Stop and remove containers:

```powershell
docker-compose down
```

Notes:

- The compose file may expose ports for the API gateway and supporting services — inspect `docker-compose.yml` to confirm ports and environment variables.
- If you change code, re-run the Maven build or rebuild Docker images before `docker-compose up --build`.

## Testing

Run unit tests for all modules:

```powershell
.\mvnw.cmd test
```

Some modules include integration tests in `src/test`; check the individual module `pom.xml` for test configuration.

## SonarQube / Code Quality

This project includes `sonar-project.properties` at the root. To analyze the project with SonarScanner, follow your SonarQube server/operator instructions and run the scanner pointing to this repo. Check the `target/sonar` folders in modules for previous scan artifacts.

## Contributing

This repository is an assignment/demo workspace. If you want to extend it:

- Fork the repo and create a feature branch
- Add tests for new behavior
- Keep changes scoped to a single service where possible
- Open a pull request describing the change and its impact

## Troubleshooting

- If a service fails to start, check its `application.properties` / `application.yml` and ensure the configuration server is reachable (or run with local overrides).
- For Eureka/service discovery issues, ensure `service-registry` is running before dependent services.
- If ports are in use, adjust the exposed ports in the service `application.yml` or in `docker-compose.yml`.

## License

This project is provided as-is for educational purposes. Add a LICENSE file if you want to apply a specific open-source license.

---

If you'd like, I can:

- Add example curl commands for common APIs
- Add a short diagram or architecture summary
- Run a local build or start the full stack via Docker Compose and share commands/output

Tell me which of the above you'd like next.

