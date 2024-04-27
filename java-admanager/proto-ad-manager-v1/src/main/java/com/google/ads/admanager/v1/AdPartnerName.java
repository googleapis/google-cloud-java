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
public class AdPartnerName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_AD_PARTNER =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/adPartners/{ad_partner}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String adPartner;

  @Deprecated
  protected AdPartnerName() {
    networkCode = null;
    adPartner = null;
  }

  private AdPartnerName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    adPartner = Preconditions.checkNotNull(builder.getAdPartner());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAdPartner() {
    return adPartner;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AdPartnerName of(String networkCode, String adPartner) {
    return newBuilder().setNetworkCode(networkCode).setAdPartner(adPartner).build();
  }

  public static String format(String networkCode, String adPartner) {
    return newBuilder().setNetworkCode(networkCode).setAdPartner(adPartner).build().toString();
  }

  public static AdPartnerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_AD_PARTNER.validatedMatch(
            formattedString, "AdPartnerName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("ad_partner"));
  }

  public static List<AdPartnerName> parseList(List<String> formattedStrings) {
    List<AdPartnerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AdPartnerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AdPartnerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_AD_PARTNER.matches(formattedString);
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
          if (adPartner != null) {
            fieldMapBuilder.put("ad_partner", adPartner);
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
    return NETWORK_CODE_AD_PARTNER.instantiate(
        "network_code", networkCode, "ad_partner", adPartner);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AdPartnerName that = ((AdPartnerName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.adPartner, that.adPartner);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(adPartner);
    return h;
  }

  /** Builder for networks/{network_code}/adPartners/{ad_partner}. */
  public static class Builder {
    private String networkCode;
    private String adPartner;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAdPartner() {
      return adPartner;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAdPartner(String adPartner) {
      this.adPartner = adPartner;
      return this;
    }

    private Builder(AdPartnerName adPartnerName) {
      this.networkCode = adPartnerName.networkCode;
      this.adPartner = adPartnerName.adPartner;
    }

    public AdPartnerName build() {
      return new AdPartnerName(this);
    }
  }
}
