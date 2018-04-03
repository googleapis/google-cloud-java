/*
 * Copyright 2018 Google LLC
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
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class TargetVpnGatewayName implements com.google.api.resourcenames.ResourceName {
  private final String project;
  private final String region;
  private final String targetVpnGateway;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/regions/{region}/targetVpnGateways/{targetVpnGateway}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private TargetVpnGatewayName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
    targetVpnGateway = Preconditions.checkNotNull(builder.getTargetVpnGateway());
  }

  public static TargetVpnGatewayName of(
      String project,
      String region,
      String targetVpnGateway
      ) {
    return newBuilder()
    .setProject(project)
    .setRegion(region)
    .setTargetVpnGateway(targetVpnGateway)
      .build();
  }

  public static String format(
      String project,
      String region,
      String targetVpnGateway
      ) {
    return of(
        project,
        region,
        targetVpnGateway
        )
        .toString();
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }

  public String getTargetVpnGateway() {
    return targetVpnGateway;
  }


  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldMapBuilder.put("targetVpnGateway", targetVpnGateway);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }


  public static ResourceNameFactory<TargetVpnGatewayName> newFactory() {
    return new ResourceNameFactory<TargetVpnGatewayName>() {
      public TargetVpnGatewayName parse(String formattedString) {return TargetVpnGatewayName.parse(formattedString);}
    };
  }

  public static TargetVpnGatewayName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "TargetVpnGatewayName.parse: formattedString not in valid format");
    return of(
      matchMap.get("project"),
      matchMap.get("region"),
      matchMap.get("targetVpnGateway")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String region;
    private String targetVpnGateway;

    public String getProject() {
      return project;
    }
    public String getRegion() {
      return region;
    }
    public String getTargetVpnGateway() {
      return targetVpnGateway;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }
    public Builder setTargetVpnGateway(String targetVpnGateway) {
      this.targetVpnGateway = targetVpnGateway;
      return this;
    }

    private Builder() {}

    public Builder (TargetVpnGatewayName targetVpnGatewayName) {
      project = targetVpnGatewayName.project;
      region = targetVpnGatewayName.region;
      targetVpnGateway = targetVpnGatewayName.targetVpnGateway;
    }

    public TargetVpnGatewayName build() {
      return new TargetVpnGatewayName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "region", region,
        "targetVpnGateway", targetVpnGateway
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TargetVpnGatewayName) {
      TargetVpnGatewayName that = (TargetVpnGatewayName) o;
      return
          Objects.equals(this.project, that.getProject()) &&
          Objects.equals(this.region, that.getRegion()) &&
          Objects.equals(this.targetVpnGateway, that.getTargetVpnGateway())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      project,
      region,
      targetVpnGateway
    );
  }
}
