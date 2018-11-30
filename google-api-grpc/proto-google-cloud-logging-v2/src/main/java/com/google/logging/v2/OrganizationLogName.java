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

package com.google.logging.v2;

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class OrganizationLogName extends LogName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/logs/{log}");

  private volatile Map<String, String> fieldValuesMap;

  private final String organization;
  private final String log;

  public String getOrganization() {
    return organization;
  }

  public String getLog() {
    return log;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private OrganizationLogName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    log = Preconditions.checkNotNull(builder.getLog());
  }

  public static OrganizationLogName of(String organization, String log) {
    return newBuilder().setOrganization(organization).setLog(log).build();
  }

  public static String format(String organization, String log) {
    return newBuilder().setOrganization(organization).setLog(log).build().toString();
  }

  public static OrganizationLogName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "OrganizationLogName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("log"));
  }

  public static List<OrganizationLogName> parseList(List<String> formattedStrings) {
    List<OrganizationLogName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OrganizationLogName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (OrganizationLogName value : values) {
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
          fieldMapBuilder.put("organization", organization);
          fieldMapBuilder.put("log", log);
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
    return PATH_TEMPLATE.instantiate("organization", organization, "log", log);
  }

  /** Builder for OrganizationLogName. */
  public static class Builder {

    private String organization;
    private String log;

    public String getOrganization() {
      return organization;
    }

    public String getLog() {
      return log;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setLog(String log) {
      this.log = log;
      return this;
    }

    private Builder() {}

    private Builder(OrganizationLogName organizationLogName) {
      organization = organizationLogName.organization;
      log = organizationLogName.log;
    }

    public OrganizationLogName build() {
      return new OrganizationLogName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrganizationLogName) {
      OrganizationLogName that = (OrganizationLogName) o;
      return (this.organization.equals(that.organization)) && (this.log.equals(that.log));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= organization.hashCode();
    h *= 1000003;
    h ^= log.hashCode();
    return h;
  }
}
