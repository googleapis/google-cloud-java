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
package com.google.api.gax.httpjson;

import com.google.api.client.http.HttpTransport;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ResumableUploadCallSettings;
import com.google.api.gax.rpc.ResumableUploadCallable;
import com.google.api.gax.rpc.ResumableUploadRequest;
import com.google.common.base.Preconditions;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

/**
 * A {@link ResumableUploadCallable} that uses HTTP/JSON transport.
 *
 * @param <RequestT> request type
 * @param <ResponseT> response type
 */
@BetaApi
public final class HttpJsonResumableUploadCallable<RequestT, ResponseT>
    extends ResumableUploadCallable<RequestT, ResponseT> {

  private final HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings;
  @Nullable private final ResumableUploadCallSettings<RequestT, ResponseT> defaultCallSettings;
  private final ClientContext clientContext;

  public HttpJsonResumableUploadCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings,
      @Nullable ResumableUploadCallSettings<RequestT, ResponseT> defaultCallSettings,
      ClientContext clientContext) {
    this.httpJsonCallSettings = Preconditions.checkNotNull(httpJsonCallSettings);
    this.defaultCallSettings = defaultCallSettings;
    this.clientContext = Preconditions.checkNotNull(clientContext);
  }

  public HttpJsonResumableUploadCallable(
      HttpJsonCallSettings<RequestT, ResponseT> httpJsonCallSettings, ClientContext clientContext) {
    this(httpJsonCallSettings, null, clientContext);
  }

  @Override
  public ApiFuture<ResponseT> futureCall(
      ResumableUploadRequest<RequestT> request, ApiCallContext context) {
    return futureCall(request, null, context);
  }

  @Override
  public ApiFuture<ResponseT> futureCall(
      ResumableUploadRequest<RequestT> request,
      ResumableUploadCallSettings<RequestT, ResponseT> perRequestSettings,
      ApiCallContext context) {
    Preconditions.checkNotNull(request);

    ResumableUploadCallSettings<RequestT, ResponseT> activeSettings =
        defaultCallSettings != null
            ? defaultCallSettings.mergeWith(perRequestSettings)
            : perRequestSettings;

    int chunkSize =
        activeSettings != null
            ? activeSettings.getChunkSizeOrDefault()
            : 8 * 1024 * 1024; // default 8 MB

    // Resolve call context
    HttpJsonCallContext httpJsonContext = HttpJsonCallContext.createDefault();
    if (context != null) {
      httpJsonContext = httpJsonContext.nullToSelf(context);
    }

    // Resolve channel and endpoint
    HttpJsonTransportChannel transportChannel =
        (HttpJsonTransportChannel) clientContext.getTransportChannel();
    ManagedHttpJsonChannel channel = transportChannel.getManagedChannel();
    String endpoint = channel.getEndpoint();
    HttpTransport httpTransport = channel.getHttpTransport();

    // Resolve credentials and executor
    HttpJsonCallOptions callOptions = httpJsonContext.getCallOptions();
    if (callOptions.getCredentials() == null && clientContext.getCredentials() != null) {
      callOptions = callOptions.toBuilder().setCredentials(clientContext.getCredentials()).build();
    }

    Executor executor = clientContext.getExecutor();

    // Gather request headers
    HttpJsonMetadata requestHeaders =
        HttpJsonMetadata.newBuilder().build().withHeaders(httpJsonContext.getExtraHeaders());

    HttpJsonResumableUploadCall<RequestT, ResponseT> call =
        new HttpJsonResumableUploadCall<>(
            httpJsonCallSettings.getMethodDescriptor(),
            request,
            httpTransport,
            requestHeaders,
            callOptions,
            endpoint,
            executor);

    return call.execute();
  }
}
