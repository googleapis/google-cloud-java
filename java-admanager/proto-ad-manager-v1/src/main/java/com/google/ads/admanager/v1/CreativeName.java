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
public class CreativeName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CREATIVE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/creatives/{creative}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String creative;

  @Deprecated
  protected CreativeName() {
    networkCode = null;
    creative = null;
  }

  private CreativeName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    creative = Preconditions.checkNotNull(builder.getCreative());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCreative() {
    return creative;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CreativeName of(String networkCode, String creative) {
    return newBuilder().setNetworkCode(networkCode).setCreative(creative).build();
  }

  public static String format(String networkCode, String creative) {
    return newBuilder().setNetworkCode(networkCode).setCreative(creative).build().toString();
  }

  public static CreativeName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CREATIVE.validatedMatch(
            formattedString, "CreativeName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("creative"));
  }

  public static List<CreativeName> parseList(List<String> formattedStrings) {
    List<CreativeName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CreativeName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CreativeName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CREATIVE.matches(formattedString);
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
          if (creative != null) {
            fieldMapBuilder.put("creative", creative);
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
    return NETWORK_CODE_CREATIVE.instantiate("network_code", networkCode, "creative", creative);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CreativeName that = ((CreativeName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.creative, that.creative);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(creative);
    return h;
  }

  /** Builder for networks/{network_code}/creatives/{creative}. */
  public static class Builder {
    private String networkCode;
    private String creative;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCreative() {
      return creative;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCreative(String creative) {
      this.creative = creative;
      return this;
    }

    private Builder(CreativeName creativeName) {
      this.networkCode = creativeName.networkCode;
      this.creative = creativeName.creative;
    }

    public CreativeName build() {
      return new CreativeName(this);
    }
  }
}
