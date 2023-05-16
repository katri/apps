Build docker:
docker build --tag java-docker .


in termminal
docker ps -a
docker run --publish 8080:8080 java-docker