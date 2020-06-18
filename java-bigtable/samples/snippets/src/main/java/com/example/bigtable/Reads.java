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

// [START bigtable_reads_print]

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.models.Filters;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.protobuf.ByteString;
import java.io.IOException;

public class Reads {

  // Write your code here.
  // [START_EXCLUDE]
  public static void readRow() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readRow(projectId, instanceId, tableId);
  }

  public static void readRow(String projectId, String instanceId, String tableId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      String rowkey = "phone#4c410523#20190501";

      Row row = dataClient.readRow(tableId, rowkey);
      printRow(row);

    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_row]

  // [START bigtable_reads_row_partial]
  public static void readRowPartial() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readRowPartial(projectId, instanceId, tableId);
  }

  public static void readRowPartial(String projectId, String instanceId, String tableId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      String rowkey = "phone#4c410523#20190501";
      Filters.Filter filter =
          FILTERS
              .chain()
              .filter(FILTERS.family().exactMatch("stats_summary"))
              .filter(FILTERS.qualifier().exactMatch("os_build"));

      Row row = dataClient.readRow(tableId, rowkey, filter);
      printRow(row);

    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_row_partial]

  // [START bigtable_reads_rows]
  public static void readRows() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readRows(projectId, instanceId, tableId);
  }

  public static void readRows(String projectId, String instanceId, String tableId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query =
          Query.create(tableId).rowKey("phone#4c410523#20190501").rowKey("phone#4c410523#20190502");
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }
    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_rows]

  // [START bigtable_reads_row_range]
  public static void readRowRange() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readRowRange(projectId, instanceId, tableId);
  }

  public static void readRowRange(String projectId, String instanceId, String tableId) {
    String start = "phone#4c410523#20190501";
    String end = "phone#4c410523#201906201";

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query = Query.create(tableId).range(start, end);
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }
    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_row_range]

  // [START bigtable_reads_row_ranges]
  public static void readRowRanges() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readRowRanges(projectId, instanceId, tableId);
  }

  public static void readRowRanges(String projectId, String instanceId, String tableId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query =
          Query.create(tableId)
              .range("phone#4c410523#20190501", "phone#4c410523#20190601")
              .range("phone#5c10102#20190501", "phone#5c10102#20190601");
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }
    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_row_ranges]

  // [START bigtable_reads_prefix]
  public static void readPrefix() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readPrefix(projectId, instanceId, tableId);
  }

  public static void readPrefix(String projectId, String instanceId, String tableId) {
    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(projectId, instanceId)) {
      Query query = Query.create(tableId).prefix("phone");
      ServerStream<Row> rows = dataClient.readRows(query);
      for (Row row : rows) {
        printRow(row);
      }
    } catch (IOException e) {
      System.out.println(
          "Unable to initialize service client, as a network error occurred: \n" + e.toString());
    }
  }
  // [END bigtable_reads_prefix]

  // [START bigtable_reads_filter]
  public static void readFilter() {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "my-project-id";
    String instanceId = "my-instance-id";
    String tableId = "mobile-time-series";
    readFilter(projectId, instanceId, tableId);
  }

  public static void readFilter(String projectId, String instanceId, String tableId) {
    Filters.Filter filter = FILTERS.value().regex("PQ2A.*");

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
  // [END bigtable_reads_filter]
  // [END_EXCLUDE]

  private static void printRow(Row row) {
    System.out.printf("Reading data for %s%n", row.getKey().toStringUtf8());
    String colFamily = "";
    for (RowCell cell : row.getCells()) {
      if (!cell.getFamily().equals(colFamily)) {
        colFamily = cell.getFamily();
        System.out.printf("Column Family %s%n", colFamily);
      }
      System.out.printf(
          "\t%s: %s @%s%n",
          cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8(), cell.getTimestamp());
    }
    System.out.println();
  }
}
// [END bigtable_reads_print]
