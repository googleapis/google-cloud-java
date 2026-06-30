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
package com.google.api.gax.rpc;

import com.google.common.util.concurrent.UncheckedExecutionException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Internal implementation of a blocking Iterator, which will coordinate with the
 * QueuingResponseObserver to fetch new items from upstream. The Iterator expects the observer to
 * request the first item, and afterwards, new items will be requested when the current ones are
 * consumed by next().
 *
 * <p>Package-private for internal use.
 *
 * @param <V> The type of items to be Iterated over.
 */
final class ServerStreamIterator<V> implements Iterator<V> {
  private final QueuingResponseObserver<V> observer;
  private Object last;

  ServerStreamIterator(QueuingResponseObserver<V> observer) {
    this.observer = observer;
  }

  /**
   * Checks if the next call to {@code hasNext()} (and {@code next()}) will block.
   *
   * @return true if the next call is guaranteed to be nonblocking.
   */
  boolean isReady() {
    return last != null || observer.isReady();
  }

  /**
   * Consumes the next response and asynchronously request the next response from the observer.
   *
   * @return The next response.
   * @throws NoSuchElementException If the stream has been consumed or cancelled.
   */
  @Override
  public V next() {
    if (!hasNext()) {
      throw new NoSuchElementException();
    }
    try {
      observer.request();
      @SuppressWarnings("unchecked")
      V tmp = (V) last;
      return tmp;
    } finally {
      last = null;
    }
  }

  /**
   * Checks if the stream has been fully consumed or cancelled. This method will block until the
   * observer enqueues another event (response or completion event). If the observer encountered an
   * error, this method will propagate the error and put itself into an error where it will always
   * return the same error.
   *
   * @return true If iterator has more responses.
   */
  @Override
  public boolean hasNext() {
    if (last == null) {
      try {
        last = observer.getNext();
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new RuntimeException(e);
      }
    }
    // Preserve async error while keeping the caller's stacktrace as a suppressed exception
    if (last instanceof RuntimeException) {
      RuntimeException runtimeException = (RuntimeException) last;
      runtimeException.addSuppressed(new RuntimeException("Asynchronous task failed"));
      throw runtimeException;
    }

    // This should never really happen because currently gax doesn't throw checked exceptions.
    // Wrap checked exceptions. This will preserve both the caller's stacktrace and the async error.
    if (last instanceof Throwable) {
      Throwable throwable = (Throwable) last;
      throw new UncheckedExecutionException(throwable);
    }

    return last != QueuingResponseObserver.EOF_MARKER;
  }

  /** Unsupported. */
  @Override
  public void remove() {
    throw new UnsupportedOperationException();
  }
}
