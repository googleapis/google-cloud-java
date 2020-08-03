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
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.UUID;
import java.util.logging.Filter;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

public class FiltersTest {

  private static final String INSTANCE_ENV = "BIGTABLE_TESTING_INSTANCE";
  private static final String TABLE_ID =
      "mobile-time-series-" + UUID.randomUUID().toString().substring(0, 20);
  private static final String COLUMN_FAMILY_NAME_STATS = "stats_summary";
  private static final String COLUMN_FAMILY_NAME_DATA = "cell_plan";
  private static final Instant CURRENT_TIME = Instant.now();
  private static final long TIMESTAMP = CURRENT_TIME.toEpochMilli() * 1000;
  private static final long TIMESTAMP_MINUS_HR =
      CURRENT_TIME.minus(1, ChronoUnit.HOURS).toEpochMilli() * 1000;

  private static String projectId;
  private static String instanceId;
  private ByteArrayOutputStream bout;

  private static String requireEnv(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        String.format("Environment variable '%s' is required to perform these tests.", varName),
        value);
    return value;
  }

  @BeforeClass
  public static void beforeClass() throws IOException {
    projectId = requireEnv("GOOGLE_CLOUD_PROJECT");
    instanceId = requireEnv(INSTANCE_ENV);

    try (BigtableTableAdminClient adminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID)
              .addFamily(COLUMN_FAMILY_NAME_STATS)
              .addFamily(COLUMN_FAMILY_NAME_DATA);
      adminClient.createTable(createTableRequest);

      try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
        BulkMutation bulkMutation =
            BulkMutation.create(TABLE_ID)
                .add(
                    "phone#4c410523#20190501",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190405.003")
                        .setCell(
                            COLUMN_FAMILY_NAME_DATA, "data_plan_01gb", TIMESTAMP_MINUS_HR, "true")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_01gb", TIMESTAMP, "false")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_05gb", TIMESTAMP, "true"))
                .add(
                    "phone#4c410523#20190502",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190405.004")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_05gb", TIMESTAMP, "true"))
                .add(
                    "phone#4c410523#20190505",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            0)
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190406.000")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_05gb", TIMESTAMP, "true"))
                .add(
                    "phone#5c10102#20190501",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190401.002")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_10gb", TIMESTAMP, "true"))
                .add(
                    "phone#5c10102#20190502",
                    Mutation.create()
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_cell".getBytes()),
                            TIMESTAMP,
                            1)
                        .setCell(
                            COLUMN_FAMILY_NAME_STATS,
                            ByteString.copyFrom("connected_wifi".getBytes()),
                            TIMESTAMP,
                            0)
                        .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190406.000")
                        .setCell(COLUMN_FAMILY_NAME_DATA, "data_plan_10gb", TIMESTAMP, "true"));

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
  public void testFilterRowSample() {
    Filters.filterLimitRowSample(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output).contains("Reading data for");
  }

  @Test
  public void testFilterRowRegex() {
    Filters.filterLimitRowRegex(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_01gb: true @%2$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterCellsPerCol() {
    Filters.filterLimitCellsPerCol(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_01gb: true @%2$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterCellsPerRow() {
    Filters.filterLimitCellsPerRow(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_01gb: true @%2$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterLimitCellsPerRowOffset() {
    Filters.filterLimitCellsPerRowOffset(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testFilterColFamilyRegex() {
    Filters.filterLimitColFamilyRegex(projectId, instanceId, TABLE_ID);

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
  public void testFilterColQualifierRegex() {
    Filters.filterLimitColQualifierRegex(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testFilterColRange() {
    Filters.filterLimitColRange(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_01gb: true @%2$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterValueRange() {
    Filters.filterLimitValueRange(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s",
                TIMESTAMP));
  }

  @Test
  public void testFilterValueRegex() {
    Filters.filterLimitValueRegex(projectId, instanceId, TABLE_ID);

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

  @Test
  public void testFilterTimestampRange() {
    Filters.filterLimitTimestampRange(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: true @%s\n",
                TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterBlockAll() {
    Filters.filterLimitBlockAll(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output).doesNotContain("Reading data for");
  }

  @Test
  public void testFilterPassAll() {
    Filters.filterLimitPassAll(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_01gb: true @%2$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterStripValue() {
    Filters.filterModifyStripValue(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb:  @%1$s\n"
                    + "\tdata_plan_01gb:  @%2$s\n"
                    + "\tdata_plan_05gb:  @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell:  @%1$s\n"
                    + "\tconnected_wifi:  @%1$s\n"
                    + "\tos_build:  @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb:  @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell:  @%1$s\n"
                    + "\tconnected_wifi:  @%1$s\n"
                    + "\tos_build:  @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb:  @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell:  @%1$s\n"
                    + "\tconnected_wifi:  @%1$s\n"
                    + "\tos_build:  @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb:  @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell:  @%1$s\n"
                    + "\tconnected_wifi:  @%1$s\n"
                    + "\tos_build:  @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb:  @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell:  @%1$s\n"
                    + "\tconnected_wifi:  @%1$s\n"
                    + "\tos_build:  @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterApplyLabel() {
    Filters.filterModifyApplyLabel(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s [labelled]\n"
                    + "\tdata_plan_01gb: true @%2$s [labelled]\n"
                    + "\tdata_plan_05gb: true @%1$s [labelled]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s [labelled]\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s [labelled]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s [labelled]\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s [labelled]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s "
                    + "[labelled]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s [labelled]\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s [labelled]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s [labelled]\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s [labelled]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[labelled]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s "
                    + "[labelled]\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s [labelled]",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterChain() {
    Filters.filterComposingChain(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n",
                TIMESTAMP));
  }

  @Test
  public void testFilterInterleave() {
    Filters.filterComposingInterleave(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: true @%2$s\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s\n"
                    + "Column Family stats_summary\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }

  @Test
  public void testFilterCondition() {
    Filters.filterComposingCondition(projectId, instanceId, TABLE_ID);

    String output = bout.toString();
    assertThat(output)
        .contains(
            String.format(
                "Reading data for phone#4c410523#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_01gb: false @%1$s [filtered-out]\n"
                    + "\tdata_plan_01gb: true @%2$s [filtered-out]\n"
                    + "\tdata_plan_05gb: true @%1$s [filtered-out]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[filtered-out]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[filtered-out]\n"
                    + "\tos_build: PQ2A.190405.003 @%1$s [filtered-out]\n\n"
                    + "Reading data for phone#4c410523#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s [filtered-out]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[filtered-out]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[filtered-out]\n"
                    + "\tos_build: PQ2A.190405.004 @%1$s [filtered-out]\n\n"
                    + "Reading data for phone#4c410523#20190505\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_05gb: true @%1$s [filtered-out]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s "
                    + "[filtered-out]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[filtered-out]\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s [filtered-out]\n\n"
                    + "Reading data for phone#5c10102#20190501\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s [passed-filter]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[passed-filter]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[passed-filter]\n"
                    + "\tos_build: PQ2A.190401.002 @%1$s [passed-filter]\n\n"
                    + "Reading data for phone#5c10102#20190502\n"
                    + "Column Family cell_plan\n"
                    + "\tdata_plan_10gb: true @%1$s [passed-filter]\n"
                    + "Column Family stats_summary\n"
                    + "\tconnected_cell: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0001 @%1$s "
                    + "[passed-filter]\n"
                    + "\tconnected_wifi: \u0000\u0000\u0000\u0000\u0000\u0000\u0000\u0000 @%1$s "
                    + "[passed-filter]\n"
                    + "\tos_build: PQ2A.190406.000 @%1$s [passed-filter]",
                TIMESTAMP, TIMESTAMP_MINUS_HR));
  }
}
