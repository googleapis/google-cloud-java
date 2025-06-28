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
public class BandwidthGroupName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_BANDWIDTH_GROUP =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/bandwidthGroups/{bandwidth_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String bandwidthGroup;

  @Deprecated
  protected BandwidthGroupName() {
    networkCode = null;
    bandwidthGroup = null;
  }

  private BandwidthGroupName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    bandwidthGroup = Preconditions.checkNotNull(builder.getBandwidthGroup());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getBandwidthGroup() {
    return bandwidthGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BandwidthGroupName of(String networkCode, String bandwidthGroup) {
    return newBuilder().setNetworkCode(networkCode).setBandwidthGroup(bandwidthGroup).build();
  }

  public static String format(String networkCode, String bandwidthGroup) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setBandwidthGroup(bandwidthGroup)
        .build()
        .toString();
  }

  public static BandwidthGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_BANDWIDTH_GROUP.validatedMatch(
            formattedString, "BandwidthGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("bandwidth_group"));
  }

  public static List<BandwidthGroupName> parseList(List<String> formattedStrings) {
    List<BandwidthGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BandwidthGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BandwidthGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_BANDWIDTH_GROUP.matches(formattedString);
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
          if (bandwidthGroup != null) {
            fieldMapBuilder.put("bandwidth_group", bandwidthGroup);
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
    return NETWORK_CODE_BANDWIDTH_GROUP.instantiate(
        "network_code", networkCode, "bandwidth_group", bandwidthGroup);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BandwidthGroupName that = ((BandwidthGroupName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.bandwidthGroup, that.bandwidthGroup);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(bandwidthGroup);
    return h;
  }

  /** Builder for networks/{network_code}/bandwidthGroups/{bandwidth_group}. */
  public static class Builder {
    private String networkCode;
    private String bandwidthGroup;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getBandwidthGroup() {
      return bandwidthGroup;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setBandwidthGroup(String bandwidthGroup) {
      this.bandwidthGroup = bandwidthGroup;
      return this;
    }

    private Builder(BandwidthGroupName bandwidthGroupName) {
      this.networkCode = bandwidthGroupName.networkCode;
      this.bandwidthGroup = bandwidthGroupName.bandwidthGroup;
    }

    public BandwidthGroupName build() {
      return new BandwidthGroupName(this);
    }
  }
}
