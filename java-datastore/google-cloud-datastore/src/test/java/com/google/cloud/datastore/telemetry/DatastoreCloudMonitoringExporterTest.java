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

package com.google.cloud.datastore.telemetry;

import static com.google.cloud.datastore.telemetry.TelemetryConstants.CLIENT_UID_KEY;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.DATABASE_ID_KEY;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.LOCATION_ID_KEY;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.METRIC_NAME_SHORT_OPERATION_COUNT;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.METRIC_PREFIX;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.PROJECT_ID_KEY;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.RESOURCE_LABEL_PROJECT_ID;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.SERVICE_KEY;
import static com.google.cloud.datastore.telemetry.TelemetryConstants.SERVICE_VALUE;
import static com.google.common.truth.Truth.assertThat;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.stub.MetricServiceStub;
import com.google.common.collect.ImmutableList;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.monitoring.v3.TimeSeries;
import com.google.protobuf.Empty;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.common.InstrumentationScopeInfo;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableLongPointData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableMetricData;
import io.opentelemetry.sdk.metrics.internal.data.ImmutableSumData;
import io.opentelemetry.sdk.resources.Resource;
import java.util.Collections;
import java.util.Map;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;

public class DatastoreCloudMonitoringExporterTest {

  private static final String PROJECT_ID = "test-project";
  private static final String LOCATION_ID = "global";
  private static final String DATABASE_ID = "test-db";

  private MetricServiceStub mockMetricServiceStub;
  private MetricServiceClient fakeMetricServiceClient;
  private DatastoreCloudMonitoringExporter exporter;

  private Attributes attributes;
  private Attributes resourceAttributes;
  private Resource resource;
  private InstrumentationScopeInfo scope;
  private String clientUid;

  @Before
  public void setUp() {
    mockMetricServiceStub = createMock(MetricServiceStub.class);
    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);

    Map<String, String> clientAttributes = BuiltInDatastoreMetricsProvider.buildClientAttributes();
    this.clientUid = clientAttributes.get(CLIENT_UID_KEY.getKey());

    exporter =
        new DatastoreCloudMonitoringExporter(
            PROJECT_ID + ":" + DATABASE_ID + ":0",
            PROJECT_ID,
            fakeMetricServiceClient,
            clientAttributes);

    attributes =
        Attributes.builder()
            .put(DATABASE_ID_KEY, DATABASE_ID)
            .put(CLIENT_UID_KEY, this.clientUid)
            .build();

    resourceAttributes =
        Attributes.builder()
            .put(PROJECT_ID_KEY, PROJECT_ID)
            .put(DATABASE_ID_KEY, DATABASE_ID)
            .put(LOCATION_ID_KEY, LOCATION_ID)
            .build();
    resource = Resource.create(resourceAttributes);

    scope = InstrumentationScopeInfo.create(OpenTelemetryMetricsRecorder.GAX_METER_NAME);
  }

  @Test
  public void testExportingSumData() {
    Capture<CreateTimeSeriesRequest> capture = EasyMock.newCapture();

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = createMock(UnaryCallable.class);
    expect(mockMetricServiceStub.isShutdown()).andReturn(false).anyTimes();
    expect(mockMetricServiceStub.createTimeSeriesCallable()).andReturn(mockCallable);
    ApiFuture<Empty> future = ApiFutures.immediateFuture(Empty.getDefaultInstance());
    expect(mockCallable.futureCall(EasyMock.capture(capture))).andReturn(future);

    replay(mockMetricServiceStub, mockCallable);

    long fakeValue = 11L;
    long startEpoch = 10;
    long endEpoch = 15;
    LongPointData longPointData =
        ImmutableLongPointData.create(startEpoch, endEpoch, attributes, fakeValue);

    MetricData longData =
        ImmutableMetricData.createLongSum(
            resource,
            scope,
            METRIC_PREFIX + "/" + METRIC_NAME_SHORT_OPERATION_COUNT,
            "description",
            "1",
            ImmutableSumData.create(
                true, AggregationTemporality.CUMULATIVE, ImmutableList.of(longPointData)));

    exporter.export(Collections.singletonList(longData));

    CreateTimeSeriesRequest request = capture.getValue();
    assertThat(request.getTimeSeriesList()).hasSize(1);

    TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(RESOURCE_LABEL_PROJECT_ID, PROJECT_ID);

    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsExactly(
            DATABASE_ID_KEY.getKey(),
            DATABASE_ID,
            CLIENT_UID_KEY.getKey(),
            this.clientUid,
            SERVICE_KEY.getKey(),
            SERVICE_VALUE);

    assertThat(timeSeries.getPoints(0).getValue().getInt64Value()).isEqualTo(fakeValue);

    verify(mockMetricServiceStub, mockCallable);
  }

  @Test
  public void testClientCacheReferenceCounting() {
    MetricServiceClient mockClient = createMock(MetricServiceClient.class);
    expect(mockClient.isShutdown()).andReturn(false).anyTimes();
    mockClient.shutdown();
    EasyMock.expectLastCall(); // Expect shutdown when refCount reaches 0
    replay(mockClient);

    String key = PROJECT_ID + ":" + DATABASE_ID + ":0";
    DatastoreCloudMonitoringExporter.CachedMetricsClient cachedMetricsClient =
        new DatastoreCloudMonitoringExporter.CachedMetricsClient(mockClient);
    cachedMetricsClient.refCount.set(2); // Simulate 2 references
    DatastoreCloudMonitoringExporter.METRICS_CLIENT_CACHE.put(key, cachedMetricsClient);

    DatastoreCloudMonitoringExporter exporter1 =
        new DatastoreCloudMonitoringExporter(key, PROJECT_ID, mockClient, Collections.emptyMap());

    // First shutdown should decrement refCount to 1, but not close client
    exporter1.shutdown();
    assertThat(cachedMetricsClient.refCount.get()).isEqualTo(1);
    assertThat(DatastoreCloudMonitoringExporter.METRICS_CLIENT_CACHE.containsKey(key)).isTrue();

    DatastoreCloudMonitoringExporter exporter2 =
        new DatastoreCloudMonitoringExporter(key, PROJECT_ID, mockClient, Collections.emptyMap());

    // Second shutdown should decrement refCount to 0, close client, and remove from cache
    exporter2.shutdown();
    assertThat(cachedMetricsClient.refCount.get()).isEqualTo(0);
    assertThat(DatastoreCloudMonitoringExporter.METRICS_CLIENT_CACHE.containsKey(key)).isFalse();

    verify(mockClient);
  }

  private static class FakeMetricServiceClient extends MetricServiceClient {
    protected FakeMetricServiceClient(MetricServiceStub stub) {
      super(stub);
    }
  }
}
