/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.firestore;

import static com.google.cloud.firestore.BulkWriterOperation.DEFAULT_BACKOFF_MAX_DELAY_MS;
import static com.google.cloud.firestore.telemetry.TraceUtil.ATTRIBUTE_KEY_DOC_COUNT;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.cloud.firestore.telemetry.MetricsUtil.MetricsContext;
import com.google.cloud.firestore.telemetry.TelemetryConstants;
import com.google.cloud.firestore.telemetry.TraceUtil;
import com.google.cloud.firestore.telemetry.TraceUtil.Context;
import com.google.cloud.firestore.telemetry.TraceUtil.Scope;
import com.google.cloud.firestore.v1.FirestoreSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/** A Firestore BulkWriter that can be used to perform a large number of writes in parallel. */
public final class BulkWriter implements AutoCloseable {
  /**
   * A callback set by `addWriteResultListener()` to be run every time an operation successfully
   * completes.
   */
  public interface WriteResultCallback {
    /**
     * @param documentReference The document the operation was performed on.
     * @param result The result of the operation.
     */
    void onResult(DocumentReference documentReference, WriteResult result);
  }

  /**
   * A callback set by `addWriteErrorListener()` to be run every time an operation fails and
   * determines if an operation should be retried.
   */
  public interface WriteErrorCallback {
    /**
     * @param error The error object from the failed BulkWriter operation attempt.
     * @return Whether to retry the operation or not.
     */
    boolean onError(BulkWriterException error);
  }

  enum OperationType {
    CREATE,
    SET,
    UPDATE,
    DELETE
  }

  /** The maximum number of writes that can be in a single batch. */
  public static final int MAX_BATCH_SIZE = 20;

  /** The maximum number of writes that can be in a batch containing retries. */
  public static final int RETRY_MAX_BATCH_SIZE = 10;

  /**
   * The maximum number of retries that will be attempted with backoff before stopping all retry
   * attempts.
   */
  public static final int MAX_RETRY_ATTEMPTS = 10;

  /**
   * The starting maximum number of operations per second as allowed by the 500/50/5 rule.
   *
   * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping
   *     up traffic</a>
   */
  static final int DEFAULT_STARTING_MAXIMUM_OPS_PER_SECOND = 500;

  /**
   * The rate by which to increase the capacity as specified by the 500/50/5 rule.
   *
   * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping
   *     up traffic</a>
   */
  private static final double RATE_LIMITER_MULTIPLIER = 1.5;

  /**
   * How often the operations per second capacity should increase in milliseconds as specified by
   * the 500/50/5 rule.
   *
   * @see <a href=https://cloud.google.com/firestore/docs/best-practices#ramping_up_traffic>Ramping
   *     up traffic</a>
   */
  private static final int RATE_LIMITER_MULTIPLIER_MILLIS = 5 * 60 * 1000;

  /**
   * The default maximum number of pending operations that can be enqueued onto a BulkWriter
   * instance. An operation is considered pending if BulkWriter has sent it via RPC and is awaiting
   * the result. BulkWriter buffers additional writes after this many pending operations in order to
   * avoiding going OOM.
   */
  private static final int DEFAULT_MAXIMUM_PENDING_OPERATIONS_COUNT = 500;

  /**
   * The default jitter to apply to the exponential backoff used in retries. For example, a factor
   * of 0.3 means a 30% jitter is applied.
   */
  static final double DEFAULT_JITTER_FACTOR = 0.3;

  private static final WriteResultCallback DEFAULT_SUCCESS_LISTENER =
      (documentReference, result) -> {};

  private static final WriteErrorCallback DEFAULT_ERROR_LISTENER =
      error -> {
        if (error.getFailedAttempts() > MAX_RETRY_ATTEMPTS) {
          return false;
        }
        Set<Code> codes = FirestoreSettings.newBuilder().batchWriteSettings().getRetryableCodes();
        for (Code code : codes) {
          if (code.equals(Code.valueOf(error.getStatus().getCode().name()))) {
            return true;
          }
        }
        return false;
      };

