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

package com.google.cloud.vmmigration.v1;

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
public class ImageImportJobName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_JOB_RESULT =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/imageImports/{job}/imageImportJobs/{result}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String job;
  private final String result;

  @Deprecated
  protected ImageImportJobName() {
    project = null;
    location = null;
    job = null;
    result = null;
  }

  private ImageImportJobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    job = Preconditions.checkNotNull(builder.getJob());
    result = Preconditions.checkNotNull(builder.getResult());
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

  public String getResult() {
    return result;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ImageImportJobName of(String project, String location, String job, String result) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setResult(result)
        .build();
  }

  public static String format(String project, String location, String job, String result) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setJob(job)
        .setResult(result)
        .build()
        .toString();
  }

  public static ImageImportJobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_JOB_RESULT.validatedMatch(
            formattedString, "ImageImportJobName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("job"),
        matchMap.get("result"));
  }

  public static List<ImageImportJobName> parseList(List<String> formattedStrings) {
    List<ImageImportJobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ImageImportJobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ImageImportJobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_JOB_RESULT.matches(formattedString);
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
          if (result != null) {
            fieldMapBuilder.put("result", result);
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
    return PROJECT_LOCATION_JOB_RESULT.instantiate(
        "project", project, "location", location, "job", job, "result", result);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ImageImportJobName that = ((ImageImportJobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.job, that.job)
          && Objects.equals(this.result, that.result);
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
    h ^= Objects.hashCode(result);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/imageImports/{job}/imageImportJobs/{result}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String job;
    private String result;

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

    public String getResult() {
      return result;
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

    public Builder setResult(String result) {
      this.result = result;
      return this;
    }

    private Builder(ImageImportJobName imageImportJobName) {
      this.project = imageImportJobName.project;
      this.location = imageImportJobName.location;
      this.job = imageImportJobName.job;
      this.result = imageImportJobName.result;
    }

    public ImageImportJobName build() {
      return new ImageImportJobName(this);
    }
  }
}
