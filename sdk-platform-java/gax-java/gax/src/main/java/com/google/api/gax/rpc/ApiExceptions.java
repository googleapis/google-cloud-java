/*
 * Copyright 2016 Google LLC
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

import com.google.api.core.ApiFuture;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.UncheckedExecutionException;

/** A utility class for working with {@link ApiException}. */
public class ApiExceptions {
  private ApiExceptions() {}

  /**
   * Invokes {@link ApiFuture#get()} on the given future, and if the call throws an exception (which
   * will be {@link UncheckedExecutionException}), the exception is processed in the following way:
   *
   * <ol>
   *   <li>If the exception cause is a RuntimeException, the RuntimeException is rethrown. To ease
   *       debugging, the a {@link AsyncTaskException} is added as a suppressed exception to
   *       maintain the callsite.
   *   <li>Otherwise, the UncheckedExecutionException is rethrown.
   * </ol>
   */
  public static <ResponseT> ResponseT callAndTranslateApiException(ApiFuture<ResponseT> future) {
    try {
      return Futures.getUnchecked(future);
    } catch (UncheckedExecutionException exception) {
      if (exception.getCause() instanceof RuntimeException) {
        RuntimeException cause = (RuntimeException) exception.getCause();
        cause.addSuppressed(new AsyncTaskException());
        throw cause;
      }

      throw exception;
    }
  }
}
