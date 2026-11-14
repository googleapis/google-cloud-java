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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.type.Interval;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
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
public class SearchServiceClientTest {
  private static MockSearchService mockSearchService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private SearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockSearchService = new MockSearchService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockSearchService));
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
    SearchServiceSettings settings =
        SearchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = SearchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockSearchService.addResponse(resultOperation);

    InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
    String query = "query107944136";
    Interval timeRange = Interval.newBuilder().build();

    SearchSession actualResponse = client.searchAsync(parent, query, timeRange).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertEquals(timeRange, actualRequest.getTimeRange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

    try {
      InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
      String query = "query107944136";
      Interval timeRange = Interval.newBuilder().build();
      client.searchAsync(parent, query, timeRange).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSearchService.addResponse(resultOperation);

    String parent = "parent-995424086";
    String query = "query107944136";
    Interval timeRange = Interval.newBuilder().build();

    SearchSession actualResponse = client.searchAsync(parent, query, timeRange).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchRequest actualRequest = ((SearchRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertEquals(timeRange, actualRequest.getTimeRange());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

    try {
      String parent = "parent-995424086";
      String query = "query107944136";
      Interval timeRange = Interval.newBuilder().build();
      client.searchAsync(parent, query, timeRange).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockSearchService.addResponse(expectedResponse);

    SearchSessionName parent =
        SearchSessionName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[SEARCH_SESSION]");

    ListSearchedResultsPagedResponse pagedListResponse = client.listSearchedResults(parent);

    List<SearchedResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchedResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchedResultsRequest actualRequest = ((ListSearchedResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchedResultsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

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
    mockSearchService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListSearchedResultsPagedResponse pagedListResponse = client.listSearchedResults(parent);

    List<SearchedResult> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSearchedResultsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSearchedResultsRequest actualRequest = ((ListSearchedResultsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSearchedResultsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockSearchService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listSearchedResults(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
