# Use a Maven base image to build the project
FROM maven:3.8.6-openjdk-11 AS build

# Set the working directory in the container
WORKDIR /app

# Copy your pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Run Maven to build the project and create the jar file
RUN mvn clean package -DskipTests
#RUN mvn clean package

# Use a smaller OpenJDK image to run the application
FROM openjdk:11-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file from the build stage
COPY --from=build /app/target/assignment-0.0.1-SNAPSHOT.jar /app/aurva-app.jar

# Copy the start.sh file
COPY start.sh /app/start.sh

# Give execute permission to the start.sh file
RUN chmod +x /app/start.sh

# Set the entrypoint to the start.sh script
ENTRYPOINT ["./start.sh"]
