/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.storage.ByteSizeConstants._1MiB;
import static com.google.cloud.storage.ByteSizeConstants._2MiB;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.rpc.OutOfRangeException;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.FlushPolicy.MinFlushSizeFlushPolicy;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.ZeroCopySupport.DisposableByteString;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.base.Stopwatch;
import com.google.common.hash.Hasher;
import com.google.common.hash.Hashing;
import com.google.common.io.ByteStreams;
import com.google.common.io.CountingOutputStream;
import com.google.protobuf.ByteString;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ScatteringByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.TEST_BENCH},
    transports = Transport.GRPC)
public final class ITObjectReadSessionTest {

  private static final int _512KiB = 512 * 1024;

  @Inject public Storage storage;

  @Inject
  @BucketFixture(BucketType.RAPID)
  public BucketInfo bucket;

  @Inject public Generator generator;

  @Inject public Backend backend;

  @Test
  public void bytes()
      throws ExecutionException, InterruptedException, TimeoutException, IOException {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(512 * 1024));
    BlobInfo obj512KiB = create(testContent);
    byte[] expected = testContent.getBytes(_512KiB - 13);
    BlobId blobId = obj512KiB.getBlobId();

    try (BlobReadSession blobReadSession =
        storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {

      BlobInfo info1 = blobReadSession.getBlobInfo();
      assertThat(info1).isNotNull();

      ApiFuture<byte[]> futureRead1Bytes =
          blobReadSession.readAs(
              ReadProjectionConfigs.asFutureBytes()
                  .withRangeSpec(RangeSpec.of(_512KiB - 13L, 13L)));

      byte[] read1Bytes = futureRead1Bytes.get(30, TimeUnit.SECONDS);
      assertThat(read1Bytes.length).isEqualTo(13);

      assertThat(xxd(read1Bytes)).isEqualTo(xxd(expected));
    }
  }

  @Test
  public void attemptingToGetFutureOutSizeSessionFails() throws Throwable {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(512 * 1024));
    BlobInfo obj512KiB = create(testContent);
    BlobId blobId = obj512KiB.getBlobId();

    ApiFuture<byte[]> future;
    try (BlobReadSession session = storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {
      future = session.readAs(ReadProjectionConfigs.asFutureBytes());
    }

    ExecutionException ee =
        assertThrows(ExecutionException.class, () -> future.get(1, TimeUnit.SECONDS));

    assertThat(ee).hasCauseThat().isInstanceOf(StorageException.class);
    assertThat(ee).hasCauseThat().hasCauseThat().isInstanceOf(AsyncSessionClosedException.class);
  }

