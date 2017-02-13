/*
 * Copyright 2017 Google Inc. All Rights Reserved.
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

package com.google.cloud.spanner;

import com.google.cloud.BaseServiceException;
import com.google.common.base.Preconditions;
import javax.annotation.Nullable;

/** Base exception type for all exceptions produced by the Cloud Spanner service. */
public class SpannerException extends BaseServiceException {
  private static final long serialVersionUID = 20150916L;

  private final ErrorCode code;
  private final boolean retryable;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  SpannerException(
      DoNotConstructDirectly token,
      ErrorCode code,
      boolean retryable,
      @Nullable String message,
      @Nullable Throwable cause) {
    super(code.getCode(), message, null /* reason */, false /* idempotent */, cause);
    this.retryable = retryable;
    if (token != DoNotConstructDirectly.ALLOWED) {
      throw new AssertionError("Do not construct directly: use SpannerExceptionFactory");
    }
    this.code = Preconditions.checkNotNull(code);
  }

  /** Returns the error code associated with this exception. */
  public ErrorCode getErrorCode() {
    return code;
  }

  /** Returns {@code true} if this exception indicates that the operation may succeed if retried. */
  @Override
  public boolean isRetryable() {
    return retryable;
  }

  enum DoNotConstructDirectly {
    ALLOWED
  }
}
