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

package com.google.gcloud.resourcemanager;

import com.google.gcloud.RetryHelper.RetryHelperException;
import com.google.gcloud.RetryHelper.RetryInterruptedException;

/**
 * Resource Manager service exception.
 *
 * @see <a href="https://cloud.google.com/resource-manager/v1/errors/core_errors">Google Cloud
 *      Resource Manager error codes</a>
 */
public class ResourceManagerException extends RuntimeException {

  private static final long serialVersionUID = 6841689911565501705L;
  private static final int UNKNOWN_CODE = -1;

  private final int code;
  private final boolean retryable;

  public ResourceManagerException(int code, String message, boolean retryable) {
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
   * Translate RetryHelperException to the ResourceManagerException that caused the error. This
   * method will always throw an exception.
   *
   * @throws ResourceManagerException when {@code ex} was caused by a {@code
   * ResourceManagerException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static ResourceManagerException translateAndThrow(RetryHelperException ex) {
    throw new ResourceManagerException(UNKNOWN_CODE, ex.getMessage(), false);
        // TODO(ajaykannan): Fix me!
  }
}
