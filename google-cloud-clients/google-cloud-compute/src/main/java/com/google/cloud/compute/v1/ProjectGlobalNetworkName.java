/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.compute.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectGlobalNetworkName implements ResourceName {
  private final String network;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("{project}/global/networks/{network}");

  public static final String SERVICE_ADDRESS = "https://www.googleapis.com/compute/v1/projects/";

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalNetworkName(Builder builder) {
    network = Preconditions.checkNotNull(builder.getNetwork());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectGlobalNetworkName of(String network, String project) {
    return newBuilder().setNetwork(network).setProject(project).build();
  }

  public static String format(String network, String project) {
    return of(network, project).toString();
  }

  public String getNetwork() {
    return network;
  }

  public String getProject() {
    return project;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("network", network);
          fieldMapBuilder.put("project", project);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalNetworkName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalNetworkName>() {
      public ProjectGlobalNetworkName parse(String formattedString) {
        return ProjectGlobalNetworkName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalNetworkName parse(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            resourcePath, "ProjectGlobalNetworkName.parse: formattedString not in valid format");
    return of(matchMap.get("network"), matchMap.get("project"));
  }

  public static boolean isParsableFrom(String formattedString) {
    String resourcePath = formattedString;
    if (formattedString.startsWith(SERVICE_ADDRESS)) {
      resourcePath = formattedString.substring(SERVICE_ADDRESS.length());
    }
    return PATH_TEMPLATE.matches(resourcePath);
  }

  public static class Builder {
    private String network;
    private String project;

    public String getNetwork() {
      return network;
    }

    public String getProject() {
      return project;
    }

    public Builder setNetwork(String network) {
      this.network = network;
      return this;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalNetworkName projectGlobalNetworkName) {
      network = projectGlobalNetworkName.network;
      project = projectGlobalNetworkName.project;
    }

    public ProjectGlobalNetworkName build() {
      return new ProjectGlobalNetworkName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "network", network,
        "project", project);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalNetworkName) {
      ProjectGlobalNetworkName that = (ProjectGlobalNetworkName) o;
      return Objects.equals(this.network, that.getNetwork())
          && Objects.equals(this.project, that.getProject());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(network, project);
  }
}
