/*
 * Copyright 2026 Google LLC
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

package com.google.showcase.v1beta1.it;

import static org.junit.Assert.assertEquals;

import com.google.api.gax.retrying.RetrySettings;
import org.junit.Test;

/**
 * Tests to confirm that usage of retry settings can be done regardless of whether threeten or
 * java.time is being used
 */
public class ITTimeObjectsPropagationTest {
  @Test
  public void testRetrySettings_fromJavaTimeHasEquivalentThreetenValues() {
    java.time.Duration javaTimeCommonValue = java.time.Duration.ofMillis(123l);
    org.threeten.bp.Duration threetenConvertedValue =
        org.threeten.bp.Duration.ofMillis(javaTimeCommonValue.toMillis());
    RetrySettings javaTimeRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(javaTimeCommonValue)
            .setMaxRetryDelayDuration(javaTimeCommonValue)
            .setInitialRpcTimeoutDuration(javaTimeCommonValue)
            .setMaxRpcTimeoutDuration(javaTimeCommonValue)
            .setTotalTimeoutDuration(javaTimeCommonValue)
            .build();

    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getInitialRetryDelay().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getMaxRetryDelay().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getInitialRpcTimeout().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getMaxRpcTimeout().toMillis());
    assertEquals(
        threetenConvertedValue.toMillis(), javaTimeRetrySettings.getTotalTimeout().toMillis());
  }

  @Test
  public void testRetrySettings_fromThreetenHasEquivalentJavaTimeValues() {
    org.threeten.bp.Duration threetenCommonValue = org.threeten.bp.Duration.ofMillis(123l);
    java.time.Duration javaTimeConvertedValue =
        java.time.Duration.ofMillis(threetenCommonValue.toMillis());
    RetrySettings threetenRetrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelay(threetenCommonValue)
            .setMaxRetryDelay(threetenCommonValue)
            .setInitialRpcTimeout(threetenCommonValue)
            .setMaxRpcTimeout(threetenCommonValue)
            .setTotalTimeout(threetenCommonValue)
            .build();

    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getInitialRetryDelay().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getMaxRetryDelay().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getInitialRpcTimeout().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getMaxRpcTimeout().toMillis());
    assertEquals(
        javaTimeConvertedValue.toMillis(), threetenRetrySettings.getTotalTimeout().toMillis());
  }
}
