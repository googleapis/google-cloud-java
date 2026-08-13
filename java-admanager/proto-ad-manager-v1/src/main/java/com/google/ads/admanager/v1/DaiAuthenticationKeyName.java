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
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class DaiAuthenticationKeyName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_DAI_AUTHENTICATION_KEY =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String daiAuthenticationKey;

  @Deprecated
  protected DaiAuthenticationKeyName() {
    networkCode = null;
    daiAuthenticationKey = null;
  }

  private DaiAuthenticationKeyName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    daiAuthenticationKey = Preconditions.checkNotNull(builder.getDaiAuthenticationKey());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getDaiAuthenticationKey() {
    return daiAuthenticationKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static DaiAuthenticationKeyName of(String networkCode, String daiAuthenticationKey) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDaiAuthenticationKey(daiAuthenticationKey)
        .build();
  }

  public static String format(String networkCode, String daiAuthenticationKey) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setDaiAuthenticationKey(daiAuthenticationKey)
        .build()
        .toString();
  }

  public static @Nullable DaiAuthenticationKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_DAI_AUTHENTICATION_KEY.validatedMatch(
            formattedString, "DaiAuthenticationKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("dai_authentication_key"));
  }

  public static List<DaiAuthenticationKeyName> parseList(List<String> formattedStrings) {
    List<DaiAuthenticationKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable DaiAuthenticationKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (DaiAuthenticationKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_DAI_AUTHENTICATION_KEY.matches(formattedString);
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
          if (daiAuthenticationKey != null) {
            fieldMapBuilder.put("dai_authentication_key", daiAuthenticationKey);
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
    return NETWORK_CODE_DAI_AUTHENTICATION_KEY.instantiate(
        "network_code", networkCode, "dai_authentication_key", daiAuthenticationKey);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      DaiAuthenticationKeyName that = ((DaiAuthenticationKeyName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.daiAuthenticationKey, that.daiAuthenticationKey);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(daiAuthenticationKey);
    return h;
  }

  /** Builder for networks/{network_code}/daiAuthenticationKeys/{dai_authentication_key}. */
  public static class Builder {
    private String networkCode;
    private String daiAuthenticationKey;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getDaiAuthenticationKey() {
      return daiAuthenticationKey;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setDaiAuthenticationKey(String daiAuthenticationKey) {
      this.daiAuthenticationKey = daiAuthenticationKey;
      return this;
    }

    private Builder(DaiAuthenticationKeyName daiAuthenticationKeyName) {
      this.networkCode = daiAuthenticationKeyName.networkCode;
      this.daiAuthenticationKey = daiAuthenticationKeyName.daiAuthenticationKey;
    }

    public DaiAuthenticationKeyName build() {
      return new DaiAuthenticationKeyName(this);
    }
  }
}
