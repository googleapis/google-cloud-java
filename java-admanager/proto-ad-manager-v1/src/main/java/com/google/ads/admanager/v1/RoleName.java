/*
 * Copyright 2024 Google LLC
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

package com.google.ads.admanager.v1;

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
public class RoleName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_ROLE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/roles/{role}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String role;

  @Deprecated
  protected RoleName() {
    networkCode = null;
    role = null;
  }

  private RoleName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    role = Preconditions.checkNotNull(builder.getRole());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getRole() {
    return role;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RoleName of(String networkCode, String role) {
    return newBuilder().setNetworkCode(networkCode).setRole(role).build();
  }

  public static String format(String networkCode, String role) {
    return newBuilder().setNetworkCode(networkCode).setRole(role).build().toString();
  }

  public static RoleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_ROLE.validatedMatch(
            formattedString, "RoleName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("role"));
  }

  public static List<RoleName> parseList(List<String> formattedStrings) {
    List<RoleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RoleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RoleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_ROLE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (role != null) {
            fieldMapBuilder.put("role", role);
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
    return NETWORK_CODE_ROLE.instantiate("network_code", networkCode, "role", role);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RoleName that = ((RoleName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.role, that.role);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(role);
    return h;
  }

  /** Builder for networks/{network_code}/roles/{role}. */
  public static class Builder {
    private String networkCode;
    private String role;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getRole() {
      return role;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setRole(String role) {
      this.role = role;
      return this;
    }

    private Builder(RoleName roleName) {
      this.networkCode = roleName.networkCode;
      this.role = roleName.role;
    }

    public RoleName build() {
      return new RoleName(this);
    }
  }
}
