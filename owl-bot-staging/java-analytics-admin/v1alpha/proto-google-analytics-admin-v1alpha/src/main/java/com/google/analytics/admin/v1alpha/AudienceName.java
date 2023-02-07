/*
 * Copyright 2022 Google LLC
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

package com.google.analytics.admin.v1alpha;

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
public class AudienceName implements ResourceName {
  private static final PathTemplate PROPERTY_AUDIENCE =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/audiences/{audience}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String audience;

  @Deprecated
  protected AudienceName() {
    property = null;
    audience = null;
  }

  private AudienceName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    audience = Preconditions.checkNotNull(builder.getAudience());
  }

  public String getProperty() {
    return property;
  }

  public String getAudience() {
    return audience;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AudienceName of(String property, String audience) {
    return newBuilder().setProperty(property).setAudience(audience).build();
  }

  public static String format(String property, String audience) {
    return newBuilder().setProperty(property).setAudience(audience).build().toString();
  }

  public static AudienceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_AUDIENCE.validatedMatch(
            formattedString, "AudienceName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("audience"));
  }

  public static List<AudienceName> parseList(List<String> formattedStrings) {
    List<AudienceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AudienceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AudienceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_AUDIENCE.matches(formattedString);
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
          if (audience != null) {
            fieldMapBuilder.put("audience", audience);
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
    return PROPERTY_AUDIENCE.instantiate("property", property, "audience", audience);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      AudienceName that = ((AudienceName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.audience, that.audience);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(audience);
    return h;
  }

  /** Builder for properties/{property}/audiences/{audience}. */
  public static class Builder {
    private String property;
    private String audience;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getAudience() {
      return audience;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setAudience(String audience) {
      this.audience = audience;
      return this;
    }

    private Builder(AudienceName audienceName) {
      this.property = audienceName.property;
      this.audience = audienceName.audience;
    }

    public AudienceName build() {
      return new AudienceName(this);
    }
  }
}
