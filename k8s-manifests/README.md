# FinBank Kubernetes Migration Manifests

This folder is organized step-by-step for the **Legacy Monolith Breakup** migration strategy.

## Structure
1. `step-1-strangler` - Namespaces, monolith + auth service deployments, and NGINX API gateway.
2. `step-2-db-migration` - Shared PostgreSQL StatefulSet + migration Job from H2 to PostgreSQL.
3. `step-3-service-mesh` - Istio-based traffic splitting (90/10 and gradual shifts).
4. `step-4-resilience` - Circuit breaking and retries for transaction flows.
5. `stretch-goals` - Jaeger tracing and blue-green deployment strategy.

## Apply order
```bash
kubectl apply -f step-1-strangler/
kubectl apply -f step-2-db-migration/
kubectl apply -f step-3-service-mesh/
kubectl apply -f step-4-resilience/
kubectl apply -f stretch-goals/
```
