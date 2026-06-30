/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 */

package com.example.storage.transfermanager;

import static com.example.storage.Env.GOOGLE_CLOUD_PROJECT;
import static com.google.cloud.storage.TestUtils.assertAll;
import static com.google.common.truth.Truth.assertThat;

import com.example.storage.TestBase;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BucketInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage.BlobTargetOption;
import com.google.cloud.storage.TmpFile;
import com.google.cloud.storage.it.TemporaryBucket;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

public class ITTransferManagerSamples extends TestBase {

  @Rule public final TemporaryFolder downloadDirectory = new TemporaryFolder();
  @Rule public final TemporaryFolder uploadDirectory = new TemporaryFolder();

  @Test
  public void uploadFiles() throws Exception {
    Path baseDir = uploadDirectory.getRoot().toPath();
    try (TmpFile file1 = DataGenerator.base64Characters().tempFile(baseDir, 13);
        TmpFile file2 = DataGenerator.base64Characters().tempFile(baseDir, 17);
        TmpFile file3 = DataGenerator.base64Characters().tempFile(baseDir, 19)) {
      List<Path> files =
          Stream.of(file1, file2, file3)
              .map(TmpFile::getPath)
              .collect(ImmutableList.toImmutableList());
      UploadMany.uploadManyFiles(bucket.getName(), files);
      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
      assertAll(
          () -> assertThat(snippetOutput).contains(file1.getPath().getFileName().toString()),
          () -> assertThat(snippetOutput).contains(file2.getPath().getFileName().toString()),
          () -> assertThat(snippetOutput).contains(file3.getPath().getFileName().toString()));
    }
  }

  @Test
  public void uploadDirectory() throws Exception {
    Path baseDir = uploadDirectory.getRoot().toPath();
    try (TmpFile file1 = DataGenerator.base64Characters().tempFile(baseDir, 13);
        TmpFile file2 = DataGenerator.base64Characters().tempFile(baseDir, 17);
        TmpFile file3 = DataGenerator.base64Characters().tempFile(baseDir, 19)) {
      UploadDirectory.uploadDirectoryContents(bucket.getName(), baseDir);
      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
      assertAll(
          () -> assertThat(snippetOutput).contains(file1.getPath().getFileName().toString()),
          () -> assertThat(snippetOutput).contains(file2.getPath().getFileName().toString()),
          () -> assertThat(snippetOutput).contains(file3.getPath().getFileName().toString()));
    }
  }

  @Test
  public void downloadBucket() throws Exception {
    try (TemporaryBucket tmpBucket =
        TemporaryBucket.newBuilder()
            .setBucketInfo(BucketInfo.newBuilder(generator.randomBucketName()).build())
            .setStorage(storage)
            .build()) {
      BucketInfo bucket = tmpBucket.getBucket();
      String name1 = generator.randomObjectName();
      String name2 = generator.randomObjectName();
      String name3 = generator.randomObjectName();
      Stream.of(name1, name2, name3)
          .map(name -> BlobInfo.newBuilder(bucket, name).build())
          .forEach(info -> storage.create(info, BlobTargetOption.doesNotExist()));
      DownloadBucket.downloadBucketContents(
          GOOGLE_CLOUD_PROJECT, bucket.getName(), downloadDirectory.getRoot().toPath());
      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
      assertAll(
          () -> assertThat(snippetOutput).contains(name1),
          () -> assertThat(snippetOutput).contains(name2),
          () -> assertThat(snippetOutput).contains(name3));
    }
  }

  @Test
  public void downloadBlobs() throws Exception {
    String name1 = generator.randomObjectName();
    String name2 = generator.randomObjectName();
    String name3 = generator.randomObjectName();
    List<BlobInfo> blobs =
        Stream.of(name1, name2, name3)
            .map(this::info)
            .map(info -> storage.create(info, BlobTargetOption.doesNotExist()))
            .collect(ImmutableList.toImmutableList());
    DownloadMany.downloadManyBlobs(bucket.getName(), blobs, downloadDirectory.getRoot().toPath());
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertAll(
        () -> assertThat(snippetOutput).contains(name1),
        () -> assertThat(snippetOutput).contains(name2),
        () -> assertThat(snippetOutput).contains(name3));
  }

  @Test
  public void uploadAllowPCU() throws IOException {
    Path baseDir = uploadDirectory.getRoot().toPath();
    try (TmpFile file1 = DataGenerator.base64Characters().tempFile(baseDir, 313 * 1024 * 1024)) {
      AllowParallelCompositeUpload.parallelCompositeUploadAllowed(
          bucket.getName(), ImmutableList.of(file1.getPath()));
      String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
      assertThat(snippetOutput).contains(file1.getPath().getFileName().toString());
    }
  }

  @Test
  public void downloadAllowDivideAndConquer() throws Exception {
    String name1 = generator.randomObjectName();
    String name2 = generator.randomObjectName();
    String name3 = generator.randomObjectName();
    List<BlobInfo> blobs =
        Stream.of(name1, name2, name3)
            .map(this::info)
            .map(info -> storage.create(info, BlobTargetOption.doesNotExist()))
            .collect(ImmutableList.toImmutableList());
    AllowDivideAndConquerDownload.divideAndConquerDownloadAllowed(
        blobs, bucket.getName(), downloadDirectory.getRoot().toPath());
    String snippetOutput = stdOut.getCapturedOutputAsUtf8String();
    assertAll(
        () -> assertThat(snippetOutput).contains(name1),
        () -> assertThat(snippetOutput).contains(name2),
        () -> assertThat(snippetOutput).contains(name3));
  }
}
