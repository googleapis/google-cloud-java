/*
 * Copyright 2022 Google LLC
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

package com.example.spanner;

// [START spanner_postgresql_interleaved_table]

import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.admin.database.v1.DatabaseAdminClient;
import com.google.spanner.admin.database.v1.DatabaseName;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;

public class PgInterleavedTableSample {

  static void pgInterleavedTable() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    pgInterleavedTable(projectId, instanceId, databaseId);
  }

  static void pgInterleavedTable(String projectId, String instanceId, String databaseId) {

    try (Spanner spanner =
        SpannerOptions.newBuilder().setProjectId(projectId).build().getService();
        DatabaseAdminClient databaseAdminClient = spanner.createDatabaseAdminClient()) {
      // The Spanner PostgreSQL dialect extends the PostgreSQL dialect with certain Spanner
      // specific features, such as interleaved tables.
      // See https://cloud.google.com/spanner/docs/postgresql/data-definition-language#create_table
      // for the full CREATE TABLE syntax.
      databaseAdminClient.updateDatabaseDdlAsync(DatabaseName.of(projectId,
              instanceId,
              databaseId),
          Arrays.asList(
              "CREATE TABLE Singers ("
                  + "  SingerId  bigint NOT NULL PRIMARY KEY,"
                  + "  FirstName varchar(1024) NOT NULL,"
                  + "  LastName  varchar(1024) NOT NULL"
                  + ")",
              "CREATE TABLE Albums ("
                  + "  SingerId bigint NOT NULL,"
                  + "  AlbumId  bigint NOT NULL,"
                  + "  Title    varchar(1024) NOT NULL,"
                  + "  PRIMARY KEY (SingerId, AlbumId)"
                  + ") INTERLEAVE IN PARENT Singers ON DELETE CASCADE")).get();
      System.out.println("Created interleaved table hierarchy using PostgreSQL dialect");
    } catch (ExecutionException e) {
      // If the operation failed during execution, expose the cause.
      throw SpannerExceptionFactory.asSpannerException(e.getCause());
    } catch (InterruptedException e) {
      // Throw when a thread is waiting, sleeping, or otherwise occupied,
      // and the thread is interrupted, either before or during the activity.
      throw SpannerExceptionFactory.propagateInterrupt(e);
    }
  }
}
// [END spanner_postgresql_interleaved_table]