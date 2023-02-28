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
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ApiStreamObserver;
import com.google.api.gax.rpc.BidiStreamingCallable;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
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
public class ParticipantsClientTest {
  private static MockLocations mockLocations;
  private static MockParticipants mockParticipants;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ParticipantsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockParticipants = new MockParticipants();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockParticipants, mockLocations));
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
    ParticipantsSettings settings =
        ParticipantsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ParticipantsClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
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
    mockParticipants.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
    Participant participant = Participant.newBuilder().build();

    Participant actualResponse = client.createParticipant(parent, participant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParticipantRequest actualRequest = ((CreateParticipantRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(participant, actualRequest.getParticipant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParticipantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Participant participant = Participant.newBuilder().build();

    Participant actualResponse = client.createParticipant(parent, participant);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateParticipantRequest actualRequest = ((CreateParticipantRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(participant, actualRequest.getParticipant());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createParticipantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockParticipants.addResponse(expectedResponse);

    ParticipantName name =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    Participant actualResponse = client.getParticipant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParticipantRequest actualRequest = ((GetParticipantRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParticipantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String name = "name3373707";

    Participant actualResponse = client.getParticipant(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetParticipantRequest actualRequest = ((GetParticipantRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getParticipantExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String name = "name3373707";
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
    mockParticipants.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParticipantsRequest actualRequest = ((ListParticipantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParticipantsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListParticipantsPagedResponse pagedListResponse = client.listParticipants(parent);

    List<Participant> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getParticipantsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListParticipantsRequest actualRequest = ((ListParticipantsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listParticipantsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockParticipants.addResponse(expectedResponse);

    Participant participant = Participant.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Participant actualResponse = client.updateParticipant(participant, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateParticipantRequest actualRequest = ((UpdateParticipantRequest) actualRequests.get(0));

    Assert.assertEquals(participant, actualRequest.getParticipant());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateParticipantExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      Participant participant = Participant.newBuilder().build();
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
    mockParticipants.addResponse(expectedResponse);

    ParticipantName participant =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
    EventInput eventInput = EventInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, eventInput);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeContentRequest actualRequest = ((AnalyzeContentRequest) actualRequests.get(0));

    Assert.assertEquals(participant.toString(), actualRequest.getParticipant());
    Assert.assertEquals(eventInput, actualRequest.getEventInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    ParticipantName participant =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");
    TextInput textInput = TextInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, textInput);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeContentRequest actualRequest = ((AnalyzeContentRequest) actualRequests.get(0));

    Assert.assertEquals(participant.toString(), actualRequest.getParticipant());
    Assert.assertEquals(textInput, actualRequest.getTextInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeContentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String participant = "participant767422259";
    EventInput eventInput = EventInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, eventInput);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeContentRequest actualRequest = ((AnalyzeContentRequest) actualRequests.get(0));

    Assert.assertEquals(participant, actualRequest.getParticipant());
    Assert.assertEquals(eventInput, actualRequest.getEventInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeContentExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String participant = "participant767422259";
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
    mockParticipants.addResponse(expectedResponse);

    String participant = "participant767422259";
    TextInput textInput = TextInput.newBuilder().build();

    AnalyzeContentResponse actualResponse = client.analyzeContent(participant, textInput);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    AnalyzeContentRequest actualRequest = ((AnalyzeContentRequest) actualRequests.get(0));

    Assert.assertEquals(participant, actualRequest.getParticipant());
    Assert.assertEquals(textInput, actualRequest.getTextInput());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void analyzeContentExceptionTest4() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String participant = "participant767422259";
      TextInput textInput = TextInput.newBuilder().build();
      client.analyzeContent(participant, textInput);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void streamingAnalyzeContentTest() throws Exception {
    StreamingAnalyzeContentResponse expectedResponse =
        StreamingAnalyzeContentResponse.newBuilder()
            .setRecognitionResult(StreamingRecognitionResult.newBuilder().build())
            .setReplyText("replyText-433699017")
            .setReplyAudio(OutputAudio.newBuilder().build())
            .setAutomatedAgentReply(AutomatedAgentReply.newBuilder().build())
            .setMessage(Message.newBuilder().build())
            .addAllHumanAgentSuggestionResults(new ArrayList<SuggestionResult>())
            .addAllEndUserSuggestionResults(new ArrayList<SuggestionResult>())
            .setDtmfParameters(DtmfParameters.newBuilder().build())
            .build();
    mockParticipants.addResponse(expectedResponse);
    StreamingAnalyzeContentRequest request =
        StreamingAnalyzeContentRequest.newBuilder()
            .setParticipant(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setReplyAudioConfig(OutputAudioConfig.newBuilder().build())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setAssistQueryParams(AssistQueryParameters.newBuilder().build())
            .setCxParameters(Struct.newBuilder().build())
            .setEnablePartialAutomatedAgentReply(true)
            .build();

    MockStreamObserver<StreamingAnalyzeContentResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
        callable = client.streamingAnalyzeContentCallable();
    ApiStreamObserver<StreamingAnalyzeContentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);
    requestObserver.onCompleted();

    List<StreamingAnalyzeContentResponse> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void streamingAnalyzeContentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);
    StreamingAnalyzeContentRequest request =
        StreamingAnalyzeContentRequest.newBuilder()
            .setParticipant(
                ParticipantName.ofProjectConversationParticipantName(
                        "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]")
                    .toString())
            .setReplyAudioConfig(OutputAudioConfig.newBuilder().build())
            .setQueryParams(QueryParameters.newBuilder().build())
            .setAssistQueryParams(AssistQueryParameters.newBuilder().build())
            .setCxParameters(Struct.newBuilder().build())
            .setEnablePartialAutomatedAgentReply(true)
            .build();

    MockStreamObserver<StreamingAnalyzeContentResponse> responseObserver =
        new MockStreamObserver<>();

    BidiStreamingCallable<StreamingAnalyzeContentRequest, StreamingAnalyzeContentResponse>
        callable = client.streamingAnalyzeContentCallable();
    ApiStreamObserver<StreamingAnalyzeContentRequest> requestObserver =
        callable.bidiStreamingCall(responseObserver);

    requestObserver.onNext(request);

    try {
      List<StreamingAnalyzeContentResponse> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void suggestArticlesTest() throws Exception {
    SuggestArticlesResponse expectedResponse =
        SuggestArticlesResponse.newBuilder()
            .addAllArticleAnswers(new ArrayList<ArticleAnswer>())
            .setLatestMessage("latestMessage-1424305536")
            .setContextSize(1116903569)
            .build();
    mockParticipants.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestArticlesResponse actualResponse = client.suggestArticles(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestArticlesRequest actualRequest = ((SuggestArticlesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestArticlesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SuggestArticlesResponse actualResponse = client.suggestArticles(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestArticlesRequest actualRequest = ((SuggestArticlesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestArticlesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockParticipants.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestFaqAnswersResponse actualResponse = client.suggestFaqAnswers(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestFaqAnswersRequest actualRequest = ((SuggestFaqAnswersRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestFaqAnswersExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SuggestFaqAnswersResponse actualResponse = client.suggestFaqAnswers(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestFaqAnswersRequest actualRequest = ((SuggestFaqAnswersRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestFaqAnswersExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockParticipants.addResponse(expectedResponse);

    ParticipantName parent =
        ParticipantName.ofProjectConversationParticipantName(
            "[PROJECT]", "[CONVERSATION]", "[PARTICIPANT]");

    SuggestSmartRepliesResponse actualResponse = client.suggestSmartReplies(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestSmartRepliesRequest actualRequest = ((SuggestSmartRepliesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestSmartRepliesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

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
    mockParticipants.addResponse(expectedResponse);

    String parent = "parent-995424086";

    SuggestSmartRepliesResponse actualResponse = client.suggestSmartReplies(parent);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockParticipants.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestSmartRepliesRequest actualRequest = ((SuggestSmartRepliesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestSmartRepliesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockParticipants.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockLocations.addResponse(expectedResponse);

    ListLocationsRequest request =
        ListLocationsRequest.newBuilder()
            .setName("name3373707")
            .setFilter("filter-1274492040")
            .setPageSize(883849137)
            .setPageToken("pageToken873572522")
            .build();

    ListLocationsPagedResponse pagedListResponse = client.listLocations(request);

    List<Location> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getLocationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListLocationsRequest actualRequest = ((ListLocationsRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertEquals(request.getFilter(), actualRequest.getFilter());
    Assert.assertEquals(request.getPageSize(), actualRequest.getPageSize());
    Assert.assertEquals(request.getPageToken(), actualRequest.getPageToken());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listLocationsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      ListLocationsRequest request =
          ListLocationsRequest.newBuilder()
              .setName("name3373707")
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
    mockLocations.addResponse(expectedResponse);

    GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();

    Location actualResponse = client.getLocation(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockLocations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetLocationRequest actualRequest = ((GetLocationRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getLocationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockLocations.addException(exception);

    try {
      GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
      client.getLocation(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
