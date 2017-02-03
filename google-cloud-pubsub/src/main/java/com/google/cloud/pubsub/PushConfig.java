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

import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableMap;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Google Cloud Pub/Sub configuration for a push subscription.
 *
 * <p>In a push subscription, the Pub/Sub server sends a request to the subscriber application. A
 * {@code PushConfig} object can be used to configure the application endpoint. The subscriber's
 * HTTP response serves as an implicit acknowledgement: a success response indicates that the
 * message has been succesfully processed and the Pub/Sub system can delete it from the
 * subscription; a non-success response indicates that the Pub/Sub server should resend it
 * (implicit "nack").
 *
 * @see <a href="https://cloud.google.com/pubsub/subscriber">Subscriber Guide</a>
 */
public final class PushConfig implements Serializable {

  private static final long serialVersionUID = 4408885787064092231L;

  private final String endpoint;
  private final ImmutableMap<String, String> attributes;

  /**
   * Builder for {@code PushConfig} objects.
   */
  public static final class Builder {

    private String endpoint;
    private Map<String, String> attributes = new HashMap<>();

    private Builder() {
    }

    /**
     * Sets the URL locating the endpoint to which messages should be pushed. For example, an
     * endpoint might use {@code https://example.com/push}.
     */
    @Deprecated
    public Builder endpoint(String endpoint) {
      return setEndpoint(endpoint);
    }

    /**
     * Sets the URL locating the endpoint to which messages should be pushed. For example, an
     * endpoint might use {@code https://example.com/push}.
     */
    public Builder setEndpoint(String endpoint) {
      this.endpoint = checkNotNull(endpoint);
      return this;
    }

    /**
     * Adds an API-supported attribute that can be used to control different aspects of the message
     * delivery.
     *
     * <p>The currently supported attribute is {@code x-goog-version}, which can be used to change
     * the format of the push message. This attribute indicates the version of the data expected by
     * the endpoint. The endpoint version is based on the version of the Pub/Sub API. Possible
     * values for this attribute are:
     * <ul>
     *   <li>{@code v1beta1}: uses the push format defined in the v1beta1 Pub/Sub API
     *   <li>{@code v1} or {@code v1beta2}: uses the push format defined in the v1 Pub/Sub API
     * </ul>
     *
     * <p>If the {@code x-goog-version} attribute is not present when a subscription is created (see
     * {@link PubSub#create(SubscriptionInfo)} and {@link PubSub#createAsync(SubscriptionInfo)}), it
     * will default to {@code v1}. If it is not present when modifying the push config (see
     * {@link PubSub#replacePushConfig(String, PushConfig)} and
     * {@link PubSub#replacePushConfigAsync(String, PushConfig)}), its value will not be changed.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#msg-format">Message Format</a>
     */
    public Builder addAttribute(String name, String value) {
      attributes.put(name, value);
      return this;
    }

    /**
     * Sets the API-supported attributes that can be used to control different aspects of the
     * message delivery.
     *
     * <p>The currently supported attribute is {@code x-goog-version}, which can be used to change
     * the format of the push message. This attribute indicates the version of the data expected by
     * the endpoint. The endpoint version is based on the version of the Pub/Sub API. Possible
     * values for this attribute are:
     * <ul>
     *   <li>{@code v1beta1}: uses the push format defined in the v1beta1 Pub/Sub API
     *   <li>{@code v1} or {@code v1beta2}: uses the push format defined in the v1 Pub/Sub API
     * </ul>
     *
     * <p>If the {@code x-goog-version} attribute is not present when a subscription is created (see
     * {@link PubSub#create(SubscriptionInfo)} and {@link PubSub#createAsync(SubscriptionInfo)}), it
     * will default to {@code v1}. If it is not present when modifying the push config (see
     * {@link PubSub#replacePushConfig(String, PushConfig)} and
     * {@link PubSub#replacePushConfigAsync(String, PushConfig)}), its value will not be changed.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#msg-format">Message Format</a>
     */
    @Deprecated
    public Builder attributes(Map<String, String> attributes) {
      return setAttributes(attributes);
    }

