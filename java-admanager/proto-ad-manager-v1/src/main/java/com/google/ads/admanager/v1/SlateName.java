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
public class SlateName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_SLATE =
      PathTemplate.createWithoutUrlEncoding("networks/{network_code}/slates/{slate}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String slate;

  @Deprecated
  protected SlateName() {
    networkCode = null;
    slate = null;
  }

  private SlateName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    slate = Preconditions.checkNotNull(builder.getSlate());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getSlate() {
    return slate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SlateName of(String networkCode, String slate) {
    return newBuilder().setNetworkCode(networkCode).setSlate(slate).build();
  }

  public static String format(String networkCode, String slate) {
    return newBuilder().setNetworkCode(networkCode).setSlate(slate).build().toString();
  }

  public static @Nullable SlateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_SLATE.validatedMatch(
            formattedString, "SlateName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("slate"));
  }

  public static List<SlateName> parseList(List<String> formattedStrings) {
    List<SlateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable SlateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SlateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_SLATE.matches(formattedString);
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
          if (slate != null) {
            fieldMapBuilder.put("slate", slate);
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
    return NETWORK_CODE_SLATE.instantiate("network_code", networkCode, "slate", slate);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SlateName that = ((SlateName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.slate, that.slate);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(slate);
    return h;
  }

  /** Builder for networks/{network_code}/slates/{slate}. */
  public static class Builder {
    private String networkCode;
    private String slate;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getSlate() {
      return slate;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setSlate(String slate) {
      this.slate = slate;
      return this;
    }

    private Builder(SlateName slateName) {
      this.networkCode = slateName.networkCode;
      this.slate = slateName.slate;
    }

    public SlateName build() {
      return new SlateName(this);
    }
  }
}
