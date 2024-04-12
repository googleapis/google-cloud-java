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

package com.google.cloud.discoveryengine.v1alpha;

import static com.google.cloud.discoveryengine.v1alpha.ConversationalSearchServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.discoveryengine.v1alpha.ConversationalSearchServiceClient.ListSessionsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.discoveryengine.v1alpha.stub.HttpJsonConversationalSearchServiceStub;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ConversationalSearchServiceClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ConversationalSearchServiceClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonConversationalSearchServiceStub.getMethodDescriptors(),
            ConversationalSearchServiceSettings.getDefaultEndpoint());
    ConversationalSearchServiceSettings settings =
        ConversationalSearchServiceSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ConversationalSearchServiceSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationalSearchServiceClient.create(settings);
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
  public void converseConversationTest() throws Exception {
    ConverseConversationResponse expectedResponse =
        ConverseConversationResponse.newBuilder()
            .setReply(Reply.newBuilder().build())
            .setConversation(Conversation.newBuilder().build())
            .addAllRelatedQuestions(new ArrayList<String>())
            .addAllSearchResults(new ArrayList<SearchResponse.SearchResult>())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
    TextInput query = TextInput.newBuilder().build();

    ConverseConversationResponse actualResponse = client.converseConversation(name, query);
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
  public void converseConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName name =
          ConversationName.ofProjectLocationDataStoreConversationName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
      TextInput query = TextInput.newBuilder().build();
      client.converseConversation(name, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void converseConversationTest2() throws Exception {
    ConverseConversationResponse expectedResponse =
        ConverseConversationResponse.newBuilder()
            .setReply(Reply.newBuilder().build())
            .setConversation(Conversation.newBuilder().build())
            .addAllRelatedQuestions(new ArrayList<String>())
            .addAllSearchResults(new ArrayList<SearchResponse.SearchResult>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";
    TextInput query = TextInput.newBuilder().build();

    ConverseConversationResponse actualResponse = client.converseConversation(name, query);
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
  public void converseConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";
      TextInput query = TextInput.newBuilder().build();
      client.converseConversation(name, query);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
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
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
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
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
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
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      Conversation conversation = Conversation.newBuilder().build();
      client.createConversation(parent, conversation);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");

    client.deleteConversation(name);

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
  public void deleteConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName name =
          ConversationName.ofProjectLocationDataStoreConversationName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
      client.deleteConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";

    client.deleteConversation(name);

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
  public void deleteConversationExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";
      client.deleteConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Conversation conversation =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Conversation actualResponse = client.updateConversation(conversation, updateMask);
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
  public void updateConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Conversation conversation =
          Conversation.newBuilder()
              .setName(
                  ConversationName.ofProjectLocationDataStoreConversationName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                      .toString())
              .setUserPseudoId("userPseudoId-1155274652")
              .addAllMessages(new ArrayList<ConversationMessage>())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateConversation(conversation, updateMask);
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
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");

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
          ConversationName.ofProjectLocationDataStoreConversationName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
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
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";

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
      String name =
          "projects/project-1064/locations/location-1064/dataStores/dataStore-1064/conversations/conversation-1064";
      client.getConversation(name);
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

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

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
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
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

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

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
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void answerQueryTest() throws Exception {
    AnswerQueryResponse expectedResponse =
        AnswerQueryResponse.newBuilder()
            .setAnswer(Answer.newBuilder().build())
            .setSession(Session.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AnswerQueryRequest request =
        AnswerQueryRequest.newBuilder()
            .setServingConfig(
                ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                    .toString())
            .setQuery(Query.newBuilder().build())
            .setSession(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setSafetySpec(AnswerQueryRequest.SafetySpec.newBuilder().build())
            .setRelatedQuestionsSpec(AnswerQueryRequest.RelatedQuestionsSpec.newBuilder().build())
            .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
            .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
            .setQueryUnderstandingSpec(
                AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
            .setAsynchronousMode(true)
            .setUserPseudoId("userPseudoId-1155274652")
            .build();

    AnswerQueryResponse actualResponse = client.answerQuery(request);
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
  public void answerQueryExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnswerQueryRequest request =
          AnswerQueryRequest.newBuilder()
              .setServingConfig(
                  ServingConfigName.ofProjectLocationDataStoreServingConfigName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SERVING_CONFIG]")
                      .toString())
              .setQuery(Query.newBuilder().build())
              .setSession(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setSafetySpec(AnswerQueryRequest.SafetySpec.newBuilder().build())
              .setRelatedQuestionsSpec(AnswerQueryRequest.RelatedQuestionsSpec.newBuilder().build())
              .setAnswerGenerationSpec(AnswerQueryRequest.AnswerGenerationSpec.newBuilder().build())
              .setSearchSpec(AnswerQueryRequest.SearchSpec.newBuilder().build())
              .setQueryUnderstandingSpec(
                  AnswerQueryRequest.QueryUnderstandingSpec.newBuilder().build())
              .setAsynchronousMode(true)
              .setUserPseudoId("userPseudoId-1155274652")
              .build();
      client.answerQuery(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnswerTest() throws Exception {
    Answer expectedResponse =
        Answer.newBuilder()
            .setName(
                AnswerName.ofProjectLocationDataStoreSessionAnswerName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]")
                    .toString())
            .setAnswerText("answerText959441419")
            .addAllCitations(new ArrayList<Answer.Citation>())
            .addAllReferences(new ArrayList<Answer.Reference>())
            .addAllRelatedQuestions(new ArrayList<String>())
            .addAllSteps(new ArrayList<Answer.Step>())
            .setQueryUnderstandingInfo(Answer.QueryUnderstandingInfo.newBuilder().build())
            .addAllAnswerSkippedReasons(new ArrayList<Answer.AnswerSkippedReason>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AnswerName name =
        AnswerName.ofProjectLocationDataStoreSessionAnswerName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]");

    Answer actualResponse = client.getAnswer(name);
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
  public void getAnswerExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnswerName name =
          AnswerName.ofProjectLocationDataStoreSessionAnswerName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]");
      client.getAnswer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnswerTest2() throws Exception {
    Answer expectedResponse =
        Answer.newBuilder()
            .setName(
                AnswerName.ofProjectLocationDataStoreSessionAnswerName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]", "[ANSWER]")
                    .toString())
            .setAnswerText("answerText959441419")
            .addAllCitations(new ArrayList<Answer.Citation>())
            .addAllReferences(new ArrayList<Answer.Reference>())
            .addAllRelatedQuestions(new ArrayList<String>())
            .addAllSteps(new ArrayList<Answer.Step>())
            .setQueryUnderstandingInfo(Answer.QueryUnderstandingInfo.newBuilder().build())
            .addAllAnswerSkippedReasons(new ArrayList<Answer.AnswerSkippedReason>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setCompleteTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-4748/locations/location-4748/dataStores/dataStore-4748/sessions/session-4748/answers/answer-4748";

    Answer actualResponse = client.getAnswer(name);
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
  public void getAnswerExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-4748/locations/location-4748/dataStores/dataStore-4748/sessions/session-4748/answers/answer-4748";
      client.getAnswer(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
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
  public void createSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
    Session session = Session.newBuilder().build();

    Session actualResponse = client.createSession(parent, session);
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
  public void createSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      Session session = Session.newBuilder().build();
      client.createSession(parent, session);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    SessionName name =
        SessionName.ofProjectLocationDataStoreSessionName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");

    client.deleteSession(name);

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
  public void deleteSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name =
          SessionName.ofProjectLocationDataStoreSessionName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSessionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";

    client.deleteSession(name);

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
  public void deleteSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";
      client.deleteSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Session session =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Session actualResponse = client.updateSession(session, updateMask);
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
  public void updateSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Session session =
          Session.newBuilder()
              .setName(
                  SessionName.ofProjectLocationDataStoreSessionName(
                          "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                      .toString())
              .setUserPseudoId("userPseudoId-1155274652")
              .addAllTurns(new ArrayList<Session.Turn>())
              .setStartTime(Timestamp.newBuilder().build())
              .setEndTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSession(session, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SessionName name =
        SessionName.ofProjectLocationDataStoreSessionName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SessionName name =
          SessionName.ofProjectLocationDataStoreSessionName(
              "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]");
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSessionTest2() throws Exception {
    Session expectedResponse =
        Session.newBuilder()
            .setName(
                SessionName.ofProjectLocationDataStoreSessionName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[SESSION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllTurns(new ArrayList<Session.Turn>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";

    Session actualResponse = client.getSession(name);
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
  public void getSessionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5067/locations/location-5067/dataStores/dataStore-5067/sessions/session-5067";
      client.getSession(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DataStoreName parent =
          DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSessionsTest2() throws Exception {
    Session responsesElement = Session.newBuilder().build();
    ListSessionsResponse expectedResponse =
        ListSessionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllSessions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";

    ListSessionsPagedResponse pagedListResponse = client.listSessions(parent);

    List<Session> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSessionsList().get(0), resources.get(0));

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
  public void listSessionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-3005/locations/location-3005/dataStores/dataStore-3005";
      client.listSessions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
