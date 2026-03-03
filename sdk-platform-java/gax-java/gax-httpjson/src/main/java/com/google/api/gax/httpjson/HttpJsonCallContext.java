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
package com.google.api.gax.httpjson;

import static com.google.api.gax.util.TimeConversionUtils.toJavaTimeDuration;
import static com.google.api.gax.util.TimeConversionUtils.toThreetenDuration;

import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.core.ObsoleteApi;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.EndpointContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.api.gax.rpc.internal.ApiCallContextOptions;
import com.google.api.gax.rpc.internal.Headers;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.auth.Credentials;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * HttpJsonCallContext encapsulates context data used to make an http-json call.
 *
 * <p>HttpJsonCallContext is immutable in the sense that none of its methods modifies the
 * HttpJsonCallContext itself or the underlying data. Methods of the form {@code withX} return
 * copies of the object, but with one field changed. The immutability and thread safety of the
 * arguments solely depends on the arguments themselves.
 */
public final class HttpJsonCallContext implements ApiCallContext {
  private static final HttpJsonStatusCode UNAUTHENTICATED_STATUS_CODE =
      HttpJsonStatusCode.of(StatusCode.Code.UNAUTHENTICATED);
  private final HttpJsonChannel channel;
  private final HttpJsonCallOptions callOptions;
  @Nullable private final java.time.Duration timeout;
  @Nullable private final java.time.Duration streamWaitTimeout;
  @Nullable private final java.time.Duration streamIdleTimeout;
  private final ImmutableMap<String, List<String>> extraHeaders;
  private final ApiCallContextOptions options;
  private final ApiTracer tracer;
  @Nullable private final RetrySettings retrySettings;
  @Nullable private final ImmutableSet<StatusCode.Code> retryableCodes;
  private final EndpointContext endpointContext;

  /** Returns an empty instance. */
  public static HttpJsonCallContext createDefault() {
    return new HttpJsonCallContext(
        null,
        HttpJsonCallOptions.newBuilder().build(),
        null,
        null,
        null,
        ImmutableMap.of(),
        ApiCallContextOptions.getDefaultOptions(),
        null,
        null,
        null,
        null);
  }

  public static HttpJsonCallContext of(HttpJsonChannel channel, HttpJsonCallOptions options) {
    return new HttpJsonCallContext(
        channel,
        options,
        null,
        null,
        null,
        ImmutableMap.of(),
        ApiCallContextOptions.getDefaultOptions(),
        null,
        null,
        null,
        null);
  }

  private HttpJsonCallContext(
      HttpJsonChannel channel,
      HttpJsonCallOptions callOptions,
      java.time.Duration timeout,
      java.time.Duration streamWaitTimeout,
      java.time.Duration streamIdleTimeout,
      ImmutableMap<String, List<String>> extraHeaders,
      ApiCallContextOptions options,
      ApiTracer tracer,
      RetrySettings defaultRetrySettings,
      Set<StatusCode.Code> defaultRetryableCodes,
      @Nullable EndpointContext endpointContext) {
    this.channel = channel;
    this.callOptions = callOptions;
    this.timeout = timeout;
    this.streamWaitTimeout = streamWaitTimeout;
    this.streamIdleTimeout = streamIdleTimeout;
    this.extraHeaders = extraHeaders;
    this.options = options;
    this.tracer = tracer;
    this.retrySettings = defaultRetrySettings;
    this.retryableCodes =
        defaultRetryableCodes == null ? null : ImmutableSet.copyOf(defaultRetryableCodes);
    // Attempt to create an empty, non-functioning EndpointContext by default. The client will have
    // a valid EndpointContext with user configurations after the client has been initialized.
    this.endpointContext =
        endpointContext == null ? EndpointContext.getDefaultInstance() : endpointContext;
  }

  /**
   * Returns inputContext cast to {@link HttpJsonCallContext}, or an empty {@link
   * HttpJsonCallContext} if inputContext is null.
   *
   * @param inputContext the {@link ApiCallContext} to cast if it is not null
   */
  @Override
  public HttpJsonCallContext nullToSelf(ApiCallContext inputContext) {
    HttpJsonCallContext httpJsonCallContext;
    if (inputContext == null) {
      httpJsonCallContext = this;
    } else {
      if (!(inputContext instanceof HttpJsonCallContext)) {
        throw new IllegalArgumentException(
            "context must be an instance of HttpJsonCallContext, but found "
                + inputContext.getClass().getName());
      }
      httpJsonCallContext = (HttpJsonCallContext) inputContext;
    }
    return httpJsonCallContext;
  }

