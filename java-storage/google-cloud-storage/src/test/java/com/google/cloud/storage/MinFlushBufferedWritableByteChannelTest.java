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
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.cloud.storage.BufferedWritableByteChannelSession.BufferedWritableByteChannel;
import com.google.cloud.storage.DefaultBufferedWritableByteChannelTest.AuditingBufferHandle;
import com.google.cloud.storage.DefaultBufferedWritableByteChannelTest.CountingWritableByteChannelAdapter;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.providers.TypeUsage;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public final class MinFlushBufferedWritableByteChannelTest {
  private static final Logger LOGGER =
      LoggerFactory.getLogger(MinFlushBufferedWritableByteChannelTest.class);
  private static final Marker TRACE_ENTER = MarkerFactory.getMarker("enter");
  private static final Marker TRACE_EXIT = MarkerFactory.getMarker("exit");

  @Example
  void edgeCases() {
    JqwikTest.report(TypeUsage.of(WriteOps.class), arbitraryWriteOps());
  }

  @Example
  void nonBlockingWrite0DoesNotBlock() throws IOException {
    BufferHandle handle = BufferHandle.allocate(5);
    MinFlushBufferedWritableByteChannel c =
        new MinFlushBufferedWritableByteChannel(handle, new OnlyConsumeNBytes(0, 1), false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_8_3 = ByteBuffer.wrap(all.slice(0, 3).getBytes());
    int written1 = c.write(s_0_4);
    assertThat(written1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);

    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(0);
    assertThat(s_4_4.remaining()).isEqualTo(4);

    int written3 = c.write(s_8_3);
    assertThat(written3).isEqualTo(0);
    assertThat(s_8_3.remaining()).isEqualTo(3);

    assertThat(handle.remaining()).isEqualTo(1);
  }

  @Example
  void nonBlockingWritePartialDoesNotBlock() throws IOException {
    BufferHandle handle = BufferHandle.allocate(5);
    MinFlushBufferedWritableByteChannel c =
        new MinFlushBufferedWritableByteChannel(handle, new OnlyConsumeNBytes(6, 5), false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    int written1 = c.write(s_0_4);
    assertThat(written1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(1);

    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(1);
    assertThat(s_4_4.remaining()).isEqualTo(3);
    assertThat(handle.remaining()).isEqualTo(5);
  }

  @Example
  void illegalStateExceptionIfWrittenLt0() throws IOException {
    BufferHandle handle = BufferHandle.allocate(4);
    MinFlushBufferedWritableByteChannel c =
        new MinFlushBufferedWritableByteChannel(
            handle,
            new UnbufferedWritableByteChannel() {
              @Override
              public long write(ByteBuffer[] srcs, int offset, int length) {
                return -1;
              }

              @Override
              public boolean isOpen() {
                return true;
              }

              @Override
              public void close() {}
            });

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    assertThrows(IllegalStateException.class, () -> c.write(s_0_4));
  }

  @Property
  void bufferingEagerlyFlushesWhenFull(@ForAll("WriteOps") WriteOps writeOps) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(writeOps.bufferSize);
    AuditingBufferHandle handle = new AuditingBufferHandle(BufferHandle.handleOf(buffer));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new MinFlushBufferedWritableByteChannel(handle, adapter)) {

      List<Integer> actualWriteSizes = new ArrayList<>();

      for (ByteBuffer buf : writeOps.writes) {
        int write = c.write(buf);
        actualWriteSizes.add(write);
      }

      c.close();
      assertThrows(ClosedChannelException.class, () -> c.write(null));

      assertWithMessage("Unexpected write size")
          .that(actualWriteSizes)
          .isEqualTo(writeOps.writeSizes);
      assertWithMessage("Unexpected total flushed length")
          .that(adapter.writeEndPoints)
          .isEqualTo(writeOps.expectedFlushes);
      assertThat(baos.toByteArray()).isEqualTo(writeOps.bytes);
    }
  }

  /**
   * Scenario A:
   *
   * <p>Data size, and write size are smaller than buffer size
   */
  @Example
  void scenario_a() throws IOException {
    bufferingEagerlyFlushesWhenFull(WriteOps.of(1, 2, 1));
  }

  /** Scenario B: Data size and buffer size are equal, while write size may be larger than both */
  @Example
  void scenario_b() throws IOException {
    bufferingEagerlyFlushesWhenFull(WriteOps.of(1, 1, 2));
  }

  /**
   * Scenario C:
   *
   * <ul>
   *   <li>data size is evenly divisible by buffer size and write size
   *   <li>buffer size is larger than write size
   *   <li>buffer size is not evenly divisible by write size
   * </ul>
   */
  @Example
  void scenario_c() throws IOException {
    bufferingEagerlyFlushesWhenFull(WriteOps.of(105, 15, 7));
  }

  /**
   * Scenario D:
   *
   * <ul>
   *   <li>write and buffer size are smaller than data
   *   <li>data size is not evenly divisible by either write size nor buffer size
   *   <li>buffer size is smaller than write size
   *   <li>write size is not evenly divisible by buffer size
   * </ul>
   */
  @Example
  void scenario_d() throws IOException {
    bufferingEagerlyFlushesWhenFull(WriteOps.of(61, 3, 16));
  }

  /**
   * Scenario E:
   *
   * <p>Some flushes are only partially consumed. Ensure we proceed with consuming the buffer
   * provided to {@code write}
   *
   * <pre>
   *           0                        27
   * data:    |--------------------------|
   *               5       14 17        27
   * writes:  |----|--------|--|---------|
   *                       14
   * flush 1: |-------------|
   *            2          14
   * flush 2:   |-----------|
   *                        15     21
   * flush 3:                |------|
   *                                21    27
   * flush 4:                       |------|
   * </pre>
   */
  @Example
  void partialFlushOfEnqueuedBytesFlushesMultipleTimes() throws IOException {
    ByteBuffer data1 = DataGenerator.base64Characters().genByteBuffer(5);
    ByteBuffer data2 = DataGenerator.base64Characters().genByteBuffer(9);
    ByteBuffer data3 = DataGenerator.base64Characters().genByteBuffer(3);
    ByteBuffer data4 = DataGenerator.base64Characters().genByteBuffer(10);

    ImmutableList<ByteBuffer> buffers = ImmutableList.of(data1, data2, data3, data4);

    int allDataSize = buffers.stream().mapToInt(ByteBuffer::remaining).sum();
    byte[] allData =
        buffers.stream().reduce(ByteBuffer.allocate(allDataSize), ByteBuffer::put).array();
    buffers.forEach(b -> b.position(0));

    AuditingBufferHandle handle = new AuditingBufferHandle(BufferHandle.allocate(10));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new MinFlushBufferedWritableByteChannel(handle, adapter)) {

      c.write(data1); // write 5 bytes, which should enqueue in full
      // before the next write, limit the number of bytes the underlying channel will consume to 2.
      adapter.nextWriteMaxConsumptionLimit = 2L;
      // write 9 bytes, which should trigger a flush - limited to 2 bytes, leaving 3 bytes in the
      // buffer and not consuming any of the 9 bytes. Since 3 + 9 is still larger than our buffer
      // attempt another flush of 12 bytes which will all be consumed.
      c.write(data2);

      // write 3 bytes, which should enqueue in full
      c.write(data3);
      // before the next write, limit the number of bytes the underlying channel will consume to 7.
      adapter.nextWriteMaxConsumptionLimit = 7L;
      // write 10 bytes, which should trigger a flush, consuming all the buffer, but only consuming
      // 4 bytes written data. The remaining 6 bytes should be enqueued in full.
      c.write(data4);

      // close the channel, causing a flush of the 6 outstanding bytes in buffer.
      c.close();
      assertThrows(ClosedChannelException.class, () -> c.write(null));

      assertWithMessage("Unexpected total flushed length")
          .that(adapter.writeEndPoints)
          .isEqualTo(ImmutableList.of(2L, 14L, 21L, 27L));
      assertThat(baos.toByteArray()).isEqualTo(allData);
    }
  }

  /**
   * Ensure manually calling flush works.
   *
   * <pre>
   *           0         12
   * data:    |-----------|
   *             3  6  9
   * writes:  |--|--|--|--|
   *             3
   * flush 1: |--|
   *             3  6
   * flush 2:    |--|
   *               5   10
   * flush 3:      |----|
   *                   10 12
   * flush 4:           |-|
   * </pre>
   */
  @Example
  void manualFlushingIsAccurate() throws IOException {
    ByteBuffer data1 = DataGenerator.base64Characters().genByteBuffer(3);
    ByteBuffer data2 = DataGenerator.base64Characters().genByteBuffer(3);
    ByteBuffer data3 = DataGenerator.base64Characters().genByteBuffer(3);
    ByteBuffer data4 = DataGenerator.base64Characters().genByteBuffer(3);

    ImmutableList<ByteBuffer> buffers = ImmutableList.of(data1, data2, data3, data4);

    int allDataSize = buffers.stream().mapToInt(ByteBuffer::remaining).sum();
    byte[] allData =
        buffers.stream().reduce(ByteBuffer.allocate(allDataSize), ByteBuffer::put).array();
    buffers.forEach(b -> b.position(0));

    AuditingBufferHandle handle = new AuditingBufferHandle(BufferHandle.allocate(5));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new MinFlushBufferedWritableByteChannel(handle, adapter)) {

      c.write(data1); // write 3 bytes, which should enqueue in full
      c.flush(); // flush all enqueued bytes

      c.write(data2); // write 3 bytes, which should enqueue in full
      // before we call flush, limit how many bytes the underlying channel will consume to 2.
      // This should leave 1 byte in the buffer
      adapter.nextWriteMaxConsumptionLimit = 2L;
      c.flush(); // attempt to flush all enqueued bytes, however only 2 of the 3 will be consumed
      c.write(data3); // write 3 bytes, which should enqueue in full
      // after this write, our buffer should contain 4 bytes of its 5 byte capacity
      c.write(data4); // all bytes from buffer and data4 should be flushed

      c.close(); // close the channel, nothing should be enqueued so we do not expect another flush
      assertThrows(ClosedChannelException.class, () -> c.write(null));

      assertWithMessage("Unexpected total flushed length")
          .that(adapter.writeEndPoints)
          .isEqualTo(ImmutableList.of(3L, 5L, 6L, 12L));
      assertThat(baos.toByteArray()).isEqualTo(allData);
    }
  }

  @Provide("WriteOps")
  static Arbitrary<WriteOps> arbitraryWriteOps() {
    return Combinators.combine(
            Arbitraries.integers().between(1, 256 * 1024),
            Arbitraries.integers().between(1, 16 * 1024),
            Arbitraries.integers().between(1, 64 * 1024))
        .as(WriteOps::of);
  }

  /**
   *
   *
   * <pre>
   *           0                                                                                                     105
   * data:    |--------------------------------------------------------------------------------------------------------|
   *                 7     14     21     28     35     42     49     56     63     70     77     84     91     98    105
   * writes:  |------|------|------|------|------|------|------|------|------|------|------|------|------|------|------|
   *                              21                   42                   63                   84                  105
   * flushes: |--------------------|--------------------|--------------------|--------------------|--------------------|
   * </pre>
   */
  @Example
  void writeOpsOfGeneratesAccurately_1() {
    int dataSize = 105;
    int bufferSize = 15;
    int writeSize = 7;

    byte[] bytes = DataGenerator.base64Characters().genBytes(dataSize);
    ImmutableList<ByteBuffer> writes =
        ImmutableList.of(
            ByteBuffer.wrap(bytes, 0, writeSize),
            ByteBuffer.wrap(bytes, 7, writeSize),
            ByteBuffer.wrap(bytes, 14, writeSize),
            ByteBuffer.wrap(bytes, 21, writeSize),
            ByteBuffer.wrap(bytes, 28, writeSize),
            ByteBuffer.wrap(bytes, 35, writeSize),
            ByteBuffer.wrap(bytes, 42, writeSize),
            ByteBuffer.wrap(bytes, 49, writeSize),
            ByteBuffer.wrap(bytes, 56, writeSize),
            ByteBuffer.wrap(bytes, 63, writeSize),
            ByteBuffer.wrap(bytes, 70, writeSize),
            ByteBuffer.wrap(bytes, 77, writeSize),
            ByteBuffer.wrap(bytes, 84, writeSize),
            ByteBuffer.wrap(bytes, 91, writeSize),
            ByteBuffer.wrap(bytes, 98, writeSize));
    ImmutableList<Long> flushes = ImmutableList.of(21L, 42L, 63L, 84L, 105L);
    String z = "[0x00000007 * 0x0000000f]";
    WriteOps expected = new WriteOps(bytes, bufferSize, writeSize, writes, flushes, z);
    assertThat(WriteOps.of(dataSize, bufferSize, writeSize)).isEqualTo(expected);
  }

  /**
   *
   *
   * <pre>
   *           0                                                          61
   * data:    |------------------------------------------------------------|
   *                         16         (16) 32         (16) 48      (13) 61
   * writes:  |---------------|---------------|---------------|------------|
   *                         16              32              48           61
   * flushes: |---------------|---------------|---------------|------------|
   * </pre>
   */
  @Example
  void writeOpsOfGeneratesAccurately_2() {
    int dataSize = 61;
    int bufferSize = 3;
    int writeSize = 16;
    byte[] bytes = DataGenerator.base64Characters().genBytes(dataSize);
    ImmutableList<ByteBuffer> writes =
        ImmutableList.of(
            ByteBuffer.wrap(bytes, 0, writeSize),
            ByteBuffer.wrap(bytes, 16, writeSize),
            ByteBuffer.wrap(bytes, 32, writeSize),
            ByteBuffer.wrap(bytes, 48, 13));
    ImmutableList<Long> flushes = ImmutableList.of(16L, 32L, 48L, 61L);
    String z = "[0x00000010 * 0x00000003, 0x0000000d]";
    WriteOps expected = new WriteOps(bytes, bufferSize, writeSize, writes, flushes, z);
    WriteOps actual = WriteOps.of(dataSize, bufferSize, writeSize);
    assertThat(actual).isEqualTo(expected);
  }

  @Example
  @SuppressWarnings("JUnit5AssertionsConverter")
  void callingCloseWithBufferedDataShouldCallWriteAndClose() throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    AtomicBoolean closed = new AtomicBoolean(false);
    UnbufferedWritableByteChannel delegate =
        new UnbufferedWritableByteChannel() {
          @Override
          public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
            fail("unexpected write(ByteBuffer[], int, int) call");
            return 0;
          }

          @Override
          public long writeAndClose(ByteBuffer[] srcs, int offset, int length) throws IOException {
            long total = 0;
            try (WritableByteChannel out = Channels.newChannel(baos)) {
              for (ByteBuffer src : srcs) {
                total += out.write(src);
              }
            }
            closed.compareAndSet(false, true);
            return total;
          }

          @Override
          public boolean isOpen() {
            return !closed.get();
          }

          @Override
          public void close() throws IOException {
            fail("unexpected close() call");
          }
        };
    BufferedWritableByteChannel test =
        new MinFlushBufferedWritableByteChannel(BufferHandle.allocate(20), delegate);

    byte[] bytes = DataGenerator.base64Characters().genBytes(10);
    String expected = xxd(bytes);

    int write = test.write(ByteBuffer.wrap(bytes));
    assertThat(write).isEqualTo(10);

    assertThat(closed.get()).isFalse();

    test.close();

    String actual = xxd(baos.toByteArray());
    assertThat(actual).isEqualTo(expected);
    assertThat(closed.get()).isTrue();
  }

  @Property
  void bufferAllocationShouldOnlyHappenWhenNeeded(@ForAll("BufferSizes") WriteOps writeOps)
      throws IOException {
    AuditingBufferHandle handle =
        new AuditingBufferHandle(BufferHandle.allocate(writeOps.bufferSize));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new MinFlushBufferedWritableByteChannel(handle, adapter)) {

      for (ByteBuffer buf : writeOps.writes) {
        c.write(buf);
      }
    }

    // if our write size is evenly divisible by our buffer size AND our buffer size is smaller
    // than the total data size we expect to never allocate a buffer
    if (writeOps.writeSize % writeOps.bufferSize == 0
        && writeOps.bufferSize <= writeOps.bytes.length) {
      assertThat(handle.getCallCount).isEqualTo(0);
    } else {
      assertThat(handle.getCallCount).isGreaterThan(0);
    }
  }

  @Provide("BufferSizes")
  static Arbitrary<WriteOps> arbitraryBufferSizes() {
    return Arbitraries.of(
        // expect no allocation
        WriteOps.of(32, 4, 16),
        WriteOps.of(32, 16, 16),
        WriteOps.of(32, 32, 32),
        // expect allocation
        WriteOps.of(32, 33, 32),
        WriteOps.of(32, 64, 4));
  }

  private static final class WriteOps {
    private final byte[] bytes;
    private final int bufferSize;
    private final int writeSize;
    private final ImmutableList<Integer> writeSizes;
    private final ImmutableList<ByteBuffer> writes;
    private final ImmutableList<Long> expectedFlushes;
    private final String dbgExpectedWriteSizes;

    public WriteOps(
        byte[] bytes,
        int bufferSize,
        int writeSize,
        ImmutableList<ByteBuffer> writes,
        ImmutableList<Long> expectedFlushes,
        String dbgExpectedWriteSizes) {
      this.bytes = bytes;
      this.bufferSize = bufferSize;
      this.writeSize = writeSize;
      this.writeSizes =
          writes.stream().map(ByteBuffer::remaining).collect(ImmutableList.toImmutableList());
      this.writes = writes;
      this.expectedFlushes = expectedFlushes;
      this.dbgExpectedWriteSizes = dbgExpectedWriteSizes;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (!(o instanceof WriteOps)) {
        return false;
      }
      WriteOps writeOps = (WriteOps) o;
      return bufferSize == writeOps.bufferSize
          && writeSize == writeOps.writeSize
          && Arrays.equals(bytes, writeOps.bytes)
          && Objects.equals(writes, writeOps.writes)
          && Objects.equals(expectedFlushes, writeOps.expectedFlushes)
          && Objects.equals(dbgExpectedWriteSizes, writeOps.dbgExpectedWriteSizes);
    }

    @Override
    public int hashCode() {
      int result =
          Objects.hash(bufferSize, writeSize, writes, expectedFlushes, dbgExpectedWriteSizes);
      result = 31 * result + Arrays.hashCode(bytes);
      return result;
    }

    @Override
    public String toString() {
      return "[WriteOps.of("
          + fmt(bytes.length)
          + ", "
          + fmt(bufferSize)
          + ", "
          + fmt(writeSize)
          + ")] WriteOps{"
          + "bytes.length="
          + fmt(bytes.length)
          + ", bufferSize="
          + fmt(bufferSize)
          + ", writeSize="
          + fmt(writeSize)
          + ", writes.size()="
          + fmt(writes.size())
          + ", expectedFlushes.size()="
          + fmt(expectedFlushes.size())
          + ", expectedWriteSizes="
          + dbgExpectedWriteSizes
          + '}';
    }

    @NonNull
    static WriteOps of(int numBytes, int bufferSize, int writeSize) {
      byte[] bytes = DataGenerator.base64Characters().genBytes(numBytes);

      List<ByteBuffer> writes = new ArrayList<>();
      Deque<Long> expectedFlushes = new ArrayDeque<>();

      int length = bytes.length;

      int fullWriteCount = 0;
      int remainingWrite = 0;
      int prevWriteEndOffset = 0;
      for (int i = 1; i <= length; i++) {
        boolean writeBoundary = (i % writeSize == 0) || writeSize == 1;
        boolean eof = i == length;

        if (writeBoundary) {
          long lastFlush = Optional.ofNullable(expectedFlushes.peekLast()).orElse(0L);
          long sinceLastFlush = i - lastFlush;
          if (sinceLastFlush >= bufferSize) {
            expectedFlushes.addLast((long) i);
          }
          writes.add(ByteBuffer.wrap(bytes, prevWriteEndOffset, writeSize));
          fullWriteCount++;
          prevWriteEndOffset += writeSize;
        }

        if (eof) {
          // We expect a flush during close in the following scenarios:
          // the buffer size is larger than our data size (peekLast == null)
          // data size is not evenly divisible by bufferSize
          if (expectedFlushes.peekLast() == null || expectedFlushes.peekLast() != length) {
            expectedFlushes.addLast((long) length);
          }

          // If the data size is not evenly divisible by writeSize we will have an extra
          // smaller write
          if (prevWriteEndOffset != length) {
            int writeLen = Math.min(length - prevWriteEndOffset, writeSize);
            writes.add(ByteBuffer.wrap(bytes, prevWriteEndOffset, writeLen));
            remainingWrite = writeLen;
            prevWriteEndOffset += writeLen;
          }
        }
      }

      String dbgExpectedWriteSizes;
      if (fullWriteCount > 0 && remainingWrite > 0) {
        dbgExpectedWriteSizes =
            String.format(
                Locale.US,
                "[%s * %s, %s]",
                fmt(writeSize),
                fmt(fullWriteCount),
                fmt(remainingWrite));
      } else if (remainingWrite > 0) {
        dbgExpectedWriteSizes = String.format(Locale.US, "[%s]", fmt(remainingWrite));
      } else {
        dbgExpectedWriteSizes =
            String.format(Locale.US, "[%s * %s]", fmt(writeSize), fmt(fullWriteCount));
      }
      return new WriteOps(
          bytes,
          bufferSize,
          writeSize,
          ImmutableList.copyOf(writes),
          ImmutableList.copyOf(expectedFlushes),
          dbgExpectedWriteSizes);
    }
  }

  static final class OnlyConsumeNBytes implements UnbufferedWritableByteChannel {
    private static final Logger LOGGER = LoggerFactory.getLogger(OnlyConsumeNBytes.class);
    private final long bytesToConsume;
    private final int consumptionIncrement;
    private long bytesConsumed;

    OnlyConsumeNBytes(int bytesToConsume, int consumptionIncrement) {
      this.bytesToConsume = bytesToConsume;
      this.consumptionIncrement = consumptionIncrement;
      this.bytesConsumed = 0;
    }

    long getBytesConsumed() {
      return bytesConsumed;
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) {
      LOGGER.info(TRACE_ENTER, "write(srcs : {}, offset : {}, length : {})", srcs, offset, length);
      try {
        if (bytesConsumed >= bytesToConsume) {
          return 0;
        }

        long consumed = 0;
        int toConsume = consumptionIncrement;
        for (int i = offset; i < length && toConsume > 0; i++) {
          ByteBuffer src = srcs[i];
          int remaining = src.remaining();
          int position = src.position();
          int consumable = Math.min(toConsume, remaining);
          toConsume -= consumable;
          consumed += consumable;
          src.position(position + consumable);
        }
        bytesConsumed += consumed;
        return consumed;
      } finally {
        LOGGER.info(TRACE_EXIT, "write(srcs : {}, offset : {}, length : {})", srcs, offset, length);
      }
    }

    @Override
    public boolean isOpen() {
      return true;
    }

    @Override
    public void close() {}

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("bytesToConsume", bytesToConsume)
          .add("consumptionIncrement", consumptionIncrement)
          .add("bytesConsumed", bytesConsumed)
          .toString();
    }
  }
}
