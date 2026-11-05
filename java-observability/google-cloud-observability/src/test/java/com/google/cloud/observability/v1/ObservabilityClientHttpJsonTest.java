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
import com.google.cloud.observability.v1.stub.HttpJsonObservabilityStub;
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
public class ObservabilityClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ObservabilityClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonObservabilityStub.getMethodDescriptors(),
            ObservabilitySettings.getDefaultEndpoint());
    ObservabilitySettings settings =
        ObservabilitySettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ObservabilitySettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ObservabilityClient.create(settings);
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
  public void getScopeTest() throws Exception {
    Scope expectedResponse =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLogScope("logScope2002130288")
            .setTraceScope("traceScope976576527")
            .build();
    mockService.addResponse(expectedResponse);

    ScopeName name = ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]");

    Scope actualResponse = client.getScope(name);
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
  public void getScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";

    Scope actualResponse = client.getScope(name);
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
  public void getScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-6287/locations/location-6287/scopes/scope-6287";
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
    mockService.addResponse(expectedResponse);

    Scope scope =
        Scope.newBuilder()
            .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLogScope("logScope2002130288")
            .setTraceScope("traceScope976576527")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Scope actualResponse = client.updateScope(scope, updateMask);
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
  public void updateScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Scope scope =
          Scope.newBuilder()
              .setName(ScopeName.of("[PROJECT]", "[LOCATION]", "[SCOPE]").toString())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setLogScope("logScope2002130288")
              .setTraceScope("traceScope976576527")
              .build();
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
    mockService.addResponse(expectedResponse);

    BucketName name = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");

    Bucket actualResponse = client.getBucket(name);
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
  public void getBucketExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-4529/locations/location-4529/buckets/bucket-4529";

    Bucket actualResponse = client.getBucket(name);
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
  public void getBucketExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-4529/locations/location-4529/buckets/bucket-4529";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBucketsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListBucketsPagedResponse pagedListResponse = client.listBuckets(parent);

    List<Bucket> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getBucketsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listBucketsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucketAsync(parent, bucket, bucketId).get();
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
  public void createBucketExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucketAsync(parent, bucket, bucketId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    Bucket bucket = Bucket.newBuilder().build();
    String bucketId = "bucketId-1603305307";

    Bucket actualResponse = client.createBucketAsync(parent, bucket, bucketId).get();
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
  public void createBucketExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      Bucket bucket = Bucket.newBuilder().build();
      String bucketId = "bucketId-1603305307";
      client.createBucketAsync(parent, bucket, bucketId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Bucket bucket =
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
    FieldMask updateMask = FieldMask.newBuilder().build();

    Bucket actualResponse = client.updateBucketAsync(bucket, updateMask).get();
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
  public void updateBucketExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Bucket bucket =
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
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateBucketAsync(bucket, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    DatasetName name = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9818/locations/location-9818/buckets/bucket-9818/datasets/dataset-9818";

    Dataset actualResponse = client.getDataset(name);
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
  public void getDatasetExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9818/locations/location-9818/buckets/bucket-9818/datasets/dataset-9818";
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
    mockService.addResponse(expectedResponse);

    BucketName parent = BucketName.of("[PROJECT]", "[LOCATION]", "[BUCKET]");

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDatasetsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-738/locations/location-738/buckets/bucket-738";

    ListDatasetsPagedResponse pagedListResponse = client.listDatasets(parent);

    List<Dataset> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDatasetsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listDatasetsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-738/locations/location-738/buckets/bucket-738";
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
    mockService.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[VIEW]");

    View actualResponse = client.getView(name);
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
  public void getViewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9312/locations/location-9312/buckets/bucket-9312/datasets/dataset-9312/views/view-9312";

    View actualResponse = client.getView(name);
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
  public void getViewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9312/locations/location-9312/buckets/bucket-9312/datasets/dataset-9312/views/view-9312";
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
    mockService.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listViewsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listViewsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";
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
    mockService.addResponse(expectedResponse);

    LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");

    Link actualResponse = client.getLink(name);
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
  public void getLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9963/locations/location-9963/buckets/bucket-9963/datasets/dataset-9963/links/link-9963";

    Link actualResponse = client.getLink(name);
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
  public void getLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9963/locations/location-9963/buckets/bucket-9963/datasets/dataset-9963/links/link-9963";
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
    mockService.addResponse(expectedResponse);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLinksExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";

    ListLinksPagedResponse pagedListResponse = client.listLinks(parent);

    List<Link> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLinksList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listLinksExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";
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
    mockService.addResponse(resultOperation);

    DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
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
  public void createLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DatasetName parent = DatasetName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]");
      Link link = Link.newBuilder().build();
      String linkId = "linkId-1102667083";
      client.createLinkAsync(parent, link, linkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";
    Link link = Link.newBuilder().build();
    String linkId = "linkId-1102667083";

    Link actualResponse = client.createLinkAsync(parent, link, linkId).get();
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
  public void createLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9223/locations/location-9223/buckets/bucket-9223/datasets/dataset-9223";
      Link link = Link.newBuilder().build();
      String linkId = "linkId-1102667083";
      client.createLinkAsync(parent, link, linkId).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    Link link =
        Link.newBuilder()
            .setName(
                LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                    .toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Link actualResponse = client.updateLinkAsync(link, updateMask).get();
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
  public void updateLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Link link =
          Link.newBuilder()
              .setName(
                  LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]")
                      .toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateLinkAsync(link, updateMask).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");

    client.deleteLinkAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteLinkExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LinkName name = LinkName.of("[PROJECT]", "[LOCATION]", "[BUCKET]", "[DATASET]", "[LINK]");
      client.deleteLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(resultOperation);

    String name =
        "projects/project-9963/locations/location-9963/buckets/bucket-9963/datasets/dataset-9963/links/link-9963";

    client.deleteLinkAsync(name).get();

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteLinkExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9963/locations/location-9963/buckets/bucket-9963/datasets/dataset-9963/links/link-9963";
      client.deleteLinkAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
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
    mockService.addResponse(expectedResponse);

    TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");

    TraceScope actualResponse = client.getTraceScope(name);
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
  public void getTraceScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9962/locations/location-9962/traceScopes/traceScope-9962";

    TraceScope actualResponse = client.getTraceScope(name);
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
  public void getTraceScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9962/locations/location-9962/traceScopes/traceScope-9962";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListTraceScopesPagedResponse pagedListResponse = client.listTraceScopes(parent);

    List<TraceScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTraceScopesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTraceScopesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListTraceScopesPagedResponse pagedListResponse = client.listTraceScopes(parent);

    List<TraceScope> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getTraceScopesList().get(0), resources.get(0));

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void listTraceScopesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    TraceScope traceScope = TraceScope.newBuilder().build();
    String traceScopeId = "traceScopeId-2107793014";

    TraceScope actualResponse = client.createTraceScope(parent, traceScope, traceScopeId);
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
  public void createTraceScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    TraceScope traceScope = TraceScope.newBuilder().build();
    String traceScopeId = "traceScopeId-2107793014";

    TraceScope actualResponse = client.createTraceScope(parent, traceScope, traceScopeId);
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
  public void createTraceScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
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
    mockService.addResponse(expectedResponse);

    TraceScope traceScope =
        TraceScope.newBuilder()
            .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
            .addAllResourceNames(new ArrayList<String>())
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    TraceScope actualResponse = client.updateTraceScope(traceScope, updateMask);
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
  public void updateTraceScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      TraceScope traceScope =
          TraceScope.newBuilder()
              .setName(TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]").toString())
              .addAllResourceNames(new ArrayList<String>())
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
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
    mockService.addResponse(expectedResponse);

    TraceScopeName name = TraceScopeName.of("[PROJECT]", "[LOCATION]", "[TRACE_SCOPE]");

    client.deleteTraceScope(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTraceScopeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

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
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9962/locations/location-9962/traceScopes/traceScope-9962";

    client.deleteTraceScope(name);

    List<String> actualRequests = mockService.getRequestPaths();
    Assert.assertEquals(1, actualRequests.size());

    String apiClientHeaderKey =
        mockService
            .getRequestHeaders()
            .get(ApiClientHeaderProvider.getDefaultApiClientHeaderKey())
            .iterator()
            .next();
    Assert.assertTrue(
        GaxHttpJsonProperties.getDefaultApiClientHeaderPattern()
            .matcher(apiClientHeaderKey)
            .matches());
  }

  @Test
  public void deleteTraceScopeExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9962/locations/location-9962/traceScopes/traceScope-9962";
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
    mockService.addResponse(expectedResponse);

    SettingsName name = SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]");

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
    mockService.addResponse(resultOperation);

    Settings settings =
        Settings.newBuilder()
            .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
            .setDefaultStorageLocation("defaultStorageLocation-872738097")
            .setServiceAccountId("serviceAccountId1964232947")
            .setKmsKeyName("kmsKeyName412586233")
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
              .setName(SettingsName.ofProjectLocationName("[PROJECT]", "[LOCATION]").toString())
              .setDefaultStorageLocation("defaultStorageLocation-872738097")
              .setServiceAccountId("serviceAccountId1964232947")
              .setKmsKeyName("kmsKeyName412586233")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettingsAsync(settings, updateMask).get();
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
