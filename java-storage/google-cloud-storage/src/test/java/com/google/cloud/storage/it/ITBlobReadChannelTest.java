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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.fail;

import com.google.cloud.ReadChannel;
import com.google.cloud.RestorableState;
import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.CrossRun.Exclude;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture;
import com.google.cloud.storage.it.runner.registry.ObjectsFixture.ObjectAndContent;
import com.google.common.collect.ImmutableMap;
import com.google.common.io.BaseEncoding;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.Locale;
import java.util.zip.GZIPInputStream;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = Backend.PROD)
public final class ITBlobReadChannelTest {

  private static final int _16MiB = 16 * 1024 * 1024;
  private static final int _256KiB = 256 * 1024;
  private static final String BLOB_STRING_CONTENT = "Hello Google Cloud Storage!";
  private static final byte[] COMPRESSED_CONTENT =
      BaseEncoding.base64()
          .decode("H4sIAAAAAAAAAPNIzcnJV3DPz0/PSVVwzskvTVEILskvSkxPVQQA/LySchsAAAA=");

  @Rule public final TemporaryFolder tmp = new TemporaryFolder();

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public ObjectsFixture objectsFixture;
  @Inject public Generator generator;

  @Test
  public void testLimit_smallerThanOneChunk() throws IOException {
    int srcContentSize = _256KiB;
    int rangeBegin = 57;
    int rangeEnd = 2384;
    int chunkSize = _16MiB;
    doLimitTest(srcContentSize, rangeBegin, rangeEnd, chunkSize);
  }

  @Test
  public void testLimit_noSeek() throws IOException {
    int srcContentSize = 16;
    int rangeBegin = 0;
    int rangeEnd = 10;
    int chunkSize = _256KiB;
    doLimitTest(srcContentSize, rangeBegin, rangeEnd, chunkSize);
  }

  @Test
  public void testLimit_pastEndOfBlob() throws IOException {
    int srcContentSize = _256KiB;
    int rangeBegin = _256KiB - 20;
    int rangeEnd = _256KiB + 20;
    int chunkSize = _16MiB;
    doLimitTest(srcContentSize, rangeBegin, rangeEnd, chunkSize);
  }

  @Test
  public void testLimit_endBeforeBegin() throws IOException {
    int srcContentSize = _256KiB;
    int rangeBegin = 4;
    int rangeEnd = 3;
    int chunkSize = _16MiB;
    doLimitTest(srcContentSize, rangeBegin, rangeEnd, chunkSize);
  }

  @Test
  public void testLimit_largerThanOneChunk() throws IOException {
    int srcContentSize = _16MiB + (_256KiB * 3);
    int rangeBegin = 384;
    int rangeEnd = rangeBegin + _16MiB;
    int chunkSize = _16MiB;

    doLimitTest(srcContentSize, rangeBegin, rangeEnd, chunkSize);
  }

  @Test
  public void testLimit_downloadToFile() throws IOException {
    String blobName = String.format(Locale.US, "%s/src", generator.randomObjectName());
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    ByteBuffer content = DataGenerator.base64Characters().genByteBuffer(108);
    try (WriteChannel writer = storage.writer(BlobInfo.newBuilder(blobId).build())) {
      writer.write(content);
    }

    File file = tmp.newFile();
    String destFileName = file.getAbsolutePath();
    byte[] expectedBytes = new byte[37 - 14];
    ByteBuffer duplicate = content.duplicate();
    duplicate.position(14);
    duplicate.limit(37);
    duplicate.get(expectedBytes);
    String xxdExpected = xxd(expectedBytes);

    try {
      Path path = Paths.get(destFileName);
      try (ReadChannel from = storage.reader(blobId);
          FileChannel to = FileChannel.open(path, StandardOpenOption.WRITE)) {
        from.seek(14);
        from.limit(37);

        ByteStreams.copy(from, to);
      }

      byte[] readBytes = Files.readAllBytes(path);
      String xxdActual = xxd(readBytes);
      assertThat(xxdActual).isEqualTo(xxdExpected);
    } finally {
      file.delete();
    }
  }

