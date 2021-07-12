# whoami

Tiny Spring Boot app that prints os information and HTTP request to output

## Usage

### Paths

- `/`: returns the whoami information as json

## Build Image

```
 export ORG_GRADLE_PROJECT_docker_user=
 export ORG_GRADLE_PROJECT_docker_password=
./gradlew bootBuildImage --publishImage
```

## Release

```
git checkout main
git pull origin main
./gradlew release -Prelease.useAutomaticVersion=true -Prelease.releaseVersion=1.0.0 -Prelease.newVersion=1.1.0-SNAPSHOT
```
