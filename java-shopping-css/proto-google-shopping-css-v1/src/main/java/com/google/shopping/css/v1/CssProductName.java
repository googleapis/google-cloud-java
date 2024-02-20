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

package com.google.shopping.css.v1;

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
public class CssProductName implements ResourceName {
  private static final PathTemplate ACCOUNT_CSS_PRODUCT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/cssProducts/{css_product}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String cssProduct;

  @Deprecated
  protected CssProductName() {
    account = null;
    cssProduct = null;
  }

  private CssProductName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    cssProduct = Preconditions.checkNotNull(builder.getCssProduct());
  }

  public String getAccount() {
    return account;
  }

  public String getCssProduct() {
    return cssProduct;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CssProductName of(String account, String cssProduct) {
    return newBuilder().setAccount(account).setCssProduct(cssProduct).build();
  }

  public static String format(String account, String cssProduct) {
    return newBuilder().setAccount(account).setCssProduct(cssProduct).build().toString();
  }

  public static CssProductName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CSS_PRODUCT.validatedMatch(
            formattedString, "CssProductName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("css_product"));
  }

  public static List<CssProductName> parseList(List<String> formattedStrings) {
    List<CssProductName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CssProductName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CssProductName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CSS_PRODUCT.matches(formattedString);
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
          if (cssProduct != null) {
            fieldMapBuilder.put("css_product", cssProduct);
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
    return ACCOUNT_CSS_PRODUCT.instantiate("account", account, "css_product", cssProduct);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CssProductName that = ((CssProductName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.cssProduct, that.cssProduct);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(cssProduct);
    return h;
  }

  /** Builder for accounts/{account}/cssProducts/{css_product}. */
  public static class Builder {
    private String account;
    private String cssProduct;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getCssProduct() {
      return cssProduct;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setCssProduct(String cssProduct) {
      this.cssProduct = cssProduct;
      return this;
    }

    private Builder(CssProductName cssProductName) {
      this.account = cssProductName.account;
      this.cssProduct = cssProductName.cssProduct;
    }

    public CssProductName build() {
      return new CssProductName(this);
    }
  }
}
