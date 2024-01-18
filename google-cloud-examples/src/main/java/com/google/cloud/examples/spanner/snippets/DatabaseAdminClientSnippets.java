/*
 * Copyright 2017 Google LLC
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

/*
 * EDITING INSTRUCTIONS
 * This file is referenced in DatabaseAdminClient's javadoc. Any change to this file should be reflected
 * in DatabaseAdminClient's javadoc.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.common.collect.Iterables;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

/** This class contains snippets for {@link DatabaseAdminClient} interface. */
public class DatabaseAdminClientSnippets {

  private final DatabaseAdminClient dbAdminClient;

  public DatabaseAdminClientSnippets(DatabaseAdminClient dbAdminClient) {
    this.dbAdminClient = dbAdminClient;
  }

  /** Example to create database. */
  // [TARGET createDatabase(String, String, Iterable)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public Database createDatabase(String instanceId, String databaseId) {
    // [START createDatabase]
    OperationFuture<Database, CreateDatabaseMetadata> op =
        dbAdminClient.createDatabase(
            instanceId,
            databaseId,
            Arrays.asList(
                "CREATE TABLE Singers (\n"
                    + "  SingerId   INT64 NOT NULL,\n"
                    + "  FirstName  STRING(1024),\n"
                    + "  LastName   STRING(1024),\n"
                    + "  SingerInfo BYTES(MAX)\n"
                    + ") PRIMARY KEY (SingerId)",
                "CREATE TABLE Albums (\n"
                    + "  SingerId     INT64 NOT NULL,\n"
                    + "  AlbumId      INT64 NOT NULL,\n"
                    + "  AlbumTitle   STRING(MAX)\n"
                    + ") PRIMARY KEY (SingerId, AlbumId),\n"
                    + "  INTERLEAVE IN PARENT Singers ON DELETE CASCADE"));
    Database db;
    try {
      db = op.get();
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // [END createDatabase]
    return db;
  }

  /** Example to getDatabase. */
  // [TARGET getDatabase(String, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public Database getDatabase(String instanceId, String databaseId) {
    // [START getDatabase]
    Database db = dbAdminClient.getDatabase(instanceId, databaseId);
    // [END getDatabase]
    return db;
  }

  /** Example to update the database DDL. */
  // [TARGET updateDatabaseDdl(String, String, Iterable, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void updateDatabaseDdl(String instanceId, String databaseId) {
    // [START updateDatabaseDdl]
    try {
      dbAdminClient
          .updateDatabaseDdl(
              instanceId,
              databaseId,
              Arrays.asList("ALTER TABLE Albums ADD COLUMN MarketingBudget INT64"),
              null)
          .get();
    } catch (ExecutionException e) {
      throw (SpannerException) e.getCause();
    } catch (InterruptedException e) {
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
    // [END updateDatabaseDdl]
  }

  /** Example to drop a Cloud Spanner database. */
  // [TARGET dropDatabase(String, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void dropDatabase(String instanceId, String databaseId) {
    // [START dropDatabase]
    dbAdminClient.dropDatabase(instanceId, databaseId);
    // [END dropDatabase]
  }

  /** Example to get the schema of a Cloud Spanner database. */
  // [TARGET getDatabaseDdl(String, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public List<String> getDatabaseDdl(String instanceId, String databaseId) {
    // [START getDatabaseDdl]
    List<String> statementsInDb = dbAdminClient.getDatabaseDdl(instanceId, databaseId);
    // [END getDatabaseDdl]
    return statementsInDb;
  }

  /** Example to get the list of Cloud Spanner database in the given instance. */
  // [TARGET listDatabases(String, ListOption...)]
  // [VARIABLE my_instance_id]
  public List<Database> listDatabases(String instanceId) {
    // [START listDatabases]
    Page<Database> page = dbAdminClient.listDatabases(instanceId, Options.pageSize(1));
    List<Database> dbs = new ArrayList<>();
    while (page != null) {
      Database db = Iterables.getOnlyElement(page.getValues());
      dbs.add(db);
      page = page.getNextPage();
    }
    // [END listDatabases]
    return dbs;
  }
}
