/*
 * Copyright 2025 Google LLC
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

import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.QueryDataObjectsPagedResponse;
import static com.google.cloud.vectorsearch.v1beta.DataObjectSearchServiceClient.SearchDataObjectsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class DataObjectSearchServiceClientTest {
  private static MockDataObjectSearchService mockDataObjectSearchService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataObjectSearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataObjectSearchService = new MockDataObjectSearchService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataObjectSearchService, mockLocations));
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
    DataObjectSearchServiceSettings settings =
        DataObjectSearchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataObjectSearchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void searchDataObjectsTest() throws Exception {
    SearchResult responsesElement = SearchResult.newBuilder().build();
    SearchDataObjectsResponse expectedResponse =
        SearchDataObjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllResults(Arrays.asList(responsesElement))
            .build();
    mockDataObjectSearchService.addResponse(expectedResponse);

    SearchDataObjectsRequest request =
        SearchDataObjectsRequest.newBuilder()
            .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    SearchDataObjectsPagedResponse pagedListResponse = client.searchDataObjects(request);

    List<SearchResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataObjectSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchDataObjectsRequest actualRequest = ((SearchDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getVectorSearch(), actualRequest.getVectorSearch());
    Assert.assertEquals(request.getSemanticSearch(), actualRequest.getSemanticSearch());
    Assert.assertEquals(request.getTextSearch(), actualRequest.getTextSearch());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectSearchService.addException(exception);

    try {
      SearchDataObjectsRequest request =
          SearchDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.searchDataObjects(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryDataObjectsTest() throws Exception {
    DataObject responsesElement = DataObject.newBuilder().build();
    QueryDataObjectsResponse expectedResponse =
        QueryDataObjectsResponse.newBuilder()
            .setNextPageToken("")
            .addAllDataObjects(Arrays.asList(responsesElement))
            .build();
    mockDataObjectSearchService.addResponse(expectedResponse);

    QueryDataObjectsRequest request =
        QueryDataObjectsRequest.newBuilder()
            .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setFilter(Struct.newBuilder().build())
            .setOutputFields(OutputFields.newBuilder().build())
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    QueryDataObjectsPagedResponse pagedListResponse = client.queryDataObjects(request);

    List<DataObject> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getDataObjectsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataObjectSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryDataObjectsRequest actualRequest = ((QueryDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getOutputFields(), actualRequest.getOutputFields());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectSearchService.addException(exception);

    try {
      QueryDataObjectsRequest request =
          QueryDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setFilter(Struct.newBuilder().build())
              .setOutputFields(OutputFields.newBuilder().build())
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .build();
      client.queryDataObjects(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void aggregateDataObjectsTest() throws Exception {
    AggregateDataObjectsResponse expectedResponse =
        AggregateDataObjectsResponse.newBuilder()
            .addAllAggregateResults(new ArrayList<Struct>())
            .build();
    mockDataObjectSearchService.addResponse(expectedResponse);

    AggregateDataObjectsRequest request =
        AggregateDataObjectsRequest.newBuilder()
            .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .setFilter(Struct.newBuilder().build())
            .setAggregate(AggregationMethod.forNumber(0))
            .build();

    AggregateDataObjectsResponse actualResponse = client.aggregateDataObjects(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AggregateDataObjectsRequest actualRequest =
        ((AggregateDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getAggregate(), actualRequest.getAggregate());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void aggregateDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectSearchService.addException(exception);

    try {
      AggregateDataObjectsRequest request =
          AggregateDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .setFilter(Struct.newBuilder().build())
              .setAggregate(AggregationMethod.forNumber(0))
              .build();
      client.aggregateDataObjects(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchSearchDataObjectsTest() throws Exception {
    BatchSearchDataObjectsResponse expectedResponse =
        BatchSearchDataObjectsResponse.newBuilder()
            .addAllResults(new ArrayList<SearchDataObjectsResponse>())
            .build();
    mockDataObjectSearchService.addResponse(expectedResponse);

    BatchSearchDataObjectsRequest request =
        BatchSearchDataObjectsRequest.newBuilder()
            .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
            .addAllSearches(new ArrayList<Search>())
            .setCombine(BatchSearchDataObjectsRequest.CombineResultsOptions.newBuilder().build())
            .build();

    BatchSearchDataObjectsResponse actualResponse = client.batchSearchDataObjects(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataObjectSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchSearchDataObjectsRequest actualRequest =
        ((BatchSearchDataObjectsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getSearchesList(), actualRequest.getSearchesList());
    Assert.assertEquals(request.getCombine(), actualRequest.getCombine());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchSearchDataObjectsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataObjectSearchService.addException(exception);

    try {
      BatchSearchDataObjectsRequest request =
          BatchSearchDataObjectsRequest.newBuilder()
              .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
              .addAllSearches(new ArrayList<Search>())
              .setCombine(BatchSearchDataObjectsRequest.CombineResultsOptions.newBuilder().build())
              .build();
      client.batchSearchDataObjects(request);
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
