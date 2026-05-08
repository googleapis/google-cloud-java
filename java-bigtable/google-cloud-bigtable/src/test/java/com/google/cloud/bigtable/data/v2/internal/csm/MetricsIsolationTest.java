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
package com.google.cloud.bigtable.data.v2.internal.csm;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.tracing.ApiTracerFactory;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.VirtualRpcResponse;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientTransportLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableApplicationBlockingLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableAttemptLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableAttemptLatency2;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableClientBlockingLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableConnectivityErrorCount;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableFirstResponseLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableOperationLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableRemainingDeadline;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableRetryCount;
import com.google.cloud.bigtable.data.v2.internal.csm.tracers.VRpcTracer;
import com.google.cloud.bigtable.data.v2.internal.middleware.VRpc.VRpcResult;
import com.google.cloud.bigtable.data.v2.internal.session.SessionPoolInfo;
import com.google.cloud.bigtable.data.v2.internal.session.VRpcDescriptor;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.truth.Correspondence;
import io.grpc.Deadline;
import io.opencensus.stats.StatsRecorder;
import io.opencensus.tags.Tagger;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class MetricsIsolationTest {
  private ScheduledExecutorService executor;
  private InMemoryMetricReader internalReader;
  private InMemoryMetricReader userReader;
  private MetricsImpl metrics;
  private ClientInfo clientInfo;

  private static final Correspondence<MetricData, String> METRIC_DATA_NAME =
      Correspondence.transforming(MetricData::getName, "metric data name");

  private static final List<String> PUBLIC_METRICS =
      ImmutableList.of(
          TableAttemptLatency.NAME,
          TableOperationLatency.NAME,
          TableFirstResponseLatency.NAME,
          TableRetryCount.NAME,
          TableConnectivityErrorCount.NAME,
          TableApplicationBlockingLatency.NAME,
          TableClientBlockingLatency.NAME);

  private static final List<String> INTERNAL_METRICS =
      ImmutableList.of(
          TableAttemptLatency2.NAME, ClientTransportLatency.NAME, TableRemainingDeadline.NAME);

  @BeforeEach
  void setUp() {
    executor = Executors.newSingleThreadScheduledExecutor();
    internalReader = InMemoryMetricReader.create();
    userReader = InMemoryMetricReader.create();

    clientInfo =
        ClientInfo.builder()
            .setInstanceName(InstanceName.of("project", "instance"))
            .setAppProfileId("profile")
            .build();

    SdkMeterProvider internalMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(internalReader).build();
    OpenTelemetrySdk internalOtel =
        OpenTelemetrySdk.builder().setMeterProvider(internalMeterProvider).build();

    SdkMeterProvider userMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(userReader).build();
    OpenTelemetry userOtel = OpenTelemetrySdk.builder().setMeterProvider(userMeterProvider).build();

    MetricRegistry registry = new MetricRegistry();

    metrics =
        new MetricsImpl(
            registry,
            clientInfo,
            Mockito.mock(ApiTracerFactory.class),
            internalOtel,
            userOtel,
            Mockito.mock(Tagger.class),
            Mockito.mock(StatsRecorder.class),
            executor);
  }

  @AfterEach
  void tearDown() {
    metrics.close();
    executor.shutdown();
  }

  @Test
  void testMetricsIsolation() {
    metrics.start();

    SessionPoolInfo poolInfo =
        SessionPoolInfo.create(
            ClientInfo.builder()
                .setClientName("fake-client")
                .setInstanceName(InstanceName.of("fake-project", "fake-instance"))
                .setAppProfileId("default")
                .build(),
            VRpcDescriptor.TABLE_SESSION,
            "fake-session");

    // 1. Trigger shared and attemptLatency2 metrics (VRpcTracer)
    VRpcTracer tracer =
        metrics.newTableTracer(
            poolInfo, VRpcDescriptor.READ_ROW, Deadline.after(1, TimeUnit.MINUTES));

    tracer.onAttemptStart(null);
    tracer.onRequestSent(PeerInfo.getDefaultInstance());
    tracer.onAttemptFinish(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));
    tracer.onOperationFinish(VRpcResult.createServerOk(VirtualRpcResponse.getDefaultInstance()));

    // user metric should have exactly PUBLIC_METRICS
    assertThat(userReader.collectAllMetrics())
        .comparingElementsUsing(METRIC_DATA_NAME)
        .containsAtLeastElementsIn(PUBLIC_METRICS);
    assertThat(userReader.collectAllMetrics())
        .comparingElementsUsing(METRIC_DATA_NAME)
        .containsNoneIn(INTERNAL_METRICS);

    // internal metric should have exactly PUBLIC_METRICS + INTERNAL_METRICS
    assertThat(internalReader.collectAllMetrics())
        .comparingElementsUsing(METRIC_DATA_NAME)
        .containsAtLeastElementsIn(Iterables.concat(PUBLIC_METRICS, INTERNAL_METRICS));
  }
}
