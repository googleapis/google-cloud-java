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

import static com.google.common.truth.Truth.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
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
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.grpc.GcpManagedChannelOptions;
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
import com.google.cloud.spanner.SpannerOptionsHelper;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.TransactionRunner;
import com.google.cloud.spanner.spi.v1.GapicSpannerRpc.AdminRequestsLimitExceededRetryAlgorithm;
import com.google.cloud.spanner.spi.v1.SpannerRpc.Option;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.ListValue;
import com.google.rpc.ErrorInfo;
import com.google.spanner.v1.ExecuteSqlRequest;
import com.google.spanner.v1.GetSessionRequest;
import com.google.spanner.v1.ResultSetMetadata;
import com.google.spanner.v1.Session;
import com.google.spanner.v1.SpannerGrpc;
import com.google.spanner.v1.StructType;
import com.google.spanner.v1.StructType.Field;
import com.google.spanner.v1.TypeCode;
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
import java.net.InetSocketAddress;
import java.time.Duration;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
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

  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;
  private static InetSocketAddress address;
  private static final Map<SpannerRpc.Option, Object> optionsMap = new HashMap<>();
  private static Metadata lastSeenHeaders;
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
  public void testNewCallContextWithNullRequestAndNullMethod() {
    SpannerOptions options = SpannerOptions.newBuilder().setProjectId("some-project").build();
    GapicSpannerRpc rpc = new GapicSpannerRpc(options, false);
    assertNotNull(rpc.newCallContext(optionsMap, "/some/resource", null, null));
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
            SpannerOptions.class);
    method.setAccessible(true);
    method.invoke(null, channelProviderBuilder, options);

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

    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableGcpFallback() {
            return true;
          }
        });
    try {
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
            metrics.stream()
                .anyMatch(md -> md.getName().contains("fallback_count") && hasValue(md));

        assertFalse("Fallback metric should not be present", fallbackOccurred);

      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
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

    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableGcpFallback() {
            return true;
          }
        });
    try {
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
            metrics.stream()
                .anyMatch(md -> md.getName().contains("fallback_count") && hasValue(md));

        assertTrue(
            "Fallback metric should be present, indicating GcpFallbackChannel is active",
            fallbackOccurred);

      } finally {
        rpc.shutdown();
      }
    } finally {
      SpannerOptions.useDefaultEnvironment();
    }
  }

  private boolean hasValue(MetricData metricData) {
    return metricData.getLongSumData().getPoints().stream().anyMatch(point -> point.getValue() > 0);
  }
}
