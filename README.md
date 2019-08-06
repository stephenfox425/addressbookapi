# addressbookapi

This is a simple address book API program that allows a user to search for customer information.

To build the application, you need to check out the codebase then run the following in a cmd window:
mvn package && java -jar target/address-book-api-1.0-SNAPSHOT.jar

This will build the application, running the tests, and will then start a server running on localhost:8080

In order to search the customer information, use the endpoint:
localhost:8080/search/{surname}

The search also works for a partial surname.
