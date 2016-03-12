FROM java:8
MAINTAINER Loïc Prieto <loic.sephiroth@gmail.com>
#Spark based REST API, inspired by the image tutorial in https://sparktutorials.github.io/2015/04/14/getting-started-with-spark-and-docker.html

WORKDIR /code

# Just put the backed final jar into the code folder, we don't want to get full
# maven installation everytime we change something. This assumes, the project has
# already been packaged, and the final jar is available in the target folder.
ADD target/backend-api-jar-with-dependencies.jar /code/backend-api.jar


EXPOSE 4567

CMD ["/usr/lib/jvm/java-8-openjdk-amd64/bin/java", "-jar", "backend-api.jar"]
