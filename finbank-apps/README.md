# FinBank Sample Java Services + Docker Images

This folder contains simple Java services you can use to simulate the legacy-to-microservice migration.

## Services
- `monolith` (port `8080`) → image: `nvenkatasaikiran/finbank-monolith:v1`
- `auth-service` (port `8081`) → image: `nvenkatasaikiran/finbank-auth:v1`
- `transaction-service` (port `8082`) → image: `nvenkatasaikiran/finbank-transaction:v1`

## Step 1: Build Images
```bash
docker build -t nvenkatasaikiran/finbank-monolith:v1 ./monolith
docker build -t nvenkatasaikiran/finbank-auth:v1 ./auth-service
docker build -t nvenkatasaikiran/finbank-transaction:v1 ./transaction-service
```

## Step 2: Login to Docker Hub
```bash
docker login
```

## Step 3: Push Images
```bash
docker push nvenkatasaikiran/finbank-monolith:v1
docker push nvenkatasaikiran/finbank-auth:v1
docker push nvenkatasaikiran/finbank-transaction:v1
```

## Step 4: Quick Local Run
```bash
docker run --rm -p 8080:8080 nvenkatasaikiran/finbank-monolith:v1
docker run --rm -p 8081:8081 nvenkatasaikiran/finbank-auth:v1
docker run --rm -p 8082:8082 nvenkatasaikiran/finbank-transaction:v1
```