  @Test
  public void
      testReadChannel_preconditionFailureResultsInIOException_metagenerationMatch_specified() {
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    try (ReadChannel reader =
        storage.reader(blob.getBlobId(), BlobSourceOption.metagenerationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("IOException was expected");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void testReadChannel_preconditionFailureResultsInIOException_generationMatch_specified() {
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    try (ReadChannel reader =
        storage.reader(blob.getBlobId(), BlobSourceOption.generationMatch(-1L))) {
      reader.read(ByteBuffer.allocate(42));
      fail("IOException was expected");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void testReadChannel_preconditionFailureResultsInIOException_generationMatch_extractor() {
    String blobName = generator.randomObjectName();
    BlobInfo blob = BlobInfo.newBuilder(bucket, blobName).build();
    Blob remoteBlob = storage.create(blob);
    assertNotNull(remoteBlob);
    BlobId blobIdWrongGeneration = BlobId.of(bucket.getName(), blobName, -1L);
    try (ReadChannel reader =
        storage.reader(blobIdWrongGeneration, BlobSourceOption.generationMatch())) {
      reader.read(ByteBuffer.allocate(42));
      fail("IOException was expected");
    } catch (IOException ex) {
      // expected
    }
  }

  @Test
  public void ensureReaderReturnsCompressedBytesByDefault() throws IOException {
    String blobName = generator.randomObjectName();
    BlobInfo blobInfo =
        BlobInfo.newBuilder(bucket, blobName)
            .setContentType("text/plain")
            .setContentEncoding("gzip")
            .build();
    Blob blob = storage.create(blobInfo, COMPRESSED_CONTENT);
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      try (ReadChannel reader = storage.reader(BlobId.of(bucket.getName(), blobName))) {
        reader.setChunkSize(8);
        ByteStreams.copy(reader, Channels.newChannel(output));
      }
      assertArrayEquals(
          BLOB_STRING_CONTENT.getBytes(UTF_8),
          storage.readAllBytes(
              bucket.getName(), blobName, BlobSourceOption.shouldReturnRawInputStream(false)));
      assertArrayEquals(COMPRESSED_CONTENT, output.toByteArray());
      try (GZIPInputStream zipInput =
          new GZIPInputStream(new ByteArrayInputStream(output.toByteArray()))) {
        assertArrayEquals(BLOB_STRING_CONTENT.getBytes(UTF_8), ByteStreams.toByteArray(zipInput));
      }
    }
  }

  @Test
  public void ensureReaderCanAutoDecompressWhenReturnRawInputStream_false() throws IOException {
    String blobName = generator.randomObjectName();
    BlobInfo blobInfo =
        BlobInfo.newBuilder(bucket, blobName)
            .setContentType("text/plain")
            .setContentEncoding("gzip")
            .build();
    Blob blob = storage.create(blobInfo, COMPRESSED_CONTENT);
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      try (ReadChannel reader =
          storage.reader(
              BlobId.of(bucket.getName(), blobName),
              BlobSourceOption.shouldReturnRawInputStream(false))) {
        reader.setChunkSize(8);
        ByteStreams.copy(reader, Channels.newChannel(output));
      }
      assertArrayEquals(BLOB_STRING_CONTENT.getBytes(UTF_8), output.toByteArray());
    }
  }

  @Test
  public void returnRawInputStream_true() throws IOException {
    String blobName = generator.randomObjectName();
    BlobInfo blobInfo =
        BlobInfo.newBuilder(bucket, blobName)
            .setContentType("text/plain")
            .setContentEncoding("gzip")
            .build();
    Blob blob = storage.create(blobInfo, COMPRESSED_CONTENT);
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      try (ReadChannel reader =
          storage.reader(
              BlobId.of(bucket.getName(), blobName),
              BlobSourceOption.shouldReturnRawInputStream(true))) {
        reader.setChunkSize(8);
        ByteStreams.copy(reader, Channels.newChannel(output));
      }
      assertArrayEquals(
          BLOB_STRING_CONTENT.getBytes(UTF_8),
          storage.readAllBytes(
              bucket.getName(), blobName, BlobSourceOption.shouldReturnRawInputStream(false)));
      assertArrayEquals(COMPRESSED_CONTENT, output.toByteArray());
      try (GZIPInputStream zipInput =
          new GZIPInputStream(new ByteArrayInputStream(output.toByteArray()))) {
        assertArrayEquals(BLOB_STRING_CONTENT.getBytes(UTF_8), ByteStreams.toByteArray(zipInput));
      }
    }
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void channelIsConsideredOpenUponConstruction() {
    ReadChannel reader = storage.reader(objectsFixture.getInfo1().getBlobId());
    assertThat(reader.isOpen()).isTrue();
    reader.close();
  }

  @Test
  public void optionsWork() {
    byte[] bytes1 = "A".getBytes(UTF_8);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info, bytes1, BlobTargetOption.doesNotExist());

    // attempt to read generation=1 && ifGenerationNotMatch=1
    try (ReadChannel r =
        storage.reader(
            gen1.getBlobId(), BlobSourceOption.generationNotMatch(gen1.getGeneration()))) {
      r.read(ByteBuffer.allocate(1));
    } catch (IOException e) {
      assertThat(e).hasCauseThat().isInstanceOf(StorageException.class);
      StorageException se = (StorageException) e.getCause();
      // b/261214971 for differing response code
      assertThat(se.getCode()).isAnyOf(/*json*/ 304, /*grpc*/ 412);
    }
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void captureAndRestore_position_Limit() throws IOException {
    captureAndRestoreTest(26, 51);
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void captureAndRestore_position_noLimit() throws IOException {
    captureAndRestoreTest(26, null);
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void captureAndRestore_noPosition_limit() throws IOException {
    captureAndRestoreTest(null, 51);
  }

  @Test
  @Exclude(transports = Transport.GRPC)
  public void captureAndRestore_noPosition_noLimit() throws IOException {
    captureAndRestoreTest(null, null);
  }

  @Test
  public void seekAfterReadWorks() throws IOException {
    ObjectAndContent obj512KiB = objectsFixture.getObj512KiB();
    BlobInfo gen1 = obj512KiB.getInfo();
    byte[] bytes = obj512KiB.getContent().getBytes();

    byte[] expected1 = Arrays.copyOfRange(bytes, 0, 4);
    byte[] expected2 = Arrays.copyOfRange(bytes, 8, 13);

    String xxdExpected1 = xxd(expected1);
    String xxdExpected2 = xxd(expected2);
    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      // read some bytes
      byte[] bytes1 = new byte[expected1.length];
      reader.read(ByteBuffer.wrap(bytes1));
      String xxd1 = xxd(bytes1);
      assertThat(xxd1).isEqualTo(xxdExpected1);

      // seek forward to a new offset
      reader.seek(8);

      // read again
      byte[] bytes2 = new byte[expected2.length];
      reader.read(ByteBuffer.wrap(bytes2));
      String xxd2 = xxd(bytes2);
      assertThat(xxd2).isEqualTo(xxdExpected2);
    }
  }

  @Test
  public void seekBackToStartAfterReachingEndOfObjectWorks() throws IOException {
    ObjectAndContent obj512KiB = objectsFixture.getObj512KiB();
    BlobInfo gen1 = obj512KiB.getInfo();
    byte[] bytes = obj512KiB.getContent().getBytes();

    int from = bytes.length - 5;
    byte[] expected1 = Arrays.copyOfRange(bytes, from, bytes.length);

    String xxdExpected1 = xxd(expected1);
    String xxdExpected2 = xxd(bytes);
    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      // seek forward to a new offset
      reader.seek(from);

      try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
          WritableByteChannel out = Channels.newChannel(baos)) {
        ByteStreams.copy(reader, out);
        String xxd = xxd(baos.toByteArray());
        assertThat(xxd).isEqualTo(xxdExpected1);
      }

      // seek back to the beginning
      reader.seek(0);
      // read again
      try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
          WritableByteChannel out = Channels.newChannel(baos)) {
        ByteStreams.copy(reader, out);
        String xxd = xxd(baos.toByteArray());
        assertThat(xxd).isEqualTo(xxdExpected2);
      }
    }
  }

  @Test
  public void limitAfterReadWorks() throws IOException {
    ObjectAndContent obj512KiB = objectsFixture.getObj512KiB();
    BlobInfo gen1 = obj512KiB.getInfo();
    byte[] bytes = obj512KiB.getContent().getBytes();

    byte[] expected1 = Arrays.copyOfRange(bytes, 0, 4);
    byte[] expected2 = Arrays.copyOfRange(bytes, 4, 10);

    String xxdExpected1 = xxd(expected1);
    String xxdExpected2 = xxd(expected2);
    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      // read some bytes
      byte[] bytes1 = new byte[expected1.length];
      reader.read(ByteBuffer.wrap(bytes1));
      String xxd1 = xxd(bytes1);
      assertThat(xxd1).isEqualTo(xxdExpected1);

      // change the limit
      reader.limit(10);

      // read again
      byte[] bytes2 = new byte[expected2.length];
      reader.read(ByteBuffer.wrap(bytes2));
      String xxd2 = xxd(bytes2);
      assertThat(xxd2).isEqualTo(xxdExpected2);
    }
  }

