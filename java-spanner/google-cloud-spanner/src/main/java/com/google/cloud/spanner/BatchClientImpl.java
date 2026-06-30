/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.spanner;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.cloud.spanner.AbstractReadContext.MultiUseReadOnlyTransaction;
import com.google.cloud.spanner.Options.QueryOption;
import com.google.cloud.spanner.Options.ReadOption;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.protobuf.Struct;
import com.google.spanner.v1.ExecuteSqlRequest.QueryMode;
import com.google.spanner.v1.PartitionQueryRequest;
import com.google.spanner.v1.PartitionReadRequest;
import com.google.spanner.v1.PartitionResponse;
import com.google.spanner.v1.TransactionSelector;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** Default implementation for Batch Client interface. */
public class BatchClientImpl implements BatchClient {
  private final SessionClient sessionClient;

  /** Lock to protect the multiplexed session. */
  private final ReentrantLock multiplexedSessionLock = new ReentrantLock();

  /** The duration before we try to replace the multiplexed session. The default is 7 days. */
  private final Duration sessionExpirationDuration;

  /** The expiration date/time of the current multiplexed session. */
  @GuardedBy("multiplexedSessionLock")
  private final AtomicReference<Instant> expirationDate;

  @GuardedBy("multiplexedSessionLock")
  private final AtomicReference<SessionImpl> multiplexedSessionReference;

  BatchClientImpl(SessionClient sessionClient) {
    this.sessionClient = checkNotNull(sessionClient);
    this.sessionExpirationDuration =
        Duration.ofMillis(
            sessionClient
                .getSpanner()
                .getOptions()
                .getSessionPoolOptions()
                .getMultiplexedSessionMaintenanceDuration()
                .toMillis());
    // Initialize the expiration date to the start of time to avoid unnecessary null checks.
    // This also ensured that a new session is created on first request.
    this.expirationDate = new AtomicReference<>(Instant.MIN);
    this.multiplexedSessionReference = new AtomicReference<>();
  }

  @Override
  @Nullable
  public String getDatabaseRole() {
    return this.sessionClient.getSpanner().getOptions().getDatabaseRole();
  }

  @Override
  public BatchReadOnlyTransaction batchReadOnlyTransaction(TimestampBound bound) {
    SessionImpl session = getMultiplexedSession();
    return new BatchReadOnlyTransactionImpl(
        MultiUseReadOnlyTransaction.newBuilder()
            .setSession(session)
            .setCancelQueryWhenClientIsClosed(true)
            .setRpc(sessionClient.getSpanner().getRpc())
            .setTimestampBound(bound)
            .setDefaultQueryOptions(
                sessionClient.getSpanner().getDefaultQueryOptions(sessionClient.getDatabaseId()))
            .setExecutorProvider(sessionClient.getSpanner().getAsyncExecutorProvider())
            .setDefaultPrefetchChunks(sessionClient.getSpanner().getDefaultPrefetchChunks())
            .setDefaultDecodeMode(sessionClient.getSpanner().getDefaultDecodeMode())
            .setDefaultDirectedReadOptions(
                sessionClient.getSpanner().getOptions().getDirectedReadOptions())
            .setSpan(sessionClient.getSpanner().getTracer().getCurrentSpan())
            .setTracer(sessionClient.getSpanner().getTracer()),
        checkNotNull(bound));
  }

  @Override
  public BatchReadOnlyTransaction batchReadOnlyTransaction(BatchTransactionId batchTransactionId) {
    SessionImpl session =
        sessionClient.sessionWithId(checkNotNull(batchTransactionId).getSessionId());
    return new BatchReadOnlyTransactionImpl(
        MultiUseReadOnlyTransaction.newBuilder()
            .setSession(session)
            .setCancelQueryWhenClientIsClosed(true)
            .setRpc(sessionClient.getSpanner().getRpc())
            .setTransactionId(batchTransactionId.getTransactionId())
            .setTimestamp(batchTransactionId.getTimestamp())
            .setDefaultQueryOptions(
                sessionClient.getSpanner().getDefaultQueryOptions(sessionClient.getDatabaseId()))
            .setExecutorProvider(sessionClient.getSpanner().getAsyncExecutorProvider())
            .setDefaultPrefetchChunks(sessionClient.getSpanner().getDefaultPrefetchChunks())
            .setDefaultDecodeMode(sessionClient.getSpanner().getDefaultDecodeMode())
            .setDefaultDirectedReadOptions(
                sessionClient.getSpanner().getOptions().getDirectedReadOptions())
            .setSpan(sessionClient.getSpanner().getTracer().getCurrentSpan())
            .setTracer(sessionClient.getSpanner().getTracer()),
        batchTransactionId);
  }

  private SessionImpl getMultiplexedSession() {
    this.multiplexedSessionLock.lock();
    try {
      if (Clock.systemUTC().instant().isAfter(this.expirationDate.get())
          || this.multiplexedSessionReference.get() == null) {
        this.multiplexedSessionReference.set(this.sessionClient.createMultiplexedSession());
        this.expirationDate.set(Clock.systemUTC().instant().plus(this.sessionExpirationDuration));
      }
      return this.multiplexedSessionReference.get();
    } finally {
      this.multiplexedSessionLock.unlock();
    }
  }

