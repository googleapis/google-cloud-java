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
public class AccessPolicyName implements ResourceName {
  private static final PathTemplate ACCESS_POLICY =
      PathTemplate.createWithoutUrlEncoding("accessPolicies/{access_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String accessPolicy;

  @Deprecated
  protected AccessPolicyName() {
    accessPolicy = null;
  }

  private AccessPolicyName(Builder builder) {
    accessPolicy = Preconditions.checkNotNull(builder.getAccessPolicy());
  }

  public String getAccessPolicy() {
    return accessPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccessPolicyName of(String accessPolicy) {
    return newBuilder().setAccessPolicy(accessPolicy).build();
  }

  public static String format(String accessPolicy) {
    return newBuilder().setAccessPolicy(accessPolicy).build().toString();
  }

  public static AccessPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCESS_POLICY.validatedMatch(
            formattedString, "AccessPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("access_policy"));
  }

  public static List<AccessPolicyName> parseList(List<String> formattedStrings) {
    List<AccessPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccessPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccessPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCESS_POLICY.matches(formattedString);
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
    return ACCESS_POLICY.instantiate("access_policy", accessPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AccessPolicyName that = ((AccessPolicyName) o);
      return Objects.equals(this.accessPolicy, that.accessPolicy);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(accessPolicy);
    return h;
  }

  /** Builder for accessPolicies/{access_policy}. */
  public static class Builder {
    private String accessPolicy;

    protected Builder() {}

    public String getAccessPolicy() {
      return accessPolicy;
    }

    public Builder setAccessPolicy(String accessPolicy) {
      this.accessPolicy = accessPolicy;
      return this;
    }

    private Builder(AccessPolicyName accessPolicyName) {
      this.accessPolicy = accessPolicyName.accessPolicy;
    }

    public AccessPolicyName build() {
      return new AccessPolicyName(this);
    }
  }
}
