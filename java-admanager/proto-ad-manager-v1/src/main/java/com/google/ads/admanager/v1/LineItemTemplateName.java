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
public class LineItemTemplateName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_LINE_ITEM_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/lineItemTemplates/{line_item_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String lineItemTemplate;

  @Deprecated
  protected LineItemTemplateName() {
    networkCode = null;
    lineItemTemplate = null;
  }

  private LineItemTemplateName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    lineItemTemplate = Preconditions.checkNotNull(builder.getLineItemTemplate());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getLineItemTemplate() {
    return lineItemTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static LineItemTemplateName of(String networkCode, String lineItemTemplate) {
    return newBuilder().setNetworkCode(networkCode).setLineItemTemplate(lineItemTemplate).build();
  }

  public static String format(String networkCode, String lineItemTemplate) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setLineItemTemplate(lineItemTemplate)
        .build()
        .toString();
  }

  public static @Nullable LineItemTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_LINE_ITEM_TEMPLATE.validatedMatch(
            formattedString, "LineItemTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("line_item_template"));
  }

  public static List<LineItemTemplateName> parseList(List<String> formattedStrings) {
    List<LineItemTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable LineItemTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (LineItemTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_LINE_ITEM_TEMPLATE.matches(formattedString);
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
          if (lineItemTemplate != null) {
            fieldMapBuilder.put("line_item_template", lineItemTemplate);
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
    return NETWORK_CODE_LINE_ITEM_TEMPLATE.instantiate(
        "network_code", networkCode, "line_item_template", lineItemTemplate);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      LineItemTemplateName that = ((LineItemTemplateName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.lineItemTemplate, that.lineItemTemplate);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(lineItemTemplate);
    return h;
  }

  /** Builder for networks/{network_code}/lineItemTemplates/{line_item_template}. */
  public static class Builder {
    private String networkCode;
    private String lineItemTemplate;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getLineItemTemplate() {
      return lineItemTemplate;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setLineItemTemplate(String lineItemTemplate) {
      this.lineItemTemplate = lineItemTemplate;
      return this;
    }

    private Builder(LineItemTemplateName lineItemTemplateName) {
      this.networkCode = lineItemTemplateName.networkCode;
      this.lineItemTemplate = lineItemTemplateName.lineItemTemplate;
    }

    public LineItemTemplateName build() {
      return new LineItemTemplateName(this);
    }
  }
}
