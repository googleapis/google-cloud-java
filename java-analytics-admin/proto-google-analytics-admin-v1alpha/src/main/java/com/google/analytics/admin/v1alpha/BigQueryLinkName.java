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
public class BigQueryLinkName implements ResourceName {
  private static final PathTemplate PROPERTY_BIGQUERY_LINK =
      PathTemplate.createWithoutUrlEncoding("properties/{property}/bigQueryLinks/{bigquery_link}");
  private volatile Map<String, String> fieldValuesMap;
  private final String property;
  private final String bigqueryLink;

  @Deprecated
  protected BigQueryLinkName() {
    property = null;
    bigqueryLink = null;
  }

  private BigQueryLinkName(Builder builder) {
    property = Preconditions.checkNotNull(builder.getProperty());
    bigqueryLink = Preconditions.checkNotNull(builder.getBigqueryLink());
  }

  public String getProperty() {
    return property;
  }

  public String getBigqueryLink() {
    return bigqueryLink;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BigQueryLinkName of(String property, String bigqueryLink) {
    return newBuilder().setProperty(property).setBigqueryLink(bigqueryLink).build();
  }

  public static String format(String property, String bigqueryLink) {
    return newBuilder().setProperty(property).setBigqueryLink(bigqueryLink).build().toString();
  }

  public static BigQueryLinkName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROPERTY_BIGQUERY_LINK.validatedMatch(
            formattedString, "BigQueryLinkName.parse: formattedString not in valid format");
    return of(matchMap.get("property"), matchMap.get("bigquery_link"));
  }

  public static List<BigQueryLinkName> parseList(List<String> formattedStrings) {
    List<BigQueryLinkName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BigQueryLinkName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BigQueryLinkName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROPERTY_BIGQUERY_LINK.matches(formattedString);
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
          if (bigqueryLink != null) {
            fieldMapBuilder.put("bigquery_link", bigqueryLink);
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
    return PROPERTY_BIGQUERY_LINK.instantiate("property", property, "bigquery_link", bigqueryLink);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BigQueryLinkName that = ((BigQueryLinkName) o);
      return Objects.equals(this.property, that.property)
          && Objects.equals(this.bigqueryLink, that.bigqueryLink);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(property);
    h *= 1000003;
    h ^= Objects.hashCode(bigqueryLink);
    return h;
  }

  /** Builder for properties/{property}/bigQueryLinks/{bigquery_link}. */
  public static class Builder {
    private String property;
    private String bigqueryLink;

    protected Builder() {}

    public String getProperty() {
      return property;
    }

    public String getBigqueryLink() {
      return bigqueryLink;
    }

    public Builder setProperty(String property) {
      this.property = property;
      return this;
    }

    public Builder setBigqueryLink(String bigqueryLink) {
      this.bigqueryLink = bigqueryLink;
      return this;
    }

    private Builder(BigQueryLinkName bigQueryLinkName) {
      this.property = bigQueryLinkName.property;
      this.bigqueryLink = bigQueryLinkName.bigqueryLink;
    }

    public BigQueryLinkName build() {
      return new BigQueryLinkName(this);
    }
  }
}
