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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.google.protobuf.ByteString;
import com.google.spanner.v1.CacheUpdate;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.Group;
import com.google.spanner.v1.Range;
import com.google.spanner.v1.RoutingHint;
import com.google.spanner.v1.Tablet;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class KeyRangeCacheTest {

  @Test
  public void skipsUnhealthyTabletAfterItIsCached() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    cache.addRanges(
        CacheUpdate.newBuilder()
            .addRange(
                Range.newBuilder()
                    .setStartKey(bytes("a"))
                    .setLimitKey(bytes("z"))
                    .setGroupUid(5)
                    .setSplitId(1)
                    .setGeneration(bytes("1")))
            .addGroup(
                Group.newBuilder()
                    .setGroupUid(5)
                    .setGeneration(bytes("1"))
                    .setLeaderIndex(0)
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(1)
                            .setServerAddress("server1")
                            .setIncarnation(bytes("1"))
                            .setDistance(0))
                    .addTablets(
                        Tablet.newBuilder()
                            .setTabletUid(2)
                            .setServerAddress("server2")
                            .setIncarnation(bytes("1"))
                            .setDistance(0)))
            .build());

    RoutingHint.Builder initialHint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint initialServer =
        cache.fillRoutingHint(
            /* preferLeader= */ false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            initialHint);
    assertNotNull(initialServer);

    endpointCache.setHealthy("server1", false);

    RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes("a"));
    ChannelEndpoint server =
        cache.fillRoutingHint(
            /* preferLeader= */ false,
            KeyRangeCache.RangeMode.COVERING_SPLIT,
            DirectedReadOptions.getDefaultInstance(),
            hint);

    assertNotNull(server);
    assertEquals("server2", server.getAddress());
    assertEquals(1, hint.getSkippedTabletUidCount());
    assertEquals(1L, hint.getSkippedTabletUid(0).getTabletUid());
  }

  @Test
  public void shrinkToEvictsRanges() {
    FakeEndpointCache endpointCache = new FakeEndpointCache();
    KeyRangeCache cache = new KeyRangeCache(endpointCache);

    final int numRanges = 100;
    for (int i = 0; i < numRanges; i++) {
      CacheUpdate update =
          CacheUpdate.newBuilder()
              .addRange(
                  Range.newBuilder()
                      .setStartKey(bytes(String.format("%04d", i)))
                      .setLimitKey(bytes(String.format("%04d", i + 1)))
                      .setGroupUid(i)
                      .setSplitId(i)
                      .setGeneration(bytes("1")))
              .addGroup(
                  Group.newBuilder()
                      .setGroupUid(i)
                      .setGeneration(bytes("1"))
                      .addTablets(
                          Tablet.newBuilder()
                              .setTabletUid(i)
                              .setServerAddress("server" + i)
                              .setIncarnation(bytes("1"))))
              .build();
      cache.addRanges(update);
    }

    checkContents(cache, numRanges, numRanges);

    int shrinkTo = numRanges - numRanges / 4;
    cache.shrinkTo(shrinkTo);
    checkContents(cache, shrinkTo, 3 * numRanges / 4);

    cache.shrinkTo(numRanges / 8);
    checkContents(cache, numRanges / 8, 7 * numRanges / 8);

    cache.shrinkTo(0);
    checkContents(cache, 0, numRanges);
  }

  private static void checkContents(KeyRangeCache cache, int expectedSize, int mustBeInCache) {
    assertEquals(expectedSize, cache.size());
    int hitCount = 0;
    for (int i = 0; i < 100; i++) {
      RoutingHint.Builder hint = RoutingHint.newBuilder().setKey(bytes(String.format("%04d", i)));
      ChannelEndpoint server =
          cache.fillRoutingHint(
              /* preferLeader= */ false,
              KeyRangeCache.RangeMode.COVERING_SPLIT,
              DirectedReadOptions.getDefaultInstance(),
              hint);
      if (i > mustBeInCache) {
        assertNotNull(server);
      }
      if (server != null) {
        hitCount++;
        assertEquals("server" + i, server.getAddress());
      }
    }
    assertEquals(expectedSize, hitCount);
  }

  private static ByteString bytes(String value) {
    return ByteString.copyFromUtf8(value);
  }

  private static final class FakeEndpointCache implements ChannelEndpointCache {
    private final Map<String, FakeEndpoint> endpoints = new HashMap<>();
    private final FakeEndpoint defaultEndpoint = new FakeEndpoint("default");

    @Override
    public ChannelEndpoint defaultChannel() {
      return defaultEndpoint;
    }

    @Override
    public ChannelEndpoint get(String address) {
      return endpoints.computeIfAbsent(address, FakeEndpoint::new);
    }

    @Override
    public void evict(String address) {
      endpoints.remove(address);
    }

    @Override
    public void shutdown() {
      endpoints.clear();
    }

    void setHealthy(String address, boolean healthy) {
      FakeEndpoint endpoint = endpoints.get(address);
      if (endpoint != null) {
        endpoint.setHealthy(healthy);
      }
    }
  }

  private static final class FakeEndpoint implements ChannelEndpoint {
    private final String address;
    private final ManagedChannel channel = new FakeManagedChannel();
    private boolean healthy = true;

    FakeEndpoint(String address) {
      this.address = address;
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      return healthy;
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
    }

    void setHealthy(boolean healthy) {
      this.healthy = healthy;
    }
  }

  private static final class FakeManagedChannel extends ManagedChannel {
    private boolean shutdown = false;

    @Override
    public ManagedChannel shutdown() {
      shutdown = true;
      return this;
    }

    @Override
    public boolean isShutdown() {
      return shutdown;
    }

    @Override
    public boolean isTerminated() {
      return shutdown;
    }

    @Override
    public ManagedChannel shutdownNow() {
      shutdown = true;
      return this;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) {
      return shutdown;
    }

    @Override
    public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
        MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
      throw new UnsupportedOperationException();
    }

    @Override
    public String authority() {
      return "fake";
    }
  }
}
