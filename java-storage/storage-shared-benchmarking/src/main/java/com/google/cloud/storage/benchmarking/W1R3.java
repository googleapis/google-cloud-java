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

package com.google.cloud.storage.benchmarking;

import static com.google.cloud.storage.benchmarking.StorageSharedBenchmarkingUtils.generateCloudMonitoringResult;

import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.TmpFile;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

final class W1R3 implements Callable<String> {

  private final Storage storage;
  private final int workers;
  private final String api;
  private final PrintWriter printWriter;
  private final int objectSize;
  private final Path tempDirectory;
  private final String bucketName;
  private final boolean isWarmup;

  W1R3(
      Storage storage,
      int workers,
      String api,
      PrintWriter printWriter,
      int objectSize,
      Path tempDirectory,
      String bucketName,
      boolean isWarmup) {
    this.storage = storage;
    this.workers = workers;
    this.api = api;
    this.printWriter = printWriter;
    this.objectSize = objectSize;
    this.tempDirectory = tempDirectory;
    this.bucketName = bucketName;
    this.isWarmup = isWarmup;
  }

  @Override
  public String call() {
    // Create the file to be uploaded and fill it with data

    try (TmpFile file = DataGenerator.base64Characters().tempFile(tempDirectory, objectSize)) {
      BlobInfo blob = BlobInfo.newBuilder(bucketName, file.toString()).build();
      // Get the start time
      Clock clock = Clock.systemDefaultZone();
      Instant startTime = clock.instant();
      Blob created = storage.createFrom(blob, file.getPath());
      Instant endTime = clock.instant();
      Duration elapsedTimeUpload = Duration.between(startTime, endTime);
      printResult("WRITE", created, elapsedTimeUpload);
      for (int i = 0; i <= StorageSharedBenchmarkingUtils.DEFAULT_NUMBER_OF_READS; i++) {
        try (TmpFile dest = TmpFile.of(tempDirectory, "prefix", "bin")) {
          startTime = clock.instant();
          storage.downloadTo(created.getBlobId(), dest.getPath());
          endTime = clock.instant();
          Duration elapsedTimeDownload = Duration.between(startTime, endTime);
          printResult("READ[" + i + "]", created, elapsedTimeDownload);
        }
      }
      StorageSharedBenchmarkingUtils.cleanupObject(storage, created.asBlobInfo());
    } catch (Exception e) {
      CloudMonitoringResult result =
          CloudMonitoringResult.newBuilder()
              .setLibrary("java")
              .setApi(api)
              .setOp("W1R3")
              .setWorkers(workers)
              .setObjectSize(-1)
              .setChunksize(-1)
              .setCrc32cEnabled(false)
              .setMd5Enabled(false)
              .setCpuTimeUs(-1)
              .setBucketName("")
              .setStatus("FAIL")
              .setTransferSize("")
              .setLatency(0)
              .build();
      printWriter.println(result.formatAsCustomMetric());
    }
    return "OK";
  }

  private void printResult(String op, Blob created, Duration duration) {
    if (!isWarmup) {
      printWriter.println(
          generateCloudMonitoringResult(op, duration.toMillis(), created.asBlobInfo(), api, workers)
              .formatAsCustomMetric());
    }
  }
}
