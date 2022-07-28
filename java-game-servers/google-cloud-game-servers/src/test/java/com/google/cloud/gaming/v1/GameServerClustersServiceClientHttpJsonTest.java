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

import static com.google.cloud.gaming.v1.GameServerClustersServiceClient.ListGameServerClustersPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.gaming.v1.stub.HttpJsonGameServerClustersServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class GameServerClustersServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static GameServerClustersServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonGameServerClustersServiceStub.getMethodDescriptors(),
            GameServerClustersServiceSettings.getDefaultEndpoint());
    GameServerClustersServiceSettings settings =
        GameServerClustersServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                GameServerClustersServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = GameServerClustersServiceClient.create(settings);
  }

  @AfterClass
  public static void stopServer() {
    client.close();
  }

  @Before
  public void setUp() {}

  @After
  public void tearDown() throws Exception {
    mockService.reset();
  }

  @Test
  public void listGameServerClustersTest() throws Exception {
    GameServerCluster responsesElement = GameServerCluster.newBuilder().build();
    ListGameServerClustersResponse expectedResponse =
        ListGameServerClustersResponse.newBuilder()
            .setNextPageToken("")
            .addAllGameServerClusters(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");

    ListGameServerClustersPagedResponse pagedListResponse = client.listGameServerClusters(parent);

    List<GameServerCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listGameServerClustersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3755/locations/location-3755/realms/realm-3755";

    ListGameServerClustersPagedResponse pagedListResponse = client.listGameServerClusters(parent);

    List<GameServerCluster> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGameServerClustersList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listGameServerClustersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3755/locations/location-3755/realms/realm-3755";
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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GameServerClusterName name =
        GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");

    GameServerCluster actualResponse = client.getGameServerCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4532/locations/location-4532/realms/realm-4532/gameServerClusters/gameServerCluster-4532";

    GameServerCluster actualResponse = client.getGameServerCluster(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void getGameServerClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4532/locations/location-4532/realms/realm-4532/gameServerClusters/gameServerCluster-4532";
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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
    String gameServerClusterId = "gameServerClusterId-1301104032";

    GameServerCluster actualResponse =
        client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RealmName parent = RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]");
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      String gameServerClusterId = "gameServerClusterId-1301104032";
      client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-3755/locations/location-3755/realms/realm-3755";
    GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
    String gameServerClusterId = "gameServerClusterId-1301104032";

    GameServerCluster actualResponse =
        client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void createGameServerClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3755/locations/location-3755/realms/realm-3755";
      GameServerCluster gameServerCluster = GameServerCluster.newBuilder().build();
      String gameServerClusterId = "gameServerClusterId-1301104032";
      client.createGameServerClusterAsync(parent, gameServerCluster, gameServerClusterId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void previewCreateGameServerClusterTest() throws Exception {
    PreviewCreateGameServerClusterResponse expectedResponse =
        PreviewCreateGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PreviewCreateGameServerClusterRequest request =
        PreviewCreateGameServerClusterRequest.newBuilder()
            .setParent(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
            .setGameServerClusterId("gameServerClusterId-1301104032")
            .setGameServerCluster(GameServerCluster.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .setView(GameServerClusterView.forNumber(0))
            .build();

    PreviewCreateGameServerClusterResponse actualResponse =
        client.previewCreateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void previewCreateGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PreviewCreateGameServerClusterRequest request =
          PreviewCreateGameServerClusterRequest.newBuilder()
              .setParent(RealmName.of("[PROJECT]", "[LOCATION]", "[REALM]").toString())
              .setGameServerClusterId("gameServerClusterId-1301104032")
              .setGameServerCluster(GameServerCluster.newBuilder().build())
              .setPreviewTime(Timestamp.newBuilder().build())
              .setView(GameServerClusterView.forNumber(0))
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
    mockService.addResponse(resultOperation);

    GameServerClusterName name =
        GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");

    client.deleteGameServerClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GameServerClusterName name =
          GameServerClusterName.of("[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]");
      client.deleteGameServerClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-4532/locations/location-4532/realms/realm-4532/gameServerClusters/gameServerCluster-4532";

    client.deleteGameServerClusterAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteGameServerClusterExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4532/locations/location-4532/realms/realm-4532/gameServerClusters/gameServerCluster-4532";
      client.deleteGameServerClusterAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void previewDeleteGameServerClusterTest() throws Exception {
    PreviewDeleteGameServerClusterResponse expectedResponse =
        PreviewDeleteGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

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

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void previewDeleteGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGameServerClusterTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GameServerCluster gameServerCluster =
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
            .setClusterState(KubernetesClusterState.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    GameServerCluster actualResponse =
        client.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void updateGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GameServerCluster gameServerCluster =
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
              .setClusterState(KubernetesClusterState.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGameServerClusterAsync(gameServerCluster, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void previewUpdateGameServerClusterTest() throws Exception {
    PreviewUpdateGameServerClusterResponse expectedResponse =
        PreviewUpdateGameServerClusterResponse.newBuilder()
            .setEtag("etag3123477")
            .setTargetState(TargetState.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PreviewUpdateGameServerClusterRequest request =
        PreviewUpdateGameServerClusterRequest.newBuilder()
            .setGameServerCluster(
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
                    .setClusterState(KubernetesClusterState.newBuilder().build())
                    .build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .setPreviewTime(Timestamp.newBuilder().build())
            .build();

    PreviewUpdateGameServerClusterResponse actualResponse =
        client.previewUpdateGameServerCluster(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void previewUpdateGameServerClusterExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PreviewUpdateGameServerClusterRequest request =
          PreviewUpdateGameServerClusterRequest.newBuilder()
              .setGameServerCluster(
                  GameServerCluster.newBuilder()
                      .setName(
                          GameServerClusterName.of(
                                  "[PROJECT]", "[LOCATION]", "[REALM]", "[CLUSTER]")
                              .toString())
                      .setCreateTime(Timestamp.newBuilder().build())
                      .setUpdateTime(Timestamp.newBuilder().build())
                      .putAllLabels(new HashMap<String, String>())
                      .setConnectionInfo(GameServerClusterConnectionInfo.newBuilder().build())
                      .setEtag("etag3123477")
                      .setDescription("description-1724546052")
                      .setClusterState(KubernetesClusterState.newBuilder().build())
                      .build())
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