  private static final Logger logger = Logger.getLogger(BulkWriter.class.getName());

  private final FirestoreImpl firestore;

  // Executor used to run all BulkWriter operations. BulkWriter uses its own executor since we
  // don't want to block a gax/grpc executor while running user error and success callbacks.
  private final ScheduledExecutorService bulkWriterExecutor;

  /** The maximum number of writes that can be in a single batch. */
  private int maxBatchSize = MAX_BATCH_SIZE;

  /**
   * Lock object for all mutable state in bulk writer. BulkWriter state is accessed from the user
   * thread and via {@code bulkWriterExecutor}.
   */
  private final Object lock = new Object();

  /** Rate limiter used to throttle requests as per the 500/50/5 rule. */
  @GuardedBy("lock")
  private final RateLimiter rateLimiter;

  /**
   * The number of pending operations enqueued on this BulkWriter instance. An operation is
   * considered pending if BulkWriter has sent it via RPC and is awaiting the result.
   */
  @GuardedBy("lock")
  private int pendingOpsCount = 0;

  /**
   * An array containing buffered BulkWriter operations after the maximum number of pending
   * operations has been enqueued.
   */
  @GuardedBy("lock")
  private final List<Runnable> bufferedOperations = new ArrayList<>();

  /**
   * The maximum number of pending operations that can be enqueued onto this BulkWriter instance.
   * Once the this number of writes have been enqueued, subsequent writes are buffered.
   */
  private int maxPendingOpCount = DEFAULT_MAXIMUM_PENDING_OPERATIONS_COUNT;

  /**
   * The batch that is currently used to schedule operations. Once this batch reaches maximum
   * capacity, a new batch is created.
   *
   * <p>Access to the BulkCommitBatch should only occur under lock as it can be accessed by both the
   * user thread as well as by the backoff logic in BulkWriter.
   */
  @GuardedBy("lock")
  private BulkCommitBatch bulkCommitBatch;

  /**
   * A pointer to the tail of all active BulkWriter applications. This pointer is advanced every
   * time a new write is enqueued.
   */
  @GuardedBy("lock")
  private ApiFuture<Void> lastOperation = ApiFutures.immediateFuture(null);

  /** Whether this BulkWriter instance is closed. Once closed, it cannot be opened again. */
  @GuardedBy("lock")
  private boolean closed = false;

  @GuardedBy("lock")
  private WriteResultCallback successListener = DEFAULT_SUCCESS_LISTENER;

  @GuardedBy("lock")
  private WriteErrorCallback errorListener = DEFAULT_ERROR_LISTENER;

  @GuardedBy("lock")
  private Executor successExecutor;

  @GuardedBy("lock")
  private Executor errorExecutor;

  Context traceContext;

  /**
   * Used to track when writes are enqueued. The user handler executors cannot be changed after a
   * write has been enqueued.
   */
  @GuardedBy("lock")
  private boolean writesEnqueued = false;

