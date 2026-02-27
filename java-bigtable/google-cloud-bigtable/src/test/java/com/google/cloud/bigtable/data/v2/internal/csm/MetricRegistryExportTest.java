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

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static com.google.common.truth.extensions.proto.ProtoTruth.assertThat;

import com.google.api.Distribution;
import com.google.api.MonitoredResource;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.rpc.FixedTransportChannelProvider;
import com.google.bigtable.v2.PeerInfo;
import com.google.bigtable.v2.PeerInfo.TransportType;
import com.google.bigtable.v2.ResponseParams;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.internal.api.InstanceName;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry.RecorderRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.MethodInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.exporter.BigtableCloudMonitoringExporter;
import com.google.cloud.bigtable.gaxx.grpc.BigtableChannelPoolSettings.LoadBalancingStrategy;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Correspondence;
import com.google.common.truth.Truth;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.MetricServiceGrpc.MetricServiceImplBase;
import com.google.monitoring.v3.Point;
import com.google.monitoring.v3.TimeSeries;
import com.google.monitoring.v3.TypedValue;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.Status.Code;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.export.PeriodicMetricReader;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MetricRegistryExportTest {
  private static final InstanceName INSTANCE_NAME = InstanceName.of("my-project", "my-instance");
  private static final String appProfileId = "my-app-profile";
  private static final String tableId = "my-table";
  private static final String clusterId = "my-cluster";
  private static final String clusterZone = "us-east1-b";

  private Server server;
  private FakeMetricService metricService;
  private ManagedChannel fakeServiceChannel;

  private PeriodicMetricReader metricReader;
  private SdkMeterProvider meterProvider;
  private MetricRegistry metricRegistry;
  private RecorderRegistry registry;

  private EnvInfo envInfo;
  private ClientInfo clientInfo =
      ClientInfo.builder().setInstanceName(INSTANCE_NAME).setAppProfileId(appProfileId).build();
  private MethodInfo methodInfo;
  private ResponseParams clusterInfo;
  private PeerInfo peerInfo;

  private MonitoredResource expectedTableMonitoredResource;
  private MonitoredResource expectedClientMonitoredResource;

  @BeforeEach
  void setUp() throws Exception {
    metricService = new FakeMetricService();
    server = FakeServiceBuilder.create(metricService).start();

    envInfo =
        EnvInfo.builder()
            .setPlatform("gcp_compute_engine")
            .setProject("my-client-project")
            .setRegion("us-east1")
            .setHostId("123456")
            .setHostName("my-vm")
            .build();

    fakeServiceChannel =
        ManagedChannelBuilder.forAddress("localhost", server.getPort()).usePlaintext().build();

    metricRegistry = new MetricRegistry();

    MetricServiceClient metricClient =
        MetricServiceClient.create(
            MetricServiceSettings.newBuilder()
                .setTransportChannelProvider(
                    FixedTransportChannelProvider.create(
                        GrpcTransportChannel.create(fakeServiceChannel)))
                .setCredentialsProvider(NoCredentialsProvider.create())
                .build());
    BigtableCloudMonitoringExporter exporter =
        new BigtableCloudMonitoringExporter(
            metricRegistry, () -> envInfo, clientInfo, metricClient);
    metricReader = PeriodicMetricReader.create(exporter);
    meterProvider = SdkMeterProvider.builder().registerMetricReader(metricReader).build();

    registry = metricRegistry.newRecorderRegistry(meterProvider);

    methodInfo = MethodInfo.builder().setName("Bigtable.ReadRow").setStreaming(false).build();

    clusterInfo =
        ResponseParams.newBuilder().setZoneId(clusterZone).setClusterId(clusterId).build();
    peerInfo =
        PeerInfo.newBuilder()
            .setTransportType(TransportType.TRANSPORT_TYPE_SESSION_CLOUD_PATH)
            .setGoogleFrontendId(123)
            .setApplicationFrontendZone("us-east1-c")
            .setApplicationFrontendSubzone("ab")
            .build();

    expectedTableMonitoredResource =
        MonitoredResource.newBuilder()
            .setType("bigtable_client_raw")
            .putLabels("project_id", clientInfo.getInstanceName().getProjectId())
            .putLabels("instance", clientInfo.getInstanceName().getInstanceId())
            .putLabels("cluster", clusterInfo.getClusterId())
            .putLabels("table", tableId)
            .putLabels("zone", clusterInfo.getZoneId())
            .build();

    expectedClientMonitoredResource =
        MonitoredResource.newBuilder()
            .setType("bigtable_client")
            .putLabels("project_id", clientInfo.getInstanceName().getProjectId())
            .putLabels("instance", clientInfo.getInstanceName().getInstanceId())
            .putLabels("app_profile", appProfileId)
            .putLabels("client_project", envInfo.getProject())
            .putLabels("region", envInfo.getRegion())
            .putLabels("cloud_platform", envInfo.getPlatform())
            .putLabels("host_id", envInfo.getHostId())
            .putLabels("host_name", envInfo.getHostName())
            .putLabels("client_name", clientInfo.getClientName())
            .putLabels("uuid", envInfo.getUid())
            .build();
  }

  @AfterEach
  void tearDown() {
    meterProvider.close();
    fakeServiceChannel.shutdown();
    server.shutdownNow();
  }

  @Test
  void testOpLatency() {
    registry.operationLatency.record(
        clientInfo,
        tableId,
        methodInfo,
        clusterInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/operation_latencies");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName(),
            "streaming", Boolean.toString(methodInfo.getStreaming()));

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testAttemptLatency() {
    registry.attemptLatency.record(
        clientInfo,
        tableId,
        clusterInfo,
        methodInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/attempt_latencies");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName(),
            "streaming", Boolean.toString(methodInfo.getStreaming()));

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testAttemptLatency2() {
    registry.attemptLatency2.record(
        clientInfo,
        tableId,
        peerInfo,
        clusterInfo,
        methodInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/attempt_latencies2");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "transport_type", "session_cloudpath",
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "transport_region", "",
            "transport_zone", peerInfo.getApplicationFrontendZone(),
            "transport_subzone", peerInfo.getApplicationFrontendSubzone(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName(),
            "streaming", Boolean.toString(methodInfo.getStreaming()));

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testRetryCount() {
    registry.retryCount.record(
        clientInfo, tableId, methodInfo, clusterInfo, Status.UNAVAILABLE.getCode(), 1);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/retry_count");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName());
    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder().setValue(TypedValue.newBuilder().setInt64Value(1)).build());
  }

  @Test
  void testFirstByteLatency() {
    registry.firstResponseLantency.record(
        clientInfo,
        tableId,
        methodInfo,
        clusterInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/first_response_latencies");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName());

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testServerLatencies() {
    registry.serverLatency.record(
        clientInfo,
        tableId,
        methodInfo,
        clusterInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/server_latencies");
    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName(),
            "streaming", Boolean.toString(methodInfo.getStreaming()));

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testChannelPoolOutstandingRpcs() {
    registry.channelPoolOutstandingRpcs.record(
        clientInfo,
        peerInfo.getTransportType(),
        LoadBalancingStrategy.POWER_OF_TWO_LEAST_IN_FLIGHT,
        true,
        1);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/connection_pool/outstanding_rpcs");
    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "transport_type", "session_cloudpath",
            "lb_policy", "POWER_OF_TWO_LEAST_IN_FLIGHT",
            "streaming", "true");

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(1)))
                .build());
  }

  @Test
  void testConnectivityErrors() {
    registry.connectivityErrorCount.record(
        clientInfo, tableId, methodInfo, clusterInfo, Status.UNAVAILABLE.getCode(), 1);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/connectivity_error_count");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName());

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder().setValue(TypedValue.newBuilder().setInt64Value(1)).build());
  }

  @Test
  void testDpCompatGuage() {
    registry.dpCompatGuage.recordFailure(clientInfo, "something");
    registry.dpCompatGuage.recordSuccess(clientInfo, "ipv4");

    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    List<TimeSeries> timeSeriesList =
        metricService.findTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/direct_access/compatible");

    assertThat(timeSeriesList).hasSize(2);
    for (TimeSeries timeSeries : timeSeriesList) {
      Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);
    }
    assertThat(timeSeriesList)
        .comparingElementsUsing(
            Correspondence.transforming(
                (Function<TimeSeries, Map<String, String>>)
                    input -> input.getMetric().getLabelsMap(),
                "metric labels"))
        .containsExactly(
            ImmutableMap.of(
                "reason", "",
                "ip_preference", "ipv4"),
            ImmutableMap.of(
                "reason", "something",
                "ip_preference", ""));
  }

  @Test
  void testApplicationErrors() {
    registry.applicationBlockingLatency.record(
        clientInfo, tableId, methodInfo, clusterInfo, Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/application_latencies");

    assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName());

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123)))
                .build());
  }

  @Test
  void testClientBlocking() {
    registry.clientBlockingLatency.record(
        clientInfo, tableId, methodInfo, clusterInfo, Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/throttling_latencies");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName());

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testRemainingDeadline() {
    registry.remainingDeadline.record(
        clientInfo,
        tableId,
        methodInfo,
        clusterInfo,
        Status.UNAVAILABLE.getCode(),
        Duration.ofMillis(123));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/remaining_deadline");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedTableMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "UNAVAILABLE",
            "client_uid", envInfo.getUid(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId(),
            "method", methodInfo.getName(),
            "streaming", Boolean.toString(methodInfo.getStreaming()));

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(123.0)))
                .build());
  }

  @Test
  void testPerConnectionErrors() {
    registry.perConnectionErrorCount.record(clientInfo, 1);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/per_connection_error_count");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "project_id", clientInfo.getInstanceName().getProjectId(),
            "client_uid", envInfo.getUid(),
            "instance", clientInfo.getInstanceName().getInstanceId(),
            "client_name", clientInfo.getClientName(),
            "app_profile", clientInfo.getAppProfileId());

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(Distribution.newBuilder().setCount(1).setMean(1)))
                .build());
  }

  @Test
  void testBatchWriteFactor() {
    registry.batchWriteFlowControlFactor.record(
        clientInfo, Code.DEADLINE_EXCEEDED, true, MethodInfo.of("Bigtable.MutateRows", false), 0.5);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/batch_write_flow_control_factor");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            "status", "DEADLINE_EXCEEDED",
            "applied", "true",
            "method", "Bigtable.MutateRows");

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(TypedValue.newBuilder().setDoubleValue(0.5).build())
                .build());
  }

  @Test
  void testBatchWriteQps() {
    registry.batchWriteFlowControlTargetQps.record(
        clientInfo, MethodInfo.of("Bigtable.MutateRows", false), 123);
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/batch_write_flow_control_target_qps");

    Truth.assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly("method", "Bigtable.MutateRows");

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(TypedValue.newBuilder().setDoubleValue(123.0).build())
                .build());
  }

  @Test
  void testPacemaker() {
    registry.pacemakerDelay.record(clientInfo, "background", Duration.ofMillis(1));
    metricReader.forceFlush().join(1, TimeUnit.MINUTES);

    TimeSeries timeSeries =
        metricService.getSingleTimeSeriesByName(
            "bigtable.googleapis.com/internal/client/pacemaker_delays");

    assertThat(timeSeries.getResource()).isEqualTo(expectedClientMonitoredResource);

    assertThat(timeSeries.getMetric().getLabelsMap()).containsExactly("executor", "background");

    assertThat(timeSeries.getPointsList())
        .comparingExpectedFieldsOnly()
        .containsExactly(
            Point.newBuilder()
                .setValue(
                    TypedValue.newBuilder()
                        .setDistributionValue(
                            Distribution.newBuilder().setCount(1).setMean(1000.0)))
                .build());
  }

  private static class FakeMetricService extends MetricServiceImplBase {
    final BlockingDeque<CreateTimeSeriesRequest> requests = new LinkedBlockingDeque<>();

    @Override
    public void createServiceTimeSeries(
        CreateTimeSeriesRequest request, StreamObserver<Empty> responseObserver) {
      requests.add(request);
      responseObserver.onNext(Empty.getDefaultInstance());
      responseObserver.onCompleted();
    }

    List<TimeSeries> findTimeSeriesByName(String name) {
      return requests.stream()
          .flatMap(r -> r.getTimeSeriesList().stream())
          .filter(ts -> name.equals(ts.getMetric().getType()))
          .collect(Collectors.toList());
    }

    TimeSeries getSingleTimeSeriesByName(String name) {
      List<TimeSeries> timeSeriesList = findTimeSeriesByName(name);
      assertWithMessage("Expected to have a single TimeSeries with the name %s", name)
          .that(timeSeriesList)
          .hasSize(1);

      return timeSeriesList.get(0);
    }
  }
}
