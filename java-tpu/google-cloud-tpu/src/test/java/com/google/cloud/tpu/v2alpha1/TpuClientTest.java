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

package com.google.cloud.tpu.v2alpha1;

import static com.google.cloud.tpu.v2alpha1.TpuClient.ListAcceleratorTypesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListNodesPagedResponse;
import static com.google.cloud.tpu.v2alpha1.TpuClient.ListRuntimeVersionsPagedResponse;

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
import com.google.protobuf.FieldMask;
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

    NodeName parent = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");

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
      NodeName parent = NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]");
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
    mockTpu.addResponse(resultOperation);

    Node node = Node.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Node actualResponse = client.updateNodeAsync(node, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateNodeRequest actualRequest = ((UpdateNodeRequest) actualRequests.get(0));

    Assert.assertEquals(node, actualRequest.getNode());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      Node node = Node.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateNodeAsync(node, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateServiceIdentityTest() throws Exception {
    GenerateServiceIdentityResponse expectedResponse =
        GenerateServiceIdentityResponse.newBuilder()
            .setIdentity(ServiceIdentity.newBuilder().build())
            .build();
    mockTpu.addResponse(expectedResponse);

    GenerateServiceIdentityRequest request =
        GenerateServiceIdentityRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .build();

    GenerateServiceIdentityResponse actualResponse = client.generateServiceIdentity(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateServiceIdentityRequest actualRequest =
        ((GenerateServiceIdentityRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateServiceIdentityExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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

  @Test
  public void listRuntimeVersionsTest() throws Exception {
    RuntimeVersion responsesElement = RuntimeVersion.newBuilder().build();
    ListRuntimeVersionsResponse expectedResponse =
        ListRuntimeVersionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllRuntimeVersions(Arrays.asList(responsesElement))
            .build();
    mockTpu.addResponse(expectedResponse);

    RuntimeVersionName parent =
        RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]");

    ListRuntimeVersionsPagedResponse pagedListResponse = client.listRuntimeVersions(parent);

    List<RuntimeVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimeVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimeVersionsRequest actualRequest = ((ListRuntimeVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimeVersionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      RuntimeVersionName parent =
          RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]");
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
    mockTpu.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListRuntimeVersionsPagedResponse pagedListResponse = client.listRuntimeVersions(parent);

    List<RuntimeVersion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getRuntimeVersionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListRuntimeVersionsRequest actualRequest = ((ListRuntimeVersionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listRuntimeVersionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockTpu.addResponse(expectedResponse);

    RuntimeVersionName name = RuntimeVersionName.of("[PROJECT]", "[LOCATION]", "[RUNTIME_VERSION]");

    RuntimeVersion actualResponse = client.getRuntimeVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeVersionRequest actualRequest = ((GetRuntimeVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeVersionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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
    mockTpu.addResponse(expectedResponse);

    String name = "name3373707";

    RuntimeVersion actualResponse = client.getRuntimeVersion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetRuntimeVersionRequest actualRequest = ((GetRuntimeVersionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getRuntimeVersionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

    try {
      String name = "name3373707";
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
    mockTpu.addResponse(expectedResponse);

    GetGuestAttributesRequest request =
        GetGuestAttributesRequest.newBuilder()
            .setName(NodeName.of("[PROJECT]", "[LOCATION]", "[NODE]").toString())
            .setQueryPath("queryPath-1807004403")
            .addAllWorkerIds(new ArrayList<String>())
            .build();

    GetGuestAttributesResponse actualResponse = client.getGuestAttributes(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockTpu.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGuestAttributesRequest actualRequest = ((GetGuestAttributesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getQueryPath(), actualRequest.getQueryPath());
    Assert.assertEquals(request.getWorkerIdsList(), actualRequest.getWorkerIdsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGuestAttributesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockTpu.addException(exception);

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
}
