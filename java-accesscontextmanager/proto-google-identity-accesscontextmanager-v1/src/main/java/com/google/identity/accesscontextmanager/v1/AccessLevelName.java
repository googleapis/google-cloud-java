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

package com.google.identity.accesscontextmanager.v1;

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
public class AccessLevelName implements ResourceName {
  private static final PathTemplate ACCESS_POLICY_ACCESS_LEVEL =
      PathTemplate.createWithoutUrlEncoding(
          "accessPolicies/{access_policy}/accessLevels/{access_level}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accessPolicy;
  private final String accessLevel;

  @Deprecated
  protected AccessLevelName() {
    accessPolicy = null;
    accessLevel = null;
  }

  private AccessLevelName(Builder builder) {
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
    accessLevel = Preconditions.checkNotNull(builder.getAccessLevel());
  }

  public String getAccessPolicy() {
    return accessPolicy;
  }

  public String getAccessLevel() {
    return accessLevel;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessLevelName of(String accessPolicy, String accessLevel) {
    return newBuilder().setAccessPolicy(accessPolicy).setAccessLevel(accessLevel).build();
  }

  public static String format(String accessPolicy, String accessLevel) {
    return newBuilder()
        .setAccessPolicy(accessPolicy)
        .setAccessLevel(accessLevel)
        .build()
        .toString();
  }

  public static AccessLevelName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCESS_POLICY_ACCESS_LEVEL.validatedMatch(
            formattedString, "AccessLevelName.parse: formattedString not in valid format");
    return of(matchMap.get("access_policy"), matchMap.get("access_level"));
  }

  public static List<AccessLevelName> parseList(List<String> formattedStrings) {
    List<AccessLevelName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessLevelName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessLevelName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCESS_POLICY_ACCESS_LEVEL.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (accessPolicy != null) {
            fieldMapBuilder.put("access_policy", accessPolicy);
          }
          if (accessLevel != null) {
            fieldMapBuilder.put("access_level", accessLevel);
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
    return ACCESS_POLICY_ACCESS_LEVEL.instantiate(
        "access_policy", accessPolicy, "access_level", accessLevel);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AccessLevelName that = ((AccessLevelName) o);
      return Objects.equals(this.accessPolicy, that.accessPolicy)
          && Objects.equals(this.accessLevel, that.accessLevel);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(accessPolicy);
    h *= 1000003;
    h ^= Objects.hashCode(accessLevel);
    return h;
  }

  /** Builder for accessPolicies/{access_policy}/accessLevels/{access_level}. */
  public static class Builder {
    private String accessPolicy;
    private String accessLevel;

    protected Builder() {}

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public String getAccessLevel() {
      return accessLevel;
    }

    public Builder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    public Builder setAccessLevel(String accessLevel) {
      this.accessLevel = accessLevel;
      return this;
    }

    private Builder(AccessLevelName accessLevelName) {
      this.accessPolicy = accessLevelName.accessPolicy;
      this.accessLevel = accessLevelName.accessLevel;
    }

    public AccessLevelName build() {
      return new AccessLevelName(this);
    }
  }
}
