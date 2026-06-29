/*
 * Copyright 2026 Google LLC
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

package com.google.storage.v2;

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
public class NotificationName implements ResourceName {
  private static final PathTemplate PROJECT_BUCKET_NOTIFICATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/buckets/{bucket}/notificationConfigs/{notification}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String bucket;
  private final String notification;

  @Deprecated
  protected NotificationName() {
    project = null;
    bucket = null;
    notification = null;
  }

  private NotificationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    bucket = Preconditions.checkNotNull(builder.getBucket());
    notification = Preconditions.checkNotNull(builder.getNotification());
  }

  public String getProject() {
    return project;
  }

  public String getBucket() {
    return bucket;
  }

  public String getNotification() {
    return notification;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NotificationName of(String project, String bucket, String notification) {
    return newBuilder().setProject(project).setBucket(bucket).setNotification(notification).build();
  }

  public static String format(String project, String bucket, String notification) {
    return newBuilder()
        .setProject(project)
        .setBucket(bucket)
        .setNotification(notification)
        .build()
        .toString();
  }

  public static NotificationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_BUCKET_NOTIFICATION.validatedMatch(
            formattedString, "NotificationName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("bucket"), matchMap.get("notification"));
  }

  public static List<NotificationName> parseList(List<String> formattedStrings) {
    List<NotificationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NotificationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NotificationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_BUCKET_NOTIFICATION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (bucket != null) {
            fieldMapBuilder.put("bucket", bucket);
          }
          if (notification != null) {
            fieldMapBuilder.put("notification", notification);
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
    return PROJECT_BUCKET_NOTIFICATION.instantiate(
        "project", project, "bucket", bucket, "notification", notification);
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NotificationName that = ((NotificationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.bucket, that.bucket)
          && Objects.equals(this.notification, that.notification);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(bucket);
    h *= 1000003;
    h ^= Objects.hashCode(notification);
    return h;
  }

  /** Builder for projects/{project}/buckets/{bucket}/notificationConfigs/{notification}. */
  public static class Builder {
    private String project;
    private String bucket;
    private String notification;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getBucket() {
      return bucket;
    }

    public String getNotification() {
      return notification;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setBucket(String bucket) {
      this.bucket = bucket;
      return this;
    }

    public Builder setNotification(String notification) {
      this.notification = notification;
      return this;
    }

    private Builder(NotificationName notificationName) {
      this.project = notificationName.project;
      this.bucket = notificationName.bucket;
      this.notification = notificationName.notification;
    }

    public NotificationName build() {
      return new NotificationName(this);
    }
  }
}
