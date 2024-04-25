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
public class CustomTargetingKeyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CUSTOM_TARGETING_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/customTargetingKeys/{custom_targeting_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String customTargetingKey;

  @Deprecated
  protected CustomTargetingKeyName() {
    networkCode = null;
    customTargetingKey = null;
  }

  private CustomTargetingKeyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    customTargetingKey = Preconditions.checkNotNull(builder.getCustomTargetingKey());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCustomTargetingKey() {
    return customTargetingKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomTargetingKeyName of(String networkCode, String customTargetingKey) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCustomTargetingKey(customTargetingKey)
        .build();
  }

  public static String format(String networkCode, String customTargetingKey) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCustomTargetingKey(customTargetingKey)
        .build()
        .toString();
  }

  public static CustomTargetingKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CUSTOM_TARGETING_KEY.validatedMatch(
            formattedString, "CustomTargetingKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("custom_targeting_key"));
  }

  public static List<CustomTargetingKeyName> parseList(List<String> formattedStrings) {
    List<CustomTargetingKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomTargetingKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomTargetingKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CUSTOM_TARGETING_KEY.matches(formattedString);
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
    return NETWORK_CODE_CUSTOM_TARGETING_KEY.instantiate(
        "network_code", networkCode, "custom_targeting_key", customTargetingKey);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CustomTargetingKeyName that = ((CustomTargetingKeyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.customTargetingKey, that.customTargetingKey);
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
    return h;
  }

  /** Builder for networks/{network_code}/customTargetingKeys/{custom_targeting_key}. */
  public static class Builder {
    private String networkCode;
    private String customTargetingKey;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCustomTargetingKey() {
      return customTargetingKey;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCustomTargetingKey(String customTargetingKey) {
      this.customTargetingKey = customTargetingKey;
      return this;
    }

    private Builder(CustomTargetingKeyName customTargetingKeyName) {
      this.networkCode = customTargetingKeyName.networkCode;
      this.customTargetingKey = customTargetingKeyName.customTargetingKey;
    }

    public CustomTargetingKeyName build() {
      return new CustomTargetingKeyName(this);
    }
  }
}
