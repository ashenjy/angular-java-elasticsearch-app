# AngularJs , Java Rest (JAX-RS) , RestEasy , Wildfly AS and Elastic Search CRUD Tutorial

https://ashenjay.blogspot.com/2017/09/angularjs-java-rest-jax-rs-resteasy.html

In this tutorial I have used AngularJs as the frontend , Java Restful web services and RestEasy as the backend, Elastic Search as the database and finally deployed to Wildfly Application Server.

## Testing Steps

After downloading the project, Update the project using Maven, and set the goal as

 ``` clean package wildfly:deploy ```  to deploy the application.

Test the client server interaction from Advance rest client using the below url.

http://localhost:8080/angularCrudJava/rest/userlist

and finally test the CRUD UI with below url

http://localhost:8080/angularCrudJava/
