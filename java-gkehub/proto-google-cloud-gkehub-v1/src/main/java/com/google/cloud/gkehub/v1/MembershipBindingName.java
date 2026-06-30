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

package com.google.cloud.gkehub.v1;

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
public class MembershipBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MEMBERSHIP_MEMBERSHIPBINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/memberships/{membership}/bindings/{membershipbinding}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String membership;
  private final String membershipbinding;

  @Deprecated
  protected MembershipBindingName() {
    project = null;
    location = null;
    membership = null;
    membershipbinding = null;
  }

  private MembershipBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    membership = Preconditions.checkNotNull(builder.getMembership());
    membershipbinding = Preconditions.checkNotNull(builder.getMembershipbinding());
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getMembership() {
    return membership;
  }

  public String getMembershipbinding() {
    return membershipbinding;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MembershipBindingName of(
      String project, String location, String membership, String membershipbinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMembership(membership)
        .setMembershipbinding(membershipbinding)
        .build();
  }

  public static String format(
      String project, String location, String membership, String membershipbinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMembership(membership)
        .setMembershipbinding(membershipbinding)
        .build()
        .toString();
  }

  public static MembershipBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MEMBERSHIP_MEMBERSHIPBINDING.validatedMatch(
            formattedString, "MembershipBindingName.parse: formattedString not in valid format");
    return of(
        matchMap.get("project"),
        matchMap.get("location"),
        matchMap.get("membership"),
        matchMap.get("membershipbinding"));
  }

  public static List<MembershipBindingName> parseList(List<String> formattedStrings) {
    List<MembershipBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<MembershipBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (MembershipBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_MEMBERSHIP_MEMBERSHIPBINDING.matches(formattedString);
  }

  @Override
  public Map<String, String> getFieldValuesMap() {
    if (fieldValuesMap == null) {
      synchronized (this) {
        if (fieldValuesMap == null) {
          ImmutableMap.Builder<String, String> fieldMapBuilder = ImmutableMap.builder();
          if (project != null) {
            fieldMapBuilder.put("project", project);
          }
          if (location != null) {
            fieldMapBuilder.put("location", location);
          }
          if (membership != null) {
            fieldMapBuilder.put("membership", membership);
          }
          if (membershipbinding != null) {
            fieldMapBuilder.put("membershipbinding", membershipbinding);
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
    return PROJECT_LOCATION_MEMBERSHIP_MEMBERSHIPBINDING.instantiate(
        "project",
        project,
        "location",
        location,
        "membership",
        membership,
        "membershipbinding",
        membershipbinding);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      MembershipBindingName that = ((MembershipBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.membership, that.membership)
          && Objects.equals(this.membershipbinding, that.membershipbinding);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(membership);
    h *= 1000003;
    h ^= Objects.hashCode(membershipbinding);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/memberships/{membership}/bindings/{membershipbinding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String membership;
    private String membershipbinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMembership() {
      return membership;
    }

    public String getMembershipbinding() {
      return membershipbinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setMembership(String membership) {
      this.membership = membership;
      return this;
    }

    public Builder setMembershipbinding(String membershipbinding) {
      this.membershipbinding = membershipbinding;
      return this;
    }

    private Builder(MembershipBindingName membershipBindingName) {
      this.project = membershipBindingName.project;
      this.location = membershipBindingName.location;
      this.membership = membershipBindingName.membership;
      this.membershipbinding = membershipBindingName.membershipbinding;
    }

    public MembershipBindingName build() {
      return new MembershipBindingName(this);
    }
  }
}
