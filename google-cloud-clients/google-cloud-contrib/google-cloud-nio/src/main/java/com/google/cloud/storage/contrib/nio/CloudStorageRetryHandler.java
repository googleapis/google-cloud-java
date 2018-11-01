/*
 * Copyright 2017 Google LLC
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

package com.google.cloud.storage.contrib.nio;

import com.google.cloud.storage.StorageException;

import java.io.EOFException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import javax.net.ssl.SSLException;

/**
 * Simple counter class to keep track of retry and reopen attempts when StorageExceptions are
 * encountered. Handles sleeping between retry/reopen attempts, as well as throwing an exception
 * when all retries/reopens are exhausted.
 */
public class CloudStorageRetryHandler {
  private int retries;
  private int reopens;
  private long totalWaitTime; // in milliseconds
  private final int maxRetries;
  private final int maxReopens;

  /**
   * Create a CloudStorageRetryHandler with the maximum retries and reopens set to the same value.
   *
   * @param maxRetriesAndReopens value for both maxRetries and maxReopens
   */
  public CloudStorageRetryHandler(final int maxRetriesAndReopens) {
    this.maxRetries = maxRetriesAndReopens;
    this.maxReopens = maxRetriesAndReopens;
  }

  /**
   * Create a CloudStorageRetryHandler with the maximum retries and reopens set to different values.
   *
   * @param maxRetries maximum number of retries
   * @param maxReopens maximum number of reopens
   */
  public CloudStorageRetryHandler(final int maxRetries, final int maxReopens) {
    this.maxRetries = maxRetries;
    this.maxReopens = maxReopens;
  }

  /**
   * @return number of retries we've performed
   */
  public int retries() {
    return retries;
  }

  /**
   * @return number of reopens we've performed
   */
  public int reopens() {
    return reopens;
  }

  /**
   * Checks whether we should retry, reopen, or give up.
   *
   * In the latter case it throws an exception (this includes the scenario where
   * we exhausted the retry count).
   *
   * Otherwise, it sleeps for a bit and returns whether we should reopen.
   * The sleep time is dependent on the retry number.
   *
   * @param exs caught StorageException
   * @return True if you need to reopen and then try again. False if you can just try again.
   * @throws StorageException if the exception is not retryable, or if you ran out of retries.
   */
  public boolean handleStorageException(final StorageException exs) throws StorageException {
    // None of the retryable exceptions are reopenable, so it's OK to write the code this way.
    if (isRetryable(exs)) {
      handleRetryForStorageException(exs);
      return false;
    }
    if (isReopenable(exs)) {
      handleReopenForStorageException(exs);
      return true;
    }
    throw exs;
  }

  /**
   * Records a retry attempt for the given StorageException, sleeping for an amount of time dependent on the
   * attempt number. Throws a StorageException if we've exhausted all retries.
   *
   * @param exs The StorageException error that prompted this retry attempt.
   */
  private void handleRetryForStorageException(final StorageException exs) throws StorageException {
    retries++;
    if (retries > maxRetries) {
      throw new StorageException(exs.getCode(),
          "All " + maxRetries + " retries failed. Waited a total of " + totalWaitTime + " ms between attempts", exs);
    }
    sleepForAttempt(retries);
  }

  /**
   * Records a reopen attempt for the given StorageException, sleeping for an amount of time dependent on the
   * attempt number. Throws a StorageException if we've exhausted all reopens.
   *
   * @param exs The StorageException error that prompted this reopen attempt.
   */
  private void handleReopenForStorageException(final StorageException exs) throws StorageException {
    reopens++;
    if (reopens > maxReopens) {
      throw new StorageException(exs.getCode(),
          "All " + maxReopens + " reopens failed. Waited a total of " + totalWaitTime + " ms between attempts", exs);
    }
    sleepForAttempt(reopens);
  }

  void sleepForAttempt(int attempt) {
    // exponential backoff, but let's bound it around 2min.
    // aggressive backoff because we're dealing with unusual cases.
    long delay = 1000L * (1L << Math.min(attempt, 7));
    try {
      Thread.sleep(delay);
      totalWaitTime += delay;
    } catch (InterruptedException iex) {
      // reset interrupt flag
      Thread.currentThread().interrupt();
    }
  }

  /**
   * @param exs StorageException to test
   * @return true if exs is a retryable error, otherwise false
   */
  private static boolean isRetryable(final StorageException exs) {
    return exs.isRetryable() || exs.getCode() == 500 || exs.getCode() == 502 || exs.getCode() == 503;
  }

  /**
   * @param exs StorageException to test
   * @return true if exs is an error that can be resolved via a channel reopen, otherwise false
   */
  private static boolean isReopenable(final StorageException exs) {
    Throwable throwable = exs;
    // ensures finite iteration
    int maxDepth = 20;
    while (throwable != null && maxDepth-- > 0) {
      if ((throwable.getMessage() != null
          && throwable.getMessage().contains("Connection closed prematurely"))
          || throwable instanceof SSLException
          || throwable instanceof EOFException
          || throwable instanceof SocketException
          || throwable instanceof SocketTimeoutException) {
        return true;
      }
      throwable = throwable.getCause();
    }
    return false;
  }
}
