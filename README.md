# Money Transfer API with ACT MSc Students in 2023

## Database script
```sql
postgres=# CREATE DATABASE moneytransferact23;
CREATE DATABASE
postgres=# CREATE ROLE moneytransferadmin WITH ENCRYPTED PASSWORD '82LmNk1iZy2Uphec';
CREATE ROLE
postgres=# GRANT ALL PRIVILEGES ON DATABASE moneytransferact23 TO moneytransferadmin;
GRANT
postgres=# ALTER USER moneytransferadmin WITH LOGIN;
ALTER ROLE
postgres=# \q
    
➜  ~ psql -h localhost -Umoneytransferadmin moneytransferact23 -W
Password:
```

# Fly.io Postgres DB Setting
```
Postgres cluster money-transfer-api-act23-db created
  Username:    postgresu)
  Password:    RrVfeZwOApW5phv
  Hostname:    money-transfer-api-act23-db.internal
  Flycast:     fdaa:0:ebd5:0:1::2)
  Proxy port:  5432fornia (US) (lax)
  Postgres port:  5433
  Connection string: postgres://postgres:RrVfeZwOApW5phv@money-transfer-api-act23-db.flycast:5432

DATABASE_URL=postgres://money_transfer_api_act23:HKTYl2YH2LuXvz5@money-transfer-api-act23-db.flycast:5432/money_transfer_api_act23?sslmode=disable
                        username                :password       @hostname                           :port/databasename
```
