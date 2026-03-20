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
import com.google.cloud.TransportOptions;
import com.google.cloud.grpc.GrpcTransportOptions;

/**
 * Internal telemetry constants shared between OpenTelemetry tracing and metrics.
 *
 * <p><b>Warning:</b> This is intended to be an internal API and is not intended for external use.
 * This is public solely for implementation purposes and does not promise any backwards
 * compatibility.
 */
@InternalApi
public class TelemetryConstants {

  // TODO(lawrenceqiu): For now, use `custom.googleapis.com` until metrics can be written to
  // datastore domain
  public static final String SERVICE_NAME = "custom.googleapis.com";
  static final String METER_NAME = "com.google.cloud.datastore";

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

  public static final String ATTRIBUTES_KEY_LIBRARY_VERSION = "library_version";

  public static final String ATTRIBUTES_KEY_TRANSPORT = "transport";

  /** Metric name for the total latency of a transaction. */
  public static final String METRIC_NAME_TRANSACTION_LATENCY =
      SERVICE_NAME + "/client/transaction_latency";

  /** Metric name for the number of attempts a transaction took. */
  public static final String METRIC_NAME_TRANSACTION_ATTEMPT_COUNT =
      SERVICE_NAME + "/client/transaction_attempt_count";

  /**
   * Metric name for the total latency of an operation (one full RPC call including retries). Note:
   * This does not have the /client prefix to match Gax's format.
   */
  public static final String METRIC_NAME_OPERATION_LATENCY = SERVICE_NAME + "/operation_latency";

  /**
   * Metric name for the latency of a single RPC attempt. Note: This does not have the /client
   * prefix to match Gax's format.
   */
  public static final String METRIC_NAME_ATTEMPT_LATENCY = SERVICE_NAME + "/attempt_latency";

  /**
   * Metric name for the count of operations. Note: This does not have the /client prefix to match
   * Gax's format.
   */
  public static final String METRIC_NAME_OPERATION_COUNT = SERVICE_NAME + "/operation_count";

  /**
   * Metric name for the count of RPC attempts. Note: This does not have the /client prefix to match
   * Gax's format.
   */
  public static final String METRIC_NAME_ATTEMPT_COUNT = SERVICE_NAME + "/attempt_count";

  // This is intentionally different from the `SERVICE_NAME` constant as it matches Gax's logic for
  // method name.
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

  public static String getTransportName(TransportOptions transportOptions) {
    if (transportOptions instanceof GrpcTransportOptions) {
      return Transport.GRPC.getTransport();
    } else {
      return Transport.HTTP.getTransport();
    }
  }

  private TelemetryConstants() {}
}
