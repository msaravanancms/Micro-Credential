# Registration,Login, Update and Apply Loan with Spring Boot, Spring Security, Spring cloud, Microservices, JPA and MySQL

																Micro Credenial Case study:

About the "Bank Management System":

Developed an independent application Bank Management System (BMS) application.It has automated the process of managing the activities of bank like opening an account, transaction etc.
The following section has covered aspects related to Bank Management System.

a) Customer Registration
b) Apply Loan
c) Update Account Details

New Customer registration: to register a new customer and let the customer to login to the application, Customer Update: as a Customer Update account Details,  Apply Loan Details: As a Customer apply loan details, The applications would store the data in local mysql database or AWS RDS. • The application are deployed to 3 AWS lambda with java handlers. • Three API gateways are configured to hit the applications deployed in AWS lambdas. • When the apps are moved to AWS, the local databases are changed to AWS RDS-mysql. • The codes are maintained in Github. • The code is also maintained in AWS code commit. • Configured AWS codepipeline to handled CICD. • Configured code commit,code deploy,code build. • Configured so that my local eclipse commit would trigger AWS pipeline and deploy the application to AWS elastic beanstalk. • Deployed apps to AWS beanstalk too. • Configured a SQS queue to handle incoming ad outgoing messages. • Configured AWS event bride to keep my lambda functions warm, to avoid cold start up issues. • Configured Redis cache to reduce hits to database. • Added 5 to 6 java 8 features in code. • Configured a separate IAM role to acces lambda/beanstalk/API gateway/SQS/pipeline/event bridge. • Configured a free tier RDS in AWS – mysql. • The logs of the applications are logged in AWS cloudwatch. 

Customer Registration and Login Service:

hostname: customeregistration
Ports: 8089
URL:  http://localhost:8089/customeregistration
URL:  http://localhost:8089/login
 

Apply Loan Service:

hostname: applyloan
Ports: 8082
URL:  http://localhost:8082/loanservice/applyloan


Update Account Details Service:

hostname: applyloan
Ports: 8081
URL:  http://localhost:8081/updatecustomer