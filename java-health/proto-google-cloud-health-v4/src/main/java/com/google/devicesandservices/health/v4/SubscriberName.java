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

package com.google.devicesandservices.health.v4;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class SubscriberName implements ResourceName {
  private static final PathTemplate PROJECT_SUBSCRIBER =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/subscribers/{subscriber}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String subscriber;

  @Deprecated
  protected SubscriberName() {
    project = null;
    subscriber = null;
  }

  private SubscriberName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    subscriber = Preconditions.checkNotNull(builder.getSubscriber());
  }

  public String getProject() {
    return project;
  }

  public String getSubscriber() {
    return subscriber;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SubscriberName of(String project, String subscriber) {
    return newBuilder().setProject(project).setSubscriber(subscriber).build();
  }

  public static String format(String project, String subscriber) {
    return newBuilder().setProject(project).setSubscriber(subscriber).build().toString();
  }

  public static @Nullable SubscriberName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_SUBSCRIBER.validatedMatch(
            formattedString, "SubscriberName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("subscriber"));
  }

  public static List<SubscriberName> parseList(List<String> formattedStrings) {
    List<SubscriberName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable SubscriberName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SubscriberName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SUBSCRIBER.matches(formattedString);
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
          if (subscriber != null) {
            fieldMapBuilder.put("subscriber", subscriber);
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
    return PROJECT_SUBSCRIBER.instantiate("project", project, "subscriber", subscriber);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SubscriberName that = ((SubscriberName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.subscriber, that.subscriber);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(subscriber);
    return h;
  }

  /** Builder for projects/{project}/subscribers/{subscriber}. */
  public static class Builder {
    private String project;
    private String subscriber;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getSubscriber() {
      return subscriber;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSubscriber(String subscriber) {
      this.subscriber = subscriber;
      return this;
    }

    private Builder(SubscriberName subscriberName) {
      this.project = subscriberName.project;
      this.subscriber = subscriberName.subscriber;
    }

    public SubscriberName build() {
      return new SubscriberName(this);
    }
  }
}
