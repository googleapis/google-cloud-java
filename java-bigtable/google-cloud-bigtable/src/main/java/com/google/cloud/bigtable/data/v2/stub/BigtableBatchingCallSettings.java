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

import com.google.api.core.BetaApi;
import com.google.api.gax.batching.BatchingCallSettings;
import com.google.api.gax.batching.BatchingDescriptor;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.DynamicFlowControlSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.bigtable.data.v2.models.BulkMutation;
import com.google.cloud.bigtable.data.v2.models.RowMutationEntry;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * This settings holds the batching thresholds as well as retry configuration.
 *
 * <p>Sample configuration:
 *
 * <pre>{@code
 * BigtableBatchingCallSettings defaultBatchingCallSettings =
 *     bigtableDataCallSettings.getStubSettings().bulkMutateRowsSettings();
 *
 * BigtableBatchingCallSettings customBatchingCallSettings = defaultBatchingCallSettings.toBuilder()
 *     .setBatchingSettings(
 *         defaultBatchingCallSettings.getBatchingSettings().toBuilder()
 *             .setDelayThreshold(Duration.ofSeconds(10))
 *             .build())
 *     .setRetryableCodes(Code.DEADLINE_EXCEEDED)
 *     .setLatencyBasedThrottling(true, 1000L)
 *     .build();
 * }</pre>
 *
 * @see BatchingSettings for batching thresholds explantion.
 * @see RetrySettings for retry configuration.
 */
@BetaApi("This surface is likely to change as the batching surface evolves.")
public final class BigtableBatchingCallSettings extends UnaryCallSettings<BulkMutation, Void> {

  // This settings is just a simple wrapper for BatchingCallSettings to allow us to add
  // additional functionality.
  private final BatchingCallSettings<RowMutationEntry, Void, BulkMutation, Void>
      batchingCallSettings;
  private final boolean isLatencyBasedThrottlingEnabled;
  private final Long targetRpcLatencyMs;
  private final DynamicFlowControlSettings dynamicFlowControlSettings;

  private BigtableBatchingCallSettings(Builder builder) {
    super(builder);
    batchingCallSettings =
        BatchingCallSettings.newBuilder(builder.batchingDescriptor)
            .setBatchingSettings(builder.batchingSettings)
            .setRetrySettings(builder.getRetrySettings())
            .setRetryableCodes(builder.getRetryableCodes())
            .build();
    this.isLatencyBasedThrottlingEnabled = builder.isLatencyBasedThrottlingEnabled;
    this.targetRpcLatencyMs = builder.targetRpcLatencyMs;
    this.dynamicFlowControlSettings = builder.dynamicFlowControlSettings;
  }

  /** Returns batching settings which contains multiple batch threshold levels. */
  public BatchingSettings getBatchingSettings() {
    return batchingCallSettings.getBatchingSettings();
  }

  /** Returns an adapter that packs and unpacks batching elements. */
  BatchingDescriptor<RowMutationEntry, Void, BulkMutation, Void> getBatchingDescriptor() {
    return batchingCallSettings.getBatchingDescriptor();
  }

  /** Gets if latency based throttling is enabled. */
  public boolean isLatencyBasedThrottlingEnabled() {
    return isLatencyBasedThrottlingEnabled;
  }

  /** Gets target rpc latency if latency based throttling is enabled. Otherwise returns null. */
  @Nullable
  public Long getTargetRpcLatencyMs() {
    return targetRpcLatencyMs;
  }

  /**
   * Gets {@link DynamicFlowControlSettings}.
   *
   * @see Builder#getDynamicFlowControlSettings()
   */
  DynamicFlowControlSettings getDynamicFlowControlSettings() {
    return dynamicFlowControlSettings;
  }

  static Builder newBuilder(
      BatchingDescriptor<RowMutationEntry, Void, BulkMutation, Void> batchingDescriptor) {
    return new Builder(batchingDescriptor);
  }

