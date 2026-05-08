/*
 * Copyright 2024 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.bigtable;

import static com.google.cloud.bigtable.data.v2.models.Filters.FILTERS;

import com.google.api.gax.rpc.NotFoundException;
import com.google.api.gax.rpc.PermissionDeniedException;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.AuthorizedView;
import com.google.cloud.bigtable.admin.v2.models.CreateAuthorizedViewRequest;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.FamilySubsets;
import com.google.cloud.bigtable.admin.v2.models.SubsetView;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.admin.v2.models.UpdateAuthorizedViewRequest;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.AuthorizedViewId;
import com.google.cloud.bigtable.data.v2.models.Filters.Filter;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AuthorizedViewExample {

  private static final String COLUMN_FAMILY = "cf";
  private static final String COLUMN_QUALIFIER_GREETING = "greeting";
  private static final String COLUMN_QUALIFIER_NAME = "name";
  private static final String ROW_KEY_PREFIX = "rowKey";
  private final String tableId;
  private final String authorizedViewId;
  private final BigtableTableAdminClient adminClient;
  private final BigtableDataClient dataClient;

  public static void main(String[] args) throws IOException {

    if (args.length != 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }
    String projectId = args[0];
    String instanceId = args[1];

    AuthorizedViewExample authorizedViewExample =
        new AuthorizedViewExample(projectId, instanceId, "test-table", "test-authorized-view");
    authorizedViewExample.run();
  }

  public AuthorizedViewExample(
      String projectId, String instanceId, String tableId, String authorizedViewId)
      throws IOException {
    this.tableId = tableId;
    this.authorizedViewId = authorizedViewId;

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
  }

  public void close() {
    dataClient.close();
    adminClient.close();
  }

  public void run() {
    createTable();
    createAuthorizedView();
    updateAuthorizedView();
    getAuthorizedView();
    listAllAuthorizedViews();
    writeToAuthorizedView();
    readSingleRowFromAuthorizedView();
    readRowsWithFilterFromAuthorizedView();
    deleteAuthorizedView();
    deleteTable();
    close();
  }

  public void createTable() {
    // Checks if table exists, creates table if it does not exist.
    if (!adminClient.exists(tableId)) {
      System.out.println("Table does not exist, creating table: " + tableId);
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(tableId).addFamily(COLUMN_FAMILY);
      Table table = adminClient.createTable(createTableRequest);
      System.out.printf("Table: %s created successfully%n", table.getId());
    }
  }

  public void deleteTable() {
    // Deletes the entire table.
    System.out.println("\nDelete table: " + tableId);
    try {
      adminClient.deleteTable(tableId);
      System.out.printf("Table: %s deleted successfully%n", tableId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent table: " + e.getMessage());
    }
  }

  /**
   * Demonstrates how to create an authorized view under a table with the specified configuration.
   */
  public void createAuthorizedView() {
    // Checks if the authorized view exists, creates it if it does not exist.
    try {
      adminClient.getAuthorizedView(tableId, authorizedViewId);
    } catch (NotFoundException exception) {
      System.out.printf("%nCreating authorized view %s in table %s%n", authorizedViewId, tableId);
      // [START bigtable_create_authorized_view]
      try {
        CreateAuthorizedViewRequest request =
            CreateAuthorizedViewRequest.of(tableId, authorizedViewId)
                .setAuthorizedViewType(
                    SubsetView.create()
                        .addRowPrefix("")
                        .setFamilySubsets(
                            COLUMN_FAMILY,
                            FamilySubsets.create().addQualifierPrefix(COLUMN_QUALIFIER_NAME)));
        AuthorizedView authorizedView = adminClient.createAuthorizedView(request);
        System.out.printf("AuthorizedView: %s created successfully%n", authorizedView.getId());
      } catch (NotFoundException e) {
        System.err.println(
            "Failed to create an authorized view from a non-existent table: " + e.getMessage());
      }
      // [END bigtable_create_authorized_view]
    }
  }

  /** Demonstrates how to modify an authorized view. */
  public void updateAuthorizedView() {
    System.out.printf("%nUpdating authorized view %s in table %s%n", authorizedViewId, tableId);
    // [START bigtable_update_authorized_view]
    try {
      // Update to an authorized view permitting everything.
      UpdateAuthorizedViewRequest request =
          UpdateAuthorizedViewRequest.of(tableId, authorizedViewId)
              .setAuthorizedViewType(
                  SubsetView.create()
                      .addRowPrefix("")
                      .setFamilySubsets(
                          COLUMN_FAMILY, FamilySubsets.create().addQualifierPrefix("")));
      AuthorizedView authorizedView = adminClient.updateAuthorizedView(request);
      System.out.printf("AuthorizedView: %s updated successfully%n", authorizedView.getId());
    } catch (NotFoundException e) {
      System.err.println("Failed to modify a non-existent authorized view: " + e.getMessage());
    }
    // [END bigtable_update_authorized_view]
  }

  /** Demonstrates how to get an authorized view's metadata. */
  public AuthorizedView getAuthorizedView() {
    System.out.printf("%nGetting authorized view %s in table %s%n", authorizedViewId, tableId);
    // [START bigtable_get_authorized_view]
    AuthorizedView authorizedView = null;
    try {
      authorizedView = adminClient.getAuthorizedView(tableId, authorizedViewId);
      SubsetView subsetView = (SubsetView) authorizedView.getAuthorizedViewType();

      for (ByteString rowPrefix : subsetView.getRowPrefixes()) {
        System.out.printf("Row Prefix: %s%n", rowPrefix.toStringUtf8());
      }
      for (Map.Entry<String, FamilySubsets> entry : subsetView.getFamilySubsets().entrySet()) {
        for (ByteString qualifierPrefix : entry.getValue().getQualifierPrefixes()) {
          System.out.printf(
              "Column Family: %s, Qualifier Prefix: %s%n",
              entry.getKey(), qualifierPrefix.toStringUtf8());
        }
        for (ByteString qualifier : entry.getValue().getQualifiers()) {
          System.out.printf(
              "Column Family: %s, Qualifier: %s%n", entry.getKey(), qualifier.toStringUtf8());
        }
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to retrieve metadata from a non-existent authorized view: " + e.getMessage());
    }
    // [END bigtable_get_authorized_view]
    return authorizedView;
  }

  /** Demonstrates how to list all authorized views within a table. */
  public List<String> listAllAuthorizedViews() {
    System.out.printf("%nListing authorized views in table %s%n", tableId);
    // [START bigtable_list_authorized_views]
    List<String> authorizedViewIds = new ArrayList<>();
    try {
      authorizedViewIds = adminClient.listAuthorizedViews(tableId);
      for (String authorizedViewId : authorizedViewIds) {
        System.out.println(authorizedViewId);
      }
    } catch (NotFoundException e) {
      System.err.println(
          "Failed to list authorized views from a non-existent table: " + e.getMessage());
    }
    // [END bigtable_list_authorized_views]
    return authorizedViewIds;
  }

  /** Demonstrates how to delete an authorized view. */
  public void deleteAuthorizedView() {
    System.out.printf("%nDeleting authorized view %s in table %s%n", authorizedViewId, tableId);
    // [START bigtable_delete_authorized_view]
    try {
      adminClient.deleteAuthorizedView(tableId, authorizedViewId);
      System.out.printf("AuthorizedView: %s deleted successfully%n", authorizedViewId);
    } catch (NotFoundException e) {
      System.err.println("Failed to delete a non-existent authorized view: " + e.getMessage());
    }
    // [END bigtable_delete_authorized_view]
  }

  /** Demonstrates how to write some rows to an authorized view. */
  public void writeToAuthorizedView() {
    // [START bigtable_authorized_view_write_rows]
    try {
      System.out.println("\nWriting to authorized view");
      String[] names = {"World", "Bigtable", "Java"};
      for (int i = 0; i < names.length; i++) {
        String greeting = "Hello " + names[i] + "!";
        RowMutation rowMutation =
            RowMutation.create(AuthorizedViewId.of(tableId, authorizedViewId), ROW_KEY_PREFIX + i)
                .setCell(COLUMN_FAMILY, COLUMN_QUALIFIER_NAME, names[i])
                .setCell(COLUMN_FAMILY, COLUMN_QUALIFIER_GREETING, greeting);
        dataClient.mutateRow(rowMutation);
        System.out.println(greeting);
      }
    } catch (Exception e) {
      if (e instanceof NotFoundException) {
        System.err.println("Failed to write to non-existent authorized view: " + e.getMessage());
      } else if (e instanceof PermissionDeniedException) {
        System.err.println(
            "Failed to apply mutations outside of the authorized view: " + e.getMessage());
      }
    }
    // [END bigtable_authorized_view_write_rows]
  }

  /** Demonstrates how to read a single row from an authorized view. */
  public Row readSingleRowFromAuthorizedView() {
    // [START bigtable_authorized_view_get_by_key]
    try {
      System.out.println("\nReading a single row by row key from an authorized view");
      Row row =
          dataClient.readRow(AuthorizedViewId.of(tableId, authorizedViewId), ROW_KEY_PREFIX + 0);
      System.out.println("Row: " + row.getKey().toStringUtf8());
      for (RowCell cell : row.getCells()) {
        System.out.printf(
            "Family: %s    Qualifier: %s    Value: %s%n",
            cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
      }
      return row;
    } catch (NotFoundException e) {
      System.err.println("Failed to read from a non-existent authorized view: " + e.getMessage());
      return null;
    }
    // [END bigtable_authorized_view_get_by_key]
  }

  /** Demonstrates how to read rows from an authorized view with a filter. */
  public List<Row> readRowsWithFilterFromAuthorizedView() {
    // [START bigtable_authorized_view_scan_with_filter]
    try {
      // A filter that matches only the most recent cell within each column
      Filter filter = FILTERS.limit().cellsPerColumn(1);
      System.out.println("\nScanning authorized view with filter");
      Query query = Query.create(AuthorizedViewId.of(tableId, authorizedViewId)).filter(filter);
      ServerStream<Row> rowStream = dataClient.readRows(query);
      List<Row> authorizedViewRows = new ArrayList<>();
      for (Row r : rowStream) {
        System.out.println("Row Key: " + r.getKey().toStringUtf8());
        authorizedViewRows.add(r);
        for (RowCell cell : r.getCells()) {
          System.out.printf(
              "Family: %s    Qualifier: %s    Value: %s%n",
              cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
        }
      }
      return authorizedViewRows;
    } catch (NotFoundException e) {
      System.err.println("Failed to read a non-existent authorized view: " + e.getMessage());
      return null;
    }
    // [END bigtable_authorized_view_scan_with_filter]
  }
}
