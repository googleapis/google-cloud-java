/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.cloud.talent.v4beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class CompanyWithTenantName extends CompanyName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/tenants/{tenant}/companies/{company}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String tenant;
  private final String company;

  public String getProject() {
    return project;
  }

  public String getTenant() {
    return tenant;
  }

  public String getCompany() {
    return company;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private CompanyWithTenantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
    company = Preconditions.checkNotNull(builder.getCompany());
  }

  public static CompanyWithTenantName of(String project, String tenant, String company) {
    return newBuilder().setProject(project).setTenant(tenant).setCompany(company).build();
  }

  public static String format(String project, String tenant, String company) {
    return newBuilder()
        .setProject(project)
        .setTenant(tenant)
        .setCompany(company)
        .build()
        .toString();
  }

  public static CompanyWithTenantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "CompanyWithTenantName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("tenant"), matchMap.get("company"));
  }

  public static List<CompanyWithTenantName> parseList(List<String> formattedStrings) {
    List<CompanyWithTenantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CompanyWithTenantName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (CompanyWithTenantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("project", project);
          fieldMapBuilder.put("tenant", tenant);
          fieldMapBuilder.put("company", company);
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
    return PATH_TEMPLATE.instantiate("project", project, "tenant", tenant, "company", company);
  }

  /** Builder for CompanyWithTenantName. */
  public static class Builder {

    private String project;
    private String tenant;
    private String company;

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public String getCompany() {
      return company;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    public Builder setCompany(String company) {
      this.company = company;
      return this;
    }

    private Builder() {}

    private Builder(CompanyWithTenantName companyWithTenantName) {
      project = companyWithTenantName.project;
      tenant = companyWithTenantName.tenant;
      company = companyWithTenantName.company;
    }

    public CompanyWithTenantName build() {
      return new CompanyWithTenantName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CompanyWithTenantName) {
      CompanyWithTenantName that = (CompanyWithTenantName) o;
      return (this.project.equals(that.project))
          && (this.tenant.equals(that.tenant))
          && (this.company.equals(that.company));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= tenant.hashCode();
    h *= 1000003;
    h ^= company.hashCode();
    return h;
  }
}
