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
import com.google.bigtable.admin.v2.LogicalViewName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import javax.annotation.Nonnull;

/**
 * A class that wraps the {@link com.google.bigtable.admin.v2.LogicalView} protocol buffer object.
 *
 * <p>A LogicalView represents subsets of a particular table based on rules. The access to each
 * LogicalView can be configured separately from the Table.
 *
 * <p>Users can perform read/write operation on a LogicalView by providing a logicalView id besides
 * a table id, in which case the semantics remain identical as reading/writing on a Table except
 * that visibility is restricted to the subset of the Table that the LogicalView represents.
 */
public final class LogicalView {
  private final com.google.bigtable.admin.v2.LogicalView proto;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static LogicalView fromProto(@Nonnull com.google.bigtable.admin.v2.LogicalView proto) {
    return new LogicalView(proto);
  }

  private LogicalView(@Nonnull com.google.bigtable.admin.v2.LogicalView proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(!proto.getName().isEmpty(), "LogicalView must have a name");
    this.proto = proto;
  }

  /** Gets the logical view's id. */
  public String getId() {
    // Constructor ensures that name is not null.
    LogicalViewName fullName = LogicalViewName.parse(proto.getName());

    //noinspection ConstantConditions
    return fullName.getLogicalView();
  }

  /** Gets the id of the instance that owns this LogicalView. */
  @SuppressWarnings("WeakerAccess")
  public String getInstanceId() {
    LogicalViewName fullName =
        Verify.verifyNotNull(LogicalViewName.parse(proto.getName()), "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getInstance();
  }

  /** Gets the query of this logical view. */
  public String getQuery() {
    return proto.getQuery();
  }

  /** Returns whether this logical view is deletion protected. */
  public boolean isDeletionProtected() {
    return proto.getDeletionProtection();
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  @InternalApi
  public com.google.bigtable.admin.v2.LogicalView toProto() {
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
    LogicalView that = (LogicalView) o;
    return Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }
}
