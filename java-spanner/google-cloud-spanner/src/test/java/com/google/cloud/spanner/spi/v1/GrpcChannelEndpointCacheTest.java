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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.SpannerException;
import io.grpc.ManagedChannelBuilder;
import org.junit.Test;

public class GrpcChannelEndpointCacheTest {
  private static final String DEFAULT_ENDPOINT = "default.invalid:1234";
  private static final String ROUTED_ENDPOINT_A = "replica-a.invalid:1111";
  private static final String ROUTED_ENDPOINT_B = "replica-b.invalid:2222";

  private static InstantiatingGrpcChannelProvider createProvider(String endpoint) {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setEndpoint(endpoint)
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .build();
  }

  @Test
  public void defaultChannelIsCached() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint defaultChannel = cache.defaultChannel();
      ChannelEndpoint server = cache.get(defaultChannel.getAddress());
      assertThat(server).isSameInstanceAs(defaultChannel);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void getCachesPerAddress() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint first = cache.get(ROUTED_ENDPOINT_A);
      ChannelEndpoint second = cache.get(ROUTED_ENDPOINT_A);
      ChannelEndpoint third = cache.get(ROUTED_ENDPOINT_B);

      assertThat(second).isSameInstanceAs(first);
      assertThat(third).isNotSameInstanceAs(first);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void routedChannelsReuseDefaultAuthority() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint routed = cache.get(ROUTED_ENDPOINT_A);

      assertThat(routed.getChannel().authority()).isEqualTo(DEFAULT_ENDPOINT);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void routedChannelsUseSingleUnderlyingChannel() throws Exception {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setPoolSize(4)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .build();
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(provider);
    try {
      InstantiatingGrpcChannelProvider routedProvider =
          cache.createProviderWithAuthorityOverride(ROUTED_ENDPOINT_A);

      assertThat(provider.toBuilder().getPoolSize()).isEqualTo(4);
      assertThat(routedProvider.getChannelPoolSettings().getInitialChannelCount()).isEqualTo(1);
      assertThat(routedProvider.getChannelPoolSettings().getMinChannelCount()).isEqualTo(1);
      assertThat(routedProvider.getChannelPoolSettings().getMaxChannelCount()).isEqualTo(1);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void routedChannelsOverrideKeepAliveSettingsOnlyForEndpointProvider() throws Exception {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setEndpoint(DEFAULT_ENDPOINT)
            .setPoolSize(4)
            .setKeepAliveTimeDuration(java.time.Duration.ofSeconds(120))
            .setKeepAliveTimeoutDuration(java.time.Duration.ofSeconds(60))
            .setKeepAliveWithoutCalls(Boolean.FALSE)
            .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
            .build();
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(provider);
    try {
      InstantiatingGrpcChannelProvider routedProvider =
          cache.createProviderWithAuthorityOverride(ROUTED_ENDPOINT_A);

      assertThat(provider.getKeepAliveWithoutCalls()).isFalse();
      assertThat(provider.getKeepAliveTimeDuration()).isEqualTo(java.time.Duration.ofSeconds(120));
      assertThat(provider.getKeepAliveTimeoutDuration())
          .isEqualTo(java.time.Duration.ofSeconds(60));
      assertThat(routedProvider.getKeepAliveWithoutCalls()).isTrue();
      assertThat(routedProvider.getKeepAliveTimeDuration())
          .isEqualTo(GrpcChannelEndpointCache.ROUTED_KEEPALIVE_TIME);
      assertThat(routedProvider.getKeepAliveTimeoutDuration())
          .isEqualTo(GrpcChannelEndpointCache.ROUTED_KEEPALIVE_TIMEOUT);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void evictRemovesNonDefaultServer() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint first = cache.get(ROUTED_ENDPOINT_A);
      cache.evict(ROUTED_ENDPOINT_A);
      ChannelEndpoint second = cache.get(ROUTED_ENDPOINT_A);

      assertThat(second).isNotSameInstanceAs(first);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void evictIgnoresDefaultChannel() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint defaultChannel = cache.defaultChannel();
      cache.evict(defaultChannel.getAddress());
      ChannelEndpoint server = cache.get(defaultChannel.getAddress());

      assertThat(server).isSameInstanceAs(defaultChannel);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void shutdownPreventsNewServers() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    cache.shutdown();

    assertThrows(SpannerException.class, () -> cache.get(ROUTED_ENDPOINT_A));
    assertThat(cache.defaultChannel().getChannel().isShutdown()).isTrue();
  }

  @Test
  public void healthReflectsChannelShutdown() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider(DEFAULT_ENDPOINT));
    try {
      ChannelEndpoint server = cache.get(ROUTED_ENDPOINT_A);
      // Newly created channel is not READY (likely IDLE), so isHealthy is false for location aware.
      // isHealthy now requires READY state for location aware routing.
      assertThat(server.isHealthy()).isFalse();

      server.getChannel().shutdownNow();
      assertThat(server.isHealthy()).isFalse();
      assertThat(server.isTransientFailure()).isFalse();
    } finally {
      cache.shutdown();
    }
  }
}
