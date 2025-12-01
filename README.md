## What is happening 

- The system is split into small, focused services. Each service has one job (for example, `flight-service` knows about flights; `ticket-service` handles bookings).
- External clients talk to the system through the **API Gateway** — this is the single entry point that forwards requests to the right service.
- The **Service Registry** keeps a live list of which services are up and where they are. Services use it to discover each other instead of hard-coding locations.
- The **Config Server** stores common configuration so services can get their settings from one place.
- When a user requests a booking, the API Gateway forwards that to `ticket-service`. `ticket-service` may ask `flight-service` and `passenger-service` for details, then it asks `email-service` to send a confirmation.

The idea: breaking the app into small services makes it easier to change or scale parts independently.

## Architecture Diagram

![Architecture diagram](microservices-architecture.png)

