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
public class SpaceEventName implements ResourceName {
  private static final PathTemplate SPACE_SPACE_EVENT =
      PathTemplate.createWithoutUrlEncoding("spaces/{space}/spaceEvents/{space_event}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;
  private final String spaceEvent;

  @Deprecated
  protected SpaceEventName() {
    space = null;
    spaceEvent = null;
  }

  private SpaceEventName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
    spaceEvent = Preconditions.checkNotNull(builder.getSpaceEvent());
  }

  public String getSpace() {
    return space;
  }

  public String getSpaceEvent() {
    return spaceEvent;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SpaceEventName of(String space, String spaceEvent) {
    return newBuilder().setSpace(space).setSpaceEvent(spaceEvent).build();
  }

  public static String format(String space, String spaceEvent) {
    return newBuilder().setSpace(space).setSpaceEvent(spaceEvent).build().toString();
  }

  public static SpaceEventName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE_SPACE_EVENT.validatedMatch(
            formattedString, "SpaceEventName.parse: formattedString not in valid format");
    return of(matchMap.get("space"), matchMap.get("space_event"));
  }

  public static List<SpaceEventName> parseList(List<String> formattedStrings) {
    List<SpaceEventName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SpaceEventName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SpaceEventName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE_SPACE_EVENT.matches(formattedString);
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
          if (spaceEvent != null) {
            fieldMapBuilder.put("space_event", spaceEvent);
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
    return SPACE_SPACE_EVENT.instantiate("space", space, "space_event", spaceEvent);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SpaceEventName that = ((SpaceEventName) o);
      return Objects.equals(this.space, that.space)
          && Objects.equals(this.spaceEvent, that.spaceEvent);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(spaceEvent);
    return h;
  }

  /** Builder for spaces/{space}/spaceEvents/{space_event}. */
  public static class Builder {
    private String space;
    private String spaceEvent;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public String getSpaceEvent() {
      return spaceEvent;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setSpaceEvent(String spaceEvent) {
      this.spaceEvent = spaceEvent;
      return this;
    }

    private Builder(SpaceEventName spaceEventName) {
      this.space = spaceEventName.space;
      this.spaceEvent = spaceEventName.spaceEvent;
    }

    public SpaceEventName build() {
      return new SpaceEventName(this);
    }
  }
}
