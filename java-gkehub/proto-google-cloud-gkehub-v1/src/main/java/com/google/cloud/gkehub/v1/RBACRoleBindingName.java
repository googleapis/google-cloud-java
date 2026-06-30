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
public class RBACRoleBindingName implements ResourceName {
  private static final PathTemplate PROJECT_LOCATION_SCOPE_RBACROLEBINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/scopes/{scope}/rbacrolebindings/{rbacrolebinding}");
  private static final PathTemplate PROJECT_LOCATION_MEMBERSHIP_RBACROLEBINDING =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/memberships/{membership}/rbacrolebindings/{rbacrolebinding}");
  private volatile Map<String, String> fieldValuesMap;
  private PathTemplate pathTemplate;
  private String fixedValue;
  private final String project;
  private final String location;
  private final String scope;
  private final String rbacrolebinding;
  private final String membership;

  @Deprecated
  protected RBACRoleBindingName() {
    project = null;
    location = null;
    scope = null;
    rbacrolebinding = null;
    membership = null;
  }

  private RBACRoleBindingName(Builder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    scope = Preconditions.checkNotNull(builder.getScope());
    rbacrolebinding = Preconditions.checkNotNull(builder.getRbacrolebinding());
    membership = null;
    pathTemplate = PROJECT_LOCATION_SCOPE_RBACROLEBINDING;
  }

  private RBACRoleBindingName(ProjectLocationMembershipRbacrolebindingBuilder builder) {
    project = Preconditions.checkNotNull(builder.getProject());
    location = Preconditions.checkNotNull(builder.getLocation());
    membership = Preconditions.checkNotNull(builder.getMembership());
    rbacrolebinding = Preconditions.checkNotNull(builder.getRbacrolebinding());
    scope = null;
    pathTemplate = PROJECT_LOCATION_MEMBERSHIP_RBACROLEBINDING;
  }

  public String getProject() {
    return project;
  }

  public String getLocation() {
    return location;
  }

  public String getScope() {
    return scope;
  }

  public String getRbacrolebinding() {
    return rbacrolebinding;
  }

