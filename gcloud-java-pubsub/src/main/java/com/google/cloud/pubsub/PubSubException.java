/*
 * Copyright 2016 Google Inc. All Rights Reserved.
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

package com.google.cloud.pubsub;

import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.RetryHelper.RetryInterruptedException;
import com.google.common.collect.ImmutableSet;

import java.util.Set;

/**
 * Pub/Sub service exception.
 *
 * @see <a href="https://cloud.google.com/pubsub/error-codes">Google Cloud Pub/Sub error codes</a>
 */
public class PubSubException extends BaseServiceException {

  private static final long serialVersionUID = 6434989638600001226L;
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(499, null),
      new Error(503, null),
      new Error(429, null),
      new Error(500, null),
      new Error(504, null));

  public PubSubException(int code, String message) {
    super(code, message, null, true);
  }

  @Override
  protected Set<Error> retryableErrors() {
    return RETRYABLE_ERRORS;
  }

  /**
   * Translate RetryHelperException to the ResourceManagerException that caused the error. This
   * method will always throw an exception.
   *
   * @throws PubSubException when {@code ex} was caused by a {@code
   * ResourceManagerException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static PubSubException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translateAndPropagateIfPossible(ex);
    throw new PubSubException(UNKNOWN_CODE, ex.getMessage());
  }
}
