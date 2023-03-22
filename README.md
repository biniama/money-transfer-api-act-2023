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
