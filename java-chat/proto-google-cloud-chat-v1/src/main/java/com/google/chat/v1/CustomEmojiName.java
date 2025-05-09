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

package com.google.chat.v1;

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
public class CustomEmojiName implements ResourceName {
  private static final PathTemplate CUSTOM_EMOJI =
      PathTemplate.createWithoutUrlEncoding("customEmojis/{custom_emoji}");
  private volatile Map<String, String> fieldValuesMap;
  private final String customEmoji;

  @Deprecated
  protected CustomEmojiName() {
    customEmoji = null;
  }

  private CustomEmojiName(Builder builder) {
    customEmoji = Preconditions.checkNotNull(builder.getCustomEmoji());
  }

  public String getCustomEmoji() {
    return customEmoji;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static CustomEmojiName of(String customEmoji) {
    return newBuilder().setCustomEmoji(customEmoji).build();
  }

  public static String format(String customEmoji) {
    return newBuilder().setCustomEmoji(customEmoji).build().toString();
  }

  public static CustomEmojiName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        CUSTOM_EMOJI.validatedMatch(
            formattedString, "CustomEmojiName.parse: formattedString not in valid format");
    return of(matchMap.get("custom_emoji"));
  }

  public static List<CustomEmojiName> parseList(List<String> formattedStrings) {
    List<CustomEmojiName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<CustomEmojiName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (CustomEmojiName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return CUSTOM_EMOJI.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (customEmoji != null) {
            fieldMapBuilder.put("custom_emoji", customEmoji);
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
    return CUSTOM_EMOJI.instantiate("custom_emoji", customEmoji);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      CustomEmojiName that = ((CustomEmojiName) o);
      return Objects.equals(this.customEmoji, that.customEmoji);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(customEmoji);
    return h;
  }

  /** Builder for customEmojis/{custom_emoji}. */
  public static class Builder {
    private String customEmoji;

    protected Builder() {}

    public String getCustomEmoji() {
      return customEmoji;
    }

    public Builder setCustomEmoji(String customEmoji) {
      this.customEmoji = customEmoji;
      return this;
    }

    private Builder(CustomEmojiName customEmojiName) {
      this.customEmoji = customEmojiName.customEmoji;
    }

    public CustomEmojiName build() {
      return new CustomEmojiName(this);
    }
  }
}
