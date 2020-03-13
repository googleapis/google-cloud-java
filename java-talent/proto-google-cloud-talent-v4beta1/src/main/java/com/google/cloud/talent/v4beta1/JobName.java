/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.talent.v4beta1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/** AUTO-GENERATED DOCUMENTATION AND CLASS */
@javax.annotation.Generated("by GAPIC protoc plugin")
public class JobName implements ResourceName {

  @Deprecated
  protected JobName() {}

  private static final PathTemplate PROJECT_JOB_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/jobs/{job}");
  private static final PathTemplate PROJECT_TENANT_JOB_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/tenants/{tenant}/jobs/{job}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String job;
  private String tenant;

  public String getProject() {
    return project;
  }

  public String getJob() {
    return job;
  }

  public String getTenant() {
    return tenant;
  }

  private JobName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    job = Preconditions.checkNotNull(builder.getJob());
    pathTemplate = PROJECT_JOB_PATH_TEMPLATE;
  }

  private JobName(ProjectTenantJobBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
    job = Preconditions.checkNotNull(builder.getJob());
    pathTemplate = PROJECT_TENANT_JOB_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectJobBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectTenantJobBuilder newProjectTenantJobBuilder() {
    return new ProjectTenantJobBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static JobName of(String project, String job) {
    return newProjectJobBuilder().setProject(project).setJob(job).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static JobName ofProjectJobName(String project, String job) {
    return newProjectJobBuilder().setProject(project).setJob(job).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static JobName ofProjectTenantJobName(String project, String tenant, String job) {
    return newProjectTenantJobBuilder().setProject(project).setTenant(tenant).setJob(job).build();
  }

  public static String format(String project, String job) {
    return newBuilder().setProject(project).setJob(job).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectJobName(String project, String job) {
    return newBuilder().setProject(project).setJob(job).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTenantJobName(String project, String tenant, String job) {
    return newProjectTenantJobBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setJob(job)
        .build()
        .toString();
  }

  public static JobName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_JOB_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_JOB_PATH_TEMPLATE.match(formattedString);
      return ofProjectJobName(matchMap.get("project"), matchMap.get("job"));
    } else if (PROJECT_TENANT_JOB_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TENANT_JOB_PATH_TEMPLATE.match(formattedString);
      return ofProjectTenantJobName(
          matchMap.get("project"), matchMap.get("tenant"), matchMap.get("job"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  @BetaApi("The method will be renamed to parseList after subclasses of this class are removed.")
  public static List<JobName> parse(List<String> formattedStrings) {
    List<JobName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  @BetaApi("The method will be renamed to toStringList after subclasses of this class are removed.")
  public static List<String> toStrings(List<JobName> values) {
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
    return PROJECT_JOB_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_TENANT_JOB_PATH_TEMPLATE.matches(formattedString);
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
          if (job != null) {
            fieldMapBuilder.put("job", job);
          }
          if (tenant != null) {
            fieldMapBuilder.put("tenant", tenant);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  /** Builder for projects/{project}/jobs/{job}. */
  public static class Builder {

    private String project;
    private String job;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getJob() {
      return job;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setJob(String job) {
      this.job = job;
      return this;
    }

    private Builder(JobName jobName) {
      Preconditions.checkArgument(
          jobName.pathTemplate == PROJECT_JOB_PATH_TEMPLATE,
          "toBuilder is only supported when JobName has the pattern of "
              + "projects/{project}/jobs/{job}.");
      project = jobName.project;
      job = jobName.job;
    }

    public JobName build() {
      return new JobName(this);
    }
  }

  /** Builder for projects/{project}/tenants/{tenant}/jobs/{job}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectTenantJobBuilder {

    private String project;
    private String tenant;
    private String job;

    private ProjectTenantJobBuilder() {}

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public String getJob() {
      return job;
    }

    public ProjectTenantJobBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectTenantJobBuilder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public ProjectTenantJobBuilder setJob(String job) {
      this.job = job;
      return this;
    }

    public JobName build() {
      return new JobName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      JobName that = (JobName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.job, that.job))
          && (Objects.equals(this.tenant, that.tenant));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(job);
    h *= 1000003;
    h ^= Objects.hashCode(tenant);
    return h;
  }
}
