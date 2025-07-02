# Uniplatform

CRUD Backend app to manage university, course, and exam data. Developed using Java and Spring Boot. The data is stored in a MySQL database via a Docker container. The data is modeled with JPA.
It loosely follows the requirements of an assignment in the Distributed Systems course at the University of Milan-Bicocca.

This project will serve as an example in the near future for experimenting with front-end development.

## Roadmap

- Implement the test suite
- Add more data to the entities

## Run Locally

Create a `.env` file in the root of the project based on `.env.example`, and then simply run:

```sh
docker compose -f "compose.yaml" up -d --build 
```
