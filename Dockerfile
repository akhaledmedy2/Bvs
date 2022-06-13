FROM openjdk:8-alpine
add target/*.jar router.jar
ENTRYPOINT ["java","-jar","router.jar"]