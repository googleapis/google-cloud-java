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
public class CreativeSetName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CREATIVE_SET =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/creativeSets/{creative_set}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String creativeSet;

  @Deprecated
  protected CreativeSetName() {
    networkCode = null;
    creativeSet = null;
  }

  private CreativeSetName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    creativeSet = Preconditions.checkNotNull(builder.getCreativeSet());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCreativeSet() {
    return creativeSet;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CreativeSetName of(String networkCode, String creativeSet) {
    return newBuilder().setNetworkCode(networkCode).setCreativeSet(creativeSet).build();
  }

  public static String format(String networkCode, String creativeSet) {
    return newBuilder().setNetworkCode(networkCode).setCreativeSet(creativeSet).build().toString();
  }

  public static @Nullable CreativeSetName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CREATIVE_SET.validatedMatch(
            formattedString, "CreativeSetName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("creative_set"));
  }

  public static List<CreativeSetName> parseList(List<String> formattedStrings) {
    List<CreativeSetName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable CreativeSetName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CreativeSetName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CREATIVE_SET.matches(formattedString);
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
          if (creativeSet != null) {
            fieldMapBuilder.put("creative_set", creativeSet);
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
    return NETWORK_CODE_CREATIVE_SET.instantiate(
        "network_code", networkCode, "creative_set", creativeSet);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CreativeSetName that = ((CreativeSetName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.creativeSet, that.creativeSet);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(creativeSet);
    return h;
  }

  /** Builder for networks/{network_code}/creativeSets/{creative_set}. */
  public static class Builder {
    private String networkCode;
    private String creativeSet;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCreativeSet() {
      return creativeSet;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCreativeSet(String creativeSet) {
      this.creativeSet = creativeSet;
      return this;
    }

    private Builder(CreativeSetName creativeSetName) {
      this.networkCode = creativeSetName.networkCode;
      this.creativeSet = creativeSetName.creativeSet;
    }

    public CreativeSetName build() {
      return new CreativeSetName(this);
    }
  }
}
