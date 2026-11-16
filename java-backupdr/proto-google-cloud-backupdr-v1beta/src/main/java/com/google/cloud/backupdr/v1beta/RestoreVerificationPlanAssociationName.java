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

package com.google.cloud.backupdr.v1beta;

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
public class RestoreVerificationPlanAssociationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_RESTORE_VERIFICATION_PLAN_ASSOCIATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/restoreVerificationPlans/{restore_verification_plan}/associations/{association}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String restoreVerificationPlan;
  private final String association;

  @Deprecated
  protected RestoreVerificationPlanAssociationName() {
    project = null;
    location = null;
    restoreVerificationPlan = null;
    association = null;
  }

  private RestoreVerificationPlanAssociationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    restoreVerificationPlan = Preconditions.checkNotNull(builder.getRestoreVerificationPlan());
    association = Preconditions.checkNotNull(builder.getAssociation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRestoreVerificationPlan() {
    return restoreVerificationPlan;
  }

  public String getAssociation() {
    return association;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RestoreVerificationPlanAssociationName of(
      String project, String location, String restoreVerificationPlan, String association) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestoreVerificationPlan(restoreVerificationPlan)
        .setAssociation(association)
        .build();
  }

  public static String format(
      String project, String location, String restoreVerificationPlan, String association) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRestoreVerificationPlan(restoreVerificationPlan)
        .setAssociation(association)
        .build()
        .toString();
  }

  public static @Nullable RestoreVerificationPlanAssociationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_RESTORE_VERIFICATION_PLAN_ASSOCIATION.validatedMatch(
            formattedString,
            "RestoreVerificationPlanAssociationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("restore_verification_plan"),
        matchMap.get("association"));
  }

  public static List<RestoreVerificationPlanAssociationName> parseList(
      List<String> formattedStrings) {
    List<RestoreVerificationPlanAssociationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(
      List<@Nullable RestoreVerificationPlanAssociationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RestoreVerificationPlanAssociationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_RESTORE_VERIFICATION_PLAN_ASSOCIATION.matches(formattedString);
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
          if (restoreVerificationPlan != null) {
            fieldMapBuilder.put("restore_verification_plan", restoreVerificationPlan);
          }
          if (association != null) {
            fieldMapBuilder.put("association", association);
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
    return PROJECT_LOCATION_RESTORE_VERIFICATION_PLAN_ASSOCIATION.instantiate(
        "project",
        project,
        "location",
        location,
        "restore_verification_plan",
        restoreVerificationPlan,
        "association",
        association);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RestoreVerificationPlanAssociationName that = ((RestoreVerificationPlanAssociationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.restoreVerificationPlan, that.restoreVerificationPlan)
          && Objects.equals(this.association, that.association);
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
    h ^= Objects.hashCode(restoreVerificationPlan);
    h *= 1000003;
    h ^= Objects.hashCode(association);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/restoreVerificationPlans/{restore_verification_plan}/associations/{association}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String restoreVerificationPlan;
    private String association;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRestoreVerificationPlan() {
      return restoreVerificationPlan;
    }

    public String getAssociation() {
      return association;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRestoreVerificationPlan(String restoreVerificationPlan) {
      this.restoreVerificationPlan = restoreVerificationPlan;
      return this;
    }

    public Builder setAssociation(String association) {
      this.association = association;
      return this;
    }

    private Builder(RestoreVerificationPlanAssociationName restoreVerificationPlanAssociationName) {
      this.project = restoreVerificationPlanAssociationName.project;
      this.location = restoreVerificationPlanAssociationName.location;
      this.restoreVerificationPlan = restoreVerificationPlanAssociationName.restoreVerificationPlan;
      this.association = restoreVerificationPlanAssociationName.association;
    }

    public RestoreVerificationPlanAssociationName build() {
      return new RestoreVerificationPlanAssociationName(this);
    }
  }
}
