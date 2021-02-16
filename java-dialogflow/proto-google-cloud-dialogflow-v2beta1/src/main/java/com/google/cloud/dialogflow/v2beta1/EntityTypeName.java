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

package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.BetaApi;
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
public class EntityTypeName implements ResourceName {
  private static final PathTemplate PROJECT_ENTITY_TYPE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/agent/entityTypes/{entity_type}");
  private static final PathTemplate PROJECT_LOCATION_ENTITY_TYPE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/agent/entityTypes/{entity_type}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String entityType;
  private final String location;

  @Deprecated
  protected EntityTypeName() {
    project = null;
    entityType = null;
    location = null;
  }

  private EntityTypeName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
    location = null;
    pathTemplate = PROJECT_ENTITY_TYPE;
  }

  private EntityTypeName(ProjectLocationEntityTypeBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    entityType = Preconditions.checkNotNull(builder.getEntityType());
    pathTemplate = PROJECT_LOCATION_ENTITY_TYPE;
  }

  public String getProject() {
    return project;
  }

  public String getEntityType() {
    return entityType;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectEntityTypeBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectLocationEntityTypeBuilder newProjectLocationEntityTypeBuilder() {
    return new ProjectLocationEntityTypeBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntityTypeName of(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EntityTypeName ofProjectEntityTypeName(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static EntityTypeName ofProjectLocationEntityTypeName(
      String project, String location, String entityType) {
    return newProjectLocationEntityTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntityType(entityType)
        .build();
  }

  public static String format(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectEntityTypeName(String project, String entityType) {
    return newBuilder().setProject(project).setEntityType(entityType).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectLocationEntityTypeName(
      String project, String location, String entityType) {
    return newProjectLocationEntityTypeBuilder()
        .setProject(project)
        .setLocation(location)
        .setEntityType(entityType)
        .build()
        .toString();
  }

  public static EntityTypeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_ENTITY_TYPE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_ENTITY_TYPE.match(formattedString);
      return ofProjectEntityTypeName(matchMap.get("project"), matchMap.get("entity_type"));
    } else if (PROJECT_LOCATION_ENTITY_TYPE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_ENTITY_TYPE.match(formattedString);
      return ofProjectLocationEntityTypeName(
          matchMap.get("project"), matchMap.get("location"), matchMap.get("entity_type"));
    }
    throw new ValidationException("EntityTypeName.parse: formattedString not in valid format");
  }

  public static List<EntityTypeName> parseList(List<String> formattedStrings) {
    List<EntityTypeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntityTypeName> values) {
    List<String> list = new ArrayList<>(values.size());
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
    return PROJECT_ENTITY_TYPE.matches(formattedString)
        || PROJECT_LOCATION_ENTITY_TYPE.matches(formattedString);
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
          if (entityType != null) {
            fieldMapBuilder.put("entity_type", entityType);
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
    if (o != null || getClass() == o.getClass()) {
      EntityTypeName that = ((EntityTypeName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.entityType, that.entityType)
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
    h ^= Objects.hashCode(entityType);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for projects/{project}/agent/entityTypes/{entity_type}. */
  public static class Builder {
    private String project;
    private String entityType;

    protected Builder() {}

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

    private Builder(EntityTypeName entityTypeName) {
      Preconditions.checkArgument(
          Objects.equals(entityTypeName.pathTemplate, PROJECT_ENTITY_TYPE),
          "toBuilder is only supported when EntityTypeName has the pattern of projects/{project}/agent/entityTypes/{entity_type}");
      project = entityTypeName.project;
      entityType = entityTypeName.entityType;
    }

    public EntityTypeName build() {
      return new EntityTypeName(this);
    }
  }

  /** Builder for projects/{project}/locations/{location}/agent/entityTypes/{entity_type}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectLocationEntityTypeBuilder {
    private String project;
    private String location;
    private String entityType;

    protected ProjectLocationEntityTypeBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getEntityType() {
      return entityType;
    }

    public ProjectLocationEntityTypeBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationEntityTypeBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationEntityTypeBuilder setEntityType(String entityType) {
      this.entityType = entityType;
      return this;
    }

    public EntityTypeName build() {
      return new EntityTypeName(this);
    }
  }
}
