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
public class TagKeyName implements ResourceName {
  private static final PathTemplate TAG_KEY =
      PathTemplate.createWithoutUrlEncoding("tagKeys/{tag_key}");
  private volatile Map<String, String> fieldValuesMap;
  private final String tagKey;

  @Deprecated
  protected TagKeyName() {
    tagKey = null;
  }

  private TagKeyName(Builder builder) {
    tagKey = Preconditions.checkNotNull(builder.getTagKey());
  }

  public String getTagKey() {
    return tagKey;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagKeyName of(String tagKey) {
    return newBuilder().setTagKey(tagKey).build();
  }

  public static String format(String tagKey) {
    return newBuilder().setTagKey(tagKey).build().toString();
  }

  public static TagKeyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        TAG_KEY.validatedMatch(
            formattedString, "TagKeyName.parse: formattedString not in valid format");
    return of(matchMap.get("tag_key"));
  }

  public static List<TagKeyName> parseList(List<String> formattedStrings) {
    List<TagKeyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagKeyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagKeyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return TAG_KEY.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (tagKey != null) {
            fieldMapBuilder.put("tag_key", tagKey);
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
    return TAG_KEY.instantiate("tag_key", tagKey);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagKeyName that = ((TagKeyName) o);
      return Objects.equals(this.tagKey, that.tagKey);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(tagKey);
    return h;
  }

  /** Builder for tagKeys/{tag_key}. */
  public static class Builder {
    private String tagKey;

    protected Builder() {}

    public String getTagKey() {
      return tagKey;
    }

    public Builder setTagKey(String tagKey) {
      this.tagKey = tagKey;
      return this;
    }

    private Builder(TagKeyName tagKeyName) {
      this.tagKey = tagKeyName.tagKey;
    }

    public TagKeyName build() {
      return new TagKeyName(this);
    }
  }
}
