/*
 * Copyright 2020 Google LLC
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

import static com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

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
public class GameServerClustersServiceClientTest {
  private static MockServiceHelper mockServiceHelper;
  private GameServerClustersServiceClient client;
  private static MockGameServerClustersService mockGameServerClustersService;
  private LocalChannelProvider channelProvider;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerClustersService = new MockGameServerClustersService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGameServerClustersService));
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
  public void listGameServerClustersTest() throws Exception {
    GameServerCluster responsesElement = GameServerCluster.newBuilder().build();
    ListGameServerClustersResponse expectedResponse =
        ListGameServerClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerClusters(Arrays.asList(responsesElement))
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    ListGameServerClustersPagedResponse pagedListResponse = client.listGameServerClusters(parent);

    List<GameServerCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerClustersRequest actualRequest =
        ((ListGameServerClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerClustersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      client.listGameServerClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGameServerClustersTest2() throws Exception {
    GameServerCluster responsesElement = GameServerCluster.newBuilder().build();
    ListGameServerClustersResponse expectedResponse =
        ListGameServerClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerClusters(Arrays.asList(responsesElement))
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGameServerClustersPagedResponse pagedListResponse = client.listGameServerClusters(parent);

    List<GameServerCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerClustersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerClustersRequest actualRequest =
        ((ListGameServerClustersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerClustersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGameServerClusters(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerClusterTest() throws Exception {
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    GameServerClusterName name =
        GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");

    GameServerCluster actualResponse = client.getGameServerCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerClusterRequest actualRequest =
        ((GetGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      GameServerClusterName name =
          GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
      client.getGameServerCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerClusterTest2() throws Exception {
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    String name = "name3373707";

    GameServerCluster actualResponse = client.getGameServerCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerClusterRequest actualRequest =
        ((GetGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String name = "name3373707";
      client.getGameServerCluster(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGameServerClusterTest() throws Exception {
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
    String gameServerClusterId = "gameServerClusterId-1301104032";

    GameServerCluster actualResponse =
        client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerClusterRequest actualRequest =
        ((CreateGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gameServerCluster, actualRequest.getGameServerCluster());
    Assert.assertEquals(gameServerClusterId, actualRequest.getGameServerClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      String gameServerClusterId = "gameServerClusterId-1301104032";
      client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGameServerClusterTest2() throws Exception {
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    String parent = "parent-995424086";
    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
    String gameServerClusterId = "gameServerClusterId-1301104032";

    GameServerCluster actualResponse =
        client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerClusterRequest actualRequest =
        ((CreateGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gameServerCluster, actualRequest.getGameServerCluster());
    Assert.assertEquals(gameServerClusterId, actualRequest.getGameServerClusterId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String parent = "parent-995424086";
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      String gameServerClusterId = "gameServerClusterId-1301104032";
      client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewCreateGameServerClusterTest() throws Exception {
    PreviewCreateGameServerClusterResponse expectedResponse =
        PreviewCreateGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewCreateGameServerClusterRequest request =
        PreviewCreateGameServerClusterRequest.newBuilder()
            .setParent(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setGameServerClusterId("gameServerClusterId-1301104032")
            .setGameServerCluster(GameServerCluster.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewCreateGameServerClusterResponse actualResponse =
        client.previewCreateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewCreateGameServerClusterRequest actualRequest =
        ((PreviewCreateGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGameServerClusterId(), actualRequest.getGameServerClusterId());
    Assert.assertEquals(request.getGameServerCluster(), actualRequest.getGameServerCluster());
    Assert.assertEquals(request.getPreviewTime(), actualRequest.getPreviewTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewCreateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewCreateGameServerClusterRequest request =
          PreviewCreateGameServerClusterRequest.newBuilder()
              .setParent(
                  GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                      .toString())
              .setGameServerClusterId("gameServerClusterId-1301104032")
              .setGameServerCluster(GameServerCluster.newBuilder().build())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      client.previewCreateGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteGameServerClusterTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    GameServerClusterName name =
        GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");

    client.deleteGameServerClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerClusterRequest actualRequest =
        ((DeleteGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      GameServerClusterName name =
          GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
      client.deleteGameServerClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGameServerClusterTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerClustersService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGameServerClusterAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerClusterRequest actualRequest =
        ((DeleteGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerClusterExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGameServerClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewDeleteGameServerClusterTest() throws Exception {
    PreviewDeleteGameServerClusterResponse expectedResponse =
        PreviewDeleteGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewDeleteGameServerClusterRequest request =
        PreviewDeleteGameServerClusterRequest.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewDeleteGameServerClusterResponse actualResponse =
        client.previewDeleteGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewDeleteGameServerClusterRequest actualRequest =
        ((PreviewDeleteGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getPreviewTime(), actualRequest.getPreviewTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewDeleteGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewDeleteGameServerClusterRequest request =
          PreviewDeleteGameServerClusterRequest.newBuilder()
              .setName(
                  GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                      .toString())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      client.previewDeleteGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateGameServerClusterTest() throws Exception {
    GameServerCluster expectedResponse =
        GameServerCluster.newBuilder()
            .setName(
                GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
            .setEtag("etag3123477")
            .setDescription("description-1724546052")
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
        ((UpdateGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(gameServerCluster, actualRequest.getGameServerCluster());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void previewUpdateGameServerClusterTest() throws Exception {
    PreviewUpdateGameServerClusterResponse expectedResponse =
        PreviewUpdateGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockGameServerClustersService.addResponse(expectedResponse);

    PreviewUpdateGameServerClusterRequest request =
        PreviewUpdateGameServerClusterRequest.newBuilder()
            .setGameServerCluster(GameServerCluster.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewUpdateGameServerClusterResponse actualResponse =
        client.previewUpdateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerClustersService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PreviewUpdateGameServerClusterRequest actualRequest =
        ((PreviewUpdateGameServerClusterRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGameServerCluster(), actualRequest.getGameServerCluster());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertEquals(request.getPreviewTime(), actualRequest.getPreviewTime());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void previewUpdateGameServerClusterExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerClustersService.addException(exception);

    try {
      PreviewUpdateGameServerClusterRequest request =
          PreviewUpdateGameServerClusterRequest.newBuilder()
              .setGameServerCluster(GameServerCluster.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .setPreviewTime(Timestamp.newBuilder().build())
              .build();
      client.previewUpdateGameServerCluster(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
