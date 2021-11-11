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

// [START bigqueryconnection_create_aws_connection]
import com.google.cloud.bigquery.connection.v1.AwsAccessRole;
import com.google.cloud.bigquery.connection.v1.AwsCrossAccountRole;
import com.google.cloud.bigquery.connection.v1.AwsProperties;
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.LocationName;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import java.io.IOException;

// Sample to create aws connection
public class CreateAwsConnection {

  public static void main(String[] args) throws IOException {
    // TODO(developer): Replace these variables before running the sample.
    String projectId = "MY_PROJECT_ID";
    // Note: As of now location only supports aws-us-east-1
    String location = "MY_LOCATION";
    String connectionId = "MY_CONNECTION_ID";
    // Example of role id arn:aws:iam::accountId:role/myrole
    String iamRoleId = "MY_AWS_ROLE_ID";
    AwsCrossAccountRole role = AwsCrossAccountRole.newBuilder().setIamRoleId(iamRoleId).build();
    AwsProperties awsProperties = AwsProperties.newBuilder().setCrossAccountRole(role).build();
    Connection connection = Connection.newBuilder().setAws(awsProperties).build();
    createAwsConnection(projectId, location, connectionId, connection);
  }

  public static void createAwsConnection(
      String projectId, String location, String connectionId, Connection connection)
      throws IOException {
    try (ConnectionServiceClient client = ConnectionServiceClient.create()) {
      LocationName parent = LocationName.of(projectId, location);
      CreateConnectionRequest request =
          CreateConnectionRequest.newBuilder()
              .setParent(parent.toString())
              .setConnection(connection)
              .setConnectionId(connectionId)
              .build();
      Connection response = client.createConnection(request);
      AwsAccessRole role = response.getAws().getAccessRole();
      System.out.println(
          "Aws connection created successfully : Aws userId :"
              + role.getIamRoleId()
              + " Aws externalId :"
              + role.getIdentity());
    }
  }
}
// [END bigqueryconnection_create_aws_connection]
