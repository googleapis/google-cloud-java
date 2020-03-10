/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.securitycenter.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class NotificationConfigName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/notificationConfigs/{notification_config}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String notificationConfig;

  public String getOrganization() {
    return organization;
  }

  public String getNotificationConfig() {
    return notificationConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private NotificationConfigName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    notificationConfig = Preconditions.checkNotNull(builder.getNotificationConfig());
  }

  public static NotificationConfigName of(String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build();
  }

  public static String format(String organization, String notificationConfig) {
    return newBuilder()
        .setOrganization(organization)
        .setNotificationConfig(notificationConfig)
        .build()
        .toString();
  }

  public static NotificationConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "NotificationConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("notification_config"));
  }

  public static List<NotificationConfigName> parseList(List<String> formattedStrings) {
    List<NotificationConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationConfigName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (NotificationConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("notificationConfig", notificationConfig);
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
    return PATH_TEMPLATE.instantiate(
        "organization", organization, "notification_config", notificationConfig);
  }

  /** Builder for NotificationConfigName. */
  public static class Builder {

    private String organization;
    private String notificationConfig;

    public String getOrganization() {
      return organization;
    }

    public String getNotificationConfig() {
      return notificationConfig;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setNotificationConfig(String notificationConfig) {
      this.notificationConfig = notificationConfig;
      return this;
    }

    private Builder() {}

    private Builder(NotificationConfigName notificationConfigName) {
      organization = notificationConfigName.organization;
      notificationConfig = notificationConfigName.notificationConfig;
    }

    public NotificationConfigName build() {
      return new NotificationConfigName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NotificationConfigName) {
      NotificationConfigName that = (NotificationConfigName) o;
      return (this.organization.equals(that.organization))
          && (this.notificationConfig.equals(that.notificationConfig));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= notificationConfig.hashCode();
    return h;
  }
}
