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

package com.google.shopping.merchant.accounts.v1;

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
public class RegionName implements ResourceName {
  private static final PathTemplate ACCOUNT_REGION =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/regions/{region}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String region;

  @Deprecated
  protected RegionName() {
    account = null;
    region = null;
  }

  private RegionName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public String getAccount() {
    return account;
  }

  public String getRegion() {
    return region;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RegionName of(String account, String region) {
    return newBuilder().setAccount(account).setRegion(region).build();
  }

  public static String format(String account, String region) {
    return newBuilder().setAccount(account).setRegion(region).build().toString();
  }

  public static RegionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_REGION.validatedMatch(
            formattedString, "RegionName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("region"));
  }

  public static List<RegionName> parseList(List<String> formattedStrings) {
    List<RegionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RegionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RegionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_REGION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (account != null) {
            fieldMapBuilder.put("account", account);
          }
          if (region != null) {
            fieldMapBuilder.put("region", region);
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
    return ACCOUNT_REGION.instantiate("account", account, "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RegionName that = ((RegionName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.region, that.region);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    return h;
  }

  /** Builder for accounts/{account}/regions/{region}. */
  public static class Builder {
    private String account;
    private String region;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getRegion() {
      return region;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    private Builder(RegionName regionName) {
      this.account = regionName.account;
      this.region = regionName.region;
    }

    public RegionName build() {
      return new RegionName(this);
    }
  }
}
