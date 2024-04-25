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
public class LineItemName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_ORDER_LINE_ITEM =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/orders/{order}/lineItems/{line_item}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String order;
  private final String lineItem;

  @Deprecated
  protected LineItemName() {
    networkCode = null;
    order = null;
    lineItem = null;
  }

  private LineItemName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    order = Preconditions.checkNotNull(builder.getOrder());
    lineItem = Preconditions.checkNotNull(builder.getLineItem());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getOrder() {
    return order;
  }

  public String getLineItem() {
    return lineItem;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LineItemName of(String networkCode, String order, String lineItem) {
    return newBuilder().setNetworkCode(networkCode).setOrder(order).setLineItem(lineItem).build();
  }

  public static String format(String networkCode, String order, String lineItem) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setOrder(order)
        .setLineItem(lineItem)
        .build()
        .toString();
  }

  public static LineItemName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_ORDER_LINE_ITEM.validatedMatch(
            formattedString, "LineItemName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("order"), matchMap.get("line_item"));
  }

  public static List<LineItemName> parseList(List<String> formattedStrings) {
    List<LineItemName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<LineItemName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LineItemName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_ORDER_LINE_ITEM.matches(formattedString);
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
          if (order != null) {
            fieldMapBuilder.put("order", order);
          }
          if (lineItem != null) {
            fieldMapBuilder.put("line_item", lineItem);
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
    return NETWORK_CODE_ORDER_LINE_ITEM.instantiate(
        "network_code", networkCode, "order", order, "line_item", lineItem);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LineItemName that = ((LineItemName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.order, that.order)
          && Objects.equals(this.lineItem, that.lineItem);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(order);
    h *= 1000003;
    h ^= Objects.hashCode(lineItem);
    return h;
  }

  /** Builder for networks/{network_code}/orders/{order}/lineItems/{line_item}. */
  public static class Builder {
    private String networkCode;
    private String order;
    private String lineItem;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getOrder() {
      return order;
    }

    public String getLineItem() {
      return lineItem;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setOrder(String order) {
      this.order = order;
      return this;
    }

    public Builder setLineItem(String lineItem) {
      this.lineItem = lineItem;
      return this;
    }

    private Builder(LineItemName lineItemName) {
      this.networkCode = lineItemName.networkCode;
      this.order = lineItemName.order;
      this.lineItem = lineItemName.lineItem;
    }

    public LineItemName build() {
      return new LineItemName(this);
    }
  }
}
