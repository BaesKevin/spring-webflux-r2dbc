#Spring WebFlux R2DBC

This repository combines Spring WebFlux with the Spring Data R2DBC M2 release, which 
offers declarative transaction support.

Connection properties (username etc.) can be configured in application.properties.
This project drop-creates a Goal table in the database on every run. 
To disable this, remove the @PostConstruct from the `persistence.config.DbInitializer` class.

## Endpoints:

**GET /goal**

retrieve all goals

**POST /goal**

create a goal, request body:

```
{
	"name": "my goal"
}
```