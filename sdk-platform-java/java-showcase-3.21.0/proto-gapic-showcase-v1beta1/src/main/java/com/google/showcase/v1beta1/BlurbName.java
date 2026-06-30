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

package com.google.showcase.v1beta1;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.pathtemplate.ValidationException;
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
public class BlurbName implements ResourceName {
  private static final PathTemplate USER_LEGACY_USER_BLURB =
      PathTemplate.createWithoutUrlEncoding(
          "users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}");
  private static final PathTemplate USER_BLURB =
      PathTemplate.createWithoutUrlEncoding("users/{user}/profile/blurbs/{blurb}");
  private static final PathTemplate ROOM_BLURB =
      PathTemplate.createWithoutUrlEncoding("rooms/{room}/blurbs/{blurb}");
  private static final PathTemplate ROOM_LEGACY_ROOM_BLURB =
      PathTemplate.createWithoutUrlEncoding("rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String user;
  private final String legacyUser;
  private final String blurb;
  private final String room;
  private final String legacyRoom;

  @Deprecated
  protected BlurbName() {
    user = null;
    legacyUser = null;
    blurb = null;
    room = null;
    legacyRoom = null;
  }

  private BlurbName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    legacyUser = Preconditions.checkNotNull(builder.getLegacyUser());
    blurb = Preconditions.checkNotNull(builder.getBlurb());
    room = null;
    legacyRoom = null;
    pathTemplate = USER_LEGACY_USER_BLURB;
  }

  private BlurbName(UserBlurbBuilder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    blurb = Preconditions.checkNotNull(builder.getBlurb());
    legacyUser = null;
    room = null;
    legacyRoom = null;
    pathTemplate = USER_BLURB;
  }

  private BlurbName(RoomBlurbBuilder builder) {
    room = Preconditions.checkNotNull(builder.getRoom());
    blurb = Preconditions.checkNotNull(builder.getBlurb());
    user = null;
    legacyUser = null;
    legacyRoom = null;
    pathTemplate = ROOM_BLURB;
  }

  private BlurbName(RoomLegacyRoomBlurbBuilder builder) {
    room = Preconditions.checkNotNull(builder.getRoom());
    legacyRoom = Preconditions.checkNotNull(builder.getLegacyRoom());
    blurb = Preconditions.checkNotNull(builder.getBlurb());
    user = null;
    legacyUser = null;
    pathTemplate = ROOM_LEGACY_ROOM_BLURB;
  }

  public String getUser() {
    return user;
  }

  public String getLegacyUser() {
    return legacyUser;
  }

  public String getBlurb() {
    return blurb;
  }

  public String getRoom() {
    return room;
  }

