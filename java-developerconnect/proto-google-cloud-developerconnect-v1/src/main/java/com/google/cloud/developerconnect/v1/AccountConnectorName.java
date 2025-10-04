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

package com.google.cloud.developerconnect.v1;

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
public class AccountConnectorName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_ACCOUNT_CONNECTOR =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/accountConnectors/{account_connector}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String accountConnector;

  @Deprecated
  protected AccountConnectorName() {
    project = null;
    location = null;
    accountConnector = null;
  }

  private AccountConnectorName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    accountConnector = Preconditions.checkNotNull(builder.getAccountConnector());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getAccountConnector() {
    return accountConnector;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountConnectorName of(String project, String location, String accountConnector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAccountConnector(accountConnector)
        .build();
  }

  public static String format(String project, String location, String accountConnector) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setAccountConnector(accountConnector)
        .build()
        .toString();
  }

  public static AccountConnectorName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_ACCOUNT_CONNECTOR.validatedMatch(
            formattedString, "AccountConnectorName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("account_connector"));
  }

  public static List<AccountConnectorName> parseList(List<String> formattedStrings) {
    List<AccountConnectorName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountConnectorName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountConnectorName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_ACCOUNT_CONNECTOR.matches(formattedString);
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
          if (accountConnector != null) {
            fieldMapBuilder.put("account_connector", accountConnector);
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
    return PROJECT_LOCATION_ACCOUNT_CONNECTOR.instantiate(
        "project", project, "location", location, "account_connector", accountConnector);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountConnectorName that = ((AccountConnectorName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.accountConnector, that.accountConnector);
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
    h ^= Objects.hashCode(accountConnector);
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/accountConnectors/{account_connector}. */
  public static class Builder {
    private String project;
    private String location;
    private String accountConnector;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getAccountConnector() {
      return accountConnector;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setAccountConnector(String accountConnector) {
      this.accountConnector = accountConnector;
      return this;
    }

    private Builder(AccountConnectorName accountConnectorName) {
      this.project = accountConnectorName.project;
      this.location = accountConnectorName.location;
      this.accountConnector = accountConnectorName.accountConnector;
    }

    public AccountConnectorName build() {
      return new AccountConnectorName(this);
    }
  }
}
