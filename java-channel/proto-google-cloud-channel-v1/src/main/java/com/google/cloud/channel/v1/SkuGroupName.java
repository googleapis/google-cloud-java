/*
 * Copyright 2023 Google LLC
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
public class SkuGroupName implements ResourceName {
  private static final PathTemplate ACCOUNT_SKU_GROUP =
      PathTemplate.createWithoutUrlEncoding("accounts/{account}/skuGroups/{sku_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String skuGroup;

  @Deprecated
  protected SkuGroupName() {
    account = null;
    skuGroup = null;
  }

  private SkuGroupName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    skuGroup = Preconditions.checkNotNull(builder.getSkuGroup());
  }

  public String getAccount() {
    return account;
  }

  public String getSkuGroup() {
    return skuGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SkuGroupName of(String account, String skuGroup) {
    return newBuilder().setAccount(account).setSkuGroup(skuGroup).build();
  }

  public static String format(String account, String skuGroup) {
    return newBuilder().setAccount(account).setSkuGroup(skuGroup).build().toString();
  }

  public static SkuGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_SKU_GROUP.validatedMatch(
            formattedString, "SkuGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("sku_group"));
  }

  public static List<SkuGroupName> parseList(List<String> formattedStrings) {
    List<SkuGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SkuGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SkuGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_SKU_GROUP.matches(formattedString);
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
          if (skuGroup != null) {
            fieldMapBuilder.put("sku_group", skuGroup);
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
    return ACCOUNT_SKU_GROUP.instantiate("account", account, "sku_group", skuGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SkuGroupName that = ((SkuGroupName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.skuGroup, that.skuGroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(skuGroup);
    return h;
  }

  /** Builder for accounts/{account}/skuGroups/{sku_group}. */
  public static class Builder {
    private String account;
    private String skuGroup;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getSkuGroup() {
      return skuGroup;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setSkuGroup(String skuGroup) {
      this.skuGroup = skuGroup;
      return this;
    }

    private Builder(SkuGroupName skuGroupName) {
      this.account = skuGroupName.account;
      this.skuGroup = skuGroupName.skuGroup;
    }

    public SkuGroupName build() {
      return new SkuGroupName(this);
    }
  }
}
