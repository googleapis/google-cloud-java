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
public class GameServerConfigsServiceClientTest {
  private static MockGameServerConfigsService mockGameServerConfigsService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private GameServerConfigsServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockGameServerConfigsService = new MockGameServerConfigsService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockGameServerConfigsService));
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
  public void listGameServerConfigsTest() throws Exception {
    GameServerConfig responsesElement = GameServerConfig.newBuilder().build();
    ListGameServerConfigsResponse expectedResponse =
        ListGameServerConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerConfigs(Arrays.asList(responsesElement))
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
        ((ListGameServerConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerDeploymentName parent =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      client.listGameServerConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGameServerConfigsTest2() throws Exception {
    GameServerConfig responsesElement = GameServerConfig.newBuilder().build();
    ListGameServerConfigsResponse expectedResponse =
        ListGameServerConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerConfigs(Arrays.asList(responsesElement))
            .build();
    mockGameServerConfigsService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListGameServerConfigsPagedResponse pagedListResponse = client.listGameServerConfigs(parent);

    List<GameServerConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListGameServerConfigsRequest actualRequest =
        ((ListGameServerConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listGameServerConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listGameServerConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerConfigTest() throws Exception {
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder()
            .setName(
                GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllFleetConfigs(new ArrayList<FleetConfig>())
            .addAllScalingConfigs(new ArrayList<ScalingConfig>())
            .setDescription("description-1724546052")
            .build();
    mockGameServerConfigsService.addResponse(expectedResponse);

    GameServerConfigName name =
        GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");

    GameServerConfig actualResponse = client.getGameServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerConfigRequest actualRequest = ((GetGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerConfigName name =
          GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
      client.getGameServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGameServerConfigTest2() throws Exception {
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder()
            .setName(
                GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllFleetConfigs(new ArrayList<FleetConfig>())
            .addAllScalingConfigs(new ArrayList<ScalingConfig>())
            .setDescription("description-1724546052")
            .build();
    mockGameServerConfigsService.addResponse(expectedResponse);

    String name = "name3373707";

    GameServerConfig actualResponse = client.getGameServerConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetGameServerConfigRequest actualRequest = ((GetGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getGameServerConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      String name = "name3373707";
      client.getGameServerConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGameServerConfigTest() throws Exception {
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder()
            .setName(
                GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllFleetConfigs(new ArrayList<FleetConfig>())
            .addAllScalingConfigs(new ArrayList<ScalingConfig>())
            .setDescription("description-1724546052")
            .build();
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
        ((CreateGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(gameServerConfig, actualRequest.getGameServerConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerDeploymentName parent =
          GameServerDeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
      GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();
      client.createGameServerConfigAsync(parent, gameServerConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createGameServerConfigTest2() throws Exception {
    GameServerConfig expectedResponse =
        GameServerConfig.newBuilder()
            .setName(
                GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]")
                    .toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .addAllFleetConfigs(new ArrayList<FleetConfig>())
            .addAllScalingConfigs(new ArrayList<ScalingConfig>())
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerConfigsService.addResponse(resultOperation);

    String parent = "parent-995424086";
    GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();

    GameServerConfig actualResponse =
        client.createGameServerConfigAsync(parent, gameServerConfig).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateGameServerConfigRequest actualRequest =
        ((CreateGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(gameServerConfig, actualRequest.getGameServerConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createGameServerConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      String parent = "parent-995424086";
      GameServerConfig gameServerConfig = GameServerConfig.newBuilder().build();
      client.createGameServerConfigAsync(parent, gameServerConfig).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
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

    client.deleteGameServerConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerConfigRequest actualRequest =
        ((DeleteGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      GameServerConfigName name =
          GameServerConfigName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[CONFIG]");
      client.deleteGameServerConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteGameServerConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGameServerConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockGameServerConfigsService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteGameServerConfigAsync(name).get();

    List<AbstractMessage> actualRequests = mockGameServerConfigsService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteGameServerConfigRequest actualRequest =
        ((DeleteGameServerConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteGameServerConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockGameServerConfigsService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteGameServerConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
