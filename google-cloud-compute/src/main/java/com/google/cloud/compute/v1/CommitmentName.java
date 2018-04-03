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
public final class CommitmentName implements com.google.api.resourcenames.ResourceName {
  private final String commitment;
  private final String project;
  private final String region;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/regions/{region}/commitments/{commitment}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private CommitmentName(Builder builder) {
    commitment = Preconditions.checkNotNull(builder.getCommitment());
    project = Preconditions.checkNotNull(builder.getProject());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public static CommitmentName of(
      String commitment,
      String project,
      String region
      ) {
    return newBuilder()
    .setCommitment(commitment)
    .setProject(project)
    .setRegion(region)
      .build();
  }

  public static String format(
      String commitment,
      String project,
      String region
      ) {
    return of(
        commitment,
        project,
        region
        )
        .toString();
  }

  public String getCommitment() {
    return commitment;
  }

  public String getProject() {
    return project;
  }

  public String getRegion() {
    return region;
  }


  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("commitment", commitment);
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("region", region);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }


  public static ResourceNameFactory<CommitmentName> newFactory() {
    return new ResourceNameFactory<CommitmentName>() {
      public CommitmentName parse(String formattedString) {return CommitmentName.parse(formattedString);}
    };
  }

  public static CommitmentName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "CommitmentName.parse: formattedString not in valid format");
    return of(
      matchMap.get("commitment"),
      matchMap.get("project"),
      matchMap.get("region")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String commitment;
    private String project;
    private String region;

    public String getCommitment() {
      return commitment;
    }
    public String getProject() {
      return project;
    }
    public String getRegion() {
      return region;
    }

    public Builder setCommitment(String commitment) {
      this.commitment = commitment;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }
    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    private Builder() {}

    public Builder (CommitmentName commitmentName) {
      commitment = commitmentName.commitment;
      project = commitmentName.project;
      region = commitmentName.region;
    }

    public CommitmentName build() {
      return new CommitmentName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "commitment", commitment,
        "project", project,
        "region", region
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CommitmentName) {
      CommitmentName that = (CommitmentName) o;
      return
          Objects.equals(this.commitment, that.getCommitment()) &&
          Objects.equals(this.project, that.getProject()) &&
          Objects.equals(this.region, that.getRegion())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      commitment,
      project,
      region
    );
  }
}
