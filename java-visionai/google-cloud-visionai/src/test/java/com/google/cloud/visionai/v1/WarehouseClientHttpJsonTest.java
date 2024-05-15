/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.visionai.v1;

import static com.google.cloud.visionai.v1.WarehouseClient.ListAnnotationsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListAssetsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListCollectionsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListCorporaPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListDataSchemasPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListIndexEndpointsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListIndexesPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListSearchConfigsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ListSearchHypernymsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.SearchAssetsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.SearchIndexEndpointPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ViewCollectionItemsPagedResponse;
import static com.google.cloud.visionai.v1.WarehouseClient.ViewIndexedAssetsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.visionai.v1.stub.HttpJsonWarehouseStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
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
public class WarehouseClientHttpJsonTest {
  private static MockHttpService mockService;
  private static WarehouseClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonWarehouseStub.getMethodDescriptors(), WarehouseSettings.getDefaultEndpoint());
    WarehouseSettings settings =
        WarehouseSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                WarehouseSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WarehouseClient.create(settings);
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
  public void createAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAsset(parent, asset, assetId);
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
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAsset(parent, asset, assetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAssetTest2() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAsset(parent, asset, assetId);
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
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      Asset asset = Asset.newBuilder().build();
      String assetId = "assetId-704776149";
      client.createAsset(parent, asset, assetId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAssetTest() throws Exception {
    Asset expectedResponse =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Asset asset =
        Asset.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
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
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .setTtl(Duration.newBuilder().build())
              .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAsset(asset, updateMask);
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
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

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
      AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
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
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTtl(Duration.newBuilder().build())
            .setAssetGcsSource(AssetSource.AssetGcsSource.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1853/locations/location-1853/corpora/corpor-1853/assets/asset-1853";

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
          "projects/project-1853/locations/location-1853/corpora/corpor-1853/assets/asset-1853";
      client.getAsset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

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
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
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

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

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
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listAssets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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

    AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

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
      AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
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
        "projects/project-1853/locations/location-1853/corpora/corpor-1853/assets/asset-1853";

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
          "projects/project-1853/locations/location-1853/corpora/corpor-1853/assets/asset-1853";
      client.deleteAssetAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void uploadAssetTest() throws Exception {
    UploadAssetResponse expectedResponse = UploadAssetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("uploadAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UploadAssetRequest request =
        UploadAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setAssetSource(AssetSource.newBuilder().build())
            .build();

    UploadAssetResponse actualResponse = client.uploadAssetAsync(request).get();
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
  public void uploadAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UploadAssetRequest request =
          UploadAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .setAssetSource(AssetSource.newBuilder().build())
              .build();
      client.uploadAssetAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void generateRetrievalUrlTest() throws Exception {
    GenerateRetrievalUrlResponse expectedResponse =
        GenerateRetrievalUrlResponse.newBuilder().setSignedUri("signedUri1076770992").build();
    mockService.addResponse(expectedResponse);

    GenerateRetrievalUrlRequest request =
        GenerateRetrievalUrlRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .build();

    GenerateRetrievalUrlResponse actualResponse = client.generateRetrievalUrl(request);
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
  public void generateRetrievalUrlExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateRetrievalUrlRequest request =
          GenerateRetrievalUrlRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .build();
      client.generateRetrievalUrl(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeAssetTest() throws Exception {
    AnalyzeAssetResponse expectedResponse = AnalyzeAssetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("analyzeAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AnalyzeAssetRequest request =
        AnalyzeAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .build();

    AnalyzeAssetResponse actualResponse = client.analyzeAssetAsync(request).get();
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
  public void analyzeAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeAssetRequest request =
          AnalyzeAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .build();
      client.analyzeAssetAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void indexAssetTest() throws Exception {
    IndexAssetResponse expectedResponse = IndexAssetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("indexAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IndexAssetRequest request =
        IndexAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setIndex(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .build();

    IndexAssetResponse actualResponse = client.indexAssetAsync(request).get();
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
  public void indexAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexAssetRequest request =
          IndexAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .setIndex(
                  IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
              .build();
      client.indexAssetAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void removeIndexAssetTest() throws Exception {
    RemoveIndexAssetResponse expectedResponse = RemoveIndexAssetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("removeIndexAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    RemoveIndexAssetRequest request =
        RemoveIndexAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setIndex(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .build();

    RemoveIndexAssetResponse actualResponse = client.removeIndexAssetAsync(request).get();
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
  public void removeIndexAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RemoveIndexAssetRequest request =
          RemoveIndexAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .setIndex(
                  IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
              .build();
      client.removeIndexAssetAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void viewIndexedAssetsTest() throws Exception {
    IndexedAsset responsesElement = IndexedAsset.newBuilder().build();
    ViewIndexedAssetsResponse expectedResponse =
        ViewIndexedAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexedAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    IndexName index = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    ViewIndexedAssetsPagedResponse pagedListResponse = client.viewIndexedAssets(index);

    List<IndexedAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexedAssetsList().get(0), resources.get(0));

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
  public void viewIndexedAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexName index = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
      client.viewIndexedAssets(index);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void viewIndexedAssetsTest2() throws Exception {
    IndexedAsset responsesElement = IndexedAsset.newBuilder().build();
    ViewIndexedAssetsResponse expectedResponse =
        ViewIndexedAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexedAssets(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String index =
        "projects/project-3117/locations/location-3117/corpora/corpor-3117/indexes/indexe-3117";

    ViewIndexedAssetsPagedResponse pagedListResponse = client.viewIndexedAssets(index);

    List<IndexedAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexedAssetsList().get(0), resources.get(0));

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
  public void viewIndexedAssetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String index =
          "projects/project-3117/locations/location-3117/corpora/corpor-3117/indexes/indexe-3117";
      client.viewIndexedAssets(index);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
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
  public void createIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      Index index = Index.newBuilder().build();
      String indexId = "indexId1943291277";
      client.createIndexAsync(parent, index, indexId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
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
  public void createIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      Index index = Index.newBuilder().build();
      String indexId = "indexId1943291277";
      client.createIndexAsync(parent, index, indexId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    Index index =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Index actualResponse = client.updateIndexAsync(index, updateMask).get();
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
  public void updateIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Index index =
          Index.newBuilder()
              .setName(
                  IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIndexAsync(index, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    mockService.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
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
  public void getIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexTest2() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllDeployedIndexes(new ArrayList<DeployedIndexReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9254/locations/location-9254/corpora/corpor-9254/indexes/indexe-9254";

    Index actualResponse = client.getIndex(name);
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
  public void getIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9254/locations/location-9254/corpora/corpor-9254/indexes/indexe-9254";
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

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
  public void listIndexesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexesTest2() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

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
  public void listIndexesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIndexTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    client.deleteIndexAsync(name).get();

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
  public void deleteIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIndexTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9254/locations/location-9254/corpora/corpor-9254/indexes/indexe-9254";

    client.deleteIndexAsync(name).get();

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
  public void deleteIndexExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9254/locations/location-9254/corpora/corpor-9254/indexes/indexe-9254";
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCorpusTest() throws Exception {
    Corpus expectedResponse =
        Corpus.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultTtl(Duration.newBuilder().build())
            .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Corpus corpus = Corpus.newBuilder().build();

    Corpus actualResponse = client.createCorpusAsync(parent, corpus).get();
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
  public void createCorpusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Corpus corpus = Corpus.newBuilder().build();
      client.createCorpusAsync(parent, corpus).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCorpusTest() throws Exception {
    Corpus expectedResponse =
        Corpus.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultTtl(Duration.newBuilder().build())
            .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    Corpus actualResponse = client.getCorpus(name);
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
  public void getCorpusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.getCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCorpusTest2() throws Exception {
    Corpus expectedResponse =
        Corpus.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultTtl(Duration.newBuilder().build())
            .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1702/locations/location-1702/corpora/corpor-1702";

    Corpus actualResponse = client.getCorpus(name);
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
  public void getCorpusExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1702/locations/location-1702/corpora/corpor-1702";
      client.getCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCorpusTest() throws Exception {
    Corpus expectedResponse =
        Corpus.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultTtl(Duration.newBuilder().build())
            .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Corpus corpus =
        Corpus.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDefaultTtl(Duration.newBuilder().build())
            .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Corpus actualResponse = client.updateCorpus(corpus, updateMask);
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
  public void updateCorpusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Corpus corpus =
          Corpus.newBuilder()
              .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setDefaultTtl(Duration.newBuilder().build())
              .setSearchCapabilitySetting(SearchCapabilitySetting.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCorpus(corpus, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCorporaTest() throws Exception {
    Corpus responsesElement = Corpus.newBuilder().build();
    ListCorporaResponse expectedResponse =
        ListCorporaResponse.newBuilder()
            .setNextPageToken("")
            .addAllCorpora(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListCorporaPagedResponse pagedListResponse = client.listCorpora(parent);

    List<Corpus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCorporaList().get(0), resources.get(0));

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
  public void listCorporaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listCorpora(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCorpusTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    client.deleteCorpus(name);

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
  public void deleteCorpusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.deleteCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCorpusTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1702/locations/location-1702/corpora/corpor-1702";

    client.deleteCorpus(name);

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
  public void deleteCorpusExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1702/locations/location-1702/corpora/corpor-1702";
      client.deleteCorpus(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeCorpusTest() throws Exception {
    AnalyzeCorpusResponse expectedResponse = AnalyzeCorpusResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("analyzeCorpusTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    AnalyzeCorpusRequest request =
        AnalyzeCorpusRequest.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .build();

    AnalyzeCorpusResponse actualResponse = client.analyzeCorpusAsync(request).get();
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
  public void analyzeCorpusExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalyzeCorpusRequest request =
          AnalyzeCorpusRequest.newBuilder()
              .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .build();
      client.analyzeCorpusAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createDataSchemaTest() throws Exception {
    DataSchema expectedResponse =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    DataSchema dataSchema = DataSchema.newBuilder().build();

    DataSchema actualResponse = client.createDataSchema(parent, dataSchema);
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
  public void createDataSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      DataSchema dataSchema = DataSchema.newBuilder().build();
      client.createDataSchema(parent, dataSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createDataSchemaTest2() throws Exception {
    DataSchema expectedResponse =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    DataSchema dataSchema = DataSchema.newBuilder().build();

    DataSchema actualResponse = client.createDataSchema(parent, dataSchema);
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
  public void createDataSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      DataSchema dataSchema = DataSchema.newBuilder().build();
      client.createDataSchema(parent, dataSchema);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateDataSchemaTest() throws Exception {
    DataSchema expectedResponse =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataSchema dataSchema =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSchema actualResponse = client.updateDataSchema(dataSchema, updateMask);
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
  public void updateDataSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSchema dataSchema =
          DataSchema.newBuilder()
              .setName(
                  DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                      .toString())
              .setKey("key106079")
              .setSchemaDetails(DataSchemaDetails.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateDataSchema(dataSchema, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSchemaTest() throws Exception {
    DataSchema expectedResponse =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataSchemaName name =
        DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");

    DataSchema actualResponse = client.getDataSchema(name);
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
  public void getDataSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSchemaName name =
          DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");
      client.getDataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDataSchemaTest2() throws Exception {
    DataSchema expectedResponse =
        DataSchema.newBuilder()
            .setName(
                DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]")
                    .toString())
            .setKey("key106079")
            .setSchemaDetails(DataSchemaDetails.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-558/locations/location-558/corpora/corpor-558/dataSchemas/dataSchema-558";

    DataSchema actualResponse = client.getDataSchema(name);
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
  public void getDataSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-558/locations/location-558/corpora/corpor-558/dataSchemas/dataSchema-558";
      client.getDataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    DataSchemaName name =
        DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");

    client.deleteDataSchema(name);

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
  public void deleteDataSchemaExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataSchemaName name =
          DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");
      client.deleteDataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSchemaTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-558/locations/location-558/corpora/corpor-558/dataSchemas/dataSchema-558";

    client.deleteDataSchema(name);

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
  public void deleteDataSchemaExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-558/locations/location-558/corpora/corpor-558/dataSchemas/dataSchema-558";
      client.deleteDataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSchemasTest() throws Exception {
    DataSchema responsesElement = DataSchema.newBuilder().build();
    ListDataSchemasResponse expectedResponse =
        ListDataSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListDataSchemasPagedResponse pagedListResponse = client.listDataSchemas(parent);

    List<DataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSchemasList().get(0), resources.get(0));

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
  public void listDataSchemasExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.listDataSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDataSchemasTest2() throws Exception {
    DataSchema responsesElement = DataSchema.newBuilder().build();
    ListDataSchemasResponse expectedResponse =
        ListDataSchemasResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataSchemas(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

    ListDataSchemasPagedResponse pagedListResponse = client.listDataSchemas(parent);

    List<DataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSchemasList().get(0), resources.get(0));

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
  public void listDataSchemasExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listDataSchemas(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnnotationTest() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
    Annotation annotation = Annotation.newBuilder().build();
    String annotationId = "annotationId251782314";

    Annotation actualResponse = client.createAnnotation(parent, annotation, annotationId);
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
  public void createAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
      Annotation annotation = Annotation.newBuilder().build();
      String annotationId = "annotationId251782314";
      client.createAnnotation(parent, annotation, annotationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnnotationTest2() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3476/locations/location-3476/corpora/corpor-3476/assets/asset-3476";
    Annotation annotation = Annotation.newBuilder().build();
    String annotationId = "annotationId251782314";

    Annotation actualResponse = client.createAnnotation(parent, annotation, annotationId);
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
  public void createAnnotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3476/locations/location-3476/corpora/corpor-3476/assets/asset-3476";
      Annotation annotation = Annotation.newBuilder().build();
      String annotationId = "annotationId251782314";
      client.createAnnotation(parent, annotation, annotationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotationTest() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AnnotationName name =
        AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");

    Annotation actualResponse = client.getAnnotation(name);
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
  public void getAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnnotationName name =
          AnnotationName.of(
              "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");
      client.getAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnnotationTest2() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2515/locations/location-2515/corpora/corpor-2515/assets/asset-2515/annotations/annotation-2515";

    Annotation actualResponse = client.getAnnotation(name);
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
  public void getAnnotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2515/locations/location-2515/corpora/corpor-2515/assets/asset-2515/annotations/annotation-2515";
      client.getAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotationsTest() throws Exception {
    Annotation responsesElement = Annotation.newBuilder().build();
    ListAnnotationsResponse expectedResponse =
        ListAnnotationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

    ListAnnotationsPagedResponse pagedListResponse = client.listAnnotations(parent);

    List<Annotation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationsList().get(0), resources.get(0));

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
  public void listAnnotationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
      client.listAnnotations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnnotationsTest2() throws Exception {
    Annotation responsesElement = Annotation.newBuilder().build();
    ListAnnotationsResponse expectedResponse =
        ListAnnotationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnnotations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-3476/locations/location-3476/corpora/corpor-3476/assets/asset-3476";

    ListAnnotationsPagedResponse pagedListResponse = client.listAnnotations(parent);

    List<Annotation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationsList().get(0), resources.get(0));

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
  public void listAnnotationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-3476/locations/location-3476/corpora/corpor-3476/assets/asset-3476";
      client.listAnnotations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAnnotationTest() throws Exception {
    Annotation expectedResponse =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Annotation annotation =
        Annotation.newBuilder()
            .setName(
                AnnotationName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                    .toString())
            .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Annotation actualResponse = client.updateAnnotation(annotation, updateMask);
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
  public void updateAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Annotation annotation =
          Annotation.newBuilder()
              .setName(
                  AnnotationName.of(
                          "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]")
                      .toString())
              .setUserSpecifiedAnnotation(UserSpecifiedAnnotation.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAnnotation(annotation, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnnotationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AnnotationName name =
        AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");

    client.deleteAnnotation(name);

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
  public void deleteAnnotationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnnotationName name =
          AnnotationName.of(
              "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");
      client.deleteAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnnotationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-2515/locations/location-2515/corpora/corpor-2515/assets/asset-2515/annotations/annotation-2515";

    client.deleteAnnotation(name);

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
  public void deleteAnnotationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-2515/locations/location-2515/corpora/corpor-2515/assets/asset-2515/annotations/annotation-2515";
      client.deleteAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestAssetUnsupportedMethodTest() throws Exception {
    // The ingestAsset() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void clipAssetTest() throws Exception {
    ClipAssetResponse expectedResponse =
        ClipAssetResponse.newBuilder()
            .addAllTimeIndexedUris(new ArrayList<ClipAssetResponse.TimeIndexedUri>())
            .build();
    mockService.addResponse(expectedResponse);

    ClipAssetRequest request =
        ClipAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTemporalPartition(Partition.TemporalPartition.newBuilder().build())
            .build();

    ClipAssetResponse actualResponse = client.clipAsset(request);
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
  public void clipAssetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ClipAssetRequest request =
          ClipAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .setTemporalPartition(Partition.TemporalPartition.newBuilder().build())
              .build();
      client.clipAsset(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateHlsUriTest() throws Exception {
    GenerateHlsUriResponse expectedResponse =
        GenerateHlsUriResponse.newBuilder()
            .setUri("uri116076")
            .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateHlsUriRequest request =
        GenerateHlsUriRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
            .setLiveViewEnabled(true)
            .build();

    GenerateHlsUriResponse actualResponse = client.generateHlsUri(request);
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
  public void generateHlsUriExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateHlsUriRequest request =
          GenerateHlsUriRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
              .setLiveViewEnabled(true)
              .build();
      client.generateHlsUri(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importAssetsTest() throws Exception {
    ImportAssetsResponse expectedResponse = ImportAssetsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importAssetsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ImportAssetsRequest request =
        ImportAssetsRequest.newBuilder()
            .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .build();

    ImportAssetsResponse actualResponse = client.importAssetsAsync(request).get();
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
  public void importAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ImportAssetsRequest request =
          ImportAssetsRequest.newBuilder()
              .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .build();
      client.importAssetsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createSearchConfigTest() throws Exception {
    SearchConfig expectedResponse =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    SearchConfig searchConfig = SearchConfig.newBuilder().build();
    String searchConfigId = "searchConfigId1576297925";

    SearchConfig actualResponse = client.createSearchConfig(parent, searchConfig, searchConfigId);
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
  public void createSearchConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      SearchConfig searchConfig = SearchConfig.newBuilder().build();
      String searchConfigId = "searchConfigId1576297925";
      client.createSearchConfig(parent, searchConfig, searchConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSearchConfigTest2() throws Exception {
    SearchConfig expectedResponse =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    SearchConfig searchConfig = SearchConfig.newBuilder().build();
    String searchConfigId = "searchConfigId1576297925";

    SearchConfig actualResponse = client.createSearchConfig(parent, searchConfig, searchConfigId);
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
  public void createSearchConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      SearchConfig searchConfig = SearchConfig.newBuilder().build();
      String searchConfigId = "searchConfigId1576297925";
      client.createSearchConfig(parent, searchConfig, searchConfigId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSearchConfigTest() throws Exception {
    SearchConfig expectedResponse =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SearchConfig searchConfig =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SearchConfig actualResponse = client.updateSearchConfig(searchConfig, updateMask);
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
  public void updateSearchConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchConfig searchConfig =
          SearchConfig.newBuilder()
              .setName(
                  SearchConfigName.of(
                          "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                      .toString())
              .setFacetProperty(FacetProperty.newBuilder().build())
              .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSearchConfig(searchConfig, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchConfigTest() throws Exception {
    SearchConfig expectedResponse =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SearchConfigName name =
        SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");

    SearchConfig actualResponse = client.getSearchConfig(name);
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
  public void getSearchConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchConfigName name =
          SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");
      client.getSearchConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchConfigTest2() throws Exception {
    SearchConfig expectedResponse =
        SearchConfig.newBuilder()
            .setName(
                SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]")
                    .toString())
            .setFacetProperty(FacetProperty.newBuilder().build())
            .setSearchCriteriaProperty(SearchCriteriaProperty.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4415/locations/location-4415/corpora/corpor-4415/searchConfigs/searchConfig-4415";

    SearchConfig actualResponse = client.getSearchConfig(name);
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
  public void getSearchConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4415/locations/location-4415/corpora/corpor-4415/searchConfigs/searchConfig-4415";
      client.getSearchConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SearchConfigName name =
        SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");

    client.deleteSearchConfig(name);

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
  public void deleteSearchConfigExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchConfigName name =
          SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");
      client.deleteSearchConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchConfigTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4415/locations/location-4415/corpora/corpor-4415/searchConfigs/searchConfig-4415";

    client.deleteSearchConfig(name);

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
  public void deleteSearchConfigExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4415/locations/location-4415/corpora/corpor-4415/searchConfigs/searchConfig-4415";
      client.deleteSearchConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchConfigsTest() throws Exception {
    SearchConfig responsesElement = SearchConfig.newBuilder().build();
    ListSearchConfigsResponse expectedResponse =
        ListSearchConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListSearchConfigsPagedResponse pagedListResponse = client.listSearchConfigs(parent);

    List<SearchConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchConfigsList().get(0), resources.get(0));

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
  public void listSearchConfigsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.listSearchConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchConfigsTest2() throws Exception {
    SearchConfig responsesElement = SearchConfig.newBuilder().build();
    ListSearchConfigsResponse expectedResponse =
        ListSearchConfigsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchConfigs(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

    ListSearchConfigsPagedResponse pagedListResponse = client.listSearchConfigs(parent);

    List<SearchConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchConfigsList().get(0), resources.get(0));

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
  public void listSearchConfigsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listSearchConfigs(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSearchHypernymTest() throws Exception {
    SearchHypernym expectedResponse =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
    String searchHypernymId = "searchHypernymId-314707559";

    SearchHypernym actualResponse =
        client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
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
  public void createSearchHypernymExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
      String searchHypernymId = "searchHypernymId-314707559";
      client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSearchHypernymTest2() throws Exception {
    SearchHypernym expectedResponse =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
    String searchHypernymId = "searchHypernymId-314707559";

    SearchHypernym actualResponse =
        client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
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
  public void createSearchHypernymExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
      String searchHypernymId = "searchHypernymId-314707559";
      client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSearchHypernymTest() throws Exception {
    SearchHypernym expectedResponse =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    SearchHypernym searchHypernym =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SearchHypernym actualResponse = client.updateSearchHypernym(searchHypernym, updateMask);
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
  public void updateSearchHypernymExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchHypernym searchHypernym =
          SearchHypernym.newBuilder()
              .setName(
                  SearchHypernymName.of(
                          "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                      .toString())
              .setHypernym("hypernym-114309610")
              .addAllHyponyms(new ArrayList<String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSearchHypernym(searchHypernym, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchHypernymTest() throws Exception {
    SearchHypernym expectedResponse =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    SearchHypernymName name =
        SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");

    SearchHypernym actualResponse = client.getSearchHypernym(name);
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
  public void getSearchHypernymExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchHypernymName name =
          SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");
      client.getSearchHypernym(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSearchHypernymTest2() throws Exception {
    SearchHypernym expectedResponse =
        SearchHypernym.newBuilder()
            .setName(
                SearchHypernymName.of(
                        "[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]")
                    .toString())
            .setHypernym("hypernym-114309610")
            .addAllHyponyms(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3909/locations/location-3909/corpora/corpor-3909/searchHypernyms/searchHypernym-3909";

    SearchHypernym actualResponse = client.getSearchHypernym(name);
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
  public void getSearchHypernymExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3909/locations/location-3909/corpora/corpor-3909/searchHypernyms/searchHypernym-3909";
      client.getSearchHypernym(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchHypernymTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SearchHypernymName name =
        SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");

    client.deleteSearchHypernym(name);

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
  public void deleteSearchHypernymExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchHypernymName name =
          SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");
      client.deleteSearchHypernym(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchHypernymTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3909/locations/location-3909/corpora/corpor-3909/searchHypernyms/searchHypernym-3909";

    client.deleteSearchHypernym(name);

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
  public void deleteSearchHypernymExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3909/locations/location-3909/corpora/corpor-3909/searchHypernyms/searchHypernym-3909";
      client.deleteSearchHypernym(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchHypernymsTest() throws Exception {
    SearchHypernym responsesElement = SearchHypernym.newBuilder().build();
    ListSearchHypernymsResponse expectedResponse =
        ListSearchHypernymsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchHypernyms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListSearchHypernymsPagedResponse pagedListResponse = client.listSearchHypernyms(parent);

    List<SearchHypernym> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchHypernymsList().get(0), resources.get(0));

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
  public void listSearchHypernymsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.listSearchHypernyms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchHypernymsTest2() throws Exception {
    SearchHypernym responsesElement = SearchHypernym.newBuilder().build();
    ListSearchHypernymsResponse expectedResponse =
        ListSearchHypernymsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchHypernyms(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

    ListSearchHypernymsPagedResponse pagedListResponse = client.listSearchHypernyms(parent);

    List<SearchHypernym> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchHypernymsList().get(0), resources.get(0));

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
  public void listSearchHypernymsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listSearchHypernyms(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchAssetsTest() throws Exception {
    SearchResultItem responsesElement = SearchResultItem.newBuilder().build();
    SearchAssetsResponse expectedResponse =
        SearchAssetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchResultItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchAssetsRequest request =
        SearchAssetsRequest.newBuilder()
            .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
            .addAllCriteria(new ArrayList<Criteria>())
            .addAllFacetSelections(new ArrayList<FacetGroup>())
            .addAllResultAnnotationKeys(new ArrayList<String>())
            .setSearchQuery("searchQuery-552137728")
            .build();

    SearchAssetsPagedResponse pagedListResponse = client.searchAssets(request);

    List<SearchResultItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchResultItemsList().get(0), resources.get(0));

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
  public void searchAssetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchAssetsRequest request =
          SearchAssetsRequest.newBuilder()
              .setCorpus(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setContentTimeRanges(DateTimeRangeArray.newBuilder().build())
              .addAllCriteria(new ArrayList<Criteria>())
              .addAllFacetSelections(new ArrayList<FacetGroup>())
              .addAllResultAnnotationKeys(new ArrayList<String>())
              .setSearchQuery("searchQuery-552137728")
              .build();
      client.searchAssets(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchIndexEndpointTest() throws Exception {
    SearchResultItem responsesElement = SearchResultItem.newBuilder().build();
    SearchIndexEndpointResponse expectedResponse =
        SearchIndexEndpointResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchResultItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchIndexEndpointRequest request =
        SearchIndexEndpointRequest.newBuilder()
            .setIndexEndpoint(
                IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .addAllCriteria(new ArrayList<Criteria>())
            .addAllExclusionCriteria(new ArrayList<Criteria>())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchIndexEndpointPagedResponse pagedListResponse = client.searchIndexEndpoint(request);

    List<SearchResultItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchResultItemsList().get(0), resources.get(0));

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
  public void searchIndexEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchIndexEndpointRequest request =
          SearchIndexEndpointRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .addAllCriteria(new ArrayList<Criteria>())
              .addAllExclusionCriteria(new ArrayList<Criteria>())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchIndexEndpoint(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIndexEndpointTest() throws Exception {
    IndexEndpoint expectedResponse =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
    String indexEndpointId = "indexEndpointId-250889214";

    IndexEndpoint actualResponse =
        client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
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
  public void createIndexEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
      String indexEndpointId = "indexEndpointId-250889214";
      client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIndexEndpointTest2() throws Exception {
    IndexEndpoint expectedResponse =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
    String indexEndpointId = "indexEndpointId-250889214";

    IndexEndpoint actualResponse =
        client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
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
  public void createIndexEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
      String indexEndpointId = "indexEndpointId-250889214";
      client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getIndexEndpointTest() throws Exception {
    IndexEndpoint expectedResponse =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");

    IndexEndpoint actualResponse = client.getIndexEndpoint(name);
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
  public void getIndexEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
      client.getIndexEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexEndpointTest2() throws Exception {
    IndexEndpoint expectedResponse =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1372/locations/location-1372/indexEndpoints/indexEndpoint-1372";

    IndexEndpoint actualResponse = client.getIndexEndpoint(name);
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
  public void getIndexEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1372/locations/location-1372/indexEndpoints/indexEndpoint-1372";
      client.getIndexEndpoint(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexEndpointsTest() throws Exception {
    IndexEndpoint responsesElement = IndexEndpoint.newBuilder().build();
    ListIndexEndpointsResponse expectedResponse =
        ListIndexEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIndexEndpointsPagedResponse pagedListResponse = client.listIndexEndpoints(parent);

    List<IndexEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexEndpointsList().get(0), resources.get(0));

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
  public void listIndexEndpointsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIndexEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIndexEndpointsTest2() throws Exception {
    IndexEndpoint responsesElement = IndexEndpoint.newBuilder().build();
    ListIndexEndpointsResponse expectedResponse =
        ListIndexEndpointsResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexEndpoints(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListIndexEndpointsPagedResponse pagedListResponse = client.listIndexEndpoints(parent);

    List<IndexEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexEndpointsList().get(0), resources.get(0));

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
  public void listIndexEndpointsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listIndexEndpoints(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIndexEndpointTest() throws Exception {
    IndexEndpoint expectedResponse =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateIndexEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IndexEndpoint indexEndpoint =
        IndexEndpoint.newBuilder()
            .setName(IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IndexEndpoint actualResponse = client.updateIndexEndpointAsync(indexEndpoint, updateMask).get();
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
  public void updateIndexEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexEndpoint indexEndpoint =
          IndexEndpoint.newBuilder()
              .setName(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setDeployedIndex(DeployedIndex.newBuilder().build())
              .putAllLabels(new HashMap<String, String>())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIndexEndpointAsync(indexEndpoint, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIndexEndpointTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");

    client.deleteIndexEndpointAsync(name).get();

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
  public void deleteIndexEndpointExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
      client.deleteIndexEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIndexEndpointTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexEndpointTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-1372/locations/location-1372/indexEndpoints/indexEndpoint-1372";

    client.deleteIndexEndpointAsync(name).get();

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
  public void deleteIndexEndpointExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1372/locations/location-1372/indexEndpoints/indexEndpoint-1372";
      client.deleteIndexEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployIndexTest() throws Exception {
    DeployIndexResponse expectedResponse = DeployIndexResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    DeployIndexRequest request =
        DeployIndexRequest.newBuilder()
            .setIndexEndpoint(
                IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .build();

    DeployIndexResponse actualResponse = client.deployIndexAsync(request).get();
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
  public void deployIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeployIndexRequest request =
          DeployIndexRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .setDeployedIndex(DeployedIndex.newBuilder().build())
              .build();
      client.deployIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeployIndexTest() throws Exception {
    UndeployIndexResponse expectedResponse = UndeployIndexResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UndeployIndexRequest request =
        UndeployIndexRequest.newBuilder()
            .setIndexEndpoint(
                IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .build();

    UndeployIndexResponse actualResponse = client.undeployIndexAsync(request).get();
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
  public void undeployIndexExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UndeployIndexRequest request =
          UndeployIndexRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .build();
      client.undeployIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
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
  public void createCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      Collection collection = Collection.newBuilder().build();
      String collectionId = "collectionId1636075609";
      client.createCollectionAsync(parent, collection, collectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createCollectionTest2() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
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
  public void createCollectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      Collection collection = Collection.newBuilder().build();
      String collectionId = "collectionId1636075609";
      client.createCollectionAsync(parent, collection, collectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCollectionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    CollectionName name =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    client.deleteCollectionAsync(name).get();

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
  public void deleteCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName name =
          CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
      client.deleteCollectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteCollectionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-3989/locations/location-3989/corpora/corpor-3989/collections/collection-3989";

    client.deleteCollectionAsync(name).get();

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
  public void deleteCollectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3989/locations/location-3989/corpora/corpor-3989/collections/collection-3989";
      client.deleteCollectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    CollectionName name =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    Collection actualResponse = client.getCollection(name);
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
  public void getCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName name =
          CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
      client.getCollection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCollectionTest2() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3989/locations/location-3989/corpora/corpor-3989/collections/collection-3989";

    Collection actualResponse = client.getCollection(name);
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
  public void getCollectionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3989/locations/location-3989/corpora/corpor-3989/collections/collection-3989";
      client.getCollection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    mockService.addResponse(expectedResponse);

    Collection collection =
        Collection.newBuilder()
            .setName(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Collection actualResponse = client.updateCollection(collection, updateMask);
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
  public void updateCollectionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Collection collection =
          Collection.newBuilder()
              .setName(
                  CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCollection(collection, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCollectionsTest() throws Exception {
    Collection responsesElement = Collection.newBuilder().build();
    ListCollectionsResponse expectedResponse =
        ListCollectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

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
  public void listCollectionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      client.listCollections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listCollectionsTest2() throws Exception {
    Collection responsesElement = Collection.newBuilder().build();
    ListCollectionsResponse expectedResponse =
        ListCollectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollections(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

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
  public void listCollectionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7911/locations/location-7911/corpora/corpor-7911";
      client.listCollections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void addCollectionItemTest() throws Exception {
    AddCollectionItemResponse expectedResponse =
        AddCollectionItemResponse.newBuilder().setItem(CollectionItem.newBuilder().build()).build();
    mockService.addResponse(expectedResponse);

    CollectionItem item =
        CollectionItem.newBuilder()
            .setCollection(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setItemResource("itemResource287367233")
            .build();

    AddCollectionItemResponse actualResponse = client.addCollectionItem(item);
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
  public void addCollectionItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionItem item =
          CollectionItem.newBuilder()
              .setCollection(
                  CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                      .toString())
              .setItemResource("itemResource287367233")
              .build();
      client.addCollectionItem(item);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void removeCollectionItemTest() throws Exception {
    RemoveCollectionItemResponse expectedResponse =
        RemoveCollectionItemResponse.newBuilder()
            .setItem(CollectionItem.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    CollectionItem item =
        CollectionItem.newBuilder()
            .setCollection(
                CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                    .toString())
            .setItemResource("itemResource287367233")
            .build();

    RemoveCollectionItemResponse actualResponse = client.removeCollectionItem(item);
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
  public void removeCollectionItemExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionItem item =
          CollectionItem.newBuilder()
              .setCollection(
                  CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]")
                      .toString())
              .setItemResource("itemResource287367233")
              .build();
      client.removeCollectionItem(item);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void viewCollectionItemsTest() throws Exception {
    CollectionItem responsesElement = CollectionItem.newBuilder().build();
    ViewCollectionItemsResponse expectedResponse =
        ViewCollectionItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    CollectionName collection =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    ViewCollectionItemsPagedResponse pagedListResponse = client.viewCollectionItems(collection);

    List<CollectionItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

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
  public void viewCollectionItemsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      CollectionName collection =
          CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
      client.viewCollectionItems(collection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void viewCollectionItemsTest2() throws Exception {
    CollectionItem responsesElement = CollectionItem.newBuilder().build();
    ViewCollectionItemsResponse expectedResponse =
        ViewCollectionItemsResponse.newBuilder()
            .setNextPageToken("")
            .addAllItems(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String collection =
        "projects/project-5278/locations/location-5278/corpora/corpor-5278/collections/collection-5278";

    ViewCollectionItemsPagedResponse pagedListResponse = client.viewCollectionItems(collection);

    List<CollectionItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

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
  public void viewCollectionItemsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String collection =
          "projects/project-5278/locations/location-5278/corpora/corpor-5278/collections/collection-5278";
      client.viewCollectionItems(collection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
