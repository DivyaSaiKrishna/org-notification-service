# Org-wide Notifications Management Service

A centralized, multi-tenant notification backend that allows organizations to publish events once and reliably deliver notifications across multiple channels (email, Slack, webhooks), while respecting user preferences, quiet hours, and delivery policies.

This project is built as infrastructure-first software, focusing on correctness, scalability, and observability before UI.

## Why this exists

Most systems re-implement notification logic independently:
- who to notify
- which channel to use
- retries and failures
- audit logs

This service provides a single, reusable notification layer that any internal system can use.

## Core Capabilities (Planned)

- Event publishing via a single API
- Topic-based notification routing
- Asynchronous fan-out and delivery
- Per-user notification preferences
- Delivery tracking and retry support
- Slack, Email, and Webhook integrations
- Admin UI for inspection and debugging

## Architecture (High-level)

- Spring Boot (Java 17)
- PostgreSQL (event & delivery store)
- Google Pub/Sub (async backbone)
- Cloud Run (deployment target)

## Project Status

🚧 **Under active development**  
Phase 1: Core publish + async delivery backbone

## License

MIT License
