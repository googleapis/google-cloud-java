/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner.jdbc;

import com.example.spanner.jdbc.SingerProto.Genre;
import com.example.spanner.jdbc.SingerProto.SingerInfo;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Type.StructField;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminSettings;
import com.google.cloud.spanner.jdbc.CloudSpannerJdbcConnection;
import com.google.cloud.spanner.jdbc.ProtoEnumType;
import com.google.cloud.spanner.jdbc.ProtoMessageType;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.DatabaseDialect;
import com.google.spanner.admin.instance.v1.InstanceName;
import com.google.spanner.v1.DatabaseName;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ExecutionException;

public final class JdbcSample {
  static class Singer {

    /** Primary key in the Singers table. */
    private final long singerId;

    /** Mapped to the FirstName column. */
    private final String firstName;

    /** Mapped to the FirstName column. */
    private final String lastName;

    Singer(final long id, final String first, final String last) {
      this.singerId = id;
      this.firstName = first;
      this.lastName = last;
    }

    public long getSingerId() {
      return singerId;
    }

    public String getFirstName() {
      return firstName;
    }

    public String getLastName() {
      return lastName;
    }
  }

  static class Album {

    /** The first part of the primary key of Albums. */
    private final long singerId;

    /** The second part of the primary key of Albums. */
    private final long albumId;

    /** Mapped to the AlbumTitle column. */
    private final String albumTitle;

    Album(final long singer, final long album, final String title) {
      this.singerId = singer;
      this.albumId = album;
      this.albumTitle = title;
    }

    public long getSingerId() {
      return singerId;
    }

    public long getAlbumId() {
      return albumId;
    }

    public String getAlbumTitle() {
      return albumTitle;
    }
  }

  // [START spanner_insert_data]
  // [START spanner_postgresql_insert_data]
  /** The list of Singers to insert. */
  static final List<Singer> SINGERS =
      Arrays.asList(
          new Singer(1, "Marc", "Richards"),
          new Singer(2, "Catalina", "Smith"),
          new Singer(3, "Alice", "Trentor"),
          new Singer(4, "Lea", "Martin"),
          new Singer(5, "David", "Lomond"));

  /** The list of Albums to insert. */
  static final List<Album> ALBUMS =
      Arrays.asList(
          new Album(1, 1, "Total Junk"),
          new Album(1, 2, "Go, Go, Go"),
          new Album(2, 1, "Green"),
          new Album(2, 2, "Forever Hold Your Peace"),
          new Album(2, 3, "Terrified"));

  // [END spanner_insert_data]
  // [END spanner_postgresql_insert_data]

  private JdbcSample() {
  }

