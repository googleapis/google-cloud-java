/*
 * Copyright 2018 Google LLC
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
 * This file is referenced in spanner/ReadContext's javadoc. Any change
 * to this file should be reflected in spanner/ReadContext's javadoc.
 */

package com.google.cloud.examples.spanner.snippets;

import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.ReadContext;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.Struct;
import com.google.spanner.v1.ResultSetStats;
import java.util.Arrays;

/** This class contains snippets for {@link com.google.cloud.spanner.ReadContext} interface. */
public class ReadContextSnippets {
  private final DatabaseClient dbClient;

  public ReadContextSnippets(DatabaseClient dbClient) {
    this.dbClient = dbClient;
  }

  ResultSet read() {
    // [START read_context_read]
    ReadContext readContext = dbClient.singleUse();
    ResultSet resultSet =
        readContext.read(
            "Albums",
            // KeySet.all() can be used to read all rows in a table. KeySet exposes other
            // methods to read only a subset of the table.
            KeySet.all(),
            Arrays.asList("SingerId", "AlbumId", "AlbumTitle"));
    // [END read_context_read]

    return resultSet;
  }

  ResultSet readUsingIndex() {
    // [START read_context_read_index]
    ReadContext readContext = dbClient.singleUse();
    ResultSet resultSet =
        readContext.readUsingIndex(
            "Albums", "AlbumsByAlbumTitle", KeySet.all(), Arrays.asList("AlbumId", "AlbumTitle"));
    // [END read_context_read_index]

    return resultSet;
  }

  Struct readRow() {
    // [START read_context_read_row]
    ReadContext readContext = dbClient.singleUse();
    Struct row = readContext.readRow("Albums", Key.of(2, 1), Arrays.asList("MarketingBudget"));
    // [END read_context_read_row]

    return row;
  }

  Struct readRowUsingIndex() {
    // [START read_context_read_index]
    ReadContext readContext = dbClient.singleUse();
    Struct row =
        readContext.readRowUsingIndex(
            "Albums",
            "AlbumsByAlbumId",
            Key.of(1, "Green"),
            Arrays.asList("AlbumId", "AlbumTitle"));
    // [END read_context_read_index]

    return row;
  }

  ResultSet executeQuery() {
    // [START read_context_execute_query]
    // Rows without an explicit value for MarketingBudget will have a MarketingBudget equal to
    // null.
    ReadContext readContext = dbClient.singleUse();
    ResultSet resultSet =
        readContext.executeQuery(
            Statement.of("SELECT SingerId, AlbumId, MarketingBudget, LastUpdateTime FROM Albums"));
    // [END read_context_execute_query]
    return resultSet;
  }

  ResultSetStats analyzeQuery() {
    // [START read_context_analyze_query]
    ReadContext rc = dbClient.singleUse();
    ResultSet resultSet =
        rc.analyzeQuery(
            Statement.of("SELECT SingerId, AlbumId, MarketingBudget FROM Albums"),
            ReadContext.QueryAnalyzeMode.PROFILE);
    while (resultSet.next()) {
      // Discard the results. We're only processing because getStats() below requires it.
      resultSet.getCurrentRowAsStruct();
    }
    ResultSetStats stats = resultSet.getStats();
    // [END read_context_analyze_query]
    return stats;
  }
}
