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
public interface PubSub extends AutoCloseable, Service<PubSubOptions> {

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
     * Returns an option to specify the maximum number of messages that can be processed
     * concurrently at any time.
     */
    public static PullOption maxConcurrentCallbacks(int maxConcurrency) {
      return new PullOption(OptionType.MAX_CONCURRENT_CALLBACKS, maxConcurrency);
    }
  }

  /**
   * A callback to process pulled messages. The received message will be ack'ed upon successful
   * return or nack'ed if exception is thrown.
   */
  interface MessageProcessor {
    /**
     * Processes the received {@code message}. If this method returns correctly the message is
     * ack'ed. If this method throws an exception the message is nack'ed.
     */
    void process(Message message) throws Exception;
  }

  /**
   * An interface to control a message consumer.
   */
  interface MessageConsumer extends AutoCloseable {

    /**
     * Stops pulling messages from the subscription associated with this {@code MessageConsumer} and
     * frees all resources. Messages that have already been pulled are processed before closing.
     */
    @Override
    void close() throws Exception;
  }

  /**
   * Creates a new topic.
   *
   * @return the created topic
   * @throws PubSubException upon failure
   */
  Topic create(TopicInfo topic);

  /**
   * Sends a request for creating a topic. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns the created topic or {@code null} if not found.
   */
  Future<Topic> createAsync(TopicInfo topic);

  /**
   * Returns the requested topic or {@code null} if not found.
   *
   * @throws PubSubException upon failure
   */
  Topic getTopic(String topic);

  /**
   * Sends a request for getting a topic. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the requested topic or {@code null} if not found.
   *
   * @throws PubSubException upon failure
   */
  Future<Topic> getTopicAsync(String topic);

  /**
   * Deletes the requested topic.
   *
   * @return {@code true} if the topic was deleted, {@code false} if it was not found
   */
  boolean deleteTopic(String topic);

  /**
   * Sends a request for deleting a topic. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns {@code true} if the topic was deleted, {@code false}
   * if it was not found.
   */
  Future<Boolean> deleteTopicAsync(String topic);

  /**
   * Lists the topics. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing topics.
   *
   * @throws PubSubException upon failure
   */
  Page<Topic> listTopics(ListOption... options);

  /**
   * Sends a request for listing topics. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing topics.
   */
  Future<AsyncPage<Topic>> listTopicsAsync(ListOption... options);

  /**
   * Publishes a message to the provided topic. This method returns a service-generated id for the
   * published message. Service-generated ids are guaranteed to be unique within the topic.
   *
   * @param topic the topic where the message is published
   * @param message the message to publish
   * @return a unique service-generated id for the message
   * @throws PubSubException upon failure, if the topic does not exist or if the message has empty
   *     payload and no attributes
   */
  String publish(String topic, Message message);

  /**
   * Sends a request for publishing a message to the provided topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a service-generated
   * id for the published message. Service-generated ids are guaranteed to be unique within the
   * topic.
   *
   * @param topic the topic where the message is published
   * @param message the message to publish
   * @return a {@code Future} for the unique service-generated id for the message
   */
  Future<String> publishAsync(String topic, Message message);

  /**
   * Publishes a number of messages to the provided topic. This method returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * @param topic the topic where the message is published
   * @param message the first message to publish
   * @param messages other messages to publish
   * @return a list of unique, service-generated, ids. Ids are in the same order as the messages.
   * @throws PubSubException upon failure, if the topic does not exist or if one of the messages has
   *     empty payload and no attributes
   */
  List<String> publish(String topic, Message message, Message... messages);

  /**
   * Sends a request to publish a number of messages to the provided topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * @param topic the topic where the message is published
   * @param message the first message to publish
   * @param messages other messages to publish
   * @return a {@code Future} for the unique, service-generated ids. Ids are in the same order as
   *     the messages.
   */
  Future<List<String>> publishAsync(String topic, Message message, Message... messages);

  /**
   * Publishes a number of messages to the provided topic. This method returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * @param topic the topic where the message is published
   * @param messages the messages to publish
   * @return a list of unique, service-generated, ids. Ids are in the same order as the messages.
   * @throws PubSubException upon failure, if the topic does not exist or if one of the messages has
   *     empty payload and no attributes
   */
  List<String> publish(String topic, Iterable<Message> messages);

  /**
   * Sends a request to publish a number of messages to the provided topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * @param topic the topic where the message is published
   * @param messages the messages to publish
   * @return a {@code Future} for the unique, service-generated ids. Ids are in the same order as
   *     the messages
   */
  Future<List<String>> publishAsync(String topic, Iterable<Message> messages);

  /**
   * Creates a new subscription.
   *
   * @return the created subscription
   * @throws PubSubException upon failure
   */
  Subscription create(SubscriptionInfo subscription);

  /**
   * Sends a request for creating a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns the created subscription or {@code null} if
   * not found.
   */
  Future<Subscription> createAsync(SubscriptionInfo subscription);

  /**
   * Returns the requested subscription or {@code null} if not found.
   */
  Subscription getSubscription(String subscription);

  /**
   * Sends a request for getting a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns the requested subscription or {@code null} if
   * not found.
   */
  Future<Subscription> getSubscriptionAsync(String subscription);

  /**
   * Sets the push configuration for a specified subscription. This may be used to change a push
   * subscription to a pull one (passing a {@code null} {@code pushConfig} parameter) or vice versa.
   * This methods can also be used to change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery regardless of changes to the push
   * configuration.
   *
   * @param subscription the subscription for which to replace push configuration
   * @param pushConfig the new push configuration. Use {@code null} to unset it
   * @throws PubSubException upon failure, or if the subscription does not exist
   */
  void replacePushConfig(String subscription, PushConfig pushConfig);

  /**
   * Sends a request for updating the push configuration for a specified subscription. This may be
   * used to change a push subscription to a pull one (passing a {@code null} {@code pushConfig}
   * parameter) or vice versa. This methods can also be used to change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for delivery regardless of changes
   * to the push configuration. The method returns a {@code Future} object that can be used to wait
   * for the replace operation to be completed.
   *
   * @param subscription the subscription for which to replace push configuration
   * @param pushConfig the new push configuration. Use {@code null} to unset it
   * @return a {@code Future} to wait for the replace operation to be completed.
   */
  Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig);

  /**
   * Deletes the requested subscription.
   *
   * @return {@code true} if the subscription was deleted, {@code false} if it was not found
   * @throws PubSubException upon failure
   */
  boolean deleteSubscription(String subscription);

  /**
   * Sends a request for deleting a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns {@code true} if the subscription was deleted,
   * {@code false} if it was not found.
   */
  Future<Boolean> deleteSubscriptionAsync(String subscription);

  /**
   * Lists the subscriptions. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing subscriptions.
   *
   * @throws PubSubException upon failure
   */
  Page<Subscription> listSubscriptions(ListOption... options);

  /**
   * Sends a request for listing subscriptions. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns an {@link AsyncPage} object that can be used
   * to asynchronously handle paginated results. Use {@link ListOption} to specify the page size or
   * the page token from which to start listing subscriptions.
   *
   * @throws PubSubException upon failure
   */
  Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options);

  /**
   * Lists the identities of the subscriptions for the provided topic. This method returns a
   * {@link Page} object that can be used to consume paginated results. Use {@link ListOption} to
   * specify the page size or the page token from which to start listing subscriptions.
   *
   * @param topic the topic for which to list subscriptions
   * @throws PubSubException upon failure
   */
  Page<SubscriptionId> listSubscriptions(String topic, ListOption... options);

  /**
   * Sends a request for listing the identities of subscriptions for the provided topic. This method
   * returns a {@code Future} object to consume the result. {@link Future#get()} returns an
   * {@link AsyncPage} object that can be used to asynchronously handle paginated results. Use
   * {@link ListOption} to specify the page size or the page token from which to start listing
   * subscriptions.
   *
   * @param topic the topic for which to list subscriptions
   */
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
