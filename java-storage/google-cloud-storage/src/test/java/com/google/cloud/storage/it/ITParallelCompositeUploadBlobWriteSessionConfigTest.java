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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.paging.Page;
import com.google.api.gax.rpc.ApiExceptions;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecorator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.BucketFixture;
import com.google.cloud.storage.it.runner.annotations.BucketType;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.it.runner.registry.KmsFixture;
import com.google.common.collect.ImmutableList;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousCloseException;
import java.nio.channels.WritableByteChannel;
import java.security.Key;
import java.time.Duration;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public final class ITParallelCompositeUploadBlobWriteSessionConfigTest {

  private static final int _1MiB = 1024 * 1024;
  private static ExecutorService exec;

  @Inject public BucketInfo bucket;

  @Inject
  @BucketFixture(BucketType.REQUESTER_PAYS)
  public BucketInfo rpBucket;

  @Inject public Storage injectedStorage;

  @Inject public Transport transport;

  @Inject public Generator generator;
  @Inject public KmsFixture kmsFixture;

  // configured Storage with the PCU config
  private Storage storage;
  private Random rand;

  @BeforeClass
  public static void beforeClass() {
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setDaemon(true).setNameFormat("test-pcuwbct-%d").build();
    exec = Executors.newCachedThreadPool(threadFactory);
  }

  @Before
  public void setUp() throws Exception {
    ParallelCompositeUploadBlobWriteSessionConfig pcu =
        BlobWriteSessionConfigs.parallelCompositeUpload()
            .withExecutorSupplier(ExecutorSupplier.useExecutor(exec))
            // define a max part size that is fairly small to aid in test speed
            .withBufferAllocationStrategy(BufferAllocationStrategy.simple(_1MiB))
            .withPartNamingStrategy(PartNamingStrategy.prefix("prefix-a"))
            // Write customTime 30 seconds in the future
            .withPartMetadataFieldDecorator(
                PartMetadataFieldDecorator.setCustomTimeInFuture(Duration.ofSeconds(30)))
            // let our fixtures take care of cleaning things
            .withPartCleanupStrategy(PartCleanupStrategy.never());

    StorageOptions storageOptions =
        injectedStorage.getOptions().toBuilder().setBlobWriteSessionConfig(pcu).build();
    storage = storageOptions.getService();
    rand = new Random();
  }

  @After
  public void tearDown() throws Exception {
    if (storage != null) {
      storage.close();
    }
  }

  @AfterClass
  public static void afterClass() {
    if (exec != null) {
      exec.shutdownNow();
    }
  }

  @Test
  public void partFilesCreatedWithCustomTimeWritten() throws IOException {
    doTest(bucket, 10 * _1MiB + 37, ImmutableList.of(), ImmutableList.of(), ImmutableList.of());
    Page<Blob> blobs = storage.list(bucket.getName(), Storage.BlobListOption.prefix("prefix-a"));
    for (Blob blob : blobs.iterateAll()) {
      assertThat(blob.getCustomTimeOffsetDateTime()).isNotNull();
    }
  }

  @Test
  public void errorRaisedByMethodAndFutureResult() throws IOException {

    BlobInfo info =
        BlobInfo.newBuilder(bucket.getName() + "x", generator.randomObjectName()).build();
    byte[] bytes = DataGenerator.rand(rand).genBytes(1);

    BlobWriteSession session = storage.blobWriteSession(info, BlobWriteOption.doesNotExist());
    try {
      try (WritableByteChannel channel = session.open()) {
        channel.write(ByteBuffer.wrap(bytes));
      }
      // it is okay if the exception is raised during write itself or close, if it happens during
      // close we should get an AsynchronousCloseException
    } catch (AsynchronousCloseException ace) {
      assertThat(((StorageException) ace.getCause()).getCode()).isEqualTo(404);
    } catch (StorageException se) {
      assertThat(se.getCode()).isEqualTo(404);
    }

    // the result future should resolve to a failure specifying the failure kind
    StorageException se =
        assertThrows(
            StorageException.class,
            () -> ApiExceptions.callAndTranslateApiException(session.getResult()));
    assertThat(se.getCode()).isEqualTo(404);
  }

  @Test
  public void uploadingAnObjectWorks() throws Exception {
    doTest(bucket, 32 * _1MiB + 37, ImmutableList.of(), ImmutableList.of(), ImmutableList.of());
  }

  @Test
  public void uploadingAnObjectWorks_requesterPays() throws Exception {
    String projectId = storage.getOptions().getProjectId();
    int _1MiB = 1024 * 1024;
    doTest(
        rpBucket,
        32 * _1MiB + 37,
        ImmutableList.of(BlobTargetOption.userProject(projectId)),
        ImmutableList.of(BlobWriteOption.userProject(projectId)),
        ImmutableList.of(BlobSourceOption.userProject(projectId)));
  }

  @Test
  public void uploadingAnObjectWorks_customerSuppliedEncryptionKey() throws IOException {
    CSEKSupport csek = CSEKSupport.create();
    Key key = csek.getKey();

    doTest(
        bucket,
        16 * _1MiB - 13,
        ImmutableList.of(BlobTargetOption.encryptionKey(key)),
        ImmutableList.of(BlobWriteOption.encryptionKey(key)),
        ImmutableList.of(BlobSourceOption.decryptionKey(key)));
  }

  @Test
  public void uploadingAnObjectWorks_kms() throws IOException {
    CryptoKey key1 = kmsFixture.getKey1();
    doTest(
        bucket,
        16 * _1MiB - 13,
        ImmutableList.of(BlobTargetOption.kmsKeyName(key1.getName())),
        ImmutableList.of(BlobWriteOption.kmsKeyName(key1.getName())),
        ImmutableList.of());
  }

  /**
   * Create an empty object, then overwrite it using a Parallel Composite Upload, then read the full
   * object and verify its contents match exactly with what was written.
   */
  private void doTest(
      BucketInfo bucket,
      int objectSizeBytes,
      ImmutableList<BlobTargetOption> overriddenCreateOptions,
      ImmutableList<BlobWriteOption> overriddenOverwriteOptions,
      ImmutableList<BlobSourceOption> overriddenReadOptions)
      throws IOException {

    BlobTargetOption[] createOptions =
        BlobTargetOption.dedupe(
            ImmutableList.of(BlobTargetOption.doesNotExist()),
            overriddenCreateOptions.toArray(new BlobTargetOption[0]));
    BlobWriteOption[] overwriteOptions =
        BlobWriteOption.dedupe(
            ImmutableList.of(BlobWriteOption.generationMatch()),
            overriddenOverwriteOptions.toArray(new BlobWriteOption[0]));
    BlobSourceOption[] readOptions =
        BlobSourceOption.dedupe(
            ImmutableList.of(), overriddenReadOptions.toArray(new BlobSourceOption[0]));

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    Blob gen1 = storage.create(info, createOptions);

    byte[] bytes = DataGenerator.rand(rand).genBytes(objectSizeBytes);

    BlobWriteSession session = storage.blobWriteSession(gen1, overwriteOptions);

    try (WritableByteChannel channel = session.open()) {
      long written = channel.write(ByteBuffer.wrap(bytes));
      assertThat(written).isEqualTo(objectSizeBytes);
    }

    BlobInfo result = ApiExceptions.callAndTranslateApiException(session.getResult());

    assertThat(result.getCrc32c()).isNotNull();
    assertThat(result.getGeneration()).isNotNull();

    byte[] actual = storage.readAllBytes(result.getBlobId(), readOptions);

    assertThat(actual).isEqualTo(bytes);
    assertThat(xxd(actual)).isEqualTo(xxd(bytes));
  }
}
