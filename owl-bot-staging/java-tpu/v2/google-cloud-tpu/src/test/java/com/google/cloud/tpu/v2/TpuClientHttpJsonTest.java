/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.tpu.v2;

import static com.google.cloud.tpu.v2.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListLocationsPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.cloud.tpu.v2.stub.HttpJsonTpuStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
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
public class TpuClientHttpJsonTest {
  private static MockHttpService mockService;
  private static TpuClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonTpuStub.getMethodDescriptors(), TpuSettings.getDefaultEndpoint());
    TpuSettings settings =
        TpuSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                TpuSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TpuClient.create(settings);
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
  public void listNodesTest() throws Exception {
    Node responsesElement = Node.newBuilder().build();
    ListNodesResponse expectedResponse =
        ListNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

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
  public void listNodesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listNodesTest2() throws Exception {
    Node responsesElement = Node.newBuilder().build();
    ListNodesResponse expectedResponse =
        ListNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

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
  public void listNodesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");

    Node actualResponse = client.getNode(name);
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
  public void getNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
      client.getNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getNodeTest2() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8007/locations/location-8007/nodes/node-8007";

    Node actualResponse = client.getNode(name);
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
  public void getNodeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8007/locations/location-8007/nodes/node-8007";
      client.getNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Node node = Node.newBuilder().build();
    String nodeId = "nodeId-1040171331";

    Node actualResponse = client.createNodeAsync(parent, node, nodeId).get();
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
  public void createNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Node node = Node.newBuilder().build();
      String nodeId = "nodeId-1040171331";
      client.createNodeAsync(parent, node, nodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createNodeTest2() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Node node = Node.newBuilder().build();
    String nodeId = "nodeId-1040171331";

    Node actualResponse = client.createNodeAsync(parent, node, nodeId).get();
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
  public void createNodeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Node node = Node.newBuilder().build();
      String nodeId = "nodeId-1040171331";
      client.createNodeAsync(parent, node, nodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteNodeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");

    client.deleteNodeAsync(name).get();

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
  public void deleteNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
      client.deleteNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteNodeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-8007/locations/location-8007/nodes/node-8007";

    client.deleteNodeAsync(name).get();

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
  public void deleteNodeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8007/locations/location-8007/nodes/node-8007";
      client.deleteNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void stopNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    StopNodeRequest request =
        StopNodeRequest.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .build();

    Node actualResponse = client.stopNodeAsync(request).get();
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
  public void stopNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StopNodeRequest request =
          StopNodeRequest.newBuilder()
              .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
              .build();
      client.stopNodeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void startNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    StartNodeRequest request =
        StartNodeRequest.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .build();

    Node actualResponse = client.startNodeAsync(request).get();
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
  public void startNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      StartNodeRequest request =
          StartNodeRequest.newBuilder()
              .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
              .build();
      client.startNodeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Node node =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setHealthDescription("healthDescription1231837184")
            .setRuntimeVersion("runtimeVersion602071520")
            .setNetworkConfig(NetworkConfig.newBuilder().build())
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount(ServiceAccount.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .putAllMetadata(new HashMap<String, String>())
            .addAllTags(new ArrayList<String>())
            .setId(3355)
            .addAllDataDisks(new ArrayList<AttachedDisk>())
            .addAllSymptoms(new ArrayList<Symptom>())
            .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Node actualResponse = client.updateNodeAsync(node, updateMask).get();
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
  public void updateNodeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Node node =
          Node.newBuilder()
              .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
              .setDescription("description-1724546052")
              .setAcceleratorType("acceleratorType-82462651")
              .setHealthDescription("healthDescription1231837184")
              .setRuntimeVersion("runtimeVersion602071520")
              .setNetworkConfig(NetworkConfig.newBuilder().build())
              .setCidrBlock("cidrBlock1646183801")
              .setServiceAccount(ServiceAccount.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setSchedulingConfig(SchedulingConfig.newBuilder().build())
              .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
              .putAllLabels(new HashMap<String, String>())
              .putAllMetadata(new HashMap<String, String>())
              .addAllTags(new ArrayList<String>())
              .setId(3355)
              .addAllDataDisks(new ArrayList<AttachedDisk>())
              .addAllSymptoms(new ArrayList<Symptom>())
              .setShieldedInstanceConfig(ShieldedInstanceConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNodeAsync(node, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateServiceIdentityTest() throws Exception {
    GenerateServiceIdentityResponse expectedResponse =
        GenerateServiceIdentityResponse.newBuilder()
            .setIdentity(ServiceIdentity.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateServiceIdentityRequest request =
        GenerateServiceIdentityRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    GenerateServiceIdentityResponse actualResponse = client.generateServiceIdentity(request);
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
  public void generateServiceIdentityExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateServiceIdentityRequest request =
          GenerateServiceIdentityRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .build();
      client.generateServiceIdentity(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAcceleratorTypesTest() throws Exception {
    AcceleratorType responsesElement = AcceleratorType.newBuilder().build();
    ListAcceleratorTypesResponse expectedResponse =
        ListAcceleratorTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAcceleratorTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAcceleratorTypesPagedResponse pagedListResponse = client.listAcceleratorTypes(parent);

    List<AcceleratorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAcceleratorTypesList().get(0), resources.get(0));

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
  public void listAcceleratorTypesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAcceleratorTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAcceleratorTypesTest2() throws Exception {
    AcceleratorType responsesElement = AcceleratorType.newBuilder().build();
    ListAcceleratorTypesResponse expectedResponse =
        ListAcceleratorTypesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAcceleratorTypes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAcceleratorTypesPagedResponse pagedListResponse = client.listAcceleratorTypes(parent);

    List<AcceleratorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAcceleratorTypesList().get(0), resources.get(0));

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
  public void listAcceleratorTypesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAcceleratorTypes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAcceleratorTypeTest() throws Exception {
    AcceleratorType expectedResponse =
        AcceleratorType.newBuilder()
            .setName(
                AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]").toString())
            .setType("type3575610")
            .build();
    mockService.addResponse(expectedResponse);

    AcceleratorTypeName name =
        AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");

    AcceleratorType actualResponse = client.getAcceleratorType(name);
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
  public void getAcceleratorTypeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AcceleratorTypeName name =
          AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");
      client.getAcceleratorType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAcceleratorTypeTest2() throws Exception {
    AcceleratorType expectedResponse =
        AcceleratorType.newBuilder()
            .setName(
                AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]").toString())
            .setType("type3575610")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7118/locations/location-7118/acceleratorTypes/acceleratorType-7118";

    AcceleratorType actualResponse = client.getAcceleratorType(name);
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
  public void getAcceleratorTypeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7118/locations/location-7118/acceleratorTypes/acceleratorType-7118";
      client.getAcceleratorType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimeVersionsTest() throws Exception {
    RuntimeVersion responsesElement = RuntimeVersion.newBuilder().build();
    ListRuntimeVersionsResponse expectedResponse =
        ListRuntimeVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimeVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListRuntimeVersionsPagedResponse pagedListResponse = client.listRuntimeVersions(parent);

    List<RuntimeVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimeVersionsList().get(0), resources.get(0));

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
  public void listRuntimeVersionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listRuntimeVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listRuntimeVersionsTest2() throws Exception {
    RuntimeVersion responsesElement = RuntimeVersion.newBuilder().build();
    ListRuntimeVersionsResponse expectedResponse =
        ListRuntimeVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimeVersions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListRuntimeVersionsPagedResponse pagedListResponse = client.listRuntimeVersions(parent);

    List<RuntimeVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimeVersionsList().get(0), resources.get(0));

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
  public void listRuntimeVersionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listRuntimeVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeVersionTest() throws Exception {
    RuntimeVersion expectedResponse =
        RuntimeVersion.newBuilder()
            .setName(
                RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]").toString())
            .setVersion("version351608024")
            .build();
    mockService.addResponse(expectedResponse);

    RuntimeVersionName name = RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]");

    RuntimeVersion actualResponse = client.getRuntimeVersion(name);
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
  public void getRuntimeVersionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RuntimeVersionName name =
          RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]");
      client.getRuntimeVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getRuntimeVersionTest2() throws Exception {
    RuntimeVersion expectedResponse =
        RuntimeVersion.newBuilder()
            .setName(
                RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]").toString())
            .setVersion("version351608024")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5927/locations/location-5927/runtimeVersions/runtimeVersion-5927";

    RuntimeVersion actualResponse = client.getRuntimeVersion(name);
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
  public void getRuntimeVersionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5927/locations/location-5927/runtimeVersions/runtimeVersion-5927";
      client.getRuntimeVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGuestAttributesTest() throws Exception {
    GetGuestAttributesResponse expectedResponse =
        GetGuestAttributesResponse.newBuilder()
            .addAllGuestAttributes(new ArrayList<GuestAttributes>())
            .build();
    mockService.addResponse(expectedResponse);

    GetGuestAttributesRequest request =
        GetGuestAttributesRequest.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setQueryPath("queryPath-1807004403")
            .addAllWorkerIds(new ArrayList<String>())
            .build();

    GetGuestAttributesResponse actualResponse = client.getGuestAttributes(request);
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
  public void getGuestAttributesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetGuestAttributesRequest request =
          GetGuestAttributesRequest.newBuilder()
              .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
              .setQueryPath("queryPath-1807004403")
              .addAllWorkerIds(new ArrayList<String>())
              .build();
      client.getGuestAttributes(request);
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
