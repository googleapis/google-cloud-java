/*
 * Copyright 2023 Google LLC
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

package com.google.apps.meet.v2beta;

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
public class SpaceName implements ResourceName {
  private static final PathTemplate SPACE = PathTemplate.createWithoutUrlEncoding("spaces/{space}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;

  @Deprecated
  protected SpaceName() {
    space = null;
  }

  private SpaceName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
  }

  public String getSpace() {
    return space;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SpaceName of(String space) {
    return newBuilder().setSpace(space).build();
  }

  public static String format(String space) {
    return newBuilder().setSpace(space).build().toString();
  }

  public static SpaceName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE.validatedMatch(
            formattedString, "SpaceName.parse: formattedString not in valid format");
    return of(matchMap.get("space"));
  }

  public static List<SpaceName> parseList(List<String> formattedStrings) {
    List<SpaceName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SpaceName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SpaceName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (space != null) {
            fieldMapBuilder.put("space", space);
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
    return SPACE.instantiate("space", space);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SpaceName that = ((SpaceName) o);
      return Objects.equals(this.space, that.space);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(space);
    return h;
  }

  /** Builder for spaces/{space}. */
  public static class Builder {
    private String space;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    private Builder(SpaceName spaceName) {
      this.space = spaceName.space;
    }

    public SpaceName build() {
      return new SpaceName(this);
    }
  }
}
