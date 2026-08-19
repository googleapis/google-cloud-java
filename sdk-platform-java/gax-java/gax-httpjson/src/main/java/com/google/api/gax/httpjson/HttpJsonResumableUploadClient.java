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

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.EmptyContent;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMethods;
import com.google.api.core.ApiFuture;
import com.google.api.core.InternalApi;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
import com.google.api.gax.resumable.StartUploadRequest;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.ApiExceptionFactory;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Implementation of {@link ResumableUploadClient} using HTTP/JSON transport.
 *
 * <p>Executes the low-level HTTP wire calls for managing resumable upload sessions.
 */
@NullMarked
@InternalApi
public final class HttpJsonResumableUploadClient implements ResumableUploadClient {

  private static final HttpJsonApiExceptionFactory API_EXCEPTION_FACTORY =
      new HttpJsonApiExceptionFactory(Collections.emptySet());

  private static final String UPLOAD_PROTOCOL_HEADER = "X-Goog-Upload-Protocol";
  private static final String UPLOAD_COMMAND_HEADER = "X-Goog-Upload-Command";
  private static final String UPLOAD_OFFSET_HEADER = "X-Goog-Upload-Offset";
  private static final String UPLOAD_URL_HEADER = "X-Goog-Upload-URL";
  private static final String UPLOAD_GRANULARITY_HEADER = "X-Goog-Upload-Chunk-Granularity";
  private static final String UPLOAD_STATUS_HEADER = "X-Goog-Upload-Status";
  private static final String UPLOAD_SIZE_RECEIVED_HEADER = "X-Goog-Upload-Size-Received";
  private static final String STATUS_FINAL = "final";

  private static final Map<String, List<String>> START_UPLOAD_HEADERS =
      ImmutableMap.of(
          UPLOAD_PROTOCOL_HEADER, ImmutableList.of("resumable"),
          UPLOAD_COMMAND_HEADER, ImmutableList.of("start"));

  private static final PathTemplate PATH_TEMPLATE = PathTemplate.create("{+path}");

