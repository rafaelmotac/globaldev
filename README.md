With a machine with Maven and Java 8 installed, simply run in the terminal on the pom.xml directory "mvn clean jetty:run-war"

the application will be served in localhost:8080


ENDPOINTS:

GET /transactions - show all transactions

GET /transactions/{type} - filter the transactions by Type

GET /transactions/count/{type - return the amount of transactions for the given type


POST /login - for JWT authentication, in memory authentication, send a json object with a username and password (both strings):

{
    "username": "admin",
    "password": "123456"
}

And then the token will be returned in the response's body.