  BulkWriter(FirestoreImpl firestore, BulkWriterOptions options) {
    this.firestore = firestore;
    this.bulkWriterExecutor =
        options.getExecutor() != null
            ? options.getExecutor()
            : Executors.newSingleThreadScheduledExecutor();
    this.successExecutor = MoreExecutors.directExecutor();
    this.errorExecutor = MoreExecutors.directExecutor();
    this.bulkCommitBatch = new BulkCommitBatch(firestore, bulkWriterExecutor, maxBatchSize);
    this.traceContext = firestore.getOptions().getTraceUtil().currentContext();

    if (!options.getThrottlingEnabled()) {
      this.rateLimiter =
          new RateLimiter(
              Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE);
    } else {
      double startingRate = DEFAULT_STARTING_MAXIMUM_OPS_PER_SECOND;
      double maxRate = Double.POSITIVE_INFINITY;

      if (options.getInitialOpsPerSecond() != null) {
        startingRate = options.getInitialOpsPerSecond();
      }

      if (options.getMaxOpsPerSecond() != null) {
        maxRate = options.getMaxOpsPerSecond();
      }

      // The initial validation step ensures that the maxOpsPerSecond is greater than
      // initialOpsPerSecond. If this inequality is true, that means initialOpsPerSecond was not
      // set and maxOpsPerSecond is less than the default starting rate.
      if (maxRate < startingRate) {
        startingRate = maxRate;
      }

      // Ensure that the batch size is not larger than the number of allowed
      // operations per second.
      if (startingRate < maxBatchSize) {
        this.maxBatchSize = (int) startingRate;
      }

      this.rateLimiter =
          new RateLimiter(
              (int) startingRate,
              RATE_LIMITER_MULTIPLIER,
              RATE_LIMITER_MULTIPLIER_MILLIS,
              (int) maxRate);
    }
  }

