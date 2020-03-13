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
public class CompanyName implements ResourceName {

  @Deprecated
  protected CompanyName() {}

  private static final PathTemplate PROJECT_COMPANY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/companies/{company}");
  private static final PathTemplate PROJECT_TENANT_COMPANY_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/tenants/{tenant}/companies/{company}");

  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;

  private String project;
  private String company;
  private String tenant;

  public String getProject() {
    return project;
  }

  public String getCompany() {
    return company;
  }

  public String getTenant() {
    return tenant;
  }

  private CompanyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    company = Preconditions.checkNotNull(builder.getCompany());
    pathTemplate = PROJECT_COMPANY_PATH_TEMPLATE;
  }

  private CompanyName(ProjectTenantCompanyBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
    company = Preconditions.checkNotNull(builder.getCompany());
    pathTemplate = PROJECT_TENANT_COMPANY_PATH_TEMPLATE;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newProjectCompanyBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static ProjectTenantCompanyBuilder newProjectTenantCompanyBuilder() {
    return new ProjectTenantCompanyBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CompanyName of(String project, String company) {
    return newProjectCompanyBuilder().setProject(project).setCompany(company).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CompanyName ofProjectCompanyName(String project, String company) {
    return newProjectCompanyBuilder().setProject(project).setCompany(company).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static CompanyName ofProjectTenantCompanyName(
      String project, String tenant, String company) {
    return newProjectTenantCompanyBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setCompany(company)
        .build();
  }

  public static String format(String project, String company) {
    return newBuilder().setProject(project).setCompany(company).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectCompanyName(String project, String company) {
    return newBuilder().setProject(project).setCompany(company).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatProjectTenantCompanyName(
      String project, String tenant, String company) {
    return newProjectTenantCompanyBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setCompany(company)
        .build()
        .toString();
  }

  public static CompanyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_COMPANY_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_COMPANY_PATH_TEMPLATE.match(formattedString);
      return ofProjectCompanyName(matchMap.get("project"), matchMap.get("company"));
    } else if (PROJECT_TENANT_COMPANY_PATH_TEMPLATE.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_TENANT_COMPANY_PATH_TEMPLATE.match(formattedString);
      return ofProjectTenantCompanyName(
          matchMap.get("project"), matchMap.get("tenant"), matchMap.get("company"));
    }
    throw new ValidationException("JobName.parse: formattedString not in valid format");
  }

  @BetaApi("The method will be renamed to parseList after subclasses of this class are removed.")
  public static List<CompanyName> parse(List<String> formattedStrings) {
    List<CompanyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  @BetaApi("The method will be renamed to toStringList after subclasses of this class are removed.")
  public static List<String> toStrings(List<CompanyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CompanyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_COMPANY_PATH_TEMPLATE.matches(formattedString)
        || PROJECT_TENANT_COMPANY_PATH_TEMPLATE.matches(formattedString);
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
          if (company != null) {
            fieldMapBuilder.put("company", company);
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

  /** Builder for projects/{project}/companies/{company}. */
  public static class Builder {

    private String project;
    private String company;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getCompany() {
      return company;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setCompany(String company) {
      this.company = company;
      return this;
    }

    private Builder(CompanyName companyName) {
      Preconditions.checkArgument(
          companyName.pathTemplate == PROJECT_COMPANY_PATH_TEMPLATE,
          "toBuilder is only supported when CompanyName has the pattern of "
              + "projects/{project}/companies/{company}.");
      project = companyName.project;
      company = companyName.company;
    }

    public CompanyName build() {
      return new CompanyName(this);
    }
  }

  /** Builder for projects/{project}/tenants/{tenant}/companies/{company}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class ProjectTenantCompanyBuilder {

    private String project;
    private String tenant;
    private String company;

    private ProjectTenantCompanyBuilder() {}

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public String getCompany() {
      return company;
    }

    public ProjectTenantCompanyBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectTenantCompanyBuilder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public ProjectTenantCompanyBuilder setCompany(String company) {
      this.company = company;
      return this;
    }

    public CompanyName build() {
      return new CompanyName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CompanyName that = (CompanyName) o;
      return (Objects.equals(this.project, that.project))
          && (Objects.equals(this.company, that.company))
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
    h ^= Objects.hashCode(company);
    h *= 1000003;
    h ^= Objects.hashCode(tenant);
    return h;
  }
}
