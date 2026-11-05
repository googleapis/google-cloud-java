/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.observability.v1;

import static com.google.cloud.observability.v1.ObservabilityClient.ListBucketsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListDatasetsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLinksPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListLocationsPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListTraceScopesPagedResponse;
import static com.google.cloud.observability.v1.ObservabilityClient.ListViewsPagedResponse;

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
public class ObservabilityClientTest {
  private static MockLocations mockLocations;
  private static MockObservability mockObservability;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ObservabilityClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockObservability = new MockObservability();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockObservability, mockLocations));
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
    ObservabilitySettings settings =
        ObservabilitySettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ObservabilityClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void getScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLogScope("logScope2002130288")
            .setTraceScope("traceScope976576527")
            .build();
    mockObservability.addResponse(expectedResponse);

    ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    Scope actualResponse = client.getScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScopeRequest actualRequest = ((GetScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");
      client.getScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getScopeTest2() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLogScope("logScope2002130288")
            .setTraceScope("traceScope976576527")
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    Scope actualResponse = client.getScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetScopeRequest actualRequest = ((GetScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLogScope("logScope2002130288")
            .setTraceScope("traceScope976576527")
            .build();
    mockObservability.addResponse(expectedResponse);

    Scope scope = Scope.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Scope actualResponse = client.updateScope(scope, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateScopeRequest actualRequest = ((UpdateScopeRequest) actualRequests.get(0));

    Assert.assertEquals(scope, actualRequest.getScope());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      Scope scope = Scope.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateScope(scope, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    BucketName name = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");

    Bucket actualResponse = client.getBucket(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      BucketName name = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");
      client.getBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getBucketTest2() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    Bucket actualResponse = client.getBucket(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetBucketRequest actualRequest = ((GetBucketRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getBucketExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getBucket(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest() throws Exception {
    Bucket responsesElement = Bucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listBucketsTest2() throws Exception {
    Bucket responsesElement = Bucket.newBuilder().build();
    ListBucketsResponse expectedResponse =
        ListBucketsResponse.newBuilder()
            .setNextPageToken("")
            .addAllBuckets(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListBucketsRequest actualRequest = ((ListBucketsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listBucketsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listBuckets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBucketTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucketAsync(parent, bucket, bucketId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(bucketId, actualRequest.getBucketId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucketAsync(parent, bucket, bucketId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createBucketTest2() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createBucketTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    String parent = "parent-995424086";
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucketAsync(parent, bucket, bucketId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateBucketRequest actualRequest = ((CreateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(bucketId, actualRequest.getBucketId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createBucketExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucketAsync(parent, bucket, bucketId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void updateBucketTest() throws Exception {
    Bucket expectedResponse =
        Bucket.newBuilder()
            .setName(BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .setCmekSettings(CmekSettings.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateBucketTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    Bucket bucket = Bucket.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Bucket actualResponse = client.updateBucketAsync(bucket, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateBucketRequest actualRequest = ((UpdateBucketRequest) actualRequests.get(0));

    Assert.assertEquals(bucket, actualRequest.getBucket());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateBucketExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      Bucket bucket = Bucket.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBucketAsync(bucket, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void getDatasetTest() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getDatasetTest2() throws Exception {
    Dataset expectedResponse =
        Dataset.newBuilder()
            .setName(DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setPurgeTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    Dataset actualResponse = client.getDataset(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetDatasetRequest actualRequest = ((GetDatasetRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getDatasetExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getDataset(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    BucketName parent = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      BucketName parent = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listDatasetsTest2() throws Exception {
    Dataset responsesElement = Dataset.newBuilder().build();
    ListDatasetsResponse expectedResponse =
        ListDatasetsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDatasets(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListDatasetsRequest actualRequest = ((ListDatasetsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listDatasetsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listDatasets(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewTest() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(
                ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]");

    View actualResponse = client.getView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViewRequest actualRequest = ((GetViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]");
      client.getView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewTest2() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(
                ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    View actualResponse = client.getView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViewRequest actualRequest = ((GetViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewsTest() throws Exception {
    View responsesElement = View.newBuilder().build();
    ListViewsResponse expectedResponse =
        ListViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViews(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViewsRequest actualRequest = ((ListViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
      client.listViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewsTest2() throws Exception {
    View responsesElement = View.newBuilder().build();
    ListViewsResponse expectedResponse =
        ListViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViews(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViewsRequest actualRequest = ((ListViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listViews(parent);
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
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");

    Link actualResponse = client.getLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");
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
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    Link actualResponse = client.getLink(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getLink(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
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
    mockObservability.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
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
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listLinks(parent);
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
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
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
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    String parent = "parent-995424086";
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

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
  public void updateLinkTest() throws Exception {
    Link expectedResponse =
        Link.newBuilder()
            .setName(
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateLinkTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    Link link = Link.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Link actualResponse = client.updateLinkAsync(link, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateLinkRequest actualRequest = ((UpdateLinkRequest) actualRequests.get(0));

    Assert.assertEquals(link, actualRequest.getLink());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateLinkExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      Link link = Link.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLinkAsync(link, updateMask).get();
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
    mockObservability.addResponse(resultOperation);

    LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");

    client.deleteLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");
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
    mockObservability.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteLinkAsync(name).get();

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

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
  public void getTraceScopeTest() throws Exception {
    TraceScope expectedResponse =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");

    TraceScope actualResponse = client.getTraceScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTraceScopeRequest actualRequest = ((GetTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTraceScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");
      client.getTraceScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getTraceScopeTest2() throws Exception {
    TraceScope expectedResponse =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    TraceScope actualResponse = client.getTraceScope(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetTraceScopeRequest actualRequest = ((GetTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getTraceScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.getTraceScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTraceScopesTest() throws Exception {
    TraceScope responsesElement = TraceScope.newBuilder().build();
    ListTraceScopesResponse expectedResponse =
        ListTraceScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTraceScopes(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTraceScopesPagedResponse pagedListResponse = client.listTraceScopes(parent);

    List<TraceScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTraceScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTraceScopesRequest actualRequest = ((ListTraceScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTraceScopesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listTraceScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listTraceScopesTest2() throws Exception {
    TraceScope responsesElement = TraceScope.newBuilder().build();
    ListTraceScopesResponse expectedResponse =
        ListTraceScopesResponse.newBuilder()
            .setNextPageToken("")
            .addAllTraceScopes(Arrays.asList(responsesElement))
            .build();
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListTraceScopesPagedResponse pagedListResponse = client.listTraceScopes(parent);

    List<TraceScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTraceScopesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListTraceScopesRequest actualRequest = ((ListTraceScopesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listTraceScopesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listTraceScopes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTraceScopeTest() throws Exception {
    TraceScope expectedResponse =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TraceScope traceScope = TraceScope.newBuilder().build();
    String traceScopeId = "traceScopeId-2107793014";

    TraceScope actualResponse = client.createTraceScope(parent, traceScope, traceScopeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTraceScopeRequest actualRequest = ((CreateTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(traceScope, actualRequest.getTraceScope());
    Assert.assertEquals(traceScopeId, actualRequest.getTraceScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTraceScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      TraceScope traceScope = TraceScope.newBuilder().build();
      String traceScopeId = "traceScopeId-2107793014";
      client.createTraceScope(parent, traceScope, traceScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createTraceScopeTest2() throws Exception {
    TraceScope expectedResponse =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    String parent = "parent-995424086";
    TraceScope traceScope = TraceScope.newBuilder().build();
    String traceScopeId = "traceScopeId-2107793014";

    TraceScope actualResponse = client.createTraceScope(parent, traceScope, traceScopeId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateTraceScopeRequest actualRequest = ((CreateTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(traceScope, actualRequest.getTraceScope());
    Assert.assertEquals(traceScopeId, actualRequest.getTraceScopeId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createTraceScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String parent = "parent-995424086";
      TraceScope traceScope = TraceScope.newBuilder().build();
      String traceScopeId = "traceScopeId-2107793014";
      client.createTraceScope(parent, traceScope, traceScopeId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateTraceScopeTest() throws Exception {
    TraceScope expectedResponse =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockObservability.addResponse(expectedResponse);

    TraceScope traceScope = TraceScope.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TraceScope actualResponse = client.updateTraceScope(traceScope, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateTraceScopeRequest actualRequest = ((UpdateTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(traceScope, actualRequest.getTraceScope());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateTraceScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      TraceScope traceScope = TraceScope.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateTraceScope(traceScope, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTraceScopeTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockObservability.addResponse(expectedResponse);

    TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");

    client.deleteTraceScope(name);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTraceScopeRequest actualRequest = ((DeleteTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTraceScopeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");
      client.deleteTraceScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteTraceScopeTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteTraceScope(name);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteTraceScopeRequest actualRequest = ((DeleteTraceScopeRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteTraceScopeExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockObservability.addException(exception);

    try {
      String name = "name3373707";
      client.deleteTraceScope(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setDefaultStorageLocation("defaultStorageLocation-872738097")
            .setServiceAccountId("serviceAccountId1964232947")
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockObservability.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      SettingsName name = SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");
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
            .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setDefaultStorageLocation("defaultStorageLocation-872738097")
            .setServiceAccountId("serviceAccountId1964232947")
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    mockObservability.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

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
            .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setDefaultStorageLocation("defaultStorageLocation-872738097")
            .setServiceAccountId("serviceAccountId1964232947")
            .setKmsKeyName("kmsKeyName412586233")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateSettingsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockObservability.addResponse(resultOperation);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettingsAsync(settings, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockObservability.getRequests();
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
    mockObservability.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettingsAsync(settings, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
