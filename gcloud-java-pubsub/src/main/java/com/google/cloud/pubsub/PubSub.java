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

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * An interface for Google Cloud Pub/Sub.
 *
 * @see <a href="https://cloud.google.com/pubsub/">Google Cloud Pub/Sub</a>
 */
public interface PubSub extends Service<PubSubOptions> {

  /**
   * Class for specifying options for listing topics and subscriptions.
   */
  final class ListOption extends Option {

    private static final long serialVersionUID = 6517442127283383124L;

    enum OptionType implements Option.OptionType {
      PAGE_SIZE, PAGE_TOKEN;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }

      String getString(Map<Option.OptionType, ?> options) {
        return get(options);
      }

      Integer getInteger(Map<Option.OptionType, ?> options) {
        return get(options);
      }
    }

    private ListOption(OptionType option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of resources returned per page.
     */
    public static ListOption pageSize(int pageSize) {
      return new ListOption(OptionType.PAGE_SIZE, pageSize);
    }

    /**
     * Returns an option to specify the page token from which to start listing resources.
     */
    public static ListOption pageToken(String pageToken) {
      return new ListOption(OptionType.PAGE_TOKEN, pageToken);
    }
  }

  /**
   * Class for specifying options for pulling messages.
   */
  final class PullOption extends Option {

    private static final long serialVersionUID = 4792164134340316582L;

    enum OptionType implements Option.OptionType {
      MAX_CONCURRENT_CALLBACKS;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }

      Integer getInteger(Map<Option.OptionType, ?> options) {
        return get(options);
      }
    }

    private PullOption(Option.OptionType option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of messages that can be executed
     * concurrently at any time.
     */
    public static PullOption maxConcurrentCallbacks(int maxConcurrency) {
      return new PullOption(OptionType.MAX_CONCURRENT_CALLBACKS, maxConcurrency);
    }
  }

  /**
   * A callback to process pulled messages.
   * The message will be ack'ed upon successful return or nack'ed if exception is thrown.
   */
  interface MessageProcessor {
    void process(Message message) throws Exception;
  }

  /**
   * An interface to control message consumer settings.
   */
  interface MessageConsumer extends AutoCloseable {

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

  Page<SubscriptionId> listSubscriptions(String topic, ListOption... options);

  Future<AsyncPage<SubscriptionId>> listSubscriptionsAsync(String topic, ListOption... options);

  Iterator<ReceivedMessage> pull(String subscription, int maxMessages);

  Future<Iterator<ReceivedMessage>> pullAsync(String subscription, int maxMessages);

  MessageConsumer pullAsync(String subscription, MessageProcessor callback, PullOption... options);

  void ack(String subscription, String ackId, String... ackIds);

  Future<Void> ackAsync(String subscription, String ackId, String... ackIds);

  void ack(String subscription, Iterable<String> ackIds);

  Future<Void> ackAsync(String subscription, Iterable<String> ackIds);

  void nack(String subscription, String ackId, String... ackIds);

  Future<Void> nackAsync(String subscription, String ackId, String... ackIds);

  void nack(String subscription, Iterable<String> ackIds);

  Future<Void> nackAsync(String subscription, Iterable<String> ackIds);

  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, String ackId,
      String... ackIds);

  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      String ackId, String... ackIds);

  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, Iterable<String> ackIds);

  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds);

  // IAM Policy operations:  getPolicy, replacePolicy, testPermissions
  // Not sure if ready (docs is not up-to-date)
  // Looks like policy is per resource (topic or subscription) but not per service?
}
