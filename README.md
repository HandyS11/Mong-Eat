[![Build Status](https://codefirst.iut.uca.fr/api/badges/React-if/Mong-eat/status.svg)](https://codefirst.iut.uca.fr/React-if/Mong-eat)

# Mong-eat

A Quarkus API for a MongoDB database.

## 📝 Purpose

...

## 🛠 Languages & tools

![skills](https://skillicons.dev/icons?i=java,mongo,idea)

## 🖊️ Versions 

- [Java SDK](https://www.java.com/): 19
- [Quarkus](https://quarkus.io): 3

## MongoDB

### Getting Started

In order to get a quick setup of a MongoDB database, you can use [Docker Desktop](https://www.docker.com/products/docker-desktop/).

1. Add a container with the `mongo:latest` image
2. Set ports to `27017:27017`
3. Launch the container

> The API is setup with the default MongoDB port `27017`. Feel free to change it at your convenience.

### Collections

> Find the database collections description [here](./Documentation/Database/Collections.md).

### CDM

> Find a simple CDM [here](./Documentation/Database/CDM.md). 
> It doesn't fill well with mongo but that can help to understand objects interractions.

## Quarkus API

### Getting Started

> Make sure to get a running MongoDB container before starting the API.

To setup the API quickly we will use [IDEA Intellji](https://www.jetbrains.com/idea/).

1. Open `./Sources/` as a project
2. Add a configuration to run the `./Sources/src/main/java/com/mongeat/launch/Main.java` main. *(pom will automatically download dependencies)*
3. Launch the configuration with Java SDK 18 or so
4. With a browser or Postman, go to `http://localhost:8080/admin/setup`
5. Feel free to explore the API with [swagger](http://localhost:8080/q/swagger-ui/).

## ✍️ Credits

* Co-author [Mathis Ribémont](https://github.com/TEDDAC)
* Co-author [Valentin Clergue](https://github.com/HandyS11)