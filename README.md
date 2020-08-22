# SpringSecurityImplementation

Well, this is a humble project just for learning about Spring Security and JWT

## In case you want to run it:

- ``` mvn clean install ```
- ``` java -jar target/{name.jar} ```

There are only three routes:

- ``` /api/user - POST & GET ``` for creating and reading

- ``` /api/auth - GET ``` for getting de token

The token should be sent to the route ``` /api/user - GET ``` in a header called Authorization like this: Bearer {token}.
