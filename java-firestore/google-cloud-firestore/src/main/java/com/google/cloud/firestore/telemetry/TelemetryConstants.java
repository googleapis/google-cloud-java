/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.firestore.telemetry;

import com.google.api.core.InternalApi;
import com.google.api.gax.tracing.OpenTelemetryMetricsRecorder;
import com.google.common.collect.ImmutableSet;
import io.opentelemetry.api.common.AttributeKey;
import java.util.Set;

/** Constants used for telemetry in the Firestore SDK. */
@InternalApi
public interface TelemetryConstants {
  // Method names for Firestore operations
  String METHOD_NAME_DOC_REF_CREATE = "DocumentReference.Create";
  String METHOD_NAME_DOC_REF_SET = "DocumentReference.Set";
  String METHOD_NAME_DOC_REF_UPDATE = "DocumentReference.Update";
  String METHOD_NAME_DOC_REF_DELETE = "DocumentReference.Delete";
  String METHOD_NAME_DOC_REF_GET = "DocumentReference.Get";
  String METHOD_NAME_DOC_REF_LIST_COLLECTIONS = "DocumentReference.ListCollections";
  String METHOD_NAME_COL_REF_ADD = "CollectionReference.Add";
  String METHOD_NAME_COL_REF_LIST_DOCUMENTS = "CollectionReference.ListDocuments";
  String METHOD_NAME_QUERY_GET = "Query.Get";
  String METHOD_NAME_AGGREGATION_QUERY_GET = "AggregationQuery.Get";
  String METHOD_NAME_RUN_QUERY = "RunQuery";
  String METHOD_NAME_RUN_QUERY_EXPLAIN = "RunQuery.Explain";
  String METHOD_NAME_RUN_QUERY_GET = "RunQuery.Get";
  String METHOD_NAME_RUN_QUERY_TRANSACTIONAL = "RunQuery.Transactional";
  String METHOD_NAME_RUN_AGGREGATION_QUERY = "RunAggregationQuery";
  String METHOD_NAME_RUN_AGGREGATION_QUERY_EXPLAIN = "RunAggregationQuery.Explain";
  String METHOD_NAME_RUN_AGGREGATION_QUERY_GET = "RunAggregationQuery.Get";
  String METHOD_NAME_RUN_AGGREGATION_QUERY_TRANSACTIONAL = "RunAggregationQuery.Transactional";
  String METHOD_NAME_BATCH_GET_DOCUMENTS = "BatchGetDocuments";
  String METHOD_NAME_BATCH_GET_DOCUMENTS_GET_ALL = "BatchGetDocuments.GetAll";
  String METHOD_NAME_BATCH_GET_DOCUMENTS_TRANSACTIONAL = "BatchGetDocuments.Transactional";
  String METHOD_NAME_TRANSACTION_RUN = "Transaction.Run";
  String METHOD_NAME_TRANSACTION_BEGIN = "Transaction.Begin";
  String METHOD_NAME_TRANSACTION_GET_QUERY = "Transaction.Get.Query";
  String METHOD_NAME_TRANSACTION_GET_AGGREGATION_QUERY = "Transaction.Get.AggregationQuery";
  String METHOD_NAME_TRANSACTION_GET_DOCUMENT = "Transaction.Get.Document";
  String METHOD_NAME_TRANSACTION_GET_DOCUMENTS = "Transaction.Get.Documents";
  String METHOD_NAME_TRANSACTION_ROLLBACK = "Transaction.Rollback";
  String METHOD_NAME_BATCH_COMMIT = "Batch.Commit";
  String METHOD_NAME_TRANSACTION_COMMIT = "Transaction.Commit";
  String METHOD_NAME_PARTITION_QUERY = "PartitionQuery";
  String METHOD_NAME_BULK_WRITER_COMMIT = "BulkWriter.Commit";
  String METHOD_NAME_RUN_TRANSACTION = "RunTransaction";
  String METHOD_NAME_PIPELINE_EXECUTE = "Pipeline.Execute";
  String METHOD_NAME_EXECUTE_PIPELINE = "ExecutePipeline";
  String METHOD_NAME_EXECUTE_PIPELINE_EXECUTE = "ExecutePipeline.Execute";

