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

import com.google.cloud.WriteChannel;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.PartNamingStrategy;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobSourceOption;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.TestUtils;
import com.google.cloud.storage.TmpFile;
import com.google.cloud.storage.TransportCompatibility.Transport;
import com.google.cloud.storage.it.runner.StorageITRunner;
import com.google.cloud.storage.it.runner.annotations.Backend;
import com.google.cloud.storage.it.runner.annotations.CrossRun;
import com.google.cloud.storage.it.runner.annotations.Inject;
import com.google.cloud.storage.it.runner.registry.Generator;
import com.google.cloud.storage.transfermanager.BucketNameMismatchException;
import com.google.cloud.storage.transfermanager.DownloadJob;
import com.google.cloud.storage.transfermanager.DownloadResult;
import com.google.cloud.storage.transfermanager.ParallelDownloadConfig;
import com.google.cloud.storage.transfermanager.ParallelUploadConfig;
import com.google.cloud.storage.transfermanager.PathTraversalBlockedException;
import com.google.cloud.storage.transfermanager.TransferManager;
import com.google.cloud.storage.transfermanager.TransferManagerConfig;
import com.google.cloud.storage.transfermanager.TransferManagerConfigTestingInstances;
import com.google.cloud.storage.transfermanager.TransferStatus;
import com.google.cloud.storage.transfermanager.UploadJob;
import com.google.cloud.storage.transfermanager.UploadResult;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;
import org.junit.runner.RunWith;

@RunWith(StorageITRunner.class)
@CrossRun(
    transports = {Transport.HTTP},
    backends = {Backend.PROD})
public class ITTransferManagerTest {

  private static final Comparator<BlobInfo> comp =
      Comparator.comparing(info -> info.getBlobId().getName());
  private static final Comparator<DownloadResult> comp2 =
      Comparator.comparing(DownloadResult::getInput, comp);

  private static final long CHUNK_THRESHOLD = 2L * 1024 * 1024;

  @Inject public Storage storage;
  @Inject public BucketInfo bucket;
  @Inject public Generator generator;

  @Rule public final TemporaryFolder tmpDir = new TemporaryFolder();

