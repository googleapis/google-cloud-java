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

import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Storage;

class StorageSharedBenchmarkingUtils {
  public static long SSB_SIZE_THRESHOLD_BYTES = 1048576;
  public static int DEFAULT_NUMBER_OF_READS = 3;

  public static void cleanupObject(Storage storage, BlobInfo created) {
    storage.delete(
        created.getBlobId(), Storage.BlobSourceOption.generationMatch(created.getGeneration()));
  }

  public static CloudMonitoringResult generateCloudMonitoringResult(
      String op, double latency, BlobInfo created, String api, int workers) {
    CloudMonitoringResult result =
        CloudMonitoringResult.newBuilder()
            .setLibrary("java")
            .setApi(api)
            .setOp(op)
            .setWorkers(workers)
            .setObjectSize(created.getSize().intValue())
            .setChunksize(created.getSize().intValue())
            .setCrc32cEnabled(false)
            .setMd5Enabled(false)
            .setCpuTimeUs(-1)
            .setBucketName(created.getBucket())
            .setStatus("OK")
            .setTransferSize(created.getSize().toString())
            .setLatency(latency)
            .build();
    return result;
  }
}
