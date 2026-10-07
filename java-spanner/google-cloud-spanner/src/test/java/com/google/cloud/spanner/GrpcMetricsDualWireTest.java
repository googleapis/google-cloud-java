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

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.cloud.spanner.connection.AbstractMockServerTest;
import com.google.spanner.v1.CreateSessionRequest;
import com.google.spanner.v1.SpannerGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.netty.shaded.io.grpc.netty.NettyChannelBuilder;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Verifies that wiring two {@link io.grpc.opentelemetry.GrpcOpenTelemetry} instances onto a single
 * channel builder (as done when a Cloud Monitoring sink and a caller-provided sink are both active)
 * records gRPC-layer metrics on each sink exactly once, with no cross-sink inflation.
 *
 * <p>This is the empirical gate for the gRPC-layer fan-out: the additive semantics wire both
 * OpenTelemetry instances into {@code enablegRPCMetrics}, and this test proves each instrument is
 * counted once per sink rather than twice.
 */
@RunWith(JUnit4.class)
public class GrpcMetricsDualWireTest extends AbstractMockServerTest {

  private static final String GRPC_ATTEMPT_STARTED = "grpc.client.attempt.started";

  private static OpenTelemetrySdk newOpenTelemetry(InMemoryMetricReader reader) {
    return OpenTelemetrySdk.builder()
        .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(reader).build())
        .build();
  }

  /** Wires each supplied OpenTelemetry onto the builder using the exact production gRPC config. */
  private static ManagedChannel buildWiredChannel(OpenTelemetry... openTelemetries) {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder();
    for (OpenTelemetry openTelemetry : openTelemetries) {
      BuiltInMetricsProvider.INSTANCE.enableGrpcMetrics(providerBuilder, openTelemetry);
    }
    ManagedChannelBuilder<?> channelBuilder =
        NettyChannelBuilder.forAddress("localhost", getPort()).usePlaintext();
    // Apply the chained channel configurator installed by enableGrpcMetrics.
    ManagedChannelBuilder<?> configured =
        providerBuilder.getChannelConfigurator().apply(channelBuilder);
    return configured.build();
  }

  private static void issueUnaryRpc(ManagedChannel channel) {
    SpannerGrpc.SpannerBlockingStub stub = SpannerGrpc.newBlockingStub(channel);
    stub.createSession(
        CreateSessionRequest.newBuilder()
            .setDatabase("projects/p/instances/i/databases/d")
            .build());
  }

  private static long attemptStartedCount(InMemoryMetricReader reader) {
    return reader.collectAllMetrics().stream()
        .filter(m -> m.getName().equals(GRPC_ATTEMPT_STARTED))
        .flatMap(m -> m.getLongSumData().getPoints().stream())
        .mapToLong(point -> point.getValue())
        .sum();
  }

  @Test
  public void twoGrpcOpenTelemetryInstancesDoNotDoubleCount() {
    // Baseline: a single wired sink sees exactly the real attempt count for one unary RPC.
    InMemoryMetricReader baselineReader = InMemoryMetricReader.create();
    OpenTelemetrySdk baselineOtel = newOpenTelemetry(baselineReader);
    ManagedChannel baselineChannel = buildWiredChannel(baselineOtel);
    long baseline;
    try {
      issueUnaryRpc(baselineChannel);
      baseline = attemptStartedCount(baselineReader);
    } finally {
      baselineChannel.shutdownNow();
      baselineOtel.close();
    }
    assertThat(baseline).isGreaterThan(0L);

    // Dual-wire: two independent sinks on one channel. Each must see the SAME count as the
    // single-sink baseline -- neither inflated (double-counting) nor starved.
    InMemoryMetricReader readerA = InMemoryMetricReader.create();
    InMemoryMetricReader readerB = InMemoryMetricReader.create();
    OpenTelemetrySdk otelA = newOpenTelemetry(readerA);
    OpenTelemetrySdk otelB = newOpenTelemetry(readerB);
    ManagedChannel dualChannel = buildWiredChannel(otelA, otelB);
    try {
      issueUnaryRpc(dualChannel);
      long countA = attemptStartedCount(readerA);
      long countB = attemptStartedCount(readerB);
      assertThat(countA).isEqualTo(baseline);
      assertThat(countB).isEqualTo(baseline);
    } finally {
      dualChannel.shutdownNow();
      otelA.close();
      otelB.close();
    }
  }
}
