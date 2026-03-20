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

package com.google.cloud.storagebatchoperations.v1;

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
public class BucketOperationName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_JOB_BUCKET_OPERATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/jobs/{job}/bucketOperations/{bucket_operation}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String job;
  private final String bucketOperation;

  @Deprecated
  protected BucketOperationName() {
    project = null;
    location = null;
    job = null;
    bucketOperation = null;
  }

  private BucketOperationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    job = Preconditions.checkNotNull(builder.getJob());
    bucketOperation = Preconditions.checkNotNull(builder.getBucketOperation());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getJob() {
    return job;
  }

  public String getBucketOperation() {
    return bucketOperation;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BucketOperationName of(
      String project, String location, String job, String bucketOperation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setBucketOperation(bucketOperation)
        .build();
  }

  public static String format(String project, String location, String job, String bucketOperation) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setBucketOperation(bucketOperation)
        .build()
        .toString();
  }

  public static BucketOperationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_JOB_BUCKET_OPERATION.validatedMatch(
            formattedString, "BucketOperationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("job"),
        matchMap.get("bucket_operation"));
  }

  public static List<BucketOperationName> parseList(List<String> formattedStrings) {
    List<BucketOperationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BucketOperationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BucketOperationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_JOB_BUCKET_OPERATION.matches(formattedString);
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
          if (job != null) {
            fieldMapBuilder.put("job", job);
          }
          if (bucketOperation != null) {
            fieldMapBuilder.put("bucket_operation", bucketOperation);
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
    return PROJECT_LOCATION_JOB_BUCKET_OPERATION.instantiate(
        "project", project, "location", location, "job", job, "bucket_operation", bucketOperation);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BucketOperationName that = ((BucketOperationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.job, that.job)
          && Objects.equals(this.bucketOperation, that.bucketOperation);
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
    h ^= Objects.hashCode(job);
    h *= 1000003;
    h ^= Objects.hashCode(bucketOperation);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/jobs/{job}/bucketOperations/{bucket_operation}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String job;
    private String bucketOperation;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getJob() {
      return job;
    }

    public String getBucketOperation() {
      return bucketOperation;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    public Builder setBucketOperation(String bucketOperation) {
      this.bucketOperation = bucketOperation;
      return this;
    }

    private Builder(BucketOperationName bucketOperationName) {
      this.project = bucketOperationName.project;
      this.location = bucketOperationName.location;
      this.job = bucketOperationName.job;
      this.bucketOperation = bucketOperationName.bucketOperation;
    }

    public BucketOperationName build() {
      return new BucketOperationName(this);
    }
  }
}
