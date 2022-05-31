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
public class VodAdTagDetailName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_VOD_SESSION_VOD_AD_TAG_DETAIL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/vodSessions/{vod_session}/vodAdTagDetails/{vod_ad_tag_detail}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String vodSession;
  private final String vodAdTagDetail;

  @Deprecated
  protected VodAdTagDetailName() {
    project = null;
    location = null;
    vodSession = null;
    vodAdTagDetail = null;
  }

  private VodAdTagDetailName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    vodSession = Preconditions.checkNotNull(builder.getVodSession());
    vodAdTagDetail = Preconditions.checkNotNull(builder.getVodAdTagDetail());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getVodSession() {
    return vodSession;
  }

  public String getVodAdTagDetail() {
    return vodAdTagDetail;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VodAdTagDetailName of(
      String project, String location, String vodSession, String vodAdTagDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVodSession(vodSession)
        .setVodAdTagDetail(vodAdTagDetail)
        .build();
  }

  public static String format(
      String project, String location, String vodSession, String vodAdTagDetail) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setVodSession(vodSession)
        .setVodAdTagDetail(vodAdTagDetail)
        .build()
        .toString();
  }

  public static VodAdTagDetailName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_VOD_SESSION_VOD_AD_TAG_DETAIL.validatedMatch(
            formattedString, "VodAdTagDetailName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("vod_session"),
        matchMap.get("vod_ad_tag_detail"));
  }

  public static List<VodAdTagDetailName> parseList(List<String> formattedStrings) {
    List<VodAdTagDetailName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VodAdTagDetailName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VodAdTagDetailName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_VOD_SESSION_VOD_AD_TAG_DETAIL.matches(formattedString);
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
          if (vodSession != null) {
            fieldMapBuilder.put("vod_session", vodSession);
          }
          if (vodAdTagDetail != null) {
            fieldMapBuilder.put("vod_ad_tag_detail", vodAdTagDetail);
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
    return PROJECT_LOCATION_VOD_SESSION_VOD_AD_TAG_DETAIL.instantiate(
        "project",
        project,
        "location",
        location,
        "vod_session",
        vodSession,
        "vod_ad_tag_detail",
        vodAdTagDetail);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      VodAdTagDetailName that = ((VodAdTagDetailName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.vodSession, that.vodSession)
          && Objects.equals(this.vodAdTagDetail, that.vodAdTagDetail);
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
    h ^= Objects.hashCode(vodSession);
    h *= 1000003;
    h ^= Objects.hashCode(vodAdTagDetail);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/vodSessions/{vod_session}/vodAdTagDetails/{vod_ad_tag_detail}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String vodSession;
    private String vodAdTagDetail;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getVodSession() {
      return vodSession;
    }

    public String getVodAdTagDetail() {
      return vodAdTagDetail;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setVodSession(String vodSession) {
      this.vodSession = vodSession;
      return this;
    }

    public Builder setVodAdTagDetail(String vodAdTagDetail) {
      this.vodAdTagDetail = vodAdTagDetail;
      return this;
    }

    private Builder(VodAdTagDetailName vodAdTagDetailName) {
      this.project = vodAdTagDetailName.project;
      this.location = vodAdTagDetailName.location;
      this.vodSession = vodAdTagDetailName.vodSession;
      this.vodAdTagDetail = vodAdTagDetailName.vodAdTagDetail;
    }

    public VodAdTagDetailName build() {
      return new VodAdTagDetailName(this);
    }
  }
}
