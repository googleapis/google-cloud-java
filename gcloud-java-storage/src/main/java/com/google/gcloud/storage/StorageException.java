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

import com.google.gcloud.RetryHelper;
import com.google.gcloud.RetryHelper.RetryHelperException;

/**
 * Storage service exception.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/status-codes">Google Cloud
 *      Storage error codes</a>
 */
public class StorageException extends RuntimeException {

  private static final long serialVersionUID = -3748432005065428084L;
  private static final int UNKNOWN_CODE = -1;

  private final int code;
  private final boolean retryable;

  public StorageException(int code, String message, boolean retryable) {
    super(message);
    this.code = code;
    this.retryable = retryable;
  }

  /**
   * Returns the code associated with this exception.
   */
  public int code() {
    return code;
  }

  public boolean retryable() {
    return retryable;
  }

  /**
   * Translate RetryHelperException to the StorageException that caused the error. This method will
   * always throw an exception.
   *
   * @throws StorageException when {@code ex} was caused by a {@code StorageException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static StorageException translateAndThrow(RetryHelperException ex) {
    if (ex.getCause() instanceof StorageException) {
      throw (StorageException) ex.getCause();
    }
    if (ex instanceof RetryHelper.RetryInterruptedException) {
      RetryHelper.RetryInterruptedException.propagate();
    }
    throw new StorageException(UNKNOWN_CODE, ex.getMessage(), false);
  }
}
