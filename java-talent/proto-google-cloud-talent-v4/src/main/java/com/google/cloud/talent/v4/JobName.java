/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4;

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
public class JobName implements ResourceName {
  private static final PathTemplate PROJECT_TENANT_JOB =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/tenants/{tenant}/jobs/{job}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String tenant;
  private final String job;

  @Deprecated
  protected JobName() {
    project = null;
    tenant = null;
    job = null;
  }

  private JobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
    job = Preconditions.checkNotNull(builder.getJob());
  }

  public String getProject() {
    return project;
  }

  public String getTenant() {
    return tenant;
  }

  public String getJob() {
    return job;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobName of(String project, String tenant, String job) {
    return newBuilder().setProject(project).setTenant(tenant).setJob(job).build();
  }

  public static String format(String project, String tenant, String job) {
    return newBuilder().setProject(project).setTenant(tenant).setJob(job).build().toString();
  }

  public static JobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TENANT_JOB.validatedMatch(
            formattedString, "JobName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("tenant"), matchMap.get("job"));
  }

  public static List<JobName> parseList(List<String> formattedStrings) {
    List<JobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<JobName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (JobName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TENANT_JOB.matches(formattedString);
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
          if (tenant != null) {
            fieldMapBuilder.put("tenant", tenant);
          }
          if (job != null) {
            fieldMapBuilder.put("job", job);
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
    return PROJECT_TENANT_JOB.instantiate("project", project, "tenant", tenant, "job", job);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobName that = ((JobName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.tenant, that.tenant)
          && Objects.equals(this.job, that.job);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(tenant);
    h *= 1000003;
    h ^= Objects.hashCode(job);
    return h;
  }

  /** Builder for projects/{project}/tenants/{tenant}/jobs/{job}. */
  public static class Builder {
    private String project;
    private String tenant;
    private String job;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public String getJob() {
      return job;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    private Builder(JobName jobName) {
      project = jobName.project;
      tenant = jobName.tenant;
      job = jobName.job;
    }

    public JobName build() {
      return new JobName(this);
    }
  }
}
