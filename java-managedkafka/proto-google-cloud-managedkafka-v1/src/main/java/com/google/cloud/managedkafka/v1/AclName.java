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

package com.google.cloud.managedkafka.v1;

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
public class AclName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_CLUSTER_ACL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/clusters/{cluster}/acls/{acl}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String cluster;
  private final String acl;

  @Deprecated
  protected AclName() {
    project = null;
    location = null;
    cluster = null;
    acl = null;
  }

  private AclName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    cluster = Preconditions.checkNotNull(builder.getCluster());
    acl = Preconditions.checkNotNull(builder.getAcl());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getCluster() {
    return cluster;
  }

  public String getAcl() {
    return acl;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AclName of(String project, String location, String cluster, String acl) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setAcl(acl)
        .build();
  }

  public static String format(String project, String location, String cluster, String acl) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setCluster(cluster)
        .setAcl(acl)
        .build()
        .toString();
  }

  public static AclName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_CLUSTER_ACL.validatedMatch(
            formattedString, "AclName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("cluster"),
        matchMap.get("acl"));
  }

  public static List<AclName> parseList(List<String> formattedStrings) {
    List<AclName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AclName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AclName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_CLUSTER_ACL.matches(formattedString);
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
          if (cluster != null) {
            fieldMapBuilder.put("cluster", cluster);
          }
          if (acl != null) {
            fieldMapBuilder.put("acl", acl);
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
    return PROJECT_LOCATION_CLUSTER_ACL.instantiate(
        "project", project, "location", location, "cluster", cluster, "acl", acl);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AclName that = ((AclName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.cluster, that.cluster)
          && Objects.equals(this.acl, that.acl);
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
    h ^= Objects.hashCode(cluster);
    h *= 1000003;
    h ^= Objects.hashCode(acl);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/clusters/{cluster}/acls/{acl}. */
  public static class Builder {
    private String project;
    private String location;
    private String cluster;
    private String acl;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getCluster() {
      return cluster;
    }

    public String getAcl() {
      return acl;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    public Builder setAcl(String acl) {
      this.acl = acl;
      return this;
    }

    private Builder(AclName aclName) {
      this.project = aclName.project;
      this.location = aclName.location;
      this.cluster = aclName.cluster;
      this.acl = aclName.acl;
    }

    public AclName build() {
      return new AclName(this);
    }
  }
}
