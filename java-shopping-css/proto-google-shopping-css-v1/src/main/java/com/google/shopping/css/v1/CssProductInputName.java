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
public class CssProductInputName implements ResourceName {
  private static final PathTemplate ACCOUNT_CSS_PRODUCT_INPUT =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/cssProductInputs/{css_product_input}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String cssProductInput;

  @Deprecated
  protected CssProductInputName() {
    account = null;
    cssProductInput = null;
  }

  private CssProductInputName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    cssProductInput = Preconditions.checkNotNull(builder.getCssProductInput());
  }

  public String getAccount() {
    return account;
  }

  public String getCssProductInput() {
    return cssProductInput;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CssProductInputName of(String account, String cssProductInput) {
    return newBuilder().setAccount(account).setCssProductInput(cssProductInput).build();
  }

  public static String format(String account, String cssProductInput) {
    return newBuilder().setAccount(account).setCssProductInput(cssProductInput).build().toString();
  }

  public static CssProductInputName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CSS_PRODUCT_INPUT.validatedMatch(
            formattedString, "CssProductInputName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("css_product_input"));
  }

  public static List<CssProductInputName> parseList(List<String> formattedStrings) {
    List<CssProductInputName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CssProductInputName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CssProductInputName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CSS_PRODUCT_INPUT.matches(formattedString);
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
          if (cssProductInput != null) {
            fieldMapBuilder.put("css_product_input", cssProductInput);
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
    return ACCOUNT_CSS_PRODUCT_INPUT.instantiate(
        "account", account, "css_product_input", cssProductInput);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CssProductInputName that = ((CssProductInputName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.cssProductInput, that.cssProductInput);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(cssProductInput);
    return h;
  }

  /** Builder for accounts/{account}/cssProductInputs/{css_product_input}. */
  public static class Builder {
    private String account;
    private String cssProductInput;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getCssProductInput() {
      return cssProductInput;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setCssProductInput(String cssProductInput) {
      this.cssProductInput = cssProductInput;
      return this;
    }

    private Builder(CssProductInputName cssProductInputName) {
      this.account = cssProductInputName.account;
      this.cssProductInput = cssProductInputName.cssProductInput;
    }

    public CssProductInputName build() {
      return new CssProductInputName(this);
    }
  }
}
