# Use an official Maven image to build the project
FROM maven:3.8.6-eclipse-temurin-17 as build

# Set working directory
WORKDIR /app

# Copy all files into the container
COPY . .

# Package the app (skip tests)
RUN mvn clean package -DskipTests

# Use a smaller Java runtime image to run the app
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy only the jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Run the jar file
CMD ["java", "-jar", "app.jar"]
