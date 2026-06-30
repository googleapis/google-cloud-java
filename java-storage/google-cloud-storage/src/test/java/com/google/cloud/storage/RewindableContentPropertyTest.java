/*
 * Copyright 2023 Google LLC
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

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.common.base.MoreObjects;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.Combinators;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;
import net.jqwik.api.RandomDistribution;
import org.checkerframework.checker.nullness.qual.NonNull;

final class RewindableContentPropertyTest {

  @Property
  void path(@ForAll("PathScenario") PathScenario pathScenario) throws Exception {
    try (PathScenario s = pathScenario) {
      RewindableContent content = RewindableContent.of(s.getPath());
      assertThrows(
          IOException.class,
          () -> {
            try (ErroringOutputStream erroringOutputStream =
                new ErroringOutputStream(s.getErrorAtOffset())) {
              content.writeTo(erroringOutputStream);
            }
          });
      content.rewindTo(s.getRewindOffset());

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      content.writeTo(baos);

      String actual = xxd(baos.toByteArray());

      assertThat(actual).isEqualTo(s.getExpectedXxd());
    }
  }

  @Property
  void byteBuffers(@ForAll("ByteBuffersScenario") ByteBuffersScenario s) throws IOException {
    RewindableContent content = RewindableContent.of(s.getBuffers());
    assertThat(content.getLength()).isEqualTo(s.getFullLength());
    assertThrows(
        IOException.class,
        () -> {
          try (ErroringOutputStream erroringOutputStream =
              new ErroringOutputStream(s.getErrorAtOffset())) {
            content.writeTo(erroringOutputStream);
          }
        });
    content.rewindTo(s.getRewindOffset());
    assertThat(content.getLength()).isEqualTo(s.getPostRewindLength());

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    content.writeTo(baos);

    String actual = xxd(baos.toByteArray());

    assertThat(actual).isEqualTo(s.getExpectedXxd());
  }

  @Provide("PathScenario")
  static Arbitrary<PathScenario> pathScenario() {
    return Arbitraries.lazyOf(
        () ->
            Arbitraries.oneOf(
                    bytes(1, 10),
                    bytes(10, 100),
                    bytes(100, 1_000),
                    bytes(1_000, 10_000),
                    bytes(10_000, 100_000),
                    bytes(100_000, 1_000_000),
                    bytes(1_000_000, 10_000_000))
                .flatMap(
                    bytes ->
                        Combinators.combine(
                                Arbitraries.integers().between(0, bytes.length - 1),
                                Arbitraries.integers().between(0, bytes.length - 1),
                                Arbitraries.just(bytes))
                            .as(PathScenario::of)));
  }

  @Provide("ByteBuffersScenario")
  static Arbitrary<ByteBuffersScenario> byteBuffersScenarioArbitrary() {
    return Arbitraries.lazyOf(
            () ->
                Arbitraries.oneOf(
                    byteBuffers(1, 10),
                    byteBuffers(10, 100),
                    byteBuffers(100, 1_000),
                    byteBuffers(1_000, 10_000),
                    byteBuffers(10_000, 100_000),
                    byteBuffers(100_000, 1_000_000)))
        .flatMap(
            buffers -> {
              long totalAvailable = Arrays.stream(buffers).mapToLong(ByteBuffer::remaining).sum();

              return Combinators.combine(
                      Arbitraries.longs().between(0, Math.max(0L, totalAvailable - 1)),
                      Arbitraries.longs().between(0, Math.max(0L, totalAvailable - 1)),
                      Arbitraries.just(buffers))
                  .as(ByteBuffersScenario::of);
            })
        .filter(bbs -> bbs.getFullLength() > 0);
  }

  @NonNull
  private static Arbitrary<byte[]> bytes(int minFileSize, int maxFileSize) {
    return Arbitraries.integers()
        .between(minFileSize, maxFileSize)
        .withDistribution(RandomDistribution.uniform())
        .map(DataGenerator.base64Characters()::genBytes);
  }

  @NonNull
  static Arbitrary<ByteBuffer[]> byteBuffers(int perBufferMinSize, int perBufferMaxSize) {
    return byteBuffer(perBufferMinSize, perBufferMaxSize)
        .array(ByteBuffer[].class)
        .ofMinSize(1)
        .ofMaxSize(10);
  }

  /**
   * Generate a ByteBuffer with size between minSize, maxSize with a random position and random
   * limit
   */
  @NonNull
  static Arbitrary<ByteBuffer> byteBuffer(int minSize, int maxSize) {
    return Arbitraries.integers()
        .between(minSize, maxSize)
        .withDistribution(RandomDistribution.uniform())
        .withoutEdgeCases()
        .map(DataGenerator.base64Characters()::genByteBuffer)
        .flatMap(
            buf ->
                Arbitraries.integers()
                    .between(0, Math.max(0, buf.capacity() - 1))
                    .withoutEdgeCases()
                    .flatMap(
                        limit ->
                            Arbitraries.integers()
                                .between(0, limit)
                                .withoutEdgeCases()
                                .flatMap(
                                    position -> {
                                      buf.limit(limit);
                                      buf.position(position);
                                      return Arbitraries.of(buf);
                                    })));
  }

  private static final class PathScenario implements AutoCloseable {

    private static final Path TMP_DIR = Paths.get(System.getProperty("java.io.tmpdir"));

    private final int rewindOffset;
    private final int errorAtOffset;
    private final TmpFile tmpFile;
    private final byte[] expectedBytes;
    private final String expectedXxd;

    private PathScenario(
        int rewindOffset, int errorAtOffset, TmpFile tmpFile, byte[] expectedBytes) {
      this.rewindOffset = rewindOffset;
      this.errorAtOffset = errorAtOffset;
      this.tmpFile = tmpFile;
      this.expectedBytes = expectedBytes;
      this.expectedXxd = xxd(expectedBytes);
    }

    public int getRewindOffset() {
      return rewindOffset;
    }

    public int getErrorAtOffset() {
      return errorAtOffset;
    }

    public Path getPath() {
      return tmpFile.getPath();
    }

    public String getExpectedXxd() {
      return expectedXxd;
    }

    public long getFullLength() throws IOException {
      return Files.size(tmpFile.getPath());
    }

    @Override
    public void close() throws IOException {
      tmpFile.close();
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("expectedXxd", "\n" + expectedXxd)
          .add("expectedBytes.length", expectedBytes.length)
          .add("rewindOffset", rewindOffset)
          .add("errorAtOffset", errorAtOffset)
          .add("tmpFile", tmpFile)
          .toString();
    }

    private static PathScenario of(int rewindOffset, int errorAtOffset, byte[] bytes) {
      try {
        TmpFile tmpFile1 = TmpFile.of(TMP_DIR, "PathScenario", ".bin");
        try (SeekableByteChannel writer = tmpFile1.writer()) {
          writer.write(ByteBuffer.wrap(bytes));
        }
        byte[] expectedBytes =
            Arrays.copyOfRange(bytes, Math.min(rewindOffset, bytes.length), bytes.length);
        return new PathScenario(rewindOffset, errorAtOffset, tmpFile1, expectedBytes);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private static class ByteBuffersScenario {

    private final long rewindOffset;
    private final long errorAtOffset;
    private final ByteBuffer[] buffers;
    private final long fullLength;
    private final String expectedXxd;

    private ByteBuffersScenario(
        long rewindOffset,
        long errorAtOffset,
        ByteBuffer[] buffers,
        byte[] expectedBytes,
        long fullLength) {
      this.rewindOffset = rewindOffset;
      this.errorAtOffset = errorAtOffset;
      this.buffers = buffers;
      this.fullLength = fullLength;
      this.expectedXxd = xxd(expectedBytes);
    }

    public long getRewindOffset() {
      return rewindOffset;
    }

    public long getErrorAtOffset() {
      return errorAtOffset;
    }

    public ByteBuffer[] getBuffers() {
      // duplicate the buffer so we have stable toString
      return Arrays.stream(buffers).map(ByteBuffer::duplicate).toArray(ByteBuffer[]::new);
    }

    public String getExpectedXxd() {
      return expectedXxd;
    }

    public long getFullLength() {
      return fullLength;
    }

    public long getPostRewindLength() {
      return fullLength - rewindOffset;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("\nexpectedXxd", "\n" + expectedXxd)
          .add(
              "\nbuffers",
              Arrays.stream(buffers)
                  .map(Object::toString)
                  .collect(Collectors.joining("\n\t", "[\n\t", "\n]")))
          .add("\nrewindOffset", rewindOffset)
          .add("\nerrorAtOffset", errorAtOffset)
          .toString();
    }

    public static ByteBuffersScenario of(
        long rewindOffset, long errorAtOffset, ByteBuffer[] buffers) {

      ByteString reduce =
          Arrays.stream(buffers)
              .map(ByteBuffer::duplicate)
              .map(ByteStringStrategy.noCopy())
              .reduce(ByteString.empty(), ByteString::concat, (l, r) -> r);

      byte[] byteArray = reduce.substring(Math.toIntExact(rewindOffset)).toByteArray();
      return new ByteBuffersScenario(
          rewindOffset, errorAtOffset, buffers, byteArray, reduce.size());
    }
  }

  static final class ErroringOutputStream extends OutputStream {
    private final long errorAt;
    private long totalWritten;

    ErroringOutputStream(long errorAt) {
      this.errorAt = errorAt;
      this.totalWritten = 0;
    }

    @Override
    public void write(int b) throws IOException {
      if (totalWritten++ >= errorAt) {
        throw new IOException("Reached errorAt limit");
      }
    }

    @Override
    public void write(byte[] b) throws IOException {
      if (totalWritten + b.length >= errorAt) {
        throw new IOException("Reached errorAt limit");
      } else {
        totalWritten += b.length;
      }
    }

    @Override
    public void write(@SuppressWarnings("NullableProblems") byte[] b, int off, int len)
        throws IOException {
      int diff = len - off;
      if (totalWritten + diff >= errorAt) {
        throw new IOException("Reached errorAt limit");
      } else {
        totalWritten += diff;
      }
    }
  }
}
