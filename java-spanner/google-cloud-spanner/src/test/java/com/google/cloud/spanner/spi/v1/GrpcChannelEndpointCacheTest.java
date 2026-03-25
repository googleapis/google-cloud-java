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

  private static InstantiatingGrpcChannelProvider createProvider(String endpoint) {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setEndpoint(endpoint)
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .build();
  }

  @Test
  public void defaultChannelIsCached() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
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
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
    try {
      ChannelEndpoint first = cache.get("localhost:1111");
      ChannelEndpoint second = cache.get("localhost:1111");
      ChannelEndpoint third = cache.get("localhost:2222");

      assertThat(second).isSameInstanceAs(first);
      assertThat(third).isNotSameInstanceAs(first);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void evictRemovesNonDefaultServer() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
    try {
      ChannelEndpoint first = cache.get("localhost:1111");
      cache.evict("localhost:1111");
      ChannelEndpoint second = cache.get("localhost:1111");

      assertThat(second).isNotSameInstanceAs(first);
    } finally {
      cache.shutdown();
    }
  }

  @Test
  public void evictIgnoresDefaultChannel() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
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
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
    cache.shutdown();

    assertThrows(SpannerException.class, () -> cache.get("localhost:1111"));
    assertThat(cache.defaultChannel().getChannel().isShutdown()).isTrue();
  }

  @Test
  public void healthReflectsChannelShutdown() throws Exception {
    GrpcChannelEndpointCache cache = new GrpcChannelEndpointCache(createProvider("localhost:1234"));
    try {
      ChannelEndpoint server = cache.get("localhost:1111");
      assertThat(server.isHealthy()).isTrue();

      server.getChannel().shutdownNow();
      assertThat(server.isHealthy()).isFalse();
    } finally {
      cache.shutdown();
    }
  }
}
