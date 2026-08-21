/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.blockchainnodeengine.v1;

import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListBlockchainNodesPagedResponse;
import static com.google.cloud.blockchainnodeengine.v1.BlockchainNodeEngineClient.ListLocationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class BlockchainNodeEngineClientTest {
  private static MockBlockchainNodeEngine mockBlockchainNodeEngine;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private BlockchainNodeEngineClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockBlockchainNodeEngine = new MockBlockchainNodeEngine();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockBlockchainNodeEngine, mockLocations));
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
    BlockchainNodeEngineSettings settings =
        BlockchainNodeEngineSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = BlockchainNodeEngineClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listBlockchainNodesTest() throws Exception {
    BlockchainNode responsesElement = BlockchainNode.newBuilder().build();
    ListBlockchainNodesResponse expectedResponse =
        ListBlockchainNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlockchainNodes(Arrays.asList(responsesElement))
            .build();
    mockBlockchainNodeEngine.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBlockchainNodesPagedResponse pagedListResponse = client.listBlockchainNodes(parent);

    List<BlockchainNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlockchainNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBlockchainNodesRequest actualRequest = ((ListBlockchainNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBlockchainNodesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBlockchainNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBlockchainNodesTest2() throws Exception {
    BlockchainNode responsesElement = BlockchainNode.newBuilder().build();
    ListBlockchainNodesResponse expectedResponse =
        ListBlockchainNodesResponse.newBuilder()
            .setNextPageToken("")
            .addAllBlockchainNodes(Arrays.asList(responsesElement))
            .build();
    mockBlockchainNodeEngine.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBlockchainNodesPagedResponse pagedListResponse = client.listBlockchainNodes(parent);

    List<BlockchainNode> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBlockchainNodesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBlockchainNodesRequest actualRequest = ((ListBlockchainNodesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBlockchainNodesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBlockchainNodes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlockchainNodeTest() throws Exception {
    BlockchainNode expectedResponse =
        BlockchainNode.newBuilder()
            .setName(
                BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(BlockchainNode.ConnectionInfo.newBuilder().build())
            .setPrivateServiceConnectEnabled(true)
            .build();
    mockBlockchainNodeEngine.addResponse(expectedResponse);

    BlockchainNodeName name = BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");

    BlockchainNode actualResponse = client.getBlockchainNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBlockchainNodeRequest actualRequest = ((GetBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBlockchainNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      BlockchainNodeName name =
          BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");
      client.getBlockchainNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBlockchainNodeTest2() throws Exception {
    BlockchainNode expectedResponse =
        BlockchainNode.newBuilder()
            .setName(
                BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(BlockchainNode.ConnectionInfo.newBuilder().build())
            .setPrivateServiceConnectEnabled(true)
            .build();
    mockBlockchainNodeEngine.addResponse(expectedResponse);

    String name = "name3373707";

    BlockchainNode actualResponse = client.getBlockchainNode(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBlockchainNodeRequest actualRequest = ((GetBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBlockchainNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      String name = "name3373707";
      client.getBlockchainNode(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBlockchainNodeTest() throws Exception {
    BlockchainNode expectedResponse =
        BlockchainNode.newBuilder()
            .setName(
                BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(BlockchainNode.ConnectionInfo.newBuilder().build())
            .setPrivateServiceConnectEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBlockchainNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBlockchainNodeEngine.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
    String blockchainNodeId = "blockchainNodeId-2023686607";

    BlockchainNode actualResponse =
        client.createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlockchainNodeRequest actualRequest =
        ((CreateBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(blockchainNode, actualRequest.getBlockchainNode());
    Assert.assertEquals(blockchainNodeId, actualRequest.getBlockchainNodeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlockchainNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
      String blockchainNodeId = "blockchainNodeId-2023686607";
      client.createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBlockchainNodeTest2() throws Exception {
    BlockchainNode expectedResponse =
        BlockchainNode.newBuilder()
            .setName(
                BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(BlockchainNode.ConnectionInfo.newBuilder().build())
            .setPrivateServiceConnectEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBlockchainNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBlockchainNodeEngine.addResponse(resultOperation);

    String parent = "parent-995424086";
    BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
    String blockchainNodeId = "blockchainNodeId-2023686607";

    BlockchainNode actualResponse =
        client.createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBlockchainNodeRequest actualRequest =
        ((CreateBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(blockchainNode, actualRequest.getBlockchainNode());
    Assert.assertEquals(blockchainNodeId, actualRequest.getBlockchainNodeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBlockchainNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      String parent = "parent-995424086";
      BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
      String blockchainNodeId = "blockchainNodeId-2023686607";
      client.createBlockchainNodeAsync(parent, blockchainNode, blockchainNodeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBlockchainNodeTest() throws Exception {
    BlockchainNode expectedResponse =
        BlockchainNode.newBuilder()
            .setName(
                BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(BlockchainNode.ConnectionInfo.newBuilder().build())
            .setPrivateServiceConnectEnabled(true)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBlockchainNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBlockchainNodeEngine.addResponse(resultOperation);

    BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    BlockchainNode actualResponse =
        client.updateBlockchainNodeAsync(blockchainNode, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBlockchainNodeRequest actualRequest =
        ((UpdateBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(blockchainNode, actualRequest.getBlockchainNode());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBlockchainNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      BlockchainNode blockchainNode = BlockchainNode.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBlockchainNodeAsync(blockchainNode, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBlockchainNodeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBlockchainNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBlockchainNodeEngine.addResponse(resultOperation);

    BlockchainNodeName name = BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");

    client.deleteBlockchainNodeAsync(name).get();

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBlockchainNodeRequest actualRequest =
        ((DeleteBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBlockchainNodeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      BlockchainNodeName name =
          BlockchainNodeName.of("[PROJECT]", "[LOCATION]", "[BLOCKCHAIN_NODE]");
      client.deleteBlockchainNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteBlockchainNodeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteBlockchainNodeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockBlockchainNodeEngine.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteBlockchainNodeAsync(name).get();

    List<AbstractMessage> actualRequests = mockBlockchainNodeEngine.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBlockchainNodeRequest actualRequest =
        ((DeleteBlockchainNodeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBlockchainNodeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockBlockchainNodeEngine.addException(exception);

    try {
      String name = "name3373707";
      client.deleteBlockchainNodeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
