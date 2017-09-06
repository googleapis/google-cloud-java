/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.examples.spanner.snippets;

import com.google.api.gax.paging.Page;
import com.google.cloud.spanner.Options.ListOption;
import com.google.spanner.admin.database.v1.CreateDatabaseMetadata;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.List;
import javax.annotation.Nullable;

/**
 * This class contains snippets for {@link DatabaseAdminClient} interface.
 */
public interface DatabaseAdminClientSnippets {
  
  private final DatabaseAdminClient dbAdminClient;

  public DatabaseAdminClientSnippets(DatabaseAdminClient dbAdminClient) {
    this.dbAdminClient = dbAdminClient;
  }
  
  /**
   * Example to create database.
   */
  // [TARGET createDatabase(String, String, Iterable)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void createDatabase(String instanceId, String databaseId) {
    // [START createDatabase]
    Operation<Database, CreateDatabaseMetadata> op = dbAdminClient
        .createDatabase(
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
    Database db = op.waitFor().getResult();
    System.out.println("Created database [" + db.getId() + "]");
    // [END createDatabase]
  }

  /**
   * Example to getDatabase.
   */
  // [TARGET getDatabase(String, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void getDatabase(String instanceId, String databaseId) {
    // [START getDatabase]
    Database db = dbClient.getDatabase(instanceId, databaseId);
    System.out.println("Fetched database [" + db.getId() + "]");
    // [END getDatabase]
  }

  /**
   * Example to update the database DDL.
   */
  // [TARGET updateDatabaseDdl(String, String, Iterable, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void updateDatabaseDdl(String instanceId, String databaseId) {
    // [START updateDatabaseDdl]
    dbAdminClient.updateDatabaseDdl(instanceId, 
        databaseId, 
        Arrays.asList("ALTER TABLE Albums ADD COLUMN MarketingBudget INT64"), 
        null).waitFor();
    System.out.println("UpdateDatabaseDdl: added MarketingBudget column");
    // [END updateDatabaseDdl]
  }

  /** 
   * Example to drop a Cloud Spanner database. 
   */
  // [TARGET dropDatabase(String, String)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void dropDatabase(String instanceId, String databaseId) {
    // [START dropDatabase]
    dbAdminClient.dropDatabase(instanceId, databaseId);
    System.out.println("DropDatabase: " + databaseId);
    // [END dropDatabase]
  }

  /**
   * Example to get the schema of a Cloud Spanner database.
   */
  // [TARGET getDatabaseDdl(instanceId, databaseId)]
  // [VARIABLE my_instance_id]
  // [VARIABLE my_database_id]
  public void getDatabaseDdl(String instanceId, String databaseId) {
    // [START getDatabaseDdl]
    List<String> statementsInDb = dbAdminClient.getDatabaseDdl(instanceId, databaseId);
    // [END getDatabaseDdl]
  }

  /** 
   * Example to get the list of Cloud Spanner database in the given instance. 
   */
  // [TARGET listDatabases(String, ListOption)]
  // [VARIABLE my_instance_id]
  public void listDatabases(String instanceId) {
    // [START listDatabases]
    Page<Database> page = dbAdminClient.listDatabases(instanceId, Options.pageSize(1));
    while (page != null) {
      Database db = Iterables.getOnlyElement(page.getValues());
      System.out.println(db.getId().getDatabase());
      page = page.getNextPage();
    }
    // [END listDatabases]
  }
}