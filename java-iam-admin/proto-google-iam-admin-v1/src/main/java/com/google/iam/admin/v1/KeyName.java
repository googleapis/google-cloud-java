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

package com.google.iam.admin.v1;

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
public class KeyName implements ResourceName {
  private static final PathTemplate PROJECT_SERVICE_ACCOUNT_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/serviceAccounts/{service_account}/keys/{key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String serviceAccount;
  private final String key;

  @Deprecated
  protected KeyName() {
    project = null;
    serviceAccount = null;
    key = null;
  }

  private KeyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    serviceAccount = Preconditions.checkNotNull(builder.getServiceAccount());
    key = Preconditions.checkNotNull(builder.getKey());
  }

  public String getProject() {
    return project;
  }

  public String getServiceAccount() {
    return serviceAccount;
  }

  public String getKey() {
    return key;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static KeyName of(String project, String serviceAccount, String key) {
    return newBuilder().setProject(project).setServiceAccount(serviceAccount).setKey(key).build();
  }

  public static String format(String project, String serviceAccount, String key) {
    return newBuilder()
        .setProject(project)
        .setServiceAccount(serviceAccount)
        .setKey(key)
        .build()
        .toString();
  }

  public static KeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_SERVICE_ACCOUNT_KEY.validatedMatch(
            formattedString, "KeyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("service_account"), matchMap.get("key"));
  }

  public static List<KeyName> parseList(List<String> formattedStrings) {
    List<KeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<KeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (KeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_SERVICE_ACCOUNT_KEY.matches(formattedString);
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
          if (serviceAccount != null) {
            fieldMapBuilder.put("service_account", serviceAccount);
          }
          if (key != null) {
            fieldMapBuilder.put("key", key);
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
    return PROJECT_SERVICE_ACCOUNT_KEY.instantiate(
        "project", project, "service_account", serviceAccount, "key", key);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      KeyName that = ((KeyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.serviceAccount, that.serviceAccount)
          && Objects.equals(this.key, that.key);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(serviceAccount);
    h *= 1000003;
    h ^= Objects.hashCode(key);
    return h;
  }

  /** Builder for projects/{project}/serviceAccounts/{service_account}/keys/{key}. */
  public static class Builder {
    private String project;
    private String serviceAccount;
    private String key;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getServiceAccount() {
      return serviceAccount;
    }

    public String getKey() {
      return key;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setServiceAccount(String serviceAccount) {
      this.serviceAccount = serviceAccount;
      return this;
    }

    public Builder setKey(String key) {
      this.key = key;
      return this;
    }

    private Builder(KeyName keyName) {
      this.project = keyName.project;
      this.serviceAccount = keyName.serviceAccount;
      this.key = keyName.key;
    }

    public KeyName build() {
      return new KeyName(this);
    }
  }
}
