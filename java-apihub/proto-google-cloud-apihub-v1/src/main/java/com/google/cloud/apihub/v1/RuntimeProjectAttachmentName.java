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

package com.google.cloud.apihub.v1;

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
public class RuntimeProjectAttachmentName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RUNTIME_PROJECT_ATTACHMENT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String runtimeProjectAttachment;

  @Deprecated
  protected RuntimeProjectAttachmentName() {
    project = null;
    location = null;
    runtimeProjectAttachment = null;
  }

  private RuntimeProjectAttachmentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    runtimeProjectAttachment = Preconditions.checkNotNull(builder.getRuntimeProjectAttachment());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRuntimeProjectAttachment() {
    return runtimeProjectAttachment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RuntimeProjectAttachmentName of(
      String project, String location, String runtimeProjectAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRuntimeProjectAttachment(runtimeProjectAttachment)
        .build();
  }

  public static String format(String project, String location, String runtimeProjectAttachment) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRuntimeProjectAttachment(runtimeProjectAttachment)
        .build()
        .toString();
  }

  public static RuntimeProjectAttachmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RUNTIME_PROJECT_ATTACHMENT.validatedMatch(
            formattedString,
            "RuntimeProjectAttachmentName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("runtime_project_attachment"));
  }

  public static List<RuntimeProjectAttachmentName> parseList(List<String> formattedStrings) {
    List<RuntimeProjectAttachmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RuntimeProjectAttachmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RuntimeProjectAttachmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RUNTIME_PROJECT_ATTACHMENT.matches(formattedString);
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
          if (runtimeProjectAttachment != null) {
            fieldMapBuilder.put("runtime_project_attachment", runtimeProjectAttachment);
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
    return PROJECT_LOCATION_RUNTIME_PROJECT_ATTACHMENT.instantiate(
        "project",
        project,
        "location",
        location,
        "runtime_project_attachment",
        runtimeProjectAttachment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RuntimeProjectAttachmentName that = ((RuntimeProjectAttachmentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.runtimeProjectAttachment, that.runtimeProjectAttachment);
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
    h ^= Objects.hashCode(runtimeProjectAttachment);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/runtimeProjectAttachments/{runtime_project_attachment}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String runtimeProjectAttachment;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRuntimeProjectAttachment() {
      return runtimeProjectAttachment;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRuntimeProjectAttachment(String runtimeProjectAttachment) {
      this.runtimeProjectAttachment = runtimeProjectAttachment;
      return this;
    }

    private Builder(RuntimeProjectAttachmentName runtimeProjectAttachmentName) {
      this.project = runtimeProjectAttachmentName.project;
      this.location = runtimeProjectAttachmentName.location;
      this.runtimeProjectAttachment = runtimeProjectAttachmentName.runtimeProjectAttachment;
    }

    public RuntimeProjectAttachmentName build() {
      return new RuntimeProjectAttachmentName(this);
    }
  }
}
