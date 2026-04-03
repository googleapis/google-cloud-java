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
public class SectionName implements ResourceName {
  private static final PathTemplate USER_SECTION =
      PathTemplate.createWithoutUrlEncoding("users/{user}/sections/{section}");
  private volatile Map<String, String> fieldValuesMap;
  private final String user;
  private final String section;

  @Deprecated
  protected SectionName() {
    user = null;
    section = null;
  }

  private SectionName(Builder builder) {
    user = Preconditions.checkNotNull(builder.getUser());
    section = Preconditions.checkNotNull(builder.getSection());
  }

  public String getUser() {
    return user;
  }

  public String getSection() {
    return section;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static SectionName of(String user, String section) {
    return newBuilder().setUser(user).setSection(section).build();
  }

  public static String format(String user, String section) {
    return newBuilder().setUser(user).setSection(section).build().toString();
  }

  public static SectionName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        USER_SECTION.validatedMatch(
            formattedString, "SectionName.parse: formattedString not in valid format");
    return of(matchMap.get("user"), matchMap.get("section"));
  }

  public static List<SectionName> parseList(List<String> formattedStrings) {
    List<SectionName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<SectionName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (SectionName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return USER_SECTION.matches(formattedString);
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
          if (section != null) {
            fieldMapBuilder.put("section", section);
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
    return USER_SECTION.instantiate("user", user, "section", section);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      SectionName that = ((SectionName) o);
      return Objects.equals(this.user, that.user) && Objects.equals(this.section, that.section);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(user);
    h *= 1000003;
    h ^= Objects.hashCode(section);
    return h;
  }

  /** Builder for users/{user}/sections/{section}. */
  public static class Builder {
    private String user;
    private String section;

    protected Builder() {}

    public String getUser() {
      return user;
    }

    public String getSection() {
      return section;
    }

    public Builder setUser(String user) {
      this.user = user;
      return this;
    }

    public Builder setSection(String section) {
      this.section = section;
      return this;
    }

    private Builder(SectionName sectionName) {
      this.user = sectionName.user;
      this.section = sectionName.section;
    }

    public SectionName build() {
      return new SectionName(this);
    }
  }
}
