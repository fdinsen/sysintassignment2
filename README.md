# Project description 
### Group members 
<a href = "https://github.com/fdinsen/sysintassignment2/graphs/contributors">
  <img src = "https://contrib.rocks/image?repo=fdinsen/sysintassignment2"/>
</a>

Click for a link to their github: 

[@josefmarcc ](https://github.com/josefmarcc)
[@fdinsen](https://github.com/fdinsen)
[@sebastianbentley ](https://github.com/SebastianBentley)
[@dahlfrederik ](https://github.com/dahlfrederik)

We have developed a complaint system which allows users to send a complaint to an email which is then processed by a supporter using the camunda takslist. 
If the issue cannot be resolved the task can be send to a manager who can handle it. 
Otherwise the supporter will send a response directly to the user. 

# How to run the project 

### Setup 
Before running trying to use the project you need to ensure all microservices are up and running. 

#### Mail service 
Open the project folder called: `EmailListenerServiceNET`

1. Open the `EmailListenerService.sln` in your VS code and run it. 
2. Mail service is up and running. 


#### Send email response 
Open the project folder called: `SendResponseEmailService`

1. Open the project in your favorite IDE. 
2. Run the main method found in `src/main/java/TaskHandlers/Main.java` 
3. The mail response service is up and running. 

#### Camunda Project 
Open the project folder called: `customer-complaint`

1. Make sure you have maven installed on your machine  
2. Open the terminal in the project directory 
3. Run `mvn clean install`
4. Run `mvn spring-boot:run`  
5. Open your browser and go to `http://localhost:8080`
6. Login with the following credentials: 
	
	Username: demo
	
	Password: demo 
	
7. Start using Camunda to run the project, you could start by creating a **process** and then proceed to start a **task** followed by executing the task in the **tasklist** or by looking at the diagram. 
8. Boom. You're done. Enjoy our project. 

# Project description 
![BPMN diagram](https://raw.githubusercontent.com/fdinsen/sysintassignment2/main/BPMN.png)

Our project is divided between 3 services. 
**2** microservices and **1** major project service. 

1. Mail listener service 
2. Mail response service 
3. Camunda service 

#### 1. Mail listener service 
This service exists outside the diagram and is the one that initiates the tasks in Camunda. 
It is listening on a complaint email address (*complain.camunda@gmail.com*). When the address receives an email the service invokes the camunda process so that a _supporter_ can see the complaint and act accordingly from there. 

#### 2. Mail response service 
The service subscribes to the external tasks topics from the camunda process.
This service is used to respond to the complaints by getting email address and relevant information from the complainer and sends the supporters response to the complainer. 
  
#### 3. Camunda service 
Camunda is functioning as the user interface of the project.
This means that camunda is used as the overall project management tool to run and execute the features in our program. 
See image below to see how the supporter receives the complaint: 

![Camunda form](https://raw.githubusercontent.com/fdinsen/sysintassignment2/main/camunda_task_form.png)






