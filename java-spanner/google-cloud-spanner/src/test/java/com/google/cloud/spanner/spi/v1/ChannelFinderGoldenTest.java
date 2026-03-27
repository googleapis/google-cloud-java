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
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.RoutingHint;
import io.grpc.CallOptions;
import io.grpc.ClientCall;
import io.grpc.ManagedChannel;
import io.grpc.MethodDescriptor;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import spanner.cloud.location.FinderTestCase;
import spanner.cloud.location.FinderTestCases;

@RunWith(JUnit4.class)
public class ChannelFinderGoldenTest {

  @Test
  public void goldenTest() throws Exception {
    FinderTestCases.Builder builder = FinderTestCases.newBuilder();
    try (InputStream inputStream =
            getClass().getClassLoader().getResourceAsStream("finder_test.textproto");
        InputStreamReader reader =
            new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8)) {
      TextFormat.merge(reader, builder);
    }

    FinderTestCases testCases = builder.build();

    for (FinderTestCase testCase : testCases.getTestCaseList()) {
      FakeEndpointCache endpointCache = new FakeEndpointCache();
      ChannelFinder finder = new ChannelFinder(endpointCache);
      finder.useDeterministicRandom();

      for (FinderTestCase.Event event : testCase.getEventList()) {
        if (event.hasCacheUpdate()) {
          finder.update(event.getCacheUpdate());
        }

        if (!event.getUnhealthyServersList().isEmpty()) {
          endpointCache.setUnhealthyServers(new HashSet<>(event.getUnhealthyServersList()));
        } else {
          endpointCache.setUnhealthyServers(Collections.emptySet());
        }

        switch (event.getRequestCase()) {
          case READ:
            ReadRequest.Builder readBuilder = event.getRead().toBuilder();
            ChannelEndpoint readEndpoint = finder.findServer(readBuilder);
            assertHintAndServer(
                testCase.getName(), event, readBuilder.getRoutingHint(), readEndpoint);
            break;
          case SQL:
            ExecuteSqlRequest.Builder sqlBuilder = event.getSql().toBuilder();
            ChannelEndpoint sqlEndpoint = finder.findServer(sqlBuilder);
            assertHintAndServer(
                testCase.getName(), event, sqlBuilder.getRoutingHint(), sqlEndpoint);
            break;
          case REQUEST_NOT_SET:
          default:
            break;
        }
      }
    }
  }

  private static void assertHintAndServer(
      String testCaseName,
      FinderTestCase.Event event,
      RoutingHint actualHint,
      ChannelEndpoint endpoint) {
    assertEquals(
        "RoutingHint mismatch for test case: " + testCaseName, event.getHint(), actualHint);
    String expectedServer = event.getServer();
    if (!expectedServer.isEmpty()) {
      assertNotNull("Expected server for test case: " + testCaseName, endpoint);
      assertEquals(expectedServer, endpoint.getAddress());
    } else {
      assertNull("Expected no server for test case: " + testCaseName, endpoint);
    }
  }

  private static final class FakeEndpointCache implements ChannelEndpointCache {
    private final Map<String, FakeEndpoint> endpoints = new HashMap<>();
    private final FakeEndpoint defaultEndpoint = new FakeEndpoint("default");
    private volatile Set<String> unhealthyServers = Collections.emptySet();

    void setUnhealthyServers(Set<String> unhealthyServers) {
      this.unhealthyServers = unhealthyServers;
    }

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

    private final class FakeEndpoint implements ChannelEndpoint {
      private final String address;

      private FakeEndpoint(String address) {
        this.address = address;
      }

      @Override
      public String getAddress() {
        return address;
      }

      @Override
      public boolean isHealthy() {
        return !unhealthyServers.contains(address);
      }

      @Override
      public ManagedChannel getChannel() {
        return new ManagedChannel() {
          @Override
          public ManagedChannel shutdown() {
            return this;
          }

          @Override
          public ManagedChannel shutdownNow() {
            return this;
          }

          @Override
          public boolean isShutdown() {
            return false;
          }

          @Override
          public boolean isTerminated() {
            return false;
          }

          @Override
          public boolean awaitTermination(long timeout, TimeUnit unit) {
            return true;
          }

          @Override
          public <RequestT, ResponseT> ClientCall<RequestT, ResponseT> newCall(
              MethodDescriptor<RequestT, ResponseT> methodDescriptor, CallOptions callOptions) {
            throw new UnsupportedOperationException();
          }

          @Override
          public String authority() {
            return address;
          }
        };
      }
    }
  }
}
