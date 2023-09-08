# Architecture

```
controllers - These will be the entry points into our app.
services - These will hold the business logic.
repositories - These will talk to the database.
dtos - These will be the data transfer objects. Incoming requests will be mapped to these objects.
entities - These will be the entities that we store in our database.
```

### Project structure:

```
project-root/
│
├── user/
│   ├── controllers/
│   │   └── UserController.java
│   ├── services/
│   │   └── UserService.java
│   ├── repositories/
│   │   └── UserRepository.java
│   ├── dtos/
│   │   └── UserDTO.java
│   └── entities/
│       └── UserEntity.java
│
├── notes/
│   ├── controllers/
│   │   └── ...
│
└── common/
    └── constants/
        └── Constants.java

```