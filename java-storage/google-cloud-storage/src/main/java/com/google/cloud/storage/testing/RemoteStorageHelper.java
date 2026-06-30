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

import com.google.api.core.ObsoleteApi;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.BlobId;
import com.google.cloud.storage.BlobInfo;
import com.google.cloud.storage.Bucket;
import com.google.cloud.storage.HttpStorageOptions;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.Storage.BlobListOption;
import com.google.cloud.storage.StorageException;
import com.google.cloud.storage.StorageOptions;
import com.google.common.base.Strings;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility to create a remote storage configuration for testing. Storage options can be obtained via
 * the {@link #getOptions()} ()} method. Returned options have custom {@link
 * StorageOptions#getRetrySettings()}: {@link RetrySettings#getMaxAttempts()} is {@code 10}, {@link
 * RetrySettings#getMaxRetryDelay()} is {@code 30000}, {@link RetrySettings#getTotalTimeout()} is
 * {@code 120000} and {@link RetrySettings#getInitialRetryDelay()} is {@code 250}. {@link
 * HttpTransportOptions#getConnectTimeout()} and {@link HttpTransportOptions#getReadTimeout()} are
 * both set to {@code 60000}.
 */
public class RemoteStorageHelper {

  private static final Logger log = Logger.getLogger(RemoteStorageHelper.class.getName());
  private static final String BUCKET_NAME_PREFIX = "gcloud-test-bucket-temp-";
  private final StorageOptions options;

  private RemoteStorageHelper(StorageOptions options) {
    this.options = options;
  }

  /** Returns a {@link StorageOptions} object to be used for testing. */
  public StorageOptions getOptions() {
    return options;
  }

  public static void cleanBuckets(final Storage storage, final long olderThan, long timeoutMs) {
    Runnable task =
        new Runnable() {
          @Override
          public void run() {
            Page<Bucket> buckets =
                storage.list(
                    Storage.BucketListOption.prefix(BUCKET_NAME_PREFIX),
                    Storage.BucketListOption.userProject(storage.getOptions().getProjectId()));
            for (Bucket bucket : buckets.iterateAll()) {
              if (bucket.getCreateTime() < olderThan) {
                try {
                  for (Blob blob :
                      bucket
                          .list(
                              BlobListOption.fields(
                                  Storage.BlobField.EVENT_BASED_HOLD,
                                  Storage.BlobField.TEMPORARY_HOLD))
                          .iterateAll()) {
                    if (Boolean.TRUE.equals(blob.getEventBasedHold())
                        || Boolean.TRUE.equals(blob.getTemporaryHold())) {
                      storage.update(
                          blob.toBuilder().setTemporaryHold(false).setEventBasedHold(false).build(),
                          Storage.BlobTargetOption.userProject(
                              storage.getOptions().getProjectId()));
                    }
                  }
                  forceDelete(storage, bucket.getName());
                } catch (Exception e) {
                  log.info("Failed to clean buckets " + e.getMessage());
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
   * separate thread to send the delete requests. Use {@link #forceDelete(Storage storage, String
   * bucket)} if spawning an additional thread is undesirable, such as in the App Engine production
   * runtime.
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
    return forceDelete(storage, bucket, timeout, unit, "");
  }

  /**
   * Deletes a bucket, even if non-empty. Objects in the bucket are listed and deleted until bucket
   * deletion succeeds or {@code timeout} expires. To allow for the timeout, this method uses a
   * separate thread to send the delete requests. Use {@link #forceDelete(Storage storage, String
   * bucket)} if spawning an additional thread is undesirable, such as in the App Engine production
   * runtime.
   *
   * @param storage the storage service to be used to issue requests
   * @param bucket the bucket to be deleted
   * @param timeout the maximum time to wait
   * @param unit the time unit of the timeout argument
   * @param userProject the project to bill for requester-pays buckets (or "")
   * @return true if deletion succeeded, false if timeout expired
   * @throws InterruptedException if the thread deleting the bucket is interrupted while waiting
   * @throws ExecutionException if an exception was thrown while deleting bucket or bucket objects
   */
  public static Boolean forceDelete(
      Storage storage, String bucket, long timeout, TimeUnit unit, String userProject)
      throws InterruptedException, ExecutionException {
    ThreadFactory threadFactory =
        new ThreadFactoryBuilder().setDaemon(true).setNameFormat("forceDelete-%s").build();
    ExecutorService executor = Executors.newSingleThreadExecutor(threadFactory);
    Future<Boolean> future = executor.submit(new DeleteBucketTask(storage, bucket, userProject));
    try {
      return future.get(timeout, unit);
    } catch (TimeoutException ex) {
      future.cancel(true);
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

  /** Returns a bucket name generated using a random UUID. */
  public static String generateBucketName() {
    return BUCKET_NAME_PREFIX + UUID.randomUUID().toString();
  }

  /**
   * This method is obsolete because of a potential security risk. Use the {@link #create(String,
   * GoogleCredentials)} method instead.
   *
   * <p>If you know that you will be loading credential configurations of a specific type, it is
   * recommended to use a credential-type-specific `fromStream()` method. This will ensure that an
   * unexpected credential type with potential for malicious intent is not loaded unintentionally.
   * You might still have to do validation for certain credential types. Please follow the
   * recommendation for that method.
   *
   * <p>If you are loading your credential configuration from an untrusted source and have not
   * mitigated the risks (e.g. by validating the configuration yourself), make these changes as soon
   * as possible to prevent security risks to your environment.
   *
   * <p>Regardless of the method used, it is always your responsibility to validate configurations
   * received from external sources.
   *
   * <p>See the {@see <a
   * href="https://cloud.google.com/docs/authentication/external/externally-sourced-credentials">documentation</a>}
   * for more details.
   *
   * <p>Creates a {@code RemoteStorageHelper} object for the given project id and JSON key input
   * stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteStorageHelper} object for the provided options
   * @throws com.google.cloud.storage.testing.RemoteStorageHelper.StorageHelperException if {@code
   *     keyStream} is not a valid JSON key stream
   */
  @ObsoleteApi(
      "This method is obsolete because of a potential security risk. Use the create() variant with"
          + " Credential parameter instead")
  public static RemoteStorageHelper create(String projectId, InputStream keyStream)
      throws StorageHelperException {
    try {
      return create(projectId, GoogleCredentials.fromStream(keyStream));
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw StorageHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteStorageHelper} object for the given project id and Credential.
   *
   * @param projectId id of the project to be used for running the tests
   * @param credentials GoogleCredential to set to StorageOptions
   * @return A {@code RemoteStorageHelper} object for the provided options
   */
  public static RemoteStorageHelper create(String projectId, GoogleCredentials credentials) {
    HttpTransportOptions transportOptions =
        HttpStorageOptions.defaults().getDefaultTransportOptions();
    transportOptions =
        transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
    StorageOptions storageOptions =
        StorageOptions.http()
            .setCredentials(credentials)
            .setProjectId(projectId)
            .setRetrySettings(retrySettings())
            .setTransportOptions(transportOptions)
            .build();
    return new RemoteStorageHelper(storageOptions);
  }

  /**
   * Creates a {@code RemoteStorageHelper} object using default project id and authentication
   * credentials.
   */
  public static RemoteStorageHelper create() throws StorageHelperException {
    HttpTransportOptions transportOptions =
        HttpStorageOptions.defaults().getDefaultTransportOptions();
    transportOptions =
        transportOptions.toBuilder().setConnectTimeout(60000).setReadTimeout(60000).build();
    StorageOptions storageOptions =
        StorageOptions.http()
            .setRetrySettings(retrySettings())
            .setTransportOptions(transportOptions)
            .build();
    return new RemoteStorageHelper(storageOptions);
  }

  private static RetrySettings retrySettings() {
    return RetrySettings.newBuilder()
        .setMaxAttempts(10)
        .setMaxRetryDelayDuration(Duration.ofMillis(30000L))
        .setTotalTimeoutDuration(Duration.ofMillis(120000L))
        .setInitialRetryDelayDuration(Duration.ofMillis(250L))
        .setRetryDelayMultiplier(1.0)
        .setInitialRpcTimeoutDuration(Duration.ofMillis(120000L))
        .setRpcTimeoutMultiplier(1.0)
        .setMaxRpcTimeoutDuration(Duration.ofMillis(120000L))
        .build();
  }

  private static class DeleteBucketTask implements Callable<Boolean> {

    private final Storage storage;
    private final String bucket;
    private final String userProject;

    public DeleteBucketTask(Storage storage, String bucket) {
      this.storage = storage;
      this.bucket = bucket;
      this.userProject = "";
    }

    public DeleteBucketTask(Storage storage, String bucket, String userProject) {
      this.storage = storage;
      this.bucket = bucket;
      this.userProject = userProject;
    }

    @Override
    public Boolean call() {
      while (true) {
        ArrayList<BlobId> ids = new ArrayList<>();
        Page<Blob> listedBlobs;
        if (Strings.isNullOrEmpty(userProject)) {
          listedBlobs = storage.list(bucket, BlobListOption.versions(true));
        } else {
          listedBlobs =
              storage.list(
                  bucket, BlobListOption.versions(true), BlobListOption.userProject(userProject));
        }
        for (BlobInfo info : listedBlobs.getValues()) {
          ids.add(info.getBlobId());
        }
        if (!ids.isEmpty()) {
          List<Boolean> results = storage.delete(ids);
          if (!Strings.isNullOrEmpty(userProject)) {
            for (int i = 0; i < results.size(); i++) {
              if (!results.get(i)) {
                // deleting that blob failed. Let's try in a different way.
                storage.delete(
                    bucket,
                    ids.get(i).getName(),
                    Storage.BlobSourceOption.userProject(userProject));
              }
            }
          }
        }
        try {
          if (Strings.isNullOrEmpty(userProject)) {
            storage.delete(bucket);
          } else {
            storage.delete(bucket, Storage.BucketSourceOption.userProject(userProject));
          }
          return true;
        } catch (StorageException e) {
          log.warning("Caught exception in Delete Bucket Task" + e.getMessage());
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
