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
package com.google.api.gax.resumable;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.ResultRetryAlgorithm;
import com.google.api.gax.retrying.RetryingContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.StatusCode;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Implementation of {@link ResultRetryAlgorithm} for resumable uploads based on the Unified
 * Resumable Upload Protocol specification.
 *
 * <p>Differentiates between:
 *
 * <ul>
 *   <li><b>Category 1 (Transient)</b>: Retriable without modification (e.g. UNAVAILABLE,
 *       DEADLINE_EXCEEDED, RESOURCE_EXHAUSTED, network I/O errors).
 *   <li><b>Category 2 (Recoverable)</b>: Retriable with modification (e.g. OUT_OF_RANGE,
 *       INVALID_ARGUMENT, FAILED_PRECONDITION, ABORTED, INTERNAL) where the upload offset must be
 *       recovered via queryStatus.
 *   <li><b>Category 3 (Terminal)</b>: Fatal errors (e.g. NOT_FOUND, UNAUTHENTICATED,
 *       PERMISSION_DENIED, CancellationException) which abort immediately.
 * </ul>
 */
@BetaApi
@InternalApi
@NullMarked
public class ResumableUploadResultRetryAlgorithm<ResponseT>
    extends BasicResultRetryAlgorithm<ResponseT> {

  private static final Set<StatusCode.Code> DEFAULT_RETRYABLE_CODES =
      ImmutableSet.of(
          // Category 1: Transient errors
          StatusCode.Code.UNAVAILABLE,
          StatusCode.Code.DEADLINE_EXCEEDED,
          StatusCode.Code.RESOURCE_EXHAUSTED,
          // Category 2: Recoverable errors (offset mismatch, precondition, missing header)
          StatusCode.Code.OUT_OF_RANGE,
          StatusCode.Code.INVALID_ARGUMENT,
          StatusCode.Code.FAILED_PRECONDITION,
          StatusCode.Code.ABORTED,
          StatusCode.Code.INTERNAL);

  private final Set<StatusCode.Code> retryableCodes;

  public static <ResponseT> ResumableUploadResultRetryAlgorithm<ResponseT> create() {
    return new ResumableUploadResultRetryAlgorithm<>(DEFAULT_RETRYABLE_CODES);
  }

  public static <ResponseT> ResumableUploadResultRetryAlgorithm<ResponseT> create(
      Set<StatusCode.Code> retryableCodes) {
    return new ResumableUploadResultRetryAlgorithm<>(retryableCodes);
  }

  public ResumableUploadResultRetryAlgorithm() {
    this(DEFAULT_RETRYABLE_CODES);
  }

  public ResumableUploadResultRetryAlgorithm(Set<StatusCode.Code> retryableCodes) {
    this.retryableCodes = ImmutableSet.copyOf(retryableCodes);
  }

  public Set<StatusCode.Code> getRetryableCodes() {
    return retryableCodes;
  }

  @Override
  public boolean shouldRetry(
      @Nullable Throwable previousThrowable, @Nullable ResponseT previousResponse) {
    if (previousThrowable == null) {
      return false;
    }
    if (previousThrowable instanceof CancellationException) {
      return false;
    }
    if (previousThrowable instanceof ApiException) {
      StatusCode.Code code = ((ApiException) previousThrowable).getStatusCode().getCode();
      return retryableCodes.contains(code);
    }
    if (previousThrowable instanceof IOException) {
      return true;
    }
    return false;
  }

  @Override
  public boolean shouldRetry(
      RetryingContext context,
      @Nullable Throwable previousThrowable,
      @Nullable ResponseT previousResponse) {
    if (context.getRetryableCodes() != null) {
      if (previousThrowable instanceof ApiException) {
        return context
            .getRetryableCodes()
            .contains(((ApiException) previousThrowable).getStatusCode().getCode());
      }
    }
    return shouldRetry(previousThrowable, previousResponse);
  }
}
