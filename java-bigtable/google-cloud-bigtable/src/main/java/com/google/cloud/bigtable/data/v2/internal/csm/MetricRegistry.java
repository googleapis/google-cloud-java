/*
 * Copyright 2025 Google LLC
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

import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientBatchWriteFlowControlFactor;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientBatchWriteFlowControlTargetQps;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientChannelPoolOutstandingRpcs;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientDpCompatGuage;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.ClientPerConnectionErrorCount;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.GrpcMetric;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.MetricWrapper;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.PacemakerDelay;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableApplicationBlockingLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableAttemptLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableAttemptLatency2;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableClientBlockingLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableConnectivityErrorCount;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableDebugTagCount;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableFirstResponseLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableOperationLatency;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableRemainingDeadline;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableRetryCount;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.TableServerLatency;
import com.google.common.collect.ImmutableList;
import io.opentelemetry.api.metrics.Meter;
import io.opentelemetry.api.metrics.MeterProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Repository for all client metrics. This class has 2 audiences:
 *
 * <ul>
 *   <li>VRpcTracer, which reference each metric directly
 *   <li>Exporter, which will look up each metric by name and use the {@link MetricWrapper}
 *       interface to augment the {@code MonitoredResource} and {@code Metric Labels}
 * </ul>
 */
public class MetricRegistry {
  static final String METER_NAME = "bigtable.googleapis.com/internal/client/";

  final TableOperationLatency operationLatencyMetric;
  final TableAttemptLatency attemptLatencyMetric;
  final TableAttemptLatency2 attemptLatency2Metric;
  final TableRetryCount retryCountMetric;
  final TableFirstResponseLatency firstResponseLantencyMetric;
  final TableServerLatency serverLatencyMetric;
  final ClientChannelPoolOutstandingRpcs channelPoolOutstandingRpcsMetric;
  final TableConnectivityErrorCount connectivityErrorCountMetric;
  final ClientDpCompatGuage dpCompatGuageMetric;
  final TableApplicationBlockingLatency applicationBlockingLatencyMetric;
  final TableClientBlockingLatency clientBlockingLatencyMetric;
  final ClientPerConnectionErrorCount perConnectionErrorCountMetric;
  final TableRemainingDeadline remainingDeadlineMetric;
  final ClientBatchWriteFlowControlFactor batchWriteFlowControlFactorMetric;
  final ClientBatchWriteFlowControlTargetQps batchWriteFlowControlTargetQpsMetric;

  final TableDebugTagCount debugTagCountMetric;
  final PacemakerDelay pacemakerDelayMetric;

  private final Map<String, MetricWrapper<?>> metrics = new HashMap<>();
  private final List<String> grpcMetricNames = new ArrayList<>();

  public MetricRegistry() {
    operationLatencyMetric = register(new TableOperationLatency());
    attemptLatencyMetric = register(new TableAttemptLatency());
    attemptLatency2Metric = register(new TableAttemptLatency2());
    retryCountMetric = register(new TableRetryCount());
    firstResponseLantencyMetric = register(new TableFirstResponseLatency());
    serverLatencyMetric = register(new TableServerLatency());
    channelPoolOutstandingRpcsMetric = register(new ClientChannelPoolOutstandingRpcs());
    connectivityErrorCountMetric = register(new TableConnectivityErrorCount());
    applicationBlockingLatencyMetric = register(new TableApplicationBlockingLatency());
    clientBlockingLatencyMetric = register(new TableClientBlockingLatency());
    perConnectionErrorCountMetric = register(new ClientPerConnectionErrorCount());
    dpCompatGuageMetric = register(new ClientDpCompatGuage());
    remainingDeadlineMetric = register(new TableRemainingDeadline());
    batchWriteFlowControlFactorMetric = register(new ClientBatchWriteFlowControlFactor());
    batchWriteFlowControlTargetQpsMetric = register(new ClientBatchWriteFlowControlTargetQps());

    debugTagCountMetric = register(new TableDebugTagCount());
    pacemakerDelayMetric = register(new PacemakerDelay());

    // From
    // https://github.com/grpc/grpc-java/blob/31fdb6c2268b4b1c8ba6c995ee46c58e84a831aa/rls/src/main/java/io/grpc/rls/CachingRlsLbClient.java#L138-L165
    registerGrpcMetric(
        "grpc.client.attempt.duration",
        ImmutableList.of("grpc.lb.locality", "grpc.status", "grpc.method", "grpc.target"));
    registerGrpcMetric(
        "grpc.lb.rls.default_target_picks",
        ImmutableList.of(
            "grpc.target",
            "grpc.lb.rls.server_target",
            "grpc.lb.rls.data_plane_target",
            "grpc.lb.pick_result"));
    registerGrpcMetric(
        "grpc.lb.rls.target_picks",
        ImmutableList.of(
            "grpc.target",
            "grpc.lb.rls.server_target",
            "grpc.lb.rls.data_plane_target",
            "grpc.lb.pick_result"));
    registerGrpcMetric(
        "grpc.lb.rls.failed_picks", ImmutableList.of("grpc.target", "grpc.lb.rls.server_target"));

    // From
    // https://github.com/grpc/grpc-java/blob/31fdb6c2268b4b1c8ba6c995ee46c58e84a831aa/xds/src/main/java/io/grpc/xds/XdsClientMetricReporterImpl.java#L67-L94
    // TODO: "grpc.xds_client.connected"
    registerGrpcMetric(
        "grpc.xds_client.server_failure", ImmutableList.of("grpc.target", "grpc.xds.server"));
    // TODO: "grpc.xds_client.resource_updates_valid",
    registerGrpcMetric(
        "grpc.xds_client.resource_updates_invalid",
        ImmutableList.of("grpc.target", "grpc.xds.server", "grpc.xds.resource_type"));
    // TODO: "grpc.xds_client.resources"

    // From
    // https://github.com/grpc/proposal/blob/86990145a7cef9e5473a132709b2556fec00c4c6/A94-subchannel-otel-metrics.md
    registerGrpcMetric(
        "grpc.subchannel.disconnections",
        ImmutableList.of(
            "grpc.target", "grpc.lb.backend_service", "grpc.lb.locality", "grpc.disconnect_error"));

    registerGrpcMetric(
        "grpc.subchannel.connection_attempts_succeeded",
        ImmutableList.of("grpc.target", "grpc.lb.backend_service", "grpc.lb.locality"));

    registerGrpcMetric(
        "grpc.subchannel.connection_attempts_failed",
        ImmutableList.of("grpc.target", "grpc.lb.backend_service", "grpc.lb.locality"));

    registerGrpcMetric(
        "grpc.subchannel.open_connections",
        ImmutableList.of(
            "grpc.target", "grpc.security_level", "grpc.lb.backend_service", "grpc.lb.locality"));
  }

