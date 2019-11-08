/*
 * Copyright 2019 Google LLC
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
package com.google.cloud.bigtable.data.v2.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.bigtable.data.v2.BigtableDataClient;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.test_helpers.env.TestEnvRule;
import io.grpc.ManagedChannelBuilder;
import io.grpc.alts.ComputeEngineChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.netty.channel.ChannelDuplexHandler;
import io.grpc.netty.shaded.io.netty.channel.ChannelFactory;
import io.grpc.netty.shaded.io.netty.channel.ChannelHandlerContext;
import io.grpc.netty.shaded.io.netty.channel.ChannelPromise;
import io.grpc.netty.shaded.io.netty.channel.EventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.nio.NioEventLoopGroup;
import io.grpc.netty.shaded.io.netty.channel.socket.nio.NioSocketChannel;
import io.grpc.netty.shaded.io.netty.util.ReferenceCountUtil;
import java.io.IOException;
import java.lang.reflect.Field;
import java.net.Inet6Address;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test DirectPath fallback behavior by injecting a ChannelHandler into the netty stack that will
 * disrupt IPv6 communications.
 */
@RunWith(JUnit4.class)
public class DirectPathFallbackIT {
  // A threshold of completed read calls to observe to ascertain IPv6 is working.
  // This was determined experimentally to account for both gRPC-LB RPCs and Bigtable api RPCs.
  private static final int MIN_COMPLETE_READ_CALLS = 40;
  private static final int NUM_RPCS_TO_SEND = 20;

  @ClassRule public static TestEnvRule testEnvRule = new TestEnvRule();

  private AtomicBoolean blackholeIPv6 = new AtomicBoolean();
  private AtomicInteger numBlocked = new AtomicInteger();
  private AtomicInteger numIPv6Read = new AtomicInteger();

  private ChannelFactory<NioSocketChannel> channelFactory;
  private EventLoopGroup eventLoopGroup;
  private BigtableDataClient instrumentedClient;

  public DirectPathFallbackIT() {
    // Create a transport channel provider that can intercept ipv6 packets.
    channelFactory = new MyChannelFactory();
    eventLoopGroup = new NioEventLoopGroup();
  }

  @Before
  public void setup() throws IOException {
    assume()
        .withMessage("DirectPath integration tests can only run against DirectPathEnv")
        .that(testEnvRule.env().isDirectPathEnabled())
        .isTrue();

    BigtableDataSettings defaultSettings = testEnvRule.env().getDataClientSettings();
    InstantiatingGrpcChannelProvider defaultTransportProvider =
        (InstantiatingGrpcChannelProvider)
            defaultSettings.getStubSettings().getTransportChannelProvider();
    InstantiatingGrpcChannelProvider instrumentedTransportChannelProvider =
        defaultTransportProvider
            .toBuilder()
            .setPoolSize(1)
            .setChannelConfigurator(
                new ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder>() {
                  @Override
                  public ManagedChannelBuilder apply(ManagedChannelBuilder builder) {
                    injectNettyChannelHandler(builder);

                    // Fail fast when blackhole is active
                    builder.keepAliveTime(1, TimeUnit.SECONDS);
                    builder.keepAliveTimeout(1, TimeUnit.SECONDS);
                    return builder;
                  }
                })
            .build();

    // Inject the instrumented transport provider into a new client
    BigtableDataSettings.Builder settingsBuilder =
        testEnvRule.env().getDataClientSettings().toBuilder();

    settingsBuilder
        .stubSettings()
        .setTransportChannelProvider(instrumentedTransportChannelProvider);

    instrumentedClient = BigtableDataClient.create(settingsBuilder.build());
  }

  @After
  public void teardown() {
    if (instrumentedClient != null) {
      instrumentedClient.close();
    }
    if (eventLoopGroup != null) {
      eventLoopGroup.shutdownGracefully();
    }
  }

