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

import com.google.api.core.InternalApi;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.common.AttributeKey;
import java.util.Set;

/**
 * Internal telemetry constants shared between OpenTelemetry tracing and metrics.
 *
 * <p><b>Warning:</b> This is intended to be an internal API and is not intended for external use.
 * This is public solely for implementation purposes and does not promise any backwards
 * compatibility.
 */
@InternalApi
public class TelemetryConstants {

  // The Firestore namespace has not been deployed yet. Must target the custom namespace
  // until this is implemented.
  public static final String METRIC_PREFIX = "custom.googleapis.com/internal/client";
  public static final String DATASTORE_METER_NAME = "java-datastore";

  // Monitored resource type for Cloud Monitoring
  public static final String DATASTORE_RESOURCE_TYPE = "global";

  // Resource label keys for the monitored resource
  // The Firestore namespace has not been deployed yet. Must target the global
  // Monitored Resource until this is implemented.
  public static final String RESOURCE_LABEL_PROJECT_ID = "project_id";
  public static final String RESOURCE_LABEL_DATABASE_ID = "database_id";
  public static final String RESOURCE_LABEL_LOCATION = "location";
  public static final Set<String> DATASTORE_RESOURCE_LABELS =
      ImmutableSet.of(
          RESOURCE_LABEL_PROJECT_ID, RESOURCE_LABEL_DATABASE_ID, RESOURCE_LABEL_LOCATION);

  // Existing attribute key constants (string-based, used by MetricsHelper/TelemetryUtils)
  public static final String ATTRIBUTES_KEY_DOCUMENT_COUNT = "doc_count";
  public static final String ATTRIBUTES_KEY_TRANSACTIONAL = "transactional";
  public static final String ATTRIBUTES_KEY_TRANSACTION_ID = "transaction_id";
  public static final String ATTRIBUTES_KEY_READ_CONSISTENCY = "read_consistency";
  public static final String ATTRIBUTES_KEY_RECEIVED = "Received";
  public static final String ATTRIBUTES_KEY_MISSING = "Missing";
  public static final String ATTRIBUTES_KEY_DEFERRED = "Deferred";
  public static final String ATTRIBUTES_KEY_MORE_RESULTS = "more_results";

  /** Attribute key for the gRPC status code (e.g. "OK", "ABORTED", "UNAVAILABLE"). */
  public static final String ATTRIBUTES_KEY_STATUS = "status";

  /** Attribute key for the RPC method name (e.g. "Transaction.Run"). */
  public static final String ATTRIBUTES_KEY_METHOD = "method";

  /** Attribute key for the GCP project ID. */
  public static final String ATTRIBUTES_KEY_PROJECT_ID = "project_id";

  /** Attribute key for the Datastore database ID. */
  public static final String ATTRIBUTES_KEY_DATABASE_ID = "database_id";

  // Resource attribute keys (used on OTel Resource)
  public static final AttributeKey<String> PROJECT_ID_KEY = AttributeKey.stringKey("project_id");
  public static final AttributeKey<String> DATABASE_ID_KEY = AttributeKey.stringKey("database_id");
  public static final AttributeKey<String> LOCATION_ID_KEY = AttributeKey.stringKey("location");

  // Metric attribute keys (used on metric data points)
  public static final AttributeKey<String> CLIENT_UID_KEY = AttributeKey.stringKey("client_uid");
  public static final AttributeKey<String> METHOD_KEY = AttributeKey.stringKey("method");
  public static final AttributeKey<String> STATUS_KEY = AttributeKey.stringKey("status");
  public static final AttributeKey<String> SERVICE_KEY = AttributeKey.stringKey("service");

  public static final String SERVICE_VALUE = "datastore.googleapis.com";

  /** String key for the {@code service} metric attribute (value: {@code "service"}). */
  public static final String ATTRIBUTES_KEY_SERVICE = SERVICE_KEY.getKey();

