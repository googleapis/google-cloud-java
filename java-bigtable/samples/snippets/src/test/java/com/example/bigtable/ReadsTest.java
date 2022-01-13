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

import java.io.IOException;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ReadsTest extends MobileTimeSeriesBaseTest {

  @BeforeClass
  public static void beforeClass() throws IOException {
    initializeVariables();
    createTable();
    writeStatsData();
  }

  @AfterClass
  public static void afterClass() throws IOException {
    cleanupTable();
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
