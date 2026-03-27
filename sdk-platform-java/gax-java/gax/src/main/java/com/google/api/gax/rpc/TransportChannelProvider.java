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

import com.google.api.core.BetaApi;
import com.google.api.core.InternalExtensionOnly;
import com.google.auth.Credentials;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/**
 * Provides an interface to either build a TransportChannel or provide a fixed TransportChannel that
 * will be used to make calls to a service.
 *
 * <p>Implementations of {@link TransportChannelProvider} may choose to create a new {@link
 * TransportChannel} for each call to {@link #getTransportChannel}, or may return a fixed {@link
 * TransportChannel} instance.
 *
 * <p>Callers should use the following pattern to get a channel:
 *
 * <pre><code>
 * TransportChannelProvider transportChannelProvider = ...;
 * if (transportChannelProvider.needsHeaders()) {
 *   transportChannelProvider = transportChannelProvider.withHeaders(headers);
 * }
 * // optional: set executor for TransportChannel
 * transportChannelProvider.withExecutor(executor);
 * TransportChannel transportChannel = transportChannelProvider.getTransportChannel();
 * </code></pre>
 */
@InternalExtensionOnly
public interface TransportChannelProvider {
  /** Indicates whether the TransportChannel should be closed by the containing client class. */
  boolean shouldAutoClose();

  /**
   * True if the TransportProvider needs an executor.
   *
   * @deprecated Channel providers will have default executors if they need one.
   */
  @Deprecated
  boolean needsExecutor();

  /** Sets the executor to use when constructing a new {@link TransportChannel}. */
  TransportChannelProvider withExecutor(Executor executor);

  /**
   * @deprecated Please use {@link #withExecutor(Executor)}.
   */
  @Deprecated
  TransportChannelProvider withExecutor(ScheduledExecutorService executor);

  /**
   * True if the TransportProvider needs a background executor. The background executor can be used
   * for refreshing channels, resizing the channel pool etc.
   */
  default boolean needsBackgroundExecutor() {
    return false;
  }

  /** Sets the background executor when constructing a new {@link TransportChannel}. */
  default TransportChannelProvider withBackgroundExecutor(ScheduledExecutorService executor) {
    return this;
  }

  /** True if the TransportProvider has no headers provided. */
  boolean needsHeaders();

  /**
   * Sets the headers to use when constructing a new {@link TransportChannel}.
   *
   * <p>This method should only be called if {@link #needsHeaders()} returns true.
   */
  TransportChannelProvider withHeaders(Map<String, String> headers);

  /** True if the TransportProvider has no endpoint set. */
  boolean needsEndpoint();

  /**
   * Sets the endpoint to use when constructing a new {@link TransportChannel}.
   *
   * <p>This method should only be called if {@link #needsEndpoint()} returns true.
   */
  TransportChannelProvider withEndpoint(String endpoint);

  /** True for gRPC transport provider which has no mtlsEndpoint set. */
  default boolean needsMtlsEndpoint() {
    return false;
  }

  /**
   * Sets the mTLS endpoint to use when constructing a new {@link TransportChannel} using S2A.
   *
   * <p>This method should only be called if {@link #needsMtlsEndpoint()} returns true.
   */
  default TransportChannelProvider withMtlsEndpoint(String mtlsEndpoint) {
    return this;
  }

  /** Sets whether to use S2A when constructing a new {@link TransportChannel}. */
  @BetaApi(
      "The S2A feature is not stable yet and may change in the future. https://github.com/grpc/grpc-java/issues/11533.")
  default TransportChannelProvider withUseS2A(boolean useS2A) {
    return this;
  }

  /**
   * Reports whether this provider allows pool size customization.
   *
   * @deprecated Pool settings should be configured on the builder of the specific implementation.
   */
  @Deprecated
  boolean acceptsPoolSize();

  /**
   * Number of underlying transport channels to open. Calls will be load balanced across them.
   *
   * @deprecated Pool settings should be configured on the builder of the specific implementation.
   */
  @Deprecated
  TransportChannelProvider withPoolSize(int size);

  /** True if credentials are needed before channel creation. */
  @BetaApi("The surface to customize credentials is not stable yet and may change in the future.")
  boolean needsCredentials();

  /** Sets the credentials that will be applied before channel creation. */
  @BetaApi("The surface to customize credentials is not stable yet and may change in the future.")
  TransportChannelProvider withCredentials(Credentials credentials);

  /**
   * Provides a Transport, which could either be a new instance for every call, or the same
   * instance, depending on the implementation.
   *
   * <p>If {@link #needsExecutor()} is true, then {@link #withExecutor(Executor)} needs to be called
   * first to provide an executor.
   *
   * <p>If {@link #needsHeaders()} is true, then {@link #withHeaders(Map)} needs to be called first
   * to provide headers.
   *
   * <p>if {@link #needsEndpoint()} is true, then {@link #withEndpoint(String)} needs to be called
   * first to provide an endpoint.
   */
  TransportChannel getTransportChannel() throws IOException;

  /**
   * The name of the transport.
   *
   * <p>This string can be used for identifying transports for switching logic.
   */
  String getTransportName();

  /**
   * User set custom endpoint for the Transport Channel Provider
   *
   * <p>This is the unresolved endpoint used by GAPICs
   */
  default String getEndpoint() {
    return null;
  }
}
