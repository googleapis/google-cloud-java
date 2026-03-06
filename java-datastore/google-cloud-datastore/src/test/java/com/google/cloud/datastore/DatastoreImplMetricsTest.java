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
package com.google.cloud.datastore;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.telemetry.TelemetryConstants;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.TransactionOptions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Collection;
import java.util.Optional;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Tests for transaction metrics recording in {@link DatastoreImpl}. These tests verify that
 * transaction latency and per-attempt metrics are correctly recorded via the {@link
 * com.google.cloud.datastore.telemetry.MetricsRecorder}.
 */
@RunWith(JUnit4.class)
public class DatastoreImplMetricsTest {

  private static final String PROJECT_ID = "test-project";
  private static final String LATENCY_METRIC_NAME = "datastore.googleapis.com/transaction_latency";
  private static final String ATTEMPT_COUNT_METRIC_NAME =
      "datastore.googleapis.com/transaction_attempt_count";

  private InMemoryMetricReader metricReader;
  private DatastoreRpcFactory rpcFactoryMock;
  private DatastoreRpc rpcMock;
  private DatastoreOptions datastoreOptions;

  @Before
  public void setUp() {
    metricReader = InMemoryMetricReader.create();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    rpcMock = EasyMock.createStrictMock(DatastoreRpc.class);

    datastoreOptions =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .setServiceRpcFactory(rpcFactoryMock)
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(openTelemetry)
                    .build())
            .build();

