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

import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.function.Consumer;

/**
 * Utility methods for working with ByteBuffers
 *
 * <p>Several methods are copied from {@link com.google.common.base.Java8Compatibility} which is
 * package private. Each of these methods will need to be kept as long as we are supporting Java 8.
 * The list of applicable methods are:
 *
 * <ol>
 *   <li>{@link #clear}
 *   <li>{@link #flip}
 *   <li>{@link #limit}
 *   <li>{@link #position}
 * </ol>
 */
final class Buffers {

  private Buffers() {}

  static void clear(Buffer b) {
    b.clear();
  }

  static void flip(Buffer b) {
    b.flip();
  }

  static void limit(Buffer b, int limit) {
    b.limit(limit);
  }

  static void position(Buffer b, int position) {
    b.position(position);
  }

  static int position(Buffer b) {
    return b.position();
  }

  static int remaining(Buffer b) {
    return b.remaining();
  }

  static boolean hasRemaining(Buffer b) {
    return b.hasRemaining();
  }

  static void compact(ByteBuffer b) {
    b.compact();
  }

  /** attempt to drain all of {@code content} into {@code dst} */
  static long copy(ByteBuffer content, ByteBuffer dst) {
    return copy(content, new ByteBuffer[] {dst}, 0, 1);
  }

  /**
   * attempt to drain all of {@code content} into {@code dsts} starting from {@code dsts[0]} through
   * {@code dsts[dsts.length - 1]}
   */
  static long copy(ByteBuffer content, ByteBuffer[] dsts) {
    return copy(content, dsts, 0, dsts.length);
  }

  /**
   * attempt to drain all of `content` into `dsts` starting from `dsts[offset]` through
   * `dsts[length]`
   */
  static long copy(ByteBuffer content, ByteBuffer[] dsts, int offset, int length) {
    long total = 0;
    for (int i = offset; i < length; i++) {
      int contentRemaining = content.remaining();
      if (contentRemaining <= 0) {
        break;
      }
      ByteBuffer buf = dsts[i];
      int bufRemaining = buf.remaining();
      if (bufRemaining == 0) {
        continue;
      } else if (bufRemaining < contentRemaining) {
        sliceAndConsume(content, bufRemaining, buf::put);
      } else {
        buf.put(content);
      }
      int written = bufRemaining - buf.remaining();
      total += written;
    }
    return total;
  }

  /**
   * Slice the provided source with a limit of {@code limit}, consume the slice with {@code c} then
   * increment position of {@code src} to reflect the consumed bytes.
   */
  static void sliceAndConsume(ByteBuffer src, int limit, Consumer<ByteBuffer> c) {
    ByteBuffer slice = src.slice();
    slice.limit(limit);
    c.accept(slice);
    Buffers.position(src, src.position() + limit);
  }

  static ByteBuffer allocate(long l) {
    return ByteBuffer.allocate(Math.toIntExact(l));
  }

  static ByteBuffer allocate(int i) {
    return ByteBuffer.allocate(i);
  }

  /**
   * Give {@code size} "snap" it to the next {@code alignmentMultiple} that is >= {@code size}.
   *
   * <p>i.e. Given 344k size, 256k alignmentMultiple expect 512k
   */
  static ByteBuffer allocateAligned(int size, int alignmentMultiple) {
    int actualSize = alignSize(size, alignmentMultiple);
    return allocate(actualSize);
  }

  static int alignSize(int size, int alignmentMultiple) {
    int alignedSize = size;
    if (size < alignmentMultiple) {
      alignedSize = alignmentMultiple;
    } else if (size % alignmentMultiple != 0) {
      // TODO: this mod will cause two divisions to happen
      //   * try and measure how expensive two divisions is compared to one
      //   * also measure the case where size is a multiple, and how much the following calculation
      //     costs

      // add almost another full alignmentMultiple to the size
      // then integer divide it before multiplying it by the alignmentMultiple
      alignedSize = (size + alignmentMultiple - 1) / alignmentMultiple * alignmentMultiple;
    } // else size is already aligned
    return alignedSize;
  }

  static int fillFrom(ByteBuffer buf, ReadableByteChannel c) throws IOException {
    return StorageChannelUtils.blockingFillFrom(buf, c);
  }

  static int emptyTo(ByteBuffer buf, WritableByteChannel c) throws IOException {
    return StorageChannelUtils.blockingEmptyTo(buf, c);
  }

  static long totalRemaining(ByteBuffer[] buffers, int offset, int length) {
    long totalRemaning = 0;
    for (int i = offset; i < length; i++) {
      ByteBuffer buffer = buffers[i];
      totalRemaning += buffer.remaining();
    }
    return totalRemaning;
  }

  static long copyUsingBuffer(ByteBuffer buf, ReadableByteChannel r, WritableByteChannel w)
      throws IOException {
    long total = 0;
    while (r.read(buf) != -1) {
      buf.flip();
      while (buf.hasRemaining()) {
        total += w.write(buf);
      }
      buf.clear();
    }
    return total;
  }
}
