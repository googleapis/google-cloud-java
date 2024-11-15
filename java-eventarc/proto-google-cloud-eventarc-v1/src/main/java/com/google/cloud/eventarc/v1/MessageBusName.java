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

package com.google.cloud.eventarc.v1;

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
public class MessageBusName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MESSAGE_BUS =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/messageBuses/{message_bus}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String messageBus;

  @Deprecated
  protected MessageBusName() {
    project = null;
    location = null;
    messageBus = null;
  }

  private MessageBusName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    messageBus = Preconditions.checkNotNull(builder.getMessageBus());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMessageBus() {
    return messageBus;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MessageBusName of(String project, String location, String messageBus) {
    return newBuilder().setProject(project).setLocation(location).setMessageBus(messageBus).build();
  }

  public static String format(String project, String location, String messageBus) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMessageBus(messageBus)
        .build()
        .toString();
  }

  public static MessageBusName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MESSAGE_BUS.validatedMatch(
            formattedString, "MessageBusName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("message_bus"));
  }

  public static List<MessageBusName> parseList(List<String> formattedStrings) {
    List<MessageBusName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MessageBusName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MessageBusName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MESSAGE_BUS.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (messageBus != null) {
            fieldMapBuilder.put("message_bus", messageBus);
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
    return PROJECT_LOCATION_MESSAGE_BUS.instantiate(
        "project", project, "location", location, "message_bus", messageBus);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MessageBusName that = ((MessageBusName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.messageBus, that.messageBus);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(messageBus);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/messageBuses/{message_bus}. */
  public static class Builder {
    private String project;
    private String location;
    private String messageBus;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMessageBus() {
      return messageBus;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMessageBus(String messageBus) {
      this.messageBus = messageBus;
      return this;
    }

    private Builder(MessageBusName messageBusName) {
      this.project = messageBusName.project;
      this.location = messageBusName.location;
      this.messageBus = messageBusName.messageBus;
    }

    public MessageBusName build() {
      return new MessageBusName(this);
    }
  }
}
