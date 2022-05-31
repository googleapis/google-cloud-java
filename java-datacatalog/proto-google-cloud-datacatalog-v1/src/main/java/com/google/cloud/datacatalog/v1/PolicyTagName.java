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

package com.google.cloud.datacatalog.v1;

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
public class PolicyTagName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_TAXONOMY_POLICY_TAG =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/taxonomies/{taxonomy}/policyTags/{policy_tag}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String taxonomy;
  private final String policyTag;

  @Deprecated
  protected PolicyTagName() {
    project = null;
    location = null;
    taxonomy = null;
    policyTag = null;
  }

  private PolicyTagName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    taxonomy = Preconditions.checkNotNull(builder.getTaxonomy());
    policyTag = Preconditions.checkNotNull(builder.getPolicyTag());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getTaxonomy() {
    return taxonomy;
  }

  public String getPolicyTag() {
    return policyTag;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyTagName of(
      String project, String location, String taxonomy, String policyTag) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTaxonomy(taxonomy)
        .setPolicyTag(policyTag)
        .build();
  }

  public static String format(String project, String location, String taxonomy, String policyTag) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setTaxonomy(taxonomy)
        .setPolicyTag(policyTag)
        .build()
        .toString();
  }

  public static PolicyTagName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_TAXONOMY_POLICY_TAG.validatedMatch(
            formattedString, "PolicyTagName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("taxonomy"),
        matchMap.get("policy_tag"));
  }

  public static List<PolicyTagName> parseList(List<String> formattedStrings) {
    List<PolicyTagName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PolicyTagName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PolicyTagName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_TAXONOMY_POLICY_TAG.matches(formattedString);
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
          if (taxonomy != null) {
            fieldMapBuilder.put("taxonomy", taxonomy);
          }
          if (policyTag != null) {
            fieldMapBuilder.put("policy_tag", policyTag);
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
    return PROJECT_LOCATION_TAXONOMY_POLICY_TAG.instantiate(
        "project", project, "location", location, "taxonomy", taxonomy, "policy_tag", policyTag);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PolicyTagName that = ((PolicyTagName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.taxonomy, that.taxonomy)
          && Objects.equals(this.policyTag, that.policyTag);
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
    h ^= Objects.hashCode(taxonomy);
    h *= 1000003;
    h ^= Objects.hashCode(policyTag);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/taxonomies/{taxonomy}/policyTags/{policy_tag}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String taxonomy;
    private String policyTag;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getTaxonomy() {
      return taxonomy;
    }

    public String getPolicyTag() {
      return policyTag;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setTaxonomy(String taxonomy) {
      this.taxonomy = taxonomy;
      return this;
    }

    public Builder setPolicyTag(String policyTag) {
      this.policyTag = policyTag;
      return this;
    }

    private Builder(PolicyTagName policyTagName) {
      this.project = policyTagName.project;
      this.location = policyTagName.location;
      this.taxonomy = policyTagName.taxonomy;
      this.policyTag = policyTagName.policyTag;
    }

    public PolicyTagName build() {
      return new PolicyTagName(this);
    }
  }
}
