FROM adoptopenjdk/openjdk13:ubi
COPY build/libs/application.jar /backend/application.jar
EXPOSE 8080
CMD java -jar /backend/application.jar
