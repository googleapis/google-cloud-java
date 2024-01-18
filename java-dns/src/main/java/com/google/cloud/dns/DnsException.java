/*
 * Copyright 2016 Google LLC
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

import com.google.api.client.googleapis.json.GoogleJsonError;
import com.google.cloud.BaseServiceException;
import com.google.cloud.RetryHelper.RetryHelperException;
import com.google.cloud.http.BaseHttpServiceException;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.Set;

/** DNS service exception. */
public final class DnsException extends BaseHttpServiceException {

  // see: https://cloud.google.com/dns/troubleshooting
  private static final Set<Error> RETRYABLE_ERRORS =
      ImmutableSet.of(
          new Error(429, null, true),
          new Error(500, null, false),
          new Error(502, null, false),
          new Error(503, null, false),
          new Error(null, "userRateLimitExceeded", true),
          new Error(null, "rateLimitExceeded", true));
  private static final long serialVersionUID = 490302380416260252L;

  public DnsException(IOException exception, boolean idempotent) {
    super(exception, idempotent, RETRYABLE_ERRORS);
  }

  public DnsException(GoogleJsonError error, boolean idempotent) {
    super(error, idempotent, RETRYABLE_ERRORS);
  }

  public DnsException(int code, String message, Throwable cause) {
    super(code, message, null, true, RETRYABLE_ERRORS, cause);
  }

  /**
   * Translate RetryHelperException to the DnsException that caused the error. This method will
   * always throw an exception.
   *
   * @throws DnsException when {@code ex} was caused by a {@code DnsException}
   */
  static DnsException translateAndThrow(RetryHelperException ex) {
    BaseServiceException.translate(ex);
    throw new DnsException(UNKNOWN_CODE, ex.getMessage(), ex.getCause());
  }
}
