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
public class SpaceReadStateName implements ResourceName {
  private static final PathTemplate USER_SPACE =
      PathTemplate.createWithoutUrlEncoding("users/{user}/spaces/{space}/spaceReadState");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String space;

  @Deprecated
  protected SpaceReadStateName() {
    user = null;
    space = null;
  }

  private SpaceReadStateName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    space = Preconditions.checkNotNull(builder.getSpace());
  }

  public String getUser() {
    return user;
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

  public static SpaceReadStateName of(String user, String space) {
    return newBuilder().setUser(user).setSpace(space).build();
  }

  public static String format(String user, String space) {
    return newBuilder().setUser(user).setSpace(space).build().toString();
  }

  public static SpaceReadStateName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_SPACE.validatedMatch(
            formattedString, "SpaceReadStateName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("space"));
  }

  public static List<SpaceReadStateName> parseList(List<String> formattedStrings) {
    List<SpaceReadStateName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SpaceReadStateName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SpaceReadStateName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_SPACE.matches(formattedString);
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
    return USER_SPACE.instantiate("user", user, "space", space);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SpaceReadStateName that = ((SpaceReadStateName) o);
      return Objects.equals(this.user, that.user) && Objects.equals(this.space, that.space);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(space);
    return h;
  }

  /** Builder for users/{user}/spaces/{space}/spaceReadState. */
  public static class Builder {
    private String user;
    private String space;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getSpace() {
      return space;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    private Builder(SpaceReadStateName spaceReadStateName) {
      this.user = spaceReadStateName.user;
      this.space = spaceReadStateName.space;
    }

    public SpaceReadStateName build() {
      return new SpaceReadStateName(this);
    }
  }
}
