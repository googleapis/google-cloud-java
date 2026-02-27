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

package com.google.cloud.bigtable.data.v2.internal.csm.exporter;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.Distribution;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.InstanceName;
import com.google.bigtable.v2.TableName;
import com.google.cloud.bigtable.data.v2.internal.csm.MetricRegistry;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.ClientInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.attributes.EnvInfo;
import com.google.cloud.bigtable.data.v2.internal.csm.metrics.Constants.MetricLabels;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.ClientSchema;
import com.google.cloud.bigtable.data.v2.internal.csm.schema.TableSchema;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.stub.MetricServiceStub;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import com.google.protobuf.util.Timestamps;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.metrics.MeterProvider;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.resources.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BigtableCloudMonitoringExporterTest2 {
  private static final TableName tableName =
      TableName.of("fake-project", "fake-instance", "fake-table");
  private static final String appProfileId = "default";
  private static final String zone = "us-east-1";
  private static final String cluster = "cluster-1";

  private ClientInfo clientInfo;
  private EnvInfo envInfo;

  private FakeMetricServiceStub mockMetricServiceStub;
  private MetricServiceClient fakeMetricServiceClient;
  private BigtableCloudMonitoringExporter exporter;

  private Attributes attributes;
  private Resource resource;
  private InstrumentationScopeInfo scope;

  @Mock(answer = Answers.RETURNS_DEEP_STUBS)
  private MeterProvider meterProvider;

  @BeforeEach
  public void setUp() {
    mockMetricServiceStub = new FakeMetricServiceStub();
    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);

    envInfo =
        EnvInfo.builder()
            .setProject("client-project")
            .setPlatform("gce_instance")
            .setRegion("cleint-region")
            .setHostName("harold")
            .setHostId("1234567890")
            .build();

    clientInfo =
        ClientInfo.builder()
            .setInstanceName(InstanceName.of(tableName.getProject(), tableName.getInstance()))
            .setAppProfileId(appProfileId)
            .build();

    MetricRegistry metricRegistry = new MetricRegistry();
    exporter =
        new BigtableCloudMonitoringExporter(
            metricRegistry, () -> envInfo, clientInfo, fakeMetricServiceClient);

    attributes =
        Attributes.builder()
            .put(TableSchema.BIGTABLE_PROJECT_ID_KEY, tableName.getProject())
            .put(TableSchema.INSTANCE_ID_KEY, tableName.getInstance())
            .put(TableSchema.TABLE_ID_KEY, tableName.getTable())
            .put(TableSchema.CLUSTER_ID_KEY, cluster)
            .put(TableSchema.ZONE_ID_KEY, zone)
            .put(MetricLabels.APP_PROFILE_KEY, appProfileId)
            .build();

    resource = Resource.create(Attributes.empty());

    scope = InstrumentationScopeInfo.create(MetricRegistry.METER_NAME);
  }

  @AfterEach
  public void tearDown() {}

  @Test
  public void testExportingSumData() throws InterruptedException {
    long fakeValue = 11L;

    long startEpoch = 10;
    long endEpoch = 15;
    LongPointData longPointData =
        ImmutableLongPointData.create(startEpoch, endEpoch, attributes, fakeValue);

    MetricData longData =
        ImmutableMetricData.createLongSum(
            resource,
            scope,
            "bigtable.googleapis.com/internal/client/retry_count",
            "description",
            "1",
            ImmutableSumData.create(
                true, AggregationTemporality.CUMULATIVE, ImmutableList.of(longPointData)));

    exporter.export(Collections.singletonList(longData));

    CreateTimeSeriesRequest request = mockMetricServiceStub.requests.poll(1, TimeUnit.MINUTES);

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), tableName.getProject(),
            TableSchema.INSTANCE_ID_KEY.getKey(), tableName.getInstance(),
            TableSchema.TABLE_ID_KEY.getKey(), tableName.getTable(),
            TableSchema.CLUSTER_ID_KEY.getKey(), cluster,
            TableSchema.ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(
            MetricLabels.APP_PROFILE_KEY.getKey(),
            appProfileId,
            MetricLabels.CLIENT_UID.getKey(),
            envInfo.getUid());
    assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(fakeValue);
    assertThat(timeSeries.getPoints(0).getInterval().getStartTime())
        .isEqualTo(Timestamps.fromNanos(startEpoch));
    assertThat(timeSeries.getPoints(0).getInterval().getEndTime())
        .isEqualTo(Timestamps.fromNanos(endEpoch));
  }

  @Test
  public void testExportingHistogramData() throws InterruptedException {
    long startEpoch = 10;
    long endEpoch = 15;
    HistogramPointData histogramPointData =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            attributes,
            3d,
            true,
            1d, // min
            true,
            2d, // max
            Collections.singletonList(1.0),
            Arrays.asList(1L, 2L));

    MetricData histogramData =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "bigtable.googleapis.com/internal/client/operation_latencies",
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData)));

    exporter.export(Arrays.asList(histogramData));

    CreateTimeSeriesRequest request = mockMetricServiceStub.requests.poll(1, TimeUnit.MINUTES);

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), tableName.getProject(),
            TableSchema.INSTANCE_ID_KEY.getKey(), tableName.getInstance(),
            TableSchema.TABLE_ID_KEY.getKey(), tableName.getTable(),
            TableSchema.CLUSTER_ID_KEY.getKey(), cluster,
            TableSchema.ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(
            MetricLabels.APP_PROFILE_KEY.getKey(),
            appProfileId,
            MetricLabels.CLIENT_UID.getKey(),
            this.envInfo.getUid());
    Distribution distribution = timeSeries.getPoints(0).getValue().getDistributionValue();
    assertThat(distribution.getCount()).isEqualTo(3);
    assertThat(timeSeries.getPoints(0).getInterval().getStartTime())
        .isEqualTo(Timestamps.fromNanos(startEpoch));
    assertThat(timeSeries.getPoints(0).getInterval().getEndTime())
        .isEqualTo(Timestamps.fromNanos(endEpoch));
  }

  @Test
  public void testExportingSumDataInBatches() {
    long startEpoch = 10;
    long endEpoch = 15;

    Collection<MetricData> toExport = new ArrayList<>();
    for (int i = 0; i < 250; i++) {
      Attributes testAttributes =
          Attributes.builder()
              .put(TableSchema.BIGTABLE_PROJECT_ID_KEY, tableName.getProject())
              .put(TableSchema.INSTANCE_ID_KEY, tableName.getInstance())
              .put(TableSchema.TABLE_ID_KEY, tableName.getTable() + i)
              .put(TableSchema.CLUSTER_ID_KEY, cluster)
              .put(TableSchema.ZONE_ID_KEY, zone)
              .put(MetricLabels.APP_PROFILE_KEY, appProfileId)
              .build();
      LongPointData longPointData =
          ImmutableLongPointData.create(startEpoch, endEpoch, testAttributes, i);

      MetricData longData =
          ImmutableMetricData.createLongSum(
              resource,
              scope,
              "bigtable.googleapis.com/internal/client/retry_count",
              "description",
              "1",
              ImmutableSumData.create(
                  true, AggregationTemporality.CUMULATIVE, ImmutableList.of(longPointData)));
      toExport.add(longData);
    }

    exporter.export(toExport);

    assertThat(mockMetricServiceStub.requests).hasSize(2);
    CreateTimeSeriesRequest firstRequest = mockMetricServiceStub.requests.poll();
    CreateTimeSeriesRequest secondRequest = mockMetricServiceStub.requests.poll();

    assertThat(firstRequest.getTimeSeriesList()).hasSize(200);
    assertThat(secondRequest.getTimeSeriesList()).hasSize(50);

    for (int i = 0; i < 250; i++) {
      TimeSeries timeSeries;
      if (i < 200) {
        timeSeries = firstRequest.getTimeSeriesList().get(i);
      } else {
        timeSeries = secondRequest.getTimeSeriesList().get(i - 200);
      }

      assertThat(timeSeries.getResource().getLabelsMap())
          .containsExactly(
              TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(),
              tableName.getProject(),
              TableSchema.INSTANCE_ID_KEY.getKey(),
              tableName.getInstance(),
              TableSchema.TABLE_ID_KEY.getKey(),
              tableName.getTable() + i,
              TableSchema.CLUSTER_ID_KEY.getKey(),
              cluster,
              TableSchema.ZONE_ID_KEY.getKey(),
              zone);

      assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
      assertThat(timeSeries.getMetric().getLabelsMap())
          .containsAtLeast(
              MetricLabels.APP_PROFILE_KEY.getKey(),
              appProfileId,
              MetricLabels.CLIENT_UID.getKey(),
              envInfo.getUid());
      assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(i);
      assertThat(timeSeries.getPoints(0).getInterval().getStartTime())
          .isEqualTo(Timestamps.fromNanos(startEpoch));
      assertThat(timeSeries.getPoints(0).getInterval().getEndTime())
          .isEqualTo(Timestamps.fromNanos(endEpoch));
    }
  }

  @Test
  public void testTimeSeriesForMetricWithGceOrGkeResource() throws InterruptedException {
    String gceProjectId = "fake-gce-project";
    EnvInfo envInfo =
        EnvInfo.builder()
            .setPlatform("gce_instance")
            .setProject(gceProjectId)
            .setRegion("cleint-region")
            .setHostId("1234567890")
            .setHostName("harold")
            .build();

    ClientInfo clientInfo =
        ClientInfo.builder()
            .setInstanceName(InstanceName.of(tableName.getProject(), tableName.getInstance()))
            .setAppProfileId(appProfileId)
            .build();

    MetricRegistry metricRegistry = new MetricRegistry();
    BigtableCloudMonitoringExporter exporter =
        new BigtableCloudMonitoringExporter(
            metricRegistry, Suppliers.ofInstance(envInfo), clientInfo, fakeMetricServiceClient);

    long startEpoch = 10;
    long endEpoch = 15;
    HistogramPointData histogramPointData =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            Attributes.of(
                ClientSchema.BIGTABLE_PROJECT_ID_KEY,
                tableName.getProject(),
                ClientSchema.INSTANCE_ID_KEY,
                tableName.getInstance(),
                ClientSchema.APP_PROFILE_KEY,
                appProfileId,
                ClientSchema.CLIENT_NAME,
                clientInfo.getClientName()),
            3d,
            true,
            1d, // min
            true,
            2d, // max
            Arrays.asList(1.0),
            Arrays.asList(1L, 2L));

    MetricData histogramData =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "bigtable.googleapis.com/internal/client/per_connection_error_count",
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData)));

    exporter.export(Collections.singletonList(histogramData));

    CreateTimeSeriesRequest request = mockMetricServiceStub.requests.poll(1, TimeUnit.MINUTES);

    assertThat(request.getName()).isEqualTo("projects/" + tableName.getProject());
    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .isEqualTo(
            ImmutableMap.<String, String>builder()
                .put("project_id", tableName.getProject())
                .put("instance", tableName.getInstance())
                .put("app_profile", appProfileId)
                .put("client_project", gceProjectId)
                .put("region", "cleint-region")
                .put("cloud_platform", "gce_instance")
                .put("host_id", "1234567890")
                .put("host_name", "harold")
                .put("client_name", clientInfo.getClientName())
                .put("uuid", envInfo.getUid())
                .build());

    assertThat(timeSeries.getMetric().getLabelsMap())
        .isEqualTo(
            ImmutableMap.builder()
                .put(ClientSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), tableName.getProject())
                .put(ClientSchema.INSTANCE_ID_KEY.getKey(), tableName.getInstance())
                .put(ClientSchema.APP_PROFILE_KEY.getKey(), appProfileId)
                .put(ClientSchema.CLIENT_NAME.getKey(), clientInfo.getClientName())
                .put(MetricLabels.CLIENT_UID.getKey(), envInfo.getUid())
                .build());
  }

  @Test
  public void testExportingToMultipleProjects() throws InterruptedException {
    long startEpoch = 10;
    long endEpoch = 15;
    HistogramPointData histogramPointData1 =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            attributes,
            3d,
            true,
            1d, // min
            true,
            2d, // max
            Arrays.asList(1.0),
            Arrays.asList(1L, 2L));

    MetricData histogramData1 =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "bigtable.googleapis.com/internal/client/operation_latencies",
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData1)));

    HistogramPointData histogramPointData2 =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            attributes.toBuilder()
                .put(TableSchema.BIGTABLE_PROJECT_ID_KEY, "another-project")
                .build(),
            50d,
            true,
            5d, // min
            true,
            30d, // max
            Arrays.asList(1.0),
            Arrays.asList(5L, 10L));

    MetricData histogramData2 =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "bigtable.googleapis.com/internal/client/operation_latencies",
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData2)));

    exporter.export(Arrays.asList(histogramData1, histogramData2));

    List<CreateTimeSeriesRequest> allValues =
        Arrays.asList(
            mockMetricServiceStub.requests.poll(1, TimeUnit.MINUTES),
            mockMetricServiceStub.requests.poll(1, TimeUnit.MINUTES));

    assertThat(allValues).hasSize(2);

    List<Map<String, String>> labelsMap = new ArrayList<>();
    List<Long> counts = new ArrayList<>();
    allValues.forEach(
        value -> {
          labelsMap.add(value.getTimeSeriesList().get(0).getResource().getLabelsMap());
          counts.add(
              value
                  .getTimeSeriesList()
                  .get(0)
                  .getPoints(0)
                  .getValue()
                  .getDistributionValue()
                  .getCount());
        });

    assertThat(labelsMap)
        .containsExactly(
            ImmutableMap.of(
                TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(),
                tableName.getProject(),
                TableSchema.INSTANCE_ID_KEY.getKey(),
                tableName.getInstance(),
                TableSchema.TABLE_ID_KEY.getKey(),
                tableName.getTable(),
                TableSchema.CLUSTER_ID_KEY.getKey(),
                cluster,
                TableSchema.ZONE_ID_KEY.getKey(),
                zone),
            ImmutableMap.of(
                TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(),
                "another-project",
                TableSchema.INSTANCE_ID_KEY.getKey(),
                tableName.getInstance(),
                TableSchema.TABLE_ID_KEY.getKey(),
                tableName.getTable(),
                TableSchema.CLUSTER_ID_KEY.getKey(),
                cluster,
                TableSchema.ZONE_ID_KEY.getKey(),
                zone));
    assertThat(counts).containsExactly(3l, 15l);
  }

  private static class FakeMetricServiceClient extends MetricServiceClient {
    protected FakeMetricServiceClient(MetricServiceStub stub) {
      super(stub);
    }
  }

  private static class FakeMetricServiceStub extends MetricServiceStub {
    private final BlockingDeque<CreateTimeSeriesRequest> requests = new LinkedBlockingDeque<>();

    @Override
    public UnaryCallable<CreateTimeSeriesRequest, Empty> createServiceTimeSeriesCallable() {
      return new UnaryCallable<CreateTimeSeriesRequest, Empty>() {
        @Override
        public ApiFuture<Empty> futureCall(
            CreateTimeSeriesRequest createTimeSeriesRequest, ApiCallContext apiCallContext) {
          requests.add(createTimeSeriesRequest);
          return ApiFutures.immediateFuture(Empty.getDefaultInstance());
        }
      };
    }

    @Override
    public void close() {}

    @Override
    public void shutdown() {}

    @Override
    public boolean isShutdown() {
      return false;
    }

    @Override
    public boolean isTerminated() {
      return false;
    }

    @Override
    public void shutdownNow() {}

    @Override
    public boolean awaitTermination(long l, TimeUnit timeUnit) throws InterruptedException {
      return false;
    }
  }
}
