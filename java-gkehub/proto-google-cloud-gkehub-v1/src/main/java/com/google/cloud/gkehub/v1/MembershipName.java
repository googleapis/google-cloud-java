/*
 * Copyright 2022 Google LLC
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
public class MembershipName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_MEMBERSHIP =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/memberships/{membership}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String location;
  private final String membership;

  @Deprecated
  protected MembershipName() {
    project = null;
    location = null;
    membership = null;
  }

  private MembershipName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    membership = Preconditions.checkNotNull(builder.getMembership());
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static MembershipName of(String project, String location, String membership) {
    return newBuilder().setProject(project).setLocation(location).setMembership(membership).build();
  }

  public static String format(String project, String location, String membership) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setMembership(membership)
        .build()
        .toString();
  }

  public static MembershipName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_LOCATION_MEMBERSHIP.validatedMatch(
            formattedString, "MembershipName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("location"), matchMap.get("membership"));
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
    return PROJECT_LOCATION_MEMBERSHIP.matches(formattedString);
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
    return PROJECT_LOCATION_MEMBERSHIP.instantiate(
        "project", project, "location", location, "membership", membership);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      MembershipName that = ((MembershipName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.membership, that.membership);
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
    return h;
  }

  /** Builder for projects/{project}/locations/{location}/memberships/{membership}. */
  public static class Builder {
    private String project;
    private String location;
    private String membership;

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

    private Builder(MembershipName membershipName) {
      this.project = membershipName.project;
      this.location = membershipName.location;
      this.membership = membershipName.membership;
    }

    public MembershipName build() {
      return new MembershipName(this);
    }
  }
}
