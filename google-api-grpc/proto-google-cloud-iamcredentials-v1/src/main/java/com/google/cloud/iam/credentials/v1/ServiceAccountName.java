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

package com.google.cloud.iam.credentials.v1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class ServiceAccountName implements ResourceName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/serviceAccounts/{service_account}");

  private volatile Map<String, String> fieldValuesMap;

  private final String project;
  private final String serviceAccount;

  public String getProject() {
    return project;
  }

  public String getServiceAccount() {
    return serviceAccount;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private ServiceAccountName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    serviceAccount = Preconditions.checkNotNull(builder.getServiceAccount());
  }

  public static ServiceAccountName of(String project, String serviceAccount) {
    return newBuilder().setProject(project).setServiceAccount(serviceAccount).build();
  }

  public static String format(String project, String serviceAccount) {
    return newBuilder().setProject(project).setServiceAccount(serviceAccount).build().toString();
  }

  public static ServiceAccountName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "ServiceAccountName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("service_account"));
  }

  public static List<ServiceAccountName> parseList(List<String> formattedStrings) {
    List<ServiceAccountName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ServiceAccountName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (ServiceAccountName value : values) {
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
          fieldMapBuilder.put("serviceAccount", serviceAccount);
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
    return PATH_TEMPLATE.instantiate("project", project, "service_account", serviceAccount);
  }

  /** Builder for ServiceAccountName. */
  public static class Builder {

    private String project;
    private String serviceAccount;

    public String getProject() {
      return project;
    }

    public String getServiceAccount() {
      return serviceAccount;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setServiceAccount(String serviceAccount) {
      this.serviceAccount = serviceAccount;
      return this;
    }

    private Builder() {}

    private Builder(ServiceAccountName serviceAccountName) {
      project = serviceAccountName.project;
      serviceAccount = serviceAccountName.serviceAccount;
    }

    public ServiceAccountName build() {
      return new ServiceAccountName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServiceAccountName) {
      ServiceAccountName that = (ServiceAccountName) o;
      return (this.project.equals(that.project))
          && (this.serviceAccount.equals(that.serviceAccount));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= project.hashCode();
    h *= 1000003;
    h ^= serviceAccount.hashCode();
    return h;
  }
}