  /**
   * Get a builder with the same values as this object. See the class documentation of {@link
   * BigtableBatchingCallSettings} for a sample settings configuration.
   */
  @Override
  public final Builder toBuilder() {
    return new Builder(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("batchingCallSettings", batchingCallSettings)
        .add("isLatencyBasedThrottlingEnabled", isLatencyBasedThrottlingEnabled)
        .add("targetRpcLatency", targetRpcLatencyMs)
        .add("dynamicFlowControlSettings", dynamicFlowControlSettings)
        .toString();
  }

  /**
   * A base builder class for {@link BigtableBatchingCallSettings}. See the class documentation of
   * {@link BigtableBatchingCallSettings} for a description of the different values that can be set.
   */
  public static class Builder extends UnaryCallSettings.Builder<BulkMutation, Void> {

    private BatchingDescriptor<RowMutationEntry, Void, BulkMutation, Void> batchingDescriptor;
    private BatchingSettings batchingSettings;
    private boolean isLatencyBasedThrottlingEnabled;
    private Long targetRpcLatencyMs;
    private DynamicFlowControlSettings dynamicFlowControlSettings;

    private Builder(
        @Nonnull
            BatchingDescriptor<RowMutationEntry, Void, BulkMutation, Void> batchingDescriptor) {
      this.batchingDescriptor =
          Preconditions.checkNotNull(batchingDescriptor, "batching descriptor can't be null");
    }

    private Builder(@Nonnull BigtableBatchingCallSettings settings) {
      super(settings);
      this.batchingDescriptor = settings.getBatchingDescriptor();
      this.batchingSettings = settings.getBatchingSettings();
      this.isLatencyBasedThrottlingEnabled = settings.isLatencyBasedThrottlingEnabled();
      this.targetRpcLatencyMs = settings.getTargetRpcLatencyMs();
      this.dynamicFlowControlSettings = settings.getDynamicFlowControlSettings();
    }

    /** Sets the batching settings with various thresholds. */
    public Builder setBatchingSettings(@Nonnull BatchingSettings batchingSettings) {
      Preconditions.checkNotNull(batchingSettings, "batching settings can't be null");
      this.batchingSettings = batchingSettings;
      return this;
    }

    /** Returns the {@link BatchingSettings}. */
    public BatchingSettings getBatchingSettings() {
      return batchingSettings;
    }

    /** Sets the rpc failure {@link StatusCode.Code code}, for which retries should be performed. */
    @Override
    public Builder setRetryableCodes(StatusCode.Code... codes) {
      super.setRetryableCodes(codes);
      return this;
    }

    /** Sets the rpc failure {@link StatusCode.Code code}, for which retries should be performed. */
    @Override
    public Builder setRetryableCodes(Set<StatusCode.Code> retryableCodes) {
      super.setRetryableCodes(retryableCodes);
      return this;
    }

    /** Sets the {@link RetrySettings} values for each retry attempts. */
    @Override
    public Builder setRetrySettings(@Nonnull RetrySettings retrySettings) {
      super.setRetrySettings(retrySettings);
      return this;
    }

    /**
     * Enable latency based throttling. The number of allowed in-flight requests will be adjusted to
     * reach the target rpc latency.
     */
    public Builder enableLatencyBasedThrottling(long targetRpcLatency) {
      Preconditions.checkArgument(
          targetRpcLatency > 0, "target RPC latency must be greater than 0");
      this.isLatencyBasedThrottlingEnabled = true;
      this.targetRpcLatencyMs = targetRpcLatency;
      return this;
    }

    /** Disable latency based throttling. */
    public Builder disableLatencyBasedThrottling() {
      this.isLatencyBasedThrottlingEnabled = false;
      this.targetRpcLatencyMs = null;
      return this;
    }

    /** Gets target rpc latency if latency based throttling is enabled. Otherwise returns null. */
    @Nullable
    public Long getTargetRpcLatencyMs() {
      return isLatencyBasedThrottlingEnabled ? targetRpcLatencyMs : null;
    }

    /** Gets if latency based throttling is enabled. */
    public boolean isLatencyBasedThrottlingEnabled() {
      return this.isLatencyBasedThrottlingEnabled;
    }

    /**
     * Gets the {@link DynamicFlowControlSettings} that'll be used to set up a {@link
     * FlowController} for throttling.
     *
     * <p>By default, this will allow a maximum of 1000 entries per channel of {@link
     * FlowControlSettings.Builder#setMaxOutstandingElementCount request count} and 100MB of {@link
     * FlowControlSettings.Builder#setMaxOutstandingRequestBytes accumulated size} in-flight
     * requests. Once the limits are reached, pending operations will by default be {@link
     * FlowControlSettings.Builder#setLimitExceededBehavior blocked} until some of the in-flight
     * requests are resolved.
     *
     * <p>If latency based throttling is enabled, number of entries allowed by {@link
     * FlowController} will be adjusted to reach {@link Builder#getTargetRpcLatencyMs()}.
     *
     * <ul>
     *   <li>{@link FlowController} will be set to allow Math.max({@link BatchingSettings.Builder
     *       #setElementCountThreshold batch size}, {@link
     *       FlowControlSettings.Builder#setMaxOutstandingElementCount request count} / 4) entries
     *       to start with.
     *   <li>If bulk mutation rpc latency is higher than target latency, decrease allowed entries to
     *       a minimum of Math.max({@link BatchingSettings.Builder#setElementCountThreshold batch
     *       size}, {@link FlowControlSettings.Builder#setMaxOutstandingElementCount request count}
     *       / 100).
     *   <li>If bulk mutation rpc latency is lower than target latency and there was throttling,
     *       increase allowed entries to a maximum of {@link
     *       FlowControlSettings.Builder#setMaxOutstandingElementCount request count}.
     * </ul>
     *
     * If latency based throttling is disabled, {@link FlowController} will always allow {@link
     * FlowControlSettings.Builder#setMaxOutstandingElementCount request count}.
     *
     * <p>Latency based throttling only updates outstanding entries count. {@link FlowController}
     * will always allow {@link FlowControlSettings.Builder#setMaxOutstandingRequestBytes
     * accumulated size}.
     */
    DynamicFlowControlSettings getDynamicFlowControlSettings() {
      return this.dynamicFlowControlSettings;
    }

    /** Builds the {@link BigtableBatchingCallSettings} object with provided configuration. */
    @Override
    public BigtableBatchingCallSettings build() {
      Preconditions.checkState(batchingSettings != null, "batchingSettings must be set");
      FlowControlSettings defaultSettings = batchingSettings.getFlowControlSettings();
      Preconditions.checkState(
          defaultSettings.getMaxOutstandingElementCount() != null,
          "maxOutstandingElementCount must be set in BatchingSettings#FlowControlSettings");
      Preconditions.checkState(
          defaultSettings.getMaxOutstandingRequestBytes() != null,
          "maxOutstandingRequestBytes must be set in BatchingSettings#FlowControlSettings");
      Preconditions.checkArgument(
          batchingSettings.getElementCountThreshold() == null
              || defaultSettings.getMaxOutstandingElementCount()
                  >= batchingSettings.getElementCountThreshold(),
          "if elementCountThreshold is set in BatchingSettings, maxOutstandingElementCount must be >= elementCountThreshold");
      Preconditions.checkArgument(
          batchingSettings.getRequestByteThreshold() == null
              || defaultSettings.getMaxOutstandingRequestBytes()
                  >= batchingSettings.getRequestByteThreshold(),
          "if requestByteThreshold is set in BatchingSettings, getMaxOutstandingRequestBytes must be >= getRequestByteThreshold");
      // Combine static FlowControlSettings with latency based throttling settings to create
      // DynamicFlowControlSettings.
      if (isLatencyBasedThrottlingEnabled()) {
        long maxThrottlingElementCount = defaultSettings.getMaxOutstandingElementCount();
        long maxThrottlingRequestByteCount = defaultSettings.getMaxOutstandingRequestBytes();
        //  The maximum in flight element count is pretty high. Set the initial parallelism to 25%
        //  of the maximum and then work up or down. This reduction should reduce the
        // impacts of a bursty job, such as those found in Dataflow.
        long initialElementCount = maxThrottlingElementCount / 4;
        // Decreases are floored at 1% of the maximum so that there is some level of
        // throughput.
        long minElementCount = maxThrottlingElementCount / 100;
        // Make sure initialOutstandingElementCount and minOutstandingElementCount element count are
        // greater or equal to batch size to avoid deadlocks.
        if (batchingSettings.getElementCountThreshold() != null) {
          initialElementCount =
              Math.max(initialElementCount, batchingSettings.getElementCountThreshold());
          minElementCount = Math.max(minElementCount, batchingSettings.getElementCountThreshold());
        }
        dynamicFlowControlSettings =
            DynamicFlowControlSettings.newBuilder()
                .setLimitExceededBehavior(defaultSettings.getLimitExceededBehavior())
                .setInitialOutstandingElementCount(initialElementCount)
                .setMaxOutstandingElementCount(maxThrottlingElementCount)
                .setMinOutstandingElementCount(minElementCount)
                .setInitialOutstandingRequestBytes(maxThrottlingRequestByteCount)
                .setMinOutstandingRequestBytes(maxThrottlingRequestByteCount)
                .setMaxOutstandingRequestBytes(maxThrottlingRequestByteCount)
                .build();
      } else {
        dynamicFlowControlSettings =
            DynamicFlowControlSettings.newBuilder()
                .setLimitExceededBehavior(defaultSettings.getLimitExceededBehavior())
                .setInitialOutstandingElementCount(defaultSettings.getMaxOutstandingElementCount())
                .setMaxOutstandingElementCount(defaultSettings.getMaxOutstandingElementCount())
                .setMinOutstandingElementCount(defaultSettings.getMaxOutstandingElementCount())
                .setInitialOutstandingRequestBytes(defaultSettings.getMaxOutstandingRequestBytes())
                .setMinOutstandingRequestBytes(defaultSettings.getMaxOutstandingRequestBytes())
                .setMaxOutstandingRequestBytes(defaultSettings.getMaxOutstandingRequestBytes())
                .build();
      }
      return new BigtableBatchingCallSettings(this);
    }
  }
}
