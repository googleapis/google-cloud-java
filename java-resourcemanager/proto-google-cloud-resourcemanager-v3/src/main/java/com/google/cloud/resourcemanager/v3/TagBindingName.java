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
public class TagBindingName implements ResourceName {
  private static final PathTemplate TAG_BINDING =
      PathTemplate.createWithoutUrlEncoding("tagBindings/{tag_binding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String tagBinding;

  @Deprecated
  protected TagBindingName() {
    tagBinding = null;
  }

  private TagBindingName(Builder builder) {
    tagBinding = Preconditions.checkNotNull(builder.getTagBinding());
  }

  public String getTagBinding() {
    return tagBinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static TagBindingName of(String tagBinding) {
    return newBuilder().setTagBinding(tagBinding).build();
  }

  public static String format(String tagBinding) {
    return newBuilder().setTagBinding(tagBinding).build().toString();
  }

  public static TagBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        TAG_BINDING.validatedMatch(
            formattedString, "TagBindingName.parse: formattedString not in valid format");
    return of(matchMap.get("tag_binding"));
  }

  public static List<TagBindingName> parseList(List<String> formattedStrings) {
    List<TagBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<TagBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (TagBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return TAG_BINDING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (tagBinding != null) {
            fieldMapBuilder.put("tag_binding", tagBinding);
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
    return TAG_BINDING.instantiate("tag_binding", tagBinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      TagBindingName that = ((TagBindingName) o);
      return Objects.equals(this.tagBinding, that.tagBinding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(tagBinding);
    return h;
  }

  /** Builder for tagBindings/{tag_binding}. */
  public static class Builder {
    private String tagBinding;

    protected Builder() {}

    public String getTagBinding() {
      return tagBinding;
    }

    public Builder setTagBinding(String tagBinding) {
      this.tagBinding = tagBinding;
      return this;
    }

    private Builder(TagBindingName tagBindingName) {
      this.tagBinding = tagBindingName.tagBinding;
    }

    public TagBindingName build() {
      return new TagBindingName(this);
    }
  }
}