  @Test
  public void readingLastByteReturnsOneByte_seekOnly() throws IOException {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    byte[] expected1 = Arrays.copyOfRange(bytes, 9, 10);
    String xxdExpected1 = xxd(expected1);
    try (ReadChannel reader = storage.reader(gen1.getBlobId());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel writer = Channels.newChannel(baos)) {
      reader.seek(length - 1);
      ByteStreams.copy(reader, writer);
      byte[] bytes1 = baos.toByteArray();
      String xxd1 = xxd(bytes1);
      assertThat(xxd1).isEqualTo(xxdExpected1);
    }
  }

  @Test
  public void readingLastByteReturnsOneByte_seekOnly_negativeOffset() throws IOException {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    byte[] expected1 = Arrays.copyOfRange(bytes, 9, 10);
    String xxdExpected1 = xxd(expected1);
    try (ReadChannel reader = storage.reader(gen1.getBlobId());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel writer = Channels.newChannel(baos)) {
      reader.seek(-1);
      ByteStreams.copy(reader, writer);
      byte[] bytes1 = baos.toByteArray();
      String xxd1 = xxd(bytes1);
      assertThat(xxd1).isEqualTo(xxdExpected1);
    }
  }

  @Test
  public void readingLastByteReturnsOneByte_seekAndLimit() throws IOException {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    byte[] expected1 = Arrays.copyOfRange(bytes, 9, 10);
    String xxdExpected1 = xxd(expected1);
    try (ReadChannel reader = storage.reader(gen1.getBlobId());
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel writer = Channels.newChannel(baos)) {
      reader.seek(length - 1);
      reader.limit(length);
      ByteStreams.copy(reader, writer);
      byte[] bytes1 = baos.toByteArray();
      String xxd1 = xxd(bytes1);
      assertThat(xxd1).isEqualTo(xxdExpected1);
    }
  }

