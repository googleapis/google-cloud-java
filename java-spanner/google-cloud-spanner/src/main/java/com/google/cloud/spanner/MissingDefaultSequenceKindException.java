/*
 * Copyright 2025 Google LLC
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
import java.util.regex.Pattern;
import javax.annotation.Nullable;

/**
 * Exception thrown by Spanner when a DDL statement failed because no default sequence kind has been
 * configured for a database.
 */
public class MissingDefaultSequenceKindException extends SpannerException {
  private static final long serialVersionUID = 1L;

  private static final Pattern PATTERN =
      Pattern.compile(
          ".*Please specify the sequence kind explicitly or set the database option"
              + " `default_sequence_kind`\\.");

  /** Private constructor. Use {@link SpannerExceptionFactory} to create instances. */
  MissingDefaultSequenceKindException(
      DoNotConstructDirectly token,
      ErrorCode errorCode,
      String message,
      Throwable cause,
      @Nullable ApiException apiException) {
    super(token, errorCode, /* retryable= */ false, message, cause, apiException);
  }

  static boolean isMissingDefaultSequenceKindException(Throwable cause) {
    if (cause == null
        || cause.getMessage() == null
        || !PATTERN.matcher(cause.getMessage()).find()) {
      return false;
    }
    return true;
  }
}
