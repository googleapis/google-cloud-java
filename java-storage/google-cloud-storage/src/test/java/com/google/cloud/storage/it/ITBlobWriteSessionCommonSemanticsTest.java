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

package com.google.cloud.storage.it;

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfig;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartCleanupStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartMetadataFieldDecorator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ITBlobWriteSessionCommonSemanticsTest.ParamsProvider;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
@Parameterized(ParamsProvider.class)
public final class ITBlobWriteSessionCommonSemanticsTest {

  @Rule public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Inject public Storage injectedStorage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Parameter public Params params;

  private Storage storage;

  @Before
  public void setUp() throws Exception {
    Path tmpDir = temporaryFolder.newFolder().toPath();
    BlobWriteSessionConfig config = params.ctor.apply(tmpDir);

    StorageOptions originalOptions = injectedStorage.getOptions();
    StorageOptions newOptions = null;
    try {
      newOptions = originalOptions.toBuilder().setBlobWriteSessionConfig(config).build();
    } catch (IllegalArgumentException e) {
      assertThat(e).hasMessageThat().contains("not compatible with this");
      assumeTrue(false);
    }
    storage = newOptions.getService();
  }

  @After
  public void tearDown() throws Exception {
    if (storage != null) {
      storage.close();
    }
  }

  @Test
  public void closingAnOpenedSessionWithoutCallingWriteShouldMakeAnEmptyObject()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobWriteSession session = storage.blobWriteSession(info, BlobWriteOption.doesNotExist());

    WritableByteChannel open = session.open();
    open.close();
    BlobInfo gen1 = session.getResult().get(1, TimeUnit.SECONDS);

