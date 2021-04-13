/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.data.v2.stub;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.DynamicFlowControlSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.cloud.bigtable.data.v2.stub.mutaterows.MutateRowsBatchingDescriptor;
import com.google.common.collect.ImmutableSet;
import java.util.Set;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.threeten.bp.Duration;

@RunWith(JUnit4.class)
public class BigtableBatchingCallSettingsTest {

  private static final BatchingSettings BATCHING_SETTINGS =
      BatchingSettings.newBuilder()
          .setElementCountThreshold(10L)
          .setRequestByteThreshold(20L)
          .setDelayThreshold(Duration.ofMillis(5))
          .setFlowControlSettings(
              FlowControlSettings.newBuilder()
                  .setMaxOutstandingElementCount(100L)
                  .setMaxOutstandingRequestBytes(100L)
                  .setLimitExceededBehavior(FlowController.LimitExceededBehavior.Block)
                  .build())
          .build();

  @Test
  public void testEmptyBuilder() {
    BigtableBatchingCallSettings.Builder builder =
        BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor());
    assertThat(builder.getBatchingSettings()).isNull();
    assertThat(builder.getRetryableCodes()).isEmpty();
    assertThat(builder.getRetrySettings()).isNotNull();
    assertThat(builder.isLatencyBasedThrottlingEnabled()).isFalse();
    assertThat(builder.getTargetRpcLatencyMs()).isNull();
    assertThat(builder.getDynamicFlowControlSettings()).isNull();
  }

  @Test
  public void testBuilder() {
    BigtableBatchingCallSettings.Builder builder =
        BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor());

    Set<StatusCode.Code> retryCodes = ImmutableSet.of(StatusCode.Code.UNAVAILABLE);
    RetrySettings retrySettings = RetrySettings.newBuilder().build();
    builder
        .setBatchingSettings(BATCHING_SETTINGS)
        .setRetryableCodes(retryCodes)
        .setRetrySettings(retrySettings);

    BigtableBatchingCallSettings settings = builder.build();
    assertThat(settings.getBatchingSettings()).isEqualTo(BATCHING_SETTINGS);
    assertThat(settings.getRetryableCodes()).isEqualTo(retryCodes);
    assertThat(settings.getRetrySettings()).isEqualTo(retrySettings);
    assertThat(settings.isLatencyBasedThrottlingEnabled()).isFalse();
    assertThat(settings.getTargetRpcLatencyMs()).isNull();
    assertThat(settings.getDynamicFlowControlSettings()).isNotNull();
    verifyFlowControlSettingWhenLatencyBasedThrottlingDisabled(
        settings.getDynamicFlowControlSettings());

    builder.enableLatencyBasedThrottling(10L);
    settings = builder.build();
    assertThat(settings.isLatencyBasedThrottlingEnabled()).isTrue();
    assertThat(settings.getTargetRpcLatencyMs()).isEqualTo(10);
    assertThat(settings.getDynamicFlowControlSettings()).isNotNull();
    verifyFlowControlSettingWhenLatencyBasedThrottlingEnabled(
        settings.getDynamicFlowControlSettings());

    builder.disableLatencyBasedThrottling();
    settings = builder.build();
    assertThat(settings.isLatencyBasedThrottlingEnabled()).isFalse();
    assertThat(settings.getTargetRpcLatencyMs()).isNull();
    assertThat(settings.getDynamicFlowControlSettings()).isNotNull();
    verifyFlowControlSettingWhenLatencyBasedThrottlingDisabled(
        settings.getDynamicFlowControlSettings());
  }

  @Test
  public void testBuilderFromSettings() {
    BigtableBatchingCallSettings.Builder builder =
        BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor());
    RetrySettings retrySettings =
        RetrySettings.newBuilder().setTotalTimeout(Duration.ofMinutes(1)).build();
    builder
        .setBatchingSettings(BATCHING_SETTINGS)
        .setRetryableCodes(StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNAUTHENTICATED)
        .setRetrySettings(retrySettings)
        .enableLatencyBasedThrottling(10L);

    BigtableBatchingCallSettings settings = builder.build();
    BigtableBatchingCallSettings.Builder newBuilder = settings.toBuilder();

    assertThat(newBuilder.getBatchingSettings()).isEqualTo(BATCHING_SETTINGS);
    assertThat(newBuilder.getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE, StatusCode.Code.UNAUTHENTICATED);
    assertThat(newBuilder.getRetrySettings()).isEqualTo(retrySettings);
    assertThat(newBuilder.isLatencyBasedThrottlingEnabled()).isTrue();
    assertThat(newBuilder.getTargetRpcLatencyMs()).isEqualTo(10L);
    assertThat(newBuilder.getDynamicFlowControlSettings()).isNotNull();
    verifyFlowControlSettingWhenLatencyBasedThrottlingEnabled(
        newBuilder.getDynamicFlowControlSettings());
  }

  @Test
  public void testMandatorySettings() {
    Exception actualEx = null;
    try {
      BigtableBatchingCallSettings.newBuilder(null);
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(NullPointerException.class);
    actualEx = null;
    try {
      BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor()).build();
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(IllegalStateException.class);
  }

  @Test
  public void testFlowControlMandatorySettings() {
    Exception actualEx = null;
    try {
      BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
          .setBatchingSettings(
              BatchingSettings.newBuilder()
                  .setFlowControlSettings(
                      FlowControlSettings.newBuilder()
                          .setMaxOutstandingElementCount(null)
                          .setMaxOutstandingRequestBytes(null)
                          .build())
                  .build())
          .build();
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(IllegalStateException.class);

    BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
        .setBatchingSettings(
            BatchingSettings.newBuilder()
                .setFlowControlSettings(
                    FlowControlSettings.newBuilder()
                        .setMaxOutstandingElementCount(10L)
                        .setMaxOutstandingRequestBytes(10L)
                        .build())
                .setElementCountThreshold(10L)
                .setRequestByteThreshold(10L)
                .build())
        .build();

    actualEx = null;
    try {
      BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
          .setBatchingSettings(
              BatchingSettings.newBuilder()
                  .setFlowControlSettings(
                      FlowControlSettings.newBuilder()
                          .setMaxOutstandingElementCount(10L)
                          .setMaxOutstandingRequestBytes(5L)
                          .build())
                  .setElementCountThreshold(10L)
                  .setRequestByteThreshold(10L)
                  .build())
          .build();
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(IllegalArgumentException.class);

    actualEx = null;
    try {
      BigtableBatchingCallSettings.newBuilder(new MutateRowsBatchingDescriptor())
          .setBatchingSettings(
              BatchingSettings.newBuilder()
                  .setFlowControlSettings(
                      FlowControlSettings.newBuilder()
                          .setMaxOutstandingElementCount(5L)
                          .setMaxOutstandingRequestBytes(10L)
                          .build())
                  .setElementCountThreshold(10L)
                  .setRequestByteThreshold(10L)
                  .build())
          .build();
    } catch (Exception ex) {
      actualEx = ex;
    }
    assertThat(actualEx).isInstanceOf(IllegalArgumentException.class);
  }

  private void verifyFlowControlSettingWhenLatencyBasedThrottlingDisabled(
      DynamicFlowControlSettings settings) {
    assertThat(settings.getInitialOutstandingElementCount())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingElementCount());
    assertThat(settings.getMaxOutstandingElementCount())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingElementCount());
    assertThat(settings.getMinOutstandingElementCount())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingElementCount());
    assertThat(settings.getInitialOutstandingRequestBytes())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingRequestBytes());
    assertThat(settings.getMaxOutstandingRequestBytes())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingRequestBytes());
    assertThat(settings.getMinOutstandingRequestBytes())
        .isEqualTo(BATCHING_SETTINGS.getFlowControlSettings().getMaxOutstandingRequestBytes());
  }

  private void verifyFlowControlSettingWhenLatencyBasedThrottlingEnabled(
      DynamicFlowControlSettings settings) {
    assertThat(settings.getInitialOutstandingElementCount())
        .isLessThan(settings.getMaxOutstandingElementCount());
    assertThat(settings.getMinOutstandingElementCount())
        .isLessThan(settings.getMaxOutstandingElementCount());
    assertThat(settings.getInitialOutstandingRequestBytes())
        .isEqualTo(settings.getMaxOutstandingRequestBytes());
    assertThat(settings.getMinOutstandingRequestBytes())
        .isEqualTo(settings.getMaxOutstandingRequestBytes());
  }
}
