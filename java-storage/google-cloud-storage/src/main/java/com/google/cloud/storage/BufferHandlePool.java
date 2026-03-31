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

import com.google.common.annotations.VisibleForTesting;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

interface BufferHandlePool {

  PooledBuffer getBuffer();

  void returnBuffer(PooledBuffer handle);

  static BufferHandlePool simple(int capacity) {
    return new SimpleBufferHandlePool(capacity);
  }

  static BufferHandlePool fixedPool(int bufferCount, int bufferCapacity) {
    return FixedBufferHandlePool.of(bufferCount, bufferCapacity);
  }

  final class SimpleBufferHandlePool implements BufferHandlePool {
    private final int capacity;

    private SimpleBufferHandlePool(int capacity) {
      this.capacity = capacity;
    }

    @Override
    public PooledBuffer getBuffer() {
      return PooledBuffer.of(BufferHandle.allocate(capacity));
    }

    @Override
    public void returnBuffer(PooledBuffer handle) {
      // noop
    }
  }

  /**
   * Specialized and simplified {@link java.util.concurrent.BlockingQueue}. We don't need the
   * majority of methods/functionality just blocking put/get.
   *
   * <p>Inspired by the BoundedBuffer example from the class javadocs of {@link Condition} (java8)
   */
  final class FixedBufferHandlePool implements BufferHandlePool {
    @VisibleForTesting final HashSet<PooledBuffer> pool;
    private final int poolMaxSize;

    private final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    @VisibleForTesting
    FixedBufferHandlePool(HashSet<PooledBuffer> pool) {
      checkArgument(!pool.isEmpty(), "provided pool bust not start empty");
      this.pool = pool;
      this.poolMaxSize = pool.size();

      this.lock = new ReentrantLock();
      this.notEmpty = lock.newCondition();
      this.notFull = lock.newCondition();
    }

    @Override
    public PooledBuffer getBuffer() {
      try (AcquiredLock ignore = AcquiredLock.lock(this.lock)) {
        while (pool.isEmpty()) {
          notEmpty.awaitUninterruptibly();
        }
        return dequeue();
      }
    }

    @Override
    public void returnBuffer(PooledBuffer handle) {
      checkNotNull(handle, "handle must be non null");
      try (AcquiredLock ignore = AcquiredLock.lock(this.lock)) {
        if (pool.contains(handle)) {
          return;
        }
        while (poolMaxSize == pool.size()) {
          notFull.awaitUninterruptibly();
        }
        enqueue(handle);
      }
    }

    private void enqueue(PooledBuffer pooled) {
      pooled.getBufferHandle().get().clear();
      pool.add(pooled);
      notEmpty.signal();
    }

    private PooledBuffer dequeue() {
      Iterator<PooledBuffer> iterator = pool.iterator();
      checkState(iterator.hasNext(), "attempt to acquire pooled buffer failed");
      PooledBuffer poll = iterator.next();
      iterator.remove();
      notFull.signal();
      return poll;
    }

    @VisibleForTesting
    static FixedBufferHandlePool of(int bufferCount, int bufferCapacity) {
      // explicitly collect to a HashSet
      HashSet<PooledBuffer> buffers =
          IntStream.range(0, bufferCount)
              .mapToObj(i -> BufferHandle.allocate(bufferCapacity))
              .map(PooledBuffer::of)
              .collect(HashSet::new, Set::add, HashSet::addAll);
      return new FixedBufferHandlePool(buffers);
    }
  }

  final class PooledBuffer {
    private final BufferHandle bufferHandle;

    private PooledBuffer(BufferHandle bufferHandle) {
      this.bufferHandle = bufferHandle;
    }

    BufferHandle getBufferHandle() {
      return bufferHandle;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof PooledBuffer)) {
        return false;
      }
      PooledBuffer that = (PooledBuffer) o;
      return Objects.equals(System.identityHashCode(this), System.identityHashCode(that));
    }

    @Override
    public int hashCode() {
      return System.identityHashCode(this);
    }

    @VisibleForTesting
    static PooledBuffer of(BufferHandle bufferHandle) {
      return new PooledBuffer(bufferHandle);
    }
  }

  final class AcquiredLock implements AutoCloseable {
    private final ReentrantLock lock;

    private AcquiredLock(ReentrantLock lock) {
      this.lock = lock;
      lock.lock();
    }

    @Override
    public void close() {
      lock.unlock();
    }

    private static AcquiredLock lock(ReentrantLock lock) {
      return new AcquiredLock(lock);
    }
  }
}
