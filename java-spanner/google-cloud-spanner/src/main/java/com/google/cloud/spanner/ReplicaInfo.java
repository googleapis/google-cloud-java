/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner;

import com.google.common.annotations.VisibleForTesting;
import java.util.Objects;

/** Represents a Cloud Spanner replica information. */
public class ReplicaInfo {

  abstract static class Builder {
    abstract Builder setLocation(String location);

    abstract Builder setType(ReplicaType type);

    abstract Builder setDefaultLeaderLocation(boolean defaultLeaderLocation);

    abstract Builder setProto(com.google.spanner.admin.instance.v1.ReplicaInfo proto);

    public abstract ReplicaInfo build();
  }

  public static class BuilderImpl extends Builder {

    private String location;
    private ReplicaType type;
    private boolean defaultLeaderLocation;
    private com.google.spanner.admin.instance.v1.ReplicaInfo proto;

    /**
     * The location of the serving resources. This can be one of the values as specified in
     * https://cloud.google.com/spanner/docs/instances#available-configurations-regional.
     */
    @Override
    Builder setLocation(String location) {
      this.location = location;
      return this;
    }

    /** The type of the replica, as per {@link ReplicaType}. */
    @Override
    Builder setType(ReplicaType type) {
      this.type = type;
      return this;
    }

    /**
     * If true, this location is designated as the default leader location where leader replicas are
     * placed.
     */
    @Override
    Builder setDefaultLeaderLocation(boolean defaultLeaderLocation) {
      this.defaultLeaderLocation = defaultLeaderLocation;
      return this;
    }

    @Override
    Builder setProto(com.google.spanner.admin.instance.v1.ReplicaInfo proto) {
      this.proto = proto;
      return this;
    }

    @Override
    public ReplicaInfo build() {
      return new ReplicaInfo(this);
    }
  }

  public static ReplicaInfo fromProto(com.google.spanner.admin.instance.v1.ReplicaInfo proto) {
    return newBuilder()
        .setLocation(proto.getLocation())
        .setType(ReplicaType.fromProto(proto.getType()))
        .setDefaultLeaderLocation(proto.getDefaultLeaderLocation())
        .setProto(proto)
        .build();
  }

  static Builder newBuilder() {
    return new BuilderImpl();
  }

  private final String location;
  private final ReplicaType type;
  private final boolean defaultLeaderLocation;
  private final com.google.spanner.admin.instance.v1.ReplicaInfo proto;

  @VisibleForTesting
  ReplicaInfo(
      String location,
      ReplicaType type,
      boolean defaultLeaderLocation,
      com.google.spanner.admin.instance.v1.ReplicaInfo proto) {
    this.location = location;
    this.type = type;
    this.defaultLeaderLocation = defaultLeaderLocation;
    this.proto = proto;
  }

  ReplicaInfo(BuilderImpl builder) {
    this.location = builder.location;
    this.type = builder.type;
    this.defaultLeaderLocation = builder.defaultLeaderLocation;
    this.proto = builder.proto;
  }

  public String getLocation() {
    return location;
  }

  public ReplicaType getType() {
    return type;
  }

  public boolean isDefaultLeaderLocation() {
    return defaultLeaderLocation;
  }

  public com.google.spanner.admin.instance.v1.ReplicaInfo getProto() {
    return proto;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof ReplicaInfo)) {
      return false;
    }
    ReplicaInfo that = (ReplicaInfo) o;
    return defaultLeaderLocation == that.defaultLeaderLocation
        && Objects.equals(location, that.location)
        && type == that.type;
  }

  @Override
  public int hashCode() {
    return Objects.hash(location, type, defaultLeaderLocation);
  }

  @Override
  public String toString() {
    return "ReplicaInfo{"
        + "location='"
        + location
        + '\''
        + ", type="
        + type
        + ", defaultLeaderLocation="
        + defaultLeaderLocation
        + '}';
  }

  /**
   * Indicates the type of the replica. See the replica types documentation at
   * https://cloud.google.com/spanner/docs/replication#replica_types for more details.
   */
  public enum ReplicaType {
    TYPE_UNSPECIFIED,
    READ_WRITE,
    READ_ONLY,
    WITNESS;

    public static ReplicaType fromProto(
        com.google.spanner.admin.instance.v1.ReplicaInfo.ReplicaType proto) {
      switch (proto) {
        case TYPE_UNSPECIFIED:
          return ReplicaType.TYPE_UNSPECIFIED;
        case READ_WRITE:
          return ReplicaType.READ_WRITE;
        case READ_ONLY:
          return ReplicaType.READ_ONLY;
        case WITNESS:
          return ReplicaType.WITNESS;
        default:
          throw new IllegalArgumentException("Unrecognized replica type " + proto);
      }
    }
  }
}
