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

package com.google.cloud.video.stitcher.v1;

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
public class LiveAdTagDetailName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_LIVE_SESSION_LIVE_AD_TAG_DETAIL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String liveSession;
  private final String liveAdTagDetail;

  @Deprecated
  protected LiveAdTagDetailName() {
    project = null;
    location = null;
    liveSession = null;
    liveAdTagDetail = null;
  }

  private LiveAdTagDetailName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    liveSession = Preconditions.checkNotNull(builder.getLiveSession());
    liveAdTagDetail = Preconditions.checkNotNull(builder.getLiveAdTagDetail());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getLiveSession() {
    return liveSession;
  }

  public String getLiveAdTagDetail() {
    return liveAdTagDetail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LiveAdTagDetailName of(
      String project, String location, String liveSession, String liveAdTagDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLiveSession(liveSession)
        .setLiveAdTagDetail(liveAdTagDetail)
        .build();
  }

  public static String format(
      String project, String location, String liveSession, String liveAdTagDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setLiveSession(liveSession)
        .setLiveAdTagDetail(liveAdTagDetail)
        .build()
        .toString();
  }

  public static LiveAdTagDetailName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_LIVE_SESSION_LIVE_AD_TAG_DETAIL.validatedMatch(
            formattedString, "LiveAdTagDetailName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("live_session"),
        matchMap.get("live_ad_tag_detail"));
  }

  public static List<LiveAdTagDetailName> parseList(List<String> formattedStrings) {
    List<LiveAdTagDetailName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LiveAdTagDetailName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LiveAdTagDetailName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_LIVE_SESSION_LIVE_AD_TAG_DETAIL.matches(formattedString);
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
          if (liveSession != null) {
            fieldMapBuilder.put("live_session", liveSession);
          }
          if (liveAdTagDetail != null) {
            fieldMapBuilder.put("live_ad_tag_detail", liveAdTagDetail);
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
    return PROJECT_LOCATION_LIVE_SESSION_LIVE_AD_TAG_DETAIL.instantiate(
        "project",
        project,
        "location",
        location,
        "live_session",
        liveSession,
        "live_ad_tag_detail",
        liveAdTagDetail);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      LiveAdTagDetailName that = ((LiveAdTagDetailName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.liveSession, that.liveSession)
          && Objects.equals(this.liveAdTagDetail, that.liveAdTagDetail);
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
    h ^= Objects.hashCode(liveSession);
    h *= 1000003;
    h ^= Objects.hashCode(liveAdTagDetail);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/liveSessions/{live_session}/liveAdTagDetails/{live_ad_tag_detail}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String liveSession;
    private String liveAdTagDetail;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getLiveSession() {
      return liveSession;
    }

    public String getLiveAdTagDetail() {
      return liveAdTagDetail;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setLiveSession(String liveSession) {
      this.liveSession = liveSession;
      return this;
    }

    public Builder setLiveAdTagDetail(String liveAdTagDetail) {
      this.liveAdTagDetail = liveAdTagDetail;
      return this;
    }

    private Builder(LiveAdTagDetailName liveAdTagDetailName) {
      this.project = liveAdTagDetailName.project;
      this.location = liveAdTagDetailName.location;
      this.liveSession = liveAdTagDetailName.liveSession;
      this.liveAdTagDetail = liveAdTagDetailName.liveAdTagDetail;
    }

    public LiveAdTagDetailName build() {
      return new LiveAdTagDetailName(this);
    }
  }
}
