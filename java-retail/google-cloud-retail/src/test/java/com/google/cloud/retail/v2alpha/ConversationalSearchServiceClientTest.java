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

package com.google.cloud.retail.v2alpha;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
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
public class ConversationalSearchServiceClientTest {
  private static MockConversationalSearchService mockConversationalSearchService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConversationalSearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConversationalSearchService = new MockConversationalSearchService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConversationalSearchService, mockLocations));
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
    ConversationalSearchServiceSettings settings =
        ConversationalSearchServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationalSearchServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void conversationalSearchTest() throws Exception {
    ConversationalSearchResponse expectedResponse =
        ConversationalSearchResponse.newBuilder()
            .addAllUserQueryTypes(new ArrayList<String>())
            .setConversationalTextResponse("conversationalTextResponse-641076324")
            .setFollowupQuestion(ConversationalSearchResponse.FollowupQuestion.newBuilder().build())
            .setConversationId("conversationId-1676095234")
            .addAllRefinedSearch(new ArrayList<ConversationalSearchResponse.RefinedSearch>())
            .setConversationalFilteringResult(
                ConversationalSearchResponse.ConversationalFilteringResult.newBuilder().build())
            .build();
    mockConversationalSearchService.addResponse(expectedResponse);
    ConversationalSearchRequest request =
        ConversationalSearchRequest.newBuilder()
            .setPlacement("placement1792938725")
            .setBranch(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setQuery("query107944136")
            .addAllPageCategories(new ArrayList<String>())
            .setConversationId("conversationId-1676095234")
            .setSearchParams(ConversationalSearchRequest.SearchParams.newBuilder().build())
            .setVisitorId("visitorId1880545833")
            .setUserInfo(UserInfo.newBuilder().build())
            .setConversationalFilteringSpec(
                ConversationalSearchRequest.ConversationalFilteringSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllSafetySettings(new ArrayList<SafetySetting>())
            .build();

    MockStreamObserver<ConversationalSearchResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse> callable =
        client.conversationalSearchCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<ConversationalSearchResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void conversationalSearchExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationalSearchService.addException(exception);
    ConversationalSearchRequest request =
        ConversationalSearchRequest.newBuilder()
            .setPlacement("placement1792938725")
            .setBranch(BranchName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[BRANCH]").toString())
            .setQuery("query107944136")
            .addAllPageCategories(new ArrayList<String>())
            .setConversationId("conversationId-1676095234")
            .setSearchParams(ConversationalSearchRequest.SearchParams.newBuilder().build())
            .setVisitorId("visitorId1880545833")
            .setUserInfo(UserInfo.newBuilder().build())
            .setConversationalFilteringSpec(
                ConversationalSearchRequest.ConversationalFilteringSpec.newBuilder().build())
            .putAllUserLabels(new HashMap<String, String>())
            .addAllSafetySettings(new ArrayList<SafetySetting>())
            .build();

    MockStreamObserver<ConversationalSearchResponse> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ConversationalSearchRequest, ConversationalSearchResponse> callable =
        client.conversationalSearchCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<ConversationalSearchResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
