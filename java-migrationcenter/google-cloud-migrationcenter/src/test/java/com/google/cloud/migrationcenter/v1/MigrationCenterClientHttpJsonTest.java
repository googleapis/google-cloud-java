/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.migrationcenter.v1;

import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListAssetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListErrorFramesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListGroupsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportDataFilesPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListImportJobsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListLocationsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListPreferenceSetsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportConfigsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListReportsPagedResponse;
import static com.google.cloud.migrationcenter.v1.MigrationCenterClient.ListSourcesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.migrationcenter.v1.stub.HttpJsonMigrationCenterStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
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
public class MigrationCenterClientHttpJsonTest {
  private static MockHttpService mockService;
  private static MigrationCenterClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonMigrationCenterStub.getMethodDescriptors(),
            MigrationCenterSettings.getDefaultEndpoint());
    MigrationCenterSettings settings =
        MigrationCenterSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                MigrationCenterSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = MigrationCenterClient.create(settings);
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
  public void listAssetsTest() throws Exception {
    Asset responsesElement = Asset.newBuilder().build();
    ListAssetsResponse expectedResponse =
        ListAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

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
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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

    String parent = "projects/project-5833/locations/location-5833";

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
      String parent = "projects/project-5833/locations/location-5833";
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
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAttributes(new HashMap<String, String>())
            .setInsightList(InsightList.newBuilder().build())
            .setPerformanceData(AssetPerformanceData.newBuilder().build())
            .addAllSources(new ArrayList<String>())
            .addAllAssignedGroups(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

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
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
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
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAttributes(new HashMap<String, String>())
            .setInsightList(InsightList.newBuilder().build())
            .setPerformanceData(AssetPerformanceData.newBuilder().build())
            .addAllSources(new ArrayList<String>())
            .addAllAssignedGroups(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3075/locations/location-3075/assets/asset-3075";

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
      String name = "projects/project-3075/locations/location-3075/assets/asset-3075";
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAttributes(new HashMap<String, String>())
            .setInsightList(InsightList.newBuilder().build())
            .setPerformanceData(AssetPerformanceData.newBuilder().build())
            .addAllSources(new ArrayList<String>())
            .addAllAssignedGroups(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    Asset asset =
        Asset.newBuilder()
            .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .putAllAttributes(new HashMap<String, String>())
            .setInsightList(InsightList.newBuilder().build())
            .setPerformanceData(AssetPerformanceData.newBuilder().build())
            .addAllSources(new ArrayList<String>())
            .addAllAssignedGroups(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Asset actualResponse = client.updateAsset(asset, updateMask);
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
              .setName(AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .putAllAttributes(new HashMap<String, String>())
              .setInsightList(InsightList.newBuilder().build())
              .setPerformanceData(AssetPerformanceData.newBuilder().build())
              .addAllSources(new ArrayList<String>())
              .addAllAssignedGroups(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAsset(asset, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateAssetsTest() throws Exception {
    BatchUpdateAssetsResponse expectedResponse =
        BatchUpdateAssetsResponse.newBuilder().addAllAssets(new ArrayList<Asset>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<UpdateAssetRequest> requests = new ArrayList<>();

    BatchUpdateAssetsResponse actualResponse = client.batchUpdateAssets(parent, requests);
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
  public void batchUpdateAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<UpdateAssetRequest> requests = new ArrayList<>();
      client.batchUpdateAssets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchUpdateAssetsTest2() throws Exception {
    BatchUpdateAssetsResponse expectedResponse =
        BatchUpdateAssetsResponse.newBuilder().addAllAssets(new ArrayList<Asset>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<UpdateAssetRequest> requests = new ArrayList<>();

    BatchUpdateAssetsResponse actualResponse = client.batchUpdateAssets(parent, requests);
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
  public void batchUpdateAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<UpdateAssetRequest> requests = new ArrayList<>();
      client.batchUpdateAssets(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");

    client.deleteAsset(name);

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
      AssetName name = AssetName.of("[PROJECT]", "[LOCATION]", "[ASSET]");
      client.deleteAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAssetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3075/locations/location-3075/assets/asset-3075";

    client.deleteAsset(name);

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
      String name = "projects/project-3075/locations/location-3075/assets/asset-3075";
      client.deleteAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteAssetsTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    List<String> names = new ArrayList<>();

    client.batchDeleteAssets(parent, names);

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
  public void batchDeleteAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      List<String> names = new ArrayList<>();
      client.batchDeleteAssets(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchDeleteAssetsTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    List<String> names = new ArrayList<>();

    client.batchDeleteAssets(parent, names);

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
  public void batchDeleteAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      List<String> names = new ArrayList<>();
      client.batchDeleteAssets(parent, names);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void reportAssetFramesTest() throws Exception {
    ReportAssetFramesResponse expectedResponse = ReportAssetFramesResponse.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ReportAssetFramesRequest request =
        ReportAssetFramesRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setFrames(Frames.newBuilder().build())
            .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();

    ReportAssetFramesResponse actualResponse = client.reportAssetFrames(request);
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
  public void reportAssetFramesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportAssetFramesRequest request =
          ReportAssetFramesRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .setFrames(Frames.newBuilder().build())
              .setSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .build();
      client.reportAssetFrames(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateAssetsValuesTest() throws Exception {
    AggregateAssetsValuesResponse expectedResponse =
        AggregateAssetsValuesResponse.newBuilder()
            .addAllResults(new ArrayList<AggregationResult>())
            .build();
    mockService.addResponse(expectedResponse);

    AggregateAssetsValuesRequest request =
        AggregateAssetsValuesRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .addAllAggregations(new ArrayList<Aggregation>())
            .setFilter("filter-1274492040")
            .build();

    AggregateAssetsValuesResponse actualResponse = client.aggregateAssetsValues(request);
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
  public void aggregateAssetsValuesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AggregateAssetsValuesRequest request =
          AggregateAssetsValuesRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
              .addAllAggregations(new ArrayList<Aggregation>())
              .setFilter("filter-1274492040")
              .build();
      client.aggregateAssetsValues(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createImportJobTest() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ImportJob importJob = ImportJob.newBuilder().build();
    String importJobId = "importJobId1449444627";

    ImportJob actualResponse = client.createImportJobAsync(parent, importJob, importJobId).get();
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
  public void createImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ImportJob importJob = ImportJob.newBuilder().build();
      String importJobId = "importJobId1449444627";
      client.createImportJobAsync(parent, importJob, importJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createImportJobTest2() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ImportJob importJob = ImportJob.newBuilder().build();
    String importJobId = "importJobId1449444627";

    ImportJob actualResponse = client.createImportJobAsync(parent, importJob, importJobId).get();
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
  public void createImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ImportJob importJob = ImportJob.newBuilder().build();
      String importJobId = "importJobId1449444627";
      client.createImportJobAsync(parent, importJob, importJobId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listImportJobsTest() throws Exception {
    ImportJob responsesElement = ImportJob.newBuilder().build();
    ListImportJobsResponse expectedResponse =
        ListImportJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListImportJobsPagedResponse pagedListResponse = client.listImportJobs(parent);

    List<ImportJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportJobsList().get(0), resources.get(0));

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
  public void listImportJobsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listImportJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listImportJobsTest2() throws Exception {
    ImportJob responsesElement = ImportJob.newBuilder().build();
    ListImportJobsResponse expectedResponse =
        ListImportJobsResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportJobs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListImportJobsPagedResponse pagedListResponse = client.listImportJobs(parent);

    List<ImportJob> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportJobsList().get(0), resources.get(0));

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
  public void listImportJobsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listImportJobs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getImportJobTest() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");

    ImportJob actualResponse = client.getImportJob(name);
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
  public void getImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      client.getImportJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getImportJobTest2() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";

    ImportJob actualResponse = client.getImportJob(name);
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
  public void getImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";
      client.getImportJob(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteImportJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");

    client.deleteImportJobAsync(name).get();

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
  public void deleteImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      client.deleteImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteImportJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";

    client.deleteImportJobAsync(name).get();

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
  public void deleteImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";
      client.deleteImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateImportJobTest() throws Exception {
    ImportJob expectedResponse =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportJob importJob =
        ImportJob.newBuilder()
            .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    ImportJob actualResponse = client.updateImportJobAsync(importJob, updateMask).get();
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
  public void updateImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJob importJob =
          ImportJob.newBuilder()
              .setName(ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setCompleteTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setAssetSource(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateImportJobAsync(importJob, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void validateImportJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("validateImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");

    client.validateImportJobAsync(name).get();

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
  public void validateImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      client.validateImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void validateImportJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("validateImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";

    client.validateImportJobAsync(name).get();

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
  public void validateImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";
      client.validateImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void runImportJobTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");

    client.runImportJobAsync(name).get();

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
  public void runImportJobExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName name = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      client.runImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void runImportJobTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("runImportJobTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";

    client.runImportJobAsync(name).get();

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
  public void runImportJobExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2869/locations/location-2869/importJobs/importJob-2869";
      client.runImportJobAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getImportDataFileTest() throws Exception {
    ImportDataFile expectedResponse =
        ImportDataFile.newBuilder()
            .setName(
                ImportDataFileName.of(
                        "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setFormat(ImportJobFormat.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ImportDataFileName name =
        ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");

    ImportDataFile actualResponse = client.getImportDataFile(name);
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
  public void getImportDataFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportDataFileName name =
          ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");
      client.getImportDataFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getImportDataFileTest2() throws Exception {
    ImportDataFile expectedResponse =
        ImportDataFile.newBuilder()
            .setName(
                ImportDataFileName.of(
                        "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setFormat(ImportJobFormat.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9665/locations/location-9665/importJobs/importJob-9665/importDataFiles/importDataFile-9665";

    ImportDataFile actualResponse = client.getImportDataFile(name);
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
  public void getImportDataFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9665/locations/location-9665/importJobs/importJob-9665/importDataFiles/importDataFile-9665";
      client.getImportDataFile(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listImportDataFilesTest() throws Exception {
    ImportDataFile responsesElement = ImportDataFile.newBuilder().build();
    ListImportDataFilesResponse expectedResponse =
        ListImportDataFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportDataFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");

    ListImportDataFilesPagedResponse pagedListResponse = client.listImportDataFiles(parent);

    List<ImportDataFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportDataFilesList().get(0), resources.get(0));

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
  public void listImportDataFilesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      client.listImportDataFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listImportDataFilesTest2() throws Exception {
    ImportDataFile responsesElement = ImportDataFile.newBuilder().build();
    ListImportDataFilesResponse expectedResponse =
        ListImportDataFilesResponse.newBuilder()
            .setNextPageToken("")
            .addAllImportDataFiles(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-900/locations/location-900/importJobs/importJob-900";

    ListImportDataFilesPagedResponse pagedListResponse = client.listImportDataFiles(parent);

    List<ImportDataFile> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getImportDataFilesList().get(0), resources.get(0));

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
  public void listImportDataFilesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-900/locations/location-900/importJobs/importJob-900";
      client.listImportDataFiles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createImportDataFileTest() throws Exception {
    ImportDataFile expectedResponse =
        ImportDataFile.newBuilder()
            .setName(
                ImportDataFileName.of(
                        "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setFormat(ImportJobFormat.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createImportDataFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
    ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
    String importDataFileId = "importDataFileId-1812510330";

    ImportDataFile actualResponse =
        client.createImportDataFileAsync(parent, importDataFile, importDataFileId).get();
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
  public void createImportDataFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportJobName parent = ImportJobName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]");
      ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
      String importDataFileId = "importDataFileId-1812510330";
      client.createImportDataFileAsync(parent, importDataFile, importDataFileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createImportDataFileTest2() throws Exception {
    ImportDataFile expectedResponse =
        ImportDataFile.newBuilder()
            .setName(
                ImportDataFileName.of(
                        "[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setFormat(ImportJobFormat.forNumber(0))
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createImportDataFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-900/locations/location-900/importJobs/importJob-900";
    ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
    String importDataFileId = "importDataFileId-1812510330";

    ImportDataFile actualResponse =
        client.createImportDataFileAsync(parent, importDataFile, importDataFileId).get();
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
  public void createImportDataFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-900/locations/location-900/importJobs/importJob-900";
      ImportDataFile importDataFile = ImportDataFile.newBuilder().build();
      String importDataFileId = "importDataFileId-1812510330";
      client.createImportDataFileAsync(parent, importDataFile, importDataFileId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteImportDataFileTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteImportDataFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportDataFileName name =
        ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");

    client.deleteImportDataFileAsync(name).get();

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
  public void deleteImportDataFileExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportDataFileName name =
          ImportDataFileName.of("[PROJECT]", "[LOCATION]", "[IMPORT_JOB]", "[IMPORT_DATA_FILE]");
      client.deleteImportDataFileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteImportDataFileTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteImportDataFileTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9665/locations/location-9665/importJobs/importJob-9665/importDataFiles/importDataFile-9665";

    client.deleteImportDataFileAsync(name).get();

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
  public void deleteImportDataFileExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9665/locations/location-9665/importJobs/importJob-9665/importDataFiles/importDataFile-9665";
      client.deleteImportDataFileAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listGroupsTest() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

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
  public void listGroupsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listGroupsTest2() throws Exception {
    Group responsesElement = Group.newBuilder().build();
    ListGroupsResponse expectedResponse =
        ListGroupsResponse.newBuilder()
            .setNextPageToken("")
            .addAllGroups(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListGroupsPagedResponse pagedListResponse = client.listGroups(parent);

    List<Group> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getGroupsList().get(0), resources.get(0));

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
  public void listGroupsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listGroups(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    Group actualResponse = client.getGroup(name);
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
  public void getGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7380/locations/location-7380/groups/group-7380";

    Group actualResponse = client.getGroup(name);
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
  public void getGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7380/locations/location-7380/groups/group-7380";
      client.getGroup(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Group group = Group.newBuilder().build();
    String groupId = "groupId293428218";

    Group actualResponse = client.createGroupAsync(parent, group, groupId).get();
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
  public void createGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Group group = Group.newBuilder().build();
      String groupId = "groupId293428218";
      client.createGroupAsync(parent, group, groupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Group group = Group.newBuilder().build();
    String groupId = "groupId293428218";

    Group actualResponse = client.createGroupAsync(parent, group, groupId).get();
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
  public void createGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Group group = Group.newBuilder().build();
      String groupId = "groupId293428218";
      client.createGroupAsync(parent, group, groupId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Group group =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Group actualResponse = client.updateGroupAsync(group, updateMask).get();
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
  public void updateGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Group group =
          Group.newBuilder()
              .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateGroupAsync(group, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGroupTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    client.deleteGroupAsync(name).get();

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
  public void deleteGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName name = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.deleteGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteGroupTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-7380/locations/location-7380/groups/group-7380";

    client.deleteGroupAsync(name).get();

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
  public void deleteGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7380/locations/location-7380/groups/group-7380";
      client.deleteGroupAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addAssetsToGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAssetsToGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    Group actualResponse = client.addAssetsToGroupAsync(group).get();
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
  public void addAssetsToGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.addAssetsToGroupAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void addAssetsToGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("addAssetsToGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String group = "projects/project-6176/locations/location-6176/groups/group-6176";

    Group actualResponse = client.addAssetsToGroupAsync(group).get();
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
  public void addAssetsToGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String group = "projects/project-6176/locations/location-6176/groups/group-6176";
      client.addAssetsToGroupAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeAssetsFromGroupTest() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeAssetsFromGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");

    Group actualResponse = client.removeAssetsFromGroupAsync(group).get();
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
  public void removeAssetsFromGroupExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GroupName group = GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]");
      client.removeAssetsFromGroupAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeAssetsFromGroupTest2() throws Exception {
    Group expectedResponse =
        Group.newBuilder()
            .setName(GroupName.of("[PROJECT]", "[LOCATION]", "[GROUP]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeAssetsFromGroupTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String group = "projects/project-6176/locations/location-6176/groups/group-6176";

    Group actualResponse = client.removeAssetsFromGroupAsync(group).get();
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
  public void removeAssetsFromGroupExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String group = "projects/project-6176/locations/location-6176/groups/group-6176";
      client.removeAssetsFromGroupAsync(group).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listErrorFramesTest() throws Exception {
    ErrorFrame responsesElement = ErrorFrame.newBuilder().build();
    ListErrorFramesResponse expectedResponse =
        ListErrorFramesResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorFrames(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    ListErrorFramesPagedResponse pagedListResponse = client.listErrorFrames(parent);

    List<ErrorFrame> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorFramesList().get(0), resources.get(0));

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
  public void listErrorFramesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName parent = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.listErrorFrames(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listErrorFramesTest2() throws Exception {
    ErrorFrame responsesElement = ErrorFrame.newBuilder().build();
    ListErrorFramesResponse expectedResponse =
        ListErrorFramesResponse.newBuilder()
            .setNextPageToken("")
            .addAllErrorFrames(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8435/locations/location-8435/sources/source-8435";

    ListErrorFramesPagedResponse pagedListResponse = client.listErrorFrames(parent);

    List<ErrorFrame> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getErrorFramesList().get(0), resources.get(0));

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
  public void listErrorFramesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-8435/locations/location-8435/sources/source-8435";
      client.listErrorFrames(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getErrorFrameTest() throws Exception {
    ErrorFrame expectedResponse =
        ErrorFrame.newBuilder()
            .setName(
                ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]")
                    .toString())
            .addAllViolations(new ArrayList<FrameViolationEntry>())
            .setOriginalFrame(AssetFrame.newBuilder().build())
            .setIngestionTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ErrorFrameName name = ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]");

    ErrorFrame actualResponse = client.getErrorFrame(name);
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
  public void getErrorFrameExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ErrorFrameName name =
          ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]");
      client.getErrorFrame(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getErrorFrameTest2() throws Exception {
    ErrorFrame expectedResponse =
        ErrorFrame.newBuilder()
            .setName(
                ErrorFrameName.of("[PROJECT]", "[LOCATION]", "[SOURCE]", "[ERROR_FRAME]")
                    .toString())
            .addAllViolations(new ArrayList<FrameViolationEntry>())
            .setOriginalFrame(AssetFrame.newBuilder().build())
            .setIngestionTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3928/locations/location-3928/sources/source-3928/errorFrames/errorFrame-3928";

    ErrorFrame actualResponse = client.getErrorFrame(name);
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
  public void getErrorFrameExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3928/locations/location-3928/sources/source-3928/errorFrames/errorFrame-3928";
      client.getErrorFrame(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

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
  public void listSourcesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSourcesTest2() throws Exception {
    Source responsesElement = Source.newBuilder().build();
    ListSourcesResponse expectedResponse =
        ListSourcesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSources(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListSourcesPagedResponse pagedListResponse = client.listSources(parent);

    List<Source> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSourcesList().get(0), resources.get(0));

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
  public void listSourcesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listSources(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    mockService.addResponse(expectedResponse);

    SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    Source actualResponse = client.getSource(name);
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
  public void getSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2226/locations/location-2226/sources/source-2226";

    Source actualResponse = client.getSource(name);
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
  public void getSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2226/locations/location-2226/sources/source-2226";
      client.getSource(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Source source = Source.newBuilder().build();
    String sourceId = "sourceId1746327190";

    Source actualResponse = client.createSourceAsync(parent, source, sourceId).get();
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
  public void createSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Source source = Source.newBuilder().build();
      String sourceId = "sourceId1746327190";
      client.createSourceAsync(parent, source, sourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSourceTest2() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Source source = Source.newBuilder().build();
    String sourceId = "sourceId1746327190";

    Source actualResponse = client.createSourceAsync(parent, source, sourceId).get();
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
  public void createSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Source source = Source.newBuilder().build();
      String sourceId = "sourceId1746327190";
      client.createSourceAsync(parent, source, sourceId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateSourceTest() throws Exception {
    Source expectedResponse =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Source source =
        Source.newBuilder()
            .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setPriority(-1165461084)
            .setManaged(true)
            .setPendingFrameCount(322639125)
            .setErrorFrameCount(1431911430)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Source actualResponse = client.updateSourceAsync(source, updateMask).get();
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
  public void updateSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Source source =
          Source.newBuilder()
              .setName(SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setPriority(-1165461084)
              .setManaged(true)
              .setPendingFrameCount(322639125)
              .setErrorFrameCount(1431911430)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSourceAsync(source, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSourceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");

    client.deleteSourceAsync(name).get();

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
  public void deleteSourceExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SourceName name = SourceName.of("[PROJECT]", "[LOCATION]", "[SOURCE]");
      client.deleteSourceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteSourceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteSourceTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2226/locations/location-2226/sources/source-2226";

    client.deleteSourceAsync(name).get();

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
  public void deleteSourceExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2226/locations/location-2226/sources/source-2226";
      client.deleteSourceAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listPreferenceSetsTest() throws Exception {
    PreferenceSet responsesElement = PreferenceSet.newBuilder().build();
    ListPreferenceSetsResponse expectedResponse =
        ListPreferenceSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPreferenceSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPreferenceSetsPagedResponse pagedListResponse = client.listPreferenceSets(parent);

    List<PreferenceSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPreferenceSetsList().get(0), resources.get(0));

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
  public void listPreferenceSetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPreferenceSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPreferenceSetsTest2() throws Exception {
    PreferenceSet responsesElement = PreferenceSet.newBuilder().build();
    ListPreferenceSetsResponse expectedResponse =
        ListPreferenceSetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllPreferenceSets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPreferenceSetsPagedResponse pagedListResponse = client.listPreferenceSets(parent);

    List<PreferenceSet> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPreferenceSetsList().get(0), resources.get(0));

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
  public void listPreferenceSetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPreferenceSets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPreferenceSetTest() throws Exception {
    PreferenceSet expectedResponse =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");

    PreferenceSet actualResponse = client.getPreferenceSet(name);
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
  public void getPreferenceSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");
      client.getPreferenceSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPreferenceSetTest2() throws Exception {
    PreferenceSet expectedResponse =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3460/locations/location-3460/preferenceSets/preferenceSet-3460";

    PreferenceSet actualResponse = client.getPreferenceSet(name);
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
  public void getPreferenceSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3460/locations/location-3460/preferenceSets/preferenceSet-3460";
      client.getPreferenceSet(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPreferenceSetTest() throws Exception {
    PreferenceSet expectedResponse =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPreferenceSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
    String preferenceSetId = "preferenceSetId-569419518";

    PreferenceSet actualResponse =
        client.createPreferenceSetAsync(parent, preferenceSet, preferenceSetId).get();
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
  public void createPreferenceSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
      String preferenceSetId = "preferenceSetId-569419518";
      client.createPreferenceSetAsync(parent, preferenceSet, preferenceSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createPreferenceSetTest2() throws Exception {
    PreferenceSet expectedResponse =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createPreferenceSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
    String preferenceSetId = "preferenceSetId-569419518";

    PreferenceSet actualResponse =
        client.createPreferenceSetAsync(parent, preferenceSet, preferenceSetId).get();
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
  public void createPreferenceSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      PreferenceSet preferenceSet = PreferenceSet.newBuilder().build();
      String preferenceSetId = "preferenceSetId-569419518";
      client.createPreferenceSetAsync(parent, preferenceSet, preferenceSetId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updatePreferenceSetTest() throws Exception {
    PreferenceSet expectedResponse =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updatePreferenceSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PreferenceSet preferenceSet =
        PreferenceSet.newBuilder()
            .setName(PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PreferenceSet actualResponse = client.updatePreferenceSetAsync(preferenceSet, updateMask).get();
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
  public void updatePreferenceSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PreferenceSet preferenceSet =
          PreferenceSet.newBuilder()
              .setName(
                  PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setVirtualMachinePreferences(VirtualMachinePreferences.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePreferenceSetAsync(preferenceSet, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePreferenceSetTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePreferenceSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");

    client.deletePreferenceSetAsync(name).get();

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
  public void deletePreferenceSetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PreferenceSetName name = PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]");
      client.deletePreferenceSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deletePreferenceSetTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deletePreferenceSetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-3460/locations/location-3460/preferenceSets/preferenceSet-3460";

    client.deletePreferenceSetAsync(name).get();

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
  public void deletePreferenceSetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3460/locations/location-3460/preferenceSets/preferenceSet-3460";
      client.deletePreferenceSetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setPreferenceSet(
                PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest2() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setPreferenceSet(
                PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7640/locations/location-7640/settings";

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7640/locations/location-7640/settings";
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setPreferenceSet(
                PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Settings settings =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setPreferenceSet(
                PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettingsAsync(settings, updateMask).get();
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
  public void updateSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Settings settings =
          Settings.newBuilder()
              .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
              .setPreferenceSet(
                  PreferenceSetName.of("[PROJECT]", "[LOCATION]", "[PREFERENCE_SET]").toString())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettingsAsync(settings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReportConfigTest() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupPreferencesetAssignments(
                new ArrayList<ReportConfig.GroupPreferenceSetAssignment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    ReportConfig reportConfig = ReportConfig.newBuilder().build();
    String reportConfigId = "reportConfigId1951664465";

    ReportConfig actualResponse =
        client.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
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
  public void createReportConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      ReportConfig reportConfig = ReportConfig.newBuilder().build();
      String reportConfigId = "reportConfigId1951664465";
      client.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReportConfigTest2() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupPreferencesetAssignments(
                new ArrayList<ReportConfig.GroupPreferenceSetAssignment>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    ReportConfig reportConfig = ReportConfig.newBuilder().build();
    String reportConfigId = "reportConfigId1951664465";

    ReportConfig actualResponse =
        client.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
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
  public void createReportConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      ReportConfig reportConfig = ReportConfig.newBuilder().build();
      String reportConfigId = "reportConfigId1951664465";
      client.createReportConfigAsync(parent, reportConfig, reportConfigId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getReportConfigTest() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupPreferencesetAssignments(
                new ArrayList<ReportConfig.GroupPreferenceSetAssignment>())
            .build();
    mockService.addResponse(expectedResponse);

    ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    ReportConfig actualResponse = client.getReportConfig(name);
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
  public void getReportConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.getReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportConfigTest2() throws Exception {
    ReportConfig expectedResponse =
        ReportConfig.newBuilder()
            .setName(ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .addAllGroupPreferencesetAssignments(
                new ArrayList<ReportConfig.GroupPreferenceSetAssignment>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2365/locations/location-2365/reportConfigs/reportConfig-2365";

    ReportConfig actualResponse = client.getReportConfig(name);
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
  public void getReportConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2365/locations/location-2365/reportConfigs/reportConfig-2365";
      client.getReportConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportConfigsTest() throws Exception {
    ReportConfig responsesElement = ReportConfig.newBuilder().build();
    ListReportConfigsResponse expectedResponse =
        ListReportConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListReportConfigsPagedResponse pagedListResponse = client.listReportConfigs(parent);

    List<ReportConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportConfigsList().get(0), resources.get(0));

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
  public void listReportConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listReportConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportConfigsTest2() throws Exception {
    ReportConfig responsesElement = ReportConfig.newBuilder().build();
    ListReportConfigsResponse expectedResponse =
        ListReportConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReportConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListReportConfigsPagedResponse pagedListResponse = client.listReportConfigs(parent);

    List<ReportConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportConfigsList().get(0), resources.get(0));

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
  public void listReportConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listReportConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReportConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    client.deleteReportConfigAsync(name).get();

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
  public void deleteReportConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConfigName name = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.deleteReportConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteReportConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReportConfigTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-2365/locations/location-2365/reportConfigs/reportConfig-2365";

    client.deleteReportConfigAsync(name).get();

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
  public void deleteReportConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2365/locations/location-2365/reportConfigs/reportConfig-2365";
      client.deleteReportConfigAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(
                ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSummary(ReportSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
    Report report = Report.newBuilder().build();
    String reportId = "reportId-427040401";

    Report actualResponse = client.createReportAsync(parent, report, reportId).get();
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
  public void createReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      Report report = Report.newBuilder().build();
      String reportId = "reportId-427040401";
      client.createReportAsync(parent, report, reportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(
                ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSummary(ReportSummary.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-9026/locations/location-9026/reportConfigs/reportConfig-9026";
    Report report = Report.newBuilder().build();
    String reportId = "reportId-427040401";

    Report actualResponse = client.createReportAsync(parent, report, reportId).get();
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
  public void createReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9026/locations/location-9026/reportConfigs/reportConfig-9026";
      Report report = Report.newBuilder().build();
      String reportId = "reportId-427040401";
      client.createReportAsync(parent, report, reportId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getReportTest() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(
                ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSummary(ReportSummary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");

    Report actualResponse = client.getReport(name);
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
  public void getReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");
      client.getReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getReportTest2() throws Exception {
    Report expectedResponse =
        Report.newBuilder()
            .setName(
                ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setSummary(ReportSummary.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-6286/locations/location-6286/reportConfigs/reportConfig-6286/reports/report-6286";

    Report actualResponse = client.getReport(name);
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
  public void getReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6286/locations/location-6286/reportConfigs/reportConfig-6286/reports/report-6286";
      client.getReport(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

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
  public void listReportsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportConfigName parent = ReportConfigName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]");
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReportsTest2() throws Exception {
    Report responsesElement = Report.newBuilder().build();
    ListReportsResponse expectedResponse =
        ListReportsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReports(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-9026/locations/location-9026/reportConfigs/reportConfig-9026";

    ListReportsPagedResponse pagedListResponse = client.listReports(parent);

    List<Report> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReportsList().get(0), resources.get(0));

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
  public void listReportsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9026/locations/location-9026/reportConfigs/reportConfig-9026";
      client.listReports(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReportTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");

    client.deleteReportAsync(name).get();

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
  public void deleteReportExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT_CONFIG]", "[REPORT]");
      client.deleteReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteReportTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteReportTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-6286/locations/location-6286/reportConfigs/reportConfig-6286/reports/report-6286";

    client.deleteReportAsync(name).get();

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
  public void deleteReportExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-6286/locations/location-6286/reportConfigs/reportConfig-6286/reports/report-6286";
      client.deleteReportAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
