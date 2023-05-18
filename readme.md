## Sample application Apps to register applications and services

### Running Apps locally
Apps  is a Spring Boot application built using Gradle. 

git clone https://github.com/katri/apps.git

Run application on your device.
You can then access application at http://localhost:8080/applications/

### Building docker (WIP)

Build docker:
```
docker build --tag register-apps .
```

Check available images:
```
docker ps -a
```

Publish container
```
docker run --publish 8080:8080 register-apps
```
