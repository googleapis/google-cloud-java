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

package com.google.area120.tables.v1alpha1;

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
public class WorkspaceName implements ResourceName {
  private static final PathTemplate WORKSPACE =
      PathTemplate.createWithoutUrlEncoding("workspaces/{workspace}");
  private volatile Map<String, String> fieldValuesMap;
  private final String workspace;

  @Deprecated
  protected WorkspaceName() {
    workspace = null;
  }

  private WorkspaceName(Builder builder) {
    workspace = Preconditions.checkNotNull(builder.getWorkspace());
  }

  public String getWorkspace() {
    return workspace;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static WorkspaceName of(String workspace) {
    return newBuilder().setWorkspace(workspace).build();
  }

  public static String format(String workspace) {
    return newBuilder().setWorkspace(workspace).build().toString();
  }

  public static WorkspaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        WORKSPACE.validatedMatch(
            formattedString, "WorkspaceName.parse: formattedString not in valid format");
    return of(matchMap.get("workspace"));
  }

  public static List<WorkspaceName> parseList(List<String> formattedStrings) {
    List<WorkspaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<WorkspaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (WorkspaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return WORKSPACE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (workspace != null) {
            fieldMapBuilder.put("workspace", workspace);
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
    return WORKSPACE.instantiate("workspace", workspace);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      WorkspaceName that = ((WorkspaceName) o);
      return Objects.equals(this.workspace, that.workspace);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(workspace);
    return h;
  }

  /** Builder for workspaces/{workspace}. */
  public static class Builder {
    private String workspace;

    protected Builder() {}

    public String getWorkspace() {
      return workspace;
    }

    public Builder setWorkspace(String workspace) {
      this.workspace = workspace;
      return this;
    }

    private Builder(WorkspaceName workspaceName) {
      this.workspace = workspaceName.workspace;
    }

    public WorkspaceName build() {
      return new WorkspaceName(this);
    }
  }
}
