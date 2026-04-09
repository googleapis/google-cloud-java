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
package com.google.cloud.bigtable.data.v2.internal.compat;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.bigtable.v2.FeatureFlags;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import io.grpc.ManagedChannelBuilder;
import java.io.IOException;
import java.util.Optional;
import javax.annotation.Nullable;

public class GaxDirectAccessChannelProvider implements ChannelProvider {
  private final InstantiatingGrpcChannelProvider inner;
  private final Optional<ChannelProvider> fallback;

  public static ChannelProvider create(
      InstantiatingGrpcChannelProvider outer, @Nullable Credentials credentials) {
    InstantiatingGrpcChannelProvider directAccessProvider =
        outer.toBuilder().setAttemptDirectPath(true).setAttemptDirectPathXds().build();

    InstantiatingGrpcChannelProvider cloudPathProvider =
        outer.toBuilder().setAttemptDirectPath(false).build();

    if (directAccessProvider.canUseDirectPath()) {
      return new GaxDirectAccessChannelProvider(
          directAccessProvider, credentials, Optional.empty());
    } else {
      return new GaxBasicChannelProvider(cloudPathProvider, credentials);
    }
  }

  public static ChannelProvider createWithFallback(
      InstantiatingGrpcChannelProvider outer, @Nullable Credentials credentials) {
    InstantiatingGrpcChannelProvider directAccessProvider =
        outer.toBuilder().setAttemptDirectPath(true).setAttemptDirectPathXds().build();

    InstantiatingGrpcChannelProvider cloudPathProvider =
        outer.toBuilder().setAttemptDirectPath(false).build();

    if (directAccessProvider.canUseDirectPath()) {
      return new GaxDirectAccessChannelProvider(
          directAccessProvider,
          credentials,
          Optional.of(new GaxBasicChannelProvider(cloudPathProvider, credentials)));
    } else {
      return new GaxBasicChannelProvider(cloudPathProvider, credentials);
    }
  }

  private GaxDirectAccessChannelProvider(
      InstantiatingGrpcChannelProvider directAccessProvider,
      @SuppressWarnings("unused") @Nullable Credentials credentials,
      Optional<ChannelProvider> fallback) {
    this.inner = directAccessProvider;
    this.fallback = fallback;
  }

  @Override
  public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
    return featureFlags.toBuilder()
        .setTrafficDirectorEnabled(true)
        .setDirectAccessRequested(true)
        .build();
  }

  @Override
  public ManagedChannelBuilder<?> newChannelBuilder() {
    try {
      return inner.createChannelBuilder();
    } catch (IOException e) {
      throw new RuntimeException("Gax channel provider failed to provide a channel builder", e);
    }
  }

  @Override
  public boolean isSingleEndpoint() {
    return false;
  }

  @Override
  public Optional<ChannelProvider> getFallback() {
    return fallback;
  }
}
