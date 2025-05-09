/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.shopping.merchant.notifications.v1beta;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class NotificationSubscriptionName implements ResourceName {
  private static final PathTemplate ACCOUNT_NOTIFICATION_SUBSCRIPTION =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/notificationsubscriptions/{notification_subscription}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String notificationSubscription;

  @Deprecated
  protected NotificationSubscriptionName() {
    account = null;
    notificationSubscription = null;
  }

  private NotificationSubscriptionName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    notificationSubscription = Preconditions.checkNotNull(builder.getNotificationSubscription());
  }

  public String getAccount() {
    return account;
  }

  public String getNotificationSubscription() {
    return notificationSubscription;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationSubscriptionName of(String account, String notificationSubscription) {
    return newBuilder()
        .setAccount(account)
        .setNotificationSubscription(notificationSubscription)
        .build();
  }

  public static String format(String account, String notificationSubscription) {
    return newBuilder()
        .setAccount(account)
        .setNotificationSubscription(notificationSubscription)
        .build()
        .toString();
  }

  public static NotificationSubscriptionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_NOTIFICATION_SUBSCRIPTION.validatedMatch(
            formattedString,
            "NotificationSubscriptionName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("notification_subscription"));
  }

  public static List<NotificationSubscriptionName> parseList(List<String> formattedStrings) {
    List<NotificationSubscriptionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationSubscriptionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationSubscriptionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_NOTIFICATION_SUBSCRIPTION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (account != null) {
            fieldMapBuilder.put("account", account);
          }
          if (notificationSubscription != null) {
            fieldMapBuilder.put("notification_subscription", notificationSubscription);
          }
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  @Override
  public String toString() {
    return ACCOUNT_NOTIFICATION_SUBSCRIPTION.instantiate(
        "account", account, "notification_subscription", notificationSubscription);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NotificationSubscriptionName that = ((NotificationSubscriptionName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.notificationSubscription, that.notificationSubscription);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(notificationSubscription);
    return h;
  }

  /** Builder for accounts/{account}/notificationsubscriptions/{notification_subscription}. */
  public static class Builder {
    private String account;
    private String notificationSubscription;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getNotificationSubscription() {
      return notificationSubscription;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setNotificationSubscription(String notificationSubscription) {
      this.notificationSubscription = notificationSubscription;
      return this;
    }

    private Builder(NotificationSubscriptionName notificationSubscriptionName) {
      this.account = notificationSubscriptionName.account;
      this.notificationSubscription = notificationSubscriptionName.notificationSubscription;
    }

    public NotificationSubscriptionName build() {
      return new NotificationSubscriptionName(this);
    }
  }
}
