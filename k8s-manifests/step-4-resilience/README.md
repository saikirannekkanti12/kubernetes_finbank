# Step 4 - Circuit Breaking and Retries

## Goal
- Protect system if transaction service starts failing.
- Fail fast via circuit breaking.
- Retry transient failures with exponential-style backoff (Envoy-managed retries with jitter).

## Files
- `10-transaction-service.yaml`
- `20-transaction-destinationrule-circuitbreaker.yaml`
- `30-transaction-virtualservice-retries.yaml`

## Apply
```bash
kubectl apply -f 10-transaction-service.yaml
kubectl apply -f 20-transaction-destinationrule-circuitbreaker.yaml
kubectl apply -f 30-transaction-virtualservice-retries.yaml
```
