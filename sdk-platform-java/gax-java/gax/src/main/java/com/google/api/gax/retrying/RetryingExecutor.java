/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.retrying;

import com.google.api.core.ApiFuture;
import java.util.concurrent.Callable;

/**
 * A retrying executor is responsible for the following operations:
 *
 * <ol>
 *   <li>Creating first attempt {@link RetryingFuture}, which acts as a facade, hiding from client
 *       code the actual execution of scheduled retry attempts.
 *   <li>Executing the actual {@link Callable} in a retriable context.
 * </ol>
 *
 * This interface is for internal/advanced use only.
 *
 * @param <ResponseT> response type
 */
public interface RetryingExecutor<ResponseT> {
  /**
   * Creates the {@link RetryingFuture}, which is a facade, returned to the client code to wait for
   * any retriable operation to complete.
   *
   * @param callable the actual callable, which should be executed in a retriable context
   * @return retrying future facade
   */
  RetryingFuture<ResponseT> createFuture(Callable<ResponseT> callable);

  /**
   * Submits an attempt for execution. A typical implementation will either try to execute the
   * attempt in the current thread or schedule it for an execution, using some sort of async
   * execution service.
   *
   * @param retryingFuture the future previously returned by {@link #createFuture(Callable)} and
   *     reused for each subsequent attempt of same operation.
   * @return submitted attempt future
   */
  ApiFuture<ResponseT> submit(RetryingFuture<ResponseT> retryingFuture);
}
