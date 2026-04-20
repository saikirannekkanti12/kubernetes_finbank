# FinBank Legacy Monolith Breakup - Task 5

This repository includes:
- **Sample Java code + Dockerfiles** in `finbank-apps/`
- **Kubernetes migration manifests** in `k8s-manifests/`

## Folder 1: Application code and Docker images
Go to [`finbank-apps/README.md`](finbank-apps/README.md) for build and push steps using Docker Hub repo prefix:
- `nvenkatasaikiran/finbank-monolith:v1`
- `nvenkatasaikiran/finbank-auth:v1`
- `nvenkatasaikiran/finbank-transaction:v1`

## Folder 2: Kubernetes manifests
Go to [`k8s-manifests/README.md`](k8s-manifests/README.md) for full deployment sequence.

Each migration step has its own README:
- `k8s-manifests/step-1-strangler/README.md`
- `k8s-manifests/step-2-db-migration/README.md`
- `k8s-manifests/step-3-service-mesh/README.md`
- `k8s-manifests/step-4-resilience/README.md`
- `k8s-manifests/stretch-goals/README.md`
