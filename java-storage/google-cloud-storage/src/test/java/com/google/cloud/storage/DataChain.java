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

import static com.google.common.base.Preconditions.checkState;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.UnmodifiableIterator;
import java.nio.ByteBuffer;
import java.util.Iterator;

public abstract class DataChain<T> implements Iterable<T> {

  private DataChain() {}

  public abstract long getTotalCapacity();

  public abstract Iterator<T> splice(long objectSize);

  static DataChain<ByteBuffer> ofByteBuffers(ImmutableList<ByteBuffer> buffers) {
    return new ByteBufferChain(buffers);
  }

  static final class ByteBufferChain extends DataChain<ByteBuffer> {
    private final long totalCapacity;
    private final ImmutableList<ByteBuffer> buffers;

    public ByteBufferChain(ImmutableList<ByteBuffer> buffers) {
      this.buffers = buffers;
      this.totalCapacity = buffers.stream().mapToLong(ByteBuffer::capacity).sum();
    }

    @Override
    public long getTotalCapacity() {
      return totalCapacity;
    }

    @Override
    public Iterator<ByteBuffer> splice(long objectSize) {
      return new BufferSplicer(objectSize, buffers.iterator());
    }

    @Override
    public Iterator<ByteBuffer> iterator() {
      return splice(totalCapacity);
    }

    static final class BufferSplicer implements Iterator<ByteBuffer> {
      private final Iterator<ByteBuffer> iter;
      private final long limit;

      private ByteBuffer now;
      private long overallPosition;

      BufferSplicer(long limit, UnmodifiableIterator<ByteBuffer> iterator) {
        this.limit = limit;
        iter = iterator;
      }

      @Override
      public boolean hasNext() {
        return remaining() > 0 && iter.hasNext();
      }

      @Override
      public ByteBuffer next() {
        if (now == null) {
          checkState(hasNext());
          now = iter.next();
        }
        ByteBuffer sub = now.asReadOnlyBuffer();
        int subLimit =
            Math.toIntExact(Math.min(sub.remaining(), Math.min(Integer.MAX_VALUE, remaining())));
        sub.limit(subLimit);
        overallPosition += subLimit;
        return sub;
      }

      private long remaining() {
        return limit - overallPosition;
      }
    }
  }
}
