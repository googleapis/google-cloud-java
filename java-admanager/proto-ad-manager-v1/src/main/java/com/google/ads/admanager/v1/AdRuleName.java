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
public class AdRuleName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_AD_RULE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/adRules/{ad_rule}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String adRule;

  @Deprecated
  protected AdRuleName() {
    networkCode = null;
    adRule = null;
  }

  private AdRuleName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    adRule = Preconditions.checkNotNull(builder.getAdRule());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getAdRule() {
    return adRule;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AdRuleName of(String networkCode, String adRule) {
    return newBuilder().setNetworkCode(networkCode).setAdRule(adRule).build();
  }

  public static String format(String networkCode, String adRule) {
    return newBuilder().setNetworkCode(networkCode).setAdRule(adRule).build().toString();
  }

  public static @Nullable AdRuleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_AD_RULE.validatedMatch(
            formattedString, "AdRuleName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("ad_rule"));
  }

  public static List<AdRuleName> parseList(List<String> formattedStrings) {
    List<AdRuleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable AdRuleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AdRuleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_AD_RULE.matches(formattedString);
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
          if (adRule != null) {
            fieldMapBuilder.put("ad_rule", adRule);
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
    return NETWORK_CODE_AD_RULE.instantiate("network_code", networkCode, "ad_rule", adRule);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AdRuleName that = ((AdRuleName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.adRule, that.adRule);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(adRule);
    return h;
  }

  /** Builder for networks/{network_code}/adRules/{ad_rule}. */
  public static class Builder {
    private String networkCode;
    private String adRule;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getAdRule() {
      return adRule;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setAdRule(String adRule) {
      this.adRule = adRule;
      return this;
    }

    private Builder(AdRuleName adRuleName) {
      this.networkCode = adRuleName.networkCode;
      this.adRule = adRuleName.adRule;
    }

    public AdRuleName build() {
      return new AdRuleName(this);
    }
  }
}
