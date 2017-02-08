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

package com.google.cloud.pubsub.deprecated;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.pubsub.v1.SubscriptionName;
import java.io.Serializable;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

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
 * <p>In a pull subscription, the subscribing application must explicitly pull messages using one of
 * {@link PubSub#pull(String, int)}, {@link PubSub#pullAsync(String, int)} or
 * {@link PubSub#pullAsync(String, PubSub.MessageProcessor callback, PubSub.PullOption...)}.
 * When messages are pulled with {@link PubSub#pull(String, int)} or
 * {@link PubSub#pullAsync(String, int)} the subscribing application must also explicitly
 * acknowledge them using one of {@link PubSub#ack(String, Iterable)},
 * {@link PubSub#ack(String, String, String...)}, {@link PubSub#ackAsync(String, Iterable)} or
 * {@link PubSub#ackAsync(String, String, String...)}.
 *
 * @see <a href="https://cloud.google.com/pubsub/overview#data_model">Pub/Sub Data Model</a>
 * @see <a href="https://cloud.google.com/pubsub/subscriber">Subscriber Guide</a>
 */
public class SubscriptionInfo implements Serializable {

  private static final long serialVersionUID = 1860057426574127128L;

  private final String name;
  private final TopicId topic;
  private final PushConfig pushConfig;
  private final int ackDeadlineSeconds;

  /**
   * Builder for {@code SubscriptionInfo} objects.
   */
  public abstract static class Builder {

    /**
     * Sets the name of the subscription. The name must start with a letter, and contain only
     * letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
     * ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
     * ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
     * string {@code goog}.
     */
    @Deprecated
    public abstract Builder name(String name);

    /**
     * Sets the name of the subscription. The name must start with a letter, and contain only
     * letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
     * ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
     * ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
     * string {@code goog}.
     */
    public abstract Builder setName(String name);

    /**
     * Sets the topic the subscription refers to, given the topic name. The topic is assumed to
     * reside in the {@link PubSubOptions#getProjectId()} project.
     */
    @Deprecated
    public abstract Builder topic(String topic);

    /**
     * Sets the topic the subscription refers to, given the topic name. The topic is assumed to
     * reside in the {@link PubSubOptions#getProjectId()} project.
     */
    public abstract Builder setTopic(String topic);

    /**
     * Sets the topic the subscription refers to, given the project and topic names.
     */
    @Deprecated
    public abstract Builder topic(String project, String topic);

    /**
     * Sets the topic the subscription refers to, given the project and topic names.
     */
    public abstract Builder setTopic(String project, String topic);

    /**
     * Sets the topic the subscription refers to, given the topic identity. If
     * {@code topic.project()} is {@code null} the topic is assumed to reside in the
     * {@link PubSubOptions#getProjectId()} project.
     */
    @Deprecated
    public abstract Builder topic(TopicId topic);

    /**
     * Sets the topic the subscription refers to, given the topic identity. If
     * {@code topic.project()} is {@code null} the topic is assumed to reside in the
     * {@link PubSubOptions#getProjectId()} project.
     */
    public abstract Builder setTopic(TopicId topic);

    /**
     * Sets the push configuration for the subscription. If set, the subscription will be in
     * push mode and the {@code pushConfig} parameter provides the push endpoint. If not set, the
     * subscription will be in pull mode.
     */
    @Deprecated
    public abstract Builder pushConfig(PushConfig pushConfig);

    /**
     * Sets the push configuration for the subscription. If set, the subscription will be in
     * push mode and the {@code pushConfig} parameter provides the push endpoint. If not set, the
     * subscription will be in pull mode.
     */
    public abstract Builder setPushConfig(PushConfig pushConfig);

    /**
     * Sets the maximum time after a subscriber receives a message before the subscriber should
     * acknowledge the message. After message delivery but before the ack deadline expires and
     * before the message is acknowledged, it is an outstanding message and will not be delivered
     * again during that time (on a best-effort basis). For pull subscriptions, this value is used
     * as the initial value for the ack deadline. To override the ack deadline value for a given
     * message, use {@link PubSub#modifyAckDeadline(String, int, TimeUnit, Iterable)}. For push
     * delivery, this value is used to set the request timeout for the call to the push endpoint.
     * This value must be between 10 and 600 seconds, if not specified, 10 seconds is used.
     */
    @Deprecated
    public abstract Builder ackDeadLineSeconds(int ackDeadLineSeconds);

    /**
     * Sets the maximum time after a subscriber receives a message before the subscriber should
     * acknowledge the message. After message delivery but before the ack deadline expires and
     * before the message is acknowledged, it is an outstanding message and will not be delivered
     * again during that time (on a best-effort basis). For pull subscriptions, this value is used
     * as the initial value for the ack deadline. To override the ack deadline value for a given
     * message, use {@link PubSub#modifyAckDeadline(String, int, TimeUnit, Iterable)}. For push
     * delivery, this value is used to set the request timeout for the call to the push endpoint.
     * This value must be between 10 and 600 seconds, if not specified, 10 seconds is used.
     */
    public abstract Builder setAckDeadLineSeconds(int ackDeadLineSeconds);

    /**
     * Creates a subscription object.
     */
    public abstract SubscriptionInfo build();
  }

  static final class BuilderImpl extends Builder {

    private String name;
    private TopicId topic;
    private PushConfig pushConfig;
    private int ackDeadlineSeconds;

    private BuilderImpl(TopicId topic, String name) {
      this.topic = checkNotNull(topic);
      this.name = checkNotNull(name);
    }

    BuilderImpl(SubscriptionInfo subscription) {
      name = subscription.name;
      topic = subscription.topic;
      pushConfig = subscription.pushConfig;
      ackDeadlineSeconds = subscription.ackDeadlineSeconds;
    }

    @Override
    @Deprecated
    public Builder name(String name) {
      return setName(name);
    }

    @Override
    public Builder setName(String name) {
      this.name = checkNotNull(name);
      return this;
    }

    @Override
    @Deprecated
    public Builder topic(String project, String topic) {
      return setTopic(project, topic);
    }

    @Override
    public Builder setTopic(String project, String topic) {
      return setTopic(TopicId.of(checkNotNull(project), topic));
    }

    @Override
    @Deprecated
    public Builder topic(String topic) {
      return setTopic(topic);
    }

    @Override
    public Builder setTopic(String topic) {
      return setTopic(TopicId.of(topic));
    }

    @Override
    @Deprecated
    public Builder topic(TopicId topic) {
      return setTopic(topic);
    }

    @Override
    public Builder setTopic(TopicId topic) {
      this.topic = checkNotNull(topic);
      return this;
    }

    @Override
    @Deprecated
    public Builder pushConfig(PushConfig pushConfig) {
      return setPushConfig(pushConfig);
    }

    @Override
    public Builder setPushConfig(PushConfig pushConfig) {
      this.pushConfig = pushConfig;
      return this;
    }

    @Override
    @Deprecated
    public Builder ackDeadLineSeconds(int ackDeadlineSeconds) {
      return setAckDeadLineSeconds(ackDeadlineSeconds);
    }

    @Override
    public Builder setAckDeadLineSeconds(int ackDeadlineSeconds) {
      this.ackDeadlineSeconds = ackDeadlineSeconds;
      return this;
    }

    @Override
    public SubscriptionInfo build() {
      return new SubscriptionInfo(this);
    }
  }

  SubscriptionInfo(BuilderImpl builder) {
    topic = builder.topic;
    name = builder.name;
    pushConfig = builder.pushConfig;
    ackDeadlineSeconds = builder.ackDeadlineSeconds;
  }

  /**
   * Returns the identity of the topic this subscription refers to. If {@link TopicId#project()} is
   * {@code null} the topic is assumed to reside in the {@link PubSubOptions#getProjectId()}
   * project. After a topic is deleted, existing subscriptions to that topic are not deleted, but
   * their topic field is set to {@link TopicId#deletedTopic()}.
   */
  @Deprecated
  public TopicId topic() {
    return getTopic();
  }

  /**
   * Returns the identity of the topic this subscription refers to. If {@link TopicId#project()} is
   * {@code null} the topic is assumed to reside in the {@link PubSubOptions#getProjectId()}
   * project. After a topic is deleted, existing subscriptions to that topic are not deleted, but
   * their topic field is set to {@link TopicId#deletedTopic()}.
   */
  public TopicId getTopic() {
    return topic;
  }

  /**
   * Returns the name of the subscription. The name must start with a letter, and contain only
   * letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   * ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   * ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   * string {@code goog}.
   */
  @Deprecated
  public String name() {
    return getName();
  }

  /**
   * Returns the name of the subscription. The name must start with a letter, and contain only
   * letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   * ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   * ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   * string {@code goog}.
   */
  public String getName() {
    return name;
  }

  /**
   * Returns the push configuration for the subscription. If set, the subscription is in push mode
   * and the returned value defines the push endpoint. If {@code null}, the subscription is in pull
   * mode.
   */
  @Deprecated
  public PushConfig pushConfig() {
    return getPushConfig();
  }

  /**
   * Returns the push configuration for the subscription. If set, the subscription is in push mode
   * and the returned value defines the push endpoint. If {@code null}, the subscription is in pull
   * mode.
   */
  public PushConfig getPushConfig() {
    return pushConfig;
  }

  /**
   * Returns the maximum time after a subscriber receives a message before the subscriber should
   * acknowledge the message. After message delivery but before the ack deadline expires and
   * before the message is acknowledged, it is an outstanding message and will not be delivered
   * again during that time (on a best-effort basis). For pull subscriptions, this value is used
   * as the initial value for the ack deadline. To override the ack deadline value for a given
   * message, use {@link PubSub#modifyAckDeadline(String, int, TimeUnit, Iterable)}. For push
   * delivery, this value is used to set the request timeout for the call to the push endpoint. This
   * value must be between 10 and 600 seconds, if not specified, 10 seconds is used.
   */
  @Deprecated
  public long ackDeadlineSeconds() {
    return getAckDeadlineSeconds();
  }

  /**
   * Returns the maximum time after a subscriber receives a message before the subscriber should
   * acknowledge the message. After message delivery but before the ack deadline expires and
   * before the message is acknowledged, it is an outstanding message and will not be delivered
   * again during that time (on a best-effort basis). For pull subscriptions, this value is used
   * as the initial value for the ack deadline. To override the ack deadline value for a given
   * message, use {@link PubSub#modifyAckDeadline(String, int, TimeUnit, Iterable)}. For push
   * delivery, this value is used to set the request timeout for the call to the push endpoint. This
   * value must be between 10 and 600 seconds, if not specified, 10 seconds is used.
   */
  public long getAckDeadlineSeconds() {
    return ackDeadlineSeconds;
  }

  final boolean baseEquals(SubscriptionInfo subscriptionInfo) {
    return Objects.equals(topic, subscriptionInfo.topic)
        && Objects.equals(name, subscriptionInfo.name)
        && Objects.equals(pushConfig, subscriptionInfo.pushConfig)
        && ackDeadlineSeconds == subscriptionInfo.ackDeadlineSeconds;
  }

  @Override
  public boolean equals(Object obj) {
    return obj == this
        || obj != null
        && obj.getClass().equals(SubscriptionInfo.class)
        && baseEquals((SubscriptionInfo) obj);
  }

  @Override
  public int hashCode() {
    return Objects.hash(topic, name, pushConfig, ackDeadlineSeconds);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("topic", topic)
        .add("name", name)
        .add("pushConfig", pushConfig)
        .add("ackDeadlineSeconds", ackDeadlineSeconds)
        .toString();
  }

  com.google.pubsub.v1.Subscription toPb(String projectId) {
    com.google.pubsub.v1.Subscription.Builder builder =
        com.google.pubsub.v1.Subscription.newBuilder();
    builder.setTopic(topic.toPb(projectId));
    builder.setNameWithSubscriptionName(SubscriptionName.create(projectId, name));
    builder.setAckDeadlineSeconds(ackDeadlineSeconds);
    if (pushConfig != null) {
      builder.setPushConfig(pushConfig.toPb());
    }
    return builder.build();
  }

  static SubscriptionInfo fromPb(com.google.pubsub.v1.Subscription subscription) {
    Builder builder = newBuilder(TopicId.fromPb(subscription.getTopic()),
        subscription.getNameAsSubscriptionName().getSubscription());
    builder.setAckDeadLineSeconds(subscription.getAckDeadlineSeconds());
    // A subscription with an "empty" push config is a pull subscription
    if (subscription.hasPushConfig()
        && !subscription.getPushConfig().getPushEndpoint().equals("")) {
      builder.setPushConfig(PushConfig.fromPb(subscription.getPushConfig()));
    }
    return builder.build();
  }

  /**
   * Returns a builder for the subscription object.
   */
  public Builder toBuilder() {
    return new BuilderImpl(this);
  }

  /**
   * Creates a pull {@code SubscriptionInfo} object given the name of the topic and the name of the
   * subscription. The topic is assumed to reside in the {@link PubSubOptions#getProjectId()}
   * project.
   *
   * @param topic the name of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  public static SubscriptionInfo of(String topic, String name) {
    return newBuilder(topic, name).build();
  }

  /**
   * Creates a pull {@code SubscriptionInfo} object given the identity of the topic and the name of
   * the subscription. If {@code topic.project()} is {@code null} the topic is assumed to reside in
   * the {@link PubSubOptions#getProjectId()} project.
   *
   * @param topic the identity of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  public static SubscriptionInfo of(TopicId topic, String name) {
    return newBuilder(topic, name).build();
  }

  /**
   * Creates a push {@code SubscriptionInfo} object given the name of the topic, the name of the
   * subscription and the push endpoint. The topic is assumed to reside in the
   * {@link PubSubOptions#getProjectId()} project.
   *
   * @param topic the name of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   * @param endpoint a URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   */
  public static SubscriptionInfo of(String topic, String name, String endpoint) {
    return newBuilder(topic, name).setPushConfig(PushConfig.of(endpoint)).build();
  }

  /**
   * Creates a push {@code SubscriptionInfo} object given the identity of the topic, the name of the
   * subscription and the push endpoint. If {@code topic.project()} is {@code null} the topic is
   * assumed to reside in the {@link PubSubOptions#getProjectId()} project.
   *
   * @param topic the identity of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   * @param endpoint a URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   */
  public static SubscriptionInfo of(TopicId topic, String name, String endpoint) {
    return newBuilder(topic, name).setPushConfig(PushConfig.of(endpoint)).build();
  }

  /**
   * Creates a builder for {@code SubscriptionInfo} objects given the name of the topic and the name
   * of the subscription. The topic is assumed to reside in the {@link PubSubOptions#getProjectId()}
   * project.
   *
   * @param topic the name of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  @Deprecated
  public static Builder builder(String topic, String name) {
    return newBuilder(topic, name);
  }

  /**
   * Creates a builder for {@code SubscriptionInfo} objects given the name of the topic and the name
   * of the subscription. The topic is assumed to reside in the {@link PubSubOptions#getProjectId()}
   * project.
   *
   * @param topic the name of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  public static Builder newBuilder(String topic, String name) {
    return newBuilder(TopicId.of(topic), name);
  }

  /**
   * Creates a builder for {@code SubscriptionInfo} objects given the identity of the topic and the
   * name of the subscription. If {@code topic.project()} is {@code null} the topic is assumed to
   * reside in the {@link PubSubOptions#getProjectId()} project.
   *
   * @param topic the identity of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  @Deprecated
  public static Builder builder(TopicId topic, String name) {
    return newBuilder(topic, name);
  }

  /**
   * Creates a builder for {@code SubscriptionInfo} objects given the identity of the topic and the
   * name of the subscription. If {@code topic.project()} is {@code null} the topic is assumed to
   * reside in the {@link PubSubOptions#getProjectId()} project.
   *
   * @param topic the identity of the topic the subscription refers to
   * @param name the name of the subscription. The name must start with a letter, and contain only
   *     letters ({@code [A-Za-z]}), numbers ({@code [0-9]}), dashes ({@code -}), underscores
   *     ({@code _}), periods ({@code .}), tildes ({@code ~}), plus ({@code +}) or percent signs
   *     ({@code %}). It must be between 3 and 255 characters in length and cannot begin with the
   *     string {@code goog}.
   */
  public static Builder newBuilder(TopicId topic, String name) {
    return new BuilderImpl(topic, name);
  }
}
