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
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import java.util.Set;

/**
 * This settings is just a simple wrapper for {@link BatchingCallSettings} to allow us to add
 * additional functionality. This settings holds the batching thresholds as well as retry
 * configuration.
 *
 * <p>Sample configuration:
 *
 * <pre>{@code
 * BigtableBatchingCallSettings settings = // Default BigtableBatchingCallSettings from the client
 * BigtableBatchingCallSettings customBigtableBatchingCallSettings =
 *     settings
 *         .toBuilder()
 *         .setBatchingSettings(BatchingSettings.newBuilder()...build())
 *         .setRetryableCodes(StatusCode.Code.UNAVAILABLE, ...)
 *         .setRetrySettings(RetrySettings.newBuilder()...build())
 *         .build();
 * }</pre>
 *
 * @see BatchingSettings for batching thresholds explantion.
 * @see RetrySettings for retry configuration.
 */
@BetaApi("This surface is likely to change as the batching surface evolves.")
public final class BigtableBatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT>
    extends UnaryCallSettings<RequestT, ResponseT> {

  private BatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT> batchingCallSettings;

  private BigtableBatchingCallSettings(
      Builder<ElementT, ElementResultT, RequestT, ResponseT> builder) {
    super(builder);
    batchingCallSettings =
        BatchingCallSettings.newBuilder(builder.batchingDescriptor)
            .setBatchingSettings(builder.batchingSettings)
            .setRetrySettings(builder.getRetrySettings())
            .setRetryableCodes(builder.getRetryableCodes())
            .build();
  }

  /** Returns batching settings which contains multiple batch threshold levels. */
  public BatchingSettings getBatchingSettings() {
    return batchingCallSettings.getBatchingSettings();
  }

  /** Returns an adapter that packs and unpacks batching elements */
  @VisibleForTesting
  BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> getBatchingDescriptor() {
    return batchingCallSettings.getBatchingDescriptor();
  }

  @VisibleForTesting
  static <ElementT, ElementResultT, RequestT, ResponseT>
      Builder<ElementT, ElementResultT, RequestT, ResponseT> newBuilder(
          BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor) {
    return new Builder<>(batchingDescriptor);
  }

  /**
   * Get a builder with the same values as this object. See the class documentation of {@link
   * BigtableBatchingCallSettings} for a sample settings configuration.
   */
  @Override
  public final Builder<ElementT, ElementResultT, RequestT, ResponseT> toBuilder() {
    return new Builder<>(this);
  }

  /**
   * A base builder class for {@link BigtableBatchingCallSettings}. See the class documentation of
   * {@link BigtableBatchingCallSettings} for a description of the different values that can be set.
   */
  public static class Builder<ElementT, ElementResultT, RequestT, ResponseT>
      extends UnaryCallSettings.Builder<RequestT, ResponseT> {

    private BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor;
    private BatchingSettings batchingSettings;

    private Builder(
        BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor) {
      this.batchingDescriptor =
          Preconditions.checkNotNull(batchingDescriptor, "batching descriptor cannot be null");
    }

    private Builder(
        BigtableBatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT> settings) {
      super(settings);
      this.batchingDescriptor = settings.getBatchingDescriptor();
      this.batchingSettings = settings.getBatchingSettings();
    }

    /** Sets the batching settings with various thresholds. */
    public Builder<ElementT, ElementResultT, RequestT, ResponseT> setBatchingSettings(
        BatchingSettings batchingSettings) {
      this.batchingSettings = batchingSettings;
      return this;
    }

    /** Returns the {@link BatchingSettings}. */
    public BatchingSettings getBatchingSettings() {
      return batchingSettings;
    }

    /** Sets the rpc failure {@link StatusCode.Code code}, for which retries should be performed. */
    @Override
    public Builder<ElementT, ElementResultT, RequestT, ResponseT> setRetryableCodes(
        StatusCode.Code... codes) {
      super.setRetryableCodes(codes);
      return this;
    }

    /** Sets the rpc failure {@link StatusCode.Code code}, for which retries should be performed. */
    @Override
    public Builder<ElementT, ElementResultT, RequestT, ResponseT> setRetryableCodes(
        Set<StatusCode.Code> retryableCodes) {
      super.setRetryableCodes(retryableCodes);
      return this;
    }

    /** Sets the {@link RetrySettings} values for each retry attempts. */
    @Override
    public Builder<ElementT, ElementResultT, RequestT, ResponseT> setRetrySettings(
        RetrySettings retrySettings) {
      super.setRetrySettings(retrySettings);
      return this;
    }

    /** Builds the {@link BigtableBatchingCallSettings} object with provided configuration. */
    @Override
    public BigtableBatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT> build() {
      return new BigtableBatchingCallSettings<>(this);
    }
  }
}
