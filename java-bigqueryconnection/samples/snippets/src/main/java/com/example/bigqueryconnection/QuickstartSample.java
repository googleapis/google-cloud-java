/*
 * Copyright 2020 Google LLC
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

package com.example.bigqueryconnection;

// [START bigqueryconnection_quickstart]
import com.google.cloud.bigquery.connection.v1.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1.LocationName;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import java.io.IOException;

// Sample to demonstrates basic usage of the BigQuery connection API.
public class QuickstartSample {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    listConnections(projectId, location);
  }

  public static void listConnections(String projectId, String location) throws IOException {
    try (ConnectionServiceClient connectionServiceClient = ConnectionServiceClient.create()) {
      LocationName parent = LocationName.of(projectId, location);
      int pageSize = 10;
      ListConnectionsRequest request =
          ListConnectionsRequest.newBuilder()
              .setParent(parent.toString())
              .setPageSize(pageSize)
              .build();
      ConnectionServiceClient.ListConnectionsPagedResponse response =
          connectionServiceClient.listConnections(request);

      // Print the results.
      System.out.println("List of connections:");
      response
          .iterateAll()
          .forEach(connection -> System.out.println("Connection Name: " + connection.getName()));
    }
  }
}
// [END bigqueryconnection_quickstart]
