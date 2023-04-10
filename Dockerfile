FROM openjdk:17

COPY \target\springboot-jenkins-demo.jar /demo.jar

CMD ["java","-jar","demo.jar"]