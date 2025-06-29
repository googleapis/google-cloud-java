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
public class OperatingSystemVersionName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_OPERATING_SYSTEM_VERSION =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/operatingSystemVersions/{operating_system_version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String operatingSystemVersion;

  @Deprecated
  protected OperatingSystemVersionName() {
    networkCode = null;
    operatingSystemVersion = null;
  }

  private OperatingSystemVersionName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    operatingSystemVersion = Preconditions.checkNotNull(builder.getOperatingSystemVersion());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getOperatingSystemVersion() {
    return operatingSystemVersion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OperatingSystemVersionName of(String networkCode, String operatingSystemVersion) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setOperatingSystemVersion(operatingSystemVersion)
        .build();
  }

  public static String format(String networkCode, String operatingSystemVersion) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setOperatingSystemVersion(operatingSystemVersion)
        .build()
        .toString();
  }

  public static OperatingSystemVersionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_OPERATING_SYSTEM_VERSION.validatedMatch(
            formattedString,
            "OperatingSystemVersionName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("operating_system_version"));
  }

  public static List<OperatingSystemVersionName> parseList(List<String> formattedStrings) {
    List<OperatingSystemVersionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OperatingSystemVersionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OperatingSystemVersionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_OPERATING_SYSTEM_VERSION.matches(formattedString);
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
          if (operatingSystemVersion != null) {
            fieldMapBuilder.put("operating_system_version", operatingSystemVersion);
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
    return NETWORK_CODE_OPERATING_SYSTEM_VERSION.instantiate(
        "network_code", networkCode, "operating_system_version", operatingSystemVersion);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OperatingSystemVersionName that = ((OperatingSystemVersionName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.operatingSystemVersion, that.operatingSystemVersion);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(operatingSystemVersion);
    return h;
  }

  /** Builder for networks/{network_code}/operatingSystemVersions/{operating_system_version}. */
  public static class Builder {
    private String networkCode;
    private String operatingSystemVersion;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getOperatingSystemVersion() {
      return operatingSystemVersion;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setOperatingSystemVersion(String operatingSystemVersion) {
      this.operatingSystemVersion = operatingSystemVersion;
      return this;
    }

    private Builder(OperatingSystemVersionName operatingSystemVersionName) {
      this.networkCode = operatingSystemVersionName.networkCode;
      this.operatingSystemVersion = operatingSystemVersionName.operatingSystemVersion;
    }

    public OperatingSystemVersionName build() {
      return new OperatingSystemVersionName(this);
    }
  }
}
