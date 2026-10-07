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

import static com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category.TRANSIENT;

import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.rpc.ResumableUploadErrorClassifier.Category;
import java.util.Objects;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * An adapter that integrates {@link ResumableUploadErrorClassifier} into GAX retrying machinery.
 *
 * <p>Only transient errors should retry with an identical request; other recoverable errors will
 * need to query the upload server to determine the appropriate next request.
 *
 * @param <ResponseT> the response type of the upload attempt
 */
@NullMarked
final class ResumableUploadResultRetryAlgorithm<ResponseT>
    extends BasicResultRetryAlgorithm<ResponseT> {

  private final ResumableUploadCommand command;

  ResumableUploadResultRetryAlgorithm(ResumableUploadCommand command) {
    this.command = Objects.requireNonNull(command);
  }

  @Override
  public boolean shouldRetry(
      @Nullable Throwable previousThrowable, @Nullable ResponseT previousResponse) {
    // Successful commands should not retry.
    if (previousThrowable == null) {
      return false;
    }
    // Transient errors are retried directly with the identical request, others are not.
    Category category = ResumableUploadErrorClassifier.classify(previousThrowable, command);
    return category == TRANSIENT;
  }
}
