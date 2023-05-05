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
public class CustomerName implements ResourceName {
  private static final PathTemplate ACCOUNT_CUSTOMER =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/customers/{customer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String customer;

  @Deprecated
  protected CustomerName() {
    account = null;
    customer = null;
  }

  private CustomerName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    customer = Preconditions.checkNotNull(builder.getCustomer());
  }

  public String getAccount() {
    return account;
  }

  public String getCustomer() {
    return customer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomerName of(String account, String customer) {
    return newBuilder().setAccount(account).setCustomer(customer).build();
  }

  public static String format(String account, String customer) {
    return newBuilder().setAccount(account).setCustomer(customer).build().toString();
  }

  public static CustomerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CUSTOMER.validatedMatch(
            formattedString, "CustomerName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("customer"));
  }

  public static List<CustomerName> parseList(List<String> formattedStrings) {
    List<CustomerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CUSTOMER.matches(formattedString);
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
    return ACCOUNT_CUSTOMER.instantiate("account", account, "customer", customer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CustomerName that = ((CustomerName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.customer, that.customer);
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
    return h;
  }

  /** Builder for accounts/{account}/customers/{customer}. */
  public static class Builder {
    private String account;
    private String customer;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getCustomer() {
      return customer;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    private Builder(CustomerName customerName) {
      this.account = customerName.account;
      this.customer = customerName.customer;
    }

    public CustomerName build() {
      return new CustomerName(this);
    }
  }
}
