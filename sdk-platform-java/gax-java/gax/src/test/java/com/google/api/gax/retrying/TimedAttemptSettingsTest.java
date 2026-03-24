/*
 * Copyright 2024 Google LLC
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

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;

import org.junit.jupiter.api.Test;

public class TimedAttemptSettingsTest {

  private static final TimedAttemptSettings.Builder SETTINGS_BUILDER =
      TimedAttemptSettings.newBuilder()
          .setGlobalSettings(RetrySettings.newBuilder().build())
          .setRpcTimeoutDuration(java.time.Duration.ofMillis(5000l))
          .setRandomizedRetryDelayDuration(java.time.Duration.ofMillis(5000l))
          .setAttemptCount(123)
          .setFirstAttemptStartTimeNanos(123l);

  @Test
  public void testRetryDelay() {
    testDurationMethod(
        123l,
        jt -> SETTINGS_BUILDER.setRetryDelayDuration(jt).build(),
        tt -> SETTINGS_BUILDER.setRetryDelay(tt).build(),
        o -> o.getRetryDelayDuration(),
        o -> o.getRetryDelay());
  }

  @Test
  public void testRandomizedRetryDelay() {
    testDurationMethod(
        123l,
        jt -> SETTINGS_BUILDER.setRandomizedRetryDelayDuration(jt).build(),
        tt -> SETTINGS_BUILDER.setRandomizedRetryDelay(tt).build(),
        o -> o.getRandomizedRetryDelayDuration(),
        o -> o.getRandomizedRetryDelay());
  }

  @Test
  public void testRpcTimeout() {
    testDurationMethod(
        123l,
        jt -> SETTINGS_BUILDER.setRpcTimeoutDuration(jt).build(),
        tt -> SETTINGS_BUILDER.setRpcTimeout(tt).build(),
        o -> o.getRpcTimeoutDuration(),
        o -> o.getRpcTimeout());
  }
}
