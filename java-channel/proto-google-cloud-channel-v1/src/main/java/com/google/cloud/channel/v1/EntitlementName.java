/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.channel.v1;

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
public class EntitlementName implements ResourceName {
  private static final PathTemplate ACCOUNT_CUSTOMER_ENTITLEMENT =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/customers/{customer}/entitlements/{entitlement}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String customer;
  private final String entitlement;

  @Deprecated
  protected EntitlementName() {
    account = null;
    customer = null;
    entitlement = null;
  }

  private EntitlementName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    customer = Preconditions.checkNotNull(builder.getCustomer());
    entitlement = Preconditions.checkNotNull(builder.getEntitlement());
  }

  public String getAccount() {
    return account;
  }

  public String getCustomer() {
    return customer;
  }

  public String getEntitlement() {
    return entitlement;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static EntitlementName of(String account, String customer, String entitlement) {
    return newBuilder()
        .setAccount(account)
        .setCustomer(customer)
        .setEntitlement(entitlement)
        .build();
  }

  public static String format(String account, String customer, String entitlement) {
    return newBuilder()
        .setAccount(account)
        .setCustomer(customer)
        .setEntitlement(entitlement)
        .build()
        .toString();
  }

  public static EntitlementName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CUSTOMER_ENTITLEMENT.validatedMatch(
            formattedString, "EntitlementName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("customer"), matchMap.get("entitlement"));
  }

  public static List<EntitlementName> parseList(List<String> formattedStrings) {
    List<EntitlementName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<EntitlementName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (EntitlementName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CUSTOMER_ENTITLEMENT.matches(formattedString);
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
          if (customer != null) {
            fieldMapBuilder.put("customer", customer);
          }
          if (entitlement != null) {
            fieldMapBuilder.put("entitlement", entitlement);
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
    return ACCOUNT_CUSTOMER_ENTITLEMENT.instantiate(
        "account", account, "customer", customer, "entitlement", entitlement);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      EntitlementName that = ((EntitlementName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.customer, that.customer)
          && Objects.equals(this.entitlement, that.entitlement);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(customer);
    h *= 1000003;
    h ^= Objects.hashCode(entitlement);
    return h;
  }

  /** Builder for accounts/{account}/customers/{customer}/entitlements/{entitlement}. */
  public static class Builder {
    private String account;
    private String customer;
    private String entitlement;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getCustomer() {
      return customer;
    }

    public String getEntitlement() {
      return entitlement;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    public Builder setEntitlement(String entitlement) {
      this.entitlement = entitlement;
      return this;
    }

    private Builder(EntitlementName entitlementName) {
      this.account = entitlementName.account;
      this.customer = entitlementName.customer;
      this.entitlement = entitlementName.entitlement;
    }

    public EntitlementName build() {
      return new EntitlementName(this);
    }
  }
}
