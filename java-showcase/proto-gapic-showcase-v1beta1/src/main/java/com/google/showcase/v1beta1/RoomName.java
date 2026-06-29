/*
 * Copyright 2026 Google LLC
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

package com.google.showcase.v1beta1;

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
public class RoomName implements ResourceName {
  private static final PathTemplate ROOM = PathTemplate.createWithoutUrlEncoding("rooms/{room}");
  private volatile Map<String, String> fieldValuesMap;
  private final String room;

  @Deprecated
  protected RoomName() {
    room = null;
  }

  private RoomName(Builder builder) {
    room = Preconditions.checkNotNull(builder.getRoom());
  }

  public String getRoom() {
    return room;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RoomName of(String room) {
    return newBuilder().setRoom(room).build();
  }

  public static String format(String room) {
    return newBuilder().setRoom(room).build().toString();
  }

  public static RoomName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ROOM.validatedMatch(formattedString, "RoomName.parse: formattedString not in valid format");
    return of(matchMap.get("room"));
  }

  public static List<RoomName> parseList(List<String> formattedStrings) {
    List<RoomName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RoomName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RoomName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ROOM.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (room != null) {
            fieldMapBuilder.put("room", room);
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
    return ROOM.instantiate("room", room);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RoomName that = ((RoomName) o);
      return Objects.equals(this.room, that.room);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(room);
    return h;
  }

  /** Builder for rooms/{room}. */
  public static class Builder {
    private String room;

    protected Builder() {}

    public String getRoom() {
      return room;
    }

    public Builder setRoom(String room) {
      this.room = room;
      return this;
    }

    private Builder(RoomName roomName) {
      this.room = roomName.room;
    }

    public RoomName build() {
      return new RoomName(this);
    }
  }
}
