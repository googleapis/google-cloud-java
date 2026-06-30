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

import com.google.common.util.concurrent.AbstractFuture;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.Nullable;

/** Abstract implementation of ApiFuture that mirrors {@code AbstractFuture} in Guava. */
public abstract class AbstractApiFuture<V> implements ApiFuture<V> {
  private final InternalSettableFuture impl = new InternalSettableFuture();

  public void addListener(Runnable listener, Executor executor) {
    impl.addListener(listener, executor);
  }

  public boolean cancel(boolean mayInterruptIfRunning) {
    return impl.cancel(mayInterruptIfRunning);
  }

  public V get() throws InterruptedException, ExecutionException {
    return impl.get();
  }

  public V get(long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException, TimeoutException {
    return impl.get(timeout, unit);
  }

  public boolean isCancelled() {
    return impl.isCancelled();
  }

  public boolean isDone() {
    return impl.isDone();
  }

  protected boolean set(V value) {
    return impl.set(value);
  }

  protected boolean setException(Throwable throwable) {
    return impl.setException(throwable);
  }

  protected void interruptTask() {}

  /* package-private for internal library use, to reduce call layering */
  ListenableFuture<V> getInternalListenableFuture() {
    return impl;
  }

  private class InternalSettableFuture extends AbstractFuture<V> {
    @Override
    protected boolean set(@Nullable V value) {
      return super.set(value);
    }

    @Override
    protected boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }

    protected void interruptTask() {
      AbstractApiFuture.this.interruptTask();
    }
  }
}
