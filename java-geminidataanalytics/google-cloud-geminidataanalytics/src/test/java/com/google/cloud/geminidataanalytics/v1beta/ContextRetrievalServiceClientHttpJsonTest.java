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
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.geminidataanalytics.v1beta.stub.HttpJsonContextRetrievalServiceStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ContextRetrievalServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ContextRetrievalServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonContextRetrievalServiceStub.getMethodDescriptors(),
            ContextRetrievalServiceSettings.getDefaultEndpoint());
    ContextRetrievalServiceSettings settings =
        ContextRetrievalServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ContextRetrievalServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContextRetrievalServiceClient.create(settings);
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
  public void retrieveBigQueryTableContextTest() throws Exception {
    RetrieveBigQueryTableContextResponse expectedResponse =
        RetrieveBigQueryTableContextResponse.newBuilder()
            .addAllCandidates(new ArrayList<RetrieveBigQueryTableContextResponse.Candidate>())
            .addAllTableCandidates(new ArrayList<TableCandidate>())
            .build();
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextRequest request =
        RetrieveBigQueryTableContextRequest.newBuilder()
            .setProject("project-309310695")
            .setParent("projects/project-5833/locations/location-5833")
            .setQuery("query107944136")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableContextResponse actualResponse =
        client.retrieveBigQueryTableContext(request);
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
  public void retrieveBigQueryTableContextExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryTableContextRequest request =
          RetrieveBigQueryTableContextRequest.newBuilder()
              .setProject("project-309310695")
              .setParent("projects/project-5833/locations/location-5833")
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
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextsRequest request =
        RetrieveBigQueryTableContextsRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setQuery("query107944136")
            .addAllDirectLookups(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableContextsResponse actualResponse =
        client.retrieveBigQueryTableContexts(request);
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
  public void retrieveBigQueryTableContextsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryTableContextsRequest request =
          RetrieveBigQueryTableContextsRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
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
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryTableContextsFromRecentTablesRequest request =
        RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setQuery("query107944136")
            .build();

    RetrieveBigQueryTableContextsFromRecentTablesResponse actualResponse =
        client.retrieveBigQueryTableContextsFromRecentTables(request);
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
  public void retrieveBigQueryTableContextsFromRecentTablesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryTableContextsFromRecentTablesRequest request =
          RetrieveBigQueryTableContextsFromRecentTablesRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
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
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryTableSuggestedDescriptionsRequest request =
        RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableSuggestedDescriptionsResponse actualResponse =
        client.retrieveBigQueryTableSuggestedDescriptions(request);
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
  public void retrieveBigQueryTableSuggestedDescriptionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryTableSuggestedDescriptionsRequest request =
          RetrieveBigQueryTableSuggestedDescriptionsRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
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
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryTableSuggestedExamplesRequest request =
        RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .addAllDirectLookup(new ArrayList<DirectLookup>())
            .build();

    RetrieveBigQueryTableSuggestedExamplesResponse actualResponse =
        client.retrieveBigQueryTableSuggestedExamples(request);
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
  public void retrieveBigQueryTableSuggestedExamplesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryTableSuggestedExamplesRequest request =
          RetrieveBigQueryTableSuggestedExamplesRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
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
    mockService.addResponse(expectedResponse);

    RetrieveBigQueryRecentRelevantTablesRequest request =
        RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
            .setParent("projects/project-5833/locations/location-5833")
            .setQuery("query107944136")
            .build();

    RetrieveBigQueryRecentRelevantTablesResponse actualResponse =
        client.retrieveBigQueryRecentRelevantTables(request);
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
  public void retrieveBigQueryRecentRelevantTablesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      RetrieveBigQueryRecentRelevantTablesRequest request =
          RetrieveBigQueryRecentRelevantTablesRequest.newBuilder()
              .setParent("projects/project-5833/locations/location-5833")
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
