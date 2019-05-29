/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.dialogflow.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class EntityTypeName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/entityTypes/{entity_type}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String entityType;

  public String getProject() {
    return project;
  }

  public String getEntityType() {
    return entityType;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private EntityTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
  }

  public static EntityTypeName of(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build();
  }

  public static String format(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build().toString();
  }

  public static EntityTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "EntityTypeName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("entity_type"));
  }

  public static List<EntityTypeName> parseList(List<String> formattedStrings) {
    List<EntityTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntityTypeName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (EntityTypeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("entityType", entityType);
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
    return PATH_TEMPLATE.instantiate("project", project, "entity_type", entityType);
  }

  /** Builder for EntityTypeName. */
  public static class Builder {

    private String project;
    private String entityType;

    public String getProject() {
      return project;
    }

    public String getEntityType() {
      return entityType;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setEntityType(String entityType) {
      this.entityType = entityType;
      return this;
    }

    private Builder() {}

    private Builder(EntityTypeName entityTypeName) {
      project = entityTypeName.project;
      entityType = entityTypeName.entityType;
    }

    public EntityTypeName build() {
      return new EntityTypeName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EntityTypeName) {
      EntityTypeName that = (EntityTypeName) o;
      return (this.project.equals(that.project)) && (this.entityType.equals(that.entityType));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= entityType.hashCode();
    return h;
  }
}
