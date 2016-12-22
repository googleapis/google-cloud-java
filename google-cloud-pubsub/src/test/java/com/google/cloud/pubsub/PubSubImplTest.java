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

package com.google.cloud.pubsub;

import static com.google.cloud.pubsub.spi.v1.SubscriberClient.formatSubscriptionName;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import com.google.cloud.AsyncPage;
import com.google.cloud.Identity;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.RetryParams;
import com.google.cloud.Role;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.cloud.pubsub.spi.PubSubRpc;
import com.google.cloud.pubsub.spi.PubSubRpcFactory;
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
import com.google.pubsub.v1.ModifyPushConfigRequest;
import com.google.pubsub.v1.PublishRequest;
import com.google.pubsub.v1.PublishResponse;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import org.easymock.EasyMock;
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
          return formatSubscriptionName(subscriptionId.getProject(),
              subscriptionId.getSubscription());
        }
      };

  private PubSubOptions options;
  private PubSubRpcFactory rpcFactoryMock;
  private PubSubRpc pubsubRpcMock;
  private PubSub pubsub;

  @Rule
  public ExpectedException thrown = ExpectedException.none();

  @Before
  @SuppressWarnings("unchecked")
  public void setUp() {
    rpcFactoryMock = EasyMock.createStrictMock(PubSubRpcFactory.class);
    pubsubRpcMock = EasyMock.createStrictMock(PubSubRpc.class);
    options = EasyMock.createMock(PubSubOptions.class);
    EasyMock.expect(options.getProjectId()).andReturn(PROJECT).anyTimes();
    EasyMock.expect(options.getRpc()).andReturn(pubsubRpcMock).anyTimes();
    EasyMock.expect(options.getRetryParams()).andReturn(RetryParams.noRetries()).anyTimes();
    EasyMock.replay(rpcFactoryMock, pubsubRpcMock, options);
    EasyMock.reset(pubsubRpcMock);
  }

  @After
  public void tearDown() {
    EasyMock.verify(rpcFactoryMock, pubsubRpcMock, options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertSame(options, pubsub.getOptions());
  }

  @Test
  public void testCreateTopic() {
    com.google.pubsub.v1.Topic topicPb = TOPIC_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Topic> response = Futures.immediateFuture(topicPb);
    EasyMock.expect(pubsubRpcMock.create(topicPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Topic topic = pubsub.create(TOPIC_INFO);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testCreateTopicAsync() throws ExecutionException, InterruptedException {
    com.google.pubsub.v1.Topic topicPb = TOPIC_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Topic> response = Futures.immediateFuture(topicPb);
    EasyMock.expect(pubsubRpcMock.create(topicPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Topic topic = pubsub.createAsync(TOPIC_INFO).get();
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testGetTopic() {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> response =
        Futures.immediateFuture(TOPIC_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Topic topic = pubsub.getTopic(TOPIC);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topic);
  }

  @Test
  public void testGetTopic_Null() {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> responseFuture = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertNull(pubsub.getTopic(TOPIC));
  }

  @Test
  public void testGetTopicAsync() throws ExecutionException, InterruptedException {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> response =
        Futures.immediateFuture(TOPIC_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Future<Topic> topicFuture = pubsub.getTopicAsync(TOPIC);
    assertEquals(new Topic(pubsub, new TopicInfo.BuilderImpl(TOPIC_INFO)), topicFuture.get());
  }

  @Test
  public void testGetTopicAsync_Null() throws ExecutionException, InterruptedException {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<com.google.pubsub.v1.Topic> responseFuture = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(responseFuture);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertNull(pubsub.getTopicAsync(TOPIC).get());
  }

  @Test
  public void testDeleteTopic() {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertTrue(pubsub.deleteTopic(TOPIC));
  }

  @Test
  public void testDeleteTopic_Null() {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertFalse(pubsub.deleteTopic(TOPIC));
  }

  @Test
  public void testDeleteTopicAsync() throws ExecutionException, InterruptedException {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertTrue(pubsub.deleteTopicAsync(TOPIC).get());
  }

  @Test
  public void testDeleteTopicAsync_Null() throws ExecutionException, InterruptedException {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(TOPIC_NAME_PB).build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertFalse(pubsub.deleteTopicAsync(TOPIC).get());
  }

  @Test
  public void testListTopics() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<Topic> page = pubsub.listTopics();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<Topic> page = pubsub.listTopics();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(topicList1.toArray(), Iterables.toArray(page.getValues(), Topic.class));
    page = page.getNextPage();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(topicList2.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsEmpty() {
    pubsub = new PubSubImpl(options);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of();
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock);
    Page<Topic> page = pubsub.listTopics();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterators.toArray(page.iterateAll(), Topic.class));
  }

  @Test
  public void testListTopicsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<Topic> page = pubsub.listTopics(ListOption.pageSize(42), ListOption.pageToken(cursor));
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsync() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertEquals(cursor1, page.getNextPageCursor());
    assertArrayEquals(topicList1.toArray(), Iterables.toArray(page.getValues(), Topic.class));
    page = page.getNextPageAsync().get();
    assertEquals(cursor2, page.getNextPageCursor());
    assertArrayEquals(topicList2.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncEmpty() throws ExecutionException, InterruptedException {
    pubsub = new PubSubImpl(options);
    resetOptionsForList(1);
    ListTopicsRequest request = ListTopicsRequest.newBuilder().setProject(PROJECT_PB).build();
    List<Topic> topicList = ImmutableList.of();
    ListTopicsResponse response = ListTopicsResponse.newBuilder()
        .setNextPageToken("")
        .addAllTopics(Lists.transform(topicList, TOPIC_TO_PB_FUNCTION))
        .build();
    Future<ListTopicsResponse> futureResponse = Futures.immediateFuture(response);
    EasyMock.expect(pubsubRpcMock.list(request)).andReturn(futureResponse);
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<Topic> page = pubsub.listTopicsAsync().get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPageAsync().get());
    assertNull(page.getNextPage());
    assertArrayEquals(topicList.toArray(), Iterators.toArray(page.iterateAll(), Topic.class));
  }

  @Test
  public void testListTopicsAsyncWithOptions() throws ExecutionException, InterruptedException {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<Topic> page =
        pubsub.listTopicsAsync(ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(topicList.toArray(), Iterables.toArray(page.getValues(), Topic.class));
  }

  @Test
  public void testCreateSubscription() {
    com.google.pubsub.v1.Subscription subscriptionPb = SUBSCRIPTION_INFO.toPb(PROJECT);
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(subscriptionPb);
    EasyMock.expect(pubsubRpcMock.create(subscriptionPb)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertNull(pubsub.getSubscription(SUBSCRIPTION));
  }

  @Test
  public void testGetSubscriptionAsync() throws ExecutionException, InterruptedException {
    GetSubscriptionRequest request =
        GetSubscriptionRequest.newBuilder().setSubscription(SUBSCRIPTION_NAME_PB).build();
    Future<com.google.pubsub.v1.Subscription> response =
        Futures.immediateFuture(SUBSCRIPTION_INFO.toPb(PROJECT));
    EasyMock.expect(pubsubRpcMock.get(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertNull(pubsub.getSubscriptionAsync(SUBSCRIPTION).get());
  }

  @Test
  public void testDeleteSubscription() {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertTrue(pubsub.deleteSubscription(SUBSCRIPTION));
  }

  @Test
  public void testDeleteSubscription_Null() {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertFalse(pubsub.deleteSubscription(SUBSCRIPTION));
  }

  @Test
  public void testDeleteSubscriptionAsync() throws ExecutionException, InterruptedException {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(Empty.getDefaultInstance());
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertTrue(pubsub.deleteSubscriptionAsync(SUBSCRIPTION).get());
  }

  @Test
  public void testDeleteSubscriptionAsync_Null() throws ExecutionException, InterruptedException {
    DeleteSubscriptionRequest request = DeleteSubscriptionRequest.newBuilder()
        .setSubscription(SUBSCRIPTION_NAME_PB)
        .build();
    Future<Empty> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.delete(request)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    pubsub.replacePushConfigAsync(SUBSCRIPTION, null).get();
  }

  @Test
  public void testListSubscriptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<Subscription> page = pubsub.listSubscriptions();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<Subscription> page = pubsub.listSubscriptions();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<Subscription> page = pubsub.listSubscriptionsAsync().get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), Subscription.class));
  }

  @Test
  public void testListSubscriptionsAsyncNextPage() throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<SubscriptionId> page = pubsub.listSubscriptions(TOPIC);
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsNextPage() {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    Page<SubscriptionId> page = pubsub.listSubscriptions(TOPIC);
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsWithOptions() {
    String cursor = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(TOPIC).get();
    assertEquals(cursor, page.getNextPageCursor());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testListTopicSubscriptionsAsyncNextPage()
      throws ExecutionException, InterruptedException {
    String cursor1 = "cursor";
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
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
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    AsyncPage<SubscriptionId> page = pubsub.listSubscriptionsAsync(
        TOPIC, ListOption.pageSize(42), ListOption.pageToken(cursor)).get();
    assertNull(page.getNextPageCursor());
    assertNull(page.getNextPage());
    assertNull(page.getNextPageAsync().get());
    assertArrayEquals(subscriptionList.toArray(),
        Iterables.toArray(page.getValues(), SubscriptionId.class));
  }

  @Test
  public void testGetTopicPolicy() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Policy policy = pubsub.getTopicPolicy(TOPIC);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetTopicPolicy_Null() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    assertNull(pubsub.getTopicPolicy(TOPIC));
  }

  @Test
  public void testGetTopicPolicyAsync() throws ExecutionException, InterruptedException {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Future<Policy> future = pubsub.getTopicPolicyAsync(TOPIC);
    assertEquals(POLICY, future.get());
  }

  @Test
  public void testGetTopicPolicyAsync_Null() throws ExecutionException, InterruptedException {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(TOPIC_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Future<List<Boolean>> future = pubsub.testTopicPermissionsAsync(TOPIC, permissions);
    assertEquals(ImmutableList.of(false), future.get());
  }

  @Test
  public void testGetSubscriptionPolicy() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(POLICY_PB);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(SUBSCRIPTION_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Policy policy = pubsub.getSubscriptionPolicy(SUBSCRIPTION);
    assertEquals(POLICY, policy);
  }

  @Test
  public void testGetSubscriptionPolicy_Null() {
    Future<com.google.iam.v1.Policy> response = Futures.immediateFuture(null);
    EasyMock.expect(pubsubRpcMock.getIamPolicy(SUBSCRIPTION_NAME_PB)).andReturn(response);
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
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
    EasyMock.replay(pubsubRpcMock);
    pubsub = new PubSubImpl(options);
    Future<List<Boolean>> future =
        pubsub.testSubscriptionPermissionsAsync(SUBSCRIPTION, permissions);
    assertEquals(ImmutableList.of(false), future.get());
  }

  @Test
  public void testClose() throws Exception {
    pubsub = new PubSubImpl(options);
    pubsubRpcMock.close();
    EasyMock.expectLastCall();
    EasyMock.expectLastCall();
    EasyMock.expectLastCall();
    EasyMock.replay(pubsubRpcMock);
    pubsub.close();
    // closing again should do nothing
    pubsub.close();
  }
}
