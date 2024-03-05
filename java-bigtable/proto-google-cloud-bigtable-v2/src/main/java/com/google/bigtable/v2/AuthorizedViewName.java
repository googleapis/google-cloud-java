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
public class AuthorizedViewName implements ResourceName {
  private static final PathTemplate PROJECT_INSTANCE_TABLE_AUTHORIZED_VIEW =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/instances/{instance}/tables/{table}/authorizedViews/{authorized_view}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String instance;
  private final String table;
  private final String authorizedView;

  @Deprecated
  protected AuthorizedViewName() {
    project = null;
    instance = null;
    table = null;
    authorizedView = null;
  }

  private AuthorizedViewName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    table = Preconditions.checkNotNull(builder.getTable());
    authorizedView = Preconditions.checkNotNull(builder.getAuthorizedView());
  }

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getTable() {
    return table;
  }

  public String getAuthorizedView() {
    return authorizedView;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AuthorizedViewName of(
      String project, String instance, String table, String authorizedView) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setTable(table)
        .setAuthorizedView(authorizedView)
        .build();
  }

  public static String format(
      String project, String instance, String table, String authorizedView) {
    return newBuilder()
        .setProject(project)
        .setInstance(instance)
        .setTable(table)
        .setAuthorizedView(authorizedView)
        .build()
        .toString();
  }

  public static AuthorizedViewName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_INSTANCE_TABLE_AUTHORIZED_VIEW.validatedMatch(
            formattedString, "AuthorizedViewName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("instance"),
        matchMap.get("table"),
        matchMap.get("authorized_view"));
  }

  public static List<AuthorizedViewName> parseList(List<String> formattedStrings) {
    List<AuthorizedViewName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AuthorizedViewName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AuthorizedViewName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_INSTANCE_TABLE_AUTHORIZED_VIEW.matches(formattedString);
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
          if (table != null) {
            fieldMapBuilder.put("table", table);
          }
          if (authorizedView != null) {
            fieldMapBuilder.put("authorized_view", authorizedView);
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
    return PROJECT_INSTANCE_TABLE_AUTHORIZED_VIEW.instantiate(
        "project",
        project,
        "instance",
        instance,
        "table",
        table,
        "authorized_view",
        authorizedView);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AuthorizedViewName that = ((AuthorizedViewName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.instance, that.instance)
          && Objects.equals(this.table, that.table)
          && Objects.equals(this.authorizedView, that.authorizedView);
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
    h ^= Objects.hashCode(table);
    h *= 1000003;
    h ^= Objects.hashCode(authorizedView);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/instances/{instance}/tables/{table}/authorizedViews/{authorized_view}.
   */
  public static class Builder {
    private String project;
    private String instance;
    private String table;
    private String authorizedView;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getTable() {
      return table;
    }

    public String getAuthorizedView() {
      return authorizedView;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setTable(String table) {
      this.table = table;
      return this;
    }

    public Builder setAuthorizedView(String authorizedView) {
      this.authorizedView = authorizedView;
      return this;
    }

    private Builder(AuthorizedViewName authorizedViewName) {
      this.project = authorizedViewName.project;
      this.instance = authorizedViewName.instance;
      this.table = authorizedViewName.table;
      this.authorizedView = authorizedViewName.authorizedView;
    }

    public AuthorizedViewName build() {
      return new AuthorizedViewName(this);
    }
  }
}
