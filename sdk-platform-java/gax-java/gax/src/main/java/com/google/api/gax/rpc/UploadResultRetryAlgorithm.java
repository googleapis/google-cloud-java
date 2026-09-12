/*
 * Copyright 2026 Google LLC
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
package com.google.api.gax.rpc;

import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithmWithContext;
import com.google.api.gax.retrying.RetryingContext;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An adapter that integrates {@link UploadErrorClassifier} into GAX retrying machinery via {@link
 * ResultRetryAlgorithmWithContext}.
 *
 * <p>Retries transient (Category 1) errors with the identical request and recoverable (Category 2)
 * errors via session query and buffer realignment. Responses lacking an upload status header also
 * enter recovery per protocol specification.
 *
 * @param <ResponseT> the response type of the upload attempt
 */
@NullMarked
final class UploadResultRetryAlgorithm<ResponseT> extends BasicResultRetryAlgorithm<ResponseT> {

  private final UploadCommand command;

  UploadResultRetryAlgorithm(UploadCommand command) {
    this.command = Objects.requireNonNull(command);
  }

  @Override
  public boolean shouldRetry(
      @Nullable Throwable previousThrowable, @Nullable ResponseT previousResponse) {
    if (previousThrowable instanceof CancellationException) {
      return false;
    }
    UploadErrorClassifier.Category category = null;
    if (previousThrowable != null) {
      category = UploadErrorClassifier.classify(previousThrowable, command);
    } else if (previousResponse instanceof ChunkUploadResponse) {
      ChunkUploadResponse<?> chunkResponse = (ChunkUploadResponse<?>) previousResponse;
      if (chunkResponse.getUploadStatus() == null) {
        category = UploadErrorClassifier.classifyMissingStatusHeader(command);
      }
    } else if (previousResponse instanceof ResumableUploadSession) {
      ResumableUploadSession session = (ResumableUploadSession) previousResponse;
      if (session.getUploadStatus() == null) {
        category = UploadErrorClassifier.classifyMissingStatusHeader(command);
      }
    }
    return category == UploadErrorClassifier.Category.TRANSIENT
        || category == UploadErrorClassifier.Category.RECOVERABLE;
  }

  @Override
  public boolean shouldRetry(
      RetryingContext context,
      @Nullable Throwable previousThrowable,
      @Nullable ResponseT previousResponse) {
    return shouldRetry(previousThrowable, previousResponse);
  }
}