  @Test
  public void testFallback() throws InterruptedException {
    // Verify that we can send a request
    instrumentedClient.readRow(testEnvRule.env().getTableId(), "nonexistent-row");

    // Enable the blackhole, which will prevent communication via IPv6 and thus DirectPath.
    blackholeIPv6.set(true);

    // Send a request, which should be routed over IPv4 and CFE.
    instrumentedClient.readRow(testEnvRule.env().getTableId(), "nonexistent-row");

    // Verify that the above check was meaningful, by verifying that the blackhole actually dropped
    // packets.
    assertWithMessage("Failed to detect any IPv6 traffic in blackhole")
        .that(numBlocked.get())
        .isGreaterThan(0);

    // Make sure that the client will start reading from IPv6 again by sending new requests and
    // checking the injected IPv6 counter has been updated.
    blackholeIPv6.set(false);
    numIPv6Read.set(0);

    while (numIPv6Read.get() < MIN_COMPLETE_READ_CALLS) {
      for (int i = 0; i < NUM_RPCS_TO_SEND; i++) {
        instrumentedClient.readRow(testEnvRule.env().getTableId(), "nonexistent-row");
      }

      Thread.sleep(100);
    }

    assertWithMessage("Failed to upgrade back to DirectPath")
        .that(numIPv6Read.get())
        .isGreaterThan(MIN_COMPLETE_READ_CALLS);
  }

  /**
   * This is a giant hack to enable testing DirectPath CFE fallback.
   *
   * <p>It unwraps the {@link ComputeEngineChannelBuilder} to inject a NettyChannelHandler to signal
   * IPv6 packet loss.
   */
  private void injectNettyChannelHandler(ManagedChannelBuilder<?> channelBuilder) {
    try {
      // Extract the delegate NettyChannelBuilder using reflection
      Field delegateField = ComputeEngineChannelBuilder.class.getDeclaredField("delegate");
      delegateField.setAccessible(true);

      ComputeEngineChannelBuilder gceChannelBuilder =
          ((ComputeEngineChannelBuilder) channelBuilder);
      Object delegateChannelBuilder = delegateField.get(gceChannelBuilder);

      NettyChannelBuilder nettyChannelBuilder = (NettyChannelBuilder) delegateChannelBuilder;
      nettyChannelBuilder.channelFactory(channelFactory);
      nettyChannelBuilder.eventLoopGroup(eventLoopGroup);
    } catch (NoSuchFieldException | IllegalAccessException e) {
      throw new RuntimeException("Failed to inject the netty ChannelHandler", e);
    }
  }

  /** @see com.google.cloud.bigtable.data.v2.it.DirectPathFallbackIT.MyChannelHandler */
  private class MyChannelFactory implements ChannelFactory<NioSocketChannel> {
    @Override
    public NioSocketChannel newChannel() {
      NioSocketChannel channel = new NioSocketChannel();
      channel.pipeline().addLast(new MyChannelHandler());

      return channel;
    }
  }

  /**
   * A netty {@link io.grpc.netty.shaded.io.netty.channel.ChannelHandler} that can be instructed to
   * make IPv6 packets disappear
   */
  private class MyChannelHandler extends ChannelDuplexHandler {
    private boolean isIPv6;

    @Override
    public void connect(
        ChannelHandlerContext ctx,
        SocketAddress remoteAddress,
        SocketAddress localAddress,
        ChannelPromise promise)
        throws Exception {

      this.isIPv6 =
          (remoteAddress instanceof InetSocketAddress)
              && ((InetSocketAddress) remoteAddress).getAddress() instanceof Inet6Address;

      if (!(isIPv6 && blackholeIPv6.get())) {
        super.connect(ctx, remoteAddress, localAddress, promise);
      } else {
        // Fail the connection fast
        promise.setFailure(new IOException("fake error"));
      }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      boolean dropCall = isIPv6 && blackholeIPv6.get();

      if (dropCall) {
        // Don't notify the next handler and increment counter
        numBlocked.incrementAndGet();
        ReferenceCountUtil.release(msg);
      } else {
        super.channelRead(ctx, msg);
      }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
      boolean dropCall = isIPv6 && blackholeIPv6.get();

      if (dropCall) {
        // Don't notify the next handler and increment counter
        numBlocked.incrementAndGet();
      } else {
        if (isIPv6) {
          numIPv6Read.incrementAndGet();
        }
        super.channelReadComplete(ctx);
      }
    }
  }
}
