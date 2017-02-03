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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.AsyncPage;
import com.google.cloud.Page;
import com.google.cloud.Policy;
import com.google.cloud.pubsub.PubSub.ListOption;
import com.google.common.base.Function;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * A Google Cloud Pub/Sub topic. A topic is a named resource to which messages are sent by
 * publishers. Subscribers can receive messages sent to a topic by creating subscriptions.
 * {@code Topic} adds a layer of service-related functionality over {@link TopicInfo}. Objects of
 * this class are immutable. To get a {@code Topic} object with the most recent information use
 * {@link #reload} or {@link #reloadAsync}.
 *
 * @see <a href="https://cloud.google.com/pubsub/overview#data_model">Pub/Sub Data Model</a>
 */
public class Topic extends TopicInfo {

  private static final long serialVersionUID = -2686692223763315944L;

  private final PubSubOptions options;
  private transient PubSub pubsub;

  /**
   * A builder for {@code Topic} objects.
   */
  public static final class Builder extends TopicInfo.Builder {

    private final PubSub pubsub;
    private final BuilderImpl delegate;

    private Builder(Topic topic) {
      pubsub = topic.pubsub;
      delegate = new BuilderImpl(topic);
    }

    @Override
    @Deprecated
    public Builder name(String name) {
      return setName(name);
    }

    @Override
    public Builder setName(String name) {
      delegate.setName(name);
      return this;
    }

    @Override
    public Topic build() {
      return new Topic(this.pubsub, this.delegate);
    }
  }

  Topic(PubSub pubsub, BuilderImpl builder) {
    super(builder);
    this.pubsub = checkNotNull(pubsub);
    options = pubsub.getOptions();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public final int hashCode() {
    return Objects.hash(options, super.hashCode());
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Topic.class)) {
      return false;
    }
    Topic other = (Topic) obj;
    return baseEquals(other) && Objects.equals(options, other.options);
  }

  /**
   * Returns the topic's {@code PubSub} object used to issue requests.
   */
  @Deprecated
  public PubSub pubSub() {
    return getPubsub();
  }

  /**
   * Returns the topic's {@code PubSub} object used to issue requests.
   */
  public PubSub getPubsub() {
    return pubsub;
  }

  /**
   * Deletes this topic.
   *
   * <p>Example of deleting the topic.
   * <pre> {@code
   * boolean deleted = topic.delete();
   * if (deleted) {
   *   // the topic was deleted
   * } else {
   *   // the topic was not found
   * }
   * }</pre>
   *
   * @return {@code true} if the topic was deleted, {@code false} if it was not found
   * @throws PubSubException upon failure
   */
  public boolean delete() {
    return pubsub.deleteTopic(getName());
  }

  /**
   * Sends a request for deleting this topic. This method returns a {@code Future} object to consume
   * the result. {@link Future#get()} returns {@code true} if the topic was deleted, {@code false}
   * if it was not found.
   *
   * <p>Example of asynchronously deleting the topic.
   * <pre> {@code
   * Future<Boolean> future = topic.deleteAsync();
   * // ...
   * boolean deleted = future.get();
   * if (deleted) {
   *   // the topic was deleted
   * } else {
   *   // the topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Boolean> deleteAsync() {
    return pubsub.deleteTopicAsync(getName());
  }

  /**
   * Fetches current topic's latest information. Returns {@code null} if the topic does not exist.
   *
   * <p>Example of getting the topic's latest information.
   * <pre> {@code
   * Topic latestTopic = topic.reload();
   * if (latestTopic == null) {
   *   // the topic was not found
   * }
   * }</pre>
   *
   * @return a {@code Topic} object with latest information or {@code null} if not found
   * @throws PubSubException upon failure
   */
  public Topic reload() {
    return pubsub.getTopic(getName());
  }

  /**
   * Sends a request to fetch current topic's latest information. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a {@code Topic}
   * object with latest information or {@code null} if not found.
   *
   * <p>Example of asynchronously getting the topic's latest information.
   * <pre> {@code
   * Future<Topic> future = topic.reloadAsync();
   * // ...
   * Topic latestTopic = future.get();
   * if (latestTopic == null) {
   *   // the topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Topic> reloadAsync() {
    return pubsub.getTopicAsync(getName());
  }

  /**
   * Publishes a message to this topic. This method returns a service-generated id for the published
   * message. Service-generated ids are guaranteed to be unique within the topic.
   *
   * <p>Example of publishing one message to the topic.
   * <pre> {@code
   * Message message = Message.of("payload");
   * String messageId = topic.publish(message);
   * }</pre>
   *
   * @param message the message to publish
   * @return a unique service-generated id for the message
   * @throws PubSubException upon failure, if the topic does not exist or if the message has empty
   *     payload and no attributes
   */
  public String publish(Message message) {
    return pubsub.publish(getName(), message);
  }

  /**
   * Sends a request for publishing a message to the this topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a service-generated
   * id for the published message. Service-generated ids are guaranteed to be unique within the
   * topic.
   *
   * <p>Example of asynchronously publishing one message to the topic.
   * <pre> {@code
   * Message message = Message.of("payload");
   * Future<String> future = topic.publishAsync(message);
   * // ...
   * String messageId = future.get();
   * }</pre>
   *
   * @param message the message to publish
   * @return a {@code Future} for the unique service-generated id for the message
   */
  public Future<String> publishAsync(Message message) {
    return pubsub.publishAsync(getName(), message);
  }

  /**
   * Publishes a number of messages to this topic. This method returns a list of service-generated
   * ids for the published messages. Service-generated ids are guaranteed to be unique within the
   * topic.
   *
   * <p>Example of publishing some messages to the topic.
   * <pre> {@code
   * Message message1 = Message.of("payload1");
   * Message message2 = Message.of("payload2");
   * List<String> messageIds = topic.publish(message1, message2);
   * }</pre>
   *
   * @param message the first message to publish
   * @param messages other messages to publish
   * @return a list of unique, service-generated, ids. Ids are in the same order as the messages.
   * @throws PubSubException upon failure, if the topic does not exist or if one of the messages has
   *     empty payload and no attributes
   */
  public List<String> publish(Message message, Message... messages) {
    return pubsub.publish(getName(), message, messages);
  }

  /**
   * Sends a request to publish a number of messages to this topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * <p>Example of asynchronously publishing some messages to the topic.
   * <pre> {@code
   * Message message1 = Message.of("payload1");
   * Message message2 = Message.of("payload2");
   * Future<List<String>> future = topic.publishAsync(message1, message2);
   * // ...
   * List<String> messageIds = future.get();
   * }</pre>
   *
   * @param message the first message to publish
   * @param messages other messages to publish
   * @return a {@code Future} for the unique, service-generated ids. Ids are in the same order as
   *     the messages.
   */
  public Future<List<String>> publishAsync(Message message, Message... messages) {
    return pubsub.publishAsync(getName(), message, messages);
  }

  /**
   * Publishes a number of messages to this topic. This method returns a list ofservice-generated
   * ids for the published messages. Service-generated ids are guaranteed to be unique within the
   * topic.
   *
   * <p>Example of publishing a list of messages to the topic.
   * <pre> {@code
   * List<Message> messages = new LinkedList<>();
   * messages.add(Message.of("payload1"));
   * messages.add(Message.of("payload2"));
   * List<String> messageIds = topic.publish(messages);
   * }</pre>
   *
   * @param messages the messages to publish
   * @return a list of unique, service-generated, ids. Ids are in the same order as the messages.
   * @throws PubSubException upon failure, if the topic does not exist or if one of the messages has
   *     empty payload and no attributes
   */
  public List<String> publish(Iterable<Message> messages) {
    return pubsub.publish(getName(), messages);
  }

  /**
   * Sends a request to publish a number of messages to this topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns a list of
   * service-generated ids for the published messages. Service-generated ids are guaranteed to be
   * unique within the topic.
   *
   * <p>Example of asynchronously publishing a list of messages to the topic.
   * <pre> {@code
   * List<Message> messages = new LinkedList<>();
   * messages.add(Message.of("payload1"));
   * messages.add(Message.of("payload2"));
   * Future<List<String>> future = topic.publishAsync(messages);
   * // ...
   * List<String> messageIds = future.get();
   * }</pre>
   *
   * @param messages the messages to publish
   * @return a {@code Future} for the unique, service-generated ids. Ids are in the same order as
   *     the messages.
   */
  public Future<List<String>> publishAsync(Iterable<Message> messages) {
    return pubsub.publishAsync(getName(), messages);
  }

  /**
   * Lists the identities of the subscriptions for this topic. This method returns a {@link Page}
   * object that can be used to consume paginated results. Use {@link ListOption} to specify the
   * page size or the page token from which to start listing subscriptions.
   *
   * <p>Example of listing subscriptions for the topic, specifying the page size.
   * <pre> {@code
   * Page<SubscriptionId> subscriptions = topic.listSubscriptions(ListOption.pageSize(100));
   * Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   SubscriptionId subscription = subscriptionIterator.next();
   *   // do something with the subscription identity
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Page<SubscriptionId> listSubscriptions(ListOption... options) {
    return pubsub.listSubscriptions(getName(), options);
  }

  /**
   * Sends a request for listing the identities of subscriptions for this topic. This method returns
   * a {@code Future} object to consume the result. {@link Future#get()} returns an
   * {@link AsyncPage} object that can be used to asynchronously handle paginated results. Use
   * {@link ListOption} to specify the page size or the page token from which to start listing
   * subscriptions.
   *
   * <p>Example of asynchronously listing subscriptions for the topic, specifying the page size.
   * <pre> {@code
   * Future<AsyncPage<SubscriptionId>> future =
   *     topic.listSubscriptionsAsync(ListOption.pageSize(100));
   * // ...
   * AsyncPage<SubscriptionId> subscriptions = future.get();
   * Iterator<SubscriptionId> subscriptionIterator = subscriptions.iterateAll();
   * while (subscriptionIterator.hasNext()) {
   *   SubscriptionId subscription = subscriptionIterator.next();
   *   // do something with the subscription identity
   * }
   * }</pre>
   *
   */
  public Future<AsyncPage<SubscriptionId>> listSubscriptionsAsync(ListOption... options) {
    return pubsub.listSubscriptionsAsync(getName(), options);
  }

  /**
   * Returns the IAM access control policy for this topic. Returns {@code null} if the topic was not
   * found.
   *
   * <p>Example of getting the topic's policy.
   * <pre> {@code
   * Policy policy = topic.getPolicy();
   * if (policy == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Policy getPolicy() {
    return pubsub.getTopicPolicy(this.getName());
  }

  /**
   * Sends a request for getting the IAM access control policy for this topic. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns the requested policy
   * or {@code null} if the topic was not found.
   *
   * <p>Example of asynchronously getting the topic's policy.
   * <pre> {@code
   * Future<Policy> future = topic.getPolicyAsync();
   * // ...
   * Policy policy = future.get();
   * if (policy == null) {
   *   // topic was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Policy> getPolicyAsync() {
    return pubsub.getTopicPolicyAsync(this.getName());
  }

  /**
   * Sets the IAM access control policy for this topic. Replaces any existing policy. This method
   * returns the new policy.
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
   * <p>Example of replacing the topic's policy.
   * <pre> {@code
   * Policy policy = topic.getPolicy();
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * updatedPolicy = topic.replacePolicy(updatedPolicy);
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Policy replacePolicy(Policy newPolicy) {
    return pubsub.replaceTopicPolicy(this.getName(), newPolicy);
  }

  /**
   * Sends a request to set the IAM access control policy for this topic. Replaces any existing
   * policy. This method returns a {@code Future} object to consume the result. {@link Future#get()}
   * returns the new policy.
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
   * <p>Example of asynchronously replacing the topic's policy.
   * <pre> {@code
   * Policy policy = topic.getPolicy();
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * Future<Policy> future = topic.replacePolicyAsync(updatedPolicy);
   * // ...
   * updatedPolicy = future.get();
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Policy> replacePolicyAsync(Policy newPolicy) {
    return pubsub.replaceTopicPolicyAsync(this.getName(), newPolicy);
  }

  /**
   * Returns the permissions that a caller has on this topic.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of testing whether the caller has the provided permissions on the topic.
   * <pre> {@code
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.topics.get");
   * List<Boolean> testedPermissions = topic.testPermissions(permissions);
   * }</pre>
   *
   * @return A list of booleans representing whether the caller has the permissions specified (in
   *     the order of the given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  public List<Boolean> testPermissions(List<String> permissions) {
    return pubsub.testTopicPermissions(this.getName(), permissions);
  }

  /**
   * Sends a request to get the permissions that a caller has on this topic.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of asynchronously testing whether the caller has the provided permissions on the
   * topic.
   * <pre> {@code
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.topics.get");
   * Future<List<Boolean>> future = topic.testPermissionsAsync(permissions);
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
  public Future<List<Boolean>> testPermissionsAsync(List<String> permissions) {
    return pubsub.testTopicPermissionsAsync(this.getName(), permissions);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.pubsub = options.getService();
  }

  static Topic fromPb(PubSub pubsub, com.google.pubsub.v1.Topic topicPb) {
    TopicInfo topicInfo = TopicInfo.fromPb(topicPb);
    return new Topic(pubsub, new BuilderImpl(topicInfo));
  }

  static Function<com.google.pubsub.v1.Topic, Topic> fromPbFunction(final PubSub pubsub) {
    return new Function<com.google.pubsub.v1.Topic, Topic>() {
      @Override
      public Topic apply(com.google.pubsub.v1.Topic topicPb) {
        return topicPb != null ? fromPb(pubsub, topicPb) : null;
      }
    };
  }
}
