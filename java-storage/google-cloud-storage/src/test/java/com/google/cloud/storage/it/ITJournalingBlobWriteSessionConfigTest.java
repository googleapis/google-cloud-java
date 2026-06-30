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

import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.JournalingBlobWriteSessionConfig;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.SingleBackend;
import com.google.cloud.storage.it.runner.annotations.StorageFixture;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@SingleBackend(Backend.PROD)
public final class ITJournalingBlobWriteSessionConfigTest {
  private static final int _1MiB = 1024 * 1024;
  private static final int _256MiB = 256 * _1MiB;

  @Inject
  @StorageFixture(Transport.GRPC)
  public Storage storage;

  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Rule public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  private Storage journalingStorage;
  private Path tempDir;

  @Before
  public void setUp() throws Exception {
    tempDir = temporaryFolder.newFolder(generator.randomObjectName()).toPath();
    JournalingBlobWriteSessionConfig journaling =
        BlobWriteSessionConfigs.journaling(ImmutableList.of(tempDir));
    journalingStorage =
        this.storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(journaling)
            .build()
            .getService();
  }

  @After
  public void tearDown() throws Exception {
    if (journalingStorage != null) {
      journalingStorage.close();
    }
  }

  @Test
  public void allBytesProperlyTransmitted() throws Exception {

    Random rand = new Random(bucket.getName().hashCode());
    int objectSize = _256MiB;
    byte[] bytes = DataGenerator.rand(rand).genBytes(objectSize);

    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();

    BlobWriteSession blobWriteSession =
        journalingStorage.blobWriteSession(info, BlobWriteOption.doesNotExist());
    try (WritableByteChannel w = blobWriteSession.open()) {
      w.write(ByteBuffer.wrap(bytes));
    }

    BlobInfo resource = blobWriteSession.getResult().get(1, TimeUnit.SECONDS);

    byte[] actual = storage.readAllBytes(info.getBlobId());
    assertAll(
        () -> assertThat(resource.getSize()).isEqualTo(objectSize),
        () -> assertThat(actual).isEqualTo(bytes));
  }

  @Test
  public void journalFileMustNotBeLeftOnDiskAfterSuccess() throws IOException {
    BlobInfo info = BlobInfo.newBuilder(bucket, generator.randomObjectName()).build();
    byte[] bytes = DataGenerator.base64Characters().genBytes(17);
    BlobWriteSession blobWriteSession =
        journalingStorage.blobWriteSession(info, BlobWriteOption.doesNotExist());
    try (WritableByteChannel w = blobWriteSession.open()) {
      w.write(ByteBuffer.wrap(bytes));
    }

    try (Stream<Path> stream = Files.list(tempDir)) {
      ImmutableList<Path> leftOverFiles = stream.collect(ImmutableList.toImmutableList());
      assertThat(leftOverFiles).isEmpty();
    }
  }
}
