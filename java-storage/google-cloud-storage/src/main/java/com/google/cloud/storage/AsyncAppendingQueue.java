/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutureCallback;
import com.google.api.core.ApiFutures;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.cloud.storage.ApiFutureUtils.OnFailureApiFutureCallback;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Define a queue where enqueued items are async tasks. When a limit is reached, compact all values
 * into a new value.
 */
final class AsyncAppendingQueue<@NonNull T> implements AutoCloseable {

  private enum State {
    OPEN,
    CLOSING,
    CLOSED;

    boolean isOpen() {
      return this == OPEN;
    }
  }

  private final Executor exec;
  private final int maxElementsPerCompact;
  private final ApiFunction<ImmutableList<T>, T> compactFunction;
  private final AtomicInteger orderSequence;
  private final SettableApiFuture<T> finalResult;
  private final PriorityQueue<Element<T>> queue;
  private final AtomicReference<Throwable> shortCircuitFailure;
  private final ApiFutureCallback<T> shortCircuitRegistrationCallback;

  private final ReentrantLock lock;
  private volatile State state;

  private AsyncAppendingQueue(
      Executor exec, int maxElementsPerCompact, ApiFunction<ImmutableList<T>, T> compactFunction) {
    this.exec = exec;
    this.maxElementsPerCompact = maxElementsPerCompact;
    this.compactFunction = compactFunction;
    this.orderSequence = new AtomicInteger(0);
    this.finalResult = SettableApiFuture.create();
    this.queue = new PriorityQueue<>(maxElementsPerCompact, Element.COMP);
    this.state = State.OPEN;
    this.shortCircuitFailure = new AtomicReference<>(null);
    this.shortCircuitRegistrationCallback =
        (OnFailureApiFutureCallback<T>)
            throwable -> {
              if (state.isOpen()) {
                shortCircuitFailure.compareAndSet(null, throwable);
              }
            };
    lock = new ReentrantLock();
  }

  AsyncAppendingQueue<T> append(ApiFuture<T> value) throws ShortCircuitException {
    lock.lock();
    try {
      checkState(state.isOpen(), "already closed");
      Throwable throwable = shortCircuitFailure.get();
      if (throwable != null) {
        ShortCircuitException shortCircuitException = new ShortCircuitException(throwable);
        finalResult.cancel(true);
        throw shortCircuitException;
      }
      checkNotNull(value, "value must not be null");

      Element<T> newElement = newElement(value);
      queue.offer(newElement);
      boolean isFull = queue.size() == maxElementsPerCompact;
      if (isFull) {
        Element<T> compact = compact(exec);
        queue.offer(compact);
      }
      return this;
    } finally {
      lock.unlock();
    }
  }

  ApiFuture<T> getResult() {
    return finalResult;
  }

  T await() {
    return ApiExceptions.callAndTranslateApiException(finalResult);
  }

  @Override
  public void close() {
    lock.lock();
    try {
      if (!state.isOpen()) {
        return;
      }
      state = State.CLOSING;

      if (queue.isEmpty()) {
        NoSuchElementException neverAppendedTo = new NoSuchElementException("Never appended to");
        finalResult.setException(neverAppendedTo);
        throw neverAppendedTo;
      } else {
        Element<T> transform = compact(exec);

        ApiFutures.addCallback(
            transform.getValue(),
            new ApiFutureCallback<T>() {
              @Override
              public void onFailure(Throwable err) {
                finalResult.setException(err);
              }

              @Override
              public void onSuccess(T t) {
                finalResult.set(t);
              }
            },
            exec);
      }
      state = State.CLOSED;
    } finally {
      lock.unlock();
    }
  }

  @NonNull
  private Element<T> newElement(ApiFuture<T> value) {
    ApiFutures.addCallback(value, shortCircuitRegistrationCallback, MoreExecutors.directExecutor());
    return new Element<>(orderSequence.getAndIncrement(), value);
  }

  @NonNull
  private Element<T> compact(Executor executor) {
    ArrayList<Element<T>> elements = new ArrayList<>();
    Element<T> peek = queue.peek();
    checkState(peek != null, "attempt to compact empty queue");
    int order = peek.getOrder();

    Element<T> curr;
    while ((curr = queue.poll()) != null) {
      elements.add(curr);
    }

    List<ApiFuture<T>> pending =
        elements.stream().map(Element::getValue).collect(Collectors.toList());
    ApiFuture<List<T>> futureTs = ApiFutureUtils.quietAllAsList(pending);
    ApiFuture<T> transform =
        ApiFutures.transform(
            futureTs, ts -> compactFunction.apply(ImmutableList.copyOf(ts)), executor);
    return new Element<>(order, transform);
  }

  public static <T> AsyncAppendingQueue<T> of(
      Executor exec, int maxElementsPerCompact, ApiFunction<ImmutableList<T>, T> compactFunction) {
    checkNotNull(exec, "exec must be non-null");
    checkArgument(maxElementsPerCompact > 1, "maxElementsPerCompact must be > 1");
    checkNotNull(compactFunction, "compactFunction must be non-null");
    return new AsyncAppendingQueue<>(exec, maxElementsPerCompact, compactFunction);
  }

  static final class ShortCircuitException extends RuntimeException {
    private ShortCircuitException(Throwable instigator) {
      super("Short Circuiting due to previously failed future", instigator);
    }
  }

  /**
   * The order in which elements are compacted is important. Define a class that allows defining an
   * order property for use by the {@link PriorityQueue}
   */
  private static final class Element<T> {
    private static final Comparator<Element<?>> COMP = Comparator.comparing(Element::getOrder);
    private final int order;
    private final ApiFuture<T> value;

    public Element(int order, ApiFuture<T> value) {
      this.order = order;
      this.value = value;
    }

    public int getOrder() {
      return order;
    }

    public ApiFuture<T> getValue() {
      return value;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this).add("order", order).add("value", value).toString();
    }
  }
}
