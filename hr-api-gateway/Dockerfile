FROM openjdk:17
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-gateway-0.0.1-SNAPSHOT.jar hr-api-gateway.jar
ENTRYPOINT ["java","-jar","/hr-api-gateway.jar"]
