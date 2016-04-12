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

package com.google.cloud.resourcemanager;

import com.google.common.collect.ImmutableSet;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

/**
 * Resource Manager service exception.
 *
 * @see <a href="https://cloud.google.com/resource-manager/v1/errors/core_errors">Google Cloud
 *      Resource Manager error codes</a>
 */
public class ResourceManagerException extends BaseServiceException {

  // see https://cloud.google.com/resource-manager/v1/errors/core_errors
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(503, null),
      new Error(500, null),
      new Error(429, null),
      new Error(403, "concurrentLimitExceeded"),
      new Error(403, "limitExceeded"),
      new Error(403, "rateLimitExceeded"),
      new Error(403, "rateLimitExceededUnreg"),
      new Error(403, "servingLimitExceeded"),
      new Error(403, "userRateLimitExceeded"),
      new Error(403, "userRateLimitExceededUnreg"),
      new Error(403, "variableTermLimitExceeded"));
  private static final long serialVersionUID = -9207194488966554136L;

  public ResourceManagerException(int code, String message) {
    super(code, message, null, true);
  }

  public ResourceManagerException(IOException exception) {
    super(exception, true);
  }

  @Override
  protected Set<Error> retryableErrors() {
    return RETRYABLE_ERRORS;
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
    BaseServiceException.translateAndPropagateIfPossible(ex);
    throw new ResourceManagerException(UNKNOWN_CODE, ex.getMessage());
  }
}
