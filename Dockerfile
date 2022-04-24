FROM java:8
EXPOSE 2000
ADD target/userdocker.jar userdocker.jar
ENTRYPOINT ["java","-jar","/userdocker.jar"]