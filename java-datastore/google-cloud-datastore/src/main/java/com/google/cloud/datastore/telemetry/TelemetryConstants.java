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

/** Internal telemetry constants shared between OpenTelemetry tracing and metrics. */
@InternalApi
public class TelemetryConstants {
  static final String SERVICE_NAME = "datastore.googleapis.com";
  static final String METER_NAME = "com.google.cloud.datastore";

  public static final String ATTRIBUTES_KEY_DOCUMENT_COUNT = "doc_count";
  public static final String ATTRIBUTES_KEY_TRANSACTIONAL = "transactional";
  public static final String ATTRIBUTES_KEY_TRANSACTION_ID = "transaction_id";
  public static final String ATTRIBUTES_KEY_READ_CONSISTENCY = "read_consistency";
  public static final String ATTRIBUTES_KEY_RECEIVED = "Received";
  public static final String ATTRIBUTES_KEY_MISSING = "Missing";
  public static final String ATTRIBUTES_KEY_DEFERRED = "Deferred";
  public static final String ATTRIBUTES_KEY_MORE_RESULTS = "more_results";

  /* TODO(lawrenceqiu): For now, these are a duplicate of method names in TraceUtil. Those will use these eventually */
  // Format is not SnakeCase to keep backward compatibility with the existing values TraceUtil spans
  public static final String METHOD_ALLOCATE_IDS = "AllocateIds";
  public static final String METHOD_BEGIN_TRANSACTION = "Transaction.Begin";
  public static final String METHOD_COMMIT = "Commit";
  public static final String METHOD_LOOKUP = "Lookup";
  public static final String METHOD_RESERVE_IDS = "ReserveIds";
  public static final String METHOD_RUN_QUERY = "RunQuery";
  public static final String METHOD_TRANSACTION_COMMIT = "Transaction.Commit";
  public static final String METHOD_TRANSACTION_LOOKUP = "Transaction.Lookup";
  public static final String METHOD_TRANSACTION_RUN = "Transaction.Run";
  public static final String METHOD_TRANSACTION_RUN_QUERY = "Transaction.RunQuery";
  public static final String METHOD_TRANSACTION_ROLLBACK = "Transaction.Rollback";
  public static final String METHOD_TRANSACTION_RUN_AGGREGATION_QUERY =
      "Transaction.RunAggregationQuery";
  public static final String METHOD_ADD = "add";
  public static final String METHOD_PUT = "put";
  public static final String METHOD_UPDATE = "update";
  public static final String METHOD_DELETE = "delete";
  public static final String METHOD_SUBMIT = "submit";

  private TelemetryConstants() {}
}
