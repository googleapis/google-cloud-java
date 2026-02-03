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

package com.google.cloud.vectorsearch.v1beta;

import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListCollectionsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListIndexesPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.VectorSearchServiceClient.ListLocationsPagedResponse;

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
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import com.google.rpc.Status;
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
public class VectorSearchServiceClientTest {
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private static MockVectorSearchService mockVectorSearchService;
  private LocalChannelProvider channelProvider;
  private VectorSearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockVectorSearchService = new MockVectorSearchService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockVectorSearchService, mockLocations));
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
    VectorSearchServiceSettings settings =
        VectorSearchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = VectorSearchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void listCollectionsTest() throws Exception {
    Collection responsesElement = Collection.newBuilder().build();
    ListCollectionsResponse expectedResponse =
        ListCollectionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllCollections(Arrays.asList(responsesElement))
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
    mockVectorSearchService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListCollectionsPagedResponse pagedListResponse = client.listCollections(parent);

    List<Collection> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getCollectionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listCollections(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchema(Struct.newBuilder().build())
            .putAllVectorSchema(new HashMap<String, VectorField>())
            .setDataSchema(Struct.newBuilder().build())
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    Collection actualResponse = client.getCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
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
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchema(Struct.newBuilder().build())
            .putAllVectorSchema(new HashMap<String, VectorField>())
            .setDataSchema(Struct.newBuilder().build())
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    String name = "name3373707";

    Collection actualResponse = client.getCollection(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      String name = "name3373707";
      client.getCollection(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchema(Struct.newBuilder().build())
            .putAllVectorSchema(new HashMap<String, VectorField>())
            .setDataSchema(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
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
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchema(Struct.newBuilder().build())
            .putAllVectorSchema(new HashMap<String, VectorField>())
            .setDataSchema(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Collection collection = Collection.newBuilder().build();
    String collectionId = "collectionId1636075609";

    Collection actualResponse =
        client.createCollectionAsync(parent, collection, collectionId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

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
  public void updateCollectionTest() throws Exception {
    Collection expectedResponse =
        Collection.newBuilder()
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .setSchema(Struct.newBuilder().build())
            .putAllVectorSchema(new HashMap<String, VectorField>())
            .setDataSchema(Struct.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("updateCollectionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    Collection collection = Collection.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Collection actualResponse = client.updateCollectionAsync(collection, updateMask).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      Collection collection = Collection.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateCollectionAsync(collection, updateMask).get();
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
    mockVectorSearchService.addResponse(resultOperation);

    CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    client.deleteCollectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
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
    mockVectorSearchService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteCollectionAsync(name).get();

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

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
  public void listIndexesTest() throws Exception {
    Index responsesElement = Index.newBuilder().build();
    ListIndexesResponse expectedResponse =
        ListIndexesResponse.newBuilder()
            .setNextPageToken("")
            .addAllIndexes(Arrays.asList(responsesElement))
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
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
    mockVectorSearchService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIndexesPagedResponse pagedListResponse = client.listIndexes(parent);

    List<Index> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getIndexesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listIndexes(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDistanceMetric(DistanceMetric.forNumber(0))
            .setIndexField("indexField723729224")
            .addAllFilterFields(new ArrayList<String>())
            .addAllStoreFields(new ArrayList<String>())
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]");

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]");
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
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDistanceMetric(DistanceMetric.forNumber(0))
            .setIndexField("indexField723729224")
            .addAllFilterFields(new ArrayList<String>())
            .addAllStoreFields(new ArrayList<String>())
            .build();
    mockVectorSearchService.addResponse(expectedResponse);

    String name = "name3373707";

    Index actualResponse = client.getIndex(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      String name = "name3373707";
      client.getIndex(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createIndexTest() throws Exception {
    Index expectedResponse =
        Index.newBuilder()
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDistanceMetric(DistanceMetric.forNumber(0))
            .setIndexField("indexField723729224")
            .addAllFilterFields(new ArrayList<String>())
            .addAllStoreFields(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
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
            .setName(IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .putAllLabels(new HashMap<String, String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDistanceMetric(DistanceMetric.forNumber(0))
            .setIndexField("indexField723729224")
            .addAllFilterFields(new ArrayList<String>())
            .addAllStoreFields(new ArrayList<String>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    String parent = "parent-995424086";
    Index index = Index.newBuilder().build();
    String indexId = "indexId1943291277";

    Index actualResponse = client.createIndexAsync(parent, index, indexId).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

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
  public void deleteIndexTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIndexTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]");

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

    try {
      IndexName name = IndexName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[INDEX]");
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
    mockVectorSearchService.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIndexAsync(name).get();

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
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
    mockVectorSearchService.addException(exception);

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
  public void importDataObjectsTest() throws Exception {
    ImportDataObjectsResponse expectedResponse =
        ImportDataObjectsResponse.newBuilder().setStatus(Status.newBuilder().build()).build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importDataObjectsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockVectorSearchService.addResponse(resultOperation);

    ImportDataObjectsRequest request =
        ImportDataObjectsRequest.newBuilder()
            .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .build();

    ImportDataObjectsResponse actualResponse = client.importDataObjectsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockVectorSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportDataObjectsRequest actualRequest = ((ImportDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getGcsImport(), actualRequest.getGcsImport());
    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockVectorSearchService.addException(exception);

    try {
      ImportDataObjectsRequest request =
          ImportDataObjectsRequest.newBuilder()
              .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .build();
      client.importDataObjectsAsync(request).get();
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
