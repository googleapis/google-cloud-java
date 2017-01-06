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

import com.google.cloud.Policy;
import com.google.common.base.Function;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;

/**
 * A Google Cloud Pub/Sub subscription. A subscription represents the stream of messages from a
 * single, specific topic, to be delivered to the subscribing application. Pub/Sub subscriptions
 * support both push and pull message delivery.
 *
 * <p>In a push subscription, the Pub/Sub server sends a request to the subscriber application, at a
 * preconfigured endpoint (see {@link PushConfig}). The subscriber's HTTP response serves as an
 * implicit acknowledgement: a success response indicates that the message has been succesfully
 * processed and the Pub/Sub system can delete it from the subscription; a non-success response
 * indicates that the Pub/Sub server should resend it (implicit "nack").
 *
 * <p>In a pull subscription, the subscribing application must pull messages using {@link
 * PubSub#getSubscriber(SubscriptionInfo, Subscriber.MessageReceiver)}.
 *
 * <p>{@code Subscription} adds a layer of service-related functionality over {@link
 * SubscriptionInfo}. Objects of this class are immutable. To get a {@code Subscription} object with
 * the most recent information use {@link #reload} or {@link #reloadAsync}.
 *
 * @see <a href="https://cloud.google.com/pubsub/overview#data_model">Pub/Sub Data Model</a>
 * @see <a href="https://cloud.google.com/pubsub/subscriber">Subscriber Guide</a>
 */
public class Subscription extends SubscriptionInfo {

  private static final long serialVersionUID = -4153366055659552230L;

  private final PubSubOptions options;
  private transient PubSub pubsub;

  /**
   * A builder for {@code Subscription} objects.
   */
  public static final class Builder extends SubscriptionInfo.Builder {

    private final PubSub pubsub;
    private final BuilderImpl delegate;

    private Builder(Subscription subscription) {
      pubsub = subscription.pubsub;
      delegate = new BuilderImpl(subscription);
    }

    @Override
    @Deprecated
    public Builder topic(TopicId topic) {
      return setTopic(topic);
    }

    @Override
    public Builder setTopic(TopicId topic) {
      delegate.setTopic(topic);
      return this;
    }

    @Override
    @Deprecated
    public Builder topic(String project, String topic) {
      return setTopic(project, topic);
    }

    @Override
    public Builder setTopic(String project, String topic) {
      delegate.setTopic(project, topic);
      return this;
    }

    @Override
    @Deprecated
    public Builder topic(String topic) {
      return setTopic(topic);
    }

    @Override
    public Builder setTopic(String topic) {
      delegate.setTopic(topic);
      return this;
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
    @Deprecated
    public Builder pushConfig(PushConfig pushConfig) {
      return setPushConfig(pushConfig);
    }

    @Override
    public Builder setPushConfig(PushConfig pushConfig) {
      delegate.setPushConfig(pushConfig);
      return this;
    }

    @Override
    @Deprecated
    public Builder ackDeadLineSeconds(int ackDeadLineSeconds) {
      return setAckDeadLineSeconds(ackDeadLineSeconds);
    }

    @Override
    public Builder setAckDeadLineSeconds(int ackDeadLineSeconds) {
      delegate.setAckDeadLineSeconds(ackDeadLineSeconds);
      return this;
    }

    @Override
    public Subscription build() {
      return new Subscription(this.pubsub, this.delegate);
    }
  }

  Subscription(PubSub pubsub, BuilderImpl builder) {
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
    if (this == obj) {
      return true;
    }
    if (obj == null || !obj.getClass().equals(Subscription.class)) {
      return false;
    }
    Subscription other = (Subscription) obj;
    return baseEquals(other) && Objects.equals(options, other.options);
  }

  /**
   * Returns the subscription's {@code PubSub} object used to issue requests.
   */
  @Deprecated
  public PubSub pubSub() {
    return getPubsub();
  }

  /**
   * Returns the subscription's {@code PubSub} object used to issue requests.
   */
  public PubSub getPubsub() {
    return pubsub;
  }

