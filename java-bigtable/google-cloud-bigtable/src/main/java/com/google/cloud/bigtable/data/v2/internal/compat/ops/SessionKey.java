/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.internal.compat.ops;

import com.google.bigtable.v2.OpenAuthorizedViewRequest;
import com.google.bigtable.v2.OpenMaterializedViewRequest;
import com.google.bigtable.v2.OpenTableRequest;
import java.util.Objects;

/**
 * Cache key for {@link SessionPoolMap}: pairs a target ID with the {@link Permission} required by
 * the operation. Two callers that request the same ID and the same permission get the same
 * session-pool handle, regardless of which shim they came from.
 */
public final class SessionKey<T> {

  /** The access permission requested when opening a session for a given target. */
  public enum Permission {
    READ(
        OpenTableRequest.Permission.PERMISSION_READ,
        OpenAuthorizedViewRequest.Permission.PERMISSION_READ,
        OpenMaterializedViewRequest.Permission.PERMISSION_READ),
    WRITE(
        OpenTableRequest.Permission.PERMISSION_WRITE,
        OpenAuthorizedViewRequest.Permission.PERMISSION_WRITE,
        null),
    READ_WRITE(
        OpenTableRequest.Permission.PERMISSION_READ_WRITE,
        OpenAuthorizedViewRequest.Permission.PERMISSION_READ_WRITE,
        null);

    private final OpenTableRequest.Permission tablePermission;
    private final OpenAuthorizedViewRequest.Permission authViewPermission;
    private final OpenMaterializedViewRequest.Permission matViewPermission;

    Permission(
        OpenTableRequest.Permission tablePermission,
        OpenAuthorizedViewRequest.Permission authViewPermission,
        OpenMaterializedViewRequest.Permission matViewPermission) {
      this.tablePermission = tablePermission;
      this.authViewPermission = authViewPermission;
      this.matViewPermission = matViewPermission;
    }

    public OpenTableRequest.Permission tablePermission() {
      return tablePermission;
    }

    public OpenAuthorizedViewRequest.Permission authViewPermission() {
      return authViewPermission;
    }

    public OpenMaterializedViewRequest.Permission matViewPermission() {
      if (matViewPermission == null) {
        throw new UnsupportedOperationException(
            "MaterializedView does not support permission: " + this);
      }
      return matViewPermission;
    }
  }

  private final T id;
  private final Permission permission;

  public SessionKey(T id, Permission permission) {
    this.id = id;
    this.permission = permission;
  }

  public T id() {
    return id;
  }

  public Permission permission() {
    return permission;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof SessionKey)) return false;
    SessionKey<?> that = (SessionKey<?>) o;
    return Objects.equals(id, that.id) && permission == that.permission;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, permission);
  }

  @Override
  public String toString() {
    return "SessionKey{id=" + id + ", permission=" + permission + "}";
  }
}
