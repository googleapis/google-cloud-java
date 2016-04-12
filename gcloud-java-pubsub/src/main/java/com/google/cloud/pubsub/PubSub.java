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

import com.google.cloud.AsyncPage;
import com.google.cloud.Page;
import com.google.cloud.Service;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * An interface for Google Cloud Pub/Sub.
 *
 * @see <a href="https://cloud.google.com/pubsub/">Google Cloud Pub/Sub</a>
 */
public interface PubSub extends Service<PubSubOptions> {

  final class ListOption implements Serializable {

    private static final long serialVersionUID = 6517442127283383124L;

    private final Option option;
    private final Object value;

    enum Option {
      PAGE_SIZE, PAGE_TOKEN
    }

    private ListOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    Option option() {
      return option;
    }

    Object value() {
      return value;
    }

    public static ListOption pageSize(int pageSize) {
      return new ListOption(Option.PAGE_SIZE, pageSize);
    }

    public static ListOption pageToken(String pageToken) {
      return new ListOption(Option.PAGE_TOKEN, pageToken);
    }
  }

  final class PullOption implements Serializable {

    private static final long serialVersionUID = -5220474819637439937L;

    private final Option option;
    private final Object value;

    enum Option {
      RETURN_IMMEDIATELY, MAX_MESSAGES
    }

    private PullOption(Option option, Object value) {
      this.option = option;
      this.value = value;
    }

    Option option() {
      return option;
    }

    Object value() {
      return value;
    }

    public static PullOption returnImmediatly() {
      return new PullOption(Option.RETURN_IMMEDIATELY, true);
    }

    public static PullOption maxMessages(int maxMessages) {
      return new PullOption(Option.MAX_MESSAGES, maxMessages);
    }
  }

  Topic create(TopicInfo topic);

  Future<Topic> createAsync(TopicInfo topic);

  // null if not found
  Topic getTopic(String topic);

  Future<Topic> getTopicAsync(String topic);

  // false if not found
  boolean deleteTopic(String topic);

  Future<Boolean> deleteTopicAsync(String topic);

  Page<Topic> listTopics(ListOption... options);

  Future<AsyncPage<Topic>> listTopicsAsync(ListOption... options);

  String publish(String topic, Message message);

  Future<String> publishAsync(String topic, Message message);

  List<String> publish(String topic, Message message, Message... messages);

  Future<List<String>> publishAsync(String topic, Message message, Message... messages);

  List<String> publish(String topic, Iterable<Message> messages);

  Future<List<String>> publishAsync(String topic, Iterable<Message> messages);

  Subscription create(SubscriptionInfo subscription);

  Future<Subscription> createAsync(SubscriptionInfo subscription);

  // null if not found
  Subscription getSubscription(String subscription);

  Future<Subscription> getSubscriptionAsync(String subscription);

  void replacePushConfig(String subscription, PushConfig pushConfig);

  Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig);

  // false if not found
  boolean deleteSubscription(String subscription);

  Future<Boolean> deleteSubscriptionAsync(String subscription);

  Page<Subscription> listSubscriptions(ListOption... options);

  Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options);

  Page<Subscription> listSubscriptions(String topic, ListOption... options);

  Future<AsyncPage<Subscription>> listSubscriptionsAsync(String topic, ListOption... options);

  // Possible Ack options:
  // 1) return a "special" iterator with "ack-iterated-messages"
  // 2) provide a way to pull with callback(Message) - ask messages that were called successfully
  //
  // Also, consider auto-renewable for all messages that were pulled and not acked.
  List<ReceivedMessage> pull(String subscription, PullOption... options);

  Future<List<Message>> pullAsync(String subscription, PullOption... options);

  void acknowledge(String subscription, String ackId, String... ackIds);

  Future<Void> acknowledgeAsync(String subscription, String ackId, String... ackIds);

  void acknowledge(String subscription, Iterable<String> ackIds);

  Future<Void> acknowledgeAsync(String subscription, Iterable<String> ackIds);

  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, String ackId,
      String... ackIds);

  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      String ackId, String... ackIds);

  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, Iterable<String> ackIds);

  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds);

  // Note regarding Data types:
  // 1) No field selection
  //  --- This is why there are no options for getters
  // 2) Never null for primitive values or collections
  //  --- should we replace default "" with null (e.g. id when not populated)?

  // IAM Policy operations:  getPolicy, replacePolicy, testPermissions
  // Not sure if ready (docs is not up-to-date)
  // Looks like policy is per resource (topic or subscription) but not per service?
}
