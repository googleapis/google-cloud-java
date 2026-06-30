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

import static com.google.cloud.storage.ChunkSegmenterTest.TestData.fmt;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.BufferedReadableByteChannelSession.BufferedReadableByteChannel;
import com.google.cloud.storage.UnbufferedReadableByteChannelSession.UnbufferedReadableByteChannel;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Streams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.ReadableByteChannel;
import java.util.Locale;
import java.util.stream.IntStream;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.NonNull;

public final class DefaultBufferedReadableByteChannelTest {

  @Example
  void edgeCases() {
    JqwikTest.report(TypeUsage.of(ReadOps.class), arbitraryReadOps());
  }

  @Example
  void _61bytes_should_read_16_16_16_13_whenRead16AtATime() throws IOException {
    byte[] bytes = DataGenerator.base64Characters().genBytes(61);

    ByteBuffer buf = ByteBuffer.allocate(16);
    BufferHandle buffer = BufferHandle.allocate(3);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        UnbufferedReadableByteChannelAdapter adapter =
            new UnbufferedReadableByteChannelAdapter(Channels.newChannel(bais));
        BufferedReadableByteChannel c = new DefaultBufferedReadableByteChannel(buffer, adapter)) {
      int read1 = c.read(buf);
      assertThat(buffer.remaining()).isEqualTo(1);
      assertThat(read1).isEqualTo(16);
      buf.clear();
      int read2 = c.read(buf);
      assertThat(buffer.remaining()).isEqualTo(2);
      assertThat(read2).isEqualTo(16);
      buf.clear();
      int read3 = c.read(buf);
      assertThat(buffer.remaining()).isEqualTo(3);
      assertThat(read3).isEqualTo(16);
      buf.clear();
      int read4 = c.read(buf);
      assertThat(buffer.remaining()).isEqualTo(3);
      assertThat(read4).isEqualTo(13);
    }
  }

  @Property
  void bufferingOnlyRequiresExpectedReads(@ForAll("ReadOps") ReadOps readOps) throws IOException {
    if (CIUtils.verbose()) {
      System.out.println("readOps = " + readOps);
    }
    byte[] bytes = readOps.bytes;

    ByteBuffer buf = ByteBuffer.allocate(readOps.readSize);
    BufferHandle buffer = BufferHandle.allocate(readOps.bufferSize);
    try (ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        UnbufferedReadableByteChannelAdapter adapter =
            new UnbufferedReadableByteChannelAdapter(Channels.newChannel(bais));
        BufferedReadableByteChannel c = new DefaultBufferedReadableByteChannel(buffer, adapter)) {
      ImmutableList<Integer> expectedReadSizes = readOps.expectedReadSizes;
      int maxReadIdx = expectedReadSizes.size() - 1;

      int i = 0;
      int read;
      // repeatedly read from `c` until we read EOF
      while ((read = c.read(buf)) != -1) {
        // ensure the read that just succeeded matches the expected size
        if (i <= maxReadIdx) {
          int expectedReadSize = expectedReadSizes.get(i);
          assertThat(read).isEqualTo(expectedReadSize);
          buf.clear();
        } else {
          assertWithMessage("More reads than expected").that(i).isAtMost(maxReadIdx);
        }
        i++;
      }
      assertThrows(ClosedChannelException.class, () -> c.read(null));
    }
  }

  @Provide("ReadOps")
  static Arbitrary<ReadOps> arbitraryReadOps() {
    return Combinators.combine(
            Arbitraries.integers().between(1, 256 * 1024),
            Arbitraries.integers().between(1, 16 * 1024),
            Arbitraries.integers().between(1, 64 * 1024))
        .as(ReadOps::of);
  }

  private static final class ReadOps {
    private final byte[] bytes;
    private final int bufferSize;
    private final int readSize;

    private final ImmutableList<Integer> expectedReadSizes;
    private final String dbgExpectedReadSizes;

    ReadOps(byte[] bytes, int bufferSize, int readSize) {
      this.bytes = bytes;
      this.bufferSize = bufferSize;
      this.readSize = readSize;

      int fullReadCount = bytes.length / readSize;
      int remainingRead = (bytes.length - fullReadCount * readSize);
      expectedReadSizes =
          Streams.concat(
                  IntStream.range(0, fullReadCount).map(i -> readSize),
                  IntStream.of(remainingRead).filter(i -> i > 0))
              .boxed()
              .collect(ImmutableList.toImmutableList());

      if (fullReadCount > 0 && remainingRead > 0) {
        dbgExpectedReadSizes =
            String.format(Locale.US, "[%s * %d, %s]", readSize, fullReadCount, remainingRead);
      } else if (remainingRead > 0) {
        dbgExpectedReadSizes = String.format(Locale.US, "[%s]", remainingRead);
      } else {
        dbgExpectedReadSizes = String.format(Locale.US, "[%s * %d]", readSize, fullReadCount);
      }
    }

    @Override
    public String toString() {
      return "ReadOps{"
          + "bytes.length="
          + fmt(bytes.length)
          + ", bufferSize="
          + fmt(bufferSize)
          + ", readSize="
          + fmt(readSize)
          + ", expectedReadSizes="
          + dbgExpectedReadSizes
          + '}';
    }

    @NonNull
    static ReadOps of(int byteSize, int bufferSize, int readSize) {
      byte[] bytes = DataGenerator.base64Characters().genBytes(byteSize);
      return new ReadOps(bytes, bufferSize, readSize);
    }
  }

  /**
   * Adapter to make any {@link ReadableByteChannel} into an {@link UnbufferedReadableByteChannel}
   */
  private static final class UnbufferedReadableByteChannelAdapter
      implements UnbufferedReadableByteChannel {

    private final ReadableByteChannel c;

    private UnbufferedReadableByteChannelAdapter(ReadableByteChannel c) {
      this.c = c;
    }

    @Override
    public int read(ByteBuffer dst) throws IOException {
      return Math.toIntExact(read(new ByteBuffer[] {dst}, 0, 1));
    }

    @Override
    public long read(ByteBuffer[] dsts) throws IOException {
      return read(dsts, 0, dsts.length);
    }

    @Override
    public long read(ByteBuffer[] dsts, int offset, int length) throws IOException {
      if (!c.isOpen()) {
        return -1;
      }

      long totalBytesRead = 0;
      for (int i = offset; i < length; i++) {
        ByteBuffer dst = dsts[i];
        if (dst.hasRemaining()) {
          int read = c.read(dst);
          if (read == -1) {
            if (totalBytesRead == 0) {
              c.close();
              return -1;
            } else {
              break;
            }
          }
          totalBytesRead += read;
        }
      }
      return totalBytesRead;
    }

    @Override
    public boolean isOpen() {
      return c.isOpen();
    }

    @Override
    public void close() throws IOException {
      c.close();
    }
  }
}
