# Backend server

## Run Locally

### Native Dev (IntelliJ IDEA)

If you are using IntelliJ IDEA you can just open the server folder with intellij and run the provided `UniplatformApplication` configuration, as it will deploy automatically the database. Just make sure that you have docker engine running.
Running `UniplatformApplication` activates the `local` profile so that it can include the necessary `.env` file.

### Container with Docker compose

You can run the backend server using docker compose.
From the root directory of the repository simply run:

```sh
docker compose -f "compose.yaml" up -d --build "server"
```
