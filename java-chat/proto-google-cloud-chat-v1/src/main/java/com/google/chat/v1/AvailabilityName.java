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
public class AvailabilityName implements ResourceName {
  private static final PathTemplate USER =
      PathTemplate.createWithoutUrlEncoding("users/{user}/availability");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;

  @Deprecated
  protected AvailabilityName() {
    user = null;
  }

  private AvailabilityName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
  }

  public String getUser() {
    return user;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static AvailabilityName of(String user) {
    return newBuilder().setUser(user).build();
  }

  public static String format(String user) {
    return newBuilder().setUser(user).build().toString();
  }

  public static AvailabilityName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER.validatedMatch(
            formattedString, "AvailabilityName.parse: formattedString not in valid format");
    return of(matchMap.get("user"));
  }

  public static List<AvailabilityName> parseList(List<String> formattedStrings) {
    List<AvailabilityName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<AvailabilityName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (AvailabilityName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER.matches(formattedString);
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
    return USER.instantiate("user", user);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      AvailabilityName that = ((AvailabilityName) o);
      return Objects.equals(this.user, that.user);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    return h;
  }

  /** Builder for users/{user}/availability. */
  public static class Builder {
    private String user;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    private Builder(AvailabilityName availabilityName) {
      this.user = availabilityName.user;
    }

    public AvailabilityName build() {
      return new AvailabilityName(this);
    }
  }
}
