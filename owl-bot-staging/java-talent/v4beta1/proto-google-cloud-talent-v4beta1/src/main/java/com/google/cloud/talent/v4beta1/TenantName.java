/*
 * Copyright 2022 Google LLC
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
public class TenantName implements ResourceName {
  private static final PathTemplate PROJECT_TENANT =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/tenants/{tenant}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String tenant;

  @Deprecated
  protected TenantName() {
    project = null;
    tenant = null;
  }

  private TenantName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    tenant = Preconditions.checkNotNull(builder.getTenant());
  }

  public String getProject() {
    return project;
  }

  public String getTenant() {
    return tenant;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TenantName of(String project, String tenant) {
    return newBuilder().setProject(project).setTenant(tenant).build();
  }

  public static String format(String project, String tenant) {
    return newBuilder().setProject(project).setTenant(tenant).build().toString();
  }

  public static TenantName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_TENANT.validatedMatch(
            formattedString, "TenantName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("tenant"));
  }

  public static List<TenantName> parseList(List<String> formattedStrings) {
    List<TenantName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TenantName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TenantName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_TENANT.matches(formattedString);
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
    return PROJECT_TENANT.instantiate("project", project, "tenant", tenant);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TenantName that = ((TenantName) o);
      return Objects.equals(this.project, that.project) && Objects.equals(this.tenant, that.tenant);
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
    return h;
  }

  /** Builder for projects/{project}/tenants/{tenant}. */
  public static class Builder {
    private String project;
    private String tenant;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getTenant() {
      return tenant;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setTenant(String tenant) {
      this.tenant = tenant;
      return this;
    }

    private Builder(TenantName tenantName) {
      this.project = tenantName.project;
      this.tenant = tenantName.tenant;
    }

    public TenantName build() {
      return new TenantName(this);
    }
  }
}