  private void registerGrpcMetric(String name, List<String> labels) {
    grpcMetricNames.add(name);
    register(new GrpcMetric(name, labels));
  }

  private <T extends MetricWrapper<?>> T register(T instrument) {
    metrics.put(instrument.getName(), instrument);
    return instrument;
  }

  List<String> getGrpcMetricNames() {
    return ImmutableList.copyOf(grpcMetricNames);
  }

  public MetricWrapper<?> getMetric(String name) {
    return metrics.get(name);
  }

  public RecorderRegistry newRecorderRegistry(MeterProvider meterProvider) {
    return new RecorderRegistry(meterProvider.get(METER_NAME));
  }

  public class RecorderRegistry {
    public final TableOperationLatency.Recorder operationLatency;
    public final TableAttemptLatency.Recorder attemptLatency;
    public final TableAttemptLatency2.Recorder attemptLatency2;
    public final TableRetryCount.Recorder retryCount;
    public final TableFirstResponseLatency.Recorder firstResponseLantency;
    public final TableServerLatency.Recorder serverLatency;
    public final ClientChannelPoolOutstandingRpcs.Recorder channelPoolOutstandingRpcs;
    public final TableConnectivityErrorCount.Recorder connectivityErrorCount;
    public final ClientDpCompatGuage.Recorder dpCompatGuage;
    public final TableApplicationBlockingLatency.Recorder applicationBlockingLatency;
    public final TableClientBlockingLatency.Recorder clientBlockingLatency;
    public final ClientPerConnectionErrorCount.Recorder perConnectionErrorCount;
    public final TableRemainingDeadline.Recorder remainingDeadline;
    public final ClientBatchWriteFlowControlTargetQps.Recorder batchWriteFlowControlTargetQps;
    public final ClientBatchWriteFlowControlFactor.Recorder batchWriteFlowControlFactor;

    public final TableDebugTagCount.Recorder debugTagCount;

    final PacemakerDelay.Recorder pacemakerDelay;

    private RecorderRegistry(Meter meter) {
      operationLatency = operationLatencyMetric.newRecorder(meter);
      attemptLatency = attemptLatencyMetric.newRecorder(meter);
      attemptLatency2 = attemptLatency2Metric.newRecorder(meter);
      retryCount = retryCountMetric.newRecorder(meter);
      firstResponseLantency = firstResponseLantencyMetric.newRecorder(meter);
      serverLatency = serverLatencyMetric.newRecorder(meter);
      channelPoolOutstandingRpcs = channelPoolOutstandingRpcsMetric.newRecorder(meter);
      connectivityErrorCount = connectivityErrorCountMetric.newRecorder(meter);
      dpCompatGuage = dpCompatGuageMetric.newRecorder(meter);
      applicationBlockingLatency = applicationBlockingLatencyMetric.newRecorder(meter);
      clientBlockingLatency = clientBlockingLatencyMetric.newRecorder(meter);
      perConnectionErrorCount = perConnectionErrorCountMetric.newRecorder(meter);
      remainingDeadline = remainingDeadlineMetric.newRecorder(meter);
      batchWriteFlowControlTargetQps = batchWriteFlowControlTargetQpsMetric.newRecorder(meter);
      batchWriteFlowControlFactor = batchWriteFlowControlFactorMetric.newRecorder(meter);

      debugTagCount = debugTagCountMetric.newRecorder(meter);
      pacemakerDelay = pacemakerDelayMetric.newRecorder(meter);
    }
  }
}
