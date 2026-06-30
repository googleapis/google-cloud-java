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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.api.core.ApiFuture;
import com.google.cloud.storage.BlobAppendableUpload.AppendableUploadWriteableByteChannel;
import com.google.cloud.storage.BlobAppendableUploadConfig.CloseAction;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.FlushPolicy.MaxFlushSizeFlushPolicy;
import com.google.cloud.storage.FlushPolicy.MinFlushSizeFlushPolicy;
import com.google.cloud.storage.ITAppendableUploadTest.UploadConfigParameters;
import com.google.cloud.storage.MetadataField.PartRange;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.base.MoreObjects;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.TEST_BENCH},
    transports = Transport.GRPC)
@Parameterized(UploadConfigParameters.class)
public final class ITAppendableUploadTest {

  @Inject public Generator generator;

  @Inject public Storage storage;

  @Inject
  @BucketFixture(BucketType.RAPID)
  public BucketInfo bucket;

  @Inject public Backend backend;

  @Parameter public Param p;

  @Test
  public void appendableUpload_emptyObject()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    assumeTrue(
        "only run once",
        p.content.length() == UploadConfigParameters.objectSizes.get(0)
            && p.uploadConfig.getCloseAction() == UploadConfigParameters.closeActions.get(0)
            && p.uploadConfig.getFlushPolicy().equals(UploadConfigParameters.flushPolicies.get(0)));

    BlobAppendableUpload upload =
        storage.blobAppendableUpload(
            BlobInfo.newBuilder(bucket, UUID.randomUUID().toString()).build(), p.uploadConfig);

    upload.open().close();

    BlobInfo actual = upload.getResult().get(5, TimeUnit.SECONDS);
    assertThat(actual.getSize()).isEqualTo(0);
    assertThat(actual.getCrc32c())
        .isEqualTo(Utils.crc32cCodec.encode(Crc32cValue.zero().getValue()));