  private static class BatchReadOnlyTransactionImpl extends MultiUseReadOnlyTransaction
      implements BatchReadOnlyTransaction {
    private final String sessionName;
    private final Map<SpannerRpc.Option, ?> options;

    BatchReadOnlyTransactionImpl(
        MultiUseReadOnlyTransaction.Builder builder, TimestampBound bound) {
      super(builder.setTimestampBound(bound));
      this.sessionName = session.getName();
      this.options = session.getOptions();
      initTransaction();
    }

    BatchReadOnlyTransactionImpl(
        MultiUseReadOnlyTransaction.Builder builder, BatchTransactionId batchTransactionId) {
      super(builder.setTransactionId(batchTransactionId.getTransactionId()));
      this.sessionName = session.getName();
      this.options = session.getOptions();
    }

    @Override
    public BatchTransactionId getBatchTransactionId() {
      return new BatchTransactionId(sessionName, getTransactionId(), getReadTimestamp());
    }

    @Override
    public List<Partition> partitionRead(
        PartitionOptions partitionOptions,
        String table,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... options)
        throws SpannerException {
      return partitionReadUsingIndex(
          partitionOptions, table, null /*index*/, keys, columns, options);
    }

    @Override
    public List<Partition> partitionReadUsingIndex(
        PartitionOptions partitionOptions,
        String table,
        String index,
        KeySet keys,
        Iterable<String> columns,
        ReadOption... option)
        throws SpannerException {
      Options readOptions = Options.fromReadOptions(option);
      Preconditions.checkArgument(
          !readOptions.hasLimit(),
          "Limit option not supported by partitionRead|partitionReadUsingIndex");
      final PartitionReadRequest.Builder builder =
          PartitionReadRequest.newBuilder()
              .setSession(sessionName)
              .setTable(checkNotNull(table))
              .addAllColumns(columns);
      keys.appendToProto(builder.getKeySetBuilder());
      if (index != null) {
        builder.setIndex(index);
      }
      TransactionSelector selector = getTransactionSelector();
      if (selector != null) {
        builder.setTransaction(selector);
      }
      com.google.spanner.v1.PartitionOptions.Builder pbuilder =
          com.google.spanner.v1.PartitionOptions.newBuilder();
      if (partitionOptions != null) {
        partitionOptions.appendToProto(pbuilder);
      }
      builder.setPartitionOptions(pbuilder.build());

      final PartitionReadRequest request = builder.build();
      PartitionResponse response = rpc.partitionRead(request, options);
      ImmutableList.Builder<Partition> partitions = ImmutableList.builder();
      for (com.google.spanner.v1.Partition p : response.getPartitionsList()) {
        Partition partition =
            Partition.createReadPartition(
                p.getPartitionToken(), partitionOptions, table, index, keys, columns, readOptions);
        partitions.add(partition);
      }
      return partitions.build();
    }

    @Override
    public List<Partition> partitionQuery(
        PartitionOptions partitionOptions, Statement statement, QueryOption... option)
        throws SpannerException {
      return partitionQuery(partitionOptions, statement, false, option);
    }

    private List<Partition> partitionQuery(
        PartitionOptions partitionOptions,
        Statement statement,
        boolean isFallback,
        QueryOption... option)
        throws SpannerException {
      Options queryOptions = Options.fromQueryOptions(option);
      final PartitionQueryRequest.Builder builder =
          PartitionQueryRequest.newBuilder().setSession(sessionName).setSql(statement.getSql());
      Map<String, Value> stmtParameters = statement.getParameters();
      if (!stmtParameters.isEmpty()) {
        Struct.Builder paramsBuilder = builder.getParamsBuilder();
        for (Map.Entry<String, Value> param : stmtParameters.entrySet()) {
          paramsBuilder.putFields(param.getKey(), Value.toProto(param.getValue()));
          if (param.getValue() != null && param.getValue().getType() != null) {
            builder.putParamTypes(param.getKey(), param.getValue().getType().toProto());
          }
        }
      }
      TransactionSelector selector = getTransactionSelector();
      if (selector != null) {
        builder.setTransaction(selector);
      }
      com.google.spanner.v1.PartitionOptions.Builder pbuilder =
          com.google.spanner.v1.PartitionOptions.newBuilder();
      if (partitionOptions != null) {
        partitionOptions.appendToProto(pbuilder);
      }
      builder.setPartitionOptions(pbuilder.build());

      final PartitionQueryRequest request = builder.build();
      PartitionResponse response = rpc.partitionQuery(request, options);
      ImmutableList.Builder<Partition> partitions = ImmutableList.builder();
      for (com.google.spanner.v1.Partition p : response.getPartitionsList()) {
        Partition partition =
            Partition.createQueryPartition(
                p.getPartitionToken(), partitionOptions, statement, queryOptions);
        partitions.add(partition);
      }
      return partitions.build();
    }

    @Override
    public ResultSet execute(Partition partition) throws SpannerException {
      if (partition.getStatement() != null) {
        return executeQueryInternalWithOptions(
            partition.getStatement(),
            QueryMode.NORMAL,
            partition.getQueryOptions(),
            partition.getPartitionToken());
      }
      return readInternalWithOptions(
          partition.getTable(),
          partition.getIndex(),
          partition.getKeys(),
          partition.getColumns(),
          partition.getReadOptions(),
          partition.getPartitionToken());
    }

    /**
     * Closes the session as part of the cleanup. It is the responsibility of the caller to make a
     * call to this method once the transaction completes execution across all the channels (which
     * is understandably hard to identify). It is okay if the caller does not call the method
     * because the backend will anyways clean up the unused session.
     */
    @Override
    public void cleanup() {
      session.close();
    }
  }
}
