/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.gcloud.resourcemanager;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.gcloud.IamPolicy;
import com.google.gcloud.Identity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * An Identity and Access Management (IAM) policy for a project. IAM policies are used to specify
 * access settings for Cloud Platform resources. A policy is a map of bindings. A binding assigns
 * a set of identities to a role, where the identities can be user accounts, Google groups, Google
 * domains, and service accounts. A role is a named list of permissions defined by IAM. Policies set
 * at the project level control access both to the project and to resources associated with the
 * project.
 *
 * @see <a href="https://cloud.google.com/iam/reference/rest/v1/Policy">Policy</a>
 */
public class Policy extends IamPolicy<Policy.Role> {

  private static final long serialVersionUID = -5573557282693961850L;

  /**
   * Represents legacy roles in an IAM Policy.
   */
  public static class Role implements Serializable {

    /**
     * The recognized roles in a Project's IAM policy.
     */
    public enum Type {

      /**
       * Permissions for read-only actions that preserve state.
       */
      VIEWER,

      /**
       * All viewer permissions and permissions for actions that modify state.
       */
      EDITOR,

      /**
       * All editor permissions and permissions for the following actions:
       * <ul>
       * <li>Manage access control for a resource.
       * <li>Set up billing (for a project).
       * </ul>
       */
      OWNER
    }

    private static final long serialVersionUID = 2421978909244287488L;

    private final String value;
    private final Type type;

    private Role(String value, Type type) {
      this.value = value;
      this.type = type;
    }

    String value() {
      return value;
    }

    /**
     * Returns the type of role (editor, owner, or viewer).  Returns {@code null} if the role type
     * is unrecognized.
     */
    public Type type() {
      return type;
    }

    /**
     * Returns a {@code Role} of type {@link Type#VIEWER VIEWER}.
     */
    public static Role viewer() {
      return new Role("roles/viewer", Type.VIEWER);
    }

    /**
     * Returns a {@code Role} of type {@link Type#EDITOR EDITOR}.
     */
    public static Role editor() {
      return new Role("roles/editor", Type.EDITOR);
    }

    /**
     * Returns a {@code Role} of type {@link Type#OWNER OWNER}.
     */
    public static Role owner() {
      return new Role("roles/owner", Type.OWNER);
    }

    static Role rawRole(String roleStr) {
      return new Role(roleStr, null);
    }

    static Role fromStr(String roleStr) {
      try {
        Type type = Type.valueOf(roleStr.split("/")[1].toUpperCase());
        return new Role(roleStr, type);
      } catch (Exception ex) {
        return new Role(roleStr, null);
      }
    }

    @Override
    public final int hashCode() {
      return Objects.hash(value, type);
    }

    @Override
    public final boolean equals(Object obj) {
      if (!(obj instanceof Role)) {
        return false;
      }
      Role other = (Role) obj;
      return Objects.equals(value, other.value()) && Objects.equals(type, other.type());
    }
  }

  /**
   * Builder for an IAM Policy.
   */
  public static class Builder extends IamPolicy.Builder<Role, Builder> {

    private Builder() {}

    @VisibleForTesting
    Builder(Map<Role, Set<Identity>> bindings, String etag, Integer version) {
      bindings(bindings).etag(etag).version(version);
    }

    @Override
    public Policy build() {
      return new Policy(this);
    }
  }

  private Policy(Builder builder) {
    super(builder);
  }

  public static Builder builder() {
    return new Builder();
  }

  @Override
  public Builder toBuilder() {
    return new Builder(bindings(), etag(), version());
  }

  @Override
  public String toString() {
    return toPb().toString();
  }

  com.google.api.services.cloudresourcemanager.model.Policy toPb() {
    com.google.api.services.cloudresourcemanager.model.Policy policyPb =
        new com.google.api.services.cloudresourcemanager.model.Policy();
    List<com.google.api.services.cloudresourcemanager.model.Binding> bindingPbList =
        new LinkedList<>();
    for (Map.Entry<Role, Set<Identity>> binding : bindings().entrySet()) {
      com.google.api.services.cloudresourcemanager.model.Binding bindingPb =
          new com.google.api.services.cloudresourcemanager.model.Binding();
      bindingPb.setRole(binding.getKey().value());
      bindingPb.setMembers(
          Lists.transform(
              new ArrayList<>(binding.getValue()),
              new Function<Identity, String>() {
                @Override
                public String apply(Identity identity) {
                  return identity.strValue();
                }
              }));
      bindingPbList.add(bindingPb);
    }
    policyPb.setBindings(bindingPbList);
    policyPb.setEtag(etag());
    policyPb.setVersion(version());
    return policyPb;
  }

  static Policy fromPb(
      com.google.api.services.cloudresourcemanager.model.Policy policyPb) {
    Map<Role, Set<Identity>> bindings = new HashMap<>();
    for (com.google.api.services.cloudresourcemanager.model.Binding bindingPb :
        policyPb.getBindings()) {
      bindings.put(
          Role.fromStr(bindingPb.getRole()),
          ImmutableSet.copyOf(
              Lists.transform(
                  bindingPb.getMembers(),
                  new Function<String, Identity>() {
                    @Override
                    public Identity apply(String identityPb) {
                      return Identity.valueOf(identityPb);
                    }
                  })));
    }
    return new Policy.Builder(bindings, policyPb.getEtag(), policyPb.getVersion()).build();
  }
}
