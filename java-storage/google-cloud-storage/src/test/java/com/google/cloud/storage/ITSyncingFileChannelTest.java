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

import static com.google.cloud.storage.RewindableContentPropertyTest.byteBuffers;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.file.Files.readAllBytes;

import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.protobuf.ByteString;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import net.jqwik.api.Arbitraries;
import net.jqwik.api.Arbitrary;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.Provide;

public final class ITSyncingFileChannelTest {

  /**
   * Run a series of generated scenarios where each write is performed against a {@link
   * SyncingFileChannel} after {@link SyncingFileChannel#write(ByteBuffer)} returns verify the full
   * contents of the file match the expected cumulative value.
   */
  @Property
  void shouldHandleAnySizeWriteGt0(@ForAll("WriteScenario") WriteScenario writeScenario)
      throws IOException {
    // use try-with-resource to approximate @TearDown and cleanup the file
    try (WriteScenario ws = writeScenario) {
      Path path = ws.getPath();
      try (FileChannel fc = FileChannel.open(path, ws.getOpenOptions());
          SyncingFileChannel syncing = new SyncingFileChannel(fc)) {
        assertThat(syncing.isOpen()).isTrue();
        ByteBuffer[] writes = ws.writes();
        for (int i = 0; i < writes.length; i++) {
          ByteBuffer buf = writes[i];
          syncing.write(buf);
          assertThat(xxd(readAllBytes(path))).isEqualTo(ws.expected(i));
        }
      }
      assertThat(xxd(readAllBytes(path))).isEqualTo(ws.all());
    }
  }

  @Provide("WriteScenario")
  static Arbitrary<WriteScenario> writeScenario() {
    return Arbitraries.lazyOf(
            () ->
                Arbitraries.oneOf(
                    byteBuffers(1, 10),
                    byteBuffers(10, 100),
                    byteBuffers(100, 1_000),
                    byteBuffers(1_000, 10_000),
                    byteBuffers(10_000, 100_000),
                    byteBuffers(100_000, 1_000_000)))
        .map(
            buffers ->
                Arrays.stream(buffers).filter(Buffer::hasRemaining).toArray(ByteBuffer[]::new))
        .filter(
            buffers -> {
              long totalAvailable = Arrays.stream(buffers).mapToLong(ByteBuffer::remaining).sum();
              return totalAvailable > 0;
            })
        .map(WriteScenario::of);
  }

  static final class WriteScenario implements AutoCloseable {
    private static final Path TMP_DIR = Paths.get(System.getProperty("java.io.tmpdir"));
    private static final Collector<CharSequence, ?, String> DEBUG_JOINER =
        Collectors.joining(",\n\t", "[\n\t", "\n]");

    private final Path path;
    private final ByteBuffer[] writes;
    private final ByteString[] expectedCumulativeContents;
    private final EnumSet<StandardOpenOption> openOptions;

    private WriteScenario(Path path, ByteBuffer[] writes, ByteString[] expectedCumulativeContents) {
      this.path = path;
      this.writes = writes;
      this.expectedCumulativeContents = expectedCumulativeContents;
      this.openOptions = EnumSet.of(StandardOpenOption.CREATE, StandardOpenOption.WRITE);
    }

    public Path getPath() {
      return path;
    }

    public EnumSet<StandardOpenOption> getOpenOptions() {
      return openOptions;
    }

    ByteBuffer[] writes() {
      return Arrays.stream(writes).map(ByteBuffer::duplicate).toArray(ByteBuffer[]::new);
    }

    String expected(int idx) {
      Preconditions.checkArgument(
          0 <= idx && idx < expectedCumulativeContents.length,
          "index out of bounds: (0 <= %s && %s < %s)",
          idx,
          idx,
          expectedCumulativeContents.length);
      return xxd(false, expectedCumulativeContents[idx].asReadOnlyByteBuffer());
    }

    String all() {
      return xxd(
          false,
          expectedCumulativeContents[expectedCumulativeContents.length - 1].asReadOnlyByteBuffer());
    }

    @Override
    public void close() throws IOException {
      Files.deleteIfExists(path);
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("\npath", path)
          .add(
              "\nwrites",
              Arrays.stream(writes)
                  .map(
                      b ->
                          String.format(
                              Locale.US, "%s \n %s", b.toString(), xxd(false, b.duplicate())))
                  .collect(DEBUG_JOINER))
          .add(
              "\nexpectedCumulativeContents",
              Arrays.stream(expectedCumulativeContents)
                  .map(ByteString::toString)
                  .collect(DEBUG_JOINER))
          .toString();
    }

    public static WriteScenario of(ByteBuffer[] byteBuffers) {
      try {
        Path path = Files.createTempFile(TMP_DIR, WriteScenario.class.getName() + "-", ".bin");

        List<ByteString> byteStrings = new ArrayList<>();
        for (int i = 0; i < byteBuffers.length; i++) {
          ByteString bs = ByteString.empty();
          for (int j = 0; j <= i; j++) {
            ByteBuffer byteBuffer = byteBuffers[j].duplicate();
            bs = bs.concat(ByteStringStrategy.noCopy().apply(byteBuffer));
          }
          byteStrings.add(bs);
        }

        return new WriteScenario(path, byteBuffers, byteStrings.toArray(new ByteString[0]));
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
  }
}
