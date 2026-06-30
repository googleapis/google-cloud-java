/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.retrying;

import com.google.api.core.ApiClock;

/**
 * The timed poll algorithm which uses jittered exponential backoff factor for calculating the next
 * poll execution time and throws {@link PollException} in case if total timeout or total number of
 * attempts is reached.
 *
 * <p>This class is thread-safe.
 */
public class ExponentialPollAlgorithm extends ExponentialRetryAlgorithm {
  /**
   * Creates a new exponential poll algorithm instance.
   *
   * @param globalSettings global poll settings (attempt independent)
   * @param clock clock to use for time-specific calculations
   * @throws NullPointerException if either {@code globalSettings} or {@code clock} is null
   */
  public ExponentialPollAlgorithm(RetrySettings globalSettings, ApiClock clock) {
    super(globalSettings, clock);
  }

  /**
   * Returns {@code true} if another poll operation should be made or throws {@link PollException},
   * if either total timeout or total number of attempts is exceeded.
   *
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @return {@code true} if more attempts should be made, never returns {@code false} (throws
   *     {@code PollException} instead)
   * @throws PollException if no more attempts should be made
   */
  @Override
  public boolean shouldRetry(TimedAttemptSettings nextAttemptSettings) throws PollException {
    if (super.shouldRetry(nextAttemptSettings)) {
      return true;
    }
    throw new PollException(
        "total timeout or maximum number of attempts exceeded; current settings: "
            + nextAttemptSettings.getGlobalSettings());
  }
}
