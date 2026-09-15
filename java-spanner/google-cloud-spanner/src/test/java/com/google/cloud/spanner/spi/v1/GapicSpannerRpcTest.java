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

package com.google.cloud.spanner.spi.v1;

import static com.google.cloud.spanner.XGoogSpannerRequestId.REQUEST_ID_CALL_OPTIONS_KEY;
import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.grpc.GrpcCallContext;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.grpc.GcpChannelPrimer;
import com.google.cloud.grpc.GcpManagedChannel;
import com.google.cloud.grpc.GcpManagedChannel.ChannelAffinityRef;
import com.google.cloud.grpc.GcpManagedChannelOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpChannelPoolOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions.GcpMetricsOptions;
import com.google.cloud.grpc.fallback.GcpFallbackChannelOptions;
import com.google.cloud.grpc.fallback.GcpFallbackOpenTelemetry;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.MockSpannerServiceImpl;
import com.google.cloud.spanner.MockSpannerServiceImpl.SimulatedExecutionTime;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.SpannerOptions.CallContextConfigurator;
import com.google.cloud.spanner.SpannerOptions.SpannerCallContextTimeoutConfigurator;
import com.google.cloud.spanner.SpannerOptionsHelper;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.XGoogSpannerRequestId;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc.AdminRequestsLimitExceededRetryAlgorithm;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.Futures;
import com.google.protobuf.ListValue;
import com.google.rpc.ErrorInfo;
import com.google.spanner.admin.database.v1.DatabaseAdminGrpc;
import com.google.spanner.admin.database.v1.ListDatabaseRolesRequest;
import com.google.spanner.v1.CommitRequest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ReadRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
import io.grpc.CallOptions;
import io.grpc.Context;
import io.grpc.Contexts;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Metadata.Key;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.protobuf.lite.ProtoLiteUtils;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.propagation.W3CTraceContextPropagator;
import io.opentelemetry.context.propagation.ContextPropagators;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.samplers.Sampler;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.net.InetSocketAddress;
import java.net.URLEncoder;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.BooleanSupplier;
import javax.annotation.Nullable;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class GapicSpannerRpcTest {

  private static final Statement SELECT1AND2 =
      Statement.of("SELECT 1 AS COL1 UNION ALL SELECT 2 AS COL1");
  private static final ResultSetMetadata SELECT1AND2_METADATA =
      ResultSetMetadata.newBuilder()
          .setRowType(
              StructType.newBuilder()
                  .addFields(
                      Field.newBuilder()
                          .setName("COL1")
                          .setType(
                              com.google.spanner.v1.Type.newBuilder()
                                  .setCode(TypeCode.INT64)
                                  .build())
                          .build())
                  .build())
          .build();
  private static final com.google.spanner.v1.ResultSet SELECT1_RESULTSET =
      com.google.spanner.v1.ResultSet.newBuilder()
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                  .build())
          .addRows(
              ListValue.newBuilder()
                  .addValues(com.google.protobuf.Value.newBuilder().setStringValue("2").build())
                  .build())
          .setMetadata(SELECT1AND2_METADATA)
          .build();
  private static final Statement UPDATE_FOO_STATEMENT =
      Statement.of("UPDATE FOO SET BAR=1 WHERE BAZ=2");

  private static final String STATIC_OAUTH_TOKEN = "STATIC_TEST_OAUTH_TOKEN";
  private static final String VARIABLE_OAUTH_TOKEN = "VARIABLE_TEST_OAUTH_TOKEN";
  private static final OAuth2Credentials STATIC_CREDENTIALS =
      OAuth2Credentials.create(
          new AccessToken(
              STATIC_OAUTH_TOKEN,
              new java.util.Date(
                  System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS))));
  private static final OAuth2Credentials VARIABLE_CREDENTIALS =
      OAuth2Credentials.create(
          new AccessToken(
              VARIABLE_OAUTH_TOKEN,
              new java.util.Date(
                  System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(1L, TimeUnit.DAYS))));

  private static final String GRPC_GCP_CHANNEL_REF_CLASS_NAME =
      "com.google.cloud.grpc.GcpManagedChannel$ChannelRef";

  private static final class GrpcGcpObjectCounts {
    int gcpManagedChannels;
    int channelRefs;

    GrpcGcpObjectCounts minus(GrpcGcpObjectCounts other) {
      GrpcGcpObjectCounts difference = new GrpcGcpObjectCounts();
      difference.gcpManagedChannels = gcpManagedChannels - other.gcpManagedChannels;
      difference.channelRefs = channelRefs - other.channelRefs;
      return difference;
    }

    String debugString() {
      return "GcpManagedChannel=" + gcpManagedChannels + ", ChannelRef=" + channelRefs;
    }
  }

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  private static final Map<SpannerRpc.Option, Object> optionsMap = new HashMap<>();
  private static Metadata lastSeenHeaders;
  // Headers of every unary ExecuteSql call, which is the RPC that channel priming uses.
  private static final List<Map<String, List<String>>> executeSqlHeaders =
      new CopyOnWriteArrayList<>();
  private static String defaultUserAgent;
  private static Spanner spanner;
  private static boolean isRouteToLeader;
  private static boolean isEndToEndTracing;
  private static boolean isTraceContextPresent;

  @Parameter public Dialect dialect;

  @Parameters(name = "dialect = {0}")
  public static Object[] data() {
    return Dialect.values();
  }

  @Before
  public void startServer() throws Exception {
    // Enable OpenTelemetry tracing.
    SpannerOptionsHelper.resetActiveTracingFramework();
    SpannerOptions.enableOpenTelemetryTraces();

    assumeTrue(
        "Skip tests when emulator is enabled as this test interferes with the check whether the"
            + " emulator is running",
        System.getenv("SPANNER_EMULATOR_HOST") == null);

    defaultUserAgent = "spanner-java/" + GaxProperties.getLibraryVersion(GapicSpannerRpc.class);
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D); // We don't want any unpredictable aborted transactions.
    mockSpanner.putStatementResult(StatementResult.query(SELECT1AND2, SELECT1_RESULTSET));
    mockSpanner.putStatementResult(StatementResult.update(UPDATE_FOO_STATEMENT, 1L));

    address = new InetSocketAddress("localhost", 0);
    server =
        NettyServerBuilder.forAddress(address)
            .addService(mockSpanner)
            // Add a server interceptor that will check that we receive the variable OAuth token
            // from the CallCredentials, and not the one set as static credentials.
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    lastSeenHeaders = headers;
                    if (call.getMethodDescriptor().equals(SpannerGrpc.getExecuteSqlMethod())) {
                      executeSqlHeaders.add(copyAsciiHeaders(headers));
                    }
                    String auth =
                        headers.get(Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER));
                    assertThat(auth).isEqualTo("Bearer " + VARIABLE_OAUTH_TOKEN);
                    String clientLibToken =
                        headers.get(
                            Metadata.Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER));
                    assertNotNull(clientLibToken);
                    assertTrue(
                        clientLibToken.contains(ServiceOptions.getGoogApiClientLibName() + "/"));
                    if (call.getMethodDescriptor()
                            .equals(SpannerGrpc.getExecuteStreamingSqlMethod())
                        || call.getMethodDescriptor().equals(SpannerGrpc.getExecuteSqlMethod())) {
                      String traceParentHeader =
                          headers.get(Key.of("traceparent", Metadata.ASCII_STRING_MARSHALLER));
                      isTraceContextPresent = (traceParentHeader != null);
                      String routeToLeaderHeader =
                          headers.get(
                              Key.of(
                                  "x-goog-spanner-route-to-leader",
                                  Metadata.ASCII_STRING_MARSHALLER));
                      String endToEndTracingHeader =
                          headers.get(
                              Key.of(
                                  "x-goog-spanner-end-to-end-tracing",
                                  Metadata.ASCII_STRING_MARSHALLER));
                      isRouteToLeader =
                          (routeToLeaderHeader != null && routeToLeaderHeader.equals("true"));
                      isEndToEndTracing =
                          (endToEndTracingHeader != null && endToEndTracingHeader.equals("true"));
                    }
                    return Contexts.interceptCall(Context.current(), call, headers, next);
                  }
                })
            .build()
            .start();
    optionsMap.put(Option.CHANNEL_HINT, 1L);
    spanner = createSpannerOptions().getService();
  }

  @After
  public void reset() throws InterruptedException {
    if (mockSpanner != null) {
      mockSpanner.reset();
    }
    if (spanner != null) {
      spanner.close();
    }
    if (server != null) {
      server.shutdown();
      server.awaitTermination();
    }
    isRouteToLeader = false;
    isEndToEndTracing = false;
    isTraceContextPresent = false;
    executeSqlHeaders.clear();
  }

  /** Copies all values of every ASCII header, so duplicated headers remain visible. */
  private static Map<String, List<String>> copyAsciiHeaders(Metadata headers) {
    Map<String, List<String>> copy = new HashMap<>();
    for (String key : headers.keys()) {
      if (!key.endsWith(Metadata.BINARY_HEADER_SUFFIX)) {
        Iterable<String> values = headers.getAll(Key.of(key, Metadata.ASCII_STRING_MARSHALLER));
        copy.put(key, values == null ? ImmutableList.of() : ImmutableList.copyOf(values));
      }
    }
    return copy;
  }

  private static void awaitCondition(BooleanSupplier condition, Duration timeout)
      throws InterruptedException {
    long deadline = System.nanoTime() + timeout.toNanos();
    while (!condition.getAsBoolean()) {
      if (System.nanoTime() > deadline) {
        throw new AssertionError("Condition not met within " + timeout);
      }
      Thread.sleep(10L);
    }
  }

  private static GapicSpannerRpc getRpc(Spanner spanner) throws Exception {
    java.lang.reflect.Method method = SpannerOptions.class.getDeclaredMethod("getSpannerRpcV1");
    method.setAccessible(true);
    return (GapicSpannerRpc) method.invoke(spanner.getOptions());
  }

  private static void registerPrimeStatementResult() {
    mockSpanner.putStatementResult(
        StatementResult.query(
            Statement.of(DynamicChannelPoolPrimer.PRIME_SQL),
            com.google.spanner.v1.ResultSet.newBuilder()
                .addRows(
                    ListValue.newBuilder()
                        .addValues(
                            com.google.protobuf.Value.newBuilder().setStringValue("1").build())
                        .build())
                .setMetadata(SELECT1AND2_METADATA)
                .build()));
  }

  private static List<ExecuteSqlRequest> primeRequests() {
    List<ExecuteSqlRequest> requests = new ArrayList<>();
    for (ExecuteSqlRequest request : mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
      if (request.getSql().equals(DynamicChannelPoolPrimer.PRIME_SQL)) {
        requests.add(request);
      }
    }
    return requests;
  }

  @Test
  public void testChannelPoolOptionsRegisterPrimerOnlyWithDynamicChannelPool() {
    GcpChannelPrimer primer = channel -> Futures.immediateFuture(null);

    SpannerOptions dcpOptions =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .build();
    GcpChannelPoolOptions withPrimer =
        GapicSpannerRpc.getGrpcGcpChannelPoolOptions(dcpOptions, primer);
    assertSame(primer, withPrimer.getChannelPrimer());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_TIMEOUT,
        withPrimer.getChannelPrimeTimeout());
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_MAX_ATTEMPTS,
        withPrimer.getChannelPrimeMaxAttempts());
    // The other dynamic pool settings are retained.
    assertEquals(
        dcpOptions.getGcpChannelPoolOptions().getMaxRpcPerChannel(),
        withPrimer.getMaxRpcPerChannel());
    assertNull(GapicSpannerRpc.getGrpcGcpChannelPoolOptions(dcpOptions, null).getChannelPrimer());
    assertNull(GapicSpannerRpc.getGrpcGcpChannelPoolOptions(dcpOptions).getChannelPrimer());

    SpannerOptions staticOptions =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .disableDynamicChannelPool()
            .setNumChannels(2)
            .build();
    assertNull(
        GapicSpannerRpc.getGrpcGcpChannelPoolOptions(staticOptions, primer).getChannelPrimer());
  }

  @Test
  public void testChannelPoolOptionsNeverOverrideUserProvidedPrimer() {
    GcpChannelPrimer userPrimer = channel -> Futures.immediateFuture(null);
    GcpChannelPrimer spannerPrimer = channel -> Futures.immediateFuture(null);
    Duration userTimeout = Duration.ofSeconds(3);
    int userAttempts = 7;
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setChannelPrimer(userPrimer)
                    .setChannelPrimeTimeout(userTimeout)
                    .setChannelPrimeMaxAttempts(userAttempts)
                    .build())
            .build();

    GcpChannelPoolOptions poolOptions =
        GapicSpannerRpc.getGrpcGcpChannelPoolOptions(options, spannerPrimer);

    assertSame(userPrimer, poolOptions.getChannelPrimer());
    assertEquals(userTimeout, poolOptions.getChannelPrimeTimeout());
    assertEquals(userAttempts, poolOptions.getChannelPrimeMaxAttempts());
  }

  @Test
  public void testUserProvidedPrimeSettingsSurviveWithoutUserPrimer() {
    GcpChannelPrimer spannerPrimer = channel -> Futures.immediateFuture(null);
    Duration userTimeout = Duration.ofSeconds(4);
    int userAttempts = 2;
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setChannelPrimeTimeout(userTimeout)
                    .setChannelPrimeMaxAttempts(userAttempts)
                    .build())
            .build();

    GcpChannelPoolOptions poolOptions =
        GapicSpannerRpc.getGrpcGcpChannelPoolOptions(options, spannerPrimer);

    assertSame(spannerPrimer, poolOptions.getChannelPrimer());
    assertEquals(userTimeout, poolOptions.getChannelPrimeTimeout());
    assertEquals(userAttempts, poolOptions.getChannelPrimeMaxAttempts());
  }

  @Test
  public void testRpcCreatesPrimerOnlyWithDynamicChannelPool() {
    GapicSpannerRpc dcpRpc =
        new GapicSpannerRpc(
            createSpannerOptions().toBuilder()
                .enableGrpcGcpExtension()
                .enableDynamicChannelPool()
                .build(),
            true);
    try {
      assertNotNull(dcpRpc.getChannelPrimer());
      assertNotNull(findGrpcGcpChannel(dcpRpc));
    } finally {
      dcpRpc.shutdown();
    }

    GapicSpannerRpc staticPoolRpc =
        new GapicSpannerRpc(
            createSpannerOptions().toBuilder()
                .enableGrpcGcpExtension()
                .disableDynamicChannelPool()
                .setNumChannels(1)
                .build(),
            true);
    try {
      assertNull(staticPoolRpc.getChannelPrimer());
    } finally {
      staticPoolRpc.shutdown();
    }

    GapicSpannerRpc gaxPoolRpc =
        new GapicSpannerRpc(
            createSpannerOptions().toBuilder()
                .disableGrpcGcpExtension()
                .enableDynamicChannelPool()
                .build(),
            true);
    try {
      assertNull(gaxPoolRpc.getChannelPrimer());
    } finally {
      gaxPoolRpc.shutdown();
    }
  }

  @Test
  public void testPrimerRpcDeadlineFollowsPoolPrimeTimeout() {
    SpannerOptions defaultTimeoutOptions =
        createSpannerOptions().toBuilder()
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .build();
    assertEquals(
        SpannerOptions.DEFAULT_DYNAMIC_POOL_CHANNEL_PRIME_TIMEOUT,
        defaultTimeoutOptions.getGcpChannelPoolOptions().getChannelPrimeTimeout());
    GapicSpannerRpc defaultTimeoutRpc = new GapicSpannerRpc(defaultTimeoutOptions, true);
    try {
      assertEquals(
          DynamicChannelPoolPrimer.MAX_RPC_DEADLINE,
          defaultTimeoutRpc.getChannelPrimer().getRpcDeadline());
    } finally {
      defaultTimeoutRpc.shutdown();
    }

    // A user-provided prime timeout below the maximum RPC deadline pulls the RPC deadline down
    // with it, so the RPC always fails before the pool times out the attempt.
    Duration userTimeout = Duration.ofSeconds(3);
    SpannerOptions shortTimeoutOptions =
        createSpannerOptions().toBuilder()
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder().setChannelPrimeTimeout(userTimeout).build())
            .build();
    assertEquals(
        userTimeout, shortTimeoutOptions.getGcpChannelPoolOptions().getChannelPrimeTimeout());
    GapicSpannerRpc shortTimeoutRpc = new GapicSpannerRpc(shortTimeoutOptions, true);
    try {
      GcpManagedChannel pool = findGrpcGcpChannel(shortTimeoutRpc);
      assertNotNull(pool);
      Duration rpcDeadline = shortTimeoutRpc.getChannelPrimer().getRpcDeadline();
      assertEquals(userTimeout.minus(DynamicChannelPoolPrimer.RPC_DEADLINE_MARGIN), rpcDeadline);
      assertTrue(rpcDeadline.compareTo(userTimeout) < 0);
    } finally {
      shortTimeoutRpc.shutdown();
    }
  }

  @Test
  public void testDynamicChannelPoolPrimesScaledUpChannelsWithSelectOne() throws Exception {
    registerPrimeStatementResult();
    // Keep the load queries open long enough to trigger a scale-up, and make the priming query
    // slow enough to observe that the channel is not published before it succeeds.
    mockSpanner.setExecuteStreamingSqlExecutionTime(
        SimulatedExecutionTime.ofMinimumAndRandomTime(3000, 0));
    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(1000, 0));
    SpannerOptions options =
        createSpannerOptions().toBuilder()
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .enableLeaderAwareRouting()
            .setGcpChannelPoolOptions(
                GcpChannelPoolOptions.newBuilder()
                    .setInitSize(1)
                    .setMinSize(1)
                    .setMaxSize(4)
                    .setDynamicScaling(1, 2, Duration.ofMinutes(3))
                    .build())
            .build();
    ExecutorService executor = Executors.newFixedThreadPool(8);
    try (Spanner spanner = options.getService()) {
      GapicSpannerRpc rpc = getRpc(spanner);
      assertNotNull(rpc.getChannelPrimer());
      GcpManagedChannel pool = findGrpcGcpChannel(rpc);
      assertNotNull(pool);
      assertEquals(1, pool.getNumberOfChannels());
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // Six concurrent streams on one channel with maxRpcPerChannel=2 force a scale-up.
      List<Future<Long>> loads = new ArrayList<>();
      for (int i = 0; i < 6; i++) {
        loads.add(
            executor.submit(
                () -> {
                  long rows = 0;
                  try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1AND2)) {
                    while (resultSet.next()) {
                      rows++;
                    }
                  }
                  return rows;
                }));
      }

      awaitCondition(() -> !primeRequests().isEmpty(), Duration.ofSeconds(15));
      // The priming query is still running (it takes at least one second), so the scaled-up
      // channel has not been published yet.
      assertEquals(1, pool.getNumberOfChannels());
      awaitCondition(() -> pool.getNumberOfChannels() > 1, Duration.ofSeconds(15));
      for (Future<Long> load : loads) {
        assertEquals(2L, load.get().longValue());
      }

      // Every priming query used the multiplexed session, which is the session that the
      // single-use load queries used as well.
      String multiplexedSession = null;
      for (ExecuteSqlRequest request : mockSpanner.getRequestsOfType(ExecuteSqlRequest.class)) {
        if (request.getSql().equals(SELECT1AND2.getSql())) {
          multiplexedSession = request.getSession();
          break;
        }
      }
      assertNotNull(multiplexedSession);
      // The mock keeps multiplexed sessions apart from regular sessions.
      assertFalse(mockSpanner.getSessions().containsKey(multiplexedSession));
      boolean multiplexedSessionCreated = false;
      for (CreateSessionRequest request :
          mockSpanner.getRequestsOfType(CreateSessionRequest.class)) {
        multiplexedSessionCreated |= request.getSession().getMultiplexed();
      }
      assertTrue(multiplexedSessionCreated);
      List<ExecuteSqlRequest> primes = primeRequests();
      assertThat(primes).isNotEmpty();
      for (ExecuteSqlRequest prime : primes) {
        assertEquals(multiplexedSession, prime.getSession());
        assertFalse(prime.hasTransaction());
      }
      assertEquals(primes.size(), pool.getNumberOfChannels() - 1);

      // The priming query carries the same credentials and headers as a normal call, and every
      // header exactly once: the fixed headers come from the delegate channel and the per-call
      // headers from the primer.
      assertEquals(primes.size(), executeSqlHeaders.size());
      Set<String> requestIds = new HashSet<>();
      for (Map<String, List<String>> headers : executeSqlHeaders) {
        assertThat(headers.get("authorization")).containsExactly("Bearer " + VARIABLE_OAUTH_TOKEN);
        assertThat(headers.get("x-goog-api-client")).hasSize(1);
        assertThat(headers.get("x-goog-api-client").get(0))
            .contains(ServiceOptions.getGoogApiClientLibName() + "/");
        assertThat(headers.get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()))
            .containsExactly("projects/[PROJECT]/instances/[INSTANCE]/databases/[DATABASE]");
        assertThat(headers.get("x-goog-request-params"))
            .containsExactly("session=" + URLEncoder.encode(multiplexedSession, "UTF-8"));
        assertThat(headers).doesNotContainKey("x-goog-spanner-route-to-leader");
        // The request id uses the client id of the rpc, the unknown channel 0 because the channel
        // is not part of the pool yet, and attempt 1 because the pool invokes prime() per attempt.
        assertThat(headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME)).hasSize(1);
        String requestId = headers.get(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME).get(0);
        assertTrue(requestId, requestIds.add(requestId));
        String[] parts = requestId.split("\\.");
        assertEquals(requestId, 6, parts.length);
        assertEquals(requestId, String.valueOf(rpc.getRequestIdCreator().getClientId()), parts[2]);
        assertEquals(requestId, "0", parts[3]);
        assertEquals(requestId, "1", parts[5]);
      }
    } finally {
      executor.shutdownNow();
    }
  }

  @Test
  public void testCallCredentialsProviderPreferenceAboveCredentials() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(STATIC_CREDENTIALS)
            .setCallCredentialsProvider(() -> MoreCallCredentials.from(VARIABLE_CREDENTIALS))
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    // GoogleAuthLibraryCallCredentials doesn't implement equals, so we can only check for the
    // existence.
    assertNotNull(
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCredentials());
    rpc.shutdown();
  }

  @Test
  public void
      testCallCredentialsProviderPreservedWhenConfiguratorReturnsDeltaContextWithCustomCallOptions() {
    CallOptions.Key<String> customKey = CallOptions.Key.create("customKey");
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return GrpcCallContext.createDefault()
                .withCallOptions(CallOptions.DEFAULT.withOption(customKey, "customVal"));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(STATIC_CREDENTIALS)
            .setCallCredentialsProvider(() -> MoreCallCredentials.from(VARIABLE_CREDENTIALS))
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            GetSessionRequest.getDefaultInstance(),
            SpannerGrpc.getGetSessionMethod());
    assertNotNull(callContext.getCallOptions().getCredentials());
    assertEquals("customVal", callContext.getCallOptions().getOption(customKey));
    rpc.shutdown();
  }

  @Test
  public void testCallCredentialsProviderReturnsNull() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(STATIC_CREDENTIALS)
            .setCallCredentialsProvider(() -> null)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertNull(
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCredentials());
    rpc.shutdown();
  }

  @Test
  public void testNoCallCredentials() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCredentials(STATIC_CREDENTIALS)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertNull(
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCredentials());
    rpc.shutdown();
  }

  @Test
  public void testClientCompressorGzip() {
    SpannerOptions options =
        SpannerOptions.newBuilder().setProjectId("some-project").setCompressorName("gzip").build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertEquals(
        "gzip",
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCompressor());
    rpc.shutdown();
  }

  @Test
  public void testClientCompressorIdentity() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCompressorName("identity")
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertEquals(
        "identity",
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCompressor());
    rpc.shutdown();
  }

  @Test
  public void testClientCompressorDefault() {
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("some-project").build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertNull(
        rpc.newCallContext(
                optionsMap,
                "/some/resource",
                GetSessionRequest.getDefaultInstance(),
                SpannerGrpc.getGetSessionMethod())
            .getCallOptions()
            .getCompressor());
    rpc.shutdown();
  }

  private static final class TimeoutHolder {

    private Duration timeout;
  }

  @Test
  public void testCallContextTimeout() {
    // Create a CallContextConfigurator that uses a variable timeout value.
    final TimeoutHolder timeoutHolder = new TimeoutHolder();
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            // Only configure a timeout for the ExecuteSql method as this method is used for
            // executing DML statements.
            if (request instanceof ExecuteSqlRequest
                && method.equals(SpannerGrpc.getExecuteSqlMethod())) {
              ExecuteSqlRequest sqlRequest = (ExecuteSqlRequest) request;
              // Sequence numbers are only assigned for DML statements, which means that
              // this is an update statement.
              if (sqlRequest.getSeqno() > 0L) {
                return context.withTimeoutDuration(timeoutHolder.timeout);
              }
            }
            return null;
          }
        };

    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
    final DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
    Context context =
        Context.current().withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, configurator);
    context.run(
        () -> {
          // First try with a 1ns timeout. This should always cause a DEADLINE_EXCEEDED
          // exception.
          timeoutHolder.timeout = Duration.ofNanos(1L);
          SpannerException e =
              assertThrows(
                  SpannerException.class,
                  () ->
                      client
                          .readWriteTransaction()
                          .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT)));
          assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());

          // Then try with a longer timeout. This should now succeed.
          timeoutHolder.timeout = Duration.ofMinutes(1L);
          long updateCount =
              client
                  .readWriteTransaction()
                  .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
          assertEquals(1L, updateCount);
        });
  }

  @Test
  public void testClientLevelCallContextConfiguratorEndToEnd() {
    final TimeoutHolder timeoutHolder = new TimeoutHolder();
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (request instanceof ExecuteSqlRequest
                && method.equals(SpannerGrpc.getExecuteSqlMethod())) {
              ExecuteSqlRequest sqlRequest = (ExecuteSqlRequest) request;
              if (sqlRequest.getSeqno() > 0L) {
                return context.withTimeoutDuration(timeoutHolder.timeout);
              }
            }
            return null;
          }
        };

    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
    SpannerOptions options =
        createSpannerOptions().toBuilder().setCallContextConfigurator(configurator).build();
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient client =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // 1. A 1ns timeout causes a DEADLINE_EXCEEDED exception end-to-end.
      timeoutHolder.timeout = Duration.ofNanos(1L);
      SpannerException e =
          assertThrows(
              SpannerException.class,
              () ->
                  client
                      .readWriteTransaction()
                      .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT)));
      assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());

      // 2. A longer timeout succeeds.
      timeoutHolder.timeout = Duration.ofMinutes(1L);
      long updateCount =
          client
              .readWriteTransaction()
              .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
      assertEquals(1L, updateCount);
    }
  }

  @Test
  public void testThreadLevelOverridesClientLevelCallContextConfiguratorEndToEnd() {
    // Client-level configurator sets a 1-minute timeout which normally succeeds.
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (request instanceof ExecuteSqlRequest
                && method.equals(SpannerGrpc.getExecuteSqlMethod())) {
              ExecuteSqlRequest sqlRequest = (ExecuteSqlRequest) request;
              if (sqlRequest.getSeqno() > 0L) {
                return context.withTimeoutDuration(Duration.ofMinutes(1L));
              }
            }
            return null;
          }
        };

    // Thread-level configurator overrides the timeout to 1ns.
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (request instanceof ExecuteSqlRequest
                && method.equals(SpannerGrpc.getExecuteSqlMethod())) {
              ExecuteSqlRequest sqlRequest = (ExecuteSqlRequest) request;
              if (sqlRequest.getSeqno() > 0L) {
                return context.withTimeoutDuration(Duration.ofNanos(1L));
              }
            }
            return null;
          }
        };

    mockSpanner.setExecuteSqlExecutionTime(SimulatedExecutionTime.ofMinimumAndRandomTime(10, 0));
    SpannerOptions options =
        createSpannerOptions().toBuilder().setCallContextConfigurator(clientConfigurator).build();
    try (Spanner customSpanner = options.getService()) {
      DatabaseClient client =
          customSpanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      // Without thread-level configurator, the client-level 1m timeout succeeds.
      long updateCount =
          client
              .readWriteTransaction()
              .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
      assertEquals(1L, updateCount);

      // With thread-level configurator, the 1ns timeout overrides client-level and causes
      // DEADLINE_EXCEEDED.
      Context context =
          Context.current()
              .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
      context.run(
          () -> {
            SpannerException e =
                assertThrows(
                    SpannerException.class,
                    () ->
                        client
                            .readWriteTransaction()
                            .run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT)));
            assertEquals(ErrorCode.DEADLINE_EXCEEDED, e.getErrorCode());
          });
    }
  }

  @Test
  public void testNewCallContextWithNullRequestAndNullMethod() {
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("some-project").build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertNotNull(rpc.newCallContext(optionsMap, "/some/resource", null, null));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithClientLevelConfigurator() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (method.equals(SpannerGrpc.getExecuteStreamingSqlMethod())) {
              return context
                  .withTimeoutDuration(Duration.ofSeconds(60))
                  .withStreamWaitTimeoutDuration(Duration.ofSeconds(30));
            }
            return null;
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod());
    assertEquals(Duration.ofSeconds(60), callContext.getTimeoutDuration());
    assertEquals(Duration.ofSeconds(30), callContext.getStreamWaitTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithThreadLevelOverridesClientLevelConfigurator() {
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(60));
          }
        };
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(10));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(clientConfigurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Context context =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
    context.run(
        () -> {
          GrpcCallContext callContext =
              rpc.newCallContext(
                  optionsMap,
                  "/some/resource",
                  ExecuteSqlRequest.getDefaultInstance(),
                  SpannerGrpc.getExecuteStreamingSqlMethod());
          assertEquals(Duration.ofSeconds(10), callContext.getTimeoutDuration());
          assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
          assertEquals(
              ImmutableList.of("projects/some-project"),
              callContext
                  .getExtraHeaders()
                  .get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
        });
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithBothClientAndThreadLevelConfiguratorsMerged() {
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withStreamWaitTimeoutDuration(Duration.ofSeconds(30));
          }
        };
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(10));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(clientConfigurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Context context =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
    context.run(
        () -> {
          GrpcCallContext callContext =
              rpc.newCallContext(
                  optionsMap,
                  "/some/resource",
                  ExecuteSqlRequest.getDefaultInstance(),
                  SpannerGrpc.getExecuteStreamingSqlMethod());
          assertEquals(Duration.ofSeconds(10), callContext.getTimeoutDuration());
          assertEquals(Duration.ofSeconds(30), callContext.getStreamWaitTimeoutDuration());
          assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
          assertEquals(
              ImmutableList.of("projects/some-project"),
              callContext
                  .getExtraHeaders()
                  .get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
        });
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithSpannerCallContextTimeoutConfiguratorClientLevel() {
    SpannerCallContextTimeoutConfigurator configurator =
        SpannerCallContextTimeoutConfigurator.create()
            .withExecuteQueryTimeoutDuration(Duration.ofSeconds(45));
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod());
    assertEquals(Duration.ofSeconds(45), callContext.getTimeoutDuration());
    assertEquals(Duration.ofSeconds(45), callContext.getStreamWaitTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithDerivedContextNoDuplicateHeaders() {
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(60));
          }
        };
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(10));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .enableLeaderAwareRouting()
            .setCallContextConfigurator(clientConfigurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Context context =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
    context.run(
        () -> {
          GrpcCallContext callContext =
              rpc.newCallContext(
                  optionsMap,
                  /* requestId= */ null,
                  "/some/resource",
                  ExecuteSqlRequest.getDefaultInstance(),
                  SpannerGrpc.getExecuteStreamingSqlMethod(),
                  /* routeToLeader= */ true);
          assertEquals(Duration.ofSeconds(10), callContext.getTimeoutDuration());
          assertEquals(
              ImmutableList.of("true"),
              callContext.getExtraHeaders().get("x-goog-spanner-route-to-leader"));
          assertEquals(
              ImmutableList.of("projects/some-project"),
              callContext
                  .getExtraHeaders()
                  .get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
          assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
        });
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextPreservesCustomCallOptionsAndUserHeaders() {
    CallOptions.Key<String> customOptionKey = CallOptions.Key.create("customOptionKey");
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return ((GrpcCallContext) context)
                .withCallOptions(
                    ((GrpcCallContext) context)
                        .getCallOptions()
                        .withOption(customOptionKey, "customValue"))
                .withExtraHeaders(
                    Collections.singletonMap("custom-header", ImmutableList.of("customValue")));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod());
    assertEquals("customValue", callContext.getCallOptions().getOption(customOptionKey));
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    assertEquals(
        ImmutableList.of("customValue"), callContext.getExtraHeaders().get("custom-header"));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithInvalidContextThrowsIllegalArgumentException() {
    ApiCallContext invalidContext =
        (ApiCallContext)
            Proxy.newProxyInstance(
                ApiCallContext.class.getClassLoader(),
                new Class<?>[] {ApiCallContext.class},
                (proxy, method, args) -> null);
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return invalidContext;
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertThrows(
        IllegalArgumentException.class,
        () ->
            rpc.newCallContext(
                optionsMap,
                "/some/resource",
                ExecuteSqlRequest.getDefaultInstance(),
                SpannerGrpc.getExecuteStreamingSqlMethod()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithConfiguratorReturningNullReturnsDefault() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return null;
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod());
    assertNotNull(callContext);
    assertNull(callContext.getTimeoutDuration());
    assertEquals(Duration.ofMinutes(30), callContext.getStreamWaitTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithSpannerCallContextTimeoutConfiguratorForRead() {
    SpannerCallContextTimeoutConfigurator configurator =
        SpannerCallContextTimeoutConfigurator.create()
            .withReadTimeoutDuration(Duration.ofSeconds(45));
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ReadRequest.getDefaultInstance(),
            SpannerGrpc.getStreamingReadMethod());
    assertEquals(Duration.ofSeconds(45), callContext.getTimeoutDuration());
    assertEquals(Duration.ofSeconds(45), callContext.getStreamWaitTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithSpannerCallContextTimeoutConfiguratorForCommit() {
    SpannerCallContextTimeoutConfigurator configurator =
        SpannerCallContextTimeoutConfigurator.create()
            .withCommitTimeoutDuration(Duration.ofSeconds(20));
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            CommitRequest.getDefaultInstance(),
            SpannerGrpc.getCommitMethod());
    assertEquals(Duration.ofSeconds(20), callContext.getTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    rpc.shutdown();
  }

  @Test
  public void
      testNewCallContextPreservesCustomCallOptionsWhenThreadConfiguratorReturnsDeltaContext() {
    CallOptions.Key<String> customOptionKey = CallOptions.Key.create("customOptionKey");
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return ((GrpcCallContext) context)
                .withCallOptions(
                    ((GrpcCallContext) context)
                        .getCallOptions()
                        .withOption(customOptionKey, "customValue"));
          }
        };
    // Thread configurator returns a standalone delta context with default CallOptions.
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return GrpcCallContext.createDefault().withTimeoutDuration(Duration.ofSeconds(10));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(clientConfigurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Context context =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
    context.run(
        () -> {
          GrpcCallContext callContext =
              rpc.newCallContext(
                  optionsMap,
                  "/some/resource",
                  ExecuteSqlRequest.getDefaultInstance(),
                  SpannerGrpc.getExecuteStreamingSqlMethod());
          assertEquals(Duration.ofSeconds(10), callContext.getTimeoutDuration());
          assertEquals("customValue", callContext.getCallOptions().getOption(customOptionKey));
          assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
        });
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithDeltaContextCustomIdleTimeout() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return GrpcCallContext.createDefault()
                .withStreamIdleTimeoutDuration(Duration.ofSeconds(15));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteStreamingSqlMethod());
    assertEquals(Duration.ofSeconds(15), callContext.getStreamIdleTimeoutDuration());
    assertEquals(Duration.ofMinutes(30), callContext.getStreamWaitTimeoutDuration());
    assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextClientDeltaWithCustomCallOptionsAndThreadDerivedContext() {
    CallOptions.Key<String> clientKey = CallOptions.Key.create("clientKey");
    CallContextConfigurator clientConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return GrpcCallContext.createDefault()
                .withCallOptions(CallOptions.DEFAULT.withOption(clientKey, "clientValue"))
                .withExtraHeaders(
                    Collections.singletonMap("custom-header", ImmutableList.of("headerValue")));
          }
        };
    CallContextConfigurator threadConfigurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            return context.withTimeoutDuration(Duration.ofSeconds(15));
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(clientConfigurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Context context =
        Context.current()
            .withValue(SpannerOptions.CALL_CONTEXT_CONFIGURATOR_KEY, threadConfigurator);
    context.run(
        () -> {
          GrpcCallContext callContext =
              rpc.newCallContext(
                  optionsMap,
                  "/some/resource",
                  ExecuteSqlRequest.getDefaultInstance(),
                  SpannerGrpc.getExecuteStreamingSqlMethod());
          assertEquals(Duration.ofSeconds(15), callContext.getTimeoutDuration());
          assertEquals("clientValue", callContext.getCallOptions().getOption(clientKey));
          assertEquals(
              ImmutableList.of("headerValue"), callContext.getExtraHeaders().get("custom-header"));
          assertNotNull(callContext.getCallOptions().getOption(REQUEST_ID_CALL_OPTIONS_KEY));
        });
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithNullMethodDoesNotThrowNpe() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (method.equals(SpannerGrpc.getExecuteStreamingSqlMethod())) {
              return context.withTimeoutDuration(Duration.ofSeconds(10));
            }
            return null;
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext = rpc.newCallContext(optionsMap, "/some/resource", null, null);
    assertNotNull(callContext);
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextConfiguratorThrowsExceptionWrapsInSpannerException() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            throw new RuntimeException("custom configurator failure");
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    SpannerException e =
        assertThrows(
            SpannerException.class,
            () ->
                rpc.newCallContext(
                    optionsMap,
                    "/some/resource",
                    ExecuteSqlRequest.getDefaultInstance(),
                    SpannerGrpc.getExecuteStreamingSqlMethod()));
    assertTrue(e.getMessage().contains("custom configurator failure"));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithAdminMethodAppliesConfigurator() {
    CallContextConfigurator configurator =
        new CallContextConfigurator() {
          @Override
          public <ReqT, RespT> ApiCallContext configure(
              ApiCallContext context, ReqT request, MethodDescriptor<ReqT, RespT> method) {
            if (method == DatabaseAdminGrpc.getListDatabaseRolesMethod()) {
              return context.withTimeoutDuration(Duration.ofSeconds(42));
            }
            return null;
          }
        };
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setCallContextConfigurator(configurator)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    ListDatabaseRolesRequest request =
        ListDatabaseRolesRequest.newBuilder()
            .setParent("projects/p/instances/i/databases/d")
            .build();
    GrpcCallContext callContext =
        rpc.newCallContext(
            /* options= */ null,
            "projects/p/instances/i/databases/d",
            request,
            DatabaseAdminGrpc.getListDatabaseRolesMethod());
    assertEquals(Duration.ofSeconds(42), callContext.getTimeoutDuration());
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithGrpcGcpUsesChannelAffinityRefWithoutDcp() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .enableGrpcGcpExtension()
            .disableDynamicChannelPool()
            .setNumChannels(4)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Map<SpannerRpc.Option, Object> grpcGcpOptions = new HashMap<>();
    grpcGcpOptions.put(Option.CHANNEL_ID_AFFINITY, new ChannelAffinityRef());

    GrpcCallContext callContext =
        rpc.newCallContext(
            grpcGcpOptions,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod());

    assertNull(callContext.getCallOptions().getOption(GcpManagedChannel.AFFINITY_KEY));
    assertThat(callContext.getCallOptions().getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY))
        .isNotNull();
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithGrpcGcpUsesChannelIdAffinityWithDcp() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    Map<SpannerRpc.Option, Object> grpcGcpOptions = new HashMap<>();
    grpcGcpOptions.put(Option.CHANNEL_ID_AFFINITY, new ChannelAffinityRef());

    GrpcCallContext callContext =
        rpc.newCallContext(
            grpcGcpOptions,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod());

    assertNull(callContext.getCallOptions().getOption(GcpManagedChannel.AFFINITY_KEY));
    assertThat(callContext.getCallOptions().getOption(GcpManagedChannel.CHANNEL_AFFINITY_REF_KEY))
        .isNotNull();
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithRouteToLeaderHeader() {
    SpannerOptions options =
        SpannerOptions.newBuilder().setProjectId("some-project").enableLeaderAwareRouting().build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod(),
            true);
    assertNotNull(callContext);
    assertEquals(
        ImmutableList.of("true"),
        callContext.getExtraHeaders().get("x-goog-spanner-route-to-leader"));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithoutRouteToLeaderHeader() {
    SpannerOptions options =
        SpannerOptions.newBuilder().enableLeaderAwareRouting().setProjectId("some-project").build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod(),
            false);
    assertNotNull(callContext);
    assertNull(callContext.getExtraHeaders().get("x-goog-spanner-route-to-leader"));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithRouteToLeaderHeaderAndLarDisabled() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .disableLeaderAwareRouting()
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod(),
            true);
    assertNotNull(callContext);
    assertNull(callContext.getExtraHeaders().get("x-goog-spanner-route-to-leader"));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithEndToEndTracingHeader() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setEnableEndToEndTracing(true)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod());
    assertNotNull(callContext);
    assertEquals(
        ImmutableList.of("true"),
        callContext.getExtraHeaders().get("x-goog-spanner-end-to-end-tracing"));
    assertEquals(
        ImmutableList.of("projects/some-project"),
        callContext.getExtraHeaders().get(ApiClientHeaderProvider.getDefaultResourceHeaderKey()));
    rpc.shutdown();
  }

  @Test
  public void testNewCallContextWithoutEndToEndTracingHeader() {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("some-project")
            .setEnableEndToEndTracing(false)
            .build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    GrpcCallContext callContext =
        rpc.newCallContext(
            optionsMap,
            "/some/resource",
            ExecuteSqlRequest.getDefaultInstance(),
            SpannerGrpc.getExecuteSqlMethod());
    assertNotNull(callContext);
    assertNull(callContext.getExtraHeaders().get("x-goog-spanner-end-to-end-tracing"));
    rpc.shutdown();
  }

  @Test
  public void testEndToEndTracingHeaderWithEnabledTracing() {
    final SpannerOptions options =
        createSpannerOptions().toBuilder().setEnableEndToEndTracing(true).build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(
          transaction -> {
            transaction.executeUpdate(UPDATE_FOO_STATEMENT);
            return null;
          });
    }
    assertTrue(isEndToEndTracing);
  }

  @Test
  public void testEndToEndTracingHeaderWithDisabledTracing() {
    final SpannerOptions options =
        createSpannerOptions().toBuilder().setEnableEndToEndTracing(false).build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(
          transaction -> {
            transaction.executeUpdate(UPDATE_FOO_STATEMENT);
            return null;
          });
    }
    assertFalse(isEndToEndTracing);
  }

  @Test
  public void testAdminRequestsLimitExceededRetryAlgorithm() {
    AdminRequestsLimitExceededRetryAlgorithm<Long> alg =
        new AdminRequestsLimitExceededRetryAlgorithm<>();

    assertThat(alg.shouldRetry(null, 1L)).isFalse();

    ErrorInfo info =
        ErrorInfo.newBuilder()
            .putMetadata("quota_limit", "AdminMethodQuotaPerMinutePerProject")
            .build();
    Metadata.Key<ErrorInfo> key =
        Metadata.Key.of(
            info.getDescriptorForType().getFullName() + Metadata.BINARY_HEADER_SUFFIX,
            ProtoLiteUtils.metadataMarshaller(info));
    Metadata trailers = new Metadata();
    trailers.put(key, info);

    SpannerException adminRateExceeded =
        SpannerExceptionFactory.newSpannerException(
            Status.RESOURCE_EXHAUSTED.withDescription("foo").asRuntimeException(trailers));
    assertThat(alg.shouldRetry(adminRateExceeded, null)).isTrue();

    SpannerException numDatabasesExceeded =
        SpannerExceptionFactory.newSpannerException(
            Status.RESOURCE_EXHAUSTED
                .withDescription("Too many databases on instance")
                .asRuntimeException());
    assertThat(alg.shouldRetry(numDatabasesExceeded, null)).isFalse();

    assertThat(alg.shouldRetry(new Exception("random exception"), null)).isFalse();
  }

  @Test
  public void testDefaultUserAgent() {
    final DatabaseClient databaseClient =
        spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

    try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
      rs.next();
    }

    assertThat(lastSeenHeaders.get(Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER)))
        .contains(defaultUserAgent);
  }

  @Test
  public void testCustomUserAgent() {
    for (String headerId : new String[] {"user-agent", "User-Agent", "USER-AGENT"}) {
      final HeaderProvider userAgentHeaderProvider =
          () -> {
            final Map<String, String> headers = new HashMap<>();
            headers.put(headerId, "test-agent");
            return headers;
          };
      final SpannerOptions options =
          createSpannerOptions().toBuilder().setHeaderProvider(userAgentHeaderProvider).build();
      try (Spanner spanner = options.getService()) {
        final DatabaseClient databaseClient =
            spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

        try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
          rs.next();
        }

        assertThat(lastSeenHeaders.get(Key.of("user-agent", Metadata.ASCII_STRING_MARSHALLER)))
            .contains("test-agent " + defaultUserAgent);
      }
    }
  }

  @Test
  public void testTraceContextHeaderWithOpenTelemetryAndEndToEndTracingEnabled() {
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(SdkTracerProvider.builder().setSampler(Sampler.alwaysOn()).build())
            .build();

    final SpannerOptions options =
        createSpannerOptions().toBuilder()
            .setOpenTelemetry(openTelemetry)
            .setEnableEndToEndTracing(true)
            .build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
        rs.next();
      }

      assertTrue(isTraceContextPresent);
    }
  }

  @Test
  public void testTraceContextHeaderWithOpenTelemetryAndEndToEndTracingDisabled() {
    OpenTelemetry openTelemetry =
        OpenTelemetrySdk.builder()
            .setPropagators(ContextPropagators.create(W3CTraceContextPropagator.getInstance()))
            .setTracerProvider(SdkTracerProvider.builder().setSampler(Sampler.alwaysOn()).build())
            .build();

    final SpannerOptions options =
        createSpannerOptions().toBuilder()
            .setOpenTelemetry(openTelemetry)
            .setEnableEndToEndTracing(false)
            .build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
        rs.next();
      }

      assertFalse(isTraceContextPresent);
    }
  }

  @Test
  public void testTraceContextHeaderWithoutOpenTelemetry() {
    final SpannerOptions options = createSpannerOptions();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
        rs.next();
      }

      assertFalse(isTraceContextPresent);
    }
  }

  @Test
  public void testRouteToLeaderHeaderForReadOnly() {
    final SpannerOptions options =
        createSpannerOptions().toBuilder().enableLeaderAwareRouting().build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));

      try (final ResultSet rs = databaseClient.singleUse().executeQuery(SELECT1AND2)) {
        rs.next();
      }

      assertFalse(isRouteToLeader);
    }
  }

  @Test
  public void testRouteToLeaderHeaderForReadWrite() {
    final SpannerOptions options =
        createSpannerOptions().toBuilder().enableLeaderAwareRouting().build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(
          transaction -> {
            transaction.executeUpdate(UPDATE_FOO_STATEMENT);
            return null;
          });
    }
    assertTrue(isRouteToLeader);
  }

  @Test
  public void testRouteToLeaderHeaderWithLeaderAwareRoutingDisabled() {
    final SpannerOptions options =
        createSpannerOptions().toBuilder().disableLeaderAwareRouting().build();
    try (Spanner spanner = options.getService()) {
      final DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(
          transaction -> {
            transaction.executeUpdate(UPDATE_FOO_STATEMENT);
            return null;
          });
    }
    assertFalse(isRouteToLeader);
  }

  @Test
  public void testClientLibToken() {
    SpannerOptions options = createSpannerOptions();
    try (Spanner spanner = options.getService()) {
      DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
    }
    Key<String> key = Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
    assertTrue(lastSeenHeaders.containsKey(key));
    assertTrue(
        lastSeenHeaders.get(key),
        Objects.requireNonNull(lastSeenHeaders.get(key))
            .contains(ServiceOptions.getGoogApiClientLibName() + "/"));
    // Check that the default header value is only included once in the header.
    // We do this by splitting the entire header by the default header value. The resulting array
    // should have 2 elements.
    assertEquals(
        lastSeenHeaders.get(key),
        2,
        Objects.requireNonNull(lastSeenHeaders.get(key))
            .split(ServiceOptions.getGoogApiClientLibName())
            .length);
    assertTrue(
        lastSeenHeaders.get(key),
        Objects.requireNonNull(lastSeenHeaders.get(key)).contains("gl-java/"));
  }

  @Test
  public void testCustomClientLibToken_alsoContainsDefaultToken() {
    SpannerOptions options =
        createSpannerOptions().toBuilder().setClientLibToken("pg-adapter").build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient databaseClient =
          spanner.getDatabaseClient(DatabaseId.of("[PROJECT]", "[INSTANCE]", "[DATABASE]"));
      TransactionRunner runner = databaseClient.readWriteTransaction();
      runner.run(transaction -> transaction.executeUpdate(UPDATE_FOO_STATEMENT));
    }
    Key<String> key = Key.of("x-goog-api-client", Metadata.ASCII_STRING_MARSHALLER);
    assertTrue(lastSeenHeaders.containsKey(key));
    assertTrue(
        lastSeenHeaders.get(key),
        Objects.requireNonNull(lastSeenHeaders.get(key)).contains("pg-adapter"));
    assertTrue(
        lastSeenHeaders.get(key),
        Objects.requireNonNull(lastSeenHeaders.get(key))
            .contains(ServiceOptions.getGoogApiClientLibName() + "/"));
    assertTrue(
        lastSeenHeaders.get(key),
        Objects.requireNonNull(lastSeenHeaders.get(key)).contains("gl-java/"));
  }

  @Test
  public void testGetDatabaseAdminStubSettings_whenStubInitialized_assertNonNullClientSetting() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);

    assertNotNull(rpc.getDatabaseAdminStubSettings());

    rpc.shutdown();
  }

  @Test
  public void testGetInstanceAdminStubSettings_whenStubInitialized_assertNonNullClientSetting() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);

    assertNotNull(rpc.getInstanceAdminStubSettings());

    rpc.shutdown();
  }

  @Test
  public void testAdminStubSettings_whenStubNotInitialized_assertNullClientSetting() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);

    assertNull(rpc.getDatabaseAdminStubSettings());
    assertNull(rpc.getInstanceAdminStubSettings());

    rpc.shutdown();
  }

  @Test
  public void testConcurrentClientCreationDoesNotRaceOnDirectPathFlag() throws Exception {
    // Concurrent creation of Spanner clients used to cause a data race on the static
    // DIRECTPATH_CHANNEL_CREATED field, which was written from the constructor without
    // synchronization. This verifies that concurrent client creation succeeds and leaves the flag
    // in a consistent state now that the field is volatile.
    int numThreads = 8;
    ExecutorService executor = Executors.newFixedThreadPool(numThreads);
    CountDownLatch start = new CountDownLatch(1);
    List<Future<Void>> futures = new ArrayList<>(numThreads);
    try {
      for (int i = 0; i < numThreads; i++) {
        futures.add(
            executor.submit(
                () -> {
                  start.await();
                  GapicSpannerRpc rpc = new GapicSpannerRpc(createSpannerOptions(), true);
                  try {
                    return null;
                  } finally {
                    rpc.shutdown();
                  }
                }));
      }
      start.countDown();
      for (Future<Void> future : futures) {
        future.get(60L, TimeUnit.SECONDS);
      }
      // The test options connect to a local plaintext mock server, so no DirectPath channel is
      // ever created.
      assertTrue(
          Modifier.isVolatile(
              GapicSpannerRpc.class.getField("DIRECTPATH_CHANNEL_CREATED").getModifiers()));
      assertFalse(GapicSpannerRpc.DIRECTPATH_CHANNEL_CREATED);
    } finally {
      start.countDown();
      for (Future<Void> future : futures) {
        future.cancel(true);
      }
      executor.shutdownNow();
    }
  }

  @Test
  public void testCreateSession_assertSessionProto() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);

    Session session = rpc.createSession("DATABASE_NAME", null, null, null);
    assertNotNull(session);
    assertNotNull(session.getCreateTime());
    assertEquals(false, session.getMultiplexed());
    rpc.shutdown();
  }

  @Test
  public void testCreateSession_whenMultiplexedSessionIsTrue_assertSessionProto() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);

    Session session = rpc.createSession("DATABASE_NAME", null, null, null, true);
    assertNotNull(session);
    assertNotNull(session.getCreateTime());
    assertEquals(true, session.getMultiplexed());
    rpc.shutdown();
  }

  @Test
  public void testCreateSession_whenMultiplexedSessionIsFalse_assertSessionProto() {
    SpannerOptions options = createSpannerOptions();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);

    Session session = rpc.createSession("DATABASE_NAME", null, null, null, false);
    assertNotNull(session);
    assertNotNull(session.getCreateTime());
    assertEquals(false, session.getMultiplexed());
    rpc.shutdown();
  }

  @Test
  public void testChannelEndpointCacheFactoryUsedWhenLocationApiEnabled() {
    AtomicBoolean factoryCalled = new AtomicBoolean(false);
    ChannelEndpointCacheFactory factory =
        baseProvider -> {
          factoryCalled.set(true);
          return new GrpcChannelEndpointCache(baseProvider);
        };

    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
      SpannerOptions options =
          createSpannerOptions().toBuilder().setChannelEndpointCacheFactory(factory).build();
      GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);
      rpc.shutdown();
      assertTrue(factoryCalled.get());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testLocationApiDoesNotOverrideExplicitChannelProvider() {
    AtomicBoolean factoryCalled = new AtomicBoolean(false);
    ChannelEndpointCacheFactory factory =
        baseProvider -> {
          factoryCalled.set(true);
          return new GrpcChannelEndpointCache(baseProvider);
        };

    AtomicBoolean providerUsed = new AtomicBoolean(false);
    TransportChannelProvider channelProvider =
        new RecordingTransportChannelProvider(
            address.getHostString(), server.getPort(), providerUsed);

    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
      SpannerOptions options =
          createSpannerOptions().toBuilder()
              .setChannelProvider(channelProvider)
              .setChannelEndpointCacheFactory(factory)
              .build();
      GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);
      rpc.shutdown();
      assertTrue(providerUsed.get());
      assertFalse(factoryCalled.get());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testLocationApiDisabledInOptionsDoesNotCreateKeyAwareChannelProvider() {
    AtomicBoolean factoryCalled = new AtomicBoolean(false);
    ChannelEndpointCacheFactory factory =
        baseProvider -> {
          factoryCalled.set(true);
          return new GrpcChannelEndpointCache(baseProvider);
        };

    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return false;
            }
          });
      SpannerOptions options =
          createSpannerOptions().toBuilder().setChannelEndpointCacheFactory(factory).build();
      GapicSpannerRpc rpc = new GapicSpannerRpc(options, true);
      rpc.shutdown();
      assertFalse(factoryCalled.get());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testReadRetryableCodesIncludeResourceExhaustedWhenLocationApiEnabled() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
      GapicSpannerRpc rpc = new GapicSpannerRpc(createSpannerOptions(), true);
      try {
        assertThat(rpc.getReadRetryableCodes()).contains(Code.RESOURCE_EXHAUSTED);
      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testExecuteQueryRetryableCodesIncludeResourceExhaustedWhenLocationApiEnabled() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return true;
            }
          });
      GapicSpannerRpc rpc = new GapicSpannerRpc(createSpannerOptions(), true);
      try {
        assertThat(rpc.getExecuteQueryRetryableCodes()).contains(Code.RESOURCE_EXHAUSTED);
      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testReadRetryableCodesDoNotAddResourceExhaustedWhenLocationApiDisabled() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return false;
            }
          });
      GapicSpannerRpc rpc = new GapicSpannerRpc(createSpannerOptions(), true);
      try {
        assertThat(rpc.getReadRetryableCodes())
            .isEqualTo(
                createSpannerOptions()
                    .getSpannerStubSettings()
                    .streamingReadSettings()
                    .getRetryableCodes());
      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testExecuteQueryRetryableCodesDoNotAddResourceExhaustedWhenLocationApiDisabled() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableLocationApi() {
              return false;
            }
          });
      GapicSpannerRpc rpc = new GapicSpannerRpc(createSpannerOptions(), true);
      try {
        assertThat(rpc.getExecuteQueryRetryableCodes())
            .isEqualTo(
                createSpannerOptions()
                    .getSpannerStubSettings()
                    .executeStreamingSqlSettings()
                    .getRetryableCodes());
      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testGrpcGcpExtensionPreservesChannelConfigurator() throws Exception {
    InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
        InstantiatingGrpcChannelProvider.newBuilder();
    AtomicBoolean baseConfiguratorCalled = new AtomicBoolean(false);
    channelProviderBuilder.setChannelConfigurator(
        builder -> {
          baseConfiguratorCalled.set(true);
          return builder;
        });

    SpannerOptions options =
        SpannerOptions.newBuilder().setProjectId("[PROJECT]").enableGrpcGcpExtension().build();

    java.lang.reflect.Method method =
        GapicSpannerRpc.class.getDeclaredMethod(
            "maybeEnableGrpcGcpExtension",
            InstantiatingGrpcChannelProvider.Builder.class,
            SpannerOptions.class,
            DynamicChannelPoolPrimer.class);
    method.setAccessible(true);
    method.invoke(null, channelProviderBuilder, options, null);

    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> chainedConfigurator =
        channelProviderBuilder.getChannelConfigurator();
    chainedConfigurator.apply(NettyChannelBuilder.forAddress("localhost", 1));

    assertTrue(baseConfiguratorCalled.get());
  }

  @Test
  public void testGrpcGcpOtelMetricsDisabledSkipsMeterInjection() throws Exception {
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setGrpcGcpOtelMetricsEnabled(false)
            .build();

    java.lang.reflect.Method method =
        GapicSpannerRpc.class.getDeclaredMethod(
            "grpcGcpOptionsWithMetricsAndDcp", SpannerOptions.class);
    method.setAccessible(true);
    GcpManagedChannelOptions grpcGcpOptions =
        (GcpManagedChannelOptions) method.invoke(null, options);
    GcpMetricsOptions metricsOptions = grpcGcpOptions.getMetricsOptions();

    assertNotNull(metricsOptions);
    assertNull(metricsOptions.getOpenTelemetryMeter());
  }

  @Test
  public void testGrpcGcpOptionsIncludeStaticChannelPoolSettingsWithoutDcp() throws Exception {
    Duration affinityKeyLifetime = Duration.ofMinutes(10);
    Duration cleanupInterval = Duration.ofMinutes(5);
    GcpChannelPoolOptions channelPoolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setAffinityKeyLifetime(affinityKeyLifetime)
            .setCleanupInterval(cleanupInterval)
            .build();
    int numChannels = 7;
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .disableDynamicChannelPool()
            .setNumChannels(numChannels)
            .setGcpChannelPoolOptions(channelPoolOptions)
            .build();

    java.lang.reflect.Method method =
        GapicSpannerRpc.class.getDeclaredMethod(
            "grpcGcpOptionsWithMetricsAndDcp", SpannerOptions.class);
    method.setAccessible(true);
    GcpManagedChannelOptions grpcGcpOptions =
        (GcpManagedChannelOptions) method.invoke(null, options);

    assertEquals(numChannels, grpcGcpOptions.getChannelPoolOptions().getMaxSize());
    assertEquals(numChannels, grpcGcpOptions.getChannelPoolOptions().getMinSize());
    assertEquals(numChannels, grpcGcpOptions.getChannelPoolOptions().getInitSize());
    assertEquals(
        affinityKeyLifetime, grpcGcpOptions.getChannelPoolOptions().getAffinityKeyLifetime());
    assertEquals(cleanupInterval, grpcGcpOptions.getChannelPoolOptions().getCleanupInterval());
    assertEquals(0, grpcGcpOptions.getChannelPoolOptions().getMinRpcPerChannel());
    assertEquals(0, grpcGcpOptions.getChannelPoolOptions().getMaxRpcPerChannel());
    assertEquals(Duration.ZERO, grpcGcpOptions.getChannelPoolOptions().getScaleDownInterval());
  }

  @Test
  public void testGrpcGcpOptionsRetainDynamicChannelPoolSettingsWithDcp() throws Exception {
    Duration affinityKeyLifetime = Duration.ofMinutes(10);
    Duration cleanupInterval = Duration.ofMinutes(5);
    Duration scaleDownInterval = Duration.ofMinutes(3);
    GcpChannelPoolOptions channelPoolOptions =
        GcpChannelPoolOptions.newBuilder()
            .setInitSize(6)
            .setMaxSize(15)
            .setMinSize(3)
            .setDynamicScaling(10, 50, scaleDownInterval)
            .setAffinityKeyLifetime(affinityKeyLifetime)
            .setCleanupInterval(cleanupInterval)
            .build();
    SpannerOptions options =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .enableGrpcGcpExtension()
            .enableDynamicChannelPool()
            .setGcpChannelPoolOptions(channelPoolOptions)
            .build();

    java.lang.reflect.Method method =
        GapicSpannerRpc.class.getDeclaredMethod(
            "grpcGcpOptionsWithMetricsAndDcp", SpannerOptions.class);
    method.setAccessible(true);
    GcpManagedChannelOptions grpcGcpOptions =
        (GcpManagedChannelOptions) method.invoke(null, options);

    assertEquals(6, grpcGcpOptions.getChannelPoolOptions().getInitSize());
    assertEquals(15, grpcGcpOptions.getChannelPoolOptions().getMaxSize());
    assertEquals(3, grpcGcpOptions.getChannelPoolOptions().getMinSize());
    assertEquals(10, grpcGcpOptions.getChannelPoolOptions().getMinRpcPerChannel());
    assertEquals(50, grpcGcpOptions.getChannelPoolOptions().getMaxRpcPerChannel());
    assertEquals(scaleDownInterval, grpcGcpOptions.getChannelPoolOptions().getScaleDownInterval());
    assertEquals(
        affinityKeyLifetime, grpcGcpOptions.getChannelPoolOptions().getAffinityKeyLifetime());
    assertEquals(cleanupInterval, grpcGcpOptions.getChannelPoolOptions().getCleanupInterval());
  }

  @Test
  public void testBuiltInMetricsDisabledSkipsGrpcBuiltInMetricsConfigurator() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableGRPCBuiltInMetrics() {
              return true;
            }
          });

      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("[PROJECT]")
              .setCredentials(STATIC_CREDENTIALS)
              .setBuiltInMetricsEnabled(false)
              .build();
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder();

      options.enablegRPCMetrics(channelProviderBuilder, /* isEmulatorEnabled= */ false);

      assertNull(channelProviderBuilder.getChannelConfigurator());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testEmulatorSkipsGrpcBuiltInMetricsConfigurator() {
    try {
      SpannerOptions.useEnvironment(
          new SpannerOptions.SpannerEnvironment() {
            @Override
            public boolean isEnableGRPCBuiltInMetrics() {
              return true;
            }
          });

      SpannerOptions options =
          SpannerOptions.newBuilder()
              .setProjectId("[PROJECT]")
              .setCredentials(STATIC_CREDENTIALS)
              .setBuiltInMetricsEnabled(true)
              .build();
      InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
          InstantiatingGrpcChannelProvider.newBuilder();

      options.enablegRPCMetrics(channelProviderBuilder, /* isEmulatorEnabled= */ true);

      assertNull(channelProviderBuilder.getChannelConfigurator());
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testSetEmulatorHostIsDetectedWithoutEnvironmentVariable() throws Exception {
    SpannerOptions emulatorOptions =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setEmulatorHost("localhost:1234")
            .build();
    SpannerOptions localhostOptions =
        SpannerOptions.newBuilder()
            .setProjectId("[PROJECT]")
            .setHost("http://localhost:1234")
            .setCredentials(NoCredentials.getInstance())
            .build();
    java.lang.reflect.Method isEmulatorEnabled =
        GapicSpannerRpc.class.getDeclaredMethod(
            "isEmulatorEnabled", SpannerOptions.class, String.class);
    isEmulatorEnabled.setAccessible(true);

    assertTrue((boolean) isEmulatorEnabled.invoke(null, emulatorOptions, null));
    assertFalse((boolean) isEmulatorEnabled.invoke(null, localhostOptions, null));
  }

  private static final class RecordingTransportChannelProvider implements TransportChannelProvider {
    private final String host;
    private final int port;
    private final AtomicBoolean used;

    private RecordingTransportChannelProvider(String host, int port, AtomicBoolean used) {
      this.host = host;
      this.port = port;
      this.used = used;
    }

    @Override
    public GrpcTransportChannel getTransportChannel() throws IOException {
      used.set(true);
      return GrpcTransportChannel.newBuilder()
          .setManagedChannel(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build())
          .build();
    }

    @Override
    public String getTransportName() {
      return GrpcTransportChannel.getGrpcTransportName();
    }

    @Override
    public boolean needsEndpoint() {
      return false;
    }

    @Override
    public boolean needsCredentials() {
      return false;
    }

    @Override
    public boolean needsExecutor() {
      return false;
    }

    @Override
    public boolean needsHeaders() {
      return false;
    }

    @Override
    public boolean shouldAutoClose() {
      return true;
    }

    @Override
    public TransportChannelProvider withEndpoint(String endpoint) {
      return this;
    }

    @Override
    public TransportChannelProvider withCredentials(Credentials credentials) {
      return this;
    }

    @Override
    public TransportChannelProvider withHeaders(Map<String, String> headers) {
      return this;
    }

    @Override
    public TransportChannelProvider withPoolSize(int poolSize) {
      return this;
    }

    @Override
    public TransportChannelProvider withExecutor(ScheduledExecutorService executor) {
      return this;
    }

    @Override
    public TransportChannelProvider withExecutor(Executor executor) {
      return this;
    }

    @Override
    public boolean acceptsPoolSize() {
      return false;
    }
  }

  private SpannerOptions createSpannerOptions() {
    String endpoint = address.getHostString() + ":" + server.getPort();
    return SpannerOptions.newBuilder()
        .setProjectId("[PROJECT]")
        // Set a custom channel configurator to allow http instead of https.
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setEnableDirectAccess(false)
        .setHost("http://" + endpoint)
        // Set static credentials that will return the static OAuth test token.
        .setCredentials(STATIC_CREDENTIALS)
        // Also set a CallCredentialsProvider. These credentials should take precedence above
        // the static credentials.
        .setCallCredentialsProvider(() -> MoreCallCredentials.from(VARIABLE_CREDENTIALS))
        .build();
  }

  @Test
  public void testDirectPathFallbackCreatesOneGrpcGcpLayerPerPath() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    GapicSpannerRpc rpc = null;
    try {
      SpannerOptions options = createDirectPathFallbackObjectCountOptions().build();
      assumeTrue(
          "GCP fallback must be enabled for this DirectPath fallback test",
          options.isEnableGcpFallback());
      GrpcGcpObjectCounts before = countGrpcGcpObjectsFromChannelz();
      rpc = new GapicSpannerRpc(options);
      GrpcGcpObjectCounts counts = countGrpcGcpObjectsFromChannelz().minus(before);
      assertEquals(counts.debugString(), 6, counts.gcpManagedChannels);
      assertEquals(counts.debugString(), 48, counts.channelRefs);
    } finally {
      if (rpc != null) {
        rpc.shutdown();
      }
      SpannerOptions.useDefaultEnvironment();
    }
  }

  @Test
  public void testDirectPathFallbackWithGaxChannelPoolDoesNotCreateGrpcGcpChannelRefs() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    GapicSpannerRpc rpc = null;
    try {
      SpannerOptions options =
          createDirectPathFallbackObjectCountOptions().disableGrpcGcpExtension().build();
      assumeTrue(
          "GCP fallback must be enabled for this DirectPath fallback test",
          options.isEnableGcpFallback());
      GrpcGcpObjectCounts before = countGrpcGcpObjectsFromChannelz();
      rpc = new GapicSpannerRpc(options);
      GrpcGcpObjectCounts counts = countGrpcGcpObjectsFromChannelz().minus(before);
      assertEquals(counts.debugString(), 0, counts.gcpManagedChannels);
      assertEquals(counts.debugString(), 0, counts.channelRefs);
    } finally {
      if (rpc != null) {
        rpc.shutdown();
      }
      SpannerOptions.useDefaultEnvironment();
    }
  }

  private SpannerOptions.Builder createDirectPathFallbackObjectCountOptions() {
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setEnableDirectAccess(true)
        .setHost("http://localhost:1")
        .setCredentials(NoCredentials.getInstance());
  }

  private static GrpcGcpObjectCounts countGrpcGcpObjectsFromChannelz() {
    GrpcGcpObjectCounts counts = new GrpcGcpObjectCounts();
    Object channelz = io.grpc.InternalChannelz.instance();
    Set<Object> visited = Collections.newSetFromMap(new IdentityHashMap<>());
    countGrpcGcpObjectsFromChannelzField(channelz, "rootChannels", visited, counts);
    countGrpcGcpObjectsFromChannelzField(channelz, "subchannels", visited, counts);
    return counts;
  }

  private static void countGrpcGcpObjectsFromChannelzField(
      Object channelz, String fieldName, Set<Object> visited, GrpcGcpObjectCounts counts) {
    try {
      java.lang.reflect.Field field = channelz.getClass().getDeclaredField(fieldName);
      field.setAccessible(true);
      countGrpcGcpObjects(field.get(channelz), visited, counts);
    } catch (RuntimeException | ReflectiveOperationException ignored) {
      // Ignore fields that are not reflectively accessible in this runtime.
    }
  }

  private static void countGrpcGcpObjects(
      Object object, Set<Object> visited, GrpcGcpObjectCounts counts) {
    visitObjectGraph(
        object,
        visited,
        visited1 -> {
          if (visited1 instanceof GcpManagedChannel) {
            counts.gcpManagedChannels++;
          }
          if (visited1.getClass().getName().equals(GRPC_GCP_CHANNEL_REF_CLASS_NAME)) {
            counts.channelRefs++;
          }
        });
  }

  /**
   * Returns the grpc-gcp channel pool that serves the Spanner stub of the given rpc. GAX wraps the
   * pool in its own channel pool and interceptor channels, so it is located by walking the object
   * graph of the rpc.
   */
  @Nullable
  private static GcpManagedChannel findGrpcGcpChannel(GapicSpannerRpc rpc) {
    java.util.concurrent.atomic.AtomicReference<GcpManagedChannel> found =
        new java.util.concurrent.atomic.AtomicReference<>();
    visitObjectGraph(
        rpc,
        Collections.newSetFromMap(new IdentityHashMap<>()),
        object -> {
          if (object instanceof GcpManagedChannel) {
            found.compareAndSet(null, (GcpManagedChannel) object);
          }
        });
    return found.get();
  }

  private static void visitObjectGraph(
      Object object, Set<Object> visited, java.util.function.Consumer<Object> visitor) {
    if (object == null || !visited.add(object)) {
      return;
    }
    visitor.accept(object);
    Class<?> clazz = object.getClass();
    if (object instanceof java.util.concurrent.atomic.AtomicReference<?>) {
      // JDK internals are not reflectively accessible; unwrap the value instead.
      visitObjectGraph(
          ((java.util.concurrent.atomic.AtomicReference<?>) object).get(), visited, visitor);
      return;
    }
    if (object instanceof Collection<?>) {
      for (Object value : (Collection<?>) object) {
        visitObjectGraph(value, visited, visitor);
      }
      return;
    }
    if (object instanceof Map<?, ?>) {
      for (Map.Entry<?, ?> entry : ((Map<?, ?>) object).entrySet()) {
        visitObjectGraph(entry.getKey(), visited, visitor);
        visitObjectGraph(entry.getValue(), visited, visitor);
      }
      return;
    }
    if (clazz.isArray()) {
      int length = Array.getLength(object);
      for (int i = 0; i < length; i++) {
        visitObjectGraph(Array.get(object, i), visited, visitor);
      }
      return;
    }
    if (!shouldInspectFields(clazz)) {
      return;
    }
    for (Class<?> current = clazz; current != null; current = current.getSuperclass()) {
      for (java.lang.reflect.Field field : current.getDeclaredFields()) {
        if (Modifier.isStatic(field.getModifiers())) {
          continue;
        }
        try {
          field.setAccessible(true);
          visitObjectGraph(field.get(object), visited, visitor);
        } catch (RuntimeException | IllegalAccessException ignored) {
          // Ignore fields that are not reflectively accessible in this runtime.
        }
      }
    }
  }

  private static boolean shouldInspectFields(Class<?> clazz) {
    String name = clazz.getName();
    return name.startsWith("com.google.") || name.startsWith("io.grpc.");
  }

  static class TestableGapicSpannerRpc extends GapicSpannerRpc {
    public TestableGapicSpannerRpc(SpannerOptions options) {
      super(options);
    }

    @Override
    OpenTelemetry getFallbackOpenTelemetry(SpannerOptions options) {
      return options.getOpenTelemetry();
    }

    @Override
    GcpFallbackChannelOptions createFallbackChannelOptions(
        GcpFallbackOpenTelemetry fallbackTelemetry, int minFailedCalls) {
      // Override default 1-minute period to 10ms for instant testing
      return GcpFallbackChannelOptions.newBuilder()
          .setPrimaryChannelName("directpath")
          .setFallbackChannelName("cloudpath")
          .setMinFailedCalls(10)
          .setPeriod(Duration.ofMillis(5))
          .setGcpFallbackOpenTelemetry(fallbackTelemetry)
          .build();
    }
  }

  @Test
  public void testFallbackIntegration_doesNotSwitchWhenThresholdNotMet() throws Exception {
    // Setup OpenTelemetry to capture metrics
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setEnableDirectAccess(true)
            .setHost("http://localhost:1") // Closed port
            .setCredentials(NoCredentials.getInstance())
            .setOpenTelemetry(openTelemetry);
    // Make sure the ExecuteBatchDml RPC fails quickly to keep the test fast.
    // Note that the timeout is actually not used. It is the fact that it does not retry that
    // makes it fail fast.
    builder
        .getSpannerStubSettingsBuilder()
        .executeBatchDmlSettings()
        .setSimpleTimeoutNoRetriesDuration(Duration.ofSeconds(10));
    // Setup Options with invalid host to force error
    SpannerOptions options = builder.build();

    TestableGapicSpannerRpc rpc = new TestableGapicSpannerRpc(options);
    try {
      // Make a call that is expected to fail
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  rpc.executeBatchDml(
                      com.google.spanner.v1.ExecuteBatchDmlRequest.newBuilder()
                          .setSession("projects/p/instances/i/databases/d/sessions/s")
                          .build(),
                      null));
      assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());

      // Wait briefly for the 10ms period to trigger the fallback check
      Thread.sleep(10);

      // Verify Fallback via Metrics
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      boolean fallbackOccurred =
          metrics.stream().anyMatch(md -> md.getName().contains("fallback_count") && hasValue(md));

      assertFalse("Fallback metric should not be present", fallbackOccurred);

    } finally {
      rpc.shutdown();
    }
  }

  static class TestableGapicSpannerRpcWithLowerMinFailedCalls extends GapicSpannerRpc {
    public TestableGapicSpannerRpcWithLowerMinFailedCalls(SpannerOptions options) {
      super(options);
    }

    @Override
    OpenTelemetry getFallbackOpenTelemetry(SpannerOptions options) {
      return options.getOpenTelemetry();
    }

    @Override
    GcpFallbackChannelOptions createFallbackChannelOptions(
        GcpFallbackOpenTelemetry fallbackTelemetry, int minFailedCalls) {
      // Override default 1-minute period to 10ms for instant testing
      return GcpFallbackChannelOptions.newBuilder()
          .setPrimaryChannelName("directpath")
          .setFallbackChannelName("cloudpath")
          .setMinFailedCalls(1)
          .setPeriod(Duration.ofMillis(5))
          .setGcpFallbackOpenTelemetry(fallbackTelemetry)
          .build();
    }
  }

  @Test
  public void testFallbackIntegration_switchesToFallbackOnFailure() throws Exception {
    // Setup OpenTelemetry to capture metrics
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    SpannerOptions.Builder builder =
        SpannerOptions.newBuilder()
            .setProjectId("test-project")
            .setEnableDirectAccess(true)
            .setHost("http://localhost:1") // Closed port
            .setCredentials(NoCredentials.getInstance())
            .setOpenTelemetry(openTelemetry);
    // Make sure the ExecuteBatchDml RPC fails quickly to keep the test fast.
    // Note that the timeout is actually not used. It is the fact that it does not retry that
    // makes it fail fast.
    builder
        .getSpannerStubSettingsBuilder()
        .executeBatchDmlSettings()
        .setSimpleTimeoutNoRetriesDuration(Duration.ofSeconds(10));
    // Setup Options with invalid host to force error
    SpannerOptions options = builder.build();

    TestableGapicSpannerRpcWithLowerMinFailedCalls rpc =
        new TestableGapicSpannerRpcWithLowerMinFailedCalls(options);
    try {
      // Make a call that is expected to fail
      SpannerException exception =
          assertThrows(
              SpannerException.class,
              () ->
                  rpc.executeBatchDml(
                      com.google.spanner.v1.ExecuteBatchDmlRequest.newBuilder()
                          .setSession("projects/p/instances/i/databases/d/sessions/s")
                          .build(),
                      null));
      assertEquals(ErrorCode.UNAVAILABLE, exception.getErrorCode());

      // Wait briefly for the 10ms period to trigger the fallback check
      Thread.sleep(10);

      // Verify Fallback via Metrics
      Collection<MetricData> metrics = metricReader.collectAllMetrics();
      boolean fallbackOccurred =
          metrics.stream().anyMatch(md -> md.getName().contains("fallback_count") && hasValue(md));

      assertTrue(
          "Fallback metric should be present, indicating GcpFallbackChannel is active",
          fallbackOccurred);

    } finally {
      rpc.shutdown();
    }
  }

  private boolean hasValue(MetricData metricData) {
    return metricData.getLongSumData().getPoints().stream().anyMatch(point -> point.getValue() > 0);
  }
}
