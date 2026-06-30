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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.JournalingBlobWriteSessionConfig;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = {Backend.PROD})
public final class ITBlobWriteSessionTest {

  @Rule public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Inject public Storage storage;

  @Inject public BucketInfo bucket;

  @Inject public Generator generator;

  @Test
  public void allDefaults() throws Exception {
    doTest(storage);
  }

  @Test
  public void bufferToTempDirThenUpload() throws Exception {
    Path path = temporaryFolder.newFolder().toPath();
    StorageOptions options =
        storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bufferToDiskThenUpload(path))
            .build();
    try (Storage s = options.getService()) {
      doTest(s);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.GRPC)
  public void journalingNotSupportedByHttp() {
    HttpStorageOptions.Builder builder = ((HttpStorageOptions) storage.getOptions()).toBuilder();

    Path rootPath = temporaryFolder.getRoot().toPath();
    JournalingBlobWriteSessionConfig journaling =
        BlobWriteSessionConfigs.journaling(ImmutableList.of(rootPath));

    IllegalArgumentException iae =
        assertThrows(
            IllegalArgumentException.class, () -> builder.setBlobWriteSessionConfig(journaling));

    assertThat(iae).hasMessageThat().contains("HTTP transport");
  }

  @Test
  public void overrideDefaultBufferSize() throws Exception {
    StorageOptions options =
        (storage.getOptions())
            .toBuilder()
                .setBlobWriteSessionConfig(
                    BlobWriteSessionConfigs.getDefault().withChunkSize(256 * 1024))
                .build();

    try (Storage s = options.getService()) {
      doTest(s);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void bidiTest() throws Exception {
    StorageOptions options =
        (storage.getOptions())
            .toBuilder().setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite()).build();
    try (Storage s = options.getService()) {
      doTest(s);
    }
  }

  private void doTest(Storage underTest) throws Exception {
    BlobWriteSession sess =
        underTest.blobWriteSession(
            BlobInfo.newBuilder(bucket, generator.randomObjectName()).build(),
            BlobWriteOption.doesNotExist());

    byte[] bytes = DataGenerator.base64Characters().genBytes(512 * 1024);
    try (WritableByteChannel w = sess.open()) {
      w.write(ByteBuffer.wrap(bytes));
    }

    BlobInfo gen1 = sess.getResult().get(10, TimeUnit.SECONDS);

    byte[] allBytes = storage.readAllBytes(gen1.getBlobId());

    assertThat(allBytes).isEqualTo(bytes);
  }
}
