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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.cloud.storage.TmpDir;
import com.google.cloud.storage.TmpFile;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.ITObjectChecksumSupportTest.ChecksummedTestContentProvider;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.annotations.Parameterized;
import com.google.cloud.storage.it.runner.annotations.Parameterized.Parameter;
import com.google.cloud.storage.it.runner.annotations.Parameterized.ParametersProvider;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.common.collect.ImmutableList;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP, Transport.GRPC},
    backends = Backend.PROD)
@Parameterized(ChecksummedTestContentProvider.class)
public final class ITObjectChecksumSupportTest {

  private static final Path tmpDir = Paths.get(System.getProperty("java.io.tmpdir"));

  @Inject public Generator generator;

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;

  @Inject public Transport transport;

  @Parameter public ChecksummedTestContent content;

  @Rule public final TestName testName = new TestName();

  public static final class ChecksummedTestContentProvider implements ParametersProvider {

    @Override
    public ImmutableList<?> parameters() {
      DataGenerator gen = DataGenerator.base64Characters();
      int _256KiB = 256 * 1024;
      int _2MiB = 2 * 1024 * 1024;
      int _24MiB = 24 * 1024 * 1024;

      return ImmutableList.of(
          // empty object content
          ChecksummedTestContent.of(new byte[0]),
          // small, single message single stream when resumable
          ChecksummedTestContent.of(gen.genBytes(15)),
          // med, multiple messages single stream when resumable
          ChecksummedTestContent.of(gen.genBytes(_2MiB + 3)),
          // large, multiple messages and multiple streams when resumable
          ChecksummedTestContent.of(gen.genBytes(_24MiB + 5)),
          // quantum aligned number of bytes
          ChecksummedTestContent.of(gen.genBytes(_2MiB * 8 + _256KiB)));
    }
  }

  @Test
  public void testCrc32cValidated_createFrom_expectFailure() {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.concat('x');
    StorageException expected =
        assertThrows(
            StorageException.class,
            () ->
                storage.createFrom(
                    blobInfo,
                    new ByteArrayInputStream(bytes),
                    BlobWriteOption.doesNotExist(),
                    BlobWriteOption.crc32cMatch()));
    assertThat(expected.getCode()).isEqualTo(400);
  }

