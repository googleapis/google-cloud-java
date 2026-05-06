# Spring Data JDBC Sample Application with Spanner GoogleSQL

This sample application shows how to use Spring Data JDBC with Spanner GoogleSQL.

This sample shows:

1. How to use Spring Data JDBC with Spanner GoogleSQL.
2. How to use bit-reversed identity columns to automatically generate primary key values for entities.
3. How to set the transaction isolation level that is used by the Spanner JDBC driver.

## Spring Data JDBC

[Spring Data JDBC](https://spring.io/projects/spring-data-jdbc) is part of the larger Spring Data
family. It makes it easy to implement JDBC based repositories. This module deals with enhanced
support for JDBC based data access layers.

Spring Data JDBC aims at being conceptually easy. In order to achieve this it does NOT offer caching,
lazy loading, write behind or many other features of JPA. This makes Spring Data JDBC a simple,
limited, opinionated ORM.

### Running the Application

The application by default runs on the Spanner Emulator.

1. Modify the [application.properties](src/main/resources/application.properties) to point to an existing
   database. The database must use the GoogleSQL dialect.
2. Run the application with `mvn spring-boot:run`.

### Main Application Components

The main application components are:
* [DatabaseSeeder.java](src/main/java/com/google/cloud/spanner/sample/DatabaseSeeder.java): This
  class is responsible for creating the database schema and inserting some initial test data. The
  schema is created from the [create_schema.sql](src/main/resources/create_schema.sql) file. The
  `DatabaseSeeder` class loads this file into memory and executes it on the active database using
  standard JDBC APIs.
* [SpannerDialectProvider](src/main/java/com/google/cloud/spanner/sample/SpannerDialectProvider.java):
  Spring Data JDBC by default detects the database dialect based on the JDBC driver that is used.
  Spanner GoogleSQL is not automatically recognized by Spring Data, so we add a dialect provider
  for Spanner.
* [SpannerDialect](src/main/java/com/google/cloud/spanner/sample/SpannerDialect.java):
  Spring Data JDBC requires a dialect for the database, so it knows which features are supported,
  and how to build clauses like `LIMIT` and `FOR UPDATE`. This class provides this information. It
  is based on the built-in `AnsiDialect` in Spring Data JDBC.
* [JdbcConfiguration.java](src/main/java/com/google/cloud/spanner/sample/JdbcConfiguration.java):
  This configuration file serves two purposes:
  1. Make sure `OpenTelemetry` is initialized before any data sources.
  2. Add a converter for `LocalDate` properties. Spring Data JDBC by default map these to `TIMESTAMP`
     columns, but a better fit in Spanner is `DATE`.
* [AbstractEntity.java](src/main/java/com/google/cloud/spanner/sample/entities/AbstractEntity.java):
  This is the shared base class for all entities in this sample application. It defines a number of
  standard attributes, such as the identifier (primary key). The primary key is automatically
  generated using a (bit-reversed) sequence. [Bit-reversed sequential values](https://cloud.google.com/spanner/docs/schema-design#bit_reverse_primary_key)
  are considered a good choice for primary keys on Cloud Spanner.
* [Application.java](src/main/java/com/google/cloud/spanner/sample/Application.java): The starter
  class of the application. It contains a command-line runner that executes a selection of queries
  and updates on the database.
