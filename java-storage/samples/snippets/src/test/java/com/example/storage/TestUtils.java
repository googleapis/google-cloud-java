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

import com.google.api.core.CurrentMillisClock;
import com.google.api.gax.retrying.BasicResultRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.cloud.RetryHelper;
import com.google.cloud.RetryHelper.RetryHelperException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public final class TestUtils {

  private static final Logger log = Logger.getLogger(TestUtils.class.getName());
  private static final Object SENTINEL = new Object();

  private TestUtils() {}

  public static void retryAssert(RetrySettings rs, RetryRunnable f) throws Throwable {
    AtomicInteger counter = new AtomicInteger(1);
    try {
      RetryHelper.runWithRetries(
          () -> {
            try {
              int c = counter.getAndIncrement();
              if (c > 1) {
                log.warning(String.format("Retrying assertion for the %d time", c));
              }
              f.run();
              return SENTINEL;
            } catch (Throwable e) {
              throw new TunnelThrowable(e);
            }
          },
          rs,
          new BasicResultRetryAlgorithm<Object>() {
            @Override
            public boolean shouldRetry(Throwable previousThrowable, Object previousResponse) {
              return previousResponse != SENTINEL && previousThrowable != null;
            }
          },
          CurrentMillisClock.getDefaultClock());
    } catch (RetryHelperException e) {
      if (e.getCause() instanceof TunnelThrowable) {
        TunnelThrowable cause = (TunnelThrowable) e.getCause();
        throw cause.getCause();
      }
      throw e.getCause();
    }
  }

  @FunctionalInterface
  public interface RetryRunnable {

    void run() throws Throwable;
  }

  private static final class TunnelThrowable extends Exception {
    private TunnelThrowable(Throwable cause) {
      super(cause);
    }
  }
}
