/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.spanner.spi.v1;

import com.google.api.core.InternalApi;
import java.util.Arrays;

/**
 * A simple, unsynchronized byte array output stream optimized for key encoding.
 *
 * <p>Unlike {@link java.io.ByteArrayOutputStream}, this class is not thread-safe and does not incur
 * synchronization overhead. This provides better performance for single-threaded key encoding
 * operations where synchronization is not required.
 */
@InternalApi
public final class UnsynchronizedByteArrayOutputStream {

  private byte[] buf;
  private int count;

  /** Creates a new output stream with a default initial capacity of 32 bytes. */
  public UnsynchronizedByteArrayOutputStream() {
    this(32);
  }

  /**
   * Creates a new output stream with the specified initial capacity.
   *
   * @param initialCapacity the initial buffer size
   * @throws IllegalArgumentException if initialCapacity is negative
   */
  public UnsynchronizedByteArrayOutputStream(int initialCapacity) {
    if (initialCapacity < 0) {
      throw new IllegalArgumentException("Negative initial capacity: " + initialCapacity);
    }
    this.buf = new byte[initialCapacity];
  }

  private void ensureCapacity(int minCapacity) {
    if (minCapacity > buf.length) {
      int newCapacity = Math.max(buf.length << 1, minCapacity);
      buf = Arrays.copyOf(buf, newCapacity);
    }
  }

  /**
   * Writes the specified byte to this output stream.
   *
   * @param b the byte to write (only the low 8 bits are used)
   */
  public void write(int b) {
    ensureCapacity(count + 1);
    buf[count++] = (byte) b;
  }

  /**
   * Writes a portion of a byte array to this output stream.
   *
   * @param b the source byte array
   * @param off the start offset in the array
   * @param len the number of bytes to write
   */
  public void write(byte[] b, int off, int len) {
    ensureCapacity(count + len);
    System.arraycopy(b, off, buf, count, len);
    count += len;
  }

  /**
   * Returns a copy of the buffer contents as a new byte array.
   *
   * @return a new byte array containing the written bytes
   */
  public byte[] toByteArray() {
    return Arrays.copyOf(buf, count);
  }

  /** Resets the buffer so that it can be reused. The underlying buffer is retained. */
  public void reset() {
    count = 0;
  }

  /**
   * Returns the current number of bytes written to this stream.
   *
   * @return the number of valid bytes in the buffer
   */
  public int size() {
    return count;
  }
}
