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

package com.google.cloud.osconfig.v1beta;

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
public class GuestPolicyName implements ResourceName {
  private static final PathTemplate PROJECT_GUEST_POLICY =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/guestPolicies/{guest_policy}");
  private volatile Map<String, String> fieldValuesMap;
  private final String project;
  private final String guestPolicy;

  @Deprecated
  protected GuestPolicyName() {
    project = null;
    guestPolicy = null;
  }

  private GuestPolicyName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    guestPolicy = Preconditions.checkNotNull(builder.getGuestPolicy());
  }

  public String getProject() {
    return project;
  }

  public String getGuestPolicy() {
    return guestPolicy;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static GuestPolicyName of(String project, String guestPolicy) {
    return newBuilder().setProject(project).setGuestPolicy(guestPolicy).build();
  }

  public static String format(String project, String guestPolicy) {
    return newBuilder().setProject(project).setGuestPolicy(guestPolicy).build().toString();
  }

  public static GuestPolicyName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    Map<String, String> matchMap =
        PROJECT_GUEST_POLICY.validatedMatch(
            formattedString, "GuestPolicyName.parse: formattedString not in valid format");
    return of(matchMap.get("project"), matchMap.get("guest_policy"));
  }

  public static List<GuestPolicyName> parseList(List<String> formattedStrings) {
    List<GuestPolicyName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<GuestPolicyName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (GuestPolicyName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_GUEST_POLICY.matches(formattedString);
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
          if (guestPolicy != null) {
            fieldMapBuilder.put("guest_policy", guestPolicy);
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
    return PROJECT_GUEST_POLICY.instantiate("project", project, "guest_policy", guestPolicy);
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null || getClass() == o.getClass()) {
      GuestPolicyName that = ((GuestPolicyName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.guestPolicy, that.guestPolicy);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(guestPolicy);
    return h;
  }

  /** Builder for projects/{project}/guestPolicies/{guest_policy}. */
  public static class Builder {
    private String project;
    private String guestPolicy;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getGuestPolicy() {
      return guestPolicy;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setGuestPolicy(String guestPolicy) {
      this.guestPolicy = guestPolicy;
      return this;
    }

    private Builder(GuestPolicyName guestPolicyName) {
      this.project = guestPolicyName.project;
      this.guestPolicy = guestPolicyName.guestPolicy;
    }

    public GuestPolicyName build() {
      return new GuestPolicyName(this);
    }
  }
}
