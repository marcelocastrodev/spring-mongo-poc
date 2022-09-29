# Spring Mongo POC

A POC for mongodb

## Steps to run

### Via terminal

```shell
cd path/to/project
docker compose up -d 
mvn spring-boot:run
```

### Via IntelliJ

1. Download the docker plugin (You need to restart the IDE)
2. In the docker-compose.yml, click on the green play button
3. Right Click on MongoPocApplication class and click "Run MongoPocApplication"

Docker compose contains the service "Docker-express". This is a webapp, exposed
at http://localhost:8081,
that allow to visualize and do some crud on the existing mongo database. The docker process will
automatically create the required database ("mongo_poc").

During the startup, the application will insert a new document for a John Doe customer. Once the app
is up and running, a set of restful endpoint will be available for some basic CRUD operation over
the customer.

#### List All Customer
```shell curl --request GET 'http://localhost:8080/api/v1/customers'```

#### Get a customer by id
```shell curl --request GET 'http://localhost:8080/api/v1/customers/6334ce61db5cec1e1f97ee6f'```

#### Create a new customer
```
curl --request POST 'http://localhost:8080/api/v1/customers' \
--header 'Content-Type: application/json' \
--data-raw '{
    "firstName": "Steve",
    "lastName": "Rogers",
    "email": "steve@email.com",
    "gender": "MALE",
    "favoritesSubjects": [
        "Military",
        "Teaching"
    ],
    "totalSpent": 10,
    "createdAt": "2022-09-30T16:00:00.000"
}'
```

#### Update a customer
curl --request PUT 'http://localhost:8080/api/v1/customers/6334ce61db5cec1e1f97ee6f'

#### Delete a customer by id
```shell curl --request DELETE 'http://localhost:8080/api/v1/customers/6334ce61db5cec1e1f97ee6f'```