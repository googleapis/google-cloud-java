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

  /**
   * Pulls messages from the provided subscription. This method possibly returns no messages if no
   * message was available at the time the request was processed by the Pub/Sub service (i.e. the
   * system is not allowed to wait until at least one message is available). Pulled messages have
   * their acknowledge deadline automatically renewed until they are explicitly consumed using
   * {@link Iterator#next()}.
   *
   * <p>Example usage of synchronous message pulling:
   * <pre> {@code
   * Iterator<ReceivedMessage> messageIterator = pubsub.pull("subscription", 100);
   * while (messageIterator.hasNext()) {
   *   ReceivedMessage message = messageIterator.next();
   *   // message's acknowledge deadline is no longer automatically renewed. If processing takes
   *   // long pubsub.modifyAckDeadline(String, String, long, TimeUnit) can be used to extend it.
   *   doSomething(message);
   *   message.ack(); // or message.nack()
   * }}</pre>
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
   * <p>Example usage of asynchronous message pulling:
   * <pre> {@code
   * Future<Iterator<ReceivedMessage>> future = pubsub.pull("subscription", 100);
   * // do something while the request gets processed
   * Iterator<ReceivedMessage> messageIterator = future.get();
   * while (messageIterator.hasNext()) {
   *   ReceivedMessage message = messageIterator.next();
   *   // message's acknowledge deadline is no longer automatically renewed. If processing takes
   *   // long pubsub.modifyAckDeadline(String, String, long, TimeUnit) can be used to extend it.
   *   doSomething(message);
   *   message.ack(); // or message.nack()
   * }}</pre>
   *
   * @param subscription the subscription from which to pull messages
   * @param maxMessages the maximum number of messages pulled by this method. This method can
   *     possibly return fewer messages.
   * @throws PubSubException upon failure
   */
  Future<Iterator<ReceivedMessage>> pullAsync(String subscription, int maxMessages);

  /**
   * Creates a message consumer that pulls messages for the provided subscription. You can stop
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
   * @param subscription the subscription whose messages need to update their acknowledge deadline
   * @param deadline the new deadline, relative to the time the modify request is received by the
   *     Pub/Sub service
   * @param unit time unit for the {@code deadline} parameter
   * @param ackIds the ack ids of messages for which the acknowledge deadline must be modified
   */
  Future<Void> modifyAckDeadlineAsync(String subscription, int deadline, TimeUnit unit,
      Iterable<String> ackIds);

  // IAM Policy operations:  getPolicy, replacePolicy, testPermissions
  // Not sure if ready (docs is not up-to-date)
  // Looks like policy is per resource (topic or subscription) but not per service?
}
