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
public class OperatingSystemName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_OPERATING_SYSTEM =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/operatingSystems/{operating_system}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String operatingSystem;

  @Deprecated
  protected OperatingSystemName() {
    networkCode = null;
    operatingSystem = null;
  }

  private OperatingSystemName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    operatingSystem = Preconditions.checkNotNull(builder.getOperatingSystem());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getOperatingSystem() {
    return operatingSystem;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static OperatingSystemName of(String networkCode, String operatingSystem) {
    return newBuilder().setNetworkCode(networkCode).setOperatingSystem(operatingSystem).build();
  }

  public static String format(String networkCode, String operatingSystem) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setOperatingSystem(operatingSystem)
        .build()
        .toString();
  }

  public static OperatingSystemName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_OPERATING_SYSTEM.validatedMatch(
            formattedString, "OperatingSystemName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("operating_system"));
  }

  public static List<OperatingSystemName> parseList(List<String> formattedStrings) {
    List<OperatingSystemName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<OperatingSystemName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (OperatingSystemName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_OPERATING_SYSTEM.matches(formattedString);
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
          if (operatingSystem != null) {
            fieldMapBuilder.put("operating_system", operatingSystem);
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
    return NETWORK_CODE_OPERATING_SYSTEM.instantiate(
        "network_code", networkCode, "operating_system", operatingSystem);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      OperatingSystemName that = ((OperatingSystemName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.operatingSystem, that.operatingSystem);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(operatingSystem);
    return h;
  }

  /** Builder for networks/{network_code}/operatingSystems/{operating_system}. */
  public static class Builder {
    private String networkCode;
    private String operatingSystem;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getOperatingSystem() {
      return operatingSystem;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setOperatingSystem(String operatingSystem) {
      this.operatingSystem = operatingSystem;
      return this;
    }

    private Builder(OperatingSystemName operatingSystemName) {
      this.networkCode = operatingSystemName.networkCode;
      this.operatingSystem = operatingSystemName.operatingSystem;
    }

    public OperatingSystemName build() {
      return new OperatingSystemName(this);
    }
  }
}
