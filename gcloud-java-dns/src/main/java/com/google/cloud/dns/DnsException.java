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

package com.google.cloud.dns;

import com.google.common.collect.ImmutableSet;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.RetryHelper.RetryInterruptedException;

import java.io.IOException;
import java.util.Set;

/**
 * DNS service exception.
 */
public class DnsException extends BaseServiceException {

  // see: https://cloud.google.com/dns/troubleshooting
  private static final Set<Error> RETRYABLE_ERRORS = ImmutableSet.of(
      new Error(429, null),
      new Error(500, null),
      new Error(502, null),
      new Error(503, null),
      new Error(null, "userRateLimitExceeded"),
      new Error(null, "rateLimitExceeded"));
  private static final long serialVersionUID = 490302380416260252L;

  public DnsException(IOException exception) {
    super(exception, true);
  }

  private DnsException(int code, String message) {
    super(code, message, null, true);
  }

  @Override
  protected Set<Error> retryableErrors() {
    return RETRYABLE_ERRORS;
  }

  /**
   * Translate RetryHelperException to the DnsException that caused the error. This method will
   * always throw an exception.
   *
   * @throws DnsException when {@code ex} was caused by a {@code DnsException}
   * @throws RetryInterruptedException when {@code ex} is a {@code RetryInterruptedException}
   */
  static DnsException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translateAndPropagateIfPossible(ex);
    throw new DnsException(UNKNOWN_CODE, ex.getMessage());
  }
}
