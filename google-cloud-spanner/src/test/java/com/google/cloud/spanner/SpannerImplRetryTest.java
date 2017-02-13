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

import static com.google.cloud.spanner.SpannerMatchers.isSpannerException;
import static com.google.common.truth.Truth.assertThat;

import io.grpc.Context;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mockito;

/** Unit tests for {@link SpannerImpl#runWithRetries}. */
@RunWith(JUnit4.class)
public class SpannerImplRetryTest {
  interface StringCallable extends Callable<String> {
    @Override
    String call();
  }

  static class RetryableException extends SpannerException {
    RetryableException(ErrorCode code, @Nullable String message) {
      // OK to instantiate SpannerException directly for this unit test.
      super(DoNotConstructDirectly.ALLOWED, code, true, message, null);
    }
  }

  static class NonRetryableException extends SpannerException {
    NonRetryableException(ErrorCode code, @Nullable String message) {
      super(DoNotConstructDirectly.ALLOWED, code, false, message, null);
    }
  }

  @Rule public ExpectedException expectedException = ExpectedException.none();

  StringCallable callable;

  @Before
  public void setUp() {
    callable = Mockito.mock(StringCallable.class);
  }

  @Test
  public void ok() {
    Mockito.when(callable.call()).thenReturn("r");
    assertThat(SpannerImpl.runWithRetries(callable)).isEqualTo("r");
  }

  @Test
  public void nonRetryableFailure() {
    Mockito.when(callable.call())
        .thenThrow(new NonRetryableException(ErrorCode.FAILED_PRECONDITION, "Failed by test"));
    expectedException.expect(isSpannerException(ErrorCode.FAILED_PRECONDITION));
    SpannerImpl.runWithRetries(callable);
  }

  @Test
  public void retryableFailure() {
    Mockito.when(callable.call())
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #1"))
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #2"))
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #3"))
        .thenReturn("r");
    assertThat(SpannerImpl.runWithRetries(callable)).isEqualTo("r");
  }

  @Test
  public void retryableFailureFollowedByPermanentFailure() {
    Mockito.when(callable.call())
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #1"))
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #2"))
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #3"))
        .thenThrow(new NonRetryableException(ErrorCode.FAILED_PRECONDITION, "Failed by test"));
    expectedException.expect(isSpannerException(ErrorCode.FAILED_PRECONDITION));
    SpannerImpl.runWithRetries(callable);
  }

  @Test
  public void contextCancelled() {
    Mockito.when(callable.call())
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #1"));
    Context.CancellableContext context = Context.current().withCancellation();
    Runnable work =
        context.wrap(
            new Runnable() {
              @Override
              public void run() {
                SpannerImpl.runWithRetries(callable);
              }
            });
    context.cancel(new RuntimeException("Cancelled by test"));
    expectedException.expect(isSpannerException(ErrorCode.CANCELLED));
    work.run();
  }

  @Test
  public void contextDeadlineExceeded() {
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
    Context.CancellableContext context =
        Context.current().withDeadlineAfter(10, TimeUnit.NANOSECONDS, executor);
    Mockito.when(callable.call())
        .thenThrow(new RetryableException(ErrorCode.UNAVAILABLE, "Failure #1"));
    Runnable work =
        context.wrap(
            new Runnable() {
              @Override
              public void run() {
                SpannerImpl.runWithRetries(callable);
              }
            });
    expectedException.expect(isSpannerException(ErrorCode.DEADLINE_EXCEEDED));
    work.run();
  }
}
