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
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.StorageException;
import com.google.common.io.ByteStreams;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Callable;

final class ChunkedDownloadCallable implements Callable<DownloadSegment> {

  private final BlobInfo originalBlob;

  private final Storage storage;

  private final Storage.BlobSourceOption[] opts;

  private final long startPosition;

  private final long endPosition;
  private final Path destPath;

  ChunkedDownloadCallable(
      Storage storage,
      BlobInfo originalBlob,
      BlobSourceOption[] opts,
      Path destPath,
      long startPosition,
      long endPosition) {
    this.originalBlob = originalBlob;
    this.storage = storage;
    this.opts = opts;
    this.startPosition = startPosition;
    this.endPosition = endPosition;
    this.destPath = destPath;
  }

  @Override
  public DownloadSegment call() {
    long bytesCopied = -1L;
    try (ReadChannel rc = storage.reader(originalBlob.getBlobId(), opts);
        FileChannel wc =
            FileChannel.open(destPath, StandardOpenOption.WRITE, StandardOpenOption.CREATE)) {
      rc.setChunkSize(0);
      rc.seek(startPosition);
      rc.limit(endPosition);
      wc.position(startPosition);
      bytesCopied = ByteStreams.copy(rc, wc);
      long bytesExpected = endPosition - startPosition;
      if (bytesCopied != bytesExpected) {
        return DownloadSegment.newBuilder(originalBlob, TransferStatus.FAILED_TO_FINISH)
            .setException(
                new StorageException(
                    0,
                    "Unexpected end of stream, read "
                        + bytesCopied
                        + " expected "
                        + bytesExpected
                        + " from object "
                        + originalBlob.getBlobId().toGsUtilUriWithGeneration()))
            .build();
      }
    } catch (Exception e) {
      if (bytesCopied == -1) {
        return DownloadSegment.newBuilder(originalBlob, TransferStatus.FAILED_TO_START)
            .setException(e)
            .build();
      }
      return DownloadSegment.newBuilder(originalBlob, TransferStatus.FAILED_TO_FINISH)
          .setException(e)
          .build();
    }
    DownloadSegment result =
        DownloadSegment.newBuilder(originalBlob, TransferStatus.SUCCESS)
            .setOutputDestination(destPath)
            .build();
    return result;
  }
}
