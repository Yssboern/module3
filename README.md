# Module 3: REST API Architecture


# What should be done
- [x] Create maven project with 4 modules :
    - [x] jmp-dto 
    - [x] jmp-service-api
    - [x] jmp-cloud-service-impl
    - [x] jmp-service-rest

  
- [ ] Create the fallowing classes under jmp-dto module :
  - [ ] [User] Long id; String name; String surname; LocalDate birthday;
  - [ ] [Subscription] Long id; User user; LocalDate startDate; 
  - [ ] [UserRequestDto] Long id; String name; String surname; String birthday; 
  - [ ] [SubscriptionRequestDto] Long id; Long userId;
  - [ ] [UserResponseDto] Long id; String name; String surname; String birthday;
  - [ ] [SubscriptionResponseDto] Long id; Long userId; String startDate;


- [ ] Create UserController under jmp-service-rest module with following methods:
  - [ ] createUser(UserRequestDto);
  - [ ] updateUser(UserRequestDto);
  - [ ] deleteUser(Long);
  - [ ] getUser(Long);
  - [ ] getAllUser();
- [ ] Use id filed into UserRequestDto only for updating data.


- [ ] Must be returned UserResponseDto from the following methods
  - [ ] createUser(UserRequestDto);
  - [ ] updateUser(UserRequestDto);
  - [ ] getUser(Long);
  - [ ] getAllUser();


- [ ] Create ServiceController under jmp-service-rest module with following methods :
  - [ ] createSubscription(SubscriptionRequestDto);
  - [ ] updateSubscription(SubscriptionRequestDto);
  - [ ] deleteSubscription(Long);
  - [ ] getSubscription(Long);
  - [ ] getAllSubscription();

- [ ] Use id filed into SubscriptionRequestDto only for updating data.


- [ ] Must be returned SubscriptionResponseDto from the following methods :
  - [ ] createSubscription(SubscriptionRequestDto);
  - [ ] updateSubscription(SubscriptionRequestDto); 
  - [ ] getSubscription(Long);
  - [ ] getAllSubscription(); (as list)

- [ ] Add necessary interfaces/methods to jmp-service-api.


- [ ] Implement interfaces/methods under jmp-service-api into jmp-cloud-service-impl.


- [ ] UserController and ServiceController must provide REST API interfaces according to 2nd of REST API maturity.

- [ ] You can use memory structures to store the data (List, Map..).

- [ ] Use jmp-cloud-service-impl to implement 
  - [ ] UserController
  - [ ] ServiceController.


- [ ] Implement Application class with @SpringBootApplication annotation and main method.

- [ ] Use lambdas and Java 8 features wherever it’s applicable.

- [ ] Make sample requests to UserController and ServiceController, provide screenshots/responses.

# (3-4 stars)

- [ ] ] Use a DB to store the data (List, Map..).

- [ ] Use spring boot data jpa module to access data.

- [ ] Use spring converters to convert :
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
