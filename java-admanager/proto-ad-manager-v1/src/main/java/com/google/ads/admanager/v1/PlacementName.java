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
public class PlacementName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_PLACEMENT =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/placements/{placement}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String placement;

  @Deprecated
  protected PlacementName() {
    networkCode = null;
    placement = null;
  }

  private PlacementName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    placement = Preconditions.checkNotNull(builder.getPlacement());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getPlacement() {
    return placement;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static PlacementName of(String networkCode, String placement) {
    return newBuilder().setNetworkCode(networkCode).setPlacement(placement).build();
  }

  public static String format(String networkCode, String placement) {
    return newBuilder().setNetworkCode(networkCode).setPlacement(placement).build().toString();
  }

  public static PlacementName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_PLACEMENT.validatedMatch(
            formattedString, "PlacementName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("placement"));
  }

  public static List<PlacementName> parseList(List<String> formattedStrings) {
    List<PlacementName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<PlacementName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (PlacementName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_PLACEMENT.matches(formattedString);
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
          if (placement != null) {
            fieldMapBuilder.put("placement", placement);
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
    return NETWORK_CODE_PLACEMENT.instantiate("network_code", networkCode, "placement", placement);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      PlacementName that = ((PlacementName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.placement, that.placement);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(placement);
    return h;
  }

  /** Builder for networks/{network_code}/placements/{placement}. */
  public static class Builder {
    private String networkCode;
    private String placement;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getPlacement() {
      return placement;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setPlacement(String placement) {
      this.placement = placement;
      return this;
    }

    private Builder(PlacementName placementName) {
      this.networkCode = placementName.networkCode;
      this.placement = placementName.placement;
    }

    public PlacementName build() {
      return new PlacementName(this);
    }
  }
}
