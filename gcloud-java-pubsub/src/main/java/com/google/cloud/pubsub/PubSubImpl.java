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

import static com.google.common.util.concurrent.Futures.lazyTransform;

import com.google.cloud.AsyncPage;
import com.google.cloud.BaseService;
import com.google.cloud.Page;
import com.google.cloud.pubsub.spi.PubSubRpc;
import com.google.common.base.Function;
import com.google.common.base.Throwables;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.protobuf.Empty;
import com.google.pubsub.v1.DeleteTopicRequest;
import com.google.pubsub.v1.GetTopicRequest;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

class PubSubImpl extends BaseService<PubSubOptions> implements PubSub {

  private final PubSubRpc rpc;

  PubSubImpl(PubSubOptions options) {
    super(options);
    rpc = options.rpc();
  }

  private static <V> V get(Future<V> future) {
    try {
      return Uninterruptibles.getUninterruptibly(future);
    } catch (ExecutionException ex) {
      // TODO: we should propagate PubSubException
      throw Throwables.propagate(ex.getCause());
    }
  }

  @Override
  public Topic create(TopicInfo topic) {
    return get(createAsync(topic));
  }

  @Override
  public Future<Topic> createAsync(TopicInfo topic) {
    return lazyTransform(rpc.create(topic.toPb()), Topic.fromPbFunction(this));
  }

  @Override
  public Topic getTopic(String topic) {
    return get(getTopicAsync(topic));
  }

  @Override
  public Future<Topic> getTopicAsync(String topic) {
    GetTopicRequest request = GetTopicRequest.newBuilder().setTopic(topic).build();
    return lazyTransform(rpc.get(request), Topic.fromPbFunction(this));
  }

  @Override
  public boolean deleteTopic(String topic) {
    return get(deleteTopicAsync(topic));
  }

  @Override
  public Future<Boolean> deleteTopicAsync(String topic) {
    DeleteTopicRequest request = DeleteTopicRequest.newBuilder().setTopic(topic).build();
    return lazyTransform(rpc.delete(request), new Function<Empty, Boolean>() {
      @Override
      public Boolean apply(Empty input) {
        return true;
      }
    });
  }

  @Override
  public Page<Topic> listTopics(ListOption... options) {
    return null;
  }

  @Override
  public Future<AsyncPage<Topic>> listTopicsAsync(ListOption... options) {
    return null;
  }

  @Override
  public String publish(String topic, Message message) {
    return null;
  }

  @Override
  public Future<String> publishAsync(String topic, Message message) {
    return null;
  }

  @Override
  public List<String> publish(String topic, Message message, Message... messages) {
    return null;
  }

  @Override
  public Future<List<String>> publishAsync(String topic, Message message, Message... messages) {
    return null;
  }

  @Override
  public List<String> publish(String topic, Iterable<Message> messages) {
    return null;
  }

  @Override
  public Future<List<String>> publishAsync(String topic, Iterable<Message> messages) {
    return null;
  }

  @Override
  public Subscription create(SubscriptionInfo subscription) {
    return null;
  }

  @Override
  public Future<Subscription> createAsync(SubscriptionInfo subscription) {
    return null;
  }

  @Override
  public Subscription getSubscription(String subscription) {
    return null;
  }

  @Override
  public Future<Subscription> getSubscriptionAsync(String subscription) {
    return null;
  }

  @Override
  public void replacePushConfig(String subscription, PushConfig pushConfig) {

  }

  @Override
  public Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig) {
    return null;
  }

  @Override
  public boolean deleteSubscription(String subscription) {
    return false;
  }

  @Override
  public Future<Boolean> deleteSubscriptionAsync(String subscription) {
    return null;
  }

  @Override
  public Page<Subscription> listSubscriptions(ListOption... options) {
    return null;
  }

  @Override
  public Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options) {
    return null;
  }

  @Override
  public Page<Subscription> listSubscriptions(String topic, ListOption... options) {
    return null;
  }

  @Override
  public Future<AsyncPage<Subscription>> listSubscriptionsAsync(String topic,
      ListOption... options) {
    return null;
  }

  @Override
  public List<ReceivedMessage> pull(String subscription, PullOption... options) {
    return null;
  }

  @Override
  public Future<List<ReceivedMessage>> pullAsync(String subscription, PullOption... options) {
    return null;
  }

  @Override
  public void pull(String subscription, PullCallback callback, PullOption... options) {

  }

  @Override
  public void pullAsync(String subscription, PullCallback callback, PullOption... options) {

  }

  @Override
  public void ack(String subscription, String ackId, String... ackIds) {
  }

  @Override
  public Future<Void> ackAsync(String subscription, String ackId, String... ackIds) {
    return null;
  }

  @Override
  public void ack(String subscription, Iterable<String> ackIds) {

  }

  @Override
  public Future<Void> ackAsync(String subscription, Iterable<String> ackIds) {
    return null;
  }

  @Override
  public void nack(String subscription, String ackId, String... ackIds) {
  }

  @Override
  public Future<Void> nackAsync(String subscription, String ackId, String... ackIds) {
    return null;
  }

  @Override
  public void nack(String subscription, Iterable<String> ackIds) {

  }

  @Override
  public Future<Void> nackAsync(String subscription, Iterable<String> ackIds) {
    return null;
  }

  @Override
  public void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, String ackId,
      String... ackIds) {

  }

  @Override
  public Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      String ackId, String... ackIds) {
    return null;
  }

  @Override
  public void modifyAckDeadline(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds) {

  }

  @Override
  public Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds) {
    return null;
  }
}
