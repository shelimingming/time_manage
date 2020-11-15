#基于
FROM openjdk:8
ENV WORKDIR /app
WORKDIR $WORKDIR
ADD target/time_manage_backend-1.0-SNAPSHOT.jar time_manage_backend-1.0-SNAPSHOT.jar
VOLUME $WORKDIR
EXPOSE 9999
ENTRYPOINT ["java","-jar","time_manage_backend-1.0-SNAPSHOT.jar","--spring.profiles.active=prod"]
