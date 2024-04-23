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

package com.google.chat.v1;

import static com.google.chat.v1.ChatServiceClient.ListMembershipsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListMessagesPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListReactionsPagedResponse;
import static com.google.chat.v1.ChatServiceClient.ListSpacesPagedResponse;

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
public class ChatServiceClientTest {
  private static MockChatService mockChatService;
  private static MockServiceHelper mockServiceHelper;
  private LocalChannelProvider channelProvider;
  private ChatServiceClient client;

  @BeforeClass
  public static void startStaticServer() {
    mockChatService = new MockChatService();
    mockServiceHelper =
        new MockServiceHelper(
            UUID.randomUUID().toString(), Arrays.<MockGrpcService>asList(mockChatService));
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
    ChatServiceSettings settings =
        ChatServiceSettings.newBuilder()
            .setTransportChannelProvider(channelProvider)
            .setCredentialsProvider(NoCredentialsProvider.create())
            .build();
    client = ChatServiceClient.create(settings);
  }

  @After
  public void tearDown() throws Exception {
    client.close();
  }

  @Test
  public void createMessageTest() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
            .setSender(User.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setText("text3556653")
            .setFormattedText("formattedText-1717326839")
            .addAllCards(new ArrayList<ContextualAddOnMarkup.Card>())
            .addAllCardsV2(new ArrayList<CardWithId>())
            .addAllAnnotations(new ArrayList<Annotation>())
            .setThread(Thread.newBuilder().build())
            .setSpace(Space.newBuilder().build())
            .setFallbackText("fallbackText-1783292113")
            .setActionResponse(ActionResponse.newBuilder().build())
            .setArgumentText("argumentText552563082")
            .setSlashCommand(SlashCommand.newBuilder().build())
            .addAllAttachment(new ArrayList<Attachment>())
            .setMatchedUrl(MatchedUrl.newBuilder().build())
            .setThreadReply(true)
            .setClientAssignedMessageId("clientAssignedMessageId-750462775")
            .addAllEmojiReactionSummaries(new ArrayList<EmojiReactionSummary>())
            .setPrivateMessageViewer(User.newBuilder().build())
            .setDeletionMetadata(DeletionMetadata.newBuilder().build())
            .setQuotedMessageMetadata(QuotedMessageMetadata.newBuilder().build())
            .addAllAttachedGifs(new ArrayList<AttachedGif>())
            .addAllAccessoryWidgets(new ArrayList<AccessoryWidget>())
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");
    Message message = Message.newBuilder().build();
    String messageId = "messageId-1440013438";

    Message actualResponse = client.createMessage(parent, message, messageId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMessageRequest actualRequest = ((CreateMessageRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(message, actualRequest.getMessage());
    Assert.assertEquals(messageId, actualRequest.getMessageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
      Message message = Message.newBuilder().build();
      String messageId = "messageId-1440013438";
      client.createMessage(parent, message, messageId);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMessageTest2() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
            .setSender(User.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setText("text3556653")
            .setFormattedText("formattedText-1717326839")
            .addAllCards(new ArrayList<ContextualAddOnMarkup.Card>())
            .addAllCardsV2(new ArrayList<CardWithId>())
            .addAllAnnotations(new ArrayList<Annotation>())
            .setThread(Thread.newBuilder().build())
            .setSpace(Space.newBuilder().build())
            .setFallbackText("fallbackText-1783292113")
            .setActionResponse(ActionResponse.newBuilder().build())
            .setArgumentText("argumentText552563082")
            .setSlashCommand(SlashCommand.newBuilder().build())
            .addAllAttachment(new ArrayList<Attachment>())
            .setMatchedUrl(MatchedUrl.newBuilder().build())
            .setThreadReply(true)
            .setClientAssignedMessageId("clientAssignedMessageId-750462775")
            .addAllEmojiReactionSummaries(new ArrayList<EmojiReactionSummary>())
            .setPrivateMessageViewer(User.newBuilder().build())
            .setDeletionMetadata(DeletionMetadata.newBuilder().build())
            .setQuotedMessageMetadata(QuotedMessageMetadata.newBuilder().build())
            .addAllAttachedGifs(new ArrayList<AttachedGif>())
            .addAllAccessoryWidgets(new ArrayList<AccessoryWidget>())
            .build();
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Message message = Message.newBuilder().build();
    String messageId = "messageId-1440013438";

    Message actualResponse = client.createMessage(parent, message, messageId);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMessageRequest actualRequest = ((CreateMessageRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(message, actualRequest.getMessage());
    Assert.assertEquals(messageId, actualRequest.getMessageId());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMessageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      Message message = Message.newBuilder().build();
      String messageId = "messageId-1440013438";
      client.createMessage(parent, message, messageId);
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
    mockChatService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
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
    mockChatService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
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
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMessagesPagedResponse pagedListResponse = client.listMessages(parent);

    List<Message> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMessagesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
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
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMessages(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipsTest() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListMembershipsResponse expectedResponse =
        ListMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemberships(Arrays.asList(responsesElement))
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembershipsRequest actualRequest = ((ListMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMembershipsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
      client.listMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listMembershipsTest2() throws Exception {
    Membership responsesElement = Membership.newBuilder().build();
    ListMembershipsResponse expectedResponse =
        ListMembershipsResponse.newBuilder()
            .setNextPageToken("")
            .addAllMemberships(Arrays.asList(responsesElement))
            .build();
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListMembershipsPagedResponse pagedListResponse = client.listMemberships(parent);

    List<Membership> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getMembershipsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListMembershipsRequest actualRequest = ((ListMembershipsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listMembershipsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listMemberships(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");

    Membership actualResponse = client.getMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMembershipRequest actualRequest = ((GetMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");
      client.getMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Membership actualResponse = client.getMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMembershipRequest actualRequest = ((GetMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMembershipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMessageTest() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
            .setSender(User.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setText("text3556653")
            .setFormattedText("formattedText-1717326839")
            .addAllCards(new ArrayList<ContextualAddOnMarkup.Card>())
            .addAllCardsV2(new ArrayList<CardWithId>())
            .addAllAnnotations(new ArrayList<Annotation>())
            .setThread(Thread.newBuilder().build())
            .setSpace(Space.newBuilder().build())
            .setFallbackText("fallbackText-1783292113")
            .setActionResponse(ActionResponse.newBuilder().build())
            .setArgumentText("argumentText552563082")
            .setSlashCommand(SlashCommand.newBuilder().build())
            .addAllAttachment(new ArrayList<Attachment>())
            .setMatchedUrl(MatchedUrl.newBuilder().build())
            .setThreadReply(true)
            .setClientAssignedMessageId("clientAssignedMessageId-750462775")
            .addAllEmojiReactionSummaries(new ArrayList<EmojiReactionSummary>())
            .setPrivateMessageViewer(User.newBuilder().build())
            .setDeletionMetadata(DeletionMetadata.newBuilder().build())
            .setQuotedMessageMetadata(QuotedMessageMetadata.newBuilder().build())
            .addAllAttachedGifs(new ArrayList<AttachedGif>())
            .addAllAccessoryWidgets(new ArrayList<AccessoryWidget>())
            .build();
    mockChatService.addResponse(expectedResponse);

    MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");

    Message actualResponse = client.getMessage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMessageRequest actualRequest = ((GetMessageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");
      client.getMessage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getMessageTest2() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
            .setSender(User.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setText("text3556653")
            .setFormattedText("formattedText-1717326839")
            .addAllCards(new ArrayList<ContextualAddOnMarkup.Card>())
            .addAllCardsV2(new ArrayList<CardWithId>())
            .addAllAnnotations(new ArrayList<Annotation>())
            .setThread(Thread.newBuilder().build())
            .setSpace(Space.newBuilder().build())
            .setFallbackText("fallbackText-1783292113")
            .setActionResponse(ActionResponse.newBuilder().build())
            .setArgumentText("argumentText552563082")
            .setSlashCommand(SlashCommand.newBuilder().build())
            .addAllAttachment(new ArrayList<Attachment>())
            .setMatchedUrl(MatchedUrl.newBuilder().build())
            .setThreadReply(true)
            .setClientAssignedMessageId("clientAssignedMessageId-750462775")
            .addAllEmojiReactionSummaries(new ArrayList<EmojiReactionSummary>())
            .setPrivateMessageViewer(User.newBuilder().build())
            .setDeletionMetadata(DeletionMetadata.newBuilder().build())
            .setQuotedMessageMetadata(QuotedMessageMetadata.newBuilder().build())
            .addAllAttachedGifs(new ArrayList<AttachedGif>())
            .addAllAccessoryWidgets(new ArrayList<AccessoryWidget>())
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Message actualResponse = client.getMessage(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetMessageRequest actualRequest = ((GetMessageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getMessageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getMessage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMessageTest() throws Exception {
    Message expectedResponse =
        Message.newBuilder()
            .setName(MessageName.of("[SPACE]", "[MESSAGE]").toString())
            .setSender(User.newBuilder().build())
            .setCreateTime(Timestamp.newBuilder().build())
            .setLastUpdateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .setText("text3556653")
            .setFormattedText("formattedText-1717326839")
            .addAllCards(new ArrayList<ContextualAddOnMarkup.Card>())
            .addAllCardsV2(new ArrayList<CardWithId>())
            .addAllAnnotations(new ArrayList<Annotation>())
            .setThread(Thread.newBuilder().build())
            .setSpace(Space.newBuilder().build())
            .setFallbackText("fallbackText-1783292113")
            .setActionResponse(ActionResponse.newBuilder().build())
            .setArgumentText("argumentText552563082")
            .setSlashCommand(SlashCommand.newBuilder().build())
            .addAllAttachment(new ArrayList<Attachment>())
            .setMatchedUrl(MatchedUrl.newBuilder().build())
            .setThreadReply(true)
            .setClientAssignedMessageId("clientAssignedMessageId-750462775")
            .addAllEmojiReactionSummaries(new ArrayList<EmojiReactionSummary>())
            .setPrivateMessageViewer(User.newBuilder().build())
            .setDeletionMetadata(DeletionMetadata.newBuilder().build())
            .setQuotedMessageMetadata(QuotedMessageMetadata.newBuilder().build())
            .addAllAttachedGifs(new ArrayList<AttachedGif>())
            .addAllAccessoryWidgets(new ArrayList<AccessoryWidget>())
            .build();
    mockChatService.addResponse(expectedResponse);

    Message message = Message.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Message actualResponse = client.updateMessage(message, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMessageRequest actualRequest = ((UpdateMessageRequest) actualRequests.get(0));

    Assert.assertEquals(message, actualRequest.getMessage());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      Message message = Message.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMessage(message, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMessageTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");

    client.deleteMessage(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMessageRequest actualRequest = ((DeleteMessageRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MessageName name = MessageName.of("[SPACE]", "[MESSAGE]");
      client.deleteMessage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMessageTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteMessage(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMessageRequest actualRequest = ((DeleteMessageRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMessageExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMessage(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]").toString())
            .setContentName("contentName-389333340")
            .setContentType("contentType-389131437")
            .setThumbnailUri("thumbnailUri-356760352")
            .setDownloadUri("downloadUri-1211148348")
            .build();
    mockChatService.addResponse(expectedResponse);

    AttachmentName name = AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]");

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachmentRequest actualRequest = ((GetAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      AttachmentName name = AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]");
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getAttachmentTest2() throws Exception {
    Attachment expectedResponse =
        Attachment.newBuilder()
            .setName(AttachmentName.of("[SPACE]", "[MESSAGE]", "[ATTACHMENT]").toString())
            .setContentName("contentName-389333340")
            .setContentType("contentType-389131437")
            .setThumbnailUri("thumbnailUri-356760352")
            .setDownloadUri("downloadUri-1211148348")
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Attachment actualResponse = client.getAttachment(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetAttachmentRequest actualRequest = ((GetAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getAttachmentExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getAttachment(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void uploadAttachmentTest() throws Exception {
    UploadAttachmentResponse expectedResponse =
        UploadAttachmentResponse.newBuilder()
            .setAttachmentDataRef(AttachmentDataRef.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    UploadAttachmentRequest request =
        UploadAttachmentRequest.newBuilder()
            .setParent(SpaceName.of("[SPACE]").toString())
            .setFilename("filename-734768633")
            .build();

    UploadAttachmentResponse actualResponse = client.uploadAttachment(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UploadAttachmentRequest actualRequest = ((UploadAttachmentRequest) actualRequests.get(0));

    Assert.assertEquals(request.getParent(), actualRequest.getParent());
    Assert.assertEquals(request.getFilename(), actualRequest.getFilename());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void uploadAttachmentExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      UploadAttachmentRequest request =
          UploadAttachmentRequest.newBuilder()
              .setParent(SpaceName.of("[SPACE]").toString())
              .setFilename("filename-734768633")
              .build();
      client.uploadAttachment(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listSpacesTest() throws Exception {
    Space responsesElement = Space.newBuilder().build();
    ListSpacesResponse expectedResponse =
        ListSpacesResponse.newBuilder()
            .setNextPageToken("")
            .addAllSpaces(Arrays.asList(responsesElement))
            .build();
    mockChatService.addResponse(expectedResponse);

    ListSpacesPagedResponse pagedListResponse = client.listSpaces();

    List<Space> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getSpacesList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListSpacesRequest actualRequest = ((ListSpacesRequest) actualRequests.get(0));

    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listSpacesExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      ListSpacesRequest request =
          ListSpacesRequest.newBuilder()
              .setPageSize(883849137)
              .setPageToken("pageToken873572522")
              .setFilter("filter-1274492040")
              .build();
      client.listSpaces(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceTest2() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Space actualResponse = client.getSpace(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceRequest actualRequest = ((GetSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();

    Space actualResponse = client.createSpace(space);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateSpaceRequest actualRequest = ((CreateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      client.createSpace(space);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void setUpSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    SetUpSpaceRequest request =
        SetUpSpaceRequest.newBuilder()
            .setSpace(Space.newBuilder().build())
            .setRequestId("requestId693933066")
            .addAllMemberships(new ArrayList<Membership>())
            .build();

    Space actualResponse = client.setUpSpace(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    SetUpSpaceRequest actualRequest = ((SetUpSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getSpace(), actualRequest.getSpace());
    Assert.assertEquals(request.getRequestId(), actualRequest.getRequestId());
    Assert.assertEquals(request.getMembershipsList(), actualRequest.getMembershipsList());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void setUpSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SetUpSpaceRequest request =
          SetUpSpaceRequest.newBuilder()
              .setSpace(Space.newBuilder().build())
              .setRequestId("requestId693933066")
              .addAllMemberships(new ArrayList<Membership>())
              .build();
      client.setUpSpace(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    Space space = Space.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Space actualResponse = client.updateSpace(space, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpaceRequest actualRequest = ((UpdateSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(space, actualRequest.getSpace());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      Space space = Space.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpace(space, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpaceTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    SpaceName name = SpaceName.of("[SPACE]");

    client.deleteSpace(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpaceRequest actualRequest = ((DeleteSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceName name = SpaceName.of("[SPACE]");
      client.deleteSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteSpaceTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteSpace(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteSpaceRequest actualRequest = ((DeleteSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteSpaceExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteSpace(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void completeImportSpaceTest() throws Exception {
    CompleteImportSpaceResponse expectedResponse =
        CompleteImportSpaceResponse.newBuilder().setSpace(Space.newBuilder().build()).build();
    mockChatService.addResponse(expectedResponse);

    CompleteImportSpaceRequest request =
        CompleteImportSpaceRequest.newBuilder().setName(SpaceName.of("[SPACE]").toString()).build();

    CompleteImportSpaceResponse actualResponse = client.completeImportSpace(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CompleteImportSpaceRequest actualRequest = ((CompleteImportSpaceRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void completeImportSpaceExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      CompleteImportSpaceRequest request =
          CompleteImportSpaceRequest.newBuilder()
              .setName(SpaceName.of("[SPACE]").toString())
              .build();
      client.completeImportSpace(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void findDirectMessageTest() throws Exception {
    Space expectedResponse =
        Space.newBuilder()
            .setName(SpaceName.of("[SPACE]").toString())
            .setSingleUserBotDm(true)
            .setThreaded(true)
            .setDisplayName("displayName1714148973")
            .setExternalUserAllowed(true)
            .setSpaceDetails(Space.SpaceDetails.newBuilder().build())
            .setSpaceHistoryState(HistoryState.forNumber(0))
            .setImportMode(true)
            .setCreateTime(Timestamp.newBuilder().build())
            .setAdminInstalled(true)
            .build();
    mockChatService.addResponse(expectedResponse);

    FindDirectMessageRequest request =
        FindDirectMessageRequest.newBuilder().setName("name3373707").build();

    Space actualResponse = client.findDirectMessage(request);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    FindDirectMessageRequest actualRequest = ((FindDirectMessageRequest) actualRequests.get(0));

    Assert.assertEquals(request.getName(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void findDirectMessageExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      FindDirectMessageRequest request =
          FindDirectMessageRequest.newBuilder().setName("name3373707").build();
      client.findDirectMessage(request);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceName parent = SpaceName.of("[SPACE]");
    Membership membership = Membership.newBuilder().build();

    Membership actualResponse = client.createMembership(parent, membership);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMembershipRequest actualRequest = ((CreateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(membership, actualRequest.getMembership());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceName parent = SpaceName.of("[SPACE]");
      Membership membership = Membership.newBuilder().build();
      client.createMembership(parent, membership);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Membership membership = Membership.newBuilder().build();

    Membership actualResponse = client.createMembership(parent, membership);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateMembershipRequest actualRequest = ((CreateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(membership, actualRequest.getMembership());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createMembershipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      Membership membership = Membership.newBuilder().build();
      client.createMembership(parent, membership);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    Membership membership = Membership.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    Membership actualResponse = client.updateMembership(membership, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateMembershipRequest actualRequest = ((UpdateMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(membership, actualRequest.getMembership());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      Membership membership = Membership.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateMembership(membership, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMembershipTest() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");

    Membership actualResponse = client.deleteMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMembershipRequest actualRequest = ((DeleteMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMembershipExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MembershipName name = MembershipName.of("[SPACE]", "[MEMBER]");
      client.deleteMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteMembershipTest2() throws Exception {
    Membership expectedResponse =
        Membership.newBuilder()
            .setName(MembershipName.of("[SPACE]", "[MEMBER]").toString())
            .setCreateTime(Timestamp.newBuilder().build())
            .setDeleteTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    Membership actualResponse = client.deleteMembership(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteMembershipRequest actualRequest = ((DeleteMembershipRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteMembershipExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteMembership(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReactionTest() throws Exception {
    Reaction expectedResponse =
        Reaction.newBuilder()
            .setName(ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]").toString())
            .setUser(User.newBuilder().build())
            .setEmoji(Emoji.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");
    Reaction reaction = Reaction.newBuilder().build();

    Reaction actualResponse = client.createReaction(parent, reaction);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReactionRequest actualRequest = ((CreateReactionRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertEquals(reaction, actualRequest.getReaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");
      Reaction reaction = Reaction.newBuilder().build();
      client.createReaction(parent, reaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void createReactionTest2() throws Exception {
    Reaction expectedResponse =
        Reaction.newBuilder()
            .setName(ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]").toString())
            .setUser(User.newBuilder().build())
            .setEmoji(Emoji.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";
    Reaction reaction = Reaction.newBuilder().build();

    Reaction actualResponse = client.createReaction(parent, reaction);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    CreateReactionRequest actualRequest = ((CreateReactionRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertEquals(reaction, actualRequest.getReaction());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void createReactionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      Reaction reaction = Reaction.newBuilder().build();
      client.createReaction(parent, reaction);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReactionsTest() throws Exception {
    Reaction responsesElement = Reaction.newBuilder().build();
    ListReactionsResponse expectedResponse =
        ListReactionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReactions(Arrays.asList(responsesElement))
            .build();
    mockChatService.addResponse(expectedResponse);

    MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");

    ListReactionsPagedResponse pagedListResponse = client.listReactions(parent);

    List<Reaction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReactionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReactionsRequest actualRequest = ((ListReactionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent.toString(), actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReactionsExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      MessageName parent = MessageName.of("[SPACE]", "[MESSAGE]");
      client.listReactions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void listReactionsTest2() throws Exception {
    Reaction responsesElement = Reaction.newBuilder().build();
    ListReactionsResponse expectedResponse =
        ListReactionsResponse.newBuilder()
            .setNextPageToken("")
            .addAllReactions(Arrays.asList(responsesElement))
            .build();
    mockChatService.addResponse(expectedResponse);

    String parent = "parent-995424086";

    ListReactionsPagedResponse pagedListResponse = client.listReactions(parent);

    List<Reaction> resources = Lists.newArrayList(pagedListResponse.iterateAll());

    Assert.assertEquals(1, resources.size());
    Assert.assertEquals(expectedResponse.getReactionsList().get(0), resources.get(0));

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    ListReactionsRequest actualRequest = ((ListReactionsRequest) actualRequests.get(0));

    Assert.assertEquals(parent, actualRequest.getParent());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void listReactionsExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String parent = "parent-995424086";
      client.listReactions(parent);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReactionTest() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    ReactionName name = ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]");

    client.deleteReaction(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReactionRequest actualRequest = ((DeleteReactionRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReactionExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      ReactionName name = ReactionName.of("[SPACE]", "[MESSAGE]", "[REACTION]");
      client.deleteReaction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void deleteReactionTest2() throws Exception {
    Empty expectedResponse = Empty.newBuilder().build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    client.deleteReaction(name);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    DeleteReactionRequest actualRequest = ((DeleteReactionRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void deleteReactionExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.deleteReaction(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceReadStateTest() throws Exception {
    SpaceReadState expectedResponse =
        SpaceReadState.newBuilder()
            .setName(SpaceReadStateName.of("[USER]", "[SPACE]").toString())
            .setLastReadTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceReadStateName name = SpaceReadStateName.of("[USER]", "[SPACE]");

    SpaceReadState actualResponse = client.getSpaceReadState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceReadStateRequest actualRequest = ((GetSpaceReadStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceReadStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceReadStateName name = SpaceReadStateName.of("[USER]", "[SPACE]");
      client.getSpaceReadState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getSpaceReadStateTest2() throws Exception {
    SpaceReadState expectedResponse =
        SpaceReadState.newBuilder()
            .setName(SpaceReadStateName.of("[USER]", "[SPACE]").toString())
            .setLastReadTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    SpaceReadState actualResponse = client.getSpaceReadState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetSpaceReadStateRequest actualRequest = ((GetSpaceReadStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getSpaceReadStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getSpaceReadState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void updateSpaceReadStateTest() throws Exception {
    SpaceReadState expectedResponse =
        SpaceReadState.newBuilder()
            .setName(SpaceReadStateName.of("[USER]", "[SPACE]").toString())
            .setLastReadTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    SpaceReadState spaceReadState = SpaceReadState.newBuilder().build();
    FieldMask updateMask = FieldMask.newBuilder().build();

    SpaceReadState actualResponse = client.updateSpaceReadState(spaceReadState, updateMask);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    UpdateSpaceReadStateRequest actualRequest =
        ((UpdateSpaceReadStateRequest) actualRequests.get(0));

    Assert.assertEquals(spaceReadState, actualRequest.getSpaceReadState());
    Assert.assertEquals(updateMask, actualRequest.getUpdateMask());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void updateSpaceReadStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      SpaceReadState spaceReadState = SpaceReadState.newBuilder().build();
      FieldMask updateMask = FieldMask.newBuilder().build();
      client.updateSpaceReadState(spaceReadState, updateMask);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getThreadReadStateTest() throws Exception {
    ThreadReadState expectedResponse =
        ThreadReadState.newBuilder()
            .setName(ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]").toString())
            .setLastReadTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    ThreadReadStateName name = ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]");

    ThreadReadState actualResponse = client.getThreadReadState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetThreadReadStateRequest actualRequest = ((GetThreadReadStateRequest) actualRequests.get(0));

    Assert.assertEquals(name.toString(), actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getThreadReadStateExceptionTest() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      ThreadReadStateName name = ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]");
      client.getThreadReadState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }

  @Test
  public void getThreadReadStateTest2() throws Exception {
    ThreadReadState expectedResponse =
        ThreadReadState.newBuilder()
            .setName(ThreadReadStateName.of("[USER]", "[SPACE]", "[THREAD]").toString())
            .setLastReadTime(Timestamp.newBuilder().build())
            .build();
    mockChatService.addResponse(expectedResponse);

    String name = "name3373707";

    ThreadReadState actualResponse = client.getThreadReadState(name);
    Assert.assertEquals(expectedResponse, actualResponse);

    List<AbstractMessage> actualRequests = mockChatService.getRequests();
    Assert.assertEquals(1, actualRequests.size());
    GetThreadReadStateRequest actualRequest = ((GetThreadReadStateRequest) actualRequests.get(0));

    Assert.assertEquals(name, actualRequest.getName());
    Assert.assertTrue(
        channelProvider.isHeaderSent(
            ApiClientHeaderProvider.getDefaultApiClientHeaderKey(),
            GaxGrpcProperties.getDefaultApiClientHeaderPattern()));
  }

  @Test
  public void getThreadReadStateExceptionTest2() throws Exception {
    StatusRuntimeException exception = new StatusRuntimeException(io.grpc.Status.INVALID_ARGUMENT);
    mockChatService.addException(exception);

    try {
      String name = "name3373707";
      client.getThreadReadState(name);
      Assert.fail("No exception raised");
    } catch (InvalidArgumentException e) {
      // Expected exception.
    }
  }
}
