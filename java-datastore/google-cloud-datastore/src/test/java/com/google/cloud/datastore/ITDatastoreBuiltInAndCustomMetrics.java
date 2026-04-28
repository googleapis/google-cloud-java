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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assume.assumeNotNull;

import com.google.cloud.TransportOptions;
import com.google.cloud.datastore.telemetry.TelemetryConstants;
import com.google.cloud.grpc.GrpcTransportOptions;
import com.google.cloud.http.HttpTransportOptions;
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
import java.util.Optional;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 * Integration test that verifies a user-configured OpenTelemetry backend (backed by {@link
 * InMemoryMetricReader}) correctly captures metrics emitted by the Datastore SDK.
 *
 * <h3>What this test covers</h3>
 *
 * <ol>
 *   <li><b>Custom OTel backend (in-memory)</b> — {@link InMemoryMetricReader} captures every metric
 *       emitted by the Datastore SDK. After each operation the test collects all metrics
 *       synchronously and asserts that expected names, types, and attributes are present. Because
 *       the in-memory reader is under full test control, these assertions are deterministic.
 * </ol>
 *
 * <p>Following the strategy used in tracing tests, this test relies on {@link InMemoryMetricReader}
 * to verify that metrics are correctly generated with expected attributes.
 */
@RunWith(Parameterized.class)
@SuppressWarnings("checkstyle:abbreviationaswordinname")
public class ITDatastoreBuiltInAndCustomMetrics {

  private static final String PROJECT_ID = System.getenv("GOOGLE_CLOUD_PROJECT");
  private static final String DATABASE_ID =
      System.getenv().getOrDefault("DATASTORE_DATABASE_ID", "");
  private boolean isDatastoreClosed = false;

  private final TransportOptions transportOptions;

  public ITDatastoreBuiltInAndCustomMetrics(TransportOptions transportOptions) {
    this.transportOptions = transportOptions;
  }

