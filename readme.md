# Notlar

## Docker Image larını eklemek

    PostgreSQL
    userName: postgres
    password: root
    DB: AuthDB
```bash
docker run -d --name postgresqlDocker -p 5432:5432 muhammedali55/postgresql:v.0.1
```
    MongoDB
    userName: admin
    password: root
    DB: UserProfileDB
```bash
docker run -d --name mongodb -p 27017:27017 muhammedali55/mongodb:v.0.3
```
    mongod:
    db.createUser({user:"dilan",pwd:"root",roles:["readWrite","dbAdmin"]})