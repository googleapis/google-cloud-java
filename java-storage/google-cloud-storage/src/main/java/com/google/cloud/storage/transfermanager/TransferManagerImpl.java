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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.ListenableFutureToApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.BlobWriteSessionConfigs;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.BufferAllocationStrategy;
import com.google.cloud.storage.ParallelCompositeUploadBlobWriteSessionConfig.ExecutorSupplier;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobWriteOption;
import com.google.cloud.storage.StorageOptions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.BinaryOperator;
import org.checkerframework.checker.nullness.qual.NonNull;

final class TransferManagerImpl implements TransferManager {

  private static final String USER_AGENT_ENTRY = "gcloud-tm/";
  private static final String LIBRARY_VERSION = StorageOptions.version();
  private final TransferManagerConfig transferManagerConfig;
  private final ListeningExecutorService executor;
  private final Qos qos;
  private final Storage storage;

  private final Deque<PendingPcuTask> pcuQueue;
  // define a unique object which we can use to synchronize modification of pcuPoller
  private final Object pcuPollerSync = new Object();
  private volatile ApiFuture<?> pcuPoller;

  TransferManagerImpl(TransferManagerConfig transferManagerConfig, Qos qos) {
    this.transferManagerConfig = transferManagerConfig;
    this.executor =
        MoreExecutors.listeningDecorator(
            Executors.newFixedThreadPool(transferManagerConfig.getMaxWorkers()));
    this.qos = qos;
    StorageOptions storageOptions = transferManagerConfig.getStorageOptions();
    String userAgent = storageOptions.getUserAgent();
    if (userAgent == null || !userAgent.contains(USER_AGENT_ENTRY)) {
      storageOptions =
          storageOptions.toBuilder()
              .setHeaderProvider(
                  FixedHeaderProvider.create(
                      ImmutableMap.of("User-Agent", USER_AGENT_ENTRY + LIBRARY_VERSION)))
              .build();
    }
    // Create the blobWriteSessionConfig for ParallelCompositeUpload
    if (transferManagerConfig.isAllowParallelCompositeUpload()) {
      ParallelCompositeUploadBlobWriteSessionConfig pcuConfig =
          BlobWriteSessionConfigs.parallelCompositeUpload()
              .withExecutorSupplier(ExecutorSupplier.useExecutor(executor))
              .withBufferAllocationStrategy(
                  BufferAllocationStrategy.fixedPool(
                      transferManagerConfig.getMaxWorkers(),
                      transferManagerConfig.getPerWorkerBufferSize()))
              .withPartNamingStrategy(
                  transferManagerConfig.getParallelCompositeUploadPartNamingStrategy());
      storageOptions = storageOptions.toBuilder().setBlobWriteSessionConfig(pcuConfig).build();
    }
    this.pcuQueue = new ConcurrentLinkedDeque<>();
    this.storage = storageOptions.getService();
  }

  @Override
  public void close() throws Exception {
    // We only want to shutdown the executor service not the provided storage instance
    executor.shutdownNow();
    executor.awaitTermination(5, TimeUnit.MINUTES);
  }

  @Override
  public @NonNull UploadJob uploadFiles(List<Path> files, ParallelUploadConfig config)
      throws IOException {
    Storage.BlobWriteOption[] opts =
        config.getWriteOptsPerRequest().toArray(new BlobWriteOption[0]);
    List<ApiFuture<UploadResult>> uploadTasks = new ArrayList<>();
    for (Path file : files) {
      if (Files.isDirectory(file)) throw new IllegalStateException("Directories are not supported");
      String bucketName = config.getBucketName();
      BlobInfo blobInfo =
          config.getUploadBlobInfoFactory().apply(bucketName, file.toAbsolutePath().toString());
      if (!blobInfo.getBucket().equals(bucketName)) {
        uploadTasks.add(
            ApiFutures.immediateFuture(
                UploadResult.newBuilder(blobInfo, TransferStatus.FAILED_TO_START)
                    .setException(new BucketNameMismatchException(blobInfo.getBucket(), bucketName))
                    .build()));
        continue;
      }
      if (transferManagerConfig.isAllowParallelCompositeUpload()
          && qos.parallelCompositeUpload(Files.size(file))) {
        ParallelCompositeUploadCallable callable =
            new ParallelCompositeUploadCallable(storage, blobInfo, file, config, opts);
        SettableApiFuture<UploadResult> resultFuture = SettableApiFuture.create();
        pcuQueue.add(new PendingPcuTask(callable, resultFuture));
        uploadTasks.add(resultFuture);
        schedulePcuPoller();
      } else {
        UploadCallable callable =
            new UploadCallable(transferManagerConfig, storage, blobInfo, file, config, opts);
        uploadTasks.add(convert(executor.submit(callable)));
      }
    }
    return UploadJob.newBuilder()
        .setParallelUploadConfig(config)
        .setUploadResults(ImmutableList.copyOf(uploadTasks))
        .build();
  }

