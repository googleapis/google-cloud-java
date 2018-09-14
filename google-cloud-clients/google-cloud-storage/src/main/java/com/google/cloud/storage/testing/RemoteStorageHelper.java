/*
 * Copyright 2015 Google LLC
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

package com.google.cloud.storage.testing;

import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.threeten.bp.Duration;

/**
 * Utility to create a remote storage configuration for testing. Storage options can be obtained via
 * the {@link #getOptions()} ()} method. Returned options have custom
 * {@link StorageOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is {@code 10},
 * {@link RetrySettings#getMaxRetryDelay()} is {@code 30000},
 * {@link RetrySettings#getTotalTimeout()} is {@code 120000} and
 * {@link RetrySettings#getInitialRetryDelay()} is {@code 250}.
 * {@link HttpTransportOptions#getConnectTimeout()} and
 * {@link HttpTransportOptions#getReadTimeout()} are both
 * set to {@code 60000}.
 */
public class RemoteStorageHelper {

  private static final Logger log = Logger.getLogger(RemoteStorageHelper.class.getName());
  private static final String BUCKET_NAME_PREFIX = "gcloud-test-bucket-temp-";
  private final StorageOptions options;

  private RemoteStorageHelper(StorageOptions options) {
    this.options = options;
  }

  /**
   * Returns a {@link StorageOptions} object to be used for testing.
   */
  public StorageOptions getOptions() {
    return options;
  }

  public static void cleanBuckets(final Storage storage, final long olderThan, long timeoutMs) {
    Runnable task =
        new Runnable() {
          @Override
          public void run() {
            Page<Bucket> buckets =
                storage.list(Storage.BucketListOption.prefix(BUCKET_NAME_PREFIX));
            for (Bucket bucket : buckets.iterateAll()) {
              if (bucket.getCreateTime() < olderThan) {
                try {
                  for (Blob blob : bucket.list(BlobListOption.fields(Storage.BlobField.EVENT_BASED_HOLD,
                      Storage.BlobField.TEMPORARY_HOLD)).iterateAll()) {
                    if(blob.getEventBasedHold() == true || blob.getTemporaryHold() == true) {
                      BlobInfo.Builder blobBuilder = BlobInfo.newBuilder(bucket.getName(), blob.getName());
                      blobBuilder.setTemporaryHold(false);
                      blobBuilder.setEventBasedHold(false);
                      storage.update(blobBuilder.build());
                    }
                  }
                  forceDelete(storage, bucket.getName());
                } catch (Exception e) {
                  // Ignore the exception, maybe the bucket is being deleted by someone else.
                }
              }
            }
          }
        };
    Thread thread = new Thread(task);
    thread.start();
    try {
      thread.join(timeoutMs);
    } catch (InterruptedException e) {
      log.info("cleanBuckets interrupted");
    }
  }

  /**
   * Deletes a bucket, even if non-empty. Objects in the bucket are listed and deleted until bucket
   * deletion succeeds or {@code timeout} expires. To allow for the timeout, this method uses a
   * separate thread to send the delete requests. Use
   * {@link #forceDelete(Storage storage, String bucket)} if spawning an additional thread is
   * undesirable, such as in the App Engine production runtime.
   *
   * @param storage the storage service to be used to issue requests
   * @param bucket the bucket to be deleted
   * @param timeout the maximum time to wait
   * @param unit the time unit of the timeout argument
   * @return true if deletion succeeded, false if timeout expired
   * @throws InterruptedException if the thread deleting the bucket is interrupted while waiting
   * @throws ExecutionException if an exception was thrown while deleting bucket or bucket objects
   */
  public static Boolean forceDelete(Storage storage, String bucket, long timeout, TimeUnit unit)
      throws InterruptedException, ExecutionException {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<Boolean> future = executor.submit(new DeleteBucketTask(storage, bucket));
    try {
      return future.get(timeout, unit);
    } catch (TimeoutException ex) {
      return false;
    } finally {
      executor.shutdown();
    }
  }

  /**
   * Deletes a bucket, even if non-empty. This method blocks until the deletion completes or fails.
   *
   * @param storage the storage service to be used to issue requests
   * @param bucket the bucket to be deleted
   * @throws StorageException if an exception is encountered during bucket deletion
   */
  public static void forceDelete(Storage storage, String bucket) {
    new DeleteBucketTask(storage, bucket).call();
  }

  /**
   * Returns a bucket name generated using a random UUID.
   */
  public static String generateBucketName() {
    return BUCKET_NAME_PREFIX + UUID.randomUUID().toString();
  }

  /**
   * Creates a {@code RemoteStorageHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteStorageHelper} object for the provided options
   * @throws com.google.cloud.storage.testing.RemoteStorageHelper.StorageHelperException if
   *     {@code keyStream} is not a valid JSON key stream
   */
  public static RemoteStorageHelper create(String projectId, InputStream keyStream)
      throws StorageHelperException {
    try {
      HttpTransportOptions transportOptions = StorageOptions.getDefaultHttpTransportOptions();
      transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
          .build();
      StorageOptions storageOptions = StorageOptions.newBuilder()
          .setCredentials(GoogleCredentials.fromStream(keyStream))
          .setProjectId(projectId)
          .setRetrySettings(retrySettings())
          .setTransportOptions(transportOptions)
          .build();
      return new RemoteStorageHelper(storageOptions);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw StorageHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteStorageHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteStorageHelper create() throws StorageHelperException {
    HttpTransportOptions transportOptions = StorageOptions.getDefaultHttpTransportOptions();
    transportOptions = transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000)
        .build();
    StorageOptions storageOptions = StorageOptions.newBuilder()
        .setRetrySettings(retrySettings())
        .setTransportOptions(transportOptions)
        .build();
    return new RemoteStorageHelper(storageOptions);
  }

  private static RetrySettings retrySettings() {
    return RetrySettings.newBuilder().setMaxAttempts(10)
        .setMaxRetryDelay(Duration.ofMillis(30000L))
        .setTotalTimeout(Duration.ofMillis(120000L))
        .setInitialRetryDelay(Duration.ofMillis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeout(Duration.ofMillis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeout(Duration.ofMillis(120000L))
        .build();
  }

  private static class DeleteBucketTask implements Callable<Boolean> {

    private Storage storage;
    private String bucket;

    public DeleteBucketTask(Storage storage, String bucket) {
      this.storage = storage;
      this.bucket = bucket;
    }

    @Override
    public Boolean call() {
      while (true) {
        ArrayList<BlobId> ids = new ArrayList<>();
        for (BlobInfo info : storage.list(bucket, BlobListOption.versions(true)).getValues()) {
          ids.add(info.getBlobId());
        }
        if (!ids.isEmpty()) {
          storage.delete(ids);
        }
        try {
          storage.delete(bucket);
          return true;
        } catch (StorageException e) {
          if (e.getCode() == 409) {
            try {
              Thread.sleep(500);
            } catch (InterruptedException interruptedException) {
              Thread.currentThread().interrupt();
              throw e;
            }
          } else {
            throw e;
          }
        }
      }
    }
  }

  public static class StorageHelperException extends RuntimeException {

    private static final long serialVersionUID = -7756074894502258736L;

    public StorageHelperException(String message) {
      super(message);
    }

    public StorageHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static StorageHelperException translate(Exception ex) {
      return new StorageHelperException(ex.getMessage(), ex);
    }
  }
}
