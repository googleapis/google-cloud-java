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

package com.google.devicesandservices.health.v4;

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
public class PairedDeviceName implements ResourceName {
  private static final PathTemplate USER_PAIRED_DEVICE =
      PathTemplate.createWithoutUrlEncoding("users/{user}/pairedDevices/{paired_device}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String pairedDevice;

  @Deprecated
  protected PairedDeviceName() {
    user = null;
    pairedDevice = null;
  }

  private PairedDeviceName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    pairedDevice = Preconditions.checkNotNull(builder.getPairedDevice());
  }

  public String getUser() {
    return user;
  }

  public String getPairedDevice() {
    return pairedDevice;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PairedDeviceName of(String user, String pairedDevice) {
    return newBuilder().setUser(user).setPairedDevice(pairedDevice).build();
  }

  public static String format(String user, String pairedDevice) {
    return newBuilder().setUser(user).setPairedDevice(pairedDevice).build().toString();
  }

  public static PairedDeviceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_PAIRED_DEVICE.validatedMatch(
            formattedString, "PairedDeviceName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("paired_device"));
  }

  public static List<PairedDeviceName> parseList(List<String> formattedStrings) {
    List<PairedDeviceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PairedDeviceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PairedDeviceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_PAIRED_DEVICE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (pairedDevice != null) {
            fieldMapBuilder.put("paired_device", pairedDevice);
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
    return USER_PAIRED_DEVICE.instantiate("user", user, "paired_device", pairedDevice);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PairedDeviceName that = ((PairedDeviceName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.pairedDevice, that.pairedDevice);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(pairedDevice);
    return h;
  }

  /** Builder for users/{user}/pairedDevices/{paired_device}. */
  public static class Builder {
    private String user;
    private String pairedDevice;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getPairedDevice() {
      return pairedDevice;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setPairedDevice(String pairedDevice) {
      this.pairedDevice = pairedDevice;
      return this;
    }

    private Builder(PairedDeviceName pairedDeviceName) {
      this.user = pairedDeviceName.user;
      this.pairedDevice = pairedDeviceName.pairedDevice;
    }

    public PairedDeviceName build() {
      return new PairedDeviceName(this);
    }
  }
}
