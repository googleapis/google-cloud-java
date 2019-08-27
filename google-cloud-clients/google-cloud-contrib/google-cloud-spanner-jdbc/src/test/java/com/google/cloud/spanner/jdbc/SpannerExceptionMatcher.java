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
import com.google.common.base.Preconditions;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public final class SpannerExceptionMatcher extends BaseMatcher<SpannerException> {
  private final ErrorCode errorCode;
  private final String message;

  public static SpannerExceptionMatcher matchCode(ErrorCode errorCode) {
    Preconditions.checkNotNull(errorCode);
    return new SpannerExceptionMatcher(errorCode, null);
  }

  public static SpannerExceptionMatcher matchCodeAndMessage(ErrorCode errorCode, String message) {
    Preconditions.checkNotNull(errorCode);
    Preconditions.checkNotNull(message);
    return new SpannerExceptionMatcher(errorCode, message);
  }

  private SpannerExceptionMatcher(ErrorCode errorCode, String message) {
    this.errorCode = errorCode;
    this.message = message;
  }

  @Override
  public boolean matches(Object item) {
    if (item instanceof SpannerException) {
      SpannerException exception = (SpannerException) item;
      if (message == null) {
        return exception.getErrorCode().equals(errorCode);
      }
      return exception.getErrorCode().equals(errorCode)
          && exception.getMessage().equals(errorCode.name() + ": " + message);
    }
    return false;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText(SpannerException.class.getName() + " with code " + errorCode.name());
    if (message != null) {
      description.appendText(" - " + SpannerException.class.getName() + " with message " + message);
    }
  }
}
