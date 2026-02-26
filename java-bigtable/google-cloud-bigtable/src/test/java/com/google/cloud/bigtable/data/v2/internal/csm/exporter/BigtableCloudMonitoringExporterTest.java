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
package com.google.cloud.bigtable.data.v2.internal.csm.exporter;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.google.api.Distribution;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.bigtable.v2.InstanceName;
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
import java.util.List;
import java.util.Map;
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

  private EnvInfo envInfo =
      EnvInfo.builder()
          .setProject("client-project")
          .setPlatform("gce_instance")
          .setRegion("cleint-region")
          .setHostName("harold")
          .setHostId("1234567890")
          .setUid(taskId)
          .build();
  private ClientInfo clientInfo =
      ClientInfo.builder()
          .setInstanceName(InstanceName.of(projectId, instanceId))
          .setAppProfileId(appProfileId)
          .setClientName(clientName)
          .build();

  @Before
  public void setUp() {
    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);

    exporter =
        new BigtableCloudMonitoringExporter(
            new MetricRegistry(),
            Suppliers.ofInstance(envInfo),
            clientInfo,
            fakeMetricServiceClient);

    attributes =
        Attributes.builder()
            .put(TableSchema.BIGTABLE_PROJECT_ID_KEY, projectId)
            .put(TableSchema.INSTANCE_ID_KEY, instanceId)
            .put(TableSchema.TABLE_ID_KEY, tableId)
            .put(TableSchema.CLUSTER_ID_KEY, cluster)
            .put(TableSchema.ZONE_ID_KEY, zone)
            .put(MetricLabels.APP_PROFILE_KEY, appProfileId)
            .build();

    resource = Resource.create(Attributes.empty());

    scope = InstrumentationScopeInfo.create(MetricRegistry.METER_NAME);
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
            TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
            TableSchema.INSTANCE_ID_KEY.getKey(), instanceId,
            TableSchema.TABLE_ID_KEY.getKey(), tableId,
            TableSchema.CLUSTER_ID_KEY.getKey(), cluster,
            TableSchema.ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(
            MetricLabels.APP_PROFILE_KEY.getKey(),
            appProfileId,
            MetricLabels.CLIENT_UID.getKey(),
            taskId);
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
            TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
            TableSchema.INSTANCE_ID_KEY.getKey(), instanceId,
            TableSchema.TABLE_ID_KEY.getKey(), tableId,
            TableSchema.CLUSTER_ID_KEY.getKey(), cluster,
            TableSchema.ZONE_ID_KEY.getKey(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(
            MetricLabels.APP_PROFILE_KEY.getKey(),
            appProfileId,
            MetricLabels.CLIENT_UID.getKey(),
            taskId);
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
              .put(TableSchema.BIGTABLE_PROJECT_ID_KEY, projectId)
              .put(TableSchema.INSTANCE_ID_KEY, instanceId)
              .put(TableSchema.TABLE_ID_KEY, tableId + i)
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
              TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), projectId,
              TableSchema.INSTANCE_ID_KEY.getKey(), instanceId,
              TableSchema.TABLE_ID_KEY.getKey(), tableId + i,
              TableSchema.CLUSTER_ID_KEY.getKey(), cluster,
              TableSchema.ZONE_ID_KEY.getKey(), zone);

      assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
      assertThat(timeSeries.getMetric().getLabelsMap())
          .containsAtLeast(
              MetricLabels.APP_PROFILE_KEY.getKey(),
              appProfileId,
              MetricLabels.CLIENT_UID.getKey(),
              taskId);
      assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(i);
      assertThat(timeSeries.getPoints(0).getInterval().getStartTime().getNanos())
          .isEqualTo(startEpoch);
      assertThat(timeSeries.getPoints(0).getInterval().getEndTime().getNanos()).isEqualTo(endEpoch);
    }
  }

  @Test
  public void testTimeSeriesForMetricWithGceOrGkeResource() {
    BigtableCloudMonitoringExporter exporter =
        new BigtableCloudMonitoringExporter(
            new MetricRegistry(),
            Suppliers.ofInstance(envInfo),
            clientInfo,
            fakeMetricServiceClient);
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
                ClientSchema.BIGTABLE_PROJECT_ID_KEY,
                projectId,
                ClientSchema.INSTANCE_ID_KEY,
                instanceId,
                ClientSchema.APP_PROFILE_KEY,
                appProfileId,
                ClientSchema.CLIENT_NAME,
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

    assertThat(request.getName()).isEqualTo("projects/" + projectId);
    assertThat(request.getTimeSeriesList()).hasSize(1);

    com.google.monitoring.v3.TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .isEqualTo(
            ImmutableMap.<String, String>builder()
                .put("project_id", projectId)
                .put("instance", instanceId)
                .put("app_profile", appProfileId)
                .put("client_project", "client-project")
                .put("region", "cleint-region")
                .put("cloud_platform", "gce_instance")
                .put("host_id", "1234567890")
                .put("host_name", "harold")
                .put("client_name", clientName)
                .put("uuid", taskId)
                .build());

    assertThat(timeSeries.getMetric().getLabelsMap())
        .isEqualTo(
            ImmutableMap.builder()
                .put(ClientSchema.BIGTABLE_PROJECT_ID_KEY.getKey(), projectId)
                .put(ClientSchema.INSTANCE_ID_KEY.getKey(), instanceId)
                .put(ClientSchema.APP_PROFILE_KEY.getKey(), appProfileId)
                .put(ClientSchema.CLIENT_NAME.getKey(), clientName)
                .build());
  }

  @Test
  public void testExportingToMultipleProjects() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(any())).thenReturn(future);

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

    verify(mockCallable, times(2)).futureCall(argumentCaptor.capture());

    List<CreateTimeSeriesRequest> allValues = argumentCaptor.getAllValues();

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
                projectId,
                TableSchema.INSTANCE_ID_KEY.getKey(),
                instanceId,
                TableSchema.TABLE_ID_KEY.getKey(),
                tableId,
                TableSchema.CLUSTER_ID_KEY.getKey(),
                cluster,
                TableSchema.ZONE_ID_KEY.getKey(),
                zone),
            ImmutableMap.of(
                TableSchema.BIGTABLE_PROJECT_ID_KEY.getKey(),
                "another-project",
                TableSchema.INSTANCE_ID_KEY.getKey(),
                instanceId,
                TableSchema.TABLE_ID_KEY.getKey(),
                tableId,
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
}
