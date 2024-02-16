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
public class TagHoldName implements ResourceName {
  private static final PathTemplate TAG_VALUE_TAG_HOLD =
      PathTemplate.createWithoutUrlEncoding("tagValues/{tag_value}/tagHolds/{tag_hold}");
  private volatile Map<String, String> fieldValuesMap;
  private final String tagValue;
  private final String tagHold;

  @Deprecated
  protected TagHoldName() {
    tagValue = null;
    tagHold = null;
  }

  private TagHoldName(Builder builder) {
    tagValue = Preconditions.checkNotNull(builder.getTagValue());
    tagHold = Preconditions.checkNotNull(builder.getTagHold());
  }

  public String getTagValue() {
    return tagValue;
  }

  public String getTagHold() {
    return tagHold;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagHoldName of(String tagValue, String tagHold) {
    return newBuilder().setTagValue(tagValue).setTagHold(tagHold).build();
  }

  public static String format(String tagValue, String tagHold) {
    return newBuilder().setTagValue(tagValue).setTagHold(tagHold).build().toString();
  }

  public static TagHoldName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        TAG_VALUE_TAG_HOLD.validatedMatch(
            formattedString, "TagHoldName.parse: formattedString not in valid format");
    return of(matchMap.get("tag_value"), matchMap.get("tag_hold"));
  }

  public static List<TagHoldName> parseList(List<String> formattedStrings) {
    List<TagHoldName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagHoldName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagHoldName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return TAG_VALUE_TAG_HOLD.matches(formattedString);
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
          if (tagHold != null) {
            fieldMapBuilder.put("tag_hold", tagHold);
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
    return TAG_VALUE_TAG_HOLD.instantiate("tag_value", tagValue, "tag_hold", tagHold);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      TagHoldName that = ((TagHoldName) o);
      return Objects.equals(this.tagValue, that.tagValue)
          && Objects.equals(this.tagHold, that.tagHold);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(tagValue);
    h *= 1000003;
    h ^= Objects.hashCode(tagHold);
    return h;
  }

  /** Builder for tagValues/{tag_value}/tagHolds/{tag_hold}. */
  public static class Builder {
    private String tagValue;
    private String tagHold;

    protected Builder() {}

    public String getTagValue() {
      return tagValue;
    }

    public String getTagHold() {
      return tagHold;
    }

    public Builder setTagValue(String tagValue) {
      this.tagValue = tagValue;
      return this;
    }

    public Builder setTagHold(String tagHold) {
      this.tagHold = tagHold;
      return this;
    }

    private Builder(TagHoldName tagHoldName) {
      this.tagValue = tagHoldName.tagValue;
      this.tagHold = tagHoldName.tagHold;
    }

    public TagHoldName build() {
      return new TagHoldName(this);
    }
  }
}
