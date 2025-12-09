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
public class DeviceCapabilityName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_DEVICE_CAPABILITY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/deviceCapabilities/{device_capability}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String deviceCapability;

  @Deprecated
  protected DeviceCapabilityName() {
    networkCode = null;
    deviceCapability = null;
  }

  private DeviceCapabilityName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    deviceCapability = Preconditions.checkNotNull(builder.getDeviceCapability());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getDeviceCapability() {
    return deviceCapability;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeviceCapabilityName of(String networkCode, String deviceCapability) {
    return newBuilder().setNetworkCode(networkCode).setDeviceCapability(deviceCapability).build();
  }

  public static String format(String networkCode, String deviceCapability) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDeviceCapability(deviceCapability)
        .build()
        .toString();
  }

  public static DeviceCapabilityName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_DEVICE_CAPABILITY.validatedMatch(
            formattedString, "DeviceCapabilityName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("device_capability"));
  }

  public static List<DeviceCapabilityName> parseList(List<String> formattedStrings) {
    List<DeviceCapabilityName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeviceCapabilityName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeviceCapabilityName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_DEVICE_CAPABILITY.matches(formattedString);
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
          if (deviceCapability != null) {
            fieldMapBuilder.put("device_capability", deviceCapability);
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
    return NETWORK_CODE_DEVICE_CAPABILITY.instantiate(
        "network_code", networkCode, "device_capability", deviceCapability);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DeviceCapabilityName that = ((DeviceCapabilityName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.deviceCapability, that.deviceCapability);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(deviceCapability);
    return h;
  }

  /** Builder for networks/{network_code}/deviceCapabilities/{device_capability}. */
  public static class Builder {
    private String networkCode;
    private String deviceCapability;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getDeviceCapability() {
      return deviceCapability;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setDeviceCapability(String deviceCapability) {
      this.deviceCapability = deviceCapability;
      return this;
    }

    private Builder(DeviceCapabilityName deviceCapabilityName) {
      this.networkCode = deviceCapabilityName.networkCode;
      this.deviceCapability = deviceCapabilityName.deviceCapability;
    }

    public DeviceCapabilityName build() {
      return new DeviceCapabilityName(this);
    }
  }
}
