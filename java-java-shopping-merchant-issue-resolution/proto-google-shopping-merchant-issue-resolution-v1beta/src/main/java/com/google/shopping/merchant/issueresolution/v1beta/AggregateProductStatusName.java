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

package com.google.shopping.merchant.issueresolution.v1beta;

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
public class AggregateProductStatusName implements ResourceName {
  private static final PathTemplate ACCOUNT_AGGREGATE_PRODUCT_STATUS =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/aggregateProductStatuses/{aggregate_product_status}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String aggregateProductStatus;

  @Deprecated
  protected AggregateProductStatusName() {
    account = null;
    aggregateProductStatus = null;
  }

  private AggregateProductStatusName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    aggregateProductStatus = Preconditions.checkNotNull(builder.getAggregateProductStatus());
  }

  public String getAccount() {
    return account;
  }

  public String getAggregateProductStatus() {
    return aggregateProductStatus;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AggregateProductStatusName of(String account, String aggregateProductStatus) {
    return newBuilder()
        .setAccount(account)
        .setAggregateProductStatus(aggregateProductStatus)
        .build();
  }

  public static String format(String account, String aggregateProductStatus) {
    return newBuilder()
        .setAccount(account)
        .setAggregateProductStatus(aggregateProductStatus)
        .build()
        .toString();
  }

  public static AggregateProductStatusName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_AGGREGATE_PRODUCT_STATUS.validatedMatch(
            formattedString,
            "AggregateProductStatusName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("aggregate_product_status"));
  }

  public static List<AggregateProductStatusName> parseList(List<String> formattedStrings) {
    List<AggregateProductStatusName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AggregateProductStatusName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AggregateProductStatusName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_AGGREGATE_PRODUCT_STATUS.matches(formattedString);
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
          if (aggregateProductStatus != null) {
            fieldMapBuilder.put("aggregate_product_status", aggregateProductStatus);
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
    return ACCOUNT_AGGREGATE_PRODUCT_STATUS.instantiate(
        "account", account, "aggregate_product_status", aggregateProductStatus);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AggregateProductStatusName that = ((AggregateProductStatusName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.aggregateProductStatus, that.aggregateProductStatus);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(aggregateProductStatus);
    return h;
  }

  /** Builder for accounts/{account}/aggregateProductStatuses/{aggregate_product_status}. */
  public static class Builder {
    private String account;
    private String aggregateProductStatus;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getAggregateProductStatus() {
      return aggregateProductStatus;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setAggregateProductStatus(String aggregateProductStatus) {
      this.aggregateProductStatus = aggregateProductStatus;
      return this;
    }

    private Builder(AggregateProductStatusName aggregateProductStatusName) {
      this.account = aggregateProductStatusName.account;
      this.aggregateProductStatus = aggregateProductStatusName.aggregateProductStatus;
    }

    public AggregateProductStatusName build() {
      return new AggregateProductStatusName(this);
    }
  }
}
