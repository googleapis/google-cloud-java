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
import com.google.bigtable.admin.v2.InstanceName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import java.util.Map;
import javax.annotation.Nonnull;

/**
 * Represents an existing Cloud Bigtable instance.
 *
 * <p>A Cloud Bigtable instance is mostly just a container for your clusters and nodes, which do all
 * of the real work.
 */
public final class Instance {
  public enum Type {
    /** An instance meant for production use. `serve_nodes` must be set on the cluster. */
    PRODUCTION(com.google.bigtable.admin.v2.Instance.Type.PRODUCTION),
    /** The instance is meant for development and testing purposes only. */
    DEVELOPMENT(com.google.bigtable.admin.v2.Instance.Type.DEVELOPMENT),
    /** The type of instance is not known by this client. Please upgrade your client. */
    UNRECOGNIZED(com.google.bigtable.admin.v2.Instance.Type.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.Instance.Type proto;

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static Type fromProto(com.google.bigtable.admin.v2.Instance.Type proto) {
      Preconditions.checkNotNull(proto);
      Preconditions.checkArgument(
          proto != com.google.bigtable.admin.v2.Instance.Type.TYPE_UNSPECIFIED,
          "Server instance type must always be specified");
      for (Type type : values()) {
        if (type.proto.equals(proto)) {
          return type;
        }
      }
      return UNRECOGNIZED;
    }

    Type(com.google.bigtable.admin.v2.Instance.Type proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.Instance.Type toProto() {
      return proto;
    }
  }

  public enum State {
    /** The state of the instance could not be determined by the server. */
    NOT_KNOWN(com.google.bigtable.admin.v2.Instance.State.STATE_NOT_KNOWN),
    /** The instance has been successfully created and can serve requests to its tables. */
    READY(com.google.bigtable.admin.v2.Instance.State.READY),
    /**
     * The instance is currently being created, and may be destroyed if the creation process
     * encounters an error.
     */
    CREATING(com.google.bigtable.admin.v2.Instance.State.CREATING),
    /** The state of instance is not known by this client. Please upgrade your client. */
    UNRECOGNIZED(com.google.bigtable.admin.v2.Instance.State.UNRECOGNIZED);

    private final com.google.bigtable.admin.v2.Instance.State proto;

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static State fromProto(com.google.bigtable.admin.v2.Instance.State proto) {
      Preconditions.checkNotNull(proto);
      for (State state : values()) {
        if (state.proto.equals(proto)) {
          return state;
        }
      }
      return UNRECOGNIZED;
    }

    State(com.google.bigtable.admin.v2.Instance.State proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.Instance.State toProto() {
      return proto;
    }
  }

  @Nonnull private final com.google.bigtable.admin.v2.Instance proto;

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
    InstanceName fullName =
        Verify.verifyNotNull(InstanceName.parse(proto.getName()), "Name can never be null");

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
    return Type.fromProto(proto.getType());
  }

  /**
   * Gets the current labels associated with the instance.
   *
   * @see <a href="https://cloud.google.com/bigtable/docs/creating-managing-labels">For more
   *     details</a>
   */
  @SuppressWarnings("WeakerAccess")
  public Map<String, String> getLabels() {
    return proto.getLabelsMap();
  }

  /** The current state of the instance. */
  @SuppressWarnings("WeakerAccess")
  public State getState() {
    return State.fromProto(proto.getState());
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
