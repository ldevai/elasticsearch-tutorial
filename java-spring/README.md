# Spring Data Elasticsearch #

This is a spring boot application demonstrating basic Elasticsearch integration and usage with Spring Data API.
The app is structured as:
- Controllers: Exposes REST services to be invoked externally
- Services: Business logic layer for handling requests incoming from Controllers
- Repositories: Data access layer through Spring Data API
- Swagger: Utility page for testing the exposed services

## Start Elasticsearch server
    docker network create elasticnet
    docker run --name es-server --net elasticnet -p 9200:9200 -p 9300:9300 -e "discovery.type=single-node" docker.elastic.co/elasticsearch/elasticsearch:7.13.4

## Run the Spring Boot application
Launch **EsDemoApplication**

## Access the Swagger page to test the endpoints

    http://localhost:8080/swagger-ui/

