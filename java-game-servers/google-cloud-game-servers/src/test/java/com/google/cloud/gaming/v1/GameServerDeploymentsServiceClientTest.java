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
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@javax.annotation.Generated("by GAPIC")
public class GameServerDeploymentsServiceClientTest {
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerConfigsService mockGameServerConfigsService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper serviceHelper;
  private GameServerDeploymentsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerClustersService = new MockGameServerClustersService();
    mockGameServerConfigsService = new MockGameServerConfigsService();
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockRealmsService = new MockRealmsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockGameServerClustersService,
                mockGameServerConfigsService,
                mockGameServerDeploymentsService,
                mockRealmsService));
    serviceHelper.start();
  }

  @AfterClass
  public static void stopServer() {
    serviceHelper.stop();
  }

  @Before
  public void setUp() throws IOException {
    serviceHelper.reset();
    channelProvider = serviceHelper.createChannelProvider();
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
  @SuppressWarnings("all")
  public void listGameServerDeploymentsTest() {
    String nextPageToken = "";
    GameServerDeployment gameServerDeploymentsElement = GameServerDeployment.newBuilder().build();
    List<GameServerDeployment> gameServerDeployments = Arrays.asList(gameServerDeploymentsElement);
    ListGameServerDeploymentsResponse expectedResponse =
        ListGameServerDeploymentsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllGameServerDeployments(gameServerDeployments)
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
        (ListGameServerDeploymentsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listGameServerDeploymentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

      client.listGameServerDeployments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerDeploymentTest() {
    GameServerDeploymentName name2 =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name2.toString())
            .setEtag(etag)
            .setDescription(description)
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    GameServerDeployment actualResponse = client.getGameServerDeployment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRequest actualRequest =
        (GetGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(name, GameServerDeploymentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

      client.getGameServerDeployment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerDeploymentTest() throws Exception {
    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name.toString())
            .setEtag(etag)
            .setDescription(description)
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
        (CreateGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(parent, LocationName.parse(actualRequest.getParent()));
    Assert.assertEquals(gameServerDeployment, actualRequest.getGameServerDeployment());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();

      client.createGameServerDeploymentAsync(parent, gameServerDeployment).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
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

    Empty actualResponse = client.deleteGameServerDeploymentAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerDeploymentRequest actualRequest =
        (DeleteGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(name, GameServerDeploymentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

      client.deleteGameServerDeploymentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerDeploymentTest() throws Exception {
    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name.toString())
            .setEtag(etag)
            .setDescription(description)
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
        (UpdateGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(gameServerDeployment, actualRequest.getGameServerDeployment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerDeploymentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateGameServerDeploymentAsync(gameServerDeployment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerDeploymentRolloutTest() {
    GameServerDeploymentRolloutName name2 =
        GameServerDeploymentRolloutName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    String defaultGameServerConfig = "defaultGameServerConfig-1758159633";
    String etag = "etag3123477";
    GameServerDeploymentRollout expectedResponse =
        GameServerDeploymentRollout.newBuilder()
            .setName(name2.toString())
            .setDefaultGameServerConfig(defaultGameServerConfig)
            .setEtag(etag)
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    GameServerDeploymentRollout actualResponse = client.getGameServerDeploymentRollout(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRolloutRequest actualRequest =
        (GetGameServerDeploymentRolloutRequest) actualRequests.get(0);

    Assert.assertEquals(name, GameServerDeploymentName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentName name =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

      client.getGameServerDeploymentRollout(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerDeploymentRolloutTest() throws Exception {
    GameServerDeploymentName name =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name.toString())
            .setEtag(etag)
            .setDescription(description)
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
        (UpdateGameServerDeploymentRolloutRequest) actualRequests.get(0);

    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateGameServerDeploymentRolloutAsync(rollout, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void previewGameServerDeploymentRolloutTest() {
    String etag = "etag3123477";
    PreviewGameServerDeploymentRolloutResponse expectedResponse =
        PreviewGameServerDeploymentRolloutResponse.newBuilder().setEtag(etag).build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
    PreviewGameServerDeploymentRolloutRequest request =
        PreviewGameServerDeploymentRolloutRequest.newBuilder().setRollout(rollout).build();

    PreviewGameServerDeploymentRolloutResponse actualResponse =
        client.previewGameServerDeploymentRollout(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewGameServerDeploymentRolloutRequest actualRequest =
        (PreviewGameServerDeploymentRolloutRequest) actualRequests.get(0);

    Assert.assertEquals(rollout, actualRequest.getRollout());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void previewGameServerDeploymentRolloutExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      GameServerDeploymentRollout rollout = GameServerDeploymentRollout.newBuilder().build();
      PreviewGameServerDeploymentRolloutRequest request =
          PreviewGameServerDeploymentRolloutRequest.newBuilder().setRollout(rollout).build();

      client.previewGameServerDeploymentRollout(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void fetchDeploymentStateTest() {
    FetchDeploymentStateResponse expectedResponse =
        FetchDeploymentStateResponse.newBuilder().build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    String name = "name3373707";
    FetchDeploymentStateRequest request =
        FetchDeploymentStateRequest.newBuilder().setName(name).build();

    FetchDeploymentStateResponse actualResponse = client.fetchDeploymentState(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FetchDeploymentStateRequest actualRequest = (FetchDeploymentStateRequest) actualRequests.get(0);

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void fetchDeploymentStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerDeploymentsService.addException(exception);

    try {
      String name = "name3373707";
      FetchDeploymentStateRequest request =
          FetchDeploymentStateRequest.newBuilder().setName(name).build();

      client.fetchDeploymentState(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
