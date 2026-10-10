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
public class BreakTemplateName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_BREAK_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/breakTemplates/{break_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String breakTemplate;

  @Deprecated
  protected BreakTemplateName() {
    networkCode = null;
    breakTemplate = null;
  }

  private BreakTemplateName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    breakTemplate = Preconditions.checkNotNull(builder.getBreakTemplate());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getBreakTemplate() {
    return breakTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BreakTemplateName of(String networkCode, String breakTemplate) {
    return newBuilder().setNetworkCode(networkCode).setBreakTemplate(breakTemplate).build();
  }

  public static String format(String networkCode, String breakTemplate) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setBreakTemplate(breakTemplate)
        .build()
        .toString();
  }

  public static @Nullable BreakTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_BREAK_TEMPLATE.validatedMatch(
            formattedString, "BreakTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("break_template"));
  }

  public static List<BreakTemplateName> parseList(List<String> formattedStrings) {
    List<BreakTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable BreakTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BreakTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_BREAK_TEMPLATE.matches(formattedString);
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
          if (breakTemplate != null) {
            fieldMapBuilder.put("break_template", breakTemplate);
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
    return NETWORK_CODE_BREAK_TEMPLATE.instantiate(
        "network_code", networkCode, "break_template", breakTemplate);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BreakTemplateName that = ((BreakTemplateName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.breakTemplate, that.breakTemplate);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(breakTemplate);
    return h;
  }

  /** Builder for networks/{network_code}/breakTemplates/{break_template}. */
  public static class Builder {
    private String networkCode;
    private String breakTemplate;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getBreakTemplate() {
      return breakTemplate;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setBreakTemplate(String breakTemplate) {
      this.breakTemplate = breakTemplate;
      return this;
    }

    private Builder(BreakTemplateName breakTemplateName) {
      this.networkCode = breakTemplateName.networkCode;
      this.breakTemplate = breakTemplateName.breakTemplate;
    }

    public BreakTemplateName build() {
      return new BreakTemplateName(this);
    }
  }
}
