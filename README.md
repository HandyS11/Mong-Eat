[![Build Status](https://codefirst.iut.uca.fr/api/badges/React-if/Mong-eat/status.svg)](https://codefirst.iut.uca.fr/React-if/Mong-eat)

# Mong-eat

A Quarkus API for a MongoDB database.

## 📝 Purpose

- Create a [Quakus](https://quarkus.io) API using a [MongoDB](https://www.mongodb.com/) database.
- Implement the CRUD operations to manage a *food delivery service*.

## 🛠 Languages & tools

![skills](https://skillicons.dev/icons?i=java,mongo,idea)

## 🖊️ Versions 

- [Java SDK](https://www.java.com/): 17
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
3. Launch the configuration with Java SDK 17 or newer
4. With a browser or Postman, go to `http://localhost:8080/admin/setup`
5. Feel free to explore the API with [swagger](http://localhost:8080/q/swagger-ui/).

You can also use the `./Documentation/API/Mong-eat.postman_collection.json` file to import the API in Postman.

### Architecture

> Theses diagrams are not fully accurate and only gave the global idea of the conception.

<details><summary> Structure </summary>

```mermaid
classDiagram

class Controller {
    
}
Controller --> Service
Controller --> Mapper~D, M~

class Service {
    
}
Service --> Repository
Service --> Converter~M, E~

class Repository {
    
}
Repository --> Codec

class Mapper~D, M~ {
    
}
Mapper .. DTO
Mapper .. Model

class Converter~M, E~ {
    
}
Converter .. Model
Converter .. Entity
```

This API is implement following the Controller -> Service -> Repository architecture.
* Controllers:
    - Handle the HTTP requests
    - Call the services
    - Return the responses
* Services:
    - Handle the business logic
    - Call the repositories
* Repositories:
    - Handle the database access
    - Call the codecs

To interact through the layers and convert **DTOs** to **Models** and **Models** to **Entities**, we use mappers and converters.
It allows us to keep the layers independant and to have a better control over the data.
It allows improve the code readability and maintainability.
</details>

<details><summary> Controllers </summary>

```mermaid
classDiagram

class GenericController~D, DA, M, MA, E~ {
    # setService(@NonNull GenericService~M_MA_E~ service)
    # setMapper(@NonNull GenericMapper~M_D~ mapper)
    # setPostMapper(@NonNull GenericPostMapper~MA_DA~ postMapper)
    + getById(String id) Response
    + getAll() Response
    + getPaginated(int page, int limit) Response
    + insert(DA dto) Response
    + insertAll(Collection~DA~ dtos) Response
    + update(DA dto) Response
    + updateAll(Collection~DA~ dtos) Response
    + delete(String id) Response
    + deleteAll() Response
    + drop() Response
    + exists(String id) Response
    + getCount() Response
}
GenericController --> "1" GenericService~M, MA, E~

class ArticleController {
    + getByName(String name) Response
}
GenericController <|.. ArticleController

class OrderController {
    
}
GenericController <|.. OrderController

class RestaurantController {
    + getByName(String name) Response
}
GenericController <|.. RestaurantController

class UserController {
    + getByName(String name) Response
}
GenericController <|.. UserController

class AdminController {
    + loadStub(String entity) Response
    + drop(String entity) Response
    + setup() Response
}
```

The controllers are the entry point of the API.
- They handle the HTTP requests
- They call the services
- They return the responses
</details>

<details><summary> Services </summary>

```mermaid
classDiagram

class GenericService~M, MA, E~ {
    # setRepository(GenericRepository~E~ repository)
    # setConverter(GenericConverter~M_E~ converter)
    # setPostConverter(GenericPostConverter~MA_E~ postConverter)
    + getById(String id) ~M~
    + getAll() ~Collection~M~~
    + getPaginated(int page, int limit) ~Collection~M~~
    + insert(M model)
    + insertAll(Collection~M~ models)
    + update(M model)
    + updateAll(Collection~M~ models)
    + delete(String id)
    + deleteAll()
    + exists(String id) Boolean
    + getCount() Long
}
GenericService --> "1" GenericRepository~E~

class ArticleService~Article, NewArticle, ArticleEntity~ {
    + findByRestaurantId(String id) List~Article~
}
GenericService <|.. ArticleService

class OrderService~Order, NewOrder, OrderEntity~ {
    + @Override getById(String id) ~Order~
    + @Override getAll() ~Collection~Order~~
    - getArticlesFromOrder(OrderEntity order) List~Article~
}
GenericService <|.. OrderService

class RestaurantService~Restaurant, NewRestaurant, RestaurantEntity~ {
    + @Override getById(String id) ~Restaurant~
    + @Override getAll() ~Collection~Restaurant~~
    + findByName(String name) List~Restaurant~
    - getArticlesFromRestaurant(RestaurantEntity restaurant) List~Article~
}
GenericService <|.. RestaurantService

class UserService~User, NewUser, UserEntity~ {
    + findByName(String name) List~User~
}
GenericService <|.. UserService

class AdminService {
    + drop(String type)
    + creadeStube(String type) Boolean
    + setup() Boolean
}
BaseRepository <|.. AdminService
```

The services are the core of the API.
- They handle the business logic
- They call the repositories
</details>

<details><summary> Repositories </summary>

```mermaid
classDiagram

class GenericRepository~E~ {
    + getCollection()* MongoCollection~E~
    + findById(String id) ~E~
    + getAll() ~Collection~E~~
    + gePaginated(int page, int limit) ~Collection~E~~
    + insert(E entity)
    + insterAll(Collection~E~ entities)
    + update(E entity)
    + updateAll(Collection~E~ entities)
    + delete(String id)
    + deleteAll()
    + exists(String id) Boolean
    + count() Long
}
BaseRepository <|.. GenericRepository

class ArticleRepository~ArticleEntity~ {
    + @Override getCollection()* MongoCollection~ArticleEntity~
    + findByName(String name) List~ArticleEntity~
}
GenericRepository <|.. ArticleRepository

class OrderRepository~OrderEntity~ {
    + @Override getCollection()* MongoCollection~OrderEntity~
}
GenericRepository <|.. OrderRepository

class RestaurantRepository~RestaurantEntity~ {
    + @Override getCollection()* MongoCollection~RestaurantEntity~
    + findByName(String name) List~RestaurantEntity~
}
GenericRepository <|.. RestaurantRepository

class UserRepository~UserEntity~ {
    + @Override getCollection()* MongoCollection~UserEntity~
    + findByName(String name) List~UserEntity~
}
GenericRepository <|.. UserRepository
```

The repositories are the link between the API and the database.
- They handle the database access
- They call the codecs
</details>


## ✍️ Credits

* Co-author [Mathis Ribémont](https://github.com/TEDDAC)
* Co-author [Valentin Clergue](https://github.com/HandyS11)