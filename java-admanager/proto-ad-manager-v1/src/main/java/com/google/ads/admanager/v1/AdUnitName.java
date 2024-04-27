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
public class AdUnitName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_AD_UNIT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/adUnits/{ad_unit}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String adUnit;

  @Deprecated
  protected AdUnitName() {
    networkCode = null;
    adUnit = null;
  }

  private AdUnitName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    adUnit = Preconditions.checkNotNull(builder.getAdUnit());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAdUnit() {
    return adUnit;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AdUnitName of(String networkCode, String adUnit) {
    return newBuilder().setNetworkCode(networkCode).setAdUnit(adUnit).build();
  }

  public static String format(String networkCode, String adUnit) {
    return newBuilder().setNetworkCode(networkCode).setAdUnit(adUnit).build().toString();
  }

  public static AdUnitName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_AD_UNIT.validatedMatch(
            formattedString, "AdUnitName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("ad_unit"));
  }

  public static List<AdUnitName> parseList(List<String> formattedStrings) {
    List<AdUnitName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AdUnitName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AdUnitName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_AD_UNIT.matches(formattedString);
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
          if (adUnit != null) {
            fieldMapBuilder.put("ad_unit", adUnit);
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
    return NETWORK_CODE_AD_UNIT.instantiate("network_code", networkCode, "ad_unit", adUnit);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AdUnitName that = ((AdUnitName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.adUnit, that.adUnit);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(adUnit);
    return h;
  }

  /** Builder for networks/{network_code}/adUnits/{ad_unit}. */
  public static class Builder {
    private String networkCode;
    private String adUnit;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAdUnit() {
      return adUnit;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAdUnit(String adUnit) {
      this.adUnit = adUnit;
      return this;
    }

    private Builder(AdUnitName adUnitName) {
      this.networkCode = adUnitName.networkCode;
      this.adUnit = adUnitName.adUnit;
    }

    public AdUnitName build() {
      return new AdUnitName(this);
    }
  }
}
