/*
 * Copyright 2017, Google Inc.
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
 *     * Neither the name of Google Inc. nor the names of its
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
package com.google.api.core;

import com.google.common.base.MoreObjects;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/** INTERNAL USE ONLY. Adapter from ApiFuture to Guava ListenableFuture. */
@InternalApi
public class ApiFutureToListenableFuture<V> implements ListenableFuture<V> {
  private final ApiFuture<V> apiFuture;

  public ApiFutureToListenableFuture(ApiFuture<V> apiFuture) {
    this.apiFuture = apiFuture;
  }

  @Override
  public void addListener(Runnable listener, Executor executor) {
    apiFuture.addListener(listener, executor);
  }

  @Override
  public boolean cancel(boolean b) {
    return apiFuture.cancel(b);
  }

  @Override
  public boolean isCancelled() {
    return apiFuture.isCancelled();
  }

  @Override
  public boolean isDone() {
    return apiFuture.isDone();
  }

  @Override
  public V get() throws InterruptedException, ExecutionException {
    return apiFuture.get();
  }

  @Override
  public V get(long l, TimeUnit timeUnit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return apiFuture.get(l, timeUnit);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(ApiFutureToListenableFuture.class.getSimpleName())
        .add("apiFuture", apiFuture)
        .toString();
  }
}
