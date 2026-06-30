/*
 * Copyright 2018 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.longrunning;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.retrying.RetryingFuture;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.base.Preconditions;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public class OperationFutures {
  private OperationFutures() {
    // Utility class
  }

  /**
   * Creates an already-completed {@code OperationFuture}, useful for testing.
   *
   * <p>{@code completedSnapshot.isDone()} must return true. The snapshot's {@code getResponse()}
   * and {@code getMetadata()} must be instances of {@code ResponseT} and {@code MetadataT},
   * respectively.
   */
  @SuppressWarnings("unchecked")
  public static final <ResponseT, MetadataT>
      OperationFuture<ResponseT, MetadataT> immediateOperationFuture(
          final OperationSnapshot completedSnapshot) {

    Preconditions.checkArgument(
        completedSnapshot.isDone(), "given snapshot must already be completed");
    final ApiFuture<MetadataT> metadataFuture =
        ApiFutures.immediateFuture((MetadataT) completedSnapshot.getMetadata());
    final ApiFuture<OperationSnapshot> initialFuture =
        ApiFutures.immediateFuture(completedSnapshot);

    return new OperationFuture<ResponseT, MetadataT>() {
      @Override
      public String getName() {
        return completedSnapshot.getName();
      }

      @Override
      public ApiFuture<MetadataT> getMetadata() {
        return metadataFuture;
      }

      @Override
      public ApiFuture<MetadataT> peekMetadata() {
        return metadataFuture;
      }

      @Override
      public ApiFuture<OperationSnapshot> getInitialFuture() {
        return initialFuture;
      }

      @Override
      public RetryingFuture<OperationSnapshot> getPollingFuture() {
        throw new UnsupportedOperationException("Not implemented: getPollingFuture().");
      }

      @Override
      public void addListener(Runnable runnable, Executor executor) {
        initialFuture.addListener(runnable, executor);
      }

      @Override
      public ResponseT get(long time, TimeUnit unit) throws ExecutionException {
        return get();
      }

      @Override
      public ResponseT get() throws ExecutionException {
        if (completedSnapshot.getErrorCode().getCode().equals(StatusCode.Code.OK)) {
          return (ResponseT) completedSnapshot.getResponse();
        }
        throw new ExecutionException(
            new ApiException(null, completedSnapshot.getErrorCode(), false));
      }

      @Override
      public boolean isDone() {
        return true;
      }

      @Override
      public boolean isCancelled() {
        return false;
      }

      @Override
      public boolean cancel(boolean b) {
        return false;
      }
    };
  }
}
