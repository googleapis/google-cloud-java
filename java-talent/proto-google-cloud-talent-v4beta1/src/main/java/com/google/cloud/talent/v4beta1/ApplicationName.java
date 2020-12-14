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

package com.google.cloud.talent.v4beta1;

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
public class ApplicationName implements ResourceName {
  private static final PathTemplate PROJECT_TENANT_PROFILE_APPLICATION =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/tenants/{tenant}/profiles/{profile}/applications/{application}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String tenant;
  private final String profile;
  private final String application;

  @Deprecated
  protected ApplicationName() {
    project = null;
    tenant = null;
    profile = null;
    application = null;
  }

  private ApplicationName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
    profile = Preconditions.checkNotNull(builder.getProfile());
    application = Preconditions.checkNotNull(builder.getApplication());
  }

  public String getProject() {
    return project;
  }

  public String getTenant() {
    return tenant;
  }

  public String getProfile() {
    return profile;
  }

  public String getApplication() {
    return application;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ApplicationName of(
      String project, String tenant, String profile, String application) {
    return newBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setProfile(profile)
        .setApplication(application)
        .build();
  }

  public static String format(String project, String tenant, String profile, String application) {
    return newBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setProfile(profile)
        .setApplication(application)
        .build()
        .toString();
  }

  public static ApplicationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TENANT_PROFILE_APPLICATION.validatedMatch(
            formattedString, "ApplicationName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("tenant"),
        matchMap.get("profile"),
        matchMap.get("application"));
  }

  public static List<ApplicationName> parseList(List<String> formattedStrings) {
    List<ApplicationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ApplicationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ApplicationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TENANT_PROFILE_APPLICATION.matches(formattedString);
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
          if (profile != null) {
            fieldMapBuilder.put("profile", profile);
          }
          if (application != null) {
            fieldMapBuilder.put("application", application);
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
    return PROJECT_TENANT_PROFILE_APPLICATION.instantiate(
        "project", project, "tenant", tenant, "profile", profile, "application", application);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      ApplicationName that = ((ApplicationName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.tenant, that.tenant)
          && Objects.equals(this.profile, that.profile)
          && Objects.equals(this.application, that.application);
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
    h ^= Objects.hashCode(profile);
    h *= 1000003;
    h ^= Objects.hashCode(application);
    return h;
  }

  /**
   * Builder for projects/{project}/tenants/{tenant}/profiles/{profile}/applications/{application}.
   */
  public static class Builder {
    private String project;
    private String tenant;
    private String profile;
    private String application;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public String getProfile() {
      return profile;
    }

    public String getApplication() {
      return application;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public Builder setProfile(String profile) {
      this.profile = profile;
      return this;
    }

    public Builder setApplication(String application) {
      this.application = application;
      return this;
    }

    private Builder(ApplicationName applicationName) {
      project = applicationName.project;
      tenant = applicationName.tenant;
      profile = applicationName.profile;
      application = applicationName.application;
    }

    public ApplicationName build() {
      return new ApplicationName(this);
    }
  }
}
