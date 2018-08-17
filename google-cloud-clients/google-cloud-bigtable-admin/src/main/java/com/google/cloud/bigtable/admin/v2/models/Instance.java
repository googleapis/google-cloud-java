/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.admin.v2.models;

import com.google.api.core.InternalApi;
import com.google.bigtable.admin.v2.Instance.State;
import com.google.bigtable.admin.v2.Instance.Type;
import com.google.bigtable.admin.v2.InstanceName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Represents an existing Cloud Bigtable instance.
 *
 * <p>A Cloud Bigtable instance is mostly just a container for your clusters and nodes, which do
 * all of the real work.
 */
public final class Instance {
  @Nonnull
  private final com.google.bigtable.admin.v2.Instance proto;

  /**
   * Wraps the protobuf. This method is considered an internal implementation detail and not meant
   * to be used by applications.
   */
  @InternalApi
  public static Instance fromProto(@Nonnull com.google.bigtable.admin.v2.Instance proto) {
    return new Instance(proto);
  }

  private Instance(@Nonnull com.google.bigtable.admin.v2.Instance proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(!proto.getName().isEmpty(), "Name must be set");
    this.proto = proto;
  }

  /** Gets the instance's id. */
  @SuppressWarnings("WeakerAccess")
  public String getId() {
    // Constructor ensures that name is not null
    InstanceName fullName = Verify.verifyNotNull(
        InstanceName.parse(proto.getName()),
        "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getInstance();
  }

  /** Gets the instance's friendly name. */
  @SuppressWarnings("WeakerAccess")
  public String getDisplayName() {
    return proto.getDisplayName();
  }

  /** Gets the instance's current type. Can be DEVELOPMENT or PRODUCTION. */
  @SuppressWarnings("WeakerAccess")
  public Type getType() {
    return proto.getType();
  }

  /**
   * Gets the current labels associated with the instance.
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/creating-managing-labels">For more
   * details</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Map<String, String> getLabels() {
    return proto.getLabelsMap();
  }


  /** The current state of the instance. */
  // TODO(igorbernstein2): Try to avoid leaking protobuf enums
  @SuppressWarnings("WeakerAccess")
  public State getState() {
    return proto.getState();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Instance instance = (Instance) o;
    return Objects.equal(proto, instance.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }
}
