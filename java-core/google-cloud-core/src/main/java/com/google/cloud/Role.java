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

package com.google.cloud;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;
import java.util.Objects;

/**
 * A role in a IAM {@link Policy}. Project owners can grant access to team members to access
 * project's resources and APIs by granting IAM roles to team members.
 *
 * @see <a href="https://cloud.google.com/iam/docs/viewing-grantable-roles">Viewing the Grantable
 *     Roles on Resources</a>
 * @see <a href="https://cloud.google.com/iam/docs/understanding-roles">Understanding Roles</a>
 */
public final class Role implements Serializable {

  private static final long serialVersionUID = -7779252712160972508L;
  private static final String ROLE_PREFIX = "roles/";

  private final String value;

  private Role(String value) {
    this.value = value;
  }

  /**
   * Returns the string identifier for this role. For example, {@code "roles/viewer"},
   * {@code "roles/editor"}, or {@code "roles/owner"}.
   */
  @Deprecated
  public String value() {
    return getValue();
  }

  /**
   * Returns the string identifier for this role. For example, {@code "roles/viewer"},
   * {@code "roles/editor"}, or {@code "roles/owner"}.
   */
  public String getValue() {
    return value;
  }

  /**
   * Returns the viewer role. Encapsulates the permission for read-only actions that preserve state
   * of a resource.
   *
   * @see <a href="https://cloud.google.com/iam/docs/understanding-roles">Understanding Roles</a>
   */
  public static Role viewer() {
    return of("viewer");
  }

  /**
   * Returns the editor role. Encapsulates all viewer's permissions and permissions for actions that
   * modify the state of a resource.
   *
   * @see <a href="https://cloud.google.com/iam/docs/understanding-roles">Understanding Roles</a>
   */
  public static Role editor() {
    return of("editor");
  }

  /**
   * Returns the owner role. Encapsulates all editor's permissions and permissions to manage access
   * control for a resource or manage the billing options for a project.
   *
   * @see <a href="https://cloud.google.com/iam/docs/understanding-roles">Understanding Roles</a>
   */
  public static Role owner() {
    return of("owner");
  }

  /**
   * Returns a new role given its string value.
   *
   * @param value the string value for the role, for example, {@code "roles/viewer"},
   *     {@code "roles/editor"}, or {@code "roles/owner"}. If this value does not start with the
   *     role prefix {@code roles/}, the prefix is prepended.
   * @see <a href="https://cloud.google.com/iam/docs/viewing-grantable-roles">Viewing the Grantable
   *     Roles on Resources</a>
   */
  public static Role of(String value) {
    checkNotNull(value);
    return new Role(value.startsWith(ROLE_PREFIX) ? value : ROLE_PREFIX + value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    return value;
  }

  @Override
  public boolean equals(Object obj) {
    return obj instanceof Role && Objects.equals(value, ((Role) obj).getValue());
  }
}
