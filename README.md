# Module 3: REST API Architecture

```
# Create a User
curl -X POST -H "Content-Type: application/json" -d '{"name":"John","surname":"Doe","birthday":"1990-01-15"}' http://localhost:8080/users

# Update a User (Replace {USER_ID} with the actual user ID)
curl -X PUT -H "Content-Type: application/json" -d '{"name":"UpdatedName"}' http://localhost:8080/users/{USER_ID}

# Delete a User (Replace {USER_ID} with the actual user ID)
curl -X DELETE http://localhost:8080/users/{USER_ID}

# Get a User (Replace {USER_ID} with the actual user ID)
curl http://localhost:8080/users/{USER_ID}

# Get All Users
curl http://localhost:8080/users

# Create a Subscription
curl -X POST -H "Content-Type: application/json" -d '{"userId": 1, "startDate": "2023-01-01"}' http://localhost:8080/subscriptions

# Update a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl -X PUT -H "Content-Type: application/json" -d '{"startDate": "2024-02-02"}' http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

# Delete a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl -X DELETE http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

# Get a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

# Get All Subscriptions
curl http://localhost:8080/subscriptions
```

```
:: Create a User
curl -X POST -H "Content-Type: application/json" -d "{\"name\":\"John\",\"surname\":\"Doe\",\"birthday\":\"1990-01-15\"}" http://localhost:8080/users

:: Update a User (Replace {USER_ID} with the actual user ID)
curl -X PUT -H "Content-Type: application/json" -d "{\"name\":\"UpdatedName\"}" http://localhost:8080/users/{USER_ID}

:: Delete a User (Replace {USER_ID} with the actual user ID)
curl -X DELETE http://localhost:8080/users/{USER_ID}

:: Get a User (Replace {USER_ID} with the actual user ID)
curl http://localhost:8080/users/{USER_ID}

:: Get All Users
curl http://localhost:8080/users

:: Create a Subscription
curl -X POST -H "Content-Type: application/json" -d "{\"userId\": 1, \"startDate\": \"2023-01-01\"}" http://localhost:8080/subscriptions

:: Update a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl -X PUT -H "Content-Type: application/json" -d "{\"startDate\": \"2024-02-02\"}" http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

:: Delete a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl -X DELETE http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

:: Get a Subscription (Replace {SUBSCRIPTION_ID} with the actual subscription ID)
curl http://localhost:8080/subscriptions/{SUBSCRIPTION_ID}

:: Get All Subscriptions
curl http://localhost:8080/subscriptions
```

# What should be done
- [x] Create maven project with 4 modules :
    - [x] jmp-dto 
    - [x] jmp-service-api
    - [x] jmp-cloud-service-impl
    - [x] jmp-service-rest


- [x] Create the fallowing classes under jmp-dto module :
  - [x] [User] Long id; String name; String surname; LocalDate birthday;
  - [x] [Subscription] Long id; User user; LocalDate startDate; 
  - [x] [UserRequestDto] Long id; String name; String surname; String birthday; 
  - [x] [SubscriptionRequestDto] Long id; Long userId;
  - [x] [UserResponseDto] Long id; String name; String surname; String birthday;
  - [x] [SubscriptionResponseDto] Long id; Long userId; String startDate;


- [x] Create UserController under jmp-service-rest module with following methods:
  - [x] createUser(UserRequestDto);
  - [x] updateUser(UserRequestDto);
  - [x] deleteUser(Long);
  - [x] getUser(Long);
  - [x] getAllUser();

- [ ] Use id filed into UserRequestDto only for updating data.

- [x] Must be returned UserResponseDto from the following methods
  - [x] createUser(UserRequestDto);
  - [x] updateUser(UserRequestDto);
  - [x] getUser(Long);
  - [x] getAllUser();


- [x] Create ServiceController under jmp-service-rest module with following methods :
  - [x] createSubscription(SubscriptionRequestDto);
  - [x] updateSubscription(SubscriptionRequestDto);
  - [x] deleteSubscription(Long);
  - [x] getSubscription(Long);
  - [x] getAllSubscription();

  - [x] Use id filed into SubscriptionRequestDto only for updating data.

  - [x] Must be returned SubscriptionResponseDto from the following methods :
    - [x] createSubscription(SubscriptionRequestDto);
    - [x] updateSubscription(SubscriptionRequestDto); 
    - [x] getSubscription(Long);
    - [x] getAllSubscription(); (as list)

- [ ] Add necessary interfaces/methods to jmp-service-api.


- [ ] Implement interfaces/methods under jmp-service-api into jmp-cloud-service-impl.


- [ ] UserController and ServiceController must provide REST API interfaces according to 2nd of REST API maturity.

- [ ] You can use memory structures to store the data (List, Map..).

- [ ] Use jmp-cloud-service-impl to implement 
  - [ ] UserController
  - [ ] ServiceController.


- [x] Implement Application class with @SpringBootApplication annotation and main method.

- [ ] Use lambdas and Java 8 features wherever it’s applicable.

- [ ] Make sample requests to UserController and ServiceController, provide screenshots/responses.

# (3-4 stars)

- [ ] ] Use a DB to store the data (List, Map..).

- [ ] Use spring boot data jpa module to access data.

- [ ] Use spring converters to convert:
  - [ ] UserRequestDto to User
  - [ ] User to UserResponseDto
  - [ ] SubscriptionRequestDto to Subscription
  - [ ] Subscription to SubscriptionResponseDto


- [ ] Document methods in UserController and ServiceController using Swagger 2 annotations.

- [ ] Make sample requests to UserController and ServiceController via Swagger UI, provide screenshots.

# (5 stars)

- [ ] Use Java 9 modules wherever it’s applicable.
- [ ] Implement REST APIs according to all Richardson Maturity Level (0 - 3).
- [ ] Make sample requests to 
  - [ ] UserController
  - [ ] ServiceController
  - [ ] provide screenshots/responses.