  /**
   * Create a document with the provided data. This single operation will fail if a document exists
   * at its location.
   *
   * @param documentReference A reference to the document to be created.
   * @param fields A map of the fields and values for the document.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> create(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Map<String, Object> fields) {
    return executeWrite(
        documentReference, OperationType.CREATE, batch -> batch.create(documentReference, fields));
  }

  /**
   * Create a document with the provided data. This single operation will fail if a document exists
   * at its location.
   *
   * @param documentReference A reference to the document to be created.
   * @param pojo The POJO that will be used to populate the document contents.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> create(
      @Nonnull final DocumentReference documentReference, @Nonnull final Object pojo) {
    return executeWrite(
        documentReference, OperationType.CREATE, batch -> batch.create(documentReference, pojo));
  }

  /**
   * Delete a document from the database.
   *
   * @param documentReference The DocumentReference to delete.
   * @return An ApiFuture containing a sentinel value (Timestamp(0)) for the delete operation.
   *     Contains a {@link BulkWriterException} if the delete fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> delete(@Nonnull final DocumentReference documentReference) {
    return executeWrite(
        documentReference, OperationType.DELETE, batch -> batch.delete(documentReference));
  }

  /**
   * Delete a document from the database.
   *
   * @param documentReference The DocumentReference to delete.
   * @param precondition Precondition to enforce for this delete.
   * @return An ApiFuture containing a sentinel value (Timestamp(0)) for the delete operation.
   *     Contains a {@link BulkWriterException} if the delete fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> delete(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Precondition precondition) {
    return executeWrite(
        documentReference,
        OperationType.DELETE,
        batch -> batch.delete(documentReference, precondition));
  }

  /**
   * Write to the document referred to by the provided DocumentReference. If the document does not
   * exist yet, it will be created.
   *
   * @param documentReference A reference to the document to be set.
   * @param fields A map of the fields and values for the document.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> set(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Map<String, Object> fields) {
    return executeWrite(
        documentReference, OperationType.SET, batch -> batch.set(documentReference, fields));
  }

  /**
   * Write to the document referred to by the provided DocumentReference. If the document does not
   * exist yet, it will be created. If you pass a {@link SetOptions}, the provided data can be
   * merged into an existing document.
   *
   * @param documentReference A reference to the document to be set.
   * @param fields A map of the fields and values for the document.
   * @param options An object to configure the set behavior.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> set(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Map<String, Object> fields,
      @Nonnull final SetOptions options) {
    return executeWrite(
        documentReference,
        OperationType.SET,
        batch -> batch.set(documentReference, fields, options));
  }

  /**
   * Write to the document referred to by the provided DocumentReference. If the document does not
   * exist yet, it will be created. If you pass a {@link SetOptions}, the provided data can be
   * merged into an existing document.
   *
   * @param documentReference A reference to the document to be set.
   * @param pojo The POJO that will be used to populate the document contents.
   * @param options An object to configure the set behavior.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> set(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Object pojo,
      @Nonnull final SetOptions options) {
    return executeWrite(
        documentReference, OperationType.SET, batch -> batch.set(documentReference, pojo, options));
  }

  /**
   * Write to the document referred to by the provided DocumentReference. If the document does not
   * exist yet, it will be created.
   *
   * @param documentReference A reference to the document to be set.
   * @param pojo The POJO that will be used to populate the document contents.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> set(
      @Nonnull final DocumentReference documentReference, @Nonnull final Object pojo) {
    return executeWrite(
        documentReference, OperationType.SET, batch -> batch.set(documentReference, pojo));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param fields A map of the fields and values for the document.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Map<String, Object> fields) {
    return executeWrite(
        documentReference, OperationType.UPDATE, batch -> batch.update(documentReference, fields));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param fields A map of the fields and values for the document.
   * @param precondition Precondition to enforce on this update.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Map<String, Object> fields,
      @Nonnull final Precondition precondition) {
    return executeWrite(
        documentReference,
        OperationType.UPDATE,
        batch -> batch.update(documentReference, fields, precondition));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param field The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final String field,
      @Nullable final Object value,
      final Object... moreFieldsAndValues) {
    return executeWrite(
        documentReference,
        OperationType.UPDATE,
        batch -> batch.update(documentReference, field, value, moreFieldsAndValues));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param fieldPath The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final FieldPath fieldPath,
      @Nullable final Object value,
      final Object... moreFieldsAndValues) {
    return executeWrite(
        documentReference,
        OperationType.UPDATE,
        batch -> batch.update(documentReference, fieldPath, value, moreFieldsAndValues));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param field The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Precondition precondition,
      @Nonnull final String field,
      @Nullable final Object value,
      final Object... moreFieldsAndValues) {
    return executeWrite(
        documentReference,
        OperationType.UPDATE,
        batch -> batch.update(documentReference, precondition, field, value, moreFieldsAndValues));
  }

  /**
   * Update fields of the document referred to by the provided {@link DocumentReference}. If the
   * document doesn't yet exist, the update will fail.
   *
   * <p>The update() method accepts either an object with field paths encoded as keys and field
   * values encoded as values, or a variable number of arguments that alternate between field paths
   * and field values. Nested fields can be updated by providing dot-separated field path strings or
   * by providing FieldPath objects.
   *
   * @param documentReference A reference to the document to be updated.
   * @param precondition Precondition to enforce on this update.
   * @param fieldPath The first field to set.
   * @param value The first value to set.
   * @param moreFieldsAndValues String and Object pairs with more fields to be set.
   * @return An ApiFuture containing the result of the write. Contains a {@link BulkWriterException}
   *     if the write fails.
   */
  @Nonnull
  public ApiFuture<WriteResult> update(
      @Nonnull final DocumentReference documentReference,
      @Nonnull final Precondition precondition,
      @Nonnull final FieldPath fieldPath,
      @Nullable final Object value,
      final Object... moreFieldsAndValues) {
    return executeWrite(
        documentReference,
        OperationType.UPDATE,
        batch ->
            batch.update(documentReference, precondition, fieldPath, value, moreFieldsAndValues));
  }

