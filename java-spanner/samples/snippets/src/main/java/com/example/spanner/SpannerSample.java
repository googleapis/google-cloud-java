/*
 * Copyright 2017 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.spanner;

import static com.google.cloud.spanner.Type.StructField;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ReadOnlyTransaction;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerBatchUpdateException;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.Type;
import com.google.cloud.spanner.Value;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupOperationsPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListBackupsPagedResponse;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient.ListDatabaseOperationsPagedResponse;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.io.BaseEncoding;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Timestamp;
import com.google.spanner.admin.database.v1.Backup;
import com.google.spanner.admin.database.v1.BackupInfo;
import com.google.spanner.admin.database.v1.BackupName;
import com.google.spanner.admin.database.v1.CopyBackupMetadata;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.DatabaseName;
import com.google.spanner.admin.database.v1.InstanceName;
import com.google.spanner.admin.database.v1.ListBackupOperationsRequest;
import com.google.spanner.admin.database.v1.ListBackupsRequest;
import com.google.spanner.admin.database.v1.ListDatabaseOperationsRequest;
import com.google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseMetadata;
import com.google.spanner.admin.database.v1.RestoreDatabaseRequest;
import com.google.spanner.admin.database.v1.RestoreInfo;
import com.google.spanner.v1.ExecuteSqlRequest.QueryOptions;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Example code for using the Cloud Spanner API. This example demonstrates all the common operations
 * that can be done on Cloud Spanner. These are:
 *
 * <p>
 *
 * <ul>
 *   <li>Creating a Cloud Spanner database.
 *   <li>Writing, reading and executing SQL queries.
 *   <li>Writing data using a read-write transaction.
 *   <li>Using an index to read and execute SQL queries over data.
 *   <li>Using commit timestamp for tracking when a record was last updated.
 *   <li>Using Google API Extensions for Java to make thread-safe requests via long-running
 *       operations. http://googleapis.github.io/gax-java/
 * </ul>
 */
public class SpannerSample {

  /**
   * Class to contain singer sample data.
   */
  static class Singer {

    final long singerId;
    final String firstName;
    final String lastName;

    Singer(long singerId, String firstName, String lastName) {
      this.singerId = singerId;
      this.firstName = firstName;
      this.lastName = lastName;
    }
  }

  /**
   * Class to contain album sample data.
   */
  static class Album {

    final long singerId;
    final long albumId;
    final String albumTitle;

    Album(long singerId, long albumId, String albumTitle) {
      this.singerId = singerId;
      this.albumId = albumId;
      this.albumTitle = albumTitle;
    }
  }

  /**
   * Class to contain performance sample data.
   */
  static class Performance {

    final long singerId;
    final long venueId;
    final String eventDate;
    final long revenue;

    Performance(long singerId, long venueId, String eventDate, long revenue) {
      this.singerId = singerId;
      this.venueId = venueId;
      this.eventDate = eventDate;
      this.revenue = revenue;
    }
  }

  /**
   * Class to contain venue sample data.
   */
  static class Venue {

    final long venueId;
    final String venueName;
    final String venueInfo;
    final long capacity;
    final Value availableDates;
    final String lastContactDate;
    final boolean outdoorVenue;
    final float popularityScore;
    final BigDecimal revenue;
    final Value venueDetails;

    Venue(
        long venueId,
        String venueName,
        String venueInfo,
        long capacity,
        Value availableDates,
        String lastContactDate,
        boolean outdoorVenue,
        float popularityScore,
        BigDecimal revenue,
        Value venueDetails) {
      this.venueId = venueId;
      this.venueName = venueName;
      this.venueInfo = venueInfo;
      this.capacity = capacity;
      this.availableDates = availableDates;
      this.lastContactDate = lastContactDate;
      this.outdoorVenue = outdoorVenue;
      this.popularityScore = popularityScore;
      this.revenue = revenue;
      this.venueDetails = venueDetails;
    }
  }

  // [START spanner_insert_data]
  static final List<Singer> SINGERS =
      Arrays.asList(
          new Singer(1, "Marc", "Richards"),
          new Singer(2, "Catalina", "Smith"),
          new Singer(3, "Alice", "Trentor"),
          new Singer(4, "Lea", "Martin"),
          new Singer(5, "David", "Lomond"));

  static final List<Album> ALBUMS =
      Arrays.asList(
          new Album(1, 1, "Total Junk"),
          new Album(1, 2, "Go, Go, Go"),
          new Album(2, 1, "Green"),
          new Album(2, 2, "Forever Hold Your Peace"),
          new Album(2, 3, "Terrified"));
  // [END spanner_insert_data]

  // [START spanner_insert_data_with_timestamp_column]
  static final List<Performance> PERFORMANCES =
      Arrays.asList(
          new Performance(1, 4, "2017-10-05", 11000),
          new Performance(1, 19, "2017-11-02", 15000),
          new Performance(2, 42, "2017-12-23", 7000));
  // [END spanner_insert_data_with_timestamp_column]

  // [START spanner_insert_datatypes_data]
  static Value availableDates1 =
      Value.dateArray(
          Arrays.asList(
              Date.parseDate("2020-12-01"),
              Date.parseDate("2020-12-02"),
              Date.parseDate("2020-12-03")));
  static Value availableDates2 =
      Value.dateArray(
          Arrays.asList(
              Date.parseDate("2020-11-01"),
              Date.parseDate("2020-11-05"),
              Date.parseDate("2020-11-15")));
  static Value availableDates3 =
      Value.dateArray(Arrays.asList(Date.parseDate("2020-10-01"), Date.parseDate("2020-10-07")));
  static String exampleBytes1 = BaseEncoding.base64().encode("Hello World 1".getBytes());
  static String exampleBytes2 = BaseEncoding.base64().encode("Hello World 2".getBytes());
  static String exampleBytes3 = BaseEncoding.base64().encode("Hello World 3".getBytes());
  static final List<Venue> VENUES =
      Arrays.asList(
          new Venue(
              4,
              "Venue 4",
              exampleBytes1,
              1800,
              availableDates1,
              "2018-09-02",
              false,
              0.85543f,
              new BigDecimal("215100.10"),
              Value.json(
                  "[{\"name\":\"room 1\",\"open\":true},{\"name\":\"room 2\",\"open\":false}]")),
          new Venue(
              19,
              "Venue 19",
              exampleBytes2,
              6300,
              availableDates2,
              "2019-01-15",
              true,
              0.98716f,
              new BigDecimal("1200100.00"),
              Value.json("{\"rating\":9,\"open\":true}")),
          new Venue(
              42,
              "Venue 42",
              exampleBytes3,
              3000,
              availableDates3,
              "2018-10-01",
              false,
              0.72598f,
              new BigDecimal("390650.99"),
              Value.json(
                  "{\"name\":null,"
                      + "\"open\":{\"Monday\":true,\"Tuesday\":false},"
                      + "\"tags\":[\"large\",\"airy\"]}")));
  // [END spanner_insert_datatypes_data]