  @Override
  public @NonNull DownloadJob downloadBlobs(List<BlobInfo> blobs, ParallelDownloadConfig config) {
    Storage.BlobSourceOption[] opts =
        config.getOptionsPerRequest().toArray(new Storage.BlobSourceOption[0]);
    List<ApiFuture<DownloadResult>> downloadTasks = new ArrayList<>();
    for (BlobInfo blob : blobs) {
      Path destPath = TransferManagerUtils.createAndValidateDestPath(config, blob);
      if (destPath == null) {
        DownloadResult skipped =
            DownloadResult.newBuilder(blob, TransferStatus.FAILED_TO_START)
                .setException(
                    new PathTraversalBlockedException(
                        blob.getName(), config.getDownloadDirectory()))
                .build();
        downloadTasks.add(ApiFutures.immediateFuture(skipped));
        continue;
      }
      if (transferManagerConfig.isAllowDivideAndConquerDownload()) {
        BlobInfo validatedBlob = retrieveSizeAndGeneration(storage, blob, config.getBucketName());
        if (validatedBlob != null && qos.divideAndConquer(validatedBlob.getSize())) {
          DownloadResult optimisticResult =
              DownloadResult.newBuilder(validatedBlob, TransferStatus.SUCCESS)
                  .setOutputDestination(destPath)
                  .build();

          List<ApiFuture<DownloadSegment>> downloadSegmentTasks =
              computeRanges(validatedBlob.getSize(), transferManagerConfig.getPerWorkerBufferSize())
                  .stream()
                  .map(
                      r ->
                          new ChunkedDownloadCallable(
                              storage, validatedBlob, opts, destPath, r.begin, r.end))
                  .map(executor::submit)
                  .map(TransferManagerImpl::convert)
                  .collect(ImmutableList.toImmutableList());

          downloadTasks.add(
              ApiFutures.transform(
                  ApiFutures.allAsList(downloadSegmentTasks),
                  segments ->
                      segments.stream()
                          .reduce(
                              optimisticResult,
                              DownloadSegment::reduce,
                              BinaryOperator.minBy(DownloadResult.COMPARATOR)),
                  MoreExecutors.directExecutor()));
          continue;
        }
      }
      DirectDownloadCallable callable =
          new DirectDownloadCallable(storage, blob, config, opts, destPath);
      downloadTasks.add(convert(executor.submit(callable)));
    }

    return DownloadJob.newBuilder()
        .setDownloadResults(downloadTasks)
        .setParallelDownloadConfig(config)
        .build();
  }

  private void schedulePcuPoller() {
    if (pcuPoller == null) {
      synchronized (pcuPollerSync) {
        if (pcuPoller == null) {
          pcuPoller = convert(executor.submit(new PcuPoller()));
        }
      }
    }
  }

  private void deschedulePcuPoller() {
    if (pcuPoller != null) {
      synchronized (pcuPollerSync) {
        if (pcuPoller != null) {
          pcuPoller = null;
        }
      }
    }
  }

  private static <T> ApiFuture<T> convert(ListenableFuture<T> lf) {
    return new ListenableFutureToApiFuture<>(lf);
  }

  private static BlobInfo retrieveSizeAndGeneration(
      Storage storage, BlobInfo blobInfo, String bucketName) {
    if (blobInfo.getGeneration() == null) {
      return storage.get(BlobId.of(bucketName, blobInfo.getName()));
    } else if (blobInfo.getSize() == null) {
      return storage.get(BlobId.of(bucketName, blobInfo.getName(), blobInfo.getGeneration()));
    }
    return blobInfo;
  }

  private static ImmutableList<Range> computeRanges(long end, long segmentSize) {
    ImmutableList.Builder<Range> b = ImmutableList.builder();

    if (end <= segmentSize) {
      b.add(Range.of(0, end));
    } else {
      for (long i = 0; i < end; i += segmentSize) {
        b.add(Range.of(i, Math.min(i + segmentSize, end)));
      }
    }
    return b.build();
  }

  private static final class Range {
    private final long begin;
    private final long end;

    private Range(long begin, long end) {
      this.begin = begin;
      this.end = end;
    }

    public static Range of(long begin, long end) {
      return new Range(begin, end);
    }
  }

  /**
   * When performing a Parallel composite upload, the thread pool we perform work on is shared as
   * the PCU worker pool. Because of this, if we submit our work to the executor service and take
   * all the threads waiting for PCU uploads to complete, the PCU work doesn't have any threads
   * available to itself.
   *
   * <p>This class represents a single worker that will be submitted to the executor service and
   * will poll a queue to process a single PCU at a time, leaving any other threads free for PCU
   * work.
   */
  private final class PcuPoller implements Runnable {

    @Override
    public void run() {
      do {
        PendingPcuTask poll = pcuQueue.poll();
        if (poll == null) {
          deschedulePcuPoller();
          return;
        }

        try {
          UploadResult result = poll.callable.call();
          poll.resultFuture.set(result);
        } catch (Throwable e) {
          poll.resultFuture.setException(e);
          throw e;
        }

      } while (true);
    }
  }

  private static final class PendingPcuTask {
    private final ParallelCompositeUploadCallable callable;
    private final SettableApiFuture<UploadResult> resultFuture;

    private PendingPcuTask(
        ParallelCompositeUploadCallable callable, SettableApiFuture<UploadResult> resultFuture) {
      this.callable = callable;
      this.resultFuture = resultFuture;
    }
  }
}
