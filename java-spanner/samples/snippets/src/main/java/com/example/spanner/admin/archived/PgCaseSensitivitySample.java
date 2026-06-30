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

package com.example.spanner.admin.archived;

// [START spanner_postgresql_identifier_case_sensitivity]

import com.google.api.gax.longrunning.OperationFuture;
import com.google.cloud.spanner.DatabaseAdminClient;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;
import com.google.spanner.admin.database.v1.UpdateDatabaseDdlMetadata;
import java.util.Collections;
import java.util.concurrent.ExecutionException;

public class PgCaseSensitivitySample {

  static void pgCaseSensitivity() {
    // TODO(developer): Replace these variables before running the sample.
    final String projectId = "my-project";
    final String instanceId = "my-instance";
    final String databaseId = "my-database";
    pgCaseSensitivity(projectId, instanceId, databaseId);
  }

  static void pgCaseSensitivity(String projectId, String instanceId, String databaseId) {
    try (Spanner spanner =
        SpannerOptions.newBuilder()
            .setProjectId(projectId)
            .build()
            .getService()) {
      final DatabaseAdminClient databaseAdminClient = spanner.getDatabaseAdminClient();

      // Spanner PostgreSQL follows the case sensitivity rules of PostgreSQL. This means that:
      // 1. Identifiers that are not double-quoted are folded to lower case.
      // 2. Identifiers that are double-quoted retain their case and are case-sensitive.
      // See https://www.postgresql.org/docs/current/sql-syntax-lexical.html#SQL-SYNTAX-IDENTIFIERS
      // for more information.
      final OperationFuture<Void, UpdateDatabaseDdlMetadata> updateOperation =
          databaseAdminClient.updateDatabaseDdl(
              instanceId,
              databaseId,
              Collections.singleton(
                  "CREATE TABLE Singers ("
                      // SingerId will be folded to `singerid`.
                      + "  SingerId      bigint NOT NULL PRIMARY KEY,"
                      // FirstName and LastName are double-quoted and will therefore retain their
                      // mixed case and are case-sensitive. This means that any statement that
                      // references any of these columns must use double quotes.
                      + "  \"FirstName\" varchar(1024) NOT NULL,"
                      + "  \"LastName\"  varchar(1024) NOT NULL"
                      + ")"),
              null);
      updateOperation.get();

      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of(projectId, instanceId, databaseId));

      client.write(
          Collections.singleton(
              Mutation.newInsertBuilder("Singers")
                  .set("singerid")
                  .to(1L)
                  // Column names in mutations are always case-insensitive, regardless whether the
                  // columns were double-quoted or not during creation.
                  .set("firstname")
                  .to("Bruce")
                  .set("lastname")
                  .to("Allison")
                  .build()));

      try (ResultSet singers =
          client
              .singleUse()
              .executeQuery(
                  Statement.of("SELECT SingerId, \"FirstName\", \"LastName\" FROM Singers"))) {
        while (singers.next()) {
          System.out.printf(
              "SingerId: %d, FirstName: %s, LastName: %s\n",
              // SingerId is automatically folded to lower case. Accessing the column by its name in
              // a result set must therefore use all lower-case letters.
              singers.getLong("singerid"),
              // FirstName and LastName were double-quoted during creation, and retain their mixed
              // case when returned in a result set.
              singers.getString("FirstName"),
              singers.getString("LastName"));
        }
      }

      // Aliases are also identifiers, and specifying an alias in double quotes will make the alias
      // retain its case.
      try (ResultSet singers =
          client
              .singleUse()
              .executeQuery(
                  Statement.of(
                      "SELECT "
                          + "singerid AS \"SingerId\", "
                          + "concat(\"FirstName\", ' '::varchar, \"LastName\") AS \"FullName\" "
                          + "FROM Singers"))) {
        while (singers.next()) {
          System.out.printf(
              "SingerId: %d, FullName: %s\n",
              // The aliases are double-quoted and therefore retains their mixed case.
              singers.getLong("SingerId"), singers.getString("FullName"));
        }
      }

      // DML statements must also follow the PostgreSQL case rules.
      client
          .readWriteTransaction()
          .run(
              transaction ->
                  transaction.executeUpdate(
                      Statement.newBuilder(
                              "INSERT INTO Singers (SingerId, \"FirstName\", \"LastName\") "
                                  + "VALUES ($1, $2, $3)")
                          .bind("p1")
                          .to(2L)
                          .bind("p2")
                          .to("Alice")
                          .bind("p3")
                          .to("Bruxelles")
                          .build()));
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
// [END spanner_postgresql_identifier_case_sensitivity]