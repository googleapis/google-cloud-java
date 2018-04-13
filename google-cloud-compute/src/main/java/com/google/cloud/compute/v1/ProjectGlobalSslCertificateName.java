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
import com.google.api.resourcenames.ResourceName;
import com.google.api.resourcenames.ResourceNameFactory;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;

@Generated("by GAPIC")
@BetaApi
public final class ProjectGlobalSslCertificateName implements ResourceName {
  private final String project;
  private final String sslCertificate;
  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/global/sslCertificates/{sslCertificate}");

  private volatile Map<String, String> fieldValuesMap;

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ProjectGlobalSslCertificateName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    sslCertificate = Preconditions.checkNotNull(builder.getSslCertificate());
  }

  public static ProjectGlobalSslCertificateName of(String project, String sslCertificate) {
    return newBuilder().setProject(project).setSslCertificate(sslCertificate).build();
  }

  public static String format(String project, String sslCertificate) {
    return of(project, sslCertificate).toString();
  }

  public String getProject() {
    return project;
  }

  public String getSslCertificate() {
    return sslCertificate;
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("sslCertificate", sslCertificate);
          fieldValuesMap = fieldMapBuilder.build();
        }
      }
    }
    return fieldValuesMap;
  }

  public String getFieldValue(String fieldName) {
    return getFieldValuesMap().get(fieldName);
  }

  public static ResourceNameFactory<ProjectGlobalSslCertificateName> newFactory() {
    return new ResourceNameFactory<ProjectGlobalSslCertificateName>() {
      public ProjectGlobalSslCertificateName parse(String formattedString) {
        return ProjectGlobalSslCertificateName.parse(formattedString);
      }
    };
  }

  public static ProjectGlobalSslCertificateName parse(String formattedString) {
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString,
            "ProjectGlobalSslCertificateName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("sslCertificate"));
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public static class Builder {
    private String project;
    private String sslCertificate;

    public String getProject() {
      return project;
    }

    public String getSslCertificate() {
      return sslCertificate;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setSslCertificate(String sslCertificate) {
      this.sslCertificate = sslCertificate;
      return this;
    }

    private Builder() {}

    public Builder(ProjectGlobalSslCertificateName projectGlobalSslCertificateName) {
      project = projectGlobalSslCertificateName.project;
      sslCertificate = projectGlobalSslCertificateName.sslCertificate;
    }

    public ProjectGlobalSslCertificateName build() {
      return new ProjectGlobalSslCertificateName(this);
    }
  }

  @Override
  public String toString() {
    return PATH_TEMPLATE.instantiate(
        "project", project,
        "sslCertificate", sslCertificate);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProjectGlobalSslCertificateName) {
      ProjectGlobalSslCertificateName that = (ProjectGlobalSslCertificateName) o;
      return Objects.equals(this.project, that.getProject())
          && Objects.equals(this.sslCertificate, that.getSslCertificate());
    }
    return false;
  }

  @Override
  public int hashCode() {
    return Objects.hash(project, sslCertificate);
  }
}
