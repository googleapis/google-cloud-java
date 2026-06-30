# Spring Data JDBC

This directory contains two sample applications for using Spring Data JDBC
with the Spanner JDBC driver.

[Spring Data JDBC](https://spring.io/projects/spring-data-jdbc) is part of the larger Spring Data
family. It makes it easy to implement JDBC based repositories.
This module deals with enhanced support for JDBC based data access layers.

Spring Data JDBC aims at being conceptually easy. In order to achieve this it does NOT offer caching,
lazy loading, write behind or many other features of JPA. This makes Spring Data JDBC a simple,
limited, opinionated ORM.

- [GoogleSQL](googlesql): This sample uses the Spanner GoogleSQL dialect.
- [PostgreSQL](postgresql): This sample uses the Spanner PostgreSQL dialect and the Spanner JDBC
  driver. It does not use PGAdapter. The sample application can also be configured to run on open
  source PostgreSQL, and shows how a portable application be developed using this setup.
