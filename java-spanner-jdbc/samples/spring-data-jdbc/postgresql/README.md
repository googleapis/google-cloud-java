# Spring Data JDBC Sample Application with Cloud Spanner PostgreSQL

This sample application shows how to develop portable applications using Spring Data JDBC in
combination with Cloud Spanner PostgreSQL. This application can be configured to run on either a
[Cloud Spanner PostgreSQL](https://cloud.google.com/spanner/docs/postgresql-interface) database or
an open-source PostgreSQL database. The only change that is needed to switch between the two is
changing the active Spring profile that is used by the application.

The application uses the Cloud Spanner JDBC driver to connect to Cloud Spanner PostgreSQL, and it
uses the PostgreSQL JDBC driver to connect to open-source PostgreSQL. Spring Data JDBC works with
both drivers and offers a single consistent API to the application developer, regardless of the
actual database or JDBC driver being used.

This sample shows:

1. How to use Spring Data JDBC with Cloud Spanner PostgreSQL.
2. How to develop a portable application that runs on both Google Cloud Spanner PostgreSQL and
   open-source PostgreSQL with the same code base.
3. How to use bit-reversed sequences to automatically generate primary key values for entities.

__NOTE__: This application does __not require PGAdapter__. Instead, it connects to Cloud Spanner
PostgreSQL using the Cloud Spanner JDBC driver.

## Cloud Spanner PostgreSQL

Cloud Spanner PostgreSQL provides language support by expressing Spanner database functionality
through a subset of open-source PostgreSQL language constructs, with extensions added to support
Spanner functionality like interleaved tables and hinting.

The PostgreSQL interface makes the capabilities of Spanner —__fully managed, unlimited scale, strong
consistency, high performance, and up to 99.999% global availability__— accessible using the
PostgreSQL dialect. Unlike other services that manage actual PostgreSQL database instances, Spanner
uses PostgreSQL-compatible syntax to expose its existing scale-out capabilities. This provides
familiarity for developers and portability for applications, but not 100% PostgreSQL compatibility.
The SQL syntax that Spanner supports is semantically equivalent PostgreSQL, meaning schemas
and queries written against the PostgreSQL interface can be easily ported to another PostgreSQL
environment.

This sample showcases this portability with an application that works on both Cloud Spanner PostgreSQL
and open-source PostgreSQL with the same code base.

## Spring Data JDBC

[Spring Data JDBC](https://spring.io/projects/spring-data-jdbc) is part of the larger Spring Data
family. It makes it easy to implement JDBC based repositories. This module deals with enhanced
support for JDBC based data access layers.

Spring Data JDBC aims at being conceptually easy. In order to achieve this it does NOT offer caching,
lazy loading, write behind or many other features of JPA. This makes Spring Data JDBC a simple,
limited, opinionated ORM.

## Sample Application

This sample shows how to create a portable application using Spring Data JDBC and the Cloud Spanner
PostgreSQL dialect. The application works on both Cloud Spanner PostgreSQL and open-source
PostgreSQL. You can switch between the two by changing the active Spring profile:
* Profile `cs` runs the application on Cloud Spanner PostgreSQL.
* Profile `pg` runs the application on open-source PostgreSQL.

The default profile is `cs`. You can change the default profile by modifying the
[application.properties](src/main/resources/application.properties) file.

### Running the Application

1. Choose the database system that you want to use by choosing a profile. The default profile is
   `cs`, which runs the application on Cloud Spanner PostgreSQL. Modify the default profile in the
   [application.properties](src/main/resources/application.properties) file.
2. Modify either [application-cs.properties](src/main/resources/application-cs.properties) or
   [application-pg.properties](src/main/resources/application-pg.properties) to point to an existing
   database. If you use Cloud Spanner, the database that the configuration file references must be a
   database that uses the PostgreSQL dialect.
3. Run the application with `mvn spring-boot:run`.

### Main Application Components

The main application components are:
* [DatabaseSeeder.java](src/main/java/com/google/cloud/spanner/sample/DatabaseSeeder.java): This
  class is responsible for creating the database schema and inserting some initial test data. The
  schema is created from the [create_schema.sql](src/main/resources/create_schema.sql) file. The
  `DatabaseSeeder` class loads this file into memory and executes it on the active database using
  standard JDBC APIs. The class also removes Cloud Spanner-specific extensions to the PostgreSQL
  dialect when the application runs on open-source PostgreSQL.
* [JdbcConfiguration.java](src/main/java/com/google/cloud/spanner/sample/JdbcConfiguration.java):
  Spring Data JDBC by default detects the database dialect based on the JDBC driver that is used.
  This class overrides this default and instructs Spring Data JDBC to also use the PostgreSQL
  dialect for Cloud Spanner PostgreSQL.
* [AbstractEntity.java](src/main/java/com/google/cloud/spanner/sample/entities/AbstractEntity.java):
  This is the shared base class for all entities in this sample application. It defines a number of
  standard attributes, such as the identifier (primary key). The primary key is automatically
  generated using a (bit-reversed) sequence. [Bit-reversed sequential values](https://cloud.google.com/spanner/docs/schema-design#bit_reverse_primary_key)
  are considered a good choice for primary keys on Cloud Spanner.
* [Application.java](src/main/java/com/google/cloud/spanner/sample/Application.java): The starter
  class of the application. It contains a command-line runner that executes a selection of queries
  and updates on the database.

