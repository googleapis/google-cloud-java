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
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class TargetingPresetName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_TARGETING_PRESET =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/targetingPresets/{targeting_preset}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String targetingPreset;

  @Deprecated
  protected TargetingPresetName() {
    networkCode = null;
    targetingPreset = null;
  }

  private TargetingPresetName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    targetingPreset = Preconditions.checkNotNull(builder.getTargetingPreset());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getTargetingPreset() {
    return targetingPreset;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TargetingPresetName of(String networkCode, String targetingPreset) {
    return newBuilder().setNetworkCode(networkCode).setTargetingPreset(targetingPreset).build();
  }

  public static String format(String networkCode, String targetingPreset) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setTargetingPreset(targetingPreset)
        .build()
        .toString();
  }

  public static @Nullable TargetingPresetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_TARGETING_PRESET.validatedMatch(
            formattedString, "TargetingPresetName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("targeting_preset"));
  }

  public static List<TargetingPresetName> parseList(List<String> formattedStrings) {
    List<TargetingPresetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable TargetingPresetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TargetingPresetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_TARGETING_PRESET.matches(formattedString);
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
          if (targetingPreset != null) {
            fieldMapBuilder.put("targeting_preset", targetingPreset);
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
    return NETWORK_CODE_TARGETING_PRESET.instantiate(
        "network_code", networkCode, "targeting_preset", targetingPreset);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TargetingPresetName that = ((TargetingPresetName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.targetingPreset, that.targetingPreset);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(targetingPreset);
    return h;
  }

  /** Builder for networks/{network_code}/targetingPresets/{targeting_preset}. */
  public static class Builder {
    private String networkCode;
    private String targetingPreset;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getTargetingPreset() {
      return targetingPreset;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setTargetingPreset(String targetingPreset) {
      this.targetingPreset = targetingPreset;
      return this;
    }

    private Builder(TargetingPresetName targetingPresetName) {
      this.networkCode = targetingPresetName.networkCode;
      this.targetingPreset = targetingPresetName.targetingPreset;
    }

    public TargetingPresetName build() {
      return new TargetingPresetName(this);
    }
  }
}
