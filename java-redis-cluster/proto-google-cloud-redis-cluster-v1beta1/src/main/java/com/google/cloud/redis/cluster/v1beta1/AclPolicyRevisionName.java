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

package com.google.cloud.redis.cluster.v1beta1;

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
public class AclPolicyRevisionName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ACL_POLICY_REVISION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/aclPolicies/{acl_policy}/revisions/{revision}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String aclPolicy;
  private final String revision;

  @Deprecated
  protected AclPolicyRevisionName() {
    project = null;
    location = null;
    aclPolicy = null;
    revision = null;
  }

  private AclPolicyRevisionName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    aclPolicy = Preconditions.checkNotNull(builder.getAclPolicy());
    revision = Preconditions.checkNotNull(builder.getRevision());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAclPolicy() {
    return aclPolicy;
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

  public static AclPolicyRevisionName of(
      String project, String location, String aclPolicy, String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAclPolicy(aclPolicy)
        .setRevision(revision)
        .build();
  }

  public static String format(String project, String location, String aclPolicy, String revision) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAclPolicy(aclPolicy)
        .setRevision(revision)
        .build()
        .toString();
  }

  public static @Nullable AclPolicyRevisionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ACL_POLICY_REVISION.validatedMatch(
            formattedString, "AclPolicyRevisionName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("acl_policy"),
        matchMap.get("revision"));
  }

  public static List<AclPolicyRevisionName> parseList(List<String> formattedStrings) {
    List<AclPolicyRevisionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AclPolicyRevisionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AclPolicyRevisionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ACL_POLICY_REVISION.matches(formattedString);
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
          if (aclPolicy != null) {
            fieldMapBuilder.put("acl_policy", aclPolicy);
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
    return PROJECT_LOCATION_ACL_POLICY_REVISION.instantiate(
        "project", project, "location", location, "acl_policy", aclPolicy, "revision", revision);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AclPolicyRevisionName that = ((AclPolicyRevisionName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.aclPolicy, that.aclPolicy)
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
    h ^= Objects.hashCode(aclPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(revision);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/aclPolicies/{acl_policy}/revisions/{revision}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String aclPolicy;
    private String revision;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAclPolicy() {
      return aclPolicy;
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

    public Builder setAclPolicy(String aclPolicy) {
      this.aclPolicy = aclPolicy;
      return this;
    }

    public Builder setRevision(String revision) {
      this.revision = revision;
      return this;
    }

    private Builder(AclPolicyRevisionName aclPolicyRevisionName) {
      this.project = aclPolicyRevisionName.project;
      this.location = aclPolicyRevisionName.location;
      this.aclPolicy = aclPolicyRevisionName.aclPolicy;
      this.revision = aclPolicyRevisionName.revision;
    }

    public AclPolicyRevisionName build() {
      return new AclPolicyRevisionName(this);
    }
  }
}
