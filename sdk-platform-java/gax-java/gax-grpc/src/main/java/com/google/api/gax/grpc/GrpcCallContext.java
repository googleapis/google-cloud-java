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
package com.google.api.gax.grpc;

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
import com.google.api.gax.rpc.UnavailableException;
import com.google.api.gax.rpc.internal.ApiCallContextOptions;
import com.google.api.gax.rpc.internal.Headers;
import com.google.api.gax.tracing.ApiTracer;
import com.google.api.gax.tracing.BaseApiTracer;
import com.google.auth.Credentials;
import com.google.auth.Retryable;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.grpc.CallCredentials;
import io.grpc.CallOptions;
import io.grpc.Channel;
import io.grpc.Deadline;
import io.grpc.Metadata;
import io.grpc.Status;
import io.grpc.auth.MoreCallCredentials;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * GrpcCallContext encapsulates context data used to make a grpc call.
 *
 * <p>GrpcCallContext is immutable in the sense that none of its methods modifies the
 * GrpcCallContext itself or the underlying data. Methods of the form {@code withX}, such as {@link
 * #withTransportChannel}, return copies of the object, but with one field changed. The immutability
 * and thread safety of the arguments solely depends on the arguments themselves.
 */
@BetaApi("Reference ApiCallContext instead - this class is likely to experience breaking changes")
public final class GrpcCallContext implements ApiCallContext {
  private static final GrpcStatusCode UNAUTHENTICATED_STATUS_CODE =
      GrpcStatusCode.of(Status.Code.UNAUTHENTICATED);

  // This field is made public for handwritten libraries to easily access the tracer from
  // CallOptions
  public static final CallOptions.Key<ApiTracer> TRACER_KEY = CallOptions.Key.create("gax.tracer");

  private final Channel channel;
  @Nullable private final Credentials credentials;
  private final CallOptions callOptions;
  @Nullable private final java.time.Duration timeout;
  @Nullable private final java.time.Duration streamWaitTimeout;
  @Nullable private final java.time.Duration streamIdleTimeout;
  @Nullable private final Integer channelAffinity;
  @Nullable private final RetrySettings retrySettings;
  @Nullable private final ImmutableSet<StatusCode.Code> retryableCodes;
  private final ImmutableMap<String, List<String>> extraHeaders;
  private final ApiCallContextOptions options;
  private final EndpointContext endpointContext;
  private final boolean isDirectPath;

  /** Returns an empty instance with a null channel and default {@link CallOptions}. */
  public static GrpcCallContext createDefault() {
    return new GrpcCallContext(
        null,
        null,
        CallOptions.DEFAULT,
        null,
        null,
        null,
        null,
        ImmutableMap.<String, List<String>>of(),
        ApiCallContextOptions.getDefaultOptions(),
        null,
        null,
        null,
        false);
  }

  /** Returns an instance with the given channel and {@link CallOptions}. */
  public static GrpcCallContext of(Channel channel, CallOptions callOptions) {
    return new GrpcCallContext(
        channel,
        null,
        callOptions,
        null,
        null,
        null,
        null,
        ImmutableMap.<String, List<String>>of(),
        ApiCallContextOptions.getDefaultOptions(),
        null,
        null,
        null,
        false);
  }

  private GrpcCallContext(
      Channel channel,
      @Nullable Credentials credentials,
      CallOptions callOptions,
      @Nullable java.time.Duration timeout,
      @Nullable java.time.Duration streamWaitTimeout,
      @Nullable java.time.Duration streamIdleTimeout,
      @Nullable Integer channelAffinity,
      ImmutableMap<String, List<String>> extraHeaders,
      ApiCallContextOptions options,
      @Nullable RetrySettings retrySettings,
      @Nullable Set<StatusCode.Code> retryableCodes,
      @Nullable EndpointContext endpointContext,
      boolean isDirectPath) {
    this.channel = channel;
    this.credentials = credentials;
    Preconditions.checkNotNull(callOptions);
    // CallCredentials is stripped from CallOptions because CallCredentials are attached
    // to ChannelCredentials in DirectPath flows. Adding it again would duplicate the headers.
    this.callOptions = isDirectPath ? callOptions.withCallCredentials(null) : callOptions;
    this.timeout = timeout;
    this.streamWaitTimeout = streamWaitTimeout;
    this.streamIdleTimeout = streamIdleTimeout;
    this.channelAffinity = channelAffinity;
    this.extraHeaders = Preconditions.checkNotNull(extraHeaders);
    this.options = Preconditions.checkNotNull(options);
    this.retrySettings = retrySettings;
    this.retryableCodes = retryableCodes == null ? null : ImmutableSet.copyOf(retryableCodes);
    // Attempt to create an empty, non-functioning EndpointContext by default. The client will have
    // a valid EndpointContext with user configurations after the client has been initialized.
    this.endpointContext =
        endpointContext == null ? EndpointContext.getDefaultInstance() : endpointContext;
    this.isDirectPath = isDirectPath;
  }

  /**
   * Returns inputContext cast to {@link GrpcCallContext}, or an empty {@link GrpcCallContext} if
   * inputContext is null.
   *
   * @param inputContext the {@link ApiCallContext} to cast if it is not null
   */
  @Override
  public GrpcCallContext nullToSelf(ApiCallContext inputContext) {
    GrpcCallContext grpcCallContext;
    if (inputContext == null) {
      grpcCallContext = this;
    } else {
      if (!(inputContext instanceof GrpcCallContext)) {
        throw new IllegalArgumentException(
            "context must be an instance of GrpcCallContext, but found "
                + inputContext.getClass().getName());
      }
      grpcCallContext = (GrpcCallContext) inputContext;
    }
    return grpcCallContext;
  }

  @Override
  public GrpcCallContext withCredentials(Credentials newCredentials) {
    Preconditions.checkNotNull(newCredentials);
    CallCredentials callCredentials = MoreCallCredentials.from(newCredentials);
    return new GrpcCallContext(
        channel,
        newCredentials,
        callOptions.withCallCredentials(callCredentials),
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @Override
  public GrpcCallContext withTransportChannel(TransportChannel inputChannel) {
    Preconditions.checkNotNull(inputChannel);
    if (!(inputChannel instanceof GrpcTransportChannel)) {
      throw new IllegalArgumentException(
          "Expected GrpcTransportChannel, got " + inputChannel.getClass().getName());
    }
    GrpcTransportChannel transportChannel = (GrpcTransportChannel) inputChannel;
    return new GrpcCallContext(
        transportChannel.getChannel(),
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        transportChannel.isDirectPath());
  }

  @Override
  public GrpcCallContext withEndpointContext(EndpointContext endpointContext) {
    Preconditions.checkNotNull(endpointContext);
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  /** This method is obsolete. Use {@link #withTimeoutDuration(java.time.Duration)} instead. */
  @Override
  @ObsoleteApi("Use withTimeoutDuration(java.time.Duration) instead")
  public GrpcCallContext withTimeout(@Nullable org.threeten.bp.Duration timeout) {
    return withTimeoutDuration(toJavaTimeDuration(timeout));
  }

  @Override
  public GrpcCallContext withTimeoutDuration(@Nullable java.time.Duration timeout) {
    // Default RetrySettings use 0 for RPC timeout. Treat that as disabled timeouts.
    if (timeout != null && (timeout.isZero() || timeout.isNegative())) {
      timeout = null;
    }

    // Prevent expanding timeouts
    if (timeout != null && this.timeout != null && this.timeout.compareTo(timeout) <= 0) {
      return this;
    }

    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  /** This method is obsolete. Use {@link #getTimeoutDuration()} instead. */
  @Nullable
  @Override
  @ObsoleteApi("Use getTimeoutDuration() instead")
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
  public GrpcCallContext withStreamWaitTimeout(
      @Nullable org.threeten.bp.Duration streamWaitTimeout) {
    return withStreamWaitTimeoutDuration(toJavaTimeDuration(streamWaitTimeout));
  }

  @Override
  public GrpcCallContext withStreamWaitTimeoutDuration(
      @Nullable java.time.Duration streamWaitTimeout) {
    if (streamWaitTimeout != null) {
      Preconditions.checkArgument(
          streamWaitTimeout.compareTo(java.time.Duration.ZERO) >= 0, "Invalid timeout: < 0 s");
    }

    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  /**
   * This method is obsolete. Use {@link #withStreamIdleTimeoutDuration(java.time.Duration)}
   * instead.
   */
  @Override
  @ObsoleteApi("Use withStreamIdleTimeoutDuration(java.time.Duration) instead")
  public GrpcCallContext withStreamIdleTimeout(
      @Nullable org.threeten.bp.Duration streamIdleTimeout) {
    return withStreamIdleTimeoutDuration(toJavaTimeDuration(streamIdleTimeout));
  }

  @Override
  public GrpcCallContext withStreamIdleTimeoutDuration(
      @Nullable java.time.Duration streamIdleTimeout) {
    if (streamIdleTimeout != null) {
      Preconditions.checkArgument(
          streamIdleTimeout.compareTo(java.time.Duration.ZERO) >= 0, "Invalid timeout: < 0 s");
    }

    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @BetaApi("The surface for channel affinity is not stable yet and may change in the future.")
  public GrpcCallContext withChannelAffinity(@Nullable Integer affinity) {
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        affinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @BetaApi("The surface for extra headers is not stable yet and may change in the future.")
  @Override
  public GrpcCallContext withExtraHeaders(Map<String, List<String>> extraHeaders) {
    Preconditions.checkNotNull(extraHeaders);
    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(this.extraHeaders, extraHeaders);
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        newExtraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @Override
  public RetrySettings getRetrySettings() {
    return retrySettings;
  }

  @Override
  public GrpcCallContext withRetrySettings(RetrySettings retrySettings) {
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @Override
  public Set<StatusCode.Code> getRetryableCodes() {
    return retryableCodes;
  }

  @Override
  public GrpcCallContext withRetryableCodes(Set<StatusCode.Code> retryableCodes) {
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  @Override
  public ApiCallContext merge(ApiCallContext inputCallContext) {
    if (inputCallContext == null) {
      return this;
    }
    if (!(inputCallContext instanceof GrpcCallContext)) {
      throw new IllegalArgumentException(
          "context must be an instance of GrpcCallContext, but found "
              + inputCallContext.getClass().getName());
    }
    GrpcCallContext grpcCallContext = (GrpcCallContext) inputCallContext;

    Credentials newCredentials = grpcCallContext.credentials;
    if (newCredentials == null) {
      newCredentials = credentials;
    }

    Channel newChannel = grpcCallContext.channel;
    if (newChannel == null) {
      newChannel = channel;
    }

    Deadline newDeadline = grpcCallContext.callOptions.getDeadline();
    if (newDeadline == null) {
      newDeadline = callOptions.getDeadline();
    }

    boolean newIsDirectPath = grpcCallContext.isDirectPath;

    CallCredentials newCallCredentials = grpcCallContext.callOptions.getCredentials();
    if (newCallCredentials == null) {
      newCallCredentials = callOptions.getCredentials();
    }

    ApiTracer newTracer = grpcCallContext.callOptions.getOption(TRACER_KEY);
    if (newTracer == null) {
      newTracer = callOptions.getOption(TRACER_KEY);
    }

    java.time.Duration newTimeout = grpcCallContext.timeout;
    if (newTimeout == null) {
      newTimeout = timeout;
    }

    java.time.Duration newStreamWaitTimeout = grpcCallContext.streamWaitTimeout;
    if (newStreamWaitTimeout == null) {
      newStreamWaitTimeout = streamWaitTimeout;
    }

    java.time.Duration newStreamIdleTimeout = grpcCallContext.streamIdleTimeout;
    if (newStreamIdleTimeout == null) {
      newStreamIdleTimeout = streamIdleTimeout;
    }

    Integer newChannelAffinity = grpcCallContext.channelAffinity;
    if (newChannelAffinity == null) {
      newChannelAffinity = channelAffinity;
    }

    RetrySettings newRetrySettings = grpcCallContext.retrySettings;
    if (newRetrySettings == null) {
      newRetrySettings = retrySettings;
    }

    Set<StatusCode.Code> newRetryableCodes = grpcCallContext.retryableCodes;
    if (newRetryableCodes == null) {
      newRetryableCodes = retryableCodes;
    }

    ImmutableMap<String, List<String>> newExtraHeaders =
        Headers.mergeHeaders(extraHeaders, grpcCallContext.extraHeaders);

    ApiCallContextOptions newOptions = options.merge(grpcCallContext.options);

    CallOptions newCallOptions =
        grpcCallContext
            .callOptions
            .withCallCredentials(newCallCredentials)
            .withDeadline(newDeadline);

    if (newTracer != null) {
      newCallOptions = newCallOptions.withOption(TRACER_KEY, newTracer);
    }

    // The EndpointContext is not updated as there should be no reason for a user
    // to update this.
    return new GrpcCallContext(
        newChannel,
        newCredentials,
        newCallOptions,
        newTimeout,
        newStreamWaitTimeout,
        newStreamIdleTimeout,
        newChannelAffinity,
        newExtraHeaders,
        newOptions,
        newRetrySettings,
        newRetryableCodes,
        endpointContext,
        newIsDirectPath);
  }

  /** The {@link Channel} set on this context. */
  public Channel getChannel() {
    return channel;
  }

  /** The {@link CallOptions} set on this context. */
  public CallOptions getCallOptions() {
    return callOptions;
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

  /** The channel affinity for this context. */
  @Nullable
  public Integer getChannelAffinity() {
    return channelAffinity;
  }

  /** The extra header for this context. */
  @BetaApi("The surface for extra headers is not stable yet and may change in the future.")
  @Override
  public Map<String, List<String>> getExtraHeaders() {
    return extraHeaders;
  }

  /**
   * This method is obsolete. Use {@link #withTransportChannel()} instead. Returns a new instance
   * with the channel set to the given channel.
   */
  @ObsoleteApi("Use withTransportChannel() instead")
  public GrpcCallContext withChannel(Channel newChannel) {
    return new GrpcCallContext(
        newChannel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  /** Returns a new instance with the call options set to the given call options. */
  public GrpcCallContext withCallOptions(CallOptions newCallOptions) {
    return new GrpcCallContext(
        channel,
        credentials,
        newCallOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
  }

  public GrpcCallContext withRequestParamsDynamicHeaderOption(String requestParams) {
    CallOptions newCallOptions =
        CallOptionsUtil.putRequestParamsDynamicHeaderOption(callOptions, requestParams);

    return withCallOptions(newCallOptions);
  }

  /** {@inheritDoc} */
  @Override
  @Nonnull
  public ApiTracer getTracer() {
    ApiTracer tracer = callOptions.getOption(TRACER_KEY);
    if (tracer == null) {
      tracer = BaseApiTracer.getInstance();
    }
    return tracer;
  }

  /** {@inheritDoc} */
  @Override
  public GrpcCallContext withTracer(@Nonnull ApiTracer tracer) {
    Preconditions.checkNotNull(tracer);
    return withCallOptions(callOptions.withOption(TRACER_KEY, tracer));
  }

  /** {@inheritDoc} */
  @Override
  public <T> GrpcCallContext withOption(Key<T> key, T value) {
    ApiCallContextOptions newOptions = options.withOption(key, value);
    return new GrpcCallContext(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        newOptions,
        retrySettings,
        retryableCodes,
        endpointContext,
        isDirectPath);
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
   *     not match the Credential's universe domain.
   * @throws UnavailableException If client library is unable to retrieve the universe domain from
   *     the Credentials and the RPC is configured to retry Unavailable exceptions, the client
   *     library will attempt to retry with the RPC's defined retry bounds. If the retry bounds have
   *     been exceeded and the library is still unable to retrieve the universe domain, the
   *     exception will be thrown back to the user.
   */
  @InternalApi
  public void validateUniverseDomain() {
    try {
      endpointContext.validateUniverseDomain(credentials, UNAUTHENTICATED_STATUS_CODE);
    } catch (IOException e) {
      // Check if it is an Auth Exception (All instances of IOException from endpointContext's
      // `validateUniverseDomain()` call should be an Auth Exception).
      if (e instanceof Retryable) {
        Retryable retryable = (Retryable) e;
        // Keep the behavior the same as gRPC-Java. Mark as Auth Exceptions as Unavailable
        throw ApiExceptionFactory.createException(
            EndpointContext.UNABLE_TO_RETRIEVE_CREDENTIALS_ERROR_MESSAGE,
            e,
            GrpcStatusCode.of(Status.Code.UNAVAILABLE),
            retryable.isRetryable());
      }
      // This exception below should never be raised as all IOExceptions should be caught above.
      throw ApiExceptionFactory.createException(
          EndpointContext.UNABLE_TO_RETRIEVE_CREDENTIALS_ERROR_MESSAGE,
          e,
          UNAUTHENTICATED_STATUS_CODE,
          false);
    }
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        channel,
        credentials,
        callOptions,
        timeout,
        streamWaitTimeout,
        streamIdleTimeout,
        channelAffinity,
        extraHeaders,
        options,
        retrySettings,
        retryableCodes,
        endpointContext);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    GrpcCallContext that = (GrpcCallContext) o;
    return Objects.equals(channel, that.channel)
        && Objects.equals(credentials, that.credentials)
        && Objects.equals(callOptions, that.callOptions)
        && Objects.equals(timeout, that.timeout)
        && Objects.equals(streamWaitTimeout, that.streamWaitTimeout)
        && Objects.equals(streamIdleTimeout, that.streamIdleTimeout)
        && Objects.equals(channelAffinity, that.channelAffinity)
        && Objects.equals(extraHeaders, that.extraHeaders)
        && Objects.equals(options, that.options)
        && Objects.equals(retrySettings, that.retrySettings)
        && Objects.equals(retryableCodes, that.retryableCodes)
        && Objects.equals(endpointContext, that.endpointContext);
  }

  Metadata getMetadata() {
    Metadata metadata = new Metadata();
    for (Map.Entry<String, List<String>> header : extraHeaders.entrySet()) {
      String headerKey = header.getKey();
      for (String headerValue : header.getValue()) {
        metadata.put(Metadata.Key.of(headerKey, Metadata.ASCII_STRING_MARSHALLER), headerValue);
      }
    }
    return metadata;
  }
}
