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

import com.google.bigtable.admin.v2.AppProfile.MultiClusterRoutingUseAny;
import com.google.bigtable.admin.v2.AppProfileName;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.base.Verify;
import com.google.common.base.VerifyException;

public class AppProfile {
  private final com.google.bigtable.admin.v2.AppProfile proto;

  public static AppProfile fromProto(com.google.bigtable.admin.v2.AppProfile proto) {
    return new AppProfile(proto);
  }

  private AppProfile(com.google.bigtable.admin.v2.AppProfile proto) {
    this.proto = proto;
    Preconditions.checkArgument(proto.hasSingleClusterRouting() || proto.hasMultiClusterRoutingUseAny(), "AppProfile must have a routing policy");
  }

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

  public String getId() {
    AppProfileName fullName = Verify.verifyNotNull(
        AppProfileName.parse(proto.getName()),
        "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getAppProfile();
  }

  public String getInstanceId() {
    AppProfileName fullName = Verify.verifyNotNull(
        AppProfileName.parse(proto.getName()),
        "Name can never be null");

    //noinspection ConstantConditions
    return fullName.getInstance();
  }

  public String getDescription() {
    return proto.getDescription();
  }

  public String getEtag() {
    return proto.getEtag();
  }

  com.google.bigtable.admin.v2.AppProfile getProto() {
    return proto;
  }

  public interface RoutingPolicy {
  }

  public static class MultiClusterRoutingPolicy implements RoutingPolicy {
    private static final MultiClusterRoutingUseAny proto =  MultiClusterRoutingUseAny.getDefaultInstance();

    public static MultiClusterRoutingPolicy of() {
      return new MultiClusterRoutingPolicy();
    }

    private MultiClusterRoutingPolicy() {
    }

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

  public static class SingleClusterRoutingPolicy implements RoutingPolicy {
    private final com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto;

    public static SingleClusterRoutingPolicy fromProto(com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto) {
      return new SingleClusterRoutingPolicy(proto);
    }

    public static SingleClusterRoutingPolicy of(String clusterId) {
      return fromProto(
          com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
              .setClusterId(clusterId)
              .build()
      );
    }

    public static SingleClusterRoutingPolicy of(String clusterId, boolean allowTransactionWrites) {
      return fromProto(
          com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting.newBuilder()
              .setClusterId(clusterId)
              .setAllowTransactionalWrites(allowTransactionWrites)
              .build()
      );
    }

    private SingleClusterRoutingPolicy(com.google.bigtable.admin.v2.AppProfile.SingleClusterRouting proto) {
      this.proto = proto;
    }

    public String getClusterId() {
      return proto.getClusterId();
    }

    public boolean getAllowTransactionalWrites() {
      return proto.getAllowTransactionalWrites();
    }

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
}