  // [START spanner_create_database]
  static void createDatabase(DatabaseAdminClient dbAdminClient,
      InstanceName instanceName, String databaseId) {
    CreateDatabaseRequest createDatabaseRequest =
        CreateDatabaseRequest.newBuilder()
            .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
            .setParent(instanceName.toString())
            .addAllExtraStatements(Arrays.asList(
                "CREATE TABLE Singers ("
                    + "  SingerId   INT64 NOT NULL,"
                    + "  FirstName  STRING(1024),"
                    + "  LastName   STRING(1024),"
                    + "  SingerInfo BYTES(MAX),"
                    + "  FullName STRING(2048) AS "
                    + "  (ARRAY_TO_STRING([FirstName, LastName], \" \")) STORED"
                    + ") PRIMARY KEY (SingerId)",
                "CREATE TABLE Albums ("
                    + "  SingerId     INT64 NOT NULL,"
                    + "  AlbumId      INT64 NOT NULL,"
                    + "  AlbumTitle   STRING(MAX)"
                    + ") PRIMARY KEY (SingerId, AlbumId),"
                    + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE")).build();
    try {
      // Initiate the request which returns an OperationFuture.
      com.google.spanner.admin.database.v1.Database db =
          dbAdminClient.createDatabaseAsync(createDatabaseRequest).get();
      System.out.println("Created database [" + db.getName() + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_create_database]

  // [START spanner_create_table_with_timestamp_column]
  static void createTableWithTimestamp(DatabaseAdminClient dbAdminClient,
      DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      dbAdminClient.updateDatabaseDdlAsync(
          databaseName,
          Arrays.asList(
              "CREATE TABLE Performances ("
                  + "  SingerId     INT64 NOT NULL,"
                  + "  VenueId      INT64 NOT NULL,"
                  + "  EventDate    Date,"
                  + "  Revenue      INT64, "
                  + "  LastUpdateTime TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true)"
                  + ") PRIMARY KEY (SingerId, VenueId, EventDate),"
                  + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE")).get();
      System.out.println(
          "Created Performances table in database: [" + databaseName.toString() + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_create_table_with_timestamp_column]

  // [START spanner_insert_data_with_timestamp_column]
  static void writeExampleDataWithTimestamp(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();
    for (Performance performance : PERFORMANCES) {
      mutations.add(
          Mutation.newInsertBuilder("Performances")
              .set("SingerId")
              .to(performance.singerId)
              .set("VenueId")
              .to(performance.venueId)
              .set("EventDate")
              .to(performance.eventDate)
              .set("Revenue")
              .to(performance.revenue)
              .set("LastUpdateTime")
              .to(Value.COMMIT_TIMESTAMP)
              .build());
    }
    dbClient.write(mutations);
  }
  // [END spanner_insert_data_with_timestamp_column]

  // [START spanner_insert_data]
  static void writeExampleData(DatabaseClient dbClient) {
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
    dbClient.write(mutations);
  }
  // [END spanner_insert_data]

  // [START spanner_delete_data]
  static void deleteExampleData(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();

    // KeySet.Builder can be used to delete a specific set of rows.
    // Delete the Albums with the key values (2,1) and (2,3).
    mutations.add(
        Mutation.delete(
            "Albums", KeySet.newBuilder().addKey(Key.of(2, 1)).addKey(Key.of(2, 3)).build()));

    // KeyRange can be used to delete rows with a key in a specific range.
    // Delete a range of rows where the column key is >=3 and <5
    mutations.add(
        Mutation.delete("Singers", KeySet.range(KeyRange.closedOpen(Key.of(3), Key.of(5)))));

    // KeySet.all() can be used to delete all the rows in a table.
    // Delete remaining Singers rows, which will also delete the remaining Albums rows since it was
    // defined with ON DELETE CASCADE.
    mutations.add(Mutation.delete("Singers", KeySet.all()));

    dbClient.write(mutations);
    System.out.printf("Records deleted.\n");
  }
  // [END spanner_delete_data]

  // [START spanner_query_data]
  static void query(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse() // Execute a single read or query against Cloud Spanner.
            .executeQuery(Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
      }
    }
  }
  // [END spanner_query_data]

  // [START spanner_read_data]
  static void read(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .read(
                "Albums",
                KeySet.all(), // Read all rows in a table.
                Arrays.asList("SingerId", "AlbumId", "AlbumTitle"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
      }
    }
  }
  // [END spanner_read_data]

  // [START spanner_add_column]
  static void addMarketingBudget(DatabaseAdminClient adminClient, DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      adminClient.updateDatabaseDdlAsync(
          databaseName,
          Arrays.asList("ALTER TABLE Albums ADD COLUMN MarketingBudget INT64")).get();
      System.out.println("Added MarketingBudget column");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_add_column]

  // Before executing this method, a new column MarketingBudget has to be added to the Albums
  // table by applying the DDL statement "ALTER TABLE Albums ADD COLUMN MarketingBudget INT64".
  // [START spanner_update_data]
  static void update(DatabaseClient dbClient) {
    // Mutation can be used to update/insert/delete a single row in a table. Here we use
    // newUpdateBuilder to create update mutations.
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newUpdateBuilder("Albums")
                .set("SingerId")
                .to(1)
                .set("AlbumId")
                .to(1)
                .set("MarketingBudget")
                .to(100000)
                .build(),
            Mutation.newUpdateBuilder("Albums")
                .set("SingerId")
                .to(2)
                .set("AlbumId")
                .to(2)
                .set("MarketingBudget")
                .to(500000)
                .build());
    // This writes all the mutations to Cloud Spanner atomically.
    dbClient.write(mutations);
  }
  // [END spanner_update_data]

  // [START spanner_read_write_transaction]
  static void writeWithTransaction(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          // Transfer marketing budget from one album to another. We do it in a transaction to
          // ensure that the transfer is atomic.
          Struct row =
              transaction.readRow("Albums", Key.of(2, 2), Arrays.asList("MarketingBudget"));
          long album2Budget = row.getLong(0);
          // Transaction will only be committed if this condition still holds at the time of
          // commit. Otherwise it will be aborted and the callable will be rerun by the
          // client library.
          long transfer = 200000;
          if (album2Budget >= transfer) {
            long album1Budget =
                transaction
                    .readRow("Albums", Key.of(1, 1), Arrays.asList("MarketingBudget"))
                    .getLong(0);
            album1Budget += transfer;
            album2Budget -= transfer;
            transaction.buffer(
                Mutation.newUpdateBuilder("Albums")
                    .set("SingerId")
                    .to(1)
                    .set("AlbumId")
                    .to(1)
                    .set("MarketingBudget")
                    .to(album1Budget)
                    .build());
            transaction.buffer(
                Mutation.newUpdateBuilder("Albums")
                    .set("SingerId")
                    .to(2)
                    .set("AlbumId")
                    .to(2)
                    .set("MarketingBudget")
                    .to(album2Budget)
                    .build());
          }
          return null;
        });
  }
  // [END spanner_read_write_transaction]

  // [START spanner_query_data_with_new_column]
  static void queryMarketingBudget(DatabaseClient dbClient) {
    // Rows without an explicit value for MarketingBudget will have a MarketingBudget equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(Statement.of("SELECT SingerId, AlbumId, MarketingBudget FROM Albums"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getLong("AlbumId"),
            // We check that the value is non null. ResultSet getters can only be used to retrieve
            // non null values.
            resultSet.isNull("MarketingBudget") ? "NULL" : resultSet.getLong("MarketingBudget"));
      }
    }
  }
  // [END spanner_query_data_with_new_column]

  // [START spanner_create_index]
  static void addIndex(DatabaseAdminClient adminClient, DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      adminClient.updateDatabaseDdlAsync(
          databaseName,
          Arrays.asList("CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle)")).get();
      System.out.println("Added AlbumsByAlbumTitle index");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_create_index]

