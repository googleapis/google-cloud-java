/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.aiplatform.v1;

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
public class VersionName implements ResourceName {
  private static final PathTemplate PROJECT_MODEL_VERSION =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/models/{model}/versions/{version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String model;
  private final String version;

  @Deprecated
  protected VersionName() {
    project = null;
    model = null;
    version = null;
  }

  private VersionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    model = Preconditions.checkNotNull(builder.getModel());
    version = Preconditions.checkNotNull(builder.getVersion());
  }

  public String getProject() {
    return project;
  }

  public String getModel() {
    return model;
  }

  public String getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static VersionName of(String project, String model, String version) {
    return newBuilder().setProject(project).setModel(model).setVersion(version).build();
  }

  public static String format(String project, String model, String version) {
    return newBuilder().setProject(project).setModel(model).setVersion(version).build().toString();
  }

  public static VersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_MODEL_VERSION.validatedMatch(
            formattedString, "VersionName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("model"), matchMap.get("version"));
  }

  public static List<VersionName> parseList(List<String> formattedStrings) {
    List<VersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<VersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (VersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_MODEL_VERSION.matches(formattedString);
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
          if (model != null) {
            fieldMapBuilder.put("model", model);
          }
          if (version != null) {
            fieldMapBuilder.put("version", version);
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
    return PROJECT_MODEL_VERSION.instantiate(
        "project", project, "model", model, "version", version);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      VersionName that = ((VersionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.model, that.model)
          && Objects.equals(this.version, that.version);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(model);
    h *= 1000003;
    h ^= Objects.hashCode(version);
    return h;
  }

  /** Builder for projects/{project}/models/{model}/versions/{version}. */
  public static class Builder {
    private String project;
    private String model;
    private String version;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getModel() {
      return model;
    }

    public String getVersion() {
      return version;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setModel(String model) {
      this.model = model;
      return this;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    private Builder(VersionName versionName) {
      project = versionName.project;
      model = versionName.model;
      version = versionName.version;
    }

    public VersionName build() {
      return new VersionName(this);
    }
  }
}
