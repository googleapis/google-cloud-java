/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import javax.annotation.Nullable;

final class KeyAwareTransportChannelProvider implements TransportChannelProvider {
  private final InstantiatingGrpcChannelProvider baseProvider;
  @Nullable private final ChannelEndpointCacheFactory endpointCacheFactory;

  KeyAwareTransportChannelProvider(
      InstantiatingGrpcChannelProvider.Builder builder,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory) {
    this.baseProvider = builder.build();
    this.endpointCacheFactory = endpointCacheFactory;
  }

  KeyAwareTransportChannelProvider(
      InstantiatingGrpcChannelProvider baseProvider,
      @Nullable ChannelEndpointCacheFactory endpointCacheFactory) {
    this.baseProvider = baseProvider;
    this.endpointCacheFactory = endpointCacheFactory;
  }

  @Override
  public GrpcTransportChannel getTransportChannel() throws IOException {
    return GrpcTransportChannel.newBuilder()
        .setManagedChannel(KeyAwareChannel.create(baseProvider, endpointCacheFactory))
        .build();
  }

  @Override
  public String getTransportName() {
    return baseProvider.getTransportName();
  }

  @Override
  public boolean needsEndpoint() {
    return baseProvider.needsEndpoint();
  }

  @Override
  public boolean needsCredentials() {
    return baseProvider.needsCredentials();
  }

  @Override
  public boolean needsExecutor() {
    return baseProvider.needsExecutor();
  }

  @Override
  public boolean needsHeaders() {
    return baseProvider.needsHeaders();
  }

  @Override
  public boolean shouldAutoClose() {
    return baseProvider.shouldAutoClose();
  }

  @Override
  public TransportChannelProvider withEndpoint(String endpoint) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withEndpoint(endpoint),
        endpointCacheFactory);
  }

  @Override
  public TransportChannelProvider withCredentials(Credentials credentials) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withCredentials(credentials),
        endpointCacheFactory);
  }

  @Override
  public TransportChannelProvider withHeaders(Map<String, String> headers) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withHeaders(headers), endpointCacheFactory);
  }

  @Override
  public TransportChannelProvider withPoolSize(int poolSize) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withPoolSize(poolSize),
        endpointCacheFactory);
  }

  @Override
  public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withExecutor(executor),
        endpointCacheFactory);
  }

  @Override
  public TransportChannelProvider withExecutor(Executor executor) {
    return new KeyAwareTransportChannelProvider(
        (InstantiatingGrpcChannelProvider) baseProvider.withExecutor(executor),
        endpointCacheFactory);
  }

  @Override
  public boolean acceptsPoolSize() {
    return baseProvider.acceptsPoolSize();
  }
}
