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
public class LineItemCreativeAssociationName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_LINE_ITEM_CREATIVE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/lineItems/{line_item}/creatives/{creative}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String lineItem;
  private final String creative;

  @Deprecated
  protected LineItemCreativeAssociationName() {
    networkCode = null;
    lineItem = null;
    creative = null;
  }

  private LineItemCreativeAssociationName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    lineItem = Preconditions.checkNotNull(builder.getLineItem());
    creative = Preconditions.checkNotNull(builder.getCreative());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getLineItem() {
    return lineItem;
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

  public static LineItemCreativeAssociationName of(
      String networkCode, String lineItem, String creative) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setLineItem(lineItem)
        .setCreative(creative)
        .build();
  }

  public static String format(String networkCode, String lineItem, String creative) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setLineItem(lineItem)
        .setCreative(creative)
        .build()
        .toString();
  }

  public static @Nullable LineItemCreativeAssociationName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_LINE_ITEM_CREATIVE.validatedMatch(
            formattedString,
            "LineItemCreativeAssociationName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("line_item"), matchMap.get("creative"));
  }

  public static List<LineItemCreativeAssociationName> parseList(List<String> formattedStrings) {
    List<LineItemCreativeAssociationName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable LineItemCreativeAssociationName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LineItemCreativeAssociationName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_LINE_ITEM_CREATIVE.matches(formattedString);
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
          if (lineItem != null) {
            fieldMapBuilder.put("line_item", lineItem);
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
    return NETWORK_CODE_LINE_ITEM_CREATIVE.instantiate(
        "network_code", networkCode, "line_item", lineItem, "creative", creative);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LineItemCreativeAssociationName that = ((LineItemCreativeAssociationName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.lineItem, that.lineItem)
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
    h ^= Objects.hashCode(lineItem);
    h *= 1000003;
    h ^= Objects.hashCode(creative);
    return h;
  }

  /** Builder for networks/{network_code}/lineItems/{line_item}/creatives/{creative}. */
  public static class Builder {
    private String networkCode;
    private String lineItem;
    private String creative;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getLineItem() {
      return lineItem;
    }

    public String getCreative() {
      return creative;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setLineItem(String lineItem) {
      this.lineItem = lineItem;
      return this;
    }

    public Builder setCreative(String creative) {
      this.creative = creative;
      return this;
    }

    private Builder(LineItemCreativeAssociationName lineItemCreativeAssociationName) {
      this.networkCode = lineItemCreativeAssociationName.networkCode;
      this.lineItem = lineItemCreativeAssociationName.lineItem;
      this.creative = lineItemCreativeAssociationName.creative;
    }

    public LineItemCreativeAssociationName build() {
      return new LineItemCreativeAssociationName(this);
    }
  }
}