  public String getMembership() {
    return membership;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static Builder newProjectLocationScopeRbacrolebindingBuilder() {
    return new Builder();
  }

  public static ProjectLocationMembershipRbacrolebindingBuilder
      newProjectLocationMembershipRbacrolebindingBuilder() {
    return new ProjectLocationMembershipRbacrolebindingBuilder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  public static RBACRoleBindingName of(
      String project, String location, String scope, String rbacrolebinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setRbacrolebinding(rbacrolebinding)
        .build();
  }

  public static RBACRoleBindingName ofProjectLocationScopeRbacrolebindingName(
      String project, String location, String scope, String rbacrolebinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setRbacrolebinding(rbacrolebinding)
        .build();
  }

  public static RBACRoleBindingName ofProjectLocationMembershipRbacrolebindingName(
      String project, String location, String membership, String rbacrolebinding) {
    return newProjectLocationMembershipRbacrolebindingBuilder()
        .setProject(project)
        .setLocation(location)
        .setMembership(membership)
        .setRbacrolebinding(rbacrolebinding)
        .build();
  }

  public static String format(
      String project, String location, String scope, String rbacrolebinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setRbacrolebinding(rbacrolebinding)
        .build()
        .toString();
  }

  public static String formatProjectLocationScopeRbacrolebindingName(
      String project, String location, String scope, String rbacrolebinding) {
    return newBuilder()
        .setProject(project)
        .setLocation(location)
        .setScope(scope)
        .setRbacrolebinding(rbacrolebinding)
        .build()
        .toString();
  }

  public static String formatProjectLocationMembershipRbacrolebindingName(
      String project, String location, String membership, String rbacrolebinding) {
    return newProjectLocationMembershipRbacrolebindingBuilder()
        .setProject(project)
        .setLocation(location)
        .setMembership(membership)
        .setRbacrolebinding(rbacrolebinding)
        .build()
        .toString();
  }

  public static RBACRoleBindingName parse(String formattedString) {
    if (formattedString.isEmpty()) {
      return null;
    }
    if (PROJECT_LOCATION_SCOPE_RBACROLEBINDING.matches(formattedString)) {
      Map<String, String> matchMap = PROJECT_LOCATION_SCOPE_RBACROLEBINDING.match(formattedString);
      return ofProjectLocationScopeRbacrolebindingName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("scope"),
          matchMap.get("rbacrolebinding"));
    } else if (PROJECT_LOCATION_MEMBERSHIP_RBACROLEBINDING.matches(formattedString)) {
      Map<String, String> matchMap =
          PROJECT_LOCATION_MEMBERSHIP_RBACROLEBINDING.match(formattedString);
      return ofProjectLocationMembershipRbacrolebindingName(
          matchMap.get("project"),
          matchMap.get("location"),
          matchMap.get("membership"),
          matchMap.get("rbacrolebinding"));
    }
    throw new ValidationException("RBACRoleBindingName.parse: formattedString not in valid format");
  }

  public static List<RBACRoleBindingName> parseList(List<String> formattedStrings) {
    List<RBACRoleBindingName> list = new ArrayList<>(formattedStrings.size());
    for (String formattedString : formattedStrings) {
      list.add(parse(formattedString));
    }
    return list;
  }

  public static List<String> toStringList(List<RBACRoleBindingName> values) {
    List<String> list = new ArrayList<>(values.size());
    for (RBACRoleBindingName value : values) {
      if (value == null) {
        list.add("");
      } else {
        list.add(value.toString());
      }
    }
    return list;
  }

  public static boolean isParsableFrom(String formattedString) {
    return PROJECT_LOCATION_SCOPE_RBACROLEBINDING.matches(formattedString)
        || PROJECT_LOCATION_MEMBERSHIP_RBACROLEBINDING.matches(formattedString);
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
          if (scope != null) {
            fieldMapBuilder.put("scope", scope);
          }
          if (rbacrolebinding != null) {
            fieldMapBuilder.put("rbacrolebinding", rbacrolebinding);
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
    return fixedValue != null ? fixedValue : pathTemplate.instantiate(getFieldValuesMap());
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o != null && getClass() == o.getClass()) {
      RBACRoleBindingName that = ((RBACRoleBindingName) o);
      return Objects.equals(this.project, that.project)
          && Objects.equals(this.location, that.location)
          && Objects.equals(this.scope, that.scope)
          && Objects.equals(this.rbacrolebinding, that.rbacrolebinding)
          && Objects.equals(this.membership, that.membership);
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= Objects.hashCode(fixedValue);
    h *= 1000003;
    h ^= Objects.hashCode(project);
    h *= 1000003;
    h ^= Objects.hashCode(location);
    h *= 1000003;
    h ^= Objects.hashCode(scope);
    h *= 1000003;
    h ^= Objects.hashCode(rbacrolebinding);
    h *= 1000003;
    h ^= Objects.hashCode(membership);
    return h;
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/scopes/{scope}/rbacrolebindings/{rbacrolebinding}.
   */
  public static class Builder {
    private String project;
    private String location;
    private String scope;
    private String rbacrolebinding;

    protected Builder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getScope() {
      return scope;
    }

    public String getRbacrolebinding() {
      return rbacrolebinding;
    }

    public Builder setProject(String project) {
      this.project = project;
      return this;
    }

    public Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    public Builder setScope(String scope) {
      this.scope = scope;
      return this;
    }

    public Builder setRbacrolebinding(String rbacrolebinding) {
      this.rbacrolebinding = rbacrolebinding;
      return this;
    }

    private Builder(RBACRoleBindingName rBACRoleBindingName) {
      Preconditions.checkArgument(
          Objects.equals(rBACRoleBindingName.pathTemplate, PROJECT_LOCATION_SCOPE_RBACROLEBINDING),
          "toBuilder is only supported when RBACRoleBindingName has the pattern of"
              + " projects/{project}/locations/{location}/scopes/{scope}/rbacrolebindings/{rbacrolebinding}");
      this.project = rBACRoleBindingName.project;
      this.location = rBACRoleBindingName.location;
      this.scope = rBACRoleBindingName.scope;
      this.rbacrolebinding = rBACRoleBindingName.rbacrolebinding;
    }

    public RBACRoleBindingName build() {
      return new RBACRoleBindingName(this);
    }
  }

  /**
   * Builder for
   * projects/{project}/locations/{location}/memberships/{membership}/rbacrolebindings/{rbacrolebinding}.
   */
  public static class ProjectLocationMembershipRbacrolebindingBuilder {
    private String project;
    private String location;
    private String membership;
    private String rbacrolebinding;

    protected ProjectLocationMembershipRbacrolebindingBuilder() {}

    public String getProject() {
      return project;
    }

    public String getLocation() {
      return location;
    }

    public String getMembership() {
      return membership;
    }

    public String getRbacrolebinding() {
      return rbacrolebinding;
    }

    public ProjectLocationMembershipRbacrolebindingBuilder setProject(String project) {
      this.project = project;
      return this;
    }

    public ProjectLocationMembershipRbacrolebindingBuilder setLocation(String location) {
      this.location = location;
      return this;
    }

    public ProjectLocationMembershipRbacrolebindingBuilder setMembership(String membership) {
      this.membership = membership;
      return this;
    }

    public ProjectLocationMembershipRbacrolebindingBuilder setRbacrolebinding(
        String rbacrolebinding) {
      this.rbacrolebinding = rbacrolebinding;
      return this;
    }

    public RBACRoleBindingName build() {
      return new RBACRoleBindingName(this);
    }
  }
}
