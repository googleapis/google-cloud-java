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
public class DeviceManufacturerName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_DEVICE_MANUFACTURER =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/deviceManufacturers/{device_manufacturer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String deviceManufacturer;

  @Deprecated
  protected DeviceManufacturerName() {
    networkCode = null;
    deviceManufacturer = null;
  }

  private DeviceManufacturerName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    deviceManufacturer = Preconditions.checkNotNull(builder.getDeviceManufacturer());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getDeviceManufacturer() {
    return deviceManufacturer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DeviceManufacturerName of(String networkCode, String deviceManufacturer) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDeviceManufacturer(deviceManufacturer)
        .build();
  }

  public static String format(String networkCode, String deviceManufacturer) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDeviceManufacturer(deviceManufacturer)
        .build()
        .toString();
  }

  public static DeviceManufacturerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_DEVICE_MANUFACTURER.validatedMatch(
            formattedString, "DeviceManufacturerName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("device_manufacturer"));
  }

  public static List<DeviceManufacturerName> parseList(List<String> formattedStrings) {
    List<DeviceManufacturerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<DeviceManufacturerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DeviceManufacturerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_DEVICE_MANUFACTURER.matches(formattedString);
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
          if (deviceManufacturer != null) {
            fieldMapBuilder.put("device_manufacturer", deviceManufacturer);
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
    return NETWORK_CODE_DEVICE_MANUFACTURER.instantiate(
        "network_code", networkCode, "device_manufacturer", deviceManufacturer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DeviceManufacturerName that = ((DeviceManufacturerName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.deviceManufacturer, that.deviceManufacturer);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(deviceManufacturer);
    return h;
  }

  /** Builder for networks/{network_code}/deviceManufacturers/{device_manufacturer}. */
  public static class Builder {
    private String networkCode;
    private String deviceManufacturer;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getDeviceManufacturer() {
      return deviceManufacturer;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setDeviceManufacturer(String deviceManufacturer) {
      this.deviceManufacturer = deviceManufacturer;
      return this;
    }

    private Builder(DeviceManufacturerName deviceManufacturerName) {
      this.networkCode = deviceManufacturerName.networkCode;
      this.deviceManufacturer = deviceManufacturerName.deviceManufacturer;
    }

    public DeviceManufacturerName build() {
      return new DeviceManufacturerName(this);
    }
  }
}
