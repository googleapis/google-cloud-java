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

import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

// AUTO-GENERATED DOCUMENTATION AND CLASS
@javax.annotation.Generated("by GAPIC protoc plugin")
public class BillingSinkName extends SinkName {

  private static final PathTemplate PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("billingAccounts/{billing_account}/sinks/{sink}");

  private volatile Map<String, String> fieldValuesMap;

  private final String billingAccount;
  private final String sink;

  public String getBillingAccount() {
    return billingAccount;
  }

  public String getSink() {
    return sink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private BillingSinkName(Builder builder) {
    billingAccount = Preconditions.checkNotNull(builder.getBillingAccount());
    sink = Preconditions.checkNotNull(builder.getSink());
  }

  public static BillingSinkName of(String billingAccount, String sink) {
    return newBuilder().setBillingAccount(billingAccount).setSink(sink).build();
  }

  public static String format(String billingAccount, String sink) {
    return newBuilder().setBillingAccount(billingAccount).setSink(sink).build().toString();
  }

  public static BillingSinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PATH_TEMPLATE.validatedMatch(
            formattedString, "BillingSinkName.parse: formattedString not in valid format");
    return of(matchMap.get("billing_account"), matchMap.get("sink"));
  }

  public static List<BillingSinkName> parseList(List<String> formattedStrings) {
    List<BillingSinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BillingSinkName> values) {
    List<String> list = new ArrayList<String>(values.size());
    for (BillingSinkName value : values) {
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
          fieldMapBuilder.put("sink", sink);
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
    return PATH_TEMPLATE.instantiate("billing_account", billingAccount, "sink", sink);
  }

  /** Builder for BillingSinkName. */
  public static class Builder {

    private String billingAccount;
    private String sink;

    public String getBillingAccount() {
      return billingAccount;
    }

    public String getSink() {
      return sink;
    }

    public Builder setBillingAccount(String billingAccount) {
      this.billingAccount = billingAccount;
      return this;
    }

    public Builder setSink(String sink) {
      this.sink = sink;
      return this;
    }

    private Builder() {}

    private Builder(BillingSinkName billingSinkName) {
      billingAccount = billingSinkName.billingAccount;
      sink = billingSinkName.sink;
    }

    public BillingSinkName build() {
      return new BillingSinkName(this);
    }
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BillingSinkName) {
      BillingSinkName that = (BillingSinkName) o;
      return (this.billingAccount.equals(that.billingAccount)) && (this.sink.equals(that.sink));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= billingAccount.hashCode();
    h *= 1000003;
    h ^= sink.hashCode();
    return h;
  }
}