    assumeFalse(
        "Testbench doesn't handle {read_id: 1, read_offset: 0} for a 0 byte object",
        backend == Backend.TEST_BENCH);
    byte[] actualBytes = readAllBytes(actual);
    assertThat(xxd(actualBytes)).isEqualTo(xxd(new byte[0]));
  }

  @Test
  public void appendableUpload_bytes()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    checkTestbenchIssue733();

    BlobAppendableUpload upload =
        storage.blobAppendableUpload(
            BlobInfo.newBuilder(bucket, UUID.randomUUID().toString()).build(), p.uploadConfig);

    // cut out the middle + 1 byte
    int length = p.content.length();
    int mid = length / 2;
    ChecksummedTestContent a1 = p.content.slice(0, mid);
    ChecksummedTestContent a2 = p.content.slice(mid + 1, length - mid - 1);
    ChecksummedTestContent a1_a2 = a1.concat(a2);
    Crc32cLengthKnown c1_c2 = Crc32cValue.of(a1_a2.getCrc32c(), a1_a2.length());

    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      int written1 = Buffers.emptyTo(ByteBuffer.wrap(a1.getBytes()), channel);
      assertThat(written1).isEqualTo(a1.length());
      int written2 = Buffers.emptyTo(ByteBuffer.wrap(a2.getBytes()), channel);
      assertThat(written2).isEqualTo(a2.length());
    }

    BlobInfo actual = upload.getResult().get(5, TimeUnit.SECONDS);
    assertThat(actual.getSize()).isEqualTo(c1_c2.getLength());
    assertThat(actual.getCrc32c()).isEqualTo(Utils.crc32cCodec.encode(c1_c2.getValue()));

    byte[] actualBytes = readAllBytes(actual);
    assertThat(xxd(actualBytes)).isEqualTo(xxd(a1_a2.getBytes()));
  }

  @Test
  public void explicitFlush()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    checkTestbenchIssue733();

    BlobAppendableUpload upload =
        storage.blobAppendableUpload(
            BlobInfo.newBuilder(bucket, UUID.randomUUID().toString()).build(), p.uploadConfig);

    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      ByteBuffer src = p.content.asByteBuffer();
      ByteBuffer zed = src.slice();
      zed.limit(zed.position() + 1);
      src.position(src.position() + 1);

      int written = channel.write(zed);
      assertThat(written).isEqualTo(1);
      channel.flush();

      written = StorageChannelUtils.blockingEmptyTo(src, channel);
      assertThat(written).isEqualTo(p.content.length() - 1);
    }

    BlobInfo gen1 = upload.getResult().get(3, TimeUnit.SECONDS);
    assertThat(gen1.getSize()).isEqualTo(p.content.length());
    assertThat(gen1.getCrc32c()).isEqualTo(Utils.crc32cCodec.encode(p.content.getCrc32c()));
  }

  @Test
  // Pending work in testbench: https://github.com/googleapis/storage-testbench/issues/723
  // manually verified internally on 2025-03-25
  @CrossRun.Ignore(backends = {Backend.TEST_BENCH})
  public void appendableBlobUploadTakeover() throws Exception {

    List<ChecksummedTestContent> chunks = p.content.chunkup((p.content.length() / 2) + 1);
    assertThat(chunks).hasSize(2);

    ChecksummedTestContent c1 = chunks.get(0);
    ChecksummedTestContent c2 = chunks.get(1);

    BlobId id = BlobId.of(bucket.getName(), UUID.randomUUID().toString());
    BlobAppendableUploadConfig doNotFinalizeConfig =
        p.uploadConfig.withCloseAction(CloseAction.CLOSE_WITHOUT_FINALIZING);

    BlobAppendableUpload upload =
        storage.blobAppendableUpload(BlobInfo.newBuilder(id).build(), doNotFinalizeConfig);
    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      int written = Buffers.emptyTo(ByteBuffer.wrap(c1.getBytes()), channel);
      assertThat(written).isEqualTo(c1.length());
    }
    BlobInfo done1 = upload.getResult().get(5, TimeUnit.SECONDS);
    assertThat(done1.getSize()).isEqualTo(c1.length());
    assertThat(done1.getCrc32c()).isEqualTo(Utils.crc32cCodec.encode(c1.getCrc32c()));

    BlobAppendableUpload takeOver =
        storage.blobAppendableUpload(
            BlobInfo.newBuilder(done1.getBlobId()).build(), p.uploadConfig);
    try (AppendableUploadWriteableByteChannel channel = takeOver.open()) {
      int written = Buffers.emptyTo(ByteBuffer.wrap(c2.getBytes()), channel);
      assertThat(written).isEqualTo(c2.length());
    }
    BlobInfo done2 = takeOver.getResult().get(5, TimeUnit.SECONDS);

    assertThat(done2.getSize()).isEqualTo(p.content.length());
    assertThat(done2.getCrc32c()).isAnyOf(Utils.crc32cCodec.encode(p.content.getCrc32c()), null);
  }

  @Test
  public void testUploadFileUsingAppendable() throws Exception {
    checkTestbenchIssue733();

    String objectName = UUID.randomUUID().toString();
    String fileName =
        ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy.noPrefix()
            .fmtName(objectName, PartRange.of(1));
    BlobId bid = BlobId.of(bucket.getName(), objectName);
    int fileSize = p.content.length();
    try (TmpFile tmpFile =
        TmpFile.of(Paths.get(System.getProperty("java.io.tmpdir")), fileName + ".", ".bin")) {
      try (SeekableByteChannel w = tmpFile.writer()) {
        int written = Buffers.emptyTo(ByteBuffer.wrap(p.content.getBytes()), w);
        assertThat(written).isEqualTo(p.content.length());
      }

      BlobAppendableUpload appendable =
          storage.blobAppendableUpload(BlobInfo.newBuilder(bid).build(), p.uploadConfig);
      try (SeekableByteChannel r = tmpFile.reader();
          AppendableUploadWriteableByteChannel w = appendable.open()) {
        long copied = ByteStreams.copy(r, w);
        assertThat(copied).isEqualTo(fileSize);
      }
      BlobInfo bi = appendable.getResult().get(5, TimeUnit.SECONDS);
      assertThat(bi.getSize()).isEqualTo(fileSize);
    }
  }

  @Test
  // Pending work in testbench: https://github.com/googleapis/storage-testbench/issues/723
  // manually verified internally on 2025-03-25
  @CrossRun.Ignore(backends = {Backend.TEST_BENCH})
  public void takeoverJustToFinalizeWorks() throws Exception {
    BlobId bid = BlobId.of(bucket.getName(), UUID.randomUUID().toString());
    assumeTrue(
        "manually finalizing",
        p.uploadConfig.getCloseAction() != CloseAction.FINALIZE_WHEN_CLOSING);

    BlobAppendableUpload upload =
        storage.blobAppendableUpload(BlobInfo.newBuilder(bid).build(), p.uploadConfig);
    try (AppendableUploadWriteableByteChannel channel = upload.open()) {
      int written = Buffers.emptyTo(ByteBuffer.wrap(p.content.getBytes()), channel);
      assertThat(written).isEqualTo(p.content.length());
    }
    BlobInfo done1 = upload.getResult().get(5, TimeUnit.SECONDS);
    assertThat(done1.getSize()).isEqualTo(p.content.length());
    assertThat(done1.getCrc32c()).isEqualTo(Utils.crc32cCodec.encode(p.content.getCrc32c()));

    BlobAppendableUpload takeOver =
        storage.blobAppendableUpload(
            BlobInfo.newBuilder(done1.getBlobId()).build(), p.uploadConfig);
    takeOver.open().finalizeAndClose();

    BlobInfo done2 = takeOver.getResult().get(5, TimeUnit.SECONDS);
    assertAll(
        () -> assertThat(done2).isNotNull(),
        () -> assertThat(done2.getSize()).isEqualTo(p.content.length()),
        () -> assertThat(done2.getCrc32c()).isNotNull());
  }

  private void checkTestbenchIssue733() {
    if (backend == Backend.TEST_BENCH
        && p.uploadConfig.getCloseAction() == CloseAction.FINALIZE_WHEN_CLOSING) {
      int estimatedMessageCount = 0;
      FlushPolicy flushPolicy = p.uploadConfig.getFlushPolicy();
      if (flushPolicy instanceof MinFlushSizeFlushPolicy) {
        MinFlushSizeFlushPolicy min = (MinFlushSizeFlushPolicy) flushPolicy;
        estimatedMessageCount = p.content.length() / min.getMinFlushSize();
      } else if (flushPolicy instanceof MaxFlushSizeFlushPolicy) {
        MaxFlushSizeFlushPolicy max = (MaxFlushSizeFlushPolicy) flushPolicy;
        estimatedMessageCount = p.content.length() / max.getMaxFlushSize();
      }
      // if our int division results in a partial message, ensure we are counting at least one
      // message. We have a separate test specifically for empty objects.
      estimatedMessageCount = Math.max(estimatedMessageCount, 1);
      assumeTrue(
          "testbench broken https://github.com/googleapis/storage-testbench/issues/733",
          estimatedMessageCount > 1);
    }
  }

  private byte[] readAllBytes(BlobInfo actual)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    ApiFuture<BlobReadSession> blobReadSessionFuture = storage.blobReadSession(actual.getBlobId());
    try (BlobReadSession read = blobReadSessionFuture.get(2_372, TimeUnit.MILLISECONDS)) {
      ApiFuture<byte[]> futureBytes = read.readAs(ReadProjectionConfigs.asFutureBytes());
      return futureBytes.get(2_273, TimeUnit.MILLISECONDS);
    }
  }

  public static final class UploadConfigParameters implements ParametersProvider {

    private static final ImmutableList<FlushPolicy> flushPolicies =
        ImmutableList.of(
            FlushPolicy.minFlushSize(1_000),
            FlushPolicy.minFlushSize(1_000).withMaxPendingBytes(5_000),
            FlushPolicy.maxFlushSize(500_000),
            FlushPolicy.minFlushSize(),
            FlushPolicy.maxFlushSize());
    private static final ImmutableList<CloseAction> closeActions =
        ImmutableList.copyOf(CloseAction.values());
    public static final ImmutableList<Integer> objectSizes =
        ImmutableList.of(5, 500, 5_000, 500_000, 5_000_000);

    @Override
    public ImmutableList<?> parameters() {
      ImmutableList.Builder<Param> builder = ImmutableList.builder();
      for (FlushPolicy fp : flushPolicies) {
        for (CloseAction ca : closeActions) {
          for (int size : objectSizes) {
            Param param =
                new Param(
                    ChecksummedTestContent.gen(size),
                    BlobAppendableUploadConfig.of().withFlushPolicy(fp).withCloseAction(ca));
            builder.add(param);
          }
        }
      }
      return builder.build();
    }
  }

  public static final class Param {
    private final ChecksummedTestContent content;
    private final BlobAppendableUploadConfig uploadConfig;

    private Param(ChecksummedTestContent content, BlobAppendableUploadConfig uploadConfig) {
      this.content = content;
      this.uploadConfig = uploadConfig;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("byteCount", content)
          .add("uploadConfig", uploadConfig)
          .toString();
    }
  }
}
