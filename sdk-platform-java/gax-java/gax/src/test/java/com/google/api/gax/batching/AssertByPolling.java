/*
 * Copyright 2023 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.batching;

import static java.util.concurrent.TimeUnit.MILLISECONDS;

import com.google.common.base.Stopwatch;
import java.util.Objects;

/**
 * Blocks the current thread to poll the given assertion every 10ms until it's successful or the
 * timeout is exceeded. Expected usage:
 *
 * <pre>{@code
 * assertByPolling(java.time.Duration.ofSeconds(2), () -> assertThat(...));
 * }</pre>
 */
class AssertByPolling {

  public static void assertByPolling(java.time.Duration timeout, Runnable assertion)
      throws InterruptedException {
    Objects.requireNonNull(timeout, "Timeout must not be null");
    Stopwatch stopwatch = Stopwatch.createStarted();
    while (true) {
      try {
        assertion.run();
        return; // Success

      } catch (AssertionError err) {
        if (stopwatch.elapsed(MILLISECONDS) < timeout.toMillis()) {
          MILLISECONDS.sleep(10);
        } else {
          throw new AssertionError("Timeout waiting for successful assertion.", err);
        }
      }
    }
  }
}
