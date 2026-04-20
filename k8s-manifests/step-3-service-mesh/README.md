# Step 3 - Service Mesh (Istio) + Weighted Traffic Split

## Goal
- Install Istio service mesh.
- Route authentication traffic with weighted split:
  - 90% to monolith auth endpoint
  - 10% to new auth service
- Increase auth-service weight gradually over time.

## Install Istio (example)
```bash
istioctl install -y
kubectl label namespace finbank-legacy istio-injection=enabled --overwrite
kubectl label namespace finbank-new istio-injection=enabled --overwrite
kubectl label namespace finbank-gateway istio-injection=enabled --overwrite
```

## Apply routing config
```bash
kubectl apply -f 10-auth-weighted-routing-90-10.yaml
```

## Gradually shift traffic
```bash
# Example: move to 50/50
kubectl apply -f 20-auth-weighted-routing-50-50.yaml

# Example: cut over fully to new auth service
kubectl apply -f 30-auth-weighted-routing-0-100.yaml
```