  // OpenTelemetry built-in metrics constants
  String FIRESTORE_RESOURCE_TYPE = "firestore_client_raw";
  // TODO(metrics): change to firestore.googleapis.com
  String METRIC_PREFIX = "custom.googleapis.com/internal/client";
  String FIRESTORE_METER_NAME = "java_firestore";
  String GAX_METER_NAME = OpenTelemetryMetricsRecorder.GAX_METER_NAME;

  // Monitored resource keys for labels
  String RESOURCE_KEY_RESOURCE_CONTAINER = "resource_container";
  String RESOURCE_KEY_LOCATION = "location";
  String RESOURCE_KEY_DATABASE_ID = "database_id";
  Set<String> FIRESTORE_RESOURCE_LABELS =
      ImmutableSet.of(
          RESOURCE_KEY_RESOURCE_CONTAINER, RESOURCE_KEY_LOCATION, RESOURCE_KEY_DATABASE_ID);

  // Metric attribute keys for labels
  AttributeKey<String> METRIC_ATTRIBUTE_KEY_METHOD = AttributeKey.stringKey("method");
  AttributeKey<String> METRIC_ATTRIBUTE_KEY_STATUS = AttributeKey.stringKey("status");
  AttributeKey<String> METRIC_ATTRIBUTE_KEY_LIBRARY_NAME = AttributeKey.stringKey("library_name");
  AttributeKey<String> METRIC_ATTRIBUTE_KEY_LIBRARY_VERSION =
      AttributeKey.stringKey("library_version");
  AttributeKey<String> METRIC_ATTRIBUTE_KEY_CLIENT_UID = AttributeKey.stringKey("client_uid");
  Set<AttributeKey> COMMON_ATTRIBUTES =
      ImmutableSet.of(
          METRIC_ATTRIBUTE_KEY_CLIENT_UID,
          METRIC_ATTRIBUTE_KEY_LIBRARY_NAME,
          METRIC_ATTRIBUTE_KEY_LIBRARY_VERSION,
          METRIC_ATTRIBUTE_KEY_STATUS,
          METRIC_ATTRIBUTE_KEY_METHOD);

  // Metric names
  String METRIC_NAME_OPERATION_LATENCY = "operation_latency";
  String METRIC_NAME_OPERATION_COUNT = "operation_count";
  String METRIC_NAME_ATTEMPT_LATENCY = "attempt_latency";
  String METRIC_NAME_ATTEMPT_COUNT = "attempt_count";
  String METRIC_NAME_FIRST_RESPONSE_LATENCY = "first_response_latency";
  String METRIC_NAME_END_TO_END_LATENCY = "end_to_end_latency";
  String METRIC_NAME_TRANSACTION_LATENCY = "transaction_latency";
  String METRIC_NAME_TRANSACTION_ATTEMPT_COUNT = "transaction_attempt_count";

  // Metrics collected on GAX and Firestore SDK layer
  Set<String> GAX_METRICS =
      ImmutableSet.of(
          METRIC_NAME_OPERATION_LATENCY,
          METRIC_NAME_ATTEMPT_LATENCY,
          METRIC_NAME_OPERATION_COUNT,
          METRIC_NAME_ATTEMPT_COUNT);

  Set<String> FIRESTORE_METRICS =
      ImmutableSet.of(
          METRIC_NAME_FIRST_RESPONSE_LATENCY,
          METRIC_NAME_END_TO_END_LATENCY,
          METRIC_NAME_TRANSACTION_LATENCY,
          METRIC_NAME_TRANSACTION_ATTEMPT_COUNT);

  public enum MetricType {
    END_TO_END_LATENCY,
    FIRST_RESPONSE_LATENCY,
    TRANSACTION_LATENCY,
    TRANSACTION_ATTEMPT_COUNT
  }
}
