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

package com.google.cloud.agentregistry.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class SkillRevisionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SKILL_REVISION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/skills/{skill}/revisions/{revision}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String skill;
  private final String revision;

  @Deprecated
  protected SkillRevisionName() {
    project = null;
    location = null;
    skill = null;
    revision = null;
  }

  private SkillRevisionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    skill = Preconditions.checkNotNull(builder.getSkill());
    revision = Preconditions.checkNotNull(builder.getRevision());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getSkill() {
    return skill;
  }

  public String getRevision() {
    return revision;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SkillRevisionName of(
      String project, String location, String skill, String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSkill(skill)
        .setRevision(revision)
        .build();
  }

  public static String format(String project, String location, String skill, String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setSkill(skill)
        .setRevision(revision)
        .build()
        .toString();
  }

  public static @Nullable SkillRevisionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_SKILL_REVISION.validatedMatch(
            formattedString, "SkillRevisionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("skill"),
        matchMap.get("revision"));
  }

  public static List<SkillRevisionName> parseList(List<String> formattedStrings) {
    List<SkillRevisionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable SkillRevisionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SkillRevisionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SKILL_REVISION.matches(formattedString);
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
          if (skill != null) {
            fieldMapBuilder.put("skill", skill);
          }
          if (revision != null) {
            fieldMapBuilder.put("revision", revision);
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
    return PROJECT_LOCATION_SKILL_REVISION.instantiate(
        "project", project, "location", location, "skill", skill, "revision", revision);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SkillRevisionName that = ((SkillRevisionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.skill, that.skill)
          && Objects.equals(this.revision, that.revision);
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
    h ^= Objects.hashCode(skill);
    h *= 1000003;
    h ^= Objects.hashCode(revision);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/skills/{skill}/revisions/{revision}. */
  public static class Builder {
    private String project;
    private String location;
    private String skill;
    private String revision;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getSkill() {
      return skill;
    }

    public String getRevision() {
      return revision;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setSkill(String skill) {
      this.skill = skill;
      return this;
    }

    public Builder setRevision(String revision) {
      this.revision = revision;
      return this;
    }

    private Builder(SkillRevisionName skillRevisionName) {
      this.project = skillRevisionName.project;
      this.location = skillRevisionName.location;
      this.skill = skillRevisionName.skill;
      this.revision = skillRevisionName.revision;
    }

    public SkillRevisionName build() {
      return new SkillRevisionName(this);
    }
  }
}