    // sometimes testbench will not define `.size = 0`, default it here if we get null
    Long size = gen1.getSize();
    if (size == null) {
      size = 0L;
    }
    assertThat(size).isEqualTo(0);
  }

  @Test
  public void attemptingToUseASessionWhichResultsInFailureShouldThrowAStorageException() {
    // attempt to write to a bucket which we have not created
    String badBucketName = bucket.getName() + "x";
    BlobInfo info = BlobInfo.newBuilder(badBucketName, generator.randomObjectName()).build();

    BlobWriteSession session = storage.blobWriteSession(info, BlobWriteOption.doesNotExist());
    StorageException se =
        assertThrows(
            StorageException.class,
            () -> {
              WritableByteChannel open = session.open();
              open.close();
            });

    assertThat(se.getCode()).isEqualTo(404);
  }

  @Test
  public void callingOpenIsOnlyAllowedOnce() throws Exception {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobWriteSession session = storage.blobWriteSession(info, BlobWriteOption.doesNotExist());

    WritableByteChannel open = session.open();
    IllegalStateException se = assertThrows(IllegalStateException.class, session::open);

    assertAll(() -> assertThat(se.getMessage()).contains("already open"));
  }

  @Test
  public void getResultErrorsWhenTheSessionErrors() throws Exception {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    byte[] helloWorld = "Hello World".getBytes(StandardCharsets.UTF_8);
    storage.create(info, helloWorld, BlobTargetOption.doesNotExist());

    BlobWriteSession session =
        storage.blobWriteSession(
            info,
            // this precondition will result in failure
            BlobWriteOption.doesNotExist());

    try (WritableByteChannel open = session.open()) {
      open.write(ByteBuffer.wrap(helloWorld));
    } catch (StorageException se) {
      assertThat(se.getCode()).isEqualTo(412);
    } catch (IOException ioe) {
      assertThat(ioe).hasCauseThat().isInstanceOf(StorageException.class);
      StorageException se = (StorageException) ioe.getCause();
      assertThat(se.getCode()).isEqualTo(412);
    }

    ExecutionException resultSe =
        assertThrows(ExecutionException.class, () -> session.getResult().get(10, TimeUnit.SECONDS));

    assertAll(
        () -> assertThat(resultSe).hasCauseThat().isInstanceOf(StorageException.class),
        () -> assertThat(((StorageException) resultSe.getCause()).getCode()).isEqualTo(412));
  }

  @Test
  public void userProvidedCrc32cValueIsRespected() throws IOException {
    assumeFalse("b/226975500", params.desc.startsWith("p"));
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(5 * 1024 * 1024 + 17));
    ChecksummedTestContent missingAByte = testContent.slice(0, testContent.getBytes().length - 1);

    BlobInfo info =
        BlobInfo.newBuilder(bucket, generator.randomObjectName())
            .setCrc32c(missingAByte.getCrc32cBase64())
            .build();
    BlobWriteSession session =
        storage.blobWriteSession(
            info, BlobWriteOption.crc32cMatch(), BlobWriteOption.doesNotExist());
    WritableByteChannel open = session.open();
    try {
      open.write(ByteBuffer.wrap(testContent.getBytes()));
    } finally {
      StorageException se = assertThrows(StorageException.class, () -> open.close());
      assertThat(se.getCode()).isEqualTo(400);
    }
  }

  @Test
  public void userProvidedMd5ValueIsRespected() throws IOException {
    assumeFalse("b/226975500", params.desc.startsWith("p"));
    ChecksummedTestContent testContent =
        ChecksummedTestContent.of(DataGenerator.base64Characters().genBytes(5 * 1024 * 1024 + 17));
    ChecksummedTestContent missingAByte = testContent.slice(0, testContent.getBytes().length - 1);

    BlobInfo info =
        BlobInfo.newBuilder(bucket, generator.randomObjectName())
            .setMd5(missingAByte.getMd5Base64())
            .build();
    BlobWriteSession session =
        storage.blobWriteSession(info, BlobWriteOption.md5Match(), BlobWriteOption.doesNotExist());
    WritableByteChannel open = session.open();
    try {
      open.write(ByteBuffer.wrap(testContent.getBytes()));
    } finally {
      StorageException se = assertThrows(StorageException.class, () -> open.close());
      assertThat(se.getCode()).isEqualTo(400);
    }
  }

  public static final class ParamsProvider implements ParametersProvider {
    @Override
    public ImmutableList<Params> parameters() {
      final int _2MiB = 2 * 1024 * 1024;
      final int _4MiB = 4 * 1024 * 1024;
      return ImmutableList.of(
          new Params("default", p -> BlobWriteSessionConfigs.getDefault()),
          new Params("c!c.2MiB", p -> BlobWriteSessionConfigs.getDefault().withChunkSize(_2MiB)),
          new Params("b!p.1", BlobWriteSessionConfigs::bufferToDiskThenUpload),
          new Params("j!p.1", p -> BlobWriteSessionConfigs.journaling(ImmutableList.of(p))),
          new Params(
              "p!t.c&b.s*&p.4MiB&c.n&m.n",
              p ->
                  BlobWriteSessionConfigs.parallelCompositeUpload()
                      .withExecutorSupplier(ExecutorSupplier.cachedPool())
                      .withPartNamingStrategy(PartNamingStrategy.noPrefix())
                      .withBufferAllocationStrategy(BufferAllocationStrategy.simple(_4MiB))
                      .withPartCleanupStrategy(PartCleanupStrategy.never())
                      .withPartMetadataFieldDecorator(PartMetadataFieldDecorator.noOp())),
          new Params("d!c.2MiB", p -> BlobWriteSessionConfigs.bidiWrite().withBufferSize(_2MiB)));
    }
  }

  public interface ParamsCtor {
    BlobWriteSessionConfig apply(Path p) throws IOException;
  }

  public static final class Params {
    private final String desc;
    private final ParamsCtor ctor;

    public Params(String desc, ParamsCtor ctor) {
      this.desc = desc;
      this.ctor = ctor;
    }

    @Override
    public String toString() {
      return desc;
    }
  }
}
