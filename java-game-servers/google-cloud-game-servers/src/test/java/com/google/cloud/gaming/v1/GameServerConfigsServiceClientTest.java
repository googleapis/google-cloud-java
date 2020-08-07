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

import static com.google.cloud.gaming.v1.GameServerConfigsServiceClient.ListGameServerConfigsPagedResponse;

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
public class GameServerConfigsServiceClientTest {
  private static MockGameServerClustersService mockGameServerClustersService;
  private static MockGameServerConfigsService mockGameServerConfigsService;
  private static MockGameServerDeploymentsService mockGameServerDeploymentsService;
  private static MockRealmsService mockRealmsService;
  private static MockServiceHelper serviceHelper;
  private GameServerConfigsServiceClient client;
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
    GameServerConfigsServiceSettings settings =
        GameServerConfigsServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GameServerConfigsServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  @SuppressWarnings("all")
  public void listGameServerConfigsTest() {
    String nextPageToken = "";
    GameServerConfig gameServerConfigsElement = GameServerConfig.newBuilder().build();
    List<GameServerConfig> gameServerConfigs = Arrays.asList(gameServerConfigsElement);
    ListGameServerConfigsResponse expectedResponse =
        ListGameServerConfigsResponse.newBuilder()
            .setNextPageToken(nextPageToken)
            .addAllGameServerConfigs(gameServerConfigs)
            .build();
    mockGameServerConfigsService.addResponse(expectedResponse);

    GameServerDeploymentName parent =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

    ListGameServerConfigsPagedResponse pagedListResponse = client.listGameServerConfigs(parent);

    List<GameServerConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());
    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerConfigsRequest actualRequest =
        (ListGameServerConfigsRequest) actualRequests.get(0);

    Assert.assertEquals(parent, GameServerDeploymentName.parse(actualRequest.getParent()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void listGameServerConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerDeploymentName parent =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");

      client.listGameServerConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerConfigTest() {
    GameServerConfigName name2 =
        GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
    String description = "description-1724546052";
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder().setName(name2.toString()).setDescription(description).build();
    mockGameServerConfigsService.addResponse(expectedResponse);

    GameServerConfigName name =
        GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");

    GameServerConfig actualResponse = client.getGameServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerConfigRequest actualRequest = (GetGameServerConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, GameServerConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void getGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerConfigName name =
          GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");

      client.getGameServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception
    }
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerConfigTest() throws Exception {
    GameServerConfigName name =
        GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
    String description = "description-1724546052";
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder().setName(name.toString()).setDescription(description).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerConfigsService.addResponse(resultOperation);

    GameServerDeploymentName parent =
        GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
    GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();

    GameServerConfig actualResponse =
        client.createGameServerConfigAsync(parent, gameServerConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerConfigRequest actualRequest =
        (CreateGameServerConfigRequest) actualRequests.get(0);

    Assert.assertEquals(parent, GameServerDeploymentName.parse(actualRequest.getParent()));
    Assert.assertEquals(gameServerConfig, actualRequest.getGameServerConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void createGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerDeploymentName parent =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();

      client.createGameServerConfigAsync(parent, gameServerConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGameServerConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerConfigsService.addResponse(resultOperation);

    GameServerConfigName name =
        GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");

    Empty actualResponse = client.deleteGameServerConfigAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerConfigRequest actualRequest =
        (DeleteGameServerConfigRequest) actualRequests.get(0);

    Assert.assertEquals(name, GameServerConfigName.parse(actualRequest.getName()));
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  @SuppressWarnings("all")
  public void deleteGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerConfigName name =
          GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");

      client.deleteGameServerConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = (InvalidArgumentException) e.getCause();
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
