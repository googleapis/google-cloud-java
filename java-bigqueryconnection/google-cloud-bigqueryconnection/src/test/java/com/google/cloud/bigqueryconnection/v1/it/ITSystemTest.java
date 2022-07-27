/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.bigqueryconnection.v1.it;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

import com.google.api.resourcenames.ResourceName;
import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.connection.v1.CloudSqlCredential;
import com.google.cloud.bigquery.connection.v1.CloudSqlProperties;
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.ConnectionName;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1.GetConnectionRequest;
import com.google.cloud.bigquery.connection.v1.ListConnectionsRequest;
import com.google.cloud.bigquery.connection.v1.LocationName;
import com.google.cloud.bigquery.connection.v1.UpdateConnectionRequest;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import com.google.common.collect.ImmutableList;
import com.google.iam.v1.Binding;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.protobuf.FieldMask;
import com.google.protobuf.util.FieldMaskUtil;
import java.io.IOException;
import java.util.UUID;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ITSystemTest {

  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String CONNECTION_ID = "test-connectin-id-" + ID;
  private static final String LOCATION = "US";
  private static final String PARENT = LocationName.of(PROJECT_ID, LOCATION).toString();
  private static final String REGION = "us-central1";
  private static final String MY_SQL_DATABASE = requireEnvVar("MY_SQL_DATABASE");
  private static final String MY_SQL_INSTANCE = requireEnvVar("MY_SQL_INSTANCE");
  private static final String DB_USER = requireEnvVar("DB_USER");
  private static final String DB_PWD = requireEnvVar("DB_PWD");
  private static ConnectionServiceClient client;
  private static Connection connection;

  private static String requireEnvVar(String varName) {
    String value = System.getenv(varName);
    assertNotNull(
        "Environment variable " + varName + " is required to perform these tests.",
        System.getenv(varName));
    return value;
  }

  @BeforeClass
  public static void checkRequirements() {
    requireEnvVar("MY_SQL_DATABASE");
    requireEnvVar("MY_SQL_INSTANCE");
    requireEnvVar("DB_USER");
    requireEnvVar("DB_PWD");
  }

  @Before
  public void setUp() throws IOException {
    client = ConnectionServiceClient.create();
    // create a temporary connection to be deleted
    String instanceId = String.format("%s:%s:%s", PROJECT_ID, REGION, MY_SQL_INSTANCE);
    CloudSqlCredential cloudSqlCredential =
        CloudSqlCredential.newBuilder().setUsername(DB_USER).setPassword(DB_PWD).build();
    CloudSqlProperties cloudSqlProperties =
        CloudSqlProperties.newBuilder()
            .setType(CloudSqlProperties.DatabaseType.MYSQL)
            .setDatabase(MY_SQL_DATABASE)
            .setInstanceId(instanceId)
            .setCredential(cloudSqlCredential)
            .build();
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(PARENT)
            .setConnection(Connection.newBuilder().setCloudSql(cloudSqlProperties).build())
            .setConnectionId(CONNECTION_ID)
            .build();
    connection = client.createConnection(request);
  }

  @After
  public void tearDown() {
    // delete a connection
    DeleteConnectionRequest request =
        DeleteConnectionRequest.newBuilder().setName(connection.getName()).build();
    client.deleteConnection(request);
    client.close();
  }

  @Test
  public void testGetConnection() {
    GetConnectionRequest request =
        GetConnectionRequest.newBuilder().setName(connection.getName()).build();
    Connection actualConnection = client.getConnection(request);
    assertEquals(connection, actualConnection);
  }

  @Test
  public void testListConnections() {
    int pageSize = 10;
    ListConnectionsRequest request =
        ListConnectionsRequest.newBuilder().setParent(PARENT).setPageSize(pageSize).build();
    for (Connection actualConnection : client.listConnections(request).iterateAll()) {
      if (connection.getName().equals(actualConnection.getName())) {
        assertEquals(connection, actualConnection);
      }
    }
  }

  @Test
  public void testUpdateConnection() {
    String description = "MY_DESCRIPTION";
    FieldMask updateMask = FieldMaskUtil.fromString("description");
    UpdateConnectionRequest request =
        UpdateConnectionRequest.newBuilder()
            .setName(connection.getName())
            .setConnection(Connection.newBuilder().setDescription(description).build())
            .setUpdateMask(updateMask)
            .build();
    Connection actualConnection = client.updateConnection(request);
    assertEquals(description, actualConnection.getDescription());
  }

  @Test
  public void testShareConnection() {
    ResourceName resource = ConnectionName.of(PROJECT_ID, LOCATION, CONNECTION_ID);
    Binding binding =
        Binding.newBuilder()
            .addMembers("group:example-analyst-group@google.com")
            .setRole("roles/bigquery.connectionUser")
            .build();
    Policy policy = Policy.newBuilder().addBindings(binding).build();
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource.toString()).setPolicy(policy).build();
    Policy actualPolicy = client.setIamPolicy(request);
    assertEquals(ImmutableList.of(binding), actualPolicy.getBindingsList());
  }
}