  private static final Map<String, List<String>> QUERY_STATUS_HEADERS =
      ImmutableMap.of(UPLOAD_COMMAND_HEADER, ImmutableList.of("query"));

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
                  return Strings.nullToEmpty(request.getJsonPayload());
                }

                @Override
                public String getPath(StartUploadRequest request) {
                  return request.getPath();
                }

                @Override
                public PathTemplate getPathTemplate() {
                  return PATH_TEMPLATE;
                }
              })
          .setResponseParser(StringHttpResponseParser.create())
          .build();

  private static final ApiMethodDescriptor<ChunkUploadRequest, String> UPLOAD_CHUNK_DESCRIPTOR =
      ApiMethodDescriptor.<ChunkUploadRequest, String>newBuilder()
          .setFullMethodName("ResumableUpload/UploadChunk")
          .setHttpMethod(HttpMethods.POST)
          .setType(ApiMethodDescriptor.MethodType.UNARY)
          .setRequestFormatter(
              new HttpRequestFormatter<ChunkUploadRequest>() {
                @Override
                public Map<String, List<String>> getQueryParamNames(ChunkUploadRequest request) {
                  return Collections.emptyMap();
                }

                @Override
                public String getRequestBody(ChunkUploadRequest request) {
                  return "";
                }

                @Override
                public HttpContent getHttpContent(ChunkUploadRequest request) {
                  if (!request.getPayload().isEmpty()) {
                    return new ByteArrayContent(
                        "application/octet-stream", request.getPayload().toByteArray());
                  }
                  return new EmptyContent();
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
          .setResponseParser(StringHttpResponseParser.create())
          .build();

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
                public HttpContent getHttpContent(QueryStatusRequest request) {
                  return new EmptyContent();
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
          StartUploadRequest request, @Nullable ApiCallContext inputContext) {
        Preconditions.checkNotNull(request);
        HttpJsonCallContext context =
            (HttpJsonCallContext)
                HttpJsonCallContext.createDefault()
                    .nullToSelf(clientContext.getDefaultCallContext())
                    .merge(inputContext)
                    .withExtraHeaders(START_UPLOAD_HEADERS);

        HttpJsonClientCall<StartUploadRequest, String> clientCall =
            HttpJsonClientCalls.newCall(START_UPLOAD_DESCRIPTOR, context);

        SettableApiFuture<ResumableUploadSession> future = SettableApiFuture.create();
        HttpJsonClientCalls.startUnaryCall(
            clientCall, request, context, new StartUploadResponseListener(future));

        return future;
      }
    };
  }

  @Override
  public UnaryCallable<ChunkUploadRequest, ChunkUploadResponse> uploadChunkCallable() {
    return new UnaryCallable<ChunkUploadRequest, ChunkUploadResponse>() {
      @Override
      public ApiFuture<ChunkUploadResponse> futureCall(
          ChunkUploadRequest request, @Nullable ApiCallContext inputContext) {
        Preconditions.checkNotNull(request);
        String command;
        if (request.isFinal()) {
          command = !request.getPayload().isEmpty() ? "upload, finalize" : "finalize";
        } else {
          command = "upload";
        }
        Map<String, List<String>> chunkHeaders =
            ImmutableMap.of(
                UPLOAD_COMMAND_HEADER,
                ImmutableList.of(command),
                UPLOAD_OFFSET_HEADER,
                ImmutableList.of(String.valueOf(request.getOffset())));

        HttpJsonCallContext context =
            (HttpJsonCallContext)
                HttpJsonCallContext.createDefault()
                    .nullToSelf(clientContext.getDefaultCallContext())
                    .merge(inputContext)
                    .withExtraHeaders(chunkHeaders);

        HttpJsonClientCall<ChunkUploadRequest, String> clientCall =
            HttpJsonClientCalls.newCall(UPLOAD_CHUNK_DESCRIPTOR, context);

        SettableApiFuture<ChunkUploadResponse> future = SettableApiFuture.create();
        HttpJsonClientCalls.startUnaryCall(
            clientCall, request, context, new ChunkUploadResponseListener(request, future));

        return future;
      }
    };
  }

  @Override
  public UnaryCallable<QueryStatusRequest, QueryStatusResponse> queryStatusCallable() {
    return new UnaryCallable<QueryStatusRequest, QueryStatusResponse>() {
      @Override
      public ApiFuture<QueryStatusResponse> futureCall(
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

        SettableApiFuture<QueryStatusResponse> future = SettableApiFuture.create();
        HttpJsonClientCalls.startUnaryCall(
            clientCall, request, context, new QueryStatusResponseListener(future));

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
      Map<String, Object> headers = responseHeaders.getHeaders();

      String url = HttpHeadersUtils.getFirstHeader(headers, UPLOAD_URL_HEADER);
      if (!Strings.isNullOrEmpty(url)) {
        this.uploadUrl = url;
      }

      String granularityStr = HttpHeadersUtils.getFirstHeader(headers, UPLOAD_GRANULARITY_HEADER);
      if (!Strings.isNullOrEmpty(granularityStr)) {
        try {
          this.chunkGranularity = Long.parseLong(granularityStr);
        } catch (NumberFormatException ignored) {
          this.chunkGranularity = 1L;
        }
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
          if (!Strings.isNullOrEmpty(uploadUrl)) {
            future.set(ResumableUploadSession.create(uploadUrl, chunkGranularity));
          } else {
            future.setException(
                ApiExceptionFactory.createException(
                    "Start upload response did not contain upload session URL header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
          }
        } else {
          future.setException(createApiException(statusCode, trailers, "Failed to start upload"));
        }
      } catch (Throwable t) {
        future.setException(
            ApiExceptionFactory.createException(
                "Internal error processing start upload response",
                t,
                HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                /* retryable= */ false));
      }
    }
  }

  private static class ChunkUploadResponseListener extends HttpJsonClientCall.Listener<String> {

    private final ChunkUploadRequest request;
    private final SettableApiFuture<ChunkUploadResponse> future;
    private boolean isComplete = false;
    private long committedOffset = -1L;
    private String responseBody = "";

    ChunkUploadResponseListener(
        ChunkUploadRequest request, SettableApiFuture<ChunkUploadResponse> future) {
      this.request = request;
      this.future = future;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      this.isComplete = isUploadFinal(responseHeaders);
      Long sizeReceived = parseSizeReceived(responseHeaders);
      if (sizeReceived != null) {
        this.committedOffset = sizeReceived;
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
          long confirmedOffset =
              committedOffset >= 0
                  ? committedOffset
                  : request.getOffset() + request.getPayload().size();
          future.set(
              ChunkUploadResponse.create(
                  confirmedOffset, isComplete, isComplete ? responseBody : ""));
        } else {
          future.setException(createApiException(statusCode, trailers, "Failed to upload chunk"));
        }
      } catch (Throwable t) {
        future.setException(
            ApiExceptionFactory.createException(
                "Internal error processing upload chunk response",
                t,
                HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                /* retryable= */ false));
      }
    }
  }

  private static class QueryStatusResponseListener extends HttpJsonClientCall.Listener<String> {

    private final SettableApiFuture<QueryStatusResponse> future;
    private boolean isComplete = false;
    @Nullable private Long committedOffset = null;
    private String responseBody = "";

    QueryStatusResponseListener(SettableApiFuture<QueryStatusResponse> future) {
      this.future = future;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      this.isComplete = isUploadFinal(responseHeaders);
      this.committedOffset = parseSizeReceived(responseHeaders);
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
          if (isComplete || committedOffset != null) {
            future.set(
                QueryStatusResponse.create(
                    committedOffset != null ? committedOffset : 0L,
                    isComplete,
                    isComplete ? responseBody : ""));
          } else {
            future.setException(
                ApiExceptionFactory.createException(
                    "Query status response did not contain valid X-Goog-Upload-Size-Received header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
          }
        } else {
          future.setException(
              createApiException(statusCode, trailers, "Failed to query upload status"));
        }
      } catch (Throwable t) {
        future.setException(
            ApiExceptionFactory.createException(
                "Internal error processing query status response",
                t,
                HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                /* retryable= */ false));
      }
    }
  }

  private static boolean isUploadFinal(HttpJsonMetadata responseHeaders) {
    String statusStr =
        HttpHeadersUtils.getFirstHeader(responseHeaders.getHeaders(), UPLOAD_STATUS_HEADER);
    return STATUS_FINAL.equalsIgnoreCase(statusStr);
  }

  @Nullable
  private static Long parseSizeReceived(HttpJsonMetadata responseHeaders) {
    String sizeReceivedStr =
        HttpHeadersUtils.getFirstHeader(responseHeaders.getHeaders(), UPLOAD_SIZE_RECEIVED_HEADER);
    if (!Strings.isNullOrEmpty(sizeReceivedStr)) {
      try {
        return Long.parseLong(sizeReceivedStr);
      } catch (NumberFormatException ignored) {
        // Unparseable header; return null and let the listener decide how to handle it.
      }
    }
    return null;
  }

  private static ApiException createApiException(
      int statusCode, @Nullable HttpJsonMetadata trailers, String actionDescription) {
    Throwable cause = trailers != null ? trailers.getException() : null;
    if (cause != null) {
      return API_EXCEPTION_FACTORY.create(cause);
    }
    return ApiExceptionFactory.createException(
        actionDescription + " with status code: " + statusCode,
        /* cause= */ null,
        HttpJsonStatusCode.of(statusCode),
        /* retryable= */ false);
  }
}
