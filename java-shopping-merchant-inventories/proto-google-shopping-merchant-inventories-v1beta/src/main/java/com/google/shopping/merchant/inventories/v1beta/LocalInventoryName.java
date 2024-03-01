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
public class LocalInventoryName implements ResourceName {
  private static final PathTemplate ACCOUNT_PRODUCT_STORE_CODE =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/products/{product}/localInventories/{store_code}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String product;
  private final String storeCode;

  @Deprecated
  protected LocalInventoryName() {
    account = null;
    product = null;
    storeCode = null;
  }

  private LocalInventoryName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    product = Preconditions.checkNotNull(builder.getProduct());
    storeCode = Preconditions.checkNotNull(builder.getStoreCode());
  }

  public String getAccount() {
    return account;
  }

  public String getProduct() {
    return product;
  }

  public String getStoreCode() {
    return storeCode;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LocalInventoryName of(String account, String product, String storeCode) {
    return newBuilder().setAccount(account).setProduct(product).setStoreCode(storeCode).build();
  }

  public static String format(String account, String product, String storeCode) {
    return newBuilder()
        .setAccount(account)
        .setProduct(product)
        .setStoreCode(storeCode)
        .build()
        .toString();
  }

  public static LocalInventoryName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PRODUCT_STORE_CODE.validatedMatch(
            formattedString, "LocalInventoryName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("product"), matchMap.get("store_code"));
  }

  public static List<LocalInventoryName> parseList(List<String> formattedStrings) {
    List<LocalInventoryName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LocalInventoryName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LocalInventoryName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PRODUCT_STORE_CODE.matches(formattedString);
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
          if (storeCode != null) {
            fieldMapBuilder.put("store_code", storeCode);
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
    return ACCOUNT_PRODUCT_STORE_CODE.instantiate(
        "account", account, "product", product, "store_code", storeCode);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LocalInventoryName that = ((LocalInventoryName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.product, that.product)
          && Objects.equals(this.storeCode, that.storeCode);
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
    h ^= Objects.hashCode(storeCode);
    return h;
  }

  /** Builder for accounts/{account}/products/{product}/localInventories/{store_code}. */
  public static class Builder {
    private String account;
    private String product;
    private String storeCode;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getProduct() {
      return product;
    }

    public String getStoreCode() {
      return storeCode;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setProduct(String product) {
      this.product = product;
      return this;
    }

    public Builder setStoreCode(String storeCode) {
      this.storeCode = storeCode;
      return this;
    }

    private Builder(LocalInventoryName localInventoryName) {
      this.account = localInventoryName.account;
      this.product = localInventoryName.product;
      this.storeCode = localInventoryName.storeCode;
    }

    public LocalInventoryName build() {
      return new LocalInventoryName(this);
    }
  }
}
