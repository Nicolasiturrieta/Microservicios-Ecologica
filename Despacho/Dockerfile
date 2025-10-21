# --------- Etapa de build (Maven + Java 17) ---------
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
# Cachea dependencias (mejores tiempos de build)
COPY pom.xml .
RUN mvn -q -e -DskipTests dependency:go-offline
# Copia el resto del código y compila
COPY . .
RUN mvn -q -DskipTests package

# --------- Etapa de runtime ---------
FROM eclipse-temurin:17-jre
WORKDIR /app
# Copia el JAR generado por Maven
COPY --from=build /app/target/*jar /app/app.jar

# Puerto inyectado por la plataforma (Railway, etc.)
ENV PORT=8080
EXPOSE 8080

# Flags JVM opcionales
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=75.0"

# Importante: Spring debe escuchar en $PORT
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -Dserver.port=${PORT} -jar /app/app.jar"]