  @Parameterized.Parameters(name = "transport: {0}")
  public static Iterable<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          {DatastoreOptions.getDefaultGrpcTransportOptions()},
          {DatastoreOptions.getDefaultHttpTransportOptions()}
        });
  }

  /**
   * Delta temporality is used so that each {@link InMemoryMetricReader#collectAllMetrics()} call
   * returns only the new data points recorded since the last collection, and automatically resets
   * the in-memory state. This makes per-test assertions independent and avoids cross-test
   * contamination.
   */
  private InMemoryMetricReader metricReader;

  private SdkMeterProvider customMeterProvider;
  private Datastore datastore;
  private String kind;

  @Before
  public void setUp() {
    // Skip the test gracefully if the required environment variable is not configured.
    assumeNotNull("GOOGLE_CLOUD_PROJECT must be set to run this IT test", PROJECT_ID);

    kind = "Kind-" + java.util.UUID.randomUUID().toString().substring(0, 8);

    // Build a user-configured OTel backend that records to an in-memory reader for assertions.
    metricReader = InMemoryMetricReader.createDelta();
    customMeterProvider = SdkMeterProvider.builder().registerMetricReader(metricReader).build();
    OpenTelemetrySdk customOtel =
        OpenTelemetrySdk.builder().setMeterProvider(customMeterProvider).build();

    // Do not enable setExportBuiltinMetricsToGoogleCloudMonitoring(false) for this IT
    // as we will only rely on in-memory to collect the metrics for this test
    DatastoreOptions.Builder builder =
        DatastoreOptions.newBuilder()
            .setProjectId(PROJECT_ID)
            .setDatabaseId(DATABASE_ID)
            .setOpenTelemetryOptions(
                DatastoreOpenTelemetryOptions.newBuilder()
                    .setMetricsEnabled(true)
                    .setOpenTelemetry(customOtel)
                    .setExportBuiltinMetricsToGoogleCloudMonitoring(false)
                    .build());

    if (transportOptions instanceof GrpcTransportOptions) {
      builder.setTransportOptions((GrpcTransportOptions) transportOptions);
    } else {
      builder.setTransportOptions((HttpTransportOptions) transportOptions);
    }

    datastore = builder.build().getService();

    // Drain any metrics emitted during client initialisation so test assertions only capture
    // data from the operations performed within the test method itself.
    metricReader.collectAllMetrics();
  }

  @After
  public void tearDown() throws Exception {
    if (datastore != null && !isDatastoreClosed) {
      Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-it-entity");
      try {
        datastore.delete(key);
      } catch (Exception e) {
        // ignore if fails, we are cleaning up
      }
      datastore.close();
    }
    if (customMeterProvider != null) {
      customMeterProvider.close();
    }
  }

  /**
   * Verifies that a transaction operation records {@code transaction_latency} and {@code
   * transaction_attempt_count} metrics in the custom (in-memory) OTel backend.
   *
   * <p>These are Datastore-specific metrics emitted by the SDK layer (not the GAX layer), so they
   * validate that the Datastore-level recording path is working end-to-end.
   */
  @Test
  public void transactionOperation_recordsTransactionMetricsInCustomBackend() {
    Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-it-entity");
    Entity initial = Entity.newBuilder(key).set("value", 0L).build();
    datastore.put(initial);

    datastore.runInTransaction(
        tx -> {
          Entity current = tx.get(key);
          tx.put(Entity.newBuilder(current).set("value", current.getLong("value") + 1).build());
          return null;
        });

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // --- transaction_latency ---
    Optional<MetricData> transactionLatencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY);
    assertWithMessage("transaction_latency metric was recorded")
        .that(transactionLatencyMetric.isPresent())
        .isTrue();

    HistogramPointData latencyPoint =
        transactionLatencyMetric.get().getHistogramData().getPoints().stream()
            .findFirst()
            .orElse(null);
    assertThat(latencyPoint).isNotNull();
    assertThat(latencyPoint.getCount()).isEqualTo(1);
    assertWithMessage("status=OK on transaction_latency")
        .that(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, "OK"))
        .isTrue();
    assertWithMessage("method=Transaction.Run on transaction_latency")
        .that(
            dataContainsStringAttribute(
                latencyPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_RUN))
        .isTrue();
    assertWithMessage("database_id attribute on transaction_latency")
        .that(
            dataContainsStringAttribute(
                latencyPoint, TelemetryConstants.ATTRIBUTES_KEY_DATABASE_ID, DATABASE_ID))
        .isTrue();

    // --- transaction_attempt_count ---
    Optional<MetricData> attemptCountMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);
    assertWithMessage("transaction_attempt_count metric was recorded")
        .that(attemptCountMetric.isPresent())
        .isTrue();

    LongPointData attemptPoint =
        attemptCountMetric.get().getLongSumData().getPoints().stream().findFirst().orElse(null);
    assertThat(attemptPoint).isNotNull();
    assertThat(attemptPoint.getValue()).isEqualTo(1);
    assertWithMessage("status=OK on transaction_attempt_count")
        .that(
            dataContainsStringAttribute(
                attemptPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, "OK"))
        .isTrue();
    assertWithMessage("method=Transaction.Commit on transaction_attempt_count")
        .that(
            dataContainsStringAttribute(
                attemptPoint,
                TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                TelemetryConstants.METHOD_TRANSACTION_COMMIT))
        .isTrue();
  }

  /**
   * Verifies that a lookup RPC records {@code operation_latency}, {@code attempt_latency}, {@code
   * operation_count}, and {@code attempt_count} in the custom (in-memory) OTel backend.
   *
   * <p>These GAX-layer metrics are recorded by {@link com.google.cloud.datastore.telemetry
   * .TelemetryUtils} and exercise the code path that was previously gated behind a {@code !GRPC}
   * transport guard (now removed). This assertion confirms that all four RPC-level metrics are
   * recorded regardless of transport.
   */
  @Test
  public void lookupRpc_recordsGaxMetricsInCustomBackend() {
    // Issue a lookup for a key that does not exist; it still produces all four RPC-level metrics.
    Key key = datastore.newKeyFactory().setKind(kind).newKey("does-not-exist");
    datastore.get(key);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    // --- operation_latency ---
    Optional<MetricData> operationLatencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY);
    assertWithMessage("operation_latency metric was recorded")
        .that(operationLatencyMetric.isPresent())
        .isTrue();
    HistogramPointData opPoint =
        operationLatencyMetric.get().getHistogramData().getPoints().stream()
            .filter(
                p ->
                    dataContainsStringAttribute(
                        p,
                        TelemetryConstants.ATTRIBUTES_KEY_METHOD,
                        TelemetryConstants.METHOD_LOOKUP))
            .findFirst()
            .orElse(null);
    assertWithMessage("operation_latency point for Lookup method").that(opPoint).isNotNull();
    assertThat(opPoint.getCount()).isAtLeast(1);
    assertWithMessage("status=OK on operation_latency")
        .that(dataContainsStringAttribute(opPoint, TelemetryConstants.ATTRIBUTES_KEY_STATUS, "OK"))
        .isTrue();

    // --- attempt_latency ---
    Optional<MetricData> attemptLatencyMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_LATENCY);
    assertWithMessage("attempt_latency metric was recorded")
        .that(attemptLatencyMetric.isPresent())
        .isTrue();

    // --- operation_count ---
    Optional<MetricData> operationCountMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_COUNT);
    assertWithMessage("operation_count metric was recorded")
        .that(operationCountMetric.isPresent())
        .isTrue();

    // --- attempt_count ---
    Optional<MetricData> attemptCountMetric =
        findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT);
    assertWithMessage("attempt_count metric was recorded")
        .that(attemptCountMetric.isPresent())
        .isTrue();
  }

  /**
   * Verifies that all six expected metrics appear in the custom (in-memory) OTel backend after a
   * combined transaction-plus-lookup workload. This is the primary "composite" scenario: both the
   * SDK-layer metrics (transaction) and the GAX-layer metrics (operation/attempt) are captured in a
   * single test run, confirming the full fan-out routing is correct.
   */
  @Test
  public void combinedWorkload_recordsAllSixMetricsInCustomBackend() {
    Key key = datastore.newKeyFactory().setKind(kind).newKey("metrics-it-entity");
    Entity initial = Entity.newBuilder(key).set("value", 0L).build();

    // Step 1: plain put (records operation_latency, attempt_latency, etc.)
    datastore.put(initial);

    // Step 2: transaction (records transaction_latency, transaction_attempt_count on top)
    datastore.runInTransaction(
        tx -> {
          Entity current = tx.get(key);
          tx.put(Entity.newBuilder(current).set("value", current.getLong("value") + 1).build());
          return null;
        });

    // Step 3: standalone lookup
    datastore.get(key);

    Collection<MetricData> metrics = metricReader.collectAllMetrics();

    assertWithMessage("operation_latency present")
        .that(findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_LATENCY).isPresent())
        .isTrue();
    assertWithMessage("attempt_latency present")
        .that(findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_LATENCY).isPresent())
        .isTrue();
    assertWithMessage("operation_count present")
        .that(findMetric(metrics, TelemetryConstants.METRIC_NAME_OPERATION_COUNT).isPresent())
        .isTrue();
    assertWithMessage("attempt_count present")
        .that(findMetric(metrics, TelemetryConstants.METRIC_NAME_ATTEMPT_COUNT).isPresent())
        .isTrue();
    assertWithMessage("transaction_latency present")
        .that(findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_LATENCY).isPresent())
        .isTrue();
    assertWithMessage("transaction_attempt_count present")
        .that(
            findMetric(metrics, TelemetryConstants.METRIC_NAME_TRANSACTION_ATTEMPT_COUNT)
                .isPresent())
        .isTrue();
  }

  // ---------------------------------------------------------------------------
  // Helpers
  // ---------------------------------------------------------------------------

  private static Optional<MetricData> findMetric(
      Collection<MetricData> metrics, String metricName) {
    return metrics.stream().filter(m -> m.getName().equals(metricName)).findFirst();
  }

  private static boolean dataContainsStringAttribute(
      PointData point, String attributeKey, String expectedValue) {
    String actual = point.getAttributes().get(AttributeKey.stringKey(attributeKey));
    return expectedValue.equals(actual);
  }
}
