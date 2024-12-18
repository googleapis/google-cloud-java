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
import com.google.protobuf.Duration;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
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
public class ContactCenterInsightsClientTest {
  private static MockContactCenterInsights mockContactCenterInsights;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ContactCenterInsightsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockContactCenterInsights = new MockContactCenterInsights();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockContactCenterInsights));
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
    ContactCenterInsightsSettings settings =
        ContactCenterInsightsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ContactCenterInsightsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationRequest actualRequest = ((CreateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertEquals(conversationId, actualRequest.getConversationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationRequest actualRequest = ((CreateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertEquals(conversationId, actualRequest.getConversationId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(resultOperation);

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

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadConversationRequest actualRequest = ((UploadConversationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getConversation(), actualRequest.getConversation());
    Assert.assertEquals(request.getConversationId(), actualRequest.getConversationId());
    Assert.assertEquals(request.getRedactionConfig(), actualRequest.getRedactionConfig());
    Assert.assertEquals(request.getSpeechConfig(), actualRequest.getSpeechConfig());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    Conversation conversation = Conversation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Conversation actualResponse = client.updateConversation(conversation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateConversationRequest actualRequest = ((UpdateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      Conversation conversation = Conversation.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationRequest actualRequest = ((GetConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetConversationRequest actualRequest = ((GetConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteConversationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContactCenterInsights.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationRequest actualRequest = ((DeleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteConversationRequest actualRequest = ((DeleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(resultOperation);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    Analysis analysis = Analysis.newBuilder().build();

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalysisRequest actualRequest = ((CreateAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(analysis, actualRequest.getAnalysis());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalysisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectLocationConversationName(
              "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      Analysis analysis = Analysis.newBuilder().build();
      client.createAnalysisAsync(parent, analysis).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    Analysis analysis = Analysis.newBuilder().build();

    Analysis actualResponse = client.createAnalysisAsync(parent, analysis).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalysisRequest actualRequest = ((CreateAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(analysis, actualRequest.getAnalysis());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalysisExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      Analysis analysis = Analysis.newBuilder().build();
      client.createAnalysisAsync(parent, analysis).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    AnalysisName name =
        AnalysisName.ofProjectLocationConversationAnalysisName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");

    Analysis actualResponse = client.getAnalysis(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalysisRequest actualRequest = ((GetAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalysisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    Analysis actualResponse = client.getAnalysis(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalysisRequest actualRequest = ((GetAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalysisExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalysesRequest actualRequest = ((ListAnalysesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalysesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalysesPagedResponse pagedListResponse = client.listAnalyses(parent);

    List<Analysis> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalysesRequest actualRequest = ((ListAnalysesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalysesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listAnalyses(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteAnalysisTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContactCenterInsights.addResponse(expectedResponse);

    AnalysisName name =
        AnalysisName.ofProjectLocationConversationAnalysisName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[ANALYSIS]");

    client.deleteAnalysis(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalysisRequest actualRequest = ((DeleteAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalysisExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnalysis(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalysisRequest actualRequest = ((DeleteAnalysisRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalysisExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String filter = "filter-1274492040";
    float analysisPercentage = 1609757661;

    BulkAnalyzeConversationsResponse actualResponse =
        client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkAnalyzeConversationsRequest actualRequest =
        ((BulkAnalyzeConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(analysisPercentage, actualRequest.getAnalysisPercentage(), 0.0001f);
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkAnalyzeConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String filter = "filter-1274492040";
      float analysisPercentage = 1609757661;
      client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";
    float analysisPercentage = 1609757661;

    BulkAnalyzeConversationsResponse actualResponse =
        client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkAnalyzeConversationsRequest actualRequest =
        ((BulkAnalyzeConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(analysisPercentage, actualRequest.getAnalysisPercentage(), 0.0001f);
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkAnalyzeConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      float analysisPercentage = 1609757661;
      client.bulkAnalyzeConversationsAsync(parent, filter, analysisPercentage).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    String filter = "filter-1274492040";

    BulkDeleteConversationsResponse actualResponse =
        client.bulkDeleteConversationsAsync(parent, filter).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDeleteConversationsRequest actualRequest =
        ((BulkDeleteConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDeleteConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      String filter = "filter-1274492040";
      client.bulkDeleteConversationsAsync(parent, filter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";

    BulkDeleteConversationsResponse actualResponse =
        client.bulkDeleteConversationsAsync(parent, filter).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDeleteConversationsRequest actualRequest =
        ((BulkDeleteConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDeleteConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      client.bulkDeleteConversationsAsync(parent, filter).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    IngestConversationsResponse actualResponse = client.ingestConversationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestConversationsRequest actualRequest = ((IngestConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestConversationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.ingestConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";

    IngestConversationsResponse actualResponse = client.ingestConversationsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestConversationsRequest actualRequest = ((IngestConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.ingestConversationsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ExportInsightsDataResponse actualResponse = client.exportInsightsDataAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportInsightsDataRequest actualRequest = ((ExportInsightsDataRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportInsightsDataExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.exportInsightsDataAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";

    ExportInsightsDataResponse actualResponse = client.exportInsightsDataAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportInsightsDataRequest actualRequest = ((ExportInsightsDataRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportInsightsDataExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.exportInsightsDataAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    IssueModel issueModel = IssueModel.newBuilder().build();

    IssueModel actualResponse = client.createIssueModelAsync(parent, issueModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueModelRequest actualRequest = ((CreateIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(issueModel, actualRequest.getIssueModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      IssueModel issueModel = IssueModel.newBuilder().build();
      client.createIssueModelAsync(parent, issueModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    IssueModel issueModel = IssueModel.newBuilder().build();

    IssueModel actualResponse = client.createIssueModelAsync(parent, issueModel).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateIssueModelRequest actualRequest = ((CreateIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(issueModel, actualRequest.getIssueModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      IssueModel issueModel = IssueModel.newBuilder().build();
      client.createIssueModelAsync(parent, issueModel).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueModel issueModel = IssueModel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    IssueModel actualResponse = client.updateIssueModel(issueModel, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIssueModelRequest actualRequest = ((UpdateIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(issueModel, actualRequest.getIssueModel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      IssueModel issueModel = IssueModel.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    IssueModel actualResponse = client.getIssueModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueModelRequest actualRequest = ((GetIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    IssueModel actualResponse = client.getIssueModel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueModelRequest actualRequest = ((GetIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListIssueModelsResponse actualResponse = client.listIssueModels(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssueModelsRequest actualRequest = ((ListIssueModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssueModelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIssueModelsResponse actualResponse = client.listIssueModels(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssueModelsRequest actualRequest = ((ListIssueModelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssueModelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    client.deleteIssueModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueModelRequest actualRequest = ((DeleteIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.deleteIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String name = "name3373707";

    client.deleteIssueModelAsync(name).get();

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueModelRequest actualRequest = ((DeleteIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
      client.deleteIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    DeployIssueModelResponse actualResponse = client.deployIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployIssueModelRequest actualRequest = ((DeployIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.deployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String name = "name3373707";

    DeployIssueModelResponse actualResponse = client.deployIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployIssueModelRequest actualRequest = ((DeployIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
      client.deployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    UndeployIssueModelResponse actualResponse = client.undeployIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployIssueModelRequest actualRequest = ((UndeployIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.undeployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String name = "name3373707";

    UndeployIssueModelResponse actualResponse = client.undeployIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployIssueModelRequest actualRequest = ((UndeployIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
      client.undeployIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    ExportIssueModelResponse actualResponse = client.exportIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportIssueModelRequest actualRequest = ((ExportIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      IssueModelName name = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");
      client.exportIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String name = "name3373707";

    ExportIssueModelResponse actualResponse = client.exportIssueModelAsync(name).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ExportIssueModelRequest actualRequest = ((ExportIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void exportIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
      client.exportIssueModelAsync(name).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ImportIssueModelResponse actualResponse = client.importIssueModelAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportIssueModelRequest actualRequest = ((ImportIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importIssueModelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.importIssueModelAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";

    ImportIssueModelResponse actualResponse = client.importIssueModelAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ImportIssueModelRequest actualRequest = ((ImportIssueModelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void importIssueModelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.importIssueModelAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");

    Issue actualResponse = client.getIssue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueRequest actualRequest = ((GetIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    Issue actualResponse = client.getIssue(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetIssueRequest actualRequest = ((GetIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueModelName parent = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    ListIssuesResponse actualResponse = client.listIssues(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssuesRequest actualRequest = ((ListIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssuesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListIssuesResponse actualResponse = client.listIssues(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListIssuesRequest actualRequest = ((ListIssuesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listIssuesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    Issue issue = Issue.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Issue actualResponse = client.updateIssue(issue, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateIssueRequest actualRequest = ((UpdateIssueRequest) actualRequests.get(0));

    Assert.assertEquals(issue, actualRequest.getIssue());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      Issue issue = Issue.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueName name = IssueName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]", "[ISSUE]");

    client.deleteIssue(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueRequest actualRequest = ((DeleteIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteIssue(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteIssueRequest actualRequest = ((DeleteIssueRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteIssueExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    IssueModelName issueModel = IssueModelName.of("[PROJECT]", "[LOCATION]", "[ISSUE_MODEL]");

    CalculateIssueModelStatsResponse actualResponse = client.calculateIssueModelStats(issueModel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateIssueModelStatsRequest actualRequest =
        ((CalculateIssueModelStatsRequest) actualRequests.get(0));

    Assert.assertEquals(issueModel.toString(), actualRequest.getIssueModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateIssueModelStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String issueModel = "issueModel1426588112";

    CalculateIssueModelStatsResponse actualResponse = client.calculateIssueModelStats(issueModel);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateIssueModelStatsRequest actualRequest =
        ((CalculateIssueModelStatsRequest) actualRequests.get(0));

    Assert.assertEquals(issueModel, actualRequest.getIssueModel());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateIssueModelStatsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String issueModel = "issueModel1426588112";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();

    PhraseMatcher actualResponse = client.createPhraseMatcher(parent, phraseMatcher);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseMatcherRequest actualRequest = ((CreatePhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(phraseMatcher, actualRequest.getPhraseMatcher());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseMatcherExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();

    PhraseMatcher actualResponse = client.createPhraseMatcher(parent, phraseMatcher);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreatePhraseMatcherRequest actualRequest = ((CreatePhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(phraseMatcher, actualRequest.getPhraseMatcher());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createPhraseMatcherExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");

    PhraseMatcher actualResponse = client.getPhraseMatcher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseMatcherRequest actualRequest = ((GetPhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseMatcherExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    PhraseMatcher actualResponse = client.getPhraseMatcher(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetPhraseMatcherRequest actualRequest = ((GetPhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getPhraseMatcherExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListPhraseMatchersPagedResponse pagedListResponse = client.listPhraseMatchers(parent);

    List<PhraseMatcher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseMatchersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseMatchersRequest actualRequest = ((ListPhraseMatchersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseMatchersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListPhraseMatchersPagedResponse pagedListResponse = client.listPhraseMatchers(parent);

    List<PhraseMatcher> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getPhraseMatchersList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListPhraseMatchersRequest actualRequest = ((ListPhraseMatchersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listPhraseMatchersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listPhraseMatchers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deletePhraseMatcherTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockContactCenterInsights.addResponse(expectedResponse);

    PhraseMatcherName name = PhraseMatcherName.of("[PROJECT]", "[LOCATION]", "[PHRASE_MATCHER]");

    client.deletePhraseMatcher(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseMatcherRequest actualRequest = ((DeletePhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseMatcherExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deletePhraseMatcher(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeletePhraseMatcherRequest actualRequest = ((DeletePhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deletePhraseMatcherExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    PhraseMatcher actualResponse = client.updatePhraseMatcher(phraseMatcher, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdatePhraseMatcherRequest actualRequest = ((UpdatePhraseMatcherRequest) actualRequests.get(0));

    Assert.assertEquals(phraseMatcher, actualRequest.getPhraseMatcher());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updatePhraseMatcherExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      PhraseMatcher phraseMatcher = PhraseMatcher.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName location = LocationName.of("[PROJECT]", "[LOCATION]");

    CalculateStatsResponse actualResponse = client.calculateStats(location);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateStatsRequest actualRequest = ((CalculateStatsRequest) actualRequests.get(0));

    Assert.assertEquals(location.toString(), actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateStatsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String location = "location1901043637";

    CalculateStatsResponse actualResponse = client.calculateStats(location);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CalculateStatsRequest actualRequest = ((CalculateStatsRequest) actualRequests.get(0));

    Assert.assertEquals(location, actualRequest.getLocation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void calculateStatsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String location = "location1901043637";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    SettingsName name = SettingsName.of("[PROJECT]", "[LOCATION]");

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    Settings actualResponse = client.getSettings(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSettingsRequest actualRequest = ((GetSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSettingsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    Settings settings = Settings.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Settings actualResponse = client.updateSettings(settings, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSettingsRequest actualRequest = ((UpdateSettingsRequest) actualRequests.get(0));

    Assert.assertEquals(settings, actualRequest.getSettings());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSettingsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      Settings settings = Settings.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    AnalysisRule analysisRule = AnalysisRule.newBuilder().build();

    AnalysisRule actualResponse = client.createAnalysisRule(parent, analysisRule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalysisRuleRequest actualRequest = ((CreateAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(analysisRule, actualRequest.getAnalysisRule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalysisRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    AnalysisRule analysisRule = AnalysisRule.newBuilder().build();

    AnalysisRule actualResponse = client.createAnalysisRule(parent, analysisRule);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateAnalysisRuleRequest actualRequest = ((CreateAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(analysisRule, actualRequest.getAnalysisRule());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createAnalysisRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");

    AnalysisRule actualResponse = client.getAnalysisRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalysisRuleRequest actualRequest = ((GetAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalysisRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    AnalysisRule actualResponse = client.getAnalysisRule(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAnalysisRuleRequest actualRequest = ((GetAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAnalysisRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAnalysisRulesPagedResponse pagedListResponse = client.listAnalysisRules(parent);

    List<AnalysisRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysisRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalysisRulesRequest actualRequest = ((ListAnalysisRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalysisRulesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAnalysisRulesPagedResponse pagedListResponse = client.listAnalysisRules(parent);

    List<AnalysisRule> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getAnalysisRulesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAnalysisRulesRequest actualRequest = ((ListAnalysisRulesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAnalysisRulesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    AnalysisRule actualResponse = client.updateAnalysisRule(analysisRule, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateAnalysisRuleRequest actualRequest = ((UpdateAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(analysisRule, actualRequest.getAnalysisRule());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateAnalysisRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      AnalysisRule analysisRule = AnalysisRule.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    AnalysisRuleName name = AnalysisRuleName.of("[PROJECT]", "[LOCATION]", "[ANALYSIS_RULE]");

    client.deleteAnalysisRule(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalysisRuleRequest actualRequest = ((DeleteAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalysisRuleExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteAnalysisRule(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteAnalysisRuleRequest actualRequest = ((DeleteAnalysisRuleRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteAnalysisRuleExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    EncryptionSpecName name = EncryptionSpecName.of("[PROJECT]", "[LOCATION]");

    EncryptionSpec actualResponse = client.getEncryptionSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEncryptionSpecRequest actualRequest = ((GetEncryptionSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEncryptionSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    EncryptionSpec actualResponse = client.getEncryptionSpec(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetEncryptionSpecRequest actualRequest = ((GetEncryptionSpecRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getEncryptionSpecExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(resultOperation);

    EncryptionSpec encryptionSpec = EncryptionSpec.newBuilder().build();

    InitializeEncryptionSpecResponse actualResponse =
        client.initializeEncryptionSpecAsync(encryptionSpec).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    InitializeEncryptionSpecRequest actualRequest =
        ((InitializeEncryptionSpecRequest) actualRequests.get(0));

    Assert.assertEquals(encryptionSpec, actualRequest.getEncryptionSpec());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void initializeEncryptionSpecExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      EncryptionSpec encryptionSpec = EncryptionSpec.newBuilder().build();
      client.initializeEncryptionSpecAsync(encryptionSpec).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    View view = View.newBuilder().build();

    View actualResponse = client.createView(parent, view);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateViewRequest actualRequest = ((CreateViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    View view = View.newBuilder().build();

    View actualResponse = client.createView(parent, view);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateViewRequest actualRequest = ((CreateViewRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");

    View actualResponse = client.getView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViewRequest actualRequest = ((GetViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    View actualResponse = client.getView(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetViewRequest actualRequest = ((GetViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViewsRequest actualRequest = ((ListViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViewsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListViewsPagedResponse pagedListResponse = client.listViews(parent);

    List<View> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getViewsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListViewsRequest actualRequest = ((ListViewsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listViewsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    View view = View.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    View actualResponse = client.updateView(view, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateViewRequest actualRequest = ((UpdateViewRequest) actualRequests.get(0));

    Assert.assertEquals(view, actualRequest.getView());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      View view = View.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ViewName name = ViewName.of("[PROJECT]", "[LOCATION]", "[VIEW]");

    client.deleteView(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteViewRequest actualRequest = ((DeleteViewRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteViewExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteView(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteViewRequest actualRequest = ((DeleteViewRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteViewExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(resultOperation);

    QueryMetricsRequest request =
        QueryMetricsRequest.newBuilder()
            .setLocation(LocationName.of("[PROJECT]", "[LOCATION]").toString())
            .setFilter("filter-1274492040")
            .addAllDimensions(new ArrayList<Dimension>())
            .setMeasureMask(FieldMask.newBuilder().build())
            .build();

    QueryMetricsResponse actualResponse = client.queryMetricsAsync(request).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    QueryMetricsRequest actualRequest = ((QueryMetricsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getLocation(), actualRequest.getLocation());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getTimeGranularity(), actualRequest.getTimeGranularity());
    Assert.assertEquals(request.getDimensionsList(), actualRequest.getDimensionsList());
    Assert.assertEquals(request.getMeasureMask(), actualRequest.getMeasureMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void queryMetricsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
    QaQuestion qaQuestion = QaQuestion.newBuilder().build();
    String qaQuestionId = "qaQuestionId1774614993";

    QaQuestion actualResponse = client.createQaQuestion(parent, qaQuestion, qaQuestionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaQuestionRequest actualRequest = ((CreateQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(qaQuestion, actualRequest.getQaQuestion());
    Assert.assertEquals(qaQuestionId, actualRequest.getQaQuestionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaQuestionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QaQuestion qaQuestion = QaQuestion.newBuilder().build();
    String qaQuestionId = "qaQuestionId1774614993";

    QaQuestion actualResponse = client.createQaQuestion(parent, qaQuestion, qaQuestionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaQuestionRequest actualRequest = ((CreateQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(qaQuestion, actualRequest.getQaQuestion());
    Assert.assertEquals(qaQuestionId, actualRequest.getQaQuestionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaQuestionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaQuestionName name =
        QaQuestionName.of(
            "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");

    QaQuestion actualResponse = client.getQaQuestion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaQuestionRequest actualRequest = ((GetQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaQuestionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    QaQuestion actualResponse = client.getQaQuestion(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaQuestionRequest actualRequest = ((GetQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaQuestionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaQuestion qaQuestion = QaQuestion.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QaQuestion actualResponse = client.updateQaQuestion(qaQuestion, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQaQuestionRequest actualRequest = ((UpdateQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(qaQuestion, actualRequest.getQaQuestion());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQaQuestionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      QaQuestion qaQuestion = QaQuestion.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaQuestionName name =
        QaQuestionName.of(
            "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]", "[QA_QUESTION]");

    client.deleteQaQuestion(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaQuestionRequest actualRequest = ((DeleteQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaQuestionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteQaQuestion(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaQuestionRequest actualRequest = ((DeleteQaQuestionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaQuestionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    ListQaQuestionsPagedResponse pagedListResponse = client.listQaQuestions(parent);

    List<QaQuestion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaQuestionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaQuestionsRequest actualRequest = ((ListQaQuestionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaQuestionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQaQuestionsPagedResponse pagedListResponse = client.listQaQuestions(parent);

    List<QaQuestion> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaQuestionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaQuestionsRequest actualRequest = ((ListQaQuestionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaQuestionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    QaScorecard qaScorecard = QaScorecard.newBuilder().build();
    String qaScorecardId = "qaScorecardId167098669";

    QaScorecard actualResponse = client.createQaScorecard(parent, qaScorecard, qaScorecardId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaScorecardRequest actualRequest = ((CreateQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(qaScorecard, actualRequest.getQaScorecard());
    Assert.assertEquals(qaScorecardId, actualRequest.getQaScorecardId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaScorecardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QaScorecard qaScorecard = QaScorecard.newBuilder().build();
    String qaScorecardId = "qaScorecardId167098669";

    QaScorecard actualResponse = client.createQaScorecard(parent, qaScorecard, qaScorecardId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaScorecardRequest actualRequest = ((CreateQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(qaScorecard, actualRequest.getQaScorecard());
    Assert.assertEquals(qaScorecardId, actualRequest.getQaScorecardId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaScorecardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    QaScorecard actualResponse = client.getQaScorecard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaScorecardRequest actualRequest = ((GetQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaScorecardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    QaScorecard actualResponse = client.getQaScorecard(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaScorecardRequest actualRequest = ((GetQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaScorecardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecard qaScorecard = QaScorecard.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    QaScorecard actualResponse = client.updateQaScorecard(qaScorecard, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateQaScorecardRequest actualRequest = ((UpdateQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(qaScorecard, actualRequest.getQaScorecard());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateQaScorecardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      QaScorecard qaScorecard = QaScorecard.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardName name = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    client.deleteQaScorecard(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaScorecardRequest actualRequest = ((DeleteQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaScorecardExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteQaScorecard(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaScorecardRequest actualRequest = ((DeleteQaScorecardRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaScorecardExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListQaScorecardsPagedResponse pagedListResponse = client.listQaScorecards(parent);

    List<QaScorecard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaScorecardsRequest actualRequest = ((ListQaScorecardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaScorecardsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQaScorecardsPagedResponse pagedListResponse = client.listQaScorecards(parent);

    List<QaScorecard> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaScorecardsRequest actualRequest = ((ListQaScorecardsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaScorecardsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");
    QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
    String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";

    QaScorecardRevision actualResponse =
        client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaScorecardRevisionRequest actualRequest =
        ((CreateQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(qaScorecardRevision, actualRequest.getQaScorecardRevision());
    Assert.assertEquals(qaScorecardRevisionId, actualRequest.getQaScorecardRevisionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    QaScorecardRevision qaScorecardRevision = QaScorecardRevision.newBuilder().build();
    String qaScorecardRevisionId = "qaScorecardRevisionId1384099944";

    QaScorecardRevision actualResponse =
        client.createQaScorecardRevision(parent, qaScorecardRevision, qaScorecardRevisionId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateQaScorecardRevisionRequest actualRequest =
        ((CreateQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(qaScorecardRevision, actualRequest.getQaScorecardRevision());
    Assert.assertEquals(qaScorecardRevisionId, actualRequest.getQaScorecardRevisionId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createQaScorecardRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardRevisionName name =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    QaScorecardRevision actualResponse = client.getQaScorecardRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaScorecardRevisionRequest actualRequest =
        ((GetQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    QaScorecardRevision actualResponse = client.getQaScorecardRevision(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetQaScorecardRevisionRequest actualRequest =
        ((GetQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getQaScorecardRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(resultOperation);

    QaScorecardRevisionName parent =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
    String filter = "filter-1274492040";
    boolean validateOnly = true;

    TuneQaScorecardRevisionResponse actualResponse =
        client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TuneQaScorecardRevisionRequest actualRequest =
        ((TuneQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(validateOnly, actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void tuneQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      QaScorecardRevisionName parent =
          QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");
      String filter = "filter-1274492040";
      boolean validateOnly = true;
      client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";
    String filter = "filter-1274492040";
    boolean validateOnly = true;

    TuneQaScorecardRevisionResponse actualResponse =
        client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    TuneQaScorecardRevisionRequest actualRequest =
        ((TuneQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(filter, actualRequest.getFilter());
    Assert.assertEquals(validateOnly, actualRequest.getValidateOnly());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void tuneQaScorecardRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      String filter = "filter-1274492040";
      boolean validateOnly = true;
      client.tuneQaScorecardRevisionAsync(parent, filter, validateOnly).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(expectedResponse);

    DeployQaScorecardRevisionRequest request =
        DeployQaScorecardRevisionRequest.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .build();

    QaScorecardRevision actualResponse = client.deployQaScorecardRevision(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeployQaScorecardRevisionRequest actualRequest =
        ((DeployQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deployQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    UndeployQaScorecardRevisionRequest request =
        UndeployQaScorecardRevisionRequest.newBuilder()
            .setName(
                QaScorecardRevisionName.of(
                        "[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]")
                    .toString())
            .build();

    QaScorecardRevision actualResponse = client.undeployQaScorecardRevision(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UndeployQaScorecardRevisionRequest actualRequest =
        ((UndeployQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void undeployQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardRevisionName name =
        QaScorecardRevisionName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]", "[REVISION]");

    client.deleteQaScorecardRevision(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaScorecardRevisionRequest actualRequest =
        ((DeleteQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaScorecardRevisionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteQaScorecardRevision(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteQaScorecardRevisionRequest actualRequest =
        ((DeleteQaScorecardRevisionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteQaScorecardRevisionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    QaScorecardName parent = QaScorecardName.of("[PROJECT]", "[LOCATION]", "[QA_SCORECARD]");

    ListQaScorecardRevisionsPagedResponse pagedListResponse =
        client.listQaScorecardRevisions(parent);

    List<QaScorecardRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaScorecardRevisionsRequest actualRequest =
        ((ListQaScorecardRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaScorecardRevisionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListQaScorecardRevisionsPagedResponse pagedListResponse =
        client.listQaScorecardRevisions(parent);

    List<QaScorecardRevision> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getQaScorecardRevisionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListQaScorecardRevisionsRequest actualRequest =
        ((ListQaScorecardRevisionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listQaScorecardRevisionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
    String feedbackLabelId = "feedbackLabelId-1251198998";

    FeedbackLabel actualResponse =
        client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeedbackLabelRequest actualRequest = ((CreateFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(feedbackLabel, actualRequest.getFeedbackLabel());
    Assert.assertEquals(feedbackLabelId, actualRequest.getFeedbackLabelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeedbackLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";
    FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
    String feedbackLabelId = "feedbackLabelId-1251198998";

    FeedbackLabel actualResponse =
        client.createFeedbackLabel(parent, feedbackLabel, feedbackLabelId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateFeedbackLabelRequest actualRequest = ((CreateFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(feedbackLabel, actualRequest.getFeedbackLabel());
    Assert.assertEquals(feedbackLabelId, actualRequest.getFeedbackLabelId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createFeedbackLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    ListFeedbackLabelsPagedResponse pagedListResponse = client.listFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeedbackLabelsRequest actualRequest = ((ListFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeedbackLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListFeedbackLabelsPagedResponse pagedListResponse = client.listFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListFeedbackLabelsRequest actualRequest = ((ListFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listFeedbackLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    FeedbackLabelName name =
        FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");

    FeedbackLabel actualResponse = client.getFeedbackLabel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeedbackLabelRequest actualRequest = ((GetFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeedbackLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    FeedbackLabel actualResponse = client.getFeedbackLabel(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetFeedbackLabelRequest actualRequest = ((GetFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getFeedbackLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    FeedbackLabel actualResponse = client.updateFeedbackLabel(feedbackLabel, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateFeedbackLabelRequest actualRequest = ((UpdateFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(feedbackLabel, actualRequest.getFeedbackLabel());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateFeedbackLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      FeedbackLabel feedbackLabel = FeedbackLabel.newBuilder().build();
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
    mockContactCenterInsights.addResponse(expectedResponse);

    FeedbackLabelName name =
        FeedbackLabelName.ofProjectLocationConversationFeedbackLabelName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]", "[FEEDBACK_LABEL]");

    client.deleteFeedbackLabel(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeedbackLabelRequest actualRequest = ((DeleteFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeedbackLabelExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteFeedbackLabel(name);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteFeedbackLabelRequest actualRequest = ((DeleteFeedbackLabelRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteFeedbackLabelExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String name = "name3373707";
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
    mockContactCenterInsights.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListAllFeedbackLabelsPagedResponse pagedListResponse = client.listAllFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAllFeedbackLabelsRequest actualRequest =
        ((ListAllFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAllFeedbackLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

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
    mockContactCenterInsights.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListAllFeedbackLabelsPagedResponse pagedListResponse = client.listAllFeedbackLabels(parent);

    List<FeedbackLabel> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getFeedbackLabelsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListAllFeedbackLabelsRequest actualRequest =
        ((ListAllFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listAllFeedbackLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    BulkUploadFeedbackLabelsResponse actualResponse =
        client.bulkUploadFeedbackLabelsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkUploadFeedbackLabelsRequest actualRequest =
        ((BulkUploadFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkUploadFeedbackLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.bulkUploadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";

    BulkUploadFeedbackLabelsResponse actualResponse =
        client.bulkUploadFeedbackLabelsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkUploadFeedbackLabelsRequest actualRequest =
        ((BulkUploadFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkUploadFeedbackLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.bulkUploadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    BulkDownloadFeedbackLabelsResponse actualResponse =
        client.bulkDownloadFeedbackLabelsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDownloadFeedbackLabelsRequest actualRequest =
        ((BulkDownloadFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDownloadFeedbackLabelsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
      client.bulkDownloadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
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
    mockContactCenterInsights.addResponse(resultOperation);

    String parent = "parent-995424086";

    BulkDownloadFeedbackLabelsResponse actualResponse =
        client.bulkDownloadFeedbackLabelsAsync(parent).get();
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockContactCenterInsights.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BulkDownloadFeedbackLabelsRequest actualRequest =
        ((BulkDownloadFeedbackLabelsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void bulkDownloadFeedbackLabelsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockContactCenterInsights.addException(exception);

    try {
      String parent = "parent-995424086";
      client.bulkDownloadFeedbackLabelsAsync(parent).get();
      Assert.fail("No exception raised");
    } catch (ExecutionException e) {
      Assert.assertEquals(InvalidArgumentException.class, e.getCause().getClass());
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }
}
