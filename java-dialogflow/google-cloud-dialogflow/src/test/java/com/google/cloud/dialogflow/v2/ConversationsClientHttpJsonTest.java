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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2.stub.HttpJsonConversationsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ConversationsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConversationsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConversationsStub.getMethodDescriptors(),
            ConversationsSettings.getDefaultEndpoint());
    ConversationsSettings settings =
        ConversationsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConversationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationsClient.create(settings);
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
  public void createConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
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
  public void createConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      Conversation conversation = Conversation.newBuilder().build();
      client.createConversation(parent, conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationTest2() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
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
  public void createConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      Conversation conversation = Conversation.newBuilder().build();
      client.createConversation(parent, conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationTest3() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
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
  public void createConversationExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      Conversation conversation = Conversation.newBuilder().build();
      client.createConversation(parent, conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationsTest() throws Exception {
    Conversation responsesElement = Conversation.newBuilder().build();
    ListConversationsResponse expectedResponse =
        ListConversationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

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
  public void listConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationsTest2() throws Exception {
    Conversation responsesElement = Conversation.newBuilder().build();
    ListConversationsResponse expectedResponse =
        ListConversationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

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
  public void listConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ProjectName parent = ProjectName.of("[PROJECT]");
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listConversationsTest3() throws Exception {
    Conversation responsesElement = Conversation.newBuilder().build();
    ListConversationsResponse expectedResponse =
        ListConversationsResponse.newBuilder()
            .setNextPageToken("")
            .addAllConversations(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-2353";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

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
  public void listConversationsExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-2353";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
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
  public void getConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName name =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.getConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getConversationTest2() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3460/conversations/conversation-3460";

    Conversation actualResponse = client.getConversation(name);
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
  public void getConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3460/conversations/conversation-3460";
      client.getConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    Conversation actualResponse = client.completeConversation(name);
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
  public void completeConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName name =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.completeConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeConversationTest2() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setPhoneNumber(ConversationPhoneNumber.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .setTelephonyConnectionInfo(Conversation.TelephonyConnectionInfo.newBuilder().build())
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3460/conversations/conversation-3460";

    Conversation actualResponse = client.completeConversation(name);
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
  public void completeConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-3460/conversations/conversation-3460";
      client.completeConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestContextReferencesTest() throws Exception {
    IngestContextReferencesResponse expectedResponse =
        IngestContextReferencesResponse.newBuilder()
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();

    IngestContextReferencesResponse actualResponse =
        client.ingestContextReferences(conversation, contextReferences);
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
  public void ingestContextReferencesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName conversation =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();
      client.ingestContextReferences(conversation, contextReferences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void ingestContextReferencesTest2() throws Exception {
    IngestContextReferencesResponse expectedResponse =
        IngestContextReferencesResponse.newBuilder()
            .putAllIngestedContextReferences(new HashMap<String, Conversation.ContextReference>())
            .build();
    mockService.addResponse(expectedResponse);

    String conversation =
        "projects/project-1634/locations/location-1634/conversations/conversation-1634";
    Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();

    IngestContextReferencesResponse actualResponse =
        client.ingestContextReferences(conversation, contextReferences);
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
  public void ingestContextReferencesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversation =
          "projects/project-1634/locations/location-1634/conversations/conversation-1634";
      Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();
      client.ingestContextReferences(conversation, contextReferences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessagesTest() throws Exception {
    Message responsesElement = Message.newBuilder().build();
    ListMessagesResponse expectedResponse =
        ListMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

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
  public void listMessagesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.listMessages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessagesTest2() throws Exception {
    Message responsesElement = Message.newBuilder().build();
    ListMessagesResponse expectedResponse =
        ListMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessages(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4379/conversations/conversation-4379";

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

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
  public void listMessagesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4379/conversations/conversation-4379";
      client.listMessages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestConversationSummaryTest() throws Exception {
    SuggestConversationSummaryResponse expectedResponse =
        SuggestConversationSummaryResponse.newBuilder()
            .setSummary(SuggestConversationSummaryResponse.Summary.newBuilder().build())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    SuggestConversationSummaryResponse actualResponse =
        client.suggestConversationSummary(conversation);
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
  public void suggestConversationSummaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName conversation =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.suggestConversationSummary(conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestConversationSummaryTest2() throws Exception {
    SuggestConversationSummaryResponse expectedResponse =
        SuggestConversationSummaryResponse.newBuilder()
            .setSummary(SuggestConversationSummaryResponse.Summary.newBuilder().build())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    String conversation = "projects/project-5228/conversations/conversation-5228";

    SuggestConversationSummaryResponse actualResponse =
        client.suggestConversationSummary(conversation);
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
  public void suggestConversationSummaryExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversation = "projects/project-5228/conversations/conversation-5228";
      client.suggestConversationSummary(conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateStatelessSummaryTest() throws Exception {
    GenerateStatelessSummaryResponse expectedResponse =
        GenerateStatelessSummaryResponse.newBuilder()
            .setSummary(GenerateStatelessSummaryResponse.Summary.newBuilder().build())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    GenerateStatelessSummaryRequest request =
        GenerateStatelessSummaryRequest.newBuilder()
            .setStatelessConversation(
                GenerateStatelessSummaryRequest.MinimalConversation.newBuilder()
                    .addAllMessages(new ArrayList<Message>())
                    .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
                    .build())
            .setConversationProfile(ConversationProfile.newBuilder().build())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setMaxContextSize(-1134084212)
            .build();

    GenerateStatelessSummaryResponse actualResponse = client.generateStatelessSummary(request);
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
  public void generateStatelessSummaryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateStatelessSummaryRequest request =
          GenerateStatelessSummaryRequest.newBuilder()
              .setStatelessConversation(
                  GenerateStatelessSummaryRequest.MinimalConversation.newBuilder()
                      .addAllMessages(new ArrayList<Message>())
                      .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
                      .build())
              .setConversationProfile(ConversationProfile.newBuilder().build())
              .setLatestMessage(
                  MessageName.ofProjectConversationMessageName(
                          "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                      .toString())
              .setMaxContextSize(-1134084212)
              .build();
      client.generateStatelessSummary(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateStatelessSuggestionTest() throws Exception {
    GenerateStatelessSuggestionResponse expectedResponse =
        GenerateStatelessSuggestionResponse.newBuilder()
            .setGeneratorSuggestion(GeneratorSuggestion.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    GenerateStatelessSuggestionRequest request =
        GenerateStatelessSuggestionRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
            .setConversationContext(ConversationContext.newBuilder().build())
            .addAllTriggerEvents(new ArrayList<TriggerEvent>())
            .build();

    GenerateStatelessSuggestionResponse actualResponse =
        client.generateStatelessSuggestion(request);
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
  public void generateStatelessSuggestionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      GenerateStatelessSuggestionRequest request =
          GenerateStatelessSuggestionRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .putAllContextReferences(new HashMap<String, Conversation.ContextReference>())
              .setConversationContext(ConversationContext.newBuilder().build())
              .addAllTriggerEvents(new ArrayList<TriggerEvent>())
              .build();
      client.generateStatelessSuggestion(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void searchKnowledgeTest() throws Exception {
    SearchKnowledgeResponse expectedResponse =
        SearchKnowledgeResponse.newBuilder()
            .addAllAnswers(new ArrayList<SearchKnowledgeAnswer>())
            .setRewrittenQuery("rewrittenQuery-1572767836")
            .build();
    mockService.addResponse(expectedResponse);

    SearchKnowledgeRequest request =
        SearchKnowledgeRequest.newBuilder()
            .setParent("projects/project-2353")
            .setQuery(TextInput.newBuilder().build())
            .setConversationProfile(
                ConversationProfileName.ofProjectConversationProfileName(
                        "[PROJECT]", "[CONVERSATION_PROFILE]")
                    .toString())
            .setSessionId("sessionId607796817")
            .setConversation(
                ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                    .toString())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setEndUserMetadata(Struct.newBuilder().build())
            .setSearchConfig(SearchKnowledgeRequest.SearchConfig.newBuilder().build())
            .setExactSearch(true)
            .build();

    SearchKnowledgeResponse actualResponse = client.searchKnowledge(request);
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
  public void searchKnowledgeExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SearchKnowledgeRequest request =
          SearchKnowledgeRequest.newBuilder()
              .setParent("projects/project-2353")
              .setQuery(TextInput.newBuilder().build())
              .setConversationProfile(
                  ConversationProfileName.ofProjectConversationProfileName(
                          "[PROJECT]", "[CONVERSATION_PROFILE]")
                      .toString())
              .setSessionId("sessionId607796817")
              .setConversation(
                  ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]")
                      .toString())
              .setLatestMessage(
                  MessageName.ofProjectConversationMessageName(
                          "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                      .toString())
              .setEndUserMetadata(Struct.newBuilder().build())
              .setSearchConfig(SearchKnowledgeRequest.SearchConfig.newBuilder().build())
              .setExactSearch(true)
              .build();
      client.searchKnowledge(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateSuggestionsTest() throws Exception {
    GenerateSuggestionsResponse expectedResponse =
        GenerateSuggestionsResponse.newBuilder()
            .addAllGeneratorSuggestionAnswers(
                new ArrayList<GenerateSuggestionsResponse.GeneratorSuggestionAnswer>())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    GenerateSuggestionsResponse actualResponse = client.generateSuggestions(conversation);
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
  public void generateSuggestionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName conversation =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.generateSuggestions(conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void generateSuggestionsTest2() throws Exception {
    GenerateSuggestionsResponse expectedResponse =
        GenerateSuggestionsResponse.newBuilder()
            .addAllGeneratorSuggestionAnswers(
                new ArrayList<GenerateSuggestionsResponse.GeneratorSuggestionAnswer>())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .build();
    mockService.addResponse(expectedResponse);

    String conversation = "projects/project-5228/conversations/conversation-5228";

    GenerateSuggestionsResponse actualResponse = client.generateSuggestions(conversation);
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
  public void generateSuggestionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String conversation = "projects/project-5228/conversations/conversation-5228";
      client.generateSuggestions(conversation);
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
