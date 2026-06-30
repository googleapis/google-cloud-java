/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.storage.benchmarking;

import static com.google.cloud.storage.benchmarking.StorageSharedBenchmarkingUtils.generateCloudMonitoringResult;

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSession;
import com.google.cloud.storage.DataGenerator;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import java.io.PrintWriter;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.time.Clock;
import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.Callable;

class Bidi implements Callable<String> {
  private final Storage storageClient;
  private final String bucketName;
  private final int objectSize;
  private final PrintWriter pw;
  private final String api;
  private final int workers;

  Bidi(
      Storage storageClient,
      String bucketName,
      int objectSize,
      PrintWriter pw,
      String api,
      int workers) {
    this.storageClient = storageClient;
    this.bucketName = bucketName;
    this.objectSize = objectSize;
    this.pw = pw;
    this.api = api;
    this.workers = workers;
  }

  @Override
  public String call() throws Exception {
    String blobName = DataGenerator.base64Characters().genBytes(20).toString();
    BlobWriteSession sess =
        storageClient.blobWriteSession(
            BlobInfo.newBuilder(bucketName, blobName).build(), BlobWriteOption.doesNotExist());
    byte[] bytes = DataGenerator.base64Characters().genBytes(objectSize);
    Clock clock = Clock.systemDefaultZone();
    Instant startTime = clock.instant();
    try (WritableByteChannel w = sess.open()) {
      w.write(ByteBuffer.wrap(bytes));
    }
    BlobInfo created = sess.getResult().get();
    Instant endTime = clock.instant();
    Duration elapsedTimeWrite = Duration.between(startTime, endTime);
    printResult("BIDI", created, elapsedTimeWrite);
    StorageSharedBenchmarkingUtils.cleanupObject(storageClient, created);
    return "OK";
  }

  private void printResult(String op, BlobInfo created, Duration duration) {
    pw.println(
        generateCloudMonitoringResult(op, duration.toMillis(), created, api, workers)
            .formatAsCustomMetric());
  }
}
