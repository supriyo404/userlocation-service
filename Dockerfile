FROM openjdk:11.0.11-jre-slim
VOLUME /tmp
EXPOSE 8080
ADD target/UserLocationService-0.0.1-SNAPSHOT.jar UserLocationService-0.0.1-SNAPSHOT.jar
CMD 'bash -c touch /UserLocationService-0.0.1-SNAPSHOT.jar'
ENTRYPOINT ["java","-Dspring.profiles.active=pi","-jar","/UserLocationService-0.0.1-SNAPSHOT.jar"]