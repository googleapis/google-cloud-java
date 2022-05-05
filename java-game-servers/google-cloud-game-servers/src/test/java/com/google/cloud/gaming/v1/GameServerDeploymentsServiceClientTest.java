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

package com.google.cloud.gaming.v1;

import static com.google.cloud.gaming.v1.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

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
import com.google.protobuf.Empty;
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
public class GameServerDeploymentsServiceClientTest {
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GameServerDeploymentsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGameServerDeploymentsService));
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
    GameServerDeploymentsServiceSettings settings =
        GameServerDeploymentsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GameServerDeploymentsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listGameServerDeploymentsTest() throws Exception {
    GameServerDeployment responsesElement = GameServerDeployment.newBuilder().build();
    ListGameServerDeploymentsResponse expectedResponse =
        ListGameServerDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerDeployments(Arrays.asList(responsesElement))
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGameServerDeploymentsPagedResponse pagedListResponse =
        client.listGameServerDeployments(parent);

    List<GameServerDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerDeploymentsRequest actualRequest =
        ((ListGameServerDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGameServerDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGameServerDeploymentsTest2() throws Exception {
    GameServerDeployment responsesElement = GameServerDeployment.newBuilder().build();
    ListGameServerDeploymentsResponse expectedResponse =
        ListGameServerDeploymentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerDeployments(Arrays.asList(responsesElement))
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGameServerDeploymentsPagedResponse pagedListResponse =
        client.listGameServerDeployments(parent);

    List<GameServerDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerDeploymentsRequest actualRequest =
        ((ListGameServerDeploymentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerDeploymentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGameServerDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerDeploymentTest() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    GameServerDeployment actualResponse = client.getGameServerDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRequest actualRequest =
        ((GetGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.getGameServerDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerDeploymentTest2() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    String name = "name3373707";

    GameServerDeployment actualResponse = client.getGameServerDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRequest actualRequest =
        ((GetGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String name = "name3373707";
      client.getGameServerDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGameServerDeploymentTest() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();

    GameServerDeployment actualResponse =
        client.createGameServerDeploymentAsync(parent, gameServerDeployment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerDeploymentRequest actualRequest =
        ((CreateGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gameServerDeployment, actualRequest.getGameServerDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
      client.createGameServerDeploymentAsync(parent, gameServerDeployment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGameServerDeploymentTest2() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();

    GameServerDeployment actualResponse =
        client.createGameServerDeploymentAsync(parent, gameServerDeployment).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerDeploymentRequest actualRequest =
        ((CreateGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gameServerDeployment, actualRequest.getGameServerDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String parent = "parent-995424086";
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
      client.createGameServerDeploymentAsync(parent, gameServerDeployment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGameServerDeploymentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    client.deleteGameServerDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerDeploymentRequest actualRequest =
        ((DeleteGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.deleteGameServerDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGameServerDeploymentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGameServerDeploymentAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerDeploymentRequest actualRequest =
        ((DeleteGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerDeploymentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGameServerDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateGameServerDeploymentTest() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGameServerDeploymentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GameServerDeployment actualResponse =
        client.updateGameServerDeploymentAsync(gameServerDeployment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGameServerDeploymentRequest actualRequest =
        ((UpdateGameServerDeploymentRequest) actualRequests.get(0));

    Assert.assertEquals(gameServerDeployment, actualRequest.getGameServerDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGameServerDeploymentAsync(gameServerDeployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getGameServerDeploymentRolloutTest() throws Exception {
    GameServerDeploymentRollout expectedResponse =
        GameServerDeploymentRollout.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultGameServerConfig("defaultGameServerConfig-1852465704")
            .addAllGameServerConfigOverrides(new ArrayList<GameServerConfigOverride>())
            .setEtag("etag3123477")
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    GameServerDeploymentRollout actualResponse = client.getGameServerDeploymentRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRolloutRequest actualRequest =
        ((GetGameServerDeploymentRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.getGameServerDeploymentRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerDeploymentRolloutTest2() throws Exception {
    GameServerDeploymentRollout expectedResponse =
        GameServerDeploymentRollout.newBuilder()
            .setName("name3373707")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDefaultGameServerConfig("defaultGameServerConfig-1852465704")
            .addAllGameServerConfigOverrides(new ArrayList<GameServerConfigOverride>())
            .setEtag("etag3123477")
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    String name = "name3373707";

    GameServerDeploymentRollout actualResponse = client.getGameServerDeploymentRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRolloutRequest actualRequest =
        ((GetGameServerDeploymentRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerDeploymentRolloutExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String name = "name3373707";
      client.getGameServerDeploymentRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGameServerDeploymentRolloutTest() throws Exception {
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(
                GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGameServerDeploymentRolloutTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerDeploymentsService.addResponse(resultOperation);

    GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GameServerDeployment actualResponse =
        client.updateGameServerDeploymentRolloutAsync(rollout, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGameServerDeploymentRolloutRequest actualRequest =
        ((UpdateGameServerDeploymentRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGameServerDeploymentRolloutAsync(rollout, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewGameServerDeploymentRolloutTest() throws Exception {
    PreviewGameServerDeploymentRolloutResponse expectedResponse =
        PreviewGameServerDeploymentRolloutResponse.newBuilder()
            .addAllUnavailable(new ArrayList<String>())
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    PreviewGameServerDeploymentRolloutRequest request =
        PreviewGameServerDeploymentRolloutRequest.newBuilder()
            .setRollout(GameServerDeploymentRollout.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewGameServerDeploymentRolloutResponse actualResponse =
        client.previewGameServerDeploymentRollout(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewGameServerDeploymentRolloutRequest actualRequest =
        ((PreviewGameServerDeploymentRolloutRequest) actualRequests.get(0));

    Assert.assertEquals(request.getRollout(), actualRequest.getRollout());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getPreviewTime(), actualRequest.getPreviewTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      PreviewGameServerDeploymentRolloutRequest request =
          PreviewGameServerDeploymentRolloutRequest.newBuilder()
              .setRollout(GameServerDeploymentRollout.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      client.previewGameServerDeploymentRollout(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void fetchDeploymentStateTest() throws Exception {
    FetchDeploymentStateResponse expectedResponse =
        FetchDeploymentStateResponse.newBuilder()
            .addAllClusterState(new ArrayList<FetchDeploymentStateResponse.DeployedClusterState>())
            .addAllUnavailable(new ArrayList<String>())
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    FetchDeploymentStateRequest request =
        FetchDeploymentStateRequest.newBuilder().setName("name3373707").build();

    FetchDeploymentStateResponse actualResponse = client.fetchDeploymentState(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDeploymentStateRequest actualRequest =
        ((FetchDeploymentStateRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void fetchDeploymentStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      FetchDeploymentStateRequest request =
          FetchDeploymentStateRequest.newBuilder().setName("name3373707").build();
      client.fetchDeploymentState(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
