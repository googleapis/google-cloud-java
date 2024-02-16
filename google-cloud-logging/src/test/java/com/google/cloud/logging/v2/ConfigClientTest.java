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

package com.google.cloud.logging.v2;

import static com.google.cloud.logging.v2.ConfigClient.ListBucketsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListLinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListViewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.logging.v2.BigQueryDataset;
import com.google.logging.v2.BillingAccountLocationName;
import com.google.logging.v2.BillingAccountName;
import com.google.logging.v2.CmekSettings;
import com.google.logging.v2.CmekSettingsName;
import com.google.logging.v2.CopyLogEntriesRequest;
import com.google.logging.v2.CopyLogEntriesResponse;
import com.google.logging.v2.CreateBucketRequest;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateLinkRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.CreateViewRequest;
import com.google.logging.v2.DeleteBucketRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteLinkRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.DeleteViewRequest;
import com.google.logging.v2.FolderLocationName;
import com.google.logging.v2.FolderName;
import com.google.logging.v2.GetBucketRequest;
import com.google.logging.v2.GetCmekSettingsRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetLinkRequest;
import com.google.logging.v2.GetSettingsRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.GetViewRequest;
import com.google.logging.v2.IndexConfig;
import com.google.logging.v2.LifecycleState;
import com.google.logging.v2.Link;
import com.google.logging.v2.LinkName;
import com.google.logging.v2.ListBucketsRequest;
import com.google.logging.v2.ListBucketsResponse;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListLinksRequest;
import com.google.logging.v2.ListLinksResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.ListViewsRequest;
import com.google.logging.v2.ListViewsResponse;
import com.google.logging.v2.LocationName;
import com.google.logging.v2.LogBucket;
import com.google.logging.v2.LogBucketName;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogExclusionName;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.LogSinkName;
import com.google.logging.v2.LogView;
import com.google.logging.v2.LogViewName;
import com.google.logging.v2.OrganizationLocationName;
import com.google.logging.v2.OrganizationName;
import com.google.logging.v2.ProjectName;
import com.google.logging.v2.Settings;
import com.google.logging.v2.SettingsName;
import com.google.logging.v2.UndeleteBucketRequest;
import com.google.logging.v2.UpdateBucketRequest;
import com.google.logging.v2.UpdateCmekSettingsRequest;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSettingsRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.logging.v2.UpdateViewRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
public class ConfigClientTest {
  private static MockConfigServiceV2 mockConfigServiceV2;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConfigClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConfigServiceV2 = new MockConfigServiceV2();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockConfigServiceV2));
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
    ConfigSettings settings =
        ConfigSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConfigClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listBucketsTest() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountLocationName parent =
        BillingAccountLocationName.of("[BILLING_ACCOUNT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountLocationName parent =
          BillingAccountLocationName.of("[BILLING_ACCOUNT]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest2() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderLocationName parent = FolderLocationName.of("[FOLDER]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest3() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest4() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest5() throws Exception {
    LogBucket responsesElement = LogBucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<LogBucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .setLocked(true)
            .setLifecycleState(LifecycleState.forNumber(0))
            .setAnalyticsEnabled(true)
            .addAllRestrictedFields(new ArrayList<String>())
            .addAllIndexConfigs(new ArrayList<IndexConfig>())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    GetBucketRequest request =
        GetBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .build();

    LogBucket actualResponse = client.getBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      GetBucketRequest request =
          GetBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .build();
      client.getBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBucketAsyncTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .setLocked(true)
            .setLifecycleState(LifecycleState.forNumber(0))
            .setAnalyticsEnabled(true)
            .addAllRestrictedFields(new ArrayList<String>())
            .addAllIndexConfigs(new ArrayList<IndexConfig>())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBucketAsyncTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setBucketId("bucketId-1603305307")
            .setBucket(LogBucket.newBuilder().build())
            .build();

    LogBucket actualResponse = client.createBucketAsyncAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getBucketId(), actualRequest.getBucketId());
    Assert.assertEquals(request.getBucket(), actualRequest.getBucket());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketAsyncExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      CreateBucketRequest request =
          CreateBucketRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setBucketId("bucketId-1603305307")
              .setBucket(LogBucket.newBuilder().build())
              .build();
      client.createBucketAsyncAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBucketAsyncTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .setLocked(true)
            .setLifecycleState(LifecycleState.forNumber(0))
            .setAnalyticsEnabled(true)
            .addAllRestrictedFields(new ArrayList<String>())
            .addAllIndexConfigs(new ArrayList<IndexConfig>())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBucketAsyncTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setBucket(LogBucket.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    LogBucket actualResponse = client.updateBucketAsyncAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = ((UpdateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getBucket(), actualRequest.getBucket());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBucketAsyncExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateBucketRequest request =
          UpdateBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .setBucket(LogBucket.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateBucketAsyncAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBucketTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .setLocked(true)
            .setLifecycleState(LifecycleState.forNumber(0))
            .setAnalyticsEnabled(true)
            .addAllRestrictedFields(new ArrayList<String>())
            .addAllIndexConfigs(new ArrayList<IndexConfig>())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    CreateBucketRequest request =
        CreateBucketRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setBucketId("bucketId-1603305307")
            .setBucket(LogBucket.newBuilder().build())
            .build();

    LogBucket actualResponse = client.createBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getBucketId(), actualRequest.getBucketId());
    Assert.assertEquals(request.getBucket(), actualRequest.getBucket());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      CreateBucketRequest request =
          CreateBucketRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setBucketId("bucketId-1603305307")
              .setBucket(LogBucket.newBuilder().build())
              .build();
      client.createBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateBucketTest() throws Exception {
    LogBucket expectedResponse =
        LogBucket.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setRetentionDays(1544391896)
            .setLocked(true)
            .setLifecycleState(LifecycleState.forNumber(0))
            .setAnalyticsEnabled(true)
            .addAllRestrictedFields(new ArrayList<String>())
            .addAllIndexConfigs(new ArrayList<IndexConfig>())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UpdateBucketRequest request =
        UpdateBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .setBucket(LogBucket.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    LogBucket actualResponse = client.updateBucket(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = ((UpdateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getBucket(), actualRequest.getBucket());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateBucketRequest request =
          UpdateBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .setBucket(LogBucket.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteBucketTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    DeleteBucketRequest request =
        DeleteBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .build();

    client.deleteBucket(request);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteBucketRequest actualRequest = ((DeleteBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      DeleteBucketRequest request =
          DeleteBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .build();
      client.deleteBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeleteBucketTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UndeleteBucketRequest request =
        UndeleteBucketRequest.newBuilder()
            .setName(
                LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                    .toString())
            .build();

    client.undeleteBucket(request);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeleteBucketRequest actualRequest = ((UndeleteBucketRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeleteBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UndeleteBucketRequest request =
          UndeleteBucketRequest.newBuilder()
              .setName(
                  LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]")
                      .toString())
              .build();
      client.undeleteBucket(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewsTest() throws Exception {
    LogView responsesElement = LogView.newBuilder().build();
    ListViewsResponse expectedResponse =
        ListViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViews(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<LogView> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViewsRequest actualRequest = ((ListViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewTest() throws Exception {
    LogView expectedResponse =
        LogView.newBuilder()
            .setName(
                LogViewName.ofProjectLocationBucketViewName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter("filter-1274492040")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    GetViewRequest request =
        GetViewRequest.newBuilder()
            .setName(
                LogViewName.ofProjectLocationBucketViewName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                    .toString())
            .build();

    LogView actualResponse = client.getView(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViewRequest actualRequest = ((GetViewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      GetViewRequest request =
          GetViewRequest.newBuilder()
              .setName(
                  LogViewName.ofProjectLocationBucketViewName(
                          "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                      .toString())
              .build();
      client.getView(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createViewTest() throws Exception {
    LogView expectedResponse =
        LogView.newBuilder()
            .setName(
                LogViewName.ofProjectLocationBucketViewName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter("filter-1274492040")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    CreateViewRequest request =
        CreateViewRequest.newBuilder()
            .setParent("parent-995424086")
            .setViewId("viewId-816632160")
            .setView(LogView.newBuilder().build())
            .build();

    LogView actualResponse = client.createView(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateViewRequest actualRequest = ((CreateViewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getViewId(), actualRequest.getViewId());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      CreateViewRequest request =
          CreateViewRequest.newBuilder()
              .setParent("parent-995424086")
              .setViewId("viewId-816632160")
              .setView(LogView.newBuilder().build())
              .build();
      client.createView(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateViewTest() throws Exception {
    LogView expectedResponse =
        LogView.newBuilder()
            .setName(
                LogViewName.ofProjectLocationBucketViewName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setFilter("filter-1274492040")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UpdateViewRequest request =
        UpdateViewRequest.newBuilder()
            .setName("name3373707")
            .setView(LogView.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    LogView actualResponse = client.updateView(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateViewRequest actualRequest = ((UpdateViewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getView(), actualRequest.getView());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateViewRequest request =
          UpdateViewRequest.newBuilder()
              .setName("name3373707")
              .setView(LogView.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateView(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteViewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    DeleteViewRequest request =
        DeleteViewRequest.newBuilder()
            .setName(
                LogViewName.ofProjectLocationBucketViewName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                    .toString())
            .build();

    client.deleteView(request);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteViewRequest actualRequest = ((DeleteViewRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      DeleteViewRequest request =
          DeleteViewRequest.newBuilder()
              .setName(
                  LogViewName.ofProjectLocationBucketViewName(
                          "[PROJECT]", "[LOCATION]", "[BUCKET]", "[VIEW]")
                      .toString())
              .build();
      client.deleteView(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest2() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest3() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest4() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSinksTest5() throws Exception {
    LogSink responsesElement = LogSink.newBuilder().build();
    ListSinksResponse expectedResponse =
        ListSinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllSinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSinksPagedResponse pagedListResponse = client.listSinks(parent);

    List<LogSink> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSinksRequest actualRequest = ((ListSinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSinksExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = ((GetSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sinkName508775358";

    LogSink actualResponse = client.getSink(sinkName);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSinkRequest actualRequest = ((GetSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sinkName508775358";
      client.getSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest3() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest4() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSinkTest5() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.createSink(parent, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSinkRequest actualRequest = ((CreateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSinkExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      LogSink sink = LogSink.newBuilder().build();
      client.createSink(parent, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();
      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest2() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sinkName508775358";
    LogSink sink = LogSink.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sinkName508775358";
      LogSink sink = LogSink.newBuilder().build();
      client.updateSink(sinkName, sink);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest3() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
    LogSink sink = LogSink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      LogSink sink = LogSink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSink(sinkName, sink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSinkTest4() throws Exception {
    LogSink expectedResponse =
        LogSink.newBuilder()
            .setName(LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]").toString())
            .setDestination("destination-1429847026")
            .setFilter("filter-1274492040")
            .setDescription("description-1724546052")
            .setDisabled(true)
            .addAllExclusions(new ArrayList<LogExclusion>())
            .setWriterIdentity("writerIdentity925193809")
            .setIncludeChildren(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sinkName508775358";
    LogSink sink = LogSink.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogSink actualResponse = client.updateSink(sinkName, sink, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSinkRequest actualRequest = ((UpdateSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertEquals(sink, actualRequest.getSink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSinkExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sinkName508775358";
      LogSink sink = LogSink.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSink(sinkName, sink, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");

    client.deleteSink(sinkName);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = ((DeleteSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName.toString(), actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogSinkName sinkName = LogSinkName.ofProjectSinkName("[PROJECT]", "[SINK]");
      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String sinkName = "sinkName508775358";

    client.deleteSink(sinkName);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSinkRequest actualRequest = ((DeleteSinkRequest) actualRequests.get(0));

    Assert.assertEquals(sinkName, actualRequest.getSinkName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String sinkName = "sinkName508775358";
      client.deleteSink(sinkName);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createLinkTest() throws Exception {
    Link expectedResponse =
        Link.newBuilder()
            .setName(
                LinkName.ofProjectLocationBucketLinkName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setBigqueryDataset(BigQueryDataset.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    LogBucketName parent =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLinkRequest actualRequest = ((CreateLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(link, actualRequest.getLink());
    Assert.assertEquals(linkId, actualRequest.getLinkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogBucketName parent =
          LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
      Link link = Link.newBuilder().build();
      String linkId = "linkId-1102667083";
      client.createLinkAsync(parent, link, linkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createLinkTest2() throws Exception {
    Link expectedResponse =
        Link.newBuilder()
            .setName(
                LinkName.ofProjectLocationBucketLinkName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setBigqueryDataset(BigQueryDataset.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    String parent = "parent-995424086";
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateLinkRequest actualRequest = ((CreateLinkRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(link, actualRequest.getLink());
    Assert.assertEquals(linkId, actualRequest.getLinkId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      Link link = Link.newBuilder().build();
      String linkId = "linkId-1102667083";
      client.createLinkAsync(parent, link, linkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLinkTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    LinkName name =
        LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");

    client.deleteLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLinkRequest actualRequest = ((DeleteLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LinkName name =
          LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");
      client.deleteLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void deleteLinkTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteLinkRequest actualRequest = ((DeleteLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.deleteLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void listLinksTest() throws Exception {
    Link responsesElement = Link.newBuilder().build();
    ListLinksResponse expectedResponse =
        ListLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllLinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogBucketName parent =
        LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinksRequest actualRequest = ((ListLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinksExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogBucketName parent =
          LogBucketName.ofProjectLocationBucketName("[PROJECT]", "[LOCATION]", "[BUCKET]");
      client.listLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listLinksTest2() throws Exception {
    Link responsesElement = Link.newBuilder().build();
    ListLinksResponse expectedResponse =
        ListLinksResponse.newBuilder()
            .setNextPageToken("")
            .addAllLinks(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLinksRequest actualRequest = ((ListLinksRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLinksExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLinks(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLinkTest() throws Exception {
    Link expectedResponse =
        Link.newBuilder()
            .setName(
                LinkName.ofProjectLocationBucketLinkName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setBigqueryDataset(BigQueryDataset.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LinkName name =
        LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");

    Link actualResponse = client.getLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLinkRequest actualRequest = ((GetLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LinkName name =
          LinkName.ofProjectLocationBucketLinkName("[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]");
      client.getLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getLinkTest2() throws Exception {
    Link expectedResponse =
        Link.newBuilder()
            .setName(
                LinkName.ofProjectLocationBucketLinkName(
                        "[PROJECT]", "[LOCATION]", "[BUCKET]", "[LINK]")
                    .toString())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setLifecycleState(LifecycleState.forNumber(0))
            .setBigqueryDataset(BigQueryDataset.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    Link actualResponse = client.getLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLinkRequest actualRequest = ((GetLinkRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLinkExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.getLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest2() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest3() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest4() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listExclusionsTest5() throws Exception {
    LogExclusion responsesElement = LogExclusion.newBuilder().build();
    ListExclusionsResponse expectedResponse =
        ListExclusionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllExclusions(Arrays.asList(responsesElement))
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListExclusionsPagedResponse pagedListResponse = client.listExclusions(parent);

    List<LogExclusion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getExclusionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListExclusionsRequest actualRequest = ((ListExclusionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listExclusionsExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listExclusions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = ((GetExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    LogExclusion actualResponse = client.getExclusion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetExclusionRequest actualRequest = ((GetExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.getExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      BillingAccountName parent = BillingAccountName.of("[BILLING_ACCOUNT]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    FolderName parent = FolderName.of("[FOLDER]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      FolderName parent = FolderName.of("[FOLDER]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest3() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      OrganizationName parent = OrganizationName.of("[ORGANIZATION]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest4() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createExclusionTest5() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String parent = "parent-995424086";
    LogExclusion exclusion = LogExclusion.newBuilder().build();

    LogExclusion actualResponse = client.createExclusion(parent, exclusion);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateExclusionRequest actualRequest = ((CreateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createExclusionExceptionTest5() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String parent = "parent-995424086";
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      client.createExclusion(parent, exclusion);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExclusionTest() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = ((UpdateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExclusion(name, exclusion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateExclusionTest2() throws Exception {
    LogExclusion expectedResponse =
        LogExclusion.newBuilder()
            .setName(LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]").toString())
            .setDescription("description-1724546052")
            .setFilter("filter-1274492040")
            .setDisabled(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";
    LogExclusion exclusion = LogExclusion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    LogExclusion actualResponse = client.updateExclusion(name, exclusion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateExclusionRequest actualRequest = ((UpdateExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(exclusion, actualRequest.getExclusion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      LogExclusion exclusion = LogExclusion.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateExclusion(name, exclusion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExclusionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");

    client.deleteExclusion(name);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = ((DeleteExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExclusionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      LogExclusionName name = LogExclusionName.ofProjectExclusionName("[PROJECT]", "[EXCLUSION]");
      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteExclusionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteExclusion(name);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteExclusionRequest actualRequest = ((DeleteExclusionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteExclusionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
      client.deleteExclusion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCmekSettingsTest() throws Exception {
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .setServiceAccountId("serviceAccountId1964232947")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    GetCmekSettingsRequest request =
        GetCmekSettingsRequest.newBuilder()
            .setName(CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]").toString())
            .build();

    CmekSettings actualResponse = client.getCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetCmekSettingsRequest actualRequest = ((GetCmekSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      GetCmekSettingsRequest request =
          GetCmekSettingsRequest.newBuilder()
              .setName(CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]").toString())
              .build();
      client.getCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateCmekSettingsTest() throws Exception {
    CmekSettings expectedResponse =
        CmekSettings.newBuilder()
            .setName(CmekSettingsName.ofProjectCmekSettingsName("[PROJECT]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsKeyVersionName("kmsKeyVersionName-1798811307")
            .setServiceAccountId("serviceAccountId1964232947")
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    UpdateCmekSettingsRequest request =
        UpdateCmekSettingsRequest.newBuilder()
            .setName("name3373707")
            .setCmekSettings(CmekSettings.newBuilder().build())
            .setUpdateMask(FieldMask.newBuilder().build())
            .build();

    CmekSettings actualResponse = client.updateCmekSettings(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateCmekSettingsRequest actualRequest = ((UpdateCmekSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getCmekSettings(), actualRequest.getCmekSettings());
    Assert.assertEquals(request.getUpdateMask(), actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateCmekSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      UpdateCmekSettingsRequest request =
          UpdateCmekSettingsRequest.newBuilder()
              .setName("name3373707")
              .setCmekSettings(CmekSettings.newBuilder().build())
              .setUpdateMask(FieldMask.newBuilder().build())
              .build();
      client.updateCmekSettings(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofProjectName("[PROJECT]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsServiceAccountId("kmsServiceAccountId662368868")
            .setStorageLocation("storageLocation911842128")
            .setDisableDefaultSink(true)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofProjectName("[PROJECT]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      SettingsName name = SettingsName.ofProjectName("[PROJECT]");
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
            .setName(SettingsName.ofProjectName("[PROJECT]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsServiceAccountId("kmsServiceAccountId662368868")
            .setStorageLocation("storageLocation911842128")
            .setDisableDefaultSink(true)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      String name = "name3373707";
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
            .setName(SettingsName.ofProjectName("[PROJECT]").toString())
            .setKmsKeyName("kmsKeyName412586233")
            .setKmsServiceAccountId("kmsServiceAccountId662368868")
            .setStorageLocation("storageLocation911842128")
            .setDisableDefaultSink(true)
            .build();
    mockConfigServiceV2.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingsRequest actualRequest = ((UpdateSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void copyLogEntriesTest() throws Exception {
    CopyLogEntriesResponse expectedResponse =
        CopyLogEntriesResponse.newBuilder().setLogEntriesCopiedCount(-2134326978).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("copyLogEntriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockConfigServiceV2.addResponse(resultOperation);

    CopyLogEntriesRequest request =
        CopyLogEntriesRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setDestination("destination-1429847026")
            .build();

    CopyLogEntriesResponse actualResponse = client.copyLogEntriesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConfigServiceV2.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CopyLogEntriesRequest actualRequest = ((CopyLogEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getDestination(), actualRequest.getDestination());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void copyLogEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConfigServiceV2.addException(exception);

    try {
      CopyLogEntriesRequest request =
          CopyLogEntriesRequest.newBuilder()
              .setName("name3373707")
              .setFilter("filter-1274492040")
              .setDestination("destination-1429847026")
              .build();
      client.copyLogEntriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
