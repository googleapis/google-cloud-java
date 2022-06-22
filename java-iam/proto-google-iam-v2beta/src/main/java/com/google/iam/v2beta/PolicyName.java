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

package com.google.iam.v2beta;

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
public class PolicyName implements ResourceName {
  private static final PathTemplate POLICY =
      PathTemplate.createWithoutUrlEncoding("policies/{policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String policy;

  @Deprecated
  protected PolicyName() {
    policy = null;
  }

  private PolicyName(Builder builder) {
    policy = Preconditions.checkNotNull(builder.getPolicy());
  }

  public String getPolicy() {
    return policy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PolicyName of(String policy) {
    return newBuilder().setPolicy(policy).build();
  }

  public static String format(String policy) {
    return newBuilder().setPolicy(policy).build().toString();
  }

  public static PolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        POLICY.validatedMatch(
            formattedString, "PolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("policy"));
  }

  public static List<PolicyName> parseList(List<String> formattedStrings) {
    List<PolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return POLICY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (policy != null) {
            fieldMapBuilder.put("policy", policy);
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
    return POLICY.instantiate("policy", policy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      PolicyName that = ((PolicyName) o);
      return Objects.equals(this.policy, that.policy);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(policy);
    return h;
  }

  /** Builder for policies/{policy}. */
  public static class Builder {
    private String policy;

    protected Builder() {}

    public String getPolicy() {
      return policy;
    }

    public Builder setPolicy(String policy) {
      this.policy = policy;
      return this;
    }

    private Builder(PolicyName policyName) {
      this.policy = policyName.policy;
    }

    public PolicyName build() {
      return new PolicyName(this);
    }
  }
}
