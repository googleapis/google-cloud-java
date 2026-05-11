/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.bigtable.admin.v2.AuthorizedViewName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import javax.annotation.Nonnull;

/**
 * A class that wraps the {@link com.google.bigtable.admin.v2.AuthorizedView} protocol buffer
 * object.
 *
 * <p>An AuthorizedView represents subsets of a particular table based on rules. The access to each
 * AuthorizedView can be configured separately from the Table.
 *
 * <p>Users can perform read/write operation on an AuthorizedView by providing an authorizedView id
 * besides a table id, in which case the semantics remain identical as reading/writing on a Table
 * except that visibility is restricted to the subset of the Table that the AuthorizedView
 * represents.
 */
public final class AuthorizedView {
  private final com.google.bigtable.admin.v2.AuthorizedView proto;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static AuthorizedView fromProto(
      @Nonnull com.google.bigtable.admin.v2.AuthorizedView proto) {
    return new AuthorizedView(proto);
  }

  private AuthorizedView(@Nonnull com.google.bigtable.admin.v2.AuthorizedView proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(!proto.getName().isEmpty(), "AuthorizedView must have a name");
    Preconditions.checkArgument(
        proto.hasSubsetView(), "AuthorizedView must have a subset_view field");
    this.proto = proto;
  }

  /** Gets the authorized view's id. */
  public String getId() {
    // Constructor ensures that name is not null.
    AuthorizedViewName fullName = AuthorizedViewName.parse(proto.getName());

    //noinspection ConstantConditions
    return fullName.getAuthorizedView();
  }

  /** Gets the id of the table that owns this authorized view. */
  public String getTableId() {
    // Constructor ensures that name is not null.
    AuthorizedViewName fullName = AuthorizedViewName.parse(proto.getName());

    //noinspection ConstantConditions
    return fullName.getTable();
  }

  /** Returns whether this authorized view is deletion protected. */
  public boolean isDeletionProtected() {
    return proto.getDeletionProtection();
  }

  /** Gets the type of this authorized view, which currently can only be a subset view. */
  public AuthorizedViewType getAuthorizedViewType() {
    if (proto.hasSubsetView()) {
      return SubsetView.fromProto(proto.getSubsetView());
    } else {
      // Should never happen because the constructor verifies that one must exist.
      throw new IllegalStateException("This AuthorizedView doesn't have a valid type specified");
    }
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.AuthorizedView toProto() {
    return proto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthorizedView that = (AuthorizedView) o;
    return Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  /**
   * Represents a subset of a Table. Please check the implementations of this interface for more
   * details.
   */
  @InternalExtensionOnly
  public interface AuthorizedViewType {}
}
