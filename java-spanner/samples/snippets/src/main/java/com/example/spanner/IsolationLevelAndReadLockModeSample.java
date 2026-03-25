/*
 * Copyright 2026 Google LLC
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

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Options;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.Builder.DefaultReadWriteTransactionOptions;
import com.google.cloud.spanner.Statement;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;

public class IsolationLevelAndReadLockModeSample {

  // [START spanner_isolation_level]
  static void isolationLevelSetting(DatabaseId db) {
    // The isolation level specified at the client-level will be applied to all
    // RW transactions.
    DefaultReadWriteTransactionOptions transactionOptions =
        DefaultReadWriteTransactionOptions.newBuilder()
            .setIsolationLevel(IsolationLevel.SERIALIZABLE)
            .build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setDefaultTransactionOptions(transactionOptions)
            .build();
    Spanner spanner = options.getService();
    DatabaseClient dbClient = spanner.getDatabaseClient(db);
    dbClient
        // The isolation level specified at the transaction-level takes precedence
        // over the isolation level configured at the client-level.
        .readWriteTransaction(Options.isolationLevel(IsolationLevel.REPEATABLE_READ))
        .run(transaction -> {
          // Read an AlbumTitle.
          String selectSql =
              "SELECT AlbumTitle from Albums WHERE SingerId = 1 and AlbumId = 1";
          String title = null;
          try (ResultSet resultSet = transaction.executeQuery(Statement.of(selectSql))) {
            if (resultSet.next()) {
              title = resultSet.getString("AlbumTitle");
            }
          }
          System.out.printf("Current album title: %s\n", title);

          // Update the title.
          String updateSql =
              "UPDATE Albums "
                  + "SET AlbumTitle = 'New Album Title' "
                  + "WHERE SingerId = 1 and AlbumId = 1";
          long rowCount = transaction.executeUpdate(Statement.of(updateSql));
          System.out.printf("%d record updated.\n", rowCount);
          return null;
        });
  }
  // [END spanner_isolation_level]

  // [START spanner_read_lock_mode]
  static void readLockModeSetting(DatabaseId db) {
    // The read lock mode specified at the client-level will be applied to all
    // RW transactions.
    DefaultReadWriteTransactionOptions transactionOptions =
        DefaultReadWriteTransactionOptions.newBuilder()
            .setReadLockMode(ReadLockMode.OPTIMISTIC)
            .build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setDefaultTransactionOptions(transactionOptions)
            .build();
    Spanner spanner = options.getService();
    DatabaseClient dbClient = spanner.getDatabaseClient(db);
    dbClient
        // The read lock mode specified at the transaction-level takes precedence
        // over the read lock mode configured at the client-level.
        .readWriteTransaction(Options.readLockMode(ReadLockMode.PESSIMISTIC))
        .run(transaction -> {
          // Read an AlbumTitle.
          String selectSql =
              "SELECT AlbumTitle from Albums WHERE SingerId = 1 and AlbumId = 1";
          String title = null;
          try (ResultSet resultSet = transaction.executeQuery(Statement.of(selectSql))) {
            if (resultSet.next()) {
              title = resultSet.getString("AlbumTitle");
            }
          }
          System.out.printf("Current album title: %s\n", title);

          // Update the title.
          String updateSql =
              "UPDATE Albums "
                  + "SET AlbumTitle = 'New Album Title' "
                  + "WHERE SingerId = 1 and AlbumId = 1";
          long rowCount = transaction.executeUpdate(Statement.of(updateSql));
          System.out.printf("%d record updated.\n", rowCount);
          return null;
        });
  }
  // [END spanner_read_lock_mode]
}