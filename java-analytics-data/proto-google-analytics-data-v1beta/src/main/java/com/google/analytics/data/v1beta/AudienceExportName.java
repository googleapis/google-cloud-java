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

package com.google.analytics.data.v1beta;

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
public class AudienceExportName implements ResourceName {
  private static final PathTemplate PROPERTY_AUDIENCE_EXPORT =
      PathTemplate.createWithoutUrlEncoding(
          "properties/{property}/audienceExports/{audience_export}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String audienceExport;

  @Deprecated
  protected AudienceExportName() {
    property = null;
    audienceExport = null;
  }

  private AudienceExportName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    audienceExport = Preconditions.checkNotNull(builder.getAudienceExport());
  }

  public String getProperty() {
    return property;
  }

  public String getAudienceExport() {
    return audienceExport;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AudienceExportName of(String property, String audienceExport) {
    return newBuilder().setProperty(property).setAudienceExport(audienceExport).build();
  }

  public static String format(String property, String audienceExport) {
    return newBuilder().setProperty(property).setAudienceExport(audienceExport).build().toString();
  }

  public static AudienceExportName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_AUDIENCE_EXPORT.validatedMatch(
            formattedString, "AudienceExportName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("audience_export"));
  }

  public static List<AudienceExportName> parseList(List<String> formattedStrings) {
    List<AudienceExportName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AudienceExportName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AudienceExportName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_AUDIENCE_EXPORT.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (property != null) {
            fieldMapBuilder.put("property", property);
          }
          if (audienceExport != null) {
            fieldMapBuilder.put("audience_export", audienceExport);
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
    return PROPERTY_AUDIENCE_EXPORT.instantiate(
        "property", property, "audience_export", audienceExport);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AudienceExportName that = ((AudienceExportName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.audienceExport, that.audienceExport);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(audienceExport);
    return h;
  }

  /** Builder for properties/{property}/audienceExports/{audience_export}. */
  public static class Builder {
    private String property;
    private String audienceExport;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getAudienceExport() {
      return audienceExport;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setAudienceExport(String audienceExport) {
      this.audienceExport = audienceExport;
      return this;
    }

    private Builder(AudienceExportName audienceExportName) {
      this.property = audienceExportName.property;
      this.audienceExport = audienceExportName.audienceExport;
    }

    public AudienceExportName build() {
      return new AudienceExportName(this);
    }
  }
}
