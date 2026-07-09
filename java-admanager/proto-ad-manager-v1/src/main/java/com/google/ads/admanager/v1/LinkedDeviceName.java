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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class LinkedDeviceName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_LINKED_DEVICE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/linkedDevices/{linked_device}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String linkedDevice;

  @Deprecated
  protected LinkedDeviceName() {
    networkCode = null;
    linkedDevice = null;
  }

  private LinkedDeviceName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    linkedDevice = Preconditions.checkNotNull(builder.getLinkedDevice());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getLinkedDevice() {
    return linkedDevice;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LinkedDeviceName of(String networkCode, String linkedDevice) {
    return newBuilder().setNetworkCode(networkCode).setLinkedDevice(linkedDevice).build();
  }

  public static String format(String networkCode, String linkedDevice) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setLinkedDevice(linkedDevice)
        .build()
        .toString();
  }

  public static LinkedDeviceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_LINKED_DEVICE.validatedMatch(
            formattedString, "LinkedDeviceName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("linked_device"));
  }

  public static List<LinkedDeviceName> parseList(List<String> formattedStrings) {
    List<LinkedDeviceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LinkedDeviceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LinkedDeviceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_LINKED_DEVICE.matches(formattedString);
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
          if (linkedDevice != null) {
            fieldMapBuilder.put("linked_device", linkedDevice);
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
    return NETWORK_CODE_LINKED_DEVICE.instantiate(
        "network_code", networkCode, "linked_device", linkedDevice);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LinkedDeviceName that = ((LinkedDeviceName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.linkedDevice, that.linkedDevice);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(linkedDevice);
    return h;
  }

  /** Builder for networks/{network_code}/linkedDevices/{linked_device}. */
  public static class Builder {
    private String networkCode;
    private String linkedDevice;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getLinkedDevice() {
      return linkedDevice;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setLinkedDevice(String linkedDevice) {
      this.linkedDevice = linkedDevice;
      return this;
    }

    private Builder(LinkedDeviceName linkedDeviceName) {
      this.networkCode = linkedDeviceName.networkCode;
      this.linkedDevice = linkedDeviceName.linkedDevice;
    }

    public LinkedDeviceName build() {
      return new LinkedDeviceName(this);
    }
  }
}
