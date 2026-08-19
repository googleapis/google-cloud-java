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
import com.google.api.core.AbstractApiFuture;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.InternalApi;
import com.google.api.gax.resumable.ChunkUploadRequest;
import com.google.api.gax.resumable.ChunkUploadResponse;
import com.google.api.gax.resumable.QueryStatusRequest;
import com.google.api.gax.resumable.QueryStatusResponse;
import com.google.api.gax.resumable.ResumableUploadClient;
import com.google.api.gax.resumable.ResumableUploadSession;
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
                  return request.getPayload().toByteArray();
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

  private final ApiMethodDescriptor<RequestT, String> startUploadDescriptor;
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

    this.startUploadDescriptor =
        ApiMethodDescriptor.<RequestT, String>newBuilder()
            .setFullMethodName(methodDescriptor.getFullMethodName())
            .setHttpMethod(HttpMethods.POST)
            .setType(ApiMethodDescriptor.MethodType.UNARY)
            .setRequestFormatter(methodDescriptor.getRequestFormatter())
            .setResponseParser(ResumableUploadResponseParser.create())
            .build();
    this.startUploadCallable = createStartUploadCallable(clientContext);
    this.uploadChunkCallable = createUploadChunkCallable(clientContext, responseParser);
    this.queryStatusCallable = createQueryStatusCallable(clientContext, responseParser);
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

  private UnaryCallable<RequestT, ResumableUploadSession> createStartUploadCallable(
      ClientContext clientContext) {
    UnaryCallable<RequestT, ResumableUploadSession> rawCallable =
        new UnaryCallable<RequestT, ResumableUploadSession>() {
          @Override
          public ApiFuture<ResumableUploadSession> futureCall(
              RequestT request, @Nullable ApiCallContext inputContext) {
            Preconditions.checkNotNull(request);
            HttpJsonCallContext context =
                createCallContext(clientContext, inputContext, START_UPLOAD_HEADERS);

            HttpJsonClientCall<RequestT, String> clientCall =
                HttpJsonClientCalls.newCall(startUploadDescriptor, context);

            HttpJsonCallFuture<ResumableUploadSession> future =
                new HttpJsonCallFuture<>(clientCall);
            HttpJsonClientCalls.startUnaryCall(
                clientCall, request, context, new StartUploadResponseListener(future));

            return future;
          }
        };
    return createClientCallable(rawCallable, clientContext);
  }

  private UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>
      createUploadChunkCallable(
          ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>> rawCallable =
        new UnaryCallable<ChunkUploadRequest, ChunkUploadResponse<ResponseT>>() {
          @Override
          public ApiFuture<ChunkUploadResponse<ResponseT>> futureCall(
              ChunkUploadRequest request, @Nullable ApiCallContext inputContext) {
            Preconditions.checkNotNull(request);
            boolean isPayloadEmpty = request.getPayload().isEmpty();
            String command;
            if (request.isFinal()) {
              command = !isPayloadEmpty ? "upload, finalize" : "finalize";
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
                createCallContext(clientContext, inputContext, chunkHeaders);

            HttpJsonClientCall<ChunkUploadRequest, String> clientCall =
                HttpJsonClientCalls.newCall(UPLOAD_CHUNK_DESCRIPTOR, context);

            HttpJsonCallFuture<ChunkUploadResponse<ResponseT>> future =
                new HttpJsonCallFuture<>(clientCall);
            HttpJsonClientCalls.startUnaryCall(
                clientCall,
                request,
                context,
                new ChunkUploadResponseListener<>(request, future, responseParser));

            return future;
          }
        };
    return createClientCallable(rawCallable, clientContext);
  }

  private UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>
      createQueryStatusCallable(
          ClientContext clientContext, HttpResponseParser<ResponseT> responseParser) {
    UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>> rawCallable =
        new UnaryCallable<QueryStatusRequest, QueryStatusResponse<ResponseT>>() {
          @Override
          public ApiFuture<QueryStatusResponse<ResponseT>> futureCall(
              QueryStatusRequest request, @Nullable ApiCallContext inputContext) {
            Preconditions.checkNotNull(request);
            HttpJsonCallContext context =
                createCallContext(clientContext, inputContext, QUERY_STATUS_HEADERS);

            HttpJsonClientCall<QueryStatusRequest, String> clientCall =
                HttpJsonClientCalls.newCall(QUERY_STATUS_DESCRIPTOR, context);

            HttpJsonCallFuture<QueryStatusResponse<ResponseT>> future =
                new HttpJsonCallFuture<>(clientCall);
            HttpJsonClientCalls.startUnaryCall(
                clientCall,
                request,
                context,
                new QueryStatusResponseListener<>(future, responseParser));

            return future;
          }
        };
    return createClientCallable(rawCallable, clientContext);
  }

  private static HttpJsonCallContext createCallContext(
      ClientContext clientContext,
      @Nullable ApiCallContext inputContext,
      Map<String, List<String>> extraHeaders) {
    return (HttpJsonCallContext)
        HttpJsonCallContext.createDefault()
            .nullToSelf(clientContext.getDefaultCallContext())
            .merge(inputContext)
            .withExtraHeaders(extraHeaders);
  }

  private static <CallReqT, CallRespT> UnaryCallable<CallReqT, CallRespT> createClientCallable(
      UnaryCallable<CallReqT, CallRespT> innerCallable, ClientContext clientContext) {
    UnaryCallable<CallReqT, CallRespT> callable =
        new HttpJsonExceptionCallable<>(
            innerCallable,
            // Wire calls do not retry directly; retries are managed by ResumableUploadCallable.
            Collections.emptySet());
    return callable.withDefaultCallContext(clientContext.getDefaultCallContext());
  }

  @Nullable
  private static <ResponseT> ResponseT parseResponseBody(
      String responseBody, HttpResponseParser<ResponseT> responseParser) {
    InputStream stream = new ByteArrayInputStream(responseBody.getBytes(StandardCharsets.UTF_8));
    return responseParser.parse(stream);
  }

  @Nullable
  private static String getUploadStatus(HttpJsonMetadata responseHeaders) {
    return HttpHeadersUtils.getSingleHeader(responseHeaders.getHeaders(), UPLOAD_STATUS_HEADER);
  }

  private static boolean isUploadFinal(HttpJsonMetadata responseHeaders) {
    return STATUS_FINAL.equalsIgnoreCase(getUploadStatus(responseHeaders));
  }

  @Nullable
  private static Long parseSizeReceived(HttpJsonMetadata responseHeaders) {
    String sizeReceivedStr =
        HttpHeadersUtils.getSingleHeader(responseHeaders.getHeaders(), UPLOAD_SIZE_RECEIVED_HEADER);
    if (!Strings.isNullOrEmpty(sizeReceivedStr)) {
      try {
        return Long.parseLong(sizeReceivedStr);
      } catch (NumberFormatException ignored) {
        // Unparseable header; return null and let the listener decide how to handle it.
      }
    }
    return null;
  }

  private static Throwable createStatusException(
      int statusCode, HttpJsonMetadata trailers, String actionMessage) {
    Throwable cause = trailers.getException();
    return cause != null
        ? cause
        : new HttpJsonStatusRuntimeException(
            statusCode, actionMessage + " with status code: " + statusCode, null);
  }

  /**
   * An {@link ApiFuture} that cancels the underlying {@link HttpJsonClientCall} to prevent
   * connection leaks.
   */
  private static class HttpJsonCallFuture<T> extends AbstractApiFuture<T> {

    private final HttpJsonClientCall<?, ?> call;

    HttpJsonCallFuture(HttpJsonClientCall<?, ?> call) {
      this.call = call;
    }

    @Override
    protected void interruptTask() {
      call.cancel("Call was cancelled", null);
    }

    public boolean set(T value) {
      return super.set(value);
    }

    public boolean setException(Throwable throwable) {
      return super.setException(throwable);
    }
  }

  /** A listener that parses HTTP response headers to produce a {@link ResumableUploadSession}. */
  private static class StartUploadResponseListener extends HttpJsonClientCall.Listener<String> {

    private final HttpJsonCallFuture<ResumableUploadSession> future;
    private long chunkGranularity = 1L;
    @Nullable private String uploadUrl;
    @Nullable private Throwable headerParsingException;

    StartUploadResponseListener(HttpJsonCallFuture<ResumableUploadSession> future) {
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

  /**
   * A listener that processes chunk upload response headers and bodies to produce the {@link
   * ChunkUploadResponse}.
   */
  private static class ChunkUploadResponseListener<ResponseT>
      extends HttpJsonClientCall.Listener<String> {

    private final ChunkUploadRequest request;
    private final HttpJsonCallFuture<ChunkUploadResponse<ResponseT>> future;
    private final HttpResponseParser<ResponseT> responseParser;
    private boolean hasUploadStatusHeader = false;
    private boolean isComplete = false;
    @Nullable private Long committedOffset = null;
    private String responseBody = "";

    ChunkUploadResponseListener(
        ChunkUploadRequest request,
        HttpJsonCallFuture<ChunkUploadResponse<ResponseT>> future,
        HttpResponseParser<ResponseT> responseParser) {
      this.request = request;
      this.future = future;
      this.responseParser = responseParser;
    }

    @Override
    public void onHeaders(HttpJsonMetadata responseHeaders) {
      String statusStr = getUploadStatus(responseHeaders);
      if (statusStr != null) {
        this.hasUploadStatusHeader = true;
        this.isComplete = STATUS_FINAL.equalsIgnoreCase(statusStr);
      }
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
          if (!hasUploadStatusHeader) {
            future.setException(
                ApiExceptionFactory.createException(
                    "Upload chunk response did not contain valid X-Goog-Upload-Status header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
            return;
          }
          long confirmedOffset =
              committedOffset != null
                  ? committedOffset
                  : request.getOffset() + request.getPayload().size();
          ResponseT response = isComplete ? parseResponseBody(responseBody, responseParser) : null;
          future.set(ChunkUploadResponse.create(confirmedOffset, isComplete, response));
        } else {
          future.setException(
              createStatusException(statusCode, trailers, "Failed to upload chunk"));
        }
      } catch (Throwable t) {
        future.setException(t);
      }
    }
  }

  /** A listener that parses query response headers to produce the {@link QueryStatusResponse}. */
  private static class QueryStatusResponseListener<ResponseT>
      extends HttpJsonClientCall.Listener<String> {

    private final HttpJsonCallFuture<QueryStatusResponse<ResponseT>> future;
    private final HttpResponseParser<ResponseT> responseParser;
    private boolean isComplete = false;
    @Nullable private Long committedOffset = null;
    private String responseBody = "";

    QueryStatusResponseListener(
        HttpJsonCallFuture<QueryStatusResponse<ResponseT>> future,
        HttpResponseParser<ResponseT> responseParser) {
      this.future = future;
      this.responseParser = responseParser;
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
            ResponseT response =
                isComplete ? parseResponseBody(responseBody, responseParser) : null;
            future.set(
                QueryStatusResponse.create(
                    committedOffset != null ? committedOffset : 0L, isComplete, response));
          } else {
            future.setException(
                ApiExceptionFactory.createException(
                    "Query status response did not contain valid X-Goog-Upload-Size-Received"
                        + " header",
                    /* cause= */ null,
                    HttpJsonStatusCode.of(StatusCode.Code.INTERNAL),
                    /* retryable= */ false));
          }
        } else {
          future.setException(
              createStatusException(statusCode, trailers, "Failed to query upload status"));
        }
      } catch (Throwable t) {
        future.setException(t);
      }
    }
  }
}