  /**
   * Schedules the provided write operation and runs the user success callback when the write result
   * is obtained.
   */
  private ApiFuture<WriteResult> executeWrite(
      final DocumentReference documentReference,
      final OperationType operationType,
      final ApiFunction<BulkCommitBatch, ApiFuture<WriteResult>> enqueueOperationOnBatchCallback) {
    final BulkWriterOperation operation =
        new BulkWriterOperation(
            documentReference,
            operationType,
            op -> {
              synchronized (lock) {
                sendOperationLocked(enqueueOperationOnBatchCallback, op);
              }
              return null;
            },
            writeResult -> {
              synchronized (lock) {
                return invokeUserSuccessCallbackLocked(documentReference, writeResult);
              }
            },
            e -> {
              synchronized (lock) {
                return invokeUserErrorCallbackLocked(e);
              }
            });

    synchronized (lock) {
      verifyNotClosedLocked();
      writesEnqueued = true;

      // Advance the lastOperation pointer. This ensures that lastOperation only completes when
      // both the previous and the current write complete.
      lastOperation =
          ApiFutures.transformAsync(
              lastOperation,
              aVoid -> silenceFuture(operation.getFuture()),
              MoreExecutors.directExecutor());

      // Schedule the operation if the BulkWriter has fewer than the maximum number of allowed
      // pending operations, or add the operation to the buffer.
      if (pendingOpsCount < maxPendingOpCount) {
        pendingOpsCount++;
        sendOperationLocked(enqueueOperationOnBatchCallback, operation);
      } else {
        bufferedOperations.add(
            () -> {
              synchronized (lock) {
                pendingOpsCount++;
                sendOperationLocked(enqueueOperationOnBatchCallback, operation);
              }
            });
      }
    }

    ApiFuture<WriteResult> processedOperationFuture =
        ApiFutures.transformAsync(
            operation.getFuture(),
            result -> {
              pendingOpsCount--;
              processBufferedOperations();
              return ApiFutures.immediateFuture(result);
            },
            MoreExecutors.directExecutor());

    return ApiFutures.catchingAsync(
        processedOperationFuture,
        ApiException.class,
        e -> {
          pendingOpsCount--;
          processBufferedOperations();
          throw e;
        },
        MoreExecutors.directExecutor());
  }

  /**
   * Manages the pending operation counter and schedules the next BulkWriter operation if we're
   * under the maximum limit.
   */
  private void processBufferedOperations() {
    if (pendingOpsCount < maxPendingOpCount && bufferedOperations.size() > 0) {
      Runnable nextOp = bufferedOperations.remove(0);
      nextOp.run();
    }
  }

  /**
   * Commits all writes that have been enqueued up to this point in parallel.
   *
   * <p>Returns an ApiFuture that completes when all currently queued operations have been
   * committed. The ApiFuture will never return an error since the results for each individual
   * operation are conveyed via their individual ApiFutures.
   *
   * <p>The ApiFuture completes immediately if there are no pending writes. Otherwise, the ApiFuture
   * waits for all previously issued writes, but it does not wait for writes that were added after
   * the method is called. If you want to wait for additional writes, call `flush()` again.
   *
   * @return An ApiFuture that completes when all enqueued writes up to this point have been
   *     committed.
   */
  @Nonnull
  public ApiFuture<Void> flush() {
    synchronized (lock) {
      return flushLocked();
    }
  }

  private ApiFuture<Void> flushLocked() {
    verifyNotClosedLocked();
    scheduleCurrentBatchLocked(/* flush= */ true);
    return lastOperation;
  }

  /**
   * Commits all enqueued writes and marks the BulkWriter instance as closed.
   *
   * <p>After calling `close()`, calling any method will return an error. Any retries scheduled with
   * `addWriteErrorListener()` will be run before `close()` completes.
   *
   * <p>This method completes when there are no more pending writes. Calling this method will send
   * all requests.
   */
  public void close() throws InterruptedException, ExecutionException {
    ApiFuture<Void> flushFuture;
    synchronized (lock) {
      flushFuture = flushLocked();
      closed = true;
    }
    flushFuture.get();
  }

  /**
   * Used for verifying that the BulkWriter instance isn't closed when calling from outside this
   * class.
   */
  void verifyNotClosed() {
    synchronized (lock) {
      verifyNotClosedLocked();
    }
  }

  void verifyNotClosedLocked() {
    if (this.closed) {
      throw new IllegalStateException("BulkWriter has already been closed.");
    }
  }

