/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.google.logging.v2;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class BillingExclusionName extends ExclusionName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/exclusions/{exclusion}");

  private volatile Map<String, String> fieldValuesMap;

  private final String billingAccount;
  private final String exclusion;

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getExclusion() {
    return exclusion;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private BillingExclusionName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    exclusion = Preconditions.checkNotNull(builder.getExclusion());
  }

  public static BillingExclusionName of(String billingAccount, String exclusion) {
    return newBuilder()
      .setBillingAccount(billingAccount)
      .setExclusion(exclusion)
      .build();
  }

  public static String format(String billingAccount, String exclusion) {
    return newBuilder()
      .setBillingAccount(billingAccount)
      .setExclusion(exclusion)
      .build()
      .toString();
  }

  public static BillingExclusionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(formattedString, "BillingExclusionName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"), matchMap.get("exclusion"));
  }

  public static List<BillingExclusionName> parseList(List<String> formattedStrings) {
    List<BillingExclusionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingExclusionName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (BillingExclusionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PATH_TEMPLATE.matches(formattedString);
  }

  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          fieldMapBuilder.put("billingAccount", billingAccount);
          fieldMapBuilder.put("exclusion", exclusion);
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
    return PATH_TEMPLATE.instantiate("billing_account", billingAccount, "exclusion", exclusion);
  }

  /** Builder for BillingExclusionName. */
  public static class Builder {

    private String billingAccount;
    private String exclusion;

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getExclusion() {
      return exclusion;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public Builder setExclusion(String exclusion) {
      this.exclusion = exclusion;
      return this;
    }

    private Builder() {
    }

    private Builder(BillingExclusionName billingExclusionName) {
      billingAccount = billingExclusionName.billingAccount;
      exclusion = billingExclusionName.exclusion;
    }

    public BillingExclusionName build() {
      return new BillingExclusionName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BillingExclusionName) {
      BillingExclusionName that = (BillingExclusionName) o;
      return (this.billingAccount.equals(that.billingAccount))
          && (this.exclusion.equals(that.exclusion));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= billingAccount.hashCode();
    h *= 1000003;
    h ^= exclusion.hashCode();
    return h;
  }
}

