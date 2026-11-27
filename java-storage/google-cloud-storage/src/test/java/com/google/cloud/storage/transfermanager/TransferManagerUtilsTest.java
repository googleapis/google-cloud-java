/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage.transfermanager;

import static com.google.common.truth.Truth.assertThat;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.mockito.Mockito;

public final class TransferManagerUtilsTest {

  @Rule public final TemporaryFolder temporaryFolder = new TemporaryFolder();

  @Test
  public void createAndValidateDestPath_returnsNullForSymbolicLinkTarget() throws Exception {
    Path downloadDir = temporaryFolder.newFolder("download-dir").toPath();
    Path otherDir = temporaryFolder.newFolder("other-dir").toPath();
    Files.createSymbolicLink(
        downloadDir.resolve("example-file.txt"), otherDir.resolve("example-target.txt"));

    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(downloadDir)
            .build();
    BlobInfo blob = BlobInfo.newBuilder("example-bucket", "example-file.txt").build();

    assertThat(TransferManagerUtils.createAndValidateDestPath(config, blob)).isNull();
  }

  @Test
  public void createAndValidateDestPath_returnsNullForIntermediateDirectorySymbolicLink()
      throws Exception {
    Path downloadDir = temporaryFolder.newFolder("download-dir").toPath();
    Path otherDir = temporaryFolder.newFolder("other-dir").toPath();
    Files.createSymbolicLink(downloadDir.resolve("linked-dir"), otherDir);

    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(downloadDir)
            .build();
    BlobInfo blob =
        BlobInfo.newBuilder("example-bucket", "linked-dir/sub/example-file.txt").build();

    assertThat(TransferManagerUtils.createAndValidateDestPath(config, blob)).isNull();
    assertThat(Files.exists(otherDir.resolve("sub"))).isFalse();
  }

  @Test
  public void createAndValidateDestPath_allowsSymlinkedDownloadDirectoryPrefix() throws Exception {
    Path realDownloadDir = temporaryFolder.newFolder("real-download-dir").toPath();
    Path linkedDownloadDir = temporaryFolder.getRoot().toPath().resolve("linked-download-dir");
    Files.createSymbolicLink(linkedDownloadDir, realDownloadDir);

    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(linkedDownloadDir)
            .build();
    BlobInfo directBlob = BlobInfo.newBuilder("example-bucket", "example-file.txt").build();
    Path directResult = TransferManagerUtils.createAndValidateDestPath(config, directBlob);
    assertThat(directResult)
        .isEqualTo(linkedDownloadDir.toAbsolutePath().normalize().resolve("example-file.txt"));

    BlobInfo blob = BlobInfo.newBuilder("example-bucket", "sub/example-file.txt").build();

    Path result = TransferManagerUtils.createAndValidateDestPath(config, blob);

    assertThat(result)
        .isEqualTo(linkedDownloadDir.toAbsolutePath().normalize().resolve("sub/example-file.txt"));
    assertThat(Files.isDirectory(realDownloadDir.resolve("sub"))).isTrue();
  }

  @Test
  public void createAndValidateDestPath_returnsPathWhenParentIsRegularFile() throws Exception {
    Path downloadDir = temporaryFolder.newFolder("download-dir").toPath();
    Files.write(
        downloadDir.resolve("example-entry"), "initial-content".getBytes(StandardCharsets.UTF_8));

    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(downloadDir)
            .build();
    BlobInfo blob = BlobInfo.newBuilder("example-bucket", "example-entry/example-file.txt").build();

    assertThat(TransferManagerUtils.createAndValidateDestPath(config, blob))
        .isEqualTo(
            downloadDir.toAbsolutePath().normalize().resolve("example-entry/example-file.txt"));
  }

  @Test
  public void directDownloadCallable_failsToStartWhenDestPathIsSymbolicLink() throws Exception {
    Path downloadDir = temporaryFolder.newFolder("download-dir").toPath();
    Path targetFile = createTargetFile("example-target.txt");
    Path destPath = createLinkedDestination(downloadDir, targetFile);

    byte[] payload = "example-content".getBytes(StandardCharsets.UTF_8);
    Storage storage = mockStorageWithPayload(payload);
    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(downloadDir)
            .build();
    BlobInfo blob = BlobInfo.newBuilder("example-bucket", "example-file.txt").build();

    DirectDownloadCallable callable =
        new DirectDownloadCallable(storage, blob, config, new BlobSourceOption[0], destPath);
    DownloadResult result = callable.call();

    assertThat(result.getStatus()).isEqualTo(TransferStatus.FAILED_TO_START);
    assertThat(result.getException()).isInstanceOf(IOException.class);
    assertThat(new String(Files.readAllBytes(targetFile), StandardCharsets.UTF_8))
        .isEqualTo("initial-content");
  }