  /**
   * Deletes this subscription.
   *
   * <p>Example of deleting the subscription.
   * <pre> {@code
   * boolean deleted = subscription.delete();
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
  public boolean delete() {
    return pubsub.deleteSubscription(getName());
  }

  /**
   * Sends a request for deleting this subscription. This method returns a {@code Future} object to
   * consume the result. {@link Future#get()} returns {@code true} if the subscription was deleted,
   * {@code false} if it was not found.
   *
   * <p>Example of asynchronously deleting the subscription.
   * <pre> {@code
   * Future<Boolean> future = subscription.deleteAsync();
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
  public Future<Boolean> deleteAsync() {
    return pubsub.deleteSubscriptionAsync(getName());
  }

  /**
   * Fetches current subscription's latest information. Returns {@code null} if the subscription
   * does not exist.
   *
   * <p>Example of getting the subscription's latest information.
   * <pre> {@code
   * Subscription latestSubscription = subscription.reload();
   * if (latestSubscription == null) {
   *   // the subscription was not found
   * }
   * }</pre>
   *
   * @return a {@code Subscription} object with latest information or {@code null} if not found
   * @throws PubSubException upon failure
   */
  public Subscription reload() {
    return pubsub.getSubscription(getName());
  }

  /**
   * Sends a request for fetching current subscription's latest information. This method returns a
   * {@code Future} object to consume the result. {@link Future#get()} returns the requested
   * subscription or {@code null} if not found.
   *
   * <p>Example of asynchronously getting the subscription's latest information.
   * <pre> {@code
   * Future<Subscription> future = subscription.reloadAsync();
   * // ...
   * Subscription latestSubscription = future.get();
   * if (latestSubscription == null) {
   *   // the subscription was not found
   * }
   * }</pre>
   *
   * @return a {@code Subscription} object with latest information or {@code null} if not found
   * @throws PubSubException upon failure
   */
  public Future<Subscription> reloadAsync() {
    return pubsub.getSubscriptionAsync(getName());
  }

  /**
   * Sets the push configuration for this subscription. This may be used to change a push
   * subscription to a pull one (passing a {@code null} {@code pushConfig} parameter) or vice versa.
   * This methods can also be used to change the endpoint URL and other attributes of a push
   * subscription. Messages will accumulate for delivery regardless of changes to the push
   * configuration.
   *
   * <p>Example of replacing the push configuration of the subscription, setting the push endpoint.
   * <pre> {@code
   * String endpoint = "https://www.example.com/push";
   * PushConfig pushConfig = PushConfig.of(endpoint);
   * subscription.replacePushConfig(pushConfig);
   * }</pre>
   *
   * <p>Example of replacing the push configuration of the subscription, making it a pull
   * subscription.
   * <pre> {@code
   * subscription.replacePushConfig(null);
   * }</pre>
   *
   * @param pushConfig the new push configuration. Use {@code null} to unset it
   * @throws PubSubException upon failure, or if the subscription does not exist
   */
  public void replacePushConfig(PushConfig pushConfig) {
    pubsub.replacePushConfig(getName(), pushConfig);
  }

  /**
   * Sends a request for updating the push configuration for a specified subscription. This may be
   * used to change a push subscription to a pull one (passing a {@code null} {@code pushConfig}
   * parameter) or vice versa. This methods can also be used to change the endpoint URL and other
   * attributes of a push subscription. Messages will accumulate for delivery regardless of changes
   * to the push configuration. The method returns a {@code Future} object that can be used to wait
   * for the replace operation to be completed.
   *
   * <p>Example of asynchronously replacing the push configuration of the subscription, setting the
   * push endpoint.
   * <pre> {@code
   * String endpoint = "https://www.example.com/push";
   * PushConfig pushConfig = PushConfig.of(endpoint);
   * Future<Void> future = subscription.replacePushConfigAsync(pushConfig);
   * // ...
   * future.get();
   * }</pre>
   *
   * <p>Example of asynchronously replacing the push configuration of the subscription, making it a
   * pull subscription.
   * <pre> {@code
   * Future<Void> future = subscription.replacePushConfigAsync(null);
   * // ...
   * future.get();
   * }</pre>
   *
   * @param pushConfig the new push configuration. Use {@code null} to unset it
   * @return a {@code Future} to wait for the replace operation to be completed.
   */
  public Future<Void> replacePushConfigAsync(PushConfig pushConfig) {
    return pubsub.replacePushConfigAsync(getName(), pushConfig);
  }

