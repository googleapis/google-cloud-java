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

package com.google.cloud.dataplex.v1;

import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListAssetsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListEnvironmentsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListJobsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakeActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLakesPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListSessionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListTasksPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZoneActionsPagedResponse;
import static com.google.cloud.dataplex.v1.DataplexServiceClient.ListZonesPagedResponse;

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
public class DataplexServiceClientTest {
  private static MockDataplexService mockDataplexService;
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataplexServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataplexService = new MockDataplexService();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataplexService, mockLocations, mockIAMPolicy));
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
    DataplexServiceSettings settings =
        DataplexServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataplexServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createLakeTest() throws Exception {
    Lake expectedResponse =
        Lake.newBuilder()
            .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setServiceAccount("serviceAccount1079137720")
            .setMetastore(Lake.Metastore.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .setMetastoreStatus(Lake.MetastoreStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLakeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Lake lake = Lake.newBuilder().build();
    String lakeId = "lakeId-1110150390";

    Lake actualResponse = client.createLakeAsync(parent, lake, lakeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLakeRequest actualRequest = ((CreateLakeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(lake, actualRequest.getLake());
    Assert.assertEquals(lakeId, actualRequest.getLakeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLakeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Lake lake = Lake.newBuilder().build();
      String lakeId = "lakeId-1110150390";
      client.createLakeAsync(parent, lake, lakeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLakeTest2() throws Exception {
    Lake expectedResponse =
        Lake.newBuilder()
            .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setServiceAccount("serviceAccount1079137720")
            .setMetastore(Lake.Metastore.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .setMetastoreStatus(Lake.MetastoreStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLakeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Lake lake = Lake.newBuilder().build();
    String lakeId = "lakeId-1110150390";

    Lake actualResponse = client.createLakeAsync(parent, lake, lakeId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLakeRequest actualRequest = ((CreateLakeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(lake, actualRequest.getLake());
    Assert.assertEquals(lakeId, actualRequest.getLakeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLakeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Lake lake = Lake.newBuilder().build();
      String lakeId = "lakeId-1110150390";
      client.createLakeAsync(parent, lake, lakeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateLakeTest() throws Exception {
    Lake expectedResponse =
        Lake.newBuilder()
            .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setServiceAccount("serviceAccount1079137720")
            .setMetastore(Lake.Metastore.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .setMetastoreStatus(Lake.MetastoreStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLakeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    Lake lake = Lake.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Lake actualResponse = client.updateLakeAsync(lake, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLakeRequest actualRequest = ((UpdateLakeRequest) actualRequests.get(0));

    Assert.assertEquals(lake, actualRequest.getLake());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLakeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      Lake lake = Lake.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLakeAsync(lake, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLakeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLakeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    client.deleteLakeAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLakeRequest actualRequest = ((DeleteLakeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLakeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.deleteLakeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLakeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLakeTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLakeAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLakeRequest actualRequest = ((DeleteLakeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLakeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLakeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLakesTest() throws Exception {
    Lake responsesElement = Lake.newBuilder().build();
    ListLakesResponse expectedResponse =
        ListLakesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLakes(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLakesPagedResponse pagedListResponse = client.listLakes(parent);

    List<Lake> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLakesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLakesRequest actualRequest = ((ListLakesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLakesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listLakes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLakesTest2() throws Exception {
    Lake responsesElement = Lake.newBuilder().build();
    ListLakesResponse expectedResponse =
        ListLakesResponse.newBuilder()
            .setNextPageToken("")
            .addAllLakes(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLakesPagedResponse pagedListResponse = client.listLakes(parent);

    List<Lake> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLakesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLakesRequest actualRequest = ((ListLakesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLakesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLakes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLakeTest() throws Exception {
    Lake expectedResponse =
        Lake.newBuilder()
            .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setServiceAccount("serviceAccount1079137720")
            .setMetastore(Lake.Metastore.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .setMetastoreStatus(Lake.MetastoreStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    Lake actualResponse = client.getLake(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLakeRequest actualRequest = ((GetLakeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLakeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.getLake(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLakeTest2() throws Exception {
    Lake expectedResponse =
        Lake.newBuilder()
            .setName(LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setServiceAccount("serviceAccount1079137720")
            .setMetastore(Lake.Metastore.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .setMetastoreStatus(Lake.MetastoreStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Lake actualResponse = client.getLake(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLakeRequest actualRequest = ((GetLakeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLakeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getLake(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLakeActionsTest() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListLakeActionsPagedResponse pagedListResponse = client.listLakeActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLakeActionsRequest actualRequest = ((ListLakeActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLakeActionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.listLakeActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLakeActionsTest2() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLakeActionsPagedResponse pagedListResponse = client.listLakeActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLakeActionsRequest actualRequest = ((ListLakeActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLakeActionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLakeActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setDiscoverySpec(Zone.DiscoverySpec.newBuilder().build())
            .setResourceSpec(Zone.ResourceSpec.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateZoneRequest actualRequest = ((CreateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(zoneId, actualRequest.getZoneId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createZoneTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setDiscoverySpec(Zone.DiscoverySpec.newBuilder().build())
            .setResourceSpec(Zone.ResourceSpec.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateZoneRequest actualRequest = ((CreateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(zoneId, actualRequest.getZoneId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setDiscoverySpec(Zone.DiscoverySpec.newBuilder().build())
            .setResourceSpec(Zone.ResourceSpec.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    Zone zone = Zone.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Zone actualResponse = client.updateZoneAsync(zone, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateZoneRequest actualRequest = ((UpdateZoneRequest) actualRequests.get(0));

    Assert.assertEquals(zone, actualRequest.getZone());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      Zone zone = Zone.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateZoneAsync(zone, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteZoneTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    client.deleteZoneAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteZoneRequest actualRequest = ((DeleteZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteZoneTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteZoneTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteZoneAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteZoneRequest actualRequest = ((DeleteZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listZonesTest() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZonesTest2() throws Exception {
    Zone responsesElement = Zone.newBuilder().build();
    ListZonesResponse expectedResponse =
        ListZonesResponse.newBuilder()
            .setNextPageToken("")
            .addAllZones(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZonesRequest actualRequest = ((ListZonesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZonesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listZones(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setDiscoverySpec(Zone.DiscoverySpec.newBuilder().build())
            .setResourceSpec(Zone.ResourceSpec.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getZoneTest2() throws Exception {
    Zone expectedResponse =
        Zone.newBuilder()
            .setName(ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setDiscoverySpec(Zone.DiscoverySpec.newBuilder().build())
            .setResourceSpec(Zone.ResourceSpec.newBuilder().build())
            .setAssetStatus(AssetStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Zone actualResponse = client.getZone(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetZoneRequest actualRequest = ((GetZoneRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getZoneExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getZone(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZoneActionsTest() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListZoneActionsPagedResponse pagedListResponse = client.listZoneActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZoneActionsRequest actualRequest = ((ListZoneActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZoneActionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.listZoneActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listZoneActionsTest2() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListZoneActionsPagedResponse pagedListResponse = client.listZoneActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListZoneActionsRequest actualRequest = ((ListZoneActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listZoneActionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listZoneActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setResourceSpec(Asset.ResourceSpec.newBuilder().build())
            .setResourceStatus(Asset.ResourceStatus.newBuilder().build())
            .setSecurityStatus(Asset.SecurityStatus.newBuilder().build())
            .setDiscoverySpec(Asset.DiscoverySpec.newBuilder().build())
            .setDiscoveryStatus(Asset.DiscoveryStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssetRequest actualRequest = ((CreateAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(asset, actualRequest.getAsset());
    Assert.assertEquals(assetId, actualRequest.getAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createAssetTest2() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setResourceSpec(Asset.ResourceSpec.newBuilder().build())
            .setResourceStatus(Asset.ResourceStatus.newBuilder().build())
            .setSecurityStatus(Asset.SecurityStatus.newBuilder().build())
            .setDiscoverySpec(Asset.DiscoverySpec.newBuilder().build())
            .setDiscoveryStatus(Asset.DiscoveryStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAssetRequest actualRequest = ((CreateAssetRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(asset, actualRequest.getAsset());
    Assert.assertEquals(assetId, actualRequest.getAssetId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setResourceSpec(Asset.ResourceSpec.newBuilder().build())
            .setResourceStatus(Asset.ResourceStatus.newBuilder().build())
            .setSecurityStatus(Asset.SecurityStatus.newBuilder().build())
            .setDiscoverySpec(Asset.DiscoverySpec.newBuilder().build())
            .setDiscoveryStatus(Asset.DiscoveryStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    Asset asset = Asset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Asset actualResponse = client.updateAssetAsync(asset, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAssetRequest actualRequest = ((UpdateAssetRequest) actualRequests.get(0));

    Assert.assertEquals(asset, actualRequest.getAsset());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      Asset asset = Asset.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAssetAsync(asset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAssetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssetRequest actualRequest = ((DeleteAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteAssetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAssetRequest actualRequest = ((DeleteAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listAssetsTest() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetsRequest actualRequest = ((ListAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetsTest2() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetsRequest actualRequest = ((ListAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setResourceSpec(Asset.ResourceSpec.newBuilder().build())
            .setResourceStatus(Asset.ResourceStatus.newBuilder().build())
            .setSecurityStatus(Asset.SecurityStatus.newBuilder().build())
            .setDiscoverySpec(Asset.DiscoverySpec.newBuilder().build())
            .setDiscoveryStatus(Asset.DiscoveryStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssetRequest actualRequest = ((GetAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAssetTest2() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setResourceSpec(Asset.ResourceSpec.newBuilder().build())
            .setResourceStatus(Asset.ResourceStatus.newBuilder().build())
            .setSecurityStatus(Asset.SecurityStatus.newBuilder().build())
            .setDiscoverySpec(Asset.DiscoverySpec.newBuilder().build())
            .setDiscoveryStatus(Asset.DiscoveryStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAssetRequest actualRequest = ((GetAssetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAssetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetActionsTest() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    ListAssetActionsPagedResponse pagedListResponse = client.listAssetActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetActionsRequest actualRequest = ((ListAssetActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetActionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      AssetName parent = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
      client.listAssetActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAssetActionsTest2() throws Exception {
    Action responsesElement = Action.newBuilder().build();
    ListActionsResponse expectedResponse =
        ListActionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllActions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssetActionsPagedResponse pagedListResponse = client.listAssetActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAssetActionsRequest actualRequest = ((ListAssetActionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAssetActionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAssetActions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setState(State.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .setTriggerSpec(Task.TriggerSpec.newBuilder().build())
            .setExecutionSpec(Task.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(Task.ExecutionStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTaskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Task task = Task.newBuilder().build();
    String taskId = "taskId-880873088";

    Task actualResponse = client.createTaskAsync(parent, task, taskId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaskRequest actualRequest = ((CreateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertEquals(taskId, actualRequest.getTaskId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Task task = Task.newBuilder().build();
      String taskId = "taskId-880873088";
      client.createTaskAsync(parent, task, taskId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setState(State.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .setTriggerSpec(Task.TriggerSpec.newBuilder().build())
            .setExecutionSpec(Task.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(Task.ExecutionStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createTaskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Task task = Task.newBuilder().build();
    String taskId = "taskId-880873088";

    Task actualResponse = client.createTaskAsync(parent, task, taskId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTaskRequest actualRequest = ((CreateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertEquals(taskId, actualRequest.getTaskId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Task task = Task.newBuilder().build();
      String taskId = "taskId-880873088";
      client.createTaskAsync(parent, task, taskId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setState(State.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .setTriggerSpec(Task.TriggerSpec.newBuilder().build())
            .setExecutionSpec(Task.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(Task.ExecutionStatus.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateTaskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    Task task = Task.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Task actualResponse = client.updateTaskAsync(task, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTaskRequest actualRequest = ((UpdateTaskRequest) actualRequests.get(0));

    Assert.assertEquals(task, actualRequest.getTask());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      Task task = Task.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTaskAsync(task, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTaskTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTaskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    client.deleteTaskAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaskRequest actualRequest = ((DeleteTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
      client.deleteTaskAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteTaskTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteTaskTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteTaskAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTaskRequest actualRequest = ((DeleteTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTaskAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listTasksTest() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTasksTest2() throws Exception {
    Task responsesElement = Task.newBuilder().build();
    ListTasksResponse expectedResponse =
        ListTasksResponse.newBuilder()
            .setNextPageToken("")
            .addAllTasks(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTasksRequest actualRequest = ((ListTasksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTasksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTasks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setState(State.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .setTriggerSpec(Task.TriggerSpec.newBuilder().build())
            .setExecutionSpec(Task.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(Task.ExecutionStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTaskTest2() throws Exception {
    Task expectedResponse =
        Task.newBuilder()
            .setName(TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]").toString())
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDescription("description-1724546052")
            .setDisplayName("displayName1714148973")
            .setState(State.forNumber(0))
            .putAllLabels(new HashMap<String, String>())
            .setTriggerSpec(Task.TriggerSpec.newBuilder().build())
            .setExecutionSpec(Task.ExecutionSpec.newBuilder().build())
            .setExecutionStatus(Task.ExecutionStatus.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Task actualResponse = client.getTask(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTaskRequest actualRequest = ((GetTaskRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTaskExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getTask(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    TaskName parent = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      TaskName parent = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listJobsTest2() throws Exception {
    Job responsesElement = Job.newBuilder().build();
    ListJobsResponse expectedResponse =
        ListJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllJobs(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListJobsRequest actualRequest = ((ListJobsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listJobsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setRetryCount(-928040776)
            .setServiceJob("serviceJob-1724783416")
            .setMessage("message954925063")
            .build();
    mockDataplexService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getJobTest2() throws Exception {
    Job expectedResponse =
        Job.newBuilder()
            .setName(JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]").toString())
            .setUid("uid115792")
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setRetryCount(-928040776)
            .setServiceJob("serviceJob-1724783416")
            .setMessage("message954925063")
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Job actualResponse = client.getJob(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetJobRequest actualRequest = ((GetJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataplexService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");

    client.cancelJob(name);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelJobRequest actualRequest = ((CancelJobRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelJobExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");
      client.cancelJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    client.cancelJob(name);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CancelJobRequest actualRequest = ((CancelJobRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void cancelJobExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.cancelJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setInfrastructureSpec(Environment.InfrastructureSpec.newBuilder().build())
            .setSessionSpec(Environment.SessionSpec.newBuilder().build())
            .setSessionStatus(Environment.SessionStatus.newBuilder().build())
            .setEndpoints(Environment.Endpoints.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Environment environment = Environment.newBuilder().build();
    String environmentId = "environmentId-950205810";

    Environment actualResponse =
        client.createEnvironmentAsync(parent, environment, environmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = ((CreateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertEquals(environmentId, actualRequest.getEnvironmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Environment environment = Environment.newBuilder().build();
      String environmentId = "environmentId-950205810";
      client.createEnvironmentAsync(parent, environment, environmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createEnvironmentTest2() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setInfrastructureSpec(Environment.InfrastructureSpec.newBuilder().build())
            .setSessionSpec(Environment.SessionSpec.newBuilder().build())
            .setSessionStatus(Environment.SessionStatus.newBuilder().build())
            .setEndpoints(Environment.Endpoints.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Environment environment = Environment.newBuilder().build();
    String environmentId = "environmentId-950205810";

    Environment actualResponse =
        client.createEnvironmentAsync(parent, environment, environmentId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateEnvironmentRequest actualRequest = ((CreateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertEquals(environmentId, actualRequest.getEnvironmentId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createEnvironmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      Environment environment = Environment.newBuilder().build();
      String environmentId = "environmentId-950205810";
      client.createEnvironmentAsync(parent, environment, environmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setInfrastructureSpec(Environment.InfrastructureSpec.newBuilder().build())
            .setSessionSpec(Environment.SessionSpec.newBuilder().build())
            .setSessionStatus(Environment.SessionStatus.newBuilder().build())
            .setEndpoints(Environment.Endpoints.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    Environment environment = Environment.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Environment actualResponse = client.updateEnvironmentAsync(environment, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateEnvironmentRequest actualRequest = ((UpdateEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(environment, actualRequest.getEnvironment());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      Environment environment = Environment.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnvironmentAsync(environment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnvironmentTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    EnvironmentName name = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    client.deleteEnvironmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = ((DeleteEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      EnvironmentName name =
          EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteEnvironmentTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteEnvironmentTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockDataplexService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteEnvironmentAsync(name).get();

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteEnvironmentRequest actualRequest = ((DeleteEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteEnvironmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listEnvironmentsTest() throws Exception {
    Environment responsesElement = Environment.newBuilder().build();
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnvironments(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = ((ListEnvironmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnvironmentsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.listEnvironments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listEnvironmentsTest2() throws Exception {
    Environment responsesElement = Environment.newBuilder().build();
    ListEnvironmentsResponse expectedResponse =
        ListEnvironmentsResponse.newBuilder()
            .setNextPageToken("")
            .addAllEnvironments(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListEnvironmentsRequest actualRequest = ((ListEnvironmentsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listEnvironmentsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listEnvironments(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnvironmentTest() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setInfrastructureSpec(Environment.InfrastructureSpec.newBuilder().build())
            .setSessionSpec(Environment.SessionSpec.newBuilder().build())
            .setSessionStatus(Environment.SessionStatus.newBuilder().build())
            .setEndpoints(Environment.Endpoints.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    EnvironmentName name = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      EnvironmentName name =
          EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEnvironmentTest2() throws Exception {
    Environment expectedResponse =
        Environment.newBuilder()
            .setName(
                EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]").toString())
            .setDisplayName("displayName1714148973")
            .setUid("uid115792")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDescription("description-1724546052")
            .setState(State.forNumber(0))
            .setInfrastructureSpec(Environment.InfrastructureSpec.newBuilder().build())
            .setSessionSpec(Environment.SessionSpec.newBuilder().build())
            .setSessionStatus(Environment.SessionStatus.newBuilder().build())
            .setEndpoints(Environment.Endpoints.newBuilder().build())
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String name = "name3373707";

    Environment actualResponse = client.getEnvironment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEnvironmentRequest actualRequest = ((GetEnvironmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEnvironmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String name = "name3373707";
      client.getEnvironment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    EnvironmentName parent =
        EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionsRequest actualRequest = ((ListSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      EnvironmentName parent =
          EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest2() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockDataplexService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataplexService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSessionsRequest actualRequest = ((ListSessionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSessionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataplexService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
