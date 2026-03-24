/*
 * Copyright 2024 Google Inc.
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

import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeyRange;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.CreateDatabaseRequest;
import com.google.spanner.admin.database.v1.InstanceName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Example code for using the Cloud Spanner API. This example demonstrates all the common property
 * graph operations that can be done on Cloud Spanner. These are:
 *
 * <p>
 *
 * <ul>
 *   <li>Creating a Cloud Spanner database with a property graph.
 *   <li>Inserting data, updating and deleting data.
 *   <li>Executing graph queries.
 * </ul>
 */
public class SpannerGraphSample {

  // [START spanner_insert_graph_data]
  /** Class to contain sample Person data. */
  static class Person {

    final long id;
    final String name;
    final Timestamp birthday;
    final String country;
    final String city;

    Person(long id, String name, Timestamp birthday, String country, String city) {
      this.id = id;
      this.name = name;
      this.birthday = birthday;
      this.country = country;
      this.city = city;
    }
  }

  /** Class to contain sample Account data. */
  static class Account {

    final long id;
    final Timestamp createTime;
    final boolean isBlocked;
    final String nickName;

    Account(long id, Timestamp createTime, boolean isBlocked, String nickName) {
      this.id = id;
      this.createTime = createTime;
      this.isBlocked = isBlocked;
      this.nickName = nickName;
    }
  }

  /** Class to contain sample Transfer data. */
  static class Transfer {

    final long id;
    final long toId;
    final double amount;
    final Timestamp createTime;
    final String orderNumber;

    Transfer(long id, long toId, double amount, Timestamp createTime, String orderNumber) {
      this.id = id;
      this.toId = toId;
      this.amount = amount;
      this.createTime = createTime;
      this.orderNumber = orderNumber;
    }
  }

  /** Class to contain sample Ownership data. */
  static class Own {

    final long id;
    final long accountId;
    final Timestamp createTime;

    Own(long id, long accountId, Timestamp createTime) {
      this.id = id;
      this.accountId = accountId;
      this.createTime = createTime;
    }
  }

  // [END spanner_insert_graph_data]

