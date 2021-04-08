/*
 * Copyright 2019 Google Inc.
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

// [START bigtable_hw_imports]
import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// [END bigtable_hw_imports]

/**
 * An example of using Google Cloud Bigtable.
 *
 * <p>This example is a very simple "hello world" application, that illustrates how to create a new
 * table, write to the table, read the data back, and delete the table.
 *
 * <ul>
 *   <li>create table
 *   <li>read single row
 *   <li>read table
 *   <li>delete table
 * </ul>
 */
public class HelloWorld {

  private static final String COLUMN_FAMILY = "cf1";
  private static final String COLUMN_QUALIFIER_GREETING = "greeting";
  private static final String COLUMN_QUALIFIER_NAME = "name";
  private static final String ROW_KEY_PREFIX = "rowKey";
  private final String tableId;
  private final BigtableDataClient dataClient;
  private final BigtableTableAdminClient adminClient;

  public static void main(String[] args) throws Exception {

    if (args.length != 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }
    String projectId = args[0];
    String instanceId = args[1];

    HelloWorld helloWorld = new HelloWorld(projectId, instanceId, "test-table");
    helloWorld.run();
  }

  public HelloWorld(String projectId, String instanceId, String tableId) throws IOException {
    this.tableId = tableId;

    // [START bigtable_hw_connect]
    // Creates the settings to configure a bigtable data client.
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId).build();

    // Creates a bigtable data client.
    dataClient = BigtableDataClient.create(settings);

    // Creates the settings to configure a bigtable table admin client.
    BigtableTableAdminSettings adminSettings =
        BigtableTableAdminSettings.newBuilder()
            .setProjectId(projectId)
            .setInstanceId(instanceId)
            .build();

    // Creates a bigtable table admin client.
    adminClient = BigtableTableAdminClient.create(adminSettings);
    // [END bigtable_hw_connect]
  }

  public void run() throws Exception {
    createTable();
    writeToTable();
    readSingleRow();
    readSpecificCells();
    readTable();
    deleteTable();
    close();
  }

  public void close() {
    dataClient.close();
    adminClient.close();
  }

  /** Demonstrates how to create a table. */
  public void createTable() {
    // [START bigtable_hw_create_table]
    // Checks if table exists, creates table if does not exist.
    if (!adminClient.exists(tableId)) {
      System.out.println("Creating table: " + tableId);
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(tableId).addFamily(COLUMN_FAMILY);
      adminClient.createTable(createTableRequest);
      System.out.printf("Table %s created successfully%n", tableId);
    }
    // [END bigtable_hw_create_table]
  }

  /** Demonstrates how to write some rows to a table. */
  public void writeToTable() {
    // [START bigtable_hw_write_rows]
    try {
      System.out.println("\nWriting some greetings to the table");
      String[] names = {"World", "Bigtable", "Java"};
      for (int i = 0; i < names.length; i++) {
        String greeting = "Hello " + names[i] + "!";
        RowMutation rowMutation =
            RowMutation.create(tableId, ROW_KEY_PREFIX + i)
                .setCell(COLUMN_FAMILY, COLUMN_QUALIFIER_NAME, names[i])
                .setCell(COLUMN_FAMILY, COLUMN_QUALIFIER_GREETING, greeting);
        dataClient.mutateRow(rowMutation);
        System.out.println(greeting);
      }
    } catch (NotFoundException e) {
      System.err.println("Failed to write to non-existent table: " + e.getMessage());
    }
    // [END bigtable_hw_write_rows]
  }

  /** Demonstrates how to read a single row from a table. */
  public Row readSingleRow() {
    // [START bigtable_hw_get_by_key]
    try {
      System.out.println("\nReading a single row by row key");
      Row row = dataClient.readRow(tableId, ROW_KEY_PREFIX + 0);
      System.out.println("Row: " + row.getKey().toStringUtf8());
      for (RowCell cell : row.getCells()) {
        System.out.printf(
            "Family: %s    Qualifier: %s    Value: %s%n",
            cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
      }
      return row;
    } catch (NotFoundException e) {
      System.err.println("Failed to read from a non-existent table: " + e.getMessage());
      return null;
    }
    // [END bigtable_hw_get_by_key]
  }

  /** Demonstrates how to access specific cells by family and qualifier. */
  public List<RowCell> readSpecificCells() {
    // [START bigtable_hw_get_by_key]
    try {
      System.out.println("\nReading specific cells by family and qualifier");
      Row row = dataClient.readRow(tableId, ROW_KEY_PREFIX + 0);
      System.out.println("Row: " + row.getKey().toStringUtf8());
      List<RowCell> cells = row.getCells(COLUMN_FAMILY, COLUMN_QUALIFIER_NAME);
      for (RowCell cell : cells) {
        System.out.printf(
            "Family: %s    Qualifier: %s    Value: %s%n",
            cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
      }
      return cells;
    } catch (NotFoundException e) {
      System.err.println("Failed to read from a non-existent table: " + e.getMessage());
      return null;
    }
    // [END bigtable_hw_get_by_key]
  }

  /** Demonstrates how to read an entire table. */
  public List<Row> readTable() {
    // [START bigtable_hw_scan_all]
    try {
      System.out.println("\nReading the entire table");
      Query query = Query.create(tableId);
      ServerStream<Row> rowStream = dataClient.readRows(query);
      List<Row> tableRows = new ArrayList<>();
      for (Row r : rowStream) {
        System.out.println("Row Key: " + r.getKey().toStringUtf8());
        tableRows.add(r);
        for (RowCell cell : r.getCells()) {
          System.out.printf(
              "Family: %s    Qualifier: %s    Value: %s%n",
              cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
        }
      }
      return tableRows;
    } catch (NotFoundException e) {
      System.err.println("Failed to read a non-existent table: " + e.getMessage());
      return null;
    }
    // [END bigtable_hw_scan_all]
  }

  /** Demonstrates how to delete a table. */
  public void deleteTable() {
    // [START bigtable_hw_delete_table]
    System.out.println("\nDeleting table: " + tableId);
    try {
      adminClient.deleteTable(tableId);
      System.out.printf("Table %s deleted successfully%n", tableId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent table: " + e.getMessage());
    }
    // [END bigtable_hw_delete_table]
  }
}
