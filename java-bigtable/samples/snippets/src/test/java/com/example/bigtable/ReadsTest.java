/*
 * Copyright 2019 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ReadsTest {

  private static final String INSTANCE_ENV = "BIGTABLE_TESTING_INSTANCE";
  private static final String TABLE_ID =
      "mobile-time-series-" + UUID.randomUUID().toString().substring(0, 20);
  private static final String COLUMN_FAMILY_NAME = "stats_summary";
  private static final long TIMESTAMP = System.currentTimeMillis() * 1000;

  private static String projectId;
  private static String instanceId;
  private ByteArrayOutputStream bout;

  private static String requireEnv(String varName) {
    String value = System.getenv(varName);
    assertNotNull(String.format("Environment variable '%s' is required to perform these tests.", varName), value);
    return value;
  }

  @BeforeClass
  public static void beforeClass() throws IOException {
    projectId = requireEnv("GOOGLE_CLOUD_PROJECT");
    instanceId = requireEnv(INSTANCE_ENV);

    try (BigtableTableAdminClient adminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID).addFamily(COLUMN_FAMILY_NAME);
      adminClient.createTable(createTableRequest);

      try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
        BulkMutation bulkMutation =
            BulkMutation.create(TABLE_ID)
                .add(
                    "phone#4c410523#20190501",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME, "os_build", TIMESTAMP, "PQ2A.190405.003"))
                .add(
                    "phone#4c410523#20190502",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME, "os_build", TIMESTAMP, "PQ2A.190405.004"))
                .add(
                    "phone#4c410523#20190505",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            0)
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME, "os_build", TIMESTAMP, "PQ2A.190406.000"))
                .add(
                    "phone#5c10102#20190501",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME, "os_build", TIMESTAMP, "PQ2A.190401.002"))
                .add(
                    "phone#5c10102#20190502",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            0)
                        .setCell(COLUMN_FAMILY_NAME, "os_build", TIMESTAMP, "PQ2A.190406.000"));

        dataClient.bulkMutateRows(bulkMutation);
      }
    } catch (Exception e) {
      System.out.println("Error during beforeClass: \n" + e.toString());
      throw (e);
    }
  }

  @Before
  public void setupStream() {
    bout = new ByteArrayOutputStream();
    System.setOut(new PrintStream(bout));
  }

  @AfterClass
  public static void afterClass() throws IOException {
    try (BigtableTableAdminClient adminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      adminClient.deleteTable(TABLE_ID);
    } catch (Exception e) {
      System.out.println("Error during afterClass: \n" + e.toString());
      throw (e);
    }
  }

  @Test
  public void testReadRow() {
    Reads.readRow(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadRowPartial() {
    Reads.readRowPartial(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadRows() {
    Reads.readRows(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadRowRange() {
    Reads.readRowRange(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadRowRanges() {
    Reads.readRowRanges(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadPrefix() {
    Reads.readPrefix(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testReadFilter() {
    Reads.readFilter(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP));
  }
}
