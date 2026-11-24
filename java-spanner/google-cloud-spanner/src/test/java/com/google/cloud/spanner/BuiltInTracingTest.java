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
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
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

  private InMemorySpanExporter spanExporter;

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
    spanExporter = InMemorySpanExporter.create();
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) -> spanExporter);
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
    ((OpenTelemetrySdk) options.getTracingOpenTelemetry())
        .getSdkTracerProvider()
        .forceFlush()
        .join(10, TimeUnit.SECONDS);

    Metadata headers = lastExecuteSqlHeaders.get();
    assertNotNull(headers);
    assertEquals("true", headers.get(END_TO_END_TRACING_KEY));
    String traceParent = headers.get(TRACE_PARENT_KEY);
    assertNotNull(traceParent);
    String[] traceParentParts = traceParent.split("-");
    assertEquals(1, Integer.parseInt(traceParentParts[3], 16) & 1);
    Optional<SpanData> querySpan =
        spanExporter.getFinishedSpanItems().stream()
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
        "Bearer token", BuiltInTracingProvider.getRequestHeaders(CREDENTIALS).get("Authorization"));
  }

  @Test
  public void credentialsWarningIsLoggedOnceUntilCredentialsWorkAgain() throws IOException {
    AtomicBoolean failing = new AtomicBoolean(true);
    Credentials credentials =
        new OAuth2Credentials() {
          @Override
          public Map<String, List<String>> getRequestMetadata(URI uri) throws IOException {
            if (failing.get()) {
              throw new IOException("test");
            }
            return CREDENTIALS.getRequestMetadata(uri);
          }
        };
    List<LogRecord> warnings = new ArrayList<>();
    Handler handler =
        new Handler() {
          @Override
          public void publish(LogRecord record) {
            if (record.getLevel() == Level.WARNING) {
              warnings.add(record);
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
      BuiltInTracingProvider.getRequestHeaders(credentials);
      BuiltInTracingProvider.getRequestHeaders(credentials);
      assertEquals(1, warnings.size());

      failing.set(false);
      assertEquals(
          "Bearer token",
          BuiltInTracingProvider.getRequestHeaders(credentials).get("Authorization"));
      failing.set(true);
      BuiltInTracingProvider.getRequestHeaders(credentials);
      assertEquals(2, warnings.size());
    } finally {
      logger.removeHandler(handler);
    }
  }

  @Test
  public void clientsOfTheSameProjectShareTheBuiltInOpenTelemetry() {
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions sameProject = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions otherProject =
        createOptionsBuilder().setEnableBuiltInTracing(true).setProjectId("other-project").build();

    OpenTelemetry openTelemetry = options.getTracingOpenTelemetry();

    assertTrue(openTelemetry instanceof OpenTelemetrySdk);
    assertSame(openTelemetry, sameProject.getTracingOpenTelemetry());
    assertNotSame(openTelemetry, otherProject.getTracingOpenTelemetry());
    assertNotSame(openTelemetry, options.getOpenTelemetry());
  }

  @Test
  public void clientsWithDifferentCredentialsObjectsUseDifferentBuiltInOpenTelemetry() {
    OAuth2Credentials otherCredentials = OAuth2Credentials.create(new AccessToken("token", null));
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions otherCredentialsOptions =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setCredentials(otherCredentials)
            .build();

    assertEquals(CREDENTIALS, otherCredentials);
    assertNotSame(
        options.getTracingOpenTelemetry(), otherCredentialsOptions.getTracingOpenTelemetry());
  }

  @Test
  public void builtInOpenTelemetryIsKeptWhenTheTokenIsRefreshed() throws IOException {
    AtomicInteger refreshes = new AtomicInteger();
    OAuth2Credentials credentials =
        new OAuth2Credentials() {
          @Override
          public AccessToken refreshAccessToken() {
            return new AccessToken("token-" + refreshes.incrementAndGet(), null);
          }
        };
    credentials.refresh();
    OpenTelemetry openTelemetry =
        BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry("test-project", credentials, 1.0);

    credentials.refresh();

    assertSame(
        openTelemetry,
        BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry("test-project", credentials, 1.0));
  }

  @Test
  public void builtInTracingIsNotUsedForNewCredentialsAfterTheInstanceLimit() {
    List<Credentials> credentials = new ArrayList<>();
    for (int i = 0; i < BuiltInTracingProvider.MAX_OPEN_TELEMETRY_INSTANCES; i++) {
      credentials.add(OAuth2Credentials.create(new AccessToken("token", null)));
      assertNotNull(
          BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry(
              "test-project", credentials.get(i), 1.0));
    }

    assertNull(
        BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry(
            "test-project", OAuth2Credentials.create(new AccessToken("token", null)), 1.0));
    assertNotNull(
        BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry(
            "test-project", credentials.get(0), 1.0));
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
      ((OpenTelemetrySdk) options.getTracingOpenTelemetry())
          .getSdkTracerProvider()
          .forceFlush()
          .join(10, TimeUnit.SECONDS);

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
  public void shutdownFlushesAllInstancesWithoutHoldingTheLock() throws Exception {
    CountDownLatch exportStarted = new CountDownLatch(1);
    CountDownLatch releaseExport = new CountDownLatch(1);
    List<SpanData> otherSpans = new CopyOnWriteArrayList<>();
    BuiltInTracingProvider.INSTANCE.setSpanExporterFactory(
        (projectId, credentials) ->
            new SpanExporter() {
              @Override
              public CompletableResultCode export(Collection<SpanData> spans) {
                if (projectId.equals("slow-project")) {
                  exportStarted.countDown();
                  try {
                    releaseExport.await();
                  } catch (InterruptedException exception) {
                    Thread.currentThread().interrupt();
                  }
                } else {
                  otherSpans.addAll(spans);
                }
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
            });
    BuiltInTracingProvider.INSTANCE
        .getOrCreateOpenTelemetry("slow-project", CREDENTIALS, 1.0)
        .getTracer("test")
        .spanBuilder("slow")
        .startSpan()
        .end();
    BuiltInTracingProvider.INSTANCE
        .getOrCreateOpenTelemetry("other-project", CREDENTIALS, 1.0)
        .getTracer("test")
        .spanBuilder("other")
        .startSpan()
        .end();

    Thread shutdown = new Thread(BuiltInTracingProvider.INSTANCE::shutdown);
    shutdown.start();
    ExecutorService executor = Executors.newSingleThreadExecutor();
    try {
      assertTrue(exportStarted.await(10, TimeUnit.SECONDS));
      assertNull(
          executor
              .submit(
                  () ->
                      BuiltInTracingProvider.INSTANCE.getOrCreateOpenTelemetry(
                          "new-project", CREDENTIALS, 1.0))
              .get(5, TimeUnit.SECONDS));
      long deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(10);
      while (otherSpans.isEmpty() && System.nanoTime() < deadline) {
        Thread.sleep(10L);
      }
      assertEquals(1, otherSpans.size());
    } finally {
      executor.shutdownNow();
      releaseExport.countDown();
      shutdown.join(TimeUnit.SECONDS.toMillis(15));
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

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
  }

  @Test
  public void builtInTracingIsNotUsedInOtherUniverses() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setUniverseDomain("example.com")
            .build();

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
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

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
  }

  @Test
  public void builtInTracingIsNotUsedWithSpannerOmni() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setType(SpannerOptions.InstanceType.OMNI)
            .build();

    assertFalse(options.getTracingOpenTelemetry() instanceof OpenTelemetrySdk);
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
    assertFalse(spanExporter.getFinishedSpanItems().isEmpty());
  }

  private static void useBuiltInTracingEnvironment() {
    SpannerOptions.useEnvironment(
        new SpannerOptions.SpannerEnvironment() {
          @Override
          public boolean isEnableBuiltInTracing() {
            return true;
          }

          @Override
          public double getBuiltInTracingSamplingRate() {
            return 0.5;
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
    if (enableBuiltInTracing) {
      ((OpenTelemetrySdk) options.getTracingOpenTelemetry())
          .getSdkTracerProvider()
          .forceFlush()
          .join(10, TimeUnit.SECONDS);
    }
    return metricReader.collectAllMetrics().stream()
        .map(MetricData::getName)
        .collect(Collectors.toSet());
  }
}