  // [START spanner_create_database]
  static void createDatabase(
      final DatabaseAdminClient dbAdminClient,
      final InstanceName instanceName,
      final String databaseId,
      final Properties properties) throws SQLException {
    // Use the Spanner admin client to create a database.
    CreateDatabaseRequest createDatabaseRequest =
        CreateDatabaseRequest.newBuilder()
            .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
            .setParent(instanceName.toString())
            .build();
    try {
      dbAdminClient.createDatabaseAsync(createDatabaseRequest).get();
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }

    // Connect to the database with the JDBC driver and create two test tables.
    String projectId = instanceName.getProject();
    String instanceId = instanceName.getInstance();
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                projectId, instanceId, databaseId),
            properties)) {
      try (Statement statement = connection.createStatement()) {
        // Create the tables in one batch.
        statement.addBatch(
            "CREATE TABLE Singers ("
                + "  SingerId   INT64 NOT NULL,"
                + "  FirstName  STRING(1024),"
                + "  LastName   STRING(1024),"
                + "  SingerInfo BYTES(MAX),"
                + "  FullName STRING(2048) AS "
                + "  (ARRAY_TO_STRING([FirstName, LastName], \" \")) STORED"
                + ") PRIMARY KEY (SingerId)");
        statement.addBatch(
            "CREATE TABLE Albums ("
                + "  SingerId     INT64 NOT NULL,"
                + "  AlbumId      INT64 NOT NULL,"
                + "  AlbumTitle   STRING(MAX)"
                + ") PRIMARY KEY (SingerId, AlbumId),"
                + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE");
        statement.executeBatch();
      }
    }
    System.out.printf(
        "Created database [%s]\n",
        DatabaseName.of(projectId, instanceId, databaseId));
  }
  // [END spanner_create_database]

  // [START spanner_postgresql_create_database]
  static void createPostgreSQLDatabase(
      final DatabaseAdminClient dbAdminClient,
      final InstanceName instanceName,
      final String databaseId,
      final Properties properties) throws SQLException {
    // Use the Spanner admin client to create a database.
    CreateDatabaseRequest createDatabaseRequest =
        CreateDatabaseRequest.newBuilder()
            // PostgreSQL database names and other identifiers
            // must be quoted using double quotes.
            .setCreateStatement("create database \"" + databaseId + "\"")
            .setParent(instanceName.toString())
            .setDatabaseDialect(DatabaseDialect.POSTGRESQL)
            .build();
    try {
      dbAdminClient.createDatabaseAsync(createDatabaseRequest).get();
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }

    // Connect to the database with the JDBC driver and create two test tables.
    String projectId = instanceName.getProject();
    String instanceId = instanceName.getInstance();
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                projectId, instanceId, databaseId),
            properties)) {
      try (Statement statement = connection.createStatement()) {
        // Create the tables in one batch.
        statement.addBatch(
            "create table singers ("
                + "  singer_id   bigint primary key not null,"
                + "  first_name  varchar(1024),"
                + "  last_name   varchar(1024),"
                + "  singer_info bytea,"
                + "  full_name   varchar(2048) generated always as (\n"
                + "      case when first_name is null then last_name\n"
                + "          when last_name  is null then first_name\n"
                + "          else first_name || ' ' || last_name\n"
                + "      end) stored"
                + ")");
        statement.addBatch(
            "create table albums ("
                + "  singer_id     bigint not null,"
                + "  album_id      bigint not null,"
                + "  album_title   varchar,"
                + "  primary key (singer_id, album_id)"
                + ") interleave in parent singers on delete cascade");
        statement.executeBatch();
      }
    }
    System.out.printf(
        "Created database [%s]\n",
        DatabaseName.of(projectId, instanceId, databaseId));
  }
  // [END spanner_postgresql_create_database]

  // [START spanner_create_jdbc_connection]
  static void createConnection(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    // Connection properties can be specified both with in a Properties object
    // and in the connection URL.
    properties.put("numChannels", "8");
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s"
                    + ";minSessions=400;maxSessions=400",
                project, instance, database),
            properties)) {
      try (ResultSet resultSet =
          connection.createStatement().executeQuery("select 'Hello World!'")) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1));
        }
      }
    }
  }
  // [END spanner_create_jdbc_connection]

  // [START spanner_create_jdbc_connection_with_emulator]
  static void createConnectionWithEmulator(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    // Add autoConfigEmulator=true to the connection URL to instruct the JDBC
    // driver to connect to the Spanner emulator on localhost:9010.
    // The Spanner instance and database are automatically created if these
    // don't already exist.
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s"
                    + ";autoConfigEmulator=true",
                project, instance, database),
            properties)) {
      try (ResultSet resultSet =
          connection.createStatement().executeQuery("select 'Hello World!'")) {
        while (resultSet.next()) {
          System.out.println(resultSet.getString(1));
        }
      }
    }
  }
  // [END spanner_create_jdbc_connection_with_emulator]

  // [START spanner_dml_getting_started_insert]
  static void writeDataWithDml(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Add 4 rows in one statement.
      // JDBC always uses '?' as a parameter placeholder.
      try (PreparedStatement preparedStatement =
          connection.prepareStatement(
              "INSERT INTO Singers (SingerId, FirstName, LastName) VALUES "
                  + "(?, ?, ?), "
                  + "(?, ?, ?), "
                  + "(?, ?, ?), "
                  + "(?, ?, ?)")) {

        final ImmutableList<Singer> singers =
            ImmutableList.of(
                new Singer(/* SingerId = */ 12L, "Melissa", "Garcia"),
                new Singer(/* SingerId = */ 13L, "Russel", "Morales"),
                new Singer(/* SingerId = */ 14L, "Jacqueline", "Long"),
                new Singer(/* SingerId = */ 15L, "Dylan", "Shaw"));

        // Note that JDBC parameters start at index 1.
        int paramIndex = 0;
        for (Singer singer : singers) {
          preparedStatement.setLong(++paramIndex, singer.singerId);
          preparedStatement.setString(++paramIndex, singer.firstName);
          preparedStatement.setString(++paramIndex, singer.lastName);
        }

        int updateCount = preparedStatement.executeUpdate();
        System.out.printf("%d records inserted.\n", updateCount);
      }
    }
  }
  // [END spanner_dml_getting_started_insert]

  // [START spanner_postgresql_dml_getting_started_insert]
  static void writeDataWithDmlPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Add 4 rows in one statement.
      // JDBC always uses '?' as a parameter placeholder.
      try (PreparedStatement preparedStatement =
          connection.prepareStatement(
              "INSERT INTO singers (singer_id, first_name, last_name) VALUES "
                  + "(?, ?, ?), "
                  + "(?, ?, ?), "
                  + "(?, ?, ?), "
                  + "(?, ?, ?)")) {

        final ImmutableList<Singer> singers =
            ImmutableList.of(
                new Singer(/* SingerId = */ 12L, "Melissa", "Garcia"),
                new Singer(/* SingerId = */ 13L, "Russel", "Morales"),
                new Singer(/* SingerId = */ 14L, "Jacqueline", "Long"),
                new Singer(/* SingerId = */ 15L, "Dylan", "Shaw"));

        // Note that JDBC parameters start at index 1.
        int paramIndex = 0;
        for (Singer singer : singers) {
          preparedStatement.setLong(++paramIndex, singer.singerId);
          preparedStatement.setString(++paramIndex, singer.firstName);
          preparedStatement.setString(++paramIndex, singer.lastName);
        }

        int updateCount = preparedStatement.executeUpdate();
        System.out.printf("%d records inserted.\n", updateCount);
      }
    }
  }
  // [END spanner_postgresql_dml_getting_started_insert]

  // [START spanner_dml_batch]
  static void writeDataWithDmlBatch(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Add multiple rows in one DML batch.
      // JDBC always uses '?' as a parameter placeholder.
      try (PreparedStatement preparedStatement =
          connection.prepareStatement(
              "INSERT INTO Singers (SingerId, FirstName, LastName) "
                  + "VALUES (?, ?, ?)")) {
        final ImmutableList<Singer> singers =
            ImmutableList.of(
                new Singer(/* SingerId = */ 16L, "Sarah", "Wilson"),
                new Singer(/* SingerId = */ 17L, "Ethan", "Miller"),
                new Singer(/* SingerId = */ 18L, "Maya", "Patel"));

        for (Singer singer : singers) {
          // Note that JDBC parameters start at index 1.
          int paramIndex = 0;
          preparedStatement.setLong(++paramIndex, singer.singerId);
          preparedStatement.setString(++paramIndex, singer.firstName);
          preparedStatement.setString(++paramIndex, singer.lastName);
          preparedStatement.addBatch();
        }

        int[] updateCounts = preparedStatement.executeBatch();
        System.out.printf(
            "%d records inserted.\n",
            Arrays.stream(updateCounts).sum());
      }
    }
  }
  // [END spanner_dml_batch]

  // [START spanner_postgresql_dml_batch]
  static void writeDataWithDmlBatchPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Add multiple rows in one DML batch.
      // JDBC always uses '?' as a parameter placeholder.
      try (PreparedStatement preparedStatement =
          connection.prepareStatement(
              "INSERT INTO singers (singer_id, first_name, last_name)"
                  + " VALUES (?, ?, ?)")) {
        final ImmutableList<Singer> singers =
            ImmutableList.of(
                new Singer(/* SingerId = */ 16L, "Sarah", "Wilson"),
                new Singer(/* SingerId = */ 17L, "Ethan", "Miller"),
                new Singer(/* SingerId = */ 18L, "Maya", "Patel"));

        for (Singer singer : singers) {
          // Note that JDBC parameters start at index 1.
          int paramIndex = 0;
          preparedStatement.setLong(++paramIndex, singer.singerId);
          preparedStatement.setString(++paramIndex, singer.firstName);
          preparedStatement.setString(++paramIndex, singer.lastName);
          preparedStatement.addBatch();
        }

        int[] updateCounts = preparedStatement.executeBatch();
        System.out.printf(
            "%d records inserted.\n",
            Arrays.stream(updateCounts).sum());
      }
    }
  }
  // [END spanner_postgresql_dml_batch]

  // [START spanner_insert_data]
  static void writeDataWithMutations(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Unwrap the CloudSpannerJdbcConnection interface
      // from the java.sql.Connection.
      CloudSpannerJdbcConnection cloudSpannerJdbcConnection =
          connection.unwrap(CloudSpannerJdbcConnection.class);

      List<Mutation> mutations = new ArrayList<>();
      for (Singer singer : SINGERS) {
        mutations.add(
            Mutation.newInsertBuilder("Singers")
                .set("SingerId")
                .to(singer.singerId)
                .set("FirstName")
                .to(singer.firstName)
                .set("LastName")
                .to(singer.lastName)
                .build());
      }
      for (Album album : ALBUMS) {
        mutations.add(
            Mutation.newInsertBuilder("Albums")
                .set("SingerId")
                .to(album.singerId)
                .set("AlbumId")
                .to(album.albumId)
                .set("AlbumTitle")
                .to(album.albumTitle)
                .build());
      }
      // Apply the mutations atomically to Spanner.
      cloudSpannerJdbcConnection.write(mutations);
      System.out.printf("Inserted %d rows.\n", mutations.size());
    }
  }
  // [END spanner_insert_data]

  // [START spanner_postgresql_insert_data]
  static void writeDataWithMutationsPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Unwrap the CloudSpannerJdbcConnection interface
      // from the java.sql.Connection.
      CloudSpannerJdbcConnection cloudSpannerJdbcConnection =
          connection.unwrap(CloudSpannerJdbcConnection.class);

      List<Mutation> mutations = new ArrayList<>();
      for (Singer singer : SINGERS) {
        mutations.add(
            Mutation.newInsertBuilder("singers")
                .set("singer_id")
                .to(singer.singerId)
                .set("first_name")
                .to(singer.firstName)
                .set("last_name")
                .to(singer.lastName)
                .build());
      }
      for (Album album : ALBUMS) {
        mutations.add(
            Mutation.newInsertBuilder("albums")
                .set("singer_id")
                .to(album.singerId)
                .set("album_id")
                .to(album.albumId)
                .set("album_title")
                .to(album.albumTitle)
                .build());
      }
      // Apply the mutations atomically to Spanner.
      cloudSpannerJdbcConnection.write(mutations);
      System.out.printf("Inserted %d rows.\n", mutations.size());
    }
  }
  // [END spanner_postgresql_insert_data]

  // [START spanner_query_data]
  static void queryData(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT SingerId, AlbumId, AlbumTitle "
                  + "FROM Albums")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("SingerId"),
              resultSet.getLong("AlbumId"),
              resultSet.getString("AlbumTitle"));
        }
      }
    }
  }
  // [END spanner_query_data]

  // [START spanner_postgresql_query_data]
  static void queryDataPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT singer_id, album_id, album_title "
                      + "FROM albums")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("singer_id"),
              resultSet.getLong("album_id"),
              resultSet.getString("album_title"));
        }
      }
    }
  }
  // [END spanner_postgresql_query_data]

  // [START spanner_query_with_parameter]
  static void queryWithParameter(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (PreparedStatement statement =
          connection.prepareStatement(
              "SELECT SingerId, FirstName, LastName "
                  + "FROM Singers "
                  + "WHERE LastName = ?")) {
        statement.setString(1, "Garcia");
        try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            System.out.printf(
                "%d %s %s\n",
                resultSet.getLong("SingerId"),
                resultSet.getString("FirstName"),
                resultSet.getString("LastName"));
          }
        }
      }
    }
  }
  // [END spanner_query_with_parameter]

  // [START spanner_postgresql_query_with_parameter]
  static void queryWithParameterPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (PreparedStatement statement =
          connection.prepareStatement(
              "SELECT singer_id, first_name, last_name "
                  + "FROM singers "
                  + "WHERE last_name = ?")) {
        statement.setString(1, "Garcia");
        try (ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            System.out.printf(
                "%d %s %s\n",
                resultSet.getLong("singer_id"),
                resultSet.getString("first_name"),
                resultSet.getString("last_name"));
          }
        }
      }
    }
  }
  // [END spanner_postgresql_query_with_parameter]

  // [START spanner_add_column]
  static void addColumn(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      connection
          .createStatement()
          .execute("ALTER TABLE Albums ADD COLUMN MarketingBudget INT64");
      System.out.println("Added MarketingBudget column");
    }
  }
  // [END spanner_add_column]

  // [START spanner_postgresql_add_column]
  static void addColumnPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      connection
          .createStatement()
          .execute("alter table albums add column marketing_budget bigint");
      System.out.println("Added marketing_budget column");
    }
  }
  // [END spanner_postgresql_add_column]

  // [START spanner_ddl_batch]
  static void ddlBatch(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (Statement statement = connection.createStatement()) {
        // Create two new tables in one batch.
        statement.addBatch(
            "CREATE TABLE Venues ("
                + "  VenueId     INT64 NOT NULL,"
                + "  Name        STRING(1024),"
                + "  Description JSON"
                + ") PRIMARY KEY (VenueId)");
        statement.addBatch(
            "CREATE TABLE Concerts ("
                + "  ConcertId INT64 NOT NULL,"
                + "  VenueId   INT64 NOT NULL,"
                + "  SingerId  INT64 NOT NULL,"
                + "  StartTime TIMESTAMP,"
                + "  EndTime   TIMESTAMP,"
                + "  CONSTRAINT Fk_Concerts_Venues FOREIGN KEY"
                + "    (VenueId) REFERENCES Venues (VenueId),"
                + "  CONSTRAINT Fk_Concerts_Singers FOREIGN KEY"
                + "    (SingerId) REFERENCES Singers (SingerId),"
                + ") PRIMARY KEY (ConcertId)");
        statement.executeBatch();
      }
      System.out.println("Added Venues and Concerts tables");
    }
  }
  // [END spanner_ddl_batch]

  // [START spanner_postgresql_ddl_batch]
  static void ddlBatchPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (Statement statement = connection.createStatement()) {
        // Create two new tables in one batch.
        statement.addBatch(
            "CREATE TABLE venues ("
                + "  venue_id    bigint not null primary key,"
                + "  name        varchar(1024),"
                + "  description jsonb"
                + ")");
        statement.addBatch(
            "CREATE TABLE concerts ("
                + "  concert_id bigint not null primary key ,"
                + "  venue_id   bigint not null,"
                + "  singer_id  bigint not null,"
                + "  start_time timestamptz,"
                + "  end_time   timestamptz,"
                + "  constraint fk_concerts_venues foreign key"
                + "    (venue_id) references venues (venue_id),"
                + "  constraint fk_concerts_singers foreign key"
                + "    (singer_id) references singers (singer_id)"
                + ")");
        statement.executeBatch();
      }
      System.out.println("Added venues and concerts tables");
    }
  }
  // [END spanner_postgresql_ddl_batch]

  // [START spanner_update_data]
  static void updateDataWithMutations(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Unwrap the CloudSpannerJdbcConnection interface
      // from the java.sql.Connection.
      CloudSpannerJdbcConnection cloudSpannerJdbcConnection =
          connection.unwrap(CloudSpannerJdbcConnection.class);

      final long marketingBudgetAlbum1 = 100000L;
      final long marketingBudgetAlbum2 = 500000L;
      // Mutation can be used to update/insert/delete a single row in a table.
      // Here we use newUpdateBuilder to create update mutations.
      List<Mutation> mutations =
          Arrays.asList(
              Mutation.newUpdateBuilder("Albums")
                  .set("SingerId")
                  .to(1)
                  .set("AlbumId")
                  .to(1)
                  .set("MarketingBudget")
                  .to(marketingBudgetAlbum1)
                  .build(),
              Mutation.newUpdateBuilder("Albums")
                  .set("SingerId")
                  .to(2)
                  .set("AlbumId")
                  .to(2)
                  .set("MarketingBudget")
                  .to(marketingBudgetAlbum2)
                  .build());
      // This writes all the mutations to Cloud Spanner atomically.
      cloudSpannerJdbcConnection.write(mutations);
      System.out.println("Updated albums");
    }
  }
  // [END spanner_update_data]

  // [START spanner_postgresql_update_data]
  static void updateDataWithMutationsPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Unwrap the CloudSpannerJdbcConnection interface
      // from the java.sql.Connection.
      CloudSpannerJdbcConnection cloudSpannerJdbcConnection =
          connection.unwrap(CloudSpannerJdbcConnection.class);

      final long marketingBudgetAlbum1 = 100000L;
      final long marketingBudgetAlbum2 = 500000L;
      // Mutation can be used to update/insert/delete a single row in a table.
      // Here we use newUpdateBuilder to create update mutations.
      List<Mutation> mutations =
          Arrays.asList(
              Mutation.newUpdateBuilder("albums")
                  .set("singer_id")
                  .to(1)
                  .set("album_id")
                  .to(1)
                  .set("marketing_budget")
                  .to(marketingBudgetAlbum1)
                  .build(),
              Mutation.newUpdateBuilder("albums")
                  .set("singer_id")
                  .to(2)
                  .set("album_id")
                  .to(2)
                  .set("marketing_budget")
                  .to(marketingBudgetAlbum2)
                  .build());
      // This writes all the mutations to Cloud Spanner atomically.
      cloudSpannerJdbcConnection.write(mutations);
      System.out.println("Updated albums");
    }
  }
  // [END spanner_postgresql_update_data]

  // [START spanner_query_data_with_new_column]
  static void queryDataWithNewColumn(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Rows without an explicit value for MarketingBudget will have a
      // MarketingBudget equal to null.
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT SingerId, AlbumId, MarketingBudget "
                  + "FROM Albums")) {
        while (resultSet.next()) {
          // Use the ResultSet#getObject(String) method to get data
          // of any type from the ResultSet.
          System.out.printf(
              "%s %s %s\n",
              resultSet.getObject("SingerId"),
              resultSet.getObject("AlbumId"),
              resultSet.getObject("MarketingBudget"));
        }
      }
    }
  }
  // [END spanner_query_data_with_new_column]

  // [START spanner_postgresql_query_data_with_new_column]
  static void queryDataWithNewColumnPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Rows without an explicit value for marketing_budget will have a
      // marketing_budget equal to null.
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "select singer_id, album_id, marketing_budget "
                      + "from albums")) {
        while (resultSet.next()) {
          // Use the ResultSet#getObject(String) method to get data
          // of any type from the ResultSet.
          System.out.printf(
              "%s %s %s\n",
              resultSet.getObject("singer_id"),
              resultSet.getObject("album_id"),
              resultSet.getObject("marketing_budget"));
        }
      }
    }
  }
  // [END spanner_postgresql_query_data_with_new_column]

  // [START spanner_dml_getting_started_update]
  static void writeWithTransactionUsingDml(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);

      // Transfer marketing budget from one album to another.
      // We do it in a transaction to ensure that the transfer is atomic.
      // There is no need to explicitly start the transaction. The first
      // statement on the connection will start a transaction when
      // AutoCommit=false.
      String selectMarketingBudgetSql =
          "SELECT MarketingBudget "
          + "FROM Albums "
          + "WHERE SingerId = ? AND AlbumId = ?";
      long album2Budget = 0;
      try (PreparedStatement selectMarketingBudgetStatement =
          connection.prepareStatement(selectMarketingBudgetSql)) {
        // Bind the query parameters to SingerId=2 and AlbumId=2.
        selectMarketingBudgetStatement.setLong(1, 2);
        selectMarketingBudgetStatement.setLong(2, 2);
        try (ResultSet resultSet =
            selectMarketingBudgetStatement.executeQuery()) {
          while (resultSet.next()) {
            album2Budget = resultSet.getLong("MarketingBudget");
          }
        }
        // The transaction will only be committed if this condition still holds
        // at the time of commit. Otherwise, the transaction will be aborted.
        final long transfer = 200000;
        if (album2Budget >= transfer) {
          long album1Budget = 0;
          // Re-use the existing PreparedStatement for selecting the
          // MarketingBudget to get the budget for Album 1.
          // Bind the query parameters to SingerId=1 and AlbumId=1.
          selectMarketingBudgetStatement.setLong(1, 1);
          selectMarketingBudgetStatement.setLong(2, 1);
          try (ResultSet resultSet =
              selectMarketingBudgetStatement.executeQuery()) {
            while (resultSet.next()) {
              album1Budget = resultSet.getLong("MarketingBudget");
            }
          }

          // Transfer part of the marketing budget of Album 2 to Album 1.
          album1Budget += transfer;
          album2Budget -= transfer;
          String updateSql =
              "UPDATE Albums "
                  + "SET MarketingBudget = ? "
                  + "WHERE SingerId = ? and AlbumId = ?";
          try (PreparedStatement updateStatement =
              connection.prepareStatement(updateSql)) {
            // Update Album 1.
            int paramIndex = 0;
            updateStatement.setLong(++paramIndex, album1Budget);
            updateStatement.setLong(++paramIndex, 1);
            updateStatement.setLong(++paramIndex, 1);
            // Create a DML batch by calling addBatch on
            // the current PreparedStatement.
            updateStatement.addBatch();

            // Update Album 2 in the same DML batch.
            paramIndex = 0;
            updateStatement.setLong(++paramIndex, album2Budget);
            updateStatement.setLong(++paramIndex, 2);
            updateStatement.setLong(++paramIndex, 2);
            updateStatement.addBatch();

            // Execute both DML statements in one batch.
            updateStatement.executeBatch();
          }
        }
      }
      // Commit the current transaction.
      connection.commit();
      System.out.println(
          "Transferred marketing budget from Album 2 to Album 1");
    }
  }
  // [END spanner_dml_getting_started_update]

  // [START spanner_postgresql_dml_getting_started_update]
  static void writeWithTransactionUsingDmlPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);

      // Transfer marketing budget from one album to another. We do it in a
      // transaction to ensure that the transfer is atomic. There is no need
      // to explicitly start the transaction. The first statement on the
      // connection will start a transaction when AutoCommit=false.
      String selectMarketingBudgetSql =
          "SELECT marketing_budget "
              + "from albums "
              + "WHERE singer_id = ? and album_id = ?";
      long album2Budget = 0;
      try (PreparedStatement selectMarketingBudgetStatement =
          connection.prepareStatement(selectMarketingBudgetSql)) {
        // Bind the query parameters to SingerId=2 and AlbumId=2.
        selectMarketingBudgetStatement.setLong(1, 2);
        selectMarketingBudgetStatement.setLong(2, 2);
        try (ResultSet resultSet =
            selectMarketingBudgetStatement.executeQuery()) {
          while (resultSet.next()) {
            album2Budget = resultSet.getLong("marketing_budget");
          }
        }
        // The transaction will only be committed if this condition still holds
        // at the time of commit. Otherwise, the transaction will be aborted.
        final long transfer = 200000;
        if (album2Budget >= transfer) {
          long album1Budget = 0;
          // Re-use the existing PreparedStatement for selecting the
          // marketing_budget to get the budget for Album 1.
          // Bind the query parameters to SingerId=1 and AlbumId=1.
          selectMarketingBudgetStatement.setLong(1, 1);
          selectMarketingBudgetStatement.setLong(2, 1);
          try (ResultSet resultSet =
              selectMarketingBudgetStatement.executeQuery()) {
            while (resultSet.next()) {
              album1Budget = resultSet.getLong("marketing_budget");
            }
          }

          // Transfer part of the marketing budget of Album 2 to Album 1.
          album1Budget += transfer;
          album2Budget -= transfer;
          String updateSql =
              "UPDATE albums "
                  + "SET marketing_budget = ? "
                  + "WHERE singer_id = ? and album_id = ?";
          try (PreparedStatement updateStatement =
              connection.prepareStatement(updateSql)) {
            // Update Album 1.
            int paramIndex = 0;
            updateStatement.setLong(++paramIndex, album1Budget);
            updateStatement.setLong(++paramIndex, 1);
            updateStatement.setLong(++paramIndex, 1);
            // Create a DML batch by calling addBatch
            // on the current PreparedStatement.
            updateStatement.addBatch();

            // Update Album 2 in the same DML batch.
            paramIndex = 0;
            updateStatement.setLong(++paramIndex, album2Budget);
            updateStatement.setLong(++paramIndex, 2);
            updateStatement.setLong(++paramIndex, 2);
            updateStatement.addBatch();

            // Execute both DML statements in one batch.
            updateStatement.executeBatch();
          }
        }
      }
      // Commit the current transaction.
      connection.commit();
      System.out.println(
          "Transferred marketing budget from Album 2 to Album 1");
    }
  }
  // [END spanner_postgresql_dml_getting_started_update]

  // [START spanner_transaction_and_statement_tag]
  static void tags(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);
      // Set the TRANSACTION_TAG session variable to set a transaction tag
      // for the current transaction.
      connection
          .createStatement()
          .execute("SET TRANSACTION_TAG='example-tx-tag'");

      // Set the STATEMENT_TAG session variable to set the request tag
      // that should be included with the next SQL statement.
      connection
          .createStatement()
          .execute("SET STATEMENT_TAG='query-marketing-budget'");
      long marketingBudget = 0L;
      long singerId = 1L;
      long albumId = 1L;
      try (PreparedStatement statement = connection.prepareStatement(
          "SELECT MarketingBudget "
          + "FROM Albums "
          + "WHERE SingerId=? AND AlbumId=?")) {
        statement.setLong(1, singerId);
        statement.setLong(2, albumId);
        try (ResultSet albumResultSet = statement.executeQuery()) {
          while (albumResultSet.next()) {
            marketingBudget = albumResultSet.getLong(1);
          }
        }
      }
      // Reduce the marketing budget by 10% if it is more than 1,000.
      final long maxMarketingBudget = 1000L;
      final float reduction = 0.1f;
      if (marketingBudget > maxMarketingBudget) {
        marketingBudget -= (long) (marketingBudget * reduction);
        connection
            .createStatement()
            .execute("SET STATEMENT_TAG='reduce-marketing-budget'");
        try (PreparedStatement statement = connection.prepareStatement(
            "UPDATE Albums SET MarketingBudget=? "
                + "WHERE SingerId=? AND AlbumId=?")) {
          int paramIndex = 0;
          statement.setLong(++paramIndex, marketingBudget);
          statement.setLong(++paramIndex, singerId);
          statement.setLong(++paramIndex, albumId);
          statement.executeUpdate();
        }
      }

      // Commit the current transaction.
      connection.commit();
      System.out.println("Reduced marketing budget");
    }
  }
  // [END spanner_transaction_and_statement_tag]

  // [START spanner_postgresql_transaction_and_statement_tag]
  static void tagsPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);
      // Set the TRANSACTION_TAG session variable to set a transaction tag
      // for the current transaction.
      connection
          .createStatement()
          .execute("set spanner.transaction_tag='example-tx-tag'");

      // Set the STATEMENT_TAG session variable to set the request tag
      // that should be included with the next SQL statement.
      connection
          .createStatement()
          .execute("set spanner.statement_tag='query-marketing-budget'");
      long marketingBudget = 0L;
      long singerId = 1L;
      long albumId = 1L;
      try (PreparedStatement statement = connection.prepareStatement(
          "select marketing_budget "
              + "from albums "
              + "where singer_id=? and album_id=?")) {
        statement.setLong(1, singerId);
        statement.setLong(2, albumId);
        try (ResultSet albumResultSet = statement.executeQuery()) {
          while (albumResultSet.next()) {
            marketingBudget = albumResultSet.getLong(1);
          }
        }
      }
      // Reduce the marketing budget by 10% if it is more than 1,000.
      final long maxMarketingBudget = 1000L;
      final float reduction = 0.1f;
      if (marketingBudget > maxMarketingBudget) {
        marketingBudget -= (long) (marketingBudget * reduction);
        connection
            .createStatement()
            .execute("set spanner.statement_tag='reduce-marketing-budget'");
        try (PreparedStatement statement = connection.prepareStatement(
            "update albums set marketing_budget=? "
                + "where singer_id=? AND album_id=?")) {
          int paramIndex = 0;
          statement.setLong(++paramIndex, marketingBudget);
          statement.setLong(++paramIndex, singerId);
          statement.setLong(++paramIndex, albumId);
          statement.executeUpdate();
        }
      }

      // Commit the current transaction.
      connection.commit();
      System.out.println("Reduced marketing budget");
    }
  }
  // [END spanner_postgresql_transaction_and_statement_tag]

  // [START spanner_read_only_transaction]
  static void readOnlyTransaction(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);
      // This SQL statement instructs the JDBC driver to use
      // a read-only transaction.
      connection.createStatement().execute("SET TRANSACTION READ ONLY");

      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT SingerId, AlbumId, AlbumTitle "
                      + "FROM Albums "
                      + "ORDER BY SingerId, AlbumId")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("SingerId"),
              resultSet.getLong("AlbumId"),
              resultSet.getString("AlbumTitle"));
        }
      }
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT SingerId, AlbumId, AlbumTitle "
                      + "FROM Albums "
                      + "ORDER BY AlbumTitle")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("SingerId"),
              resultSet.getLong("AlbumId"),
              resultSet.getString("AlbumTitle"));
        }
      }
      // End the read-only transaction by calling commit().
      connection.commit();
    }
  }
  // [END spanner_read_only_transaction]

  // [START spanner_postgresql_read_only_transaction]
  static void readOnlyTransactionPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Set AutoCommit=false to enable transactions.
      connection.setAutoCommit(false);
      // This SQL statement instructs the JDBC driver to use
      // a read-only transaction.
      connection.createStatement().execute("set transaction read only");

      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT singer_id, album_id, album_title "
                      + "FROM albums "
                      + "ORDER BY singer_id, album_id")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("singer_id"),
              resultSet.getLong("album_id"),
              resultSet.getString("album_title"));
        }
      }
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "SELECT singer_id, album_id, album_title "
                      + "FROM albums "
                      + "ORDER BY album_title")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              resultSet.getLong("singer_id"),
              resultSet.getLong("album_id"),
              resultSet.getString("album_title"));
        }
      }
      // End the read-only transaction by calling commit().
      connection.commit();
    }
  }
  // [END spanner_postgresql_read_only_transaction]

  // [START spanner_data_boost]
  static void dataBoost(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // This enables Data Boost for all partitioned queries on this connection.
      connection.createStatement().execute("SET DATA_BOOST_ENABLED=TRUE");

      // Run a partitioned query. This query will use Data Boost.
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "RUN PARTITIONED QUERY "
                      + "SELECT SingerId, FirstName, LastName "
                      + "FROM Singers")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %s %s\n",
              resultSet.getLong("SingerId"),
              resultSet.getString("FirstName"),
              resultSet.getString("LastName"));
        }
      }
    }
  }
  // [END spanner_data_boost]

  // [START spanner_postgresql_data_boost]
  static void dataBoostPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // This enables Data Boost for all partitioned queries on this connection.
      connection
          .createStatement()
          .execute("set spanner.data_boost_enabled=true");

      // Run a partitioned query. This query will use Data Boost.
      try (ResultSet resultSet =
          connection
              .createStatement()
              .executeQuery(
                  "run partitioned query "
                      + "select singer_id, first_name, last_name "
                      + "from singers")) {
        while (resultSet.next()) {
          System.out.printf(
              "%d %s %s\n",
              resultSet.getLong("singer_id"),
              resultSet.getString("first_name"),
              resultSet.getString("last_name"));
        }
      }
    }
  }
  // [END spanner_postgresql_data_boost]

  // [START spanner_partitioned_dml]
  static void partitionedDml(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Enable Partitioned DML on this connection.
      connection
          .createStatement()
          .execute("SET AUTOCOMMIT_DML_MODE='PARTITIONED_NON_ATOMIC'");
      // Back-fill a default value for the MarketingBudget column.
      long lowerBoundUpdateCount =
          connection
              .createStatement()
              .executeUpdate("UPDATE Albums "
                  + "SET MarketingBudget=0 "
                  + "WHERE MarketingBudget IS NULL");
      System.out.printf("Updated at least %d albums\n", lowerBoundUpdateCount);
    }
  }
  // [END spanner_partitioned_dml]

  // [START spanner_postgresql_partitioned_dml]
  static void partitionedDmlPostgreSQL(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Enable Partitioned DML on this connection.
      connection
          .createStatement()
          .execute("set spanner.autocommit_dml_mode='partitioned_non_atomic'");
      // Back-fill a default value for the MarketingBudget column.
      long lowerBoundUpdateCount =
          connection
              .createStatement()
              .executeUpdate("update albums "
                  + "set marketing_budget=0 "
                  + "where marketing_budget is null");
      System.out.printf("Updated at least %d albums\n", lowerBoundUpdateCount);
    }
  }
  // [END spanner_postgresql_partitioned_dml]

  static void arrayOfStructAsQueryParameter(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      try (Statement statement = connection.createStatement()) {
        statement.execute(
            "create table if not exists my_table "
                + "(col1 string(max), col2 int64) primary key (col1)");
        statement.execute(
            "insert or update into my_table (col1, col2) "
                + "values ('value1', 1), ('value2', 2), ('value3', 3)");
      }

      try (PreparedStatement statement = connection.prepareStatement(
          "select * from my_table "
              + "where STRUCT<col1 STRING, col2 INT64>(col1, col2) "
              + "in unnest (?)")) {
        statement.setObject(
            1,
            Value.structArray(
                com.google.cloud.spanner.Type.struct(
                    StructField.of("col1", Type.string()),
                    StructField.of("col2", Type.int64())),
                ImmutableList.of(
                    Struct.newBuilder()
                        .set("col1").to("value1")
                        .set("col2").to(1L)
                        .build(),
                    Struct.newBuilder()
                        .set("col1").to("value2")
                        .set("col2").to(2L)
                        .build())));
        try (java.sql.ResultSet resultSet = statement.executeQuery()) {
          while (resultSet.next()) {
            for (int col = 1;
                col <= resultSet.getMetaData().getColumnCount();
                col++) {
              System.out.printf("%s;", resultSet.getString(col));
            }
            System.out.println();
          }
        }
      }
    }
  }

  static void protoColumns(
      final String project,
      final String instance,
      final String database,
      final Properties properties) throws SQLException, IOException {
    try (Connection connection =
        DriverManager.getConnection(
            String.format(
                "jdbc:cloudspanner:/projects/%s/instances/%s/databases/%s",
                project, instance, database),
            properties)) {
      // Create a PROTO BUNDLE and a table.
      try (Statement statement = connection.createStatement();
          InputStream protoDescriptors = JdbcSample.class.getClassLoader()
              .getResourceAsStream("com/example/spanner/jdbc/descriptors.pb")) {
        if (protoDescriptors == null) {
          throw new IllegalArgumentException("proto descriptors not found");
        }

        // Unwrap the CloudSpannerJdbcConnection interface to set the proto
        // descriptors that should be used for the next DDL statements.
        connection
            .unwrap(CloudSpannerJdbcConnection.class)
            .setProtoDescriptors(protoDescriptors);
        // Execute the DDL statements as one batch.
        // This will reduce execution time compared to executing each statement
        // sequentially.
        statement.addBatch("CREATE PROTO BUNDLE (\n"
            + "examples.spanner.music.SingerInfo,\n"
            + "examples.spanner.music.Genre,\n"
            + ")");
        statement.addBatch("CREATE TABLE SingersWithProto (\n"
            + "  SingerId INT64 NOT NULL,\n"
            + "  SingerInfo examples.spanner.music.SingerInfo,\n"
            + "  SingerGenre examples.spanner.music.Genre,\n"
            + ")  PRIMARY KEY (SingerId)");
        statement.executeBatch();
      }

      // Insert a couple of rows using a prepared statement.
      try (PreparedStatement statement = connection.prepareStatement(
          "INSERT INTO SingersWithProto "
              + "(SingerId, SingerInfo, SingerGenre) "
              + "VALUES (?, ?, ?)")) {
        int param = 0;
        statement.setLong(++param, 1L);
        statement.setObject(++param,
            SingerInfo.newBuilder()
                .setGenre(Genre.ROCK)
                .setBirthDate("1998-07-04")
                .setSingerId(1L)
                .setNationality("ES")
                .build(), ProtoMessageType.VENDOR_TYPE_NUMBER);
        statement.setObject(++param, Genre.ROCK,
            ProtoEnumType.VENDOR_TYPE_NUMBER);
        statement.addBatch();

        param = 0;
        statement.setLong(++param, 2L);
        statement.setObject(++param,
            SingerInfo.newBuilder()
                .setGenre(Genre.POP)
                .setBirthDate("2001-12-03")
                .setSingerId(2L)
                .setNationality("FO")
                .build(), ProtoMessageType.VENDOR_TYPE_NUMBER);
        statement.setObject(++param, Genre.POP,
            ProtoEnumType.VENDOR_TYPE_NUMBER);
        statement.addBatch();

        int[] updateCounts = statement.executeBatch();
        System.out.printf("Inserted %d singers\n",
            Arrays.stream(updateCounts).sum());
      }

      // Read the inserted rows.
      try (ResultSet resultSet = connection.createStatement()
          .executeQuery("SELECT * FROM SingersWithProto")) {
        while (resultSet.next()) {
          long singerId = resultSet.getLong("SingerId");
          // Proto messages and proto enums can be retrieved with the
          // ResultSet#getObject(int, Class) method.
          // The Spanner JDBC driver automatically deserializes
          // and converts the column to the Java class representation.
          SingerInfo info = resultSet.getObject("SingerInfo", SingerInfo.class);
          Genre genre = resultSet.getObject("SingerGenre", Genre.class);
          System.out.printf("%d:\n%s\n%s\n", singerId, info, genre);
        }
      }
    }
  }

  /** The expected number of command line arguments. */
  private static final int NUM_EXPECTED_ARGS = 3;

  /**
   * Main method for running a sample.
   *
   * @param args the command line arguments
   */
  public static void main(final String[] args) throws Exception {
    if (args.length != NUM_EXPECTED_ARGS) {
      printUsageAndExit();
    }
    try (DatabaseAdminClient dbAdminClient = createDatabaseAdminClient()) {
      final String command = args[0];
      DatabaseId databaseId = DatabaseId.of(
          SpannerOptions.getDefaultInstance().getProjectId(),
          args[1],
          args[2]);

      run(dbAdminClient, command, databaseId);
    }
    System.out.println();
    System.out.println("Finished running sample");
  }

  static DatabaseAdminClient createDatabaseAdminClient() throws Exception {
    String emulatorHost = System.getenv("SPANNER_EMULATOR_HOST");
    if (!Strings.isNullOrEmpty(emulatorHost)) {
      return DatabaseAdminClient.create(
          DatabaseAdminSettings.newBuilder()
              .setTransportChannelProvider(
                  InstantiatingGrpcChannelProvider.newBuilder()
                      .setEndpoint(emulatorHost)
                      .setChannelConfigurator(
                          ManagedChannelBuilder::usePlaintext)
                      .build())
              .setCredentialsProvider(NoCredentialsProvider.create())
              .build());
    }
    return DatabaseAdminClient.create();
  }

  static Properties createProperties() {
    Properties properties = new Properties();
    String emulatorHost = System.getenv("SPANNER_EMULATOR_HOST");
    if (!Strings.isNullOrEmpty(emulatorHost)) {
      properties.put("autoConfigEmulator", "true");
      properties.put("endpoint", emulatorHost);
    }
    return properties;
  }

  static void run(
      final DatabaseAdminClient dbAdminClient,
      final String command,
      final DatabaseId database) throws Exception {
    if (
        !runGoogleSQLSample(dbAdminClient, command, database)
        && !runPostgreSQLSample(dbAdminClient, command, database)) {
        System.err.println();
        System.err.println("Unknown command: " + command);
        System.err.println();
        printUsageAndExit();
    }
  }

  static boolean runGoogleSQLSample(
      final DatabaseAdminClient dbAdminClient,
      final String command,
      final DatabaseId database) throws Exception {
    switch (command) {
      case "createdatabase":
        createDatabase(
            dbAdminClient,
            InstanceName.of(
                database.getInstanceId().getProject(),
                database.getInstanceId().getInstance()),
            database.getDatabase(),
            createProperties());
        return true;
      case "writeusingdml":
        writeDataWithDml(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "writeusingdmlbatch":
        writeDataWithDmlBatch(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "write":
        writeDataWithMutations(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "query":
        queryData(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "querywithparameter":
        queryWithParameter(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "addmarketingbudget":
        addColumn(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "ddlbatch":
        ddlBatch(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "update":
        updateDataWithMutations(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "querymarketingbudget":
        queryDataWithNewColumn(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "writewithtransactionusingdml":
        writeWithTransactionUsingDml(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "tags":
        tags(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "readonlytransaction":
        readOnlyTransaction(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "databoost":
        dataBoost(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "pdml":
        partitionedDml(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "arrayofstructparam":
        arrayOfStructAsQueryParameter(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "protocolumns":
        protoColumns(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      default:
        return false;
    }
  }

  static boolean runPostgreSQLSample(
      final DatabaseAdminClient dbAdminClient,
      final String command,
      final DatabaseId database) throws Exception {
    switch (command) {
      case "createpgdatabase":
        createPostgreSQLDatabase(
            dbAdminClient,
            InstanceName.of(
                database.getInstanceId().getProject(),
                database.getInstanceId().getInstance()),
            database.getDatabase(),
            createProperties());
        return true;
      case "writeusingdmlpg":
        writeDataWithDmlPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "writeusingdmlbatchpg":
        writeDataWithDmlBatchPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "writepg":
        writeDataWithMutationsPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "querypg":
        queryDataPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "querywithparameterpg":
        queryWithParameterPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "addmarketingbudgetpg":
        addColumnPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "ddlbatchpg":
        ddlBatchPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "updatepg":
        updateDataWithMutationsPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "querymarketingbudgetpg":
        queryDataWithNewColumnPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "writewithtransactionusingdmlpg":
        writeWithTransactionUsingDmlPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "tagspg":
        tagsPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "readonlytransactionpg":
        readOnlyTransactionPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "databoostpg":
        dataBoostPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      case "pdmlpg":
        partitionedDmlPostgreSQL(
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(),
            database.getDatabase(),
            createProperties());
        return true;
      default:
        return false;
    }
  }

  static void printUsageAndExit() {
    System.err.println("Usage:");
    System.err.println("    JdbcSample <command> <instance_id> <database_id>");
    System.err.println();
    System.err.println("Examples:");
    System.err.println("    JdbcSample createdatabase my-instance example-db");
    System.exit(1);
  }
}
