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
public class AccountServiceName implements ResourceName {
  private static final PathTemplate ACCOUNT_SERVICE =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/services/{service}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String service;

  @Deprecated
  protected AccountServiceName() {
    account = null;
    service = null;
  }

  private AccountServiceName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    service = Preconditions.checkNotNull(builder.getService());
  }

  public String getAccount() {
    return account;
  }

  public String getService() {
    return service;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AccountServiceName of(String account, String service) {
    return newBuilder().setAccount(account).setService(service).build();
  }

  public static String format(String account, String service) {
    return newBuilder().setAccount(account).setService(service).build().toString();
  }

  public static AccountServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_SERVICE.validatedMatch(
            formattedString, "AccountServiceName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("service"));
  }

  public static List<AccountServiceName> parseList(List<String> formattedStrings) {
    List<AccountServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AccountServiceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AccountServiceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_SERVICE.matches(formattedString);
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
          if (service != null) {
            fieldMapBuilder.put("service", service);
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
    return ACCOUNT_SERVICE.instantiate("account", account, "service", service);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AccountServiceName that = ((AccountServiceName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.service, that.service);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(service);
    return h;
  }

  /** Builder for accounts/{account}/services/{service}. */
  public static class Builder {
    private String account;
    private String service;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getService() {
      return service;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setService(String service) {
      this.service = service;
      return this;
    }

    private Builder(AccountServiceName accountServiceName) {
      this.account = accountServiceName.account;
      this.service = accountServiceName.service;
    }

    public AccountServiceName build() {
      return new AccountServiceName(this);
    }
  }
}
