From openjdk:latest

copy ./target /

CMD ["java","jar","./readData-1.0-SNAPSHOT.jar"]