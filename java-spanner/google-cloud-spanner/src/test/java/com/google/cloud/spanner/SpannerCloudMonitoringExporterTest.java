/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_HASH_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_NAME_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.CLIENT_UID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.DATABASE_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.DIRECT_PATH_ENABLED_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.DIRECT_PATH_USED_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.GAX_METER_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.INSTANCE_CONFIG_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.INSTANCE_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.LOCATION_ID_KEY;
import static com.google.cloud.spanner.BuiltInMetricsConstant.OPERATION_COUNT_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.OPERATION_LATENCIES_NAME;
import static com.google.cloud.spanner.BuiltInMetricsConstant.PROJECT_ID_KEY;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.Distribution;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.MetricServiceSettings;
import com.google.cloud.monitoring.v3.stub.MetricServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.DroppedLabels;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import com.google.protobuf.InvalidProtocolBufferException;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.TraceFlags;
import io.opentelemetry.api.trace.TraceState;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.DoubleExemplarData;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableDoubleExemplarData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableHistogramPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.resources.Resource;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

public class SpannerCloudMonitoringExporterTest {

  private static final String projectId = "fake-project";
  private static final String instanceId = "fake-instance";
  private static final String locationId = "global";
  private static final String databaseId = "fake-database";
  private static final String clientName = "spanner-java/";

  private static final String clientHash = "spanner-test";
  private static final String instanceConfigId = "fake-instance-config-id";

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock private MetricServiceStub mockMetricServiceStub;
  private MetricServiceClient fakeMetricServiceClient;
  private SpannerCloudMonitoringExporter exporter;

  private Attributes attributes;

  private Attributes resourceAttributes;
  private Resource resource;
  private InstrumentationScopeInfo scope;

  private String client_uid;

  @Before
  public void setUp() {
    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);
    exporter = new SpannerCloudMonitoringExporter(projectId, fakeMetricServiceClient);

    this.client_uid = BuiltInMetricsProvider.INSTANCE.createClientAttributes().get("client_uid");

    attributes =
        Attributes.builder()
            .put(INSTANCE_ID_KEY, instanceId)
            .put(DATABASE_KEY, databaseId)
            .put(CLIENT_NAME_KEY, clientName)
            .put(CLIENT_UID_KEY, this.client_uid)
            .put(String.valueOf(DIRECT_PATH_ENABLED_KEY), true)
            .put(String.valueOf(DIRECT_PATH_USED_KEY), true)
            .build();

    resourceAttributes =
        Attributes.builder()
            .put(PROJECT_ID_KEY, projectId)
            .put(LOCATION_ID_KEY, locationId)
            .put(CLIENT_HASH_KEY, clientHash)
            .put(INSTANCE_CONFIG_ID_KEY, instanceConfigId)
            .build();
    resource = Resource.create(resourceAttributes);

