/*
 * Copyright 2025 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.managedkafka.v1;

import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectClustersPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListConnectorsPagedResponse;
import static com.google.cloud.managedkafka.v1.ManagedKafkaConnectClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.managedkafka.v1.stub.HttpJsonManagedKafkaConnectStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ManagedKafkaConnectClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ManagedKafkaConnectClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonManagedKafkaConnectStub.getMethodDescriptors(),
            ManagedKafkaConnectSettings.getDefaultEndpoint());
    ManagedKafkaConnectSettings settings =
        ManagedKafkaConnectSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ManagedKafkaConnectSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ManagedKafkaConnectClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listConnectClustersTest() throws Exception {
    ConnectCluster responsesElement = ConnectCluster.newBuilder().build();
    ListConnectClustersResponse expectedResponse =
        ListConnectClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConnectClustersPagedResponse pagedListResponse = client.listConnectClusters(parent);

    List<ConnectCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConnectClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectClustersTest2() throws Exception {
    ConnectCluster responsesElement = ConnectCluster.newBuilder().build();
    ListConnectClustersResponse expectedResponse =
        ListConnectClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListConnectClustersPagedResponse pagedListResponse = client.listConnectClusters(parent);

    List<ConnectCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listConnectClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectClusterName name = ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    ConnectCluster actualResponse = client.getConnectCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConnectClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectClusterName name =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      client.getConnectCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectClusterTest2() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1113/locations/location-1113/connectClusters/connectCluster-1113";

    ConnectCluster actualResponse = client.getConnectCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConnectClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1113/locations/location-1113/connectClusters/connectCluster-1113";
      client.getConnectCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
    String connectClusterId = "connectClusterId-1562078485";

    ConnectCluster actualResponse =
        client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createConnectClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
      String connectClusterId = "connectClusterId-1562078485";
      client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createConnectClusterTest2() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
    String connectClusterId = "connectClusterId-1562078485";

    ConnectCluster actualResponse =
        client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createConnectClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ConnectCluster connectCluster = ConnectCluster.newBuilder().build();
      String connectClusterId = "connectClusterId-1562078485";
      client.createConnectClusterAsync(parent, connectCluster, connectClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateConnectClusterTest() throws Exception {
    ConnectCluster expectedResponse =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ConnectCluster connectCluster =
        ConnectCluster.newBuilder()
            .setName(
                ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
            .setKafkaCluster("kafkaCluster-481625100")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCapacityConfig(CapacityConfig.newBuilder().build())
            .putAllConfig(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ConnectCluster actualResponse =
        client.updateConnectClusterAsync(connectCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateConnectClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectCluster connectCluster =
          ConnectCluster.newBuilder()
              .setName(
                  ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]").toString())
              .setKafkaCluster("kafkaCluster-481625100")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setCapacityConfig(CapacityConfig.newBuilder().build())
              .putAllConfig(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnectClusterAsync(connectCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteConnectClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ConnectClusterName name = ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    client.deleteConnectClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectClusterName name =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      client.deleteConnectClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteConnectClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteConnectClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-1113/locations/location-1113/connectClusters/connectCluster-1113";

    client.deleteConnectClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1113/locations/location-1113/connectClusters/connectCluster-1113";
      client.deleteConnectClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listConnectorsTest() throws Exception {
    Connector responsesElement = Connector.newBuilder().build();
    ListConnectorsResponse expectedResponse =
        ListConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConnectClusterName parent =
        ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectorsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectClusterName parent =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      client.listConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConnectorsTest2() throws Exception {
    Connector responsesElement = Connector.newBuilder().build();
    ListConnectorsResponse expectedResponse =
        ListConnectorsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConnectors(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4120/locations/location-4120/connectClusters/connectCluster-4120";

    ListConnectorsPagedResponse pagedListResponse = client.listConnectors(parent);

    List<Connector> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConnectorsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listConnectorsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4120/locations/location-4120/connectClusters/connectCluster-4120";
      client.listConnectors(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.getConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConnectorTest2() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    Connector actualResponse = client.getConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.getConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ConnectClusterName parent =
        ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
    Connector connector = Connector.newBuilder().build();
    String connectorId = "connectorId1724784200";

    Connector actualResponse = client.createConnector(parent, connector, connectorId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectClusterName parent =
          ConnectClusterName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]");
      Connector connector = Connector.newBuilder().build();
      String connectorId = "connectorId1724784200";
      client.createConnector(parent, connector, connectorId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConnectorTest2() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4120/locations/location-4120/connectClusters/connectCluster-4120";
    Connector connector = Connector.newBuilder().build();
    String connectorId = "connectorId1724784200";

    Connector actualResponse = client.createConnector(parent, connector, connectorId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4120/locations/location-4120/connectClusters/connectCluster-4120";
      Connector connector = Connector.newBuilder().build();
      String connectorId = "connectorId1724784200";
      client.createConnector(parent, connector, connectorId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConnectorTest() throws Exception {
    Connector expectedResponse =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Connector connector =
        Connector.newBuilder()
            .setName(
                ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                    .toString())
            .putAllConfigs(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Connector actualResponse = client.updateConnector(connector, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Connector connector =
          Connector.newBuilder()
              .setName(
                  ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]")
                      .toString())
              .putAllConfigs(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConnector(connector, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectorTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    client.deleteConnector(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.deleteConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConnectorTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    client.deleteConnector(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.deleteConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseConnectorTest() throws Exception {
    PauseConnectorResponse expectedResponse = PauseConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    PauseConnectorResponse actualResponse = client.pauseConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pauseConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.pauseConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void pauseConnectorTest2() throws Exception {
    PauseConnectorResponse expectedResponse = PauseConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    PauseConnectorResponse actualResponse = client.pauseConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void pauseConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.pauseConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeConnectorTest() throws Exception {
    ResumeConnectorResponse expectedResponse = ResumeConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    ResumeConnectorResponse actualResponse = client.resumeConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void resumeConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.resumeConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void resumeConnectorTest2() throws Exception {
    ResumeConnectorResponse expectedResponse = ResumeConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    ResumeConnectorResponse actualResponse = client.resumeConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void resumeConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.resumeConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restartConnectorTest() throws Exception {
    RestartConnectorResponse expectedResponse = RestartConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    RestartConnectorResponse actualResponse = client.restartConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restartConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.restartConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void restartConnectorTest2() throws Exception {
    RestartConnectorResponse expectedResponse = RestartConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    RestartConnectorResponse actualResponse = client.restartConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void restartConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.restartConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopConnectorTest() throws Exception {
    StopConnectorResponse expectedResponse = StopConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConnectorName name =
        ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");

    StopConnectorResponse actualResponse = client.stopConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void stopConnectorExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConnectorName name =
          ConnectorName.of("[PROJECT]", "[LOCATION]", "[CONNECT_CLUSTER]", "[CONNECTOR]");
      client.stopConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void stopConnectorTest2() throws Exception {
    StopConnectorResponse expectedResponse = StopConnectorResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";

    StopConnectorResponse actualResponse = client.stopConnector(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void stopConnectorExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5161/locations/location-5161/connectClusters/connectCluster-5161/connectors/connector-5161";
      client.stopConnector(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLocationsTest() throws Exception {
    Location responsesElement = Location.newBuilder().build();
    ListLocationsResponse expectedResponse =
        ListLocationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllLocations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
              .setFilter("filter-1274492040")
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.listLocations(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLocationTest() throws Exception {
    Location expectedResponse =
        Location.newBuilder()
            .setName("name3373707")
            .setLocationId("locationId1541836720")
            .setDisplayName("displayName1714148973")
            .putAllLabels(new HashMap<String, String>())
            .setMetadata(Any.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
