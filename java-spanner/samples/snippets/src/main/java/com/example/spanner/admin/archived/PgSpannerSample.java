/*
 * Copyright 2022 Google Inc.
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

package com.example.spanner.admin.archived;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.ByteArray;
import com.google.cloud.Date;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.Instance;
import com.google.cloud.spanner.InstanceAdminClient;
import com.google.cloud.spanner.InstanceId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.Options;
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
import com.google.cloud.spanner.Value;
import com.google.common.io.BaseEncoding;
import com.google.longrunning.Operation;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.spanner.admin.database.v1.CreateBackupMetadata;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import com.google.spanner.v1.ExecuteSqlRequest;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Example code for using the Cloud Spanner PostgreSQL interface.
 */
public class PgSpannerSample {
  // [START spanner_postgresql_insert_data]
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
  // [END spanner_postgresql_insert_data]

  /** Class to contain performance sample data. */
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

  // [START spanner_postgresql_insert_data_with_timestamp_column]
  static final List<Performance> PERFORMANCES =
      Arrays.asList(
          new Performance(1, 4, "2017-10-05", 11000),
          new Performance(1, 19, "2017-11-02", 15000),
          new Performance(2, 42, "2017-12-23", 7000));
  // [START spanner_postgresql_insert_datatypes_data]

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
  // [END spanner_postgresql_insert_data_with_timestamp_column]
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
              new BigDecimal("215100.10")),
          new Venue(
              19,
              "Venue 19",
              exampleBytes2,
              6300,
              availableDates2,
              "2019-01-15",
              true,
              0.98716f,
              new BigDecimal("1200100.00")),
          new Venue(
              42,
              "Venue 42",
              exampleBytes3,
              3000,
              availableDates3,
              "2018-10-01",
              false,
              0.72598f,
              new BigDecimal("390650.99")));
  // [END spanner_postgresql_insert_datatypes_data]

  /** Class to contain venue sample data. */
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

    Venue(
        long venueId,
        String venueName,
        String venueInfo,
        long capacity,
        Value availableDates,
        String lastContactDate,
        boolean outdoorVenue,
        float popularityScore,
        BigDecimal revenue) {
      this.venueId = venueId;
      this.venueName = venueName;
      this.venueInfo = venueInfo;
      this.capacity = capacity;
      this.availableDates = availableDates;
      this.lastContactDate = lastContactDate;
      this.outdoorVenue = outdoorVenue;
      this.popularityScore = popularityScore;
      this.revenue = revenue;
    }
  }

  // [START spanner_postgresql_create_database]
  static void createPostgreSqlDatabase(DatabaseAdminClient dbAdminClient, DatabaseId id) {
    OperationFuture<Database, CreateDatabaseMetadata> op = dbAdminClient.createDatabase(
        dbAdminClient.newDatabaseBuilder(id).setDialect(Dialect.POSTGRESQL).build(),
        Collections.emptyList());
    try {
      // Initiate the request which returns an OperationFuture.
      Database db = op.get();
      System.out.println("Created database [" + db.getId() + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_postgresql_create_database]

  // [START spanner_postgresql_insert_data]
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
  // [END spanner_postgresql_insert_data]

  // [START spanner_postgresql_delete_data]
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
  // [END spanner_postgresql_delete_data]

  // [START spanner_postgresql_query_data]
  static void query(DatabaseClient dbClient) {
    try (ResultSet resultSet =
             dbClient
                 .singleUse() // Execute a single read or query against Cloud Spanner.
                 .executeQuery(Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1),
            resultSet.getString(2));
      }
    }
  }
  // [END spanner_postgresql_query_data]

  // [START spanner_postgresql_read_data]
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
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1),
            resultSet.getString(2));
      }
    }
  }
  // [END spanner_postgresql_read_data]

  // [START spanner_postgresql_add_column]
  static void addMarketingBudget(DatabaseAdminClient adminClient, DatabaseId dbId) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op = adminClient.updateDatabaseDdl(
        dbId.getInstanceId().getInstance(),
        dbId.getDatabase(),
        Arrays.asList("ALTER TABLE Albums ADD COLUMN MarketingBudget bigint"),
        null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
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
  // [END spanner_postgresql_add_column]

  // Before executing this method, a new column MarketingBudget has to be added to the Albums
  // table by applying the DDL statement "ALTER TABLE Albums ADD COLUMN MarketingBudget INT64".
  // [START spanner_postgresql_update_data]
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
  // [END spanner_postgresql_update_data]

  // [START spanner_postgresql_read_write_transaction]
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
  // [END spanner_postgresql_read_write_transaction]

  // [START spanner_postgresql_query_data_with_new_column]
  static void queryMarketingBudget(DatabaseClient dbClient) {
    // Rows without an explicit value for MarketingBudget will have a MarketingBudget equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
             dbClient
                 .singleUse()
                 .executeQuery(Statement.of("SELECT singerid as \"SingerId\", "
                     + "albumid as \"AlbumId\", marketingbudget as \"MarketingBudget\" "
                     + "FROM Albums"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getLong("AlbumId"),
            // We check that the value is non null. ResultSet getters can only be used to retrieve
            // non null values.
            resultSet.isNull("MarketingBudget") ? "NULL" :
                resultSet.getLong("MarketingBudget"));
      }
    }
  }
  // [END spanner_postgresql_query_data_with_new_column]

  // [START spanner_postgresql_create_index]
  static void addIndex(DatabaseAdminClient adminClient, DatabaseId dbId) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        adminClient.updateDatabaseDdl(
            dbId.getInstanceId().getInstance(),
            dbId.getDatabase(),
            Arrays.asList("CREATE INDEX AlbumsByAlbumTitle ON Albums(AlbumTitle)"),
            null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
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
  // [END spanner_postgresql_create_index]

  // [START spanner_postgresql_read_data_with_index]
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
  // [END spanner_postgresql_read_data_with_index]

  // [START spanner_postgresql_create_storing_index]
  static void addStoringIndex(DatabaseAdminClient adminClient, DatabaseId dbId) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op = adminClient.updateDatabaseDdl(
        dbId.getInstanceId().getInstance(),
        dbId.getDatabase(),
        Arrays.asList(
            "CREATE INDEX AlbumsByAlbumTitle2 ON Albums(AlbumTitle) "
                + "INCLUDE (MarketingBudget)"),
        null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
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
  // [END spanner_postgresql_create_storing_index]

  // Before running this example, create a storing index AlbumsByAlbumTitle2 by applying the DDL
  // statement "CREATE INDEX AlbumsByAlbumTitle2 ON Albums(AlbumTitle) INCLUDE (MarketingBudget)".
  // [START spanner_postgresql_read_data_with_storing_index]
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
            resultSet.isNull("marketingbudget") ? "NULL" : resultSet.getLong(2));
      }
    }
  }
  // [END spanner_postgresql_read_data_with_storing_index]

  // [START spanner_postgresql_read_only_transaction]
  static void readOnlyTransaction(DatabaseClient dbClient) {
    // ReadOnlyTransaction must be closed by calling close() on it to release resources held by it.
    // We use a try-with-resource block to automatically do so.
    try (ReadOnlyTransaction transaction = dbClient.readOnlyTransaction()) {
      ResultSet queryResultSet =
          transaction.executeQuery(
              Statement.of("SELECT SingerId, AlbumId, AlbumTitle FROM Albums"));
      while (queryResultSet.next()) {
        System.out.printf(
            "%d %d %s\n",
            queryResultSet.getLong(0), queryResultSet.getLong(1),
            queryResultSet.getString(2));
      }
      try (ResultSet readResultSet =
               transaction.read(
                   "Albums", KeySet.all(), Arrays.asList("SingerId", "AlbumId", "AlbumTitle"))) {
        while (readResultSet.next()) {
          System.out.printf(
              "%d %d %s\n",
              readResultSet.getLong(0), readResultSet.getLong(1),
              readResultSet.getString(2));
        }
      }
    }
  }
  // [END spanner_postgresql_read_only_transaction]

  // [START spanner_postgresql_query_singers_table]
  static void querySingersTable(DatabaseClient dbClient) {
    try (ResultSet resultSet =
             dbClient
                 .singleUse()
                 .executeQuery(Statement.of("SELECT singerid as \"SingerId\", "
                     + "firstname as \"FirstName\", lastname as \"LastName\" FROM Singers"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%s %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getString("FirstName"),
            resultSet.getString("LastName"));
      }
    }
  }
  // [END spanner_postgresql_query_singers_table]


  // [START spanner_postgresql_dml_getting_started_insert]
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
  // [END spanner_postgresql_dml_getting_started_insert]

  // [START spanner_postgresql_query_with_parameter]
  static void queryWithParameter(DatabaseClient dbClient) {
    Statement statement =
        Statement.newBuilder(
                "SELECT singerid AS \"SingerId\", "
                    + "firstname as \"FirstName\", lastname as \"LastName\" "
                    + "FROM Singers "
                    + "WHERE LastName = $1")
            .bind("p1")
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
  // [END spanner_postgresql_query_with_parameter]

  // [START spanner_postgresql_dml_getting_started_update]
  static void writeWithTransactionUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(transaction -> {
          // Transfer marketing budget from one album to another. We do it in a transaction to
          // ensure that the transfer is atomic.
          String sql1 =
              "SELECT marketingbudget as \"MarketingBudget\" from Albums WHERE "
                  + "SingerId = 2 and AlbumId = 2";
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
                "SELECT marketingbudget as \"MarketingBudget\" from Albums WHERE "
                    + "SingerId = 1 and AlbumId = 1";
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
                            + "SET MarketingBudget = $1 "
                            + "WHERE SingerId = 1 and AlbumId = 1")
                    .bind("p1")
                    .to(album1Budget)
                    .build();
            transaction.executeUpdate(updateStatement);
            Statement updateStatement2 =
                Statement.newBuilder(
                        "UPDATE Albums "
                            + "SET MarketingBudget = $1 "
                            + "WHERE SingerId = 2 and AlbumId = 2")
                    .bind("p1")
                    .to(album2Budget)
                    .build();
            transaction.executeUpdate(updateStatement2);
          }
          return null;
        });
  }
  // [END spanner_postgresql_dml_getting_started_update]

  // [START spanner_postgresql_create_table_using_ddl]
  // [START spanner_postgresql_create_database]
  static void createTableUsingDdl(DatabaseAdminClient dbAdminClient, DatabaseId id) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        dbAdminClient.updateDatabaseDdl(
            id.getInstanceId().getInstance(),
            id.getDatabase(),
            Arrays.asList(
                "CREATE TABLE Singers ("
                    + "  SingerId   bigint NOT NULL,"
                    + "  FirstName  character varying(1024),"
                    + "  LastName   character varying(1024),"
                    + "  SingerInfo bytea,"
                    + "  FullName character varying(2048) GENERATED "
                    + "  ALWAYS AS (FirstName || ' ' || LastName) STORED,"
                    + "  PRIMARY KEY (SingerId)"
                    + ")",
                "CREATE TABLE Albums ("
                    + "  SingerId     bigint NOT NULL,"
                    + "  AlbumId      bigint NOT NULL,"
                    + "  AlbumTitle   character varying(1024),"
                    + "  PRIMARY KEY (SingerId, AlbumId)"
                    + ") INTERLEAVE IN PARENT Singers ON DELETE CASCADE"),
            null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
      System.out.println("Created Singers & Albums tables in database: [" + id + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_postgresql_create_database]
  // [END spanner_postgresql_create_table_using_ddl]

  // [START spanner_postgresql_read_stale_data]
  static void readStaleData(DatabaseClient dbClient) {
    try (ResultSet resultSet =
             dbClient
                 .singleUse(TimestampBound.ofExactStaleness(15, TimeUnit.SECONDS))
                 .read(
                     "Albums", KeySet.all(),
                     Arrays.asList("SingerId", "AlbumId", "MarketingBudget"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n",
            resultSet.getLong(0),
            resultSet.getLong(1),
            resultSet.isNull(2) ? "NULL" : resultSet.getLong(2));
      }
    }
  }
  // [END spanner_postgresql_read_stale_data]

  // Before executing this method, a new column MarketingBudget has to be added to the Albums
  // table by applying the DDL statement "ALTER TABLE Albums ADD COLUMN MarketingBudget BIGINT".
  // In addition this update expects the LastUpdateTime column added by applying the DDL statement
  // "ALTER TABLE Albums ADD COLUMN LastUpdateTime TIMESTAMPTZ"
  // [START spanner_postgresql_update_data_with_timestamp_column]
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
  // [END spanner_postgresql_update_data_with_timestamp_column]

  // [START spanner_postgresql_add_timestamp_column]
  static void addLastUpdateTimestampColumn(DatabaseAdminClient adminClient, DatabaseId dbId) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        adminClient.updateDatabaseDdl(
            dbId.getInstanceId().getInstance(),
            dbId.getDatabase(),
            Arrays.asList(
                "ALTER TABLE Albums ADD COLUMN LastUpdateTime spanner.commit_timestamp"),
            null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
      System.out.println("Added LastUpdateTime as a timestamp column in Albums table.");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_postgresql_add_timestamp_column]

  // [START spanner_postgresql_query_data_with_timestamp_column]
  static void queryMarketingBudgetWithTimestamp(DatabaseClient dbClient) {
    // Rows without an explicit value for MarketingBudget will have a MarketingBudget equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
             dbClient
                 .singleUse()
                 .executeQuery(
                     Statement.of(
                         "SELECT singerid as \"SingerId\", albumid as \"AlbumId\", "
                             + "marketingbudget as \"MarketingBudget\","
                             + "lastupdatetime as \"LastUpdateTime\" FROM Albums"
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
  // [END spanner_postgresql_query_data_with_timestamp_column]

  // [START spanner_postgresql_create_table_with_timestamp_column]
  static void createTableWithTimestamp(DatabaseAdminClient dbAdminClient, DatabaseId id) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        dbAdminClient.updateDatabaseDdl(
            id.getInstanceId().getInstance(),
            id.getDatabase(),
            Arrays.asList(
                "CREATE TABLE Performances ("
                    + "  SingerId     BIGINT NOT NULL,"
                    + "  VenueId      BIGINT NOT NULL,"
                    + "  Revenue      BIGINT,"
                    + "  LastUpdateTime SPANNER.COMMIT_TIMESTAMP NOT NULL,"
                    + "  PRIMARY KEY (SingerId, VenueId))"
                    + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE"),
            null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
      System.out.println("Created Performances table in database: [" + id + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_postgresql_create_table_with_timestamp_column]

  // [START spanner_postgresql_insert_data_with_timestamp_column]
  static void writeExampleDataWithTimestamp(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();
    for (Performance performance : PERFORMANCES) {
      mutations.add(
          Mutation.newInsertBuilder("Performances")
              .set("SingerId")
              .to(performance.singerId)
              .set("VenueId")
              .to(performance.venueId)
              .set("Revenue")
              .to(performance.revenue)
              .set("LastUpdateTime")
              .to(Value.COMMIT_TIMESTAMP)
              .build());
    }
    dbClient.write(mutations);
  }
  // [END spanner_postgresql_insert_data_with_timestamp_column]

  static void queryPerformancesTable(DatabaseClient dbClient) {
    // Rows without an explicit value for Revenue will have a Revenue equal to
    // null. A try-with-resource block is used to automatically release resources held by
    // ResultSet.
    try (ResultSet resultSet =
             dbClient
                 .singleUse()
                 .executeQuery(
                     Statement.of(
                         "SELECT singerid as \"SingerId\", venueid as \"VenueId\", "
                             + "revenue as \"Revenue\", lastupdatetime as \"LastUpdateTime\" "
                             + "FROM Performances ORDER BY LastUpdateTime DESC"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s %s\n",
            resultSet.getLong("SingerId"),
            resultSet.getLong("VenueId"),
            // We check that the value is non null. ResultSet getters can only be used to retrieve
            // non null values.
            resultSet.isNull("Revenue") ? "NULL" : resultSet.getLong("Revenue"),
            resultSet.getTimestamp("LastUpdateTime"));
      }
    }
  }

  // [START spanner_postgresql_dml_standard_insert]
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
  // [END spanner_postgresql_dml_standard_insert]

  // [START spanner_postgresql_dml_standard_update]
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
  // [END spanner_postgresql_dml_standard_update]

  // [START spanner_postgresql_dml_standard_delete]
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
  // [END spanner_postgresql_dml_standard_delete]

  // [START spanner_postgresql_dml_write_then_read]
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
          sql = "SELECT firstname as \"FirstName\", lastname as \"LastName\" FROM Singers WHERE "
              + "SingerId = 11";
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
  // [END spanner_postgresql_dml_write_then_read]

  // [START spanner_postgresql_dml_partitioned_update]
  static void updateUsingPartitionedDml(DatabaseClient dbClient) {
    String sql = "UPDATE Albums SET MarketingBudget = 100000 WHERE SingerId > 1";
    long rowCount = dbClient.executePartitionedUpdate(Statement.of(sql));
    System.out.printf("%d records updated.\n", rowCount);
  }
  // [END spanner_postgresql_dml_partitioned_update]

  // [START spanner_postgresql_dml_partitioned_delete]
  static void deleteUsingPartitionedDml(DatabaseClient dbClient) {
    String sql = "DELETE FROM Singers WHERE SingerId > 10";
    long rowCount = dbClient.executePartitionedUpdate(Statement.of(sql));
    System.out.printf("%d records deleted.\n", rowCount);
  }
  // [END spanner_postgresql_dml_partitioned_delete]

  // [START spanner_postgresql_dml_batch_update]
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
  // [END spanner_postgresql_dml_batch_update]

  // [START spanner_postgresql_create_table_with_datatypes]
  static void createTableWithDatatypes(DatabaseAdminClient dbAdminClient, DatabaseId id) {
    OperationFuture<Void, UpdateDatabaseDdlMetadata> op =
        dbAdminClient.updateDatabaseDdl(
            id.getInstanceId().getInstance(),
            id.getDatabase(),
            Arrays.asList(
                "CREATE TABLE Venues ("
                    + "  VenueId         BIGINT NOT NULL,"
                    + "  VenueName       character varying(100),"
                    + "  VenueInfo       bytea,"
                    + "  Capacity        BIGINT,"
                    + "  OutdoorVenue    BOOL, "
                    + "  PopularityScore FLOAT8, "
                    + "  Revenue         NUMERIC, "
                    + "  LastUpdateTime  SPANNER.COMMIT_TIMESTAMP NOT NULL,"
                    + "  PRIMARY KEY (VenueId))"),
            null);
    try {
      // Initiate the request which returns an OperationFuture.
      op.get();
      System.out.println("Created Venues table in database: [" + id + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
  // [END spanner_postgresql_create_table_with_datatypes]

  // [START spanner_postgresql_insert_datatypes_data]
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
              .set("OutdoorVenue")
              .to(venue.outdoorVenue)
              .set("PopularityScore")
              .to(venue.popularityScore)
              .set("Revenue")
              .to(venue.revenue)
              .set("LastUpdateTime")
              .to(Value.COMMIT_TIMESTAMP)
              .build());
    }
    dbClient.write(mutations);
  }
  // [END spanner_postgresql_insert_datatypes_data]

  // [START spanner_postgresql_query_with_bool_parameter]
  static void queryWithBool(DatabaseClient dbClient) {
    boolean exampleBool = true;
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\","
                    + " outdoorvenue as \"OutdoorVenue\" FROM Venues "
                    + "WHERE OutdoorVenue = $1")
            .bind("p1")
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
  // [END spanner_postgresql_query_with_bool_parameter]

  // [START spanner_postgresql_query_with_bytes_parameter]
  static void queryWithBytes(DatabaseClient dbClient) {
    ByteArray exampleBytes =
        ByteArray.fromBase64(BaseEncoding.base64().encode("Hello World 1".getBytes()));
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\" FROM Venues "
                    + "WHERE VenueInfo = $1")
            .bind("p1")
            .to(exampleBytes)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s\n", resultSet.getLong("VenueId"), resultSet.getString("VenueName"));
      }
    }
  }
  // [END spanner_postgresql_query_with_bytes_parameter]

  // [START spanner_postgresql_query_with_float_parameter]
  static void queryWithFloat(DatabaseClient dbClient) {
    float exampleFloat = 0.8f;
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\", "
                    + "popularityscore as \"PopularityScore\" FROM Venues "
                    + "WHERE PopularityScore > $1")
            .bind("p1")
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
  // [END spanner_postgresql_query_with_float_parameter]

  // [START spanner_postgresql_query_with_int_parameter]
  static void queryWithInt(DatabaseClient dbClient) {
    long exampleInt = 3000;
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\", "
                    + "capacity as \"Capacity\" "
                    + "FROM Venues " + "WHERE Capacity >= $1")
            .bind("p1")
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
  // [END spanner_postgresql_query_with_int_parameter]

  // [START spanner_postgresql_query_with_string_parameter]
  static void queryWithString(DatabaseClient dbClient) {
    String exampleString = "Venue 42";
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\" FROM Venues WHERE"
                    + " VenueName = $1")
            .bind("p1")
            .to(exampleString)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s\n", resultSet.getLong("VenueId"), resultSet.getString("VenueName"));
      }
    }
  }
  // [END spanner_postgresql_query_with_string_parameter]

  // [START spanner_postgresql_query_with_timestamp_parameter]
  static void queryWithTimestampParameter(DatabaseClient dbClient) {
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\", "
                    + "lastupdatetime as \"LastUpdateTime\" FROM Venues "
                    + "WHERE LastUpdateTime < $1")
            .bind("p1")
            .to(Timestamp.now())
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
  // [END spanner_postgresql_query_with_timestamp_parameter]

  // [START spanner_postgresql_query_with_numeric_parameter]
  static void queryWithNumeric(DatabaseClient dbClient) {
    Statement statement =
        Statement.newBuilder(
                "SELECT venueid as \"VenueId\", venuename as \"VenueName\", "
                    + "revenue as \"Revenue\" FROM Venues\n"
                    + "WHERE Revenue >= $1")
            .bind("p1")
            .to(Value.pgNumeric("300000"))
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %s %s%n",
            resultSet.getLong("VenueId"),
            resultSet.getString("VenueName"),
            resultSet.getValue("Revenue"));
      }
    }
  }
  // [END spanner_postgresql_query_with_numeric_parameter]

  // [START spanner_postgresql_create_client_with_query_options]
  static void clientWithQueryOptions(DatabaseId db) {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setDefaultQueryOptions(
                db, ExecuteSqlRequest.QueryOptions
                    .newBuilder()
                    .setOptimizerVersion("1")
                    // The list of available statistics packages can be found by querying the
                    // "INFORMATION_SCHEMA.spanner_postgresql_STATISTICS" table.
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
  // [END spanner_postgresql_create_client_with_query_options]

  // [START spanner_postgresql_query_with_query_options]
  static void queryWithQueryOptions(DatabaseClient dbClient) {
    try (ResultSet resultSet =
             dbClient
                 .singleUse()
                 .executeQuery(
                     Statement
                         .newBuilder("SELECT SingerId, AlbumId, AlbumTitle FROM Albums")
                         .withQueryOptions(ExecuteSqlRequest.QueryOptions
                             .newBuilder()
                             .setOptimizerVersion("1")
                             // The list of available statistics packages can be found by querying
                             // the "INFORMATION_SCHEMA.spanner_postgresql_STATISTICS" table.
                             .setOptimizerStatisticsPackage("latest")
                             .build())
                         .build())) {
      while (resultSet.next()) {
        System.out.printf(
            "%d %d %s\n", resultSet.getLong(0), resultSet.getLong(1), resultSet.getString(2));
      }
    }
  }
  // [END spanner_postgresql_query_with_query_options]

  // [START spanner_postgresql_list_backup_operations]
  static void listBackupOperations(InstanceAdminClient instanceAdminClient, DatabaseId databaseId) {
    Instance instance = instanceAdminClient.getInstance(databaseId.getInstanceId().getInstance());
    // Get create backup operations for the sample database.
    Timestamp last24Hours = Timestamp.ofTimeSecondsAndNanos(TimeUnit.SECONDS.convert(
        TimeUnit.HOURS.convert(Timestamp.now().getSeconds(), TimeUnit.SECONDS) - 24,
        TimeUnit.HOURS), 0);
    String filter =
        String.format(
            "(metadata.database:%s) AND "
                + "(metadata.@type:type.googleapis.com/"
                + "google.spanner.admin.database.v1.CreateBackupMetadata) AND "
                + "(metadata.progress.start_time > \"%s\")",
            databaseId.getName(), last24Hours);
    Page<com.google.longrunning.Operation> operations = instance
        .listBackupOperations(Options.filter(filter));
    for (com.google.longrunning.Operation op : operations.iterateAll()) {
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
  }
  // [END spanner_postgresql_list_backup_operations]

  // [START spanner_postgresql_list_database_operations]
  static void listDatabaseOperations(
      InstanceAdminClient instanceAdminClient,
      DatabaseAdminClient dbAdminClient,
      InstanceId instanceId) {
    Instance instance = instanceAdminClient.getInstance(instanceId.getInstance());
    // Get optimize restored database operations.
    Timestamp last24Hours = Timestamp.ofTimeSecondsAndNanos(TimeUnit.SECONDS.convert(
        TimeUnit.HOURS.convert(Timestamp.now().getSeconds(), TimeUnit.SECONDS) - 24,
        TimeUnit.HOURS), 0);
    String filter = String.format("(metadata.@type:type.googleapis.com/"
        + "google.spanner.admin.database.v1.OptimizeRestoredDatabaseMetadata) AND "
        + "(metadata.progress.start_time > \"%s\")", last24Hours);
    for (Operation op : instance.listDatabaseOperations(Options.filter(filter)).iterateAll()) {
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
  // [END spanner_postgresql_list_database_operations]

  static void run(
      DatabaseClient dbClient,
      DatabaseAdminClient dbAdminClient,
      InstanceAdminClient instanceAdminClient,
      String command,
      DatabaseId database) {
    switch (command) {
      case "createdatabase":
        createPostgreSqlDatabase(dbAdminClient, database);
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
        addMarketingBudget(dbAdminClient, database);
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
        addIndex(dbAdminClient, database);
        break;
      case "readindex":
        readUsingIndex(dbClient);
        break;
      case "addstoringindex":
        addStoringIndex(dbAdminClient, database);
        break;
      case "readstoringindex":
        readStoringIndex(dbClient);
        break;
      case "readonlytransaction":
        readOnlyTransaction(dbClient);
        break;
      case "querysingerstable":
        querySingersTable(dbClient);
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
      case "createtableusingddl":
        createTableUsingDdl(dbAdminClient, database);
        break;
      case "readstaledata":
        readStaleData(dbClient);
        break;
      case "addlastupdatetimestampcolumn":
        addLastUpdateTimestampColumn(dbAdminClient, database);
        break;
      case "updatewithtimestamp":
        updateWithTimestamp(dbClient);
        break;
      case "querywithtimestamp":
        queryMarketingBudgetWithTimestamp(dbClient);
        break;
      case "createtablewithtimestamp":
        createTableWithTimestamp(dbAdminClient, database);
        break;
      case "writewithtimestamp":
        writeExampleDataWithTimestamp(dbClient);
        break;
      case "queryperformancestable":
        queryPerformancesTable(dbClient);
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
      case "writeandreadusingdml":
        writeAndReadUsingDml(dbClient);
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
        createTableWithDatatypes(dbAdminClient, database);
        break;
      case "writedatatypesdata":
        writeDatatypesData(dbClient);
        break;
      case "querywithbool":
        queryWithBool(dbClient);
        break;
      case "querywithbytes":
        queryWithBytes(dbClient);
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
      case "listbackupoperations":
        listBackupOperations(instanceAdminClient, database);
        break;
      case "listdatabaseoperations":
        listDatabaseOperations(instanceAdminClient, dbAdminClient, database.getInstanceId());
        break;
      default:
        printUsageAndExit();
    }
  }

  static void printUsageAndExit() {
    System.err.println("Usage:");
    System.err.println("    PgSpannerExample <command> <instance_id> <database_id>");
    System.err.println();
    System.err.println("Examples:");
    System.err.println("    PgSpannerExample createdatabase my-instance example-db");
    System.err.println("    PgSpannerExample write my-instance example-db");
    System.err.println("    PgSpannerExample delete my-instance example-db");
    System.err.println("    PgSpannerExample query my-instance example-db");
    System.err.println("    PgSpannerExample read my-instance example-db");
    System.err.println("    PgSpannerExample addmarketingbudget my-instance example-db");
    System.err.println("    PgSpannerExample update my-instance example-db");
    System.err.println("    PgSpannerExample writetransaction my-instance example-db");
    System.err.println("    PgSpannerExample querymarketingbudget my-instance example-db");
    System.err.println("    PgSpannerExample addindex my-instance example-db");
    System.err.println("    PgSpannerExample readindex my-instance example-db");
    System.err.println("    PgSpannerExample addstoringindex my-instance example-db");
    System.err.println("    PgSpannerExample readstoringindex my-instance example-db");
    System.err.println("    PgSpannerExample readonlytransaction my-instance example-db");
    System.err.println("    PgSpannerExample querysingerstable my-instance example-db");
    System.err.println("    PgSpannerExample writeusingdml my-instance example-db");
    System.err.println("    PgSpannerExample querywithparameter my-instance example-db");
    System.err.println("    PgSpannerExample writewithtransactionusingdml my-instance example-db");
    System.err.println("    PgSpannerExample createtableforsamples my-instance example-db");
    System.err.println("    PgSpannerExample writewithtimestamp my-instance example-db");
    System.err.println("    PgSpannerExample queryperformancestable my-instance example-db");
    System.err.println("    PgSpannerExample writestructdata my-instance example-db");
    System.err.println("    PgSpannerExample insertusingdml my-instance example-db");
    System.err.println("    PgSpannerExample updateusingdml my-instance example-db");
    System.err.println("    PgSpannerExample deleteusingdml my-instance example-db");
    System.err.println("    PgSpannerExample writeandreadusingdml my-instance example-db");
    System.err.println("    PgSpannerExample writeusingdml my-instance example-db");
    System.err.println("    PgSpannerExample deleteusingpartitioneddml my-instance example-db");
    System.err.println("    PgSpannerExample updateusingbatchdml my-instance example-db");
    System.err.println("    PgSpannerExample createtablewithdatatypes my-instance example-db");
    System.err.println("    PgSpannerExample writedatatypesdata my-instance example-db");
    System.err.println("    PgSpannerExample querywithbool my-instance example-db");
    System.err.println("    PgSpannerExample querywithbytes my-instance example-db");
    System.err.println("    PgSpannerExample querywithfloat my-instance example-db");
    System.err.println("    PgSpannerExample querywithint my-instance example-db");
    System.err.println("    PgSpannerExample querywithstring my-instance example-db");
    System.err.println("    PgSpannerExample querywithtimestampparameter my-instance example-db");
    System.err.println("    PgSpannerExample clientwithqueryoptions my-instance example-db");
    System.err.println("    PgSpannerExample querywithqueryoptions my-instance example-db");
    System.err.println("    PgSpannerExample listbackupoperations my-instance example-db");
    System.err.println("    PgSpannerExample listdatabaseoperations my-instance example-db");
    System.exit(1);
  }

  public static void main(String[] args) {
    if (args.length != 3) {
      printUsageAndExit();
    }
    // [START spanner_init_client]
    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();
    try {
      // [END spanner_init_client]
      String command = args[0];
      DatabaseId db = DatabaseId.of(options.getProjectId(), args[1], args[2]);

      // This will return the default project id based on the environment.
      String clientProject = spanner.getOptions().getProjectId();
      if (!db.getInstanceId().getProject().equals(clientProject)) {
        System.err.println(
            "Invalid project specified. Project in the database id should match the"
                + "project name set in the environment variable GOOGLE_CLOUD_PROJECT. Expected: "
                + clientProject);
        printUsageAndExit();
      }
      // [START spanner_init_client]
      DatabaseClient dbClient = spanner.getDatabaseClient(db);
      DatabaseAdminClient dbAdminClient = spanner.getDatabaseAdminClient();
      InstanceAdminClient instanceAdminClient = spanner.getInstanceAdminClient();
      // [END spanner_init_client]

      // Use client here...
      run(dbClient, dbAdminClient, instanceAdminClient, command, db);
      // [START spanner_init_client]
    } finally {
      spanner.close();
    }
    // [END spanner_init_client]
    System.out.println("Closed client");
  }

  /** Class to contain singer sample data. */
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

  /** Class to contain album sample data. */
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
}
