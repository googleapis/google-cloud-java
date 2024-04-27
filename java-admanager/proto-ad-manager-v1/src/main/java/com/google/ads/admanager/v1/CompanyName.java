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

package com.google.ads.admanager.v1;

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
public class CompanyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_COMPANY =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/companies/{company}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String company;

  @Deprecated
  protected CompanyName() {
    networkCode = null;
    company = null;
  }

  private CompanyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    company = Preconditions.checkNotNull(builder.getCompany());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCompany() {
    return company;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CompanyName of(String networkCode, String company) {
    return newBuilder().setNetworkCode(networkCode).setCompany(company).build();
  }

  public static String format(String networkCode, String company) {
    return newBuilder().setNetworkCode(networkCode).setCompany(company).build().toString();
  }

  public static CompanyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_COMPANY.validatedMatch(
            formattedString, "CompanyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("company"));
  }

  public static List<CompanyName> parseList(List<String> formattedStrings) {
    List<CompanyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CompanyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CompanyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_COMPANY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (networkCode != null) {
            fieldMapBuilder.put("network_code", networkCode);
          }
          if (company != null) {
            fieldMapBuilder.put("company", company);
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
    return NETWORK_CODE_COMPANY.instantiate("network_code", networkCode, "company", company);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CompanyName that = ((CompanyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.company, that.company);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(company);
    return h;
  }

  /** Builder for networks/{network_code}/companies/{company}. */
  public static class Builder {
    private String networkCode;
    private String company;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCompany() {
      return company;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCompany(String company) {
      this.company = company;
      return this;
    }

    private Builder(CompanyName companyName) {
      this.networkCode = companyName.networkCode;
      this.company = companyName.company;
    }

    public CompanyName build() {
      return new CompanyName(this);
    }
  }
}
