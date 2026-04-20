# Step 1 - Strangler Fig Pattern

## Goal
- Monolith in namespace `finbank-legacy`
- New auth service in namespace `finbank-new`
- API gateway routes:
  - `/api/auth/*` -> auth service
  - all other routes -> monolith

## Files
- `00-namespaces.yaml`
- `10-monolith.yaml`
- `20-auth-service.yaml`
- `30-nginx-gateway.yaml`

## Deploy
```bash
kubectl apply -f 00-namespaces.yaml
kubectl apply -f 10-monolith.yaml
kubectl apply -f 20-auth-service.yaml
kubectl apply -f 30-nginx-gateway.yaml
```
