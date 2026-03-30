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

import com.google.api.core.ApiFuture;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "ssb")
public final class StorageSharedBenchmarkingCli implements Runnable {
  // TODO: check what input validation is needed for option values.
  @Option(names = "-project", description = "GCP Project Identifier", required = true)
  String project;

  @Option(names = "-bucket", description = "Name of the bucket to use", required = true)
  String bucket;

  @Option(names = "-samples", defaultValue = "8000", description = "Number of samples to report")
  int samples;

  @Option(
      names = "-workers",
      defaultValue = "16",
      description = "Number of workers to run in parallel for the workload")
  int workers;

  @Option(names = "-api", description = "API to use", required = true)
  String api;

  @Option(
      names = "-object_size",
      defaultValue = "1048576..1048576",
      description =
          "any positive integer, or an inclusive range such as min..max where min and max are"
              + " positive integers")
  String objectSize;

  @Option(
      names = "-output_type",
      defaultValue = "cloud-monitoring",
      description = "Output results format")
  String outputType;

  @Option(
      names = "-test_type",
      description = "Specify which workload the cli should run",
      required = true)
  String testType;

  @Option(
      names = "-temp_dir_location",
      description = "Specify the path where the temporary directory should be located")
  String tempDirLocation;

  @Option(
      names = "-warmup",
      description = "Number of seconds a W1R3 warmup will run on all available processors",
      defaultValue = "0")
  int warmup;

  @Option(names = "-bidi_enabled", description = "If bidi should be enabled")
  boolean bidiEnabled;

  Path tempDir;

  PrintWriter printWriter;

  public static void main(String[] args) {
    CommandLine cmd = new CommandLine(StorageSharedBenchmarkingCli.class);
    System.exit(cmd.execute(args));
  }

  @Override
  public void run() {
    tempDir =
        tempDirLocation != null
            ? Paths.get(tempDirLocation)
            : Paths.get(System.getProperty("java.io.tmpdir"));
    printWriter = new PrintWriter(System.out, true);
    switch (testType) {
      case "w1r3":
        runWorkload1();
        break;
      case "write-only":
        runWorkloadWriteOnly();
        break;
      default:
        throw new IllegalStateException("Specify a workload to run");
    }
  }

  private void runWorkload1() {
    switch (api) {
      case "JSON":
        runWorkload1Json();
        break;
      case "DirectPath":
        runWorkload1DirectPath();
        break;
      default:
        throw new IllegalStateException("Specify an API to use");
    }
  }

  private void runWorkload1Json() {
    RetrySettings retrySettings = StorageOptions.getNoRetrySettings().toBuilder().build();

    StorageOptions retryStorageOptions =
        StorageOptions.newBuilder().setProjectId(project).setRetrySettings(retrySettings).build();
    Storage storageClient = retryStorageOptions.getService();
    try {
      runW1R3(storageClient);
    } catch (Exception e) {
      System.err.println("Failed to run workload 1: " + e.getMessage());
      System.exit(1);
    }
  }

  private void runWorkload1DirectPath() {
    RetrySettings retrySettings = StorageOptions.getNoRetrySettings().toBuilder().build();
    StorageOptions retryStorageOptions =
        StorageOptions.grpc().setRetrySettings(retrySettings).setAttemptDirectPath(true).build();
    Storage storageClient = retryStorageOptions.getService();
    try {
      runW1R3(storageClient);
    } catch (Exception e) {
      System.err.println("Failed to run workload 4: " + e.getMessage());
      System.exit(1);
    }
  }

  private void runWorkloadWriteOnly() {
    try {
      if (bidiEnabled) {
        StorageOptions options =
            StorageOptions.grpc()
                .setProjectId(project)
                .setBlobWriteSessionConfig(BlobWriteSessionConfigs.bidiWrite())
                .build();
        Storage storageClient = options.getService();
        runBidi(storageClient);
      } else {
        StorageOptions options =
            StorageOptions.grpc()
                .setProjectId(project)
                .setBlobWriteSessionConfig(BlobWriteSessionConfigs.getDefault())
                .build();
        Storage storageClient = options.getService();
        runBidi(storageClient);
      }
    } catch (Exception e) {
      System.err.println("Failed to run workload bidi" + e.getMessage());
      System.exit(1);
    }
  }

  private void runW1R3(Storage storageClient) throws ExecutionException, InterruptedException {
    ListeningExecutorService executorService =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(workers));
    runWarmup(storageClient);
    for (int i = 0; i < samples; i++) {
      Range objectSizeRange = Range.of(objectSize);
      int objectSize = getRandomInt(objectSizeRange.min, objectSizeRange.max);
      convert(
              executorService.submit(
                  new W1R3(
                      storageClient,
                      workers,
                      api,
                      printWriter,
                      objectSize,
                      tempDir,
                      bucket,
                      false)))
          .get();
    }
  }

  private void runBidi(Storage storageClient) throws ExecutionException, InterruptedException {
    ListeningExecutorService executorService =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(workers));
    for (int i = 0; i < samples; i++) {
      Range objectSizeRange = Range.of(objectSize);
      int objectSize = getRandomInt(objectSizeRange.min, objectSizeRange.max);
      convert(
              executorService.submit(
                  new Bidi(storageClient, bucket, objectSize, printWriter, api, workers)))
          .get();
    }
  }

  private void runWarmup(Storage storageClient) throws ExecutionException, InterruptedException {
    if (warmup <= 0) {
      return;
    }
    int numberProcessors = Runtime.getRuntime().availableProcessors();
    ListeningExecutorService executorService =
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(numberProcessors));
    long startTime = System.currentTimeMillis();
    long endTime = startTime + (warmup * 1000);
    // Run Warmup
    while (System.currentTimeMillis() < endTime) {
      Range objectSizeRange = Range.of(objectSize);
      int objectSize = getRandomInt(objectSizeRange.min, objectSizeRange.max);
      convert(
              executorService.submit(
                  new W1R3(
                      storageClient, workers, api, printWriter, objectSize, tempDir, bucket, true)))
          .get();
    }
  }

  public static int getRandomInt(int min, int max) {
    if (min == max) return min;
    Random random = new Random();
    return random.nextInt((max - min) + 1) + min;
  }

  private static <T> ApiFuture<T> convert(ListenableFuture<T> lf) {
    return new ListenableFutureToApiFuture<>(lf);
  }

  private static final class Range {
    private final int min;
    private final int max;

    private Range(int min, int max) {
      this.min = min;
      this.max = max;
    }

    public static Range of(int min, int max) {
      return new Range(min, max);
    }

    // Takes an object size range of format min..max and creates a range object
    public static Range of(String range) {
      Pattern p = Pattern.compile("\\.\\.");
      String[] splitRangeVals = p.split(range);
      if (splitRangeVals.length == 2) {
        String min = splitRangeVals[0];
        String max = splitRangeVals[1];
        return of(Integer.parseInt(min), Integer.parseInt(max));
      }
      throw new IllegalStateException("Expected a size range of format min..max, but got " + range);
    }
  }
}
