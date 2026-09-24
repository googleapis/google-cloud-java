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

package com.google.ads.marketingplatform.admin.v1alpha;

import com.google.api.pathtemplate.PathTemplate;
import com.google.api.resourcenames.ResourceName;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
@NullMarked
@Generated("by gapic-generator-java")
public class UserGroupMemberName implements ResourceName {
  private static final PathTemplate ORGANIZATION_USER_GROUP_MEMBER =
      PathTemplate.createWithoutUrlEncoding(
          "organizations/{organization}/userGroups/{user_group}/members/{member}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String userGroup;
  private final String member;

  @Deprecated
  protected UserGroupMemberName() {
    organization = null;
    userGroup = null;
    member = null;
  }

  private UserGroupMemberName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    userGroup = Preconditions.checkNotNull(builder.getUserGroup());
    member = Preconditions.checkNotNull(builder.getMember());
  }

  public String getOrganization() {
    return organization;
  }

  public String getUserGroup() {
    return userGroup;
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

  public static UserGroupMemberName of(String organization, String userGroup, String member) {
    return newBuilder()
        .setOrganization(organization)
        .setUserGroup(userGroup)
        .setMember(member)
        .build();
  }

  public static String format(String organization, String userGroup, String member) {
    return newBuilder()
        .setOrganization(organization)
        .setUserGroup(userGroup)
        .setMember(member)
        .build()
        .toString();
  }

  public static @Nullable UserGroupMemberName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_USER_GROUP_MEMBER.validatedMatch(
            formattedString, "UserGroupMemberName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("user_group"), matchMap.get("member"));
  }

  public static List<UserGroupMemberName> parseList(List<String> formattedStrings) {
    List<UserGroupMemberName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable UserGroupMemberName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserGroupMemberName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_USER_GROUP_MEMBER.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (organization != null) {
            fieldMapBuilder.put("organization", organization);
          }
          if (userGroup != null) {
            fieldMapBuilder.put("user_group", userGroup);
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
    return ORGANIZATION_USER_GROUP_MEMBER.instantiate(
        "organization", organization, "user_group", userGroup, "member", member);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserGroupMemberName that = ((UserGroupMemberName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.userGroup, that.userGroup)
          && Objects.equals(this.member, that.member);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(organization);
    h *= 1000003;
    h ^= Objects.hashCode(userGroup);
    h *= 1000003;
    h ^= Objects.hashCode(member);
    return h;
  }

  /** Builder for organizations/{organization}/userGroups/{user_group}/members/{member}. */
  public static class Builder {
    private String organization;
    private String userGroup;
    private String member;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getUserGroup() {
      return userGroup;
    }

    public String getMember() {
      return member;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setUserGroup(String userGroup) {
      this.userGroup = userGroup;
      return this;
    }

    public Builder setMember(String member) {
      this.member = member;
      return this;
    }

    private Builder(UserGroupMemberName userGroupMemberName) {
      this.organization = userGroupMemberName.organization;
      this.userGroup = userGroupMemberName.userGroup;
      this.member = userGroupMemberName.member;
    }

    public UserGroupMemberName build() {
      return new UserGroupMemberName(this);
    }
  }
}
