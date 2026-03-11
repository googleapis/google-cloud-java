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

  // Format is not SnakeCase to match the method name convention in Gax.
  // The format is {ServiceName}.{MethodName}. For these methods, include `Transaction`
  // to denote that the metrics are related specifically to transactions.
  public static final String METHOD_TRANSACTION_COMMIT = "Datastore.Transaction.Commit";
  public static final String METHOD_TRANSACTION_RUN = "Datastore.Transaction.Run";

  private TelemetryConstants() {}

  public static String getTransportName(TransportOptions transportOptions) {
    if (transportOptions instanceof GrpcTransportOptions) {
      return "grpc";
    } else {
      return "http";
    }
  }
}
