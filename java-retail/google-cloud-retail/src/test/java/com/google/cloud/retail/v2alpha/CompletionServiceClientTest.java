/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.longrunning.Operation;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class CompletionServiceClientTest {
  private static MockCompletionService mockCompletionService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CompletionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCompletionService = new MockCompletionService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockCompletionService));
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
    CompletionServiceSettings settings =
        CompletionServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = CompletionServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void completeQueryTest() throws Exception {
    CompleteQueryResponse expectedResponse =
        CompleteQueryResponse.newBuilder()
            .addAllCompletionResults(new ArrayList<CompleteQueryResponse.CompletionResult>())
            .setAttributionToken("attributionToken104706234")
            .addAllRecentSearchResults(new ArrayList<CompleteQueryResponse.RecentSearchResult>())
            .putAllAttributeResults(new HashMap<String, CompleteQueryResponse.AttributeResult>())
            .build();
    mockCompletionService.addResponse(expectedResponse);

    CompleteQueryRequest request =
        CompleteQueryRequest.newBuilder()
            .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setQuery("query107944136")
            .setVisitorId("visitorId1880545833")
            .addAllLanguageCodes(new ArrayList<String>())
            .setDeviceType("deviceType781190832")
            .setDataset("dataset1443214456")
            .setMaxSuggestions(618824852)
            .setEnableAttributeSuggestions(true)
            .build();

    CompleteQueryResponse actualResponse = client.completeQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteQueryRequest actualRequest = ((CompleteQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getCatalog(), actualRequest.getCatalog());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getVisitorId(), actualRequest.getVisitorId());
    Assert.assertEquals(request.getLanguageCodesList(), actualRequest.getLanguageCodesList());
    Assert.assertEquals(request.getDeviceType(), actualRequest.getDeviceType());
    Assert.assertEquals(request.getDataset(), actualRequest.getDataset());
    Assert.assertEquals(request.getMaxSuggestions(), actualRequest.getMaxSuggestions());
    Assert.assertEquals(
        request.getEnableAttributeSuggestions(), actualRequest.getEnableAttributeSuggestions());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeQueryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompletionService.addException(exception);

    try {
      CompleteQueryRequest request =
          CompleteQueryRequest.newBuilder()
              .setCatalog(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setQuery("query107944136")
              .setVisitorId("visitorId1880545833")
              .addAllLanguageCodes(new ArrayList<String>())
              .setDeviceType("deviceType781190832")
              .setDataset("dataset1443214456")
              .setMaxSuggestions(618824852)
              .setEnableAttributeSuggestions(true)
              .build();
      client.completeQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importCompletionDataTest() throws Exception {
    ImportCompletionDataResponse expectedResponse =
        ImportCompletionDataResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importCompletionDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCompletionService.addResponse(resultOperation);

    ImportCompletionDataRequest request =
        ImportCompletionDataRequest.newBuilder()
            .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
            .setInputConfig(CompletionDataInputConfig.newBuilder().build())
            .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
            .build();

    ImportCompletionDataResponse actualResponse = client.importCompletionDataAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportCompletionDataRequest actualRequest =
        ((ImportCompletionDataRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getInputConfig(), actualRequest.getInputConfig());
    Assert.assertEquals(
        request.getNotificationPubsubTopic(), actualRequest.getNotificationPubsubTopic());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importCompletionDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompletionService.addException(exception);

    try {
      ImportCompletionDataRequest request =
          ImportCompletionDataRequest.newBuilder()
              .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
              .setInputConfig(CompletionDataInputConfig.newBuilder().build())
              .setNotificationPubsubTopic("notificationPubsubTopic-1361224991")
              .build();
      client.importCompletionDataAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
