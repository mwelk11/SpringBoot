This is a small application that I am writing in order to get familiar with Spring Boot.

I have added an AngularJS frontend as well as a mySql integration.

### Frontend

The frontend is using NPM and Bower to manage packages. I am using Grunt as a task runner.

To run the application, make sure you have NPM and Bower installed, then run the commands `npm install` and 
`bower install` to install the necessary dependencies. I am using http-server to host the static web page for 
now. Install http-server globally with the command `npm install http-server -g`. You can then start the server 
by navigating to /frontend and executing 'http-server -o'. In the future, I plan to package the frontend and backend together into one build process using gradle.

I use Grunt for unit testing and syntax validation using jsHint. To run the unit tests, execute `grunt test` 
command.

### Backend

You will need to setup a mySql database. Spring JPA should handle all of the table creation for you. You should 
just need to create a database and then supply the database information in backend/src/main/resrouces/application.properties

The backend uses Gradle to build an executable jar. You can build the project by navigating to /backend and 
executing `gradle clean build`. This create an executable jar. You run the jar by executing 
`java -jar build/libs/gs-rest-service-0.1.0.jar`
