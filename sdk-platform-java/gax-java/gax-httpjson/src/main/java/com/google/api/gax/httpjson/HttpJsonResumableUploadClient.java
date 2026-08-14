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

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpMethods;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

/**
 * Implementation of {@link ResumableUploadClient} using HTTP/JSON transport.
 *
 * <p>Executes the low-level HTTP wire calls for managing resumable upload sessions.
 */
@InternalApi
public final class HttpJsonResumableUploadClient implements ResumableUploadClient {

  private static final String UPLOAD_PROTOCOL_HEADER = "X-Goog-Upload-Protocol";
  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_URL_HEADER = "X-Goog-Upload-URL";
  private static final String UPLOAD_GRANULARITY_HEADER = "X-Goog-Upload-Chunk-Granularity";

  private static final ApiMethodDescriptor<StartUploadRequest, String> START_UPLOAD_DESCRIPTOR =
      ApiMethodDescriptor.<StartUploadRequest, String>newBuilder()
          .setFullMethodName("ResumableUpload/StartUpload")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new HttpRequestFormatter<StartUploadRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(StartUploadRequest request) {
                  return request.getQueryParams();
                }

                @Override
                public String getRequestBody(StartUploadRequest request) {
                  return request.getJsonPayload();
                }

                @Override
                public String getPath(StartUploadRequest request) {
                  return request.getPath();
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PathTemplate.create("{+path}");
                }
              })
          .setResponseParser(StringHttpResponseParser.create())
          .build();

  private final ClientContext clientContext;

  public static HttpJsonResumableUploadClient create(ClientContext clientContext) {
    return new HttpJsonResumableUploadClient(clientContext);
  }

  private HttpJsonResumableUploadClient(ClientContext clientContext) {
    this.clientContext = Preconditions.checkNotNull(clientContext);
  }

  @Override
  public UnaryCallable<StartUploadRequest, ResumableUploadSession> startUploadCallable() {
    return new UnaryCallable<StartUploadRequest, ResumableUploadSession>() {
      @Override
      public ApiFuture<ResumableUploadSession> futureCall(
          StartUploadRequest request, ApiCallContext inputContext) {
        Preconditions.checkNotNull(request);
        HttpJsonCallContext context =
            HttpJsonCallContext.createDefault()
                .nullToSelf(clientContext.getDefaultCallContext())
                .merge(inputContext);

        Map<String, List<String>> extraHeaders = new HashMap<>(context.getExtraHeaders());
        extraHeaders.putIfAbsent(UPLOAD_PROTOCOL_HEADER, Collections.singletonList("resumable"));
        extraHeaders.putIfAbsent(UPLOAD_COMMAND_HEADER, Collections.singletonList("start"));
        context = (HttpJsonCallContext) context.withExtraHeaders(extraHeaders);

        HttpJsonClientCall<StartUploadRequest, String> clientCall =
            HttpJsonClientCalls.newCall(START_UPLOAD_DESCRIPTOR, context);

        SettableApiFuture<ResumableUploadSession> future = SettableApiFuture.create();
        clientCall.start(
            new StartUploadResponseListener(future),
            HttpJsonClientCalls.getMetadataWithTraceContext(context));

        try {
          clientCall.sendMessage(request);
          clientCall.halfClose();
          clientCall.request(2);
        } catch (Throwable sendError) {
          try {
            clientCall.cancel(null, sendError);
          } catch (Throwable ignored) {
          }
          throw sendError;
        }

        return future;
      }
    };
  }

  private static class StartUploadResponseListener extends HttpJsonClientCall.Listener<String> {

    private final SettableApiFuture<ResumableUploadSession> future;
    @Nullable private String uploadUrl;
    private long chunkGranularity = 1L;

    StartUploadResponseListener(SettableApiFuture<ResumableUploadSession> future) {
      this.future = future;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      if (responseHeaders != null && responseHeaders.getHeaders() != null) {
        HttpHeaders headers;
        if (responseHeaders.getHeaders() instanceof HttpHeaders) {
          headers = (HttpHeaders) responseHeaders.getHeaders();
        } else {
          headers = new HttpHeaders();
          headers.putAll(responseHeaders.getHeaders());
        }

        String url = headers.getFirstHeaderStringValue(UPLOAD_URL_HEADER);
        if (Strings.isNullOrEmpty(url)) {
          url = headers.getLocation();
        }
        if (!Strings.isNullOrEmpty(url)) {
          this.uploadUrl = url;
        }

        String granularityStr = headers.getFirstHeaderStringValue(UPLOAD_GRANULARITY_HEADER);
        if (!Strings.isNullOrEmpty(granularityStr)) {
          try {
            this.chunkGranularity = Long.parseLong(granularityStr);
          } catch (NumberFormatException ignored) {
            this.chunkGranularity = 1L;
          }
        }
      }
    }

    @Override
    public void onMessage(@Nullable String message) {}

    @Override
    public void onClose(int statusCode, HttpJsonMetadata trailers) {
      if (statusCode >= 200 && statusCode < 300) {
        if (!Strings.isNullOrEmpty(uploadUrl)) {
          future.set(ResumableUploadSession.create(uploadUrl, chunkGranularity));
        } else {
          future.setException(
              new HttpJsonStatusRuntimeException(
                  statusCode,
                  "Start upload response did not contain upload session URL header",
                  null));
        }
      } else {
        future.setException(
            trailers != null && trailers.getException() != null
                ? trailers.getException()
                : new HttpJsonStatusRuntimeException(statusCode, "Failed to start upload", null));
      }
    }
  }
}
