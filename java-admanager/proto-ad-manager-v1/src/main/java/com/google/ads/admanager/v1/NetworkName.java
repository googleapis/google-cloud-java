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
public class NetworkName implements ResourceName {
  private static final PathTemplate NETWORK_CODE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;

  @Deprecated
  protected NetworkName() {
    networkCode = null;
  }

  private NetworkName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NetworkName of(String networkCode) {
    return newBuilder().setNetworkCode(networkCode).build();
  }

  public static String format(String networkCode) {
    return newBuilder().setNetworkCode(networkCode).build().toString();
  }

  public static NetworkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE.validatedMatch(
            formattedString, "NetworkName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"));
  }

  public static List<NetworkName> parseList(List<String> formattedStrings) {
    List<NetworkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<NetworkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NetworkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE.matches(formattedString);
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
    return NETWORK_CODE.instantiate("network_code", networkCode);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NetworkName that = ((NetworkName) o);
      return Objects.equals(this.networkCode, that.networkCode);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    return h;
  }

  /** Builder for networks/{network_code}. */
  public static class Builder {
    private String networkCode;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    private Builder(NetworkName networkName) {
      this.networkCode = networkName.networkCode;
    }

    public NetworkName build() {
      return new NetworkName(this);
    }
  }
}
