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

package com.google.cloud.geminidataanalytics.v1beta;

import static com.google.cloud.geminidataanalytics.v1beta.ContextRetrievalServiceClient.ListLocationsPagedResponse;

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
public class ContextRetrievalServiceClientTest {
  private static MockContextRetrievalService mockContextRetrievalService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ContextRetrievalServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockContextRetrievalService = new MockContextRetrievalService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockContextRetrievalService, mockLocations));
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
    ContextRetrievalServiceSettings settings =
        ContextRetrievalServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContextRetrievalServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void retrieveBigQueryTableContextTest() throws Exception {
    RetrieveBigQueryTableContextResponse expectedResponse =
        RetrieveBigQueryTableContextResponse.newBuilder()
            .addAllCandidates(new ArrayList<RetrieveBigQueryTableContextResponse.Candidate>())
            .addAllTableCandidates(new ArrayList<TableCandidate>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextRequest request =
        RetrieveBigQueryTableContextRequest.newBuilder()
            .setProject("project-309310695")
            .setParent("parent-995424086")
            .setQuery("query107944136")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableContextResponse actualResponse =
        client.retrieveBigQueryTableContext(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryTableContextRequest actualRequest =
        ((RetrieveBigQueryTableContextRequest) actualRequests.get(0));

    Assert.assertEquals(request.getProject(), actualRequest.getProject());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getDirectLookupList(), actualRequest.getDirectLookupList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryTableContextExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryTableContextRequest request =
          RetrieveBigQueryTableContextRequest.newBuilder()
              .setProject("project-309310695")
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .addAllDirectLookup(new ArrayList<DirectLookup>())
              .build();
      client.retrieveBigQueryTableContext(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveBigQueryTableContextsTest() throws Exception {
    RetrieveBigQueryTableContextsResponse expectedResponse =
        RetrieveBigQueryTableContextsResponse.newBuilder()
            .addAllTableCandidates(new ArrayList<TableCandidate>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextsRequest request =
        RetrieveBigQueryTableContextsRequest.newBuilder()
            .setParent("parent-995424086")
            .setQuery("query107944136")
            .addAllDirectLookups(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableContextsResponse actualResponse =
        client.retrieveBigQueryTableContexts(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryTableContextsRequest actualRequest =
        ((RetrieveBigQueryTableContextsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getDirectLookupsList(), actualRequest.getDirectLookupsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryTableContextsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryTableContextsRequest request =
          RetrieveBigQueryTableContextsRequest.newBuilder()
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .addAllDirectLookups(new ArrayList<DirectLookup>())
              .build();
      client.retrieveBigQueryTableContexts(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveBigQueryTableContextsFromRecentTablesTest() throws Exception {
    RetrieveBigQueryTableContextsFromRecentTablesResponse expectedResponse =
        RetrieveBigQueryTableContextsFromRecentTablesResponse.newBuilder()
            .addAllTableCandidates(new ArrayList<TableCandidate>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextsFromRecentTablesRequest request =
        RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
            .setParent("parent-995424086")
            .setQuery("query107944136")
            .build();

    RetrieveBigQueryTableContextsFromRecentTablesResponse actualResponse =
        client.retrieveBigQueryTableContextsFromRecentTables(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryTableContextsFromRecentTablesRequest actualRequest =
        ((RetrieveBigQueryTableContextsFromRecentTablesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryTableContextsFromRecentTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryTableContextsFromRecentTablesRequest request =
          RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .build();
      client.retrieveBigQueryTableContextsFromRecentTables(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveBigQueryTableSuggestedDescriptionsTest() throws Exception {
    RetrieveBigQueryTableSuggestedDescriptionsResponse expectedResponse =
        RetrieveBigQueryTableSuggestedDescriptionsResponse.newBuilder()
            .addAllTableCandidates(new ArrayList<TableCandidate>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryTableSuggestedDescriptionsRequest request =
        RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableSuggestedDescriptionsResponse actualResponse =
        client.retrieveBigQueryTableSuggestedDescriptions(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryTableSuggestedDescriptionsRequest actualRequest =
        ((RetrieveBigQueryTableSuggestedDescriptionsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDirectLookupList(), actualRequest.getDirectLookupList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryTableSuggestedDescriptionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryTableSuggestedDescriptionsRequest request =
          RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllDirectLookup(new ArrayList<DirectLookup>())
              .build();
      client.retrieveBigQueryTableSuggestedDescriptions(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveBigQueryTableSuggestedExamplesTest() throws Exception {
    RetrieveBigQueryTableSuggestedExamplesResponse expectedResponse =
        RetrieveBigQueryTableSuggestedExamplesResponse.newBuilder()
            .addAllExampleSuggestions(
                new ArrayList<RetrieveBigQueryTableSuggestedExamplesResponse.ExampleSuggestion>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryTableSuggestedExamplesRequest request =
        RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
            .setParent("parent-995424086")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableSuggestedExamplesResponse actualResponse =
        client.retrieveBigQueryTableSuggestedExamples(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryTableSuggestedExamplesRequest actualRequest =
        ((RetrieveBigQueryTableSuggestedExamplesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getDirectLookupList(), actualRequest.getDirectLookupList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryTableSuggestedExamplesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryTableSuggestedExamplesRequest request =
          RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
              .setParent("parent-995424086")
              .addAllDirectLookup(new ArrayList<DirectLookup>())
              .build();
      client.retrieveBigQueryTableSuggestedExamples(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void retrieveBigQueryRecentRelevantTablesTest() throws Exception {
    RetrieveBigQueryRecentRelevantTablesResponse expectedResponse =
        RetrieveBigQueryRecentRelevantTablesResponse.newBuilder()
            .addAllTableIds(new ArrayList<String>())
            .build();
    mockContextRetrievalService.addResponse(expectedResponse);

    RetrieveBigQueryRecentRelevantTablesRequest request =
        RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
            .setParent("parent-995424086")
            .setQuery("query107944136")
            .build();

    RetrieveBigQueryRecentRelevantTablesResponse actualResponse =
        client.retrieveBigQueryRecentRelevantTables(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContextRetrievalService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    RetrieveBigQueryRecentRelevantTablesRequest actualRequest =
        ((RetrieveBigQueryRecentRelevantTablesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void retrieveBigQueryRecentRelevantTablesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContextRetrievalService.addException(exception);

    try {
      RetrieveBigQueryRecentRelevantTablesRequest request =
          RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
              .setParent("parent-995424086")
              .setQuery("query107944136")
              .build();
      client.retrieveBigQueryRecentRelevantTables(request);
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
