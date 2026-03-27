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

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import java.util.Set;

/**
 * This is an extension of {@link UnaryCallSettings} class to configure a {@link UnaryCallable} for
 * calls to an API method that supports batching. The batching settings are provided using the
 * instance of {@link BatchingSettings}.
 *
 * <p>Retry configuration will be applied on each batching RPC request.
 *
 * <p>Sample settings configuration:
 *
 * <pre>{@code
 * BatchingCallSettings batchingCallSettings = // Default BatchingCallSettings from the client
 * BatchingCallSettings customBatchingCallSettings =
 *     batchingCallSettings
 *         .toBuilder()
 *         .setRetryableCodes(StatusCode.Code.UNAVAILABLE, ...)
 *         .setRetrySettings(RetrySettings.newBuilder()...build())
 *         .setBatchingSettings(BatchingSettings.newBuilder()...build())
 *         .build();
 * }</pre>
 *
 * @param <ElementT> The type of each individual element to be batched.
 * @param <ElementResultT> The type of the result for each individual element.
 * @param <RequestT> The type of the request that will contain the accumulated elements.
 * @param <ResponseT> The type of the response that will unpack into individual element results.
 */
public final class BatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT>
    extends UnaryCallSettings<RequestT, ResponseT> {
  private final BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT>
      batchingDescriptor;
  private final BatchingSettings batchingSettings;

  @InternalApi("For google-cloud-java client use only")
  public BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> getBatchingDescriptor() {
    return batchingDescriptor;
  }

  /** Returns batching settings which contains multiple batch threshold levels. */
  public BatchingSettings getBatchingSettings() {
    return batchingSettings;
  }

  private BatchingCallSettings(Builder<ElementT, ElementResultT, RequestT, ResponseT> builder) {
    super(builder);
    Preconditions.checkState(builder.batchingSettings != null, "batching settings cannot be null");
    this.batchingDescriptor = builder.batchingDescriptor;
    this.batchingSettings = builder.batchingSettings;
  }

  /** Please use {@link #toBuilder()} to override settings values. */
  @InternalApi("For google-cloud-java client use only")
  public static <ElementT, ElementResultT, RequestT, ResponseT>
      Builder<ElementT, ElementResultT, RequestT, ResponseT> newBuilder(
          BatchingDescriptor<ElementT, ElementResultT, RequestT, ResponseT> batchingDescriptor) {
    return new Builder<>(batchingDescriptor);
  }

  /**
   * Get a builder with the same values as this object. See the class documentation of {@link
   * BatchingCallSettings} for a sample settings configuration.
   */
  @Override
  public final Builder<ElementT, ElementResultT, RequestT, ResponseT> toBuilder() {
    return new Builder<>(this);
  }

  @Override
  public String toString() {
    return MoreObjects.toStringHelper(this)
        .add("retryableCodes", getRetryableCodes())
        .add("retrySettings", getRetrySettings())
        .add("batchingSettings", batchingSettings)
        .toString();
  }

  /**
   * A base builder class for {@link BatchingCallSettings}. See the class documentation of {@link
   * BatchingCallSettings} for a description of the different values that can be set.
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

    private Builder(BatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT> settings) {
      super(settings);
      this.batchingDescriptor = settings.batchingDescriptor;
      this.batchingSettings = settings.batchingSettings;
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

    /** Builds the {@link BatchingCallSettings} object with provided configuration. */
    @Override
    public BatchingCallSettings<ElementT, ElementResultT, RequestT, ResponseT> build() {
      return new BatchingCallSettings<>(this);
    }
  }
}
