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

package com.google.cloud.visionai.v1;

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
public class DraftName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_APPLICATION_DRAFT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/applications/{application}/drafts/{draft}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String application;
  private final String draft;

  @Deprecated
  protected DraftName() {
    project = null;
    location = null;
    application = null;
    draft = null;
  }

  private DraftName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    application = Preconditions.checkNotNull(builder.getApplication());
    draft = Preconditions.checkNotNull(builder.getDraft());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getApplication() {
    return application;
  }

  public String getDraft() {
    return draft;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DraftName of(String project, String location, String application, String draft) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApplication(application)
        .setDraft(draft)
        .build();
  }

  public static String format(String project, String location, String application, String draft) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setApplication(application)
        .setDraft(draft)
        .build()
        .toString();
  }

  public static DraftName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_APPLICATION_DRAFT.validatedMatch(
            formattedString, "DraftName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("application"),
        matchMap.get("draft"));
  }

  public static List<DraftName> parseList(List<String> formattedStrings) {
    List<DraftName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DraftName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DraftName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_APPLICATION_DRAFT.matches(formattedString);
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
          if (application != null) {
            fieldMapBuilder.put("application", application);
          }
          if (draft != null) {
            fieldMapBuilder.put("draft", draft);
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
    return PROJECT_LOCATION_APPLICATION_DRAFT.instantiate(
        "project", project, "location", location, "application", application, "draft", draft);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DraftName that = ((DraftName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.application, that.application)
          && Objects.equals(this.draft, that.draft);
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
    h ^= Objects.hashCode(application);
    h *= 1000003;
    h ^= Objects.hashCode(draft);
    return h;
  }

  /**
   * Builder for projects/{project}/locations/{location}/applications/{application}/drafts/{draft}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String application;
    private String draft;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getApplication() {
      return application;
    }

    public String getDraft() {
      return draft;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setApplication(String application) {
      this.application = application;
      return this;
    }

    public Builder setDraft(String draft) {
      this.draft = draft;
      return this;
    }

    private Builder(DraftName draftName) {
      this.project = draftName.project;
      this.location = draftName.location;
      this.application = draftName.application;
      this.draft = draftName.draft;
    }

    public DraftName build() {
      return new DraftName(this);
    }
  }
}
