FROM openjdk:17-ea-11-jdk-slim
VOLUME /tmp
COPY build/libs/salerService-1.0.jar salerservice.jar
ENTRYPOINT ["java","-jar","/salerservice.jar"]