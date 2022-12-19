# Expense record API (Back-end lab 3)

This is a solution for the third lab on back-end dev course. [Detailed technical requirements](https://docs.google.com/document/d/11zEDVhyPrYx7482_12dZBAwYyMYYyaYX6cfZjW8Z2dg/edit) 

Postman requests can be found in [postmanRequests.json](postmanRequests.json)

Insomnia requests can be found in [Insomnia_2022-12-19.json](Insomnia_2022-12-19.json)

A MongoDB server at [Clever Cloud](https://www.clever-cloud.com/) was used as the database

Project uses both access and refresh tokens.
### How to start
[Video instruction](https://drive.google.com/file/d/17hC29hxif4vG_UZfcoSTCujOsIAUMe7T/view?usp=sharing)

The autogenerated Swagger API is available at ``` http://be-lab-1.herokuapp.com/swagger-ui/index.html ```


### Requirements
- JDK 8 or higher
- Spring Boot (v.2.7.4)
- Docker

### Docker instructions
- Build the image from the Dockerfile
```
docker build -t <image name> <path to Dockerfile>
```
- Run the application from the image in the Dockerfile directory
```
docker run -p<your port>:8080 <image name>
```

