# addressbookapi

This is a simple address book API program that allows a user to search for customer information.

To build the application, you need to check out the codebase then run the following in a cmd window:

`mvn package && java -jar target/address-book-api-1.0-SNAPSHOT.jar`

This will build the application, running the tests, and will then start a server running on localhost:8080

In order to search the customer information, use the endpoint:

`localhost:8080/search/{surname}`

The search also works for a partial surname.

In order to lookup a specific customers full contact information once you have their ID using the search endpoint, you can use the following:

`localhost:8080/lookup/{customerId}`

lookup only takes integer values, anythinb else will throw an error.
