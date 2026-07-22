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
public class CdnConfigName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CDN_CONFIG =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/cdnConfigs/{cdn_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String cdnConfig;

  @Deprecated
  protected CdnConfigName() {
    networkCode = null;
    cdnConfig = null;
  }

  private CdnConfigName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    cdnConfig = Preconditions.checkNotNull(builder.getCdnConfig());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCdnConfig() {
    return cdnConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CdnConfigName of(String networkCode, String cdnConfig) {
    return newBuilder().setNetworkCode(networkCode).setCdnConfig(cdnConfig).build();
  }

  public static String format(String networkCode, String cdnConfig) {
    return newBuilder().setNetworkCode(networkCode).setCdnConfig(cdnConfig).build().toString();
  }

  public static @Nullable CdnConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CDN_CONFIG.validatedMatch(
            formattedString, "CdnConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("cdn_config"));
  }

  public static List<CdnConfigName> parseList(List<String> formattedStrings) {
    List<CdnConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable CdnConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CdnConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CDN_CONFIG.matches(formattedString);
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
          if (cdnConfig != null) {
            fieldMapBuilder.put("cdn_config", cdnConfig);
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
    return NETWORK_CODE_CDN_CONFIG.instantiate(
        "network_code", networkCode, "cdn_config", cdnConfig);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CdnConfigName that = ((CdnConfigName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.cdnConfig, that.cdnConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(cdnConfig);
    return h;
  }

  /** Builder for networks/{network_code}/cdnConfigs/{cdn_config}. */
  public static class Builder {
    private String networkCode;
    private String cdnConfig;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCdnConfig() {
      return cdnConfig;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCdnConfig(String cdnConfig) {
      this.cdnConfig = cdnConfig;
      return this;
    }

    private Builder(CdnConfigName cdnConfigName) {
      this.networkCode = cdnConfigName.networkCode;
      this.cdnConfig = cdnConfigName.cdnConfig;
    }

    public CdnConfigName build() {
      return new CdnConfigName(this);
    }
  }
}
