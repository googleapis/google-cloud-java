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
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

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

  Publisher getPublisher(TopicInfo topic) throws IOException;

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

  Subscriber getSubscriber(SubscriptionInfo subscription, Subscriber.MessageReceiver receiver)
      throws IOException;

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
