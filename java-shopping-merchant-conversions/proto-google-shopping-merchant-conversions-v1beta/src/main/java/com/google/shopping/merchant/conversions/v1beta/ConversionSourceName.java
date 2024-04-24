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

package com.google.shopping.merchant.conversions.v1beta;

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
public class ConversionSourceName implements ResourceName {
  private static final PathTemplate ACCOUNT_CONVERSION_SOURCE =
      PathTemplate.createWithoutUrlEncoding(
          "accounts/{account}/conversionSources/{conversion_source}");
  private volatile Map<String, String> fieldValuesMap;
  private final String account;
  private final String conversionSource;

  @Deprecated
  protected ConversionSourceName() {
    account = null;
    conversionSource = null;
  }

  private ConversionSourceName(Builder builder) {
    account = Preconditions.checkNotNull(builder.getAccount());
    conversionSource = Preconditions.checkNotNull(builder.getConversionSource());
  }

  public String getAccount() {
    return account;
  }

  public String getConversionSource() {
    return conversionSource;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ConversionSourceName of(String account, String conversionSource) {
    return newBuilder().setAccount(account).setConversionSource(conversionSource).build();
  }

  public static String format(String account, String conversionSource) {
    return newBuilder()
        .setAccount(account)
        .setConversionSource(conversionSource)
        .build()
        .toString();
  }

  public static ConversionSourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ACCOUNT_CONVERSION_SOURCE.validatedMatch(
            formattedString, "ConversionSourceName.parse: formattedString not in valid format");
    return of(matchMap.get("account"), matchMap.get("conversion_source"));
  }

  public static List<ConversionSourceName> parseList(List<String> formattedStrings) {
    List<ConversionSourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ConversionSourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ConversionSourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ACCOUNT_CONVERSION_SOURCE.matches(formattedString);
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
          if (conversionSource != null) {
            fieldMapBuilder.put("conversion_source", conversionSource);
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
    return ACCOUNT_CONVERSION_SOURCE.instantiate(
        "account", account, "conversion_source", conversionSource);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ConversionSourceName that = ((ConversionSourceName) o);
      return Objects.equals(this.account, that.account)
          && Objects.equals(this.conversionSource, that.conversionSource);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(account);
    h *= 1000003;
    h ^= Objects.hashCode(conversionSource);
    return h;
  }

  /** Builder for accounts/{account}/conversionSources/{conversion_source}. */
  public static class Builder {
    private String account;
    private String conversionSource;

    protected Builder() {}

    public String getAccount() {
      return account;
    }

    public String getConversionSource() {
      return conversionSource;
    }

    public Builder setAccount(String account) {
      this.account = account;
      return this;
    }

    public Builder setConversionSource(String conversionSource) {
      this.conversionSource = conversionSource;
      return this;
    }

    private Builder(ConversionSourceName conversionSourceName) {
      this.account = conversionSourceName.account;
      this.conversionSource = conversionSourceName.conversionSource;
    }

    public ConversionSourceName build() {
      return new ConversionSourceName(this);
    }
  }
}
