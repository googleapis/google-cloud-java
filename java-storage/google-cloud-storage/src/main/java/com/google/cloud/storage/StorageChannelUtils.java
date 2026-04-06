/*
 * Copyright 2025 Google LLC
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
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 * Set of utility methods for working with non-blocking channels returned by this library.
 *
 * @since 2.56.0
 */
public final class StorageChannelUtils {

  private StorageChannelUtils() {}

  /**
   * Attempt to fill {@code buf} from {@code c}, blocking the invoking thread if necessary in order
   * to do so.
   *
   * <p>This method will not close {@code c}.
   *
   * @return The number of bytes read, possibly zero, or {@code -1} if the channel has reached
   *     end-of-stream
   * @throws IOException any IOException from calling {@link ReadableByteChannel#read(ByteBuffer)}
   * @since 2.56.0
   */
  public static int blockingFillFrom(ByteBuffer buf, ReadableByteChannel c) throws IOException {
    int total = 0;
    while (buf.hasRemaining()) {
      int read = c.read(buf);
      if (read != -1) {
        total += read;
      } else if (total == 0) {
        return -1;
      } else {
        break;
      }
    }
    return total;
  }

  /**
   * Attempt to empty {@code buf} to {@code c}, blocking the invoking thread if necessary in order
   * to do so.
   *
   * <p>This method will not close {@code c}
   *
   * @return The number of bytes written, possibly zero
   * @throws IOException any IOException from calling {@link WritableByteChannel#write(ByteBuffer)}
   * @since 2.56.0
   */
  public static int blockingEmptyTo(ByteBuffer buf, WritableByteChannel c) throws IOException {
    int total = 0;
    while (buf.hasRemaining()) {
      int written = c.write(buf);
      if (written != 0) {
        total += written;
      }
    }
    return total;
  }
}