  /**
   * Attaches a listener that is run every time a BulkWriter operation successfully completes. The
   * listener will be run before `close()` completes.
   *
   * <p>For example, see the sample code: <code>
   *   BulkWriter bulkWriter = firestore.bulkWriter();
   *   bulkWriter.addWriteResultListener(
   *         (DocumentReference documentReference, WriteResult result) -> {
   *             System.out.println(
   *                 "Successfully executed write on document: "
   *                     + documentReference
   *                     + " at: "
   *                     + result.getUpdateTime());
   *           }
   *         );
   * </code>
   *
   * @param writeResultCallback A callback to be called every time a BulkWriter operation
   *     successfully completes.
   */
  public void addWriteResultListener(WriteResultCallback writeResultCallback) {
    synchronized (lock) {
      successListener = writeResultCallback;
    }
  }

  /**
   * Attaches a listener that is run every time a BulkWriter operation successfully completes.
   *
   * <p>The executor cannot be changed once writes have been enqueued onto the BulkWriter.
   *
   * <p>For example, see the sample code:
   *
   * <pre>{@code
   * BulkWriter bulkWriter = firestore.bulkWriter();
   * bulkWriter.addWriteResultListener(
   *       (DocumentReference documentReference, WriteResult result) -> {
   *           System.out.println(
   *               "Successfully executed write on document: "
   *                   + documentReference
   *                   + " at: "
   *                   + result.getUpdateTime());
   *         }
   *       );
   * }</pre>
   *
   * @param executor The executor to run the provided callback on.
   * @param writeResultCallback A callback to be called every time a BulkWriter operation
   *     successfully completes.
   */
  public void addWriteResultListener(
      @Nonnull Executor executor, WriteResultCallback writeResultCallback) {
    synchronized (lock) {
      if (writesEnqueued) {
        throw new IllegalStateException(
            "The executor cannot be changed once writes have been enqueued.");
      }
      successListener = writeResultCallback;
      successExecutor = executor;
    }
  }

  /**
   * Attaches an error handler listener that is run every time a BulkWriter operation fails.
   *
   * <p>BulkWriter has a default error handler that retries UNAVAILABLE and ABORTED errors up to a
   * maximum of 10 failed attempts. When an error handler is specified, the default error handler
   * will be overwritten.
   *
   * <p>For example, see the sample code:
   *
   * <pre>{@code
   * BulkWriter bulkWriter = firestore.bulkWriter();
   * bulkWriter.addWriteErrorListener(
   *       (BulkWriterException error) -> {
   *         if (error.getStatus() == Status.UNAVAILABLE
   *           && error.getFailedAttempts() < MAX_RETRY_ATTEMPTS) {
   *           return true;
   *         } else {
   *           System.out.println("Failed write at document: " + error.getDocumentReference());
   *           return false;
   *         }
   *       }
   *     );
   * }</pre>
   *
   * @param onError A callback to be called every time a BulkWriter operation fails. Returning
   *     `true` will retry the operation. Returning `false` will stop the retry loop.
   */
  public void addWriteErrorListener(WriteErrorCallback onError) {
    synchronized (lock) {
      errorListener = onError;
    }
  }

  /**
   * Attaches an error handler listener that is run every time a BulkWriter operation fails.
   *
   * <p>The executor cannot be changed once writes have been enqueued onto the BulkWriter.
   *
   * <p>BulkWriter has a default error handler that retries UNAVAILABLE and ABORTED errors up to a
   * maximum of 10 failed attempts. When an error handler is specified, the default error handler
   * will be overwritten.
   *
   * <p>For example, see the sample code:
   *
   * <pre>{@code
   * BulkWriter bulkWriter = firestore.bulkWriter();
   * bulkWriter.addWriteErrorListener(
   *       (BulkWriterException error) -> {
   *         if (error.getStatus() == Status.UNAVAILABLE
   *           && error.getFailedAttempts() < MAX_RETRY_ATTEMPTS) {
   *           return true;
   *         } else {
   *           System.out.println("Failed write at document: " + error.getDocumentReference());
   *           return false;
   *         }
   *       }
   *     );
   * }</pre>
   *
   * @param executor The executor to run the provided callback on.
   * @param onError A callback to be called every time a BulkWriter operation fails. Returning
   *     `true` will retry the operation. Returning `false` will stop the retry loop.
   */
  public void addWriteErrorListener(@Nonnull Executor executor, WriteErrorCallback onError) {
    synchronized (lock) {
      if (writesEnqueued) {
        throw new IllegalStateException(
            "The executor cannot be changed once writes have been enqueued.");
      }
      errorListener = onError;
      errorExecutor = executor;
    }
  }