  public String getLegacyRoom() {
    return legacyRoom;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newUserLegacyUserBlurbBuilder() {
    return new Builder();
  }

  public static UserBlurbBuilder newUserBlurbBuilder() {
    return new UserBlurbBuilder();
  }

  public static RoomBlurbBuilder newRoomBlurbBuilder() {
    return new RoomBlurbBuilder();
  }

  public static RoomLegacyRoomBlurbBuilder newRoomLegacyRoomBlurbBuilder() {
    return new RoomLegacyRoomBlurbBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static BlurbName of(String user, String legacyUser, String blurb) {
    return newBuilder().setUser(user).setLegacyUser(legacyUser).setBlurb(blurb).build();
  }

  public static BlurbName ofUserLegacyUserBlurbName(String user, String legacyUser, String blurb) {
    return newBuilder().setUser(user).setLegacyUser(legacyUser).setBlurb(blurb).build();
  }

  public static BlurbName ofUserBlurbName(String user, String blurb) {
    return newUserBlurbBuilder().setUser(user).setBlurb(blurb).build();
  }

  public static BlurbName ofRoomBlurbName(String room, String blurb) {
    return newRoomBlurbBuilder().setRoom(room).setBlurb(blurb).build();
  }

  public static BlurbName ofRoomLegacyRoomBlurbName(String room, String legacyRoom, String blurb) {
    return newRoomLegacyRoomBlurbBuilder()
        .setRoom(room)
        .setLegacyRoom(legacyRoom)
        .setBlurb(blurb)
        .build();
  }

  public static String format(String user, String legacyUser, String blurb) {
    return newBuilder().setUser(user).setLegacyUser(legacyUser).setBlurb(blurb).build().toString();
  }

  public static String formatUserLegacyUserBlurbName(String user, String legacyUser, String blurb) {
    return newBuilder().setUser(user).setLegacyUser(legacyUser).setBlurb(blurb).build().toString();
  }

  public static String formatUserBlurbName(String user, String blurb) {
    return newUserBlurbBuilder().setUser(user).setBlurb(blurb).build().toString();
  }

  public static String formatRoomBlurbName(String room, String blurb) {
    return newRoomBlurbBuilder().setRoom(room).setBlurb(blurb).build().toString();
  }

  public static String formatRoomLegacyRoomBlurbName(String room, String legacyRoom, String blurb) {
    return newRoomLegacyRoomBlurbBuilder()
        .setRoom(room)
        .setLegacyRoom(legacyRoom)
        .setBlurb(blurb)
        .build()
        .toString();
  }

  public static BlurbName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (USER_LEGACY_USER_BLURB.matches(formattedString)) {
      Map<String, String> matchMap = USER_LEGACY_USER_BLURB.match(formattedString);
      return ofUserLegacyUserBlurbName(
          matchMap.get("user"), matchMap.get("legacy_user"), matchMap.get("blurb"));
    } else if (USER_BLURB.matches(formattedString)) {
      Map<String, String> matchMap = USER_BLURB.match(formattedString);
      return ofUserBlurbName(matchMap.get("user"), matchMap.get("blurb"));
    } else if (ROOM_BLURB.matches(formattedString)) {
      Map<String, String> matchMap = ROOM_BLURB.match(formattedString);
      return ofRoomBlurbName(matchMap.get("room"), matchMap.get("blurb"));
    } else if (ROOM_LEGACY_ROOM_BLURB.matches(formattedString)) {
      Map<String, String> matchMap = ROOM_LEGACY_ROOM_BLURB.match(formattedString);
      return ofRoomLegacyRoomBlurbName(
          matchMap.get("room"), matchMap.get("legacy_room"), matchMap.get("blurb"));
    }
    throw new ValidationException("BlurbName.parse: formattedString not in valid format");
  }

  public static List<BlurbName> parseList(List<String> formattedStrings) {
    List<BlurbName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<BlurbName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (BlurbName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_LEGACY_USER_BLURB.matches(formattedString)
        || USER_BLURB.matches(formattedString)
        || ROOM_BLURB.matches(formattedString)
        || ROOM_LEGACY_ROOM_BLURB.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (user != null) {
            fieldMapBuilder.put("user", user);
          }
          if (legacyUser != null) {
            fieldMapBuilder.put("legacy_user", legacyUser);
          }
          if (blurb != null) {
            fieldMapBuilder.put("blurb", blurb);
          }
          if (room != null) {
            fieldMapBuilder.put("room", room);
          }
          if (legacyRoom != null) {
            fieldMapBuilder.put("legacy_room", legacyRoom);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      BlurbName that = ((BlurbName) o);
      return Objects.equals(this.user, that.user)
          && Objects.equals(this.legacyUser, that.legacyUser)
          && Objects.equals(this.blurb, that.blurb)
          && Objects.equals(this.room, that.room)
          && Objects.equals(this.legacyRoom, that.legacyRoom);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(legacyUser);
    h *= 1000003;
    h ^= Objects.hashCode(blurb);
    h *= 1000003;
    h ^= Objects.hashCode(room);
    h *= 1000003;
    h ^= Objects.hashCode(legacyRoom);
    return h;
  }

  /** Builder for users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}. */
  public static class Builder {
    private String user;
    private String legacyUser;
    private String blurb;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getLegacyUser() {
      return legacyUser;
    }

    public String getBlurb() {
      return blurb;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setLegacyUser(String legacyUser) {
      this.legacyUser = legacyUser;
      return this;
    }

    public Builder setBlurb(String blurb) {
      this.blurb = blurb;
      return this;
    }

    private Builder(BlurbName blurbName) {
      Preconditions.checkArgument(
          Objects.equals(blurbName.pathTemplate, USER_LEGACY_USER_BLURB),
          "toBuilder is only supported when BlurbName has the pattern of"
              + " users/{user}/profile/blurbs/legacy/{legacy_user}~{blurb}");
      this.user = blurbName.user;
      this.legacyUser = blurbName.legacyUser;
      this.blurb = blurbName.blurb;
    }

    public BlurbName build() {
      return new BlurbName(this);
    }
  }

  /** Builder for users/{user}/profile/blurbs/{blurb}. */
  public static class UserBlurbBuilder {
    private String user;
    private String blurb;

    protected UserBlurbBuilder() {}

    public String getUser() {
      return user;
    }

    public String getBlurb() {
      return blurb;
    }

    public UserBlurbBuilder setUser(String user) {
      this.user = user;
      return this;
    }

    public UserBlurbBuilder setBlurb(String blurb) {
      this.blurb = blurb;
      return this;
    }

    public BlurbName build() {
      return new BlurbName(this);
    }
  }

  /** Builder for rooms/{room}/blurbs/{blurb}. */
  public static class RoomBlurbBuilder {
    private String room;
    private String blurb;

    protected RoomBlurbBuilder() {}

    public String getRoom() {
      return room;
    }

    public String getBlurb() {
      return blurb;
    }

    public RoomBlurbBuilder setRoom(String room) {
      this.room = room;
      return this;
    }

    public RoomBlurbBuilder setBlurb(String blurb) {
      this.blurb = blurb;
      return this;
    }

    public BlurbName build() {
      return new BlurbName(this);
    }
  }

  /** Builder for rooms/{room}/blurbs/legacy/{legacy_room}.{blurb}. */
  public static class RoomLegacyRoomBlurbBuilder {
    private String room;
    private String legacyRoom;
    private String blurb;

    protected RoomLegacyRoomBlurbBuilder() {}

    public String getRoom() {
      return room;
    }

    public String getLegacyRoom() {
      return legacyRoom;
    }

    public String getBlurb() {
      return blurb;
    }

    public RoomLegacyRoomBlurbBuilder setRoom(String room) {
      this.room = room;
      return this;
    }

    public RoomLegacyRoomBlurbBuilder setLegacyRoom(String legacyRoom) {
      this.legacyRoom = legacyRoom;
      return this;
    }

    public RoomLegacyRoomBlurbBuilder setBlurb(String blurb) {
      this.blurb = blurb;
      return this;
    }

    public BlurbName build() {
      return new BlurbName(this);
    }
  }
}
