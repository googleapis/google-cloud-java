/*
 * Copyright 2022 Google LLC
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

package com.example.bigtable;

import com.google.api.core.ApiFuture;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class KeySalting {
  private static final String COLUMN_FAMILY_NAME = "stats_summary";
  public static final int SALT_RANGE = 4;

  public static void writeSaltedRow(
      String projectId, String instanceId, String tableId, String rowKey) throws IOException {
    BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId);
    String saltedRowKey = getSaltedRowKey(rowKey, SALT_RANGE);
    RowMutation rowMutation =
        RowMutation.create(tableId, saltedRowKey)
            .setCell(COLUMN_FAMILY_NAME, "os_build", "PQ2A.190405.003");

    dataClient.mutateRow(rowMutation);
    System.out.printf("Successfully wrote row %s as %s\n", rowKey, saltedRowKey);

    dataClient.close();
  }

  public static void readSaltedRow(
      String projectId, String instanceId, String tableId, String rowKey) throws IOException {
    BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId);
    Row row = dataClient.readRow(tableId, getSaltedRowKey(rowKey, SALT_RANGE));
    System.out.printf("Successfully read row %s\n", row.getKey().toStringUtf8());
  }

  public static void scanSaltedRows(
      String projectId, String instanceId, String tableId, String prefix)
      throws IOException, ExecutionException, InterruptedException {
    BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId);

    List<Query> queries = new ArrayList<>();
    for (int i = 0; i < SALT_RANGE; i++) {
      queries.add(Query.create(tableId).prefix(i + "-" + prefix));
    }

    List<ApiFuture<List<Row>>> futures = new ArrayList<>();
    for (Query q : queries) {
      futures.add(dataClient.readRowsCallable().all().futureCall(q));
    }

    List<Row> rows = new ArrayList<>();
    for (ApiFuture<List<Row>> future : futures) {
      rows.addAll(future.get());
    }

    System.out.printf("Successfully fetched %s rows\n", rows.size());
    for (Row row : rows) {
      System.out.printf("Successfully read row %s\n", row.getKey().toStringUtf8());
    }
  }

  /**
   * Generates a salted version of the row key.
   *
   * <p>Some Bigtable schema designs will always have hot spots, and a salted row key breaks up
   * individual rows and groups of rows that are hot. Row keys are stored in sorted order, so
   * prepending a numeric prefix allows those hot rows to be stored in different locations.
   *
   * <p>The salted row key is created by hashing the existing row key and taking a modulo of how
   * large a prefix range you want to create; then prepending the existing row key with that result.
   * This produces a deterministic output, so each row key will always produce the same salted key.
   */
  public static String getSaltedRowKey(String rowKey, int saltRange) {
    int prefix = rowKey.hashCode() % saltRange;
    return prefix + "-" + rowKey;
  }
}
