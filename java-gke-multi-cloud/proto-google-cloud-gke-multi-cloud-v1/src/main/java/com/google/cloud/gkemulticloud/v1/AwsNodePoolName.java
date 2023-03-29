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

package com.google.cloud.gkemulticloud.v1;

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
public class AwsNodePoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_AWS_CLUSTER_AWS_NODE_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/awsClusters/{aws_cluster}/awsNodePools/{aws_node_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String awsCluster;
  private final String awsNodePool;

  @Deprecated
  protected AwsNodePoolName() {
    project = null;
    location = null;
    awsCluster = null;
    awsNodePool = null;
  }

  private AwsNodePoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    awsCluster = Preconditions.checkNotNull(builder.getAwsCluster());
    awsNodePool = Preconditions.checkNotNull(builder.getAwsNodePool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAwsCluster() {
    return awsCluster;
  }

  public String getAwsNodePool() {
    return awsNodePool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AwsNodePoolName of(
      String project, String location, String awsCluster, String awsNodePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAwsCluster(awsCluster)
        .setAwsNodePool(awsNodePool)
        .build();
  }

  public static String format(
      String project, String location, String awsCluster, String awsNodePool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAwsCluster(awsCluster)
        .setAwsNodePool(awsNodePool)
        .build()
        .toString();
  }

  public static AwsNodePoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_AWS_CLUSTER_AWS_NODE_POOL.validatedMatch(
            formattedString, "AwsNodePoolName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("aws_cluster"),
        matchMap.get("aws_node_pool"));
  }

  public static List<AwsNodePoolName> parseList(List<String> formattedStrings) {
    List<AwsNodePoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AwsNodePoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AwsNodePoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_AWS_CLUSTER_AWS_NODE_POOL.matches(formattedString);
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
          if (awsCluster != null) {
            fieldMapBuilder.put("aws_cluster", awsCluster);
          }
          if (awsNodePool != null) {
            fieldMapBuilder.put("aws_node_pool", awsNodePool);
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
    return PROJECT_LOCATION_AWS_CLUSTER_AWS_NODE_POOL.instantiate(
        "project",
        project,
        "location",
        location,
        "aws_cluster",
        awsCluster,
        "aws_node_pool",
        awsNodePool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AwsNodePoolName that = ((AwsNodePoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.awsCluster, that.awsCluster)
          && Objects.equals(this.awsNodePool, that.awsNodePool);
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
    h ^= Objects.hashCode(awsCluster);
    h *= 1000003;
    h ^= Objects.hashCode(awsNodePool);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/awsClusters/{aws_cluster}/awsNodePools/{aws_node_pool}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String awsCluster;
    private String awsNodePool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAwsCluster() {
      return awsCluster;
    }

    public String getAwsNodePool() {
      return awsNodePool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAwsCluster(String awsCluster) {
      this.awsCluster = awsCluster;
      return this;
    }

    public Builder setAwsNodePool(String awsNodePool) {
      this.awsNodePool = awsNodePool;
      return this;
    }

    private Builder(AwsNodePoolName awsNodePoolName) {
      this.project = awsNodePoolName.project;
      this.location = awsNodePoolName.location;
      this.awsCluster = awsNodePoolName.awsCluster;
      this.awsNodePool = awsNodePoolName.awsNodePool;
    }

    public AwsNodePoolName build() {
      return new AwsNodePoolName(this);
    }
  }
}
