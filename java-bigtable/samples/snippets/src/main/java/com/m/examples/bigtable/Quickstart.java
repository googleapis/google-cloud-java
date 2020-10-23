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

package com.m.examples.bigtable;

// [START bigtable_quickstart_veneer]

import com.google.api.gax.rpc.NotFoundException;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowCell;

public class Quickstart {

  public static void main(String... args) {
    String projectId = args[0];  // my-gcp-project-id
    String instanceId = args[1]; // my-bigtable-instance-id
    String tableId = args[2];    // my-bigtable-table-id

    quickstart(projectId, instanceId, tableId);
  }

  public static void quickstart(String projectId, String instanceId, String tableId) {
    BigtableDataSettings settings =
        BigtableDataSettings.newBuilder().setProjectId(projectId).setInstanceId(instanceId).build();

    // Initialize client that will be used to send requests. This client only needs to be created
    // once, and can be reused for multiple requests. After completing all of your requests, call
    // the "close" method on the client to safely clean up any remaining background resources.
    try (BigtableDataClient dataClient = BigtableDataClient.create(settings)) {
      System.out.println("\nReading a single row by row key");
      Row row = dataClient.readRow(tableId, "r1");
      System.out.println("Row: " + row.getKey().toStringUtf8());
      for (RowCell cell : row.getCells()) {
        System.out.printf(
            "Family: %s    Qualifier: %s    Value: %s%n",
            cell.getFamily(), cell.getQualifier().toStringUtf8(), cell.getValue().toStringUtf8());
      }
    } catch (NotFoundException e) {
      System.err.println("Failed to read from a non-existent table: " + e.getMessage());
    } catch (Exception e) {
      System.out.println("Error during quickstart: \n" + e.toString());
    }
  }
}
// [END bigtable_quickstart_veneer]
