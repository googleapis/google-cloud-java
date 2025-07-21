/*
 * Copyright 2024 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

import com.google.api.gax.core.FixedExecutorProvider;
import com.google.api.gax.grpc.ChannelPoolSettings;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.bigtable.v2.*;
import com.google.cloud.bigtable.Version;
import com.google.cloud.bigtable.data.v2.BigtableDataSettings;
import com.google.cloud.bigtable.data.v2.FakeServiceBuilder;
import com.google.cloud.bigtable.data.v2.models.*;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStub;
import com.google.cloud.bigtable.data.v2.stub.EnhancedBigtableStubSettings;
import com.google.common.collect.Lists;
import io.grpc.Server;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.SdkMeterProviderBuilder;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;

@RunWith(JUnit4.class)
public class ErrorCountPerConnectionTest {
  private static final String SUCCESS_TABLE_NAME = "some-table";
  private static final String ERROR_TABLE_NAME = "nonexistent-table";
  private Server server;
  private final FakeService fakeService = new FakeService();
  private EnhancedBigtableStubSettings.Builder builder;
  private ArgumentCaptor<Runnable> runnableCaptor;

  private InMemoryMetricReader metricReader;

  private Attributes attributes;

  @Before
  public void setup() throws Exception {
    server = FakeServiceBuilder.create(fakeService).start();

    ScheduledExecutorService executors = Mockito.mock(ScheduledExecutorService.class);

    attributes =
        Attributes.builder()
            .put(BuiltinMetricsConstants.BIGTABLE_PROJECT_ID_KEY, "fake-project")
            .put(BuiltinMetricsConstants.INSTANCE_ID_KEY, "fake-instance")
            .put(BuiltinMetricsConstants.APP_PROFILE_KEY, "")
            .put(BuiltinMetricsConstants.CLIENT_NAME_KEY, "bigtable-java/" + Version.VERSION)
            .build();

    metricReader = InMemoryMetricReader.create();

    SdkMeterProviderBuilder meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader);

    for (Map.Entry<InstrumentSelector, View> e :
        BuiltinMetricsConstants.getInternalViews().entrySet()) {
      meterProvider.registerView(e.getKey(), e.getValue());
    }

    OpenTelemetrySdk otel =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider.build()).build();

    builder =
        BigtableDataSettings.newBuilderForEmulator(server.getPort())
            .stubSettings()
            .setBackgroundExecutorProvider(FixedExecutorProvider.create(executors))
            .setProjectId("fake-project")
            .setInstanceId("fake-instance")
            .setMetricsProvider(NoopMetricsProvider.INSTANCE)
            .setInternalMetricsProvider((ignored1, ignored2) -> otel);

    runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
    when(executors.scheduleAtFixedRate(runnableCaptor.capture(), anyLong(), anyLong(), any()))
        .then((Answer<ScheduledFuture<?>>) invocation -> Mockito.mock(ScheduledFuture.class));
  }

  @After
  public void tearDown() throws Exception {
    if (server != null) {
      server.shutdown();
    }
  }

  @Test
  public void readWithOneChannel() throws Exception {
    long errorCount = 0;

    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build())) {
      for (int i = 0; i < 20; i++) {
        Query query;
        if (i % 3 == 0) {
          query = Query.create(ERROR_TABLE_NAME);
          errorCount += 1;
        } else {
          query = Query.create(SUCCESS_TABLE_NAME);
        }
        try {
          @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
          ArrayList<Row> ignored = Lists.newArrayList(stub.readRowsCallable().call(query));
        } catch (Exception e) {
          // noop
        }
      }
    }

    runInterceptorTasksAndAssertCount();

    MetricData metricData =
        BuiltinMetricsTestUtils.getMetricData(
            metricReader, BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME);

    // Make sure the correct bucket is updated with the correct number of data points
    ArrayList<HistogramPointData> histogramPointData =
        new ArrayList<>(metricData.getHistogramData().getPoints());
    assertThat(histogramPointData.size()).isEqualTo(1);
    HistogramPointData point = histogramPointData.get(0);
    int index = findDataPointIndex(point.getBoundaries(), errorCount);
    assertThat(point.getCounts().get(index)).isEqualTo(1);
  }

  @Test
  public void readWithTwoChannels() throws Exception {
    EnhancedBigtableStubSettings.Builder builderWithTwoChannels =
        builder.setTransportChannelProvider(
            ((InstantiatingGrpcChannelProvider) builder.getTransportChannelProvider())
                .toBuilder()
                    .setChannelPoolSettings(ChannelPoolSettings.staticallySized(2))
                    .build());
    long totalErrorCount = 0;
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(builderWithTwoChannels.build())) {
      for (int i = 0; i < 20; i++) {
        try {
          if (i < 10) {
            totalErrorCount += 1;
            @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
            ArrayList<Row> ignored =
                Lists.newArrayList(stub.readRowsCallable().call(Query.create(ERROR_TABLE_NAME)));
          } else {
            ArrayList<Row> ignored =
                Lists.newArrayList(stub.readRowsCallable().call(Query.create(SUCCESS_TABLE_NAME)));
          }
        } catch (Exception e) {
          // noop
        }
      }
    }
    runInterceptorTasksAndAssertCount();

    long errorCountPerChannel = totalErrorCount / 2;

    MetricData metricData =
        BuiltinMetricsTestUtils.getMetricData(
            metricReader, BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME);

    // The 2 channels should get equal amount of errors, so the totalErrorCount / 2 bucket is
    // updated twice.
    ArrayList<HistogramPointData> histogramPointData =
        new ArrayList<>(metricData.getHistogramData().getPoints());
    assertThat(histogramPointData.size()).isEqualTo(1);
    HistogramPointData point = histogramPointData.get(0);
    int index = findDataPointIndex(point.getBoundaries(), errorCountPerChannel);
    assertThat(point.getCounts().get(index)).isEqualTo(2);
  }

  @Test
  public void readOverTwoPeriods() throws Exception {
    long errorCount1 = 0;
    long errorCount2 = 0;
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build())) {

      for (int i = 0; i < 20; i++) {
        Query query;
        if (i % 3 == 0) {
          query = Query.create(ERROR_TABLE_NAME);
          errorCount1 += 1;
        } else {
          query = Query.create(SUCCESS_TABLE_NAME);
        }
        try {
          @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
          ArrayList<Row> ignored = Lists.newArrayList(stub.readRowsCallable().call(query));
        } catch (Exception e) {
          // noop
        }
      }

      runInterceptorTasksAndAssertCount();

      for (int i = 0; i < 20; i++) {
        Query query;
        if (i % 3 == 0) {
          query = Query.create(SUCCESS_TABLE_NAME);
        } else {
          query = Query.create(ERROR_TABLE_NAME);
          errorCount2 += 1;
        }
        try {
          @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
          ArrayList<Row> ignored = Lists.newArrayList(stub.readRowsCallable().call(query));
        } catch (Exception e) {
          // noop
        }
      }
    }

    runInterceptorTasksAndAssertCount();

    MetricData metricData =
        BuiltinMetricsTestUtils.getMetricData(
            metricReader, BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME);

    ArrayList<HistogramPointData> histogramPointData =
        new ArrayList<>(metricData.getHistogramData().getPoints());
    assertThat(histogramPointData.size()).isEqualTo(1);
    HistogramPointData point = histogramPointData.get(0);
    int index1 = findDataPointIndex(point.getBoundaries(), errorCount1);
    int index2 = findDataPointIndex(point.getBoundaries(), errorCount2);
    assertThat(point.getCounts().get(index1)).isEqualTo(1);
    assertThat(point.getCounts().get(index2)).isEqualTo(1);
  }

  @Test
  public void noFailedRequests() throws Exception {
    try (EnhancedBigtableStub stub = EnhancedBigtableStub.create(builder.build())) {
      for (int i = 0; i < 20; i++) {
        try {
          @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
          ArrayList<Row> ignored =
              Lists.newArrayList(stub.readRowsCallable().call(Query.create(SUCCESS_TABLE_NAME)));
        } catch (Exception e) {
          // noop
        }
      }
    }

    runInterceptorTasksAndAssertCount();
    MetricData metricData =
        BuiltinMetricsTestUtils.getMetricData(
            metricReader, BuiltinMetricsConstants.PER_CONNECTION_ERROR_COUNT_NAME);
    long value = BuiltinMetricsTestUtils.getAggregatedValue(metricData, attributes);
    assertThat(value).isEqualTo(0);
  }

  private void runInterceptorTasksAndAssertCount() {
    int actualNumOfTasks = 0;
    for (Runnable runnable : runnableCaptor.getAllValues()) {
      if (runnable instanceof ErrorCountPerConnectionMetricTracker) {
        runnable.run();
        actualNumOfTasks++;
      }
    }
    assertThat(actualNumOfTasks).isEqualTo(1);
  }

  private int findDataPointIndex(List<Double> boundaries, long dataPoint) {
    int index = 0;
    for (; index < boundaries.size(); index++) {
      if (boundaries.get(index) >= dataPoint) {
        break;
      }
    }
    return index;
  }

  static class FakeService extends BigtableGrpc.BigtableImplBase {
    @Override
    public void readRows(
        ReadRowsRequest request, StreamObserver<ReadRowsResponse> responseObserver) {
      if (request.getTableName().contains(SUCCESS_TABLE_NAME)) {
        responseObserver.onNext(ReadRowsResponse.getDefaultInstance());
        responseObserver.onCompleted();
      } else {
        // Send a non-retriable error, since otherwise the client tries to use the mocked
        // ScheduledExecutorService object for retyring, resulting in a hang.
        StatusRuntimeException exception = new StatusRuntimeException(Status.INTERNAL);
        responseObserver.onError(exception);
      }
    }
  }
}
