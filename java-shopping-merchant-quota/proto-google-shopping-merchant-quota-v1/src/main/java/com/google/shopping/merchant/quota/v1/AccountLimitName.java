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

package com.google.shopping.merchant.quota.v1;

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
public class AccountLimitName implements ResourceName {
  private static final PathTemplate ACCOUNT_LIMIT =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/limits/{limit}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String limit;

  @Deprecated
  protected AccountLimitName() {
    account = null;
    limit = null;
  }

  private AccountLimitName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    limit = Preconditions.checkNotNull(builder.getLimit());
  }

  public String getAccount() {
    return account;
  }

  public String getLimit() {
    return limit;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountLimitName of(String account, String limit) {
    return newBuilder().setAccount(account).setLimit(limit).build();
  }

  public static String format(String account, String limit) {
    return newBuilder().setAccount(account).setLimit(limit).build().toString();
  }

  public static AccountLimitName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_LIMIT.validatedMatch(
            formattedString, "AccountLimitName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("limit"));
  }

  public static List<AccountLimitName> parseList(List<String> formattedStrings) {
    List<AccountLimitName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountLimitName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountLimitName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_LIMIT.matches(formattedString);
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
          if (limit != null) {
            fieldMapBuilder.put("limit", limit);
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
    return ACCOUNT_LIMIT.instantiate("account", account, "limit", limit);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountLimitName that = ((AccountLimitName) o);
      return Objects.equals(this.account, that.account) && Objects.equals(this.limit, that.limit);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(limit);
    return h;
  }

  /** Builder for accounts/{account}/limits/{limit}. */
  public static class Builder {
    private String account;
    private String limit;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getLimit() {
      return limit;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setLimit(String limit) {
      this.limit = limit;
      return this;
    }

    private Builder(AccountLimitName accountLimitName) {
      this.account = accountLimitName.account;
      this.limit = accountLimitName.limit;
    }

    public AccountLimitName build() {
      return new AccountLimitName(this);
    }
  }
}
