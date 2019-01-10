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
import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import javax.annotation.Nonnull;

/**
 * An application profile, or app profile, stores settings that tell your Cloud Bigtable instance
 * how to handle incoming requests from an application. When one of your applications connects to a
 * Cloud Bigtable instance, it can specify an app profile, and Cloud Bigtable uses that app profile
 * for any requests that the application sends over that connection.
 *
 * <p>App profiles affect how your applications communicate with an instance that uses replication.
 * As a result, app profiles are especially useful for instances that have 2 clusters. Even if your
 * instance has only 1 cluster, you can use a unique app profile for each application that you run,
 * or for different components within a single application.
 *
 * @see <a href="https://cloud.google.com/bigtable/docs/app-profiles">For more details</a>.
 */
public final class AppProfile {
  private final com.google.bigtable.admin.v2.AppProfile proto;

  /**
   * Wraps a protobuf response.
   *
   * <p>This method is considered an internal implementation detail and not meant to be used by
   * applications.
   */
  @InternalApi
  public static AppProfile fromProto(@Nonnull com.google.bigtable.admin.v2.AppProfile proto) {
    return new AppProfile(proto);
  }

  private AppProfile(@Nonnull com.google.bigtable.admin.v2.AppProfile proto) {
    Preconditions.checkNotNull(proto);
    Preconditions.checkArgument(
        proto.hasSingleClusterRouting() || proto.hasMultiClusterRoutingUseAny(),
        "AppProfile must have a routing policy");
    Preconditions.checkArgument(!proto.getName().isEmpty(), "AppProfile must have a name");
    this.proto = proto;
  }

  /** Gets the routing policy for all read/write requests which use this app profile. */
  @SuppressWarnings("WeakerAccess")
  public RoutingPolicy getPolicy() {
    if (proto.hasMultiClusterRoutingUseAny()) {
      return MultiClusterRoutingPolicy.of();
    } else if (proto.hasSingleClusterRouting()) {
      return new SingleClusterRoutingPolicy(proto.getSingleClusterRouting());
    } else {
      // Should never happen because the constructor verifies that one must exist.
      throw new VerifyException();
    }
  }

  /** Gets the id of this AppProfile. */
  @SuppressWarnings("WeakerAccess")
  public String getId() {
    AppProfileName fullName =
        Verify.verifyNotNull(AppProfileName.parse(proto.getName()), "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getAppProfile();
  }

  /** Gets the id of the instance that owns this AppProfile. */
  @SuppressWarnings("WeakerAccess")
  public String getInstanceId() {
    AppProfileName fullName =
        Verify.verifyNotNull(AppProfileName.parse(proto.getName()), "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getInstance();
  }

  /** Gets long form description of the use case for this AppProfile. */
  @SuppressWarnings("WeakerAccess")
  public String getDescription() {
    return proto.getDescription();
  }

  /**
   * Creates the request protobuf. This method is considered an internal implementation detail and
   * not meant to be used by applications.
   */
  com.google.bigtable.admin.v2.AppProfile toProto() {
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
    AppProfile that = (AppProfile) o;
    return Objects.equal(proto, that.proto);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(proto);
  }

  /**
   * Represents the routing for read/write requests. Please check the implementations of this
   * interface for more details.
   */
  @SuppressWarnings("WeakerAccess")
  public interface RoutingPolicy {}

  /** A {@link RoutingPolicy} that routes all requests to a specific cluster. */
  @SuppressWarnings("WeakerAccess")
  public static class SingleClusterRoutingPolicy implements RoutingPolicy {
    private final com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto;

    /**
     * Wraps a protobuf response.
     *
     * <p>This method is considered an internal implementation detail and not meant to be used by
     * applications.
     */
    @InternalApi
    public static SingleClusterRoutingPolicy fromProto(
        com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto) {
      return new SingleClusterRoutingPolicy(proto);
    }

    /**
     * Builds a new instance of the routing policy that will send all requests to the specified
     * cluster.
     *
     * <p>Please note that atomic row transactions will be disabled.
     */
    public static SingleClusterRoutingPolicy of(String clusterId) {
      return of(clusterId, false);
    }

    /**
     * Builds a new instance of the routing policy that will send all requests to the specified
     * cluster. This variant enables the ability to re-enable single row transactions at the cost of
     * consistency.
     *
     * <p>Please see the <a
     * href="https://cloud.google.com/bigtable/docs/app-profiles#single-row-transactions">online
     * documentation</a> for more details.
     */
    public static SingleClusterRoutingPolicy of(String clusterId, boolean allowTransactionWrites) {
      return fromProto(
          com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
              .setClusterId(clusterId)
              .setAllowTransactionalWrites(allowTransactionWrites)
              .build());
    }

    private SingleClusterRoutingPolicy(
        com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto) {
      this.proto = proto;
    }

    /** Gets the target cluster of this policy. */
    @SuppressWarnings("WeakerAccess")
    public String getClusterId() {
      return proto.getClusterId();
    }

    /** Checks if transactional writes are enabled. */
    @SuppressWarnings("WeakerAccess")
    public boolean getAllowTransactionalWrites() {
      return proto.getAllowTransactionalWrites();
    }

    /**
     * Wraps a protobuf response.
     *
     * <p>This method is considered an internal implementation detail and not meant to be used by
     * applications.
     */
    @InternalApi
    com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting toProto() {
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
      SingleClusterRoutingPolicy that = (SingleClusterRoutingPolicy) o;
      return Objects.equal(proto, that.proto);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(proto);
    }
  }

  /**
   * A {@link RoutingPolicy} that tells Cloud Bigtable that it can route each request to any
   * available cluster.
   */
  public static class MultiClusterRoutingPolicy implements RoutingPolicy {
    private static final MultiClusterRoutingUseAny proto =
        MultiClusterRoutingUseAny.getDefaultInstance();

    /** Creates a new instance of {@link MultiClusterRoutingPolicy}. */
    public static MultiClusterRoutingPolicy of() {
      return new MultiClusterRoutingPolicy();
    }

    private MultiClusterRoutingPolicy() {}

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    MultiClusterRoutingUseAny toProto() {
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

      return true;
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(proto);
    }
  }
}
