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

package com.google.cloud.geminidataanalytics.v1beta;

import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListConversationsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.geminidataanalytics.v1beta.DataChatServiceClient.ListMessagesPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.grpc.testing.MockStreamObserver;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Any;
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
public class DataChatServiceClientTest {
  private static MockDataChatService mockDataChatService;
  private static MockLocations mockLocations;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private DataChatServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockDataChatService = new MockDataChatService();
    mockLocations = new MockLocations();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(),
            Arrays.<MockGrpcService>asList(mockDataChatService, mockLocations));
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
    DataChatServiceSettings settings =
        DataChatServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = DataChatServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void chatTest() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setTimestamp(Timestamp.newBuilder().build())
            .setMessageId("messageId-1440013438")
            .build();
    mockDataChatService.addResponse(expectedResponse);
    ChatRequest request =
        ChatRequest.newBuilder()
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setParent("parent-995424086")
            .addAllMessages(new ArrayList<Message>())
            .build();

    MockStreamObserver<Message> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ChatRequest, Message> callable = client.chatCallable();
    callable.serverStreamingCall(request, responseObserver);

    List<Message> actualResponses = responseObserver.future().get();
    Assert.assertEquals(1, actualResponses.size());
    Assert.assertEquals(expectedResponse, actualResponses.get(0));
  }

  @Test
  public void chatExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockDataChatService.addException(exception);
    ChatRequest request =
        ChatRequest.newBuilder()
            .setProject(ProjectName.of("[PROJECT]").toString())
            .setParent("parent-995424086")
            .addAllMessages(new ArrayList<Message>())
            .build();

    MockStreamObserver<Message> responseObserver = new MockStreamObserver<>();

    ServerStreamingCallable<ChatRequest, Message> callable = client.chatCallable();
    callable.serverStreamingCall(request, responseObserver);

    try {
      List<Message> actualResponses = responseObserver.future().get();
      Assert.fail("No exception thrown");
    } catch (ExecutionException e) {
      Assert.assertTrue(e.getCause() instanceof InvalidArgumentException);
      InvalidArgumentException apiException = ((InvalidArgumentException) e.getCause());
      Assert.assertEquals(StatusCode.Code.INVALID_ARGUMENT, apiException.getStatusCode().getCode());
    }
  }

  @Test
  public void createConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
            .addAllAgents(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUsedTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDataChatService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

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
            .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
            .addAllAgents(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUsedTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDataChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Conversation conversation = Conversation.newBuilder().build();
    String conversationId = "conversationId-1676095234";

    Conversation actualResponse = client.createConversation(parent, conversation, conversationId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

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
  public void getConversationTest() throws Exception {
    Conversation expectedResponse =
        Conversation.newBuilder()
            .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
            .addAllAgents(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUsedTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDataChatService.addResponse(expectedResponse);

    ConversationName name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

    try {
      ConversationName name = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
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
            .setName(ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]").toString())
            .addAllAgents(new ArrayList<String>())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUsedTime(Timestamp.newBuilder().build())
            .putAllLabels(new HashMap<String, String>())
            .build();
    mockDataChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

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
    mockDataChatService.addResponse(expectedResponse);

    LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

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
    mockDataChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessagesTest() throws Exception {
    StorageMessage responsesElement = StorageMessage.newBuilder().build();
    ListMessagesResponse expectedResponse =
        ListMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessages(Arrays.asList(responsesElement))
            .build();
    mockDataChatService.addResponse(expectedResponse);

    ConversationName parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<StorageMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

    try {
      ConversationName parent = ConversationName.of("[PROJECT]", "[LOCATION]", "[CONVERSATION]");
      client.listMessages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMessagesTest2() throws Exception {
    StorageMessage responsesElement = StorageMessage.newBuilder().build();
    ListMessagesResponse expectedResponse =
        ListMessagesResponse.newBuilder()
            .setNextPageToken("")
            .addAllMessages(Arrays.asList(responsesElement))
            .build();
    mockDataChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<StorageMessage> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockDataChatService.getRequests();
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
    mockDataChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMessages(parent);
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
