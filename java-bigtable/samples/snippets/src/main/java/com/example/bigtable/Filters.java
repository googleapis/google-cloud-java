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

// [START bigtable_filters_print]

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import java.io.IOException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;


public class Filters {

  // Write your code here.
  // [START_EXCLUDE]
  // [START bigtable_filters_limit_row_sample]
  public static void filterLimitRowSample() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitRowSample(projectId, instanceId, tableId);
  }

  public static void filterLimitRowSample(String projectId, String instanceId, String tableId) {
    // A filter that matches cells from a row with probability .75
    Filter filter = FILTERS.key().sample(.75);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_row_sample]

  // [START bigtable_filters_limit_row_regex]
  public static void filterLimitRowRegex() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitRowRegex(projectId, instanceId, tableId);
  }

  public static void filterLimitRowRegex(String projectId, String instanceId, String tableId) {
    // A filter that matches cells from rows whose keys satisfy the given regex
    Filter filter = FILTERS.key().regex(".*#20190501$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_row_regex]

  // [START bigtable_filters_limit_cells_per_col]
  public static void filterLimitCellsPerCol() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitCellsPerCol(projectId, instanceId, tableId);
  }

  public static void filterLimitCellsPerCol(String projectId, String instanceId, String tableId) {
    // A filter that matches only the most recent 2 cells within each column
    Filter filter = FILTERS.limit().cellsPerColumn(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_col]

  // [START bigtable_filters_limit_cells_per_row]
  public static void filterLimitCellsPerRow() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitCellsPerRow(projectId, instanceId, tableId);
  }

  public static void filterLimitCellsPerRow(String projectId, String instanceId, String tableId) {
    // A filter that matches the first 2 cells of each row
    Filter filter = FILTERS.limit().cellsPerRow(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_row]

  // [START bigtable_filters_limit_cells_per_row_offset]
  public static void filterLimitCellsPerRowOffset() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitCellsPerRowOffset(projectId, instanceId, tableId);
  }

  public static void filterLimitCellsPerRowOffset(
      String projectId, String instanceId, String tableId) {
    // A filter that skips the first 2 cells per row
    Filter filter = FILTERS.offset().cellsPerRow(2);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_cells_per_row_offset]

  // [START bigtable_filters_limit_col_family_regex]
  public static void filterLimitColFamilyRegex() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitColFamilyRegex(projectId, instanceId, tableId);
  }

  public static void filterLimitColFamilyRegex(
      String projectId, String instanceId, String tableId) {
    // A filter that matches cells whose column family satisfies the given regex
    Filter filter = FILTERS.family().regex("stats_.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_family_regex]

  // [START bigtable_filters_limit_col_qualifier_regex]
  public static void filterLimitColQualifierRegex() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitColQualifierRegex(projectId, instanceId, tableId);
  }

  public static void filterLimitColQualifierRegex(
      String projectId, String instanceId, String tableId) {
    // A filter that matches cells whose column qualifier satisfies the given regex
    Filter filter = FILTERS.qualifier().regex("connected_.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_qualifier_regex]

  // [START bigtable_filters_limit_col_range]
  public static void filterLimitColRange() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitColRange(projectId, instanceId, tableId);
  }

  public static void filterLimitColRange(String projectId, String instanceId, String tableId) {
    // A filter that matches cells whose column qualifiers are between data_plan_01gb and
    // data_plan_10gb in the column family cell_plan
    Filter filter =
        FILTERS
            .qualifier()
            .rangeWithinFamily("cell_plan")
            .startClosed("data_plan_01gb")
            .endOpen("data_plan_10gb");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_col_range]

  // [START bigtable_filters_limit_value_range]
  public static void filterLimitValueRange() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitValueRange(projectId, instanceId, tableId);
  }

  public static void filterLimitValueRange(String projectId, String instanceId, String tableId) {
    // A filter that matches cells whose values are between the given values
    Filter filter = FILTERS.value().range().startClosed("PQ2A.190405").endClosed("PQ2A.190406");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_value_range]

  // [START bigtable_filters_limit_value_regex]
  public static void filterLimitValueRegex() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitValueRegex(projectId, instanceId, tableId);
  }

  public static void filterLimitValueRegex(String projectId, String instanceId, String tableId) {
    // A filter that matches cells whose value satisfies the given regex
    Filter filter = FILTERS.value().regex("PQ2A.*$");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_value_regex]

  // [START bigtable_filters_limit_timestamp_range]
  public static void filterLimitTimestampRange() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitTimestampRange(projectId, instanceId, tableId);
  }

  public static void filterLimitTimestampRange(
      String projectId, String instanceId, String tableId) {
    // Get a time representing one hour ago
    long timestamp = Instant.now().minus(1, ChronoUnit.HOURS).toEpochMilli() * 1000;

    // A filter that matches cells whose timestamp is from an hour ago or earlier
    Filter filter = FILTERS.timestamp().range().startClosed(0L).endOpen(timestamp);
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_timestamp_range]

  // [START bigtable_filters_limit_block_all]
  public static void filterLimitBlockAll() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitBlockAll(projectId, instanceId, tableId);
  }

  public static void filterLimitBlockAll(String projectId, String instanceId, String tableId) {
    // A filter that does not match any cells
    Filter filter = FILTERS.block();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_block_all]

  // [START bigtable_filters_limit_pass_all]
  public static void filterLimitPassAll() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterLimitPassAll(projectId, instanceId, tableId);
  }

  public static void filterLimitPassAll(String projectId, String instanceId, String tableId) {
    // A filter that matches all cells
    Filter filter = FILTERS.pass();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_limit_pass_all]

  // [START bigtable_filters_modify_strip_value]
  public static void filterModifyStripValue() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterModifyStripValue(projectId, instanceId, tableId);
  }

  public static void filterModifyStripValue(String projectId, String instanceId, String tableId) {
    // A filter that replaces the outputted cell value with the empty string
    Filter filter = FILTERS.value().strip();
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_modify_strip_value]

  // [START bigtable_filters_modify_apply_label]
  public static void filterModifyApplyLabel() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterModifyApplyLabel(projectId, instanceId, tableId);
  }

  public static void filterModifyApplyLabel(String projectId, String instanceId, String tableId) {
    // A filter that applies the given label to the outputted cell
    Filter filter = FILTERS.label("labelled");
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_modify_apply_label]

  // [START bigtable_filters_composing_chain]
  public static void filterComposingChain() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterComposingChain(projectId, instanceId, tableId);
  }

  public static void filterComposingChain(String projectId, String instanceId, String tableId) {
    // A filter that selects one cell per column AND within the column family cell_plan
    Filter filter =
        FILTERS
            .chain()
            .filter(FILTERS.limit().cellsPerColumn(1))
            .filter(FILTERS.family().exactMatch("cell_plan"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_chain]

  // [START bigtable_filters_composing_interleave]
  public static void filterComposingInterleave() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterComposingInterleave(projectId, instanceId, tableId);
  }

  public static void filterComposingInterleave(
      String projectId, String instanceId, String tableId) {
    // A filter that matches cells with the value true OR with the column qualifier os_build
    Filter filter =
        FILTERS
            .interleave()
            .filter(FILTERS.value().exactMatch("true"))
            .filter(FILTERS.qualifier().exactMatch("os_build"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_interleave]

  // [START bigtable_filters_composing_condition]
  public static void filterComposingCondition() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    filterComposingCondition(projectId, instanceId, tableId);
  }

  public static void filterComposingCondition(String projectId, String instanceId, String tableId) {
    // A filter that applies the label passed-filter IF the cell has the column qualifier
    // data_plan_10gb AND the value true, OTHERWISE applies the label filtered-out
    Filter filter =
        FILTERS
            .condition(
                FILTERS
                    .chain()
                    .filter(FILTERS.qualifier().exactMatch("data_plan_10gb"))
                    .filter(FILTERS.value().exactMatch("true")))
            .then(FILTERS.label("passed-filter"))
            .otherwise(FILTERS.label("filtered-out"));
    readFilter(projectId, instanceId, tableId, filter);
  }
  // [END bigtable_filters_composing_condition]
  // [END_EXCLUDE]

  private static void readFilter(
      String projectId, String instanceId, String tableId, Filter filter) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query = Query.create(tableId).filter(filter);
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }
    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }

  private static void printRow(Row row) {
    System.out.printf("Reading data for %s%n", row.getKey().toStringUtf8());
    String colFamily = "";
    for (RowCell cell : row.getCells()) {
      if (!cell.getFamily().equals(colFamily)) {
        colFamily = cell.getFamily();
        System.out.printf("Column Family %s%n", colFamily);
      }
      String labels =
          cell.getLabels().size() == 0 ? "" : " [" + String.join(",", cell.getLabels()) + "]";
      System.out.printf(
          "\t%s: %s @%s%s%n",
          cell.getQualifier().toStringUtf8(),
          cell.getValue().toStringUtf8(),
          cell.getTimestamp(),
          labels);
    }
    System.out.println();
  }
}
// [END bigtable_filters_print]
