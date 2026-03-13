/*
 * Copyright 2017 Google LLC
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
package com.google.api.gax.rpc.testing;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.InternalApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.internal.ApiCallContextOptions;
import com.google.api.gax.rpc.internal.Headers;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.auth.Credentials;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

@InternalApi("for testing")
public class FakeCallContext implements ApiCallContext {
  private final Credentials credentials;
  private final FakeChannel channel;
  private final java.time.Duration timeout;
  private final java.time.Duration streamWaitTimeout;
  private final java.time.Duration streamIdleTimeout;
  private final ImmutableMap<String, List<String>> extraHeaders;
  private final ApiCallContextOptions options;
  private final ApiTracer tracer;
  private final RetrySettings retrySettings;
  private final ImmutableSet<StatusCode.Code> retryableCodes;
  private final EndpointContext endpointContext;

  private FakeCallContext(
      Credentials credentials,
      FakeChannel channel,
      java.time.Duration timeout,
      java.time.Duration streamWaitTimeout,
      java.time.Duration streamIdleTimeout,
      ImmutableMap<String, List<String>> extraHeaders,
      ApiCallContextOptions options,
      ApiTracer tracer,
      RetrySettings retrySettings,
      Set<StatusCode.Code> retryableCodes,
      EndpointContext endpointContext) {
    this.credentials = credentials;
    this.channel = channel;
    this.timeout = timeout;
    this.streamWaitTimeout = streamWaitTimeout;
    this.streamIdleTimeout = streamIdleTimeout;
    this.extraHeaders = extraHeaders;
    this.options = options;
    this.tracer = tracer;
    this.retrySettings = retrySettings;
    this.retryableCodes = retryableCodes == null ? null : ImmutableSet.copyOf(retryableCodes);
    this.endpointContext =
        endpointContext == null ? EndpointContext.getDefaultInstance() : endpointContext;
  }

  public static FakeCallContext createDefault() {
    return new FakeCallContext(
        null,
        null,
        null,
        null,
        null,
        ImmutableMap.<String, List<String>>of(),
        ApiCallContextOptions.getDefaultOptions(),
        null,
        null,
        null,
        null);
  }

  @Override
  public FakeCallContext nullToSelf(ApiCallContext inputContext) {
    FakeCallContext fakeCallContext;
    if (inputContext == null) {
      fakeCallContext = this;
    } else {
      if (!(inputContext instanceof FakeCallContext)) {
        throw new IllegalArgumentException(
            "context must be an instance of FakeCallContext, but found "
                + inputContext.getClass().getName());
      }
      fakeCallContext = (FakeCallContext) inputContext;
    }
    return fakeCallContext;
  }

  @Override
  public ApiCallContext merge(ApiCallContext inputCallContext) {
    if (inputCallContext == null) {
      return this;
    }
    if (!(inputCallContext instanceof FakeCallContext)) {
      throw new IllegalArgumentException(
          "context must be an instance of FakeCallContext, but found "
              + inputCallContext.getClass().getName());
    }
    FakeCallContext fakeCallContext = (FakeCallContext) inputCallContext;

    FakeChannel newChannel = fakeCallContext.channel;
    if (newChannel == null) {
      newChannel = channel;
    }

    Credentials newCallCredentials = fakeCallContext.credentials;
    if (newCallCredentials == null) {
      newCallCredentials = credentials;
    }

    java.time.Duration newTimeout = fakeCallContext.timeout;
    if (newTimeout == null) {
      newTimeout = timeout;
    }

    java.time.Duration newStreamWaitTimeout = fakeCallContext.streamWaitTimeout;
    if (newStreamWaitTimeout == null) {
      newStreamWaitTimeout = streamWaitTimeout;
    }

    java.time.Duration newStreamIdleTimeout = fakeCallContext.streamIdleTimeout;
    if (newStreamIdleTimeout == null) {
      newStreamIdleTimeout = streamIdleTimeout;
    }

    ApiTracer newTracer = fakeCallContext.tracer;
    if (newTracer == null) {
      newTracer = this.tracer;
    }

    RetrySettings newRetrySettings = fakeCallContext.retrySettings;
    if (newRetrySettings == null) {
      newRetrySettings = this.retrySettings;
    }

    Set<StatusCode.Code> newRetryableCodes = fakeCallContext.retryableCodes;
    if (newRetryableCodes == null) {
      newRetryableCodes = this.retryableCodes;
    }

    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(extraHeaders, fakeCallContext.extraHeaders);

    ApiCallContextOptions newOptions = options.merge(fakeCallContext.options);

    return new FakeCallContext(
        newCallCredentials,
        newChannel,
        newTimeout,
        newStreamWaitTimeout,
        newStreamIdleTimeout,
        newExtraHeaders,
        newOptions,
        newTracer,
        newRetrySettings,
        newRetryableCodes,
        endpointContext);
  }

  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  public FakeCallContext withRetrySettings(RetrySettings retrySettings) {
    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  public Set<StatusCode.Code> getRetryableCodes() {
    return retryableCodes;
  }

  public FakeCallContext withRetryableCodes(Set<StatusCode.Code> retryableCodes) {
    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        retryableCodes,
        this.endpointContext);
  }

  public Credentials getCredentials() {
    return credentials;
  }

  public FakeChannel getChannel() {
    return channel;
  }

  @Override
  public java.time.Duration getTimeoutDuration() {
    return timeout;
  }

  @Override
  public ApiCallContext withStreamWaitTimeout(
      @Nullable org.threeten.bp.Duration streamWaitTimeout) {
    return withStreamWaitTimeoutDuration(toJavaTimeDuration(streamWaitTimeout));
  }

  @Nullable
  @Override
  public java.time.Duration getStreamWaitTimeoutDuration() {
    return streamWaitTimeout;
  }

  @Override
  public ApiCallContext withStreamIdleTimeout(
      @Nullable org.threeten.bp.Duration streamIdleTimeout) {
    return withStreamIdleTimeoutDuration(toJavaTimeDuration(streamIdleTimeout));
  }

  @Nullable
  @Override
  public java.time.Duration getStreamIdleTimeoutDuration() {
    return streamIdleTimeout;
  }

  @Override
  public FakeCallContext withCredentials(Credentials credentials) {
    return new FakeCallContext(
        credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Override
  public FakeCallContext withTransportChannel(TransportChannel inputChannel) {
    Preconditions.checkNotNull(inputChannel);
    if (!(inputChannel instanceof FakeTransportChannel)) {
      throw new IllegalArgumentException(
          "Expected FakeTransportChannel, got " + inputChannel.getClass().getName());
    }
    FakeTransportChannel transportChannel = (FakeTransportChannel) inputChannel;
    return withChannel(transportChannel.getChannel());
  }

  @Override
  public FakeCallContext withEndpointContext(EndpointContext endpointContext) {
    Preconditions.checkNotNull(endpointContext);
    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        endpointContext);
  }

  @Override
  public FakeCallContext withTimeout(@Nullable org.threeten.bp.Duration timeout) {
    return withTimeoutDuration(toJavaTimeDuration(timeout));
  }

  public FakeCallContext withChannel(FakeChannel channel) {
    return new FakeCallContext(
        this.credentials,
        channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Override
  public FakeCallContext withTimeoutDuration(java.time.Duration timeout) {
    // Default RetrySettings use 0 for RPC timeout. Treat that as disabled timeouts.
    if (timeout != null && (timeout.isZero() || timeout.isNegative())) {
      timeout = null;
    }

    // Prevent expanding timeouts
    if (timeout != null && this.timeout != null && this.timeout.compareTo(timeout) <= 0) {
      return this;
    }

    return new FakeCallContext(
        this.credentials,
        this.channel,
        timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Nullable
  @Override
  public org.threeten.bp.Duration getTimeout() {
    return toThreetenDuration(getTimeoutDuration());
  }

  @Override
  public ApiCallContext withStreamWaitTimeoutDuration(
      @Nullable java.time.Duration streamWaitTimeout) {
    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Nullable
  @Override
  public org.threeten.bp.Duration getStreamWaitTimeout() {
    return toThreetenDuration(getStreamWaitTimeoutDuration());
  }

  @Override
  public ApiCallContext withStreamIdleTimeoutDuration(
      @Nullable java.time.Duration streamIdleTimeout) {
    Preconditions.checkNotNull(streamIdleTimeout);
    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        streamIdleTimeout,
        this.extraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Nullable
  @Override
  public org.threeten.bp.Duration getStreamIdleTimeout() {
    return toThreetenDuration(getStreamIdleTimeoutDuration());
  }

  @Override
  public ApiCallContext withExtraHeaders(Map<String, List<String>> extraHeaders) {
    Preconditions.checkNotNull(extraHeaders);
    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(this.extraHeaders, extraHeaders);
    return new FakeCallContext(
        credentials,
        channel,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        newExtraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Override
  public Map<String, List<String>> getExtraHeaders() {
    return this.extraHeaders;
  }

  @Override
  public <T> ApiCallContext withOption(Key<T> key, T value) {
    Preconditions.checkNotNull(key);
    ApiCallContextOptions newOptions = options.withOption(key, value);
    return new FakeCallContext(
        credentials,
        channel,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        extraHeaders,
        newOptions,
        tracer,
        retrySettings,
        retryableCodes,
        this.endpointContext);
  }

  @Override
  public <T> T getOption(Key<T> key) {
    Preconditions.checkNotNull(key);
    return options.getOption(key);
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public ApiTracer getTracer() {
    if (tracer == null) {
      return BaseApiTracer.getInstance();
    }
    return tracer;
  }

  /** {@inheritDoc} */
  @Override
  public ApiCallContext withTracer(@Nonnull ApiTracer tracer) {
    Preconditions.checkNotNull(tracer);

    return new FakeCallContext(
        this.credentials,
        this.channel,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  public static FakeCallContext create(ClientContext clientContext) {
    return FakeCallContext.createDefault()
        .withTransportChannel(clientContext.getTransportChannel())
        .withCredentials(clientContext.getCredentials());
  }
}
