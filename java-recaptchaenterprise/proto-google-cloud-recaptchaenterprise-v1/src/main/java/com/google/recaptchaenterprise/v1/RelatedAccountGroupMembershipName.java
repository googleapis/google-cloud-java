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
public class RelatedAccountGroupMembershipName implements ResourceName {
  private static final PathTemplate PROJECT_RELATEDACCOUNTGROUP_MEMBERSHIP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/relatedaccountgroups/{relatedaccountgroup}/memberships/{membership}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String relatedaccountgroup;
  private final String membership;

  @Deprecated
  protected RelatedAccountGroupMembershipName() {
    project = null;
    relatedaccountgroup = null;
    membership = null;
  }

  private RelatedAccountGroupMembershipName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    relatedaccountgroup = Preconditions.checkNotNull(builder.getRelatedaccountgroup());
    membership = Preconditions.checkNotNull(builder.getMembership());
  }

  public String getProject() {
    return project;
  }

  public String getRelatedaccountgroup() {
    return relatedaccountgroup;
  }

  public String getMembership() {
    return membership;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RelatedAccountGroupMembershipName of(
      String project, String relatedaccountgroup, String membership) {
    return newBuilder()
        .setProject(project)
        .setRelatedaccountgroup(relatedaccountgroup)
        .setMembership(membership)
        .build();
  }

  public static String format(String project, String relatedaccountgroup, String membership) {
    return newBuilder()
        .setProject(project)
        .setRelatedaccountgroup(relatedaccountgroup)
        .setMembership(membership)
        .build()
        .toString();
  }

  public static RelatedAccountGroupMembershipName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_RELATEDACCOUNTGROUP_MEMBERSHIP.validatedMatch(
            formattedString,
            "RelatedAccountGroupMembershipName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"), matchMap.get("relatedaccountgroup"), matchMap.get("membership"));
  }

  public static List<RelatedAccountGroupMembershipName> parseList(List<String> formattedStrings) {
    List<RelatedAccountGroupMembershipName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RelatedAccountGroupMembershipName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RelatedAccountGroupMembershipName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_RELATEDACCOUNTGROUP_MEMBERSHIP.matches(formattedString);
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
          if (membership != null) {
            fieldMapBuilder.put("membership", membership);
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
    return PROJECT_RELATEDACCOUNTGROUP_MEMBERSHIP.instantiate(
        "project", project, "relatedaccountgroup", relatedaccountgroup, "membership", membership);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      RelatedAccountGroupMembershipName that = ((RelatedAccountGroupMembershipName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.relatedaccountgroup, that.relatedaccountgroup)
          && Objects.equals(this.membership, that.membership);
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
    h *= 1000003;
    h ^= Objects.hashCode(membership);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/relatedaccountgroups/{relatedaccountgroup}/memberships/{membership}.
   */
  public static class Builder {
    private String project;
    private String relatedaccountgroup;
    private String membership;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getRelatedaccountgroup() {
      return relatedaccountgroup;
    }

    public String getMembership() {
      return membership;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setRelatedaccountgroup(String relatedaccountgroup) {
      this.relatedaccountgroup = relatedaccountgroup;
      return this;
    }

    public Builder setMembership(String membership) {
      this.membership = membership;
      return this;
    }

    private Builder(RelatedAccountGroupMembershipName relatedAccountGroupMembershipName) {
      this.project = relatedAccountGroupMembershipName.project;
      this.relatedaccountgroup = relatedAccountGroupMembershipName.relatedaccountgroup;
      this.membership = relatedAccountGroupMembershipName.membership;
    }

    public RelatedAccountGroupMembershipName build() {
      return new RelatedAccountGroupMembershipName(this);
    }
  }
}