  @Test
  public void chunkedDownloadCallable_failsToStartWhenDestPathIsSymbolicLink() throws Exception {
    Path downloadDir = temporaryFolder.newFolder("download-dir").toPath();
    Path targetFile = createTargetFile("example-target.txt");
    Path destPath = createLinkedDestination(downloadDir, targetFile);

    byte[] payload = "example-content".getBytes(StandardCharsets.UTF_8);
    Storage storage = mockStorageWithPayload(payload);
    BlobInfo blob = BlobInfo.newBuilder("example-bucket", "example-file.txt").build();

    ChunkedDownloadCallable callable =
        new ChunkedDownloadCallable(
            storage, blob, new BlobSourceOption[0], destPath, 0L, payload.length);
    DownloadSegment result = callable.call();

    assertThat(result.getStatus()).isEqualTo(TransferStatus.FAILED_TO_START);
    assertThat(result.getException()).isInstanceOf(IOException.class);
    assertThat(new String(Files.readAllBytes(targetFile), StandardCharsets.UTF_8))
        .isEqualTo("initial-content");
  }

  @Test
  public void downloadCallables_writeRegularFilesUnderSymlinkedDownloadDirectory()
      throws Exception {
    Path realDownloadDir = temporaryFolder.newFolder("real-download-dir").toPath();
    Path linkedDownloadDir = temporaryFolder.getRoot().toPath().resolve("linked-download-dir");
    Files.createSymbolicLink(linkedDownloadDir, realDownloadDir);

    byte[] payload = "example-content".getBytes(StandardCharsets.UTF_8);
    ParallelDownloadConfig config =
        ParallelDownloadConfig.newBuilder()
            .setBucketName("example-bucket")
            .setDownloadDirectory(linkedDownloadDir)
            .build();

    BlobInfo directBlob = BlobInfo.newBuilder("example-bucket", "sub/direct-file.txt").build();
    Path directDest = TransferManagerUtils.createAndValidateDestPath(config, directBlob);
    DownloadResult directResult =
        new DirectDownloadCallable(
                mockStorageWithPayload(payload),
                directBlob,
                config,
                new BlobSourceOption[0],
                directDest)
            .call();
    assertThat(directResult.getStatus()).isEqualTo(TransferStatus.SUCCESS);
    assertThat(new String(Files.readAllBytes(directDest), StandardCharsets.UTF_8))
        .isEqualTo("example-content");

    BlobInfo chunkedBlob = BlobInfo.newBuilder("example-bucket", "sub/chunked-file.txt").build();
    Path chunkedDest = TransferManagerUtils.createAndValidateDestPath(config, chunkedBlob);
    DownloadSegment chunkedResult =
        new ChunkedDownloadCallable(
                mockStorageWithPayload(payload),
                chunkedBlob,
                new BlobSourceOption[0],
                chunkedDest,
                0L,
                payload.length)
            .call();
    assertThat(chunkedResult.getStatus()).isEqualTo(TransferStatus.SUCCESS);
    assertThat(new String(Files.readAllBytes(chunkedDest), StandardCharsets.UTF_8))
        .isEqualTo("example-content");
  }

  private Path createTargetFile(String fileName) throws IOException {
    Path otherDir = temporaryFolder.newFolder("other-dir").toPath();
    Path targetFile = otherDir.resolve(fileName);
    Files.write(targetFile, "initial-content".getBytes(StandardCharsets.UTF_8));
    return targetFile;
  }

  private static Path createLinkedDestination(Path downloadDir, Path targetFile)
      throws IOException {
    return Files.createSymbolicLink(downloadDir.resolve("example-file.txt"), targetFile);
  }

  private static Storage mockStorageWithPayload(byte[] payload) throws IOException {
    Storage storage = Mockito.mock(Storage.class);
    ReadChannel readChannel = Mockito.mock(ReadChannel.class);
    ByteBuffer buffer = ByteBuffer.wrap(payload);
    Mockito.when(readChannel.read(Mockito.any()))
        .thenAnswer(
            invocation -> {
              ByteBuffer dst = invocation.getArgument(0);
              if (!buffer.hasRemaining()) {
                return -1;
              }
              int toCopy = Math.min(dst.remaining(), buffer.remaining());
              byte[] chunk = new byte[toCopy];
              buffer.get(chunk);
              dst.put(chunk);
              return toCopy;
            });
    Mockito.when(storage.reader(Mockito.any(BlobId.class), Mockito.any(BlobSourceOption[].class)))
        .thenReturn(readChannel);
    return storage;
  }
}
