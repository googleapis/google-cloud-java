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

package com.google.cloud.tpu.v1;

import static com.google.cloud.tpu.v1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v1.TpuClient.ListTensorFlowVersionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class TpuClientTest {
  private static MockServiceHelper mockServiceHelper;
  private static MockTpu mockTpu;
  private LocalChannelProvider channelProvider;
  private TpuClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockTpu = new MockTpu();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockTpu));
    mockServiceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    mockServiceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    mockServiceHelper.reset();
    channelProvider = mockServiceHelper.createChannelProvider();
    TpuSettings settings =
        TpuSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = TpuClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listNodesTest() throws Exception {
    Node responsesElement = Node.newBuilder().build();
    ListNodesResponse expectedResponse =
        ListNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllNodes(Arrays.asList(responsesElement))
            .build();
    mockTpu.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodesRequest actualRequest = ((ListNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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
    mockTpu.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListNodesPagedResponse pagedListResponse = client.listNodes(parent);

    List<Node> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListNodesRequest actualRequest = ((ListNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listNodesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String parent = "parent-995424086";
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
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    mockTpu.addResponse(expectedResponse);

    NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");

    Node actualResponse = client.getNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeRequest actualRequest = ((GetNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    mockTpu.addResponse(expectedResponse);

    String name = "name3373707";

    Node actualResponse = client.getNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetNodeRequest actualRequest = ((GetNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String name = "name3373707";
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
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Node node = Node.newBuilder().build();
    String nodeId = "nodeId-1040171331";

    Node actualResponse = client.createNodeAsync(parent, node, nodeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodeRequest actualRequest = ((CreateNodeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(node, actualRequest.getNode());
    Assert.assertEquals(nodeId, actualRequest.getNodeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Node node = Node.newBuilder().build();
      String nodeId = "nodeId-1040171331";
      client.createNodeAsync(parent, node, nodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createNodeTest2() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    String parent = "parent-995424086";
    Node node = Node.newBuilder().build();
    String nodeId = "nodeId-1040171331";

    Node actualResponse = client.createNodeAsync(parent, node, nodeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateNodeRequest actualRequest = ((CreateNodeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(node, actualRequest.getNode());
    Assert.assertEquals(nodeId, actualRequest.getNodeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String parent = "parent-995424086";
      Node node = Node.newBuilder().build();
      String nodeId = "nodeId-1040171331";
      client.createNodeAsync(parent, node, nodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");

    Node actualResponse = client.deleteNodeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNodeRequest actualRequest = ((DeleteNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      NodeName name = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
      client.deleteNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteNodeTest2() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    String name = "name3373707";

    Node actualResponse = client.deleteNodeAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteNodeRequest actualRequest = ((DeleteNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String name = "name3373707";
      client.deleteNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void reimageNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("reimageNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    ReimageNodeRequest request =
        ReimageNodeRequest.newBuilder()
            .setName("name3373707")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .build();

    Node actualResponse = client.reimageNodeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ReimageNodeRequest actualRequest = ((ReimageNodeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTensorflowVersion(), actualRequest.getTensorflowVersion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void reimageNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      ReimageNodeRequest request =
          ReimageNodeRequest.newBuilder()
              .setName("name3373707")
              .setTensorflowVersion("tensorflowVersion-470125103")
              .build();
      client.reimageNodeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void stopNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("stopNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    StopNodeRequest request = StopNodeRequest.newBuilder().setName("name3373707").build();

    Node actualResponse = client.stopNodeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StopNodeRequest actualRequest = ((StopNodeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void stopNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      StopNodeRequest request = StopNodeRequest.newBuilder().setName("name3373707").build();
      client.stopNodeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void startNodeTest() throws Exception {
    Node expectedResponse =
        Node.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setDescription("description-1724546052")
            .setAcceleratorType("acceleratorType-82462651")
            .setIpAddress("ipAddress1634032845")
            .setPort("port3446913")
            .setHealthDescription("healthDescription1231837184")
            .setTensorflowVersion("tensorflowVersion-470125103")
            .setNetwork("network1843485230")
            .setCidrBlock("cidrBlock1646183801")
            .setServiceAccount("serviceAccount1079137720")
            .setCreateTime(Timestamp.newBuilder().build())
            .setSchedulingConfig(SchedulingConfig.newBuilder().build())
            .addAllNetworkEndpoints(new ArrayList<NetworkEndpoint>())
            .putAllLabels(new HashMap<String, String>())
            .setUseServiceNetworking(true)
            .addAllSymptoms(new ArrayList<Symptom>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("startNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockTpu.addResponse(resultOperation);

    StartNodeRequest request = StartNodeRequest.newBuilder().setName("name3373707").build();

    Node actualResponse = client.startNodeAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    StartNodeRequest actualRequest = ((StartNodeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void startNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      StartNodeRequest request = StartNodeRequest.newBuilder().setName("name3373707").build();
      client.startNodeAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTensorFlowVersionsTest() throws Exception {
    TensorFlowVersion responsesElement = TensorFlowVersion.newBuilder().build();
    ListTensorFlowVersionsResponse expectedResponse =
        ListTensorFlowVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorflowVersions(Arrays.asList(responsesElement))
            .build();
    mockTpu.addResponse(expectedResponse);

    TensorFlowVersionName parent =
        TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");

    ListTensorFlowVersionsPagedResponse pagedListResponse = client.listTensorFlowVersions(parent);

    List<TensorFlowVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorflowVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorFlowVersionsRequest actualRequest =
        ((ListTensorFlowVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorFlowVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      TensorFlowVersionName parent =
          TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");
      client.listTensorFlowVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTensorFlowVersionsTest2() throws Exception {
    TensorFlowVersion responsesElement = TensorFlowVersion.newBuilder().build();
    ListTensorFlowVersionsResponse expectedResponse =
        ListTensorFlowVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllTensorflowVersions(Arrays.asList(responsesElement))
            .build();
    mockTpu.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTensorFlowVersionsPagedResponse pagedListResponse = client.listTensorFlowVersions(parent);

    List<TensorFlowVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTensorflowVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTensorFlowVersionsRequest actualRequest =
        ((ListTensorFlowVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTensorFlowVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTensorFlowVersions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorFlowVersionTest() throws Exception {
    TensorFlowVersion expectedResponse =
        TensorFlowVersion.newBuilder()
            .setName(
                TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
                    .toString())
            .setVersion("version351608024")
            .build();
    mockTpu.addResponse(expectedResponse);

    TensorFlowVersionName name =
        TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");

    TensorFlowVersion actualResponse = client.getTensorFlowVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorFlowVersionRequest actualRequest =
        ((GetTensorFlowVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorFlowVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      TensorFlowVersionName name =
          TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]");
      client.getTensorFlowVersion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTensorFlowVersionTest2() throws Exception {
    TensorFlowVersion expectedResponse =
        TensorFlowVersion.newBuilder()
            .setName(
                TensorFlowVersionName.of("[PROJECT]", "[LOCATION]", "[TENSOR_FLOW_VERSION]")
                    .toString())
            .setVersion("version351608024")
            .build();
    mockTpu.addResponse(expectedResponse);

    String name = "name3373707";

    TensorFlowVersion actualResponse = client.getTensorFlowVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTensorFlowVersionRequest actualRequest =
        ((GetTensorFlowVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTensorFlowVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String name = "name3373707";
      client.getTensorFlowVersion(name);
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
    mockTpu.addResponse(expectedResponse);

    AcceleratorTypeName parent =
        AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");

    ListAcceleratorTypesPagedResponse pagedListResponse = client.listAcceleratorTypes(parent);

    List<AcceleratorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAcceleratorTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAcceleratorTypesRequest actualRequest =
        ((ListAcceleratorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAcceleratorTypesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      AcceleratorTypeName parent =
          AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");
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
    mockTpu.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAcceleratorTypesPagedResponse pagedListResponse = client.listAcceleratorTypes(parent);

    List<AcceleratorType> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAcceleratorTypesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAcceleratorTypesRequest actualRequest =
        ((ListAcceleratorTypesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAcceleratorTypesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockTpu.addResponse(expectedResponse);

    AcceleratorTypeName name =
        AcceleratorTypeName.of("[PROJECT]", "[LOCATION]", "[ACCELERATOR_TYPE]");

    AcceleratorType actualResponse = client.getAcceleratorType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAcceleratorTypeRequest actualRequest = ((GetAcceleratorTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAcceleratorTypeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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
    mockTpu.addResponse(expectedResponse);

    String name = "name3373707";

    AcceleratorType actualResponse = client.getAcceleratorType(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAcceleratorTypeRequest actualRequest = ((GetAcceleratorTypeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAcceleratorTypeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String name = "name3373707";
      client.getAcceleratorType(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
