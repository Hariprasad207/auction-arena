
# Architecture

## Application Architecture
Modular monolith.

## Frontend
React JavaScript + Vite.

## Backend
Java + Spring Boot.

## Database
One PostgreSQL database:
- app schema
- cricket schema

## Communication
- REST APIs for normal application operations.
- WebSocket/STOMP for real-time auction events.
- LiveKit/WebRTC for voice.

## Architecture Rules
- Backend is authoritative for auction state.
- Frontend countdown is display-only.
- Bidding and settlement must be transactional.
- Cricket data must be locally cached.
- Auction uses immutable player snapshots.
- Auction module accesses cricket data through a service interface.

## V1 Infrastructure
- Docker Compose.
- GitHub Actions.
- No Redis, Kafka or Kubernetes initially.
