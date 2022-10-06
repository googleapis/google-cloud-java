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

package com.google.recaptchaenterprise.v1;

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
public class RelatedAccountGroupName implements ResourceName {
  private static final PathTemplate PROJECT_RELATEDACCOUNTGROUP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/relatedaccountgroups/{relatedaccountgroup}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String relatedaccountgroup;

  @Deprecated
  protected RelatedAccountGroupName() {
    project = null;
    relatedaccountgroup = null;
  }

  private RelatedAccountGroupName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    relatedaccountgroup = Preconditions.checkNotNull(builder.getRelatedaccountgroup());
  }

  public String getProject() {
    return project;
  }

  public String getRelatedaccountgroup() {
    return relatedaccountgroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RelatedAccountGroupName of(String project, String relatedaccountgroup) {
    return newBuilder().setProject(project).setRelatedaccountgroup(relatedaccountgroup).build();
  }

  public static String format(String project, String relatedaccountgroup) {
    return newBuilder()
        .setProject(project)
        .setRelatedaccountgroup(relatedaccountgroup)
        .build()
        .toString();
  }

  public static RelatedAccountGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_RELATEDACCOUNTGROUP.validatedMatch(
            formattedString, "RelatedAccountGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("relatedaccountgroup"));
  }

  public static List<RelatedAccountGroupName> parseList(List<String> formattedStrings) {
    List<RelatedAccountGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RelatedAccountGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RelatedAccountGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_RELATEDACCOUNTGROUP.matches(formattedString);
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
          if (relatedaccountgroup != null) {
            fieldMapBuilder.put("relatedaccountgroup", relatedaccountgroup);
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
    return PROJECT_RELATEDACCOUNTGROUP.instantiate(
        "project", project, "relatedaccountgroup", relatedaccountgroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      RelatedAccountGroupName that = ((RelatedAccountGroupName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.relatedaccountgroup, that.relatedaccountgroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(relatedaccountgroup);
    return h;
  }

  /** Builder for projects/{project}/relatedaccountgroups/{relatedaccountgroup}. */
  public static class Builder {
    private String project;
    private String relatedaccountgroup;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getRelatedaccountgroup() {
      return relatedaccountgroup;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRelatedaccountgroup(String relatedaccountgroup) {
      this.relatedaccountgroup = relatedaccountgroup;
      return this;
    }

    private Builder(RelatedAccountGroupName relatedAccountGroupName) {
      this.project = relatedAccountGroupName.project;
      this.relatedaccountgroup = relatedAccountGroupName.relatedaccountgroup;
    }

    public RelatedAccountGroupName build() {
      return new RelatedAccountGroupName(this);
    }
  }
}
