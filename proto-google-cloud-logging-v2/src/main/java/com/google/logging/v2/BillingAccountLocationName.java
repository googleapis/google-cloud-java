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

package com.google.logging.v2;

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
public class BillingAccountLocationName implements ResourceName {
  private static final PathTemplate BILLING_ACCOUNT_LOCATION =
      PathTemplate.createWithoutUrlEncoding(
          "billingAccounts/{billing_account}/locations/{location}");
  private volatile Map<String, String> fieldValuesMap;
  private final String billingAccount;
  private final String location;

  @Deprecated
  protected BillingAccountLocationName() {
    billingAccount = null;
    location = null;
  }

  private BillingAccountLocationName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    location = Preconditions.checkNotNull(builder.getLocation());
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getLocation() {
    return location;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BillingAccountLocationName of(String billingAccount, String location) {
    return newBuilder().setBillingAccount(billingAccount).setLocation(location).build();
  }

  public static String format(String billingAccount, String location) {
    return newBuilder().setBillingAccount(billingAccount).setLocation(location).build().toString();
  }

  public static BillingAccountLocationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        BILLING_ACCOUNT_LOCATION.validatedMatch(
            formattedString,
            "BillingAccountLocationName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"), matchMap.get("location"));
  }

  public static List<BillingAccountLocationName> parseList(List<String> formattedStrings) {
    List<BillingAccountLocationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingAccountLocationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BillingAccountLocationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return BILLING_ACCOUNT_LOCATION.matches(formattedString);
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
          if (location != null) {
            fieldMapBuilder.put("location", location);
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
    return BILLING_ACCOUNT_LOCATION.instantiate(
        "billing_account", billingAccount, "location", location);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BillingAccountLocationName that = ((BillingAccountLocationName) o);
      return Objects.equals(this.billingAccount, that.billingAccount)
          && Objects.equals(this.location, that.location);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    return h;
  }

  /** Builder for billingAccounts/{billing_account}/locations/{location}. */
  public static class Builder {
    private String billingAccount;
    private String location;

    protected Builder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getLocation() {
      return location;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    private Builder(BillingAccountLocationName billingAccountLocationName) {
      this.billingAccount = billingAccountLocationName.billingAccount;
      this.location = billingAccountLocationName.location;
    }

    public BillingAccountLocationName build() {
      return new BillingAccountLocationName(this);
    }
  }
}
