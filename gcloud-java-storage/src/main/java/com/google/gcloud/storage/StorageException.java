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

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.common.collect.ImmutableSet;
import com.google.gcloud.BaseServiceException;
import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

/**
 * Storage service exception.
 *
 * @see <a href="https://cloud.google.com/storage/docs/json_api/v1/status-codes">Google Cloud
 *      Storage error codes</a>
 */
public class StorageException extends BaseServiceException {

  private static final Set<Integer> RETRYABLE_CODES = ImmutableSet.of(504, 503, 502, 500, 429, 408);
  private static final long serialVersionUID = 8088235105953640145L;

  public StorageException(int code, String message) {
    super(code, message, RETRYABLE_CODES.contains(code), true);
  }

  public StorageException(IOException exception) {
    super(exception, true);
  }

  public StorageException(GoogleJsonError error) {
    super(error, true);
  }

  @Override
  protected Set<Integer> retryableCodes() {
    return RETRYABLE_CODES;
  }

  @Override
  protected boolean isRetryable(GoogleJsonError error) {
    return super.isRetryable(error) || "InternalError".equals(error.getMessage());
  }

  /**
   * Translate RetryHelperException to the StorageException that caused the error. This method will
   * always throw an exception.
   *
   * @throws StorageException when {@code ex} was caused by a {@code StorageException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  public static StorageException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translateAndThrow(ex);
    throw new StorageException(UNKNOWN_CODE, ex.getMessage());
  }
}
