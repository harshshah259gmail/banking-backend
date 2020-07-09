# Bank Application - Backend

# Technology  Used

  - Spring Boot
  - Java8
  - jUnit + Mockito
  - Spring JPA
  - H2

# How to Run
- Simply execute BackendServiceApplication.java
- Service will runs on 8081 PORT
- Since we have added Swagger you can check all services by accessing http://localhost:8081/swagger-ui.html

# Architecture
- We have Cotroller + Service + Repository
- Each Controller follws REST guidlines
- H2 Database used (data.sql for crearting tables & adding sample data)
- Demonstrated Java8 Lambda wherever possible

# Service
- Customer & Account service created.
# Customer
 - Add/Remove/Modify Customers
 - Social Security Number not visible for Get reqeust
 - Validation if Customer Present while updating

# Account
 - Add/Remove/Modify Account
 - Transfer Money from one account to other
 - Validate if from account has enough balance
 - Validate if from & to account present
 - Account transfer call transactional


# Testing
- Repository Level testing
- Service level testing using Mockito