  // Before running this example, add the index AlbumsByAlbumTitle by applying the DDL statement
  // "CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle)".
  // [START spanner_query_data_with_index]
  static void queryUsingIndex(DatabaseClient dbClient) {
    Statement statement =
        Statement
            // We use FORCE_INDEX hint to specify which index to use. For more details see
            // https://cloud.google.com/spanner/docs/query-syntax#from-clause
            .newBuilder(
                "SELECT AlbumId, AlbumTitle, MarketingBudget "
                    + "FROM Albums@{FORCE_INDEX=AlbumsByAlbumTitle} "
                    + "WHERE AlbumTitle >= @StartTitle AND AlbumTitle < @EndTitle")
            // We use @BoundParameters to help speed up frequently executed queries.
            //  For more details see https://cloud.google.com/spanner/docs/sql-best-practices
            .bind("StartTitle")
            .to("Aardvark")
            .bind("EndTitle")
            .to("Goo")
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong("AlbumId"),
            resultSet.getString("AlbumTitle"),
            resultSet.isNull("MarketingBudget") ? "NULL" : resultSet.getLong("MarketingBudget"));
      }
    }
  }
  // [END spanner_query_data_with_index]

  // [START spanner_read_data_with_index]
  static void readUsingIndex(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .readUsingIndex(
                "Albums",
                "AlbumsByAlbumTitle",
                KeySet.all(),
                Arrays.asList("AlbumId", "AlbumTitle"))) {
      while (resultSet.next()) {
        System.out.printf("%d %s\n", resultSet.getLong(0), resultSet.getString(1));
      }
    }
  }
  // [END spanner_read_data_with_index]

  // [START spanner_create_storing_index]
  static void addStoringIndex(DatabaseAdminClient adminClient, DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      adminClient.updateDatabaseDdlAsync(
          databaseName,
          Arrays.asList(
              "CREATE INDEX AlbumsByAlbumTitle2 ON Albums(AlbumTitle) "
                  + "STORING (MarketingBudget)")).get();
      System.out.println("Added AlbumsByAlbumTitle2 index");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_create_storing_index]

  // Before running this example, create a storing index AlbumsByAlbumTitle2 by applying the DDL
  // statement "CREATE INDEX AlbumsByAlbumTitle2 ON Albums(AlbumTitle) STORING (MarketingBudget)".
  // [START spanner_read_data_with_storing_index]
  static void readStoringIndex(DatabaseClient dbClient) {
    // We can read MarketingBudget also from the index since it stores a copy of MarketingBudget.
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .readUsingIndex(
                "Albums",
                "AlbumsByAlbumTitle2",
                KeySet.all(),
                Arrays.asList("AlbumId", "AlbumTitle", "MarketingBudget"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong(0),
            resultSet.getString(1),
            resultSet.isNull("MarketingBudget") ? "NULL" : resultSet.getLong("MarketingBudget"));
      }
    }
  }
  // [END spanner_read_data_with_storing_index]

  // [START spanner_read_only_transaction]
  static void readOnlyTransaction(DatabaseClient dbClient) {
    // ReadOnlyTransaction must be closed by calling close() on it to release resources held by it.
    // We use a try-with-resource block to automatically do so.
    try (ReadOnlyTransaction transaction = dbClient.readOnlyTransaction()) {
      try (ResultSet queryResultSet =
          transaction.executeQuery(
              Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
        while (queryResultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              queryResultSet.getLong(0), queryResultSet.getLong(1), queryResultSet.getString(2));
        }
      } // queryResultSet.close() is automatically called here
      try (ResultSet readResultSet =
          transaction.read(
            "Albums", KeySet.all(), Arrays.asList("SingerId", "AlbumId", "AlbumTitle"))) {
        while (readResultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              readResultSet.getLong(0), readResultSet.getLong(1), readResultSet.getString(2));
        }
      } // readResultSet.close() is automatically called here
    } // transaction.close() is automatically called here
  }
  // [END spanner_read_only_transaction]

  // [START spanner_read_stale_data]
  static void readStaleData(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse(TimestampBound.ofExactStaleness(15, TimeUnit.SECONDS))
            .read(
                "Albums", KeySet.all(), Arrays.asList("SingerId", "AlbumId", "MarketingBudget"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n",
            resultSet.getLong(0),
            resultSet.getLong(1),
            resultSet.isNull(2) ? "NULL" : resultSet.getLong("MarketingBudget"));
      }
    }
  }
  // [END spanner_read_stale_data]

  // [START spanner_add_timestamp_column]
  static void addCommitTimestamp(DatabaseAdminClient adminClient, DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      adminClient.updateDatabaseDdlAsync(
          databaseName,
          Arrays.asList(
              "ALTER TABLE Albums ADD COLUMN LastUpdateTime TIMESTAMP "
                  + "OPTIONS (allow_commit_timestamp=true)")).get();
      System.out.println("Added LastUpdateTime as a commit timestamp column in Albums table.");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_add_timestamp_column]

  // Before executing this method, a new column MarketingBudget has to be added to the Albums
  // table by applying the DDL statement "ALTER TABLE Albums ADD COLUMN MarketingBudget INT64".
  // In addition this update expects the LastUpdateTime column added by applying the DDL statement
  // "ALTER TABLE Albums ADD COLUMN LastUpdateTime TIMESTAMP OPTIONS (allow_commit_timestamp=true)"
  // [START spanner_update_data_with_timestamp_column]
  static void updateWithTimestamp(DatabaseClient dbClient) {
    // Mutation can be used to update/insert/delete a single row in a table. Here we use
    // newUpdateBuilder to create update mutations.
    List<Mutation> mutations =
        Arrays.asList(
            Mutation.newUpdateBuilder("Albums")
                .set("SingerId")
                .to(1)
                .set("AlbumId")
                .to(1)
                .set("MarketingBudget")
                .to(1000000)
                .set("LastUpdateTime")
                .to(Value.COMMIT_TIMESTAMP)
                .build(),
            Mutation.newUpdateBuilder("Albums")
                .set("SingerId")
                .to(2)
                .set("AlbumId")
                .to(2)
                .set("MarketingBudget")
                .to(750000)
                .set("LastUpdateTime")
                .to(Value.COMMIT_TIMESTAMP)
                .build());
    // This writes all the mutations to Cloud Spanner atomically.
    dbClient.write(mutations);
  }
  // [END spanner_update_data_with_timestamp_column]

  // [START spanner_query_data_with_timestamp_column]
  static void queryMarketingBudgetWithTimestamp(DatabaseClient dbClient) {
    // Rows without an explicit value for MarketingBudget will have a MarketingBudget equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT SingerId, AlbumId, MarketingBudget, LastUpdateTime FROM Albums"
                        + " ORDER BY LastUpdateTime DESC"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getLong("AlbumId"),
            // We check that the value is non null. ResultSet getters can only be used to retrieve
            // non null values.
            resultSet.isNull("MarketingBudget") ? "NULL" : resultSet.getLong("MarketingBudget"),
            resultSet.isNull("LastUpdateTime") ? "NULL" : resultSet.getTimestamp("LastUpdateTime"));
      }
    }
  }
  // [END spanner_query_data_with_timestamp_column]

  static void querySingersTable(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(Statement.of("SELECT SingerId, FirstName, LastName FROM Singers"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%s %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getString("FirstName"),
            resultSet.getString("LastName"));
      }
    }
  }

  static void queryPerformancesTable(DatabaseClient dbClient) {
    // Rows without an explicit value for Revenue will have a Revenue equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(
                Statement.of(
                    "SELECT SingerId, VenueId, EventDate, Revenue, LastUpdateTime "
                        + "FROM Performances ORDER BY LastUpdateTime DESC"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getLong("VenueId"),
            resultSet.getDate("EventDate"),
            // We check that the value is non null. ResultSet getters can only be used to retrieve
            // non null values.
            resultSet.isNull("Revenue") ? "NULL" : resultSet.getLong("Revenue"),
            resultSet.getTimestamp("LastUpdateTime"));
      }
    }
  }

  // [START spanner_write_data_for_struct_queries]
  static void writeStructExampleData(DatabaseClient dbClient) {
    final List<Singer> singers =
        Arrays.asList(
            new Singer(6, "Elena", "Campbell"),
            new Singer(7, "Gabriel", "Wright"),
            new Singer(8, "Benjamin", "Martinez"),
            new Singer(9, "Hannah", "Harris"));

    List<Mutation> mutations = new ArrayList<>();
    for (Singer singer : singers) {
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
    dbClient.write(mutations);
    System.out.println("Inserted example data for struct parameter queries.");
  }
  // [END spanner_write_data_for_struct_queries]

  static void queryWithStruct(DatabaseClient dbClient) {
    // [START spanner_create_struct_with_data]
    Struct name =
        Struct.newBuilder().set("FirstName").to("Elena").set("LastName").to("Campbell").build();
    // [END spanner_create_struct_with_data]

    // [START spanner_query_data_with_struct]
    Statement s =
        Statement.newBuilder(
                "SELECT SingerId FROM Singers "
                    + "WHERE STRUCT<FirstName STRING, LastName STRING>(FirstName, LastName) "
                    + "= @name")
            .bind("name")
            .to(name)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(s)) {
      while (resultSet.next()) {
        System.out.printf("%d\n", resultSet.getLong("SingerId"));
      }
    }
    // [END spanner_query_data_with_struct]
  }

  static void queryWithArrayOfStruct(DatabaseClient dbClient) {
    // [START spanner_create_user_defined_struct]
    Type nameType =
        Type.struct(
            Arrays.asList(
                StructField.of("FirstName", Type.string()),
                StructField.of("LastName", Type.string())));
    // [END spanner_create_user_defined_struct]

    // [START spanner_create_array_of_struct_with_data]
    List<Struct> bandMembers = new ArrayList<>();
    bandMembers.add(
        Struct.newBuilder().set("FirstName").to("Elena").set("LastName").to("Campbell").build());
    bandMembers.add(
        Struct.newBuilder().set("FirstName").to("Gabriel").set("LastName").to("Wright").build());
    bandMembers.add(
        Struct.newBuilder().set("FirstName").to("Benjamin").set("LastName").to("Martinez").build());
    // [END spanner_create_array_of_struct_with_data]

    // [START spanner_query_data_with_array_of_struct]
    Statement s =
        Statement.newBuilder(
                "SELECT SingerId FROM Singers WHERE "
                    + "STRUCT<FirstName STRING, LastName STRING>(FirstName, LastName) "
                    + "IN UNNEST(@names) "
                    + "ORDER BY SingerId DESC")
            .bind("names")
            .toStructArray(nameType, bandMembers)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(s)) {
      while (resultSet.next()) {
        System.out.printf("%d\n", resultSet.getLong("SingerId"));
      }
    }
    // [END spanner_query_data_with_array_of_struct]
  }

  // [START spanner_field_access_on_struct_parameters]
  static void queryStructField(DatabaseClient dbClient) {
    Statement s =
        Statement.newBuilder("SELECT SingerId FROM Singers WHERE FirstName = @name.FirstName")
            .bind("name")
            .to(
                Struct.newBuilder()
                    .set("FirstName")
                    .to("Elena")
                    .set("LastName")
                    .to("Campbell")
                    .build())
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(s)) {
      while (resultSet.next()) {
        System.out.printf("%d\n", resultSet.getLong("SingerId"));
      }
    }
  }
  // [END spanner_field_access_on_struct_parameters]

  // [START spanner_field_access_on_nested_struct_parameters]
  static void queryNestedStructField(DatabaseClient dbClient) {
    Type nameType =
        Type.struct(
            Arrays.asList(
                StructField.of("FirstName", Type.string()),
                StructField.of("LastName", Type.string())));

    Struct songInfo =
        Struct.newBuilder()
            .set("song_name")
            .to("Imagination")
            .set("artistNames")
            .toStructArray(
                nameType,
                Arrays.asList(
                    Struct.newBuilder()
                        .set("FirstName")
                        .to("Elena")
                        .set("LastName")
                        .to("Campbell")
                        .build(),
                    Struct.newBuilder()
                        .set("FirstName")
                        .to("Hannah")
                        .set("LastName")
                        .to("Harris")
                        .build()))
            .build();
    Statement s =
        Statement.newBuilder(
                "SELECT SingerId, @song_info.song_name "
                    + "FROM Singers WHERE "
                    + "STRUCT<FirstName STRING, LastName STRING>(FirstName, LastName) "
                    + "IN UNNEST(@song_info.artistNames)")
            .bind("song_info")
            .to(songInfo)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(s)) {
      while (resultSet.next()) {
        System.out.printf("%d %s\n", resultSet.getLong("SingerId"), resultSet.getString(1));
      }
    }
  }
  // [END spanner_field_access_on_nested_struct_parameters]

  // [START spanner_dml_standard_insert]
  static void insertUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          String sql =
              "INSERT INTO Singers (SingerId, FirstName, LastName) "
                  + " VALUES (10, 'Virginia', 'Watson')";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d record inserted.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_standard_insert]

  // [START spanner_dml_standard_update]
  static void updateUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          String sql =
              "UPDATE Albums "
                  + "SET MarketingBudget = MarketingBudget * 2 "
                  + "WHERE SingerId = 1 and AlbumId = 1";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d record updated.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_standard_update]

  // [START spanner_dml_standard_delete]
  static void deleteUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          String sql = "DELETE FROM Singers WHERE FirstName = 'Alice'";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d record deleted.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_standard_delete]

  // [START spanner_dml_standard_update_with_timestamp]
  static void updateUsingDmlWithTimestamp(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          String sql =
              "UPDATE Albums "
                  + "SET LastUpdateTime = PENDING_COMMIT_TIMESTAMP() WHERE SingerId = 1";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d records updated.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_standard_update_with_timestamp]

  // [START spanner_dml_write_then_read]
  static void writeAndReadUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          // Insert record.
          String sql =
              "INSERT INTO Singers (SingerId, FirstName, LastName) "
                  + " VALUES (11, 'Timothy', 'Campbell')";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d record inserted.\n", rowCount);
          // Read newly inserted record.
          sql = "SELECT FirstName, LastName FROM Singers WHERE SingerId = 11";
          // We use a try-with-resource block to automatically release resources held by
          // ResultSet.
          try (ResultSet resultSet = transaction.executeQuery(Statement.of(sql))) {
            while (resultSet.next()) {
              System.out.printf(
                  "%s %s\n",
                  resultSet.getString("FirstName"), resultSet.getString("LastName"));
            }
          }
          return null;
        });
  }
  // [END spanner_dml_write_then_read]

  // [START spanner_dml_structs]
  static void updateUsingDmlWithStruct(DatabaseClient dbClient) {
    Struct name =
        Struct.newBuilder().set("FirstName").to("Timothy").set("LastName").to("Campbell").build();
    Statement s =
        Statement.newBuilder(
                "UPDATE Singers SET LastName = 'Grant' "
                    + "WHERE STRUCT<FirstName STRING, LastName STRING>(FirstName, LastName) "
                    + "= @name")
            .bind("name")
            .to(name)
            .build();
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          long rowCount = transaction.executeUpdate(s);
          System.out.printf("%d record updated.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_structs]

  // [START spanner_dml_getting_started_insert]
  static void writeUsingDml(DatabaseClient dbClient) {
    // Insert 4 singer records
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          String sql =
              "INSERT INTO Singers (SingerId, FirstName, LastName) VALUES "
                  + "(12, 'Melissa', 'Garcia'), "
                  + "(13, 'Russell', 'Morales'), "
                  + "(14, 'Jacqueline', 'Long'), "
                  + "(15, 'Dylan', 'Shaw')";
          long rowCount = transaction.executeUpdate(Statement.of(sql));
          System.out.printf("%d records inserted.\n", rowCount);
          return null;
        });
  }
  // [END spanner_dml_getting_started_insert]

  // [START spanner_query_with_parameter]
  static void queryWithParameter(DatabaseClient dbClient) {
    Statement statement =
        Statement.newBuilder(
                "SELECT SingerId, FirstName, LastName "
                    + "FROM Singers "
                    + "WHERE LastName = @lastName")
            .bind("lastName")
            .to("Garcia")
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getString("FirstName"),
            resultSet.getString("LastName"));
      }
    }
  }
  // [END spanner_query_with_parameter]

  // [START spanner_dml_getting_started_update]
  static void writeWithTransactionUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          // Transfer marketing budget from one album to another. We do it in a transaction to
          // ensure that the transfer is atomic.
          String sql1 =
              "SELECT MarketingBudget from Albums WHERE SingerId = 2 and AlbumId = 2";
          ResultSet resultSet = transaction.executeQuery(Statement.of(sql1));
          long album2Budget = 0;
          while (resultSet.next()) {
            album2Budget = resultSet.getLong("MarketingBudget");
          }
          // Transaction will only be committed if this condition still holds at the time of
          // commit. Otherwise it will be aborted and the callable will be rerun by the
          // client library.
          long transfer = 200000;
          if (album2Budget >= transfer) {
            String sql2 =
                "SELECT MarketingBudget from Albums WHERE SingerId = 1 and AlbumId = 1";
            ResultSet resultSet2 = transaction.executeQuery(Statement.of(sql2));
            long album1Budget = 0;
            while (resultSet2.next()) {
              album1Budget = resultSet2.getLong("MarketingBudget");
            }
            album1Budget += transfer;
            album2Budget -= transfer;
            Statement updateStatement =
                Statement.newBuilder(
                        "UPDATE Albums "
                            + "SET MarketingBudget = @AlbumBudget "
                            + "WHERE SingerId = 1 and AlbumId = 1")
                    .bind("AlbumBudget")
                    .to(album1Budget)
                    .build();
            transaction.executeUpdate(updateStatement);
            Statement updateStatement2 =
                Statement.newBuilder(
                        "UPDATE Albums "
                            + "SET MarketingBudget = @AlbumBudget "
                            + "WHERE SingerId = 2 and AlbumId = 2")
                    .bind("AlbumBudget")
                    .to(album2Budget)
                    .build();
            transaction.executeUpdate(updateStatement2);
          }
          return null;
        });
  }
  // [END spanner_dml_getting_started_update]

  // [START spanner_dml_partitioned_update]
  static void updateUsingPartitionedDml(DatabaseClient dbClient) {
    String sql = "UPDATE Albums SET MarketingBudget = 100000 WHERE SingerId > 1";
    long rowCount = dbClient.executePartitionedUpdate(Statement.of(sql));
    System.out.printf("%d records updated.\n", rowCount);
  }
  // [END spanner_dml_partitioned_update]

  // [START spanner_dml_partitioned_delete]
  static void deleteUsingPartitionedDml(DatabaseClient dbClient) {
    String sql = "DELETE FROM Singers WHERE SingerId > 10";
    long rowCount = dbClient.executePartitionedUpdate(Statement.of(sql));
    System.out.printf("%d records deleted.\n", rowCount);
  }
  // [END spanner_dml_partitioned_delete]

  // [START spanner_dml_batch_update]
  static void updateUsingBatchDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          List<Statement> stmts = new ArrayList<Statement>();
          String sql =
              "INSERT INTO Albums "
                  + "(SingerId, AlbumId, AlbumTitle, MarketingBudget) "
                  + "VALUES (1, 3, 'Test Album Title', 10000) ";
          stmts.add(Statement.of(sql));
          sql =
              "UPDATE Albums "
                  + "SET MarketingBudget = MarketingBudget * 2 "
                  + "WHERE SingerId = 1 and AlbumId = 3";
          stmts.add(Statement.of(sql));
          long[] rowCounts;
          try {
            rowCounts = transaction.batchUpdate(stmts);
          } catch (SpannerBatchUpdateException e) {
            rowCounts = e.getUpdateCounts();
          }
          for (int i = 0; i < rowCounts.length; i++) {
            System.out.printf("%d record updated by stmt %d.\n", rowCounts[i], i);
          }
          return null;
        });
  }
  // [END spanner_dml_batch_update]

  // [START spanner_create_table_with_datatypes]
  static void createTableWithDatatypes(DatabaseAdminClient dbAdminClient,
      DatabaseName databaseName) {
    try {
      // Initiate the request which returns an OperationFuture.
      dbAdminClient.updateDatabaseDdlAsync(databaseName,
          Arrays.asList(
              "CREATE TABLE Venues ("
                  + "  VenueId         INT64 NOT NULL,"
                  + "  VenueName       STRING(100),"
                  + "  VenueInfo       BYTES(MAX),"
                  + "  Capacity        INT64,"
                  + "  AvailableDates  ARRAY<DATE>,"
                  + "  LastContactDate DATE,"
                  + "  OutdoorVenue    BOOL, "
                  + "  PopularityScore FLOAT64, "
                  + "  Revenue         NUMERIC, "
                  + "  VenueDetails    JSON, "
                  + "  LastUpdateTime  TIMESTAMP NOT NULL OPTIONS (allow_commit_timestamp=true)"
                  + ") PRIMARY KEY (VenueId)")).get();
      System.out.println("Created Venues table in database: [" + databaseName.toString() + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_create_table_with_datatypes]

  // [START spanner_insert_datatypes_data]
  static void writeDatatypesData(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();
    for (Venue venue : VENUES) {
      mutations.add(
          Mutation.newInsertBuilder("Venues")
              .set("VenueId")
              .to(venue.venueId)
              .set("VenueName")
              .to(venue.venueName)
              .set("VenueInfo")
              .to(venue.venueInfo)
              .set("Capacity")
              .to(venue.capacity)
              .set("AvailableDates")
              .to(venue.availableDates)
              .set("LastContactDate")
              .to(venue.lastContactDate)
              .set("OutdoorVenue")
              .to(venue.outdoorVenue)
              .set("PopularityScore")
              .to(venue.popularityScore)
              .set("Revenue")
              .to(venue.revenue)
              .set("VenueDetails")
              .to(venue.venueDetails)
              .set("LastUpdateTime")
              .to(Value.COMMIT_TIMESTAMP)
              .build());
    }
    dbClient.write(mutations);
  }
  // [END spanner_insert_datatypes_data]

  // [START spanner_query_with_array_parameter]
  static void queryWithArray(DatabaseClient dbClient) {
    Value exampleArray =
        Value.dateArray(Arrays.asList(Date.parseDate("2020-10-01"), Date.parseDate("2020-11-01")));

    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, AvailableDate FROM Venues v, "
                    + "UNNEST(v.AvailableDates) as AvailableDate "
                    + "WHERE AvailableDate in UNNEST(@availableDates)")
            .bind("availableDates")
            .to(exampleArray)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getDate("AvailableDate"));
      }
    }
  }
  // [END spanner_query_with_array_parameter]

  // [START spanner_query_with_bool_parameter]
  static void queryWithBool(DatabaseClient dbClient) {
    boolean exampleBool = true;
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, OutdoorVenue FROM Venues "
                    + "WHERE OutdoorVenue = @outdoorVenue")
            .bind("outdoorVenue")
            .to(exampleBool)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %b\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getBoolean("OutdoorVenue"));
      }
    }
  }
  // [END spanner_query_with_bool_parameter]

  // [START spanner_query_with_bytes_parameter]
  static void queryWithBytes(DatabaseClient dbClient) {
    ByteArray exampleBytes =
        ByteArray.fromBase64(BaseEncoding.base64().encode("Hello World 1".getBytes()));
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName FROM Venues " + "WHERE VenueInfo = @venueInfo")
            .bind("venueInfo")
            .to(exampleBytes)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s\n", resultSet.getLong("VenueId"), resultSet.getString("VenueName"));
      }
    }
  }
  // [END spanner_query_with_bytes_parameter]

  // [START spanner_query_with_date_parameter]
  static void queryWithDate(DatabaseClient dbClient) {
    String exampleDate = "2019-01-01";
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, LastContactDate FROM Venues "
                    + "WHERE LastContactDate < @lastContactDate")
            .bind("lastContactDate")
            .to(exampleDate)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getDate("LastContactDate"));
      }
    }
  }
  // [END spanner_query_with_date_parameter]

  // [START spanner_query_with_float_parameter]
  static void queryWithFloat(DatabaseClient dbClient) {
    float exampleFloat = 0.8f;
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, PopularityScore FROM Venues "
                    + "WHERE PopularityScore > @popularityScore")
            .bind("popularityScore")
            .to(exampleFloat)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %f\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getDouble("PopularityScore"));
      }
    }
  }
  // [END spanner_query_with_float_parameter]

  // [START spanner_query_with_int_parameter]
  static void queryWithInt(DatabaseClient dbClient) {
    long exampleInt = 3000;
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, Capacity FROM Venues " + "WHERE Capacity >= @capacity")
            .bind("capacity")
            .to(exampleInt)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %d\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getLong("Capacity"));
      }
    }
  }
  // [END spanner_query_with_int_parameter]

  // [START spanner_query_with_string_parameter]
  static void queryWithString(DatabaseClient dbClient) {
    String exampleString = "Venue 42";
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName FROM Venues " + "WHERE VenueName = @venueName")
            .bind("venueName")
            .to(exampleString)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s\n", resultSet.getLong("VenueId"), resultSet.getString("VenueName"));
      }
    }
  }
  // [END spanner_query_with_string_parameter]

  // [START spanner_query_with_timestamp_parameter]
  static void queryWithTimestampParameter(DatabaseClient dbClient) {
    Instant exampleTimestamp = Instant.now();
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, LastUpdateTime FROM Venues "
                    + "WHERE LastUpdateTime < @lastUpdateTime")
            .bind("lastUpdateTime")
            .to(exampleTimestamp.toString())
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s\n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getTimestamp("LastUpdateTime"));
      }
    }
  }
  // [END spanner_query_with_timestamp_parameter]

  // [START spanner_query_with_numeric_parameter]
  static void queryWithNumeric(DatabaseClient dbClient) {
    BigDecimal exampleNumeric = new BigDecimal("300000");
    Statement statement =
        Statement.newBuilder(
                "SELECT VenueId, VenueName, Revenue\n"
                    + "FROM Venues\n"
                    + "WHERE Revenue >= @revenue")
            .bind("revenue")
            .to(exampleNumeric)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s%n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getBigDecimal("Revenue"));
      }
    }
  }
  // [END spanner_query_with_numeric_parameter]

  // [START spanner_create_client_with_query_options]
  static void clientWithQueryOptions(DatabaseId db) {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setDefaultQueryOptions(
                db, QueryOptions
                    .newBuilder()
                    .setOptimizerVersion("1")
                    // The list of available statistics packages can be found by querying the
                    // "INFORMATION_SCHEMA.SPANNER_STATISTICS" table.
                    .setOptimizerStatisticsPackage("latest")
                    .build())
            .build();
    Spanner spanner = options.getService();
    DatabaseClient dbClient = spanner.getDatabaseClient(db);
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
      }
    }
  }
  // [END spanner_create_client_with_query_options]

  // [START spanner_query_with_query_options]
  static void queryWithQueryOptions(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse()
            .executeQuery(
                Statement
                    .newBuilder("SELECT SingerId, AlbumId, AlbumTitle FROM Albums")
                    .withQueryOptions(QueryOptions
                        .newBuilder()
                        .setOptimizerVersion("1")
                        // The list of available statistics packages can be found by querying the
                        // "INFORMATION_SCHEMA.SPANNER_STATISTICS" table.
                        .setOptimizerStatisticsPackage("latest")
                        .build())
                    .build())) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
      }
    }
  }
  // [END spanner_query_with_query_options]

  // [START spanner_create_backup]
  static void createBackup(DatabaseAdminClient dbAdminClient, String projectId, String instanceId,
      String databaseId, String backupId, Timestamp versionTime) {
    // Set expire time to 14 days from now.
    Timestamp expireTime =
        Timestamp.newBuilder().setSeconds(TimeUnit.MILLISECONDS.toSeconds((
            System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14)))).build();
    BackupName backupName = BackupName.of(projectId, instanceId, backupId);
    Backup backup = Backup.newBuilder()
        .setName(backupName.toString())
        .setDatabase(DatabaseName.of(projectId, instanceId, databaseId).toString())
        .setExpireTime(expireTime).setVersionTime(versionTime).build();

    // Initiate the request which returns an OperationFuture.
    System.out.println("Creating backup [" + backupId + "]...");
    try {
      // Wait for the backup operation to complete.
      backup = dbAdminClient.createBackupAsync(
          InstanceName.of(projectId, instanceId), backup, backupId).get();
      System.out.println("Created backup [" + backup.getName() + "]");
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.asSpannerException(e);
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }

    // Reload the metadata of the backup from the server.
    backup = dbAdminClient.getBackup(backup.getName());
    System.out.println(
        String.format(
            "Backup %s of size %d bytes was created at %s for version of database at %s",
            backup.getName(),
            backup.getSizeBytes(),
            java.time.OffsetDateTime.ofInstant(
                Instant.ofEpochSecond(backup.getCreateTime().getSeconds(),
                    backup.getCreateTime().getNanos()), ZoneId.systemDefault()),
            java.time.OffsetDateTime.ofInstant(
                Instant.ofEpochSecond(backup.getVersionTime().getSeconds(),
                    backup.getVersionTime().getNanos()), ZoneId.systemDefault()))
    );
  }
  // [END spanner_create_backup]

  // [START spanner_cancel_backup_create]
  static void cancelCreateBackup(
      DatabaseAdminClient dbAdminClient, String projectId, String instanceId,
      String databaseId, String backupId) {
    // Set expire time to 14 days from now.
    Timestamp expireTime =
        Timestamp.newBuilder().setSeconds(TimeUnit.MILLISECONDS.toSeconds((
            System.currentTimeMillis() + TimeUnit.DAYS.toMillis(14)))).build();
    BackupName backupName = BackupName.of(projectId, instanceId, backupId);
    Backup backup = Backup.newBuilder()
        .setName(backupName.toString())
        .setDatabase(DatabaseName.of(projectId, instanceId, databaseId).toString())
        .setExpireTime(expireTime).build();

    try {
      // Start the creation of a backup.
      System.out.println("Creating backup [" + backupId + "]...");
      OperationFuture<Backup, CreateBackupMetadata> op = dbAdminClient.createBackupAsync(
          InstanceName.of(projectId, instanceId), backup, backupId);

      // Try to cancel the backup operation.
      System.out.println("Cancelling create backup operation for [" + backupId + "]...");
      dbAdminClient.getOperationsClient().cancelOperation(op.getName());

      // Get a polling future for the running operation. This future will regularly poll the server
      // for the current status of the backup operation.
      RetryingFuture<OperationSnapshot> pollingFuture = op.getPollingFuture();

      // Wait for the operation to finish.
      // isDone will return true when the operation is complete, regardless of whether it was
      // successful or not.
      while (!pollingFuture.get().isDone()) {
        System.out.println("Waiting for the cancelled backup operation to finish...");
        Thread.sleep(TimeUnit.MILLISECONDS.convert(5, TimeUnit.SECONDS));
      }
      if (pollingFuture.get().getErrorCode() == null) {
        // Backup was created before it could be cancelled. Delete the backup.
        dbAdminClient.deleteBackup(backupName);
        System.out.println("Backup operation for [" + backupId
            + "] successfully finished before it could be cancelled");
      } else if (pollingFuture.get().getErrorCode().getCode() == StatusCode.Code.CANCELLED) {
        System.out.println("Backup operation for [" + backupId + "] successfully cancelled");
      }
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e.getCause());
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_cancel_backup_create]

  // [START spanner_list_backup_operations]
  static void listBackupOperations(
      DatabaseAdminClient databaseAdminClient,
      String projectId, String instanceId,
      String databaseId, String backupId) {
    InstanceName instanceName = InstanceName.of(projectId, instanceId);
    // Get 'CreateBackup' operations for the sample database.
    String filter =
        String.format(
            "(metadata.@type:type.googleapis.com/"
                + "google.spanner.admin.database.v1.CreateBackupMetadata) "
                + "AND (metadata.database:%s)",
            DatabaseName.of(projectId, instanceId, databaseId).toString());
    ListBackupOperationsRequest listBackupOperationsRequest =
        ListBackupOperationsRequest.newBuilder()
            .setParent(instanceName.toString()).setFilter(filter).build();
    ListBackupOperationsPagedResponse createBackupOperations
        = databaseAdminClient.listBackupOperations(listBackupOperationsRequest);
    System.out.println("Create Backup Operations:");
    for (Operation op : createBackupOperations.iterateAll()) {
      try {
        CreateBackupMetadata metadata = op.getMetadata().unpack(CreateBackupMetadata.class);
        System.out.println(
            String.format(
                "Backup %s on database %s pending: %d%% complete",
                metadata.getName(),
                metadata.getDatabase(),
                metadata.getProgress().getProgressPercent()));
      } catch (InvalidProtocolBufferException e) {
        // The returned operation does not contain CreateBackupMetadata.
        System.err.println(e.getMessage());
      }
    }
    // Get copy backup operations for the sample database.
    filter = String.format(
        "(metadata.@type:type.googleapis.com/"
            + "google.spanner.admin.database.v1.CopyBackupMetadata) "
            + "AND (metadata.source_backup:%s)",
        BackupName.of(projectId, instanceId, backupId).toString());
    listBackupOperationsRequest =
        ListBackupOperationsRequest.newBuilder()
            .setParent(instanceName.toString()).setFilter(filter).build();
    ListBackupOperationsPagedResponse copyBackupOperations =
        databaseAdminClient.listBackupOperations(listBackupOperationsRequest);
    System.out.println("Copy Backup Operations:");
    for (Operation op : copyBackupOperations.iterateAll()) {
      try {
        CopyBackupMetadata copyBackupMetadata =
            op.getMetadata().unpack(CopyBackupMetadata.class);
        System.out.println(
            String.format(
                "Copy Backup %s on backup %s pending: %d%% complete",
                copyBackupMetadata.getName(),
                copyBackupMetadata.getSourceBackup(),
                copyBackupMetadata.getProgress().getProgressPercent()));
      } catch (InvalidProtocolBufferException e) {
        // The returned operation does not contain CopyBackupMetadata.
        System.err.println(e.getMessage());
      }
    }
  }
  // [END spanner_list_backup_operations]

  // [START spanner_list_database_operations]
  static void listDatabaseOperations(
      DatabaseAdminClient dbAdminClient, String projectId, String instanceId) {
    // Get optimize restored database operations.
    com.google.cloud.Timestamp last24Hours = com.google.cloud.Timestamp.ofTimeSecondsAndNanos(
        TimeUnit.SECONDS.convert(
            TimeUnit.HOURS.convert(com.google.cloud.Timestamp.now().getSeconds(), TimeUnit.SECONDS)
                - 24,
            TimeUnit.HOURS), 0);
    String filter = String.format("(metadata.@type:type.googleapis.com/"
        + "google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata) AND "
        + "(metadata.progress.start_time > \"%s\")", last24Hours);
    ListDatabaseOperationsRequest listDatabaseOperationsRequest =
        ListDatabaseOperationsRequest.newBuilder()
            .setParent(com.google.spanner.admin.instance.v1.InstanceName.of(
                projectId, instanceId).toString()).setFilter(filter).build();
    ListDatabaseOperationsPagedResponse pagedResponse
        = dbAdminClient.listDatabaseOperations(listDatabaseOperationsRequest);
    for (Operation op : pagedResponse.iterateAll()) {
      try {
        OptimizeRestoredDatabaseMetadata metadata =
            op.getMetadata().unpack(OptimizeRestoredDatabaseMetadata.class);
        System.out.println(String.format(
            "Database %s restored from backup is %d%% optimized",
            metadata.getName(),
            metadata.getProgress().getProgressPercent()));
      } catch (InvalidProtocolBufferException e) {
        // The returned operation does not contain OptimizeRestoredDatabaseMetadata.
        System.err.println(e.getMessage());
      }
    }
  }
  // [END spanner_list_database_operations]

  // [START spanner_list_backups]
  static void listBackups(
      DatabaseAdminClient dbAdminClient, String projectId,
      String instanceId, String databaseId, String backupId) {
    InstanceName instanceName = InstanceName.of(projectId, instanceId);
    // List all backups.
    System.out.println("All backups:");
    for (Backup backup : dbAdminClient.listBackups(
        instanceName.toString()).iterateAll()) {
      System.out.println(backup);
    }

    // List all backups with a specific name.
    System.out.println(
        String.format("All backups with backup name containing \"%s\":", backupId));
    ListBackupsRequest listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString())
            .setFilter(String.format("name:%s", backupId)).build();
    for (Backup backup : dbAdminClient.listBackups(listBackupsRequest).iterateAll()) {
      System.out.println(backup);
    }

    // List all backups for databases whose name contains a certain text.
    System.out.println(
        String.format(
            "All backups for databases with a name containing \"%s\":", databaseId));
    listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString())
            .setFilter(String.format("database:%s", databaseId)).build();
    for (Backup backup : dbAdminClient.listBackups(listBackupsRequest).iterateAll()) {
      System.out.println(backup);
    }

    // List all backups that expire before a certain time.
    com.google.cloud.Timestamp expireTime = com.google.cloud.Timestamp.ofTimeMicroseconds(
        TimeUnit.MICROSECONDS.convert(
            System.currentTimeMillis() + TimeUnit.DAYS.toMillis(30), TimeUnit.MILLISECONDS));

    System.out.println(String.format("All backups that expire before %s:", expireTime));
    listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString())
            .setFilter(String.format("expire_time < \"%s\"", expireTime)).build();

    for (Backup backup : dbAdminClient.listBackups(listBackupsRequest).iterateAll()) {
      System.out.println(backup);
    }

    // List all backups with size greater than a certain number of bytes.
    listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString())
            .setFilter("size_bytes > 100").build();

    System.out.println("All backups with size greater than 100 bytes:");
    for (Backup backup : dbAdminClient.listBackups(listBackupsRequest).iterateAll()) {
      System.out.println(backup);
    }

    // List all backups with a create time after a certain timestamp and that are also ready.
    com.google.cloud.Timestamp createTime = com.google.cloud.Timestamp.ofTimeMicroseconds(
        TimeUnit.MICROSECONDS.convert(
            System.currentTimeMillis() - TimeUnit.DAYS.toMillis(1), TimeUnit.MILLISECONDS));

    System.out.println(
        String.format(
            "All databases created after %s and that are ready:", createTime.toString()));
    listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString())
            .setFilter(String.format(
                "create_time >= \"%s\" AND state:READY", createTime.toString())).build();
    for (Backup backup : dbAdminClient.listBackups(listBackupsRequest).iterateAll()) {
      System.out.println(backup);
    }

    // List backups using pagination.
    System.out.println("All backups, listed using pagination:");
    listBackupsRequest =
        ListBackupsRequest.newBuilder().setParent(instanceName.toString()).setPageSize(10).build();
    while (true) {
      ListBackupsPagedResponse response = dbAdminClient.listBackups(listBackupsRequest);
      for (Backup backup : response.getPage().iterateAll()) {
        System.out.println(backup);
      }
      String nextPageToken = response.getNextPageToken();
      if (!Strings.isNullOrEmpty(nextPageToken)) {
        listBackupsRequest = listBackupsRequest.toBuilder().setPageToken(nextPageToken).build();
      } else {
        break;
      }
    }
  }
  // [END spanner_list_backups]

  // [START spanner_restore_backup]
  static void restoreBackup(
      DatabaseAdminClient dbAdminClient,
      String projectId,
      String instanceId,
      String backupId,
      String restoreToDatabaseId) {
    BackupName backupName = BackupName.of(projectId, instanceId, backupId);
    Backup backup = dbAdminClient.getBackup(backupName);
    // Initiate the request which returns an OperationFuture.
    System.out.println(String.format(
        "Restoring backup [%s] to database [%s]...", backup.getName(), restoreToDatabaseId));
    try {
      RestoreDatabaseRequest request =
          RestoreDatabaseRequest.newBuilder()
              .setParent(InstanceName.of(projectId, instanceId).toString())
              .setDatabaseId(restoreToDatabaseId)
              .setBackup(backupName.toString()).build();
      OperationFuture<com.google.spanner.admin.database.v1.Database, RestoreDatabaseMetadata> op =
          dbAdminClient.restoreDatabaseAsync(request);
      // Wait until the database has been restored.
      com.google.spanner.admin.database.v1.Database db = op.get();
      // Get the restore info.
      RestoreInfo restoreInfo = db.getRestoreInfo();
      BackupInfo backupInfo = restoreInfo.getBackupInfo();

      System.out.println(
          "Restored database ["
              + db.getName()
              + "] from ["
              + restoreInfo.getBackupInfo().getBackup()
              + "] with version time [" + backupInfo.getVersionTime() + "]");
    } catch (ExecutionException e) {
      throw SpannerExceptionFactory.newSpannerException(e.getCause());
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_restore_backup]

  // [START spanner_update_backup]
  static void updateBackup(DatabaseAdminClient dbAdminClient, String projectId,
      String instanceId, String backupId) {
    BackupName backupName = BackupName.of(projectId, instanceId, backupId);

    // Get current backup metadata.
    Backup backup = dbAdminClient.getBackup(backupName);
    // Add 30 days to the expire time.
    // Expire time must be within 366 days of the create time of the backup.
    Timestamp currentExpireTime = backup.getExpireTime();
    com.google.cloud.Timestamp newExpireTime =
        com.google.cloud.Timestamp.ofTimeMicroseconds(
            TimeUnit.SECONDS.toMicros(currentExpireTime.getSeconds())
                + TimeUnit.NANOSECONDS.toMicros(currentExpireTime.getNanos())
                + TimeUnit.DAYS.toMicros(30L));

    // New Expire Time must be less than Max Expire Time
    newExpireTime =
        newExpireTime.compareTo(com.google.cloud.Timestamp.fromProto(backup.getMaxExpireTime()))
            < 0 ? newExpireTime : com.google.cloud.Timestamp.fromProto(backup.getMaxExpireTime());

    System.out.println(String.format(
        "Updating expire time of backup [%s] to %s...",
        backupId.toString(),
        java.time.OffsetDateTime.ofInstant(
            Instant.ofEpochSecond(newExpireTime.getSeconds(),
                newExpireTime.getNanos()), ZoneId.systemDefault())));

    // Update expire time.
    backup = backup.toBuilder().setExpireTime(newExpireTime.toProto()).build();
    dbAdminClient.updateBackup(backup,
        FieldMask.newBuilder().addAllPaths(Lists.newArrayList("expire_time")).build());
    System.out.println("Updated backup [" + backupId + "]");
  }
  // [END spanner_update_backup]

  // [START spanner_delete_backup]
  static void deleteBackup(DatabaseAdminClient dbAdminClient,
      String project, String instance, String backupId) {
    BackupName backupName = BackupName.of(project, instance, backupId);

    // Delete the backup.
    System.out.println("Deleting backup [" + backupId + "]...");
    dbAdminClient.deleteBackup(backupName);
    // Verify that the backup is deleted.
    try {
      dbAdminClient.getBackup(backupName);
    } catch (NotFoundException e) {
      if (e.getStatusCode().getCode() == Code.NOT_FOUND) {
        System.out.println("Deleted backup [" + backupId + "]");
      } else {
        System.out.println("Delete backup [" + backupId + "] failed");
        throw new RuntimeException("Delete backup [" + backupId + "] failed", e);
      }
    }
  }
  // [END spanner_delete_backup]

  static void run(
      DatabaseClient dbClient,
      DatabaseAdminClient dbAdminClient,
      String command,
      DatabaseId database,
      String backupId) {
    switch (command) {
      case "createdatabase":
        createDatabase(dbAdminClient, InstanceName.of(database.getInstanceId().getProject(),
            database.getInstanceId().getInstance()), database.getDatabase());
        break;
      case "write":
        writeExampleData(dbClient);
        break;
      case "delete":
        deleteExampleData(dbClient);
        break;
      case "query":
        query(dbClient);
        break;
      case "read":
        read(dbClient);
        break;
      case "addmarketingbudget":
        addMarketingBudget(dbAdminClient, DatabaseName.of(database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "update":
        update(dbClient);
        break;
      case "writetransaction":
        writeWithTransaction(dbClient);
        break;
      case "querymarketingbudget":
        queryMarketingBudget(dbClient);
        break;
      case "addindex":
        addIndex(dbAdminClient, DatabaseName.of(database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "readindex":
        readUsingIndex(dbClient);
        break;
      case "queryindex":
        queryUsingIndex(dbClient);
        break;
      case "addstoringindex":
        addStoringIndex(dbAdminClient, DatabaseName.of(database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "readstoringindex":
        readStoringIndex(dbClient);
        break;
      case "readonlytransaction":
        readOnlyTransaction(dbClient);
        break;
      case "readstaledata":
        readStaleData(dbClient);
        break;
      case "addcommittimestamp":
        addCommitTimestamp(dbAdminClient, DatabaseName.of(database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "updatewithtimestamp":
        updateWithTimestamp(dbClient);
        break;
      case "querywithtimestamp":
        queryMarketingBudgetWithTimestamp(dbClient);
        break;
      case "createtablewithtimestamp":
        createTableWithTimestamp(dbAdminClient,
            DatabaseName.of(database.getInstanceId().getProject(),
                database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "writewithtimestamp":
        writeExampleDataWithTimestamp(dbClient);
        break;
      case "querysingerstable":
        querySingersTable(dbClient);
        break;
      case "queryperformancestable":
        queryPerformancesTable(dbClient);
        break;
      case "writestructdata":
        writeStructExampleData(dbClient);
        break;
      case "querywithstruct":
        queryWithStruct(dbClient);
        break;
      case "querywitharrayofstruct":
        queryWithArrayOfStruct(dbClient);
        break;
      case "querystructfield":
        queryStructField(dbClient);
        break;
      case "querynestedstructfield":
        queryNestedStructField(dbClient);
        break;
      case "insertusingdml":
        insertUsingDml(dbClient);
        break;
      case "updateusingdml":
        updateUsingDml(dbClient);
        break;
      case "deleteusingdml":
        deleteUsingDml(dbClient);
        break;
      case "updateusingdmlwithtimestamp":
        updateUsingDmlWithTimestamp(dbClient);
        break;
      case "writeandreadusingdml":
        writeAndReadUsingDml(dbClient);
        break;
      case "updateusingdmlwithstruct":
        updateUsingDmlWithStruct(dbClient);
        break;
      case "writeusingdml":
        writeUsingDml(dbClient);
        break;
      case "querywithparameter":
        queryWithParameter(dbClient);
        break;
      case "writewithtransactionusingdml":
        writeWithTransactionUsingDml(dbClient);
        break;
      case "updateusingpartitioneddml":
        updateUsingPartitionedDml(dbClient);
        break;
      case "deleteusingpartitioneddml":
        deleteUsingPartitionedDml(dbClient);
        break;
      case "updateusingbatchdml":
        updateUsingBatchDml(dbClient);
        break;
      case "createtablewithdatatypes":
        createTableWithDatatypes(dbAdminClient,
            DatabaseName.of(database.getInstanceId().getProject(),
                database.getInstanceId().getInstance(), database.getDatabase()));
        break;
      case "writedatatypesdata":
        writeDatatypesData(dbClient);
        break;
      case "querywitharray":
        queryWithArray(dbClient);
        break;
      case "querywithbool":
        queryWithBool(dbClient);
        break;
      case "querywithbytes":
        queryWithBytes(dbClient);
        break;
      case "querywithdate":
        queryWithDate(dbClient);
        break;
      case "querywithfloat":
        queryWithFloat(dbClient);
        break;
      case "querywithint":
        queryWithInt(dbClient);
        break;
      case "querywithstring":
        queryWithString(dbClient);
        break;
      case "querywithtimestampparameter":
        queryWithTimestampParameter(dbClient);
        break;
      case "querywithnumeric":
        queryWithNumeric(dbClient);
        break;
      case "clientwithqueryoptions":
        clientWithQueryOptions(database);
        break;
      case "querywithqueryoptions":
        queryWithQueryOptions(dbClient);
        break;
      case "createbackup":
        createBackup(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase(),
            backupId, getVersionTime(dbClient));
        break;
      case "cancelcreatebackup":
        cancelCreateBackup(
            dbAdminClient,
            database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase(),
            backupId + "_cancel");
        break;
      case "listbackupoperations":
        listBackupOperations(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase(), backupId);
        break;
      case "listdatabaseoperations":
        listDatabaseOperations(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance());
        break;
      case "listbackups":
        listBackups(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), database.getDatabase(), backupId);
        break;
      case "restorebackup":
        restoreBackup(
            dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), backupId, database.getDatabase());
        break;
      case "updatebackup":
        updateBackup(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), backupId);
        break;
      case "deletebackup":
        deleteBackup(dbAdminClient, database.getInstanceId().getProject(),
            database.getInstanceId().getInstance(), backupId);
        break;
      default:
        printUsageAndExit();
    }
  }

  static Timestamp getVersionTime(DatabaseClient dbClient) {
    // Generates a version time for the backup
    com.google.cloud.Timestamp versionTime;
    try (ResultSet resultSet = dbClient.singleUse()
        .executeQuery(Statement.of("SELECT CURRENT_TIMESTAMP()"))) {
      resultSet.next();
      versionTime = resultSet.getTimestamp(0);
    }
    return versionTime.toProto();
  }

  static void printUsageAndExit() {
    System.err.println("Usage:");
    System.err.println("    SpannerExample <command> <instance_id> <database_id>");
    System.err.println("");
    System.err.println("Examples:");
    System.err.println("    SpannerExample createdatabase my-instance example-db");
    System.err.println("    SpannerExample write my-instance example-db");
    System.err.println("    SpannerExample delete my-instance example-db");
    System.err.println("    SpannerExample query my-instance example-db");
    System.err.println("    SpannerExample read my-instance example-db");
    System.err.println("    SpannerExample addmarketingbudget my-instance example-db");
    System.err.println("    SpannerExample update my-instance example-db");
    System.err.println("    SpannerExample writetransaction my-instance example-db");
    System.err.println("    SpannerExample querymarketingbudget my-instance example-db");
    System.err.println("    SpannerExample addindex my-instance example-db");
    System.err.println("    SpannerExample readindex my-instance example-db");
    System.err.println("    SpannerExample queryindex my-instance example-db");
    System.err.println("    SpannerExample addstoringindex my-instance example-db");
    System.err.println("    SpannerExample readstoringindex my-instance example-db");
    System.err.println("    SpannerExample readonlytransaction my-instance example-db");
    System.err.println("    SpannerExample readstaledata my-instance example-db");
    System.err.println("    SpannerExample addcommittimestamp my-instance example-db");
    System.err.println("    SpannerExample updatewithtimestamp my-instance example-db");
    System.err.println("    SpannerExample querywithtimestamp my-instance example-db");
    System.err.println("    SpannerExample createtablewithtimestamp my-instance example-db");
    System.err.println("    SpannerExample writewithtimestamp my-instance example-db");
    System.err.println("    SpannerExample querysingerstable my-instance example-db");
    System.err.println("    SpannerExample queryperformancestable my-instance example-db");
    System.err.println("    SpannerExample writestructdata my-instance example-db");
    System.err.println("    SpannerExample querywithstruct my-instance example-db");
    System.err.println("    SpannerExample querywitharrayofstruct my-instance example-db");
    System.err.println("    SpannerExample querystructfield my-instance example-db");
    System.err.println("    SpannerExample querynestedstructfield my-instance example-db");
    System.err.println("    SpannerExample insertusingdml my-instance example-db");
    System.err.println("    SpannerExample updateusingdml my-instance example-db");
    System.err.println("    SpannerExample deleteusingdml my-instance example-db");
    System.err.println("    SpannerExample updateusingdmlwithtimestamp my-instance example-db");
    System.err.println("    SpannerExample writeandreadusingdml my-instance example-db");
    System.err.println("    SpannerExample updateusingdmlwithstruct my-instance example-db");
    System.err.println("    SpannerExample writeusingdml my-instance example-db");
    System.err.println("    SpannerExample querywithparameter my-instance example-db");
    System.err.println("    SpannerExample writewithtransactionusingdml my-instance example-db");
    System.err.println("    SpannerExample updateusingpartitioneddml my-instance example-db");
    System.err.println("    SpannerExample deleteusingpartitioneddml my-instance example-db");
    System.err.println("    SpannerExample updateusingbatchdml my-instance example-db");
    System.err.println("    SpannerExample createtablewithdatatypes my-instance example-db");
    System.err.println("    SpannerExample writedatatypesdata my-instance example-db");
    System.err.println("    SpannerExample querywitharray my-instance example-db");
    System.err.println("    SpannerExample querywithbool my-instance example-db");
    System.err.println("    SpannerExample querywithbytes my-instance example-db");
    System.err.println("    SpannerExample querywithdate my-instance example-db");
    System.err.println("    SpannerExample querywithfloat my-instance example-db");
    System.err.println("    SpannerExample querywithint my-instance example-db");
    System.err.println("    SpannerExample querywithstring my-instance example-db");
    System.err.println("    SpannerExample querywithtimestampparameter my-instance example-db");
    System.err.println("    SpannerExample clientwithqueryoptions my-instance example-db");
    System.err.println("    SpannerExample querywithqueryoptions my-instance example-db");
    System.err.println("    SpannerExample createbackup my-instance example-db");
    System.err.println("    SpannerExample listbackups my-instance example-db");
    System.err.println("    SpannerExample listbackupoperations my-instance example-db backup-id");
    System.err.println("    SpannerExample listdatabaseoperations my-instance example-db");
    System.err.println("    SpannerExample restorebackup my-instance example-db");
    System.exit(1);
  }

  public static void main(String[] args) {
    if (args.length != 3 && args.length != 4) {
      printUsageAndExit();
    }
    // [START init_client]
    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();
    DatabaseAdminClient dbAdminClient = null;
    try {
      final String command = args[0];
      DatabaseId db = DatabaseId.of(options.getProjectId(), args[1], args[2]);
      // [END init_client]
      // This will return the default project id based on the environment.
      String clientProject = spanner.getOptions().getProjectId();
      if (!db.getInstanceId().getProject().equals(clientProject)) {
        System.err.println(
            "Invalid project specified. Project in the database id should match the"
                + "project name set in the environment variable GOOGLE_CLOUD_PROJECT. Expected: "
                + clientProject);
        printUsageAndExit();
      }
      // Generate a backup id for the sample database.
      String backupId = null;
      if (args.length == 4) {
        backupId = args[3];
      }

      // [START init_client]
      DatabaseClient dbClient = spanner.getDatabaseClient(db);
      dbAdminClient = spanner.createDatabaseAdminClient();

      // Use client here...
      // [END init_client]

      run(dbClient, dbAdminClient, command, db, backupId);
      // [START init_client]
    } finally {
      if (dbAdminClient != null) {
        if (!dbAdminClient.isShutdown() || !dbAdminClient.isTerminated()) {
          dbAdminClient.close();
        }
      }
      spanner.close();
    }
    // [END init_client]
    System.out.println("Closed client");
  }
}
