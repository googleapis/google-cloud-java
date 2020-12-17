/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.securitycenter.v1p1beta1;

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
public class SourceName implements ResourceName {
  private static final PathTemplate ORGANIZATION_SOURCE =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/sources/{source}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String source;

  @Deprecated
  protected SourceName() {
    organization = null;
    source = null;
  }

  private SourceName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    source = Preconditions.checkNotNull(builder.getSource());
  }

  public String getOrganization() {
    return organization;
  }

  public String getSource() {
    return source;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SourceName of(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build();
  }

  public static String format(String organization, String source) {
    return newBuilder().setOrganization(organization).setSource(source).build().toString();
  }

  public static SourceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_SOURCE.validatedMatch(
            formattedString, "SourceName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("source"));
  }

  public static List<SourceName> parseList(List<String> formattedStrings) {
    List<SourceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SourceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SourceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_SOURCE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (source != null) {
            fieldMapBuilder.put("source", source);
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
    return ORGANIZATION_SOURCE.instantiate("organization", organization, "source", source);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      SourceName that = ((SourceName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.source, that.source);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(source);
    return h;
  }

  /** Builder for organizations/{organization}/sources/{source}. */
  public static class Builder {
    private String organization;
    private String source;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getSource() {
      return source;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setSource(String source) {
      this.source = source;
      return this;
    }

    private Builder(SourceName sourceName) {
      organization = sourceName.organization;
      source = sourceName.source;
    }

    public SourceName build() {
      return new SourceName(this);
    }
  }
}
