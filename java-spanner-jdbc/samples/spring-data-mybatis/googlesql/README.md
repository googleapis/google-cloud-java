# Spring Data MyBatis Sample Application with Spanner GoogleSQL

This sample application shows how to develop applications using Spring Data MyBatis in
combination with Spanner GoogleSQL.

This sample shows:

1. How to use Spring Data MyBatis with a Spanner GoogleSQL database.
2. How to use bit-reversed identity columns to automatically generate primary key values for entities.
3. How to set the transaction isolation level that is used by the Spanner JDBC driver.
4. How to use the Spanner Emulator for development in combination with Spring Data.

## MyBatis Spring
[MyBatis Spring](http://mybatis.org/spring/) integrates MyBatis with the popular Java Spring
framework. This allows MyBatis to participate in Spring transactions and to automatically inject
MyBatis mappers into other beans.

### Running the Application

1. The sample by default starts an instance of the Spanner Emulator together with the application and
   runs the application against the emulator.
2. To run the sample on a real Spanner database, modify
   [application.properties](src/main/resources/application.properties) and set the
   `spanner.emulator` property to `false`. Modify the `spanner.project`, `spanner.instance`, and
   `spanner.database` properties to point to an existing Spanner database. 
   The database must use the GoogleSQL dialect.
3. Run the application with `mvn spring-boot:run`.

### Main Application Components

The main application components are:
* [DatabaseSeeder.java](src/main/java/com/google/cloud/spanner/sample/DatabaseSeeder.java): This
  class is responsible for creating the database schema and inserting some initial test data. The
  schema is created from the [create_schema.sql](src/main/resources/create_schema.sql) file. The
  `DatabaseSeeder` class loads this file into memory and executes it on the active database using
  standard JDBC APIs.
* [EmulatorInitializer.java](src/main/java/com/google/cloud/spanner/sample/EmulatorInitializer.java):
  This ApplicationListener automatically starts the Spanner emulator as a Docker container if the
  sample has been configured to run on the emulator. You can disable this with the `spanner.emulator`
  property in `application.properties`.
* [AbstractEntity.java](src/main/java/com/google/cloud/spanner/sample/entities/AbstractEntity.java):
  This is the shared base class for all entities in this sample application. It defines a number of
  standard attributes, such as the identifier (primary key). The primary key is automatically
  generated using a (bit-reversed) identity column. [Bit-reversed sequential values](https://cloud.google.com/spanner/docs/schema-design#bit_reverse_primary_key)
  are considered a good choice for primary keys in Spanner.
* [Application.java](src/main/java/com/google/cloud/spanner/sample/Application.java): The starter
  class of the application. It contains a command-line runner that executes a selection of queries
  and updates on the database.
* [SingerService](src/main/java/com/google/cloud/spanner/sample/service/SingerService.java) and
  [AlbumService](src/main/java/com/google/cloud/spanner/sample/service/SingerService.java) are
  standard Spring service beans that contain business logic that can be executed as transactions.
  This includes both read/write and read-only transactions.
