/*
 * Copyright 2019 Google LLC
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

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Exception thrown by a {@link CloudSpannerJdbcConnection} when a database operation detects that a
 * transaction has aborted and an internal retry failed because of a concurrent modification. This
 * type of error has its own subclass since it is often necessary to handle this specific kind of
 * aborted exceptions differently to other types of errors.
 */
public class AbortedDueToConcurrentModificationException extends AbortedException {
  private static final long serialVersionUID = 7600146169922053323L;
  private final SpannerException databaseError;

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AbortedDueToConcurrentModificationException(
      DoNotConstructDirectly token, @Nullable String message, @Nullable Throwable cause) {
    super(token, message, cause);
    this.databaseError = null;
  }

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  AbortedDueToConcurrentModificationException(
      DoNotConstructDirectly token,
      @Nullable String message,
      @Nullable Throwable cause,
      @Nonnull SpannerException databaseError) {
    super(token, message, cause);
    this.databaseError = databaseError;
  }

  public SpannerException getDatabaseErrorDuringRetry() {
    return databaseError;
  }
}
