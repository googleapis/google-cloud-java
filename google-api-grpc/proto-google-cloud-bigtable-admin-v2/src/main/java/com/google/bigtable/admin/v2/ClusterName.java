/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.bigtable.admin.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ClusterName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/instances/{instance}/clusters/{cluster}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String instance;
  private final String cluster;

  public String getProject() {
    return project;
  }

  public String getInstance() {
    return instance;
  }

  public String getCluster() {
    return cluster;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ClusterName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    instance = Preconditions.checkNotNull(builder.getInstance());
    cluster = Preconditions.checkNotNull(builder.getCluster());
  }

  public static ClusterName of(String project, String instance, String cluster) {
    return newBuilder()
      .setProject(project)
      .setInstance(instance)
      .setCluster(cluster)
      .build();
  }

  public static String format(String project, String instance, String cluster) {
    return newBuilder()
      .setProject(project)
      .setInstance(instance)
      .setCluster(cluster)
      .build()
      .toString();
  }

  public static ClusterName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ClusterName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("instance"), matchMap.get("cluster"));
  }

  public static List<ClusterName> parseList(List<String> formattedStrings) {
    List<ClusterName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ClusterName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ClusterName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("instance", instance);
          fieldMapBuilder.put("cluster", cluster);
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
    return PATH_TEMPLATE.instantiate("project", project, "instance", instance, "cluster", cluster);
  }

  /** Builder for ClusterName. */
  public static class Builder {

    private String project;
    private String instance;
    private String cluster;

    public String getProject() {
      return project;
    }

    public String getInstance() {
      return instance;
    }

    public String getCluster() {
      return cluster;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setInstance(String instance) {
      this.instance = instance;
      return this;
    }

    public Builder setCluster(String cluster) {
      this.cluster = cluster;
      return this;
    }

    private Builder() {
    }

    private Builder(ClusterName clusterName) {
      project = clusterName.project;
      instance = clusterName.instance;
      cluster = clusterName.cluster;
    }

    public ClusterName build() {
      return new ClusterName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ClusterName) {
      ClusterName that = (ClusterName) o;
      return (this.project.equals(that.project))
          && (this.instance.equals(that.instance))
          && (this.cluster.equals(that.cluster));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= instance.hashCode();
    h *= 1000003;
    h ^= cluster.hashCode();
    return h;
  }
}

