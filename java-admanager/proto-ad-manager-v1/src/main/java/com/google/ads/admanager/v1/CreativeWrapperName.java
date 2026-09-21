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
public class CreativeWrapperName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CREATIVE_WRAPPER =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/creativeWrappers/{creative_wrapper}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String creativeWrapper;

  @Deprecated
  protected CreativeWrapperName() {
    networkCode = null;
    creativeWrapper = null;
  }

  private CreativeWrapperName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    creativeWrapper = Preconditions.checkNotNull(builder.getCreativeWrapper());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCreativeWrapper() {
    return creativeWrapper;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CreativeWrapperName of(String networkCode, String creativeWrapper) {
    return newBuilder().setNetworkCode(networkCode).setCreativeWrapper(creativeWrapper).build();
  }

  public static String format(String networkCode, String creativeWrapper) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCreativeWrapper(creativeWrapper)
        .build()
        .toString();
  }

  public static @Nullable CreativeWrapperName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CREATIVE_WRAPPER.validatedMatch(
            formattedString, "CreativeWrapperName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("creative_wrapper"));
  }

  public static List<CreativeWrapperName> parseList(List<String> formattedStrings) {
    List<CreativeWrapperName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable CreativeWrapperName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CreativeWrapperName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CREATIVE_WRAPPER.matches(formattedString);
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
          if (creativeWrapper != null) {
            fieldMapBuilder.put("creative_wrapper", creativeWrapper);
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
    return NETWORK_CODE_CREATIVE_WRAPPER.instantiate(
        "network_code", networkCode, "creative_wrapper", creativeWrapper);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CreativeWrapperName that = ((CreativeWrapperName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.creativeWrapper, that.creativeWrapper);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(creativeWrapper);
    return h;
  }

  /** Builder for networks/{network_code}/creativeWrappers/{creative_wrapper}. */
  public static class Builder {
    private String networkCode;
    private String creativeWrapper;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCreativeWrapper() {
      return creativeWrapper;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCreativeWrapper(String creativeWrapper) {
      this.creativeWrapper = creativeWrapper;
      return this;
    }

    private Builder(CreativeWrapperName creativeWrapperName) {
      this.networkCode = creativeWrapperName.networkCode;
      this.creativeWrapper = creativeWrapperName.creativeWrapper;
    }

    public CreativeWrapperName build() {
      return new CreativeWrapperName(this);
    }
  }
}
