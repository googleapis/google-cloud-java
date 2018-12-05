/*
 * Copyright 2018 Google LLC.  All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.examples.bigtable;

import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminClient;
import com.google.cloud.bigtable.admin.v2.BigtableTableAdminSettings;
import com.google.cloud.bigtable.admin.v2.models.CreateTableRequest;
import com.google.cloud.bigtable.admin.v2.models.Table;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.InstanceName;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;
import com.google.cloud.bigtable.data.v2.models.RowMutation;

public class HelloWorld {

  public static void main(String... args) throws Exception {

    final String GCLOUD_PROJECT_ID = args[0];
    final String INSTANCE_ID = args[1];
    final String TABLE_ID = "Hello-Bigtable";
    final String COLUMN_FAMILY_ID = "cf1";
    final String COLUMN_QUALIFIER = "greeting";
    final String ROW_KEY_PREFIX = "rowKey";

    if (args.length < 2) {
      System.out.println("Missing required project id or instance id");
      return;
    }

    // [START connecting_to_bigtable]
    // create the settings to configure a bigtable data client
    BigtableDataSettings settings = BigtableDataSettings.newBuilder()
        .setInstanceName(InstanceName.of(GCLOUD_PROJECT_ID, INSTANCE_ID)).build();

    // Create bigtable data client
    BigtableDataClient dataClient = BigtableDataClient.create(settings);

    // Create the settings to configure a bigtable admin client
    BigtableTableAdminSettings adminSettings = BigtableTableAdminSettings.newBuilder()
        .setInstanceName(
            com.google.bigtable.admin.v2.InstanceName.of(GCLOUD_PROJECT_ID, INSTANCE_ID)).build();

    // Create bigtable admin client
    BigtableTableAdminClient adminClient = BigtableTableAdminClient.create(adminSettings);
    // [END connecting_to_bigtable]

    try {
      // Check if table exists, create table if does not exist
      createTable(adminClient, TABLE_ID, COLUMN_FAMILY_ID);

      // Write to table
      writeToTable(dataClient, TABLE_ID, ROW_KEY_PREFIX, COLUMN_FAMILY_ID, COLUMN_QUALIFIER);

      // Read single row from the table
      readSingleRow(dataClient, TABLE_ID, ROW_KEY_PREFIX);

      // Read entire table
      readTable(dataClient, TABLE_ID);

      // Delete table
      deleteTable(adminClient, TABLE_ID);
    } catch (Exception e) {
      System.out.println("Exception while running HelloWorld: " + e.getMessage());
    } finally {
      dataClient.close();
      adminClient.close();
    }
  }

  public static Table createTable(BigtableTableAdminClient adminClient, String TABLE_ID,
      String COLUMN_FAMILY_ID) {
    // [START creating_a_table]
    Table table = null;
    if (!adminClient.exists(TABLE_ID)) {
      CreateTableRequest createTableRequest =
          CreateTableRequest.of(TABLE_ID).addFamily(COLUMN_FAMILY_ID);
      System.out.println("Creating table: " + TABLE_ID);
      table = adminClient.createTable(createTableRequest);
    }
    return table;
    // [END creating_a_table]
  }

  public static RowMutation writeToTable(BigtableDataClient dataClient, String TABLE_ID,
      String ROW_KEY_PREFIX, String COLUMN_FAMILY_ID, String COLUMN_QUALIFIER) {
    // [START writing_rows]
    RowMutation mutation = null;
    try {
      System.out.println("Write some greetings to the table:");
      String[] greetings = { "Hello World!", "Hello Bigtable!", "Hello Java!" };
      for (int i = 0; i < greetings.length; i++) {
        RowMutation rowMutation = RowMutation.create(TABLE_ID, ROW_KEY_PREFIX + i);
        mutation = rowMutation.setCell(COLUMN_FAMILY_ID, COLUMN_QUALIFIER, greetings[i]);
        dataClient.mutateRow(rowMutation);
        System.out.println(greetings[i]);
      }
    } catch (Exception e) {
      System.out.println("Exception while writing to table: " + e.getMessage());
    }
    return mutation;
    // [END writing_rows]
  }

  public static Row readSingleRow(BigtableDataClient dataClient, String TABLE_ID,
      String ROW_KEY_PREFIX) {
    // [START reading_a_row]
    Row row = null;
    try {
      System.out.println("Reading a single row by row key:");
      row = dataClient.readRow(TABLE_ID, ROW_KEY_PREFIX + 0);
      System.out.println("Row: " + row.getKey().toStringUtf8());
      for (RowCell cell : row.getCells()) {
        System.out.printf("Family: %s    Qualifier: %s    Value: %s", cell.getFamily(),
            cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
      }
    } catch (Exception e) {
      System.out.println("Exception while reading a single row: " + e.getMessage());
    }
    return row;
    // [END reading_a_row]
  }

  public static ServerStream<Row> readTable(BigtableDataClient dataClient, String TABLE_ID) {
    // [START scanning_all_rows]
    ServerStream<Row> rowStream = null;
    try {
      System.out.println("Reading the entire table:");
      Query query = Query.create(TABLE_ID);
      rowStream = dataClient.readRows(query);
      for (Row r : rowStream) {
        System.out.println("Row Key: " + r.getKey());
        for (RowCell cell : r.getCells()) {
          System.out.printf("Family: %s    Qualifier: %s    Value: %s", cell.getFamily(),
              cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
        }
      }
    } catch (Exception e) {
      System.out.println("Exception while reading table: " + e.getMessage());
    }
    return rowStream;
    // [END scanning_all_rows]
  }

  public static void deleteTable(BigtableTableAdminClient adminClient, String TABLE_ID) {
    // [START deleting_a_table]
    System.out.println("Delete the table:");
    try {
      adminClient.deleteTable(TABLE_ID);
      System.out.printf("Table: %s deleted successfully", TABLE_ID);
    } catch (Exception e) {
      System.out.println("Exception while deleting table: " + e.getMessage());
    }
    // [END deleting_a_table]
  }
}
