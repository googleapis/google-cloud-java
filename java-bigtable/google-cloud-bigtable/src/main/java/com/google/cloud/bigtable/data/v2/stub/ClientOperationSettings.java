/*
 * Copyright 2026 Google LLC
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
package com.google.cloud.bigtable.data.v2.stub;

import com.google.api.core.InternalApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ServerStreamingCallSettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.bigtable.v2.PingAndWarmRequest;
import com.google.cloud.bigtable.data.v2.internal.PrepareQueryRequest;
import com.google.cloud.bigtable.data.v2.internal.PrepareResponse;
import com.google.cloud.bigtable.data.v2.internal.SqlRow;
import com.google.cloud.bigtable.data.v2.models.ChangeStreamRecord;
import com.google.cloud.bigtable.data.v2.models.ConditionalRowMutation;
import com.google.cloud.bigtable.data.v2.models.KeyOffset;
import com.google.cloud.bigtable.data.v2.models.Query;
import com.google.cloud.bigtable.data.v2.models.Range;
import com.google.cloud.bigtable.data.v2.models.ReadChangeStreamQuery;
import com.google.cloud.bigtable.data.v2.models.ReadModifyWriteRow;
import com.google.cloud.bigtable.data.v2.models.Row;
import com.google.cloud.bigtable.data.v2.models.RowMutation;
import com.google.cloud.bigtable.data.v2.models.sql.BoundStatement;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.cloud.bigtable.data.v2.stub.readrows.ReadRowsBatchingDescriptor;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import org.threeten.bp.Duration;

@InternalApi
public class ClientOperationSettings {
  private static final Set<StatusCode.Code> IDEMPOTENT_RETRY_CODES =
      ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE);

  // Copy of default retrying settings in the yaml
  private static final RetrySettings IDEMPOTENT_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setInitialRpcTimeout(Duration.ofSeconds(20))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofSeconds(20))
          .setTotalTimeout(Duration.ofMinutes(10))
          .build();

  // Allow retrying ABORTED statuses. These will be returned by the server when the client is
  // too slow to read the rows. This makes sense for the java client because retries happen
  // after the row merging logic. Which means that the retry will not be invoked until the
  // current buffered chunks are consumed.
  private static final Set<StatusCode.Code> READ_ROWS_RETRY_CODES =
      ImmutableSet.<StatusCode.Code>builder()
          .addAll(IDEMPOTENT_RETRY_CODES)
          .add(StatusCode.Code.ABORTED)
          .build();

  // Priming request should have a shorter timeout
  private static final Duration PRIME_REQUEST_TIMEOUT = Duration.ofSeconds(30);

  private static final RetrySettings READ_ROWS_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setMaxAttempts(10)
          .setInitialRpcTimeout(Duration.ofMinutes(30))
          .setRpcTimeoutMultiplier(2.0)
          .setMaxRpcTimeout(Duration.ofMinutes(30))
          .setTotalTimeout(Duration.ofHours(12))
          .build();

  private static final RetrySettings MUTATE_ROWS_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setInitialRpcTimeout(Duration.ofMinutes(1))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofMinutes(1))
          .setTotalTimeout(Duration.ofMinutes(10))
          .build();

  private static final Set<StatusCode.Code> GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS_RETRY_CODES =
      ImmutableSet.<StatusCode.Code>builder()
          .addAll(IDEMPOTENT_RETRY_CODES)
          .add(StatusCode.Code.ABORTED)
          .build();

  private static final RetrySettings GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setMaxAttempts(10)
          .setInitialRpcTimeout(Duration.ofMinutes(1))
          .setRpcTimeoutMultiplier(2.0)
          .setMaxRpcTimeout(Duration.ofMinutes(10))
          .setTotalTimeout(Duration.ofMinutes(60))
          .build();

  // Allow retrying ABORTED statuses. These will be returned by the server when the client is
  // too slow to read the change stream records. This makes sense for the java client because
  // retries happen after the mutation merging logic. Which means that the retry will not be
  // invoked until the current buffered change stream mutations are consumed.
  private static final Set<StatusCode.Code> READ_CHANGE_STREAM_RETRY_CODES =
      ImmutableSet.<StatusCode.Code>builder()
          .addAll(IDEMPOTENT_RETRY_CODES)
          .add(StatusCode.Code.ABORTED)
          .build();

  private static final RetrySettings READ_CHANGE_STREAM_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setMaxAttempts(10)
          .setInitialRpcTimeout(Duration.ofMinutes(5))
          .setRpcTimeoutMultiplier(2.0)
          .setMaxRpcTimeout(Duration.ofMinutes(5))
          .setTotalTimeout(Duration.ofHours(12))
          .build();

  // Allow retrying ABORTED statuses. These will be returned by the server when the client is
  // too slow to read the responses.
  private static final Set<StatusCode.Code> EXECUTE_QUERY_RETRY_CODES =
      ImmutableSet.<StatusCode.Code>builder()
          .addAll(IDEMPOTENT_RETRY_CODES)
          .add(StatusCode.Code.ABORTED)
          .build();

  // We use the same configuration as READ_ROWS
  private static final RetrySettings EXECUTE_QUERY_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2.0)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          .setMaxAttempts(10)
          .setInitialRpcTimeout(Duration.ofMinutes(30))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofMinutes(30))
          .setTotalTimeout(Duration.ofHours(12))
          .build();

  // Similar to IDEMPOTENT but with a lower initial rpc timeout since we expect
  // these calls to be quick in most circumstances
  private static final RetrySettings PREPARE_QUERY_RETRY_SETTINGS =
      RetrySettings.newBuilder()
          .setInitialRetryDelay(Duration.ofMillis(10))
          .setRetryDelayMultiplier(2)
          .setMaxRetryDelay(Duration.ofMinutes(1))
          // TODO: fix the settings: initial attempt deadline: 5s, max is 20s but multiplier is 1
          .setInitialRpcTimeout(Duration.ofSeconds(5))
          .setRpcTimeoutMultiplier(1.0)
          .setMaxRpcTimeout(Duration.ofSeconds(20))
          .setTotalTimeout(Duration.ofMinutes(10))
          .build();

  final ServerStreamingCallSettings<Query, Row> readRowsSettings;
  final UnaryCallSettings<Query, Row> readRowSettings;
  final UnaryCallSettings<String, List<KeyOffset>> sampleRowKeysSettings;
  final UnaryCallSettings<RowMutation, Void> mutateRowSettings;
  final BigtableBatchingCallSettings bulkMutateRowsSettings;
  final BigtableBulkReadRowsCallSettings bulkReadRowsSettings;
  final UnaryCallSettings<ConditionalRowMutation, Boolean> checkAndMutateRowSettings;
  final UnaryCallSettings<ReadModifyWriteRow, Row> readModifyWriteRowSettings;
  final ServerStreamingCallSettings<String, Range.ByteStringRange>
      generateInitialChangeStreamPartitionsSettings;
  final ServerStreamingCallSettings<ReadChangeStreamQuery, ChangeStreamRecord>
      readChangeStreamSettings;
  final UnaryCallSettings<PingAndWarmRequest, Void> pingAndWarmSettings;
  final ServerStreamingCallSettings<BoundStatement, SqlRow> executeQuerySettings;
  final UnaryCallSettings<PrepareQueryRequest, PrepareResponse> prepareQuerySettings;

  ClientOperationSettings(Builder builder) {
    // Since point reads, streaming reads, bulk reads share the same base callable that converts
    // grpc errors into ApiExceptions, they must have the same retry codes.
    Preconditions.checkState(
        builder
            .readRowSettings
            .getRetryableCodes()
            .equals(builder.readRowsSettings.getRetryableCodes()),
        "Single ReadRow retry codes must match ReadRows retry codes");
    Preconditions.checkState(
        builder
            .bulkReadRowsSettings
            .getRetryableCodes()
            .equals(builder.readRowsSettings.getRetryableCodes()),
        "Bulk ReadRow retry codes must match ReadRows retry codes");

    // Per method settings.
    readRowsSettings = builder.readRowsSettings.build();
    readRowSettings = builder.readRowSettings.build();
    sampleRowKeysSettings = builder.sampleRowKeysSettings.build();
    mutateRowSettings = builder.mutateRowSettings.build();
    bulkMutateRowsSettings = builder.bulkMutateRowsSettings.build();
    bulkReadRowsSettings = builder.bulkReadRowsSettings.build();
    checkAndMutateRowSettings = builder.checkAndMutateRowSettings.build();
    readModifyWriteRowSettings = builder.readModifyWriteRowSettings.build();
    generateInitialChangeStreamPartitionsSettings =
        builder.generateInitialChangeStreamPartitionsSettings.build();
    readChangeStreamSettings = builder.readChangeStreamSettings.build();
    pingAndWarmSettings = builder.pingAndWarmSettings.build();
    executeQuerySettings = builder.executeQuerySettings.build();
    prepareQuerySettings = builder.prepareQuerySettings.build();
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("readRowsSettings", readRowsSettings)
        .add("readRowSettings", readRowSettings)
        .add("sampleRowKeysSettings", sampleRowKeysSettings)
        .add("mutateRowSettings", mutateRowSettings)
        .add("bulkMutateRowsSettings", bulkMutateRowsSettings)
        .add("bulkReadRowsSettings", bulkReadRowsSettings)
        .add("checkAndMutateRowSettings", checkAndMutateRowSettings)
        .add("readModifyWriteRowSettings", readModifyWriteRowSettings)
        .add(
            "generateInitialChangeStreamPartitionsSettings",
            generateInitialChangeStreamPartitionsSettings)
        .add("readChangeStreamSettings", readChangeStreamSettings)
        .add("pingAndWarmSettings", pingAndWarmSettings)
        .add("executeQuerySettings", executeQuerySettings)
        .add("prepareQuerySettings", prepareQuerySettings)
        .toString();
  }

  static class Builder {
    ServerStreamingCallSettings.Builder<Query, Row> readRowsSettings;
    UnaryCallSettings.Builder<Query, Row> readRowSettings;
    UnaryCallSettings.Builder<String, List<KeyOffset>> sampleRowKeysSettings;
    UnaryCallSettings.Builder<RowMutation, Void> mutateRowSettings;
    BigtableBatchingCallSettings.Builder bulkMutateRowsSettings;
    BigtableBulkReadRowsCallSettings.Builder bulkReadRowsSettings;
    UnaryCallSettings.Builder<ConditionalRowMutation, Boolean> checkAndMutateRowSettings;
    UnaryCallSettings.Builder<ReadModifyWriteRow, Row> readModifyWriteRowSettings;
    ServerStreamingCallSettings.Builder<String, Range.ByteStringRange>
        generateInitialChangeStreamPartitionsSettings;
    ServerStreamingCallSettings.Builder<ReadChangeStreamQuery, ChangeStreamRecord>
        readChangeStreamSettings;
    UnaryCallSettings.Builder<PingAndWarmRequest, Void> pingAndWarmSettings;
    ServerStreamingCallSettings.Builder<BoundStatement, SqlRow> executeQuerySettings;
    UnaryCallSettings.Builder<PrepareQueryRequest, PrepareResponse> prepareQuerySettings;

    Builder() {
      BigtableStubSettings.Builder baseDefaults = BigtableStubSettings.newBuilder();

      readRowsSettings = ServerStreamingCallSettings.newBuilder();

      readRowsSettings
          .setRetryableCodes(READ_ROWS_RETRY_CODES)
          .setRetrySettings(READ_ROWS_RETRY_SETTINGS)
          .setIdleTimeout(Duration.ofMinutes(5))
          .setWaitTimeout(Duration.ofMinutes(5));

      readRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      readRowSettings
          .setRetryableCodes(readRowsSettings.getRetryableCodes())
          .setRetrySettings(IDEMPOTENT_RETRY_SETTINGS);

      sampleRowKeysSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      sampleRowKeysSettings
          .setRetryableCodes(IDEMPOTENT_RETRY_CODES)
          .setRetrySettings(
              IDEMPOTENT_RETRY_SETTINGS.toBuilder()
                  .setInitialRpcTimeout(Duration.ofMinutes(5))
                  .setMaxRpcTimeout(Duration.ofMinutes(5))
                  .build());

      mutateRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyRetrySettings(baseDefaults.mutateRowSettings(), mutateRowSettings);

      long maxBulkMutateElementPerBatch = 100L;
      long maxBulkMutateOutstandingElementCount = 20_000L;

      bulkMutateRowsSettings =
          BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
              .setRetryableCodes(IDEMPOTENT_RETRY_CODES)
              .setRetrySettings(MUTATE_ROWS_RETRY_SETTINGS)
              .setBatchingSettings(
                  BatchingSettings.newBuilder()
                      .setIsEnabled(true)
                      .setElementCountThreshold(maxBulkMutateElementPerBatch)
                      .setRequestByteThreshold(20L * 1024 * 1024)
                      .setDelayThreshold(Duration.ofSeconds(1))
                      .setFlowControlSettings(
                          FlowControlSettings.newBuilder()
                              .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                              .setMaxOutstandingRequestBytes(100L * 1024 * 1024)
                              .setMaxOutstandingElementCount(maxBulkMutateOutstandingElementCount)
                              .build())
                      .build());

      long maxBulkReadElementPerBatch = 100L;
      long maxBulkReadRequestSizePerBatch = 400L * 1024L;
      long maxBulkReadOutstandingElementCount = 20_000L;

      bulkReadRowsSettings =
          BigtableBulkReadRowsCallSettings.newBuilder(new ReadRowsBatchingDescriptor())
              .setRetryableCodes(readRowsSettings.getRetryableCodes())
              .setRetrySettings(IDEMPOTENT_RETRY_SETTINGS)
              .setBatchingSettings(
                  BatchingSettings.newBuilder()
                      .setElementCountThreshold(maxBulkReadElementPerBatch)
                      .setRequestByteThreshold(maxBulkReadRequestSizePerBatch)
                      .setDelayThreshold(Duration.ofSeconds(1))
                      .setFlowControlSettings(
                          FlowControlSettings.newBuilder()
                              .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                              .setMaxOutstandingElementCount(maxBulkReadOutstandingElementCount)
                              .build())
                      .build());

      checkAndMutateRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyRetrySettings(baseDefaults.checkAndMutateRowSettings(), checkAndMutateRowSettings);

      readModifyWriteRowSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      copyRetrySettings(baseDefaults.readModifyWriteRowSettings(), readModifyWriteRowSettings);

      generateInitialChangeStreamPartitionsSettings = ServerStreamingCallSettings.newBuilder();
      generateInitialChangeStreamPartitionsSettings
          .setRetryableCodes(GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS_RETRY_CODES)
          .setRetrySettings(GENERATE_INITIAL_CHANGE_STREAM_PARTITIONS_RETRY_SETTINGS)
          .setIdleTimeout(Duration.ofMinutes(5))
          .setWaitTimeout(Duration.ofMinutes(1));

      readChangeStreamSettings = ServerStreamingCallSettings.newBuilder();
      readChangeStreamSettings
          .setRetryableCodes(READ_CHANGE_STREAM_RETRY_CODES)
          .setRetrySettings(READ_CHANGE_STREAM_RETRY_SETTINGS)
          .setIdleTimeout(Duration.ofMinutes(5))
          .setWaitTimeout(Duration.ofMinutes(1));

      pingAndWarmSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      pingAndWarmSettings.setRetrySettings(
          RetrySettings.newBuilder()
              .setMaxAttempts(1)
              .setInitialRpcTimeout(PRIME_REQUEST_TIMEOUT)
              .setMaxRpcTimeout(PRIME_REQUEST_TIMEOUT)
              .setTotalTimeout(PRIME_REQUEST_TIMEOUT)
              .build());

      executeQuerySettings = ServerStreamingCallSettings.newBuilder();
      executeQuerySettings
          .setRetryableCodes(EXECUTE_QUERY_RETRY_CODES)
          .setRetrySettings(EXECUTE_QUERY_RETRY_SETTINGS)
          .setIdleTimeout(Duration.ofMinutes(5))
          .setWaitTimeout(Duration.ofMinutes(5));

      prepareQuerySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      prepareQuerySettings
          .setRetryableCodes(IDEMPOTENT_RETRY_CODES)
          .setRetrySettings(PREPARE_QUERY_RETRY_SETTINGS);
    }

    Builder(ClientOperationSettings settings) {
      readRowsSettings = settings.readRowsSettings.toBuilder();
      readRowSettings = settings.readRowSettings.toBuilder();
      sampleRowKeysSettings = settings.sampleRowKeysSettings.toBuilder();
      mutateRowSettings = settings.mutateRowSettings.toBuilder();
      bulkMutateRowsSettings = settings.bulkMutateRowsSettings.toBuilder();
      bulkReadRowsSettings = settings.bulkReadRowsSettings.toBuilder();
      checkAndMutateRowSettings = settings.checkAndMutateRowSettings.toBuilder();
      readModifyWriteRowSettings = settings.readModifyWriteRowSettings.toBuilder();
      generateInitialChangeStreamPartitionsSettings =
          settings.generateInitialChangeStreamPartitionsSettings.toBuilder();
      readChangeStreamSettings = settings.readChangeStreamSettings.toBuilder();
      pingAndWarmSettings = settings.pingAndWarmSettings.toBuilder();
      executeQuerySettings = settings.executeQuerySettings.toBuilder();
      prepareQuerySettings = settings.prepareQuerySettings.toBuilder();
    }

    /**
     * Copies settings from unary RPC to another. This is necessary when modifying request and
     * response types while trying to retain retry settings.
     */
    private static void copyRetrySettings(
        UnaryCallSettings.Builder<?, ?> source, UnaryCallSettings.Builder<?, ?> dest) {
      dest.setRetryableCodes(source.getRetryableCodes());
      dest.setRetrySettings(source.getRetrySettings());
    }

    ClientOperationSettings build() {
      return new ClientOperationSettings(this);
    }
  }
}
