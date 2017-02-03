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
import com.google.pubsub.v1.SubscriptionName;
import java.io.Serializable;
import java.util.Objects;

/**
 * Identity for a Google PubSub subscription. {@code SubscriptionId} objects are returned by the
 * {@link PubSub#listSubscriptions(String, PubSub.ListOption...)} and
 * {@link PubSub#listSubscriptionsAsync(String, PubSub.ListOption...)} methods as a topic may have
 * subscriptions from different projects.
 */
public class SubscriptionId implements Serializable {

  private static final long serialVersionUID = 6507142968866856283L;

  private final String project;
  private final String subscription;

  SubscriptionId(String project, String subscription) {
    this.project = checkNotNull(project);
    this.subscription = checkNotNull(subscription);
  }

  /**
   * Returns the name of the project where the subscription resides.
   */
  @Deprecated
  public String project() {
    return getProject();
  }

  /**
   * Returns the name of the project where the subscription resides.
   */
  public String getProject() {
    return project;
  }

  /**
   * Returns the name of the subscription.
   */
  @Deprecated
  public String subscription() {
    return getSubscription();
  }

  /**
   * Returns the name of the subscription.
   */
  public String getSubscription() {
    return subscription;
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("project", project)
        .add("subscription", subscription).toString();
  }

  @Override
  public final int hashCode() {
    return Objects.hash(project, subscription);
  }

  @Override
  public final boolean equals(Object obj) {
    if (obj == this) {
      return true;
    }
    if (!(obj instanceof SubscriptionId)) {
      return false;
    }
    SubscriptionId other = (SubscriptionId) obj;
    return Objects.equals(project, other.project)
        && Objects.equals(subscription, other.subscription);
  }

  static SubscriptionId fromPb(String pb) {
    SubscriptionName subscriptionName = SubscriptionName.parse(pb);
    return new SubscriptionId(subscriptionName.getProject(),
        subscriptionName.getSubscription());
  }
}