  // [START spanner_create_database_with_property_graph]
  static void createDatabaseWithPropertyGraph(
      DatabaseAdminClient dbAdminClient, InstanceName instanceName, String databaseId) {
    CreateDatabaseRequest createDatabaseRequest =
        CreateDatabaseRequest.newBuilder()
            .setCreateStatement("CREATE DATABASE `" + databaseId + "`")
            .setParent(instanceName.toString())
            .addAllExtraStatements(
                Arrays.asList(
                    "CREATE TABLE Person ("
                        + "  id               INT64 NOT NULL,"
                        + "  name             STRING(MAX),"
                        + "  birthday         TIMESTAMP,"
                        + "  country          STRING(MAX),"
                        + "  city             STRING(MAX),"
                        + ") PRIMARY KEY (id)",
                    "CREATE TABLE Account ("
                        + "  id               INT64 NOT NULL,"
                        + "  create_time      TIMESTAMP,"
                        + "  is_blocked       BOOL,"
                        + "  nick_name        STRING(MAX),"
                        + ") PRIMARY KEY (id)",
                    "CREATE TABLE PersonOwnAccount ("
                        + "  id               INT64 NOT NULL,"
                        + "  account_id       INT64 NOT NULL,"
                        + "  create_time      TIMESTAMP,"
                        + "  FOREIGN KEY (account_id)"
                        + "  REFERENCES Account (id)"
                        + ") PRIMARY KEY (id, account_id),"
                        + "INTERLEAVE IN PARENT Person ON DELETE CASCADE",
                    "CREATE TABLE AccountTransferAccount ("
                        + "  id               INT64 NOT NULL,"
                        + "  to_id            INT64 NOT NULL,"
                        + "  amount           FLOAT64,"
                        + "  create_time      TIMESTAMP NOT NULL,"
                        + "  order_number     STRING(MAX),"
                        + "  FOREIGN KEY (to_id) REFERENCES Account (id)"
                        + ") PRIMARY KEY (id, to_id, create_time),"
                        + "INTERLEAVE IN PARENT Account ON DELETE CASCADE",
                    "CREATE OR REPLACE PROPERTY GRAPH FinGraph "
                        + "NODE TABLES (Account, Person)"
                        + "EDGE TABLES ("
                        + "  PersonOwnAccount"
                        + "    SOURCE KEY(id) REFERENCES Person(id)"
                        + "    DESTINATION KEY(account_id) REFERENCES Account(id)"
                        + "    LABEL Owns,"
                        + "  AccountTransferAccount"
                        + "    SOURCE KEY(id) REFERENCES Account(id)"
                        + "    DESTINATION KEY(to_id) REFERENCES Account(id)"
                        + "    LABEL Transfers)"))
            .build();
    try {
      // Initiate the request which returns an OperationFuture.
      com.google.spanner.admin.database.v1.Database db =
          dbAdminClient.createDatabaseAsync(createDatabaseRequest).get();
      System.out.println("Created database [" + db.getName() + "]");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      System.out.println("Encountered exception" + e.getCause());
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }

  // [END spanner_create_database_with_property_graph]

  // [START spanner_insert_graph_data]
  static final List<Account> ACCOUNTS =
      Arrays.asList(
          new Account(
              7, Timestamp.parseTimestamp("2020-01-10T06:22:20.12Z"), false, "Vacation Fund"),
          new Account(
              16, Timestamp.parseTimestamp("2020-01-27T17:55:09.12Z"), true, "Vacation Fund"),
          new Account(
              20, Timestamp.parseTimestamp("2020-02-18T05:44:20.12Z"), false, "Rainy Day Fund"));

  static final List<Person> PERSONS =
      Arrays.asList(
          new Person(
              1,
              "Alex",
              Timestamp.parseTimestamp("1991-12-21T00:00:00.12Z"),
              "Australia",
              " Adelaide"),
          new Person(
              2,
              "Dana",
              Timestamp.parseTimestamp("1980-10-31T00:00:00.12Z"),
              "Czech_Republic",
              "Moravia"),
          new Person(
              3, "Lee", Timestamp.parseTimestamp("1986-12-07T00:00:00.12Z"), "India", "Kollam"));

  static final List<Transfer> TRANSFERS =
      Arrays.asList(
          new Transfer(
              7, 16, 300.0, Timestamp.parseTimestamp("2020-08-29T15:28:58.12Z"), "304330008004315"),
          new Transfer(
              7, 16, 100.0, Timestamp.parseTimestamp("2020-10-04T16:55:05.12Z"), "304120005529714"),
          new Transfer(
              16,
              20,
              300.0,
              Timestamp.parseTimestamp("2020-09-25T02:36:14.12Z"),
              "103650009791820"),
          new Transfer(
              20, 7, 500.0, Timestamp.parseTimestamp("2020-10-04T16:55:05.12Z"), "304120005529714"),
          new Transfer(
              20,
              16,
              200.0,
              Timestamp.parseTimestamp("2020-10-17T03:59:40.12Z"),
              "302290001255747"));

  static final List<Own> OWNERSHIPS =
      Arrays.asList(
          new Own(1, 7, Timestamp.parseTimestamp("2020-01-10T06:22:20.12Z")),
          new Own(2, 20, Timestamp.parseTimestamp("2020-01-27T17:55:09.12Z")),
          new Own(3, 16, Timestamp.parseTimestamp("2020-02-18T05:44:20.12Z")));

  static void insertData(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();
    for (Account account : ACCOUNTS) {
      mutations.add(
          Mutation.newInsertBuilder("Account")
              .set("id")
              .to(account.id)
              .set("create_time")
              .to(account.createTime)
              .set("is_blocked")
              .to(account.isBlocked)
              .set("nick_name")
              .to(account.nickName)
              .build());
    }
    for (Person person : PERSONS) {
      mutations.add(
          Mutation.newInsertBuilder("Person")
              .set("id")
              .to(person.id)
              .set("name")
              .to(person.name)
              .set("birthday")
              .to(person.birthday)
              .set("country")
              .to(person.country)
              .set("city")
              .to(person.city)
              .build());
    }
    for (Transfer transfer : TRANSFERS) {
      mutations.add(
          Mutation.newInsertBuilder("AccountTransferAccount")
              .set("id")
              .to(transfer.id)
              .set("to_id")
              .to(transfer.toId)
              .set("amount")
              .to(transfer.amount)
              .set("create_time")
              .to(transfer.createTime)
              .set("order_number")
              .to(transfer.orderNumber)
              .build());
    }
    for (Own own : OWNERSHIPS) {
      mutations.add(
          Mutation.newInsertBuilder("PersonOwnAccount")
              .set("id")
              .to(own.id)
              .set("account_id")
              .to(own.accountId)
              .set("create_time")
              .to(own.createTime)
              .build());
    }

    dbClient.write(mutations);
  }

  // [END spanner_insert_graph_data]

  // [START spanner_insert_graph_data_with_dml]
  static void insertUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql =
                  "INSERT INTO Account (id, create_time, is_blocked) "
                      + "  VALUES"
                      + "    (1, CAST('2000-08-10 08:18:48.463959-07:52' AS TIMESTAMP), false),"
                      + "    (2, CAST('2000-08-12 07:13:16.463959-03:41' AS TIMESTAMP), true)";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d record(s) inserted into Account.\n", rowCount);
              return null;
            });

    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql =
                  "INSERT INTO AccountTransferAccount (id, to_id, create_time, amount) "
                      + "  VALUES"
                      + "    (1, 2, CAST('2000-09-11 03:11:18.463959-06:36' AS TIMESTAMP), 100),"
                      + "    (1, 1, CAST('2000-09-12 04:09:34.463959-05:12' AS TIMESTAMP), 200) ";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d record(s) inserted into AccountTransferAccount.\n", rowCount);
              return null;
            });
  }

  // [END spanner_insert_graph_data_with_dml]

  // [START spanner_update_graph_data_with_dml]
  static void updateUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql = "UPDATE Account SET is_blocked = false WHERE id = 2";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d Account record(s) updated.\n", rowCount);
              return null;
            });

    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql =
                  "UPDATE AccountTransferAccount SET amount = 300 WHERE id = 1 AND to_id = 2";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d AccountTransferAccount record(s) updated.\n", rowCount);
              return null;
            });
  }

  // [END spanner_update_graph_data_with_dml]

  // [START spanner_update_graph_data_with_graph_query_in_dml]
  static void updateUsingGraphQueryInDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql =
                  "UPDATE Account SET is_blocked = true "
                      + "WHERE id IN {"
                      + "  GRAPH FinGraph"
                      + "  MATCH (a:Account WHERE a.id = 1)-[:TRANSFERS]->{1,2}(b:Account)"
                      + "  RETURN b.id}";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d Account record(s) updated.\n", rowCount);
              return null;
            });
  }

  // [END spanner_update_graph_data_with_graph_query_in_dml]

  // [START spanner_query_graph_data]
  static void query(DatabaseClient dbClient) {
    try (ResultSet resultSet =
        dbClient
            .singleUse() // Execute a single query against Cloud Spanner.
            .executeQuery(
                Statement.of(
                    "Graph FinGraph MATCH"
                        + " (a:Person)-[o:Owns]->()-[t:Transfers]->()<-[p:Owns]-(b:Person)RETURN"
                        + " a.name AS sender, b.name AS receiver, t.amount, t.create_time AS"
                        + " transfer_at"))) {
      while (resultSet.next()) {
        System.out.printf(
            "%s %s %f %s\n",
            resultSet.getString(0),
            resultSet.getString(1),
            resultSet.getDouble(2),
            resultSet.getTimestamp(3));
      }
    }
  }

  // [END spanner_query_graph_data]

  // [START spanner_query_graph_data_with_parameter]
  static void queryWithParameter(DatabaseClient dbClient) {
    Statement statement =
        Statement.newBuilder(
                "Graph FinGraph MATCH"
                    + " (a:Person)-[o:Owns]->()-[t:Transfers]->()<-[p:Owns]-(b:Person) WHERE"
                    + " t.amount >= @min RETURN a.name AS sender, b.name AS receiver, t.amount,"
                    + " t.create_time AS transfer_at")
            .bind("min")
            .to(500)
            .build();
    try (ResultSet resultSet = dbClient.singleUse().executeQuery(statement)) {
      while (resultSet.next()) {
        System.out.printf(
            "%s %s %f %s\n",
            resultSet.getString("sender"),
            resultSet.getString("receiver"),
            resultSet.getDouble("amount"),
            resultSet.getTimestamp("transfer_at"));
      }
    }
  }

  // [END spanner_query_graph_data_with_parameter]

  // [START spanner_delete_graph_data_with_dml]
  static void deleteUsingDml(DatabaseClient dbClient) {
    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql = "DELETE FROM AccountTransferAccount WHERE id = 1 AND to_id = 2";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d AccountTransferAccount record(s) deleted.\n", rowCount);
              return null;
            });

    dbClient
        .readWriteTransaction()
        .run(
            transaction -> {
              String sql = "DELETE FROM Account WHERE id = 2";
              long rowCount = transaction.executeUpdate(Statement.of(sql));
              System.out.printf("%d Account record(s) deleted.\n", rowCount);
              return null;
            });
  }

  // [END spanner_delete_graph_data_with_dml]

  // [START spanner_delete_graph_data]
  static void deleteData(DatabaseClient dbClient) {
    List<Mutation> mutations = new ArrayList<>();

    // KeySet.Builder can be used to delete a specific set of rows.
    // Delete the PersonOwnAccount rows with the key values (1,7) and (2,20).
    mutations.add(
        Mutation.delete(
            "PersonOwnAccount",
            KeySet.newBuilder().addKey(Key.of(1, 7)).addKey(Key.of(2, 20)).build()));

    // KeyRange can be used to delete rows with a key in a specific range.
    // Delete a range of rows where the key prefix is >=1 and <8
    mutations.add(
        Mutation.delete(
            "AccountTransferAccount", KeySet.range(KeyRange.closedOpen(Key.of(1), Key.of(8)))));

    // KeySet.all() can be used to delete all the rows in a table.
    // Delete all Account rows, which will also delete the remaining
    // AccountTransferAccount rows since it was defined with ON DELETE CASCADE.
    mutations.add(Mutation.delete("Account", KeySet.all()));

    // KeySet.all() can be used to delete all the rows in a table.
    // Delete all Person rows, which will also delete the remaining
    // PersonOwnAccount rows since it was defined with ON DELETE CASCADE.
    mutations.add(Mutation.delete("Person", KeySet.all()));

    dbClient.write(mutations);
    System.out.printf("Records deleted.\n");
  }

  // [END spanner_delete_graph_data]

  static void run(
      DatabaseClient dbClient,
      DatabaseAdminClient dbAdminClient,
      String command,
      DatabaseId database) {
    switch (command) {
      case "createdatabase":
        createDatabaseWithPropertyGraph(
            dbAdminClient,
            InstanceName.of(
                database.getInstanceId().getProject(), database.getInstanceId().getInstance()),
            database.getDatabase());
        break;
      case "insert":
        insertData(dbClient);
        break;
      case "insertusingdml":
        insertUsingDml(dbClient);
        break;
      case "updateusingdml":
        updateUsingDml(dbClient);
        break;
      case "updateusinggraphqueryindml":
        updateUsingGraphQueryInDml(dbClient);
        break;
      case "query":
        query(dbClient);
        break;
      case "querywithparameter":
        queryWithParameter(dbClient);
        break;
      case "deleteusingdml":
        deleteUsingDml(dbClient);
        break;
      case "delete":
        deleteData(dbClient);
        break;
      default:
        printUsageAndExit();
    }
  }

  static void printUsageAndExit() {
    System.err.println("Usage:");
    System.err.println("    SpannerGraphExample <command> <instance_id> <database_id>");
    System.err.println("");
    System.err.println("Examples:");
    System.err.println("    SpannerGraphExample createdatabase my-instance example-db");
    System.err.println("    SpannerGraphExample insert my-instance example-db");
    System.err.println("    SpannerGraphExample insertusingdml my-instance example-db");
    System.err.println("    SpannerGraphExample updateusingdml my-instance example-db");
    System.err.println("    SpannerGraphExample updateusinggraphqueryindml my-instance example-db");
    System.err.println("    SpannerGraphExample query my-instance example-db");
    System.err.println("    SpannerGraphExample querywithparameter my-instance example-db");
    System.err.println("    SpannerGraphExample deleteusingdml my-instance example-db");
    System.err.println("    SpannerGraphExample delete my-instance example-db");
    System.exit(1);
  }

  public static void main(String[] args) {
    if (args.length != 3 && args.length != 4) {
      printUsageAndExit();
    }
    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();
    DatabaseAdminClient dbAdminClient = null;
    try {
      final String command = args[0];
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

      DatabaseClient dbClient = spanner.getDatabaseClient(db);
      dbAdminClient = spanner.createDatabaseAdminClient();

      run(dbClient, dbAdminClient, command, db);
    } finally {
      if (dbAdminClient != null) {
        if (!dbAdminClient.isShutdown() || !dbAdminClient.isTerminated()) {
          dbAdminClient.close();
        }
      }
      spanner.close();
    }
    System.out.println("Closed client");
  }
}
