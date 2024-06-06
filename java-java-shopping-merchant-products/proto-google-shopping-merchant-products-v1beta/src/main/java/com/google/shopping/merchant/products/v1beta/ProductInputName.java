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

package com.google.shopping.merchant.products.v1beta;

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
public class ProductInputName implements ResourceName {
  private static final PathTemplate ACCOUNT_PRODUCTINPUT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/productInputs/{productinput}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String productinput;

  @Deprecated
  protected ProductInputName() {
    account = null;
    productinput = null;
  }

  private ProductInputName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    productinput = Preconditions.checkNotNull(builder.getProductinput());
  }

  public String getAccount() {
    return account;
  }

  public String getProductinput() {
    return productinput;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProductInputName of(String account, String productinput) {
    return newBuilder().setAccount(account).setProductinput(productinput).build();
  }

  public static String format(String account, String productinput) {
    return newBuilder().setAccount(account).setProductinput(productinput).build().toString();
  }

  public static ProductInputName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_PRODUCTINPUT.validatedMatch(
            formattedString, "ProductInputName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("productinput"));
  }

  public static List<ProductInputName> parseList(List<String> formattedStrings) {
    List<ProductInputName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProductInputName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProductInputName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_PRODUCTINPUT.matches(formattedString);
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
          if (productinput != null) {
            fieldMapBuilder.put("productinput", productinput);
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
    return ACCOUNT_PRODUCTINPUT.instantiate("account", account, "productinput", productinput);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProductInputName that = ((ProductInputName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.productinput, that.productinput);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(productinput);
    return h;
  }

  /** Builder for accounts/{account}/productInputs/{productinput}. */
  public static class Builder {
    private String account;
    private String productinput;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getProductinput() {
      return productinput;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setProductinput(String productinput) {
      this.productinput = productinput;
      return this;
    }

    private Builder(ProductInputName productInputName) {
      this.account = productInputName.account;
      this.productinput = productInputName.productinput;
    }

    public ProductInputName build() {
      return new ProductInputName(this);
    }
  }
}
