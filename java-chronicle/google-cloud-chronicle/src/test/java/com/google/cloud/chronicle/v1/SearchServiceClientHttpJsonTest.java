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

package com.google.cloud.chronicle.v1;

import static com.google.cloud.chronicle.v1.SearchServiceClient.ListSearchedResultsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.chronicle.v1.stub.HttpJsonSearchServiceStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.type.Interval;
import java.io.IOException;
import java.util.Arrays;
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
public class SearchServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static SearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonSearchServiceStub.getMethodDescriptors(),
            SearchServiceSettings.getDefaultEndpoint());
    SearchServiceSettings settings =
        SearchServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                SearchServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SearchServiceClient.create(settings);
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
  public void searchTest() throws Exception {
    SearchSession expectedResponse =
        SearchSession.newBuilder()
            .setName(
                SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
                    .toString())
            .setQuery("query107944136")
            .setTimeRange(Interval.newBuilder().build())
            .setDialect(QueryDialect.forNumber(0))
            .setDraftDataAccessScope(DataAccessScope.newBuilder().build())
            .setMetadata(SearchSessionMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("searchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String query = "query107944136";
    Interval timeRange = Interval.newBuilder().build();

    SearchSession actualResponse = client.searchAsync(parent, query, timeRange).get();
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
  public void searchExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String query = "query107944136";
      Interval timeRange = Interval.newBuilder().build();
      client.searchAsync(parent, query, timeRange).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void searchTest2() throws Exception {
    SearchSession expectedResponse =
        SearchSession.newBuilder()
            .setName(
                SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]")
                    .toString())
            .setQuery("query107944136")
            .setTimeRange(Interval.newBuilder().build())
            .setDialect(QueryDialect.forNumber(0))
            .setDraftDataAccessScope(DataAccessScope.newBuilder().build())
            .setMetadata(SearchSessionMetadata.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("searchTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
    String query = "query107944136";
    Interval timeRange = Interval.newBuilder().build();

    SearchSession actualResponse = client.searchAsync(parent, query, timeRange).get();
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
  public void searchExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5197/locations/location-5197/instances/instance-5197";
      String query = "query107944136";
      Interval timeRange = Interval.newBuilder().build();
      client.searchAsync(parent, query, timeRange).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void listSearchedResultsTest() throws Exception {
    SearchedResult responsesElement = SearchedResult.newBuilder().build();
    ListSearchedResultsResponse expectedResponse =
        ListSearchedResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchedResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    SearchSessionName parent =
        SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]");

    ListSearchedResultsPagedResponse pagedListResponse = client.listSearchedResults(parent);

    List<SearchedResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchedResultsList().get(0), resources.get(0));

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
  public void listSearchedResultsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchSessionName parent =
          SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]");
      client.listSearchedResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSearchedResultsTest2() throws Exception {
    SearchedResult responsesElement = SearchedResult.newBuilder().build();
    ListSearchedResultsResponse expectedResponse =
        ListSearchedResultsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSearchedResults(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-9660/locations/location-9660/instances/instance-9660/searchSessions/searchSession-9660";

    ListSearchedResultsPagedResponse pagedListResponse = client.listSearchedResults(parent);

    List<SearchedResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchedResultsList().get(0), resources.get(0));

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
  public void listSearchedResultsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-9660/locations/location-9660/instances/instance-9660/searchSessions/searchSession-9660";
      client.listSearchedResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
