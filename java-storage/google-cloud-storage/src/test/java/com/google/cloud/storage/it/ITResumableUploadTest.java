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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TmpFile;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    backends = {Backend.PROD},
    transports = {Transport.HTTP, Transport.GRPC})
public final class ITResumableUploadTest {
  @Rule public final TemporaryFolder temp = new TemporaryFolder();

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Test
  public void expectedUploadSize_chunked_doesMatch()
      throws IOException, ExecutionException, InterruptedException, TimeoutException {
    doTestDoesMatch(storage);
  }

  @Test
  public void expectedUploadSize_chunked_doesNotMatch() throws IOException {
    doTestDoesNotMatch(storage);
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void expectedUploadSize_bidi_doesMatch() throws Exception {
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite())
            .build();
    try (Storage storage = options.getService()) {
      doTestDoesMatch(storage);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void expectedUploadSize_bidi_doesNotMatch() throws Exception {
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite())
            .build();
    try (Storage storage = options.getService()) {
      doTestDoesNotMatch(storage);
    }
  }

  @Test
  public void expectedUploadSize_ignored_pcu() throws Exception {
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.parallelCompositeUpload())
            .build();
    try (Storage storage = options.getService()) {
      int objectContentSize = 10;
      byte[] bytes = DataGenerator.base64Characters().genBytes(objectContentSize);
      BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
      BlobWriteSession session =
          storage.blobWriteSession(info, BlobWriteOption.expectedObjectSize(objectContentSize + 1));
      try (WritableByteChannel open = session.open()) {
        open.write(ByteBuffer.wrap(bytes));
      }

      BlobInfo gen1 = session.getResult().get(5, TimeUnit.SECONDS);
      assertThat(gen1.getSize()).isEqualTo(objectContentSize);
    }
  }

  @Test
  public void expectedUploadSize_createFrom_inputStream_doesMatch() throws Exception {
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.parallelCompositeUpload())
            .build();
    try (Storage storage = options.getService()) {
      int objectContentSize = 10;
      byte[] bytes = DataGenerator.base64Characters().genBytes(objectContentSize);
      BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
      BlobInfo gen1 =
          storage.createFrom(
              info,
              new ByteArrayInputStream(bytes),
              BlobWriteOption.expectedObjectSize(objectContentSize));
      assertThat(gen1.getSize()).isEqualTo(objectContentSize);
    }
  }

  @Test
  public void expectedUploadSize_createFrom_inputStream_doesNotMatch() throws Exception {
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.parallelCompositeUpload())
            .build();
    try (Storage storage = options.getService()) {
      int objectContentSize = 10;
      byte[] bytes = DataGenerator.base64Characters().genBytes(objectContentSize);
      BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
      StorageException se =
          assertThrows(
              StorageException.class,
              () ->
                  storage.createFrom(
                      info,
                      new ByteArrayInputStream(bytes),
                      BlobWriteOption.expectedObjectSize(objectContentSize + 1)));

      assertThat(se.getCode()).isEqualTo(400);
    }
  }

  @Test
  public void expectedUploadSize_createFrom_path_doesMatch() throws IOException {
    int objectContentSize = 10;
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    try (TmpFile tmpFile =
        DataGenerator.base64Characters().tempFile(temp.getRoot().toPath(), objectContentSize)) {
      BlobInfo gen1 =
          storage.createFrom(
              info, tmpFile.getPath(), BlobWriteOption.expectedObjectSize(objectContentSize));
      assertThat(gen1.getSize()).isEqualTo(objectContentSize);
    }
  }

  @Test
  public void expectedUploadSize_createFrom_path_doesNotMatch() throws IOException {
    int objectContentSize = 10;
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    try (TmpFile tmpFile =
        DataGenerator.base64Characters().tempFile(temp.getRoot().toPath(), objectContentSize)) {
      StorageException se =
          assertThrows(
              StorageException.class,
              () ->
                  storage.createFrom(
                      info,
                      tmpFile.getPath(),
                      BlobWriteOption.expectedObjectSize(objectContentSize + 1)));

      assertThat(se.getCode()).isEqualTo(400);
    }
  }

  private void doTestDoesMatch(Storage storage)
      throws IOException, InterruptedException, ExecutionException, TimeoutException {
    int objectContentSize = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(objectContentSize);
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobWriteSession session =
        storage.blobWriteSession(info, BlobWriteOption.expectedObjectSize(objectContentSize));
    try (WritableByteChannel open = session.open()) {
      open.write(ByteBuffer.wrap(bytes));
    }

    BlobInfo gen1 = session.getResult().get(5, TimeUnit.SECONDS);
    assertThat(gen1.getSize()).isEqualTo(objectContentSize);
  }

  private void doTestDoesNotMatch(Storage storage) throws IOException {
    int objectContentSize = 10;
    byte[] bytes = DataGenerator.base64Characters().genBytes(objectContentSize);
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    BlobWriteSession session =
        storage.blobWriteSession(info, BlobWriteOption.expectedObjectSize(objectContentSize + 1));

    WritableByteChannel open = session.open();
    open.write(ByteBuffer.wrap(bytes));
    StorageException se = assertThrows(StorageException.class, open::close);

    assertThat(se.getCode()).isEqualTo(400);
  }
}
