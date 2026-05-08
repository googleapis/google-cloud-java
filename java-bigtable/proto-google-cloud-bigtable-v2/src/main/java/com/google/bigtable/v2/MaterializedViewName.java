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

package com.google.bigtable.v2;

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
public class MaterializedViewName implements ResourceName {
  private static final PathTemplate PROJECT_INSTANCE_MATERIALIZED_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/materializedViews/{materialized_view}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instance;
  private final String materializedView;

  @Deprecated
  protected MaterializedViewName() {
    project = null;
    instance = null;
    materializedView = null;
  }

  private MaterializedViewName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    materializedView = Preconditions.checkNotNull(builder.getMaterializedView());
  }

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getMaterializedView() {
    return materializedView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MaterializedViewName of(String project, String instance, String materializedView) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setMaterializedView(materializedView)
        .build();
  }

  public static String format(String project, String instance, String materializedView) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setMaterializedView(materializedView)
        .build()
        .toString();
  }

  public static MaterializedViewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_MATERIALIZED_VIEW.validatedMatch(
            formattedString, "MaterializedViewName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("instance"), matchMap.get("materialized_view"));
  }

  public static List<MaterializedViewName> parseList(List<String> formattedStrings) {
    List<MaterializedViewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MaterializedViewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MaterializedViewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTANCE_MATERIALIZED_VIEW.matches(formattedString);
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
          if (instance != null) {
            fieldMapBuilder.put("instance", instance);
          }
          if (materializedView != null) {
            fieldMapBuilder.put("materialized_view", materializedView);
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
    return PROJECT_INSTANCE_MATERIALIZED_VIEW.instantiate(
        "project", project, "instance", instance, "materialized_view", materializedView);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MaterializedViewName that = ((MaterializedViewName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.materializedView, that.materializedView);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(instance);
    h *= 1000003;
    h ^= Objects.hashCode(materializedView);
    return h;
  }

  /** Builder for projects/{project}/instances/{instance}/materializedViews/{materialized_view}. */
  public static class Builder {
    private String project;
    private String instance;
    private String materializedView;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getMaterializedView() {
      return materializedView;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setMaterializedView(String materializedView) {
      this.materializedView = materializedView;
      return this;
    }

    private Builder(MaterializedViewName materializedViewName) {
      this.project = materializedViewName.project;
      this.instance = materializedViewName.instance;
      this.materializedView = materializedViewName.materializedView;
    }

    public MaterializedViewName build() {
      return new MaterializedViewName(this);
    }
  }
}
