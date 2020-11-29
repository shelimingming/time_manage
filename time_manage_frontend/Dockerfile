FROM nginx:stable-alpine
COPY ./nginx.conf /etc/nginx/nginx.conf
COPY ./dist/ /usr/share/nginx/html
COPY ./cert/ /etc/nginx/cert
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]