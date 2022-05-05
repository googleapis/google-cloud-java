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
public class CustomerRepricingConfigName implements ResourceName {
  private static final PathTemplate ACCOUNT_CUSTOMER_CUSTOMER_REPRICING_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/customers/{customer}/customerRepricingConfigs/{customer_repricing_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String customer;
  private final String customerRepricingConfig;

  @Deprecated
  protected CustomerRepricingConfigName() {
    account = null;
    customer = null;
    customerRepricingConfig = null;
  }

  private CustomerRepricingConfigName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    customer = Preconditions.checkNotNull(builder.getCustomer());
    customerRepricingConfig = Preconditions.checkNotNull(builder.getCustomerRepricingConfig());
  }

  public String getAccount() {
    return account;
  }

  public String getCustomer() {
    return customer;
  }

  public String getCustomerRepricingConfig() {
    return customerRepricingConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomerRepricingConfigName of(
      String account, String customer, String customerRepricingConfig) {
    return newBuilder()
        .setAccount(account)
        .setCustomer(customer)
        .setCustomerRepricingConfig(customerRepricingConfig)
        .build();
  }

  public static String format(String account, String customer, String customerRepricingConfig) {
    return newBuilder()
        .setAccount(account)
        .setCustomer(customer)
        .setCustomerRepricingConfig(customerRepricingConfig)
        .build()
        .toString();
  }

  public static CustomerRepricingConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CUSTOMER_CUSTOMER_REPRICING_CONFIG.validatedMatch(
            formattedString,
            "CustomerRepricingConfigName.parse: formattedString not in valid format");
    return of(
        matchMap.get("account"),
        matchMap.get("customer"),
        matchMap.get("customer_repricing_config"));
  }

  public static List<CustomerRepricingConfigName> parseList(List<String> formattedStrings) {
    List<CustomerRepricingConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomerRepricingConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomerRepricingConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CUSTOMER_CUSTOMER_REPRICING_CONFIG.matches(formattedString);
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
          if (customerRepricingConfig != null) {
            fieldMapBuilder.put("customer_repricing_config", customerRepricingConfig);
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
    return ACCOUNT_CUSTOMER_CUSTOMER_REPRICING_CONFIG.instantiate(
        "account",
        account,
        "customer",
        customer,
        "customer_repricing_config",
        customerRepricingConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      CustomerRepricingConfigName that = ((CustomerRepricingConfigName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.customer, that.customer)
          && Objects.equals(this.customerRepricingConfig, that.customerRepricingConfig);
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
    h ^= Objects.hashCode(customerRepricingConfig);
    return h;
  }

  /**
   * Builder for
   * accounts/{account}/customers/{customer}/customerRepricingConfigs/{customer_repricing_config}.
   */
  public static class Builder {
    private String account;
    private String customer;
    private String customerRepricingConfig;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getCustomer() {
      return customer;
    }

    public String getCustomerRepricingConfig() {
      return customerRepricingConfig;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setCustomer(String customer) {
      this.customer = customer;
      return this;
    }

    public Builder setCustomerRepricingConfig(String customerRepricingConfig) {
      this.customerRepricingConfig = customerRepricingConfig;
      return this;
    }

    private Builder(CustomerRepricingConfigName customerRepricingConfigName) {
      this.account = customerRepricingConfigName.account;
      this.customer = customerRepricingConfigName.customer;
      this.customerRepricingConfig = customerRepricingConfigName.customerRepricingConfig;
    }

    public CustomerRepricingConfigName build() {
      return new CustomerRepricingConfigName(this);
    }
  }
}
