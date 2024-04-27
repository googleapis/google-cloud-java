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
public class CustomTargetingValueName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CUSTOM_TARGETING_KEY_CUSTOM_TARGETING_VALUE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/customTargetingKeys/{custom_targeting_key}/customTargetingValues/{custom_targeting_value}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String customTargetingKey;
  private final String customTargetingValue;

  @Deprecated
  protected CustomTargetingValueName() {
    networkCode = null;
    customTargetingKey = null;
    customTargetingValue = null;
  }

  private CustomTargetingValueName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    customTargetingKey = Preconditions.checkNotNull(builder.getCustomTargetingKey());
    customTargetingValue = Preconditions.checkNotNull(builder.getCustomTargetingValue());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCustomTargetingKey() {
    return customTargetingKey;
  }

  public String getCustomTargetingValue() {
    return customTargetingValue;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomTargetingValueName of(
      String networkCode, String customTargetingKey, String customTargetingValue) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCustomTargetingKey(customTargetingKey)
        .setCustomTargetingValue(customTargetingValue)
        .build();
  }

  public static String format(
      String networkCode, String customTargetingKey, String customTargetingValue) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCustomTargetingKey(customTargetingKey)
        .setCustomTargetingValue(customTargetingValue)
        .build()
        .toString();
  }

  public static CustomTargetingValueName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CUSTOM_TARGETING_KEY_CUSTOM_TARGETING_VALUE.validatedMatch(
            formattedString, "CustomTargetingValueName.parse: formattedString not in valid format");
    return of(
        matchMap.get("network_code"),
        matchMap.get("custom_targeting_key"),
        matchMap.get("custom_targeting_value"));
  }

  public static List<CustomTargetingValueName> parseList(List<String> formattedStrings) {
    List<CustomTargetingValueName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomTargetingValueName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomTargetingValueName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CUSTOM_TARGETING_KEY_CUSTOM_TARGETING_VALUE.matches(formattedString);
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
          if (customTargetingKey != null) {
            fieldMapBuilder.put("custom_targeting_key", customTargetingKey);
          }
          if (customTargetingValue != null) {
            fieldMapBuilder.put("custom_targeting_value", customTargetingValue);
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
    return NETWORK_CODE_CUSTOM_TARGETING_KEY_CUSTOM_TARGETING_VALUE.instantiate(
        "network_code",
        networkCode,
        "custom_targeting_key",
        customTargetingKey,
        "custom_targeting_value",
        customTargetingValue);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CustomTargetingValueName that = ((CustomTargetingValueName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.customTargetingKey, that.customTargetingKey)
          && Objects.equals(this.customTargetingValue, that.customTargetingValue);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(customTargetingKey);
    h *= 1000003;
    h ^= Objects.hashCode(customTargetingValue);
    return h;
  }

  /**
   * Builder for
   * networks/{network_code}/customTargetingKeys/{custom_targeting_key}/customTargetingValues/{custom_targeting_value}.
   */
  public static class Builder {
    private String networkCode;
    private String customTargetingKey;
    private String customTargetingValue;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCustomTargetingKey() {
      return customTargetingKey;
    }

    public String getCustomTargetingValue() {
      return customTargetingValue;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCustomTargetingKey(String customTargetingKey) {
      this.customTargetingKey = customTargetingKey;
      return this;
    }

    public Builder setCustomTargetingValue(String customTargetingValue) {
      this.customTargetingValue = customTargetingValue;
      return this;
    }

    private Builder(CustomTargetingValueName customTargetingValueName) {
      this.networkCode = customTargetingValueName.networkCode;
      this.customTargetingKey = customTargetingValueName.customTargetingKey;
      this.customTargetingValue = customTargetingValueName.customTargetingValue;
    }

    public CustomTargetingValueName build() {
      return new CustomTargetingValueName(this);
    }
  }
}
