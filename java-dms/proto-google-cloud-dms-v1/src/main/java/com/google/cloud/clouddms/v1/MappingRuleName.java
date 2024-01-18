/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.clouddms.v1;

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
public class MappingRuleName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CONVERSION_WORKSPACE_MAPPING_RULE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}/mappingRules/{mapping_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String conversionWorkspace;
  private final String mappingRule;

  @Deprecated
  protected MappingRuleName() {
    project = null;
    location = null;
    conversionWorkspace = null;
    mappingRule = null;
  }

  private MappingRuleName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    conversionWorkspace = Preconditions.checkNotNull(builder.getConversionWorkspace());
    mappingRule = Preconditions.checkNotNull(builder.getMappingRule());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getConversionWorkspace() {
    return conversionWorkspace;
  }

  public String getMappingRule() {
    return mappingRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MappingRuleName of(
      String project, String location, String conversionWorkspace, String mappingRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversionWorkspace(conversionWorkspace)
        .setMappingRule(mappingRule)
        .build();
  }

  public static String format(
      String project, String location, String conversionWorkspace, String mappingRule) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setConversionWorkspace(conversionWorkspace)
        .setMappingRule(mappingRule)
        .build()
        .toString();
  }

  public static MappingRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CONVERSION_WORKSPACE_MAPPING_RULE.validatedMatch(
            formattedString, "MappingRuleName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("conversion_workspace"),
        matchMap.get("mapping_rule"));
  }

  public static List<MappingRuleName> parseList(List<String> formattedStrings) {
    List<MappingRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MappingRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MappingRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CONVERSION_WORKSPACE_MAPPING_RULE.matches(formattedString);
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
          if (conversionWorkspace != null) {
            fieldMapBuilder.put("conversion_workspace", conversionWorkspace);
          }
          if (mappingRule != null) {
            fieldMapBuilder.put("mapping_rule", mappingRule);
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
    return PROJECT_LOCATION_CONVERSION_WORKSPACE_MAPPING_RULE.instantiate(
        "project",
        project,
        "location",
        location,
        "conversion_workspace",
        conversionWorkspace,
        "mapping_rule",
        mappingRule);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MappingRuleName that = ((MappingRuleName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.conversionWorkspace, that.conversionWorkspace)
          && Objects.equals(this.mappingRule, that.mappingRule);
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
    h ^= Objects.hashCode(conversionWorkspace);
    h *= 1000003;
    h ^= Objects.hashCode(mappingRule);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/conversionWorkspaces/{conversion_workspace}/mappingRules/{mapping_rule}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String conversionWorkspace;
    private String mappingRule;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getConversionWorkspace() {
      return conversionWorkspace;
    }

    public String getMappingRule() {
      return mappingRule;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setConversionWorkspace(String conversionWorkspace) {
      this.conversionWorkspace = conversionWorkspace;
      return this;
    }

    public Builder setMappingRule(String mappingRule) {
      this.mappingRule = mappingRule;
      return this;
    }

    private Builder(MappingRuleName mappingRuleName) {
      this.project = mappingRuleName.project;
      this.location = mappingRuleName.location;
      this.conversionWorkspace = mappingRuleName.conversionWorkspace;
      this.mappingRule = mappingRuleName.mappingRule;
    }

    public MappingRuleName build() {
      return new MappingRuleName(this);
    }
  }
}
