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
import static com.google.cloud.storage.TestUtils.xxd;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assert.assertThrows;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.io.ByteStreams;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Stream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

public final class RecoveryFileManagerTest {
  private static final int _128KiB = 128 * 1024;

  @Rule public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Rule public final TestName testName = new TestName();

  private final TestClock clock = TestClock.tickBy(Instant.EPOCH, Duration.ofSeconds(1));

  @Test
  public void happyPath() throws IOException {
    Path tempDir = temporaryFolder.newFolder(testName.getMethodName()).toPath();
    RecoveryFileManager rfm =
        RecoveryFileManager.of(
            ImmutableList.of(tempDir),
            path -> ThroughputSink.logged(path.toAbsolutePath().toString(), clock));

    BlobInfo info = BlobInfo.newBuilder("bucket", "object").build();
    try (RecoveryFile recoveryFile = rfm.newRecoveryFile(info)) {

      byte[] bytes = DataGenerator.base64Characters().genBytes(_128KiB);
      try (WritableByteChannel writer = recoveryFile.writer()) {
        writer.write(ByteBuffer.wrap(bytes));
      }

      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      try (SeekableByteChannel r = recoveryFile.reader();
          WritableByteChannel w = Channels.newChannel(baos)) {
        long copy = ByteStreams.copy(r, w);
        assertThat(copy).isEqualTo(_128KiB);
      }

      assertThat(baos.toByteArray()).isEqualTo(bytes);
    }

    try (Stream<Path> stream = Files.list(tempDir)) {
      boolean b = stream.anyMatch(Objects::nonNull);
      assertThat(b).isFalse();
    }
  }

  @Test
  public void argValidation_nonEmpty() {
    IllegalArgumentException iae =
        assertThrows(
            IllegalArgumentException.class, () -> RecoveryFileManager.of(ImmutableList.of()));

    assertThat(iae).hasMessageThat().isNotEmpty();
  }

  @Test
  public void argValidation_fileInsteadOfDirectory() throws IOException {
    Path tempDir = temporaryFolder.newFile(testName.getMethodName()).toPath();

    IllegalArgumentException iae =
        assertThrows(
            IllegalArgumentException.class,
            () -> RecoveryFileManager.of(ImmutableList.of(tempDir)));

    assertThat(iae).hasMessageThat().isNotEmpty();
  }

  @Test
  public void argValidation_directoryDoesNotExistIsCreated() throws IOException {
    Path tempDir = temporaryFolder.newFolder(testName.getMethodName()).toPath();

    Path subPathA = tempDir.resolve("sub/path/a");

    assertThat(Files.exists(subPathA)).isFalse();
    RecoveryFileManager rfm = RecoveryFileManager.of(ImmutableList.of(subPathA));
    assertThat(Files.exists(subPathA)).isTrue();
  }

  @Test
  public void fileAssignmentIsRoundRobin() throws IOException {
    Path tempDir1 = temporaryFolder.newFolder(testName.getMethodName() + "1").toPath();
    Path tempDir2 = temporaryFolder.newFolder(testName.getMethodName() + "2").toPath();
    Path tempDir3 = temporaryFolder.newFolder(testName.getMethodName() + "3").toPath();
    RecoveryFileManager rfm =
        RecoveryFileManager.of(ImmutableList.of(tempDir1, tempDir2, tempDir3));

    BlobInfo info1 = BlobInfo.newBuilder("bucket", "object1").build();
    BlobInfo info2 = BlobInfo.newBuilder("bucket", "object2").build();
    BlobInfo info3 = BlobInfo.newBuilder("bucket", "object3").build();
    try (RecoveryFile recoveryFile1 = rfm.newRecoveryFile(info1);
        RecoveryFile recoveryFile2 = rfm.newRecoveryFile(info2);
        RecoveryFile recoveryFile3 = rfm.newRecoveryFile(info3)) {

      ImmutableSet<Path> paths =
          Stream.of(recoveryFile1, recoveryFile2, recoveryFile3)
              .map(rf -> rf.unsafe().touch())
              .map(Path::toAbsolutePath)
              .collect(ImmutableSet.toImmutableSet());

      ImmutableSet<Path> parentDirs =
          Stream.of(recoveryFile1, recoveryFile2, recoveryFile3)
              .map(RecoveryFile::getPath)
              .map(Path::getParent)
              .collect(ImmutableSet.toImmutableSet());

      assertThat(paths).hasSize(3);
      assertThat(parentDirs).isEqualTo(ImmutableSet.of(tempDir1, tempDir2, tempDir3));
    }
  }

  @Test
  public void multipleRecoveryFilesForEqualBlobInfoAreAbleToExistConcurrently() throws Exception {
    Path tempDir = temporaryFolder.newFolder(testName.getMethodName()).toPath();
    RecoveryFileManager rfm =
        RecoveryFileManager.of(
            ImmutableList.of(tempDir),
            path -> ThroughputSink.logged(path.toAbsolutePath().toString(), clock));

    BlobInfo info = BlobInfo.newBuilder("bucket", "object").build();
    try (RecoveryFile rf1 = rfm.newRecoveryFile(info);
        RecoveryFile rf2 = rfm.newRecoveryFile(info); ) {

      Random rand = new Random(467123);
      byte[] bytes1 = DataGenerator.rand(rand).genBytes(7);
      byte[] bytes2 = DataGenerator.rand(rand).genBytes(41);
      try (WritableByteChannel writer = rf1.writer()) {
        writer.write(ByteBuffer.wrap(bytes1));
      }
      try (WritableByteChannel writer = rf2.writer()) {
        writer.write(ByteBuffer.wrap(bytes2));
      }

      byte[] actual1 = ByteStreams.toByteArray(Files.newInputStream(rf1.getPath()));
      byte[] actual2 = ByteStreams.toByteArray(Files.newInputStream(rf2.getPath()));

      String expected1 = xxd(bytes1);
      String expected2 = xxd(bytes2);

      String xxd1 = xxd(actual1);
      String xxd2 = xxd(actual2);
      assertAll(
          () -> assertWithMessage("rf1 should contain bytes1").that(xxd1).isEqualTo(expected1),
          () -> assertWithMessage("rf2 should contain bytes2").that(xxd2).isEqualTo(expected2));
    }
  }
}