  @Test
  public void testCrc32cValidated_createFrom_expectSuccess() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.getBytes();
    Blob blob =
        storage.createFrom(
            blobInfo,
            new ByteArrayInputStream(bytes),
            BlobWriteOption.doesNotExist(),
            BlobWriteOption.crc32cMatch());
    assertThat(blob.getCrc32c()).isEqualTo(content.getCrc32cBase64());
  }

  @Test
  public void testCrc32cValidated_createFrom_path_expectFailure() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    try (TmpFile tmpFile = TmpFile.of(tmpDir, "prefix", "bin")) {
      try (SeekableByteChannel writer = tmpFile.writer()) {
        writer.write(ByteBuffer.wrap(content.concat('x')));
      }
      StorageException expected =
          assertThrows(
              StorageException.class,
              () ->
                  storage.createFrom(
                      blobInfo,
                      tmpFile.getPath(),
                      BlobWriteOption.doesNotExist(),
                      BlobWriteOption.crc32cMatch()));
      assertThat(expected.getCode()).isEqualTo(400);
    }
  }

  @Test
  public void testCrc32cValidated_createFrom_path_expectSuccess() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    try (TmpFile tmpFile = TmpFile.of(tmpDir, "prefix", "bin")) {
      try (SeekableByteChannel writer = tmpFile.writer()) {
        writer.write(ByteBuffer.wrap(content.getBytes()));
      }

      Blob blob =
          storage.createFrom(
              blobInfo,
              tmpFile.getPath(),
              BlobWriteOption.doesNotExist(),
              BlobWriteOption.crc32cMatch());
      assertThat(blob.getCrc32c()).isEqualTo(content.getCrc32cBase64());
    }
  }

  @Test
  public void testCrc32cValidated_writer_expectFailure() {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.concat('x');
    StorageException expected =
        assertThrows(
            StorageException.class,
            () -> {
              try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
                  WriteChannel dst =
                      storage.writer(
                          blobInfo,
                          BlobWriteOption.doesNotExist(),
                          BlobWriteOption.crc32cMatch())) {
                ByteStreams.copy(src, dst);
              }
            });
    assertThat(expected.getCode()).isEqualTo(400);
  }

  @Test
  public void testCrc32cValidated_writer_expectSuccess() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.getBytes();

    try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
        WriteChannel dst =
            storage.writer(
                blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.crc32cMatch())) {
      ByteStreams.copy(src, dst);
    }

    Blob blob = storage.get(blobId);
    assertThat(blob.getCrc32c()).isEqualTo(content.getCrc32cBase64());
  }

  @Test
  public void testMd5Validated_createFrom_expectFailure() {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMd5(content.getMd5Base64()).build();

    byte[] bytes = content.concat('x');
    StorageException expected =
        assertThrows(
            StorageException.class,
            () ->
                storage.createFrom(
                    blobInfo,
                    new ByteArrayInputStream(bytes),
                    BlobWriteOption.doesNotExist(),
                    BlobWriteOption.md5Match()));
    assertThat(expected.getCode()).isEqualTo(400);
  }

  @Test
  public void testMd5Validated_createFrom_expectSuccess() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMd5(content.getMd5Base64()).build();

    byte[] bytes = content.getBytes();
    Blob blob =
        storage.createFrom(
            blobInfo,
            new ByteArrayInputStream(bytes),
            BlobWriteOption.doesNotExist(),
            BlobWriteOption.md5Match());
    assertThat(blob.getMd5()).isEqualTo(content.getMd5Base64());
  }

  @Test
  public void testMd5Validated_writer_expectFailure() {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMd5(content.getMd5Base64()).build();

    byte[] bytes = content.concat('x');
    StorageException expected =
        assertThrows(
            StorageException.class,
            () -> {
              try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
                  WriteChannel dst =
                      storage.writer(
                          blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.md5Match())) {
                ByteStreams.copy(src, dst);
              }
            });
    assertThat(expected.getCode()).isEqualTo(400);
  }

  @Test
  public void testMd5Validated_writer_expectSuccess() throws IOException {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setMd5(content.getMd5Base64()).build();

    byte[] bytes = content.getBytes();

    try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
        WriteChannel dst =
            storage.writer(blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.md5Match())) {
      ByteStreams.copy(src, dst);
    }

    Blob blob = storage.get(blobId);
    assertThat(blob.getMd5()).isEqualTo(content.getMd5Base64());
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void testCrc32cValidated_bidiWrite_expectSuccess() throws Exception {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.getBytes();

    StorageOptions optionsWithBidi =
        this.storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite())
            .build();

    try (Storage storage = optionsWithBidi.getService()) {
      BlobWriteSession session =
          storage.blobWriteSession(
              blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.crc32cMatch());

      try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
          WritableByteChannel dst = session.open()) {
        ByteStreams.copy(src, dst);
      }

      BlobInfo gen1 = session.getResult().get(5, TimeUnit.SECONDS);
      assertThat(gen1.getCrc32c()).isEqualTo(content.getCrc32cBase64());
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void testCrc32cValidated_bidiWrite_expectFailure() throws Exception {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.concat('x');

    StorageOptions optionsWithBidi =
        this.storage.getOptions().toBuilder()
            .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite())
            .build();

    try (Storage storage = optionsWithBidi.getService()) {
      BlobWriteSession session =
          storage.blobWriteSession(
              blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.crc32cMatch());

      WritableByteChannel dst = session.open();
      try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes))) {
        ByteStreams.copy(src, dst);
      }

      StorageException expected = assertThrows(StorageException.class, dst::close);

      assertThat(expected.getCode()).isEqualTo(400);
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void testCrc32cValidated_journaling_expectSuccess() throws Exception {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.getBytes();

    try (TmpDir journalingDir = TmpDir.of(tmpDir, testName.getMethodName())) {
      StorageOptions options =
          this.storage.getOptions().toBuilder()
              .setBlobWriteSessionConfig(
                  BlobWriteSessionConfigs.journaling(ImmutableList.of(journalingDir.getPath())))
              .build();

      try (Storage storage = options.getService()) {
        BlobWriteSession session =
            storage.blobWriteSession(
                blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.crc32cMatch());

        try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes));
            WritableByteChannel dst = session.open()) {
          ByteStreams.copy(src, dst);
        }

        BlobInfo gen1 = session.getResult().get(5, TimeUnit.SECONDS);
        assertThat(gen1.getCrc32c()).isEqualTo(content.getCrc32cBase64());
      }
    }
  }

  @Test
  @CrossRun.Exclude(transports = Transport.HTTP)
  public void testCrc32cValidated_journaling_expectFailure() throws Exception {
    String blobName = generator.randomObjectName();
    BlobId blobId = BlobId.of(bucket.getName(), blobName);
    BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setCrc32c(content.getCrc32cBase64()).build();

    byte[] bytes = content.concat('x');

    try (TmpDir journalingDir = TmpDir.of(tmpDir, generator.randomObjectName())) {
      StorageOptions options =
          this.storage.getOptions().toBuilder()
              .setBlobWriteSessionConfig(
                  BlobWriteSessionConfigs.journaling(ImmutableList.of(journalingDir.getPath())))
              .build();

      try (Storage storage = options.getService()) {
        BlobWriteSession session =
            storage.blobWriteSession(
                blobInfo, BlobWriteOption.doesNotExist(), BlobWriteOption.crc32cMatch());

        WritableByteChannel dst = session.open();
        try (ReadableByteChannel src = Channels.newChannel(new ByteArrayInputStream(bytes))) {
          ByteStreams.copy(src, dst);
        }

        StorageException expected = assertThrows(StorageException.class, dst::close);

        assertThat(expected.getCode()).isEqualTo(400);
      }
    }
  }
}
