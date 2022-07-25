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

// [START bigqueryconnection_delete_connection]
import com.google.cloud.bigquery.connection.v1.ConnectionName;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import java.io.IOException;

// Sample to delete a connection
public class DeleteConnection {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    String location = "MY_LOCATION";
    String connectionName = "MY_CONNECTION_NAME";
    deleteConnection(projectId, location, connectionName);
  }

  public static void deleteConnection(String projectId, String location, String connectionName)
      throws IOException {
    try (ConnectionServiceClient client = ConnectionServiceClient.create()) {
      ConnectionName name = ConnectionName.of(projectId, location, connectionName);
      DeleteConnectionRequest request =
          DeleteConnectionRequest.newBuilder().setName(name.toString()).build();
      client.deleteConnection(request);
      System.out.println("Connection deleted successfully");
    }
  }
}
// [END bigqueryconnection_delete_connection]
