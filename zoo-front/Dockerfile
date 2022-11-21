FROM node:14-alpine AS myangular
WORKDIR /app
COPY *.json /app 
RUN npm install --silent
COPY src src
RUN npm run build

FROM nginx:alpine
VOLUME /var/cache/nginx
COPY --from=myangular app/dist/zoo-front /usr/share/nginx/html