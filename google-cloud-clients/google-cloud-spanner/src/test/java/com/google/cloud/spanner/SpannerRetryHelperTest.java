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

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class SpannerRetryHelperTest {

  @Test
  public void noException() {
    Callable<Integer> callable =
        new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            return 1 + 1;
          }
        };
    assertThat(SpannerRetryHelper.runTxWithRetriesOnAborted(callable), is(equalTo(2)));
  }

  @Test(expected = IllegalStateException.class)
  public void propagateUncheckedException() {
    Callable<Integer> callable =
        new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            throw new IllegalStateException("test");
          }
        };
    SpannerRetryHelper.runTxWithRetriesOnAborted(callable);
  }

  @Test
  public void retryOnAborted() {
    final AtomicInteger attempts = new AtomicInteger();
    Callable<Integer> callable =
        new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            if (attempts.getAndIncrement() == 0) {
              throw SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "test");
            }
            return 1 + 1;
          }
        };
    assertThat(SpannerRetryHelper.runTxWithRetriesOnAborted(callable), is(equalTo(2)));
  }

  @Test
  public void retryMultipleTimesOnAborted() {
    final AtomicInteger attempts = new AtomicInteger();
    Callable<Integer> callable =
        new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            if (attempts.getAndIncrement() < 2) {
              throw SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "test");
            }
            return 1 + 1;
          }
        };
    assertThat(SpannerRetryHelper.runTxWithRetriesOnAborted(callable), is(equalTo(2)));
  }

  @Test(expected = IllegalStateException.class)
  public void retryOnAbortedAndThenPropagateUnchecked() {
    final AtomicInteger attempts = new AtomicInteger();
    Callable<Integer> callable =
        new Callable<Integer>() {
          @Override
          public Integer call() throws Exception {
            if (attempts.getAndIncrement() == 0) {
              throw SpannerExceptionFactory.newSpannerException(ErrorCode.ABORTED, "test");
            }
            throw new IllegalStateException("test");
          }
        };
    SpannerRetryHelper.runTxWithRetriesOnAborted(callable);
  }
}
