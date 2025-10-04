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

package com.google.cloud.run.v2;

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
public class BuildWorkerPoolName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_WORKER_POOL =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/workerPools/{worker_pool}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String workerPool;

  @Deprecated
  protected BuildWorkerPoolName() {
    project = null;
    location = null;
    workerPool = null;
  }

  private BuildWorkerPoolName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    workerPool = Preconditions.checkNotNull(builder.getWorkerPool());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getWorkerPool() {
    return workerPool;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BuildWorkerPoolName of(String project, String location, String workerPool) {
    return newBuilder().setProject(project).setLocation(location).setWorkerPool(workerPool).build();
  }

  public static String format(String project, String location, String workerPool) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setWorkerPool(workerPool)
        .build()
        .toString();
  }

  public static BuildWorkerPoolName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_WORKER_POOL.validatedMatch(
            formattedString, "BuildWorkerPoolName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("worker_pool"));
  }

  public static List<BuildWorkerPoolName> parseList(List<String> formattedStrings) {
    List<BuildWorkerPoolName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BuildWorkerPoolName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BuildWorkerPoolName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_WORKER_POOL.matches(formattedString);
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
          if (workerPool != null) {
            fieldMapBuilder.put("worker_pool", workerPool);
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
    return PROJECT_LOCATION_WORKER_POOL.instantiate(
        "project", project, "location", location, "worker_pool", workerPool);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BuildWorkerPoolName that = ((BuildWorkerPoolName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.workerPool, that.workerPool);
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
    h ^= Objects.hashCode(workerPool);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/workerPools/{worker_pool}. */
  public static class Builder {
    private String project;
    private String location;
    private String workerPool;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getWorkerPool() {
      return workerPool;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setWorkerPool(String workerPool) {
      this.workerPool = workerPool;
      return this;
    }

    private Builder(BuildWorkerPoolName buildWorkerPoolName) {
      this.project = buildWorkerPoolName.project;
      this.location = buildWorkerPoolName.location;
      this.workerPool = buildWorkerPoolName.workerPool;
    }

    public BuildWorkerPoolName build() {
      return new BuildWorkerPoolName(this);
    }
  }
}
