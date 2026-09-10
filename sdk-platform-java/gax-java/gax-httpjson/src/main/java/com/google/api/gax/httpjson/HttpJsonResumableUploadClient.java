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

import com.google.api.client.http.HttpMethods;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import org.jspecify.annotations.NullMarked;

/**
 * Implementation of {@link ResumableUploadClient} using HTTP/JSON transport.
 *
 * <p>Executes the low-level HTTP wire calls for managing resumable upload sessions.
 *
 * @param <RequestT> request type for starting an upload
 * @param <ResponseT> response type of the upload method
 */
@NullMarked
@BetaApi
@InternalApi
public final class HttpJsonResumableUploadClient<RequestT, ResponseT>
    implements ResumableUploadClient<RequestT, ResponseT> {

  private final UnaryCallable<RequestT, ResumableUploadSession> startUploadCallable;
  private final UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      uploadChunkCallable;
  private final UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      queryStatusCallable;

  public static <RequestT, ResponseT> HttpJsonResumableUploadClient<RequestT, ResponseT> create(
      ClientContext clientContext, ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor) {
    return new HttpJsonResumableUploadClient<>(clientContext, methodDescriptor);
  }

  private HttpJsonResumableUploadClient(
      ClientContext clientContext, ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor) {
    Preconditions.checkNotNull(clientContext);
    Preconditions.checkNotNull(methodDescriptor);
    HttpResponseParser<ResponseT> responseParser =
        Preconditions.checkNotNull(methodDescriptor.getResponseParser());

    ApiMethodDescriptor<RequestT, String> startUploadDescriptor =
        ApiMethodDescriptor.<RequestT, String>newBuilder()
            .setFullMethodName(methodDescriptor.getFullMethodName())
            .setHttpMethod(HttpMethods.POST)
            .setType(ApiMethodDescriptor.MethodType.UNARY)
            .setRequestFormatter(methodDescriptor.getRequestFormatter())
            .setResponseParser(ResumableUploadResponseParser.create())
            .build();
    this.startUploadCallable =
        ResumableUploadStartCallable.create(clientContext, startUploadDescriptor);
    this.uploadChunkCallable = ResumableUploadChunkCallable.create(clientContext, responseParser);
    this.queryStatusCallable =
        ResumableUploadQueryStatusCallable.create(clientContext, responseParser);
  }

  @Override
  public UnaryCallable<RequestT, ResumableUploadSession> startUploadCallable() {
    return startUploadCallable;
  }

  @Override
  public UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> uploadChunkCallable() {
    return uploadChunkCallable;
  }

  @Override
  public UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> queryStatusCallable() {
    return queryStatusCallable;
  }
}
