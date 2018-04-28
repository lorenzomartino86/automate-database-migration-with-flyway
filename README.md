# Automate database migrations with Flyway Maven Plugin

### Requirements for Linux users
You just need to install [docker for linux](https://www.docker.com/docker-ubuntu) (I will provide soon the instructions for windows users). 

### How run integration tests with Fabric8
You can run local integration tests by activating *docker* profile during Maven build. 
This profile will activate Fabric8 plugin that will pull and run mysql container. Ten Flyway plugin will trigger a migration operation.

An integration test class is added to demonstrate the schema alteration.