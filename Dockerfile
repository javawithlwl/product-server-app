FROM maven:3.8.1-openjdk-17-slim AS build

RUN mkdir /home/lwl
copy . /home/lwl
RUN cd /home/lwl && mvn package
RUN cp /home/lwl/target/*.jar product-server-api.jar
ENTRYPOINT [ "java","-jar","product-server-api.jar" ]