  @Override
  public HttpJsonCallContext merge(ApiCallContext inputCallContext) {
    if (inputCallContext == null) {
      return this;
    }
    if (!(inputCallContext instanceof HttpJsonCallContext)) {
      throw new IllegalArgumentException(
          "context must be an instance of HttpJsonCallContext, but found "
              + inputCallContext.getClass().getName());
    }
    HttpJsonCallContext httpJsonCallContext = (HttpJsonCallContext) inputCallContext;

    HttpJsonChannel newChannel = httpJsonCallContext.channel;
    if (newChannel == null) {
      newChannel = this.channel;
    }

    // Do deep merge of callOptions
    HttpJsonCallOptions newCallOptions = callOptions.merge(httpJsonCallContext.callOptions);

    java.time.Duration newTimeout = httpJsonCallContext.timeout;
    if (newTimeout == null) {
      newTimeout = this.timeout;
    }

    java.time.Duration newStreamWaitTimeout = httpJsonCallContext.streamWaitTimeout;
    if (newStreamWaitTimeout == null) {
      newStreamWaitTimeout = streamWaitTimeout;
    }

    java.time.Duration newStreamIdleTimeout = httpJsonCallContext.streamIdleTimeout;
    if (newStreamIdleTimeout == null) {
      newStreamIdleTimeout = streamIdleTimeout;
    }

    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(extraHeaders, httpJsonCallContext.extraHeaders);

    ApiCallContextOptions newOptions = options.merge(httpJsonCallContext.options);

    ApiTracer newTracer = httpJsonCallContext.tracer;
    if (newTracer == null) {
      newTracer = this.tracer;
    }

    RetrySettings newRetrySettings = httpJsonCallContext.retrySettings;
    if (newRetrySettings == null) {
      newRetrySettings = this.retrySettings;
    }

    Set<StatusCode.Code> newRetryableCodes = httpJsonCallContext.retryableCodes;
    if (newRetryableCodes == null) {
      newRetryableCodes = this.retryableCodes;
    }

    // The EndpointContext is not updated as there should be no reason for a user
    // to update this.
    return new HttpJsonCallContext(
        newChannel,
        newCallOptions,
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

  @Override
  public HttpJsonCallContext withCredentials(Credentials newCredentials) {
    HttpJsonCallOptions.Builder builder =
        callOptions != null ? callOptions.toBuilder() : HttpJsonCallOptions.newBuilder();
    return withCallOptions(builder.setCredentials(newCredentials).build());
  }

  @Override
  public HttpJsonCallContext withTransportChannel(TransportChannel inputChannel) {
    Preconditions.checkNotNull(inputChannel);
    if (!(inputChannel instanceof HttpJsonTransportChannel)) {
      throw new IllegalArgumentException(
          "Expected HttpJsonTransportChannel, got " + inputChannel.getClass().getName());
    }
    HttpJsonTransportChannel transportChannel = (HttpJsonTransportChannel) inputChannel;
    return withChannel(transportChannel.getChannel());
  }

  /** This method is obsolete. Use {@link #withTimeoutDuration(java.time.Duration)} instead. */
  @Override
  @ObsoleteApi("Use withTimeoutDuration(java.time.Duration) instead")
  public HttpJsonCallContext withTimeout(org.threeten.bp.Duration timeout) {
    return withTimeoutDuration(toJavaTimeDuration(timeout));
  }

  @Override
  public HttpJsonCallContext withEndpointContext(EndpointContext endpointContext) {
    Preconditions.checkNotNull(endpointContext);
    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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
  public HttpJsonCallContext withTimeoutDuration(java.time.Duration timeout) {
    // Default RetrySettings use 0 for RPC timeout. Treat that as disabled timeouts.
    if (timeout != null && (timeout.isZero() || timeout.isNegative())) {
      timeout = null;
    }

    // Prevent expanding deadlines
    if (timeout != null && this.timeout != null && this.timeout.compareTo(timeout) <= 0) {
      return this;
    }

    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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

  /** This method is obsolete. Use {@link #getTimeoutDuration()} instead. */
  @Nullable
  @Override
  @ObsoleteApi("Use getTimeoutDuration instead")
  public org.threeten.bp.Duration getTimeout() {
    return toThreetenDuration(getTimeoutDuration());
  }

  @Nullable
  @Override
  public java.time.Duration getTimeoutDuration() {
    return timeout;
  }

  /**
   * This method is obsolete. Use {@link #withStreamWaitTimeoutDuration(java.time.Duration)}
   * instead.
   */
  @Override
  @ObsoleteApi("Use withStreamWaitTimeoutDuration(java.time.Duration) instead")
  public HttpJsonCallContext withStreamWaitTimeout(
      @Nullable org.threeten.bp.Duration streamWaitTimeout) {
    return withStreamWaitTimeoutDuration(toJavaTimeDuration(streamWaitTimeout));
  }

  @Override
  public HttpJsonCallContext withStreamWaitTimeoutDuration(
      @Nullable java.time.Duration streamWaitTimeout) {
    if (streamWaitTimeout != null) {
      Preconditions.checkArgument(
          streamWaitTimeout.compareTo(java.time.Duration.ZERO) >= 0, "Invalid timeout: < 0 s");
    }

    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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

  /** This method is obsolete. Use {@link #getStreamWaitTimeoutDuration()} instead. */
  @Override
  @Nullable
  @ObsoleteApi("Use getStreamWaitTimeoutDuration() instead")
  public org.threeten.bp.Duration getStreamWaitTimeout() {
    return toThreetenDuration(getStreamWaitTimeoutDuration());
  }

  /**
   * The stream wait timeout set for this context.
   *
   * @see ApiCallContext#withStreamWaitTimeoutDuration(java.time.Duration)
   */
  @Override
  @Nullable
  public java.time.Duration getStreamWaitTimeoutDuration() {
    return streamWaitTimeout;
  }

  /**
   * This method is obsolete. Use {@link #withStreamIdleTimeoutDuration(java.time.Duration)}
   * instead.
   */
  @Override
  @ObsoleteApi("Use withStreamIdleTimeoutDuration(java.time.Duration) instead")
  public HttpJsonCallContext withStreamIdleTimeout(
      @Nullable org.threeten.bp.Duration streamIdleTimeout) {
    return withStreamIdleTimeoutDuration(toJavaTimeDuration(streamIdleTimeout));
  }

  @Override
  public HttpJsonCallContext withStreamIdleTimeoutDuration(
      @Nullable java.time.Duration streamIdleTimeout) {
    if (streamIdleTimeout != null) {
      Preconditions.checkArgument(
          streamIdleTimeout.compareTo(java.time.Duration.ZERO) >= 0, "Invalid timeout: < 0 s");
    }

    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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

  /** This method is obsolete. Use {@link #getStreamIdleTimeoutDuration()} instead. */
  @Override
  @Nullable
  @ObsoleteApi("Use getStreamIdleTimeoutDuration() instead")
  public org.threeten.bp.Duration getStreamIdleTimeout() {
    return toThreetenDuration(getStreamIdleTimeoutDuration());
  }

  /**
   * The stream idle timeout set for this context.
   *
   * @see ApiCallContext#withStreamIdleTimeoutDuration(java.time.Duration)
   */
  @Override
  @Nullable
  public java.time.Duration getStreamIdleTimeoutDuration() {
    return streamIdleTimeout;
  }

  @BetaApi("The surface for extra headers is not stable yet and may change in the future.")
  @Override
  public ApiCallContext withExtraHeaders(Map<String, List<String>> extraHeaders) {
    Preconditions.checkNotNull(extraHeaders);
    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(this.extraHeaders, extraHeaders);
    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        newExtraHeaders,
        this.options,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @BetaApi("The surface for extra headers is not stable yet and may change in the future.")
  @Override
  public Map<String, List<String>> getExtraHeaders() {
    return extraHeaders;
  }

  /** {@inheritDoc} */
  @Override
  public <T> ApiCallContext withOption(Key<T> key, T value) {
    ApiCallContextOptions newOptions = options.withOption(key, value);
    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        newOptions,
        this.tracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  /** {@inheritDoc} */
  @Override
  public <T> T getOption(Key<T> key) {
    return options.getOption(key);
  }

  /**
   * Validate the Universe Domain to ensure that the user configured Universe Domain and the
   * Credentials' Universe Domain match. An exception will be raised if there are any issues when
   * trying to validate (i.e. unable to access the universe domain).
   *
   * @throws UnauthenticatedException Thrown if the universe domain that the user configured does
   *     not match the Credential's universe domain or if the client library is unable to retrieve
   *     the Universe Domain from the Credentials.
   */
  @InternalApi
  public void validateUniverseDomain() {
    try {
      endpointContext.validateUniverseDomain(
          getCallOptions().getCredentials(), UNAUTHENTICATED_STATUS_CODE);
    } catch (IOException e) {
      // All instances of IOException from endpointContext's `validateUniverseDomain()`
      // call should be an Auth Exception
      throw ApiExceptionFactory.createException(
          EndpointContext.UNABLE_TO_RETRIEVE_CREDENTIALS_ERROR_MESSAGE,
          e,
          UNAUTHENTICATED_STATUS_CODE,
          false);
    }
  }

  public HttpJsonChannel getChannel() {
    return channel;
  }

  public HttpJsonCallOptions getCallOptions() {
    return callOptions;
  }

  @Deprecated
  @Nullable
  public org.threeten.bp.Instant getDeadline() {
    return getCallOptions() != null ? getCallOptions().getDeadline() : null;
  }

  @Deprecated
  @Nullable
  public Credentials getCredentials() {
    return getCallOptions() != null ? getCallOptions().getCredentials() : null;
  }

  @Override
  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  @Override
  public HttpJsonCallContext withRetrySettings(RetrySettings retrySettings) {
    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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

  @Override
  public Set<StatusCode.Code> getRetryableCodes() {
    return retryableCodes;
  }

  @Override
  public HttpJsonCallContext withRetryableCodes(Set<StatusCode.Code> retryableCodes) {
    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
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

  public HttpJsonCallContext withChannel(HttpJsonChannel newChannel) {
    return new HttpJsonCallContext(
        newChannel,
        this.callOptions,
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

  public HttpJsonCallContext withCallOptions(HttpJsonCallOptions newCallOptions) {
    return new HttpJsonCallContext(
        this.channel,
        newCallOptions,
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

  @Deprecated
  public HttpJsonCallContext withDeadline(org.threeten.bp.Instant newDeadline) {
    HttpJsonCallOptions.Builder builder =
        callOptions != null ? callOptions.toBuilder() : HttpJsonCallOptions.newBuilder();
    return withCallOptions(builder.setDeadline(newDeadline).build());
  }

  @Nonnull
  @Override
  public ApiTracer getTracer() {
    if (tracer == null) {
      return BaseApiTracer.getInstance();
    }
    return tracer;
  }

  /** {@inheritDoc} */
  @Override
  public HttpJsonCallContext withTracer(@Nonnull ApiTracer newTracer) {
    Preconditions.checkNotNull(newTracer);

    return new HttpJsonCallContext(
        this.channel,
        this.callOptions,
        this.timeout,
        this.streamWaitTimeout,
        this.streamIdleTimeout,
        this.extraHeaders,
        this.options,
        newTracer,
        this.retrySettings,
        this.retryableCodes,
        this.endpointContext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    HttpJsonCallContext that = (HttpJsonCallContext) o;
    return Objects.equals(this.channel, that.channel)
        && Objects.equals(this.callOptions, that.callOptions)
        && Objects.equals(this.timeout, that.timeout)
        && Objects.equals(this.extraHeaders, that.extraHeaders)
        && Objects.equals(this.options, that.options)
        && Objects.equals(this.tracer, that.tracer)
        && Objects.equals(this.retrySettings, that.retrySettings)
        && Objects.equals(this.retryableCodes, that.retryableCodes)
        && Objects.equals(this.endpointContext, that.endpointContext);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channel,
        callOptions,
        timeout,
        extraHeaders,
        options,
        tracer,
        retrySettings,
        retryableCodes,
        endpointContext);
  }
}