  private Path baseDir;
  private static final int objectContentSize = 64;
  private List<BlobInfo> blobs = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    baseDir = tmpDir.getRoot().toPath();
    BlobInfo blobInfo1 =
        BlobInfo.newBuilder(
                BlobId.of(
                    bucket.getName(),
                    String.format(Locale.US, "%s/src", generator.randomObjectName())))
            .build();
    BlobInfo blobInfo2 =
        BlobInfo.newBuilder(
                BlobId.of(
                    bucket.getName(),
                    String.format(Locale.US, "%s/src", generator.randomObjectName())))
            .build();
    BlobInfo blobInfoChunking =
        BlobInfo.newBuilder(
                BlobId.of(
                    bucket.getName(),
                    String.format(Locale.US, "%s/src", generator.randomObjectName())))
            .build();
    Collections.addAll(blobs, blobInfo1, blobInfo2);
    ByteBuffer content = DataGenerator.base64Characters().genByteBuffer(108);
    for (BlobInfo blob : blobs) {
      try (WriteChannel writeChannel = storage.writer(blob)) {
        writeChannel.write(content);
      }
    }
    // We make this size just a bit bigger than the threshold.
    long size = CHUNK_THRESHOLD + 100L;
    ByteBuffer chunkedContent = DataGenerator.base64Characters().genByteBuffer(size);
    try (WriteChannel writeChannel = storage.writer(blobInfoChunking)) {
      writeChannel.write(chunkedContent);
    }
    blobs.add(blobInfoChunking);
  }

  @Test
  public void uploadFiles() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile1 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile2 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      List<Path> files =
          ImmutableList.of(tmpFile.getPath(), tmpFile1.getPath(), tmpFile2.getPath());
      String bucketName = bucket.getName();
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucketName).build();
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults).hasSize(3);
      assertThat(
              uploadResults.stream()
                  .filter(result -> result.getStatus() == TransferStatus.SUCCESS)
                  .collect(Collectors.toList()))
          .hasSize(3);
    }
  }

  @Test
  public void uploadFilesPartNaming() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowParallelCompositeUpload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .setParallelCompositeUploadPartNamingStrategy(PartNamingStrategy.prefix("not-root"))
            .build();
    long size = CHUNK_THRESHOLD + 100L;
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, size)) {
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucket.getName()).build();
      UploadJob job =
          transferManager.uploadFiles(
              Collections.singletonList(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.SUCCESS);
    }
  }

  @Test
  public void uploadFilesWithOpts() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile1 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile2 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      List<Path> files =
          ImmutableList.of(tmpFile.getPath(), tmpFile1.getPath(), tmpFile2.getPath());
      String bucketName = bucket.getName();
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder()
              .setBucketName(bucketName)
              .setWriteOptsPerRequest(Collections.singletonList(BlobWriteOption.doesNotExist()))
              .build();
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults).hasSize(3);
      assertThat(
              uploadResults.stream()
                  .filter(result -> result.getStatus() == TransferStatus.SUCCESS)
                  .collect(Collectors.toList()))
          .hasSize(3);
    }
  }

  @Test
  public void uploadFilesOneFailure() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile1 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize);
        TmpFile tmpFile2 = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      List<Path> files =
          ImmutableList.of(
              tmpFile.getPath(),
              tmpFile1.getPath(),
              tmpFile2.getPath(),
              Paths.get("this-file-does-not-exist.txt"));
      String bucketName = bucket.getName();
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucketName).build();
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults).hasSize(4);
      assertThat(
              uploadResults.stream()
                  .filter(x -> x.getStatus() == TransferStatus.FAILED_TO_FINISH)
                  .collect(Collectors.toList()))
          .hasSize(1);
      assertThat(
              uploadResults.stream()
                  .filter(result -> result.getStatus() == TransferStatus.SUCCESS)
                  .collect(Collectors.toList()))
          .hasSize(3);
    }
  }

  @Test
  public void uploadNonexistentBucket() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder().build();
    String bucketName = bucket.getName() + "-does-not-exist";
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      List<Path> files = ImmutableList.of(tmpFile.getPath());
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucketName).build();
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.FAILED_TO_FINISH);
      assertThat(uploadResults.get(0).getException()).isInstanceOf(StorageException.class);
    }
  }

  @Test
  public void uploadNonexistentFile() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder().build();
    String bucketName = bucket.getName();
    try (TransferManager transferManager = config.getService()) {
      List<Path> files = ImmutableList.of(Paths.get("this-file-does-not-exist.txt"));
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucketName).build();
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.FAILED_TO_FINISH);
      assertThat(uploadResults.get(0).getException()).isInstanceOf(NoSuchFileException.class);
    }
  }

  @Test
  public void uploadFailsSkipIfExists() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder().build();
    String bucketName = bucket.getName();
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucketName).setSkipIfExists(true).build();
      UploadJob jobInitUpload =
          transferManager.uploadFiles(ImmutableList.of(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> uploadResults = jobInitUpload.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.SUCCESS);
      UploadJob failedSecondUpload =
          transferManager.uploadFiles(ImmutableList.of(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> failedResult = failedSecondUpload.getUploadResults();
      assertThat(failedResult.get(0).getStatus()).isEqualTo(TransferStatus.SKIPPED);
    }
  }

  @Test
  public void uploadSkipIfExistsGenerationOverride() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder().build();
    String bucketName = bucket.getName();
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, objectContentSize)) {
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder()
              .setBucketName(bucketName)
              .setSkipIfExists(true)
              .setWriteOptsPerRequest(ImmutableList.of(BlobWriteOption.generationMatch(5L)))
              .build();
      assertThat(parallelUploadConfig.getWriteOptsPerRequest()).hasSize(1);
      UploadJob jobInitUpload =
          transferManager.uploadFiles(ImmutableList.of(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> uploadResults = jobInitUpload.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.SUCCESS);
      UploadJob failedSecondUpload =
          transferManager.uploadFiles(ImmutableList.of(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> failedResult = failedSecondUpload.getUploadResults();
      assertThat(failedResult.get(0).getStatus()).isEqualTo(TransferStatus.SKIPPED);
    }
  }

  @Test
  public void downloadBlobs() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName();
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      try {
        assertThat(downloadResults).hasSize(3);
      } finally {
        cleanUpFiles(downloadResults);
      }
    }
  }

  @Test
  public void downloadBlobsAllowChunked() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowDivideAndConquerDownload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .build();
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName();
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      assertThat(downloadResults).hasSize(3);

      List<String> expectedContents =
          blobs.stream()
              .sorted(comp)
              .map(BlobInfo::getBlobId)
              .map(storage::readAllBytes)
              .map(TestUtils::xxd)
              .collect(Collectors.toList());

      List<String> actualContents =
          downloadResults.stream()
              .sorted(comp2)
              .map(DownloadResult::getOutputDestination)
              .map(ITTransferManagerTest::readAllPathBytes)
              .map(TestUtils::xxd)
              .collect(Collectors.toList());

      try {
        assertThat(actualContents).isEqualTo(expectedContents);
      } finally {
        cleanUpFiles(downloadResults);
      }
    }
  }

  @Test
  public void uploadFilesAllowPCU() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowParallelCompositeUpload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .build();
    long size = CHUNK_THRESHOLD + 100L;
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, size)) {
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucket.getName()).build();
      UploadJob job =
          transferManager.uploadFiles(
              Collections.singletonList(tmpFile.getPath()), parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults.get(0).getStatus()).isEqualTo(TransferStatus.SUCCESS);
    }
  }

  @Test
  public void uploadFilesAllowMultiplePCUAndSmallerFiles() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowParallelCompositeUpload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .build();
    long largeFileSize = CHUNK_THRESHOLD + 100L;
    long smallFileSize = CHUNK_THRESHOLD - 100L;
    try (TransferManager transferManager = config.getService();
        TmpFile tmpFile = DataGenerator.base64Characters().tempFile(baseDir, largeFileSize);
        TmpFile tmpfile2 = DataGenerator.base64Characters().tempFile(baseDir, largeFileSize);
        TmpFile tmpFile3 = DataGenerator.base64Characters().tempFile(baseDir, smallFileSize)) {
      ParallelUploadConfig parallelUploadConfig =
          ParallelUploadConfig.newBuilder().setBucketName(bucket.getName()).build();
      List<Path> files =
          ImmutableList.of(tmpFile.getPath(), tmpfile2.getPath(), tmpFile3.getPath());
      UploadJob job = transferManager.uploadFiles(files, parallelUploadConfig);
      List<UploadResult> uploadResults = job.getUploadResults();
      assertThat(uploadResults).hasSize(3);
      assertThat(
              uploadResults.stream()
                  .filter(result -> result.getStatus() == TransferStatus.SUCCESS)
                  .collect(Collectors.toList()))
          .hasSize(3);
    }
  }

  @Test
  public void downloadNonexistentBucket() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName() + "-does-not-exist";
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      List<DownloadResult> failedToStart =
          downloadResults.stream()
              .filter(x -> x.getStatus() == TransferStatus.FAILED_TO_START)
              .collect(Collectors.toList());
      assertThat(failedToStart).hasSize(3);
    }
  }

  @Test
  public void downloadBlobsChunkedFail() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowDivideAndConquerDownload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .build();
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName() + "-does-not-exist";
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      assertThat(downloadResults).hasSize(3);
      List<DownloadResult> failedToStart =
          downloadResults.stream()
              .filter(x -> x.getStatus() == TransferStatus.FAILED_TO_START)
              .collect(Collectors.toList());
      assertThat(failedToStart).hasSize(3);
    }
  }

  @Test
  public void downloadBlobsPreconditionFailure() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions()).toBuilder()
            .setAllowDivideAndConquerDownload(true)
            .setPerWorkerBufferSize(128 * 1024)
            .build();
    try (TransferManager transferManager = config.getService()) {
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucket.getName())
              .setDownloadDirectory(baseDir)
              .setOptionsPerRequest(ImmutableList.of(BlobSourceOption.generationMatch(-1)))
              .build();
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      assertThat(downloadResults).hasSize(3);
      List<DownloadResult> failedToStart =
          downloadResults.stream()
              .filter(x -> x.getStatus() == TransferStatus.FAILED_TO_START)
              .collect(Collectors.toList());
      assertThat(failedToStart).hasSize(3);
    }
  }

  @Test
  public void downloadBlobsOneFailure() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName();
      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();
      List<BlobInfo> downloadBlobs = blobs;
      BlobInfo nonexistentBlob =
          BlobInfo.newBuilder(
                  BlobId.of(
                      bucket.getName(),
                      String.format(Locale.US, "%s/src", generator.randomObjectName())))
              .build();
      downloadBlobs.add(nonexistentBlob);
      DownloadJob job = transferManager.downloadBlobs(blobs, parallelDownloadConfig);
      List<DownloadResult> downloadResults = job.getDownloadResults();
      try {
        assertThat(downloadResults).hasSize(4);
        assertThat(
                downloadResults.stream()
                    .filter(res -> res.getStatus() == TransferStatus.FAILED_TO_START)
                    .collect(Collectors.toList()))
            .hasSize(1);
      } finally {
        cleanUpFiles(
            downloadResults.stream()
                .filter(res -> res.getStatus() == TransferStatus.SUCCESS)
                .collect(Collectors.toList()));
      }
    }
  }

  @Test
  public void uploadChangePrefix() throws Exception {
    try (TmpFile tmpFile1 = DataGenerator.base64Characters().tempFile(baseDir, 373);
        TmpFile tmpFile2 =
            DataGenerator.base64Characters().tempFile(baseDir, 2 * 1024 * 1024 + 13);
        TransferManager tm =
            TransferManagerConfig.newBuilder()
                .setMaxWorkers(1)
                .setPerWorkerBufferSize(4 * 1024 * 1024)
                .setAllowDivideAndConquerDownload(false)
                .setAllowParallelCompositeUpload(false)
                .setStorageOptions(storage.getOptions())
                .build()
                .getService()) {

      String prefix = "asdfasdf";
      ImmutableMap<@NonNull String, @Nullable String> metadata = ImmutableMap.of("k", "v");
      String contentType = "text/plain;charset=utf-8";
      ParallelUploadConfig uploadConfig =
          ParallelUploadConfig.newBuilder()
              .setBucketName(bucket.getName())
              .setSkipIfExists(false)
              .setUploadBlobInfoFactory(
                  (b, f) ->
                      BlobInfo.newBuilder(
                              b, prefix + f.replace(baseDir.toAbsolutePath().toString(), ""))
                          .setContentType(contentType)
                          .setMetadata(metadata)
                          .build())
              .setWriteOptsPerRequest(ImmutableList.of(BlobWriteOption.doesNotExist()))
              .build();

      ImmutableList<Path> files = ImmutableList.of(tmpFile1.getPath(), tmpFile2.getPath());
      UploadJob uploadJob = tm.uploadFiles(files, uploadConfig);
      List<UploadResult> uploadResults = uploadJob.getUploadResults();

      List<String> expected =
          files.stream()
              .map(p -> p.getFileName().toString())
              .map(s -> prefix + "/" + s)
              .collect(Collectors.toList());

      List<String> actualGsUtilUris =
          uploadResults.stream()
              .map(UploadResult::getUploadedBlob)
              .map(BlobInfo::getName)
              .collect(Collectors.toList());
      assertThat(actualGsUtilUris).containsExactlyElementsIn(expected);

      List<Map<@NonNull String, @Nullable String>> actualMetadatas =
          uploadResults.stream()
              .map(UploadResult::getUploadedBlob)
              .map(BlobInfo::getMetadata)
              .collect(Collectors.toList());

      assertThat(actualMetadatas).isEqualTo(ImmutableList.of(metadata, metadata));

      List<String> actualContentTypes =
          uploadResults.stream()
              .map(UploadResult::getUploadedBlob)
              .map(BlobInfo::getContentType)
              .collect(Collectors.toList());

      assertThat(actualContentTypes).isEqualTo(ImmutableList.of(contentType, contentType));
    }
  }

  @Test
  public void bucketNameFromUploadBlobInfoFactoryMustMatchConfig() throws Exception {
    try (TmpFile tmpFile1 = DataGenerator.base64Characters().tempFile(baseDir, 373);
        TransferManager tm =
            TransferManagerConfig.newBuilder()
                .setMaxWorkers(1)
                .setPerWorkerBufferSize(4 * 1024 * 1024)
                .setAllowDivideAndConquerDownload(false)
                .setAllowParallelCompositeUpload(false)
                .setStorageOptions(storage.getOptions())
                .build()
                .getService()) {

      ParallelUploadConfig uploadConfig =
          ParallelUploadConfig.newBuilder()
              .setBucketName(bucket.getName())
              .setSkipIfExists(false)
              .setUploadBlobInfoFactory((b, f) -> BlobInfo.newBuilder(b + "x", f).build())
              .setWriteOptsPerRequest(ImmutableList.of(BlobWriteOption.doesNotExist()))
              .build();

      ImmutableList<Path> files = ImmutableList.of(tmpFile1.getPath());
      UploadJob uploadJob = tm.uploadFiles(files, uploadConfig);
      List<UploadResult> uploadResults = uploadJob.getUploadResults();

      Optional<UploadResult> failedToStart =
          uploadResults.stream()
              .filter(r -> r.getStatus() == TransferStatus.FAILED_TO_START)
              .findAny();
      assertThat(failedToStart).isPresent();
      UploadResult result = failedToStart.get();
      assertThat(result.getException()).isInstanceOf(BucketNameMismatchException.class);
    }
  }

  @Test
  public void downloadBlobsPathTraversalBlocked() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName();
      // Create an object with a name that attempts to "escape" the target directory
      String maliciousName = "../malicious.txt";
      BlobInfo maliciousBlob = BlobInfo.newBuilder(BlobId.of(bucketName, maliciousName)).build();
      storage.create(
          maliciousBlob, "malicious content".getBytes(java.nio.charset.StandardCharsets.UTF_8));

      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir) // baseDir is the target
              .build();

      List<BlobInfo> blobsToDownload = new ArrayList<>(blobs);
      blobsToDownload.add(maliciousBlob);

      DownloadJob job = transferManager.downloadBlobs(blobsToDownload, parallelDownloadConfig);
      List<DownloadResult> results = job.getDownloadResults();

      try {
        long successCount =
            results.stream().filter(res -> res.getStatus() == TransferStatus.SUCCESS).count();
        assertThat(successCount).isEqualTo(blobs.size());

        // Verify that the malicious blob was blocked/skipped
        Optional<DownloadResult> blockedResult =
            results.stream()
                .filter(res -> res.getInput().getName().equals(maliciousName))
                .findFirst();

        assertThat(blockedResult).isPresent();
        assertThat(blockedResult.get().getStatus()).isEqualTo(TransferStatus.FAILED_TO_START);
        assertThat(blockedResult.get().getException())
            .isInstanceOf(PathTraversalBlockedException.class);
        assertThat(blockedResult.get().getException().getMessage()).contains("blocked");
      } finally {
        storage.delete(maliciousBlob.getBlobId());
        cleanUpFiles(
            results.stream()
                .filter(res -> res.getStatus() == TransferStatus.SUCCESS)
                .collect(Collectors.toList()));
      }
    }
  }

  @Test
  public void downloadBlobsPathTraversalAllowedWithinTarget() throws Exception {
    TransferManagerConfig config =
        TransferManagerConfigTestingInstances.defaults(storage.getOptions());
    try (TransferManager transferManager = config.getService()) {
      String bucketName = bucket.getName();
      // This name resolves to 'safe.txt' inside the target directory
      String safeNameWithDots = "subdir/../safe.txt";
      BlobInfo safeBlob = BlobInfo.newBuilder(BlobId.of(bucketName, safeNameWithDots)).build();
      storage.create(safeBlob, "safe content".getBytes(java.nio.charset.StandardCharsets.UTF_8));

      ParallelDownloadConfig parallelDownloadConfig =
          ParallelDownloadConfig.newBuilder()
              .setBucketName(bucketName)
              .setDownloadDirectory(baseDir)
              .build();

      DownloadJob job =
          transferManager.downloadBlobs(
              Collections.singletonList(safeBlob), parallelDownloadConfig);
      List<DownloadResult> results = job.getDownloadResults();

      try {
        assertThat(results.get(0).getStatus()).isEqualTo(TransferStatus.SUCCESS);
        // Verify it was saved to the correct normalized location
        Path expectedPath = baseDir.resolve("safe.txt").toAbsolutePath().normalize();
        assertThat(results.get(0).getOutputDestination().toAbsolutePath().normalize())
            .isEqualTo(expectedPath);
      } finally {
        cleanUpFiles(results);
        storage.delete(safeBlob.getBlobId());
      }
    }
  }

  private void cleanUpFiles(List<DownloadResult> results) throws IOException {
    // Cleanup downloaded blobs and the parent directory
    for (DownloadResult res : results) {
      Files.delete(res.getOutputDestination());
      Files.delete(res.getOutputDestination().getParent());
    }
  }

  private static byte[] readAllPathBytes(Path path) {
    try {
      return Files.readAllBytes(path);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
