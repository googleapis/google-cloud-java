/*
 * Copyright 2026 Google LLC
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
import com.google.api.core.InternalApi;
import com.google.common.annotations.VisibleForTesting;
import java.io.IOException;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Helpers for bridging a stub's transport configuration to the HTTP/JSON {@link ClientContext} used
 * for resumable uploads. Designed for use by generated code.
 */
@BetaApi
@InternalApi
@NullMarked
public final class ResumableUploadTransportBridge {

  private static final ApiCallContext.Key<Boolean> NON_SETTINGS_TRANSPORT_CUSTOMIZATION_KEY =
      ApiCallContext.Key.create("resumable_upload_non_settings_transport_customization");

  private static final String CLIENT_CONTEXT_FAILURE_MESSAGE =
      "Failed to initialize the HTTP/JSON client context required for resumable uploads."
          + " Resumable uploads run over HTTP/JSON using only the endpoint, credentials, and"
          + " headers configured on the service Settings; create the client or stub from Settings"
          + " rather than a ClientContext.";

  static final String NON_SETTINGS_TRANSPORT_CUSTOMIZATION_HINT =
      "This client configures the endpoint, credentials, or headers outside the service Settings"
          + " (on the TransportChannelProvider or via a pre-built channel). Resumable uploads do"
          + " not use the TransportChannelProvider or pre-built channel; configure the endpoint,"
          + " credentials, and headers on the Settings instead.";

  private ResumableUploadTransportBridge() {}

  /**
   * Creates the HTTP/JSON {@link ClientContext} used for resumable uploads. If {@code settings}
   * already uses an HTTP/JSON transport, the context is created from {@code settings} unchanged.
   * Otherwise the transport channel provider and internal headers are replaced with the given
   * HTTP/JSON equivalents, and if the original transport channel provider was customized outside
   * the settings, the context is marked so that upload failures can surface an actionable hint.
   */
  public static ClientContext createUploadClientContext(
      StubSettings<?> settings,
      TransportChannelProvider httpJsonChannelProvider,
      HeaderProvider httpJsonInternalHeaderProvider)
      throws IOException {
    TransportChannelProvider original = settings.getTransportChannelProvider();
    if (original.getTransportName().equals(httpJsonChannelProvider.getTransportName())) {
      return ClientContext.create(settings);
    }
    StubSettings.Builder<?, ?> builder = settings.toBuilder();
    builder.setInternalHeaderProvider(httpJsonInternalHeaderProvider);
    builder.setTransportChannelProvider(httpJsonChannelProvider);
    ClientContext uploadContext = ClientContext.create(builder.build());
    if (!isCustomizedOutsideSettings(original)) {
      return uploadContext;
    }
    return markNonSettingsTransportCustomization(uploadContext);
  }

  @VisibleForTesting
  static ClientContext markNonSettingsTransportCustomization(ClientContext uploadContext) {
    return uploadContext.toBuilder()
        .setDefaultCallContext(
            uploadContext
                .getDefaultCallContext()
                .withOption(NON_SETTINGS_TRANSPORT_CUSTOMIZATION_KEY, true))
        .build();
  }

  /**
   * Creates a {@link ResumableUploadCallable} that synchronously throws an {@link
   * IllegalStateException} with the given cause when invoked because the HTTP/JSON client context
   * required for resumable uploads could not be created.
   */
  public static <RequestT, ResponseT> ResumableUploadCallable<RequestT, ResponseT> failingCallable(
      Throwable cause) {
    return new FailingResumableUploadCallable<>(cause);
  }

  /**
   * Returns {@code true} if {@code callContext} was marked by {@link #createUploadClientContext}
   * because the original transport channel provider was customized outside the stub's settings.
   */
  static boolean hasNonSettingsTransportCustomization(ApiCallContext callContext) {
    return Boolean.TRUE.equals(callContext.getOption(NON_SETTINGS_TRANSPORT_CUSTOMIZATION_KEY));
  }

  /**
   * Returns {@code true} if {@code provider} does not need the endpoint, credentials, or headers
   * from the stub's settings, meaning they were configured on the provider directly or the provider
   * wraps a pre-built channel.
   */
  private static boolean isCustomizedOutsideSettings(TransportChannelProvider provider) {
    return !provider.needsHeaders() || !provider.needsCredentials() || !provider.needsEndpoint();
  }

  private static final class FailingResumableUploadCallable<RequestT, ResponseT>
      extends ResumableUploadCallable<RequestT, ResponseT> {

    private final Throwable cause;

    private FailingResumableUploadCallable(Throwable cause) {
      this.cause = cause;
    }

    @Override
    public ResumableUploadFuture<ResponseT> futureCall(
        RequestT request,
        InputStreamSupplier payload,
        @Nullable ApiCallContext context,
        @Nullable ResumableUploadOptions options) {
      throw new IllegalStateException(CLIENT_CONTEXT_FAILURE_MESSAGE, cause);
    }

    @Override
    public ResumableUploadFuture<ResponseT> resumeCall(
        String sessionUrl, InputStreamSupplier payload, @Nullable ResumableUploadOptions options) {
      throw new IllegalStateException(CLIENT_CONTEXT_FAILURE_MESSAGE, cause);
    }
  }
}
