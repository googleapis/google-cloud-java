/*
 * Copyright 2021 Google LLC
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


import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.Mutation;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class MobileTimeSeriesBaseTest extends BigtableBaseTest {

  public static final String TABLE_ID = generateTableId("mobile-time-series");
  public static final String COLUMN_FAMILY_NAME_STATS = "stats_summary";
  public static final String COLUMN_FAMILY_NAME_PLAN = "cell_plan";
  public static final Instant CURRENT_TIME = Instant.now();
  public static final long TIMESTAMP = CURRENT_TIME.toEpochMilli() * 1000;
  public static final long TIMESTAMP_MINUS_HR =
      CURRENT_TIME.minus(1, ChronoUnit.HOURS).toEpochMilli() * 1000;


  public static void createTable() throws IOException {
    try (BigtableTableAdminClient adminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID)
              .addFamily(COLUMN_FAMILY_NAME_STATS)
              .addFamily(COLUMN_FAMILY_NAME_PLAN);
      adminClient.createTable(createTableRequest);
    } catch (IOException e) {
      System.out.println("Error during createTable: \n" + e.toString());
      throw (e);
    }
  }


  public static void writeStatsData() throws IOException {
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
                      .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190405.003"))
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
              )
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
              )
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
              )
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
                      .setCell(COLUMN_FAMILY_NAME_STATS, "os_build", TIMESTAMP, "PQ2A.190406.000"));

      dataClient.bulkMutateRows(bulkMutation);
    } catch (IOException e) {
      System.out.println("Error during writeTestData: \n" + e.toString());
      throw (e);
    }
  }

  public static void writePlanData() throws IOException {
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      BulkMutation bulkMutation =
          BulkMutation.create(TABLE_ID)
              .add(
                  "phone#4c410523#20190501",
                  Mutation.create()
                      .setCell(
                          COLUMN_FAMILY_NAME_PLAN, "data_plan_01gb", TIMESTAMP_MINUS_HR, "true")
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_01gb", TIMESTAMP, "false")
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_05gb", TIMESTAMP, "true"))
              .add(
                  "phone#4c410523#20190502",
                  Mutation.create()
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_05gb", TIMESTAMP, "true"))
              .add(
                  "phone#4c410523#20190505",
                  Mutation.create()
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_05gb", TIMESTAMP, "true"))
              .add(
                  "phone#5c10102#20190501",
                  Mutation.create()
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_10gb", TIMESTAMP, "true"))
              .add(
                  "phone#5c10102#20190502",
                  Mutation.create()
                      .setCell(COLUMN_FAMILY_NAME_PLAN, "data_plan_10gb", TIMESTAMP, "true"));

      dataClient.bulkMutateRows(bulkMutation);
    } catch (IOException e) {
      System.out.println("Error during writeTestData: \n" + e.toString());
      throw (e);
    }
  }


  public static void cleanupTable() throws IOException {
    try (BigtableTableAdminClient adminClient =
        BigtableTableAdminClient.create(projectId, instanceId)) {
      adminClient.deleteTable(TABLE_ID);
    } catch (Exception e) {
      System.out.println("Error during afterClass: \n" + e.toString());
      throw (e);
    }
  }

}
