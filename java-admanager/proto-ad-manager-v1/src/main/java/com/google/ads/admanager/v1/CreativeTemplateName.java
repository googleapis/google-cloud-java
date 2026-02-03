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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@Generated("by gapic-generator-java")
public class CreativeTemplateName implements ResourceName {
  private static final PathTemplate NETWORK_CODE_CREATIVE_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "networks/{network_code}/creativeTemplates/{creative_template}");
  private volatile Map<String, String> fieldValuesMap;
  private final String networkCode;
  private final String creativeTemplate;

  @Deprecated
  protected CreativeTemplateName() {
    networkCode = null;
    creativeTemplate = null;
  }

  private CreativeTemplateName(Builder builder) {
    networkCode = Preconditions.checkNotNull(builder.getNetworkCode());
    creativeTemplate = Preconditions.checkNotNull(builder.getCreativeTemplate());
  }

  public String getNetworkCode() {
    return networkCode;
  }

  public String getCreativeTemplate() {
    return creativeTemplate;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CreativeTemplateName of(String networkCode, String creativeTemplate) {
    return newBuilder().setNetworkCode(networkCode).setCreativeTemplate(creativeTemplate).build();
  }

  public static String format(String networkCode, String creativeTemplate) {
    return newBuilder()
        .setNetworkCode(networkCode)
        .setCreativeTemplate(creativeTemplate)
        .build()
        .toString();
  }

  public static CreativeTemplateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        NETWORK_CODE_CREATIVE_TEMPLATE.validatedMatch(
            formattedString, "CreativeTemplateName.parse: formattedString not in valid format");
    return of(matchMap.get("network_code"), matchMap.get("creative_template"));
  }

  public static List<CreativeTemplateName> parseList(List<String> formattedStrings) {
    List<CreativeTemplateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CreativeTemplateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CreativeTemplateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return NETWORK_CODE_CREATIVE_TEMPLATE.matches(formattedString);
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
          if (creativeTemplate != null) {
            fieldMapBuilder.put("creative_template", creativeTemplate);
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
    return NETWORK_CODE_CREATIVE_TEMPLATE.instantiate(
        "network_code", networkCode, "creative_template", creativeTemplate);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CreativeTemplateName that = ((CreativeTemplateName) o);
      return Objects.equals(this.networkCode, that.networkCode)
          && Objects.equals(this.creativeTemplate, that.creativeTemplate);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(networkCode);
    h *= 1000003;
    h ^= Objects.hashCode(creativeTemplate);
    return h;
  }

  /** Builder for networks/{network_code}/creativeTemplates/{creative_template}. */
  public static class Builder {
    private String networkCode;
    private String creativeTemplate;

    protected Builder() {}

    public String getNetworkCode() {
      return networkCode;
    }

    public String getCreativeTemplate() {
      return creativeTemplate;
    }

    public Builder setNetworkCode(String networkCode) {
      this.networkCode = networkCode;
      return this;
    }

    public Builder setCreativeTemplate(String creativeTemplate) {
      this.creativeTemplate = creativeTemplate;
      return this;
    }

    private Builder(CreativeTemplateName creativeTemplateName) {
      this.networkCode = creativeTemplateName.networkCode;
      this.creativeTemplate = creativeTemplateName.creativeTemplate;
    }

    public CreativeTemplateName build() {
      return new CreativeTemplateName(this);
    }
  }
}
