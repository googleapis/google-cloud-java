/*
 * Copyright 2020 Google LLC
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

package com.example.bigquery;

import static com.google.common.truth.Truth.assertThat;
import static junit.framework.TestCase.assertNotNull;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

@Ignore
public class QueryExternalBigtablePermIT {

  private final Logger log = Logger.getLogger(this.getClass().getName());
  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String TABLE_ID = "bigquery-samples-test" + ID;
  private static final String COLUMN_FAMILY_NAME = "stats_summary";
  private static final long TIMESTAMP = System.currentTimeMillis() * 1000;
  private static final String CONNECTED_CELL = "connected_cell";
  private static final String CONNECTED_WIFI = "connected_wifi";
  private static final String OS_BUILD = "os_build";
  private String tableName;
  private ByteArrayOutputStream bout;
  private PrintStream out;
  private PrintStream originalPrintStream;

  private static final String INSTANCE = requireEnvVar("BIGTABLE_TESTING_INSTANCE");
  private static final String PROJECT = requireEnvVar("SAMPLES_TESTING_PROJECT");
  private static final String BIGQUERY_DATASET_NAME = requireEnvVar("BIGQUERY_DATASET_NAME");

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("GOOGLE_CLOUD_PROJECT");
    requireEnvVar("BIGTABLE_TESTING_INSTANCE");
    requireEnvVar("BIGQUERY_DATASET_NAME");
  }

  @Before
  public void setUp() throws IOException {
    // Create a test table
    tableName = "EXTERNAL_TABLE_FROM_BIGTABLE_TEST_" + ID;
    bout = new ByteArrayOutputStream();
    out = new PrintStream(bout);
    originalPrintStream = System.out;
    System.setOut(out);

    // create a temporary bigtable table.
    try (BigtableTableAdminClient client = BigtableTableAdminClient.create(PROJECT, INSTANCE)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID).addFamily(COLUMN_FAMILY_NAME);
      client.createTable(createTableRequest);
    }
    // inserting temporary rows.
    try (BigtableDataClient client = BigtableDataClient.create(PROJECT, INSTANCE)) {
      BulkMutation bulkMutation =
          BulkMutation.create(TABLE_ID)
              .add(
                  "phone#4c410523#20190501",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_CELL.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_WIFI.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(COLUMN_FAMILY_NAME, OS_BUILD, TIMESTAMP, "PQ2A.190405.003"))
              .add(
                  "phone#4c410523#20190502",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_CELL.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_WIFI.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(COLUMN_FAMILY_NAME, OS_BUILD, TIMESTAMP, "PQ2A.190405.004"))
              .add(
                  "phone#4c410523#20190505",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_CELL.getBytes()),
                          TIMESTAMP,
                          0)
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_WIFI.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(COLUMN_FAMILY_NAME, OS_BUILD, TIMESTAMP, "PQ2A.190406.000"))
              .add(
                  "phone#5c10102#20190501",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_CELL.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_WIFI.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(COLUMN_FAMILY_NAME, OS_BUILD, TIMESTAMP, "PQ2A.190401.002"))
              .add(
                  "phone#5c10102#20190502",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_CELL.getBytes()),
                          TIMESTAMP,
                          1)
                      .setCell(
                          COLUMN_FAMILY_NAME,
                          ByteString.copyFrom(CONNECTED_WIFI.getBytes()),
                          TIMESTAMP,
                          0)
                      .setCell(COLUMN_FAMILY_NAME, OS_BUILD, TIMESTAMP, "PQ2A.190406.000"));

      client.bulkMutateRows(bulkMutation);
    }
  }

  @After
  public void tearDown() throws IOException {
    // Clean up
    try (BigtableTableAdminClient client = BigtableTableAdminClient.create(PROJECT, INSTANCE)) {
      client.deleteTable(TABLE_ID);
    }
    DeleteTable.deleteTable(BIGQUERY_DATASET_NAME, tableName);
    // restores print statements in the original method
    System.out.flush();
    System.setOut(originalPrintStream);
    log.log(Level.INFO, bout.toString());
  }

  @Test
  public void testQueryExternalBigtablePerm() {
    String query = String.format("SELECT * FROM %s.%s ", BIGQUERY_DATASET_NAME, tableName);
    String sourceUri =
        String.format(
            "https://googleapis.com/bigtable/projects/%s/instances/%s/tables/%s",
            PROJECT, INSTANCE, TABLE_ID);
    QueryExternalBigtablePerm.queryExternalBigtablePerm(
        BIGQUERY_DATASET_NAME, tableName, sourceUri, query);
    assertThat(bout.toString())
        .contains("Query on external permanent table performed successfully.");
  }
}
