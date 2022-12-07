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

package com.google.cloud.dialogflow.v2;

import static com.google.cloud.dialogflow.v2.ParticipantsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2.ParticipantsClient.ListParticipantsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.testing.MockHttpService;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeStatusCode;
import com.google.cloud.dialogflow.v2.stub.HttpJsonParticipantsStub;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
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
public class ParticipantsClientHttpJsonTest {
  private static MockHttpService mockService;
  private static ParticipantsClient client;

  @BeforeClass
  public static void startStaticServer() throws IOException {
    mockService =
        new MockHttpService(
            HttpJsonParticipantsStub.getMethodDescriptors(),
            ParticipantsSettings.getDefaultEndpoint());
    ParticipantsSettings settings =
        ParticipantsSettings.newHttpJsonBuilder()
            .setTransportChannelProvider(
                ParticipantsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockService)
                    .build())
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ParticipantsClient.create(settings);
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
  public void createParticipantTest() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
    Participant participant = Participant.newBuilder().build();

    Participant actualResponse = client.createParticipant(parent, participant);
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
  public void createParticipantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      Participant participant = Participant.newBuilder().build();
      client.createParticipant(parent, participant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createParticipantTest2() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4379/conversations/conversation-4379";
    Participant participant = Participant.newBuilder().build();

    Participant actualResponse = client.createParticipant(parent, participant);
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
  public void createParticipantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4379/conversations/conversation-4379";
      Participant participant = Participant.newBuilder().build();
      client.createParticipant(parent, participant);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantTest() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName name =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    Participant actualResponse = client.getParticipant(name);
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
  public void getParticipantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName name =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      client.getParticipant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getParticipantTest2() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    String name =
        "projects/project-7006/conversations/conversation-7006/participants/participant-7006";

    Participant actualResponse = client.getParticipant(name);
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
  public void getParticipantExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String name =
          "projects/project-7006/conversations/conversation-7006/participants/participant-7006";
      client.getParticipant(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantsTest() throws Exception {
    Participant responsesElement = Participant.newBuilder().build();
    ListParticipantsResponse expectedResponse =
        ListParticipantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

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
  public void listParticipantsExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      client.listParticipants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listParticipantsTest2() throws Exception {
    Participant responsesElement = Participant.newBuilder().build();
    ListParticipantsResponse expectedResponse =
        ListParticipantsResponse.newBuilder()
            .setNextPageToken("")
            .addAllParticipants(Arrays.asList(responsesElement))
            .build();
    mockService.addResponse(expectedResponse);

    String parent = "projects/project-4379/conversations/conversation-4379";

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

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
  public void listParticipantsExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent = "projects/project-4379/conversations/conversation-4379";
      client.listParticipants(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateParticipantTest() throws Exception {
    Participant expectedResponse =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    mockService.addResponse(expectedResponse);

    Participant participant =
        Participant.newBuilder()
            .setName(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
            .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
            .putAllDocumentsMetadataFilters(new HashMap<String, String>())
            .build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Participant actualResponse = client.updateParticipant(participant, updateMask);
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
  public void updateParticipantExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      Participant participant =
          Participant.newBuilder()
              .setName(
                  ParticipantName.ofProjectConversationParticipantName(
                          "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                      .toString())
              .setSipRecordingMediaLabel("sipRecordingMediaLabel-1887770873")
              .setObfuscatedExternalUserId("obfuscatedExternalUserId1778228693")
              .putAllDocumentsMetadataFilters(new HashMap<String, String>())
              .build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateParticipant(participant, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeContentTest() throws Exception {
    AnalyzeContentResponse expectedResponse =
        AnalyzeContentResponse.newBuilder()
            .setReplyText("replyText-433699017")
            .setReplyAudio(OutputAudio.newBuilder().build())
            .setAutomatedAgentReply(AutomatedAgentReply.newBuilder().build())
            .setMessage(Message.newBuilder().build())
            .addAllHumanAgentSuggestionResults(new ArrayList<SuggestionResult>())
            .addAllEndUserSuggestionResults(new ArrayList<SuggestionResult>())
            .setDtmfParameters(DtmfParameters.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName participant =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
    EventInput eventInput = EventInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, eventInput);
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
  public void analyzeContentExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName participant =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      EventInput eventInput = EventInput.newBuilder().build();
      client.analyzeContent(participant, eventInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeContentTest2() throws Exception {
    AnalyzeContentResponse expectedResponse =
        AnalyzeContentResponse.newBuilder()
            .setReplyText("replyText-433699017")
            .setReplyAudio(OutputAudio.newBuilder().build())
            .setAutomatedAgentReply(AutomatedAgentReply.newBuilder().build())
            .setMessage(Message.newBuilder().build())
            .addAllHumanAgentSuggestionResults(new ArrayList<SuggestionResult>())
            .addAllEndUserSuggestionResults(new ArrayList<SuggestionResult>())
            .setDtmfParameters(DtmfParameters.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName participant =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
    TextInput textInput = TextInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, textInput);
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
  public void analyzeContentExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName participant =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      TextInput textInput = TextInput.newBuilder().build();
      client.analyzeContent(participant, textInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeContentTest3() throws Exception {
    AnalyzeContentResponse expectedResponse =
        AnalyzeContentResponse.newBuilder()
            .setReplyText("replyText-433699017")
            .setReplyAudio(OutputAudio.newBuilder().build())
            .setAutomatedAgentReply(AutomatedAgentReply.newBuilder().build())
            .setMessage(Message.newBuilder().build())
            .addAllHumanAgentSuggestionResults(new ArrayList<SuggestionResult>())
            .addAllEndUserSuggestionResults(new ArrayList<SuggestionResult>())
            .setDtmfParameters(DtmfParameters.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String participant =
        "projects/project-8054/conversations/conversation-8054/participants/participant-8054";
    EventInput eventInput = EventInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, eventInput);
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
  public void analyzeContentExceptionTest3() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String participant =
          "projects/project-8054/conversations/conversation-8054/participants/participant-8054";
      EventInput eventInput = EventInput.newBuilder().build();
      client.analyzeContent(participant, eventInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void analyzeContentTest4() throws Exception {
    AnalyzeContentResponse expectedResponse =
        AnalyzeContentResponse.newBuilder()
            .setReplyText("replyText-433699017")
            .setReplyAudio(OutputAudio.newBuilder().build())
            .setAutomatedAgentReply(AutomatedAgentReply.newBuilder().build())
            .setMessage(Message.newBuilder().build())
            .addAllHumanAgentSuggestionResults(new ArrayList<SuggestionResult>())
            .addAllEndUserSuggestionResults(new ArrayList<SuggestionResult>())
            .setDtmfParameters(DtmfParameters.newBuilder().build())
            .build();
    mockService.addResponse(expectedResponse);

    String participant =
        "projects/project-8054/conversations/conversation-8054/participants/participant-8054";
    TextInput textInput = TextInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, textInput);
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
  public void analyzeContentExceptionTest4() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String participant =
          "projects/project-8054/conversations/conversation-8054/participants/participant-8054";
      TextInput textInput = TextInput.newBuilder().build();
      client.analyzeContent(participant, textInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingAnalyzeContentUnsupportedMethodTest() throws Exception {
    // The streamingAnalyzeContent() method is not supported in REST transport.
    // This empty test is generated for technical reasons.
  }

  @Test
  public void suggestArticlesTest() throws Exception {
    SuggestArticlesResponse expectedResponse =
        SuggestArticlesResponse.newBuilder()
            .addAllArticleAnswers(new ArrayList<ArticleAnswer>())
            .setLatestMessage("latestMessage-1424305536")
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestArticlesResponse actualResponse = client.suggestArticles(parent);
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
  public void suggestArticlesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName parent =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      client.suggestArticles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestArticlesTest2() throws Exception {
    SuggestArticlesResponse expectedResponse =
        SuggestArticlesResponse.newBuilder()
            .addAllArticleAnswers(new ArrayList<ArticleAnswer>())
            .setLatestMessage("latestMessage-1424305536")
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4961/conversations/conversation-4961/participants/participant-4961";

    SuggestArticlesResponse actualResponse = client.suggestArticles(parent);
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
  public void suggestArticlesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4961/conversations/conversation-4961/participants/participant-4961";
      client.suggestArticles(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestFaqAnswersTest() throws Exception {
    SuggestFaqAnswersResponse expectedResponse =
        SuggestFaqAnswersResponse.newBuilder()
            .addAllFaqAnswers(new ArrayList<FaqAnswer>())
            .setLatestMessage("latestMessage-1424305536")
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestFaqAnswersResponse actualResponse = client.suggestFaqAnswers(parent);
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
  public void suggestFaqAnswersExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName parent =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      client.suggestFaqAnswers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestFaqAnswersTest2() throws Exception {
    SuggestFaqAnswersResponse expectedResponse =
        SuggestFaqAnswersResponse.newBuilder()
            .addAllFaqAnswers(new ArrayList<FaqAnswer>())
            .setLatestMessage("latestMessage-1424305536")
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4961/conversations/conversation-4961/participants/participant-4961";

    SuggestFaqAnswersResponse actualResponse = client.suggestFaqAnswers(parent);
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
  public void suggestFaqAnswersExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4961/conversations/conversation-4961/participants/participant-4961";
      client.suggestFaqAnswers(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestSmartRepliesTest() throws Exception {
    SuggestSmartRepliesResponse expectedResponse =
        SuggestSmartRepliesResponse.newBuilder()
            .addAllSmartReplyAnswers(new ArrayList<SmartReplyAnswer>())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestSmartRepliesResponse actualResponse = client.suggestSmartReplies(parent);
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
  public void suggestSmartRepliesExceptionTest() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      ParticipantName parent =
          ParticipantName.ofProjectConversationParticipantName(
              "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
      client.suggestSmartReplies(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void suggestSmartRepliesTest2() throws Exception {
    SuggestSmartRepliesResponse expectedResponse =
        SuggestSmartRepliesResponse.newBuilder()
            .addAllSmartReplyAnswers(new ArrayList<SmartReplyAnswer>())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setContextSize(1116903569)
            .build();
    mockService.addResponse(expectedResponse);

    String parent =
        "projects/project-4961/conversations/conversation-4961/participants/participant-4961";

    SuggestSmartRepliesResponse actualResponse = client.suggestSmartReplies(parent);
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
  public void suggestSmartRepliesExceptionTest2() throws Exception {
    ApiException exception =
        ApiExceptionFactory.createException(
            new Exception(), FakeStatusCode.of(StatusCode.Code.INVALID_ARGUMENT), false);
    mockService.addException(exception);

    try {
      String parent =
          "projects/project-4961/conversations/conversation-4961/participants/participant-4961";
      client.suggestSmartReplies(parent);
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
