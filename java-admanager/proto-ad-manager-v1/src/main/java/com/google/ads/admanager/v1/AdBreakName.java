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
public class AdBreakName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_ASSET_KEY_AD_BREAK =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String assetKey;
  private final String adBreak;

  @Deprecated
  protected AdBreakName() {
    networkCode = null;
    assetKey = null;
    adBreak = null;
  }

  private AdBreakName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    assetKey = Preconditions.checkNotNull(builder.getAssetKey());
    adBreak = Preconditions.checkNotNull(builder.getAdBreak());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAssetKey() {
    return assetKey;
  }

  public String getAdBreak() {
    return adBreak;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AdBreakName of(String networkCode, String assetKey, String adBreak) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setAssetKey(assetKey)
        .setAdBreak(adBreak)
        .build();
  }

  public static String format(String networkCode, String assetKey, String adBreak) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setAssetKey(assetKey)
        .setAdBreak(adBreak)
        .build()
        .toString();
  }

  public static AdBreakName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_ASSET_KEY_AD_BREAK.validatedMatch(
            formattedString, "AdBreakName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("asset_key"), matchMap.get("ad_break"));
  }

  public static List<AdBreakName> parseList(List<String> formattedStrings) {
    List<AdBreakName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AdBreakName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AdBreakName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_ASSET_KEY_AD_BREAK.matches(formattedString);
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
          if (assetKey != null) {
            fieldMapBuilder.put("asset_key", assetKey);
          }
          if (adBreak != null) {
            fieldMapBuilder.put("ad_break", adBreak);
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
    return NETWORK_CODE_ASSET_KEY_AD_BREAK.instantiate(
        "network_code", networkCode, "asset_key", assetKey, "ad_break", adBreak);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AdBreakName that = ((AdBreakName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.assetKey, that.assetKey)
          && Objects.equals(this.adBreak, that.adBreak);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(assetKey);
    h *= 1000003;
    h ^= Objects.hashCode(adBreak);
    return h;
  }

  /**
   * Builder for networks/{network_code}/liveStreamEventsByAssetKey/{asset_key}/adBreaks/{ad_break}.
   */
  public static class Builder {
    private String networkCode;
    private String assetKey;
    private String adBreak;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAssetKey() {
      return assetKey;
    }

    public String getAdBreak() {
      return adBreak;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAssetKey(String assetKey) {
      this.assetKey = assetKey;
      return this;
    }

    public Builder setAdBreak(String adBreak) {
      this.adBreak = adBreak;
      return this;
    }

    private Builder(AdBreakName adBreakName) {
      this.networkCode = adBreakName.networkCode;
      this.assetKey = adBreakName.assetKey;
      this.adBreak = adBreakName.adBreak;
    }

    public AdBreakName build() {
      return new AdBreakName(this);
    }
  }
}
