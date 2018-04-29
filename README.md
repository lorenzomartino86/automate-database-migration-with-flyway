# Automate database migrations with Flyway Maven Plugin

### Requirements for Linux users
You just need to install [docker for linux](https://www.docker.com/docker-ubuntu) (I will provide soon the instructions for windows users). 

### How run flyway with maven plugin 
You can run local integration tests by activating *docker* profile during Maven build. 
This profile will activate Fabric8 plugin that will pull and run mysql container. Ten Flyway plugin will trigger a migration operation.

An integration test class is added to demonstrate the schema alteration.

In order to run build with migration you need to execute following command:
```
mvn clean verify -Pdocker,migration -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root
```

If you need to set run a Flyway baseline you can a command like the following:
```
mvn flyway:baseline -Pmigration -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root -Dflyway.baselineVersion=1.0.0 -Dflyway.baselineDescription='Baseline for Flyway initialization'
```

If you need to run a Flyway migration you can run a command like the following:
```
mvn flyway:migrate -Pmigration -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root
```

If you need to run a Flyway info you can run a command like the following:
```
mvn flyway:info -Pmigration -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root
```

For more details please check the post [here](https://javanger.blogspot.ie/2018/04/automate-database-migration-with-flyway.html).



