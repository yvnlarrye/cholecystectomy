FROM openjdk:17
WORKDIR /usr/src/app/
COPY ./target/cholecystectomyRecord-0.0.1-SNAPSHOT.jar /usr/src/app/
RUN mkdir -p /usr/src/app/templates/
RUN mkdir -p /usr/src/app/temp/
COPY ./src/main/resources/templates/poll-template.xlsx /usr/src/app/templates/
EXPOSE 8080
ENV TZ="Europe/Moscow"
CMD ["java", "-jar", "cholecystectomyRecord-0.0.1-SNAPSHOT.jar"]