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

package com.google.gcloud.storage;

import com.google.common.collect.ImmutableMap;
import com.google.gcloud.AuthCredentials;
import com.google.gcloud.storage.RemoteGcsHelper.Option.KeyFromClasspath;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;
import java.util.Map;
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
   * Returns a {@StorageOptions} object to be used for testing.
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
   * Creates a {@code RemoteGcsHelper} object.
   *
   * @param options creation options
   * @return A {@code RemoteGcsHelper} object for the provided options.
   * @throws com.google.gcloud.storage.RemoteGcsHelper.GcsHelperException if environment variables
   * {@code GCLOUD_TESTS_PROJECT_ID} and {@code GCLOUD_TESTS_KEY} are not set or if the file
   * pointed by {@code GCLOUD_TESTS_KEY} does not exist
   */
  public static RemoteGcsHelper create(Option... options) throws GcsHelperException {
    boolean keyFromClassPath = false;
    Map<Class<? extends Option>, Option> optionsMap = Option.asImmutableMap(options);
    if (optionsMap.containsKey(KeyFromClasspath.class)) {
      keyFromClassPath =
          ((KeyFromClasspath) optionsMap.get(KeyFromClasspath.class)).keyFromClasspath();
    }
    String projectId = System.getenv(PROJECT_ID_ENV_VAR);
    String stringKeyPath = System.getenv(PRIVATE_KEY_ENV_VAR);
    if (projectId == null) {
      String message = "Environment variable " + PROJECT_ID_ENV_VAR + " not set";
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, message);
      }
      throw new GcsHelperException(message);
    }
    if (stringKeyPath == null) {
      String message = "Environment variable " + PRIVATE_KEY_ENV_VAR + " not set";
      if (log.isLoggable(Level.WARNING)) {
        log.log(Level.WARNING, message);
      }
      throw new GcsHelperException(message);
    }
    try {
      InputStream keyFileStream;
      if (keyFromClassPath) {
        keyFileStream = RemoteGcsHelper.class.getResourceAsStream(stringKeyPath);
        if (keyFileStream == null) {
          throw new FileNotFoundException(stringKeyPath + " not found in classpath");
        }
      } else {
        keyFileStream = new FileInputStream(stringKeyPath);
      }
      StorageOptions storageOptions = StorageOptions.builder()
          .authCredentials(AuthCredentials.createForJson(keyFileStream))
          .projectId(projectId)
          .build();
      return new RemoteGcsHelper(storageOptions);
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

  public static abstract class Option implements java.io.Serializable {

    private static final long serialVersionUID = 8849118657896662369L;

    public static final class KeyFromClasspath extends Option {

      private static final long serialVersionUID = -5506049413185246821L;

      private final boolean keyFromClasspath;

      public KeyFromClasspath(boolean keyFromClasspath) {
        this.keyFromClasspath = keyFromClasspath;
      }

      public boolean keyFromClasspath() {
        return keyFromClasspath;
      }
    }

    Option() {
      // package protected
    }

    public static KeyFromClasspath keyFromClassPath() {
      return new KeyFromClasspath(true);
    }

    static Map<Class<? extends Option>, Option> asImmutableMap(Option... options) {
      ImmutableMap.Builder<Class<? extends Option>, Option> builder = ImmutableMap.builder();
      for (Option option : options) {
        builder.put(option.getClass(), option);
      }
      return builder.build();
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
