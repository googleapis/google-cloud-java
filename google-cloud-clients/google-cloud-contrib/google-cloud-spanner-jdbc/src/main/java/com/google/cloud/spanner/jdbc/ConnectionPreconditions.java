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

package com.google.cloud.spanner.jdbc;

import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import javax.annotation.Nullable;

/**
 * Static convenience methods that help a method or constructor in the Connection API to check
 * whether it was invoked correctly.
 */
class ConnectionPreconditions {
  /**
   * Ensures the truth of an expression involving the state of the calling instance, but not
   * involving any parameters to the calling method.
   *
   * @param expression a boolean expression
   * @param errorMessage the exception message to use if the check fails; will be converted to a
   *     string using {@link String#valueOf(Object)}.
   * @throws SpannerException with {@link ErrorCode#FAILED_PRECONDITION} if {@code expression} is
   *     false.
   */
  static void checkState(boolean expression, @Nullable Object errorMessage) {
    if (!expression) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION, String.valueOf(errorMessage));
    }
  }
}
