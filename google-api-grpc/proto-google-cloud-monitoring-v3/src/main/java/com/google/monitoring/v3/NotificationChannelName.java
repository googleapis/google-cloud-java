/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.monitoring.v3;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class NotificationChannelName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/notificationChannels/{notification_channel}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String notificationChannel;

  public String getProject() {
    return project;
  }

  public String getNotificationChannel() {
    return notificationChannel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private NotificationChannelName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    notificationChannel = Preconditions.checkNotNull(builder.getNotificationChannel());
  }

  public static NotificationChannelName of(String project, String notificationChannel) {
    return newBuilder()
      .setProject(project)
      .setNotificationChannel(notificationChannel)
      .build();
  }

  public static String format(String project, String notificationChannel) {
    return newBuilder()
      .setProject(project)
      .setNotificationChannel(notificationChannel)
      .build()
      .toString();
  }

  public static NotificationChannelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "NotificationChannelName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("notification_channel"));
  }

  public static List<NotificationChannelName> parseList(List<String> formattedStrings) {
    List<NotificationChannelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationChannelName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (NotificationChannelName value : values) {
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
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("notificationChannel", notificationChannel);
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
    return PATH_TEMPLATE.instantiate("project", project, "notification_channel", notificationChannel);
  }

  /** Builder for NotificationChannelName. */
  public static class Builder {

    private String project;
    private String notificationChannel;

    public String getProject() {
      return project;
    }

    public String getNotificationChannel() {
      return notificationChannel;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setNotificationChannel(String notificationChannel) {
      this.notificationChannel = notificationChannel;
      return this;
    }

    private Builder() {
    }

    private Builder(NotificationChannelName notificationChannelName) {
      project = notificationChannelName.project;
      notificationChannel = notificationChannelName.notificationChannel;
    }

    public NotificationChannelName build() {
      return new NotificationChannelName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NotificationChannelName) {
      NotificationChannelName that = (NotificationChannelName) o;
      return (this.project.equals(that.project))
          && (this.notificationChannel.equals(that.notificationChannel));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= notificationChannel.hashCode();
    return h;
  }
}

