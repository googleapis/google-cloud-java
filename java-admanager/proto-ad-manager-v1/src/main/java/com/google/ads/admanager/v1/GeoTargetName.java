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
public class GeoTargetName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_GEO_TARGET =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/geoTargets/{geo_target}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String geoTarget;

  @Deprecated
  protected GeoTargetName() {
    networkCode = null;
    geoTarget = null;
  }

  private GeoTargetName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    geoTarget = Preconditions.checkNotNull(builder.getGeoTarget());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getGeoTarget() {
    return geoTarget;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GeoTargetName of(String networkCode, String geoTarget) {
    return newBuilder().setNetworkCode(networkCode).setGeoTarget(geoTarget).build();
  }

  public static String format(String networkCode, String geoTarget) {
    return newBuilder().setNetworkCode(networkCode).setGeoTarget(geoTarget).build().toString();
  }

  public static GeoTargetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_GEO_TARGET.validatedMatch(
            formattedString, "GeoTargetName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("geo_target"));
  }

  public static List<GeoTargetName> parseList(List<String> formattedStrings) {
    List<GeoTargetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GeoTargetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GeoTargetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_GEO_TARGET.matches(formattedString);
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
          if (geoTarget != null) {
            fieldMapBuilder.put("geo_target", geoTarget);
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
    return NETWORK_CODE_GEO_TARGET.instantiate(
        "network_code", networkCode, "geo_target", geoTarget);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      GeoTargetName that = ((GeoTargetName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.geoTarget, that.geoTarget);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(geoTarget);
    return h;
  }

  /** Builder for networks/{network_code}/geoTargets/{geo_target}. */
  public static class Builder {
    private String networkCode;
    private String geoTarget;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getGeoTarget() {
      return geoTarget;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setGeoTarget(String geoTarget) {
      this.geoTarget = geoTarget;
      return this;
    }

    private Builder(GeoTargetName geoTargetName) {
      this.networkCode = geoTargetName.networkCode;
      this.geoTarget = geoTargetName.geoTarget;
    }

    public GeoTargetName build() {
      return new GeoTargetName(this);
    }
  }
}
