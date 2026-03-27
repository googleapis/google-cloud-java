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

import com.google.api.core.InternalApi;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nonnull;

/**
 * A blocking Iterable-style wrapper around server stream responses.
 *
 * <p>This class asynchronously pulls responses from upstream via {@link
 * StreamController#request(int)} and exposes them via its Iterator. The implementation is back
 * pressure aware and uses a constant buffer of 1 item.
 *
 * <p>Please note that the stream can only be consumed once and must either be fully consumed or be
 * canceled.
 *
 * <p>Neither this class nor the iterator it returns is thread-safe.
 *
 * <p>Example usage:
 *
 * <pre>{@code
 * ServerStream<Item> stream = ...;
 *
 * for (Item item : stream) {
 *   System.out.println(item.id());
 *
 *   // Allow for early termination
 *   if (item.id().equals("needle")) {
 *     // Cancelling the stream will cause `hasNext()` to return false on the next iteration,
 *     // naturally breaking the loop.
 *     stream.cancel();
 *   }
 * }
 * }</pre>
 *
 * @param <V> The type of each response.
 */
public class ServerStream<V> implements Iterable<V> {
  private final QueuingResponseObserver<V> observer = new QueuingResponseObserver<>();
  private final ServerStreamIterator<V> iterator = new ServerStreamIterator<>(observer);
  private boolean consumed;

  @InternalApi("For use by ServerStreamingCallable only.")
  ServerStream() {}

  @InternalApi("For use by ServerStreamingCallable only.")
  ResponseObserver<V> observer() {
    return observer;
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public Iterator<V> iterator() {
    if (consumed) {
      throw new IllegalStateException("Iterator already consumed");
    }
    consumed = true;

    return iterator;
  }

  /**
   * Returns a sequential {@code Stream} with server responses as its source.
   *
   * @return a sequential {@code Stream} over the elements in server responses
   */
  public Stream<V> stream() {
    return StreamSupport.stream(this.spliterator(), false);
  }

  /**
   * Returns true if the next call to the iterator's hasNext() or next() is guaranteed to be
   * nonblocking.
   *
   * @return If the call on any of the iterator's methods is guaranteed to be nonblocking.
   */
  public boolean isReceiveReady() {
    return iterator.isReady();
  }

  /**
   * Cleanly cancels a partially consumed stream. The associated iterator will return false for the
   * hasNext() in the next iteration. This maintains the contract that an observed true from
   * hasNext() will yield an item in next(), but afterwards will return false.
   */
  public void cancel() {
    observer.cancel();
  }
}
