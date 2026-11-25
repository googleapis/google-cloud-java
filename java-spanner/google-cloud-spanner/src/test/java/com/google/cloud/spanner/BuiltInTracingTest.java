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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1;
import static com.google.cloud.spanner.MockSpannerTestUtil.SELECT1_RESULTSET;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.common.io.ByteStreams;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.MethodDescriptor;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.ServerServiceDefinition;
import io.grpc.Status;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.grpc.stub.ServerCalls;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.common.export.GrpcSenderProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.resources.Resource;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import io.opentelemetry.sdk.trace.export.SimpleSpanProcessor;
import io.opentelemetry.sdk.trace.export.SpanExporter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.jspecify.annotations.Nullable;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInTracingTest {
  private static final Metadata.Key<String> TRACE_PARENT_KEY =
      Metadata.Key.of("traceparent", Metadata.ASCII_STRING_MARSHALLER);
  private static final Metadata.Key<String> END_TO_END_TRACING_KEY =
      Metadata.Key.of("x-goog-spanner-end-to-end-tracing", Metadata.ASCII_STRING_MARSHALLER);
  private static final OAuth2Credentials CREDENTIALS =
      OAuth2Credentials.create(new AccessToken("token", null));

  private static final AtomicReference<Metadata> lastExecuteSqlHeaders = new AtomicReference<>();
  private static MockSpannerServiceImpl mockSpanner;
  private static Server server;

  private final List<SpanData> exportedSpans = Collections.synchronizedList(new ArrayList<>());

  @BeforeClass
  public static void startMockServer() throws Exception {
    mockSpanner = new MockSpannerServiceImpl();
    mockSpanner.setAbortProbability(0.0D);
    mockSpanner.putStatementResult(StatementResult.query(SELECT1, SELECT1_RESULTSET));
    server =
        NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
            .addService(mockSpanner)
            .intercept(
                new ServerInterceptor() {
                  @Override
                  public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                      ServerCall<ReqT, RespT> call,
                      Metadata headers,
                      ServerCallHandler<ReqT, RespT> next) {
                    if (call.getMethodDescriptor()
                        .getFullMethodName()
                        .equals(SpannerGrpc.getExecuteStreamingSqlMethod().getFullMethodName())) {
                      lastExecuteSqlHeaders.set(headers);
                    }
                    return next.startCall(call, headers);
                  }
                })
            .build()
            .start();
  }

  @AfterClass
  public static void stopMockServer() throws InterruptedException {
    server.shutdown();
    server.awaitTermination();
  }

  @Before
  public void setUp() {
    SpannerOptions.useEnvironment(new SpannerOptions.SpannerEnvironment() {});
    SpannerOptionsHelper.resetActiveTracingFramework();
    GlobalOpenTelemetry.resetForTest();
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) -> new CollectingSpanExporter(exportedSpans, null));
    lastExecuteSqlHeaders.set(null);
  }

  @After
  public void tearDown() {
    BuiltInTracingProvider.INSTANCE.reset();
    GlobalOpenTelemetry.resetForTest();
    SpannerOptionsHelper.resetActiveTracingFramework();
    SpannerOptions.useDefaultEnvironment();
    mockSpanner.reset();
  }

  private static OpenTelemetry createOpenTelemetryWithTracing() {
    return OpenTelemetrySdk.builder()
        .setTracerProvider(
            SdkTracerProvider.builder()
                .addSpanProcessor(SimpleSpanProcessor.create(InMemorySpanExporter.create()))
                .build())
        .build();
  }

  private static OpenTelemetry createMetricsOnlyOpenTelemetry() {
    return OpenTelemetrySdk.builder().setMeterProvider(SdkMeterProvider.builder().build()).build();
  }

  private static SpannerOptions.Builder createOptionsBuilder() {
    return SpannerOptions.newBuilder()
        .setProjectId("test-project")
        .setHost("http://localhost:" + server.getPort())
        .setChannelConfigurator(ManagedChannelBuilder::usePlaintext)
        .setEnableDirectAccess(false)
        .setCredentials(CREDENTIALS);
  }

  @Test
  public void builtInTracingIsDisabledByDefault() {
    SpannerOptions options = createOptionsBuilder().build();

    assertFalse(options.isEnableBuiltInTracing());
    assertEquals(0.01, options.getBuiltInTracingSamplingRate(), 0.0);
    assertFalse(options.isEndToEndTracingEnabled());
    assertSame(TracerProvider.noop(), options.getTracingOpenTelemetry().getTracerProvider());
  }

  @Test
  public void builtInTracingIsConfiguredFromTheEnvironment() {
    useBuiltInTracingEnvironment();

    SpannerOptions options = createOptionsBuilder().build();

    assertTrue(options.isEnableBuiltInTracing());
    assertEquals(0.5, options.getBuiltInTracingSamplingRate(), 0.0);
  }

  @Test
  public void builderSettingsWinOverTheEnvironment() {
    useBuiltInTracingEnvironment();

    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(false)
            .setBuiltInTracingSamplingRate(0.2)
            .build();

    assertFalse(options.isEnableBuiltInTracing());
    assertEquals(0.2, options.getBuiltInTracingSamplingRate(), 0.0);
  }

  @Test
  public void samplingRateMustBeBetweenZeroAndOne() {
    assertThrows(
        IllegalArgumentException.class,
        () -> createOptionsBuilder().setBuiltInTracingSamplingRate(-0.1));
    assertThrows(
        IllegalArgumentException.class,
        () -> createOptionsBuilder().setBuiltInTracingSamplingRate(1.1));
  }

  @Test
  public void samplingRateOfTheEnvironmentIsParsed() {
    assertEquals(0.25, SpannerOptions.parseBuiltInTracingSamplingRate("0.25"), 0.0);
    assertEquals(0.0, SpannerOptions.parseBuiltInTracingSamplingRate("0"), 0.0);
    assertEquals(1.0, SpannerOptions.parseBuiltInTracingSamplingRate("1"), 0.0);
    assertNull(SpannerOptions.parseBuiltInTracingSamplingRate(null));
    assertNull(SpannerOptions.parseBuiltInTracingSamplingRate(""));
    assertNull(SpannerOptions.parseBuiltInTracingSamplingRate("abc"));
    assertNull(SpannerOptions.parseBuiltInTracingSamplingRate("-0.1"));
    assertNull(SpannerOptions.parseBuiltInTracingSamplingRate("1.5"));
  }

  @Test
  public void builtInTracingSendsTheTraceOfTheRequestToSpanner() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .build();
    assertTrue(options.isEndToEndTracingEnabled());

    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("test-project", "test-instance", "test-db"));
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
        while (resultSet.next()) {}
      }
    }
    assertTrue(waitForInstanceCount(0));

    Metadata headers = lastExecuteSqlHeaders.get();
    assertNotNull(headers);
    assertEquals("true", headers.get(END_TO_END_TRACING_KEY));
    String traceParent = headers.get(TRACE_PARENT_KEY);
    assertNotNull(traceParent);
    String[] traceParentParts = traceParent.split("-");
    assertEquals(1, Integer.parseInt(traceParentParts[3], 16) & 1);
    Optional<SpanData> querySpan =
        exportedSpans.stream()
            .filter(span -> span.getName().equals("CloudSpannerOperation.ExecuteStreamingQuery"))
            .findFirst();
    assertTrue(querySpan.isPresent());
    assertEquals(traceParentParts[1], querySpan.get().getTraceId());
    assertEquals(traceParentParts[2], querySpan.get().getSpanId());
    assertEquals(
        "test-project",
        querySpan.get().getResource().getAttribute(AttributeKey.stringKey("gcp.project_id")));
  }

  @Test
  public void resourceUsesTheServiceNameWhenSet() {
    Resource resource = BuiltInTracingProvider.createResource("test-project", "my-service");

    assertEquals("test-project", resource.getAttribute(AttributeKey.stringKey("gcp.project_id")));
    assertEquals("my-service", resource.getAttribute(AttributeKey.stringKey("service.name")));
    assertEquals(
        Resource.getDefault().getAttribute(AttributeKey.stringKey("service.name")),
        BuiltInTracingProvider.createResource("test-project", null)
            .getAttribute(AttributeKey.stringKey("service.name")));
  }

  @Test
  public void requestHeadersContainTheCredentials() {
    assertEquals(
        "Bearer token",
        BuiltInTracingProvider.getRequestHeaders(CREDENTIALS, new AtomicBoolean())
            .get("Authorization"));
  }

  @Test
  public void credentialsWarningIsLoggedOnceUntilCredentialsWorkAgain() {
    AtomicBoolean failing = new AtomicBoolean(true);
    Credentials credentials = createFailingCredentials(failing, new IOException("test"));
    AtomicBoolean warningLogged = new AtomicBoolean();

    List<String> warnings =
        captureLogs(
            Level.WARNING,
            () -> {
              BuiltInTracingProvider.getRequestHeaders(credentials, warningLogged);
              BuiltInTracingProvider.getRequestHeaders(credentials, warningLogged);
            });
    assertEquals(1, warnings.size());

    failing.set(false);
    assertEquals(
        "Bearer token",
        BuiltInTracingProvider.getRequestHeaders(credentials, warningLogged).get("Authorization"));
    failing.set(true);
    warnings =
        captureLogs(
            Level.WARNING,
            () -> BuiltInTracingProvider.getRequestHeaders(credentials, warningLogged));
    assertEquals(1, warnings.size());
  }

  @Test
  public void credentialsWarningOfOneExporterIsNotResetByAnotherExporter() {
    Credentials failingCredentials =
        createFailingCredentials(new AtomicBoolean(true), new IOException("test"));
    AtomicBoolean failingWarningLogged = new AtomicBoolean();
    AtomicBoolean workingWarningLogged = new AtomicBoolean();

    List<String> warnings =
        captureLogs(
            Level.WARNING,
            () -> {
              BuiltInTracingProvider.getRequestHeaders(failingCredentials, failingWarningLogged);
              BuiltInTracingProvider.getRequestHeaders(CREDENTIALS, workingWarningLogged);
              BuiltInTracingProvider.getRequestHeaders(failingCredentials, failingWarningLogged);
            });

    assertEquals(1, warnings.size());
  }

  @Test
  public void requestHeadersAreEmptyWhenTheCredentialsThrowARuntimeException() {
    Credentials credentials =
        createFailingCredentials(new AtomicBoolean(true), new IllegalStateException("test"));
    List<Map<String, String>> headers = new ArrayList<>();

    List<String> warnings =
        captureLogs(
            Level.WARNING,
            () ->
                headers.add(
                    BuiltInTracingProvider.getRequestHeaders(credentials, new AtomicBoolean())));

    assertTrue(headers.get(0).isEmpty());
    assertEquals(1, warnings.size());
  }

  private static Credentials createFailingCredentials(AtomicBoolean failing, Exception failure) {
    return new OAuth2Credentials() {
      @Override
      public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
        if (failing.get()) {
          if (failure instanceof IOException) {
            throw (IOException) failure;
          }
          throw (RuntimeException) failure;
        }
        return CREDENTIALS.getRequestMetadata(uri);
      }
    };
  }

  private static List<String> captureLogs(Level level, Runnable action) {
    List<String> messages = new CopyOnWriteArrayList<>();
    Handler handler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {
            if (record.getLevel() == level) {
              messages.add(record.getMessage());
            }
          }

          @Override
          public void flush() {}

          @Override
          public void close() {}
        };
    Logger logger = Logger.getLogger(BuiltInTracingProvider.class.getName());
    logger.addHandler(handler);
    try {
      action.run();
    } finally {
      logger.removeHandler(handler);
    }
    return messages;
  }

  @Test
  public void eachClientGetsItsOwnBuiltInOpenTelemetry() {
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions sameProject = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    OpenTelemetry openTelemetry = options.getTracingOpenTelemetry();

    assertTrue(openTelemetry instanceof OpenTelemetrySdk);
    assertSame(openTelemetry, options.getTracingOpenTelemetry());
    assertNotSame(openTelemetry, sameProject.getTracingOpenTelemetry());
    assertNotSame(openTelemetry, options.getOpenTelemetry());
  }

  @Test
  public void oneClientUsesOneBuiltInOpenTelemetry() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .setEnableApiTracing(true)
            .build();
    try (Spanner spanner = options.getService()) {
      executeSelect1(spanner);

      assertEquals(1, BuiltInTracingProvider.INSTANCE.instanceCount());
      assertSame(options.getTracingOpenTelemetry(), spanner.getOptions().getTracingOpenTelemetry());
    }
  }

  @Test
  public void builtInOpenTelemetryIsShutDownWhenTheClientIsClosed() throws Exception {
    List<SpanData> exported = new CopyOnWriteArrayList<>();
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) -> new CollectingSpanExporter(exported, null));
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .build();
    Spanner spanner = options.getService();
    executeSelect1(spanner);

    spanner.close();

    assertTrue(waitForInstanceCount(0));
    assertFalse(exported.isEmpty());
    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertEquals(0, BuiltInTracingProvider.INSTANCE.instanceCount());
  }

  @Test
  public void newClientOfTheSameOptionsGetsANewBuiltInOpenTelemetry() {
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    Spanner first = options.getService();
    OpenTelemetry firstOpenTelemetry = options.getTracingOpenTelemetry();
    first.close();

    try (Spanner second = options.getService()) {
      assertNotSame(first, second);
      assertTrue(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
      assertNotSame(firstOpenTelemetry, options.getTracingOpenTelemetry());
    }
  }

  @Test
  public void builtInOpenTelemetryCreatedBeforeTheClientIsClosedWithTheClient() {
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    OpenTelemetry openTelemetry = options.getTracingOpenTelemetry();

    Spanner spanner = options.getService();
    assertSame(openTelemetry, options.getTracingOpenTelemetry());
    assertEquals(1, BuiltInTracingProvider.INSTANCE.instanceCount());
    spanner.close();

    assertTrue(waitForInstanceCount(0));
  }

  @Test
  public void closingTheClientDoesNotWaitForTheExport() throws Exception {
    CountDownLatch exportStarted = new CountDownLatch(1);
    CountDownLatch releaseExport = new CountDownLatch(1);
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) ->
            new CollectingSpanExporter(
                new CopyOnWriteArrayList<>(),
                () -> {
                  exportStarted.countDown();
                  awaitUninterruptibly(releaseExport);
                }));
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .build();
    Spanner spanner = options.getService();
    executeSelect1(spanner);
    try {
      long start = System.nanoTime();
      spanner.close();
      assertTrue(exportStarted.await(10, TimeUnit.SECONDS));
      assertTrue(System.nanoTime() - start < TimeUnit.SECONDS.toNanos(5));
      assertEquals(1, BuiltInTracingProvider.INSTANCE.instanceCount());
    } finally {
      releaseExport.countDown();
    }
    assertTrue(waitForInstanceCount(0));
  }

  @Test
  public void exporterIsOnlyCreatedOnceWhenItFails() {
    AtomicInteger attempts = new AtomicInteger();
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) -> {
          attempts.incrementAndGet();
          throw new IllegalStateException("test");
        });

    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertEquals(1, attempts.get());
  }

  @Test
  public void exporterDoesNotRecordMetricsInTheGlobalOpenTelemetry() {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    GlobalOpenTelemetry.set(
        OpenTelemetrySdk.builder()
            .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(metricReader).build())
            .build());
    InMemorySpanExporter finishedSpans = InMemorySpanExporter.create();
    List<SpanData> spans;
    try (SdkTracerProvider tracerProvider =
        SdkTracerProvider.builder()
            .addSpanProcessor(SimpleSpanProcessor.create(finishedSpans))
            .build()) {
      tracerProvider.get("test").spanBuilder("test").startSpan().end();
      spans = finishedSpans.getFinishedSpanItems();
    }
    SpanExporter exporter =
        BuiltInTracingProvider.createOtlpExporter(
            "http://localhost:" + server.getPort(), CREDENTIALS);

    exporter.export(spans).join(10, TimeUnit.SECONDS);
    exporter.shutdown().join(10, TimeUnit.SECONDS);

    assertTrue(metricReader.collectAllMetrics().isEmpty());
  }

  @Test
  public void exporterSendsSpansWithTheBuiltInSender() throws Exception {
    AtomicReference<Metadata> exportHeaders = new AtomicReference<>();
    AtomicReference<byte[]> exportRequest = new AtomicReference<>();
    Server traceServer = startTraceServer(null, exportHeaders, exportRequest);
    try {
      InMemorySpanExporter finishedSpans = InMemorySpanExporter.create();
      List<SpanData> spans;
      try (SdkTracerProvider tracerProvider =
          SdkTracerProvider.builder()
              .addSpanProcessor(SimpleSpanProcessor.create(finishedSpans))
              .build()) {
        tracerProvider.get("test").spanBuilder("built-in-sender-test").startSpan().end();
        spans = finishedSpans.getFinishedSpanItems();
      }
      SpanExporter exporter =
          BuiltInTracingProvider.createOtlpExporter(
              "http://localhost:" + traceServer.getPort(), CREDENTIALS);

      CompletableResultCode result = exporter.export(spans).join(10, TimeUnit.SECONDS);
      exporter.shutdown().join(10, TimeUnit.SECONDS);

      assertTrue(result.isSuccess());
      assertEquals(
          "Bearer token",
          exportHeaders
              .get()
              .get(Metadata.Key.of("authorization", Metadata.ASCII_STRING_MARSHALLER)));
      assertTrue(
          new String(exportRequest.get(), StandardCharsets.UTF_8).contains("built-in-sender-test"));
    } finally {
      traceServer.shutdownNow();
    }
  }

  @Test
  public void queriesWorkWhenExportingTracesIsDenied() throws Exception {
    AtomicReference<byte[]> exportRequest = new AtomicReference<>();
    Server traceServer =
        startTraceServer(Status.PERMISSION_DENIED, new AtomicReference<>(), exportRequest);
    try {
      String endpoint = "http://localhost:" + traceServer.getPort();
      InMemorySpanExporter finishedSpans = InMemorySpanExporter.create();
      List<SpanData> spans;
      try (SdkTracerProvider tracerProvider =
          SdkTracerProvider.builder()
              .addSpanProcessor(SimpleSpanProcessor.create(finishedSpans))
              .build()) {
        tracerProvider.get("test").spanBuilder("denied").startSpan().end();
        spans = finishedSpans.getFinishedSpanItems();
      }
      SpanExporter exporter = BuiltInTracingProvider.createOtlpExporter(endpoint, CREDENTIALS);
      CompletableResultCode result = exporter.export(spans).join(10, TimeUnit.SECONDS);
      exporter.shutdown().join(10, TimeUnit.SECONDS);
      assertTrue(result.isDone());
      assertFalse(result.isSuccess());

      exportRequest.set(null);
      BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
          (projectId, credentials) ->
              BuiltInTracingProvider.createOtlpExporter(endpoint, credentials));
      SpannerOptions options =
          createOptionsBuilder()
              .setEnableBuiltInTracing(true)
              .setBuiltInTracingSamplingRate(1.0)
              .build();
      long rows = 0;
      try (Spanner spanner = options.getService()) {
        DatabaseClient client =
            spanner.getDatabaseClient(DatabaseId.of("test-project", "test-instance", "test-db"));
        try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
          while (resultSet.next()) {
            rows++;
          }
        }
      }
      assertTrue(waitForInstanceCount(0));

      assertEquals(1, rows);
      assertNotNull(exportRequest.get());
    } finally {
      traceServer.shutdownNow();
    }
  }

  private static Server startTraceServer(
      @Nullable Status failure,
      AtomicReference<Metadata> exportHeaders,
      AtomicReference<byte[]> exportRequest)
      throws IOException {
    MethodDescriptor.Marshaller<byte[]> bytesMarshaller =
        new MethodDescriptor.Marshaller<byte[]>() {
          @Override
          public InputStream stream(byte[] value) {
            return new ByteArrayInputStream(value);
          }

          @Override
          public byte[] parse(InputStream stream) {
            try {
              return ByteStreams.toByteArray(stream);
            } catch (IOException exception) {
              throw new UncheckedIOException(exception);
            }
          }
        };
    MethodDescriptor<byte[], byte[]> exportMethod =
        MethodDescriptor.<byte[], byte[]>newBuilder()
            .setType(MethodDescriptor.MethodType.UNARY)
            .setFullMethodName("opentelemetry.proto.collector.trace.v1.TraceService/Export")
            .setRequestMarshaller(bytesMarshaller)
            .setResponseMarshaller(bytesMarshaller)
            .build();
    return NettyServerBuilder.forAddress(new InetSocketAddress("localhost", 0))
        .addService(
            ServerServiceDefinition.builder("opentelemetry.proto.collector.trace.v1.TraceService")
                .addMethod(
                    exportMethod,
                    ServerCalls.asyncUnaryCall(
                        (request, responseObserver) -> {
                          exportRequest.set(request);
                          if (failure != null) {
                            responseObserver.onError(failure.asRuntimeException());
                            return;
                          }
                          responseObserver.onNext(new byte[0]);
                          responseObserver.onCompleted();
                        }))
                .build())
        .intercept(
            new ServerInterceptor() {
              @Override
              public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
                  ServerCall<ReqT, RespT> call,
                  Metadata headers,
                  ServerCallHandler<ReqT, RespT> next) {
                exportHeaders.set(headers);
                return next.startCall(call, headers);
              }
            })
        .build()
        .start();
  }

  @Test
  public void noGrpcSenderIsRegisteredAsAService() {
    assertFalse(ServiceLoader.load(GrpcSenderProvider.class).iterator().hasNext());
  }

  @Test
  public void shutdownFlushesAllInstancesAtTheSameTimeWithoutHoldingTheLock() throws Exception {
    CountDownLatch slowExportStarted = new CountDownLatch(1);
    CountDownLatch releaseSlowExport = new CountDownLatch(1);
    CountDownLatch otherExported = new CountDownLatch(1);
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) ->
            new CollectingSpanExporter(
                new CopyOnWriteArrayList<>(),
                projectId.equals("slow-project")
                    ? () -> {
                      slowExportStarted.countDown();
                      awaitUninterruptibly(releaseSlowExport);
                    }
                    : otherExported::countDown));
    createOptionsBuilder()
        .setProjectId("slow-project")
        .setEnableBuiltInTracing(true)
        .setBuiltInTracingSamplingRate(1.0)
        .build()
        .getTracingOpenTelemetry()
        .getTracer("test")
        .spanBuilder("slow")
        .startSpan()
        .end();
    createOptionsBuilder()
        .setProjectId("other-project")
        .setEnableBuiltInTracing(true)
        .setBuiltInTracingSamplingRate(1.0)
        .build()
        .getTracingOpenTelemetry()
        .getTracer("test")
        .spanBuilder("other")
        .startSpan()
        .end();

    Thread shutdown = new Thread(BuiltInTracingProvider.INSTANCE::shutdown);
    shutdown.start();
    try {
      assertTrue(slowExportStarted.await(10, TimeUnit.SECONDS));
      assertTrue(otherExported.await(1, TimeUnit.SECONDS));
      assertEquals(2, BuiltInTracingProvider.INSTANCE.instanceCount());
      assertTrue(shutdown.isAlive());
    } finally {
      releaseSlowExport.countDown();
      shutdown.join(TimeUnit.SECONDS.toMillis(15));
    }
    assertFalse(shutdown.isAlive());
  }

  @Test
  public void shutdownWaitsForInstancesOfClosedClients() throws Exception {
    CountDownLatch exportStarted = new CountDownLatch(1);
    CountDownLatch releaseExport = new CountDownLatch(1);
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) ->
            new CollectingSpanExporter(
                new CopyOnWriteArrayList<>(),
                () -> {
                  exportStarted.countDown();
                  awaitUninterruptibly(releaseExport);
                }));
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .build();
    Spanner spanner = options.getService();
    executeSelect1(spanner);
    spanner.close();
    assertTrue(exportStarted.await(10, TimeUnit.SECONDS));

    Thread shutdown = new Thread(BuiltInTracingProvider.INSTANCE::shutdown);
    shutdown.start();
    try {
      shutdown.join(500L);
      assertTrue(shutdown.isAlive());
    } finally {
      releaseExport.countDown();
      shutdown.join(TimeUnit.SECONDS.toMillis(15));
    }
    assertFalse(shutdown.isAlive());
  }

  private static void executeSelect1(Spanner spanner) {
    DatabaseClient client =
        spanner.getDatabaseClient(DatabaseId.of("test-project", "test-instance", "test-db"));
    try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
      while (resultSet.next()) {}
    }
  }

  private static boolean waitForInstanceCount(int count) {
    long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(15);
    while (BuiltInTracingProvider.INSTANCE.instanceCount() != count) {
      if (System.nanoTime() > deadline) {
        return false;
      }
      Thread.yield();
    }
    return true;
  }

  private static void awaitUninterruptibly(CountDownLatch latch) {
    try {
      latch.await(30, TimeUnit.SECONDS);
    } catch (InterruptedException exception) {
      Thread.currentThread().interrupt();
    }
  }

  private static final class CollectingSpanExporter implements SpanExporter {
    private final List<SpanData> spans;
    @Nullable private final Runnable onExport;

    CollectingSpanExporter(List<SpanData> spans, @Nullable Runnable onExport) {
      this.spans = spans;
      this.onExport = onExport;
    }

    @Override
    public CompletableResultCode export(Collection<SpanData> spans) {
      if (onExport != null) {
        onExport.run();
      }
      this.spans.addAll(spans);
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode flush() {
      return CompletableResultCode.ofSuccess();
    }

    @Override
    public CompletableResultCode shutdown() {
      return CompletableResultCode.ofSuccess();
    }
  }

  @Test
  public void openTelemetryOfTheClientIsUsedInsteadOfBuiltInTracing() {
    OpenTelemetry openTelemetry = createOpenTelemetryWithTracing();
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setOpenTelemetry(openTelemetry)
            .build();

    assertSame(openTelemetry, options.getTracingOpenTelemetry());
    assertTrue(options.isEndToEndTracingEnabled());
  }

  @Test
  public void globalOpenTelemetryWithTracingIsUsedInsteadOfBuiltInTracing() {
    GlobalOpenTelemetry.set(createOpenTelemetryWithTracing());
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertSame(GlobalOpenTelemetry.get(), options.getTracingOpenTelemetry());
    assertTrue(options.isEndToEndTracingEnabled());
  }

  @Test
  public void metricsOnlyOpenTelemetryOfTheClientDoesNotDisableBuiltInTracing() {
    OpenTelemetry openTelemetry = createMetricsOnlyOpenTelemetry();
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setOpenTelemetry(openTelemetry)
            .build();

    assertTrue(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertNotSame(openTelemetry, options.getTracingOpenTelemetry());
    assertSame(openTelemetry, options.getOpenTelemetry());
  }

  @Test
  public void metricsOnlyGlobalOpenTelemetryDoesNotDisableBuiltInTracing() {
    GlobalOpenTelemetry.set(createMetricsOnlyOpenTelemetry());
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertTrue(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertSame(GlobalOpenTelemetry.get(), options.getOpenTelemetry());
  }

  @Test
  public void globalOpenTelemetryWithoutTracingDoesNotDisableBuiltInTracing() {
    GlobalOpenTelemetry.get();
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertTrue(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
  }

  @Test
  public void builtInTracingIsNotUsedWithoutCredentials() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setCredentials(NoCredentials.getInstance())
            .build();

    assertBuiltInTracingIsNotUsed(options, "a client without credentials");
  }

  @Test
  public void builtInTracingIsNotUsedInOtherUniverses() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setUniverseDomain("example.com")
            .build();

    assertBuiltInTracingIsNotUsed(options, "universe domain example.com");
  }

  @Test
  public void universeDomainOfTheEnvironmentIsUsedWhenNotSetInTheOptions() {
    assertEquals("googleapis.com", SpannerOptions.resolveBuiltInTracingUniverseDomain(null, null));
    assertEquals("googleapis.com", SpannerOptions.resolveBuiltInTracingUniverseDomain("", ""));
    assertEquals(
        "example.com", SpannerOptions.resolveBuiltInTracingUniverseDomain(null, "example.com"));
    assertEquals(
        "example.com", SpannerOptions.resolveBuiltInTracingUniverseDomain("", "example.com"));
    assertEquals(
        "googleapis.com",
        SpannerOptions.resolveBuiltInTracingUniverseDomain("googleapis.com", "example.com"));
    assertEquals(
        "example.com", SpannerOptions.resolveBuiltInTracingUniverseDomain("example.com", null));
  }

  @Test
  public void builtInTracingIsNotUsedWithTheEmulator() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setEmulatorHost("localhost:" + server.getPort())
            .build();

    assertBuiltInTracingIsNotUsed(options, "the emulator");
  }

  @Test
  public void builtInTracingIsNotUsedWithSpannerOmni() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setType(SpannerOptions.InstanceType.OMNI)
            .build();

    assertBuiltInTracingIsNotUsed(options, "Spanner Omni");
  }

  @Test
  public void endToEndTracingIsNotEnabledWhenBuiltInTracingIsNotUsedWithOpenTelemetry() {
    SpannerOptions.enableOpenTelemetryTraces();
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setEmulatorHost("localhost:" + server.getPort())
            .build();

    assertFalse(options.isEndToEndTracingEnabled());
  }

  @Test
  public void eachReasonForNotUsingBuiltInTracingIsLoggedOnce() {
    SpannerOptions emulator =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setEmulatorHost("localhost:" + server.getPort())
            .build();
    SpannerOptions omni =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setType(SpannerOptions.InstanceType.OMNI)
            .build();

    List<String> messages =
        captureLogs(
            Level.INFO,
            () -> {
              emulator.getTracingOpenTelemetry();
              omni.getTracingOpenTelemetry();
              emulator.getTracingOpenTelemetry();
              omni.getTracingOpenTelemetry();
            });

    assertEquals(
        Arrays.asList(
            "Built-in tracing is enabled, but it is not used with the emulator.",
            "Built-in tracing is enabled, but it is not used with Spanner Omni."),
        messages);
  }

  private static void assertBuiltInTracingIsNotUsed(SpannerOptions options, String reason) {
    List<String> messages =
        captureLogs(
            Level.INFO,
            () -> assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk));

    assertEquals(
        Collections.singletonList(
            "Built-in tracing is enabled, but it is not used with " + reason + "."),
        messages);
    assertFalse(options.isEndToEndTracingEnabled());
    assertEquals(
        SpannerOptions.TracingFramework.OPEN_CENSUS, SpannerOptions.getActiveTracingFramework());
  }

  @Test
  public void invalidSamplingRateOfTheEnvironmentIsLoggedWhenTheBuilderEnablesBuiltInTracing() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public String getBuiltInTracingSamplingRate() {
            return "abc";
          }
        });
    List<SpannerOptions> options = new ArrayList<>();

    List<String> warnings =
        captureLogs(
            Level.WARNING,
            () -> {
              options.add(createOptionsBuilder().build());
              options.add(
                  createOptionsBuilder()
                      .setEnableBuiltInTracing(true)
                      .setBuiltInTracingSamplingRate(0.2)
                      .build());
            });
    assertEquals(0, warnings.size());
    warnings =
        captureLogs(
            Level.WARNING,
            () -> options.add(createOptionsBuilder().setEnableBuiltInTracing(true).build()));

    assertEquals(1, warnings.size());
    assertTrue(warnings.get(0).contains("(abc)"));
    assertEquals(0.01, options.get(0).getBuiltInTracingSamplingRate(), 0.0);
    assertEquals(0.2, options.get(1).getBuiltInTracingSamplingRate(), 0.0);
    assertEquals(0.01, options.get(2).getBuiltInTracingSamplingRate(), 0.0);
  }

  @Test
  public void builtInTracingIsNotUsedWithOpenCensus() {
    createOptionsBuilder().build();
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
    assertFalse(options.isEndToEndTracingEnabled());
  }

  @Test
  public void openCensusCannotBeEnabledAfterAClientWithBuiltInTracing() {
    createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertThrows(IllegalStateException.class, SpannerOptions::enableOpenCensusTraces);
  }

  @Test
  public void builtInTracingIsNotUsedWhenItsSpansCannotBeCurrent() {
    BuiltInTracingProvider.INSTANCE.setContextCheck(() -> false);
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
  }

  @Test
  public void spansOfBuiltInTracingCanBeCurrent() {
    assertTrue(BuiltInTracingProvider.contextCanHoldSpans());
  }

  @Test
  public void builtInTracingDoesNotChangeTheRecordedMetrics() {
    SpannerOptions.enableOpenTelemetryTraces();
    Set<String> metricsWithoutBuiltInTracing = recordMetrics(false);
    Set<String> metricsWithBuiltInTracing = recordMetrics(true);

    assertTrue(
        metricsWithoutBuiltInTracing.contains(
            BuiltInMetricsConstant.CUSTOM_EXPORT_METER_NAME
                + "/"
                + BuiltInMetricsConstant.OPERATION_COUNT_NAME));
    assertEquals(metricsWithoutBuiltInTracing, metricsWithBuiltInTracing);
    assertFalse(exportedSpans.isEmpty());
  }

  private static void useBuiltInTracingEnvironment() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableBuiltInTracing() {
            return true;
          }

          @Override
          public String getBuiltInTracingSamplingRate() {
            return "0.5";
          }
        });
  }

  private Set<String> recordMetrics(boolean enableBuiltInTracing) {
    InMemoryMetricReader metricReader = InMemoryMetricReader.create();
    SdkMeterProviderBuilder meterProviderBuilder =
        SdkMeterProvider.builder().registerMetricReader(metricReader);
    SpannerMetrics.configureMeterProviderBuilder(meterProviderBuilder);
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProviderBuilder.build()).build();
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(enableBuiltInTracing)
            .setBuiltInTracingSamplingRate(1.0)
            .setOpenTelemetry(openTelemetry)
            .setClientMetricsProvider(CustomOpenTelemetryMetricsProvider.create(openTelemetry))
            .setBuiltInMetricsEnabled(false)
            .build();
    try (Spanner spanner = options.getService()) {
      DatabaseClient client =
          spanner.getDatabaseClient(DatabaseId.of("test-project", "test-instance", "test-db"));
      try (ResultSet resultSet = client.singleUse().executeQuery(SELECT1)) {
        while (resultSet.next()) {}
      }
    }
    assertTrue(waitForInstanceCount(0));
    return metricReader.collectAllMetrics().stream()
        .map(MetricData::getName)
        .collect(Collectors.toSet());
  }
}
