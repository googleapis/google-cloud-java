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

package com.google.cloud.discoveryengine.v1;

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
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private CompletionServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockCompletionService = new MockCompletionService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockCompletionService, mockLocations));
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
            .addAllQuerySuggestions(new ArrayList<CompleteQueryResponse.QuerySuggestion>())
            .setTailMatchTriggered(true)
            .build();
    mockCompletionService.addResponse(expectedResponse);

    CompleteQueryRequest request =
        CompleteQueryRequest.newBuilder()
            .setDataStore(
                DataStoreName.ofProjectLocationDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                    .toString())
            .setQuery("query107944136")
            .setQueryModel("queryModel-184930495")
            .setUserPseudoId("userPseudoId-1155274652")
            .setIncludeTailSuggestions(true)
            .build();

    CompleteQueryResponse actualResponse = client.completeQuery(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteQueryRequest actualRequest = ((CompleteQueryRequest) actualRequests.get(0));

    Assert.assertEquals(request.getDataStore(), actualRequest.getDataStore());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getQueryModel(), actualRequest.getQueryModel());
    Assert.assertEquals(request.getUserPseudoId(), actualRequest.getUserPseudoId());
    Assert.assertEquals(
        request.getIncludeTailSuggestions(), actualRequest.getIncludeTailSuggestions());
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
              .setDataStore(
                  DataStoreName.ofProjectLocationDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]")
                      .toString())
              .setQuery("query107944136")
              .setQueryModel("queryModel-184930495")
              .setUserPseudoId("userPseudoId-1155274652")
              .setIncludeTailSuggestions(true)
              .build();
      client.completeQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void importSuggestionDenyListEntriesTest() throws Exception {
    ImportSuggestionDenyListEntriesResponse expectedResponse =
        ImportSuggestionDenyListEntriesResponse.newBuilder()
            .addAllErrorSamples(new ArrayList<Status>())
            .setImportedEntriesCount(-325324123)
            .setFailedEntriesCount(-1467071458)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importSuggestionDenyListEntriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCompletionService.addResponse(resultOperation);

    ImportSuggestionDenyListEntriesRequest request =
        ImportSuggestionDenyListEntriesRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .build();

    ImportSuggestionDenyListEntriesResponse actualResponse =
        client.importSuggestionDenyListEntriesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportSuggestionDenyListEntriesRequest actualRequest =
        ((ImportSuggestionDenyListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getInlineSource(), actualRequest.getInlineSource());
    Assert.assertEquals(request.getGcsSource(), actualRequest.getGcsSource());
    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importSuggestionDenyListEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompletionService.addException(exception);

    try {
      ImportSuggestionDenyListEntriesRequest request =
          ImportSuggestionDenyListEntriesRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.importSuggestionDenyListEntriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void purgeSuggestionDenyListEntriesTest() throws Exception {
    PurgeSuggestionDenyListEntriesResponse expectedResponse =
        PurgeSuggestionDenyListEntriesResponse.newBuilder()
            .setPurgeCount(575305851)
            .addAllErrorSamples(new ArrayList<Status>())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("purgeSuggestionDenyListEntriesTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockCompletionService.addResponse(resultOperation);

    PurgeSuggestionDenyListEntriesRequest request =
        PurgeSuggestionDenyListEntriesRequest.newBuilder()
            .setParent(
                DataStoreName.ofProjectLocationCollectionDataStoreName(
                        "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                    .toString())
            .build();

    PurgeSuggestionDenyListEntriesResponse actualResponse =
        client.purgeSuggestionDenyListEntriesAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockCompletionService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    PurgeSuggestionDenyListEntriesRequest actualRequest =
        ((PurgeSuggestionDenyListEntriesRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void purgeSuggestionDenyListEntriesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockCompletionService.addException(exception);

    try {
      PurgeSuggestionDenyListEntriesRequest request =
          PurgeSuggestionDenyListEntriesRequest.newBuilder()
              .setParent(
                  DataStoreName.ofProjectLocationCollectionDataStoreName(
                          "[PROJECT]", "[LOCATION]", "[COLLECTION]", "[DATA_STORE]")
                      .toString())
              .build();
      client.purgeSuggestionDenyListEntriesAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
