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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.ChunkSegmenter.ChunkSegment;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.common.collect.ImmutableList;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import com.google.protobuf.ByteString;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Example;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.RandomDistribution;

final class ChunkSegmenterTest {
  private static final int _2MiB = 2 * 1024 * 1024;

  @Property
  void chunkIt(@ForAll("TestData") TestData td) {
    if (CIUtils.verbose()) {
      System.out.println("td = " + td);
    }

    ChunkSegment[] data =
        new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), td.chunkSize)
            .segmentBuffers(td.buffers);

    long dataTotalSize = Arrays.stream(data).mapToLong(d -> d.getB().size()).sum();
    Optional<Crc32cLengthKnown> reduce =
        Arrays.stream(data)
            .map(ChunkSegment::getCrc32c)
            .filter(Objects::nonNull)
            .reduce(Crc32cValue::concat);

    assertThat(dataTotalSize).isEqualTo(td.totalSize);
    assertThat(data).hasLength(td.expectedChunkCount);
    assertThat(reduce).isAnyOf(Optional.empty(), Optional.of(Crc32cValue.of(td.allCrc32c.asInt())));
  }

  /**
   *
   *
   * <pre>
   * Given 64 bytes, maxSegmentSize: 10, blockSize: 5
   * 0                                                              64
   * |---------------------------------------------------------------|
   *   Produce 6 10-byte segments
   * |---------|---------|---------|---------|---------|---------|
   * </pre>
   */
  @Example
  void allowUnalignedBlocks_false_1() {
    ChunkSegmenter segmenter =
        new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 10, 5);

    byte[] bytes = DataGenerator.base64Characters().genBytes(64);
    List<ByteString> expected =
        ImmutableList.of(
            ByteString.copyFrom(bytes, 0, 10),
            ByteString.copyFrom(bytes, 10, 10),
            ByteString.copyFrom(bytes, 20, 10),
            ByteString.copyFrom(bytes, 30, 10),
            ByteString.copyFrom(bytes, 40, 10),
            ByteString.copyFrom(bytes, 50, 10));

    ByteBuffer buf = ByteBuffer.wrap(bytes);

    ChunkSegment[] segments = segmenter.segmentBuffers(new ByteBuffer[] {buf}, 0, 1, false);
    assertThat(buf.remaining()).isEqualTo(4);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertThat(actual).isEqualTo(expected);
  }

  /**
   *
   *
   * <pre>
   * Given 64 bytes, maxSegmentSize: 14, blockSize: 7
   * 0                                                              64
   * |---------------------------------------------------------------|
   *   Produce 4 14-byte segments, and one 7 byte segment
   * |-------------|-------------|-------------|-------------|------|
   * </pre>
   */
  @Example
  void allowUnalignedBlocks_false_2() throws Exception {
    ChunkSegmenter segmenter =
        new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 14, 7);

    byte[] bytes = DataGenerator.base64Characters().genBytes(64);
    List<ByteString> expected =
        ImmutableList.of(
            ByteString.copyFrom(bytes, 0, 14),
            ByteString.copyFrom(bytes, 14, 14),
            ByteString.copyFrom(bytes, 28, 14),
            ByteString.copyFrom(bytes, 42, 14),
            ByteString.copyFrom(bytes, 56, 7));

    ByteBuffer buf = ByteBuffer.wrap(bytes);

    ChunkSegment[] segments = segmenter.segmentBuffers(new ByteBuffer[] {buf}, 0, 1, false);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertAll(
        () -> assertThat(buf.remaining()).isEqualTo(1),
        () -> assertThat(actual).isEqualTo(expected));
  }

  /**
   *
   *
   * <pre>
   * Given 60 bytes in one buffer and 4 bytes in a second buffer, maxSegmentSize: 14, blockSize: 7
   * 0                                                          60   4
   * |-----------------------------------------------------------|---|
   *   Produce 4 14-byte segments, and one 7 byte segment
   * |-------------|-------------|-------------|-------------|------|
   * </pre>
   */
  @Example
  void allowUnalignedBlocks_false_3() throws Exception {
    ChunkSegmenter segmenter =
        new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 14, 7);

    byte[] bytes = DataGenerator.base64Characters().genBytes(64);
    List<ByteString> expected =
        ImmutableList.of(
            ByteString.copyFrom(bytes, 0, 14),
            ByteString.copyFrom(bytes, 14, 14),
            ByteString.copyFrom(bytes, 28, 14),
            ByteString.copyFrom(bytes, 42, 14),
            ByteString.copyFrom(bytes, 56, 7));

    ByteBuffer buf1 = ByteBuffer.wrap(bytes, 0, 60);
    ByteBuffer buf2 = ByteBuffer.wrap(bytes, 60, 4);

    ChunkSegment[] segments = segmenter.segmentBuffers(new ByteBuffer[] {buf1, buf2}, 0, 2, false);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertAll(
        () -> assertThat(buf1.remaining()).isEqualTo(0),
        () -> assertThat(buf2.remaining()).isEqualTo(1),
        () -> assertThat(actual).isEqualTo(expected));
  }

  @Example
  void maxBytesToConsume_unaligned() throws Exception {

    ChecksummedTestContent ctc = ChecksummedTestContent.gen(64);

    ChunkSegmenter segmenter = new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 6, 3);

    List<ChecksummedTestContent> chunks = ctc.chunkup(4);
    ByteBuffer[] buffers =
        chunks.stream().map(ChecksummedTestContent::asByteBuffer).toArray(ByteBuffer[]::new);
    buffers[1].position(1);

    ChecksummedTestContent slice = ctc.slice(5, 37);
    List<ByteString> expected =
        slice.chunkup(6).stream()
            .map(ChecksummedTestContent::asByteBuffer)
            .map(ByteStringStrategy.noCopy())
            .collect(Collectors.toList());

    ChunkSegment[] segments = segmenter.segmentBuffers(buffers, 1, buffers.length - 2, true, 37);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertThat(actual).isEqualTo(expected);
  }

  @Example
  void maxBytesToConsume_aligned() throws Exception {

    ChecksummedTestContent ctc = ChecksummedTestContent.gen(64);

    ChunkSegmenter segmenter = new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 6, 3);

    List<ChecksummedTestContent> chunks = ctc.chunkup(4);
    ByteBuffer[] buffers =
        chunks.stream().map(ChecksummedTestContent::asByteBuffer).toArray(ByteBuffer[]::new);
    buffers[1].position(1);

    ChecksummedTestContent slice = ctc.slice(5, 36);
    List<ByteString> expected =
        slice.chunkup(6).stream()
            .map(ChecksummedTestContent::asByteBuffer)
            .map(ByteStringStrategy.noCopy())
            .collect(Collectors.toList());

    ChunkSegment[] segments = segmenter.segmentBuffers(buffers, 1, buffers.length - 2, false, 37);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertThat(actual).isEqualTo(expected);
  }

  @Example
  void alignedConsumeForLargeBuffersOnlyConsumesAligned() throws Exception {

    ChecksummedTestContent ctc = ChecksummedTestContent.gen(2048 + 13);

    ChunkSegmenter segmenter =
        new ChunkSegmenter(Hasher.noop(), ByteStringStrategy.noCopy(), 2048, 256);

    ChecksummedTestContent slice = ctc.slice(0, 2048);
    List<ByteString> expected =
        slice.chunkup(2048).stream()
            .map(ChecksummedTestContent::asByteBuffer)
            .map(ByteStringStrategy.noCopy())
            .collect(Collectors.toList());

    ByteBuffer buf = ctc.asByteBuffer();
    ChunkSegment[] segments = segmenter.segmentBuffers(new ByteBuffer[] {buf}, 0, 1, false);
    List<ByteString> actual =
        Arrays.stream(segments).map(ChunkSegment::getB).collect(Collectors.toList());
    assertThat(actual).isEqualTo(expected);
  }

  @Provide("TestData")
  static Arbitrary<TestData> arbitraryTestData() {
    return Arbitraries.lazyOf(
            () ->
                Arbitraries.lazyOf(
                        () ->
                            Arbitraries.integers()
                                .greaterOrEqual(1)
                                .lessOrEqual(8 * 1024 * 1024)
                                .withDistribution(RandomDistribution.uniform()))
                    .map(DataGenerator.base64Characters()::genBytes)
                    .array(byte[][].class)
                    .ofMinSize(0)
                    .ofMaxSize(10)
                    .withSizeDistribution(RandomDistribution.uniform()))
        .map(TestData::create);
  }

  static final class TestData {
    private final int chunkSize;
    private final long totalSize;
    private final int expectedChunkCount;
    private final byte[][] originalData;
    private final ByteBuffer[] buffers;
    private final HashCode allCrc32c;

    private TestData(
        long totalSize,
        int expectedChunkCount,
        byte[][] originalData,
        ByteBuffer[] buffers,
        HashCode allCrc32c,
        int chunkSize) {
      this.totalSize = totalSize;
      this.expectedChunkCount = expectedChunkCount;
      this.originalData = originalData;
      this.buffers = buffers;
      this.allCrc32c = allCrc32c;
      this.chunkSize = chunkSize;
    }

    @Override
    public String toString() {
      return "TestData{"
          + "chunkSize="
          + fmt(chunkSize)
          + ", totalSize="
          + fmt(totalSize)
          + ", expectedChunkCount="
          + fmt(expectedChunkCount)
          + ", allCrc32c="
          + allCrc32c
          + ", originalDataLengths="
          + Arrays.toString(
              Arrays.stream(originalData).mapToInt(x -> x.length).mapToObj(TestData::fmt).toArray())
          + '}';
    }

    @SuppressWarnings("UnstableApiUsage")
    static TestData create(byte[][] bs) {
      long totalSize = 0;
      HashCode allCrc32c;
      int expectedChunkCount;
      com.google.common.hash.Hasher hasher = Hashing.crc32c().newHasher();
      for (byte[] bb : bs) {
        totalSize += bb.length;
        hasher.putBytes(bb);
      }
      allCrc32c = hasher.hash();

      int chunkSize = _2MiB;
      expectedChunkCount = Math.toIntExact(totalSize / chunkSize);
      if (totalSize % chunkSize != 0) {
        expectedChunkCount++;
      }

      ByteBuffer[] bbs = Arrays.stream(bs).map(ByteBuffer::wrap).toArray(ByteBuffer[]::new);

      return new TestData(totalSize, expectedChunkCount, bs, bbs, allCrc32c, chunkSize);
    }

    static String fmt(int i) {
      return String.format(Locale.US, "0x%08x", i);
    }

    static String fmt(long i) {
      return String.format(Locale.US, "0x%016x", i);
    }
  }
}
