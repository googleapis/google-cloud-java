/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.spanner.it;

import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.TruthJUnit.assume;

import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.cloud.spanner.Database;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.IntegrationTestEnv;
import com.google.cloud.spanner.Key;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.testing.RemoteSpannerHelper;
import com.google.common.base.Stopwatch;
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
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Test DirectPath fallback behavior by injecting a ChannelHandler into the netty stack that will
 * disrupt IPv6 communications.
 *
 * <p>WARNING: this test can only be run on a GCE VM and will explicitly ignore
 * GOOGLE_APPLICATION_CREDENTIALS and use the service account associated with the VM.
 */
@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITDirectPathFallback {
  // A threshold of completed read calls to observe to ascertain IPv6 is working.
  // This was determined experimentally to account for both gRPC-LB RPCs and Bigtable api RPCs.
  private static final int MIN_COMPLETE_READ_CALLS = 40;
  private static final int NUM_RPCS_TO_SEND = 20;

  // IP address prefixes allocated for DirectPath backends.
  private static final String DP_IPV6_PREFIX = "2001:4860:8040";
  private static final String DP_IPV4_PREFIX = "34.126";

  @ClassRule public static IntegrationTestEnv env = new IntegrationTestEnv();

  private AtomicBoolean blackholeDpAddr = new AtomicBoolean();
  private AtomicInteger numBlocked = new AtomicInteger();
  private AtomicInteger numDpAddrRead = new AtomicInteger();
  private boolean isDpAddr;

  private ChannelFactory<NioSocketChannel> channelFactory;
  private EventLoopGroup eventLoopGroup;
  private RemoteSpannerHelper testHelper;

  private static final String TABLE_NAME = "TestTable";
  private static final List<String> ALL_COLUMNS = Arrays.asList("Key", "StringValue");
  private static Database db;
  private static DatabaseClient client;

  // TODO(mohanli): Remove this temporary endpoint once DirectPath goes to public beta.
  private static final String DIRECT_PATH_ENDPOINT = "aa423245250f2bbf.sandbox.googleapis.com:443";
  private static final String ENABLE_DIRECT_ACCESS = "spanner.enable_direct_access";

  public ITDirectPathFallback() {
    // Create a transport channel provider that can intercept ipv6 packets.
    channelFactory = new MyChannelFactory();
    eventLoopGroup = new NioEventLoopGroup();
  }

  @Before
  public void setup() {
    assume()
        .withMessage("DirectPath integration tests can only run against DirectPathEnv")
        .that(Boolean.getBoolean(ENABLE_DIRECT_ACCESS))
        .isTrue();
    // Get default spanner options for Ingetration test
    SpannerOptions.Builder builder = env.getTestHelper().getOptions().toBuilder();
    // Set instrumented transport provider
    builder.setChannelProvider(
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setEndpoint(DIRECT_PATH_ENDPOINT)
            .setPoolSize(1)
            .setChannelConfigurator(
                managedChannelBuilder -> {
                  injectNettyChannelHandler(managedChannelBuilder);
                  // Fail fast when blackhole is active
                  managedChannelBuilder.keepAliveTime(1, TimeUnit.SECONDS);
                  managedChannelBuilder.keepAliveTimeout(1, TimeUnit.SECONDS);
                  return managedChannelBuilder;
                })
            .build());
    // Forcefully ignore GOOGLE_APPLICATION_CREDENTIALS
    builder.setCredentials(
        FixedCredentialsProvider.create(ComputeEngineCredentials.create()).getCredentials());

    // Create a new testHelper with the instrumented transport provider
    testHelper = RemoteSpannerHelper.create(builder.build(), env.getTestHelper().getInstanceId());

    db =
        testHelper.createTestDatabase(
            "CREATE TABLE TestTable ("
                + "  Key                STRING(MAX) NOT NULL,"
                + "  StringValue        STRING(MAX),"
                + ") PRIMARY KEY (Key)");
    client = testHelper.getDatabaseClient(db);
    List<Mutation> mutations = new ArrayList<>();
    for (int i = 0; i < 3; ++i) {
      mutations.add(
          Mutation.newInsertOrUpdateBuilder(TABLE_NAME)
              .set("Key")
              .to("k" + i)
              .set("StringValue")
              .to("v" + i)
              .build());
    }
    client.write(mutations);
  }

  @After
  public void teardown() {
    if (testHelper != null) {
      testHelper.cleanUp();
      testHelper.getClient().close();
    }
    if (eventLoopGroup != null) {
      eventLoopGroup.shutdownGracefully();
    }
  }

  @Test
  public void testFallback() throws InterruptedException, TimeoutException {
    // Precondition: wait for DirectPath to connect
    assertWithMessage("Failed to observe RPCs over DirectPath").that(exerciseDirectPath()).isTrue();

    // Enable the blackhole, which will prevent communication with grpclb and thus DirectPath.
    blackholeDpAddr.set(true);

    // Send a request, which should be routed over IPv4 and CFE.
    client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k0"), ALL_COLUMNS);

    // Verify that the above check was meaningful, by verifying that the blackhole actually dropped
    // packets.
    assertWithMessage("Failed to detect any IPv6 traffic in blackhole")
        .that(numBlocked.get())
        .isGreaterThan(0);

    // Make sure that the client will start reading from IPv6 again by sending new requests and
    // checking the injected IPv6 counter has been updated.
    blackholeDpAddr.set(false);

    assertWithMessage("Failed to upgrade back to DirectPath").that(exerciseDirectPath()).isTrue();
  }

  private boolean exerciseDirectPath() throws InterruptedException {
    Stopwatch stopwatch = Stopwatch.createStarted();
    numDpAddrRead.set(0);

    boolean seenEnough = false;

    while (!seenEnough && stopwatch.elapsed(TimeUnit.MINUTES) < 2) {
      for (int i = 0; i < NUM_RPCS_TO_SEND; i++) {
        client.singleUse(TimestampBound.strong()).readRow(TABLE_NAME, Key.of("k0"), ALL_COLUMNS);
      }
      Thread.sleep(100);
      seenEnough = numDpAddrRead.get() >= MIN_COMPLETE_READ_CALLS;
    }
    return seenEnough;
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

  /**
   * @see com.google.cloud.bigtable.data.v2.it.DirectPathFallbackIT.MyChannelHandler
   */
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
    @Override
    public void connect(
        ChannelHandlerContext ctx,
        SocketAddress remoteAddress,
        SocketAddress localAddress,
        ChannelPromise promise)
        throws Exception {

      if (remoteAddress instanceof InetSocketAddress) {
        InetAddress inetAddress = ((InetSocketAddress) remoteAddress).getAddress();
        String addr = inetAddress.getHostAddress();
        isDpAddr = addr.startsWith(DP_IPV6_PREFIX) || addr.startsWith(DP_IPV4_PREFIX);
      }

      if (!(isDpAddr && blackholeDpAddr.get())) {
        super.connect(ctx, remoteAddress, localAddress, promise);
      } else {
        // Fail the connection fast
        promise.setFailure(new IOException("fake error"));
      }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
      boolean dropCall = isDpAddr && blackholeDpAddr.get();
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
      boolean dropCall = isDpAddr && blackholeDpAddr.get();
      if (dropCall) {
        // Don't notify the next handler and increment counter
        numBlocked.incrementAndGet();
      } else {
        if (isDpAddr) {
          numDpAddrRead.incrementAndGet();
        }
        super.channelReadComplete(ctx);
      }
    }
  }
}
