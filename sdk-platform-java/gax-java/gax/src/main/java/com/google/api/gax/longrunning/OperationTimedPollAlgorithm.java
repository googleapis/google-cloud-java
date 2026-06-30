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
package com.google.api.gax.longrunning;

import com.google.api.core.ApiClock;
import com.google.api.core.InternalApi;
import com.google.api.core.NanoClock;
import com.google.api.gax.retrying.ExponentialRetryAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.retrying.TimedAttemptSettings;
import com.google.common.annotations.VisibleForTesting;
import java.util.concurrent.CancellationException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Operation timed polling algorithm, which uses exponential backoff factor for determining when the
 * next polling operation should be executed. If the polling exceeds the total timeout this
 * algorithm cancels polling.
 */
public class OperationTimedPollAlgorithm extends ExponentialRetryAlgorithm {

  @VisibleForTesting
  static final Logger LOGGER = Logger.getLogger(OperationTimedPollAlgorithm.class.getName());

  @VisibleForTesting
  static final String LRO_TROUBLESHOOTING_LINK =
      "https://github.com/googleapis/google-cloud-java#lro-timeouts";

  /**
   * Creates the polling algorithm, using the default {@code NanoClock} for time computations.
   *
   * @param globalSettings the settings
   * @return timed poll algorithm
   */
  public static OperationTimedPollAlgorithm create(RetrySettings globalSettings) {
    return new OperationTimedPollAlgorithm(globalSettings, NanoClock.getDefaultClock());
  }

  public static OperationTimedPollAlgorithm create(RetrySettings globalSettings, ApiClock clock) {
    return new OperationTimedPollAlgorithm(globalSettings, clock);
  }

  private OperationTimedPollAlgorithm(RetrySettings globalSettings, ApiClock clock) {
    super(globalSettings, clock);
  }

  /**
   * Returns {@code true} if another poll operation should be made or throws {@link
   * CancellationException} otherwise.
   *
   * @param nextAttemptSettings attempt settings, which will be used for the next attempt, if
   *     accepted
   * @return {@code true} if more attempts should be made, never returns {@code false} (throws
   *     {@code CancellationException} instead)
   * @throws CancellationException if no more attempts should be made
   */
  @Override
  public boolean shouldRetry(TimedAttemptSettings nextAttemptSettings)
      throws CancellationException {
    if (super.shouldRetry(nextAttemptSettings)) {
      return true;
    }
    if (LOGGER.isLoggable(Level.WARNING)) {
      LOGGER.log(
          Level.WARNING,
          "The long running operation request is no longer being tracked. "
              + "Possible reasons include a timeout or "
              + "exceeding the maximum number of poll attempts."
              + " Please refer to "
              + LRO_TROUBLESHOOTING_LINK
              + " for more information");
    }
    throw new CancellationException();
  }

  // Note: if the potential time spent is exactly equal to the totalTimeout,
  // the attempt will still be allowed. This might not be desired, but if we
  // enforce it, it could have potentially negative side effects on LRO polling.
  // Specifically, if a polling retry attempt is denied, the LRO is canceled, and
  // if a polling retry attempt is denied because its delay would *reach* the
  // totalTimeout, the LRO would be canceled prematurely. The problem here is that
  // totalTimeout doubles as the polling threshold and also the time limit for an
  // operation to finish.
  @InternalApi
  @Override
  protected boolean shouldRPCTerminate(long timeLeftMs) {
    return timeLeftMs < 0;
  }
}
