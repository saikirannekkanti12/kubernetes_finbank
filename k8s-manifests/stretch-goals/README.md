# Stretch Goals

## 1) Distributed Tracing with Jaeger
Apply `10-jaeger.yaml` to run Jaeger all-in-one in namespace `observability`.

## 2) Blue-Green Deployment for Monolith
Apply `20-monolith-bluegreen.yaml`.
- `monolith-blue` and `monolith-green` run in parallel.
- `monolith-live` service initially points to blue.
- Switch to green by patching service selector.

Example switch command:
```bash
kubectl -n finbank-legacy patch service monolith-live -p '{"spec":{"selector":{"app":"monolith","version":"green"}}}'
```
