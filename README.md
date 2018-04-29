# Automate database migrations with Flyway Maven Plugin

### Requirements for Linux users
You just need to install [docker for linux](https://www.docker.com/docker-ubuntu) (I will provide soon the instructions for windows users). 

### How run flyway with maven plugin 
You can run local integration tests by activating *docker* profile during Maven build. 
This profile will activate Fabric8 plugin that will pull and run mysql container. Ten Flyway plugin will trigger a migration operation.

An integration test class is added to demonstrate the schema alteration.


mvn clean verify -Pdocker,migration -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root


mvn flyway:baseline -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root -Dflyway.baselineVersion=1.0.0 -Dflyway.baselineDescription='Baseline for Flyway initialization'

mvn flyway:migrate -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root
+-----------+---------+------------------------------------+----------+---------------------+----------------+
| Category  | Version | Description                        | Type     | Installed On        | State          |
+-----------+---------+------------------------------------+----------+---------------------+----------------+
| Versioned | 0.1.0   | create book table                  | SQL      |                     | Below Baseline |
| Versioned | 0.2.0   | create author table                | SQL      |                     | Below Baseline |
| Versioned | 0.3.0   | create fk book author              | SQL      |                     | Below Baseline |
| Versioned | 1.0.0   | Baseline for Flyway initialization | BASELINE | 2018-04-29 15:53:22 | Baseline       |
| Versioned | 1.1.0   | create edition table               | SQL      |                     | Pending        |
+-----------+---------+------------------------------------+----------+---------------------+----------------+

mvn flyway:info -Dflyway.url="jdbc:mysql://127.0.0.1:3306/bookstore" -Dflyway.user=root -Dflyway.password=root
+-----------+---------+------------------------------------+----------+---------------------+----------------+
| Category  | Version | Description                        | Type     | Installed On        | State          |
+-----------+---------+------------------------------------+----------+---------------------+----------------+
| Versioned | 0.1.0   | create book table                  | SQL      |                     | Below Baseline |
| Versioned | 0.2.0   | create author table                | SQL      |                     | Below Baseline |
| Versioned | 0.3.0   | create fk book author              | SQL      |                     | Below Baseline |
| Versioned | 1.0.0   | Baseline for Flyway initialization | BASELINE | 2018-04-29 15:53:22 | Baseline       |
| Versioned | 1.1.0   | create edition table               | SQL      | 2018-04-29 15:53:58 | Success        |
+-----------+---------+------------------------------------+----------+---------------------+----------------+

mvn flyway:undo (only in the Flyway PRO edition)