  @Test
  public void lotsOfBytes() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(64 * _1MiB));

    BlobInfo gen1 = create(testContent);
    BlobId blobId = gen1.getBlobId();
    for (int j = 0; j < 2; j++) {

      Stopwatch sw = Stopwatch.createStarted();
      try (BlobReadSession blobReadSession =
          storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {

        int numRangesToRead = 32;
        List<ApiFuture<byte[]>> futures =
            LongStream.range(0, numRangesToRead)
                .mapToObj(i -> RangeSpec.of(i * _2MiB, _2MiB))
                .map(
                    r ->
                        blobReadSession.readAs(
                            ReadProjectionConfigs.asFutureBytes().withRangeSpec(r)))
                .collect(Collectors.toList());

        ApiFuture<List<byte[]>> listApiFuture = ApiFutures.allAsList(futures);

        List<byte[]> ranges = listApiFuture.get(30, TimeUnit.SECONDS);
        Stopwatch stop = sw.stop();
        System.out.println(stop.elapsed(TimeUnit.MILLISECONDS));
        Hasher hasher = Hashing.crc32c().newHasher();
        long length = 0;
        for (byte[] range : ranges) {
          hasher.putBytes(range);
          length += range.length;
        }
        final long finalLength = length;

        assertAll(
            () -> {
              Crc32cLengthKnown expectedCrc32c =
                  Crc32cValue.of(testContent.getCrc32c(), testContent.getBytes().length);
              Crc32cLengthKnown actualCrc32c = Crc32cValue.of(hasher.hash().asInt(), finalLength);

              assertThat(actualCrc32c).isEqualTo(expectedCrc32c);
            },
            () -> assertThat(finalLength).isEqualTo(numRangesToRead * _2MiB));
      }
    }
  }

  @Test
  public void lotsChannel() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(64 * _1MiB));

    BlobInfo gen1 = create(testContent);
    BlobId blobId = gen1.getBlobId();
    byte[] buffer = new byte[_2MiB];
    for (int j = 0; j < 2; j++) {

      Stopwatch sw = Stopwatch.createStarted();
      try (BlobReadSession blobReadSession =
          storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try (ScatteringByteChannel r = blobReadSession.readAs(ReadProjectionConfigs.asChannel())) {
          ByteBuffer buf = ByteBuffer.wrap(buffer);
          Buffers.copyUsingBuffer(buf, r, Channels.newChannel(baos));
        }
        Stopwatch stop = sw.stop();
        System.out.println(stop.elapsed(TimeUnit.MILLISECONDS));
        Hasher hasher = Hashing.crc32c().newHasher();
        byte[] actual = baos.toByteArray();
        hasher.putBytes(actual);

        Crc32cLengthKnown expectedCrc32c =
            Crc32cValue.of(testContent.getCrc32c(), testContent.getBytes().length);
        Crc32cLengthKnown actualCrc32c = Crc32cValue.of(hasher.hash().asInt(), actual.length);

        assertThat(actualCrc32c).isEqualTo(expectedCrc32c);
      }
    }
  }

  @Test
  public void readRangeAsByteString() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(64 * _1MiB));

    BlobInfo gen1 = create(testContent);
    BlobId blobId = gen1.getBlobId();
    for (int j = 0; j < 2; j++) {

      Stopwatch sw = Stopwatch.createStarted();
      try (BlobReadSession blobReadSession =
          storage.blobReadSession(blobId).get(2, TimeUnit.SECONDS)) {

        int numRangesToRead = 32;
        List<ApiFuture<DisposableByteString>> futures =
            LongStream.range(0, numRangesToRead)
                .mapToObj(i -> RangeSpec.of(i * _2MiB, _2MiB))
                .map(
                    r ->
                        blobReadSession.readAs(
                            ReadProjectionConfigs.asFutureByteString().withRangeSpec(r)))
                .collect(Collectors.toList());

        ApiFuture<List<DisposableByteString>> listApiFuture = ApiFutures.allAsList(futures);

        List<DisposableByteString> ranges = listApiFuture.get(30, TimeUnit.SECONDS);
        Stopwatch stop = sw.stop();
        System.out.println(stop.elapsed(TimeUnit.MILLISECONDS));
        Hasher hasher = Hashing.crc32c().newHasher();
        long length = 0;
        for (DisposableByteString range : ranges) {
          try (DisposableByteString disposable = range) {
            ByteString byteString = disposable.byteString();
            for (ByteBuffer byteBuffer : byteString.asReadOnlyByteBufferList()) {
              hasher.putBytes(byteBuffer);
            }
            length += byteString.size();
          }
        }
        final long finalLength = length;

        assertAll(
            () -> {
              Crc32cLengthKnown expectedCrc32c =
                  Crc32cValue.of(testContent.getCrc32c(), testContent.getBytes().length);
              Crc32cLengthKnown actualCrc32c = Crc32cValue.of(hasher.hash().asInt(), finalLength);

              assertThat(actualCrc32c).isEqualTo(expectedCrc32c);
            },
            () -> assertThat(finalLength).isEqualTo(numRangesToRead * _2MiB));
      }
    }
  }

  @Test
  public void readFromBucketThatDoesNotExistShouldRaiseStorageExceptionWith404() {
    BlobId blobId = BlobId.of("gcs-grpc-team-bucket-that-does-not-exist", "someobject");

    ApiFuture<BlobReadSession> futureObjectReadSession = storage.blobReadSession(blobId);

    ExecutionException ee =
        assertThrows(
            ExecutionException.class, () -> futureObjectReadSession.get(5, TimeUnit.SECONDS));

    assertThat(ee).hasCauseThat().isInstanceOf(StorageException.class);
    StorageException cause = (StorageException) ee.getCause();
    assertThat(cause.getCode()).isEqualTo(404);
  }

  @Test
  public void seekable() throws Exception {
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(16 * _1MiB));

    ReadAsSeekableChannel config =
        ReadProjectionConfigs.asSeekableChannel()
            .withRangeSpecFunction(
                RangeSpecFunction.linearExponential()
                    .withInitialMaxLength(_1MiB)
                    .withMaxLengthScalar(4.0));

    BlobInfo gen1 = create(testContent);
    BlobId blobId = gen1.getBlobId();
    ByteBuffer buf = ByteBuffer.allocate(2 * 1024 * 1024);
    for (int j = 0; j < 1; j++) {

      try (BlobReadSession session = storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {
        CountingOutputStream countingOutputStream =
            new CountingOutputStream(ByteStreams.nullOutputStream());
        long copy1;
        long copy2;
        long copy3;
        try (SeekableByteChannel seekable = session.readAs(config);
            WritableByteChannel w = Channels.newChannel(countingOutputStream)) {
          copy1 = Buffers.copyUsingBuffer(buf, seekable, w);

          seekable.position(8 * _1MiB);
          copy2 = Buffers.copyUsingBuffer(buf, seekable, w);

          seekable.position(0);
          copy3 = Buffers.copyUsingBuffer(buf, seekable, w);
        }

        long totalRead = countingOutputStream.getCount();
        long finalCopy1 = copy1;
        long finalCopy2 = copy2;
        long finalCopy3 = copy3;
        assertAll(
            () -> assertThat(totalRead).isEqualTo((16 + 8 + 16) * _1MiB),
            () -> assertThat(finalCopy1).isEqualTo(16 * _1MiB),
            () -> assertThat(finalCopy2).isEqualTo(8 * _1MiB),
            () -> assertThat(finalCopy3).isEqualTo(16 * _1MiB));
      }
    }
  }

  @Test
  public void outOfRange()
      throws ExecutionException, InterruptedException, TimeoutException, IOException {
    int objectSize = 4 * 1024 * 1024;
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(objectSize));
    BlobInfo gen1 = create(testContent);
    BlobId blobId = gen1.getBlobId();

    try (BlobReadSession blobReadSession =
        storage.blobReadSession(blobId).get(30, TimeUnit.SECONDS)) {

      BlobInfo info1 = blobReadSession.getBlobInfo();
      assertThat(info1).isNotNull();

      ReadAsFutureBytes cfg = ReadProjectionConfigs.asFutureBytes();

      ApiFuture<byte[]> f2 =
          blobReadSession.readAs(cfg.withRangeSpec(RangeSpec.beginAt(objectSize + 1)));
      ExecutionException ee =
          assertThrows(ExecutionException.class, () -> f2.get(30, TimeUnit.SECONDS));
      assertThat(ee).hasCauseThat().hasCauseThat().isInstanceOf(OutOfRangeException.class);

      ApiFuture<byte[]> f1 = blobReadSession.readAs(cfg.withRangeSpec(RangeSpec.all()));
      byte[] bytes1 = f1.get(30, TimeUnit.SECONDS);
      assertThat(bytes1.length).isEqualTo(objectSize);
    }
  }

  private BlobInfo create(ChecksummedTestContent content)
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    BlobAppendableUploadConfig config = BlobAppendableUploadConfig.of();
    if (backend == Backend.TEST_BENCH) {
      // workaround for https://github.com/googleapis/storage-testbench/issues/733
      MinFlushSizeFlushPolicy flushPolicy =
          FlushPolicy.minFlushSize(256 * 1024).withMaxPendingBytes(4 * 1024 * 1024);
      config = config.withFlushPolicy(flushPolicy);
    }
    BlobAppendableUpload upload =
        storage.blobAppendableUpload(info, config, BlobWriteOption.doesNotExist());
    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      Buffers.emptyTo(ByteBuffer.wrap(content.getBytes()), channel);
      channel.finalizeAndClose();
    }
    return upload.getResult().get(5, TimeUnit.SECONDS);
  }
}
