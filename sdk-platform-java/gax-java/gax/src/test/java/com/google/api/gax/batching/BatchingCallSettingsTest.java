/*
 * Copyright 2019 Google LLC
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

import static com.google.api.gax.rpc.testing.FakeBatchableApi.SQUARER_BATCHING_DESC_V2;
import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.testing.FakeBatchableApi.LabeledIntList;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

class BatchingCallSettingsTest {

  private static final BatchingSettings BATCHING_SETTINGS =
      BatchingSettings.newBuilder()
          .setElementCountThreshold(10L)
          .setRequestByteThreshold(20L)
          .setDelayThresholdDuration(java.time.Duration.ofMillis(5))
          .setFlowControlSettings(
              FlowControlSettings.newBuilder()
                  .setMaxOutstandingElementCount(100L)
                  .setMaxOutstandingRequestBytes(100L)
                  .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                  .build())
          .build();

  @Test
  void testEmptyBuilder() {
    BatchingCallSettings.Builder<Integer, Integer, LabeledIntList, List<Integer>> builder =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC_V2);
    assertThat(builder.getBatchingSettings()).isNull();
    assertThat(builder.getRetryableCodes()).isEmpty();
    assertThat(builder.getRetrySettings()).isNotNull();
  }

  @Test
  void testBuilder() {
    BatchingCallSettings.Builder<Integer, Integer, LabeledIntList, List<Integer>> builder =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC_V2);

    Set<StatusCode.Code> retryCodes = ImmutableSet.of(StatusCode.Code.UNAVAILABLE);
    RetrySettings retrySettings = RetrySettings.newBuilder().build();
    builder
        .setBatchingSettings(BATCHING_SETTINGS)
        .setRetryableCodes(retryCodes)
        .setRetrySettings(retrySettings);

    BatchingCallSettings settings = builder.build();
    assertThat(settings.getBatchingSettings()).isEqualTo(BATCHING_SETTINGS);
    assertThat(settings.getRetryableCodes()).isEqualTo(retryCodes);
    assertThat(settings.getRetrySettings()).isEqualTo(retrySettings);
  }

  @Test
  void testBuilderFromSettings() {
    BatchingCallSettings.Builder<Integer, Integer, LabeledIntList, List<Integer>> builder =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC_V2);
    RetrySettings retrySettings =
        RetrySettings.newBuilder().setTotalTimeoutDuration(java.time.Duration.ofMinutes(1)).build();
    builder
        .setBatchingSettings(BATCHING_SETTINGS)
        .setRetryableCodes(StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNAUTHENTICATED)
        .setRetrySettings(retrySettings);

    BatchingCallSettings settings = builder.build();
    BatchingCallSettings.Builder newBuilder = settings.toBuilder();

    assertThat(newBuilder.getBatchingSettings()).isEqualTo(BATCHING_SETTINGS);
    assertThat(newBuilder.getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNAUTHENTICATED);
    assertThat(newBuilder.getRetrySettings()).isEqualTo(retrySettings);
  }

  @Test
  void testMandatorySettings() {
    Exception actualEx = null;
    try {
      BatchingCallSettings.newBuilder(null);
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(NullPointerException.class);
    actualEx = null;
    try {
      BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC_V2).build();
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(IllegalStateException.class);
  }

  @Test
  void testToString() {
    RetrySettings retrySettings = RetrySettings.newBuilder().build();
    Set<StatusCode.Code> retryCodes = ImmutableSet.of(StatusCode.Code.UNAUTHENTICATED);
    BatchingCallSettings<Integer, Integer, LabeledIntList, List<Integer>> batchingCallSettings =
        BatchingCallSettings.newBuilder(SQUARER_BATCHING_DESC_V2)
            .setRetryableCodes(retryCodes)
            .setRetrySettings(retrySettings)
            .setBatchingSettings(BATCHING_SETTINGS)
            .build();

    assertThat(batchingCallSettings.toString()).contains("retryableCodes=" + retryCodes);
    assertThat(batchingCallSettings.toString()).contains("retrySettings=" + retrySettings);
    assertThat(batchingCallSettings.toString()).contains("batchingSettings=" + BATCHING_SETTINGS);
  }
}
