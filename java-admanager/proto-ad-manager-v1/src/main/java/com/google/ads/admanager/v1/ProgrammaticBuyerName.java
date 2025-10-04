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
public class ProgrammaticBuyerName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_PROGRAMMATIC_BUYER =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/programmaticBuyers/{programmatic_buyer}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String programmaticBuyer;

  @Deprecated
  protected ProgrammaticBuyerName() {
    networkCode = null;
    programmaticBuyer = null;
  }

  private ProgrammaticBuyerName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    programmaticBuyer = Preconditions.checkNotNull(builder.getProgrammaticBuyer());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getProgrammaticBuyer() {
    return programmaticBuyer;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static ProgrammaticBuyerName of(String networkCode, String programmaticBuyer) {
    return newBuilder().setNetworkCode(networkCode).setProgrammaticBuyer(programmaticBuyer).build();
  }

  public static String format(String networkCode, String programmaticBuyer) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setProgrammaticBuyer(programmaticBuyer)
        .build()
        .toString();
  }

  public static ProgrammaticBuyerName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_PROGRAMMATIC_BUYER.validatedMatch(
            formattedString, "ProgrammaticBuyerName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("programmatic_buyer"));
  }

  public static List<ProgrammaticBuyerName> parseList(List<String> formattedStrings) {
    List<ProgrammaticBuyerName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<ProgrammaticBuyerName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (ProgrammaticBuyerName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_PROGRAMMATIC_BUYER.matches(formattedString);
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
          if (programmaticBuyer != null) {
            fieldMapBuilder.put("programmatic_buyer", programmaticBuyer);
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
    return NETWORK_CODE_PROGRAMMATIC_BUYER.instantiate(
        "network_code", networkCode, "programmatic_buyer", programmaticBuyer);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      ProgrammaticBuyerName that = ((ProgrammaticBuyerName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.programmaticBuyer, that.programmaticBuyer);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(programmaticBuyer);
    return h;
  }

  /** Builder for networks/{network_code}/programmaticBuyers/{programmatic_buyer}. */
  public static class Builder {
    private String networkCode;
    private String programmaticBuyer;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getProgrammaticBuyer() {
      return programmaticBuyer;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setProgrammaticBuyer(String programmaticBuyer) {
      this.programmaticBuyer = programmaticBuyer;
      return this;
    }

    private Builder(ProgrammaticBuyerName programmaticBuyerName) {
      this.networkCode = programmaticBuyerName.networkCode;
      this.programmaticBuyer = programmaticBuyerName.programmaticBuyer;
    }

    public ProgrammaticBuyerName build() {
      return new ProgrammaticBuyerName(this);
    }
  }
}
