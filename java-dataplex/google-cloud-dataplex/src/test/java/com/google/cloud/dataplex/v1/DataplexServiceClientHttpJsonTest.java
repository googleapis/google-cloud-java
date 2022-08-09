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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dataplex.v1.stub.HttpJsonDataplexServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
public class DataplexServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static DataplexServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonDataplexServiceStub.getMethodDescriptors(),
            DataplexServiceSettings.getDefaultEndpoint());
    DataplexServiceSettings settings =
        DataplexServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                DataplexServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataplexServiceClient.create(settings);
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Lake lake = Lake.newBuilder().build();
    String lakeId = "lakeId-1110150390";

    Lake actualResponse = client.createLakeAsync(parent, lake, lakeId).get();
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
  public void createLakeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Lake lake = Lake.newBuilder().build();
      String lakeId = "lakeId-1110150390";
      client.createLakeAsync(parent, lake, lakeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Lake lake = Lake.newBuilder().build();
    String lakeId = "lakeId-1110150390";

    Lake actualResponse = client.createLakeAsync(parent, lake, lakeId).get();
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
  public void createLakeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Lake lake = Lake.newBuilder().build();
      String lakeId = "lakeId-1110150390";
      client.createLakeAsync(parent, lake, lakeId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Lake lake =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Lake actualResponse = client.updateLakeAsync(lake, updateMask).get();
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
  public void updateLakeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Lake lake =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLakeAsync(lake, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    client.deleteLakeAsync(name).get();

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
  public void deleteLakeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      client.deleteLakeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-2822/locations/location-2822/lakes/lake-2822";

    client.deleteLakeAsync(name).get();

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
  public void deleteLakeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2822/locations/location-2822/lakes/lake-2822";
      client.deleteLakeAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListLakesPagedResponse pagedListResponse = client.listLakes(parent);

    List<Lake> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLakesList().get(0), resources.get(0));

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
  public void listLakesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListLakesPagedResponse pagedListResponse = client.listLakes(parent);

    List<Lake> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLakesList().get(0), resources.get(0));

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
  public void listLakesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LakeName name = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    Lake actualResponse = client.getLake(name);
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
  public void getLakeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2822/locations/location-2822/lakes/lake-2822";

    Lake actualResponse = client.getLake(name);
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
  public void getLakeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2822/locations/location-2822/lakes/lake-2822";
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
    mockService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListLakeActionsPagedResponse pagedListResponse = client.listLakeActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listLakeActionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";

    ListLakeActionsPagedResponse pagedListResponse = client.listLakeActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listLakeActionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
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
    mockService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
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
  public void createZoneExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
    Zone zone = Zone.newBuilder().build();
    String zoneId = "zoneId-696323609";

    Zone actualResponse = client.createZoneAsync(parent, zone, zoneId).get();
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
  public void createZoneExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
      Zone zone = Zone.newBuilder().build();
      String zoneId = "zoneId-696323609";
      client.createZoneAsync(parent, zone, zoneId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Zone zone =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Zone actualResponse = client.updateZoneAsync(zone, updateMask).get();
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
  public void updateZoneExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Zone zone =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateZoneAsync(zone, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    client.deleteZoneAsync(name).get();

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
  public void deleteZoneExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-8147/locations/location-8147/lakes/lake-8147/zones/zone-8147";

    client.deleteZoneAsync(name).get();

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
  public void deleteZoneExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8147/locations/location-8147/lakes/lake-8147/zones/zone-8147";
      client.deleteZoneAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

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
  public void listZonesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";

    ListZonesPagedResponse pagedListResponse = client.listZones(parent);

    List<Zone> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getZonesList().get(0), resources.get(0));

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
  public void listZonesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
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
    mockService.addResponse(expectedResponse);

    ZoneName name = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    Zone actualResponse = client.getZone(name);
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
  public void getZoneExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8147/locations/location-8147/lakes/lake-8147/zones/zone-8147";

    Zone actualResponse = client.getZone(name);
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
  public void getZoneExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-8147/locations/location-8147/lakes/lake-8147/zones/zone-8147";
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
    mockService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListZoneActionsPagedResponse pagedListResponse = client.listZoneActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listZoneActionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";

    ListZoneActionsPagedResponse pagedListResponse = client.listZoneActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listZoneActionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
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
    mockService.addResponse(resultOperation);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
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
  public void createAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAssetAsync(parent, asset, assetId).get();
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
  public void createAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAssetAsync(parent, asset, assetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Asset asset =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Asset actualResponse = client.updateAssetAsync(asset, updateMask).get();
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
  public void updateAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Asset asset =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAssetAsync(asset, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    client.deleteAssetAsync(name).get();

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
  public void deleteAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6864/locations/location-6864/lakes/lake-6864/zones/zone-6864/assets/asset-6864";

    client.deleteAssetAsync(name).get();

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
  public void deleteAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6864/locations/location-6864/lakes/lake-6864/zones/zone-6864/assets/asset-6864";
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    ZoneName parent = ZoneName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

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
  public void listAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4052/locations/location-4052/lakes/lake-4052/zones/zone-4052";
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
    mockService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    Asset actualResponse = client.getAsset(name);
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
  public void getAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6864/locations/location-6864/lakes/lake-6864/zones/zone-6864/assets/asset-6864";

    Asset actualResponse = client.getAsset(name);
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
  public void getAssetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6864/locations/location-6864/lakes/lake-6864/zones/zone-6864/assets/asset-6864";
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
    mockService.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ZONE]", "[ASSET]");

    ListAssetActionsPagedResponse pagedListResponse = client.listAssetActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listAssetActionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-383/locations/location-383/lakes/lake-383/zones/zone-383/assets/asset-383";

    ListAssetActionsPagedResponse pagedListResponse = client.listAssetActions(parent);

    List<Action> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getActionsList().get(0), resources.get(0));

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
  public void listAssetActionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-383/locations/location-383/lakes/lake-383/zones/zone-383/assets/asset-383";
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
    mockService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Task task = Task.newBuilder().build();
    String taskId = "taskId-880873088";

    Task actualResponse = client.createTaskAsync(parent, task, taskId).get();
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
  public void createTaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Task task = Task.newBuilder().build();
      String taskId = "taskId-880873088";
      client.createTaskAsync(parent, task, taskId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
    Task task = Task.newBuilder().build();
    String taskId = "taskId-880873088";

    Task actualResponse = client.createTaskAsync(parent, task, taskId).get();
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
  public void createTaskExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
      Task task = Task.newBuilder().build();
      String taskId = "taskId-880873088";
      client.createTaskAsync(parent, task, taskId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Task task =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Task actualResponse = client.updateTaskAsync(task, updateMask).get();
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
  public void updateTaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Task task =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTaskAsync(task, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    client.deleteTaskAsync(name).get();

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
  public void deleteTaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");
      client.deleteTaskAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name = "projects/project-4700/locations/location-4700/lakes/lake-4700/tasks/task-4700";

    client.deleteTaskAsync(name).get();

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
  public void deleteTaskExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4700/locations/location-4700/lakes/lake-4700/tasks/task-4700";
      client.deleteTaskAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

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
  public void listTasksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";

    ListTasksPagedResponse pagedListResponse = client.listTasks(parent);

    List<Task> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTasksList().get(0), resources.get(0));

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
  public void listTasksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
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
    mockService.addResponse(expectedResponse);

    TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    Task actualResponse = client.getTask(name);
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
  public void getTaskExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4700/locations/location-4700/lakes/lake-4700/tasks/task-4700";

    Task actualResponse = client.getTask(name);
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
  public void getTaskExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4700/locations/location-4700/lakes/lake-4700/tasks/task-4700";
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
    mockService.addResponse(expectedResponse);

    TaskName parent = TaskName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]");

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void listJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-6691/locations/location-6691/lakes/lake-6691/tasks/task-6691";

    ListJobsPagedResponse pagedListResponse = client.listJobs(parent);

    List<Job> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getJobsList().get(0), resources.get(0));

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
  public void listJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-6691/locations/location-6691/lakes/lake-6691/tasks/task-6691";
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
    mockService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");

    Job actualResponse = client.getJob(name);
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
  public void getJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4548/locations/location-4548/lakes/lake-4548/tasks/task-4548/jobs/job-4548";

    Job actualResponse = client.getJob(name);
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
  public void getJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4548/locations/location-4548/lakes/lake-4548/tasks/task-4548/jobs/job-4548";
      client.getJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void cancelJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    JobName name = JobName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[TASK]", "[JOB]");

    client.cancelJob(name);

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
  public void cancelJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4548/locations/location-4548/lakes/lake-4548/tasks/task-4548/jobs/job-4548";

    client.cancelJob(name);

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
  public void cancelJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4548/locations/location-4548/lakes/lake-4548/tasks/task-4548/jobs/job-4548";
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
    mockService.addResponse(resultOperation);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
    Environment environment = Environment.newBuilder().build();
    String environmentId = "environmentId-950205810";

    Environment actualResponse =
        client.createEnvironmentAsync(parent, environment, environmentId).get();
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
  public void createEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");
      Environment environment = Environment.newBuilder().build();
      String environmentId = "environmentId-950205810";
      client.createEnvironmentAsync(parent, environment, environmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
    Environment environment = Environment.newBuilder().build();
    String environmentId = "environmentId-950205810";

    Environment actualResponse =
        client.createEnvironmentAsync(parent, environment, environmentId).get();
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
  public void createEnvironmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
      Environment environment = Environment.newBuilder().build();
      String environmentId = "environmentId-950205810";
      client.createEnvironmentAsync(parent, environment, environmentId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Environment environment =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Environment actualResponse = client.updateEnvironmentAsync(environment, updateMask).get();
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
  public void updateEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Environment environment =
          Environment.newBuilder()
              .setName(
                  EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]")
                      .toString())
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateEnvironmentAsync(environment, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    EnvironmentName name = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    client.deleteEnvironmentAsync(name).get();

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
  public void deleteEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EnvironmentName name =
          EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6992/locations/location-6992/lakes/lake-6992/environments/environment-6992";

    client.deleteEnvironmentAsync(name).get();

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
  public void deleteEnvironmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6992/locations/location-6992/lakes/lake-6992/environments/environment-6992";
      client.deleteEnvironmentAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    LakeName parent = LakeName.of("[PROJECT]", "[LOCATION]", "[LAKE]");

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

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
  public void listEnvironmentsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";

    ListEnvironmentsPagedResponse pagedListResponse = client.listEnvironments(parent);

    List<Environment> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getEnvironmentsList().get(0), resources.get(0));

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
  public void listEnvironmentsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8905/locations/location-8905/lakes/lake-8905";
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
    mockService.addResponse(expectedResponse);

    EnvironmentName name = EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    Environment actualResponse = client.getEnvironment(name);
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
  public void getEnvironmentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6992/locations/location-6992/lakes/lake-6992/environments/environment-6992";

    Environment actualResponse = client.getEnvironment(name);
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
  public void getEnvironmentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6992/locations/location-6992/lakes/lake-6992/environments/environment-6992";
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
    mockService.addResponse(expectedResponse);

    EnvironmentName parent =
        EnvironmentName.of("[PROJECT]", "[LOCATION]", "[LAKE]", "[ENVIRONMENT]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-353/locations/location-353/lakes/lake-353/environments/environment-353";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-353/locations/location-353/lakes/lake-353/environments/environment-353";
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
    mockService.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("projects/project-3664")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

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
  public void listLocationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("projects/project-3664")
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
    mockService.addResponse(expectedResponse);

    GetLocationRequest request =
        GetLocationRequest.newBuilder()
            .setName("projects/project-9062/locations/location-9062")
            .build();

    Location actualResponse = client.getLocation(request);
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
  public void getLocationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GetLocationRequest request =
          GetLocationRequest.newBuilder()
              .setName("projects/project-9062/locations/location-9062")
              .build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
