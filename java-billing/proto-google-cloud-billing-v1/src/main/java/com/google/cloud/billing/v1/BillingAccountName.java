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

package com.google.cloud.billing.v1;

import com.google.api.core.BetaApi;
import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class BillingAccountName implements ResourceName {
  private static final PathTemplate BILLING_ACCOUNT =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}");
  private static final PathTemplate ORGANIZATION_BILLING_ACCOUNT =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/billingAccounts/{billing_account}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String billingAccount;
  private final String organization;

  @Deprecated
  protected BillingAccountName() {
    billingAccount = null;
    organization = null;
  }

  private BillingAccountName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    organization = null;
    pathTemplate = BILLING_ACCOUNT;
  }

  private BillingAccountName(OrganizationBillingAccountBuilder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    pathTemplate = ORGANIZATION_BILLING_ACCOUNT;
  }

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getOrganization() {
    return organization;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static Builder newBillingAccountBuilder() {
    return new Builder();
  }

  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static OrganizationBillingAccountBuilder newOrganizationBillingAccountBuilder() {
    return new OrganizationBillingAccountBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BillingAccountName of(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BillingAccountName ofBillingAccountName(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build();
  }

  @BetaApi("The static create methods are not stable yet and may be changed in the future.")
  public static BillingAccountName ofOrganizationBillingAccountName(
      String organization, String billingAccount) {
    return newOrganizationBillingAccountBuilder()
        .setOrganization(organization)
        .setBillingAccount(billingAccount)
        .build();
  }

  public static String format(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatBillingAccountName(String billingAccount) {
    return newBuilder().setBillingAccount(billingAccount).build().toString();
  }

  @BetaApi("The static format methods are not stable yet and may be changed in the future.")
  public static String formatOrganizationBillingAccountName(
      String organization, String billingAccount) {
    return newOrganizationBillingAccountBuilder()
        .setOrganization(organization)
        .setBillingAccount(billingAccount)
        .build()
        .toString();
  }

  public static BillingAccountName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (BILLING_ACCOUNT.matches(formattedString)) {
      Map<String, String> matchMap = BILLING_ACCOUNT.match(formattedString);
      return ofBillingAccountName(matchMap.get("billing_account"));
    } else if (ORGANIZATION_BILLING_ACCOUNT.matches(formattedString)) {
      Map<String, String> matchMap = ORGANIZATION_BILLING_ACCOUNT.match(formattedString);
      return ofOrganizationBillingAccountName(
          matchMap.get("organization"), matchMap.get("billing_account"));
    }
    throw new ValidationException("BillingAccountName.parse: formattedString not in valid format");
  }

  public static List<BillingAccountName> parseList(List<String> formattedStrings) {
    List<BillingAccountName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingAccountName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BillingAccountName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return BILLING_ACCOUNT.matches(formattedString)
        || ORGANIZATION_BILLING_ACCOUNT.matches(formattedString);
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
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BillingAccountName that = ((BillingAccountName) o);
      return Objects.equals(this.billingAccount, that.billingAccount)
          && Objects.equals(this.organization, that.organization);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(billingAccount);
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    return h;
  }

  /** Builder for billingAccounts/{billing_account}. */
  public static class Builder {
    private String billingAccount;

    protected Builder() {}

    public String getBillingAccount() {
      return billingAccount;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    private Builder(BillingAccountName billingAccountName) {
      Preconditions.checkArgument(
          Objects.equals(billingAccountName.pathTemplate, BILLING_ACCOUNT),
          "toBuilder is only supported when BillingAccountName has the pattern of billingAccounts/{billing_account}");
      this.billingAccount = billingAccountName.billingAccount;
    }

    public BillingAccountName build() {
      return new BillingAccountName(this);
    }
  }

  /** Builder for organizations/{organization}/billingAccounts/{billing_account}. */
  @BetaApi("The per-pattern Builders are not stable yet and may be changed in the future.")
  public static class OrganizationBillingAccountBuilder {
    private String organization;
    private String billingAccount;

    protected OrganizationBillingAccountBuilder() {}

    public String getOrganization() {
      return organization;
    }

    public String getBillingAccount() {
      return billingAccount;
    }

    public OrganizationBillingAccountBuilder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public OrganizationBillingAccountBuilder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public BillingAccountName build() {
      return new BillingAccountName(this);
    }
  }
}