    EasyMock.expect(rpcFactoryMock.create(datastoreOptions)).andReturn(rpcMock);
  }

  @Test
  public void runInTransaction_recordsLatencyOnSuccess() {
    // Mock a successful transaction: begin -> commit
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);

    Datastore datastore = datastoreOptions.getService();
    datastore.runInTransaction(transaction -> null);

    // Verify latency metric was recorded with status OK
    Optional<MetricData> latencyMetric = findMetric(LATENCY_METRIC_NAME);
    assertThat(latencyMetric.isPresent()).isTrue();

    HistogramPointData point =
        latencyMetric.get().getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getCount()).isEqualTo(1);
    assertThat(point.getSum()).isAtLeast(0.0);
    assertThat(point.getAttributes().get(AttributeKey.stringKey("status"))).isEqualTo("OK");
    assertThat(point.getAttributes().get(AttributeKey.stringKey("method")))
        .isEqualTo(TelemetryConstants.METHOD_TRANSACTION_RUN);
    assertThat(point.getAttributes().get(AttributeKey.stringKey("project_id")))
        .isEqualTo(PROJECT_ID);
    assertThat(point.getAttributes().get(AttributeKey.stringKey("database_id"))).isNotNull();

    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void runInTransaction_recordsPerAttemptCountOnSuccess() {
    // Mock a successful transaction: begin -> commit
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);

    Datastore datastore = datastoreOptions.getService();
    datastore.runInTransaction(transaction -> null);

    // Verify attempt count was recorded once with status OK
    Optional<MetricData> attemptMetric = findMetric(ATTEMPT_COUNT_METRIC_NAME);
    assertThat(attemptMetric.isPresent()).isTrue();

    LongPointData point =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(p -> "OK".equals(p.getAttributes().get(AttributeKey.stringKey("status"))))
            .findFirst()
            .orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getValue()).isEqualTo(1);
    assertThat(point.getAttributes().get(AttributeKey.stringKey("method")))
        .isEqualTo(TelemetryConstants.METHOD_TRANSACTION_COMMIT);

    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void runInTransaction_recordsPerAttemptOnRetry() {
    // First attempt: begin -> ABORTED -> rollback
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.rollback(EasyMock.anyObject(RollbackRequest.class)))
        .andReturn(RollbackResponse.getDefaultInstance());

    // Second attempt: begin -> commit (success)
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);

    Datastore datastore = datastoreOptions.getService();

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
            .build();

    Datastore.TransactionCallable<Integer> callable =
        new Datastore.TransactionCallable<Integer>() {
          private int attempts = 0;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            attempts++;
            if (attempts < 2) {
              throw new DatastoreException(10, "", "ABORTED", false, null);
            }
            return attempts;
          }
        };

    Integer result = datastore.runInTransaction(callable, options);
    assertThat(result).isEqualTo(2);

    // Verify attempt count has two data points: one with ABORTED and one with OK
    Optional<MetricData> attemptMetric = findMetric(ATTEMPT_COUNT_METRIC_NAME);
    assertThat(attemptMetric.isPresent()).isTrue();
    assertThat(attemptMetric.get().getLongSumData().getPoints()).hasSize(2);

    // Verify ABORTED attempt
    LongPointData abortedPoint =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(p -> "ABORTED".equals(p.getAttributes().get(AttributeKey.stringKey("status"))))
            .findFirst()
            .orElse(null);
    assertThat(abortedPoint).isNotNull();
    assertThat(abortedPoint.getValue()).isEqualTo(1);

    // Verify OK attempt
    LongPointData okPoint =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(p -> "OK".equals(p.getAttributes().get(AttributeKey.stringKey("status"))))
            .findFirst()
            .orElse(null);
    assertThat(okPoint).isNotNull();
    assertThat(okPoint.getValue()).isEqualTo(1);

    // Verify latency was recorded with OK (overall transaction succeeded)
    Optional<MetricData> latencyMetric = findMetric(LATENCY_METRIC_NAME);
    assertThat(latencyMetric.isPresent()).isTrue();
    HistogramPointData latencyPoint =
        latencyMetric.get().getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(latencyPoint).isNotNull();
    assertThat(latencyPoint.getAttributes().get(AttributeKey.stringKey("status"))).isEqualTo("OK");

    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  @Test
  public void runInTransaction_recordsGrpcStatusCodeOnFailure() {
    // This test uses a separate set of nice mocks since the retry loop makes
    // multiple begin/rollback calls whose exact count depends on retry settings.
    DatastoreRpcFactory localRpcFactoryMock = EasyMock.createNiceMock(DatastoreRpcFactory.class);
    DatastoreRpc localRpcMock = EasyMock.createNiceMock(DatastoreRpc.class);

    InMemoryMetricReader localMetricReader = InMemoryMetricReader.create();
    SdkMeterProvider localMeterProvider =
        SdkMeterProvider.builder().registerMetricReader(localMetricReader).build();
    OpenTelemetrySdk localOpenTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(localMeterProvider).build();

    DatastoreOptions localOptions =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setCredentials(NoCredentials.getInstance())
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .setServiceRpcFactory(localRpcFactoryMock)
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(localOpenTelemetry)
                    .build())
            .build();

    EasyMock.expect(localRpcFactoryMock.create(localOptions)).andReturn(localRpcMock);
    EasyMock.expect(
            localRpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance())
        .anyTimes();
    EasyMock.expect(localRpcMock.rollback(EasyMock.anyObject(RollbackRequest.class)))
        .andReturn(RollbackResponse.getDefaultInstance())
        .anyTimes();
    EasyMock.replay(localRpcFactoryMock, localRpcMock);

    Datastore datastore = localOptions.getService();

    Datastore.TransactionCallable<Void> callable =
        transaction -> {
          throw new DatastoreException(10, "ABORTED", "ABORTED", false, null);
        };

    assertThrows(DatastoreException.class, () -> datastore.runInTransaction(callable));

    // Verify that attempt count was recorded with ABORTED status
    Optional<MetricData> attemptMetric =
        localMetricReader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(ATTEMPT_COUNT_METRIC_NAME))
            .findFirst();
    assertThat(attemptMetric.isPresent()).isTrue();

    LongPointData abortedPoint =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(p -> "ABORTED".equals(p.getAttributes().get(AttributeKey.stringKey("status"))))
            .findFirst()
            .orElse(null);
    assertThat(abortedPoint).isNotNull();
    assertThat(abortedPoint.getValue()).isAtLeast(1);

    // Verify that latency was recorded with the failure status code
    Optional<MetricData> latencyMetric =
        localMetricReader.collectAllMetrics().stream()
            .filter(m -> m.getName().equals(LATENCY_METRIC_NAME))
            .findFirst();
    assertThat(latencyMetric.isPresent()).isTrue();
    HistogramPointData latencyPoint =
        latencyMetric.get().getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(latencyPoint).isNotNull();
    assertThat(latencyPoint.getAttributes().get(AttributeKey.stringKey("status")))
        .isEqualTo("ABORTED");
  }

  @Test
  public void runInTransaction_withTransactionOptions_recordsMetrics() {
    // Verify metrics are recorded when calling the overload with TransactionOptions
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcFactoryMock, rpcMock);

    Datastore datastore = datastoreOptions.getService();

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
            .build();
    datastore.runInTransaction(transaction -> null, options);

    // Verify both metrics were recorded
    assertThat(findMetric(LATENCY_METRIC_NAME).isPresent()).isTrue();
    assertThat(findMetric(ATTEMPT_COUNT_METRIC_NAME).isPresent()).isTrue();

    EasyMock.verify(rpcFactoryMock, rpcMock);
  }

  /**
   * Finds a specific metric by name from the in-memory metric reader.
   *
   * @param metricName The fully qualified name of the metric to find.
   * @return An {@link Optional} containing the {@link MetricData} if found.
   */
  private Optional<MetricData> findMetric(String metricName) {
    Collection<MetricData> metrics = metricReader.collectAllMetrics();
    return metrics.stream().filter(m -> m.getName().equals(metricName)).findFirst();
  }
}
