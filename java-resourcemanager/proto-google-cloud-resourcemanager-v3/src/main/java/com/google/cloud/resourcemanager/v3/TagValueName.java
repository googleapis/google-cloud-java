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

package com.google.cloud.resourcemanager.v3;

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
public class TagValueName implements ResourceName {
  private static final PathTemplate TAG_VALUE =
      PathTemplate.createWithoutUrlEncoding("tagValues/{tag_value}");
  private volatile Map<String, String> fieldValuesMap;
  private final String tagValue;

  @Deprecated
  protected TagValueName() {
    tagValue = null;
  }

  private TagValueName(Builder builder) {
    tagValue = Preconditions.checkNotNull(builder.getTagValue());
  }

  public String getTagValue() {
    return tagValue;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagValueName of(String tagValue) {
    return newBuilder().setTagValue(tagValue).build();
  }

  public static String format(String tagValue) {
    return newBuilder().setTagValue(tagValue).build().toString();
  }

  public static TagValueName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        TAG_VALUE.validatedMatch(
            formattedString, "TagValueName.parse: formattedString not in valid format");
    return of(matchMap.get("tag_value"));
  }

  public static List<TagValueName> parseList(List<String> formattedStrings) {
    List<TagValueName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagValueName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagValueName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return TAG_VALUE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (tagValue != null) {
            fieldMapBuilder.put("tag_value", tagValue);
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
    return TAG_VALUE.instantiate("tag_value", tagValue);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagValueName that = ((TagValueName) o);
      return Objects.equals(this.tagValue, that.tagValue);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(tagValue);
    return h;
  }

  /** Builder for tagValues/{tag_value}. */
  public static class Builder {
    private String tagValue;

    protected Builder() {}

    public String getTagValue() {
      return tagValue;
    }

    public Builder setTagValue(String tagValue) {
      this.tagValue = tagValue;
      return this;
    }

    private Builder(TagValueName tagValueName) {
      this.tagValue = tagValueName.tagValue;
    }

    public TagValueName build() {
      return new TagValueName(this);
    }
  }
}
