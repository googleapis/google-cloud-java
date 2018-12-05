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

package com.google.cloud.storage;

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.api.core.InternalApi;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

/**
 * Storage service exception.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/status-codes">Google Cloud
 *     Storage error codes</a>
 */
@InternalApi
public final class StorageException extends BaseHttpServiceException {

  // see: https://cloud.google.com/storage/docs/resumable-uploads-xml#practices
  private static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(504, null),
          new Error(503, null),
          new Error(502, null),
          new Error(500, null),
          new Error(429, null),
          new Error(408, null),
          new Error(null, "internalError"));

  private static final long serialVersionUID = -4168430271327813063L;

  public StorageException(int code, String message) {
    this(code, message, null);
  }

  public StorageException(int code, String message, Throwable cause) {
    super(code, message, null, true, RETRYABLE_ERRORS, cause);
  }

  public StorageException(IOException exception) {
    super(exception, true, RETRYABLE_ERRORS);
  }

  public StorageException(GoogleJsonError error) {
    super(error, true, RETRYABLE_ERRORS);
  }

  /**
   * Translate RetryHelperException to the StorageException that caused the error. This method will
   * always throw an exception.
   *
   * @throws StorageException when {@code ex} was caused by a {@code StorageException}
   */
  public static StorageException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    throw new StorageException(UNKNOWN_CODE, ex.getMessage(), ex.getCause());
  }
}