  /**
   * This is specifically in place for compatibility with BlobReadChannelV1.
   *
   * <p>This is behavior is a bug, and should be fixed at the next major version
   */
  @Test
  @Exclude(transports = Transport.GRPC)
  public void responseWith416ReturnsZeroAndLeavesTheChannelOpen() throws IOException {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      reader.seek(length);
      ByteBuffer buf = ByteBuffer.allocate(1);
      int read = reader.read(buf);
      assertThat(read).isEqualTo(-1);
      assertThat(reader.isOpen()).isTrue();
      int read2 = reader.read(buf);
      assertThat(read2).isEqualTo(-1);
    }
  }

  @Test
  public void responseWith416AttemptingToReadStartingPastTheEndOfTheObjectIsTerminallyEOF()
      throws IOException {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 =
        BlobInfo.newBuilder(bucket, generator.randomObjectName())
            .setMetadata(ImmutableMap.of("gen", "1"))
            .build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      reader.seek(length + 1);
      ByteBuffer buf = ByteBuffer.allocate(1);
      assertThat(reader.read(buf)).isEqualTo(-1);
      assertThat(reader.read(buf)).isEqualTo(-1);

      BlobInfo update = gen1.toBuilder().setMetadata(ImmutableMap.of("gen", "2")).build();
      BlobInfo gen2 =
          storage.create(
              update,
              DataGenerator.base64Characters().genBytes(length + 2),
              BlobTargetOption.generationMatch());

      assertThat(reader.read(buf)).isEqualTo(-1);
      assertThat(reader.read(buf)).isEqualTo(-1);
    }
  }

  /** Read channel does not consider itself closed once it returns {@code -1} from read. */
  @Test
  public void readChannelIsAlwaysOpen_willReturnNegative1UntilExplicitlyClosed() throws Exception {
    int length = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(length);

    BlobInfo info1 = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info1, bytes, BlobTargetOption.doesNotExist());

    try (ReadChannel reader = storage.reader(gen1.getBlobId())) {
      ByteBuffer buf = ByteBuffer.allocate(length * 2);
      int read = reader.read(buf);
      assertAll(
          () -> assertThat(read).isEqualTo(length), () -> assertThat(reader.isOpen()).isTrue());
      int read2 = reader.read(buf);
      assertAll(() -> assertThat(read2).isEqualTo(-1), () -> assertThat(reader.isOpen()).isTrue());
      int read3 = reader.read(buf);
      assertAll(() -> assertThat(read3).isEqualTo(-1), () -> assertThat(reader.isOpen()).isTrue());
      reader.close();
      assertThrows(ClosedChannelException.class, () -> reader.read(buf));
    }
  }

  private void captureAndRestoreTest(@Nullable Integer position, @Nullable Integer endOffset)
      throws IOException {
    ObjectAndContent obj512KiB = objectsFixture.getObj512KiB();
    BlobInfo gen1 = obj512KiB.getInfo();
    byte[] bytes = obj512KiB.getContent().getBytes();

    String xxdExpected1;
    String xxdExpected2;
    {
      int begin = position != null ? position : 0;
      int end = endOffset != null ? endOffset : bytes.length;
      byte[] expected1 = Arrays.copyOfRange(bytes, begin, begin + 10);
      byte[] expected2 = Arrays.copyOfRange(bytes, begin, end);
      xxdExpected1 = xxd(expected1);
      xxdExpected2 = xxd(expected2);
    }

    ReadChannel reader = storage.reader(gen1.getBlobId());
    if (position != null) {
      reader.seek(position);
    }
    if (endOffset != null) {
      reader.limit(endOffset);
    }

    ByteBuffer buf = ByteBuffer.allocate(bytes.length);
    buf.limit(10);

    int read1 = reader.read(buf);
    assertThat(read1).isEqualTo(10);
    String xxd1 = xxd(buf);
    assertThat(xxd1).isEqualTo(xxdExpected1);
    buf.limit(buf.capacity());

    RestorableState<ReadChannel> capture = reader.capture();
    reader.close();

    try (ReadChannel restore = capture.restore()) {
      restore.read(buf);
      String xxd2 = xxd(buf);
      assertThat(xxd2).isEqualTo(xxdExpected2);
    }
  }

  private void doLimitTest(int srcContentSize, int rangeBegin, int rangeEnd, int chunkSize)
      throws IOException {
    String blobName = String.format(Locale.US, "%s/src", generator.randomObjectName());
    BlobInfo src = BlobInfo.newBuilder(bucket, blobName).build();
    ByteBuffer content = DataGenerator.base64Characters().genByteBuffer(srcContentSize);
    ByteBuffer dup = content.duplicate();
    dup.position(rangeBegin);
    int newLimit = Math.min(dup.capacity(), rangeEnd);
    dup.limit(newLimit);
    byte[] expectedSubContent = new byte[dup.remaining()];
    dup.get(expectedSubContent);

    try (WriteChannel writer = storage.writer(src)) {
      writer.write(content);
    }

    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ReadChannel reader = storage.reader(src.getBlobId());
        WritableByteChannel writer = Channels.newChannel(baos)) {
      reader.setChunkSize(chunkSize);
      if (rangeBegin > 0) {
        reader.seek(rangeBegin);
      }
      reader.limit(rangeEnd);
      ByteStreams.copy(reader, writer);
    }

    byte[] actual = baos.toByteArray();
    assertThat(xxd(actual)).isEqualTo(xxd(expectedSubContent));
  }
}
