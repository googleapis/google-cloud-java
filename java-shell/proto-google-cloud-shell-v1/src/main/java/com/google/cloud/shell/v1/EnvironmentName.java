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

package com.google.cloud.shell.v1;

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
public class EnvironmentName implements ResourceName {
  private static final PathTemplate USER_ENVIRONMENT =
      PathTemplate.createWithoutUrlEncoding("users/{user}/environments/{environment}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String environment;

  @Deprecated
  protected EnvironmentName() {
    user = null;
    environment = null;
  }

  private EnvironmentName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    environment = Preconditions.checkNotNull(builder.getEnvironment());
  }

  public String getUser() {
    return user;
  }

  public String getEnvironment() {
    return environment;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EnvironmentName of(String user, String environment) {
    return newBuilder().setUser(user).setEnvironment(environment).build();
  }

  public static String format(String user, String environment) {
    return newBuilder().setUser(user).setEnvironment(environment).build().toString();
  }

  public static EnvironmentName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_ENVIRONMENT.validatedMatch(
            formattedString, "EnvironmentName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("environment"));
  }

  public static List<EnvironmentName> parseList(List<String> formattedStrings) {
    List<EnvironmentName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EnvironmentName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EnvironmentName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_ENVIRONMENT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (environment != null) {
            fieldMapBuilder.put("environment", environment);
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
    return USER_ENVIRONMENT.instantiate("user", user, "environment", environment);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EnvironmentName that = ((EnvironmentName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.environment, that.environment);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(environment);
    return h;
  }

  /** Builder for users/{user}/environments/{environment}. */
  public static class Builder {
    private String user;
    private String environment;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getEnvironment() {
      return environment;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setEnvironment(String environment) {
      this.environment = environment;
      return this;
    }

    private Builder(EnvironmentName environmentName) {
      this.user = environmentName.user;
      this.environment = environmentName.environment;
    }

    public EnvironmentName build() {
      return new EnvironmentName(this);
    }
  }
}
