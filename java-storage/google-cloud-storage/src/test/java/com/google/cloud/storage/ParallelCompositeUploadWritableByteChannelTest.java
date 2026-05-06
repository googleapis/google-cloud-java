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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.core.ApiFutureCallback;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.grpc.GrpcStatusCode;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.cloud.storage.BufferHandlePool.PooledBuffer;
import com.google.cloud.storage.Crc32cValue.Crc32cLengthKnown;
import com.google.cloud.storage.MetadataField.PartRange;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecorator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecoratorInstance;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.ParallelCompositeUploadWritableByteChannel.BufferHandleReleaser;
import com.google.cloud.storage.Storage.ComposeRequest;
import com.google.cloud.storage.Storage.PredefinedAcl;
import com.google.cloud.storage.UnifiedOpts.EncryptionKey;
import com.google.cloud.storage.UnifiedOpts.ObjectSourceOpt;
import com.google.cloud.storage.UnifiedOpts.ObjectTargetOpt;
import com.google.cloud.storage.UnifiedOpts.Opts;
import com.google.cloud.storage.it.ChecksummedTestContent;
import com.google.cloud.storage.spi.v1.StorageRpc;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.google.common.util.concurrent.Uninterruptibles;
import com.google.storage.v2.WriteObjectRequest;
import io.grpc.Status.Code;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.ClosedChannelException;
import java.time.Duration;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.Before;
import org.junit.Test;

public final class ParallelCompositeUploadWritableByteChannelTest {

  private static final Hasher HASHER = Hasher.enabled();

  private BlobInfo info;
  private Opts<ObjectTargetOpt> opts;

  private BufferHandlePool bufferHandlePool;
  private SettableApiFuture<BlobInfo> finalObject;
  private FakeStorageInternal storageInternal;
  private SimplisticPartNamingStrategy partNamingStrategy;
  private PartMetadataFieldDecoratorInstance partMetadataFieldDecorator;
  private int bufferCapacity;

  @Before
  public void setUp() throws Exception {
    info = BlobInfo.newBuilder("bucket", "object").build();
    opts = Opts.from(UnifiedOpts.generationMatch(0));
    bufferCapacity = 10;
    bufferHandlePool = BufferHandlePool.simple(bufferCapacity);
    finalObject = SettableApiFuture.create();
    partNamingStrategy = new SimplisticPartNamingStrategy("prefix");
    storageInternal = new FakeStorageInternal();
    partMetadataFieldDecorator = PartMetadataFieldDecorator.noOp().newInstance(null);
  }

