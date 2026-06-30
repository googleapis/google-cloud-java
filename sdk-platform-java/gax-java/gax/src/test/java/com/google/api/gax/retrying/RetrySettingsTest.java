/*
 * Copyright 2021 Google LLC
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

import com.google.common.truth.Truth;
import org.junit.jupiter.api.Test;

class RetrySettingsTest {
  private static final RetrySettings.Builder DEFAULT_BUILDER =
      RetrySettings.newBuilder()
          .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(5000l))
          .setMaxRetryDelayDuration(java.time.Duration.ofMillis(5000l));

  @Test
  void retrySettingsSetLogicalTimeout() {
    java.time.Duration timeout = java.time.Duration.ofMillis(60000);
    RetrySettings retrySettings = RetrySettings.newBuilder().setLogicalTimeout(timeout).build();

    Truth.assertThat(retrySettings.getRpcTimeoutMultiplier()).isEqualTo(1);
    Truth.assertThat(retrySettings.getInitialRpcTimeoutDuration()).isEqualTo(timeout);
    Truth.assertThat(retrySettings.getMaxRpcTimeoutDuration()).isEqualTo(timeout);
    Truth.assertThat(retrySettings.getTotalTimeoutDuration()).isEqualTo(timeout);
  }

  @Test
  void retrySettingsMerge() {
    RetrySettings.Builder builder =
        RetrySettings.newBuilder()
            .setTotalTimeoutDuration(java.time.Duration.ofMillis(45000))
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(2000))
            .setRpcTimeoutMultiplier(1.5)
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(30000))
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100))
            .setRetryDelayMultiplier(1.2)
            .setMaxRetryDelayDuration(java.time.Duration.ofMillis(1000));
    RetrySettings.Builder mergedBuilder = RetrySettings.newBuilder();
    mergedBuilder.merge(builder);

    RetrySettings settingsA = builder.build();
    RetrySettings settingsB = mergedBuilder.build();

    Truth.assertThat(settingsA.getTotalTimeoutDuration())
        .isEqualTo(settingsB.getTotalTimeoutDuration());
    Truth.assertThat(settingsA.getInitialRetryDelayDuration())
        .isEqualTo(settingsB.getInitialRetryDelayDuration());
    Truth.assertThat(settingsA.getRpcTimeoutMultiplier())
        .isWithin(0)
        .of(settingsB.getRpcTimeoutMultiplier());
    Truth.assertThat(settingsA.getMaxRpcTimeoutDuration())
        .isEqualTo(settingsB.getMaxRpcTimeoutDuration());
    Truth.assertThat(settingsA.getInitialRetryDelayDuration())
        .isEqualTo(settingsB.getInitialRetryDelayDuration());
    Truth.assertThat(settingsA.getRetryDelayMultiplier())
        .isWithin(0)
        .of(settingsB.getRetryDelayMultiplier());
    Truth.assertThat(settingsA.getMaxRetryDelayDuration())
        .isEqualTo(settingsB.getMaxRetryDelayDuration());
  }

  @Test
  public void testTotalTimeout() {
    testDurationMethod(
        123l,
        jt -> DEFAULT_BUILDER.setTotalTimeoutDuration(jt).build(),
        tt -> DEFAULT_BUILDER.setTotalTimeout(tt).build(),
        rs -> rs.getTotalTimeoutDuration(),
        rs -> rs.getTotalTimeout());
  }

  @Test
  public void testInitialRetryDelay() {
    testDurationMethod(
        123l,
        jt -> DEFAULT_BUILDER.setInitialRetryDelayDuration(jt).build(),
        tt -> DEFAULT_BUILDER.setInitialRetryDelay(tt).build(),
        rs -> rs.getInitialRetryDelayDuration(),
        rs -> rs.getInitialRetryDelay());
  }

  @Test
  public void testMaxRetryDelay() {
    testDurationMethod(
        123l,
        jt -> DEFAULT_BUILDER.setMaxRetryDelayDuration(jt).build(),
        tt -> DEFAULT_BUILDER.setMaxRetryDelay(tt).build(),
        rs -> rs.getMaxRetryDelayDuration(),
        rs -> rs.getMaxRetryDelay());
  }

  @Test
  public void testInitialRpcTimeout() {
    testDurationMethod(
        123l,
        jt -> DEFAULT_BUILDER.setInitialRpcTimeoutDuration(jt).build(),
        tt -> DEFAULT_BUILDER.setInitialRpcTimeout(tt).build(),
        rs -> rs.getInitialRpcTimeoutDuration(),
        rs -> rs.getInitialRpcTimeout());
  }

  @Test
  public void testMaxRpcTimeout() {
    testDurationMethod(
        123l,
        jt -> DEFAULT_BUILDER.setMaxRpcTimeoutDuration(jt).build(),
        tt -> DEFAULT_BUILDER.setMaxRpcTimeout(tt).build(),
        rs -> rs.getMaxRpcTimeoutDuration(),
        rs -> rs.getMaxRpcTimeout());
  }
}