    /**
     * Sets the API-supported attributes that can be used to control different aspects of the
     * message delivery.
     *
     * <p>The currently supported attribute is {@code x-goog-version}, which can be used to change
     * the format of the push message. This attribute indicates the version of the data expected by
     * the endpoint. The endpoint version is based on the version of the Pub/Sub API. Possible
     * values for this attribute are:
     * <ul>
     *   <li>{@code v1beta1}: uses the push format defined in the v1beta1 Pub/Sub API
     *   <li>{@code v1} or {@code v1beta2}: uses the push format defined in the v1 Pub/Sub API
     * </ul>
     *
     * <p>If the {@code x-goog-version} attribute is not present when a subscription is created (see
     * {@link PubSub#create(SubscriptionInfo)} and {@link PubSub#createAsync(SubscriptionInfo)}), it
     * will default to {@code v1}. If it is not present when modifying the push config (see
     * {@link PubSub#replacePushConfig(String, PushConfig)} and
     * {@link PubSub#replacePushConfigAsync(String, PushConfig)}), its value will not be changed.
     *
     * @see <a href="https://cloud.google.com/pubsub/subscriber#msg-format">Message Format</a>
     */
    public Builder setAttributes(Map<String, String> attributes) {
      this.attributes = new HashMap<>(attributes);
      return this;
    }

    /**
     * Removes an API-supported attribute.
     */
    public Builder removeAttribute(String name) {
      attributes.remove(name);
      return this;
    }

    /**
     * Clears all API-supported attributes.
     */
    public Builder clearAttributes() {
      attributes.clear();
      return this;
    }

    /**
     * Creates a {@code PushConfig} object.
     */
    public PushConfig build() {
      return new PushConfig(this);
    }
  }

  private PushConfig(Builder builder) {
    endpoint = builder.endpoint;
    attributes = ImmutableMap.copyOf(builder.attributes);
  }

  /**
   * Returns the URL locating the endpoint to which messages should be pushed. For example, an
   * endpoint might use {@code https://example.com/push}.
   */
  @Deprecated
  public String endpoint() {
    return getEndpoint();
  }

  /**
   * Returns the URL locating the endpoint to which messages should be pushed. For example, an
   * endpoint might use {@code https://example.com/push}.
   */
  public String getEndpoint() {
    return endpoint;
  }

  /**
   * Returns the API-supported attributes that can be used to control different aspects of the
   * message delivery.
   *
   * <p>The currently supported attribute is {@code x-goog-version}, which can be used to change
   * the format of the push message. This attribute indicates the version of the data expected by
   * the endpoint. The endpoint version is based on the version of the Pub/Sub API. Possible
   * values for this attribute are:
   * <ul>
   *   <li>{@code v1beta1}: uses the push format defined in the v1beta1 Pub/Sub API
   *   <li>{@code v1} or {@code v1beta2}: uses the push format defined in the v1 Pub/Sub API
   * </ul>
   *
   * <p>If the {@code x-goog-version} attribute is not present when a subscription is created (see
   * {@link PubSub#create(SubscriptionInfo)} and {@link PubSub#createAsync(SubscriptionInfo)}), it
   * will default to {@code v1}. If it is not present when modifying the push config (see
   * {@link PubSub#replacePushConfig(String, PushConfig)} and
   * {@link PubSub#replacePushConfigAsync(String, PushConfig)}), its value will not be changed.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#msg-format">Message Format</a>
   */
  @Deprecated
  public Map<String, String> attributes() {
    return getAttributes();
  }