  /**
   * Sends the current batch and resets {@link #bulkCommitBatch}.
   *
   * @param flush If provided, keeps re-sending operations until no more operations are enqueued.
   *     This allows retries to resolve as part of a {@link BulkWriter#flush()} or {@link
   *     BulkWriter#close()} call.
   */
  private void scheduleCurrentBatchLocked(final boolean flush) {
    if (bulkCommitBatch.getMutationsSize() == 0) return;

    final BulkCommitBatch pendingBatch = bulkCommitBatch;
    bulkCommitBatch = new BulkCommitBatch(firestore, bulkWriterExecutor, maxBatchSize);

    // Use the write with the longest backoff duration when determining backoff.
    int highestBackoffDuration = 0;
    for (BulkWriterOperation op : pendingBatch.pendingOperations) {
      if (op.getBackoffDuration() > highestBackoffDuration) {
        highestBackoffDuration = op.getBackoffDuration();
      }
    }
    final int backoffMsWithJitter = applyJitter(highestBackoffDuration);

    bulkWriterExecutor.schedule(
        () -> {
          synchronized (lock) {
            sendBatchLocked(pendingBatch, flush);
          }
        },
        backoffMsWithJitter,
        TimeUnit.MILLISECONDS);
  }

  /** Sends the provided batch once the rate limiter does not require any delay. */
  private void sendBatchLocked(final BulkCommitBatch batch, final boolean flush) {
    // Send the batch if it does not require any delay, or schedule another attempt after the
    // appropriate timeout.
    boolean underRateLimit = rateLimiter.tryMakeRequest(batch.getMutationsSize());
    if (underRateLimit) {
      TraceUtil.Span span =
          firestore
              .getOptions()
              .getTraceUtil()
              .startSpan(TelemetryConstants.METHOD_NAME_BULK_WRITER_COMMIT, traceContext)
              .setAttribute(ATTRIBUTE_KEY_DOC_COUNT, batch.getMutationsSize());

      MetricsContext metricsContext =
          firestore
              .getOptions()
              .getMetricsUtil()
              .createMetricsContext(TelemetryConstants.METHOD_NAME_BULK_WRITER_COMMIT);

      try (Scope ignored = span.makeCurrent()) {
        ApiFuture<Void> result = batch.bulkCommit();
        result.addListener(
            () -> {
              if (flush) {
                synchronized (lock) {
                  scheduleCurrentBatchLocked(/* flush= */ true);
                }
              }
            },
            bulkWriterExecutor);
        span.endAtFuture(result);
        metricsContext.recordEndToEndLatencyAtFuture(result);
      } catch (Exception error) {
        span.end(error);
        metricsContext.recordEndToEndLatency(error);
        throw error;
      }
    } else {
      long delayMs = rateLimiter.getNextRequestDelayMs(batch.getMutationsSize());
      logger.log(Level.FINE, () -> String.format("Backing off for %d seconds", delayMs / 1000));
      bulkWriterExecutor.schedule(
          () -> {
            synchronized (lock) {
              sendBatchLocked(batch, flush);
            }
          },
          delayMs,
          TimeUnit.MILLISECONDS);
    }
  }

  @VisibleForTesting
  void setMaxBatchSize(int size) {
    Preconditions.checkState(
        bulkCommitBatch.getMutationsSize() == 0, "BulkCommitBatch should be empty");
    maxBatchSize = size;
    bulkCommitBatch = new BulkCommitBatch(firestore, bulkWriterExecutor, size);
  }

