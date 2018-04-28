# Automate database migrations with Flyway

mvn flyway:info -Dflyway.url=jdbc:mysql:/127.0.0.1:3306 -Dflyway.user=admin -Dflyway.password=admin -Dflyway.locations=migrations -Dflyway.schemas=bookstore 
