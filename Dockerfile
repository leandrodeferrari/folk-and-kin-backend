FROM openjdk:11-jdk-slim
COPY /out/artifacts/tienda_jar/tienda.jar tienda.jar
ENTRYPOINT ["java", "-jar", "/tienda.jar"]