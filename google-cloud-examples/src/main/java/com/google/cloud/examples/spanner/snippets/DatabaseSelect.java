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
 * This file is referenced in READMEs. Any change to this file should be reflected in
 * the project's READMEs.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.Statement;

/**
 * A quick start code for Cloud Spanner. It demonstrates how to setup the Cloud Spanner client and
 * execute a simple query using it against an existing database.
 */
public class DatabaseSelect {
  public static void main(String... args) throws Exception {

    if (args.length != 2) {
      System.err.println("Usage: QuickStartSample <instance_id> <database_id>");
      return;
    }
    // Instantiates a client
    SpannerOptions options = SpannerOptions.newBuilder().build();
    Spanner spanner = options.getService();

    // Name of your instance & database.
    String instanceId = args[0];
    String databaseId = args[1];
    try {
      // Creates a database client
      DatabaseClient dbClient =
          spanner.getDatabaseClient(DatabaseId.of(options.getProjectId(), instanceId, databaseId));
      // Queries the database
      try (ResultSet resultSet = dbClient.singleUse().executeQuery(Statement.of("SELECT 1"))) {
        System.out.println("\n\nResults:");
        // Prints the results
        while (resultSet.next()) {
          System.out.printf("%d\n\n", resultSet.getLong(0));
        }
      }
    } finally {
      // Closes the client which will free up the resources used
      spanner.close();
    }
  }
}
