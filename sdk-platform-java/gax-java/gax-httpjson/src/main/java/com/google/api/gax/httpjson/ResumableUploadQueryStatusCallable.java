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
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
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

/**
 * A {@link UnaryCallable} that queries the committed status and offset of a resumable upload
 * session.
 */
@NullMarked
class ResumableUploadQueryStatusCallable<ResponseT>
    extends UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> {

  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_STATUS_HEADER = "X-Goog-Upload-Status";
  private static final String UPLOAD_SIZE_RECEIVED_HEADER = "X-Goog-Upload-Size-Received";
  private static final String STATUS_FINAL = "final";
  private static final String COMMAND_QUERY = "query";

  private static final Map<String, List<String>> QUERY_STATUS_HEADERS =
      ImmutableMap.of(UPLOAD_COMMAND_HEADER, ImmutableList.of(COMMAND_QUERY));

  private static final PathTemplate PATH_TEMPLATE = PathTemplate.create("**");

  private static final ApiMethodDescriptor<QueryStatusRequest, String> QUERY_STATUS_DESCRIPTOR =
      ApiMethodDescriptor.<QueryStatusRequest, String>newBuilder()
          .setFullMethodName("ResumableUpload/QueryStatus")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new HttpRequestFormatter<QueryStatusRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(QueryStatusRequest request) {
                  return Collections.emptyMap();
                }

                @Override
                public String getRequestBody(QueryStatusRequest request) {
                  return "";
                }

                @Override
                public String getPath(QueryStatusRequest request) {
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

  private ResumableUploadQueryStatusCallable(
      ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    this.clientContext = Preconditions.checkNotNull(clientContext);
    this.responseParser = Preconditions.checkNotNull(responseParser);
  }

  @Override
  public ApiFuture<QueryStatusResponse<ResponseT>> futureCall(
      QueryStatusRequest request, @Nullable ApiCallContext inputContext) {
    Preconditions.checkNotNull(request);
    HttpJsonCallContext context =
        (HttpJsonCallContext)
            HttpJsonCallContext.createDefault()
                .nullToSelf(clientContext.getDefaultCallContext())
                .merge(inputContext)
                .withExtraHeaders(QUERY_STATUS_HEADERS);

    HttpJsonClientCall<QueryStatusRequest, String> clientCall =
        HttpJsonClientCalls.newCall(QUERY_STATUS_DESCRIPTOR, context);

    ResumableUploadHttpJsonFuture<QueryStatusResponse<ResponseT>> future =
        new ResumableUploadHttpJsonFuture<>(clientCall);
    HttpJsonClientCalls.startUnaryCall(
        clientCall, request, context, new QueryStatusResponseListener<>(future, responseParser));

    return future;
  }

  static <ResponseT> UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> create(
      ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> rawCallable =
        new ResumableUploadQueryStatusCallable<>(clientContext, responseParser);
    UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> callable =
        new HttpJsonExceptionCallable<>(
            rawCallable,
            // Wire calls do not retry directly; retries are managed by ResumableUploadCallable.
            Collections.emptySet());
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  @Nullable
  private static Long parseSizeReceived(HttpJsonMetadata responseHeaders) {
    String sizeReceivedStr =
        HttpHeadersUtils.getSingleHeader(responseHeaders.getHeaders(), UPLOAD_SIZE_RECEIVED_HEADER);
    if (!Strings.isNullOrEmpty(sizeReceivedStr)) {
      try {
        long parsed = Long.parseLong(sizeReceivedStr);
        if (parsed < 0) {
          throw ApiExceptionFactory.createException(
              "Response contained negative "
                  + UPLOAD_SIZE_RECEIVED_HEADER
                  + " header: "
                  + sizeReceivedStr,
              /* cause= */ null,
              HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
              /* retryable= */ false);
        }
        return parsed;
      } catch (NumberFormatException e) {
        throw ApiExceptionFactory.createException(
            "Response contained invalid "
                + UPLOAD_SIZE_RECEIVED_HEADER
                + " header: "
                + sizeReceivedStr,
            e,
            HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
            /* retryable= */ false);
      }
    }
    return null;
  }

  /** A listener that parses query response headers to produce the {@link QueryStatusResponse}. */
  private static class QueryStatusResponseListener<ResponseT>
      extends HttpJsonClientCall.Listener<String> {

    private final ResumableUploadHttpJsonFuture<QueryStatusResponse<ResponseT>> future;
    private final HttpResponseParser<ResponseT> responseParser;
    @Nullable private String uploadStatus = null;
    @Nullable private Long committedOffset = null;
    @Nullable private Throwable headerParsingException;
    private String responseBody = "";

    private QueryStatusResponseListener(
        ResumableUploadHttpJsonFuture<QueryStatusResponse<ResponseT>> future,
        HttpResponseParser<ResponseT> responseParser) {
      this.future = future;
      this.responseParser = responseParser;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      Map<String, Object> headers = responseHeaders.getHeaders();
      this.uploadStatus = HttpHeadersUtils.getSingleHeader(headers, UPLOAD_STATUS_HEADER);
      try {
        this.committedOffset = parseSizeReceived(responseHeaders);
      } catch (Throwable t) {
        this.headerParsingException = t;
      }
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
          if (headerParsingException != null) {
            future.setException(headerParsingException);
            return;
          }
          boolean isComplete = STATUS_FINAL.equalsIgnoreCase(uploadStatus);
          if (isComplete) {
            QueryStatusResponse.Builder<ResponseT> queryResponseBuilder =
                QueryStatusResponse.<ResponseT>newBuilder().setComplete(true);
            InputStream stream =
                new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8));
            queryResponseBuilder.setResponse(responseParser.parse(stream));
            future.set(queryResponseBuilder.build());
          } else if (committedOffset != null) {
            future.set(
                QueryStatusResponse.<ResponseT>newBuilder()
                    .setComplete(false)
                    .setCommittedOffset(committedOffset)
                    .build());
          } else {
            future.setException(
                ApiExceptionFactory.createException(
                    "Query status response did not contain valid "
                        + UPLOAD_SIZE_RECEIVED_HEADER
                        + " header",
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
                      statusCode,
                      "Failed to query upload status with status code: " + statusCode,
                      null));
        }
      } catch (Throwable t) {
        future.setException(t);
      }
    }
  }
}
