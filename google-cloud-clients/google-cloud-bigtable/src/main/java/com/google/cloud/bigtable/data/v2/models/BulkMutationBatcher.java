/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.bigtable.data.v2.models;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import org.threeten.bp.Duration;

/**
 * Tracker for outstanding bulk mutations. Allows for the caller to wait for all of the outstanding
 * mutations to complete.
 *
 * @see com.google.cloud.bigtable.data.v2.BigtableDataClient#newBulkMutationBatcher() for example
 *     usage.
 */
@BetaApi("This surface is likely to change as the batching surface evolves.")
public final class BulkMutationBatcher implements AutoCloseable {
  private final UnaryCallable<RowMutation, Void> callable;
  // Shared
  private final Object lock = new Object();
  private final AtomicLong numOutstanding = new AtomicLong();
  // Only accessed by grpc
  private long numFailures;
  // Only accessed by caller
  private boolean closed;

  @InternalApi
  public BulkMutationBatcher(UnaryCallable<RowMutation, Void> callable) {
    this.callable = callable;
  }

  /**
   * Waits up to 10 minutes for all of the outstanding mutations to be resolved.
   *
   * @see #close(Duration) for more infortmation.
   */
  @Override
  public void close() throws InterruptedException, TimeoutException {
    close(Duration.ofMinutes(10));
  }

  /**
   * Prevents further mutations and waits for all outstanding mutations to complete.
   *
   * @throws BulkMutationFailure If any mutations failed.
   * @throws InterruptedException If interrupted.
   * @throws TimeoutException If the outstanding requests don't finish in time.
   */
  public void close(Duration duration) throws InterruptedException, TimeoutException {
    closed = true;
    long deadlineMs = System.currentTimeMillis() + duration.toMillis();

    synchronized (lock) {
      while (numOutstanding.get() > 0) {
        long waitMs = deadlineMs - System.currentTimeMillis();
        if (waitMs <= 0) {
          throw new TimeoutException("Timed out waiting outstanding mutations to finish");
        }
        lock.wait(waitMs);
      }

      // numFailures can only be checked after numOutstanding is zero.
      if (numFailures > 0) {
        throw new BulkMutationFailure(numFailures);
      }
    }
  }

  /**
   * Queues the mutation to be batched and sent. Please note that the order of mutations is not
   * guaranteed.
   *
   * @throws IllegalStateException If this instance has been closed.
   */
  public ApiFuture<Void> add(final RowMutation rowMutation) {
    Preconditions.checkState(!closed, "BulkMutations has been closed");
    numOutstanding.incrementAndGet();

    ApiFuture<Void> future = callable.futureCall(rowMutation);

    ApiFutures.addCallback(
        future,
        new ApiFutureCallback<Void>() {
          @Override
          public void onFailure(Throwable throwable) {
            onMutationComplete(false);
          }

          @Override
          public void onSuccess(Void aVoid) {
            onMutationComplete(true);
          }
        });

    return future;
  }

  private void onMutationComplete(boolean isOk) {
    // Order matters here: numOutstanding must be decremented after numFailures to ensure a
    // consistent view in close(Duration)
    if (!isOk) {
      numFailures++;
    }

    if (numOutstanding.decrementAndGet() == 0) {
      synchronized (lock) {
        lock.notifyAll();
      }
    }
  }

  /**
   * Thrown when at least one mutation failed in a batch.
   *
   * <p>Note that this exception only tracks that some item failed, it is the callers responsibility
   * to track the results of the {@link ApiFuture}s to figure out which item failed.
   */
  public static class BulkMutationFailure extends RuntimeException {
    BulkMutationFailure(long numFailures) {
      super("Failed to commit " + numFailures + " mutations");
    }
  }
}
