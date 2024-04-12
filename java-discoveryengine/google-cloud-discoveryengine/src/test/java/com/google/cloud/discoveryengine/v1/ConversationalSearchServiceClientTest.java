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

import static com.google.cloud.discoveryengine.v1.ConversationalSearchServiceClient.ListConversationsPagedResponse;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.testing.LocalChannelProvider;
import com.google.api.gax.grpc.testing.MockGrpcService;
import com.google.api.gax.grpc.testing.MockServiceHelper;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.InvalidArgumentException;
import com.google.common.collect.Lists;
import com.google.protobuf.AbstractMessage;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Timestamp;
import io.grpc.StatusRuntimeException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
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
  public void converseConversationTest() throws Exception {
    ConverseConversationResponse expectedResponse =
        ConverseConversationResponse.newBuilder()
            .setReply(Reply.newBuilder().build())
            .setConversation(Conversation.newBuilder().build())
            .addAllSearchResults(new ArrayList<SearchResponse.SearchResult>())
            .build();
    mockConversationalSearchService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");
    TextInput query = TextInput.newBuilder().build();

    ConverseConversationResponse actualResponse = client.converseConversation(name, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConverseConversationRequest actualRequest =
        ((ConverseConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void converseConversationExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationalSearchService.addException(exception);

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
            .addAllSearchResults(new ArrayList<SearchResponse.SearchResult>())
            .build();
    mockConversationalSearchService.addResponse(expectedResponse);

    String name = "name3373707";
    TextInput query = TextInput.newBuilder().build();

    ConverseConversationResponse actualResponse = client.converseConversation(name, query);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ConverseConversationRequest actualRequest =
        ((ConverseConversationRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertEquals(query, actualRequest.getQuery());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void converseConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationalSearchService.addException(exception);

    try {
      String name = "name3373707";
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
    mockConversationalSearchService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
    mockConversationalSearchService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Conversation conversation = Conversation.newBuilder().build();

    Conversation actualResponse = client.createConversation(parent, conversation);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
  public void createConversationExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockConversationalSearchService.addException(exception);

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
  public void deleteConversationTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockConversationalSearchService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
    mockConversationalSearchService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteConversation(name);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

    try {
      String name = "name3373707";
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
    mockConversationalSearchService.addResponse(expectedResponse);

    Conversation conversation = Conversation.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Conversation actualResponse = client.updateConversation(conversation, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
                ConversationName.ofProjectLocationDataStoreConversationName(
                        "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]")
                    .toString())
            .setUserPseudoId("userPseudoId-1155274652")
            .addAllMessages(new ArrayList<ConversationMessage>())
            .setStartTime(Timestamp.newBuilder().build())
            .setEndTime(Timestamp.newBuilder().build())
            .build();
    mockConversationalSearchService.addResponse(expectedResponse);

    ConversationName name =
        ConversationName.ofProjectLocationDataStoreConversationName(
            "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[CONVERSATION]");

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
    mockConversationalSearchService.addResponse(expectedResponse);

    String name = "name3373707";

    Conversation actualResponse = client.getConversation(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
    mockConversationalSearchService.addResponse(expectedResponse);

    DataStoreName parent =
        DataStoreName.ofProjectLocationDataStoreName("[PROJECT]", "[LOCATION]", "[DATA_STORE]");

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

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
    mockConversationalSearchService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListConversationsPagedResponse pagedListResponse = client.listConversations(parent);

    List<Conversation> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getConversationsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockConversationalSearchService.getRequests();
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
    mockConversationalSearchService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listConversations(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
