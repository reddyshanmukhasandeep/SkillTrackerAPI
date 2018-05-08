FROM java:8
VOLUME /tmp
EXPOSE 8090
ADD target/Skill-Tracker-API-0.0.1-SNAPSHOT.jar Skill-Tracker-API-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","Skill-Tracker-API-0.0.1-SNAPSHOT.jar"]
