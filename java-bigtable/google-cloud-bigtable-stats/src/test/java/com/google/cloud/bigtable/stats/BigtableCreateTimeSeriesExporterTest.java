/*
 * Copyright 2021 Google LLC
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
package com.google.cloud.bigtable.stats;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.api.MonitoredResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.monitoring.v3.MetricServiceClient;
import com.google.cloud.monitoring.v3.stub.MetricServiceStub;
import com.google.monitoring.v3.CreateTimeSeriesRequest;
import com.google.protobuf.Empty;
import io.opencensus.common.Timestamp;
import io.opencensus.metrics.LabelKey;
import io.opencensus.metrics.LabelValue;
import io.opencensus.metrics.export.Metric;
import io.opencensus.metrics.export.MetricDescriptor;
import io.opencensus.metrics.export.Point;
import io.opencensus.metrics.export.TimeSeries;
import io.opencensus.metrics.export.Value;
import java.util.Arrays;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

@RunWith(JUnit4.class)
public class BigtableCreateTimeSeriesExporterTest {

  private static final String projectId = "fake-project";
  private static final String instanceId = "fake-instance";
  private static final String appProfileId = "default";
  private static final String tableId = "fake-table";
  private static final String zone = "us-east-1";
  private static final String cluster = "cluster-1";

  @Rule public final MockitoRule mockitoRule = MockitoJUnit.rule();

  @Mock private MetricServiceStub mockMetricServiceStub;
  private MetricServiceClient fakeMetricServiceClient;
  private BigtableCreateTimeSeriesExporter exporter;

  @Before
  public void setUp() {

    fakeMetricServiceClient = new FakeMetricServiceClient(mockMetricServiceStub);

    exporter =
        new BigtableCreateTimeSeriesExporter(
            fakeMetricServiceClient,
            MonitoredResource.newBuilder().setType("bigtable-table").build());
  }

  @After
  public void tearDown() {}

  @Test
  public void testTimeSeries() {
    ArgumentCaptor<CreateTimeSeriesRequest> argumentCaptor =
        ArgumentCaptor.forClass(CreateTimeSeriesRequest.class);

    UnaryCallable<CreateTimeSeriesRequest, Empty> mockCallable = mock(UnaryCallable.class);
    when(mockMetricServiceStub.createServiceTimeSeriesCallable()).thenReturn(mockCallable);
    when(mockCallable.call(argumentCaptor.capture())).thenReturn(Empty.getDefaultInstance());

    double fakeValue = 10.0;
    Metric fakeMetric =
        Metric.create(
            MetricDescriptor.create(
                "bigtable/test",
                "descritpion",
                "ms",
                MetricDescriptor.Type.CUMULATIVE_DOUBLE,
                Arrays.asList(
                    LabelKey.create(BuiltinMeasureConstants.PROJECT_ID.getName(), ""),
                    LabelKey.create(BuiltinMeasureConstants.INSTANCE_ID.getName(), ""),
                    LabelKey.create(BuiltinMeasureConstants.TABLE.getName(), ""),
                    LabelKey.create(BuiltinMeasureConstants.CLUSTER.getName(), ""),
                    LabelKey.create(BuiltinMeasureConstants.ZONE.getName(), ""),
                    LabelKey.create(BuiltinMeasureConstants.APP_PROFILE.getName(), ""))),
            Arrays.asList(
                TimeSeries.create(
                    Arrays.asList(
                        LabelValue.create(projectId),
                        LabelValue.create(instanceId),
                        LabelValue.create(tableId),
                        LabelValue.create(cluster),
                        LabelValue.create(zone),
                        LabelValue.create(appProfileId)),
                    Arrays.asList(
                        Point.create(
                            Value.doubleValue(fakeValue),
                            Timestamp.fromMillis(System.currentTimeMillis()))),
                    Timestamp.fromMillis(System.currentTimeMillis()))));

    exporter.export(Arrays.asList(fakeMetric));

    CreateTimeSeriesRequest request = argumentCaptor.getValue();

    assertThat(request.getTimeSeriesList()).hasSize(1);

    com.google.monitoring.v3.TimeSeries timeSeries = request.getTimeSeriesList().get(0);

    assertThat(timeSeries.getResource().getLabelsMap())
        .containsExactly(
            BuiltinMeasureConstants.PROJECT_ID.getName(), projectId,
            BuiltinMeasureConstants.INSTANCE_ID.getName(), instanceId,
            BuiltinMeasureConstants.TABLE.getName(), tableId,
            BuiltinMeasureConstants.CLUSTER.getName(), cluster,
            BuiltinMeasureConstants.ZONE.getName(), zone);

    assertThat(timeSeries.getMetric().getLabelsMap()).hasSize(2);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsAtLeast(BuiltinMeasureConstants.APP_PROFILE.getName(), appProfileId);
    assertThat(timeSeries.getMetric().getLabelsMap())
        .containsKey(BuiltinMeasureConstants.CLIENT_UID.getName());

    assertThat(timeSeries.getPoints(0).getValue().getDoubleValue()).isEqualTo(fakeValue);
  }

  private class FakeMetricServiceClient extends MetricServiceClient {

    protected FakeMetricServiceClient(MetricServiceStub stub) {
      super(stub);
    }
  }
}
