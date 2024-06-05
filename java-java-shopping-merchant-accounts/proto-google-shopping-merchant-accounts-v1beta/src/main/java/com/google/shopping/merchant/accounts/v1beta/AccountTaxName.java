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

package com.google.shopping.merchant.accounts.v1beta;

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
public class AccountTaxName implements ResourceName {
  private static final PathTemplate ACCOUNT_TAX =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/accounttax/{tax}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String tax;

  @Deprecated
  protected AccountTaxName() {
    account = null;
    tax = null;
  }

  private AccountTaxName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    tax = Preconditions.checkNotNull(builder.getTax());
  }

  public String getAccount() {
    return account;
  }

  public String getTax() {
    return tax;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountTaxName of(String account, String tax) {
    return newBuilder().setAccount(account).setTax(tax).build();
  }

  public static String format(String account, String tax) {
    return newBuilder().setAccount(account).setTax(tax).build().toString();
  }

  public static AccountTaxName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_TAX.validatedMatch(
            formattedString, "AccountTaxName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("tax"));
  }

  public static List<AccountTaxName> parseList(List<String> formattedStrings) {
    List<AccountTaxName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountTaxName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountTaxName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_TAX.matches(formattedString);
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
          if (tax != null) {
            fieldMapBuilder.put("tax", tax);
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
    return ACCOUNT_TAX.instantiate("account", account, "tax", tax);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountTaxName that = ((AccountTaxName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.tax, that.tax);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(tax);
    return h;
  }

  /** Builder for accounts/{account}/accounttax/{tax}. */
  public static class Builder {
    private String account;
    private String tax;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getTax() {
      return tax;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setTax(String tax) {
      this.tax = tax;
      return this;
    }

    private Builder(AccountTaxName accountTaxName) {
      this.account = accountTaxName.account;
      this.tax = accountTaxName.tax;
    }

    public AccountTaxName build() {
      return new AccountTaxName(this);
    }
  }
}
