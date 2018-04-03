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
public final class ProjectBackendBucketName implements com.google.api.resourcenames.ResourceName {
  private final String backendBucket;
  private final String project;
  private static final PathTemplate PATH_TEMPLATE =
        PathTemplate.createWithoutUrlEncoding("projects/{project}/backendBuckets/{backendBucket}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectBackendBucketName(Builder builder) {
    backendBucket = Preconditions.checkNotNull(builder.getBackendBucket());
    project = Preconditions.checkNotNull(builder.getProject());
  }

  public static ProjectBackendBucketName of(
      String backendBucket,
      String project
      ) {
    return newBuilder()
    .setBackendBucket(backendBucket)
    .setProject(project)
      .build();
  }

  public static String format(
      String backendBucket,
      String project
      ) {
    return of(
        backendBucket,
        project
        )
        .toString();
  }

  public String getBackendBucket() {
    return backendBucket;
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
          fieldMapBuilder.put("backendBucket", backendBucket);
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


  public static ResourceNameFactory<ProjectBackendBucketName> newFactory() {
    return new ResourceNameFactory<ProjectBackendBucketName>() {
      public ProjectBackendBucketName parse(String formattedString) {return ProjectBackendBucketName.parse(formattedString);}
    };
  }

  public static ProjectBackendBucketName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "ProjectBackendBucketName.parse: formattedString not in valid format");
    return of(
      matchMap.get("backendBucket"),
      matchMap.get("project")
    );
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String backendBucket;
    private String project;

    public String getBackendBucket() {
      return backendBucket;
    }
    public String getProject() {
      return project;
    }

    public Builder setBackendBucket(String backendBucket) {
      this.backendBucket = backendBucket;
      return this;
    }
    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    private Builder() {}

    public Builder (ProjectBackendBucketName projectBackendBucketName) {
      backendBucket = projectBackendBucketName.backendBucket;
      project = projectBackendBucketName.project;
    }

    public ProjectBackendBucketName build() {
      return new ProjectBackendBucketName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "backendBucket", backendBucket,
        "project", project
        );
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectBackendBucketName) {
      ProjectBackendBucketName that = (ProjectBackendBucketName) o;
      return
          Objects.equals(this.backendBucket, that.getBackendBucket()) &&
          Objects.equals(this.project, that.getProject())
          ;
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(
      backendBucket,
      project
    );
  }
}