  @VisibleForTesting
  RateLimiter getRateLimiter() {
    return rateLimiter;
  }

  @VisibleForTesting
  int getBufferedOperationsCount() {
    return bufferedOperations.size();
  }

  @VisibleForTesting
  void setMaxPendingOpCount(int newMax) {
    maxPendingOpCount = newMax;
  }

  /**
   * Schedules the provided operations on the current BulkCommitBatch. Sends the BulkCommitBatch if
   * it reaches maximum capacity.
   */
  private void sendOperationLocked(
      ApiFunction<BulkCommitBatch, ApiFuture<WriteResult>> enqueueOperationOnBatchCallback,
      final BulkWriterOperation op) {
    // A backoff duration greater than 0 implies that this batch is a retry.
    // Retried writes are sent with a batch size of 10 in order to guarantee
    // that the batch is under the 10MiB limit.
    if (op.getBackoffDuration() > 0) {
      if (bulkCommitBatch.getMutationsSize() >= RETRY_MAX_BATCH_SIZE) {
        scheduleCurrentBatchLocked(/* flush= */ false);
      }
      bulkCommitBatch.setMaxBatchSize(RETRY_MAX_BATCH_SIZE);
    }

    if (bulkCommitBatch.has(op.getDocumentReference())) {
      // Create a new batch since the backend doesn't support batches with two writes to the same
      // document.
      scheduleCurrentBatchLocked(/* flush= */ false);
    }

    // Run the operation on the current batch and advance the `lastOperation` pointer. This
    // ensures that `lastOperation` only resolves when both the previous and the current write
    // resolves.
    bulkCommitBatch.enqueueOperation(op);
    enqueueOperationOnBatchCallback.apply(bulkCommitBatch);

    if (bulkCommitBatch.getMutationsSize() == bulkCommitBatch.getMaxBatchSize()) {
      scheduleCurrentBatchLocked(/* flush= */ false);
    }
  }

  /** Invokes the user error callback on the user callback executor and returns the result. */
  private SettableApiFuture<Boolean> invokeUserErrorCallbackLocked(
      final BulkWriterException error) {
    final SettableApiFuture<Boolean> callbackResult = SettableApiFuture.create();
    final WriteErrorCallback listener = errorListener;
    errorExecutor.execute(
        () -> {
          try {
            boolean shouldRetry = listener.onError(error);
            callbackResult.set(shouldRetry);
          } catch (Exception e) {
            callbackResult.setException(e);
          }
        });
    return callbackResult;
  }

  /** Invokes the user success callback on the user callback executor. */
  private ApiFuture<Void> invokeUserSuccessCallbackLocked(
      final DocumentReference documentReference, final WriteResult result) {
    final SettableApiFuture<Void> callbackResult = SettableApiFuture.create();
    final WriteResultCallback listener = successListener;
    successExecutor.execute(
        () -> {
          try {
            listener.onResult(documentReference, result);
            callbackResult.set(null);
          } catch (Exception e) {
            callbackResult.setException(e);
          }
        });
    return callbackResult;
  }

  /** Returns an ApiFuture that resolves successfully when the provided future completes. */
  static <T> SettableApiFuture<Void> silenceFuture(ApiFuture<T> future) {
    final SettableApiFuture<Void> flushCallback = SettableApiFuture.create();
    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<T>() {
          @Override
          public void onFailure(Throwable throwable) {
            flushCallback.set(null);
          }

          @Override
          public void onSuccess(T writeResult) {
            flushCallback.set(null);
          }
        },
        MoreExecutors.directExecutor());
    return flushCallback;
  }

  private int applyJitter(int backoffMs) {
    if (backoffMs == 0) return 0;
    // Random value in [-0.3, 0.3].
    double jitter = DEFAULT_JITTER_FACTOR * (Math.random() * 2 - 1);
    return (int) Math.min(DEFAULT_BACKOFF_MAX_DELAY_MS, backoffMs + jitter * backoffMs);
  }
}
