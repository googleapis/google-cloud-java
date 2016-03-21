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

package com.google.gcloud.pubsub;

import com.google.gcloud.BaseService;
import com.google.gcloud.Page;
import com.google.gcloud.pubsub.spi.PubSubRpc;

import java.util.List;
import java.util.concurrent.Future;

class PubSubImpl extends BaseService<PubSubOptions> implements PubSub {

  private final PubSubRpc rpc;

  public PubSubImpl(PubSubOptions options) {
    super(options);
    rpc = options.rpc();
  }

  @Override
  public Topic createTopic(TopicInfo topic) {
    return null;
  }

  @Override
  public Future<Topic> createTopicAsync(String topic) {
    return null;
  }

  @Override
  public Topic getTopic(String topic) {
    return null;
  }

  @Override
  public Future<Topic> getTopicAsync(String topic) {
    return null;
  }

  @Override
  public boolean deleteTopic(String topic) {
    return false;
  }

  @Override
  public Future<Boolean> deleteTopicAsync(String topic) {
    return null;
  }

  @Override
  public Page<Topic> listTopics(ListOption... options) {
    return null;
  }

  @Override
  public Future<Page<Topic>> listTopicsAsync(ListOption... options) {
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
  public List<String> publish(String topic, Message first, Message... other) {
    return null;
  }

  @Override
  public Future<List<String>> publishAsync(String topic, Message first, Message... other) {
    return null;
  }

  @Override
  public Subscription createSubscription(SubscriptionInfo subscription) {
    return null;
  }

  @Override
  public Future<Subscription> createSubscriptionAsync(SubscriptionInfo subscription) {
    return null;
  }

  @Override
  public Subscription getSubscription(String subscription) {
    return null;
  }

  @Override
  public Future<Subscription> getSubscriptionAsync(String topic) {
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
  public Page<Subscription> listSubscription(ListOption... options) {
    return null;
  }

  @Override
  public Future<Page<Subscription>> listSubscriptionAsync(ListOption... options) {
    return null;
  }

  @Override
  public Page<Subscription> listSubscription(String topic, ListOption... options) {
    return null;
  }

  @Override
  public Future<Page<Subscription>> listSubscriptionAsync(String topic, ListOption... options) {
    return null;
  }

  @Override
  public List<Message> pull(String subscription, PullOption... options) {
    return null;
  }

  @Override
  public Future<List<Message>> pullAsync(String subscription, PullOption... options) {
    return null;
  }
}