  /**
   * Returns the API-supported attributes that can be used to control different aspects of the
   * message delivery.
   *
   * <p>The currently supported attribute is {@code x-goog-version}, which can be used to change
   * the format of the push message. This attribute indicates the version of the data expected by
   * the endpoint. The endpoint version is based on the version of the Pub/Sub API. Possible
   * values for this attribute are:
   * <ul>
   *   <li>{@code v1beta1}: uses the push format defined in the v1beta1 Pub/Sub API
   *   <li>{@code v1} or {@code v1beta2}: uses the push format defined in the v1 Pub/Sub API
   * </ul>
   *
   * <p>If the {@code x-goog-version} attribute is not present when a subscription is created (see
   * {@link PubSub#create(SubscriptionInfo)} and {@link PubSub#createAsync(SubscriptionInfo)}), it
   * will default to {@code v1}. If it is not present when modifying the push config (see
   * {@link PubSub#replacePushConfig(String, PushConfig)} and
   * {@link PubSub#replacePushConfigAsync(String, PushConfig)}), its value will not be changed.
   *
   * @see <a href="https://cloud.google.com/pubsub/subscriber#msg-format">Message Format</a>
   */
  public Map<String, String> getAttributes() {
    return attributes;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof PushConfig)) {
      return false;
    }
    PushConfig other = (PushConfig) obj;
    return Objects.equals(endpoint, other.endpoint) && Objects.equals(attributes, other.attributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(endpoint, attributes);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("attributes", attributes)
        .add("endpoint", endpoint)
        .toString();
  }

  /**
   * Returns a builder for the {@code PushConfig} object.
   */
  public Builder toBuilder() {
    return newBuilder(endpoint, attributes);
  }

  /**
   * Creates a {@code PushConfig} object given the push endpoint.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   */
  public static PushConfig of(String endpoint) {
    return newBuilder(endpoint).build();
  }

  /**
   * Creates a {@code PushConfig} object given the push endpoint and the API-supported attributes
   * that can be used to control different aspects of the message delivery.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   * @param attributes API supported attributes used to control message delivery. See
   *     {@link Builder#attributes(Map)} for more details.
   */
  public static PushConfig of(String endpoint, Map<String, String> attributes) {
    return newBuilder(endpoint, attributes).build();
  }

  /**
   * Creates a builder for {@code PushConfig} objects given the push endpoint.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   */
  @Deprecated
  public static Builder builder(String endpoint) {
    return newBuilder(endpoint);
  }

  /**
   * Creates a builder for {@code PushConfig} objects given the push endpoint.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   */
  public static Builder newBuilder(String endpoint) {
    return new Builder().setEndpoint(endpoint);
  }

  /**
   * Creates a builder for {@code PushConfig} objects given the push endpoint and the API-supported
   * attributes that can be used to control different aspects of the message delivery.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   * @param attributes API supported attributes used to control message delivery. See
   *     {@link Builder#attributes(Map)} for more details.
   */
  @Deprecated
  public static Builder builder(String endpoint, Map<String, String> attributes) {
    return newBuilder(endpoint, attributes);
  }

  /**
   * Creates a builder for {@code PushConfig} objects given the push endpoint and the API-supported
   * attributes that can be used to control different aspects of the message delivery.
   *
   * @param endpoint the URL locating the endpoint to which messages should be pushed. For example,
   *     an endpoint might use {@code https://example.com/push}.
   * @param attributes API supported attributes used to control message delivery. See
   *     {@link Builder#attributes(Map)} for more details.
   */
  public static Builder newBuilder(String endpoint, Map<String, String> attributes) {
    return newBuilder(endpoint).setAttributes(attributes);
  }

  com.google.pubsub.v1.PushConfig toPb() {
    return com.google.pubsub.v1.PushConfig.newBuilder().setPushEndpoint(endpoint)
        .putAllAttributes(attributes).build();
  }

  static PushConfig fromPb(com.google.pubsub.v1.PushConfig pushConfigPb) {
    return newBuilder(pushConfigPb.getPushEndpoint(), pushConfigPb.getAttributesMap()).build();
  }
}
