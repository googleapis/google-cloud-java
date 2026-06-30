/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1beta;

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
public class BillingAccountLicenseConfigName implements ResourceName {
  private static final PathTemplate BILLING_ACCOUNT_BILLING_ACCOUNT_LICENSE_CONFIG =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config}");
  private volatile Map<String, String> fieldValuesMap;
  private final String billingAccount;
  private final String billingAccountLicenseConfig;

  @Deprecated
  protected BillingAccountLicenseConfigName() {
    billingAccount = null;
    billingAccountLicenseConfig = null;
  }

  private BillingAccountLicenseConfigName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    billingAccountLicenseConfig =
        Preconditions.checkNotNull(builder.getBillingAccountLicenseConfig());
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getBillingAccountLicenseConfig() {
    return billingAccountLicenseConfig;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BillingAccountLicenseConfigName of(
      String billingAccount, String billingAccountLicenseConfig) {
    return newBuilder()
        .setBillingAccount(billingAccount)
        .setBillingAccountLicenseConfig(billingAccountLicenseConfig)
        .build();
  }

  public static String format(String billingAccount, String billingAccountLicenseConfig) {
    return newBuilder()
        .setBillingAccount(billingAccount)
        .setBillingAccountLicenseConfig(billingAccountLicenseConfig)
        .build()
        .toString();
  }

  public static BillingAccountLicenseConfigName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        BILLING_ACCOUNT_BILLING_ACCOUNT_LICENSE_CONFIG.validatedMatch(
            formattedString,
            "BillingAccountLicenseConfigName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"), matchMap.get("billing_account_license_config"));
  }

  public static List<BillingAccountLicenseConfigName> parseList(List<String> formattedStrings) {
    List<BillingAccountLicenseConfigName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingAccountLicenseConfigName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BillingAccountLicenseConfigName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return BILLING_ACCOUNT_BILLING_ACCOUNT_LICENSE_CONFIG.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (billingAccount != null) {
            fieldMapBuilder.put("billing_account", billingAccount);
          }
          if (billingAccountLicenseConfig != null) {
            fieldMapBuilder.put("billing_account_license_config", billingAccountLicenseConfig);
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
    return BILLING_ACCOUNT_BILLING_ACCOUNT_LICENSE_CONFIG.instantiate(
        "billing_account",
        billingAccount,
        "billing_account_license_config",
        billingAccountLicenseConfig);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BillingAccountLicenseConfigName that = ((BillingAccountLicenseConfigName) o);
      return Objects.equals(this.billingAccount, that.billingAccount)
          && Objects.equals(this.billingAccountLicenseConfig, that.billingAccountLicenseConfig);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccountLicenseConfig);
    return h;
  }

  /**
   * Builder for
   * billingAccounts/{billing_account}/billingAccountLicenseConfigs/{billing_account_license_config}.
   */
  public static class Builder {
    private String billingAccount;
    private String billingAccountLicenseConfig;

    protected Builder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getBillingAccountLicenseConfig() {
      return billingAccountLicenseConfig;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public Builder setBillingAccountLicenseConfig(String billingAccountLicenseConfig) {
      this.billingAccountLicenseConfig = billingAccountLicenseConfig;
      return this;
    }

    private Builder(BillingAccountLicenseConfigName billingAccountLicenseConfigName) {
      this.billingAccount = billingAccountLicenseConfigName.billingAccount;
      this.billingAccountLicenseConfig =
          billingAccountLicenseConfigName.billingAccountLicenseConfig;
    }

    public BillingAccountLicenseConfigName build() {
      return new BillingAccountLicenseConfigName(this);
    }
  }
}
