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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.protobuf.Message;
import com.google.protobuf.TextFormat;
import java.lang.reflect.InvocationTargetException;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/** Various {@link Matcher} implementations used by Cloud Spanner unit tests. */
public final class SpannerMatchers {
  private SpannerMatchers() {}

  /**
   * Returns a matcher that checks that a protocol buffer message is equivalent to that described in
   * text format by {@code expected}.
   */
  static <T extends Message> Matcher<T> matchesProto(Class<T> clazz, String expected) {
    return new ProtoTextMatcher<>(clazz, expected);
  }

  /**
   * Returns a matcher that checks that a {@code Throwable} is a {@link SpannerException} where
   * {@link SpannerException#getErrorCode()} is equal to {@code code}.
   *
   * <p>TODO(user): Move this method to testing.
   */
  public static <T extends Throwable> Matcher<T> isSpannerException(ErrorCode code) {
    return new SpannerExceptionMatcher<>(code);
  }

  private static class ProtoTextMatcher<T extends Message> extends BaseMatcher<T> {
    private final T expected;

    ProtoTextMatcher(Class<T> clazz, String expectedTextFormat) {
      T defaultInstance = getDefaultInstance(clazz);
      Message.Builder builder = defaultInstance.toBuilder();
      try {
        TextFormat.merge(expectedTextFormat, builder);
      } catch (TextFormat.ParseException e) {
        throw new IllegalArgumentException("Invalid text format for " + clazz.getName(), e);
      }
      @SuppressWarnings("unchecked") // T.builder().build() always returns T.
      T expectedInstance = (T) builder.build();
      expected = expectedInstance;
    }

    private T getDefaultInstance(Class<T> clazz) {
      try {
        @SuppressWarnings("unchecked") // T.getDefaultInstance() always returns T.
        T instance = (T) clazz.getMethod("getDefaultInstance").invoke(clazz);
        return instance;
      } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
        throw new AssertionError("Invalid proto class " + clazz, e);
      }
    }

    @Override
    public boolean matches(Object item) {
      if (item == null || !(expected.getClass().isAssignableFrom(item.getClass()))) {
        return false;
      }
      @SuppressWarnings("unchecked") // Type checked above.
      T actual = (T) item;
      return expected.equals(actual);
    }

    @Override
    public void describeTo(Description description) {
      description.appendText(expected.toString());
    }
  }

  private static class SpannerExceptionMatcher<T extends Throwable> extends BaseMatcher<T> {
    private final ErrorCode expectedCode;

    SpannerExceptionMatcher(ErrorCode expectedCode) {
      this.expectedCode = checkNotNull(expectedCode);
    }

    @Override
    public boolean matches(Object item) {
      if (!(item instanceof SpannerException)) {
        return false;
      }
      SpannerException e = (SpannerException) item;
      return e.getErrorCode() == expectedCode;
    }

    @Override
    public void describeTo(Description description) {
      description.appendText("SpannerException[" + expectedCode + "]");
    }
  }
}
