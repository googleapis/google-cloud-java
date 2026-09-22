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
import com.google.api.core.ApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/** A {@link UnaryCallable} that transmits individual chunks in a resumable upload session. */
@NullMarked
class ResumableUploadChunkCallable<ResponseT>
    extends UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> {

  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_OFFSET_HEADER = "X-Goog-Upload-Offset";
  private static final String UPLOAD_STATUS_HEADER = "X-Goog-Upload-Status";
  private static final String STATUS_FINAL = "final";

  private static final String COMMAND_UPLOAD = "upload";
  private static final String COMMAND_FINALIZE = "finalize";
  private static final String COMMAND_UPLOAD_FINALIZE = "upload, finalize";

  private static final PathTemplate PATH_TEMPLATE = PathTemplate.create("**");

  private static final ApiMethodDescriptor<ChunkUploadRequest, String> UPLOAD_CHUNK_DESCRIPTOR =
      ApiMethodDescriptor.<ChunkUploadRequest, String>newBuilder()
          .setFullMethodName("ResumableUpload/UploadChunk")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new ResumableUploadChunkRequestFormatter<ChunkUploadRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(ChunkUploadRequest request) {
                  return Collections.emptyMap();
                }

                @Override
                public byte[] getBinaryRequestBody(ChunkUploadRequest request) {
                  return request.getPayload();
                }

                @Override
                public String getPath(ChunkUploadRequest request) {
                  return request.getUploadUrl();
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PATH_TEMPLATE;
                }
              })
          .setResponseParser(ResumableUploadResponseParser.create())
          .build();

  private final ClientContext clientContext;
  private final HttpResponseParser<ResponseT> responseParser;

  private ResumableUploadChunkCallable(
      ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    this.clientContext = Preconditions.checkNotNull(clientContext);
    this.responseParser = Preconditions.checkNotNull(responseParser);
  }

  @Override
  public ApiFuture<ChunkUploadResponse<ResponseT>> futureCall(
      ChunkUploadRequest request, @Nullable ApiCallContext inputContext) {
    Preconditions.checkNotNull(request);
    boolean isPayloadEmpty = request.getPayload().length == 0;
    String command;
    if (request.isFinal()) {
      command = !isPayloadEmpty ? COMMAND_UPLOAD_FINALIZE : COMMAND_FINALIZE;
    } else {
      command = COMMAND_UPLOAD;
    }
    ImmutableMap.Builder<String, List<String>> chunkHeadersBuilder =
        ImmutableMap.<String, List<String>>builder()
            .put(UPLOAD_COMMAND_HEADER, ImmutableList.of(command));
    if (!COMMAND_FINALIZE.equals(command)) {
      chunkHeadersBuilder.put(
          UPLOAD_OFFSET_HEADER, ImmutableList.of(String.valueOf(request.getOffset())));
    }
    Map<String, List<String>> chunkHeaders = chunkHeadersBuilder.build();

    HttpJsonCallContext context =
        (HttpJsonCallContext)
            HttpJsonCallContext.createDefault()
                .nullToSelf(clientContext.getDefaultCallContext())
                .merge(inputContext)
                .withExtraHeaders(chunkHeaders);

    HttpJsonClientCall<ChunkUploadRequest, String> clientCall =
        HttpJsonClientCalls.newCall(UPLOAD_CHUNK_DESCRIPTOR, context);

    ResumableUploadHttpJsonFuture<ChunkUploadResponse<ResponseT>> future =
        new ResumableUploadHttpJsonFuture<>(clientCall);
    HttpJsonClientCalls.startUnaryCall(
        clientCall, request, context, new ChunkUploadResponseListener<>(future, responseParser));

    return future;
  }

  static <ResponseT> UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> create(
      ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> rawCallable =
        new ResumableUploadChunkCallable<>(clientContext, responseParser);
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> callable =
        new HttpJsonExceptionCallable<>(
            rawCallable,
            // Wire calls do not retry directly; retries are managed by ResumableUploadCallable.
            Collections.emptySet());
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  /**
   * A listener that processes chunk upload response headers and bodies to produce the {@link
   * ChunkUploadResponse}.
   */
  private static class ChunkUploadResponseListener<ResponseT>
      extends HttpJsonClientCall.Listener<String> {

    private final ResumableUploadHttpJsonFuture<ChunkUploadResponse<ResponseT>> future;
    private final HttpResponseParser<ResponseT> responseParser;
    @Nullable private String uploadStatus = null;
    private String responseBody = "";

    private ChunkUploadResponseListener(
        ResumableUploadHttpJsonFuture<ChunkUploadResponse<ResponseT>> future,
        HttpResponseParser<ResponseT> responseParser) {
      this.future = future;
      this.responseParser = responseParser;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      Map<String, Object> headers = responseHeaders.getHeaders();
      this.uploadStatus = HttpHeadersUtils.getSingleHeader(headers, UPLOAD_STATUS_HEADER);
    }

    @Override
    public void onMessage(@Nullable String message) {
      if (message != null) {
        this.responseBody = message;
      }
    }

    @Override
    public void onClose(int statusCode, HttpJsonMetadata trailers) {
      try {
        if (statusCode >= 200 && statusCode < 300) {
          if (uploadStatus == null) {
            future.setException(
                ApiExceptionFactory.createException(
                    "Upload chunk response did not contain valid "
                        + UPLOAD_STATUS_HEADER
                        + " header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
            return;
          }
          boolean isComplete = STATUS_FINAL.equalsIgnoreCase(uploadStatus);
          ChunkUploadResponse.Builder<ResponseT> chunkResponseBuilder =
              ChunkUploadResponse.<ResponseT>newBuilder().setComplete(isComplete);
          if (isComplete) {
            InputStream stream =
                new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8));
            chunkResponseBuilder.setResponse(responseParser.parse(stream));
          }
          future.set(chunkResponseBuilder.build());
        } else {
          Throwable cause = trailers.getException();
          future.setException(
              cause != null
                  ? cause
                  : new HttpJsonStatusRuntimeException(
                      statusCode, "Failed to upload chunk with status code: " + statusCode, null));
        }
      } catch (Throwable t) {
        future.setException(t);
      }
    }
  }
}
