/*
 * Copyright 2016 Google LLC
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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.core.ApiFunction;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.retrying.TimedRetryAlgorithm;

/**
 * A settings class to configure an {@link OperationCallable} for calls to initiate, resume, and
 * cancel a long-running operation.
 */
public final class OperationCallSettings<RequestT, ResponseT, MetadataT> {
  private final UnaryCallSettings<RequestT, OperationSnapshot> initialCallSettings;
  private final TimedRetryAlgorithm pollingAlgorithm;
  private final ApiFunction<OperationSnapshot, ResponseT> responseTransformer;
  private final ApiFunction<OperationSnapshot, MetadataT> metadataTransformer;

  public final UnaryCallSettings<RequestT, OperationSnapshot> getInitialCallSettings() {
    return initialCallSettings;
  }

  public final TimedRetryAlgorithm getPollingAlgorithm() {
    return pollingAlgorithm;
  }

  public final ApiFunction<OperationSnapshot, ResponseT> getResponseTransformer() {
    return responseTransformer;
  }

  public final ApiFunction<OperationSnapshot, MetadataT> getMetadataTransformer() {
    return metadataTransformer;
  }

  private OperationCallSettings(
      UnaryCallSettings<RequestT, OperationSnapshot> initialCallSettings,
      TimedRetryAlgorithm pollingAlgorithm,
      ApiFunction<OperationSnapshot, ResponseT> responseTransformer,
      ApiFunction<OperationSnapshot, MetadataT> metadataTransformer) {
    this.initialCallSettings = checkNotNull(initialCallSettings);
    this.pollingAlgorithm = checkNotNull(pollingAlgorithm);
    this.responseTransformer = checkNotNull(responseTransformer);
    this.metadataTransformer = metadataTransformer;
  }

  /** Create a new builder which can construct an instance of OperationCallSettings. */
  public static <RequestT, ResponseT, MetadataT>
      Builder<RequestT, ResponseT, MetadataT> newBuilder() {
    return new Builder<>();
  }

  public final Builder<RequestT, ResponseT, MetadataT> toBuilder() {
    return new Builder<>(this);
  }

  public static class Builder<RequestT, ResponseT, MetadataT> {
    private UnaryCallSettings<RequestT, OperationSnapshot> initialCallSettings;
    private TimedRetryAlgorithm pollingAlgorithm;
    private ApiFunction<OperationSnapshot, ResponseT> responseTransformer;
    private ApiFunction<OperationSnapshot, MetadataT> metadataTransformer;

    public Builder() {}

    public Builder(OperationCallSettings<RequestT, ResponseT, MetadataT> settings) {
      this.initialCallSettings = settings.initialCallSettings.toBuilder().build();
      this.pollingAlgorithm = settings.pollingAlgorithm;
      this.responseTransformer = settings.responseTransformer;
      this.metadataTransformer = settings.metadataTransformer;
    }

    /** Set the polling algorithm of the operation. */
    public Builder<RequestT, ResponseT, MetadataT> setPollingAlgorithm(
        TimedRetryAlgorithm pollingAlgorithm) {
      this.pollingAlgorithm = pollingAlgorithm;
      return this;
    }

    /** Get the polling algorithm of the operation. */
    public TimedRetryAlgorithm getPollingAlgorithm() {
      return pollingAlgorithm;
    }

    /** Set the call settings which are used on the call to initiate the operation. */
    public Builder<RequestT, ResponseT, MetadataT> setInitialCallSettings(
        UnaryCallSettings<RequestT, OperationSnapshot> initialCallSettings) {
      this.initialCallSettings = initialCallSettings;
      return this;
    }

    /** Get the call settings which are used on the call to initiate the operation. */
    public UnaryCallSettings<RequestT, OperationSnapshot> getInitialCallSettings() {
      return initialCallSettings;
    }

    public final ApiFunction<OperationSnapshot, ResponseT> getResponseTransformer() {
      return responseTransformer;
    }

    public Builder<RequestT, ResponseT, MetadataT> setResponseTransformer(
        ApiFunction<OperationSnapshot, ResponseT> responseTransformer) {
      this.responseTransformer = responseTransformer;
      return this;
    }

    public final ApiFunction<OperationSnapshot, MetadataT> getMetadataTransformer() {
      return metadataTransformer;
    }

    public Builder<RequestT, ResponseT, MetadataT> setMetadataTransformer(
        ApiFunction<OperationSnapshot, MetadataT> metadataTransformer) {
      this.metadataTransformer = metadataTransformer;
      return this;
    }

    public OperationCallSettings<RequestT, ResponseT, MetadataT> build() {
      return new OperationCallSettings<>(
          initialCallSettings, pollingAlgorithm, responseTransformer, metadataTransformer);
    }
  }
}
