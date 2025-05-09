/*
 * Copyright 2025 Google LLC
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
public class ClipName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CHANNEL_CLIP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/channels/{channel}/clips/{clip}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String channel;
  private final String clip;

  @Deprecated
  protected ClipName() {
    project = null;
    location = null;
    channel = null;
    clip = null;
  }

  private ClipName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    channel = Preconditions.checkNotNull(builder.getChannel());
    clip = Preconditions.checkNotNull(builder.getClip());
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

  public String getClip() {
    return clip;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ClipName of(String project, String location, String channel, String clip) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setChannel(channel)
        .setClip(clip)
        .build();
  }

  public static String format(String project, String location, String channel, String clip) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setChannel(channel)
        .setClip(clip)
        .build()
        .toString();
  }

  public static ClipName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CHANNEL_CLIP.validatedMatch(
            formattedString, "ClipName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("channel"),
        matchMap.get("clip"));
  }

  public static List<ClipName> parseList(List<String> formattedStrings) {
    List<ClipName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ClipName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ClipName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CHANNEL_CLIP.matches(formattedString);
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
          if (clip != null) {
            fieldMapBuilder.put("clip", clip);
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
    return PROJECT_LOCATION_CHANNEL_CLIP.instantiate(
        "project", project, "location", location, "channel", channel, "clip", clip);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ClipName that = ((ClipName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.channel, that.channel)
          && Objects.equals(this.clip, that.clip);
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
    h ^= Objects.hashCode(clip);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/channels/{channel}/clips/{clip}. */
  public static class Builder {
    private String project;
    private String location;
    private String channel;
    private String clip;

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

    public String getClip() {
      return clip;
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

    public Builder setClip(String clip) {
      this.clip = clip;
      return this;
    }

    private Builder(ClipName clipName) {
      this.project = clipName.project;
      this.location = clipName.location;
      this.channel = clipName.channel;
      this.clip = clipName.clip;
    }

    public ClipName build() {
      return new ClipName(this);
    }
  }
}
