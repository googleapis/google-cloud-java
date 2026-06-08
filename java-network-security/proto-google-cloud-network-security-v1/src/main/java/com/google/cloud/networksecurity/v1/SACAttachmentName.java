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

package com.google.cloud.networksecurity.v1;

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
public class SACAttachmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SAC_ATTACHMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/sacAttachments/{sac_attachment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String sacAttachment;

  @Deprecated
  protected SACAttachmentName() {
    project = null;
    location = null;
    sacAttachment = null;
  }

  private SACAttachmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    sacAttachment = Preconditions.checkNotNull(builder.getSacAttachment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSacAttachment() {
    return sacAttachment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SACAttachmentName of(String project, String location, String sacAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSacAttachment(sacAttachment)
        .build();
  }

  public static String format(String project, String location, String sacAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSacAttachment(sacAttachment)
        .build()
        .toString();
  }

  public static SACAttachmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SAC_ATTACHMENT.validatedMatch(
            formattedString, "SACAttachmentName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("sac_attachment"));
  }

  public static List<SACAttachmentName> parseList(List<String> formattedStrings) {
    List<SACAttachmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SACAttachmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SACAttachmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SAC_ATTACHMENT.matches(formattedString);
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
          if (sacAttachment != null) {
            fieldMapBuilder.put("sac_attachment", sacAttachment);
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
    return PROJECT_LOCATION_SAC_ATTACHMENT.instantiate(
        "project", project, "location", location, "sac_attachment", sacAttachment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SACAttachmentName that = ((SACAttachmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.sacAttachment, that.sacAttachment);
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
    h ^= Objects.hashCode(sacAttachment);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/sacAttachments/{sac_attachment}. */
  public static class Builder {
    private String project;
    private String location;
    private String sacAttachment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSacAttachment() {
      return sacAttachment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSacAttachment(String sacAttachment) {
      this.sacAttachment = sacAttachment;
      return this;
    }

    private Builder(SACAttachmentName sACAttachmentName) {
      this.project = sACAttachmentName.project;
      this.location = sACAttachmentName.location;
      this.sacAttachment = sACAttachmentName.sacAttachment;
    }

    public SACAttachmentName build() {
      return new SACAttachmentName(this);
    }
  }
}
