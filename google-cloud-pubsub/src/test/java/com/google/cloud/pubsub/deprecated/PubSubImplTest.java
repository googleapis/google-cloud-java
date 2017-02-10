/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.pubsub.deprecated;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.google.cloud.AsyncPage;
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.RetryParams;
import com.google.cloud.Role;
import com.google.cloud.pubsub.deprecated.MessageConsumerImplTest.TestPullFuture;
import com.google.cloud.pubsub.deprecated.PubSub.ListOption;
import com.google.cloud.pubsub.deprecated.PubSub.MessageConsumer;
import com.google.cloud.pubsub.deprecated.PubSub.MessageProcessor;
import com.google.cloud.pubsub.deprecated.PubSub.PullOption;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullCallback;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpc.PullFuture;
import com.google.cloud.pubsub.deprecated.spi.PubSubRpcFactory;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.AcknowledgeRequest;
import com.google.pubsub.v1.DeleteSubscriptionRequest;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetSubscriptionRequest;
import com.google.pubsub.v1.GetTopicRequest;
import com.google.pubsub.v1.ListSubscriptionsRequest;
import com.google.pubsub.v1.ListSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicSubscriptionsRequest;
import com.google.pubsub.v1.ListTopicSubscriptionsResponse;
import com.google.pubsub.v1.ListTopicsRequest;
import com.google.pubsub.v1.ListTopicsResponse;
import com.google.pubsub.v1.ModifyAckDeadlineRequest;
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import com.google.pubsub.v1.PullRequest;
import com.google.pubsub.v1.PullResponse;
import com.google.pubsub.v1.SubscriptionName;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.easymock.IAnswer;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class PubSubImplTest {

  private static final String PROJECT = "project";
  private static final String PROJECT_PB = "projects/project";
  private static final String TOPIC = "topic";
  private static final String TOPIC_NAME_PB = "projects/project/topics/topic";
  private static final TopicInfo TOPIC_INFO = TopicInfo.of(TOPIC);
  private static final Function<TopicInfo, com.google.pubsub.v1.Topic> TOPIC_TO_PB_FUNCTION =
      new Function<TopicInfo, com.google.pubsub.v1.Topic>() {
        @Override
        public com.google.pubsub.v1.Topic apply(TopicInfo topicInfo) {
          return topicInfo.toPb(PROJECT);
        }
      };
  private static final Message MESSAGE = Message.of("payload");
  private static final String SUBSCRIPTION = "subscription";
  private static final String SUBSCRIPTION_NAME_PB = "projects/project/subscriptions/subscription";
  private static final PushConfig PUSH_CONFIG = PushConfig.of("endpoint");
  private static final SubscriptionInfo SUBSCRIPTION_INFO =
      SubscriptionInfo.newBuilder(TOPIC, SUBSCRIPTION)
          .setAckDeadLineSeconds(42)
          .setPushConfig(PUSH_CONFIG)
          .build();
  private static final SubscriptionInfo COMPLETE_SUBSCRIPTION_INFO =
      SubscriptionInfo.newBuilder(TopicId.of(PROJECT, TOPIC), SUBSCRIPTION)
          .setAckDeadLineSeconds(42)
          .setPushConfig(PUSH_CONFIG)
          .build();
  private static final Message MESSAGE1 = Message.of("payload1");
  private static final com.google.pubsub.v1.ReceivedMessage MESSAGE_PB1 =
      com.google.pubsub.v1.ReceivedMessage.newBuilder()
          .setMessage(MESSAGE1.toPb())
          .setAckId("ackId1")
          .build();
  private static final Message MESSAGE2 = Message.of("payload2");
  private static final com.google.pubsub.v1.ReceivedMessage MESSAGE_PB2 =
      com.google.pubsub.v1.ReceivedMessage.newBuilder()
          .setMessage(MESSAGE2.toPb())
          .setAckId("ackId2")
          .build();
  private static final Policy POLICY = Policy.newBuilder()
      .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
      .build();
  private static final com.google.iam.v1.Policy POLICY_PB = PolicyMarshaller.INSTANCE.toPb(POLICY);
  private static final Function<SubscriptionInfo, com.google.pubsub.v1.Subscription>
      SUBSCRIPTION_TO_PB_FUNCTION =
          new Function<SubscriptionInfo, com.google.pubsub.v1.Subscription>() {
            @Override
            public com.google.pubsub.v1.Subscription apply(SubscriptionInfo subscriptionInfo) {
              return subscriptionInfo.toPb(PROJECT);
            }
          };
  private static final Function<SubscriptionId, String> SUBSCRIPTION_ID_TO_PB_FUNCTION =
      new Function<SubscriptionId, String>() {
        @Override
        public String apply(SubscriptionId subscriptionId) {
          return SubscriptionName.create(subscriptionId.getProject(),
              subscriptionId.getSubscription()).toString();
        }
      };
  private static final MessageProcessor DO_NOTHING = new MessageProcessor() {
    @Override
    public void process(Message message) throws Exception {
      // do nothing
    }
  };

  private PubSubOptions options;
  private PubSubRpcFactory rpcFactoryMock;
  private PubSubRpc pubsubRpcMock;
  private AckDeadlineRenewer renewerMock;
  private PubSub pubsub;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  @SuppressWarnings("unchecked")
  public void setUp() {
    rpcFactoryMock = EasyMock.createStrictMock(PubSubRpcFactory.class);
    pubsubRpcMock = EasyMock.createStrictMock(PubSubRpc.class);
    renewerMock = EasyMock.createStrictMock(AckDeadlineRenewer.class);
    options = EasyMock.createMock(PubSubOptions.class);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpcMock).anyTimes();
    EasyMock.expect(options.getRetryParams()).andReturn(RetryParams.noRetries()).anyTimes();
    EasyMock.replay(rpcFactoryMock, pubsubRpcMock, renewerMock, options);
    EasyMock.reset(pubsubRpcMock, renewerMock);
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, pubsubRpcMock, renewerMock, options);
  }

  private void resetOptionsForList(int pageCount) {
    EasyMock.reset(options);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).times(pageCount);
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpcMock).times(pageCount);
    EasyMock.expect(options.getService()).andReturn(pubsub).times(pageCount);
    EasyMock.replay(options);
  }

  @Test
  public void testGetOptions() {
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertSame(options, pubsub.getOptions());
  }

  @Test
  public void testCreateTopic() {
    com.google.pubsub.v1.Topic topicPb = TOPIC_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Topic> response = Futures.immediateFuture(topicPb);
    EasyMock.expect(pubsubRpcMock.create(topicPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Topic topic = pubsub.create(TOPIC_INFO);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testCreateTopicAsync() throws ExecutionException, InterruptedException {
    com.google.pubsub.v1.Topic topicPb = TOPIC_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Topic> response = Futures.immediateFuture(topicPb);
    EasyMock.expect(pubsubRpcMock.create(topicPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Topic topic = pubsub.createAsync(TOPIC_INFO).get();
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testGetTopic() {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> response =
        Futures.immediateFuture(TOPIC_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Topic topic = pubsub.getTopic(TOPIC);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testGetTopic_Null() {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> responseFuture = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getTopic(TOPIC));
  }

  @Test
  public void testGetTopicAsync() throws ExecutionException, InterruptedException {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> response =
        Futures.immediateFuture(TOPIC_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<Topic> topicFuture = pubsub.getTopicAsync(TOPIC);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topicFuture.get());
  }

  @Test
  public void testGetTopicAsync_Null() throws ExecutionException, InterruptedException {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> responseFuture = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getTopicAsync(TOPIC).get());
  }

  @Test
  public void testDeleteTopic() {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertTrue(pubsub.deleteTopic(TOPIC));
  }

  @Test
  public void testDeleteTopic_Null() {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertFalse(pubsub.deleteTopic(TOPIC));
  }

  @Test
  public void testDeleteTopicAsync() throws ExecutionException, InterruptedException {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertTrue(pubsub.deleteTopicAsync(TOPIC).get());
  }

  @Test
  public void testDeleteTopicAsync_Null() throws ExecutionException, InterruptedException {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertFalse(pubsub.deleteTopicAsync(TOPIC).get());
  }

  @Test
  public void testListTopics() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Topic> page = pubsub.listTopics();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(2);
    ListTopicsRequest request1 = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    ListTopicsRequest request2 = ListTopicsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Topic> topicList1 = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    List<Topic> topicList2 = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response1 = ListTopicsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllTopics(Lists.transform(topicList1, TOPIC_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListTopicsResponse response2 = ListTopicsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllTopics(Lists.transform(topicList2, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListTopicsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Topic> page = pubsub.listTopics();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(topicList1.toArray(), Iterables.toArray(page.getValues(), Topic.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(topicList2.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsEmpty() {
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of();
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Topic> page = pubsub.listTopics();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterators.toArray(page.iterateAll(), Topic.class));
  }

  @Test
  public void testListTopicsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<Topic> topicList = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Topic> page = pubsub.listTopics(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(2);
    ListTopicsRequest request1 = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    ListTopicsRequest request2 = ListTopicsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Topic> topicList1 = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    List<Topic> topicList2 = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response1 = ListTopicsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllTopics(Lists.transform(topicList1, TOPIC_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListTopicsResponse response2 = ListTopicsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllTopics(Lists.transform(topicList2, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListTopicsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(topicList1.toArray(), Iterables.toArray(page.getValues(), Topic.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(topicList2.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncEmpty() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of();
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPageAsync().get());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterators.toArray(page.iterateAll(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncWithOptions() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<Topic> topicList = ImmutableList.of(
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)),
        new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)));
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Topic> page =
        pubsub.listTopicsAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testPublishOneMessage() {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addAllMessages(ImmutableList.of(MESSAGE.toPb()))
        .build();
    String messageId = "messageId";
    PublishResponse response = PublishResponse.newBuilder().addMessageIds(messageId).build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageId, pubsub.publish(TOPIC, MESSAGE));
  }

  @Test
  public void testPublishOneMessageAsync() throws ExecutionException, InterruptedException {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addMessages(MESSAGE.toPb())
        .build();
    String messageId = "messageId";
    PublishResponse response = PublishResponse.newBuilder().addMessageIds(messageId).build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageId, pubsub.publishAsync(TOPIC, MESSAGE).get());
  }

  @Test
  public void testPublishMoreMessages() {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addAllMessages(ImmutableList.of(MESSAGE.toPb(), MESSAGE.toPb()))
        .build();
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    PublishResponse response = PublishResponse.newBuilder()
        .addAllMessageIds(messageIds)
        .build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageIds, pubsub.publish(TOPIC, MESSAGE, MESSAGE));
  }

  @Test
  public void testPublishMoreMessagesAsync() throws ExecutionException, InterruptedException {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addAllMessages(ImmutableList.of(MESSAGE.toPb(), MESSAGE.toPb()))
        .build();
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    PublishResponse response = PublishResponse.newBuilder()
        .addAllMessageIds(messageIds)
        .build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageIds, pubsub.publishAsync(TOPIC, MESSAGE, MESSAGE).get());
  }

  @Test
  public void testPublishMessageList() {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addAllMessages(ImmutableList.of(MESSAGE.toPb(), MESSAGE.toPb()))
        .build();
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    PublishResponse response = PublishResponse.newBuilder()
        .addAllMessageIds(messageIds)
        .build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageIds, pubsub.publish(TOPIC, ImmutableList.of(MESSAGE, MESSAGE)));
  }

  @Test
  public void testPublishMessageListAsync() throws ExecutionException, InterruptedException {
    PublishRequest request = PublishRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .addAllMessages(ImmutableList.of(MESSAGE.toPb(), MESSAGE.toPb()))
        .build();
    List<String> messageIds = ImmutableList.of("messageId1", "messageId2");
    PublishResponse response = PublishResponse.newBuilder()
        .addAllMessageIds(messageIds)
        .build();
    Future<PublishResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.publish(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertEquals(messageIds, pubsub.publishAsync(TOPIC, ImmutableList.of(MESSAGE, MESSAGE)).get());
  }

  @Test
  public void testCreateSubscription() {
    com.google.pubsub.v1.Subscription subscriptionPb = SUBSCRIPTION_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(subscriptionPb);
    EasyMock.expect(pubsubRpcMock.create(subscriptionPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Subscription subscription = pubsub.create(SUBSCRIPTION_INFO);
    assertEquals(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        subscription);
  }

  @Test
  public void testCreateSubscriptionAsync() throws ExecutionException, InterruptedException {
    com.google.pubsub.v1.Subscription subscriptionPb = SUBSCRIPTION_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(subscriptionPb);
    EasyMock.expect(pubsubRpcMock.create(subscriptionPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Subscription subscription = pubsub.createAsync(SUBSCRIPTION_INFO).get();
    assertEquals(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        subscription);
  }

  @Test
  public void testGetSubscription() {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(SUBSCRIPTION_NAME_PB).build();
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(SUBSCRIPTION_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Subscription subscription = pubsub.getSubscription(SUBSCRIPTION);
    assertEquals(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        subscription);
  }

  @Test
  public void testGetSubscription_Null() {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(SUBSCRIPTION_NAME_PB).build();
    Future<com.google.pubsub.v1.Subscription> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getSubscription(SUBSCRIPTION));
  }

  @Test
  public void testGetSubscriptionAsync() throws ExecutionException, InterruptedException {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(SUBSCRIPTION_NAME_PB).build();
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(SUBSCRIPTION_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Subscription subscription = pubsub.getSubscriptionAsync(SUBSCRIPTION).get();
    assertEquals(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        subscription);
  }

  @Test
  public void testGetSubscriptionAsync_Null() throws ExecutionException, InterruptedException {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(SUBSCRIPTION_NAME_PB).build();
    Future<com.google.pubsub.v1.Subscription> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getSubscriptionAsync(SUBSCRIPTION).get());
  }

  @Test
  public void testDeleteSubscription() {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertTrue(pubsub.deleteSubscription(SUBSCRIPTION));
  }

  @Test
  public void testDeleteSubscription_Null() {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertFalse(pubsub.deleteSubscription(SUBSCRIPTION));
  }

  @Test
  public void testDeleteSubscriptionAsync() throws ExecutionException, InterruptedException {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertTrue(pubsub.deleteSubscriptionAsync(SUBSCRIPTION).get());
  }

  @Test
  public void testDeleteSubscriptionAsync_Null() throws ExecutionException, InterruptedException {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertFalse(pubsub.deleteSubscriptionAsync(SUBSCRIPTION).get());
  }

  @Test
  public void testReplacePushConfig() {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setPushConfig(PUSH_CONFIG.toPb())
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    pubsub.replacePushConfig(SUBSCRIPTION, PUSH_CONFIG);
  }

  @Test
  public void testReplacePushConfig_Null() {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setPushConfig(com.google.pubsub.v1.PushConfig.getDefaultInstance())
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    pubsub.replacePushConfig(SUBSCRIPTION, null);
  }

  @Test
  public void testReplacePushConfigAsync() throws ExecutionException, InterruptedException {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setPushConfig(PUSH_CONFIG.toPb())
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    pubsub.replacePushConfigAsync(SUBSCRIPTION, PUSH_CONFIG).get();
  }

  @Test
  public void testReplacePushConfigAsync_Null() throws ExecutionException, InterruptedException {
    ModifyPushConfigRequest request = ModifyPushConfigRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setPushConfig(com.google.pubsub.v1.PushConfig.getDefaultInstance())
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    pubsub.replacePushConfigAsync(SUBSCRIPTION, null).get();
  }

  @Test
  public void testListSubscriptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Subscription> page = pubsub.listSubscriptions();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(2);
    ListSubscriptionsRequest request1 = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    ListSubscriptionsRequest request2 = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Subscription> subscriptionList1 = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    List<Subscription> subscriptionList2 = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response1 = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSubscriptions(Lists.transform(subscriptionList1, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListSubscriptionsResponse response2 = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSubscriptions(Lists.transform(subscriptionList2, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListSubscriptionsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Subscription> page = pubsub.listSubscriptions();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(subscriptionList1.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(subscriptionList2.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsEmpty() {
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of();
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Subscription> page = pubsub.listSubscriptions();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<Subscription> page =
        pubsub.listSubscriptions(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Subscription> page = pubsub.listSubscriptionsAsync().get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(2);
    ListSubscriptionsRequest request1 = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    ListSubscriptionsRequest request2 = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageToken(cursor1)
        .build();
    List<Subscription> subscriptionList1 = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    List<Subscription> subscriptionList2 = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response1 = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSubscriptions(Lists.transform(subscriptionList1, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListSubscriptionsResponse response2 = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSubscriptions(Lists.transform(subscriptionList2, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse1 = Futures.immediateFuture(response1);
    Future<ListSubscriptionsResponse> futureResponse2 = Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Subscription> page = pubsub.listSubscriptionsAsync().get();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(subscriptionList1.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(subscriptionList2.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsAsyncEmpty() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of();
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Subscription> page = pubsub.listSubscriptionsAsync().get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPageAsync().get());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    resetOptionsForList(1);
    ListSubscriptionsRequest request = ListSubscriptionsRequest.newBuilder()
        .setProject(PROJECT_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<Subscription> subscriptionList = ImmutableList.of(
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)),
        new Subscription(pubsub, new SubscriptionInfo.BuilderImpl(COMPLETE_SUBSCRIPTION_INFO)));
    ListSubscriptionsResponse response = ListSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_TO_PB_FUNCTION))
        .build();
    Future<ListSubscriptionsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<Subscription> page =
        pubsub.listSubscriptionsAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListTopicSubscriptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<SubscriptionId> page = pubsub.listSubscriptions(TOPIC);
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request1 = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    ListTopicSubscriptionsRequest request2 = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .setPageToken(cursor1)
        .build();
    List<SubscriptionId> subscriptionList1 = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    List<SubscriptionId> subscriptionList2 = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription3"));
    ListTopicSubscriptionsResponse response1 = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSubscriptions(Lists.transform(subscriptionList1, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListTopicSubscriptionsResponse response2 = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSubscriptions(Lists.transform(subscriptionList2, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse1 =
        Futures.immediateFuture(response1);
    Future<ListTopicSubscriptionsResponse> futureResponse2 =
        Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<SubscriptionId> page = pubsub.listSubscriptions(TOPIC);
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(subscriptionList1.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(subscriptionList2.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsEmpty() {
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of();
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<SubscriptionId> page = pubsub.listSubscriptions(TOPIC);
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Page<SubscriptionId> page =
        pubsub.listSubscriptions(TOPIC, ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("cursor")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(TOPIC).get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsAsyncNextPage()
      throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request1 = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    ListTopicSubscriptionsRequest request2 = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .setPageToken(cursor1)
        .build();
    List<SubscriptionId> subscriptionList1 = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    List<SubscriptionId> subscriptionList2 = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription3"));
    ListTopicSubscriptionsResponse response1 = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor1)
        .addAllSubscriptions(Lists.transform(subscriptionList1, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    String cursor2 = "nextCursor";
    ListTopicSubscriptionsResponse response2 = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken(cursor2)
        .addAllSubscriptions(Lists.transform(subscriptionList2, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse1 =
        Futures.immediateFuture(response1);
    Future<ListTopicSubscriptionsResponse> futureResponse2 =
        Futures.immediateFuture(response2);
    EasyMock.expect(pubsubRpcMock.list(request1)).andReturn(futureResponse1);
    EasyMock.expect(pubsubRpcMock.list(request2)).andReturn(futureResponse2);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(TOPIC).get();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(subscriptionList1.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(subscriptionList2.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsAsyncEmpty()
      throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of();
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(TOPIC).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsAsyncWithOptions()
      throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options, renewerMock);
    ListTopicSubscriptionsRequest request = ListTopicSubscriptionsRequest.newBuilder()
        .setTopic(TOPIC_NAME_PB)
        .setPageSize(42)
        .setPageToken(cursor)
        .build();
    List<SubscriptionId> subscriptionList = ImmutableList.of(
        new SubscriptionId(PROJECT, "subscription1"),
        new SubscriptionId(PROJECT, "subscription2"));
    ListTopicSubscriptionsResponse response = ListTopicSubscriptionsResponse.newBuilder()
        .setNextPageToken("")
        .addAllSubscriptions(Lists.transform(subscriptionList, SUBSCRIPTION_ID_TO_PB_FUNCTION))
        .build();
    Future<ListTopicSubscriptionsResponse> futureResponse =
        Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(
        TOPIC, ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testPullMessages() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(42)
        .setReturnImmediately(true)
        .build();
    List<ReceivedMessage> messageList = ImmutableList.of(
        ReceivedMessage.fromPb(pubsub, SUBSCRIPTION, MESSAGE_PB1),
        ReceivedMessage.fromPb(pubsub, SUBSCRIPTION, MESSAGE_PB2));
    PullResponse response = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE_PB1)
        .addReceivedMessages(MESSAGE_PB2)
        .build();
    Capture<PullCallback> callback = Capture.newInstance();
    PullFuture futureMock = EasyMock.createStrictMock(PullFuture.class);
    futureMock.addCallback(EasyMock.capture(callback));
    EasyMock.expectLastCall();
    EasyMock.expect(futureMock.get()).andReturn(response);
    EasyMock.expect(pubsubRpcMock.pull(request)).andReturn(futureMock);
    renewerMock.add(SUBSCRIPTION, ImmutableList.of("ackId1", "ackId2"));
    EasyMock.replay(pubsubRpcMock, renewerMock, futureMock);
    Iterator<ReceivedMessage> messageIterator = pubsub.pull(SUBSCRIPTION, 42);
    callback.getValue().success(response);
    EasyMock.reset(renewerMock);
    for (ReceivedMessage message : messageList) {
      renewerMock.remove(SUBSCRIPTION, message.getAckId());
      EasyMock.expectLastCall();
    }
    EasyMock.replay(renewerMock);
    while (messageIterator.hasNext()) {
      messageIterator.next();
    }
    EasyMock.verify(futureMock);
  }

  @Test
  public void testPullMessagesAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(42)
        .setReturnImmediately(false)
        .build();
    List<ReceivedMessage> messageList = ImmutableList.of(
        ReceivedMessage.fromPb(pubsub, SUBSCRIPTION, MESSAGE_PB1),
        ReceivedMessage.fromPb(pubsub, SUBSCRIPTION, MESSAGE_PB2));
    PullResponse response = PullResponse.newBuilder()
        .addReceivedMessages(MESSAGE_PB1)
        .addReceivedMessages(MESSAGE_PB2)
        .build();
    Capture<PullCallback> callback = Capture.newInstance();
    PullFuture futureMock = EasyMock.createStrictMock(PullFuture.class);
    futureMock.addCallback(EasyMock.capture(callback));
    EasyMock.expectLastCall();
    EasyMock.expect(futureMock.get()).andReturn(response);
    EasyMock.expect(pubsubRpcMock.pull(request)).andReturn(futureMock);
    renewerMock.add(SUBSCRIPTION, ImmutableList.of("ackId1", "ackId2"));
    EasyMock.replay(pubsubRpcMock, renewerMock, futureMock);
    Iterator<ReceivedMessage> messageIterator = pubsub.pullAsync(SUBSCRIPTION, 42).get();
    callback.getValue().success(response);
    EasyMock.reset(renewerMock);
    for (ReceivedMessage message : messageList) {
      renewerMock.remove(SUBSCRIPTION, message.getAckId());
      EasyMock.expectLastCall();
    }
    EasyMock.replay(renewerMock);
    while (messageIterator.hasNext()) {
      messageIterator.next();
    }
    EasyMock.verify(futureMock);
  }

  @Test
  public void testPullMessagesError() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(42)
        .setReturnImmediately(true)
        .build();
    PubSubException exception = new PubSubException(new IOException(), false);
    PullFuture futureMock = EasyMock.createStrictMock(PullFuture.class);
    futureMock.addCallback(EasyMock.anyObject(PullCallback.class));
    EasyMock.expectLastCall();
    EasyMock.expect(futureMock.get()).andThrow(new ExecutionException(exception));
    EasyMock.expect(pubsubRpcMock.pull(request)).andReturn(futureMock);
    EasyMock.replay(pubsubRpcMock, renewerMock, futureMock);
    try {
      pubsub.pull(SUBSCRIPTION, 42);
      fail("Expected PubSubException");
    } catch (PubSubException ex) {
      assertSame(exception, ex);
    }
    EasyMock.verify(futureMock);
  }

  @Test
  public void testPullMessagesAsyncError() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(42)
        .setReturnImmediately(false)
        .build();
    PubSubException exception = new PubSubException(new IOException(), false);
    PullFuture futureMock = EasyMock.createStrictMock(PullFuture.class);
    futureMock.addCallback(EasyMock.anyObject(PullCallback.class));
    EasyMock.expectLastCall();
    EasyMock.expect(futureMock.get()).andThrow(new ExecutionException(exception));
    EasyMock.expect(pubsubRpcMock.pull(request)).andReturn(futureMock);
    EasyMock.replay(pubsubRpcMock, renewerMock, futureMock);
    try {
      pubsub.pullAsync(SUBSCRIPTION, 42).get();
      fail("Expected ExecutionException");
    } catch (ExecutionException ex) {
      assertSame(exception, ex.getCause());
    }
    EasyMock.verify(futureMock);
  }

  @Test
  public void testMessageConsumer() throws Exception {
    pubsub = new PubSubImpl(options, renewerMock);
    EasyMock.reset(options);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpcMock);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT);
    EasyMock.replay(options);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(100)
        .setReturnImmediately(false)
        .build();
    final PullResponse response = PullResponse.getDefaultInstance();
    final CountDownLatch latch = new CountDownLatch(1);
    EasyMock.expect(pubsubRpcMock.pull(request)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        latch.countDown();
        return new TestPullFuture(response);
      }
    });
    EasyMock.replay(pubsubRpcMock, renewerMock);
    try (MessageConsumer consumer = pubsub.pullAsync(SUBSCRIPTION, DO_NOTHING)) {
      latch.await();
    }
  }

  @Test
  public void testMessageConsumerWithOptions() throws Exception {
    pubsub = new PubSubImpl(options, renewerMock);
    EasyMock.reset(options);
    EasyMock.expect(options.getService()).andReturn(pubsub);
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpcMock);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT);
    EasyMock.replay(options);
    ExecutorFactory executorFactoryMock = EasyMock.createStrictMock(ExecutorFactory.class);
    ExecutorService executorServiceMock = EasyMock.createStrictMock(ExecutorService.class);
    EasyMock.expect(executorFactoryMock.get()).andReturn(executorServiceMock);
    executorFactoryMock.release(executorServiceMock);
    PullRequest request = PullRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .setMaxMessages(42)
        .setReturnImmediately(false)
        .build();
    final PullResponse response = PullResponse.getDefaultInstance();
    final CountDownLatch latch = new CountDownLatch(1);
    EasyMock.expect(pubsubRpcMock.pull(request)).andAnswer(new IAnswer<PullFuture>() {
      @Override
      public PullFuture answer() throws Throwable {
        latch.countDown();
        return new TestPullFuture(response);
      }
    });
    EasyMock.replay(pubsubRpcMock, renewerMock, executorFactoryMock, executorServiceMock);
    PullOption[] options =
        {PullOption.maxQueuedCallbacks(42), PullOption.executorFactory(executorFactoryMock)};
    try (MessageConsumer consumer = pubsub.pullAsync(SUBSCRIPTION, DO_NOTHING, options)) {
      latch.await();
    }
  }

  @Test
  public void testAckOneMessage() {
    pubsub = new PubSubImpl(options, renewerMock);
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.ack(SUBSCRIPTION, "ackId");
  }

  @Test
  public void testAckOneMessageAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.ackAsync(SUBSCRIPTION, "ackId");
    assertNull(future.get());
  }

  @Test
  public void testAckMoreMessages() {
    pubsub = new PubSubImpl(options, renewerMock);
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.ack(SUBSCRIPTION, "ackId1", "ackId2");
  }

  @Test
  public void testAckMoreMessagesAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.ackAsync(SUBSCRIPTION, "ackId1", "ackId2");
    assertNull(future.get());
  }

  @Test
  public void testAckMessageList() {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.ack(SUBSCRIPTION, ackIds);
  }

  @Test
  public void testAckMessageListAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    AcknowledgeRequest request = AcknowledgeRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.acknowledge(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.ackAsync(SUBSCRIPTION, ackIds);
    assertNull(future.get());
  }

  @Test
  public void testNackOneMessage() {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.nack(SUBSCRIPTION, "ackId");
  }

  @Test
  public void testNackOneMessageAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.nackAsync(SUBSCRIPTION, "ackId");
    assertNull(future.get());
  }

  @Test
  public void testNackMoreMessages() {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.nack(SUBSCRIPTION, "ackId1", "ackId2");
  }

  @Test
  public void testNackMoreMessagesAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.nackAsync(SUBSCRIPTION, "ackId1", "ackId2");
    assertNull(future.get());
  }

  @Test
  public void testNackMessageList() {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.nack(SUBSCRIPTION, ackIds);
  }

  @Test
  public void testNackMessageListAsync() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(0)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.nackAsync(SUBSCRIPTION, ackIds);
    assertNull(future.get());
  }

  @Test
  public void testModifyAckDeadlineOneMessage() {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.modifyAckDeadline(SUBSCRIPTION, 10, TimeUnit.SECONDS, "ackId");
  }

  @Test
  public void testModifyAckDeadlineOneMessageAsync()
      throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAckIds("ackId")
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future =
        pubsub.modifyAckDeadlineAsync(SUBSCRIPTION, 10, TimeUnit.SECONDS, "ackId");
    assertNull(future.get());
  }

  @Test
  public void testModifyAckDeadlineMoreMessages() {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.modifyAckDeadline(SUBSCRIPTION, 10, TimeUnit.SECONDS, "ackId1", "ackId2");
  }

  @Test
  public void testModifyAckDeadlineMoreMessagesAsync()
      throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ImmutableList.of("ackId1", "ackId2"))
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future =
        pubsub.modifyAckDeadlineAsync(SUBSCRIPTION, 10, TimeUnit.SECONDS, "ackId1", "ackId2");
    assertNull(future.get());
  }

  @Test
  public void testModifyAckDeadlineMessageList() {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.modifyAckDeadline(SUBSCRIPTION, 10, TimeUnit.SECONDS, ackIds);
  }

  @Test
  public void testModifyAckDeadlineMessageListAsync()
      throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options, renewerMock);
    List<String> ackIds = ImmutableList.of("ackId1", "ackId2");
    ModifyAckDeadlineRequest request = ModifyAckDeadlineRequest.newBuilder()
        .setAckDeadlineSeconds(10)
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .addAllAckIds(ackIds)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.modify(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    Future<Void> future = pubsub.modifyAckDeadlineAsync(SUBSCRIPTION, 10, TimeUnit.SECONDS, ackIds);
    assertNull(future.get());
  }

  @Test
  public void testGetTopicPolicy() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Policy policy = pubsub.getTopicPolicy(TOPIC);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetTopicPolicy_Null() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getTopicPolicy(TOPIC));
  }

  @Test
  public void testGetTopicPolicyAsync() throws ExecutionException, InterruptedException {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<Policy> future = pubsub.getTopicPolicyAsync(TOPIC);
    assertEquals(POLICY, future.get());
  }

  @Test
  public void testGetTopicPolicyAsync_Null() throws ExecutionException, InterruptedException {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getTopicPolicyAsync(TOPIC).get());
  }

  @Test
  public void testReplaceTopicPolicy() {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(POLICY))
        .build();
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.setIamPolicy(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Policy policy = pubsub.replaceTopicPolicy(TOPIC, POLICY);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplaceTopicPolicyAsync() throws ExecutionException, InterruptedException {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(POLICY))
        .build();
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.setIamPolicy(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<Policy> future = pubsub.replaceTopicPolicyAsync(TOPIC, POLICY);
    assertEquals(POLICY, future.get());
  }

  @Test
  public void testTestTopicPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(permissions)
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    List<Boolean> permissionBooleans = pubsub.testTopicPermissions(TOPIC, permissions);
    assertEquals(ImmutableList.of(true), permissionBooleans);
  }

  @Test
  public void testTestTopicNoPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(ImmutableList.<String>of())
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    List<Boolean> permissionBooleans = pubsub.testTopicPermissions(TOPIC, permissions);
    assertEquals(ImmutableList.of(false), permissionBooleans);
  }

  @Test
  public void testTestTopicPermissionsAsync() throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(permissions)
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<List<Boolean>> future = pubsub.testTopicPermissionsAsync(TOPIC, permissions);
    assertEquals(ImmutableList.of(true), future.get());
  }

  @Test
  public void testTestTopicNoPermissionsAsync() throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.topics.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(TOPIC_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(ImmutableList.<String>of())
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<List<Boolean>> future = pubsub.testTopicPermissionsAsync(TOPIC, permissions);
    assertEquals(ImmutableList.of(false), future.get());
  }

  @Test
  public void testGetSubscriptionPolicy() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(SUBSCRIPTION_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Policy policy = pubsub.getSubscriptionPolicy(SUBSCRIPTION);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetSubscriptionPolicy_Null() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(SUBSCRIPTION_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    assertNull(pubsub.getSubscriptionPolicy(SUBSCRIPTION));
  }

  @Test
  public void testReplaceSubscriptionPolicy() {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(POLICY))
        .build();
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.setIamPolicy(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Policy policy = pubsub.replaceSubscriptionPolicy(SUBSCRIPTION, POLICY);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testReplaceSubscriptionPolicyAsync() throws ExecutionException, InterruptedException {
    SetIamPolicyRequest request = SetIamPolicyRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .setPolicy(PolicyMarshaller.INSTANCE.toPb(POLICY))
        .build();
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.setIamPolicy(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<Policy> future = pubsub.replaceSubscriptionPolicyAsync(SUBSCRIPTION, POLICY);
    assertEquals(POLICY, future.get());
  }

  @Test
  public void testTestSubscriptionPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(permissions)
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    List<Boolean> permissionBooleans =
        pubsub.testSubscriptionPermissions(SUBSCRIPTION, permissions);
    assertEquals(ImmutableList.of(true), permissionBooleans);
  }

  @Test
  public void testTestSubscriptionNoPermissions() {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(ImmutableList.<String>of())
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    List<Boolean> permissionBooleans =
        pubsub.testSubscriptionPermissions(SUBSCRIPTION, permissions);
    assertEquals(ImmutableList.of(false), permissionBooleans);
  }

  @Test
  public void testTestSubscriptionPermissionsAsync()
      throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(permissions)
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<List<Boolean>> future =
        pubsub.testSubscriptionPermissionsAsync(SUBSCRIPTION, permissions);
    assertEquals(ImmutableList.of(true), future.get());
  }

  @Test
  public void testTestSubscriptionNoPermissionsAsync()
      throws ExecutionException, InterruptedException {
    List<String> permissions = ImmutableList.of("pubsub.subscriptions.get");
    TestIamPermissionsRequest request = TestIamPermissionsRequest.newBuilder()
        .setResource(SUBSCRIPTION_NAME_PB)
        .addAllPermissions(permissions)
        .build();
    TestIamPermissionsResponse response = TestIamPermissionsResponse.newBuilder()
        .addAllPermissions(ImmutableList.<String>of())
        .build();
    Future<TestIamPermissionsResponse> responseFuture = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.testIamPermissions(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub = new PubSubImpl(options, renewerMock);
    Future<List<Boolean>> future =
        pubsub.testSubscriptionPermissionsAsync(SUBSCRIPTION, permissions);
    assertEquals(ImmutableList.of(false), future.get());
  }

  @Test
  public void testClose() throws Exception {
    pubsub = new PubSubImpl(options, renewerMock);
    pubsubRpcMock.close();
    EasyMock.expectLastCall();
    EasyMock.expectLastCall();
    renewerMock.close();
    EasyMock.expectLastCall();
    EasyMock.replay(pubsubRpcMock, renewerMock);
    pubsub.close();
    // closing again should do nothing
    pubsub.close();
  }
}
