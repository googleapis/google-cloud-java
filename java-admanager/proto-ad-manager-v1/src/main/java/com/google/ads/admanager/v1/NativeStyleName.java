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
public class NativeStyleName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_NATIVE_STYLE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/nativeStyles/{native_style}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String nativeStyle;

  @Deprecated
  protected NativeStyleName() {
    networkCode = null;
    nativeStyle = null;
  }

  private NativeStyleName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    nativeStyle = Preconditions.checkNotNull(builder.getNativeStyle());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getNativeStyle() {
    return nativeStyle;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static NativeStyleName of(String networkCode, String nativeStyle) {
    return newBuilder().setNetworkCode(networkCode).setNativeStyle(nativeStyle).build();
  }

  public static String format(String networkCode, String nativeStyle) {
    return newBuilder().setNetworkCode(networkCode).setNativeStyle(nativeStyle).build().toString();
  }

  public static @Nullable NativeStyleName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_NATIVE_STYLE.validatedMatch(
            formattedString, "NativeStyleName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("native_style"));
  }

  public static List<NativeStyleName> parseList(List<String> formattedStrings) {
    List<NativeStyleName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable NativeStyleName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (NativeStyleName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_NATIVE_STYLE.matches(formattedString);
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
          if (nativeStyle != null) {
            fieldMapBuilder.put("native_style", nativeStyle);
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
    return NETWORK_CODE_NATIVE_STYLE.instantiate(
        "network_code", networkCode, "native_style", nativeStyle);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      NativeStyleName that = ((NativeStyleName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.nativeStyle, that.nativeStyle);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(nativeStyle);
    return h;
  }

  /** Builder for networks/{network_code}/nativeStyles/{native_style}. */
  public static class Builder {
    private String networkCode;
    private String nativeStyle;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getNativeStyle() {
      return nativeStyle;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setNativeStyle(String nativeStyle) {
      this.nativeStyle = nativeStyle;
      return this;
    }

    private Builder(NativeStyleName nativeStyleName) {
      this.networkCode = nativeStyleName.networkCode;
      this.nativeStyle = nativeStyleName.nativeStyle;
    }

    public NativeStyleName build() {
      return new NativeStyleName(this);
    }
  }
}
