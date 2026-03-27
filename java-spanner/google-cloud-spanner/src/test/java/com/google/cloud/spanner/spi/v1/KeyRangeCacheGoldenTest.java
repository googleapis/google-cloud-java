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
import static org.junit.Assert.assertNull;

import com.google.protobuf.TextFormat;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.RoutingHint;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import spanner.cloud.location.RangeCacheTestCase;
import spanner.cloud.location.RangeCacheTestCases;

@RunWith(JUnit4.class)
public class KeyRangeCacheGoldenTest {

  private static final int DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK = 1000;

  @Test
  public void goldenTest() throws Exception {
    RangeCacheTestCases.Builder builder = RangeCacheTestCases.newBuilder();
    try (InputStream inputStream =
            getClass().getClassLoader().getResourceAsStream("range_cache_test.textproto");
        InputStreamReader reader =
            new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8)) {
      TextFormat.merge(reader, builder);
    }

    RangeCacheTestCases testCases = builder.build();

    for (RangeCacheTestCase testCase : testCases.getTestCaseList()) {
      FakeEndpointCache endpointCache = new FakeEndpointCache();
      KeyRangeCache cache = new KeyRangeCache(endpointCache);
      cache.useDeterministicRandom();

      for (RangeCacheTestCase.Step step : testCase.getStepList()) {
        if (step.hasUpdate()) {
          cache.addRanges(step.getUpdate());
        }
        for (RangeCacheTestCase.Step.Test test : step.getTestList()) {
          cache.setMinCacheEntriesForRandomPick(DEFAULT_MIN_ENTRIES_FOR_RANDOM_PICK);
          int minEntries = test.getMinCacheEntriesForRandomPick();
          if (minEntries != 0) {
            cache.setMinCacheEntriesForRandomPick(minEntries);
          }

          RoutingHint.Builder hintBuilder = RoutingHint.newBuilder();
          if (!test.getKey().isEmpty()) {
            hintBuilder.setKey(test.getKey());
          }
          if (!test.getLimitKey().isEmpty()) {
            hintBuilder.setLimitKey(test.getLimitKey());
          }

          DirectedReadOptions directedReadOptions =
              test.hasDirectedReadOptions()
                  ? test.getDirectedReadOptions()
                  : DirectedReadOptions.getDefaultInstance();

          KeyRangeCache.RangeMode rangeMode =
              test.getRangeMode() == RangeCacheTestCase.Step.Test.RangeMode.PICK_RANDOM
                  ? KeyRangeCache.RangeMode.PICK_RANDOM
                  : KeyRangeCache.RangeMode.COVERING_SPLIT;

          ChannelEndpoint server =
              cache.fillRoutingHint(test.getLeader(), rangeMode, directedReadOptions, hintBuilder);

          assertEquals(
              "RoutingHint mismatch for test case: " + testCase.getName(),
              test.getResult(),
              hintBuilder.build());
          if (!test.getServer().isEmpty()) {
            assertNotNull("Expected server for test case: " + testCase.getName(), server);
            assertEquals(test.getServer(), server.getAddress());
          } else {
            assertNull("Expected no server for test case: " + testCase.getName(), server);
          }
        }
      }

      cache.clear();
    }
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
  }

  private static final class FakeEndpoint implements ChannelEndpoint {
    private final String address;
    private final ManagedChannel channel = new FakeManagedChannel();

    FakeEndpoint(String address) {
      this.address = address;
    }

    @Override
    public String getAddress() {
      return address;
    }

    @Override
    public boolean isHealthy() {
      return true;
    }

    @Override
    public ManagedChannel getChannel() {
      return channel;
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
