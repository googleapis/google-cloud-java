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

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.bigtable.v2.FeatureFlags;
import com.google.cloud.bigtable.data.v2.internal.api.ChannelProviders.ChannelProvider;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.ClientCall;
import io.grpc.ClientInterceptor;
import io.grpc.ManagedChannelBuilder;
import io.grpc.MethodDescriptor;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.util.Optional;
import javax.annotation.Nullable;

public class GaxBasicChannelProvider implements ChannelProvider {
  private final ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator;
  private final InstantiatingGrpcChannelProvider inner;
  private final @Nullable CallCredentials credentials;

  @SuppressWarnings("rawtypes")
  public GaxBasicChannelProvider(
      InstantiatingGrpcChannelProvider inner, @Nullable Credentials credentials) {
    this.channelConfigurator =
        Optional.ofNullable(inner.toBuilder().getChannelConfigurator()).orElse(b -> b);
    this.inner = inner.toBuilder().setAttemptDirectPath(false).build();
    this.credentials = Optional.ofNullable(credentials).map(MoreCallCredentials::from).orElse(null);
  }

  @Override
  public FeatureFlags updateFeatureFlags(FeatureFlags featureFlags) {
    return featureFlags.toBuilder()
        .setTrafficDirectorEnabled(false)
        .setDirectAccessRequested(false)
        .build();
  }

  @Override
  public ManagedChannelBuilder<?> newChannelBuilder() {
    try {
      ManagedChannelBuilder<?> builder = inner.createChannelBuilder();
      if (credentials != null) {
        builder.intercept(new CredInterceptor(credentials));
      }
      builder = channelConfigurator.apply(builder);
      return builder;
    } catch (IOException e) {
      throw new RuntimeException("Gax channel provider failed to provide a channel builder", e);
    }
  }

  @Override
  public boolean isSingleEndpoint() {
    return false;
  }

  private static class CredInterceptor implements ClientInterceptor {
    private final CallCredentials callCredentials;

    private CredInterceptor(CallCredentials callCredentials) {
      this.callCredentials = callCredentials;
    }

    @Override
    public <ReqT, RespT> ClientCall<ReqT, RespT> interceptCall(
        MethodDescriptor<ReqT, RespT> method, CallOptions callOptions, Channel next) {
      return next.newCall(method, callOptions.withCallCredentials(callCredentials));
    }
  }

  @Override
  public Optional<ChannelProvider> getFallback() {
    return Optional.empty();
  }
}
