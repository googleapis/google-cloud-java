/*
 * Copyright 2022 Google LLC
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

import com.google.common.annotations.VisibleForTesting;
import java.nio.ByteBuffer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Sometimes, we need a handle to create a buffer but do not want to unnecessarily allocate it. This
 * class can be though of as an enriched {@code Supplier<ByteBuffer>} that still implements the
 * common stateful methods of {@link ByteBuffer} without allocating the ByteBuffer until necessary.
 *
 * <p>{@link ByteBuffer} is a sealed class hierarchy, meaning we can't simply extend it to provide
 * laziness without this new class.
 */
abstract class BufferHandle implements Supplier<ByteBuffer> {

  @VisibleForTesting
  BufferHandle() {}

  abstract int remaining();

  abstract int capacity();

  abstract int position();

  static BufferHandle allocate(int capacity) {
    return new LazyBufferHandle(capacity, Buffers::allocate);
  }

  static BufferHandle handleOf(ByteBuffer buf) {
    return new EagerBufferHandle(buf);
  }

  static final class LazyBufferHandle extends BufferHandle {

    private final int capacity;
    private final Function<Integer, ByteBuffer> factory;

    // It is theoretically possible for this value to be null for any of the methods, while
    // get is invoked. Whenever reading this value, always read into a local variable and then
    // operate on that variable for the rest of the scope.
    private volatile ByteBuffer buf;

    @VisibleForTesting
    LazyBufferHandle(int capacity, Function<Integer, ByteBuffer> factory) {
      this.capacity = capacity;
      this.factory = factory;
    }

    @Override
    int remaining() {
      ByteBuffer buffer = buf;
      return buffer == null ? capacity : buffer.remaining();
    }

    @Override
    int capacity() {
      ByteBuffer buffer = buf;
      return buffer == null ? capacity : buffer.capacity();
    }

    @Override
    int position() {
      ByteBuffer buffer = buf;
      return buffer == null ? 0 : buffer.position();
    }

    @Override
    public ByteBuffer get() {
      ByteBuffer result = buf;
      if (result != null) {
        return result;
      } else {
        synchronized (this) {
          if (buf == null) {
            buf = factory.apply(capacity);
          }
          return buf;
        }
      }
    }
  }

  static final class EagerBufferHandle extends BufferHandle {
    private final ByteBuffer buf;

    private EagerBufferHandle(ByteBuffer buf) {
      this.buf = buf;
    }

    @Override
    int remaining() {
      return buf.remaining();
    }

    @Override
    int capacity() {
      return buf.capacity();
    }

    @Override
    int position() {
      return buf.position();
    }

    @Override
    public ByteBuffer get() {
      return buf;
    }
  }
}
