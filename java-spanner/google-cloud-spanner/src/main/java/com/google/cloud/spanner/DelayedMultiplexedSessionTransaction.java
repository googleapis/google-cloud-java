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

package com.google.cloud.spanner;

import static com.google.cloud.spanner.SessionImpl.NO_CHANNEL_HINT;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.ServerStream;
import com.google.cloud.Timestamp;
import com.google.cloud.spanner.DelayedReadContext.DelayedReadOnlyTransaction;
import com.google.cloud.spanner.MultiplexedSessionDatabaseClient.MultiplexedSessionTransaction;
import com.google.cloud.spanner.Options.TransactionOption;
import com.google.cloud.spanner.Options.UpdateOption;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.spanner.v1.BatchWriteResponse;
import java.util.concurrent.ExecutionException;

/**
 * Represents a delayed execution of a transaction on a multiplexed session. The execution is
 * delayed because the multiplexed session is not yet ready. This class is only used during client
 * creation before the multiplexed session has been created. The use of this class while the
 * multiplexed session is still being created ensures that the creation of a {@link DatabaseClient}
 * is non-blocking.
 */
class DelayedMultiplexedSessionTransaction extends AbstractMultiplexedSessionDatabaseClient {

  private final MultiplexedSessionDatabaseClient client;

  private final ISpan span;

  private final ApiFuture<SessionReference> sessionFuture;

  DelayedMultiplexedSessionTransaction(
      MultiplexedSessionDatabaseClient client,
      ISpan span,
      ApiFuture<SessionReference> sessionFuture) {
    this.client = client;
    this.span = span;
    this.sessionFuture = sessionFuture;
  }

  @Override
  public String getDatabaseRole() {
    return this.client.getDatabaseRole();
  }

  @Override
  public ReadContext singleUse() {
    return new DelayedReadContext<>(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)
                    .singleUse(),
            MoreExecutors.directExecutor()));
  }

  @Override
  public ReadContext singleUse(TimestampBound bound) {
    return new DelayedReadContext<>(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)
                    .singleUse(bound),
            MoreExecutors.directExecutor()));
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction() {
    return new DelayedReadOnlyTransaction(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)
                    .singleUseReadOnlyTransaction(),
            MoreExecutors.directExecutor()));
  }

  @Override
  public ReadOnlyTransaction singleUseReadOnlyTransaction(TimestampBound bound) {
    return new DelayedReadOnlyTransaction(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)
                    .singleUseReadOnlyTransaction(bound),
            MoreExecutors.directExecutor()));
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction() {
    return new DelayedReadOnlyTransaction(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .readOnlyTransaction(),
            MoreExecutors.directExecutor()));
  }

  @Override
  public ReadOnlyTransaction readOnlyTransaction(TimestampBound bound) {
    return new DelayedReadOnlyTransaction(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .readOnlyTransaction(bound),
            MoreExecutors.directExecutor()));
  }

  /**
   * This is a blocking method, as the interface that it implements is also defined as a blocking
   * method.
   */
  @Override
  public CommitResponse writeAtLeastOnceWithOptions(
      Iterable<Mutation> mutations, TransactionOption... options) throws SpannerException {
    SessionReference sessionReference = getSessionReference();
    try (MultiplexedSessionTransaction transaction =
        new MultiplexedSessionTransaction(
            client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)) {
      return transaction.writeAtLeastOnceWithOptions(mutations, options);
    }
  }

  // This is a blocking method, as the interface that it implements is also defined as a blocking
  // method.
  @Override
  public Timestamp write(Iterable<Mutation> mutations) throws SpannerException {
    SessionReference sessionReference = getSessionReference();
    try (MultiplexedSessionTransaction transaction =
        new MultiplexedSessionTransaction(
            client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)) {
      return transaction.write(mutations);
    }
  }

  // This is a blocking method, as the interface that it implements is also defined as a blocking
  // method.
  @Override
  public CommitResponse writeWithOptions(Iterable<Mutation> mutations, TransactionOption... options)
      throws SpannerException {
    SessionReference sessionReference = getSessionReference();
    try (MultiplexedSessionTransaction transaction =
        new MultiplexedSessionTransaction(
            client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)) {
      return transaction.writeWithOptions(mutations, options);
    }
  }

  /**
   * This is a blocking method, as the interface that it implements is also defined as a blocking
   * method.
   */
  @Override
  public ServerStream<BatchWriteResponse> batchWriteAtLeastOnce(
      Iterable<MutationGroup> mutationGroups, TransactionOption... options)
      throws SpannerException {
    SessionReference sessionReference = getSessionReference();
    try (MultiplexedSessionTransaction transaction =
        new MultiplexedSessionTransaction(
            client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)) {
      return transaction.batchWriteAtLeastOnce(mutationGroups, options);
    }
  }

  @Override
  public TransactionRunner readWriteTransaction(TransactionOption... options) {
    return new DelayedTransactionRunner(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .readWriteTransaction(options),
            MoreExecutors.directExecutor()));
  }

  @Override
  public TransactionManager transactionManager(TransactionOption... options) {
    return new DelayedTransactionManager(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .transactionManager(options),
            MoreExecutors.directExecutor()));
  }

  @Override
  public AsyncRunner runAsync(TransactionOption... options) {
    return new DelayedAsyncRunner(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .runAsync(options),
            MoreExecutors.directExecutor()));
  }

  @Override
  public AsyncTransactionManager transactionManagerAsync(TransactionOption... options) {
    return new DelayedAsyncTransactionManager(
        ApiFutures.transform(
            this.sessionFuture,
            sessionReference ->
                new MultiplexedSessionTransaction(
                        client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ false)
                    .transactionManagerAsync(options),
            MoreExecutors.directExecutor()));
  }

  /**
   * Gets the session reference that this delayed transaction is waiting for. This method should
   * only be called by methods that are allowed to be blocking.
   */
  private SessionReference getSessionReference() {
    try {
      return this.sessionFuture.get();
    } catch (ExecutionException executionException) {
      throw SpannerExceptionFactory.causeAsRunTimeException(executionException);
    } catch (InterruptedException interruptedException) {
      throw SpannerExceptionFactory.propagateInterrupt(interruptedException);
    }
  }

  /**
   * Execute `stmt` within PARTITIONED_DML transaction using multiplexed session. This method is a
   * blocking call as the interface expects to return the output of the `stmt`.
   */
  @Override
  public long executePartitionedUpdate(Statement stmt, UpdateOption... options) {
    SessionReference sessionReference = getSessionReference();
    return new MultiplexedSessionTransaction(
            client, span, sessionReference, NO_CHANNEL_HINT, /* singleUse= */ true)
        .executePartitionedUpdate(stmt, options);
  }
}
