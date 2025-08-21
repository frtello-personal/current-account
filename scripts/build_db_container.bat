docker stop current-account-db && docker current-account-db
docker run --name current-account-db -e POSTGRES_PASSWORD=postgres -p 5432:5432 -d postgres:17.0
