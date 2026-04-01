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
import static java.util.Objects.requireNonNull;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Random;
import java.util.stream.IntStream;

public abstract class DataGenerator {

  private DataGenerator() {}

  public final ByteBuffer genByteBuffer(int capacity) {
    Preconditions.checkArgument(capacity > 0, "capacity must be > 0");
    ByteBuffer bb = ByteBuffer.allocate(capacity);
    fill(bb);
    bb.position(0);
    return bb;
  }

  public final ByteBuffer genByteBuffer(long capacity) {
    return genByteBuffer(Math.toIntExact(capacity));
  }

  public final byte[] genBytes(int capacity) {
    Preconditions.checkArgument(capacity > 0, "capacity must be > 0");
    byte[] bytes = new byte[capacity];
    fill(bytes, 0, capacity);
    return bytes;
  }

  public final byte[] genBytes(long capacity) {
    return genBytes(Math.toIntExact(capacity));
  }

  public abstract void fill(ByteBuffer buf);

  public abstract void fill(byte[] b, int offset, int length);

  public final DataChain<ByteBuffer> dataChainOfByteBuffers(
      long totalCapacity, int segmentCapacity) {
    final int segmentCount;
    if (totalCapacity % segmentCapacity == 0) {
      segmentCount = Math.toIntExact(totalCapacity / segmentCapacity);
    } else {
      segmentCount = Math.toIntExact(totalCapacity / segmentCapacity) + 1;
    }
    ImmutableList<ByteBuffer> buffers;
    if (segmentCount > 1) {
      buffers =
          IntStream.range(0, segmentCount)
              .mapToObj(i -> genByteBuffer(segmentCapacity))
              .collect(ImmutableList.toImmutableList());
    } else {
      buffers = ImmutableList.of(genByteBuffer(totalCapacity));
    }
    return DataChain.ofByteBuffers(buffers);
  }

  public final TmpFile tempFile(Path baseDir, long size) throws IOException {
    requireNonNull(baseDir, "baseDir must be non null");
    checkState(size > 0, "size must be > 0");
    TmpFile bin = TmpFile.of(baseDir, String.format(Locale.US, "%015d-", size), ".bin");
    ReadableByteChannel src =
        new ReadableByteChannel() {
          long read = 0;

          @Override
          public int read(ByteBuffer dst) throws IOException {
            long remaining = size - read;
            if (remaining <= 0) {
              return -1;
            }
            int toRead = Math.toIntExact(Math.min(dst.remaining(), remaining));
            byte[] bytes = genBytes(toRead);
            dst.put(bytes);
            read += toRead;
            return toRead;
          }

          @Override
          public boolean isOpen() {
            return read < size;
          }

          @Override
          public void close() throws IOException {}
        };

    try (SeekableByteChannel dest = bin.writer()) {
      ByteStreams.copy(src, dest);
    }

    return bin;
  }

  public static DataGenerator base64Characters() {
    return new Base64CharactersDataGenerator();
  }

  public static DataGenerator rand(Random rand) {
    return new RandomDataGenerator(rand);
  }

  private static final class Base64CharactersDataGenerator extends DataGenerator {
    private static final byte[] base64Characters =
        new byte[] {
          // A-Z
          0x41,
          0x42,
          0x43,
          0x44,
          0x45,
          0x46,
          0x47,
          0x48,
          0x49,
          0x4a,
          0x4b,
          0x4c,
          0x4d,
          0x4e,
          0x4f,
          0x50,
          0x51,
          0x52,
          0x53,
          0x54,
          0x55,
          0x56,
          0x57,
          0x58,
          0x59,
          0x5a,
          // a-z
          0x61,
          0x62,
          0x63,
          0x64,
          0x65,
          0x66,
          0x67,
          0x68,
          0x69,
          0x6a,
          0x6b,
          0x6c,
          0x6d,
          0x6e,
          0x6f,
          0x70,
          0x71,
          0x72,
          0x73,
          0x74,
          0x75,
          0x76,
          0x77,
          0x78,
          0x79,
          0x7a,
          // 0-9
          0x30,
          0x31,
          0x32,
          0x33,
          0x34,
          0x35,
          0x36,
          0x37,
          0x38,
          0x39,
          // +, /
          0x2b,
          0x2f,
        };

    @Override
    public void fill(ByteBuffer buf) {
      int rem;
      while ((rem = buf.remaining()) > 0) {
        buf.put(base64Characters, 0, Math.min(rem, base64Characters.length));
      }
    }

    @Override
    public void fill(byte[] b, int offset, int length) {
      int curr = offset;
      int rem = length;
      do {
        int min = Math.min(rem, base64Characters.length);
        System.arraycopy(base64Characters, 0, b, curr, min);
        curr += min;
        rem -= min;
      } while (rem > 0);
    }
  }

  private static final class RandomDataGenerator extends DataGenerator {
    private final Random rand;

    private RandomDataGenerator(Random rand) {
      this.rand = rand;
    }

    @Override
    public void fill(ByteBuffer b) {
      while (b.position() < b.limit()) {
        byte b1 = (byte) rand.nextInt(Byte.MAX_VALUE);
        if (b1 == 0x00) { // exclude nul sequence
          continue;
        }
        b.put(b1);
      }
    }

    @Override
    public void fill(byte[] b, int offset, int length) {
      int i = 0;
      while (i < length) {
        byte b1 = (byte) rand.nextInt(Byte.MAX_VALUE);
        if (b1 == 0x00) { // exclude nul sequence
          continue;
        }
        b[offset + i] = b1;
        i++;
      }
    }
  }
}
