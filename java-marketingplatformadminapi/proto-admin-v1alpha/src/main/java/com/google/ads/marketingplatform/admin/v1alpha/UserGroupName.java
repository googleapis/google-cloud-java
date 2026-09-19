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
public class UserGroupName implements ResourceName {
  private static final PathTemplate ORGANIZATION_USER_GROUP =
      PathTemplate.createWithoutUrlEncoding("organizations/{organization}/userGroups/{user_group}");
  private volatile Map<String, String> fieldValuesMap;
  private final String organization;
  private final String userGroup;

  @Deprecated
  protected UserGroupName() {
    organization = null;
    userGroup = null;
  }

  private UserGroupName(Builder builder) {
    organization = Preconditions.checkNotNull(builder.getOrganization());
    userGroup = Preconditions.checkNotNull(builder.getUserGroup());
  }

  public String getOrganization() {
    return organization;
  }

  public String getUserGroup() {
    return userGroup;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static UserGroupName of(String organization, String userGroup) {
    return newBuilder().setOrganization(organization).setUserGroup(userGroup).build();
  }

  public static String format(String organization, String userGroup) {
    return newBuilder().setOrganization(organization).setUserGroup(userGroup).build().toString();
  }

  public static @Nullable UserGroupName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        ORGANIZATION_USER_GROUP.validatedMatch(
            formattedString, "UserGroupName.parse: formattedString not in valid format");
    return of(matchMap.get("organization"), matchMap.get("user_group"));
  }

  public static List<UserGroupName> parseList(List<String> formattedStrings) {
    List<UserGroupName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<@Nullable UserGroupName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (UserGroupName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return ORGANIZATION_USER_GROUP.matches(formattedString);
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
    return ORGANIZATION_USER_GROUP.instantiate(
        "organization", organization, "user_group", userGroup);
  }

  @Override
  public boolean equals(@Nullable Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      UserGroupName that = ((UserGroupName) o);
      return Objects.equals(this.organization, that.organization)
          && Objects.equals(this.userGroup, that.userGroup);
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
    return h;
  }

  /** Builder for organizations/{organization}/userGroups/{user_group}. */
  public static class Builder {
    private String organization;
    private String userGroup;

    protected Builder() {}

    public String getOrganization() {
      return organization;
    }

    public String getUserGroup() {
      return userGroup;
    }

    public Builder setOrganization(String organization) {
      this.organization = organization;
      return this;
    }

    public Builder setUserGroup(String userGroup) {
      this.userGroup = userGroup;
      return this;
    }

    private Builder(UserGroupName userGroupName) {
      this.organization = userGroupName.organization;
      this.userGroup = userGroupName.userGroup;
    }

    public UserGroupName build() {
      return new UserGroupName(this);
    }
  }
}
