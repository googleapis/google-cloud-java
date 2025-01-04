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

package com.google.cloud.contactcenterinsights.v1;

import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAllFeedbackLabelsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListAnalysisRulesPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListConversationsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListFeedbackLabelsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListPhraseMatchersPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaQuestionsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaScorecardRevisionsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListQaScorecardsPagedResponse;
import static com.google.cloud.contactcenterinsights.v1.ContactCenterInsightsClient.ListViewsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.contactcenterinsights.v1.stub.HttpJsonContactCenterInsightsStub;
import com.google.common.collect.Lists;
import com.google.longrunning.Operation;
import com.google.protobuf.Any;
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
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
public class ContactCenterInsightsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ContactCenterInsightsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonContactCenterInsightsStub.getMethodDescriptors(),
            ContactCenterInsightsSettings.getDefaultEndpoint());
    ContactCenterInsightsSettings settings =
        ContactCenterInsightsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ContactCenterInsightsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContactCenterInsightsClient.create(settings);
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
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
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
      String conversationId = "conversationId-1676095234";
      client.createConversation(parent, conversation, conversationId);
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
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
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
      String parent = "projects/project-5833/locations/location-5833";
      Conversation conversation = Conversation.newBuilder().build();
      String conversationId = "conversationId-1676095234";
      client.createConversation(parent, conversation, conversationId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uploadConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("uploadConversationTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    UploadConversationRequest request =
        UploadConversationRequest.newBuilder()
            .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setConversation(Conversation.newBuilder().build())
            .setConversationId("conversationId-1676095234")
            .setRedactionConfig(RedactionConfig.newBuilder().build())
            .setSpeechConfig(SpeechConfig.newBuilder().build())
            .build();

    Conversation actualResponse = client.uploadConversationAsync(request).get();
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
  public void uploadConversationExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UploadConversationRequest request =
          UploadConversationRequest.newBuilder()
              .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setConversation(Conversation.newBuilder().build())
              .setConversationId("conversationId-1676095234")
              .setRedactionConfig(RedactionConfig.newBuilder().build())
              .setSpeechConfig(SpeechConfig.newBuilder().build())
              .build();
      client.uploadConversationAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    mockService.addResponse(expectedResponse);

    Conversation conversation =
        Conversation.newBuilder()
            .setName(
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
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
                  ConversationName.ofProjectLocationConversationName(
                          "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                      .toString())
              .setDataSource(ConversationDataSource.newBuilder().build())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setStartTime(Timestamp.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setAgentId("agentId-1060987136")
              .putAllLabels(new HashMap<String, String>())
              .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
              .setMetadataJson("metadataJson1320266935")
              .setTranscript(Conversation.Transcript.newBuilder().build())
              .setDuration(Duration.newBuilder().build())
              .setTurnCount(428155597)
              .setLatestAnalysis(Analysis.newBuilder().build())
              .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
              .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
              .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
              .setObfuscatedUserId("obfuscatedUserId971552298")
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
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

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
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
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
                ConversationName.ofProjectLocationConversationName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]")
                    .toString())
            .setDataSource(ConversationDataSource.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setStartTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setAgentId("agentId-1060987136")
            .putAllLabels(new HashMap<String, String>())
            .setQualityMetadata(Conversation.QualityMetadata.newBuilder().build())
            .setMetadataJson("metadataJson1320266935")
            .setTranscript(Conversation.Transcript.newBuilder().build())
            .setDuration(Duration.newBuilder().build())
            .setTurnCount(428155597)
            .setLatestAnalysis(Analysis.newBuilder().build())
            .setLatestSummary(ConversationSummarizationSuggestionData.newBuilder().build())
            .addAllRuntimeAnnotations(new ArrayList<RuntimeAnnotation>())
            .putAllDialogflowIntents(new HashMap<String, DialogflowIntent>())
            .setObfuscatedUserId("obfuscatedUserId971552298")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-3338/locations/location-3338/conversations/conversation-3338";

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
      String name = "projects/project-3338/locations/location-3338/conversations/conversation-3338";
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

    String parent = "projects/project-5833/locations/location-5833";

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
      String parent = "projects/project-5833/locations/location-5833";
      client.listConversations(parent);
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
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

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
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
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

    String name = "projects/project-3338/locations/location-3338/conversations/conversation-3338";

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
      String name = "projects/project-3338/locations/location-3338/conversations/conversation-3338";
      client.deleteConversation(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalysisTest() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.ofProjectLocationConversationAnalysisName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
                    .toString())
            .setRequestTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setAnalysisResult(AnalysisResult.newBuilder().build())
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    Analysis analysis = Analysis.newBuilder().build();

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis).get();
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
  public void createAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      Analysis analysis = Analysis.newBuilder().build();
      client.createAnalysisAsync(parent, analysis).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createAnalysisTest2() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.ofProjectLocationConversationAnalysisName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
                    .toString())
            .setRequestTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setAnalysisResult(AnalysisResult.newBuilder().build())
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createAnalysisTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-8053/locations/location-8053/conversations/conversation-8053";
    Analysis analysis = Analysis.newBuilder().build();

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis).get();
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
  public void createAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8053/locations/location-8053/conversations/conversation-8053";
      Analysis analysis = Analysis.newBuilder().build();
      client.createAnalysisAsync(parent, analysis).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getAnalysisTest() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.ofProjectLocationConversationAnalysisName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
                    .toString())
            .setRequestTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setAnalysisResult(AnalysisResult.newBuilder().build())
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    AnalysisName name =
        AnalysisName.ofProjectLocationConversationAnalysisName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");

    Analysis actualResponse = client.getAnalysis(name);
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
  public void getAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisName name =
          AnalysisName.ofProjectLocationConversationAnalysisName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
      client.getAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalysisTest2() throws Exception {
    Analysis expectedResponse =
        Analysis.newBuilder()
            .setName(
                AnalysisName.ofProjectLocationConversationAnalysisName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]")
                    .toString())
            .setRequestTime(Timestamp.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setAnalysisResult(AnalysisResult.newBuilder().build())
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3940/locations/location-3940/conversations/conversation-3940/analyses/analyse-3940";

    Analysis actualResponse = client.getAnalysis(name);
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
  public void getAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3940/locations/location-3940/conversations/conversation-3940/analyses/analyse-3940";
      client.getAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalysesTest() throws Exception {
    Analysis responsesElement = Analysis.newBuilder().build();
    ListAnalysesResponse expectedResponse =
        ListAnalysesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

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
  public void listAnalysesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      client.listAnalyses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalysesTest2() throws Exception {
    Analysis responsesElement = Analysis.newBuilder().build();
    ListAnalysesResponse expectedResponse =
        ListAnalysesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalyses(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8053/locations/location-8053/conversations/conversation-8053";

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

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
  public void listAnalysesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8053/locations/location-8053/conversations/conversation-8053";
      client.listAnalyses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalysisTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AnalysisName name =
        AnalysisName.ofProjectLocationConversationAnalysisName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");

    client.deleteAnalysis(name);

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
  public void deleteAnalysisExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisName name =
          AnalysisName.ofProjectLocationConversationAnalysisName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");
      client.deleteAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalysisTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-3940/locations/location-3940/conversations/conversation-3940/analyses/analyse-3940";

    client.deleteAnalysis(name);

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
  public void deleteAnalysisExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-3940/locations/location-3940/conversations/conversation-3940/analyses/analyse-3940";
      client.deleteAnalysis(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkAnalyzeConversationsTest() throws Exception {
    BulkAnalyzeConversationsResponse expectedResponse =
        BulkAnalyzeConversationsResponse.newBuilder()
            .setSuccessfulAnalysisCount(1153322545)
            .setFailedAnalysisCount(1044285998)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkAnalyzeConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String filter = "filter-1274492040";
    float analysisPercentage = 1609757661;

    BulkAnalyzeConversationsResponse actualResponse =
        client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
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
  public void bulkAnalyzeConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String filter = "filter-1274492040";
      float analysisPercentage = 1609757661;
      client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkAnalyzeConversationsTest2() throws Exception {
    BulkAnalyzeConversationsResponse expectedResponse =
        BulkAnalyzeConversationsResponse.newBuilder()
            .setSuccessfulAnalysisCount(1153322545)
            .setFailedAnalysisCount(1044285998)
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkAnalyzeConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String filter = "filter-1274492040";
    float analysisPercentage = 1609757661;

    BulkAnalyzeConversationsResponse actualResponse =
        client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
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
  public void bulkAnalyzeConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String filter = "filter-1274492040";
      float analysisPercentage = 1609757661;
      client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDeleteConversationsTest() throws Exception {
    BulkDeleteConversationsResponse expectedResponse =
        BulkDeleteConversationsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDeleteConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String filter = "filter-1274492040";

    BulkDeleteConversationsResponse actualResponse =
        client.bulkDeleteConversationsAsync(parent, filter).get();
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
  public void bulkDeleteConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String filter = "filter-1274492040";
      client.bulkDeleteConversationsAsync(parent, filter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDeleteConversationsTest2() throws Exception {
    BulkDeleteConversationsResponse expectedResponse =
        BulkDeleteConversationsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDeleteConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    String filter = "filter-1274492040";

    BulkDeleteConversationsResponse actualResponse =
        client.bulkDeleteConversationsAsync(parent, filter).get();
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
  public void bulkDeleteConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      String filter = "filter-1274492040";
      client.bulkDeleteConversationsAsync(parent, filter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void ingestConversationsTest() throws Exception {
    IngestConversationsResponse expectedResponse = IngestConversationsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("ingestConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    IngestConversationsResponse actualResponse = client.ingestConversationsAsync(parent).get();
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
  public void ingestConversationsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.ingestConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void ingestConversationsTest2() throws Exception {
    IngestConversationsResponse expectedResponse = IngestConversationsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("ingestConversationsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";

    IngestConversationsResponse actualResponse = client.ingestConversationsAsync(parent).get();
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
  public void ingestConversationsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.ingestConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportInsightsDataTest() throws Exception {
    ExportInsightsDataResponse expectedResponse = ExportInsightsDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportInsightsDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ExportInsightsDataResponse actualResponse = client.exportInsightsDataAsync(parent).get();
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
  public void exportInsightsDataExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.exportInsightsDataAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportInsightsDataTest2() throws Exception {
    ExportInsightsDataResponse expectedResponse = ExportInsightsDataResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportInsightsDataTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";

    ExportInsightsDataResponse actualResponse = client.exportInsightsDataAsync(parent).get();
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
  public void exportInsightsDataExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.exportInsightsDataAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIssueModelTest() throws Exception {
    IssueModel expectedResponse =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IssueModel issueModel = IssueModel.newBuilder().build();

    IssueModel actualResponse = client.createIssueModelAsync(parent, issueModel).get();
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
  public void createIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IssueModel issueModel = IssueModel.newBuilder().build();
      client.createIssueModelAsync(parent, issueModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createIssueModelTest2() throws Exception {
    IssueModel expectedResponse =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("createIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";
    IssueModel issueModel = IssueModel.newBuilder().build();

    IssueModel actualResponse = client.createIssueModelAsync(parent, issueModel).get();
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
  public void createIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      IssueModel issueModel = IssueModel.newBuilder().build();
      client.createIssueModelAsync(parent, issueModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void updateIssueModelTest() throws Exception {
    IssueModel expectedResponse =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    IssueModel issueModel =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IssueModel actualResponse = client.updateIssueModel(issueModel, updateMask);
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
  public void updateIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModel issueModel =
          IssueModel.newBuilder()
              .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setIssueCount(1779144233)
              .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
              .setTrainingStats(IssueModelLabelStats.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIssueModel(issueModel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIssueModelTest() throws Exception {
    IssueModel expectedResponse =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    IssueModel actualResponse = client.getIssueModel(name);
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
  public void getIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.getIssueModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIssueModelTest2() throws Exception {
    IssueModel expectedResponse =
        IssueModel.newBuilder()
            .setName(IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setIssueCount(1779144233)
            .setInputDataConfig(IssueModel.InputDataConfig.newBuilder().build())
            .setTrainingStats(IssueModelLabelStats.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";

    IssueModel actualResponse = client.getIssueModel(name);
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
  public void getIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";
      client.getIssueModel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssueModelsTest() throws Exception {
    ListIssueModelsResponse expectedResponse =
        ListIssueModelsResponse.newBuilder().addAllIssueModels(new ArrayList<IssueModel>()).build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIssueModelsResponse actualResponse = client.listIssueModels(parent);
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
  public void listIssueModelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listIssueModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssueModelsTest2() throws Exception {
    ListIssueModelsResponse expectedResponse =
        ListIssueModelsResponse.newBuilder().addAllIssueModels(new ArrayList<IssueModel>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListIssueModelsResponse actualResponse = client.listIssueModels(parent);
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
  public void listIssueModelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listIssueModels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIssueModelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    client.deleteIssueModelAsync(name).get();

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
  public void deleteIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.deleteIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deleteIssueModelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deleteIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";

    client.deleteIssueModelAsync(name).get();

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
  public void deleteIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";
      client.deleteIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployIssueModelTest() throws Exception {
    DeployIssueModelResponse expectedResponse = DeployIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    DeployIssueModelResponse actualResponse = client.deployIssueModelAsync(name).get();
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
  public void deployIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.deployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployIssueModelTest2() throws Exception {
    DeployIssueModelResponse expectedResponse = DeployIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("deployIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";

    DeployIssueModelResponse actualResponse = client.deployIssueModelAsync(name).get();
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
  public void deployIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";
      client.deployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeployIssueModelTest() throws Exception {
    UndeployIssueModelResponse expectedResponse = UndeployIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    UndeployIssueModelResponse actualResponse = client.undeployIssueModelAsync(name).get();
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
  public void undeployIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.undeployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void undeployIssueModelTest2() throws Exception {
    UndeployIssueModelResponse expectedResponse = UndeployIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("undeployIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";

    UndeployIssueModelResponse actualResponse = client.undeployIssueModelAsync(name).get();
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
  public void undeployIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";
      client.undeployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportIssueModelTest() throws Exception {
    ExportIssueModelResponse expectedResponse = ExportIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    ExportIssueModelResponse actualResponse = client.exportIssueModelAsync(name).get();
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
  public void exportIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.exportIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void exportIssueModelTest2() throws Exception {
    ExportIssueModelResponse expectedResponse = ExportIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("exportIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";

    ExportIssueModelResponse actualResponse = client.exportIssueModelAsync(name).get();
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
  public void exportIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-9415/locations/location-9415/issueModels/issueModel-9415";
      client.exportIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importIssueModelTest() throws Exception {
    ImportIssueModelResponse expectedResponse = ImportIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ImportIssueModelResponse actualResponse = client.importIssueModelAsync(parent).get();
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
  public void importIssueModelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.importIssueModelAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void importIssueModelTest2() throws Exception {
    ImportIssueModelResponse expectedResponse = ImportIssueModelResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("importIssueModelTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";

    ImportIssueModelResponse actualResponse = client.importIssueModelAsync(parent).get();
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
  public void importIssueModelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.importIssueModelAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void getIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSampleUtterances(new ArrayList<String>())
            .setDisplayDescription("displayDescription-872782374")
            .build();
    mockService.addResponse(expectedResponse);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");

    Issue actualResponse = client.getIssue(name);
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
  public void getIssueExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");
      client.getIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getIssueTest2() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSampleUtterances(new ArrayList<String>())
            .setDisplayDescription("displayDescription-872782374")
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9867/locations/location-9867/issueModels/issueModel-9867/issues/issue-9867";

    Issue actualResponse = client.getIssue(name);
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
  public void getIssueExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9867/locations/location-9867/issueModels/issueModel-9867/issues/issue-9867";
      client.getIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssuesTest() throws Exception {
    ListIssuesResponse expectedResponse =
        ListIssuesResponse.newBuilder().addAllIssues(new ArrayList<Issue>()).build();
    mockService.addResponse(expectedResponse);

    IssueModelName parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    ListIssuesResponse actualResponse = client.listIssues(parent);
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
  public void listIssuesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.listIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listIssuesTest2() throws Exception {
    ListIssuesResponse expectedResponse =
        ListIssuesResponse.newBuilder().addAllIssues(new ArrayList<Issue>()).build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-7032/locations/location-7032/issueModels/issueModel-7032";

    ListIssuesResponse actualResponse = client.listIssues(parent);
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
  public void listIssuesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-7032/locations/location-7032/issueModels/issueModel-7032";
      client.listIssues(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateIssueTest() throws Exception {
    Issue expectedResponse =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSampleUtterances(new ArrayList<String>())
            .setDisplayDescription("displayDescription-872782374")
            .build();
    mockService.addResponse(expectedResponse);

    Issue issue =
        Issue.newBuilder()
            .setName(IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSampleUtterances(new ArrayList<String>())
            .setDisplayDescription("displayDescription-872782374")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Issue actualResponse = client.updateIssue(issue, updateMask);
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
  public void updateIssueExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Issue issue =
          Issue.newBuilder()
              .setName(
                  IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .addAllSampleUtterances(new ArrayList<String>())
              .setDisplayDescription("displayDescription-872782374")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateIssue(issue, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIssueTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");

    client.deleteIssue(name);

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
  public void deleteIssueExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");
      client.deleteIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteIssueTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-9867/locations/location-9867/issueModels/issueModel-9867/issues/issue-9867";

    client.deleteIssue(name);

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
  public void deleteIssueExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-9867/locations/location-9867/issueModels/issueModel-9867/issues/issue-9867";
      client.deleteIssue(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateIssueModelStatsTest() throws Exception {
    CalculateIssueModelStatsResponse expectedResponse =
        CalculateIssueModelStatsResponse.newBuilder()
            .setCurrentStats(IssueModelLabelStats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    IssueModelName issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    CalculateIssueModelStatsResponse actualResponse = client.calculateIssueModelStats(issueModel);
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
  public void calculateIssueModelStatsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      IssueModelName issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.calculateIssueModelStats(issueModel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateIssueModelStatsTest2() throws Exception {
    CalculateIssueModelStatsResponse expectedResponse =
        CalculateIssueModelStatsResponse.newBuilder()
            .setCurrentStats(IssueModelLabelStats.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String issueModel = "projects/project-2174/locations/location-2174/issueModels/issueModel-2174";

    CalculateIssueModelStatsResponse actualResponse = client.calculateIssueModelStats(issueModel);
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
  public void calculateIssueModelStatsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String issueModel =
          "projects/project-2174/locations/location-2174/issueModels/issueModel-2174";
      client.calculateIssueModelStats(issueModel);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPhraseMatcherTest() throws Exception {
    PhraseMatcher expectedResponse =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();

    PhraseMatcher actualResponse = client.createPhraseMatcher(parent, phraseMatcher);
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
  public void createPhraseMatcherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
      client.createPhraseMatcher(parent, phraseMatcher);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createPhraseMatcherTest2() throws Exception {
    PhraseMatcher expectedResponse =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();

    PhraseMatcher actualResponse = client.createPhraseMatcher(parent, phraseMatcher);
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
  public void createPhraseMatcherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
      client.createPhraseMatcher(parent, phraseMatcher);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseMatcherTest() throws Exception {
    PhraseMatcher expectedResponse =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");

    PhraseMatcher actualResponse = client.getPhraseMatcher(name);
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
  public void getPhraseMatcherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
      client.getPhraseMatcher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getPhraseMatcherTest2() throws Exception {
    PhraseMatcher expectedResponse =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8010/locations/location-8010/phraseMatchers/phraseMatcher-8010";

    PhraseMatcher actualResponse = client.getPhraseMatcher(name);
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
  public void getPhraseMatcherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8010/locations/location-8010/phraseMatchers/phraseMatcher-8010";
      client.getPhraseMatcher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhraseMatchersTest() throws Exception {
    PhraseMatcher responsesElement = PhraseMatcher.newBuilder().build();
    ListPhraseMatchersResponse expectedResponse =
        ListPhraseMatchersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseMatchers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhraseMatchersPagedResponse pagedListResponse = client.listPhraseMatchers(parent);

    List<PhraseMatcher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseMatchersList().get(0), resources.get(0));

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
  public void listPhraseMatchersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listPhraseMatchers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listPhraseMatchersTest2() throws Exception {
    PhraseMatcher responsesElement = PhraseMatcher.newBuilder().build();
    ListPhraseMatchersResponse expectedResponse =
        ListPhraseMatchersResponse.newBuilder()
            .setNextPageToken("")
            .addAllPhraseMatchers(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListPhraseMatchersPagedResponse pagedListResponse = client.listPhraseMatchers(parent);

    List<PhraseMatcher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseMatchersList().get(0), resources.get(0));

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
  public void listPhraseMatchersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listPhraseMatchers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhraseMatcherTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");

    client.deletePhraseMatcher(name);

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
  public void deletePhraseMatcherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");
      client.deletePhraseMatcher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhraseMatcherTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-8010/locations/location-8010/phraseMatchers/phraseMatcher-8010";

    client.deletePhraseMatcher(name);

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
  public void deletePhraseMatcherExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-8010/locations/location-8010/phraseMatchers/phraseMatcher-8010";
      client.deletePhraseMatcher(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updatePhraseMatcherTest() throws Exception {
    PhraseMatcher expectedResponse =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    PhraseMatcher phraseMatcher =
        PhraseMatcher.newBuilder()
            .setName(PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
            .setRevisionId("revisionId-1507445162")
            .setVersionTag("versionTag-670508126")
            .setRevisionCreateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setActive(true)
            .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
            .setActivationUpdateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhraseMatcher actualResponse = client.updatePhraseMatcher(phraseMatcher, updateMask);
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
  public void updatePhraseMatcherExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      PhraseMatcher phraseMatcher =
          PhraseMatcher.newBuilder()
              .setName(
                  PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]").toString())
              .setRevisionId("revisionId-1507445162")
              .setVersionTag("versionTag-670508126")
              .setRevisionCreateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setActive(true)
              .addAllPhraseMatchRuleGroups(new ArrayList<PhraseMatchRuleGroup>())
              .setActivationUpdateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updatePhraseMatcher(phraseMatcher, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateStatsTest() throws Exception {
    CalculateStatsResponse expectedResponse =
        CalculateStatsResponse.newBuilder()
            .setAverageDuration(Duration.newBuilder().build())
            .setAverageTurnCount(-1693477329)
            .setConversationCount(1994187347)
            .putAllSmartHighlighterMatches(new HashMap<String, Integer>())
            .putAllCustomHighlighterMatches(new HashMap<String, Integer>())
            .putAllIssueMatches(new HashMap<String, Integer>())
            .putAllIssueMatchesStats(new HashMap<String, IssueModelLabelStats.IssueStats>())
            .setConversationCountTimeSeries(CalculateStatsResponse.TimeSeries.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");

    CalculateStatsResponse actualResponse = client.calculateStats(location);
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
  public void calculateStatsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");
      client.calculateStats(location);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void calculateStatsTest2() throws Exception {
    CalculateStatsResponse expectedResponse =
        CalculateStatsResponse.newBuilder()
            .setAverageDuration(Duration.newBuilder().build())
            .setAverageTurnCount(-1693477329)
            .setConversationCount(1994187347)
            .putAllSmartHighlighterMatches(new HashMap<String, Integer>())
            .putAllCustomHighlighterMatches(new HashMap<String, Integer>())
            .putAllIssueMatches(new HashMap<String, Integer>())
            .putAllIssueMatchesStats(new HashMap<String, IssueModelLabelStats.IssueStats>())
            .setConversationCountTimeSeries(CalculateStatsResponse.TimeSeries.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String location = "projects/project-7132/locations/location-7132";

    CalculateStatsResponse actualResponse = client.calculateStats(location);
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
  public void calculateStatsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String location = "projects/project-7132/locations/location-7132";
      client.calculateStats(location);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setConversationTtl(Duration.newBuilder().build())
            .putAllPubsubNotificationSettings(new HashMap<String, String>())
            .setAnalysisConfig(Settings.AnalysisConfig.newBuilder().build())
            .setRedactionConfig(RedactionConfig.newBuilder().build())
            .setSpeechConfig(SpeechConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSettingsTest2() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setConversationTtl(Duration.newBuilder().build())
            .putAllPubsubNotificationSettings(new HashMap<String, String>())
            .setAnalysisConfig(Settings.AnalysisConfig.newBuilder().build())
            .setRedactionConfig(RedactionConfig.newBuilder().build())
            .setSpeechConfig(SpeechConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7640/locations/location-7640/settings";

    Settings actualResponse = client.getSettings(name);
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
  public void getSettingsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7640/locations/location-7640/settings";
      client.getSettings(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSettingsTest() throws Exception {
    Settings expectedResponse =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setConversationTtl(Duration.newBuilder().build())
            .putAllPubsubNotificationSettings(new HashMap<String, String>())
            .setAnalysisConfig(Settings.AnalysisConfig.newBuilder().build())
            .setRedactionConfig(RedactionConfig.newBuilder().build())
            .setSpeechConfig(SpeechConfig.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    Settings settings =
        Settings.newBuilder()
            .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setLanguageCode("languageCode-2092349083")
            .setConversationTtl(Duration.newBuilder().build())
            .putAllPubsubNotificationSettings(new HashMap<String, String>())
            .setAnalysisConfig(Settings.AnalysisConfig.newBuilder().build())
            .setRedactionConfig(RedactionConfig.newBuilder().build())
            .setSpeechConfig(SpeechConfig.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
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
  public void updateSettingsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Settings settings =
          Settings.newBuilder()
              .setName(SettingsName.of("[PROJECT]", "[LOCATION]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setLanguageCode("languageCode-2092349083")
              .setConversationTtl(Duration.newBuilder().build())
              .putAllPubsubNotificationSettings(new HashMap<String, String>())
              .setAnalysisConfig(Settings.AnalysisConfig.newBuilder().build())
              .setRedactionConfig(RedactionConfig.newBuilder().build())
              .setSpeechConfig(SpeechConfig.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSettings(settings, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalysisRuleTest() throws Exception {
    AnalysisRule expectedResponse =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AnalysisRule analysisRule = AnalysisRule.newBuilder().build();

    AnalysisRule actualResponse = client.createAnalysisRule(parent, analysisRule);
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
  public void createAnalysisRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
      client.createAnalysisRule(parent, analysisRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createAnalysisRuleTest2() throws Exception {
    AnalysisRule expectedResponse =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    AnalysisRule analysisRule = AnalysisRule.newBuilder().build();

    AnalysisRule actualResponse = client.createAnalysisRule(parent, analysisRule);
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
  public void createAnalysisRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
      client.createAnalysisRule(parent, analysisRule);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalysisRuleTest() throws Exception {
    AnalysisRule expectedResponse =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    mockService.addResponse(expectedResponse);

    AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");

    AnalysisRule actualResponse = client.getAnalysisRule(name);
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
  public void getAnalysisRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");
      client.getAnalysisRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAnalysisRuleTest2() throws Exception {
    AnalysisRule expectedResponse =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1295/locations/location-1295/analysisRules/analysisRule-1295";

    AnalysisRule actualResponse = client.getAnalysisRule(name);
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
  public void getAnalysisRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1295/locations/location-1295/analysisRules/analysisRule-1295";
      client.getAnalysisRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalysisRulesTest() throws Exception {
    AnalysisRule responsesElement = AnalysisRule.newBuilder().build();
    ListAnalysisRulesResponse expectedResponse =
        ListAnalysisRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalysisRules(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAnalysisRulesPagedResponse pagedListResponse = client.listAnalysisRules(parent);

    List<AnalysisRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysisRulesList().get(0), resources.get(0));

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
  public void listAnalysisRulesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAnalysisRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAnalysisRulesTest2() throws Exception {
    AnalysisRule responsesElement = AnalysisRule.newBuilder().build();
    ListAnalysisRulesResponse expectedResponse =
        ListAnalysisRulesResponse.newBuilder()
            .setNextPageToken("")
            .addAllAnalysisRules(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAnalysisRulesPagedResponse pagedListResponse = client.listAnalysisRules(parent);

    List<AnalysisRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysisRulesList().get(0), resources.get(0));

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
  public void listAnalysisRulesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAnalysisRules(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateAnalysisRuleTest() throws Exception {
    AnalysisRule expectedResponse =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    mockService.addResponse(expectedResponse);

    AnalysisRule analysisRule =
        AnalysisRule.newBuilder()
            .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setDisplayName("displayName1714148973")
            .setConversationFilter("conversationFilter1283909083")
            .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
            .setAnalysisPercentage(1609757661)
            .setActive(true)
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AnalysisRule actualResponse = client.updateAnalysisRule(analysisRule, updateMask);
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
  public void updateAnalysisRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisRule analysisRule =
          AnalysisRule.newBuilder()
              .setName(AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]").toString())
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setDisplayName("displayName1714148973")
              .setConversationFilter("conversationFilter1283909083")
              .setAnnotatorSelector(AnnotatorSelector.newBuilder().build())
              .setAnalysisPercentage(1609757661)
              .setActive(true)
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateAnalysisRule(analysisRule, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalysisRuleTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");

    client.deleteAnalysisRule(name);

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
  public void deleteAnalysisRuleExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");
      client.deleteAnalysisRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalysisRuleTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-1295/locations/location-1295/analysisRules/analysisRule-1295";

    client.deleteAnalysisRule(name);

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
  public void deleteAnalysisRuleExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-1295/locations/location-1295/analysisRules/analysisRule-1295";
      client.deleteAnalysisRule(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEncryptionSpecTest() throws Exception {
    EncryptionSpec expectedResponse =
        EncryptionSpec.newBuilder()
            .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");

    EncryptionSpec actualResponse = client.getEncryptionSpec(name);
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
  public void getEncryptionSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");
      client.getEncryptionSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getEncryptionSpecTest2() throws Exception {
    EncryptionSpec expectedResponse =
        EncryptionSpec.newBuilder()
            .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2979/locations/location-2979/encryptionSpec";

    EncryptionSpec actualResponse = client.getEncryptionSpec(name);
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
  public void getEncryptionSpecExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2979/locations/location-2979/encryptionSpec";
      client.getEncryptionSpec(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void initializeEncryptionSpecTest() throws Exception {
    InitializeEncryptionSpecResponse expectedResponse =
        InitializeEncryptionSpecResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("initializeEncryptionSpecTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    EncryptionSpec encryptionSpec =
        EncryptionSpec.newBuilder()
            .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
            .setKmsKey("kmsKey-1127483058")
            .build();

    InitializeEncryptionSpecResponse actualResponse =
        client.initializeEncryptionSpecAsync(encryptionSpec).get();
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
  public void initializeEncryptionSpecExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      EncryptionSpec encryptionSpec =
          EncryptionSpec.newBuilder()
              .setName(EncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
              .setKmsKey("kmsKey-1127483058")
              .build();
      client.initializeEncryptionSpecAsync(encryptionSpec).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createViewTest() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    View view = View.newBuilder().build();

    View actualResponse = client.createView(parent, view);
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
  public void createViewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      View view = View.newBuilder().build();
      client.createView(parent, view);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createViewTest2() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    View view = View.newBuilder().build();

    View actualResponse = client.createView(parent, view);
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
  public void createViewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      View view = View.newBuilder().build();
      client.createView(parent, view);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewTest() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    mockService.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");

    View actualResponse = client.getView(name);
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
  public void getViewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
      client.getView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getViewTest2() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2284/locations/location-2284/views/view-2284";

    View actualResponse = client.getView(name);
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
  public void getViewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2284/locations/location-2284/views/view-2284";
      client.getView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewsTest() throws Exception {
    View responsesElement = View.newBuilder().build();
    ListViewsResponse expectedResponse =
        ListViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViews(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

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
  public void listViewsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listViewsTest2() throws Exception {
    View responsesElement = View.newBuilder().build();
    ListViewsResponse expectedResponse =
        ListViewsResponse.newBuilder()
            .setNextPageToken("")
            .addAllViews(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

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
  public void listViewsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listViews(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateViewTest() throws Exception {
    View expectedResponse =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    mockService.addResponse(expectedResponse);

    View view =
        View.newBuilder()
            .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
            .setDisplayName("displayName1714148973")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setValue("value111972721")
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    View actualResponse = client.updateView(view, updateMask);
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
  public void updateViewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      View view =
          View.newBuilder()
              .setName(ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]").toString())
              .setDisplayName("displayName1714148973")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setValue("value111972721")
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateView(view, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteViewTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");

    client.deleteView(name);

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
  public void deleteViewExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");
      client.deleteView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteViewTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-2284/locations/location-2284/views/view-2284";

    client.deleteView(name);

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
  public void deleteViewExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-2284/locations/location-2284/views/view-2284";
      client.deleteView(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void queryMetricsTest() throws Exception {
    QueryMetricsResponse expectedResponse =
        QueryMetricsResponse.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setUpdateTime(Timestamp.newBuilder().build())
            .addAllSlices(new ArrayList<QueryMetricsResponse.Slice>())
            .setMacroAverageSlice(QueryMetricsResponse.Slice.newBuilder().build())
            .build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("queryMetricsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    QueryMetricsRequest request =
        QueryMetricsRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setFilter("filter-1274492040")
            .addAllDimensions(new ArrayList<Dimension>())
            .setMeasureMask(FieldMask.newBuilder().build())
            .build();

    QueryMetricsResponse actualResponse = client.queryMetricsAsync(request).get();
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
  public void queryMetricsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QueryMetricsRequest request =
          QueryMetricsRequest.newBuilder()
              .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
              .setFilter("filter-1274492040")
              .addAllDimensions(new ArrayList<Dimension>())
              .setMeasureMask(FieldMask.newBuilder().build())
              .build();
      client.queryMetricsAsync(request).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void createQaQuestionTest() throws Exception {
    QaQuestion expectedResponse =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
    QaQuestion qaQuestion = QaQuestion.newBuilder().build();
    String qaQuestionId = "qaQuestionId1774614993";

    QaQuestion actualResponse = client.createQaQuestion(parent, qaQuestion, qaQuestionId);
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
  public void createQaQuestionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardRevisionName parent =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      QaQuestion qaQuestion = QaQuestion.newBuilder().build();
      String qaQuestionId = "qaQuestionId1774614993";
      client.createQaQuestion(parent, qaQuestion, qaQuestionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQaQuestionTest2() throws Exception {
    QaQuestion expectedResponse =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";
    QaQuestion qaQuestion = QaQuestion.newBuilder().build();
    String qaQuestionId = "qaQuestionId1774614993";

    QaQuestion actualResponse = client.createQaQuestion(parent, qaQuestion, qaQuestionId);
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
  public void createQaQuestionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";
      QaQuestion qaQuestion = QaQuestion.newBuilder().build();
      String qaQuestionId = "qaQuestionId1774614993";
      client.createQaQuestion(parent, qaQuestion, qaQuestionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaQuestionTest() throws Exception {
    QaQuestion expectedResponse =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    QaQuestionName name =
        QaQuestionName.of(
            "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");

    QaQuestion actualResponse = client.getQaQuestion(name);
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
  public void getQaQuestionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaQuestionName name =
          QaQuestionName.of(
              "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");
      client.getQaQuestion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaQuestionTest2() throws Exception {
    QaQuestion expectedResponse =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5730/locations/location-5730/qaScorecards/qaScorecard-5730/revisions/revision-5730/qaQuestions/qaQuestion-5730";

    QaQuestion actualResponse = client.getQaQuestion(name);
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
  public void getQaQuestionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5730/locations/location-5730/qaScorecards/qaScorecard-5730/revisions/revision-5730/qaQuestions/qaQuestion-5730";
      client.getQaQuestion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQaQuestionTest() throws Exception {
    QaQuestion expectedResponse =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    QaQuestion qaQuestion =
        QaQuestion.newBuilder()
            .setName(
                QaQuestionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]")
                    .toString())
            .setAbbreviation("abbreviation-1960645810")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .setQuestionBody("questionBody-172652888")
            .setAnswerInstructions("answerInstructions-946697085")
            .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
            .addAllTags(new ArrayList<String>())
            .setOrder(106006350)
            .setMetrics(QaQuestion.Metrics.newBuilder().build())
            .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QaQuestion actualResponse = client.updateQaQuestion(qaQuestion, updateMask);
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
  public void updateQaQuestionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaQuestion qaQuestion =
          QaQuestion.newBuilder()
              .setName(
                  QaQuestionName.of(
                          "[PROJECT]",
                          "[LOCATION]",
                          "[QA_SCORECARD]",
                          "[REVISION]",
                          "[QA_QUESTION]")
                      .toString())
              .setAbbreviation("abbreviation-1960645810")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .setQuestionBody("questionBody-172652888")
              .setAnswerInstructions("answerInstructions-946697085")
              .addAllAnswerChoices(new ArrayList<QaQuestion.AnswerChoice>())
              .addAllTags(new ArrayList<String>())
              .setOrder(106006350)
              .setMetrics(QaQuestion.Metrics.newBuilder().build())
              .setTuningMetadata(QaQuestion.TuningMetadata.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQaQuestion(qaQuestion, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaQuestionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    QaQuestionName name =
        QaQuestionName.of(
            "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");

    client.deleteQaQuestion(name);

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
  public void deleteQaQuestionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaQuestionName name =
          QaQuestionName.of(
              "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");
      client.deleteQaQuestion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaQuestionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5730/locations/location-5730/qaScorecards/qaScorecard-5730/revisions/revision-5730/qaQuestions/qaQuestion-5730";

    client.deleteQaQuestion(name);

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
  public void deleteQaQuestionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5730/locations/location-5730/qaScorecards/qaScorecard-5730/revisions/revision-5730/qaQuestions/qaQuestion-5730";
      client.deleteQaQuestion(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaQuestionsTest() throws Exception {
    QaQuestion responsesElement = QaQuestion.newBuilder().build();
    ListQaQuestionsResponse expectedResponse =
        ListQaQuestionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaQuestions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    ListQaQuestionsPagedResponse pagedListResponse = client.listQaQuestions(parent);

    List<QaQuestion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaQuestionsList().get(0), resources.get(0));

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
  public void listQaQuestionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardRevisionName parent =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      client.listQaQuestions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaQuestionsTest2() throws Exception {
    QaQuestion responsesElement = QaQuestion.newBuilder().build();
    ListQaQuestionsResponse expectedResponse =
        ListQaQuestionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaQuestions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";

    ListQaQuestionsPagedResponse pagedListResponse = client.listQaQuestions(parent);

    List<QaQuestion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaQuestionsList().get(0), resources.get(0));

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
  public void listQaQuestionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";
      client.listQaQuestions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQaScorecardTest() throws Exception {
    QaScorecard expectedResponse =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    QaScorecard qaScorecard = QaScorecard.newBuilder().build();
    String qaScorecardId = "qaScorecardId167098669";

    QaScorecard actualResponse = client.createQaScorecard(parent, qaScorecard, qaScorecardId);
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
  public void createQaScorecardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      QaScorecard qaScorecard = QaScorecard.newBuilder().build();
      String qaScorecardId = "qaScorecardId167098669";
      client.createQaScorecard(parent, qaScorecard, qaScorecardId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQaScorecardTest2() throws Exception {
    QaScorecard expectedResponse =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";
    QaScorecard qaScorecard = QaScorecard.newBuilder().build();
    String qaScorecardId = "qaScorecardId167098669";

    QaScorecard actualResponse = client.createQaScorecard(parent, qaScorecard, qaScorecardId);
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
  public void createQaScorecardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      QaScorecard qaScorecard = QaScorecard.newBuilder().build();
      String qaScorecardId = "qaScorecardId167098669";
      client.createQaScorecard(parent, qaScorecard, qaScorecardId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaScorecardTest() throws Exception {
    QaScorecard expectedResponse =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    QaScorecard actualResponse = client.getQaScorecard(name);
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
  public void getQaScorecardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
      client.getQaScorecard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaScorecardTest2() throws Exception {
    QaScorecard expectedResponse =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7375/locations/location-7375/qaScorecards/qaScorecard-7375";

    QaScorecard actualResponse = client.getQaScorecard(name);
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
  public void getQaScorecardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7375/locations/location-7375/qaScorecards/qaScorecard-7375";
      client.getQaScorecard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateQaScorecardTest() throws Exception {
    QaScorecard expectedResponse =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecard qaScorecard =
        QaScorecard.newBuilder()
            .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
            .setDisplayName("displayName1714148973")
            .setDescription("description-1724546052")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QaScorecard actualResponse = client.updateQaScorecard(qaScorecard, updateMask);
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
  public void updateQaScorecardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecard qaScorecard =
          QaScorecard.newBuilder()
              .setName(QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]").toString())
              .setDisplayName("displayName1714148973")
              .setDescription("description-1724546052")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateQaScorecard(qaScorecard, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaScorecardTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    client.deleteQaScorecard(name);

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
  public void deleteQaScorecardExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
      client.deleteQaScorecard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaScorecardTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name = "projects/project-7375/locations/location-7375/qaScorecards/qaScorecard-7375";

    client.deleteQaScorecard(name);

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
  public void deleteQaScorecardExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name = "projects/project-7375/locations/location-7375/qaScorecards/qaScorecard-7375";
      client.deleteQaScorecard(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaScorecardsTest() throws Exception {
    QaScorecard responsesElement = QaScorecard.newBuilder().build();
    ListQaScorecardsResponse expectedResponse =
        ListQaScorecardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaScorecards(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListQaScorecardsPagedResponse pagedListResponse = client.listQaScorecards(parent);

    List<QaScorecard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardsList().get(0), resources.get(0));

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
  public void listQaScorecardsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listQaScorecards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaScorecardsTest2() throws Exception {
    QaScorecard responsesElement = QaScorecard.newBuilder().build();
    ListQaScorecardsResponse expectedResponse =
        ListQaScorecardsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaScorecards(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListQaScorecardsPagedResponse pagedListResponse = client.listQaScorecards(parent);

    List<QaScorecard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardsList().get(0), resources.get(0));

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
  public void listQaScorecardsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listQaScorecards(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQaScorecardRevisionTest() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
    QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
    String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";

    QaScorecardRevision actualResponse =
        client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
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
  public void createQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
      QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
      String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";
      client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createQaScorecardRevisionTest2() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1550/locations/location-1550/qaScorecards/qaScorecard-1550";
    QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
    String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";

    QaScorecardRevision actualResponse =
        client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
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
  public void createQaScorecardRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1550/locations/location-1550/qaScorecards/qaScorecard-1550";
      QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
      String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";
      client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaScorecardRevisionTest() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardRevisionName name =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    QaScorecardRevision actualResponse = client.getQaScorecardRevision(name);
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
  public void getQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardRevisionName name =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      client.getQaScorecardRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getQaScorecardRevisionTest2() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7899/locations/location-7899/qaScorecards/qaScorecard-7899/revisions/revision-7899";

    QaScorecardRevision actualResponse = client.getQaScorecardRevision(name);
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
  public void getQaScorecardRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7899/locations/location-7899/qaScorecards/qaScorecard-7899/revisions/revision-7899";
      client.getQaScorecardRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void tuneQaScorecardRevisionTest() throws Exception {
    TuneQaScorecardRevisionResponse expectedResponse =
        TuneQaScorecardRevisionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneQaScorecardRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
    String filter = "filter-1274492040";
    boolean validateOnly = true;

    TuneQaScorecardRevisionResponse actualResponse =
        client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
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
  public void tuneQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardRevisionName parent =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      String filter = "filter-1274492040";
      boolean validateOnly = true;
      client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void tuneQaScorecardRevisionTest2() throws Exception {
    TuneQaScorecardRevisionResponse expectedResponse =
        TuneQaScorecardRevisionResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("tuneQaScorecardRevisionTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent =
        "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";
    String filter = "filter-1274492040";
    boolean validateOnly = true;

    TuneQaScorecardRevisionResponse actualResponse =
        client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
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
  public void tuneQaScorecardRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-2630/locations/location-2630/qaScorecards/qaScorecard-2630/revisions/revision-2630";
      String filter = "filter-1274492040";
      boolean validateOnly = true;
      client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void deployQaScorecardRevisionTest() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    DeployQaScorecardRevisionRequest request =
        DeployQaScorecardRevisionRequest.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .build();

    QaScorecardRevision actualResponse = client.deployQaScorecardRevision(request);
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
  public void deployQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      DeployQaScorecardRevisionRequest request =
          DeployQaScorecardRevisionRequest.newBuilder()
              .setName(
                  QaScorecardRevisionName.of(
                          "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                      .toString())
              .build();
      client.deployQaScorecardRevision(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void undeployQaScorecardRevisionTest() throws Exception {
    QaScorecardRevision expectedResponse =
        QaScorecardRevision.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .setSnapshot(QaScorecard.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .addAllAlternateIds(new ArrayList<String>())
            .build();
    mockService.addResponse(expectedResponse);

    UndeployQaScorecardRevisionRequest request =
        UndeployQaScorecardRevisionRequest.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .build();

    QaScorecardRevision actualResponse = client.undeployQaScorecardRevision(request);
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
  public void undeployQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      UndeployQaScorecardRevisionRequest request =
          UndeployQaScorecardRevisionRequest.newBuilder()
              .setName(
                  QaScorecardRevisionName.of(
                          "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                      .toString())
              .build();
      client.undeployQaScorecardRevision(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaScorecardRevisionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    QaScorecardRevisionName name =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    client.deleteQaScorecardRevision(name);

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
  public void deleteQaScorecardRevisionExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardRevisionName name =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      client.deleteQaScorecardRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteQaScorecardRevisionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7899/locations/location-7899/qaScorecards/qaScorecard-7899/revisions/revision-7899";

    client.deleteQaScorecardRevision(name);

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
  public void deleteQaScorecardRevisionExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7899/locations/location-7899/qaScorecards/qaScorecard-7899/revisions/revision-7899";
      client.deleteQaScorecardRevision(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaScorecardRevisionsTest() throws Exception {
    QaScorecardRevision responsesElement = QaScorecardRevision.newBuilder().build();
    ListQaScorecardRevisionsResponse expectedResponse =
        ListQaScorecardRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaScorecardRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    ListQaScorecardRevisionsPagedResponse pagedListResponse =
        client.listQaScorecardRevisions(parent);

    List<QaScorecardRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardRevisionsList().get(0), resources.get(0));

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
  public void listQaScorecardRevisionsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
      client.listQaScorecardRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listQaScorecardRevisionsTest2() throws Exception {
    QaScorecardRevision responsesElement = QaScorecardRevision.newBuilder().build();
    ListQaScorecardRevisionsResponse expectedResponse =
        ListQaScorecardRevisionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllQaScorecardRevisions(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-1550/locations/location-1550/qaScorecards/qaScorecard-1550";

    ListQaScorecardRevisionsPagedResponse pagedListResponse =
        client.listQaScorecardRevisions(parent);

    List<QaScorecardRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardRevisionsList().get(0), resources.get(0));

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
  public void listQaScorecardRevisionsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-1550/locations/location-1550/qaScorecards/qaScorecard-1550";
      client.listQaScorecardRevisions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFeedbackLabelTest() throws Exception {
    FeedbackLabel expectedResponse =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
    String feedbackLabelId = "feedbackLabelId-1251198998";

    FeedbackLabel actualResponse =
        client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
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
  public void createFeedbackLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
      String feedbackLabelId = "feedbackLabelId-1251198998";
      client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createFeedbackLabelTest2() throws Exception {
    FeedbackLabel expectedResponse =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8053/locations/location-8053/conversations/conversation-8053";
    FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
    String feedbackLabelId = "feedbackLabelId-1251198998";

    FeedbackLabel actualResponse =
        client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
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
  public void createFeedbackLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8053/locations/location-8053/conversations/conversation-8053";
      FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
      String feedbackLabelId = "feedbackLabelId-1251198998";
      client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedbackLabelsTest() throws Exception {
    FeedbackLabel responsesElement = FeedbackLabel.newBuilder().build();
    ListFeedbackLabelsResponse expectedResponse =
        ListFeedbackLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedbackLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    ListFeedbackLabelsPagedResponse pagedListResponse = client.listFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

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
  public void listFeedbackLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      client.listFeedbackLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listFeedbackLabelsTest2() throws Exception {
    FeedbackLabel responsesElement = FeedbackLabel.newBuilder().build();
    ListFeedbackLabelsResponse expectedResponse =
        ListFeedbackLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedbackLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-8053/locations/location-8053/conversations/conversation-8053";

    ListFeedbackLabelsPagedResponse pagedListResponse = client.listFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

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
  public void listFeedbackLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-8053/locations/location-8053/conversations/conversation-8053";
      client.listFeedbackLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedbackLabelTest() throws Exception {
    FeedbackLabel expectedResponse =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FeedbackLabelName name =
        FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");

    FeedbackLabel actualResponse = client.getFeedbackLabel(name);
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
  public void getFeedbackLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedbackLabelName name =
          FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");
      client.getFeedbackLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getFeedbackLabelTest2() throws Exception {
    FeedbackLabel expectedResponse =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5400/locations/location-5400/conversations/conversation-5400/feedbackLabels/feedbackLabel-5400";

    FeedbackLabel actualResponse = client.getFeedbackLabel(name);
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
  public void getFeedbackLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5400/locations/location-5400/conversations/conversation-5400/feedbackLabels/feedbackLabel-5400";
      client.getFeedbackLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateFeedbackLabelTest() throws Exception {
    FeedbackLabel expectedResponse =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    FeedbackLabel feedbackLabel =
        FeedbackLabel.newBuilder()
            .setName(
                FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                        "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                    .toString())
            .setLabeledResource("labeledResource-527465535")
            .setCreateTime(Timestamp.newBuilder().build())
            .setUpdateTime(Timestamp.newBuilder().build())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FeedbackLabel actualResponse = client.updateFeedbackLabel(feedbackLabel, updateMask);
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
  public void updateFeedbackLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedbackLabel feedbackLabel =
          FeedbackLabel.newBuilder()
              .setName(
                  FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
                          "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]")
                      .toString())
              .setLabeledResource("labeledResource-527465535")
              .setCreateTime(Timestamp.newBuilder().build())
              .setUpdateTime(Timestamp.newBuilder().build())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateFeedbackLabel(feedbackLabel, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedbackLabelTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    FeedbackLabelName name =
        FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");

    client.deleteFeedbackLabel(name);

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
  public void deleteFeedbackLabelExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      FeedbackLabelName name =
          FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");
      client.deleteFeedbackLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteFeedbackLabelTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-5400/locations/location-5400/conversations/conversation-5400/feedbackLabels/feedbackLabel-5400";

    client.deleteFeedbackLabel(name);

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
  public void deleteFeedbackLabelExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-5400/locations/location-5400/conversations/conversation-5400/feedbackLabels/feedbackLabel-5400";
      client.deleteFeedbackLabel(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFeedbackLabelsTest() throws Exception {
    FeedbackLabel responsesElement = FeedbackLabel.newBuilder().build();
    ListAllFeedbackLabelsResponse expectedResponse =
        ListAllFeedbackLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedbackLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAllFeedbackLabelsPagedResponse pagedListResponse = client.listAllFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

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
  public void listAllFeedbackLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.listAllFeedbackLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listAllFeedbackLabelsTest2() throws Exception {
    FeedbackLabel responsesElement = FeedbackLabel.newBuilder().build();
    ListAllFeedbackLabelsResponse expectedResponse =
        ListAllFeedbackLabelsResponse.newBuilder()
            .setNextPageToken("")
            .addAllFeedbackLabels(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-5833/locations/location-5833";

    ListAllFeedbackLabelsPagedResponse pagedListResponse = client.listAllFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

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
  public void listAllFeedbackLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.listAllFeedbackLabels(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void bulkUploadFeedbackLabelsTest() throws Exception {
    BulkUploadFeedbackLabelsResponse expectedResponse =
        BulkUploadFeedbackLabelsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkUploadFeedbackLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    BulkUploadFeedbackLabelsResponse actualResponse =
        client.bulkUploadFeedbackLabelsAsync(parent).get();
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
  public void bulkUploadFeedbackLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.bulkUploadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkUploadFeedbackLabelsTest2() throws Exception {
    BulkUploadFeedbackLabelsResponse expectedResponse =
        BulkUploadFeedbackLabelsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkUploadFeedbackLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";

    BulkUploadFeedbackLabelsResponse actualResponse =
        client.bulkUploadFeedbackLabelsAsync(parent).get();
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
  public void bulkUploadFeedbackLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.bulkUploadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDownloadFeedbackLabelsTest() throws Exception {
    BulkDownloadFeedbackLabelsResponse expectedResponse =
        BulkDownloadFeedbackLabelsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDownloadFeedbackLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    BulkDownloadFeedbackLabelsResponse actualResponse =
        client.bulkDownloadFeedbackLabelsAsync(parent).get();
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
  public void bulkDownloadFeedbackLabelsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.bulkDownloadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }

  @Test
  public void bulkDownloadFeedbackLabelsTest2() throws Exception {
    BulkDownloadFeedbackLabelsResponse expectedResponse =
        BulkDownloadFeedbackLabelsResponse.newBuilder().build();
    Operation resultOperation =
        Operation.newBuilder()
            .setName("bulkDownloadFeedbackLabelsTest")
            .setDone(true)
            .setResponse(Any.pack(expectedResponse))
            .build();
    mockService.addResponse(resultOperation);

    String parent = "projects/project-5833/locations/location-5833";

    BulkDownloadFeedbackLabelsResponse actualResponse =
        client.bulkDownloadFeedbackLabelsAsync(parent).get();
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
  public void bulkDownloadFeedbackLabelsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-5833/locations/location-5833";
      client.bulkDownloadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
    }
  }
}
