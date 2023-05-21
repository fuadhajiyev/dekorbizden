#
# Build stage
#
FROM maven:3.8.7-openjdk-18-slim AS build
COPY . .
RUN mvn clean package -DskipTests

#
# Package stage
#
FROM openjdk:17-jdk-slim
COPY --from=build /target/dekor_bizden-0.0.1-SNAPSHOT.jar dekor_bizden.jar
# ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["java","-jar","dekor_bizden.jar"]