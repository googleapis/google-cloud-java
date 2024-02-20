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

package com.google.shopping.merchant.inventories.v1beta;

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
public class RegionalInventoryName implements ResourceName {
  private static final PathTemplate ACCOUNT_PRODUCT_REGION =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/products/{product}/regionalInventories/{region}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String product;
  private final String region;

  @Deprecated
  protected RegionalInventoryName() {
    account = null;
    product = null;
    region = null;
  }

  private RegionalInventoryName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    product = Preconditions.checkNotNull(builder.getProduct());
    region = Preconditions.checkNotNull(builder.getRegion());
  }

  public String getAccount() {
    return account;
  }

  public String getProduct() {
    return product;
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

  public static RegionalInventoryName of(String account, String product, String region) {
    return newBuilder().setAccount(account).setProduct(product).setRegion(region).build();
  }

  public static String format(String account, String product, String region) {
    return newBuilder()
        .setAccount(account)
        .setProduct(product)
        .setRegion(region)
        .build()
        .toString();
  }

  public static RegionalInventoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PRODUCT_REGION.validatedMatch(
            formattedString, "RegionalInventoryName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("product"), matchMap.get("region"));
  }

  public static List<RegionalInventoryName> parseList(List<String> formattedStrings) {
    List<RegionalInventoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RegionalInventoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RegionalInventoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PRODUCT_REGION.matches(formattedString);
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
          if (product != null) {
            fieldMapBuilder.put("product", product);
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
    return ACCOUNT_PRODUCT_REGION.instantiate(
        "account", account, "product", product, "region", region);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RegionalInventoryName that = ((RegionalInventoryName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.product, that.product)
          && Objects.equals(this.region, that.region);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(product);
    h *= 1000003;
    h ^= Objects.hashCode(region);
    return h;
  }

  /** Builder for accounts/{account}/products/{product}/regionalInventories/{region}. */
  public static class Builder {
    private String account;
    private String product;
    private String region;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getProduct() {
      return product;
    }

    public String getRegion() {
      return region;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setProduct(String product) {
      this.product = product;
      return this;
    }

    public Builder setRegion(String region) {
      this.region = region;
      return this;
    }

    private Builder(RegionalInventoryName regionalInventoryName) {
      this.account = regionalInventoryName.account;
      this.product = regionalInventoryName.product;
      this.region = regionalInventoryName.region;
    }

    public RegionalInventoryName build() {
      return new RegionalInventoryName(this);
    }
  }
}
