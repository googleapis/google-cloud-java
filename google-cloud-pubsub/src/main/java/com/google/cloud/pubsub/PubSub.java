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
import com.google.cloud.GrpcServiceOptions.ExecutorFactory;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.Service;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
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
      EXECUTOR_FACTORY,
      MAX_QUEUED_CALLBACKS;

      @SuppressWarnings("unchecked")
      <T> T get(Map<Option.OptionType, ?> options) {
        return (T) options.get(this);
      }

      Integer getInteger(Map<Option.OptionType, ?> options) {
        return get(options);
      }

      ExecutorFactory<ExecutorService> getExecutorFactory(Map<Option.OptionType, ?> options) {
        return get(options);
      }
    }

    private PullOption(Option.OptionType option, Object value) {
      super(option, value);
    }

    /**
     * Returns an option to specify the maximum number of messages that can be queued in the message
     * consumer at any time. Queued messages are already pulled messages that are either waiting to
     * be processed or being processed. Queued messages will have their acknowledge deadline renewed
     * until they are acknowledged or "nacked". If not provided, at most 100 messages can be in the
     * queue.
     */
    public static PullOption maxQueuedCallbacks(int maxQueuedCallbacks) {
      return new PullOption(OptionType.MAX_QUEUED_CALLBACKS, maxQueuedCallbacks);
    }

    /**
     * Returns an option to specify the executor used to execute message processor callbacks. The
     * executor determines the number of messages that can be processed at the same time. If not
     * provided, a single-threaded executor is used to execute message processor callbacks.
     *
     * <p>The {@link ExecutorFactory} object can be used to handle creation and release of the
     * executor, possibly reusing existing executors. {@link ExecutorFactory#get()} is called when
     * the message consumer is created. {@link ExecutorFactory#release(ExecutorService)} is called
     * when the message consumer is closed.
     *
     * <p>For the created option to be serializable, the provided executor factory should implement
     * {@link java.io.Serializable}.
     *
     * @param executorFactory the executor factory.
     */
    public static PullOption executorFactory(ExecutorFactory executorFactory) {
      return new PullOption(OptionType.EXECUTOR_FACTORY, executorFactory);
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
   * <p>Example of creating a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * TopicInfo topicInfo = TopicInfo.of(topicName);
   * Topic topic = pubsub.create(topicInfo);
   * }</pre>
   *
   * @return the created topic
   * @throws PubSubException upon failure
   */
  Topic create(TopicInfo topic);

  /**
   * Sends a request for creating a topic. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns the created topic.
   *
   * <p>Example of asynchronously creating a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * TopicInfo topicInfo = TopicInfo.of(topicName);
   * Future<Topic> future = pubsub.createAsync(topicInfo);
   * // ...
   * Topic topic = future.get();
   * }</pre>
   *
   */
  Future<Topic> createAsync(TopicInfo topic);

  /**
   * Returns the requested topic or {@code null} if not found.
   *
   * <p>Example of getting a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Topic topic = pubsub.getTopic(topicName);
   * if (topic == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Topic getTopic(String topic);

  /**
   * Sends a request for getting a topic. This method returns a {@code Future} object to consume the
   * result. {@link Future#get()} returns the requested topic or {@code null} if not found.
   *
   * <p>Example of asynchronously getting a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Future<Topic> future = pubsub.getTopicAsync(topicName);
   * // ...
   * Topic topic = future.get();
   * if (topic == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<Topic> getTopicAsync(String topic);

  /**
   * Deletes the requested topic.
   *
   * <p>Example of deleting a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * boolean deleted = pubsub.deleteTopic(topicName);
   * if (deleted) {
   *   // the topic was deleted
   * } else {
   *   // the topic was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the topic was deleted, {@code false} if it was not found
   */
  boolean deleteTopic(String topic);

  /**
   * Sends a request for deleting a topic. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns {@code true} if the topic was deleted, {@code false}
   * if it was not found.
   *
   * <p>Example of asynchronously deleting a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Future<Boolean> future = pubsub.deleteTopicAsync(topicName);
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the topic was deleted
   * } else {
   *   // the topic was not found
   * }
   * }</pre>
   *
   */
  Future<Boolean> deleteTopicAsync(String topic);

  /**
   * Lists the topics. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing topics.
   *
   * <p>Example of listing topics, specifying the page size.
   * <pre> {@code
   * Page<Topic> topics = pubsub.listTopics(ListOption.pageSize(100));
   * Iterator<Topic> topicIterator = topics.iterateAll();
   * while (topicIterator.hasNext()) {
   *   Topic topic = topicIterator.next();
   *   // do something with the topic
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Page<Topic> listTopics(ListOption... options);

  /**
   * Sends a request for listing topics. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns an {@link AsyncPage} object that can be used to
   * asynchronously handle paginated results. Use {@link ListOption} to specify the page size or the
   * page token from which to start listing topics.
   *
   * <p>Example of asynchronously listing topics, specifying the page size.
   * <pre> {@code
   * Future<AsyncPage<Topic>> future = pubsub.listTopicsAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<Topic> topics = future.get();
   * Iterator<Topic> topicIterator = topics.iterateAll();
   * while (topicIterator.hasNext()) {
   *   Topic topic = topicIterator.next();
   *   // do something with the topic
   * }
   * }</pre>
   *
   */
  Future<AsyncPage<Topic>> listTopicsAsync(ListOption... options);

  /**
   * Publishes a message to the provided topic. This method returns a service-generated id for the
   * published message. Service-generated ids are guaranteed to be unique within the topic.
   *
   * <p>Example of publishing one message to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Message message = Message.of("payload");
   * String messageId = pubsub.publish(topicName, message);
   * }</pre>
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
   * <p>Example of asynchronously publishing one message to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Message message = Message.of("payload");
   * Future<String> future = pubsub.publishAsync(topicName, message);
   * // ...
   * String messageId = future.get();
   * }</pre>
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
   * <p>Example of publishing some messages to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Message message1 = Message.of("payload1");
   * Message message2 = Message.of("payload2");
   * List<String> messageIds = pubsub.publish(topicName, message1, message2);
   * }</pre>
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
   * <p>Example of asynchronously publishing some messages to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Message message1 = Message.of("payload1");
   * Message message2 = Message.of("payload2");
   * Future<List<String>> future = pubsub.publishAsync(topicName, message1, message2);
   * // ...
   * List<String> messageIds = future.get();
   * }</pre>
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
   * <p>Example of publishing a list of messages to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * List<Message> messages = new LinkedList<>();
   * messages.add(Message.of("payload1"));
   * messages.add(Message.of("payload2"));
   * List<String> messageIds = pubsub.publish(topicName, messages);
   * }</pre>
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
   * <p>Example of asynchronously publishing a list of messages to a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * List<Message> messages = new LinkedList<>();
   * messages.add(Message.of("payload1"));
   * messages.add(Message.of("payload2"));
   * Future<List<String>> future = pubsub.publishAsync(topicName, messages);
   * // ...
   * List<String> messageIds = future.get();
   * }</pre>
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
   * <p>Example of creating a pull subscription for a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * String subscriptionName = "my_subscription_name";
   * SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(topicName, subscriptionName);
   * Subscription subscription = pubsub.create(subscriptionInfo);
   * }</pre>
   *
   * @return the created subscription
   * @throws PubSubException upon failure
   */
  Subscription create(SubscriptionInfo subscription);

  /**
   * Sends a request for creating a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns the created subscription.
   *
   * <p>Example of asynchronously creating a pull subscription for a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * String subscriptionName = "my_subscription_name";
   * SubscriptionInfo subscriptionInfo = SubscriptionInfo.of(topicName, subscriptionName);
   * Future<Subscription> future = pubsub.createAsync(subscriptionInfo);
   * // ...
   * Subscription subscription = future.get();
   * }</pre>
   *
   */
  Future<Subscription> createAsync(SubscriptionInfo subscription);

  /**
   * Returns the requested subscription or {@code null} if not found.
   *
   * <p>Example of getting a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Subscription subscription = pubsub.getSubscription(subscriptionName);
   * if (subscription == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   */
  Subscription getSubscription(String subscription);

  /**
   * Sends a request for getting a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns the requested subscription or {@code null} if
   * not found.
   *
   * <p>Example of asynchronously getting a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Future<Subscription> future = pubsub.getSubscriptionAsync(subscriptionName);
   * // ...
   * Subscription subscription = future.get();
   * if (subscription == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   */
  Future<Subscription> getSubscriptionAsync(String subscription);

  /**
   * Sets the push configuration for a specified subscription. This may be used to change a push
   * subscription to a pull one (passing a {@code null} {@code pushConfig} parameter) or vice versa.
   * This methods can also be used to change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery regardless of changes to the push
   * configuration.
   *
   * <p>Example of replacing the push configuration of a subscription, setting the push endpoint.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String endpoint = "https://www.example.com/push";
   * PushConfig pushConfig = PushConfig.of(endpoint);
   * pubsub.replacePushConfig(subscriptionName, pushConfig);
   * }</pre>
   *
   * <p>Example of replacing the push configuration of a subscription, making it a pull
   * subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * pubsub.replacePushConfig(subscriptionName, null);
   * }</pre>
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
   * <p>Example of asynchronously replacing the push configuration of a subscription, setting the
   * push endpoint.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String endpoint = "https://www.example.com/push";
   * PushConfig pushConfig = PushConfig.of(endpoint);
   * Future<Void> future = pubsub.replacePushConfigAsync(subscriptionName, pushConfig);
   * // ...
   * future.get();
   * }</pre>
   *
   * <p>Example of asynchronously replacing the push configuration of a subscription, making it a
   * pull subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Future<Void> future = pubsub.replacePushConfigAsync(subscriptionName, null);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription for which to replace push configuration
   * @param pushConfig the new push configuration. Use {@code null} to unset it
   * @return a {@code Future} to wait for the replace operation to be completed.
   */
  Future<Void> replacePushConfigAsync(String subscription, PushConfig pushConfig);

  /**
   * Deletes the requested subscription.
   *
   * <p>Example of deleting a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * boolean deleted = pubsub.deleteSubscription(subscriptionName);
   * if (deleted) {
   *   // the subscription was deleted
   * } else {
   *   // the subscription was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the subscription was deleted, {@code false} if it was not found
   * @throws PubSubException upon failure
   */
  boolean deleteSubscription(String subscription);

  /**
   * Sends a request for deleting a subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns {@code true} if the subscription was deleted,
   * {@code false} if it was not found.
   *
   * <p>Example of asynchronously deleting a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Future<Boolean> future = pubsub.deleteSubscriptionAsync(subscriptionName);
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the subscription was deleted
   * } else {
   *   // the subscription was not found
   * }
   * }</pre>
   *
   */
  Future<Boolean> deleteSubscriptionAsync(String subscription);

  /**
   * Lists the subscriptions. This method returns a {@link Page} object that can be used to consume
   * paginated results. Use {@link ListOption} to specify the page size or the page token from which
   * to start listing subscriptions.
   *
   * <p>Example of listing subscriptions, specifying the page size.
   * <pre> {@code
   * Page<Subscription> subscriptions = pubsub.listSubscriptions(ListOption.pageSize(100));
   * Iterator<Subscription> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   Subscription subscription = subscriptionIterator.next();
   *   // do something with the subscription
   * }
   * }</pre>
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
   * <p>Example of asynchronously listing subscriptions, specifying the page size.
   * <pre> {@code
   * Future<AsyncPage<Subscription>> future =
   *     pubsub.listSubscriptionsAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<Subscription> subscriptions = future.get();
   * Iterator<Subscription> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   Subscription subscription = subscriptionIterator.next();
   *   // do something with the subscription
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<AsyncPage<Subscription>> listSubscriptionsAsync(ListOption... options);

  /**
   * Lists the identities of the subscriptions for the provided topic. This method returns a
   * {@link Page} object that can be used to consume paginated results. Use {@link ListOption} to
   * specify the page size or the page token from which to start listing subscriptions.
   *
   * <p>Example of listing subscriptions for a topic, specifying the page size.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Page<SubscriptionId> subscriptions =
   *     pubsub.listSubscriptions(topicName, ListOption.pageSize(100));
   * Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   SubscriptionId subscription = subscriptionIterator.next();
   *   // do something with the subscription identity
   * }
   * }</pre>
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
   * <p>Example of asynchronously listing subscriptions for a topic, specifying the page size.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Future<AsyncPage<SubscriptionId>> future =
   *     pubsub.listSubscriptionsAsync(topicName, ListOption.pageSize(100));
   * // ...
   * AsyncPage<SubscriptionId> subscriptions = future.get();
   * Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   SubscriptionId subscription = subscriptionIterator.next();
   *   // do something with the subscription identity
   * }
   * }</pre>
   *
   * @param topic the topic for which to list subscriptions
   */
  Future<AsyncPage<SubscriptionId>> listSubscriptionsAsync(String topic, ListOption... options);

  /**
   * Pulls messages from the provided subscription. This method possibly returns no messages if no
   * message was available at the time the request was processed by the Pub/Sub service (i.e. the
   * system is not allowed to wait until at least one message is available). Pulled messages have
   * their acknowledge deadline automatically renewed until they are explicitly consumed using
   * {@link Iterator#next()}.
   *
   * <p>Example of pulling a maximum number of messages from a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Iterator<ReceivedMessage> messages = pubsub.pull(subscriptionName, 100);
   * // Ack deadline is renewed until the message is consumed
   * while (messages.hasNext()) {
   *   ReceivedMessage message = messages.next();
   *   // do something with message and ack/nack it
   *   message.ack(); // or message.nack()
   * }
   * }</pre>
   *
   * @param subscription the subscription from which to pull messages
   * @param maxMessages the maximum number of messages pulled by this method. This method can
   *     possibly return fewer messages.
   * @throws PubSubException upon failure
   */
  Iterator<ReceivedMessage> pull(String subscription, int maxMessages);

  /**
   * Sends a request for pulling messages from the provided subscription. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a message iterator.
   * This method possibly returns no messages if no message was available at the time the request
   * was processed by the Pub/Sub service (i.e. the system is not allowed to wait until at least one
   * message is available).
   *
   * <p>Example of asynchronously pulling a maximum number of messages from a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Future<Iterator<ReceivedMessage>> future = pubsub.pullAsync(subscriptionName, 100);
   * // ...
   * Iterator<ReceivedMessage> messages = future.get();
   * // Ack deadline is renewed until the message is consumed
   * while (messages.hasNext()) {
   *   ReceivedMessage message = messages.next();
   *   // do something with message and ack/nack it
   *   message.ack(); // or message.nack()
   * }
   * }</pre>
   *
   * @param subscription the subscription from which to pull messages
   * @param maxMessages the maximum number of messages pulled by this method. This method can
   *     possibly return fewer messages.
   * @throws PubSubException upon failure
   */
  Future<Iterator<ReceivedMessage>> pullAsync(String subscription, int maxMessages);

  /**
   * Creates a message consumer that pulls messages from the provided subscription. You can stop
   * pulling messages by calling {@link MessageConsumer#close()}. The returned message consumer
   * executes {@link MessageProcessor#process(Message)} on each pulled message. If
   * {@link MessageProcessor#process(Message)} executes correctly, the message is acknowledged. If
   * {@link MessageProcessor#process(Message)} throws an exception, the message is "nacked". For
   * all pulled messages, the ack deadline is automatically renewed until the message is either
   * acknowledged or "nacked".
   *
   * <p>The {@link PullOption#maxQueuedCallbacks(int)} option can be used to control the maximum
   * number of queued messages (messages either being processed or waiting to be processed). The
   * {@link PullOption#executorFactory(ExecutorFactory)} can be used to provide an executor to run
   * message processor callbacks.
   *
   * <p>Example of continuously pulling messages from a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * MessageProcessor callback = new MessageProcessor() {
   *   public void process(Message message) throws Exception {
   *     // Ack deadline is renewed until this method returns
   *     // Message is acked if this method returns successfully
   *     // Message is nacked if this method throws an exception
   *   }
   * };
   * PubSub.MessageConsumer consumer = pubsub.pullAsync(subscriptionName, callback);
   * // ...
   * // Stop pulling
   * consumer.close();
   * }</pre>
   *
   * @param subscription the subscription from which to pull messages
   * @param callback the callback to be executed on each message
   * @param options pulling options
   * @return a message consumer for the provided subscription and options
   */
  MessageConsumer pullAsync(String subscription, MessageProcessor callback, PullOption... options);

  /**
   * Acknowledges the given messages for the provided subscription. Ack ids identify the messages to
   * acknowledge, as returned in {@link ReceivedMessage#ackId()} by {@link #pull(String, int)} and
   * {@link #pullAsync(String, int)}.
   *
   * <p>Example of acking one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * pubsub.ack(subscriptionName, ackId);
   * }</pre>
   *
   * <p>Example of acking more messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * pubsub.ack(subscriptionName, ackId1, ackId2);
   * }</pre>
   *
   * @param subscription the subscription whose messages must be acknowledged
   * @param ackId the ack id of the first message to acknowledge
   * @param ackIds other ack ids of messages to acknowledge
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void ack(String subscription, String ackId, String... ackIds);

  /**
   * Sends a request to acknowledge the given messages for the provided subscription. Ack ids
   * identify the messages to acknowledge, as returned in {@link ReceivedMessage#ackId()} by
   * {@link #pull(String, int)} and {@link #pullAsync(String, int)}. The method returns a
   * {@code Future} object that can be used to wait for the acknowledge operation to be completed.
   *
   * <p>Example of asynchronously acking one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * Future<Void> future = pubsub.ackAsync(subscriptionName, ackId);
   * // ...
   * future.get();
   * }</pre>
   *
   * <p>Example of asynchronously acking more messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * Future<Void> future = pubsub.ackAsync(subscriptionName, ackId1, ackId2);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages must be acknowledged
   * @param ackId the ack id of the first message to acknowledge
   * @param ackIds other ack ids of messages to acknowledge
   */
  Future<Void> ackAsync(String subscription, String ackId, String... ackIds);

  /**
   * Acknowledges the given messages for the provided subscription. Ack ids identify the messages to
   * acknowledge, as returned in {@link ReceivedMessage#ackId()} by {@link #pull(String, int)} and
   * {@link #pullAsync(String, int)}.
   *
   * <p>Example of acking a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * pubsub.ack(subscriptionName, ackIds);
   * }</pre>
   *
   * @param subscription the subscription whose messages must be acknowledged
   * @param ackIds the ack ids of messages to acknowledge
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void ack(String subscription, Iterable<String> ackIds);

  /**
   * Sends a request to acknowledge the given messages for the provided subscription. Ack ids
   * identify the messages to acknowledge, as returned in {@link ReceivedMessage#ackId()} by
   * {@link #pull(String, int)} and {@link #pullAsync(String, int)}. The method returns a
   * {@code Future} object that can be used to wait for the acknowledge operation to be completed.
   *
   * <p>Example of asynchronously acking a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * Future<Void> future = pubsub.ackAsync(subscriptionName, ackIds);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages must be acknowledged
   * @param ackIds the ack ids of messages to acknowledge
   */
  Future<Void> ackAsync(String subscription, Iterable<String> ackIds);

  /**
   * "Nacks" the given messages for the provided subscription. Ack ids identify the messages to
   * "nack", as returned in {@link ReceivedMessage#ackId()} by {@link #pull(String, int)} and
   * {@link #pullAsync(String, int)}. This method corresponds to calling
   * {@link #modifyAckDeadline(String, int, TimeUnit, String, String...)} with a deadline of 0.
   *
   * <p>Example of nacking one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * pubsub.nack(subscriptionName, ackId);
   * }</pre>
   *
   * <p>Example of nacking more messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * pubsub.nack(subscriptionName, ackId1, ackId2);
   * }</pre>
   *
   * @param subscription the subscription whose messages must be "nacked"
   * @param ackId the ack id of the first message to "nack"
   * @param ackIds other ack ids of messages to "nack"
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void nack(String subscription, String ackId, String... ackIds);

  /**
   * Sends a request to "nack" the given messages for the provided subscription. Ack ids identify
   * the messages to "nack", as returned in {@link ReceivedMessage#ackId()} by
   * {@link #pull(String, int)} and {@link #pullAsync(String, int)}. This method corresponds to
   * calling {@link #modifyAckDeadlineAsync(String, int, TimeUnit, String, String...)} with a
   * deadline of 0. The method returns a {@code Future} object that can be used to wait for the
   * "nack" operation to be completed.
   *
   * <p>Example of asynchronously nacking one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * Future<Void> future = pubsub.nackAsync(subscriptionName, ackId);
   * // ...
   * future.get();
   * }</pre>
   *
   * <p>Example of asynchronously nacking more messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * Future<Void> future = pubsub.nackAsync(subscriptionName, ackId1, ackId2);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages must be "nacked"
   * @param ackId the ack id of the first message to "nack"
   * @param ackIds other ack ids of messages to "nack"
   */
  Future<Void> nackAsync(String subscription, String ackId, String... ackIds);

  /**
   * "Nacks" the given messages for the provided subscription. Ack ids identify the messages to
   * "nack", as returned in {@link ReceivedMessage#ackId()} by {@link #pull(String, int)} and
   * {@link #pullAsync(String, int)}. This method corresponds to calling
   * {@link #modifyAckDeadline(String, int, TimeUnit, Iterable)} with a deadline of 0.
   *
   * <p>Example of nacking a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * pubsub.nack(subscriptionName, ackIds);
   * }</pre>
   *
   * @param subscription the subscription whose messages must be "nacked"
   * @param ackIds the ack ids of messages to "nack"
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void nack(String subscription, Iterable<String> ackIds);

  /**
   * Sends a request to "nack" the given messages for the provided subscription. Ack ids identify
   * the messages to "nack", as returned in {@link ReceivedMessage#ackId()} by
   * {@link #pull(String, int)} and {@link #pullAsync(String, int)}. This method corresponds to
   * calling {@link #modifyAckDeadlineAsync(String, int, TimeUnit, Iterable)} with a deadline of 0.
   * The method returns a {@code Future} object that can be used to wait for the "nack" operation to
   * be completed.
   *
   * <p>Example of asynchronously nacking a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * Future<Void> future = pubsub.nackAsync(subscriptionName, ackIds);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages must be "nacked"
   * @param ackIds the ack ids of messages to "nack"
   */
  Future<Void> nackAsync(String subscription, Iterable<String> ackIds);

  /**
   * Modifies the acknowledge deadline of the given messages. {@code deadline} must be &gt;= 0 and
   * is the new deadline with respect to the time the modify request was received by the Pub/Sub
   * service. For example, if {@code deadline} is 10 and {@code unit} is {@link TimeUnit#SECONDS},
   * the new ack deadline will expire 10 seconds after the modify request was received by the
   * service. Specifying 0 may be used to make the message available for another pull request
   * (corresponds to calling {@link #nack(String, String, String...)}).
   *
   * <p>Example of modifying the ack deadline of one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * pubsub.modifyAckDeadline(subscriptionName, 60, TimeUnit.SECONDS, ackId);
   * }</pre>
   *
   * <p>Example of modifying the ack deadline of some messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * pubsub.modifyAckDeadline(subscriptionName, 60, TimeUnit.SECONDS, ackId1, ackId2);
   * }</pre>
   *
   * @param subscription the subscription whose messages need to update their acknowledge deadline
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit time unit for the {@code deadline} parameter
   * @param ackId the ack id of the first message for which the acknowledge deadline must be
   *     modified
   * @param ackIds other ack ids of messages for which the acknowledge deadline must be modified
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, String ackId,
      String... ackIds);

  /**
   * Sends a request to modify the acknowledge deadline of the given messages. {@code deadline}
   * must be &gt;= 0 and is the new deadline with respect to the time the modify request was
   * received by the Pub/Sub service. For example, if {@code deadline} is 10 and {@code unit} is
   * {@link TimeUnit#SECONDS}, the new ack deadline will expire 10 seconds after the modify request
   * was received by the service. Specifying 0 may be used to make the message available for another
   * pull request (corresponds to calling {@link #nackAsync(String, Iterable)}). The method returns
   * a {@code Future} object that can be used to wait for the modify operation to be completed.
   *
   * <p>Example of asynchronously modifying the ack deadline of one message.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId = "message_ack_id";
   * Future<Void> future =
   *     pubsub.modifyAckDeadlineAsync(subscriptionName, 60, TimeUnit.SECONDS, ackId);
   * // ...
   * future.get();
   * }</pre>
   *
   * <p>Example of asynchronously modifying the ack deadline of some messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * Future<Void> future =
   *     pubsub.modifyAckDeadlineAsync(subscriptionName, 60, TimeUnit.SECONDS, ackId1, ackId2);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages need to update their acknowledge deadline
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit time unit for the {@code deadline} parameter
   * @param ackId the ack id of the first message for which the acknowledge deadline must be
   *     modified
   * @param ackIds other ack ids of messages for which the acknowledge deadline must be modified
   */
  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      String ackId, String... ackIds);

  /**
   * Modifies the acknowledge deadline of the given messages. {@code deadline} must be &gt;= 0 and
   * is the new deadline with respect to the time the modify request was received by the Pub/Sub
   * service. For example, if {@code deadline} is 10 and {@code unit} is {@link TimeUnit#SECONDS},
   * the new ack deadline will expire 10 seconds after the modify request was received by the
   * service. Specifying 0 may be used to make the message available for another pull request
   * (corresponds to calling {@link #nack(String, Iterable)}).
   *
   * <p>Example of modifying the ack deadline of a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * pubsub.modifyAckDeadline(subscriptionName, 60, TimeUnit.SECONDS, ackIds);
   * }</pre>
   *
   * @param subscription the subscription whose messages need to update their acknowledge deadline
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit time unit for the {@code deadline} parameter
   * @param ackIds the ack ids of messages for which the acknowledge deadline must be modified
   * @throws PubSubException upon failure, or if the subscription was not found
   */
  void modifyAckDeadline(String subscription, int deadline, TimeUnit unit, Iterable<String> ackIds);

  /**
   * Sends a request to modify the acknowledge deadline of the given messages. {@code deadline}
   * must be &gt;= 0 and is the new deadline with respect to the time the modify request was
   * received by the Pub/Sub service. For example, if {@code deadline} is 10 and {@code unit} is
   * {@link TimeUnit#SECONDS}, the new ack deadline will expire 10 seconds after the modify request
   * was received by the service. Specifying 0 may be used to make the message available for another
   * pull request (corresponds to calling {@link #nackAsync(String, Iterable)}). The method returns
   * a {@code Future} object that can be used to wait for the modify operation to be completed.
   *
   * <p>Example of asynchronously modifying the ack deadline of a list of messages.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * String ackId1 = "message1_ack_id";
   * String ackId2 = "message2_ack_id";
   * List<String> ackIds = new LinkedList<>();
   * ackIds.add(ackId1);
   * ackIds.add(ackId2);
   * Future<Void> future =
   *     pubsub.modifyAckDeadlineAsync(subscriptionName, 60, TimeUnit.SECONDS, ackIds);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param subscription the subscription whose messages need to update their acknowledge deadline
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit time unit for the {@code deadline} parameter
   * @param ackIds the ack ids of messages for which the acknowledge deadline must be modified
   */
  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds);

  /**
   * Returns the IAM access control policy for the specified topic. Returns {@code null} if the
   * topic was not found.
   *
   * <p>Example of getting a topic policy.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Policy policy = pubsub.getTopicPolicy(topicName);
   * if (policy == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Policy getTopicPolicy(String topic);

  /**
   * Sends a request for getting the IAM access control policy for the specified topic. This method
   * returns a {@code Future} object to consume the result. {@link Future#get()} returns the
   * requested policy or {@code null} if the topic was not found.
   *
   * <p>Example of asynchronously getting a topic policy.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Future<Policy> future = pubsub.getTopicPolicyAsync(topicName);
   * // ...
   * Policy policy = future.get();
   * if (policy == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<Policy> getTopicPolicyAsync(String topic);

  /**
   * Sets the IAM access control policy for the specified topic. Replaces any existing policy. This
   * method returns the new policy.
   *
   * <p>It is recommended that you use the read-modify-write pattern. This pattern entails reading
   * the project's current policy, updating it locally, and then sending the modified policy for
   * writing. Cloud IAM solves the problem of conflicting processes simultaneously attempting to
   * modify a policy by using the {@link Policy#etag etag} property. This property is used to
   * verify whether the policy has changed since the last request. When you make a request with an
   * etag value, the value in the request is compared with the existing etag value associated with
   * the policy. The policy is written only if the etag values match. If the etags don't match, a
   * {@code PubSubException} is thrown, denoting that the server aborted update. If an etag is not
   * provided, the policy is overwritten blindly.
   *
   * <p>Example of replacing a topic policy.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Policy policy = pubsub.getTopicPolicy(topicName);
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * updatedPolicy = pubsub.replaceTopicPolicy(topicName, updatedPolicy);
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Policy replaceTopicPolicy(String topic, Policy newPolicy);

  /**
   * Sends a request to set the IAM access control policy for the specified topic. Replaces any
   * existing policy. This method returns a {@code Future} object to consume the result.
   * {@link Future#get()} returns the new policy.
   *
   * <p>It is recommended that you use the read-modify-write pattern. This pattern entails reading
   * the project's current policy, updating it locally, and then sending the modified policy for
   * writing. Cloud IAM solves the problem of conflicting processes simultaneously attempting to
   * modify a policy by using the {@link Policy#etag etag} property. This property is used to
   * verify whether the policy has changed since the last request. When you make a request with an
   * etag value, the value in the request is compared with the existing etag value associated with
   * the policy. The policy is written only if the etag values match. If the etags don't match,
   * {@link Future#get()} will throw a {@link java.util.concurrent.ExecutionException} caused by a
   * {@code PubSubException}, denoting that the server aborted update. If an etag is not provided,
   * the policy is overwritten blindly.
   *
   * <p>Example of asynchronously replacing a topic policy.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * Policy policy = pubsub.getTopicPolicy(topicName);
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * Future<Policy> future = pubsub.replaceTopicPolicyAsync(topicName, updatedPolicy);
   * // ...
   * updatedPolicy = future.get();
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<Policy> replaceTopicPolicyAsync(String topic, Policy newPolicy);

  /**
   * Returns the permissions that a caller has on the specified topic.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of testing whether the caller has the provided permissions on a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.topics.get");
   * List<Boolean> testedPermissions = pubsub.testTopicPermissions(topicName, permissions);
   * }</pre>
   *
   * @return A list of booleans representing whether the caller has the permissions specified (in
   *     the order of the given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  List<Boolean> testTopicPermissions(String topic, List<String> permissions);

  /**
   * Sends a request to get the permissions that a caller has on the specified topic.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of asynchronously testing whether the caller has the provided permissions on a topic.
   * <pre> {@code
   * String topicName = "my_topic_name";
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.topics.get");
   * Future<List<Boolean>> future = pubsub.testTopicPermissionsAsync(topicName, permissions);
   * // ...
   * List<Boolean> testedPermissions = future.get();
   * }</pre>
   *
   * @return A {@code Future} object to consume the result. {@link Future#get()} returns a list of
   *     booleans representing whether the caller has the permissions specified (in the order of the
   *     given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  Future<List<Boolean>> testTopicPermissionsAsync(String topic, List<String> permissions);

  /**
   * Returns the IAM access control policy for the specified subscription. Returns {@code null} if
   * the subscription was not found.
   *
   * <p>Example of getting a subscription policy.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
   * if (policy == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Policy getSubscriptionPolicy(String subscription);

  /**
   * Sends a request for getting the IAM access control policy for the specified subscription. This
   * method returns a {@code Future} object to consume the result. {@link Future#get()} returns the
   * requested policy or {@code null} if the subscription was not found.
   *
   * <p>Example of asynchronously getting a subscription policy.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Future<Policy> future = pubsub.getSubscriptionPolicyAsync(subscriptionName);
   * // ...
   * Policy policy = future.get();
   * if (policy == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<Policy> getSubscriptionPolicyAsync(String subscription);

  /**
   * Sets the IAM access control policy for the specified subscription. Replaces any existing
   * policy. This method returns the new policy.
   *
   * <p>It is recommended that you use the read-modify-write pattern. This pattern entails reading
   * the project's current policy, updating it locally, and then sending the modified policy for
   * writing. Cloud IAM solves the problem of conflicting processes simultaneously attempting to
   * modify a policy by using the {@link Policy#etag etag} property. This property is used to
   * verify whether the policy has changed since the last request. When you make a request with an
   * etag value, the value in the request is compared with the existing etag value associated with
   * the policy. The policy is written only if the etag values match. If the etags don't match, a
   * {@code PubSubException} is thrown, denoting that the server aborted update. If an etag is not
   * provided, the policy is overwritten blindly.
   *
   * <p>Example of replacing a subscription policy.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * updatedPolicy = pubsub.replaceSubscriptionPolicy(subscriptionName, updatedPolicy);
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Policy replaceSubscriptionPolicy(String subscription, Policy newPolicy);

  /**
   * Sends a request to set the IAM access control policy for the specified subscription. Replaces
   * any existing policy. This method returns a {@code Future} object to consume the result.
   * {@link Future#get()} returns the new policy.
   *
   * <p>It is recommended that you use the read-modify-write pattern. This pattern entails reading
   * the project's current policy, updating it locally, and then sending the modified policy for
   * writing. Cloud IAM solves the problem of conflicting processes simultaneously attempting to
   * modify a policy by using the {@link Policy#etag etag} property. This property is used to
   * verify whether the policy has changed since the last request. When you make a request with an
   * etag value, the value in the request is compared with the existing etag value associated with
   * the policy. The policy is written only if the etag values match. If the etags don't match,
   * {@link Future#get()} will throw a {@link java.util.concurrent.ExecutionException} caused by a
   * {@code PubSubException}, denoting that the server aborted update. If an etag is not provided,
   * the policy is overwritten blindly.
   *
   * <p>Example of asynchronously replacing a subscription policy.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * Policy policy = pubsub.getSubscriptionPolicy(subscriptionName);
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * Future<Policy> future =
   *     pubsub.replaceSubscriptionPolicyAsync(subscriptionName, updatedPolicy);
   * // ...
   * updatedPolicy = future.get();
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  Future<Policy> replaceSubscriptionPolicyAsync(String subscription, Policy newPolicy);

  /**
   * Returns the permissions that a caller has on the specified subscription. You typically don't
   * call this method if you're using Google Cloud Platform directly to manage permissions. This
   * method is intended for integration with your proprietary software, such as a customized
   * graphical user interface. For example, the Cloud Platform Console tests IAM permissions
   * internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of testing whether the caller has the provided permissions on a subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.subscriptions.get");
   * List<Boolean> testedPermissions =
   *     pubsub.testSubscriptionPermissions(subscriptionName, permissions);
   * }</pre>
   *
   * @return A list of booleans representing whether the caller has the permissions specified (in
   *     the order of the given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  List<Boolean> testSubscriptionPermissions(String subscription, List<String> permissions);

  /**
   * Sends a request to get the permissions that a caller has on the specified subscription.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of asynchronously testing whether the caller has the provided permissions on a
   * subscription.
   * <pre> {@code
   * String subscriptionName = "my_subscription_name";
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.subscriptions.get");
   * Future<List<Boolean>> future =
   *     pubsub.testSubscriptionPermissionsAsync(subscriptionName, permissions);
   * // ...
   * List<Boolean> testedPermissions = future.get();
   * }</pre>
   *
   * @return A {@code Future} object to consume the result. {@link Future#get()} returns a list of
   *     booleans representing whether the caller has the permissions specified (in the order of the
   *     given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  Future<List<Boolean>> testSubscriptionPermissionsAsync(String subscription,
      List<String> permissions);
}
