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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
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
public class WarehouseClientTest {
  private static MockIAMPolicy mockIAMPolicy;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockWarehouse mockWarehouse;
  private LocalChannelProvider channelProvider;
  private WarehouseClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockWarehouse = new MockWarehouse();
    mockLocations = new MockLocations();
    mockIAMPolicy = new MockIAMPolicy();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockWarehouse, mockLocations, mockIAMPolicy));
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
    WarehouseSettings settings =
        WarehouseSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = WarehouseClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAsset(parent, asset, assetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Asset asset = Asset.newBuilder().build();
    String assetId = "assetId-704776149";

    Asset actualResponse = client.createAsset(parent, asset, assetId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    Asset asset = Asset.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Asset actualResponse = client.updateAsset(asset, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

    try {
      Asset asset = Asset.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    Asset actualResponse = client.getAsset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAssetsPagedResponse pagedListResponse = client.listAssets(parent);

    List<Asset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(resultOperation);

    AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

    try {
      AssetName name = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
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
    mockWarehouse.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteAssetAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
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
    mockWarehouse.addException(exception);

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
  public void uploadAssetTest() throws Exception {
    UploadAssetResponse expectedResponse = UploadAssetResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("uploadAssetTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockWarehouse.addResponse(resultOperation);

    UploadAssetRequest request =
        UploadAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setAssetSource(AssetSource.newBuilder().build())
            .build();

    UploadAssetResponse actualResponse = client.uploadAssetAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadAssetRequest actualRequest = ((UploadAssetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getAssetSource(), actualRequest.getAssetSource());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void generateRetrievalUrlTest() throws Exception {
    GenerateRetrievalUrlResponse expectedResponse =
        GenerateRetrievalUrlResponse.newBuilder().setSignedUri("signedUri1076770992").build();
    mockWarehouse.addResponse(expectedResponse);

    GenerateRetrievalUrlRequest request =
        GenerateRetrievalUrlRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .build();

    GenerateRetrievalUrlResponse actualResponse = client.generateRetrievalUrl(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateRetrievalUrlRequest actualRequest =
        ((GenerateRetrievalUrlRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateRetrievalUrlExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(resultOperation);

    AnalyzeAssetRequest request =
        AnalyzeAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .build();

    AnalyzeAssetResponse actualResponse = client.analyzeAssetAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeAssetRequest actualRequest = ((AnalyzeAssetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      AnalyzeAssetRequest request =
          AnalyzeAssetRequest.newBuilder()
              .setName(
                  AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
              .build();
      client.analyzeAssetAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    IndexAssetRequest request =
        IndexAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setIndex(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .build();

    IndexAssetResponse actualResponse = client.indexAssetAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IndexAssetRequest actualRequest = ((IndexAssetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getIndex(), actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void indexAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    RemoveIndexAssetRequest request =
        RemoveIndexAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setIndex(
                IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]").toString())
            .build();

    RemoveIndexAssetResponse actualResponse = client.removeIndexAssetAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveIndexAssetRequest actualRequest = ((RemoveIndexAssetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getIndex(), actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeIndexAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    IndexName index = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    ViewIndexedAssetsPagedResponse pagedListResponse = client.viewIndexedAssets(index);

    List<IndexedAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexedAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ViewIndexedAssetsRequest actualRequest = ((ViewIndexedAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(index.toString(), actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void viewIndexedAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String index = "index100346066";

    ViewIndexedAssetsPagedResponse pagedListResponse = client.viewIndexedAssets(index);

    List<IndexedAsset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexedAssetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ViewIndexedAssetsRequest actualRequest = ((ViewIndexedAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void viewIndexedAssetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String index = "index100346066";
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
    mockWarehouse.addResponse(resultOperation);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertEquals(indexId, actualRequest.getIndexId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      Index index = Index.newBuilder().build();
      String indexId = "indexId1943291277";
      client.createIndexAsync(parent, index, indexId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String parent = "parent-995424086";
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexRequest actualRequest = ((CreateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertEquals(indexId, actualRequest.getIndexId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
      Index index = Index.newBuilder().build();
      String indexId = "indexId1943291277";
      client.createIndexAsync(parent, index, indexId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    Index index = Index.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Index actualResponse = client.updateIndexAsync(index, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIndexRequest actualRequest = ((UpdateIndexRequest) actualRequests.get(0));

    Assert.assertEquals(index, actualRequest.getIndex());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      Index index = Index.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIndexAsync(index, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexRequest actualRequest = ((GetIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexesRequest actualRequest = ((ListIndexesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(resultOperation);

    IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[INDEX]");
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexRequest actualRequest = ((DeleteIndexRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIndexAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String parent = "parent-995424086";
    Corpus corpus = Corpus.newBuilder().build();

    Corpus actualResponse = client.createCorpusAsync(parent, corpus).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCorpusRequest actualRequest = ((CreateCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(corpus, actualRequest.getCorpus());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
      Corpus corpus = Corpus.newBuilder().build();
      client.createCorpusAsync(parent, corpus).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    Corpus actualResponse = client.getCorpus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCorpusRequest actualRequest = ((GetCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    Corpus actualResponse = client.getCorpus(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCorpusRequest actualRequest = ((GetCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCorpusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    Corpus corpus = Corpus.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Corpus actualResponse = client.updateCorpus(corpus, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCorpusRequest actualRequest = ((UpdateCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(corpus, actualRequest.getCorpus());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      Corpus corpus = Corpus.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCorporaPagedResponse pagedListResponse = client.listCorpora(parent);

    List<Corpus> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCorporaList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCorporaRequest actualRequest = ((ListCorporaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCorporaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCorpora(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteCorpusTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWarehouse.addResponse(expectedResponse);

    CorpusName name = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    client.deleteCorpus(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCorpusRequest actualRequest = ((DeleteCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteCorpus(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCorpusRequest actualRequest = ((DeleteCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCorpusExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(resultOperation);

    AnalyzeCorpusRequest request =
        AnalyzeCorpusRequest.newBuilder()
            .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .build();

    AnalyzeCorpusResponse actualResponse = client.analyzeCorpusAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeCorpusRequest actualRequest = ((AnalyzeCorpusRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeCorpusExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      AnalyzeCorpusRequest request =
          AnalyzeCorpusRequest.newBuilder()
              .setName(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .build();
      client.analyzeCorpusAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    DataSchema dataSchema = DataSchema.newBuilder().build();

    DataSchema actualResponse = client.createDataSchema(parent, dataSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataSchemaRequest actualRequest = ((CreateDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(dataSchema, actualRequest.getDataSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";
    DataSchema dataSchema = DataSchema.newBuilder().build();

    DataSchema actualResponse = client.createDataSchema(parent, dataSchema);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateDataSchemaRequest actualRequest = ((CreateDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(dataSchema, actualRequest.getDataSchema());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createDataSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    DataSchema dataSchema = DataSchema.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    DataSchema actualResponse = client.updateDataSchema(dataSchema, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateDataSchemaRequest actualRequest = ((UpdateDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(dataSchema, actualRequest.getDataSchema());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateDataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      DataSchema dataSchema = DataSchema.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    DataSchemaName name =
        DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");

    DataSchema actualResponse = client.getDataSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSchemaRequest actualRequest = ((GetDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    DataSchema actualResponse = client.getDataSchema(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDataSchemaRequest actualRequest = ((GetDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDataSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.getDataSchema(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteDataSchemaTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWarehouse.addResponse(expectedResponse);

    DataSchemaName name =
        DataSchemaName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[DATA_SCHEMA]");

    client.deleteDataSchema(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataSchemaRequest actualRequest = ((DeleteDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataSchemaExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteDataSchema(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteDataSchemaRequest actualRequest = ((DeleteDataSchemaRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteDataSchemaExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListDataSchemasPagedResponse pagedListResponse = client.listDataSchemas(parent);

    List<DataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSchemasRequest actualRequest = ((ListDataSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSchemasExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDataSchemasPagedResponse pagedListResponse = client.listDataSchemas(parent);

    List<DataSchema> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataSchemasList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDataSchemasRequest actualRequest = ((ListDataSchemasRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDataSchemasExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");
    Annotation annotation = Annotation.newBuilder().build();
    String annotationId = "annotationId251782314";

    Annotation actualResponse = client.createAnnotation(parent, annotation, annotationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationRequest actualRequest = ((CreateAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertEquals(annotationId, actualRequest.getAnnotationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Annotation annotation = Annotation.newBuilder().build();
    String annotationId = "annotationId251782314";

    Annotation actualResponse = client.createAnnotation(parent, annotation, annotationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnnotationRequest actualRequest = ((CreateAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertEquals(annotationId, actualRequest.getAnnotationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnnotationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    AnnotationName name =
        AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationRequest actualRequest = ((GetAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    Annotation actualResponse = client.getAnnotation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnnotationRequest actualRequest = ((GetAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnnotationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    AssetName parent = AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]");

    ListAnnotationsPagedResponse pagedListResponse = client.listAnnotations(parent);

    List<Annotation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotationsRequest actualRequest = ((ListAnnotationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnnotationsPagedResponse pagedListResponse = client.listAnnotations(parent);

    List<Annotation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnnotationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnnotationsRequest actualRequest = ((ListAnnotationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnnotationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    Annotation annotation = Annotation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Annotation actualResponse = client.updateAnnotation(annotation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAnnotationRequest actualRequest = ((UpdateAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(annotation, actualRequest.getAnnotation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      Annotation annotation = Annotation.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    AnnotationName name =
        AnnotationName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]", "[ANNOTATION]");

    client.deleteAnnotation(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationRequest actualRequest = ((DeleteAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnnotationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnnotation(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnnotationRequest actualRequest = ((DeleteAnnotationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnnotationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.deleteAnnotation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestAssetTest() throws Exception {
    IngestAssetResponse expectedResponse =
        IngestAssetResponse.newBuilder()
            .setSuccessfullyIngestedPartition(Partition.TemporalPartition.newBuilder().build())
            .build();
    mockWarehouse.addResponse(expectedResponse);
    IngestAssetRequest request = IngestAssetRequest.newBuilder().build();

    MockStreamObserver<IngestAssetResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> callable =
        client.ingestAssetCallable();
    ApiStreamObserver<IngestAssetRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<IngestAssetResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void ingestAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);
    IngestAssetRequest request = IngestAssetRequest.newBuilder().build();

    MockStreamObserver<IngestAssetResponse> responseObserver = new MockStreamObserver<>();

    BidiStreamingCallable<IngestAssetRequest, IngestAssetResponse> callable =
        client.ingestAssetCallable();
    ApiStreamObserver<IngestAssetRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<IngestAssetResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void clipAssetTest() throws Exception {
    ClipAssetResponse expectedResponse =
        ClipAssetResponse.newBuilder()
            .addAllTimeIndexedUris(new ArrayList<ClipAssetResponse.TimeIndexedUri>())
            .build();
    mockWarehouse.addResponse(expectedResponse);

    ClipAssetRequest request =
        ClipAssetRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .setTemporalPartition(Partition.TemporalPartition.newBuilder().build())
            .build();

    ClipAssetResponse actualResponse = client.clipAsset(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ClipAssetRequest actualRequest = ((ClipAssetRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getTemporalPartition(), actualRequest.getTemporalPartition());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void clipAssetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    GenerateHlsUriRequest request =
        GenerateHlsUriRequest.newBuilder()
            .setName(
                AssetName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[ASSET]").toString())
            .addAllTemporalPartitions(new ArrayList<Partition.TemporalPartition>())
            .setLiveViewEnabled(true)
            .build();

    GenerateHlsUriResponse actualResponse = client.generateHlsUri(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateHlsUriRequest actualRequest = ((GenerateHlsUriRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(
        request.getTemporalPartitionsList(), actualRequest.getTemporalPartitionsList());
    Assert.assertEquals(request.getLiveViewEnabled(), actualRequest.getLiveViewEnabled());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateHlsUriExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(resultOperation);

    ImportAssetsRequest request =
        ImportAssetsRequest.newBuilder()
            .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
            .build();

    ImportAssetsResponse actualResponse = client.importAssetsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportAssetsRequest actualRequest = ((ImportAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getAssetsGcsUri(), actualRequest.getAssetsGcsUri());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      ImportAssetsRequest request =
          ImportAssetsRequest.newBuilder()
              .setParent(CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]").toString())
              .build();
      client.importAssetsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    SearchConfig searchConfig = SearchConfig.newBuilder().build();
    String searchConfigId = "searchConfigId1576297925";

    SearchConfig actualResponse = client.createSearchConfig(parent, searchConfig, searchConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSearchConfigRequest actualRequest = ((CreateSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(searchConfig, actualRequest.getSearchConfig());
    Assert.assertEquals(searchConfigId, actualRequest.getSearchConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSearchConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SearchConfig searchConfig = SearchConfig.newBuilder().build();
    String searchConfigId = "searchConfigId1576297925";

    SearchConfig actualResponse = client.createSearchConfig(parent, searchConfig, searchConfigId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSearchConfigRequest actualRequest = ((CreateSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(searchConfig, actualRequest.getSearchConfig());
    Assert.assertEquals(searchConfigId, actualRequest.getSearchConfigId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSearchConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    SearchConfig searchConfig = SearchConfig.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SearchConfig actualResponse = client.updateSearchConfig(searchConfig, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSearchConfigRequest actualRequest = ((UpdateSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(searchConfig, actualRequest.getSearchConfig());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSearchConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      SearchConfig searchConfig = SearchConfig.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    SearchConfigName name =
        SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");

    SearchConfig actualResponse = client.getSearchConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSearchConfigRequest actualRequest = ((GetSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSearchConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    SearchConfig actualResponse = client.getSearchConfig(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSearchConfigRequest actualRequest = ((GetSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSearchConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.getSearchConfig(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchConfigTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWarehouse.addResponse(expectedResponse);

    SearchConfigName name =
        SearchConfigName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_CONFIG]");

    client.deleteSearchConfig(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSearchConfigRequest actualRequest = ((DeleteSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSearchConfigExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSearchConfig(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSearchConfigRequest actualRequest = ((DeleteSearchConfigRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSearchConfigExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListSearchConfigsPagedResponse pagedListResponse = client.listSearchConfigs(parent);

    List<SearchConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchConfigsRequest actualRequest = ((ListSearchConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchConfigsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSearchConfigsPagedResponse pagedListResponse = client.listSearchConfigs(parent);

    List<SearchConfig> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchConfigsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchConfigsRequest actualRequest = ((ListSearchConfigsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchConfigsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
    String searchHypernymId = "searchHypernymId-314707559";

    SearchHypernym actualResponse =
        client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSearchHypernymRequest actualRequest =
        ((CreateSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(searchHypernym, actualRequest.getSearchHypernym());
    Assert.assertEquals(searchHypernymId, actualRequest.getSearchHypernymId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSearchHypernymExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";
    SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
    String searchHypernymId = "searchHypernymId-314707559";

    SearchHypernym actualResponse =
        client.createSearchHypernym(parent, searchHypernym, searchHypernymId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSearchHypernymRequest actualRequest =
        ((CreateSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(searchHypernym, actualRequest.getSearchHypernym());
    Assert.assertEquals(searchHypernymId, actualRequest.getSearchHypernymId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSearchHypernymExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SearchHypernym actualResponse = client.updateSearchHypernym(searchHypernym, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSearchHypernymRequest actualRequest =
        ((UpdateSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(searchHypernym, actualRequest.getSearchHypernym());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSearchHypernymExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      SearchHypernym searchHypernym = SearchHypernym.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    SearchHypernymName name =
        SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");

    SearchHypernym actualResponse = client.getSearchHypernym(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSearchHypernymRequest actualRequest = ((GetSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSearchHypernymExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    SearchHypernym actualResponse = client.getSearchHypernym(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSearchHypernymRequest actualRequest = ((GetSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSearchHypernymExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.getSearchHypernym(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSearchHypernymTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockWarehouse.addResponse(expectedResponse);

    SearchHypernymName name =
        SearchHypernymName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[SEARCH_HYPERNYM]");

    client.deleteSearchHypernym(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSearchHypernymRequest actualRequest =
        ((DeleteSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSearchHypernymExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSearchHypernym(name);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSearchHypernymRequest actualRequest =
        ((DeleteSearchHypernymRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSearchHypernymExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListSearchHypernymsPagedResponse pagedListResponse = client.listSearchHypernyms(parent);

    List<SearchHypernym> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchHypernymsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchHypernymsRequest actualRequest = ((ListSearchHypernymsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchHypernymsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSearchHypernymsPagedResponse pagedListResponse = client.listSearchHypernyms(parent);

    List<SearchHypernym> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchHypernymsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchHypernymsRequest actualRequest = ((ListSearchHypernymsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchHypernymsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchAssetsRequest actualRequest = ((SearchAssetsRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getSchemaKeySortingStrategy(), actualRequest.getSchemaKeySortingStrategy());
    Assert.assertEquals(request.getCorpus(), actualRequest.getCorpus());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertEquals(request.getContentTimeRanges(), actualRequest.getContentTimeRanges());
    Assert.assertEquals(request.getCriteriaList(), actualRequest.getCriteriaList());
    Assert.assertEquals(request.getFacetSelectionsList(), actualRequest.getFacetSelectionsList());
    Assert.assertEquals(
        request.getResultAnnotationKeysList(), actualRequest.getResultAnnotationKeysList());
    Assert.assertEquals(request.getSearchQuery(), actualRequest.getSearchQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchAssetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchIndexEndpointRequest actualRequest = ((SearchIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(request.getImageQuery(), actualRequest.getImageQuery());
    Assert.assertEquals(request.getTextQuery(), actualRequest.getTextQuery());
    Assert.assertEquals(request.getIndexEndpoint(), actualRequest.getIndexEndpoint());
    Assert.assertEquals(request.getCriteriaList(), actualRequest.getCriteriaList());
    Assert.assertEquals(
        request.getExclusionCriteriaList(), actualRequest.getExclusionCriteriaList());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchIndexEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
    String indexEndpointId = "indexEndpointId-250889214";

    IndexEndpoint actualResponse =
        client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexEndpointRequest actualRequest = ((CreateIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(indexEndpoint, actualRequest.getIndexEndpoint());
    Assert.assertEquals(indexEndpointId, actualRequest.getIndexEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
      String indexEndpointId = "indexEndpointId-250889214";
      client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String parent = "parent-995424086";
    IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
    String indexEndpointId = "indexEndpointId-250889214";

    IndexEndpoint actualResponse =
        client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIndexEndpointRequest actualRequest = ((CreateIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(indexEndpoint, actualRequest.getIndexEndpoint());
    Assert.assertEquals(indexEndpointId, actualRequest.getIndexEndpointId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIndexEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
      IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
      String indexEndpointId = "indexEndpointId-250889214";
      client.createIndexEndpointAsync(parent, indexEndpoint, indexEndpointId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");

    IndexEndpoint actualResponse = client.getIndexEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexEndpointRequest actualRequest = ((GetIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    IndexEndpoint actualResponse = client.getIndexEndpoint(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIndexEndpointRequest actualRequest = ((GetIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIndexEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIndexEndpointsPagedResponse pagedListResponse = client.listIndexEndpoints(parent);

    List<IndexEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexEndpointsRequest actualRequest = ((ListIndexEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexEndpointsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIndexEndpointsPagedResponse pagedListResponse = client.listIndexEndpoints(parent);

    List<IndexEndpoint> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexEndpointsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIndexEndpointsRequest actualRequest = ((ListIndexEndpointsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIndexEndpointsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(resultOperation);

    IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IndexEndpoint actualResponse = client.updateIndexEndpointAsync(indexEndpoint, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIndexEndpointRequest actualRequest = ((UpdateIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(indexEndpoint, actualRequest.getIndexEndpoint());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIndexEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      IndexEndpoint indexEndpoint = IndexEndpoint.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIndexEndpointAsync(indexEndpoint, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");

    client.deleteIndexEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexEndpointRequest actualRequest = ((DeleteIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexEndpointExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      IndexEndpointName name = IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]");
      client.deleteIndexEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIndexEndpointAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIndexEndpointRequest actualRequest = ((DeleteIndexEndpointRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIndexEndpointExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIndexEndpointAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    DeployIndexRequest request =
        DeployIndexRequest.newBuilder()
            .setIndexEndpoint(
                IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .setDeployedIndex(DeployedIndex.newBuilder().build())
            .build();

    DeployIndexResponse actualResponse = client.deployIndexAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployIndexRequest actualRequest = ((DeployIndexRequest) actualRequests.get(0));

    Assert.assertEquals(request.getIndexEndpoint(), actualRequest.getIndexEndpoint());
    Assert.assertEquals(request.getDeployedIndex(), actualRequest.getDeployedIndex());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    UndeployIndexRequest request =
        UndeployIndexRequest.newBuilder()
            .setIndexEndpoint(
                IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
            .build();

    UndeployIndexResponse actualResponse = client.undeployIndexAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployIndexRequest actualRequest = ((UndeployIndexRequest) actualRequests.get(0));

    Assert.assertEquals(request.getIndexEndpoint(), actualRequest.getIndexEndpoint());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployIndexExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      UndeployIndexRequest request =
          UndeployIndexRequest.newBuilder()
              .setIndexEndpoint(
                  IndexEndpointName.of("[PROJECT]", "[LOCATION]", "[INDEX_ENDPOINT]").toString())
              .build();
      client.undeployIndexAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCollectionRequest actualRequest = ((CreateCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(collection, actualRequest.getCollection());
    Assert.assertEquals(collectionId, actualRequest.getCollectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");
      Collection collection = Collection.newBuilder().build();
      String collectionId = "collectionId1636075609";
      client.createCollectionAsync(parent, collection, collectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String parent = "parent-995424086";
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateCollectionRequest actualRequest = ((CreateCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(collection, actualRequest.getCollection());
    Assert.assertEquals(collectionId, actualRequest.getCollectionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createCollectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
      Collection collection = Collection.newBuilder().build();
      String collectionId = "collectionId1636075609";
      client.createCollectionAsync(parent, collection, collectionId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    CollectionName name =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    client.deleteCollectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCollectionRequest actualRequest = ((DeleteCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      CollectionName name =
          CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");
      client.deleteCollectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCollectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteCollectionRequest actualRequest = ((DeleteCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteCollectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
      client.deleteCollectionAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockWarehouse.addResponse(expectedResponse);

    CollectionName name =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    Collection actualResponse = client.getCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCollectionRequest actualRequest = ((GetCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String name = "name3373707";

    Collection actualResponse = client.getCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCollectionRequest actualRequest = ((GetCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCollectionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String name = "name3373707";
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
    mockWarehouse.addResponse(expectedResponse);

    Collection collection = Collection.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Collection actualResponse = client.updateCollection(collection, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCollectionRequest actualRequest = ((UpdateCollectionRequest) actualRequests.get(0));

    Assert.assertEquals(collection, actualRequest.getCollection());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCollectionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      Collection collection = Collection.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    CorpusName parent = CorpusName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]");

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectionsRequest actualRequest = ((ListCollectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCollectionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListCollectionsRequest actualRequest = ((ListCollectionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listCollectionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockWarehouse.addResponse(expectedResponse);

    CollectionItem item = CollectionItem.newBuilder().build();

    AddCollectionItemResponse actualResponse = client.addCollectionItem(item);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AddCollectionItemRequest actualRequest = ((AddCollectionItemRequest) actualRequests.get(0));

    Assert.assertEquals(item, actualRequest.getItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void addCollectionItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      CollectionItem item = CollectionItem.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    CollectionItem item = CollectionItem.newBuilder().build();

    RemoveCollectionItemResponse actualResponse = client.removeCollectionItem(item);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RemoveCollectionItemRequest actualRequest =
        ((RemoveCollectionItemRequest) actualRequests.get(0));

    Assert.assertEquals(item, actualRequest.getItem());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void removeCollectionItemExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      CollectionItem item = CollectionItem.newBuilder().build();
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
    mockWarehouse.addResponse(expectedResponse);

    CollectionName collection =
        CollectionName.of("[PROJECT_NUMBER]", "[LOCATION]", "[CORPUS]", "[COLLECTION]");

    ViewCollectionItemsPagedResponse pagedListResponse = client.viewCollectionItems(collection);

    List<CollectionItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ViewCollectionItemsRequest actualRequest = ((ViewCollectionItemsRequest) actualRequests.get(0));

    Assert.assertEquals(collection.toString(), actualRequest.getCollection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void viewCollectionItemsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

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
    mockWarehouse.addResponse(expectedResponse);

    String collection = "collection-1741312354";

    ViewCollectionItemsPagedResponse pagedListResponse = client.viewCollectionItems(collection);

    List<CollectionItem> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getItemsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockWarehouse.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ViewCollectionItemsRequest actualRequest = ((ViewCollectionItemsRequest) actualRequests.get(0));

    Assert.assertEquals(collection, actualRequest.getCollection());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void viewCollectionItemsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockWarehouse.addException(exception);

    try {
      String collection = "collection-1741312354";
      client.viewCollectionItems(collection);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
