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

package com.google.cloud.securesourcemanager.v1;

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
public class BranchRuleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_REPOSITORY_BRANCH_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/repositories/{repository}/branchRules/{branch_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String repository;
  private final String branchRule;

  @Deprecated
  protected BranchRuleName() {
    project = null;
    location = null;
    repository = null;
    branchRule = null;
  }

  private BranchRuleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    repository = Preconditions.checkNotNull(builder.getRepository());
    branchRule = Preconditions.checkNotNull(builder.getBranchRule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getRepository() {
    return repository;
  }

  public String getBranchRule() {
    return branchRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BranchRuleName of(
      String project, String location, String repository, String branchRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setBranchRule(branchRule)
        .build();
  }

  public static String format(
      String project, String location, String repository, String branchRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setRepository(repository)
        .setBranchRule(branchRule)
        .build()
        .toString();
  }

  public static BranchRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_REPOSITORY_BRANCH_RULE.validatedMatch(
            formattedString, "BranchRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("repository"),
        matchMap.get("branch_rule"));
  }

  public static List<BranchRuleName> parseList(List<String> formattedStrings) {
    List<BranchRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BranchRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BranchRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_REPOSITORY_BRANCH_RULE.matches(formattedString);
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
          if (repository != null) {
            fieldMapBuilder.put("repository", repository);
          }
          if (branchRule != null) {
            fieldMapBuilder.put("branch_rule", branchRule);
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
    return PROJECT_LOCATION_REPOSITORY_BRANCH_RULE.instantiate(
        "project",
        project,
        "location",
        location,
        "repository",
        repository,
        "branch_rule",
        branchRule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BranchRuleName that = ((BranchRuleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.repository, that.repository)
          && Objects.equals(this.branchRule, that.branchRule);
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
    h ^= Objects.hashCode(repository);
    h *= 1000003;
    h ^= Objects.hashCode(branchRule);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/repositories/{repository}/branchRules/{branch_rule}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String repository;
    private String branchRule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getRepository() {
      return repository;
    }

    public String getBranchRule() {
      return branchRule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setRepository(String repository) {
      this.repository = repository;
      return this;
    }

    public Builder setBranchRule(String branchRule) {
      this.branchRule = branchRule;
      return this;
    }

    private Builder(BranchRuleName branchRuleName) {
      this.project = branchRuleName.project;
      this.location = branchRuleName.location;
      this.repository = branchRuleName.repository;
      this.branchRule = branchRuleName.branchRule;
    }

    public BranchRuleName build() {
      return new BranchRuleName(this);
    }
  }
}
