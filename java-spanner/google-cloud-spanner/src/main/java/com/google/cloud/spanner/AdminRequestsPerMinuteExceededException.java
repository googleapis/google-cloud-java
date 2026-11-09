/*
 * Copyright 2020 Google LLC
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

import com.google.api.gax.rpc.ApiException;
import javax.annotation.Nullable;

/**
 * Exception thrown by Cloud Spanner the number of administrative requests per minute has been
 * exceeded.
 */
public class AdminRequestsPerMinuteExceededException extends SpannerException {
  private static final long serialVersionUID = -6395746612598975751L;

  static final String ADMIN_REQUESTS_LIMIT_KEY = "quota_limit";
  static final String ADMIN_REQUESTS_LIMIT_VALUE = "AdminMethodQuotaPerMinutePerProject";

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AdminRequestsPerMinuteExceededException(
      DoNotConstructDirectly token, @Nullable String message, @Nullable Throwable cause) {
    this(token, message, cause, null);
  }

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AdminRequestsPerMinuteExceededException(
      DoNotConstructDirectly token,
      @Nullable String message,
      @Nullable Throwable cause,
      @Nullable ApiException apiException) {
    super(token, ErrorCode.RESOURCE_EXHAUSTED, true, message, cause, apiException);
  }
}