  /**
   * Returns the IAM access control policy for this subscription. Returns {@code null} if the
   * subscription was not found.
   *
   * <p>Example of getting the subscription's policy.
   * <pre> {@code
   * Policy policy = subscription.getPolicy();
   * if (policy == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Policy getPolicy() {
    return pubsub.getSubscriptionPolicy(this.getName());
  }

  /**
   * Sends a request for getting the IAM access control policy for this subscription. This method
   * returns a {@code Future} object to consume the result. {@link Future#get()} returns the
   * requested policy or {@code null} if the subscription was not found.
   *
   * <p>Example of asynchronously getting the subscription's policy.
   * <pre> {@code
   * Future<Policy> future = subscription.getPolicyAsync();
   * // ...
   * Policy policy = future.get();
   * if (policy == null) {
   *   // subscription was not found
   * }
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Policy> getPolicyAsync() {
    return pubsub.getSubscriptionPolicyAsync(this.getName());
  }

  /**
   * Sets the IAM access control policy for this subscription. Replaces any existing policy. This
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
   * <p>Example of replacing the subscription's policy.
   * <pre> {@code
   * Policy policy = subscription.getPolicy();
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * updatedPolicy = subscription.replacePolicy(updatedPolicy);
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Policy replacePolicy(Policy newPolicy) {
    return pubsub.replaceSubscriptionPolicy(this.getName(), newPolicy);
  }

  /**
   * Sends a request to set the IAM access control policy for this subscription. Replaces any
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
   * <p>Example of asynchronously replacing the subscription's policy.
   * <pre> {@code
   * Policy policy = subscription.getPolicy();
   * Policy updatedPolicy = policy.toBuilder()
   *     .addIdentity(Role.viewer(), Identity.allAuthenticatedUsers())
   *     .build();
   * Future<Policy> future = subscription.replacePolicyAsync(updatedPolicy);
   * // ...
   * updatedPolicy = future.get();
   * }</pre>
   *
   * @throws PubSubException upon failure
   */
  public Future<Policy> replacePolicyAsync(Policy newPolicy) {
    return pubsub.replaceSubscriptionPolicyAsync(this.getName(), newPolicy);
  }

  /**
   * Returns the permissions that a caller has on this subscription. You typically don't call this
   * method if you're using Google Cloud Platform directly to manage permissions. This method is
   * intended for integration with your proprietary software, such as a customized graphical user
   * interface. For example, the Cloud Platform Console tests IAM permissions internally to
   * determine which UI should be available to the logged-in user.
   *
   * <p>Example of testing whether the caller has the provided permissions on the subscription.
   * <pre> {@code
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.subscriptions.get");
   * List<Boolean> testedPermissions = subscription.testPermissions(permissions);
   * }</pre>
   *
   * @return A list of booleans representing whether the caller has the permissions specified (in
   *     the order of the given permissions)
   * @throws PubSubException upon failure
   * @see <a href="https://cloud.google.com/pubsub/docs/access_control#permissions">
   *     Permissions and Roles</a>
   */
  public List<Boolean> testPermissions(List<String> permissions) {
    return pubsub.testSubscriptionPermissions(this.getName(), permissions);
  }

  /**
   * Sends a request to get the permissions that a caller has on this subscription.
   *
   * <p>You typically don't call this method if you're using Google Cloud Platform directly to
   * manage permissions. This method is intended for integration with your proprietary software,
   * such as a customized graphical user interface. For example, the Cloud Platform Console tests
   * IAM permissions internally to determine which UI should be available to the logged-in user.
   *
   * <p>Example of asynchronously testing whether the caller has the provided permissions on the
   * subscription.
   * <pre> {@code
   * List<String> permissions = new LinkedList<>();
   * permissions.add("pubsub.subscriptions.get");
   * Future<List<Boolean>> future = subscription.testPermissionsAsync(permissions);
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
    return pubsub.testSubscriptionPermissionsAsync(this.getName(), permissions);
  }

  private void readObject(ObjectInputStream input) throws IOException, ClassNotFoundException {
    input.defaultReadObject();
    this.pubsub = options.getService();
  }

  static Subscription fromPb(PubSub storage, com.google.pubsub.v1.Subscription subscriptionPb) {
    SubscriptionInfo subscriptionInfo = SubscriptionInfo.fromPb(subscriptionPb);
    return new Subscription(storage, new BuilderImpl(subscriptionInfo));
  }

  static Function<com.google.pubsub.v1.Subscription, Subscription> fromPbFunction(
      final PubSub pubsub) {
    return new Function<com.google.pubsub.v1.Subscription, Subscription>() {
      @Override
      public Subscription apply(com.google.pubsub.v1.Subscription subscriptionPb) {
        return subscriptionPb != null ? fromPb(pubsub, subscriptionPb) : null;
      }
    };
  }
}
