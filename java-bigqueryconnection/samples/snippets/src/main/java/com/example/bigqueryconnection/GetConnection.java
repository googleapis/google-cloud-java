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

// [START bigqueryconnection_get_connection]
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.ConnectionName;
import com.google.cloud.bigquery.connection.v1.GetConnectionRequest;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import java.io.IOException;

// Sample to get connection
public class GetConnection {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    String connectionId = "MY_CONNECTION_ID";
    getConnection(projectId, location, connectionId);
  }

  public static void getConnection(String projectId, String location, String connectionId)
      throws IOException {
    try (ConnectionServiceClient client = ConnectionServiceClient.create()) {
      ConnectionName name = ConnectionName.of(projectId, location, connectionId);
      GetConnectionRequest request =
          GetConnectionRequest.newBuilder().setName(name.toString()).build();
      Connection response = client.getConnection(request);
      System.out.println("Connection info retrieved successfully :" + response.getName());
    }
  }
}
// [END bigqueryconnection_get_connection]
