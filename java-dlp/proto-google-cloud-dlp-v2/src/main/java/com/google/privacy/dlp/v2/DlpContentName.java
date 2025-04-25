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

package com.google.privacy.dlp.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class DlpContentName implements ResourceName {
  private static final PathTemplate PROJECT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/dlpContent");
  private static final PathTemplate PROJECT_LOCATION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/locations/{location}/dlpContent");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;

  @Deprecated
  protected DlpContentName() {
    project = null;
    location = null;
  }

  private DlpContentName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = null;
    pathTemplate = PROJECT;
  }

  private DlpContentName(ProjectLocationBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    pathTemplate = PROJECT_LOCATION;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectBuilder() {
    return new Builder();
  }

  public static ProjectLocationBuilder newProjectLocationBuilder() {
    return new ProjectLocationBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DlpContentName of(String project) {
    return newBuilder().setProject(project).build();
  }

  public static DlpContentName ofProjectName(String project) {
    return newBuilder().setProject(project).build();
  }

  public static DlpContentName ofProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build();
  }

  public static String format(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  public static String formatProjectName(String project) {
    return newBuilder().setProject(project).build().toString();
  }

  public static String formatProjectLocationName(String project, String location) {
    return newProjectLocationBuilder().setProject(project).setLocation(location).build().toString();
  }

  public static DlpContentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT.match(formattedString);
      return ofProjectName(matchMap.get("project"));
    } else if (PROJECT_LOCATION.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION.match(formattedString);
      return ofProjectLocationName(matchMap.get("project"), matchMap.get("location"));
    }
    throw new ValidationException("DlpContentName.parse: formattedString not in valid format");
  }

  public static List<DlpContentName> parseList(List<String> formattedStrings) {
    List<DlpContentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DlpContentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DlpContentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT.matches(formattedString) || PROJECT_LOCATION.matches(formattedString);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DlpContentName that = ((DlpContentName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/dlpContent. */
  public static class Builder {
    private String project;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder(DlpContentName dlpContentName) {
      Preconditions.checkArgument(
          Objects.equals(dlpContentName.pathTemplate, PROJECT),
          "toBuilder is only supported when DlpContentName has the pattern of projects/{project}/dlpContent");
      this.project = dlpContentName.project;
    }

    public DlpContentName build() {
      return new DlpContentName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/dlpContent. */
  public static class ProjectLocationBuilder {
    private String project;
    private String location;

    protected ProjectLocationBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public ProjectLocationBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public DlpContentName build() {
      return new DlpContentName(this);
    }
  }
}
