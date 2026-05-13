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

package com.google.cloud.spanner.spi.v1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.SpannerOptions;
import com.google.common.base.Stopwatch;
import io.grpc.Attributes;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.ServerTransportFilter;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import java.net.InetSocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class GapicSpannerRpcConnectionTest {

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;

  private final AtomicInteger activeNetworkConnections = new AtomicInteger(0);

  private final ServerTransportFilter connectionCounterFilter =
      new ServerTransportFilter() {
        @Override
        public Attributes transportReady(Attributes transportAttrs) {
          activeNetworkConnections.incrementAndGet();
          return super.transportReady(transportAttrs);
        }

        @Override
        public void transportTerminated(Attributes transportAttrs) {
          activeNetworkConnections.decrementAndGet();
          super.transportTerminated(transportAttrs);
        }
      };

  @Before
  public void startServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);

    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            .addTransportFilter(connectionCounterFilter)
            .build()
            .start();
    activeNetworkConnections.set(0);
  }

  @After
  public void reset() throws InterruptedException {
    if (mockSpanner != null) {
      mockSpanner.reset();
    }
    if (server != null) {
      server.shutdown();
      server.awaitTermination();
    }
  }

  private SpannerOptions.Builder createDirectPathFallbackOptions() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setEnableDirectAccess(true)
        .setHost("http://" + endpoint)
        .setCredentials(NoCredentials.getInstance());
  }

  @Test
  public void testDirectPathFallbackCreatesExactlyFourPhysicalSockets() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    GapicSpannerRpc rpc = null;
    try {
      SpannerOptions options = createDirectPathFallbackOptions().build();
      assumeTrue(
          "GCP fallback must be enabled for this DirectPath fallback test",
          options.isEnableGcpFallback());

      activeNetworkConnections.set(0);
      rpc = new GapicSpannerRpc(options);

      // Poll active loopback connections for up to 1000ms with an aggressive 1ms wait
      Stopwatch watch = Stopwatch.createStarted();
      while (activeNetworkConnections.get() < 48 && watch.elapsed(TimeUnit.MILLISECONDS) < 1000L) {
        try {
          Thread.sleep(1L);
        } catch (InterruptedException ignored) {
        }
      }

      // Sleep for an extra 5ms after seeing 48 connections (or hitting timeout) to
      // ensure we catch any additional connections that are created.
      try {
        Thread.sleep(5L);
      } catch (InterruptedException ignored) {
      }

      // Assert that the Spanner client stubs eagerly construct exactly 3 fallback channels:
      // 1. Shared pool for the Data client and PartitionedDML client stubs
      // 2. Dedicated pool for the InstanceAdmin client stub
      // 3. Dedicated pool for the DatabaseAdmin client stub
      // Each fallback channel contains a primary and fallback pool (totaling 6
      // GcpManagedChannel pools).
      // Since the default pool size is 8 channels when gRPC-GCP is enabled, they eagerly
      // establish exactly 48 physical Loopback TCP connection sockets (6 pools of size 8).
      assertEquals(48, activeNetworkConnections.get());
    } finally {
      if (rpc != null) {
        rpc.shutdown();
      }
      SpannerOptions.useDefaultEnvironment();
    }
  }
}
