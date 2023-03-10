/*
 * Copyright 2022 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.it;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.cloud.ServiceOptions;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.DatasetInfo;
import com.google.cloud.bigquery.RemoteFunctionOptions;
import com.google.cloud.bigquery.Routine;
import com.google.cloud.bigquery.RoutineArgument;
import com.google.cloud.bigquery.RoutineId;
import com.google.cloud.bigquery.RoutineInfo;
import com.google.cloud.bigquery.StandardSQLDataType;
import com.google.cloud.bigquery.connection.v1.CloudResourceProperties;
import com.google.cloud.bigquery.connection.v1.Connection;
import com.google.cloud.bigquery.connection.v1.CreateConnectionRequest;
import com.google.cloud.bigquery.connection.v1.DeleteConnectionRequest;
import com.google.cloud.bigquery.connection.v1.LocationName;
import com.google.cloud.bigquery.testing.RemoteBigQueryHelper;
import com.google.cloud.bigqueryconnection.v1.ConnectionServiceClient;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class ITRemoteUDFTest {

  private static final String ID = UUID.randomUUID().toString().substring(0, 8);
  private static final String PROJECT_ID = ServiceOptions.getDefaultProjectId();
  private static final String CONNECTION_ID = "test-connection-id-" + ID;
  private static final String LOCATION = "US";
  private static final String PARENT = LocationName.of(PROJECT_ID, LOCATION).toString();
  private static final String REMOTE_ENDPOINT = "https://aaabbbccc-uc.a.run.app";
  private static final String ROUTINE_DATASET = RemoteBigQueryHelper.generateDatasetName();
  private static ConnectionServiceClient client;
  private static Connection connection;
  private static BigQuery bigquery;

  @Before
  public void setUp() throws IOException {
    RemoteBigQueryHelper bigqueryHelper = RemoteBigQueryHelper.create();
    bigquery = bigqueryHelper.getOptions().getService();
    client = ConnectionServiceClient.create();

    DatasetInfo info =
        DatasetInfo.newBuilder(ROUTINE_DATASET).setDescription("java routine lifecycle").build();
    bigquery.create(info);
    CloudResourceProperties cloudResourceProperties = CloudResourceProperties.newBuilder().build();
    CreateConnectionRequest request =
        CreateConnectionRequest.newBuilder()
            .setParent(PARENT)
            .setConnection(
                Connection.newBuilder().setCloudResource(cloudResourceProperties).build())
            .setConnectionId(CONNECTION_ID)
            .build();
    connection = client.createConnection(request);
  }

  @AfterClass
  public static void afterClass() {
    if (bigquery != null) {
      RemoteBigQueryHelper.forceDelete(bigquery, ROUTINE_DATASET);
    }
    // delete a connection
    DeleteConnectionRequest request =
        DeleteConnectionRequest.newBuilder().setName(connection.getName()).build();
    client.deleteConnection(request);
    client.close();
  }

  @Test
  public void testRoutineRemoteUDF() {
    String routineName = RemoteBigQueryHelper.generateRoutineName();
    RoutineId routineId = RoutineId.of(ROUTINE_DATASET, routineName);
    Map<String, String> userDefinedContext =
        new HashMap<String, String>() {
          {
            put("key1", "value1");
            put("key2", "value2");
          }
        };

    RemoteFunctionOptions remoteFunctionOptions =
        RemoteFunctionOptions.newBuilder()
            .setEndpoint(REMOTE_ENDPOINT)
            .setConnection(connection.getName())
            .setMaxBatchingRows(Long.valueOf(30))
            .setUserDefinedContext(userDefinedContext)
            .build();
    RoutineInfo routineInfo =
        RoutineInfo.newBuilder(routineId)
            .setRoutineType("SCALAR_FUNCTION")
            .setArguments(
                ImmutableList.of(
                    RoutineArgument.newBuilder()
                        .setName("x")
                        .setDataType(StandardSQLDataType.newBuilder("INT64").build())
                        .build()))
            .setRemoteFunctionOptions(remoteFunctionOptions)
            .setReturnType(StandardSQLDataType.newBuilder("INT64").build())
            .build();

    Routine routine = bigquery.create(routineInfo);
    assertNotNull(routine);
    assertEquals(routine.getRoutineType(), "SCALAR_FUNCTION");
    assertEquals(REMOTE_ENDPOINT, routine.getRemoteFunctionOptions().getEndpoint());
    assertEquals(connection.getName(), routine.getRemoteFunctionOptions().getConnection());
  }
}
