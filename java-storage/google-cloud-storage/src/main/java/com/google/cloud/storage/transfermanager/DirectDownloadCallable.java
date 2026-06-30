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

package com.google.cloud.storage.transfermanager;

import com.google.cloud.ReadChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.StorageException;
import com.google.common.io.ByteStreams;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Callable;

final class DirectDownloadCallable implements Callable<DownloadResult> {
  private final BlobInfo originalBlob;

  private final ParallelDownloadConfig parallelDownloadConfig;
  private final Storage storage;

  private final Storage.BlobSourceOption[] opts;

  private final Path destPath;

  DirectDownloadCallable(
      Storage storage,
      BlobInfo originalBlob,
      ParallelDownloadConfig parallelDownloadConfig,
      BlobSourceOption[] opts,
      Path destPath) {
    this.originalBlob = originalBlob;
    this.parallelDownloadConfig = parallelDownloadConfig;
    this.storage = storage;
    this.opts = opts;
    this.destPath = destPath;
  }

  @Override
  public DownloadResult call() {
    long bytesCopied = -1L;
    try (ReadChannel rc =
            storage.reader(
                BlobId.of(parallelDownloadConfig.getBucketName(), originalBlob.getName()), opts);
        FileChannel wc =
            FileChannel.open(
                destPath,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
      rc.setChunkSize(0);
      bytesCopied = ByteStreams.copy(rc, wc);
      if (originalBlob.getSize() != null) {
        if (bytesCopied != originalBlob.getSize()) {
          return DownloadResult.newBuilder(originalBlob, TransferStatus.FAILED_TO_FINISH)
              .setException(
                  new StorageException(
                      0,
                      "Unexpected end of stream, read "
                          + bytesCopied
                          + " expected "
                          + originalBlob.getSize()
                          + " from object "
                          + originalBlob.getBlobId().toGsUtilUriWithGeneration()))
              .build();
        }
      }
    } catch (Exception e) {
      if (bytesCopied == -1) {
        return DownloadResult.newBuilder(originalBlob, TransferStatus.FAILED_TO_START)
            .setException(e)
            .build();
      }
      return DownloadResult.newBuilder(originalBlob, TransferStatus.FAILED_TO_FINISH)
          .setException(e)
          .build();
    }
    DownloadResult result =
        DownloadResult.newBuilder(originalBlob, TransferStatus.SUCCESS)
            .setOutputDestination(destPath)
            .build();
    return result;
  }
}
