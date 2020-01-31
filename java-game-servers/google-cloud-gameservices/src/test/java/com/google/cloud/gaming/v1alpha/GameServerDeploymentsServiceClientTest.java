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
package com.google.cloud.gaming.v1alpha;

import static com.google.cloud.gaming.v1alpha.GameServerDeploymentsServiceClient.ListGameServerDeploymentsPagedResponse;

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
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper serviceHelper;
  private GameServerDeploymentsServiceClient client;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerClustersService = new MockGameServerClustersService();
    mockGameServerDeploymentsService = new MockGameServerDeploymentsService();
    mockRealmsService = new MockRealmsService();
    serviceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(
                mockGameServerClustersService,
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

    String formattedParent =
        GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

    ListGameServerDeploymentsPagedResponse pagedListResponse =
        client.listGameServerDeployments(formattedParent);

    List<GameServerDeployment> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerDeploymentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerDeploymentsRequest actualRequest =
        (ListGameServerDeploymentsRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
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
      String formattedParent =
          GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");

      client.listGameServerDeployments(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerDeploymentTest() {
    String name2 = "name2-1052831874";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name2)
            .setEtag(etag)
            .setDescription(description)
            .build();
    mockGameServerDeploymentsService.addResponse(expectedResponse);

    String formattedName =
        GameServerDeploymentsServiceClient.formatGameServerDeploymentName(
            "[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");

    GameServerDeployment actualResponse = client.getGameServerDeployment(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerDeploymentRequest actualRequest =
        (GetGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          GameServerDeploymentsServiceClient.formatGameServerDeploymentName(
              "[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");

      client.getGameServerDeployment(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerDeploymentTest() throws Exception {
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name)
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

    String formattedParent =
        GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
    String deploymentId = "deploymentId51250389";
    GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();

    GameServerDeployment actualResponse =
        client
            .createGameServerDeploymentAsync(formattedParent, deploymentId, gameServerDeployment)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerDeploymentRequest actualRequest =
        (CreateGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(deploymentId, actualRequest.getDeploymentId());
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
      String formattedParent =
          GameServerDeploymentsServiceClient.formatLocationName("[PROJECT]", "[LOCATION]");
      String deploymentId = "deploymentId51250389";
      GameServerDeployment gameServerDeployment = GameServerDeployment.newBuilder().build();

      client
          .createGameServerDeploymentAsync(formattedParent, deploymentId, gameServerDeployment)
          .get();
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

    String formattedName =
        GameServerDeploymentsServiceClient.formatGameServerDeploymentName(
            "[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");

    Empty actualResponse = client.deleteGameServerDeploymentAsync(formattedName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerDeploymentsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerDeploymentRequest actualRequest =
        (DeleteGameServerDeploymentRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
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
      String formattedName =
          GameServerDeploymentsServiceClient.formatGameServerDeploymentName(
              "[PROJECT]", "[LOCATION]", "[GAME_SERVER_DEPLOYMENT]");

      client.deleteGameServerDeploymentAsync(formattedName).get();
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
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerDeployment expectedResponse =
        GameServerDeployment.newBuilder()
            .setName(name)
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
}
