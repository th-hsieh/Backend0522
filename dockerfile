FROM openjdk

WORKDIR /app

COPY build/libs/SpringBootBackend-0.0.1-SNAPSHOT.jar /app

CMD ["java","-jar","/app/SpringBootBackend-0.0.1-SNAPSHOT.jar"]