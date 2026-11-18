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
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.spanner.MockSpannerServiceImpl.StatementResult;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Metadata;
import io.grpc.Server;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import io.grpc.netty.shaded.io.grpc.netty.NettyServerBuilder;
import io.opentelemetry.api.GlobalOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.trace.TracerProvider;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.testing.exporter.InMemorySpanExporter;
import io.opentelemetry.sdk.trace.SdkTracerProvider;
import io.opentelemetry.sdk.trace.data.SpanData;
import java.net.InetSocketAddress;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
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

    assertThat(options.isEnableBuiltInTracing()).isFalse();
    assertThat(options.getBuiltInTracingSamplingRate()).isEqualTo(0.1);
    assertThat(options.isEndToEndTracingEnabled()).isFalse();
    assertThat(options.getTracingOpenTelemetry().getTracerProvider())
        .isSameInstanceAs(TracerProvider.noop());
  }

  @Test
  public void builtInTracingIsConfiguredFromTheEnvironment() {
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

    SpannerOptions options = createOptionsBuilder().build();

    assertThat(options.isEnableBuiltInTracing()).isTrue();
    assertThat(options.getBuiltInTracingSamplingRate()).isEqualTo(0.5);
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
  public void builtInTracingSendsTheTraceOfTheRequestToSpanner() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setBuiltInTracingSamplingRate(1.0)
            .build();
    assertThat(options.isEndToEndTracingEnabled()).isTrue();

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
    assertThat(headers).isNotNull();
    assertThat(headers.get(END_TO_END_TRACING_KEY)).isEqualTo("true");
    String traceParent = headers.get(TRACE_PARENT_KEY);
    assertThat(traceParent).isNotNull();
    String[] traceParentParts = traceParent.split("-");
    assertThat(Integer.parseInt(traceParentParts[3], 16) & 1).isEqualTo(1);
    List<SpanData> spans = spanExporter.getFinishedSpanItems();
    assertThat(spans).isNotEmpty();
    assertThat(spans.stream().map(SpanData::getTraceId)).contains(traceParentParts[1]);
  }

  @Test
  public void clientsOfTheSameProjectShareTheBuiltInOpenTelemetry() {
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions sameProject = createOptionsBuilder().setEnableBuiltInTracing(true).build();
    SpannerOptions otherProject =
        createOptionsBuilder().setEnableBuiltInTracing(true).setProjectId("other-project").build();

    OpenTelemetry openTelemetry = options.getTracingOpenTelemetry();

    assertThat(openTelemetry).isInstanceOf(OpenTelemetrySdk.class);
    assertThat(sameProject.getTracingOpenTelemetry()).isSameInstanceAs(openTelemetry);
    assertThat(otherProject.getTracingOpenTelemetry()).isNotSameInstanceAs(openTelemetry);
    assertThat(options.getOpenTelemetry()).isNotSameInstanceAs(openTelemetry);
  }

  @Test
  public void openTelemetryOfTheClientIsUsedInsteadOfBuiltInTracing() {
    OpenTelemetry openTelemetry = OpenTelemetry.noop();
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setOpenTelemetry(openTelemetry)
            .build();

    assertThat(options.getTracingOpenTelemetry()).isSameInstanceAs(openTelemetry);
    assertThat(options.isEndToEndTracingEnabled()).isTrue();
  }

  @Test
  public void globalOpenTelemetryWithTracingIsUsedInsteadOfBuiltInTracing() {
    OpenTelemetrySdk global =
        OpenTelemetrySdk.builder().setTracerProvider(SdkTracerProvider.builder().build()).build();
    GlobalOpenTelemetry.set(global);
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertThat(options.getTracingOpenTelemetry()).isSameInstanceAs(GlobalOpenTelemetry.get());
    assertThat(options.isEndToEndTracingEnabled()).isTrue();
  }

  @Test
  public void globalOpenTelemetryWithoutTracingDoesNotDisableBuiltInTracing() {
    GlobalOpenTelemetry.get();
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertThat(options.getTracingOpenTelemetry()).isInstanceOf(OpenTelemetrySdk.class);
  }

  @Test
  public void builtInTracingIsNotUsedWithoutCredentials() {
    SpannerOptions options =
        createOptionsBuilder()
            .setEnableBuiltInTracing(true)
            .setCredentials(NoCredentials.getInstance())
            .build();

    assertThat(options.getTracingOpenTelemetry()).isNotInstanceOf(OpenTelemetrySdk.class);
  }

  @Test
  public void builtInTracingIsNotUsedWithOpenCensus() {
    createOptionsBuilder().build();
    SpannerOptions options = createOptionsBuilder().setEnableBuiltInTracing(true).build();

    assertThat(options.getTracingOpenTelemetry()).isNotInstanceOf(OpenTelemetrySdk.class);
    assertThat(options.isEndToEndTracingEnabled()).isFalse();
  }
}
