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

import com.google.api.core.ApiFuture;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** A {@link UnaryCallable} that initiates a resumable upload session. */
@NullMarked
class ResumableUploadStartCallable<RequestT>
    extends UnaryCallable<RequestT, ResumableUploadSession> {

  private static final String UPLOAD_PROTOCOL_HEADER = "X-Goog-Upload-Protocol";
  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_URL_HEADER = "X-Goog-Upload-URL";
  private static final String UPLOAD_GRANULARITY_HEADER = "X-Goog-Upload-Chunk-Granularity";

  private static final Map<String, List<String>> START_UPLOAD_HEADERS =
      ImmutableMap.of(
          UPLOAD_PROTOCOL_HEADER, ImmutableList.of("resumable"),
          UPLOAD_COMMAND_HEADER, ImmutableList.of("start"));

  private final ApiMethodDescriptor<RequestT, String> descriptor;
  private final ClientContext clientContext;

  private ResumableUploadStartCallable(
      ClientContext clientContext, ApiMethodDescriptor<RequestT, String> descriptor) {
    this.clientContext = Preconditions.checkNotNull(clientContext);
    this.descriptor = Preconditions.checkNotNull(descriptor);
  }

  @Override
  public ApiFuture<ResumableUploadSession> futureCall(
      RequestT request, @Nullable ApiCallContext inputContext) {
    Preconditions.checkNotNull(request);
    HttpJsonCallContext context =
        (HttpJsonCallContext)
            HttpJsonCallContext.createDefault()
                .nullToSelf(clientContext.getDefaultCallContext())
                .merge(inputContext)
                .withExtraHeaders(START_UPLOAD_HEADERS);

    HttpJsonClientCall<RequestT, String> clientCall =
        HttpJsonClientCalls.newCall(descriptor, context);

    ResumableUploadHttpJsonFuture<ResumableUploadSession> future =
        new ResumableUploadHttpJsonFuture<>(clientCall);
    HttpJsonClientCalls.startUnaryCall(
        clientCall, request, context, new StartUploadResponseListener(future));

    return future;
  }

  static <RequestT> UnaryCallable<RequestT, ResumableUploadSession> create(
      ClientContext clientContext, ApiMethodDescriptor<RequestT, String> descriptor) {
    UnaryCallable<RequestT, ResumableUploadSession> rawCallable =
        new ResumableUploadStartCallable<>(clientContext, descriptor);
    UnaryCallable<RequestT, ResumableUploadSession> callable =
        new HttpJsonExceptionCallable<>(
            rawCallable,
            // Wire calls do not retry directly; retries are managed by ResumableUploadCallable.
            Collections.emptySet());
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /** A listener that parses HTTP response headers to produce a {@link ResumableUploadSession}. */
  private static class StartUploadResponseListener extends HttpJsonClientCall.Listener<String> {
    private final ResumableUploadHttpJsonFuture<ResumableUploadSession> future;
    private long chunkGranularity = 1L;
    @Nullable private String uploadUrl;
    @Nullable private Throwable headerParsingException;

    private StartUploadResponseListener(
        ResumableUploadHttpJsonFuture<ResumableUploadSession> future) {
      this.future = future;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      Map<String, Object> headers = responseHeaders.getHeaders();

      String url = HttpHeadersUtils.getSingleHeader(headers, UPLOAD_URL_HEADER);
      if (!Strings.isNullOrEmpty(url)) {
        this.uploadUrl = url;
      }

      String granularityStr = HttpHeadersUtils.getSingleHeader(headers, UPLOAD_GRANULARITY_HEADER);
      if (Strings.isNullOrEmpty(granularityStr)) {
        return;
      }

      try {
        long parsed = Long.parseLong(granularityStr);
        if (parsed <= 0) {
          this.headerParsingException =
              ApiExceptionFactory.createException(
                  "Start upload response contained non-positive chunk granularity header: "
                      + granularityStr,
                  /* cause= */ null,
                  HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                  /* retryable= */ false);
        } else {
          this.chunkGranularity = parsed;
        }
      } catch (NumberFormatException e) {
        this.headerParsingException =
            ApiExceptionFactory.createException(
                "Start upload response contained invalid chunk granularity header: "
                    + granularityStr,
                e,
                HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                /* retryable= */ false);
      }
    }

    @Override
    public void onMessage(@Nullable String message) {
      // Response body is not needed for startUpload; session URL is in headers.
    }

    @Override
    public void onClose(int statusCode, HttpJsonMetadata trailers) {
      try {
        if (statusCode >= 200 && statusCode < 300) {
          if (headerParsingException != null) {
            future.setException(headerParsingException);
            return;
          }
          if (!Strings.isNullOrEmpty(uploadUrl)) {
            future.set(
                ResumableUploadSession.newBuilder()
                    .setUploadUrl(uploadUrl)
                    .setChunkGranularity(chunkGranularity)
                    .build());
          } else {
            future.setException(
                ApiExceptionFactory.createException(
                    "Start upload response did not contain upload session URL header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
          }
        } else {
          Throwable cause = trailers.getException();
          future.setException(
              cause != null
                  ? cause
                  : new HttpJsonStatusRuntimeException(
                      statusCode, "Failed to start upload with status code: " + statusCode, null));
        }
      } catch (Throwable t) {
        future.setException(t);
      }
    }
  }
}
