# Frontend client

## Run Locally

It is obviously advised to run the [backend server first](../server/README.md#run-locally), or just run everything with docker compose.

### Native Dev

If you are developing you can simply install the dependencies

```sh
pnpm install
```

and run vite with

```sh
npm run dev
```

### Docker container Dev

The client will be available at `localhost:<VITE_CLIENT_PORT_DEV>`

```sh
docker build -t client .
```

```sh
docker run client
```

### Docker compose

You can build and run the container with docker compose.
From the root directory of the repository run:

```sh
docker compose -f "compose.yaml" up -d --build "client"
```

The client will be available at `localhost:8081`
