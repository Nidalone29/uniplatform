# Uniplatform

Full-stack CRUD REST web app to manage University, Degree programs, and Courses data. Developed using Java Spring Boot. The data is stored in a MySQL database via a Docker container. The data is modeled with JPA. The frontend is built with React and react-router and maintains data integrity with the backend. The inputs are validated both with Zod in the frontend and manually in the backend. The UI is built using the default Shadcn components and features a theme switch for light and dark mode.

![preview_screenshot](https://github.com/user-attachments/assets/7ff20307-55fa-4968-8fe6-387b550a517c)

It loosely follows the requirements of an assignment in the Distributed Systems course at the University of Milan-Bicocca.
This project is now serving as a playground to experiment with web development.
  
## Roadmap

- [ ] Add sorting and pagination
- [ ] Add Authentication
- [ ] Implement the test suite
- [ ] Update documentation and upload the OpenAPI spec

## Run Locally

Create a `.env` file in the root of the project based on `.env.example`, and then simply run:

```sh
docker compose -f "compose.yaml" up -d --build 
```