  /**
   * The allowlist of metric attributes that are permitted on every exported data point.
   *
   * <p>Cloud Monitoring is strict about label schemas: exporting a label that was not present when
   * the metric descriptor was first created will cause the entire {@code createTimeSeries} call to
   * fail. Only {@code status}, {@code method}, {@code service}, and {@code client_uid} are
   * accepted; all other attributes must be omitted from every {@code record*()} call.
   */
  public static final Set<AttributeKey<?>> COMMON_ATTRIBUTES =
      ImmutableSet.of(CLIENT_UID_KEY, METHOD_KEY, STATUS_KEY, SERVICE_KEY);

  /** Metric name for the total latency of a transaction. */
  public static final String METRIC_NAME_TRANSACTION_LATENCY =
      METRIC_PREFIX + "/transaction_latencies";

  /** Metric name for the number of attempts a transaction took. */
  public static final String METRIC_NAME_TRANSACTION_ATTEMPT_COUNT =
      METRIC_PREFIX + "/transaction_attempt_count";

  /**
   * Metric name for the total latency of an operation (one full RPC call including retries).
   *
   * <p>The plural form ({@code operation_latencies}) is intentional: it matches the internal Cloud
   * Monitoring metric descriptor name. {@link OpenTelemetryDatastoreMetricsRecorder} overrides the
   * inherited GAX method to record to this name rather than the singular GAX default.
   */
  public static final String METRIC_NAME_OPERATION_LATENCY = METRIC_PREFIX + "/operation_latencies";

  /**
   * Metric name for the latency of a single RPC attempt.
   *
   * <p>The plural form ({@code attempt_latencies}) is intentional: it matches the internal Cloud
   * Monitoring metric descriptor name. {@link OpenTelemetryDatastoreMetricsRecorder} overrides the
   * inherited GAX method to record to this name rather than the singular GAX default.
   */
  public static final String METRIC_NAME_ATTEMPT_LATENCY = METRIC_PREFIX + "/attempt_latencies";

  /** Metric name for the count of operations. */
  public static final String METRIC_NAME_OPERATION_COUNT = METRIC_PREFIX + "/operation_count";

  /** Metric name for the count of RPC attempts. */
  public static final String METRIC_NAME_ATTEMPT_COUNT = METRIC_PREFIX + "/attempt_count";

  static final String METHOD_SERVICE_NAME = "Datastore";

  // The follow method name formats are not in SnakeCase to match the method name convention in Gax.
  // The format is {ServiceName}.{MethodName}. For these methods, include `Transaction`
  // to denote that the metrics are related specifically to transactions.
  public static final String METHOD_ALLOCATE_IDS = METHOD_SERVICE_NAME + ".AllocateIds";
  public static final String METHOD_BEGIN_TRANSACTION = METHOD_SERVICE_NAME + ".BeginTransaction";
  public static final String METHOD_COMMIT = METHOD_SERVICE_NAME + ".Commit";
  public static final String METHOD_LOOKUP = METHOD_SERVICE_NAME + ".Lookup";
  public static final String METHOD_RESERVE_IDS = METHOD_SERVICE_NAME + ".ReserveIds";
  public static final String METHOD_ROLLBACK = METHOD_SERVICE_NAME + ".Rollback";
  public static final String METHOD_RUN_QUERY = METHOD_SERVICE_NAME + ".RunQuery";
  public static final String METHOD_RUN_AGGREGATION_QUERY =
      METHOD_SERVICE_NAME + ".RunAggregationQuery";

  // These metrics capture the specific transaction related
  public static final String METHOD_TRANSACTION_COMMIT =
      METHOD_SERVICE_NAME + ".Transaction.Commit";
  public static final String METHOD_TRANSACTION_RUN = METHOD_SERVICE_NAME + ".Transaction.Run";

  public enum Transport {
    GRPC("grpc"),
    HTTP("http");

    private final String transport;

    Transport(String transport) {
      this.transport = transport;
    }

    public String getTransport() {
      return transport;
    }
  }

  private TelemetryConstants() {}
}
