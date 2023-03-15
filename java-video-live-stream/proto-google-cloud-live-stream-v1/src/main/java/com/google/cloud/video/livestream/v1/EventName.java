/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.video.livestream.v1;

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
public class EventName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CHANNEL_EVENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/channels/{channel}/events/{event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String channel;
  private final String event;

  @Deprecated
  protected EventName() {
    project = null;
    location = null;
    channel = null;
    event = null;
  }

  private EventName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    channel = Preconditions.checkNotNull(builder.getChannel());
    event = Preconditions.checkNotNull(builder.getEvent());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getChannel() {
    return channel;
  }

  public String getEvent() {
    return event;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EventName of(String project, String location, String channel, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setChannel(channel)
        .setEvent(event)
        .build();
  }

  public static String format(String project, String location, String channel, String event) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setChannel(channel)
        .setEvent(event)
        .build()
        .toString();
  }

  public static EventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CHANNEL_EVENT.validatedMatch(
            formattedString, "EventName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("channel"),
        matchMap.get("event"));
  }

  public static List<EventName> parseList(List<String> formattedStrings) {
    List<EventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CHANNEL_EVENT.matches(formattedString);
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
          if (channel != null) {
            fieldMapBuilder.put("channel", channel);
          }
          if (event != null) {
            fieldMapBuilder.put("event", event);
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
    return PROJECT_LOCATION_CHANNEL_EVENT.instantiate(
        "project", project, "location", location, "channel", channel, "event", event);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EventName that = ((EventName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.channel, that.channel)
          && Objects.equals(this.event, that.event);
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
    h ^= Objects.hashCode(channel);
    h *= 1000003;
    h ^= Objects.hashCode(event);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/channels/{channel}/events/{event}. */
  public static class Builder {
    private String project;
    private String location;
    private String channel;
    private String event;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getChannel() {
      return channel;
    }

    public String getEvent() {
      return event;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setChannel(String channel) {
      this.channel = channel;
      return this;
    }

    public Builder setEvent(String event) {
      this.event = event;
      return this;
    }

    private Builder(EventName eventName) {
      this.project = eventName.project;
      this.location = eventName.location;
      this.channel = eventName.channel;
      this.event = eventName.event;
    }

    public EventName build() {
      return new EventName(this);
    }
  }
}
