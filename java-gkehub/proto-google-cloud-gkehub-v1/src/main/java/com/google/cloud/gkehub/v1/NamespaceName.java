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

package com.google.cloud.gkehub.v1;

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
public class NamespaceName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SCOPE_NAMESPACE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/scopes/{scope}/namespaces/{namespace}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String scope;
  private final String namespace;

  @Deprecated
  protected NamespaceName() {
    project = null;
    location = null;
    scope = null;
    namespace = null;
  }

  private NamespaceName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    scope = Preconditions.checkNotNull(builder.getScope());
    namespace = Preconditions.checkNotNull(builder.getNamespace());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getScope() {
    return scope;
  }

  public String getNamespace() {
    return namespace;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NamespaceName of(String project, String location, String scope, String namespace) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setNamespace(namespace)
        .build();
  }

  public static String format(String project, String location, String scope, String namespace) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setNamespace(namespace)
        .build()
        .toString();
  }

  public static NamespaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SCOPE_NAMESPACE.validatedMatch(
            formattedString, "NamespaceName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("scope"),
        matchMap.get("namespace"));
  }

  public static List<NamespaceName> parseList(List<String> formattedStrings) {
    List<NamespaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NamespaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NamespaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SCOPE_NAMESPACE.matches(formattedString);
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
          if (scope != null) {
            fieldMapBuilder.put("scope", scope);
          }
          if (namespace != null) {
            fieldMapBuilder.put("namespace", namespace);
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
    return PROJECT_LOCATION_SCOPE_NAMESPACE.instantiate(
        "project", project, "location", location, "scope", scope, "namespace", namespace);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NamespaceName that = ((NamespaceName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.scope, that.scope)
          && Objects.equals(this.namespace, that.namespace);
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
    h ^= Objects.hashCode(scope);
    h *= 1000003;
    h ^= Objects.hashCode(namespace);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/scopes/{scope}/namespaces/{namespace}. */
  public static class Builder {
    private String project;
    private String location;
    private String scope;
    private String namespace;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getScope() {
      return scope;
    }

    public String getNamespace() {
      return namespace;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setScope(String scope) {
      this.scope = scope;
      return this;
    }

    public Builder setNamespace(String namespace) {
      this.namespace = namespace;
      return this;
    }

    private Builder(NamespaceName namespaceName) {
      this.project = namespaceName.project;
      this.location = namespaceName.location;
      this.scope = namespaceName.scope;
      this.namespace = namespaceName.namespace;
    }

    public NamespaceName build() {
      return new NamespaceName(this);
    }
  }
}
