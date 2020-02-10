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

import static com.google.cloud.gaming.v1alpha.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

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
public class GameServerClustersServiceClientTest {
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper serviceHelper;
  private GameServerClustersServiceClient client;
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
    GameServerClustersServiceSettings settings =
        GameServerClustersServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GameServerClustersServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGameServerClustersTest() {
    String nextPageToken = "";
    GameServerCluster gameServerClustersElement = GameServerCluster.newBuilder().build();
    List<GameServerCluster> gameServerClusters = Arrays.asList(gameServerClustersElement);
    ListGameServerClustersResponse expectedResponse =
        ListGameServerClustersResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllGameServerClusters(gameServerClusters)
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    String formattedParent =
        GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

    ListGameServerClustersPagedResponse pagedListResponse =
        client.listGameServerClusters(formattedParent);

    List<GameServerCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerClustersRequest actualRequest =
        (ListGameServerClustersRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listGameServerClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String formattedParent =
          GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");

      client.listGameServerClusters(formattedParent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerClusterTest() {
    String name2 = "name2-1052831874";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(name2)
            .setEtag(etag)
            .setDescription(description)
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    String formattedName =
        GameServerClustersServiceClient.formatGameServerClusterName(
            "[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");

    GameServerCluster actualResponse = client.getGameServerCluster(formattedName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerClusterRequest actualRequest = (GetGameServerClusterRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String formattedName =
          GameServerClustersServiceClient.formatGameServerClusterName(
              "[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");

      client.getGameServerCluster(formattedName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerClusterTest() throws Exception {
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(name)
            .setEtag(etag)
            .setDescription(description)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    String formattedParent =
        GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
    String gameServerClusterId = "gameServerClusterId-858763025";
    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();

    GameServerCluster actualResponse =
        client
            .createGameServerClusterAsync(formattedParent, gameServerClusterId, gameServerCluster)
            .get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerClusterRequest actualRequest =
        (CreateGameServerClusterRequest) actualRequests.get(0);

    Assert.assertEquals(formattedParent, actualRequest.getParent());
    Assert.assertEquals(gameServerClusterId, actualRequest.getGameServerClusterId());
    Assert.assertEquals(gameServerCluster, actualRequest.getGameServerCluster());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String formattedParent =
          GameServerClustersServiceClient.formatRealmName("[PROJECT]", "[LOCATION]", "[REALM]");
      String gameServerClusterId = "gameServerClusterId-858763025";
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();

      client
          .createGameServerClusterAsync(formattedParent, gameServerClusterId, gameServerCluster)
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
  public void deleteGameServerClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    String formattedName =
        GameServerClustersServiceClient.formatGameServerClusterName(
            "[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");

    Empty actualResponse = client.deleteGameServerClusterAsync(formattedName).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerClusterRequest actualRequest =
        (DeleteGameServerClusterRequest) actualRequests.get(0);

    Assert.assertEquals(formattedName, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String formattedName =
          GameServerClustersServiceClient.formatGameServerClusterName(
              "[PROJECT]", "[LOCATION]", "[REALM]", "[GAME_SERVER_CLUSTER]");

      client.deleteGameServerClusterAsync(formattedName).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerClusterTest() throws Exception {
    String name = "name3373707";
    String etag = "etag3123477";
    String description = "description-1724546052";
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(name)
            .setEtag(etag)
            .setDescription(description)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GameServerCluster actualResponse =
        client.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateGameServerClusterRequest actualRequest =
        (UpdateGameServerClusterRequest) actualRequests.get(0);

    Assert.assertEquals(gameServerCluster, actualRequest.getGameServerCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void updateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();

      client.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void previewCreateGameServerClusterTest() {
    String etag = "etag3123477";
    PreviewCreateGameServerClusterResponse expectedResponse =
        PreviewCreateGameServerClusterResponse.newBuilder().setEtag(etag).build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewCreateGameServerClusterRequest request =
        PreviewCreateGameServerClusterRequest.newBuilder().build();

    PreviewCreateGameServerClusterResponse actualResponse =
        client.previewCreateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewCreateGameServerClusterRequest actualRequest =
        (PreviewCreateGameServerClusterRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void previewCreateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewCreateGameServerClusterRequest request =
          PreviewCreateGameServerClusterRequest.newBuilder().build();

      client.previewCreateGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void previewDeleteGameServerClusterTest() {
    String etag = "etag3123477";
    PreviewDeleteGameServerClusterResponse expectedResponse =
        PreviewDeleteGameServerClusterResponse.newBuilder().setEtag(etag).build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewDeleteGameServerClusterRequest request =
        PreviewDeleteGameServerClusterRequest.newBuilder().build();

    PreviewDeleteGameServerClusterResponse actualResponse =
        client.previewDeleteGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewDeleteGameServerClusterRequest actualRequest =
        (PreviewDeleteGameServerClusterRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void previewDeleteGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewDeleteGameServerClusterRequest request =
          PreviewDeleteGameServerClusterRequest.newBuilder().build();

      client.previewDeleteGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void previewUpdateGameServerClusterTest() {
    String etag = "etag3123477";
    PreviewUpdateGameServerClusterResponse expectedResponse =
        PreviewUpdateGameServerClusterResponse.newBuilder().setEtag(etag).build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewUpdateGameServerClusterRequest request =
        PreviewUpdateGameServerClusterRequest.newBuilder().build();

    PreviewUpdateGameServerClusterResponse actualResponse =
        client.previewUpdateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewUpdateGameServerClusterRequest actualRequest =
        (PreviewUpdateGameServerClusterRequest) actualRequests.get(0);

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void previewUpdateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewUpdateGameServerClusterRequest request =
          PreviewUpdateGameServerClusterRequest.newBuilder().build();

      client.previewUpdateGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }
}