    scope = InstrumentationScopeInfo.create(GAX_METER_NAME);
  }

  @After
  public void tearDown() {}

  @Test
  public void testExportingSumData() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = Mockito.mock(UnaryCallable.class);
    Mockito.when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    Mockito.when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

    long fakeValue = 11L;

    long startEpoch = 10;
    long endEpoch = 15;
    LongPointData longPointData =
        ImmutableLongPointData.create(startEpoch, endEpoch, attributes, fakeValue);

    MetricData longData =
        ImmutableMetricData.createLongSum(
            resource,
            scope,
            "spanner.googleapis.com/internal/client/" + OPERATION_COUNT_NAME,
            "description",
            "1",
            ImmutableSumData.create(
                true, AggregationTemporality.CUMULATIVE, ImmutableList.of(longPointData)));

    exporter.export(Collections.singletonList(longData));
    assertFalse(exporter.lastExportSkippedData());

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            PROJECT_ID_KEY.getKey(), projectId,
            INSTANCE_ID_KEY.getKey(), instanceId,
            LOCATION_ID_KEY.getKey(), locationId,
            INSTANCE_CONFIG_ID_KEY.getKey(), instanceConfigId,
            CLIENT_HASH_KEY.getKey(), clientHash);

    assertThat(timeSeries.getResource().getLabelsMap()).hasSize(5);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            DATABASE_KEY.getKey(),
            databaseId,
            CLIENT_NAME_KEY.getKey(),
            clientName,
            DIRECT_PATH_ENABLED_KEY.getKey(),
            "true",
            DIRECT_PATH_USED_KEY.getKey(),
            "true",
            CLIENT_UID_KEY.getKey(),
            this.client_uid);
    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(5);

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
            Collections.singletonList(1.0),
            Arrays.asList(1L, 2L));

    MetricData histogramData =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "spanner.googleapis.com/internal/client/" + OPERATION_LATENCIES_NAME,
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData)));

    exporter.export(Collections.singletonList(histogramData));
    assertFalse(exporter.lastExportSkippedData());

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap()).hasSize(5);
    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            PROJECT_ID_KEY.getKey(), projectId,
            INSTANCE_ID_KEY.getKey(), instanceId,
            LOCATION_ID_KEY.getKey(), locationId,
            INSTANCE_CONFIG_ID_KEY.getKey(), instanceConfigId,
            CLIENT_HASH_KEY.getKey(), clientHash);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(5);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            DATABASE_KEY.getKey(),
            databaseId,
            CLIENT_NAME_KEY.getKey(),
            clientName,
            DIRECT_PATH_ENABLED_KEY.getKey(),
            "true",
            DIRECT_PATH_USED_KEY.getKey(),
            "true",
            CLIENT_UID_KEY.getKey(),
            this.client_uid);

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
      LongPointData longPointData =
          ImmutableLongPointData.create(startEpoch, endEpoch, attributes, i);

      MetricData longData =
          ImmutableMetricData.createLongSum(
              resource,
              scope,
              "spanner.googleapis.com/internal/client/" + OPERATION_COUNT_NAME,
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
    assertFalse(exporter.lastExportSkippedData());

    for (int i = 0; i < 250; i++) {
      TimeSeries timeSeries;
      if (i < 200) {
        timeSeries = firstRequest.getTimeSeriesList().get(i);
      } else {
        timeSeries = secondRequest.getTimeSeriesList().get(i - 200);
      }

      assertThat(timeSeries.getResource().getLabelsMap()).hasSize(5);
      assertThat(timeSeries.getResource().getLabelsMap())
          .containsExactly(
              PROJECT_ID_KEY.getKey(), projectId,
              INSTANCE_ID_KEY.getKey(), instanceId,
              LOCATION_ID_KEY.getKey(), locationId,
              INSTANCE_CONFIG_ID_KEY.getKey(), instanceConfigId,
              CLIENT_HASH_KEY.getKey(), clientHash);

      assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(5);
      assertThat(timeSeries.getMetric().getLabelsMap())
          .containsExactly(
              DATABASE_KEY.getKey(),
              databaseId,
              CLIENT_NAME_KEY.getKey(),
              clientName,
              DIRECT_PATH_ENABLED_KEY.getKey(),
              "true",
              DIRECT_PATH_USED_KEY.getKey(),
              "true",
              CLIENT_UID_KEY.getKey(),
              this.client_uid);

      assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(i);
      assertThat(timeSeries.getPoints(0).getInterval().getStartTime().getNanos())
          .isEqualTo(startEpoch);
      assertThat(timeSeries.getPoints(0).getInterval().getEndTime().getNanos()).isEqualTo(endEpoch);
    }
  }

  @Test
  public void testExportingHistogramDataWithExemplars() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    when(mockCallable.futureCall(argumentCaptor.capture())).thenReturn(future);

    long startEpoch = 10 * 1_000_000_000L;
    long endEpoch = 15 * 1_000_000_000L;
    long recordTimeEpoch = 12_123_456_789L;

    DoubleExemplarData exemplar =
        ImmutableDoubleExemplarData.create(
            Attributes.builder()
                .put(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME, "test")
                .put("lang", "java")
                .build(),
            recordTimeEpoch,
            SpanContext.create(
                "0123456789abcdef0123456789abcdef",
                "0123456789abcdef",
                TraceFlags.getSampled(),
                TraceState.getDefault()),
            1.5);

    HistogramPointData histogramPointData =
        ImmutableHistogramPointData.create(
            startEpoch,
            endEpoch,
            attributes,
            3d,
            true,
            1d,
            true,
            2d,
            Collections.singletonList(1.0),
            Arrays.asList(1L, 2L),
            Collections.singletonList(exemplar) // ← add exemplar
            );

    MetricData histogramData =
        ImmutableMetricData.createDoubleHistogram(
            resource,
            scope,
            "spanner.googleapis.com/internal/client/" + OPERATION_LATENCIES_NAME,
            "description",
            "ms",
            ImmutableHistogramData.create(
                AggregationTemporality.CUMULATIVE, ImmutableList.of(histogramPointData)));

    exporter.export(Collections.singletonList(histogramData));
    assertFalse(exporter.lastExportSkippedData());

    CreateTimeSeriesRequest request = argumentCaptor.getValue();
    TimeSeries timeSeries = request.getTimeSeriesList().get(0);
    Distribution distribution = timeSeries.getPoints(0).getValue().getDistributionValue();

    // Assert exemplar exists and has expected value
    assertThat(distribution.getExemplarsCount()).isEqualTo(1);
    Distribution.Exemplar exportedExemplar = distribution.getExemplars(0);
    assertThat(exportedExemplar.getValue()).isEqualTo(1.5);

    // Assert timestamp mapping
    assertThat(exportedExemplar.getTimestamp().getSeconds())
        .isEqualTo(recordTimeEpoch / 1_000_000_000L);
    assertThat(exportedExemplar.getTimestamp().getNanos())
        .isEqualTo((int) (recordTimeEpoch % 1_000_000_000L));

    // Assert attachments: SpanContext
    boolean hasSpanAttachment =
        exportedExemplar.getAttachmentsList().stream()
            .anyMatch(any -> any.is(com.google.monitoring.v3.SpanContext.class));
    assertThat(hasSpanAttachment).isTrue();

    // Assert attachments: DroppedLabels (filtered attributes)
    List<DroppedLabels> filterAttributes =
        exportedExemplar.getAttachmentsList().stream()
            .filter(any -> any.is(DroppedLabels.class))
            .map(
                any -> {
                  try {
                    return any.unpack(DroppedLabels.class);
                  } catch (InvalidProtocolBufferException e) {
                    throw new RuntimeException("Failed to unpack SpanContext", e);
                  }
                })
            .collect(Collectors.toList());

    // Assert only 1 attachment is there with 1 label for request_id.
    assertThat(filterAttributes.size()).isEqualTo(1);
    assertThat(filterAttributes.get(0).getLabelCount()).isEqualTo(1);
    assertThat(filterAttributes.get(0).containsLabel(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME))
        .isTrue();
    assertThat(
            filterAttributes.get(0).getLabelOrThrow(XGoogSpannerRequestId.REQUEST_ID_HEADER_NAME))
        .isEqualTo("test");
  }

  @Test
  public void getAggregationTemporality() throws IOException {
    SpannerCloudMonitoringExporter actualExporter =
        SpannerCloudMonitoringExporter.create(projectId, null, null, null);
    assertThat(actualExporter.getAggregationTemporality(InstrumentType.COUNTER))
        .isEqualTo(AggregationTemporality.CUMULATIVE);
  }

  @Test
  public void testUniverseDomain() throws IOException {
    SpannerCloudMonitoringExporter actualExporter =
        SpannerCloudMonitoringExporter.create(projectId, null, null, "abc.goog");
    MetricServiceSettings metricServiceSettings =
        actualExporter.getMetricServiceClient().getSettings();

    assertEquals("abc.goog", metricServiceSettings.getUniverseDomain());
    assertEquals("monitoring.abc.goog:443", metricServiceSettings.getEndpoint());

    actualExporter =
        SpannerCloudMonitoringExporter.create(
            projectId, null, "monitoringa.abc.goog:443", "abc.goog");
    metricServiceSettings = actualExporter.getMetricServiceClient().getSettings();

    assertEquals("abc.goog", metricServiceSettings.getUniverseDomain());
    assertEquals("monitoringa.abc.goog:443", metricServiceSettings.getEndpoint());
  }

  private static class FakeMetricServiceClient extends MetricServiceClient {

    protected FakeMetricServiceClient(MetricServiceStub stub) {
      super(stub);
    }
  }
}
