/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.rpc;

import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode.Code;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

class ServerStreamingCallSettingsTest {
  @Test
  void retryableCodesAreNotLost() {
    Set<Code> codes = ImmutableSet.of(Code.UNAVAILABLE, Code.RESOURCE_EXHAUSTED);
    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder();
    builder.setRetryableCodes(codes);

    assertThat(builder.getRetryableCodes()).containsExactlyElementsIn(codes);
    assertThat(builder.build().getRetryableCodes()).containsExactlyElementsIn(codes);
    assertThat(builder.build().toBuilder().getRetryableCodes()).containsExactlyElementsIn(codes);
  }

  @Test
  void retryableCodesVarArgs() {
    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder().setRetryableCodes(Code.UNKNOWN, Code.ABORTED);

    assertThat(builder.getRetryableCodes()).containsExactly(Code.UNKNOWN, Code.ABORTED);
  }

  @Test
  void retryableSettingsAreNotLost() {
    RetrySettings retrySettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(5))
            .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRetryDelayMultiplier(2)
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100))
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(200))
            .setRpcTimeoutMultiplier(1.1)
            .setJittered(true)
            .setMaxAttempts(10)
            .build();

    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder();
    builder.setRetrySettings(retrySettings);

    assertThat(builder.getRetrySettings()).isEqualTo(retrySettings);
    assertThat(builder.build().getRetrySettings()).isEqualTo(retrySettings);
    assertThat(builder.build().toBuilder().getRetrySettings()).isEqualTo(retrySettings);
  }

  @Test
  void idleTimeoutIsNotLost() {
    java.time.Duration idleTimeout = java.time.Duration.ofSeconds(5);

    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder();
    builder.setIdleTimeoutDuration(idleTimeout);

    assertThat(builder.getIdleTimeoutDuration()).isEqualTo(idleTimeout);
    assertThat(builder.build().getIdleTimeoutDuration()).isEqualTo(idleTimeout);
    assertThat(builder.build().toBuilder().getIdleTimeoutDuration()).isEqualTo(idleTimeout);
  }

  @Test
  void waitTimeoutIsNotLost() {
    java.time.Duration waitTimeout = java.time.Duration.ofSeconds(5);

    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder();

    builder.setWaitTimeoutDuration(waitTimeout);

    assertThat(builder.getWaitTimeoutDuration()).isEqualTo(waitTimeout);
    assertThat(builder.build().getWaitTimeoutDuration()).isEqualTo(waitTimeout);
    assertThat(builder.build().toBuilder().getWaitTimeoutDuration()).isEqualTo(waitTimeout);
  }

  @Test
  void testRetrySettingsBuilder() {
    RetrySettings initialSettings =
        RetrySettings.newBuilder()
            .setInitialRetryDelayDuration(java.time.Duration.ofMillis(5))
            .setMaxRetryDelayDuration(java.time.Duration.ofSeconds(1))
            .setRetryDelayMultiplier(2)
            .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(100))
            .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(200))
            .setRpcTimeoutMultiplier(1.1)
            .setJittered(true)
            .setMaxAttempts(10)
            .build();

    ServerStreamingCallSettings.Builder<Object, Object> builder =
        ServerStreamingCallSettings.newBuilder().setRetrySettings(initialSettings);

    builder.retrySettings().setMaxRetryDelayDuration(java.time.Duration.ofMinutes(1));

    assertThat(builder.getRetrySettings().getMaxRetryDelayDuration())
        .isEqualTo(java.time.Duration.ofMinutes(1));
    assertThat(builder.build().getRetrySettings().getMaxRetryDelayDuration())
        .isEqualTo(java.time.Duration.ofMinutes(1));
  }

  @Test
  void testToString() {
    RetrySettings retrySettings = RetrySettings.newBuilder().build();
    Set<StatusCode.Code> retryableCodes = ImmutableSet.of(StatusCode.Code.DEADLINE_EXCEEDED);
    java.time.Duration idleTime = java.time.Duration.ofSeconds(100);
    ServerStreamingCallSettings serverCallSettings =
        ServerStreamingCallSettings.newBuilder()
            .setRetrySettings(retrySettings)
            .setRetryableCodes(retryableCodes)
            .setIdleTimeoutDuration(idleTime)
            .build();
    assertThat(serverCallSettings.toString()).contains("idleTimeout=" + idleTime);
    assertThat(serverCallSettings.toString()).contains("retryableCodes=" + retryableCodes);
    assertThat(serverCallSettings.toString()).contains("retrySettings=" + retrySettings);
  }

  @Test
  public void testIdleTimeout_backportMethodsBehaveCorrectly() {
    final ServerStreamingCallSettings.Builder builder = ServerStreamingCallSettings.newBuilder();
    testDurationMethod(
        123l,
        jt -> builder.setIdleTimeoutDuration(jt).build(),
        tt -> builder.setIdleTimeout(tt).build(),
        cs -> cs.getIdleTimeoutDuration(),
        cs -> cs.getIdleTimeout());
  }

  @Test
  public void testWaitTimeout_backportMethodsBehaveCorrectly() {
    final ServerStreamingCallSettings.Builder builder = ServerStreamingCallSettings.newBuilder();
    testDurationMethod(
        123l,
        jt -> builder.setWaitTimeoutDuration(jt).build(),
        tt -> builder.setWaitTimeout(tt).build(),
        cs -> cs.getWaitTimeoutDuration(),
        cs -> cs.getWaitTimeout());
  }
}
