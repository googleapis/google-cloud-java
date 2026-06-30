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

import com.google.cloud.storage.BlobInfo;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * An interface for a Transfer Manager.
 *
 * <p>Transfer Manager handles Parallel Uploads and Parallel Downloads.
 */
public interface TransferManager extends AutoCloseable {

  /**
   * Uploads a list of files in parallel. This operation will not block the invoking thread,
   * awaiting results should be done on the returned UploadJob.
   *
   * <p>Accepts a {@link ParallelUploadConfig} which defines the constraints of parallel uploads or
   * predefined defaults.
   *
   * <p>Example of creating a parallel upload with Transfer Manager.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * Path filePath = Paths.get("/path/to/my/file.txt");
   * Path anotherFilePath = Paths.get("/path/to/another/file.txt");
   * List<Path> files = List.of(filePath, anotherFilePath);
   *
   * ParallelUploadConfig parallelUploadConfig =
   *           ParallelUploadConfig.newBuilder()
   *               .setBucketName(bucketName)
   *               .build();
   *
   * UploadJob uploadedFiles = transferManager.uploadFiles(files, config);
   *
   * }</pre>
   *
   * @return an {@link UploadJob}
   */
  @NonNull UploadJob uploadFiles(List<Path> files, ParallelUploadConfig config) throws IOException;

  /**
   * Downloads a list of blobs in parallel. This operation will not block the invoking thread,
   * awaiting results should be done on the returned DownloadJob.
   *
   * <p>Accepts a {@link ParallelDownloadConfig} which defines the constraints of parallel downloads
   * or predefined defaults.
   *
   * <p>Example of creating a parallel download with Transfer Manager.
   *
   * <pre>{@code
   * String bucketName = "my-unique-bucket";
   * String blobName = "my-blob-name";
   * BlobId blobId = BlobId.of(bucketName, blobName);
   * BlobInfo blobInfo = BlobInfo.newBuilder(blobId).setContentType("text/plain").build();
   * Path baseDir = Paths.get("/path/to/directory/");
   *
   * ParallelDownloadConfig parallelDownloadConfig =
   *           ParallelDownloadConfig.newBuilder()
   *               .setBucketName(bucketName)
   *               .setDownloadDirectory(baseDir)
   *               .build();
   *
   * DownloadJob downloadedBlobs = transferManager.downloadBlobs(files, config);
   *
   * }</pre>
   *
   * @return a {@link DownloadJob}
   */
  @NonNull DownloadJob downloadBlobs(List<BlobInfo> blobs, ParallelDownloadConfig config);
}
