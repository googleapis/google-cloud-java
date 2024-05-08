/*
 * Copyright 2023 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub.metrics;

import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.APP_PROFILE_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.BIGTABLE_PROJECT_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_NAME_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLIENT_UID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.CLUSTER_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.INSTANCE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.TABLE_ID_KEY;
import static com.google.cloud.bigtable.data.v2.stub.metrics.BuiltinMetricsConstants.ZONE_ID_KEY;
import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.Distribution;
import com.google.api.MonitoredResource;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.stub.MetricServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import io.opentelemetry.api.common.Attributes;
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
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class BigtableCloudMonitoringExporterTest {
  private static final String projectId = "fake-project";
  private static final String instanceId = "fake-instance";
  private static final String appProfileId = "default";
  private static final String tableId = "fake-table";
  private static final String zone = "us-east-1";
  private static final String cluster = "cluster-1";

  private static final String clientName = "fake-client-name";
  private static final String taskId = "fake-task-id";

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock private MetricServiceStub mockMetricServiceStub;
  private MetricServiceClient fakeMetricServiceClient;
  private BigtableCloudMonitoringExporter exporter;

  private Attributes attributes;
  private Resource resource;
  private InstrumentationScopeInfo scope;

  @Before
  public void setUp() {
    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);

    exporter =
        new BigtableCloudMonitoringExporter(
            projectId, fakeMetricServiceClient, /* applicationResource= */ null, taskId);

    attributes =
        Attributes.builder()
            .put(BIGTABLE_PROJECT_ID_KEY, projectId)
            .put(INSTANCE_ID_KEY, instanceId)
            .put(TABLE_ID_KEY, tableId)
            .put(CLUSTER_ID_KEY, cluster)
            .put(ZONE_ID_KEY, zone)
            .put(APP_PROFILE_KEY, appProfileId)
            .build();

    resource = Resource.create(Attributes.empty());

    scope = InstrumentationScopeInfo.create(BuiltinMetricsConstants.METER_NAME);
  }

  @After
  public void tearDown() {}

  @Test
  public void testExportingSumData() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

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

    exporter.export(Arrays.asList(longData));

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
            INSTANCE_ID_KEY.getKey(), instanceId,
            TABLE_ID_KEY.getKey(), tableId,
            CLUSTER_ID_KEY.getKey(), cluster,
            ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(APP_PROFILE_KEY.getKey(), appProfileId, CLIENT_UID_KEY.getKey(), taskId);
    assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(fakeValue);
    assertThat(timeSeries.getPoints(0).getInterval().getStartTime().getNanos())
        .isEqualTo(startEpoch);
    assertThat(timeSeries.getPoints(0).getInterval().getEndTime().getNanos()).isEqualTo(endEpoch);
  }

  @Test
  public void testExportingHistogramData() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

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
            Arrays.asList(1.0),
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

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
            INSTANCE_ID_KEY.getKey(), instanceId,
            TABLE_ID_KEY.getKey(), tableId,
            CLUSTER_ID_KEY.getKey(), cluster,
            ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(APP_PROFILE_KEY.getKey(), appProfileId, CLIENT_UID_KEY.getKey(), taskId);
    Distribution distribution = timeSeries.getPoints(0).getValue().getDistributionValue();
    assertThat(distribution.getCount()).isEqualTo(3);
    assertThat(timeSeries.getPoints(0).getInterval().getStartTime().getNanos())
        .isEqualTo(startEpoch);
    assertThat(timeSeries.getPoints(0).getInterval().getEndTime().getNanos()).isEqualTo(endEpoch);
  }

  @Test
  public void testExportingSumDataInBatches() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

    long startEpoch = 10;
    long endEpoch = 15;

    Collection<MetricData> toExport = new ArrayList<>();
    for (int i = 0; i < 250; i++) {
      Attributes testAttributes =
          Attributes.builder()
              .put(BIGTABLE_PROJECT_ID_KEY, projectId)
              .put(INSTANCE_ID_KEY, instanceId)
              .put(TABLE_ID_KEY, tableId + i)
              .put(CLUSTER_ID_KEY, cluster)
              .put(ZONE_ID_KEY, zone)
              .put(APP_PROFILE_KEY, appProfileId)
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

    assertThat(argumentCaptor.getAllValues()).hasSize(2);
    CreateTimeSeriesRequest firstRequest = argumentCaptor.getAllValues().get(0);
    CreateTimeSeriesRequest secondRequest = argumentCaptor.getAllValues().get(1);

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
              BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
              INSTANCE_ID_KEY.getKey(), instanceId,
              TABLE_ID_KEY.getKey(), tableId + i,
              CLUSTER_ID_KEY.getKey(), cluster,
              ZONE_ID_KEY.getKey(), zone);

      assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
      assertThat(timeSeries.getMetric().getLabelsMap())
          .containsAtLeast(APP_PROFILE_KEY.getKey(), appProfileId, CLIENT_UID_KEY.getKey(), taskId);
      assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(i);
      assertThat(timeSeries.getPoints(0).getInterval().getStartTime().getNanos())
          .isEqualTo(startEpoch);
      assertThat(timeSeries.getPoints(0).getInterval().getEndTime().getNanos()).isEqualTo(endEpoch);
    }
  }

  @Test
  public void testTimeSeriesForMetricWithGceOrGkeResource() {
    String gceProjectId = "fake-gce-project";
    BigtableCloudMonitoringExporter exporter =
        new BigtableCloudMonitoringExporter(
            projectId,
            fakeMetricServiceClient,
            MonitoredResource.newBuilder()
                .setType("gce-instance")
                .putLabels("some-gce-key", "some-gce-value")
                .putLabels("project_id", gceProjectId)
                .build(),
            taskId);
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

    long startEpoch = 10;
    long endEpoch = 15;
    HistogramPointData histogramPointData =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            Attributes.of(
                BIGTABLE_PROJECT_ID_KEY,
                projectId,
                INSTANCE_ID_KEY,
                instanceId,
                APP_PROFILE_KEY,
                appProfileId,
                CLIENT_NAME_KEY,
                clientName),
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

    exporter.export(Arrays.asList(histogramData));

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getName()).isEqualTo("projects/" + gceProjectId);
    assertThat(request.getTimeSeriesList()).hasSize(1);

    com.google.monitoring.v3.TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly("some-gce-key", "some-gce-value", "project_id", gceProjectId);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(5);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(
            BIGTABLE_PROJECT_ID_KEY.getKey(),
            projectId,
            INSTANCE_ID_KEY.getKey(),
            instanceId,
            APP_PROFILE_KEY.getKey(),
            appProfileId,
            CLIENT_NAME_KEY.getKey(),
            clientName,
            CLIENT_UID_KEY.getKey(),
            taskId);
  }

  private static class FakeMetricServiceClient extends MetricServiceClient {

    protected FakeMetricServiceClient(MetricServiceStub stub) {
      super(stub);
    }
  }
}
