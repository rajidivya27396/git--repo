FROM openjdk:8
EXPOSE 8202
ADD /target/user-module.jar user-module.jar
ENTRYPOINT ["java","-jar","/user-module.jar"]
