/*
 * Copyright 2023 Google LLC
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

package com.example.storage;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertThrows;

import com.google.api.gax.retrying.RetrySettings;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.Test;

public class TestUtilsTest {

  private static final RetrySettings RETRY_SETTINGS =
      RetrySettings.newBuilder().setMaxAttempts(3).build();

  @Test
  public void noException() throws Throwable {
    TestUtils.retryAssert(RETRY_SETTINGS, () -> assertThat(true).isTrue());
  }

  @Test
  public void assertionFailureOnce() throws Throwable {
    System.out.println("TestUtilsTest.assertionFailureOnce");
    AtomicInteger c = new AtomicInteger(1);
    TestUtils.retryAssert(RETRY_SETTINGS, () -> assertThat(c.getAndIncrement()).isGreaterThan(1));
  }

  @Test
  public void assertionError_exhausted() throws Throwable {
    AtomicInteger c = new AtomicInteger(1);
    try {
      TestUtils.retryAssert(
          RETRY_SETTINGS, () -> assertThat(c.getAndIncrement()).isGreaterThan(10));
      throw new Throwable("expected AssertionError");
    } catch (AssertionError ignore) {
      // expected
    }
  }

  @Test
  public void runtimeException_exhausted() {
    assertThrows(
        RuntimeException.class,
        () ->
            TestUtils.retryAssert(
                RETRY_SETTINGS,
                () -> {
                  throw new RuntimeException("kaboom");
                }));
  }
}
