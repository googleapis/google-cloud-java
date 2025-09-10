/*
 * Copyright 2025 Google LLC
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

package com.google.shopping.merchant.accounts.v1;

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
public class TermsOfServiceName implements ResourceName {
  private static final PathTemplate VERSION =
      PathTemplate.createWithoutUrlEncoding("termsOfService/{version}");
  private volatile Map<String, String> fieldValuesMap;
  private final String version;

  @Deprecated
  protected TermsOfServiceName() {
    version = null;
  }

  private TermsOfServiceName(Builder builder) {
    version = Preconditions.checkNotNull(builder.getVersion());
  }

  public String getVersion() {
    return version;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TermsOfServiceName of(String version) {
    return newBuilder().setVersion(version).build();
  }

  public static String format(String version) {
    return newBuilder().setVersion(version).build().toString();
  }

  public static TermsOfServiceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        VERSION.validatedMatch(
            formattedString, "TermsOfServiceName.parse: formattedString not in valid format");
    return of(matchMap.get("version"));
  }

  public static List<TermsOfServiceName> parseList(List<String> formattedStrings) {
    List<TermsOfServiceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TermsOfServiceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TermsOfServiceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return VERSION.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (version != null) {
            fieldMapBuilder.put("version", version);
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
    return VERSION.instantiate("version", version);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TermsOfServiceName that = ((TermsOfServiceName) o);
      return Objects.equals(this.version, that.version);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(version);
    return h;
  }

  /** Builder for termsOfService/{version}. */
  public static class Builder {
    private String version;

    protected Builder() {}

    public String getVersion() {
      return version;
    }

    public Builder setVersion(String version) {
      this.version = version;
      return this;
    }

    private Builder(TermsOfServiceName termsOfServiceName) {
      this.version = termsOfServiceName.version;
    }

    public TermsOfServiceName build() {
      return new TermsOfServiceName(this);
    }
  }
}
