# Step 2 - Database Migration Strategy

## Goal
- Replace monolith H2 in-memory DB with shared PostgreSQL (persistent)
- Use a one-time migration Job to move data from H2 export to PostgreSQL

## Files
- `00-namespace.yaml`
- `10-postgres-statefulset.yaml`
- `20-h2-to-postgres-job.yaml`

## Deploy
```bash
kubectl apply -f 00-namespace.yaml
kubectl apply -f 10-postgres-statefulset.yaml
kubectl apply -f 20-h2-to-postgres-job.yaml
```

> `nvenkatasaikiran/finbank-h2-to-postgres-migrator:v1` is expected to contain your migration logic.
