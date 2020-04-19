if [ -z "$TRAVIS_PULL_REQUEST" ] || [ "$TRAVIS_PULL_REQUEST" == "false" ]; then
  gradle build
  mv build/libs/*-SNAPSHOT.jar build/libs/application.jar
else
  gradle test
fi
