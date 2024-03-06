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
public class MembershipName implements ResourceName {
  private static final PathTemplate SPACE_MEMBER =
      PathTemplate.createWithoutUrlEncoding("spaces/{space}/members/{member}");
  private volatile Map<String, String> fieldValuesMap;
  private final String space;
  private final String member;

  @Deprecated
  protected MembershipName() {
    space = null;
    member = null;
  }

  private MembershipName(Builder builder) {
    space = Preconditions.checkNotNull(builder.getSpace());
    member = Preconditions.checkNotNull(builder.getMember());
  }

  public String getSpace() {
    return space;
  }

  public String getMember() {
    return member;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MembershipName of(String space, String member) {
    return newBuilder().setSpace(space).setMember(member).build();
  }

  public static String format(String space, String member) {
    return newBuilder().setSpace(space).setMember(member).build().toString();
  }

  public static MembershipName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        SPACE_MEMBER.validatedMatch(
            formattedString, "MembershipName.parse: formattedString not in valid format");
    return of(matchMap.get("space"), matchMap.get("member"));
  }

  public static List<MembershipName> parseList(List<String> formattedStrings) {
    List<MembershipName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MembershipName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MembershipName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return SPACE_MEMBER.matches(formattedString);
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
          if (member != null) {
            fieldMapBuilder.put("member", member);
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
    return SPACE_MEMBER.instantiate("space", space, "member", member);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MembershipName that = ((MembershipName) o);
      return Objects.equals(this.space, that.space) && Objects.equals(this.member, that.member);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(space);
    h *= 1000003;
    h ^= Objects.hashCode(member);
    return h;
  }

  /** Builder for spaces/{space}/members/{member}. */
  public static class Builder {
    private String space;
    private String member;

    protected Builder() {}

    public String getSpace() {
      return space;
    }

    public String getMember() {
      return member;
    }

    public Builder setSpace(String space) {
      this.space = space;
      return this;
    }

    public Builder setMember(String member) {
      this.member = member;
      return this;
    }

    private Builder(MembershipName membershipName) {
      this.space = membershipName.space;
      this.member = membershipName.member;
    }

    public MembershipName build() {
      return new MembershipName(this);
    }
  }
}
