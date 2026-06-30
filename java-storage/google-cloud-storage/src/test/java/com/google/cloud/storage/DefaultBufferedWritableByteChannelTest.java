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
import com.google.cloud.storage.MinFlushBufferedWritableByteChannelTest.OnlyConsumeNBytes;
import com.google.cloud.storage.UnbufferedWritableByteChannelSession.UnbufferedWritableByteChannel;
import com.google.cloud.storage.it.ChecksummedTestContent;
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

public final class DefaultBufferedWritableByteChannelTest {

  @Example
  void edgeCases() {
    JqwikTest.report(TypeUsage.of(WriteOps.class), arbitraryWriteOps());
  }

  @Property
  void bufferingEagerlyFlushesWhenFull(@ForAll("WriteOps") WriteOps writeOps) throws IOException {
    ByteBuffer buffer = ByteBuffer.allocate(writeOps.bufferSize);
    AuditingBufferHandle handle = new AuditingBufferHandle(BufferHandle.handleOf(buffer));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new DefaultBufferedWritableByteChannel(handle, adapter)) {

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
   *                   10
   * flush 1: |---------|
   *            2        12
   * flush 2:   |---------|
   *                     12        22
   * flush 3:             |---------|
   *                              19    27
   * flush 4:                     |------|
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
        BufferedWritableByteChannel c = new DefaultBufferedWritableByteChannel(handle, adapter)) {

      c.write(data1); // write 5 bytes, which should enqueue in full
      // before the next write, limit the number of bytes the underlying channel will consume to 2.
      adapter.nextWriteMaxConsumptionLimit = 2L;
      // write 9 bytes, which should trigger a flush - limited to 2 bytes, leaving 3 bytes in the
      // buffer and not consuming any of the 9 bytes. Since 3 + 9 is still larger than our buffer
      // attempt another flush of 10 bytes which will all be consumed. Enqueue the remaining 2
      // bytes from data2.
      c.write(data2);

      // write 3 bytes, which should enqueue in full, leaving the buffer with 5 bytes enqueued
      c.write(data3);
      // before the next write, limit the number of bytes the underlying channel will consume to 7.
      adapter.nextWriteMaxConsumptionLimit = 7L;
      // write 10 bytes, which should trigger a flush - limited to 7 bytes, consuming all of the
      // buffer, but only consuming 2 bytes written data. The remaining 8 bytes should be
      // enqueued in full.
      c.write(data4);

      // close the channel, causing a flush of the 8 outstanding bytes in buffer.
      c.close();
      assertThrows(ClosedChannelException.class, () -> c.write(null));

      assertWithMessage("Unexpected total flushed length")
          .that(adapter.writeEndPoints)
          .isEqualTo(ImmutableList.of(2L, 12L, 19L, 27L));
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
        BufferedWritableByteChannel c = new DefaultBufferedWritableByteChannel(handle, adapter)) {

      c.write(data1); // write 3 bytes, which should enqueue in full
      c.flush(); // flush all enqueued bytes

      c.write(data2); // write 3 bytes, which should enqueue in full
      // before we call flush, limit how many bytes the underlying channel will consume to 2.
      // This should leave 1 byte in the buffer
      adapter.nextWriteMaxConsumptionLimit = 2L;
      c.flush(); // attempt to flush all enqueued bytes, however only 2 of the 3 will be consumed
      c.write(data3); // write 3 bytes, which should enqueue in full
      // after this write, our buffer should contain 4 bytes of its 5 byte capacity
      // on the next write, 5 bytes should be flushed. 4 from the buffer, 1 from the written data
      c.write(data4); // 1 of the 3 bytes will be flushed, leaving 2 bytes in the buffer

      c.close(); // close the channel, which should flush the 2 outstanding buffered bytes
      assertThrows(ClosedChannelException.class, () -> c.write(null));

      assertWithMessage("Unexpected total flushed length")
          .that(adapter.writeEndPoints)
          .isEqualTo(ImmutableList.of(3L, 5L, 6L, 11L, 12L));
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
   *                        15             30             45             60             75             90            105
   * flushes: |--------------|--------------|--------------|--------------|--------------|--------------|--------------|
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
    ImmutableList<Long> flushes = ImmutableList.of(15L, 30L, 45L, 60L, 75L, 90L, 105L);
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
   *             3  6  9 12 15 18 21 24 27 30 33 36 39 42 45 48 51 54 57 60
   * flushes: |--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--|--||
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
    ImmutableList<Long> flushes =
        ImmutableList.of(
            3L, 6L, 9L, 12L, 15L, 18L, 21L, 24L, 27L, 30L, 33L, 36L, 39L, 42L, 45L, 48L, 51L, 54L,
            57L, 60L, 61L);
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
    DefaultBufferedWritableByteChannel test =
        new DefaultBufferedWritableByteChannel(BufferHandle.allocate(20), delegate);

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

  @Example
  void nonBlockingWrite0DoesNotBlock() throws IOException {
    BufferHandle handle = BufferHandle.allocate(5);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, new OnlyConsumeNBytes(0, 1), false);

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
  void nonBlockingWritePartialDoesNotBlock_withoutBuffering() throws IOException {
    BufferHandle handle = BufferHandle.allocate(4);
    OnlyConsumeNBytes channel = new OnlyConsumeNBytes(4, 4);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, channel, false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(13);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(4, 4).getBytes());

    // write all 4 bytes
    int written1 = c.write(s_0_4);
    assertThat(written1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(4);
    assertThat(channel.getBytesConsumed()).isEqualTo(4);

    // Attempt to write 4 bytes, but 0 will be consumed, break out without consuming any
    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(0);
    assertThat(s_4_4.remaining()).isEqualTo(4);
    assertThat(handle.remaining()).isEqualTo(4);
    assertThat(channel.getBytesConsumed()).isEqualTo(4);
  }

  @Example
  void nonBlockingWritePartialDoesNotBlock_withoutBuffering_oversized() throws IOException {
    BufferHandle handle = BufferHandle.allocate(2);
    OnlyConsumeNBytes channel = new OnlyConsumeNBytes(4, 2);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, channel, false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(13);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(4, 4).getBytes());

    // write all 4 bytes
    int written1 = c.write(s_0_4);
    assertThat(written1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(2);
    assertThat(channel.getBytesConsumed()).isEqualTo(4);

    // Attempt to write 4 bytes, but 0 will be consumed, break out without consuming any
    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(0);
    assertThat(s_4_4.remaining()).isEqualTo(4);
    assertThat(handle.remaining()).isEqualTo(2);
    assertThat(channel.getBytesConsumed()).isEqualTo(4);
  }

  @Example
  void nonBlockingWritePartialDoesNotBlock_withBuffering() throws IOException {
    BufferHandle handle = BufferHandle.allocate(5);
    OnlyConsumeNBytes channel = new OnlyConsumeNBytes(5, 5);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, channel, false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(13);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(4, 4).getBytes());
    ByteBuffer s_8_12 = ByteBuffer.wrap(all.slice(8, 4).getBytes());

    // write all 4 bytes
    int written1 = c.write(s_0_4);
    assertThat(written1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(1);
    assertThat(channel.getBytesConsumed()).isEqualTo(0);

    //
    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(4);
    assertThat(s_4_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(2);
    assertThat(channel.getBytesConsumed()).isEqualTo(5);

    int written3 = c.write(s_8_12);
    assertThat(written3).isEqualTo(0);
    assertThat(s_8_12.remaining()).isEqualTo(4);
    assertThat(handle.remaining()).isEqualTo(2);
    assertThat(channel.getBytesConsumed()).isEqualTo(5);
  }

  @Example
  void nonBlockingWritePartialDoesNotBlock_withBuffering_oversized() throws IOException {
    BufferHandle handle = BufferHandle.allocate(3);
    OnlyConsumeNBytes channel = new OnlyConsumeNBytes(6, 3);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, channel, false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(13);
    ByteBuffer s_0_4 = ByteBuffer.wrap(all.slice(0, 4).getBytes());
    ByteBuffer s_4_4 = ByteBuffer.wrap(all.slice(4, 4).getBytes());
    ByteBuffer s_8_12 = ByteBuffer.wrap(all.slice(8, 4).getBytes());

    // slice 3 bytes and consume them, then enqueue the remaining 1 byte
    int written1_1 = c.write(s_0_4);
    assertThat(written1_1).isEqualTo(4);
    assertThat(s_0_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(2);
    assertThat(channel.getBytesConsumed()).isEqualTo(3);

    // write 1 buffered byte and 2 sliced bytes, enqueue 2 remaining
    int written2 = c.write(s_4_4);
    assertThat(written2).isEqualTo(4);
    assertThat(s_4_4.remaining()).isEqualTo(0);
    assertThat(handle.remaining()).isEqualTo(1);
    assertThat(channel.getBytesConsumed()).isEqualTo(6);

    // attempt to write 4 bytes, non will be consumed and the buffer should remain the same
    int written3 = c.write(s_8_12);
    assertThat(written3).isEqualTo(0);
    assertThat(s_8_12.remaining()).isEqualTo(4);
    assertThat(handle.remaining()).isEqualTo(1);
    assertThat(channel.getBytesConsumed()).isEqualTo(6);
  }

  @Example
  void illegalStateExceptionIfWrittenLt0_slice_eqBuffer() {
    BufferHandle handle = BufferHandle.allocate(4);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, new NegativeOneWritableByteChannel(), false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    IllegalStateException ise =
        assertThrows(IllegalStateException.class, () -> c.write(all.slice(0, 4).asByteBuffer()));
    ise.printStackTrace(System.out);
  }

  @Example
  void illegalStateExceptionIfWrittenLt0_slice_gtBuffer() {
    BufferHandle handle = BufferHandle.allocate(4);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, new NegativeOneWritableByteChannel(), false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    IllegalStateException ise =
        assertThrows(IllegalStateException.class, () -> c.write(all.slice(0, 5).asByteBuffer()));
    ise.printStackTrace(System.out);
  }

  @Example
  void illegalStateExceptionIfWrittenLt0_slice_ltBuffer() {
    BufferHandle handle = BufferHandle.allocate(4);
    DefaultBufferedWritableByteChannel c =
        new DefaultBufferedWritableByteChannel(handle, new NegativeOneWritableByteChannel(), false);

    ChecksummedTestContent all = ChecksummedTestContent.gen(11);
    IllegalStateException ise =
        assertThrows(
            IllegalStateException.class,
            () -> {
              int written1 = c.write(all.slice(0, 3).asByteBuffer());
              assertThat(written1).isEqualTo(3);
              c.write(all.slice(3, 3).asByteBuffer());
              fail("should have errored in previous write call");
            });
    ise.printStackTrace(System.out);
  }

  @Example
  void test() {
    illegalStateExceptionIfWrittenLt0_slice_eqBuffer();
    illegalStateExceptionIfWrittenLt0_slice_gtBuffer();
    illegalStateExceptionIfWrittenLt0_slice_ltBuffer();
  }

  @Property
  void bufferAllocationShouldOnlyHappenWhenNeeded(@ForAll("BufferSizes") WriteOps writeOps)
      throws IOException {
    AuditingBufferHandle handle =
        new AuditingBufferHandle(BufferHandle.allocate(writeOps.bufferSize));
    try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
        CountingWritableByteChannelAdapter adapter =
            new CountingWritableByteChannelAdapter(Channels.newChannel(baos));
        BufferedWritableByteChannel c = new DefaultBufferedWritableByteChannel(handle, adapter)) {

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
    static WriteOps of(int byteSize, int bufferSize, int writeSize) {
      byte[] bytes = DataGenerator.base64Characters().genBytes(byteSize);

      List<ByteBuffer> writes = new ArrayList<>();
      Deque<Long> expectedFlushes = new ArrayDeque<>();

      int length = bytes.length;

      int fullWriteCount = 0;
      int remainingWrite = 0;
      int prevWriteEndOffset = 0;
      for (int i = 1; i <= length; i++) {
        boolean flushBoundary = (i % bufferSize == 0) || bufferSize == 1;
        boolean writeBoundary = (i % writeSize == 0) || writeSize == 1;
        boolean eof = i == length;

        if (flushBoundary) {
          expectedFlushes.addLast((long) i);
        }

        if (writeBoundary) {
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

  /**
   * Adapter to make any {@link WritableByteChannel} into an {@link UnbufferedWritableByteChannel}
   */
  static final class CountingWritableByteChannelAdapter implements UnbufferedWritableByteChannel {

    private final WritableByteChannel c;

    final List<Long> writeEndPoints;
    long totalBytesWritten;

    long nextWriteMaxConsumptionLimit = Long.MAX_VALUE;

    CountingWritableByteChannelAdapter(WritableByteChannel c) {
      this.c = c;
      writeEndPoints = new ArrayList<>();
    }

    @Override
    public int write(ByteBuffer src) throws IOException {
      return Math.toIntExact(write(new ByteBuffer[] {src}, 0, 1));
    }

    @Override
    public long write(ByteBuffer[] srcs) throws IOException {
      return write(srcs, 0, srcs.length);
    }

    @Override
    public long write(ByteBuffer[] srcs, int offset, int length) throws IOException {
      if (!c.isOpen()) {
        return -1;
      }

      long budgetRemaining = nextWriteMaxConsumptionLimit;
      nextWriteMaxConsumptionLimit = Long.MAX_VALUE;

      long bytesWriten = 0;
      for (int i = offset; i < length && budgetRemaining > 0; i++) {
        ByteBuffer src = srcs[i];
        if (src.hasRemaining()) {
          ByteBuffer slice = src.slice();
          int remaining = src.remaining();
          int newLimit = Math.toIntExact(Math.min(budgetRemaining, remaining));
          slice.limit(newLimit);
          int write = c.write(slice);
          if (write == -1) {
            if (bytesWriten == 0) {
              c.close();
              return -1;
            } else {
              break;
            }
          } else if (write == 0) {
            break;
          } else {
            src.position(src.position() + write);
          }
          budgetRemaining -= write;
          bytesWriten += write;
        }
      }
      incr(bytesWriten);
      return bytesWriten;
    }

    @Override
    public boolean isOpen() {
      return c.isOpen();
    }

    @Override
    public void close() throws IOException {
      c.close();
    }

    private void incr(long bytesWritten) {
      if (bytesWritten > 0) {
        totalBytesWritten += bytesWritten;
        writeEndPoints.add(totalBytesWritten);
      }
    }
  }

  static final class AuditingBufferHandle extends BufferHandle {
    private final BufferHandle delegate;

    int getCallCount = 0;

    AuditingBufferHandle(BufferHandle delegate) {
      this.delegate = delegate;
    }

    @Override
    public int remaining() {
      return delegate.remaining();
    }

    @Override
    public int capacity() {
      return delegate.capacity();
    }

    @Override
    public int position() {
      return delegate.position();
    }

    @Override
    public ByteBuffer get() {
      getCallCount++;
      return delegate.get();
    }
  }

  private static class NegativeOneWritableByteChannel implements UnbufferedWritableByteChannel {

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
  }
}
