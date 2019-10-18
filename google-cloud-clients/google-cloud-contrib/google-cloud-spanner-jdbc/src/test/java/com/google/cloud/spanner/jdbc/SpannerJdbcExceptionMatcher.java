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

import com.google.common.base.Preconditions;
import io.grpc.Status.Code;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;

public final class SpannerJdbcExceptionMatcher<T extends JdbcSqlException> extends BaseMatcher<T> {
  private final Class<T> exceptionClass;
  private final Code errorCode;
  private final String message;

  public static <T extends JdbcSqlException> SpannerJdbcExceptionMatcher<T> matchCode(
      Class<T> exceptionClass, Code errorCode) {
    Preconditions.checkNotNull(exceptionClass);
    Preconditions.checkNotNull(errorCode);
    return new SpannerJdbcExceptionMatcher<T>(exceptionClass, errorCode, null);
  }

  public static <T extends JdbcSqlException> SpannerJdbcExceptionMatcher<T> matchCodeAndMessage(
      Class<T> exceptionClass, Code errorCode, String message) {
    Preconditions.checkNotNull(exceptionClass);
    Preconditions.checkNotNull(errorCode);
    Preconditions.checkNotNull(message);
    return new SpannerJdbcExceptionMatcher<T>(exceptionClass, errorCode, message);
  }

  private SpannerJdbcExceptionMatcher(Class<T> exceptionClass, Code errorCode, String message) {
    this.exceptionClass = exceptionClass;
    this.errorCode = errorCode;
    this.message = message;
  }

  @Override
  public boolean matches(Object item) {
    if (exceptionClass.isAssignableFrom(item.getClass())) {
      JdbcSqlException exception = (JdbcSqlException) item;
      if (message == null) {
        return exception.getErrorCode() == errorCode.value();
      }
      return exception.getErrorCode() == errorCode.value()
          && exception.getMessage().endsWith(": " + message);
    }
    return false;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText(exceptionClass.getName() + " with code " + errorCode.name());
    if (message != null) {
      description.appendText(" - " + JdbcSqlException.class.getName() + " with message " + message);
    }
  }
}
