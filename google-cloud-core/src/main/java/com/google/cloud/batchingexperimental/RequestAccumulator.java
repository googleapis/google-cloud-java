/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.batchingexperimental;

import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.List;

/**
 * Accumulates requests, used to batch many requests into one RPC call.
 *
 * <p>Experimental and only meant to be used by other packages in google-cloud-java.
 *
 * <p>Methods are not thread-safe.
 *
 * <p>Sample usage:
 *
 * <pre>{@code
 * synchronized(accumulator) {
 *   accumulator.add(item, future);
 *   while (accumulator.hasBatch()) {
 *     // If items and futures must be retained, they must be copied.
 *     List<ElementT> items = new ArrayList<>(accumulator.batch());
 *     List<SettableApiFuture<ResponseT>> futures = new ArrayList<>(accumulator.futureBatch());
 *
 *     // ...
 *
 *     accumulator.next();
 *   }
 * }
 *
 * @param <ElementT> The elements that, when batched, make up RPC calls.
 * @param <ResponseT> The RPC results for the individual elements.
 * }</pre>
 */
@InternalApi
public class RequestAccumulator<ElementT, ResponseT> {
  private final ArrayList<ElementT> requests = new ArrayList<>();
  private final ArrayList<SettableApiFuture<ResponseT>> futures = new ArrayList<>();
  private long curBytes = 0;

  // If not 0, the last element of requests is oversized and
  // must be sent in its own batch.
  private long oversizedBytes = 0;

  private final int batchCount;
  private final long batchBytes;

  /**
   * Creates a new accumulator, holding {@code batchCount} items and {@code batchBytes} bytes in a
   * batch.
   *
   * <p>{@code batchBytes} is a soft limit. Once the current batch is larger than {@code
   * batchBytes}, no new items will be added to the batch. {@code batchCount} is a hard limit. Once
   * reached, no new items will be added.
   */
  public RequestAccumulator(int batchCount, long batchBytes) {
    Preconditions.checkArgument(batchCount > 0, "batchCount must be positive");
    Preconditions.checkArgument(batchBytes > 0, "batchBytes must be positive");
    this.batchCount = batchCount;
    this.batchBytes = batchBytes;
  }

  /**
   * Add a new item {@code e} with size {@code bytes} into the current batch. The item is associated
   * with a {@code future}.
   *
   * <p>Given a call {@code add(e, f)}, {@code e} and {@code f} are in the same index in {@link
   * #batch()} and {@link #futureBatch()}.
   *
   * @throws IllegalArgumentException if {@code bytes} is not positive.
   * @throws IllegalStateException if {@link #hasBatch()} would return true immediately before the
   *     call.
   */
  public void add(ElementT e, long bytes, SettableApiFuture<ResponseT> future) {
    Preconditions.checkArgument(bytes >= 0, "size of element must not be negative");
    Preconditions.checkState(!hasBatch(), "invalid use of add; there's already a batch waiting");

    if (!requests.isEmpty() && bytes >= batchBytes) {
      oversizedBytes = bytes;
    }
    requests.add(e);
    futures.add(future);
    curBytes += bytes;
  }

  /**
   * Reports whether the current batch is ready to be sent. If this method returns true, it is
   * invalid to call {@link #add()}. See the class documentation for example usage.
   */
  public boolean hasBatch() {
    return requests.size() >= batchCount || curBytes >= batchBytes;
  }

  /**
   * Returns the previously added items. The returned list must not be modified and will become
   * invalid after the next call to {@link #next()}.
   */
  public List<ElementT> batch() {
    if (oversizedBytes > 0) {
      return requests.subList(0, requests.size() - 1);
    }
    return requests;
  }

  /**
   * Returns the previously added futures. The returned list must not be modified and will become
   * invalid after the next call to {@link #next()}.
   */
  public List<SettableApiFuture<ResponseT>> futureBatch() {
    if (oversizedBytes > 0) {
      return futures.subList(0, futures.size() - 1);
    }
    return futures;
  }

  /** Returns the combined size of items in {@link #batch()}. */
  public long bytes() {
    return curBytes - oversizedBytes;
  }

  /** Consumes the current batch. */
  public void next() {
    batch().clear();
    futureBatch().clear();
    curBytes = oversizedBytes;
    oversizedBytes = 0;
  }
}
