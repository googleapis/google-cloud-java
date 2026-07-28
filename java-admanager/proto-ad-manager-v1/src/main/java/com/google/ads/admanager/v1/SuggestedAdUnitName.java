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
public class SuggestedAdUnitName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_SUGGESTED_AD_UNIT =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/suggestedAdUnits/{suggested_ad_unit}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String suggestedAdUnit;

  @Deprecated
  protected SuggestedAdUnitName() {
    networkCode = null;
    suggestedAdUnit = null;
  }

  private SuggestedAdUnitName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    suggestedAdUnit = Preconditions.checkNotNull(builder.getSuggestedAdUnit());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getSuggestedAdUnit() {
    return suggestedAdUnit;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SuggestedAdUnitName of(String networkCode, String suggestedAdUnit) {
    return newBuilder().setNetworkCode(networkCode).setSuggestedAdUnit(suggestedAdUnit).build();
  }

  public static String format(String networkCode, String suggestedAdUnit) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setSuggestedAdUnit(suggestedAdUnit)
        .build()
        .toString();
  }

  public static @Nullable SuggestedAdUnitName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_SUGGESTED_AD_UNIT.validatedMatch(
            formattedString, "SuggestedAdUnitName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("suggested_ad_unit"));
  }

  public static List<SuggestedAdUnitName> parseList(List<String> formattedStrings) {
    List<SuggestedAdUnitName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable SuggestedAdUnitName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SuggestedAdUnitName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_SUGGESTED_AD_UNIT.matches(formattedString);
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
          if (suggestedAdUnit != null) {
            fieldMapBuilder.put("suggested_ad_unit", suggestedAdUnit);
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
    return NETWORK_CODE_SUGGESTED_AD_UNIT.instantiate(
        "network_code", networkCode, "suggested_ad_unit", suggestedAdUnit);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SuggestedAdUnitName that = ((SuggestedAdUnitName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.suggestedAdUnit, that.suggestedAdUnit);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(suggestedAdUnit);
    return h;
  }

  /** Builder for networks/{network_code}/suggestedAdUnits/{suggested_ad_unit}. */
  public static class Builder {
    private String networkCode;
    private String suggestedAdUnit;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getSuggestedAdUnit() {
      return suggestedAdUnit;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setSuggestedAdUnit(String suggestedAdUnit) {
      this.suggestedAdUnit = suggestedAdUnit;
      return this;
    }

    private Builder(SuggestedAdUnitName suggestedAdUnitName) {
      this.networkCode = suggestedAdUnitName.networkCode;
      this.suggestedAdUnit = suggestedAdUnitName.suggestedAdUnit;
    }

    public SuggestedAdUnitName build() {
      return new SuggestedAdUnitName(this);
    }
  }
}
