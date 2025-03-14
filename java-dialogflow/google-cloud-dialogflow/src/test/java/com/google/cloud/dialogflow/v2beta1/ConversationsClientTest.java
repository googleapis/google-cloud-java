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

package com.google.cloud.dialogflow.v2beta1;

import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListConversationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListLocationsPagedResponse;
import static com.google.cloud.dialogflow.v2beta1.ConversationsClient.ListMessagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
import com.google.protobuf.Struct;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import javax.annotation.Generated;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

@Generated("by gapic-generator-java")
public class ConversationsClientTest {
  private static MockConversations mockConversations;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ConversationsClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockConversations = new MockConversations();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockConversations, mockLocations));
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
    ConversationsSettings settings =
        ConversationsSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ConversationsClient.create(settings);
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
    mockConversations.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationRequest actualRequest = ((CreateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationRequest actualRequest = ((CreateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateConversationRequest actualRequest = ((CreateConversationRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createConversationExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConversations.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
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
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    ProjectName parent = ProjectName.of("[PROJECT]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListConversationsRequest actualRequest = ((ListConversationsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listConversationsExceptionTest3() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConversations.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
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
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
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
    mockConversations.addException(exception);

    try {
      String name = "name3373707";
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
    mockConversations.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    Conversation actualResponse = client.completeConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteConversationRequest actualRequest =
        ((CompleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.completeConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteConversationRequest actualRequest =
        ((CompleteConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String name = "name3373707";
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
    mockConversations.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectLocationConversationName(
            "[PROJECT]", "[LOCATION]", "[CONVERSATION]");
    Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();

    IngestContextReferencesResponse actualResponse =
        client.ingestContextReferences(conversation, contextReferences);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestContextReferencesRequest actualRequest =
        ((IngestContextReferencesRequest) actualRequests.get(0));

    Assert.assertEquals(conversation.toString(), actualRequest.getConversation());
    Assert.assertEquals(contextReferences, actualRequest.getContextReferencesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestContextReferencesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String conversation = "conversation740154499";
    Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();

    IngestContextReferencesResponse actualResponse =
        client.ingestContextReferences(conversation, contextReferences);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    IngestContextReferencesRequest actualRequest =
        ((IngestContextReferencesRequest) actualRequests.get(0));

    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertEquals(contextReferences, actualRequest.getContextReferencesMap());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void ingestContextReferencesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String conversation = "conversation740154499";
      Map<String, Conversation.ContextReference> contextReferences = new HashMap<>();
      client.ingestContextReferences(conversation, contextReferences);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateMessagesTest() throws Exception {
    BatchCreateMessagesResponse expectedResponse =
        BatchCreateMessagesResponse.newBuilder().addAllMessages(new ArrayList<Message>()).build();
    mockConversations.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
    List<CreateMessageRequest> requests = new ArrayList<>();

    BatchCreateMessagesResponse actualResponse = client.batchCreateMessages(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateMessagesRequest actualRequest = ((BatchCreateMessagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateMessagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      ConversationName parent =
          ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");
      List<CreateMessageRequest> requests = new ArrayList<>();
      client.batchCreateMessages(parent, requests);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void batchCreateMessagesTest2() throws Exception {
    BatchCreateMessagesResponse expectedResponse =
        BatchCreateMessagesResponse.newBuilder().addAllMessages(new ArrayList<Message>()).build();
    mockConversations.addResponse(expectedResponse);

    String parent = "parent-995424086";
    List<CreateMessageRequest> requests = new ArrayList<>();

    BatchCreateMessagesResponse actualResponse = client.batchCreateMessages(parent, requests);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    BatchCreateMessagesRequest actualRequest = ((BatchCreateMessagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(requests, actualRequest.getRequestsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void batchCreateMessagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String parent = "parent-995424086";
      List<CreateMessageRequest> requests = new ArrayList<>();
      client.batchCreateMessages(parent, requests);
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
    mockConversations.addResponse(expectedResponse);

    ConversationName parent =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessagesRequest actualRequest = ((ListMessagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessagesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMessagesRequest actualRequest = ((ListMessagesRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMessagesExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String parent = "parent-995424086";
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
    mockConversations.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    SuggestConversationSummaryResponse actualResponse =
        client.suggestConversationSummary(conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestConversationSummaryRequest actualRequest =
        ((SuggestConversationSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(conversation.toString(), actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestConversationSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String conversation = "conversation740154499";

    SuggestConversationSummaryResponse actualResponse =
        client.suggestConversationSummary(conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SuggestConversationSummaryRequest actualRequest =
        ((SuggestConversationSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void suggestConversationSummaryExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String conversation = "conversation740154499";
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
    mockConversations.addResponse(expectedResponse);

    GenerateStatelessSummaryRequest request =
        GenerateStatelessSummaryRequest.newBuilder()
            .setStatelessConversation(
                GenerateStatelessSummaryRequest.MinimalConversation.newBuilder().build())
            .setConversationProfile(ConversationProfile.newBuilder().build())
            .setLatestMessage(
                MessageName.ofProjectConversationMessageName(
                        "[PROJECT]", "[CONVERSATION]", "[MESSAGE]")
                    .toString())
            .setMaxContextSize(-1134084212)
            .build();

    GenerateStatelessSummaryResponse actualResponse = client.generateStatelessSummary(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateStatelessSummaryRequest actualRequest =
        ((GenerateStatelessSummaryRequest) actualRequests.get(0));

    Assert.assertEquals(
        request.getStatelessConversation(), actualRequest.getStatelessConversation());
    Assert.assertEquals(request.getConversationProfile(), actualRequest.getConversationProfile());
    Assert.assertEquals(request.getLatestMessage(), actualRequest.getLatestMessage());
    Assert.assertEquals(request.getMaxContextSize(), actualRequest.getMaxContextSize());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateStatelessSummaryExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      GenerateStatelessSummaryRequest request =
          GenerateStatelessSummaryRequest.newBuilder()
              .setStatelessConversation(
                  GenerateStatelessSummaryRequest.MinimalConversation.newBuilder().build())
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
    mockConversations.addResponse(expectedResponse);

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

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateStatelessSuggestionRequest actualRequest =
        ((GenerateStatelessSuggestionRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getGenerator(), actualRequest.getGenerator());
    Assert.assertEquals(request.getGeneratorName(), actualRequest.getGeneratorName());
    Assert.assertEquals(request.getContextReferencesMap(), actualRequest.getContextReferencesMap());
    Assert.assertEquals(request.getConversationContext(), actualRequest.getConversationContext());
    Assert.assertEquals(request.getTriggerEventsList(), actualRequest.getTriggerEventsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateStatelessSuggestionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    SearchKnowledgeRequest request =
        SearchKnowledgeRequest.newBuilder()
            .setParent("parent-995424086")
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

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SearchKnowledgeRequest actualRequest = ((SearchKnowledgeRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getQuery(), actualRequest.getQuery());
    Assert.assertEquals(request.getConversationProfile(), actualRequest.getConversationProfile());
    Assert.assertEquals(request.getSessionId(), actualRequest.getSessionId());
    Assert.assertEquals(request.getConversation(), actualRequest.getConversation());
    Assert.assertEquals(request.getLatestMessage(), actualRequest.getLatestMessage());
    Assert.assertEquals(request.getQuerySource(), actualRequest.getQuerySource());
    Assert.assertEquals(request.getEndUserMetadata(), actualRequest.getEndUserMetadata());
    Assert.assertEquals(request.getSearchConfig(), actualRequest.getSearchConfig());
    Assert.assertEquals(request.getExactSearch(), actualRequest.getExactSearch());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void searchKnowledgeExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      SearchKnowledgeRequest request =
          SearchKnowledgeRequest.newBuilder()
              .setParent("parent-995424086")
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
    mockConversations.addResponse(expectedResponse);

    ConversationName conversation =
        ConversationName.ofProjectConversationName("[PROJECT]", "[CONVERSATION]");

    GenerateSuggestionsResponse actualResponse = client.generateSuggestions(conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateSuggestionsRequest actualRequest = ((GenerateSuggestionsRequest) actualRequests.get(0));

    Assert.assertEquals(conversation.toString(), actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateSuggestionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

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
    mockConversations.addResponse(expectedResponse);

    String conversation = "conversation740154499";

    GenerateSuggestionsResponse actualResponse = client.generateSuggestions(conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversations.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GenerateSuggestionsRequest actualRequest = ((GenerateSuggestionsRequest) actualRequests.get(0));

    Assert.assertEquals(conversation, actualRequest.getConversation());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void generateSuggestionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversations.addException(exception);

    try {
      String conversation = "conversation740154499";
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
