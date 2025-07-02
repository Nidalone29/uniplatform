FROM node:22-alpine AS base
WORKDIR /app
ENV PNPM_HOME="/pnpm"
ENV PATH="$PNPM_HOME:$PATH"
RUN corepack enable
COPY package.json package.json
COPY pnpm-lock.yaml pnpm-lock.yaml

# https://pnpm.io/docker#example-1-build-a-bundle-in-a-docker-container
FROM base AS build
RUN --mount=type=cache,id=pnpm,target=/pnpm/store pnpm install --frozen-lockfile
COPY . .
RUN pnpm run build

FROM nginx:1.29-alpine-slim
COPY --from=build /app/dist /usr/share/nginx/html/
