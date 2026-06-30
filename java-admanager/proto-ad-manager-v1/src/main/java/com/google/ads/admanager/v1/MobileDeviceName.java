/*
 * Copyright 2026 Google LLC
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
public class MobileDeviceName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_MOBILE_DEVICE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/mobileDevices/{mobile_device}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String mobileDevice;

  @Deprecated
  protected MobileDeviceName() {
    networkCode = null;
    mobileDevice = null;
  }

  private MobileDeviceName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    mobileDevice = Preconditions.checkNotNull(builder.getMobileDevice());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getMobileDevice() {
    return mobileDevice;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MobileDeviceName of(String networkCode, String mobileDevice) {
    return newBuilder().setNetworkCode(networkCode).setMobileDevice(mobileDevice).build();
  }

  public static String format(String networkCode, String mobileDevice) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setMobileDevice(mobileDevice)
        .build()
        .toString();
  }

  public static MobileDeviceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_MOBILE_DEVICE.validatedMatch(
            formattedString, "MobileDeviceName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("mobile_device"));
  }

  public static List<MobileDeviceName> parseList(List<String> formattedStrings) {
    List<MobileDeviceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MobileDeviceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MobileDeviceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_MOBILE_DEVICE.matches(formattedString);
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
          if (mobileDevice != null) {
            fieldMapBuilder.put("mobile_device", mobileDevice);
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
    return NETWORK_CODE_MOBILE_DEVICE.instantiate(
        "network_code", networkCode, "mobile_device", mobileDevice);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MobileDeviceName that = ((MobileDeviceName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.mobileDevice, that.mobileDevice);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(mobileDevice);
    return h;
  }

  /** Builder for networks/{network_code}/mobileDevices/{mobile_device}. */
  public static class Builder {
    private String networkCode;
    private String mobileDevice;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getMobileDevice() {
      return mobileDevice;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setMobileDevice(String mobileDevice) {
      this.mobileDevice = mobileDevice;
      return this;
    }

    private Builder(MobileDeviceName mobileDeviceName) {
      this.networkCode = mobileDeviceName.networkCode;
      this.mobileDevice = mobileDeviceName.mobileDevice;
    }

    public MobileDeviceName build() {
      return new MobileDeviceName(this);
    }
  }
}
