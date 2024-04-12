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
public class ProductName implements ResourceName {
  private static final PathTemplate ACCOUNT_PRODUCT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/products/{product}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String product;

  @Deprecated
  protected ProductName() {
    account = null;
    product = null;
  }

  private ProductName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    product = Preconditions.checkNotNull(builder.getProduct());
  }

  public String getAccount() {
    return account;
  }

  public String getProduct() {
    return product;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProductName of(String account, String product) {
    return newBuilder().setAccount(account).setProduct(product).build();
  }

  public static String format(String account, String product) {
    return newBuilder().setAccount(account).setProduct(product).build().toString();
  }

  public static ProductName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PRODUCT.validatedMatch(
            formattedString, "ProductName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("product"));
  }

  public static List<ProductName> parseList(List<String> formattedStrings) {
    List<ProductName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProductName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProductName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PRODUCT.matches(formattedString);
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
    return ACCOUNT_PRODUCT.instantiate("account", account, "product", product);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProductName that = ((ProductName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.product, that.product);
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
    return h;
  }

  /** Builder for accounts/{account}/products/{product}. */
  public static class Builder {
    private String account;
    private String product;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getProduct() {
      return product;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setProduct(String product) {
      this.product = product;
      return this;
    }

    private Builder(ProductName productName) {
      this.account = productName.account;
      this.product = productName.product;
    }

    public ProductName build() {
      return new ProductName(this);
    }
  }
}
