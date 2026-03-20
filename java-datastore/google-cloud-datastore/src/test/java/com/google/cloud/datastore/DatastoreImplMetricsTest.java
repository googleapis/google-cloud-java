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

import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.datastore.spi.DatastoreRpcFactory;
import com.google.cloud.datastore.spi.v1.DatastoreRpc;
import com.google.cloud.datastore.telemetry.TelemetryConstants;
import com.google.datastore.v1.BeginTransactionRequest;
import com.google.datastore.v1.BeginTransactionResponse;
import com.google.datastore.v1.CommitRequest;
import com.google.datastore.v1.CommitResponse;
import com.google.datastore.v1.LookupRequest;
import com.google.datastore.v1.LookupResponse;
import com.google.datastore.v1.RollbackRequest;
import com.google.datastore.v1.RollbackResponse;
import com.google.datastore.v1.TransactionOptions;
import io.opentelemetry.api.common.AttributeKey;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.HistogramPointData;
import io.opentelemetry.sdk.metrics.data.LongPointData;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.data.PointData;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.easymock.EasyMock;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 * Tests for transaction metrics recording in {@link DatastoreImpl}. These tests verify that
 * transaction latency and per-attempt metrics are correctly recorded via the {@link
 * com.google.cloud.datastore.telemetry.MetricsRecorder}.
 */
@RunWith(Parameterized.class)
public class DatastoreImplMetricsTest {

  private static final String PROJECT_ID = "test-project";
  private static final String DATABASE_ID = "test-database";

  private InMemoryMetricReader metricReader;
  private DatastoreRpc rpcMock;
  private Datastore datastore;
  private final TelemetryConstants.Transport transport;

  /**
   * We parameterize this test to run against both GRPC and HTTP transports. This ensures that
   * Datastore-specific transaction and commit metrics are correctly recorded for both transports,
   * while verifying that operation and attempt metrics are only manually recorded for HTTP (since
   * GAX handles them natively for gRPC). Parameterizing allows us to automatically test both
   * transports for any new metrics added.
   */
  @Parameters(name = "transport={0}")
  public static List<TelemetryConstants.Transport> data() {
    return Arrays.asList(TelemetryConstants.Transport.GRPC, TelemetryConstants.Transport.HTTP);
  }

  public DatastoreImplMetricsTest(TelemetryConstants.Transport transport) {
    this.transport = transport;
  }

  @Before
  public void setUp() {
    // Use delta temporality so each collectAllMetrics() call returns only new data and resets.
    metricReader = InMemoryMetricReader.createDelta();
    SdkMeterProvider meterProvider =
        SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk openTelemetry =
        OpenTelemetrySdk.builder().setMeterProvider(meterProvider).build();

    DatastoreRpcFactory rpcFactoryMock = EasyMock.createStrictMock(DatastoreRpcFactory.class);
    // Use a regular (non-strict) mock for rpcMock so that anyTimes() expectations work without
    // enforcing call order — needed for retry tests with unpredictable call counts.
    rpcMock = EasyMock.createMock(DatastoreRpc.class);

    DatastoreOptions.Builder builder =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setCredentials(NoCredentials.getInstance())
            .setRetrySettings(ServiceOptions.getDefaultRetrySettings())
            .setServiceRpcFactory(rpcFactoryMock)
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(openTelemetry)
                    .build());

    if (TelemetryConstants.Transport.GRPC.equals(transport)) {
      builder.setTransportOptions(com.google.cloud.grpc.GrpcTransportOptions.newBuilder().build());
    } else {
      builder.setTransportOptions(com.google.cloud.http.HttpTransportOptions.newBuilder().build());
    }

    DatastoreOptions datastoreOptions = builder.build();

    EasyMock.expect(rpcFactoryMock.create(datastoreOptions)).andReturn(rpcMock);
    EasyMock.replay(rpcFactoryMock);
    datastore = datastoreOptions.getService();
    EasyMock.verify(rpcFactoryMock);

