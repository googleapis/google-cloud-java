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
public class YieldPartnerName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_YIELD_PARTNER =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/yieldPartners/{yield_partner}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String yieldPartner;

  @Deprecated
  protected YieldPartnerName() {
    networkCode = null;
    yieldPartner = null;
  }

  private YieldPartnerName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    yieldPartner = Preconditions.checkNotNull(builder.getYieldPartner());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getYieldPartner() {
    return yieldPartner;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static YieldPartnerName of(String networkCode, String yieldPartner) {
    return newBuilder().setNetworkCode(networkCode).setYieldPartner(yieldPartner).build();
  }

  public static String format(String networkCode, String yieldPartner) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setYieldPartner(yieldPartner)
        .build()
        .toString();
  }

  public static @Nullable YieldPartnerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_YIELD_PARTNER.validatedMatch(
            formattedString, "YieldPartnerName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("yield_partner"));
  }

  public static List<YieldPartnerName> parseList(List<String> formattedStrings) {
    List<YieldPartnerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable YieldPartnerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (YieldPartnerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_YIELD_PARTNER.matches(formattedString);
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
          if (yieldPartner != null) {
            fieldMapBuilder.put("yield_partner", yieldPartner);
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
    return NETWORK_CODE_YIELD_PARTNER.instantiate(
        "network_code", networkCode, "yield_partner", yieldPartner);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      YieldPartnerName that = ((YieldPartnerName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.yieldPartner, that.yieldPartner);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(yieldPartner);
    return h;
  }

  /** Builder for networks/{network_code}/yieldPartners/{yield_partner}. */
  public static class Builder {
    private String networkCode;
    private String yieldPartner;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getYieldPartner() {
      return yieldPartner;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setYieldPartner(String yieldPartner) {
      this.yieldPartner = yieldPartner;
      return this;
    }

    private Builder(YieldPartnerName yieldPartnerName) {
      this.networkCode = yieldPartnerName.networkCode;
      this.yieldPartner = yieldPartnerName.yieldPartner;
    }

    public YieldPartnerName build() {
      return new YieldPartnerName(this);
    }
  }
}
