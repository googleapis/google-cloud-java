/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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

package com.google.gcloud.storage.testing;

import com.google.gcloud.AuthCredentials;
import com.google.gcloud.RetryParams;
import com.google.gcloud.storage.BlobInfo;
import com.google.gcloud.storage.Storage;
import com.google.gcloud.storage.StorageException;
import com.google.gcloud.storage.StorageOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
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

/**
 * Utility to create a remote storage configuration for testing
 */
public class RemoteGcsHelper {

  private static final Logger log = Logger.getLogger(RemoteGcsHelper.class.getName());
  private static final String BUCKET_NAME_PREFIX = "gcloud-test-bucket-temp-";
  private static final String PROJECT_ID_ENV_VAR = "GCLOUD_TESTS_PROJECT_ID";
  private static final String PRIVATE_KEY_ENV_VAR = "GCLOUD_TESTS_KEY";
  private final StorageOptions options;

  private RemoteGcsHelper(StorageOptions options) {
    this.options = options;
  }

  /**
   * Returns a {@link StorageOptions} object to be used for testing.
   */
  public StorageOptions options() {
    return options;
  }

  /**
   * Deletes a bucket, even if non-empty. Objects in the bucket are listed and deleted until bucket
   * deletion succeeds or {@code timeout} expires.
   *
   * @param storage the storage service to be used to issue requests
   * @param bucket the bucket to be deleted
   * @param timeout the maximum time to wait
   * @param unit the time unit of the timeout argument
   * @return true if deletion succeeded, false if timeout expired.
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
   * Returns a bucket name generated using a random UUID.
   */
  public static String generateBucketName() {
    return BUCKET_NAME_PREFIX + UUID.randomUUID().toString();
  }

  /**
   * Creates a {@code RemoteGcsHelper} object for the given project id and JSON key input stream.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyStream input stream for a JSON key
   * @return A {@code RemoteGcsHelper} object for the provided options.
   * @throws com.google.gcloud.storage.testing.RemoteGcsHelper.GcsHelperException if
   *     {@code keyStream} is not a valid JSON key stream
   */
  public static RemoteGcsHelper create(String projectId, InputStream keyStream)
      throws GcsHelperException {
    try {
      StorageOptions storageOptions = StorageOptions.builder()
          .authCredentials(AuthCredentials.createForJson(keyStream))
          .projectId(projectId)
          .retryParams(RetryParams.builder()
              .retryMaxAttempts(10)
              .retryMinAttempts(6)
              .maxRetryDelayMillis(30000)
              .totalRetryPeriodMillis(120000)
              .initialRetryDelayMillis(250)
              .build())
          .connectTimeout(60000)
          .readTimeout(60000)
          .build();
      return new RemoteGcsHelper(storageOptions);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw GcsHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteGcsHelper} object for the given project id and JSON key path.
   *
   * @param projectId id of the project to be used for running the tests
   * @param keyPath path to the JSON key to be used for running the tests
   * @return A {@code RemoteGcsHelper} object for the provided options.
   * @throws com.google.gcloud.storage.testing.RemoteGcsHelper.GcsHelperException if the file
   *     pointed by {@code keyPath} does not exist
   */
  public static RemoteGcsHelper create(String projectId, String keyPath)
      throws GcsHelperException {
    try {
      InputStream keyFileStream = new FileInputStream(keyPath);
      return create(projectId, keyFileStream);
    } catch (FileNotFoundException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw GcsHelperException.translate(ex);
    } catch (IOException ex) {
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, ex.getMessage());
      }
      throw GcsHelperException.translate(ex);
    }
  }

  /**
   * Creates a {@code RemoteGcsHelper} object. Project id and path to JSON key are read from two
   * environment variables: {@code GCLOUD_TESTS_PROJECT_ID} and {@code GCLOUD_TESTS_KEY}.
   *
   * @return A {@code RemoteGcsHelper} object for the provided options.
   * @throws com.google.gcloud.storage.testing.RemoteGcsHelper.GcsHelperException if environment
   *     variables {@code GCLOUD_TESTS_PROJECT_ID} and {@code GCLOUD_TESTS_KEY} are not set or if
   *     the file pointed by {@code GCLOUD_TESTS_KEY} does not exist
   */
  public static RemoteGcsHelper create() throws GcsHelperException {
    String projectId = System.getenv(PROJECT_ID_ENV_VAR);
    String keyPath = System.getenv(PRIVATE_KEY_ENV_VAR);
    if (projectId == null) {
      String message = "Environment variable " + PROJECT_ID_ENV_VAR + " not set";
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, message);
      }
      throw new GcsHelperException(message);
    }
    if (keyPath == null) {
      String message = "Environment variable " + PRIVATE_KEY_ENV_VAR + " not set";
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, message);
      }
      throw new GcsHelperException(message);
    }
    return create(projectId, keyPath);
  }

  private static class DeleteBucketTask implements Callable<Boolean> {

    private Storage storage;
    private String bucket;

    public DeleteBucketTask(Storage storage, String bucket) {
      this.storage = storage;
      this.bucket = bucket;
    }

    @Override
    public Boolean call() throws Exception {
      while (true) {
        for (BlobInfo info : storage.list(bucket)) {
          storage.delete(bucket, info.name());
        }
        try {
          storage.delete(bucket);
          return true;
        } catch (StorageException e) {
          if (e.code() == 409) {
            Thread.sleep(500);
          } else {
            throw e;
          }
        }
      }
    }
  }

  public static class GcsHelperException extends RuntimeException {

    private static final long serialVersionUID = -7756074894502258736L;

    public GcsHelperException(String message) {
      super(message);
    }

    public GcsHelperException(String message, Throwable cause) {
      super(message, cause);
    }

    public static GcsHelperException translate(Exception ex) {
      return new GcsHelperException(ex.getMessage(), ex);
    }
  }
}