    metricReader.collectAllMetrics(); // drain initialization
  }

  @Test
  public void runInTransaction_recordsLatencyOnSuccess() {
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcMock);

    datastore.runInTransaction(transaction -> null);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    Optional<MetricData> latencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY);
    assertThat(latencyMetric.isPresent()).isTrue();

    HistogramPointData point =
        latencyMetric.get().getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getCount()).isEqualTo(1);

    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString()))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_RUN))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    EasyMock.verify(rpcMock);
  }

  @Test
  public void runInTransaction_recordsPerAttemptCountOnSuccess() {
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcMock);

    datastore.runInTransaction(transaction -> null);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    Optional<MetricData> attemptMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);
    assertThat(attemptMetric.isPresent()).isTrue();

    LongPointData point =
        attemptMetric.get().getLongSumData().getPoints().stream().findFirst().orElse(null);
    assertThat(point).isNotNull();
    assertThat(point.getValue()).isEqualTo(1);

    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_STATUS, StatusCode.Code.OK.toString()))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                point, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    EasyMock.verify(rpcMock);
  }

  @Test
  public void runInTransaction_recordsPerAttemptOnRetry() {
    String abortedStatusCodeString = StatusCode.Code.ABORTED.toString();
    String okStatusCodeString = StatusCode.Code.OK.toString();
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
    EasyMock.replay(rpcMock);

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
              throw new DatastoreException(10, "", abortedStatusCodeString, false, null);
            }
            return attempts;
          }
        };

    Integer result = datastore.runInTransaction(callable, options);
    assertThat(result).isEqualTo(2);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // Verify attempt count has two data points: one with ABORTED and one with OK
    Optional<MetricData> attemptMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);
    assertThat(attemptMetric.isPresent()).isTrue();
    assertThat(attemptMetric.get().getLongSumData().getPoints()).hasSize(2);

    // Find the first point (this would match to ABORTED)
    LongPointData abortedPoint =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(
                p ->
                    abortedStatusCodeString.equals(
                        p.getAttributes()
                            .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_STATUS))))
            .findFirst()
            .orElse(null);
    assertThat(abortedPoint).isNotNull();
    assertThat(abortedPoint.getValue()).isEqualTo(1);

    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, abortedStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    LongPointData okPoint =
        attemptMetric.get().getLongSumData().getPoints().stream()
            .filter(
                p ->
                    okStatusCodeString.equals(
                        p.getAttributes()
                            .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_STATUS))))
            .findFirst()
            .orElse(null);
    assertThat(okPoint).isNotNull();
    assertThat(okPoint.getValue()).isEqualTo(1);

    assertThat(
            dataContainsStringAttribute(
                okPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, okStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                okPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                okPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                okPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    // Verify latency was recorded with OK (overall transaction succeeded)
    Optional<MetricData> latencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY);
    assertThat(latencyMetric.isPresent()).isTrue();
    HistogramPointData latencyPoint =
        latencyMetric.get().getHistogramData().getPoints().stream().findFirst().orElse(null);
    assertThat(latencyPoint).isNotNull();
    assertThat(
            latencyPoint
                .getAttributes()
                .get(AttributeKey.stringKey(TelemetryConstants.ATTRIBUTES_KEY_STATUS)))
        .isEqualTo(okStatusCodeString);

    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, okStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_RUN))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    EasyMock.verify(rpcMock);
  }

  @Test
  public void runInTransaction_recordsStatusCodeOnFailure() {
    String abortedStatusCodeString = StatusCode.Code.ABORTED.toString();
    String cancelledStatusCodeString = StatusCode.Code.CANCELLED.toString();

    // The retry loop makes multiple begin/rollback calls with unpredictable counts, so use
    // anyTimes() rather than exact expectations.
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance())
        .anyTimes();
    EasyMock.expect(rpcMock.rollback(EasyMock.anyObject(RollbackRequest.class)))
        .andReturn(RollbackResponse.getDefaultInstance())
        .anyTimes();
    EasyMock.replay(rpcMock);

    Datastore.TransactionCallable<Integer> callable =
        new Datastore.TransactionCallable<Integer>() {
          private int attempts = 0;

          @Override
          public Integer run(DatastoreReaderWriter transaction) {
            attempts++;
            if (attempts < 2) {
              throw new DatastoreException(10, "", abortedStatusCodeString, false, null);
            }
            throw new DatastoreException(1, "", cancelledStatusCodeString, false, null);
          }
        };

    assertThrows(DatastoreException.class, () -> datastore.runInTransaction(callable));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // Verify attempt count was recorded with ABORTED status
    Optional<MetricData> attemptMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);
    assertThat(attemptMetric.isPresent()).isTrue();

    Collection<LongPointData> transactionAttemptCountData =
        attemptMetric.get().getLongSumData().getPoints();
    LongPointData abortedPoint =
        transactionAttemptCountData.stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p, TelemetryConstants.ATTRIBUTES_KEY_STATUS, abortedStatusCodeString))
            .findFirst()
            .orElse(null);
    assertThat(abortedPoint).isNotNull();
    assertThat(abortedPoint.getValue()).isAtLeast(1);

    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, abortedStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                abortedPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    LongPointData cancelledPoint =
        transactionAttemptCountData.stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p, TelemetryConstants.ATTRIBUTES_KEY_STATUS, cancelledStatusCodeString))
            .findFirst()
            .orElse(null);
    assertThat(cancelledPoint).isNotNull();
    assertThat(cancelledPoint.getValue()).isAtLeast(1);

    assertThat(
            dataContainsStringAttribute(
                cancelledPoint,
                TelemetryConstants.ATTRIBUTES_KEY_STATUS,
                cancelledStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                cancelledPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                cancelledPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                cancelledPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    // Verify latency was recorded with the failure status code
    Optional<MetricData> latencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY);
    assertThat(latencyMetric.isPresent()).isTrue();
    HistogramPointData latencyPoint =
        latencyMetric.get().getHistogramData().getPoints().stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p, TelemetryConstants.ATTRIBUTES_KEY_STATUS, cancelledStatusCodeString))
            .findFirst()
            .orElse(null);
    assertThat(latencyPoint).isNotNull();

    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, cancelledStatusCodeString))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_RUN))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();
  }

  @Test
  public void runInTransaction_withTransactionOptions_recordsMetrics() {
    EasyMock.expect(rpcMock.beginTransaction(EasyMock.anyObject(BeginTransactionRequest.class)))
        .andReturn(BeginTransactionResponse.getDefaultInstance());
    EasyMock.expect(rpcMock.commit(EasyMock.anyObject(CommitRequest.class)))
        .andReturn(CommitResponse.newBuilder().build());
    EasyMock.replay(rpcMock);

    TransactionOptions options =
        TransactionOptions.newBuilder()
            .setReadWrite(TransactionOptions.ReadWrite.getDefaultInstance())
            .build();
    datastore.runInTransaction(transaction -> null, options);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    Optional<MetricData> transactionLatencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY);
    assertThat(transactionLatencyMetric.isPresent()).isTrue();
    Optional<MetricData> transactionAttemptCountMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);
    assertThat(transactionAttemptCountMetric.isPresent()).isTrue();

    EasyMock.verify(rpcMock);
  }

  @Test
  public void lookup_recordsOperationAndAttemptMetrics() {
    // Use `lookup` as a simple RPC test to test that metrics are recorded for operation
    // and attempt. Any RPC could have worked (there is no specific reason for lookup)
    EasyMock.expect(rpcMock.lookup(EasyMock.anyObject(LookupRequest.class)))
        .andReturn(LookupResponse.getDefaultInstance());
    EasyMock.replay(rpcMock);

    // Use get() which triggers lookup internally
    datastore.get(Key.newBuilder(PROJECT_ID, "Kind", "name").setDatabaseId(DATABASE_ID).build());

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // Gax already records operation and attempt metrics natively for the gRPC transport.
    // DatastoreImpl explicitly avoids recording them here to prevent double-counting.
    // Since this unit test bypasses the GAX networking layer by mocking DatastoreRpc,
    // we assert that no local duplicate metrics are emitted by DatastoreImpl for gRPC,
    // and skip the rest of the assertions.
    if (TelemetryConstants.Transport.GRPC.equals(transport)) {
      Optional<MetricData> operationLatency =
          findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY);
      assertThat(operationLatency.isPresent()).isFalse();
      EasyMock.verify(rpcMock);
      return;
    }

    // Verify operation latency
    Optional<MetricData> operationLatency =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY);
    assertThat(operationLatency.isPresent()).isTrue();
    HistogramPointData opLatencyPoint =
        operationLatency.get().getHistogramData().getPoints().stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p,
                        TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                        TelemetryConstants.METHOD_LOOKUP))
            .findFirst()
            .orElse(null);
    assertThat(opLatencyPoint).isNotNull();
    assertThat(opLatencyPoint.getCount()).isEqualTo(1);
    assertThat(
            dataContainsStringAttribute(
                opLatencyPoint,
                TelemetryConstants.ATTRIBUTES_KEY_STATUS,
                StatusCode.Code.OK.toString()))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                opLatencyPoint, TelemetryConstants.ATTRIBUTES_KEY_PROJECT_ID, PROJECT_ID))
        .isTrue();
    assertThat(
            dataContainsStringAttribute(
                opLatencyPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    // Verify operation count
    Optional<MetricData> operationCount =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_COUNT);
    assertThat(operationCount.isPresent()).isTrue();

    // Verify attempt latency
    Optional<MetricData> attemptLatency =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_LATENCY);
    assertThat(attemptLatency.isPresent()).isTrue();
    HistogramPointData attLatencyPoint =
        attemptLatency.get().getHistogramData().getPoints().stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p,
                        TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                        TelemetryConstants.METHOD_LOOKUP))
            .findFirst()
            .orElse(null);
    assertThat(attLatencyPoint).isNotNull();
    assertThat(attLatencyPoint.getCount()).isEqualTo(1);

    // Verify attempt count
    Optional<MetricData> attemptCount =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT);
    assertThat(attemptCount.isPresent()).isTrue();

    EasyMock.verify(rpcMock);
  }

  @Test
  public void lookup_recordsFailureStatusOnError() {
    // Use `lookup` as a simple RPC test to test that metrics are recorded for operation
    // and attempt. Any RPC could have worked (there is no specific reason for lookup)
    StatusCode.Code unavailableStatusCode = StatusCode.Code.UNAVAILABLE;
    EasyMock.expect(rpcMock.lookup(EasyMock.anyObject(LookupRequest.class)))
        .andThrow(
            new DatastoreException(
                14,
                unavailableStatusCode.toString(),
                unavailableStatusCode.toString(),
                false,
                null))
        .anyTimes();
    EasyMock.replay(rpcMock);

    assertThrows(
        DatastoreException.class,
        () ->
            datastore.get(
                Key.newBuilder(PROJECT_ID, "Kind", "name").setDatabaseId(DATABASE_ID).build()));

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // Gax already records operation and attempt metrics natively for the gRPC transport.
    // DatastoreImpl explicitly avoids recording them here to prevent double-counting.
    // Since this unit test bypasses the GAX networking layer by mocking DatastoreRpc,
    // we assert that no local duplicate metrics are emitted by DatastoreImpl for gRPC,
    // and skip the rest of the assertions.
    if (TelemetryConstants.Transport.GRPC.equals(transport)) {
      Optional<MetricData> operationLatency =
          findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY);
      assertThat(operationLatency.isPresent()).isFalse();
      EasyMock.verify(rpcMock);
      return;
    }

    // Verify operation latency with UNAVAILABLE status
    Optional<MetricData> operationLatency =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY);
    assertThat(operationLatency.isPresent()).isTrue();
    HistogramPointData opLatencyPoint =
        operationLatency.get().getHistogramData().getPoints().stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p,
                        TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                        TelemetryConstants.METHOD_LOOKUP))
            .findFirst()
            .orElse(null);
    assertThat(opLatencyPoint).isNotNull();
    assertThat(
            dataContainsStringAttribute(
                opLatencyPoint,
                TelemetryConstants.ATTRIBUTES_KEY_STATUS,
                unavailableStatusCode.toString()))
        .isTrue();

    // Verify attempt metrics were also recorded with UNAVAILABLE
    Optional<MetricData> attemptCount =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT);
    assertThat(attemptCount.isPresent()).isTrue();

    EasyMock.verify(rpcMock);
  }

  private static Optional<MetricData> findMetric(
      Collection<MetricData> metrics, String metricName) {
    return metrics.stream().filter(m -> m.getName().equals(metricName)).findFirst();
  }

  private static boolean dataContainsStringAttribute(
      PointData p, String attributeKey, String matchedAttributeValue) {
    String attributeValue = p.getAttributes().get(AttributeKey.stringKey(attributeKey));
    return matchedAttributeValue.equals(attributeValue);
  }
}