  @Test
  public void objectCreated_partCount_eqToLimit() throws Exception {

    int maxElementsPerCompact = 5;
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(maxElementsPerCompact);

    byte[] bytes = DataGenerator.base64Characters().genBytes(47);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();

    String name = info.getName();
    // individual parts
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    BlobId p3 = id(partNamingStrategy.fmtName(name, PartRange.of(3)), 3L);
    BlobId p4 = id(partNamingStrategy.fmtName(name, PartRange.of(4)), 4L);
    BlobId p5 = id(partNamingStrategy.fmtName(name, PartRange.of(5)), 5L);
    // compose
    BlobId c1 = id(partNamingStrategy.fmtName(name, PartRange.of(1, 5)), 6L);
    // ultimate object
    BlobId expectedId = id(name, 7L);

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () ->
            assertThat(storageInternal.addedObjects.keySet())
                .containsExactly(p1, p2, p3, p4, p5, c1, expectedId),
        () -> assertThat(storageInternal.deleteRequests).containsExactly(p1, p2, p3, p4, p5, c1));
  }

  @Test
  public void objectCreated_partCount_ltToLimit() throws Exception {

    int maxElementsPerCompact = 6;
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(maxElementsPerCompact);

    byte[] bytes = DataGenerator.base64Characters().genBytes(47);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();

    String name = info.getName();
    // individual parts
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    BlobId p3 = id(partNamingStrategy.fmtName(name, PartRange.of(3)), 3L);
    BlobId p4 = id(partNamingStrategy.fmtName(name, PartRange.of(4)), 4L);
    BlobId p5 = id(partNamingStrategy.fmtName(name, PartRange.of(5)), 5L);
    // no compose
    // ultimate object
    BlobId expectedId = id(name, 6L);
    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () ->
            assertThat(storageInternal.addedObjects.keySet())
                .containsExactly(p1, p2, p3, p4, p5, expectedId),
        () -> assertThat(storageInternal.deleteRequests).containsExactly(p1, p2, p3, p4, p5));
  }

  @Test
  public void objectCreated_partCount_gtToLimit() throws Exception {

    int maxElementsPerCompact = 4;
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(maxElementsPerCompact);

    byte[] bytes = DataGenerator.base64Characters().genBytes(47);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();

    String name = info.getName();
    // parts 1-4
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    BlobId p3 = id(partNamingStrategy.fmtName(name, PartRange.of(3)), 3L);
    BlobId p4 = id(partNamingStrategy.fmtName(name, PartRange.of(4)), 4L);
    // compose 1-4
    BlobId c1 = id(partNamingStrategy.fmtName(name, PartRange.of(1, 4)), 5L);
    // part 5
    BlobId p5 = id(partNamingStrategy.fmtName(name, PartRange.of(5)), 6L);
    // ultimate object
    BlobId expectedId = id(name, 7L);

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () ->
            assertThat(storageInternal.addedObjects.keySet())
                .containsExactly(p1, p2, p3, p4, c1, p5, expectedId),
        () -> assertThat(storageInternal.deleteRequests).containsExactly(p1, p2, p3, p4, p5, c1));
  }

  @Test
  public void cleanup_success_disabled() throws Exception {

    int maxElementsPerCompact = 10;
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.never(),
            maxElementsPerCompact,
            partMetadataFieldDecorator,
            finalObject,
            storageInternal,
            info,
            opts);

    byte[] bytes = DataGenerator.base64Characters().genBytes(22);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();

    String name = info.getName();
    // parts 1-4
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    BlobId p3 = id(partNamingStrategy.fmtName(name, PartRange.of(3)), 3L);
    // ultimate object
    BlobId expectedId = id(name, 4L);

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () ->
            assertThat(storageInternal.addedObjects.keySet())
                .containsExactly(p1, p2, p3, expectedId),
        () -> assertThat(storageInternal.deleteRequests).isEmpty());
  }

  @Test
  public void writeDoesNotFlushIfItIsnNotFull() throws Exception {

    int maxElementsPerCompact = 10;
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.never(),
            maxElementsPerCompact,
            partMetadataFieldDecorator,
            finalObject,
            storageInternal,
            info,
            opts);

    byte[] bytes1 = DataGenerator.base64Characters().genBytes(bufferCapacity * 2 - 1);
    int limit = bufferCapacity - 1;
    pcu.write(ByteBuffer.wrap(bytes1, 0, limit));
    pcu.write(ByteBuffer.wrap(bytes1, limit, bytes1.length - limit));

    pcu.close();

    String name = info.getName();
    // parts 1-4
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    // ultimate object
    BlobId expectedId = id(name, 3L);

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () -> assertThat(storageInternal.addedObjects.keySet()).containsExactly(p1, p2, expectedId),
        () -> assertThat(storageInternal.deleteRequests).isEmpty(),
        () -> {
          Crc32cLengthKnown part1Crc32c = storageInternal.addedObjects.get(p1).getCrc32c();
          Crc32cLengthKnown expected = HASHER.hash(ByteBuffer.wrap(bytes1, 0, bufferCapacity));
          assertThat(part1Crc32c).isEqualTo(expected);
        });
  }

  @Test
  public void partOpts_stripsPreconditionsAndChecksums_addingIfGenEq0() {
    EncryptionKey key = UnifiedOpts.encryptionKey("key");
    Opts<ObjectTargetOpt> opts =
        Opts.from(
            UnifiedOpts.generationMatch(4),
            UnifiedOpts.generationNotMatch(5),
            UnifiedOpts.metagenerationMatch(6),
            UnifiedOpts.metagenerationNotMatch(7),
            UnifiedOpts.userProject("user-project"),
            key,
            UnifiedOpts.predefinedAcl(PredefinedAcl.PRIVATE),
            UnifiedOpts.kmsKeyName("kms-key"),
            UnifiedOpts.crc32cMatch(1),
            UnifiedOpts.md5Match("asdf"),
            UnifiedOpts.generationMatch(8).asSource(),
            UnifiedOpts.generationNotMatch(10).asSource(),
            UnifiedOpts.metagenerationMatch(12).asSource(),
            UnifiedOpts.metagenerationNotMatch(14).asSource());

    Opts<ObjectTargetOpt> partOpts = ParallelCompositeUploadWritableByteChannel.getPartOpts(opts);

    ImmutableMap<StorageRpc.Option, ?> expected =
        ImmutableMap.of(
            StorageRpc.Option.IF_GENERATION_MATCH,
            0L,
            StorageRpc.Option.USER_PROJECT,
            "user-project",
            StorageRpc.Option.CUSTOMER_SUPPLIED_KEY,
            Base64.getEncoder().encodeToString(key.val.getEncoded()),
            StorageRpc.Option.PREDEFINED_ACL,
            PredefinedAcl.PRIVATE.getEntry(),
            StorageRpc.Option.KMS_KEY_NAME,
            "kms-key");
    ImmutableMap<StorageRpc.Option, ?> rpcOptions = partOpts.getRpcOptions();

    assertThat(rpcOptions).containsAtLeastEntriesIn(expected);
  }

  @Test
  public void callingCloseOnANeverWrittenPcuStillCreatesAnEmptyObject() throws Exception {
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(3);
    // never call write
    pcu.close();
    // ultimate object
    BlobId expectedId = id(info.getName(), 1L);

    BlobInfo result = ApiFutureUtils.await(finalObject);
    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () -> assertThat(storageInternal.addedObjects.keySet()).containsExactly(expectedId),
        () -> assertThat(storageInternal.deleteRequests).isEmpty());
  }

  @Test
  public void partsRetainMetadata() throws Exception {
    ImmutableMap<String, String> metadata = ImmutableMap.of("a", "1", "b", "2");

    List<Map<String, String>> metadatas = Collections.synchronizedList(new ArrayList<>());
    BlobInfo info = this.info.toBuilder().setMetadata(metadata).build();
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.never(),
            3,
            partMetadataFieldDecorator,
            finalObject,
            new FakeStorageInternal() {
              @Override
              public BlobInfo internalDirectUpload(
                  BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
                metadatas.add(info.getMetadata());
                return super.internalDirectUpload(info, opts, buf);
              }

              @Override
              public BlobInfo compose(ComposeRequest composeRequest) {
                metadatas.add(composeRequest.getTarget().getMetadata());
                return super.compose(composeRequest);
              }
            },
            info,
            opts);

    pcu.write(DataGenerator.base64Characters().genByteBuffer(bufferCapacity * 3 + 5));
    pcu.close();

    BlobInfo result = ApiFutureUtils.await(finalObject);
    assertAll(
        () -> assertThat(result.getMetadata()).isEqualTo(metadata),
        () -> {
          assertThat(metadatas).isNotEmpty();
          for (Map<String, String> m : metadatas) {
            assertThat(m).containsAtLeastEntriesIn(metadata);
          }
        });
  }

  @Test
  public void channelClosedException_writeAfterClose() throws Exception {
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(3);
    // never call write
    pcu.close();
    assertThrows(
        ClosedChannelException.class,
        () -> pcu.write(DataGenerator.base64Characters().genByteBuffer(3)));
  }

  @Test
  public void multipleInvocationsOfCloseDoNotError() throws Exception {
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(3);
    pcu.close();
    pcu.close();
  }

  @Test
  public void openUponConstruction() throws Exception {
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(3);
    assertThat(pcu.isOpen()).isTrue();
    pcu.close();
  }

  @Test
  public void callingFlushWhileBufferIsEmptyIsANoOp() throws Exception {
    ParallelCompositeUploadWritableByteChannel pcu = defaultPcu(3);
    pcu.write(DataGenerator.base64Characters().genByteBuffer(bufferCapacity));
    pcu.flush();
    pcu.close();

    String name = info.getName();
    // parts 1
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    // ultimate object
    BlobId expectedId = id(name, 2L);

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () -> assertThat(storageInternal.addedObjects.keySet()).containsExactly(p1, expectedId),
        () -> assertThat(storageInternal.composeRequests).hasSize(1),
        () -> assertThat(storageInternal.deleteRequests).containsExactly(p1));
  }

  @Test
  public void creatingAnEmptyObjectWhichFailsIsSetAsResultFailureAndThrowFromClose()
      throws Exception {
    //noinspection resource
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.always(),
            3,
            partMetadataFieldDecorator,
            finalObject,
            new FakeStorageInternal() {
              @Override
              public BlobInfo internalDirectUpload(
                  BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
                throw StorageException.coalesce(
                    ApiExceptionFactory.createException(
                        null, GrpcStatusCode.of(Code.PERMISSION_DENIED), false));
              }
            },
            info,
            opts);
    StorageException se1 = assertThrows(StorageException.class, pcu::close);
    StorageException se2 =
        assertThrows(StorageException.class, () -> ApiFutureUtils.await(finalObject));

    assertAll(
        () -> assertThat(se1).hasMessageThat().isEqualTo("Error: PERMISSION_DENIED"),
        () -> assertThat(se2).hasMessageThat().isEqualTo("Error: PERMISSION_DENIED"),
        () -> assertThat(se1.getCode()).isEqualTo(403),
        () -> assertThat(se2.getCode()).isEqualTo(403));
  }

  @Test
  public void badServerCrc32cResultsInException() throws Exception {
    //noinspection resource
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.always(),
            3,
            partMetadataFieldDecorator,
            finalObject,
            new FakeStorageInternal() {
              @Override
              public BlobInfo compose(ComposeRequest composeRequest) {
                BlobInfo response = super.compose(composeRequest);
                // return a bad crc32c
                return response.toBuilder().setCrc32c(Utils.crc32cCodec.encode(0)).build();
              }
            },
            info,
            opts);
    pcu.write(DataGenerator.base64Characters().genByteBuffer(3));

    AsynchronousCloseException se1 = assertThrows(AsynchronousCloseException.class, pcu::close);
    StorageException se2 =
        assertThrows(StorageException.class, () -> ApiFutureUtils.await(finalObject));

    assertAll(
        () -> assertThat(se1).hasCauseThat().isInstanceOf(StorageException.class),
        () -> assertThat(se1).hasCauseThat().hasMessageThat().contains("Checksum mismatch"),
        () -> assertThat(se2).hasMessageThat().contains("Checksum mismatch"),
        () -> assertThat(se2.getCode()).isEqualTo(400));
  }

  @Test
  public void bufferHandleRelease_returnsBufferOnFailureAndSuccess() throws Exception {
    AtomicReference<Throwable> failure = new AtomicReference<>(null);
    AtomicReference<String> success = new AtomicReference<>(null);

    ApiFutureCallback<String> delegate =
        new ApiFutureCallback<String>() {
          @Override
          public void onFailure(Throwable t) {
            failure.set(t);
          }

          @Override
          public void onSuccess(String result) {
            success.set(result);
          }
        };

    PooledBuffer p1 = PooledBuffer.of(BufferHandle.allocate(3));
    BufferHandlePool pool =
        new BufferHandlePool() {
          @Override
          public PooledBuffer getBuffer() {
            return null;
          }

          @Override
          public void returnBuffer(PooledBuffer handle) {
            assertThat(handle).isSameInstanceAs(p1);
          }
        };

    BufferHandleReleaser<String> releaser = new BufferHandleReleaser<>(pool, p1, delegate);

    releaser.onSuccess("success");
    releaser.onFailure(new Exception("induced failure"));

    assertAll(
        () -> assertThat(success.get()).isEqualTo("success"),
        () -> assertThat(failure.get()).hasMessageThat().isEqualTo("induced failure"));
  }

  @Test
  public void shortCircuitExceptionResultsInFastFailure() throws Exception {
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setDaemon(true).setNameFormat("test-shortCircuit-%d").build();
    ExecutorService threadPool = Executors.newFixedThreadPool(1, threadFactory);

    try {

      AtomicBoolean induceFailure = new AtomicBoolean(true);
      CountDownLatch blockForWrite1 = new CountDownLatch(1);
      CountDownLatch blockForWrite1Complete = new CountDownLatch(1);
      FakeStorageInternal storageInternal =
          new FakeStorageInternal() {
            @Override
            public BlobInfo internalDirectUpload(
                BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
              if (induceFailure.getAndSet(false)) {
                Uninterruptibles.awaitUninterruptibly(blockForWrite1);
                try {
                  throw StorageException.coalesce(
                      ApiExceptionFactory.createException(
                          "induced failure: " + info.getBlobId().toGsUtilUri(),
                          null,
                          GrpcStatusCode.of(Code.DATA_LOSS),
                          false));
                } finally {
                  blockForWrite1Complete.countDown();
                }
              } else {
                return super.internalDirectUpload(info, opts, buf);
              }
            }
          };
      ParallelCompositeUploadWritableByteChannel pcu =
          new ParallelCompositeUploadWritableByteChannel(
              bufferHandlePool,
              threadPool,
              partNamingStrategy,
              PartCleanupStrategy.never(),
              32,
              partMetadataFieldDecorator,
              finalObject,
              storageInternal,
              info,
              opts);

      byte[] bytes = DataGenerator.base64Characters().genBytes(bufferCapacity * 2 + 3);
      // write the first parts worth of bytes
      pcu.write(ByteBuffer.wrap(bytes, 0, bufferCapacity));
      // signal that the blocking on the internalDirectUpload can proceed
      blockForWrite1.countDown();
      // wait until the internalDirectUpload has failed
      blockForWrite1Complete.await();
      // attempt to write some more bytes, where we should get a failure
      StorageException storageException =
          assertThrows(
              StorageException.class,
              () -> {
                // due to the multiple threads doing uploads, it can sometimes take more than one
                // invocation in order for the short circuit to trigger
                for (int i = 0; i < 300; i++) {
                  pcu.write(ByteBuffer.wrap(bytes, bufferCapacity, bufferCapacity));
                }
              });
      // signal that the blocking on the internalDirectUpload can proceed
      // blockForWrite2.countDown();
      // wait until the internalDirectUpload has failed
      // blockForWrite2Complete.await();
      // calling close shouldn't cause another exception
      pcu.close();

      String name = info.getName();
      BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), -1L);

      CancellationException cancellationException =
          assertThrows(
              CancellationException.class,
              () -> ApiExceptions.callAndTranslateApiException(finalObject));

      assertAll(
          () -> {
            Optional<String> found =
                storageInternal.addedObjects.keySet().stream()
                    .map(BlobId::toGsUtilUri)
                    .filter(p1.toGsUtilUri()::equals)
                    .findFirst();
            assertThat(found.isPresent()).isFalse();
          },
          () -> {
            Optional<String> found =
                storageInternal.addedObjects.keySet().stream()
                    .map(BlobId::getName)
                    .filter(name::equals)
                    .findFirst();
            assertThat(found.isPresent()).isFalse();
          },
          () ->
              assertThat(storageException)
                  .hasMessageThat()
                  .contains("induced failure: " + p1.toGsUtilUri()),
          () ->
              assertThat(cancellationException)
                  .hasCauseThat()
                  .hasMessageThat()
                  .contains("induced failure: " + p1.toGsUtilUri()));
    } finally {
      threadPool.shutdownNow();
    }
  }

  @Test
  public void errorContextIsPopulated() throws Exception {
    //noinspection resource
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.never(),
            3,
            partMetadataFieldDecorator,
            finalObject,
            new FakeStorageInternal() {
              @Override
              public BlobInfo compose(ComposeRequest composeRequest) {
                BlobInfo response = super.compose(composeRequest);
                // return a bad crc32c
                return response.toBuilder().setCrc32c(Utils.crc32cCodec.encode(0)).build();
              }
            },
            info,
            opts);
    pcu.write(DataGenerator.base64Characters().genByteBuffer(3));

    AsynchronousCloseException se1 = assertThrows(AsynchronousCloseException.class, pcu::close);
    StorageException se2 =
        assertThrows(StorageException.class, () -> ApiFutureUtils.await(finalObject));

    String name = info.getName();
    // parts 1-4
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    // ultimate object
    BlobId expectedId = id(name, 2L);

    assertAll(
        () -> assertThat(se1).hasCauseThat().isInstanceOf(StorageException.class),
        () -> assertThat(se1).hasCauseThat().hasMessageThat().contains("Checksum mismatch"),
        () -> assertThat(se2).hasMessageThat().contains("Checksum mismatch"),
        () -> {
          assertThat(se2).hasCauseThat().isInstanceOf(ParallelCompositeUploadException.class);
          ParallelCompositeUploadException pcue = (ParallelCompositeUploadException) se2.getCause();
          // since we fail client side with a checksum validation, we expect the object to have been
          // created
          assertThat(pcue.getCreatedObjects().get()).containsExactly(p1, expectedId);
        },
        () -> assertThat(se2.getCode()).isEqualTo(400));
  }

  @Test
  public void partFailedPreconditionOnRetryIsHandledGracefully() throws Exception {
    String name = info.getName();
    // parts 1-4
    BlobId p1 = id(partNamingStrategy.fmtName(name, PartRange.of(1)), 1L);
    BlobId p2 = id(partNamingStrategy.fmtName(name, PartRange.of(2)), 2L);
    BlobId p3 = id(partNamingStrategy.fmtName(name, PartRange.of(3)), 3L);
    // ultimate object
    BlobId expectedId = id(name, 4L);

    FakeStorageInternal storageInternal =
        new FakeStorageInternal() {
          @Override
          public BlobInfo internalDirectUpload(
              BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
            BlobInfo blobInfo = super.internalDirectUpload(info, opts, buf);
            if (info.getName().equals(p1.getName())) {
              throw StorageException.coalesce(
                  ApiExceptionFactory.createException(
                      null, GrpcStatusCode.of(Code.FAILED_PRECONDITION), false));
            } else {
              return blobInfo;
            }
          }

          @Override
          public BlobInfo internalObjectGet(BlobId blobId, Opts<ObjectSourceOpt> opts) {
            Optional<BlobId> found = this.objectGet(blobId);
            if (found.isPresent()) {
              BlobId foundId = found.get();
              Data d = this.addedObjects.get(foundId);
              return d.getInfo();
            }
            throw StorageException.coalesce(
                ApiExceptionFactory.createException(
                    null, GrpcStatusCode.of(Code.NOT_FOUND), false));
          }
        };
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.always(),
            10,
            partMetadataFieldDecorator,
            finalObject,
            storageInternal,
            info,
            opts);

    byte[] bytes = DataGenerator.base64Characters().genBytes(bufferCapacity * 3 - 1);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();

    BlobInfo result = ApiFutureUtils.await(finalObject);

    assertAll(
        () -> assertThat(result.getBlobId()).isEqualTo(expectedId),
        () ->
            assertThat(storageInternal.addedObjects.keySet())
                .containsExactly(p1, p2, p3, expectedId),
        () -> assertThat(storageInternal.deleteRequests).containsExactly(p1, p2, p3));
  }

  @Test
  public void partMetadataFieldDecoratorUsesCustomTime() throws IOException {
    TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));
    OffsetDateTime rangeBegin =
        OffsetDateTime.from(Instant.EPOCH.plus(Duration.ofSeconds(29)).atZone(ZoneId.of("Z")));
    OffsetDateTime rangeEnd =
        OffsetDateTime.from(Instant.EPOCH.plus(Duration.ofMinutes(2)).atZone(ZoneId.of("Z")));

    FakeStorageInternal storageInternal =
        new FakeStorageInternal() {
          @Override
          public BlobInfo internalDirectUpload(
              BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
            if (info.getBlobId().getName().endsWith(".part")) {
              // Kinda hacky but since we are creating multiple parts we will use a range
              // to ensure the customTimes are being calculated appropriately
              assertThat(info.getCustomTimeOffsetDateTime().isAfter(rangeBegin)).isTrue();
              assertThat(info.getCustomTimeOffsetDateTime().isBefore(rangeEnd)).isTrue();
            } else {
              assertThat(info.getCustomTimeOffsetDateTime()).isNull();
            }
            return super.internalDirectUpload(info, opts, buf);
          }
        };
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.always(),
            10,
            PartMetadataFieldDecorator.setCustomTimeInFuture(Duration.ofSeconds(30))
                .newInstance(clock),
            finalObject,
            storageInternal,
            info,
            opts);
    byte[] bytes = DataGenerator.base64Characters().genBytes(bufferCapacity * 3 - 1);
    pcu.write(ByteBuffer.wrap(bytes));

    pcu.close();
  }

  @Test
  public void partDoesNotSpecifyAnyChecksum() throws IOException {
    FakeStorageInternal storageInternal =
        new FakeStorageInternal() {
          @Override
          public BlobInfo compose(ComposeRequest composeRequest) {
            BlobInfo target = composeRequest.getTarget();
            if (target.getBlobId().getName().startsWith(partNamingStrategy.prefix)) {
              assertThat(target.getCrc32c()).isNull();
              assertThat(target.getMd5()).isNull();
            }
            return super.compose(composeRequest);
          }
        };
    ChecksummedTestContent content = ChecksummedTestContent.gen(bufferCapacity * 3 - 1);
    ParallelCompositeUploadWritableByteChannel pcu =
        new ParallelCompositeUploadWritableByteChannel(
            bufferHandlePool,
            MoreExecutors.directExecutor(),
            partNamingStrategy,
            PartCleanupStrategy.always(),
            2,
            b -> b,
            finalObject,
            storageInternal,
            info.toBuilder()
                .setCrc32c(content.getCrc32cBase64())
                .setMd5(content.getMd5Base64())
                .build(),
            opts);
    pcu.write(content.asByteBuffer());

    pcu.close();
  }

  @NonNull
  private ParallelCompositeUploadWritableByteChannel defaultPcu(int maxElementsPerCompact) {
    return new ParallelCompositeUploadWritableByteChannel(
        bufferHandlePool,
        MoreExecutors.directExecutor(),
        partNamingStrategy,
        PartCleanupStrategy.always(),
        maxElementsPerCompact,
        partMetadataFieldDecorator,
        finalObject,
        storageInternal,
        info,
        opts);
  }

  private BlobId id(String name, long generation) {
    return BlobId.of(info.getBucket(), name, generation);
  }

  private static class FakeStorageInternal implements StorageInternal {
    protected final AtomicInteger generations;
    protected final Map<BlobId, Data> addedObjects;
    protected final List<ComposeRequest> composeRequests;
    protected final List<BlobId> deleteRequests;

    FakeStorageInternal() {
      generations = new AtomicInteger(1);
      addedObjects = Collections.synchronizedMap(new HashMap<>());
      composeRequests = Collections.synchronizedList(new ArrayList<>());
      deleteRequests = Collections.synchronizedList(new ArrayList<>());
    }

    @Override
    public BlobInfo internalDirectUpload(
        BlobInfo info, Opts<ObjectTargetOpt> opts, ByteBuffer buf) {
      BlobId id = info.getBlobId();

      BlobInfo.Builder b = info.toBuilder();
      WriteObjectRequest apply =
          opts.writeObjectRequest().apply(WriteObjectRequest.newBuilder()).build();
      if (apply.hasWriteObjectSpec() && apply.getWriteObjectSpec().hasIfGenerationMatch()) {
        long ifGenerationMatch = apply.getWriteObjectSpec().getIfGenerationMatch();
        Optional<BlobId> existing = objectGet(id);
        if (existing.isPresent()) {
          BlobId existingId = existing.get();
          if (ifGenerationMatch != existingId.getGeneration()) {
            throw StorageException.coalesce(
                ApiExceptionFactory.createException(
                    null, GrpcStatusCode.of(Code.FAILED_PRECONDITION), false));
          }
        }
      }
      BlobId newId = id.withGeneration(generations.getAndIncrement());
      b.setBlobId(newId);
      BlobInfo gen1 = b.build();
      addedObjects.put(newId, new Data(gen1, HASHER.hash(buf)));
      return gen1;
    }

    @NonNull
    protected Optional<BlobId> objectGet(BlobId id) {
      return addedObjects.keySet().stream()
          .filter(
              key -> key.getBucket().equals(id.getBucket()) && key.getName().equals(id.getName()))
          .findFirst();
    }

    @Override
    public BlobInfo compose(ComposeRequest composeRequest) {
      composeRequests.add(composeRequest);
      BlobInfo info = composeRequest.getTarget();
      String bucket = info.getBucket();
      BlobInfo.Builder b = info.toBuilder();
      BlobId newId = info.getBlobId().withGeneration(generations.getAndIncrement());
      b.setBlobId(newId);
      ImmutableList<Crc32cLengthKnown> crc32cs =
          composeRequest.getSourceBlobs().stream()
              .map(so -> BlobId.of(bucket, so.getName(), so.getGeneration()))
              .map(addedObjects::get)
              .map(Data::getCrc32c)
              .collect(ImmutableList.toImmutableList());

      Crc32cLengthKnown reduce =
          crc32cs.stream().reduce(Crc32cValue.zero(), Crc32cLengthKnown::concat);
      Preconditions.checkState(reduce != null, "unable to compute crc32c for compose request");
      b.setCrc32c(Utils.crc32cCodec.encode(reduce.getValue()));
      BlobInfo gen1 = b.build();
      addedObjects.put(newId, new Data(gen1, reduce));
      return gen1;
    }

    @Override
    public Void internalObjectDelete(BlobId id, Opts<ObjectSourceOpt> opts) {
      deleteRequests.add(id);
      boolean containsKey = addedObjects.containsKey(id);
      if (!containsKey) {
        throw ApiExceptionFactory.createException(null, GrpcStatusCode.of(Code.NOT_FOUND), false);
      }
      return null;
    }

    @Override
    public String toString() {
      return MoreObjects.toStringHelper(this)
          .add("generations", generations)
          .add("addedObjects", addedObjects)
          .add("composeRequests", composeRequests)
          .add("deleteRequests", deleteRequests)
          .toString();
    }

    protected static final class Data {
      private final BlobInfo info;
      private final Crc32cLengthKnown crc32c;

      private Data(BlobInfo info, Crc32cLengthKnown crc32c) {
        this.info = info;
        this.crc32c = crc32c;
      }

      public BlobInfo getInfo() {
        return info;
      }

      public Crc32cLengthKnown getCrc32c() {
        return crc32c;
      }
    }
  }

  private static class SimplisticPartNamingStrategy extends PartNamingStrategy {

    private final String prefix;

    private SimplisticPartNamingStrategy(String prefix) {
      super(null);
      this.prefix = prefix;
    }

    @Override
    String fmtName(String ultimateObjectName, PartRange partRange) {
      return String.format(
          Locale.US, "%s/%s/%s.part", prefix, ultimateObjectName, partRange.encode());
    }

    @Override
    protected String fmtFields(String randomKey, String nameDigest, String partRange) {
      return null;
    }
  }
}
