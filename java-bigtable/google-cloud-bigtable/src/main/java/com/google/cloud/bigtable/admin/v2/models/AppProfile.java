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
import com.google.bigtable.admin.v2.AppProfile.Priority;
import com.google.bigtable.admin.v2.AppProfile.StandardIsolation;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
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
      return MultiClusterRoutingPolicy.of(
          ImmutableSet.copyOf(proto.getMultiClusterRoutingUseAny().getClusterIdsList()));
    } else if (proto.hasSingleClusterRouting()) {
      return new SingleClusterRoutingPolicy(proto.getSingleClusterRouting());
    } else {
      // Should never happen because the constructor verifies that one must exist.
      throw new VerifyException();
    }
  }

  public IsolationPolicy getIsolationPolicy() {
    if (proto.hasStandardIsolation()) {
      return new StandardIsolationPolicy(proto.getStandardIsolation());
    } else {
      // Should never happen because the constructor verifies that one must exist.
      throw new IllegalStateException();
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
    private final MultiClusterRoutingUseAny proto;

    /** Creates a new instance of {@link MultiClusterRoutingPolicy}. */
    public static MultiClusterRoutingPolicy of() {
      return new MultiClusterRoutingPolicy(MultiClusterRoutingUseAny.getDefaultInstance());
    }

    /**
     * Creates a new instance of {@link MultiClusterRoutingPolicy} with specified cluster ids to
     * route to.
     */
    public static MultiClusterRoutingPolicy of(String... clusterIds) {
      return of(ImmutableSet.copyOf(clusterIds));
    }

    /**
     * Creates a new instance of {@link MultiClusterRoutingPolicy} with specified cluster ids to
     * route to.
     */
    public static MultiClusterRoutingPolicy of(Set<String> clusterIds) {
      return new MultiClusterRoutingPolicy(
          MultiClusterRoutingUseAny.newBuilder().addAllClusterIds(clusterIds).build());
    }

    /*
     * Returns the set of clusters to route to. The order is ignored; clusters will be
     * tried in order of distance. If empty, all clusters are eligible.
     */
    public Set<String> getClusterIds() {
      return ImmutableSet.copyOf(proto.getClusterIdsList());
    }

    private MultiClusterRoutingPolicy(
        com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny proto) {
      this.proto = proto;
    }

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
      MultiClusterRoutingPolicy that = (MultiClusterRoutingPolicy) o;
      return Objects.equal(proto, that.proto);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(proto);
    }
  }

  /** Represents the options for isolating this app profile's traffic from other use cases. */
  @SuppressWarnings("WeakerAccess")
  public interface IsolationPolicy {}

  /**
   * The possible priorities for an app profile. Note that higher priority writes can sometimes
   * queue behind lower priority writes to the same tablet, as writes must be strictly sequenced in
   * the durability log.
   */
  public static enum Priority {
    LOW(com.google.bigtable.admin.v2.AppProfile.Priority.PRIORITY_LOW),
    MEDIUM(com.google.bigtable.admin.v2.AppProfile.Priority.PRIORITY_MEDIUM),
    HIGH(com.google.bigtable.admin.v2.AppProfile.Priority.PRIORITY_HIGH);

    private final com.google.bigtable.admin.v2.AppProfile.Priority proto;

    /**
     * Wraps the protobuf. This method is considered an internal implementation detail and not meant
     * to be used by applications.
     */
    @InternalApi
    public static Priority fromProto(com.google.bigtable.admin.v2.AppProfile.Priority proto) {
      Preconditions.checkNotNull(proto);

      for (Priority priority : values()) {
        if (priority.proto.equals(proto)) {
          return priority;
        }
      }

      throw new IllegalArgumentException("Unknown priority: " + proto);
    }

    Priority(com.google.bigtable.admin.v2.AppProfile.Priority proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    public com.google.bigtable.admin.v2.AppProfile.Priority toProto() {
      return proto;
    }
  }

  /**
   * A standard {@link IsolationPolicy} for isolating this app profile's traffic from other use
   * cases. This accomplished by assigning different priorities to app profiles. A request that uses
   * an app profile with a StandardIsolationPolicy with a HIGH priority will likely run before a
   * request with a LOW priority.
   */
  public static class StandardIsolationPolicy implements IsolationPolicy {
    private final StandardIsolation proto;

    /** Creates a new instance of {@link StandardIsolationPolicy}. */
    public static StandardIsolationPolicy of() {
      return new StandardIsolationPolicy(StandardIsolation.getDefaultInstance());
    }

    /** Creates a new instance of {@link StandardIsolationPolicy} with the specified priority. */
    public static StandardIsolationPolicy of(Priority priority) {
      return new StandardIsolationPolicy(
          StandardIsolation.newBuilder().setPriority(priority.toProto()).build());
    }

    /*
     * Returns the priority for this app profile.
     */
    public Priority getPriority() {
      return Priority.fromProto(proto.getPriority());
    }

    private StandardIsolationPolicy(
        com.google.bigtable.admin.v2.AppProfile.StandardIsolation proto) {
      this.proto = proto;
    }

    /**
     * Creates the request protobuf. This method is considered an internal implementation detail and
     * not meant to be used by applications.
     */
    @InternalApi
    com.google.bigtable.admin.v2.AppProfile.StandardIsolation toProto() {
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
      StandardIsolationPolicy that = (StandardIsolationPolicy) o;
      return Objects.equal(proto, that.proto);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(proto);
    }
  }
}
