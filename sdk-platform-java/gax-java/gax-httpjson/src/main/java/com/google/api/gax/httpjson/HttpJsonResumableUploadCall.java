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
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpMediaType;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.GenericData;
import com.google.api.core.ApiFuture;
import com.google.api.core.SettableApiFuture;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.ResumableUploadProgressListener;
import com.google.api.gax.rpc.ResumableUploadRequest;
import com.google.api.gax.rpc.ResumableUploadStatus;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Encapsulates the execution logic and state machine of the Resumable Upload protocol. */
final class HttpJsonResumableUploadCall<RequestT, ResponseT> {

  private static final Logger logger =
      Logger.getLogger(HttpJsonResumableUploadCall.class.getName());
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
  private static final int HTTP_BAD_REQUEST = 400;
  private static final int HTTP_TOO_MANY_REQUESTS = 429;
  private static final int HTTP_INTERNAL_ERROR = 500;
  private static final int HTTP_PRECONDITION_FAILED = 412;
  private static final int HTTP_RANGE_NOT_SATISFIABLE = 416;
  private static final long DEFAULT_BACKOFF_BASE_MS = 500;
  private static final long DEFAULT_BACKOFF_MAX_MS = 30000;
  private static final int DEFAULT_DEADLINE_MINUTES = 10;

  private final ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor;
  private final ResumableUploadRequest<RequestT> uploadRequest;
  private final HttpTransport httpTransport;
  private final HttpJsonMetadata requestHeaders;
  private final HttpJsonCallOptions callOptions;
  private final String endpoint;
  private final Executor executor;

  private enum ErrorCategory {
    CATEGORY_1_TRANSIENT,
    CATEGORY_2_MISMATCH,
    CATEGORY_3_FATAL
  }

  HttpJsonResumableUploadCall(
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor,
      ResumableUploadRequest<RequestT> uploadRequest,
      HttpTransport httpTransport,
      HttpJsonMetadata requestHeaders,
      HttpJsonCallOptions callOptions,
      String endpoint,
      Executor executor) {
    this.methodDescriptor = Preconditions.checkNotNull(methodDescriptor);
    this.uploadRequest = Preconditions.checkNotNull(uploadRequest);
    this.httpTransport = Preconditions.checkNotNull(httpTransport);
    this.requestHeaders = Preconditions.checkNotNull(requestHeaders);
    this.callOptions = Preconditions.checkNotNull(callOptions);
    this.endpoint = Preconditions.checkNotNull(endpoint);
    this.executor = Preconditions.checkNotNull(executor);
  }

  ApiFuture<ResponseT> execute() {
    SettableApiFuture<ResponseT> future = SettableApiFuture.create();
    executor.execute(
        () -> {
          try {
            ResponseT result = runStateMachine();
            future.set(result);
          } catch (Throwable t) {
            future.setException(t);
          }
        });
    return future;
  }

  private ResponseT runStateMachine() throws Exception {
    try {
      return runStateMachineInternal();
    } catch (HttpResponseException e) {
      throw translateException(e);
    }
  }

  private static class BufferedChunk {
    final long offset;
    final byte[] data;
    final int length;

    BufferedChunk(long offset, byte[] data, int length) {
      this.offset = offset;
      this.data = data;
      this.length = length;
    }
  }

  private static class SessionInfo {
    final String uploadUrl;
    final int granularity;

    SessionInfo(String uploadUrl, int granularity) {
      this.uploadUrl = uploadUrl;
      this.granularity = granularity;
    }
  }

  private static final class UploadAlreadyFinalizedException extends Exception {
    private final Object response;

    UploadAlreadyFinalizedException(Object response) {
      this.response = response;
    }

    Object getResponse() {
      return response;
    }
  }

  private ResponseT runStateMachineInternal() throws Exception {
    Instant deadline = calculateDeadline();

    // Phase 1: Start Session (with retry)
    String uploadUrl = null;
    int attempt = 0;
    int granularity = 1;
    while (true) {
      try {
        checkDeadline(deadline);
        SessionInfo sessionInfo = startSession(deadline);
        uploadUrl = sessionInfo.uploadUrl;
        granularity = sessionInfo.granularity;
        break; // Success
      } catch (Exception e) {
        checkDeadline(deadline);
        ErrorCategory category = getErrorCategory(e);
        if (category == ErrorCategory.CATEGORY_1_TRANSIENT) {
          attempt++;
          long delayMs = calculateBackoff(attempt);
          logger.log(
              Level.WARNING,
              "Transient error starting session. Backing off for " + delayMs + " ms",
              e);
          sleep(delayMs);
        } else {
          throw e; // Fatal/Mismatch, bubble up
        }
      }
    }
    logger.log(
        Level.FINE,
        "Resumable session started. Upload URL: {0}, Granularity: {1}",
        new Object[] {uploadUrl, granularity});

    int adjustedChunkSize = uploadRequest.getChunkSize();
    if (granularity > 1) {
      adjustedChunkSize = (adjustedChunkSize / granularity) * granularity;
      if (adjustedChunkSize == 0) {
        adjustedChunkSize = granularity;
      }
    }

    long offset = 0;
    attempt = 0;
    long previousOffset = -1;

    InputStream stream = uploadRequest.getStreamProvider().get();
    long streamPosition = 0;

    List<BufferedChunk> cache = new ArrayList<>();

    // Phase 2 & 3 Loop: Transmit Chunks & Query Recovery
    while (true) {
      try {
        checkDeadline(deadline);

        // Find chunk in cache or read from stream
        BufferedChunk chunk = null;
        for (BufferedChunk cached : cache) {
          if (cached.offset == offset) {
            chunk = cached;
            break;
          }
        }

        if (chunk == null) {
          // Read from stream
          if (streamPosition != offset) {
            if (stream != null) {
              stream.close();
            }
            stream = uploadRequest.getStreamProvider().get();
            long skipped = skipFully(stream, offset);
            if (skipped < offset) {
              throw new IOException("Failed to skip stream bytes to offset: " + offset);
            }
            streamPosition = offset;
          }

          byte[] buffer = new byte[adjustedChunkSize];
          int bytesRead = readFully(stream, buffer, adjustedChunkSize);
          if (bytesRead > 0) {
            chunk = new BufferedChunk(offset, buffer, bytesRead);
            cache.add(chunk);
            if (cache.size() > 2) {
              cache.remove(0);
            }
            streamPosition += bytesRead;
          }
        }

        if (chunk == null) {
          // Stream was empty or exact chunk multiple and fully uploaded.
          // Send finalize only
          return sendFinalizeOnly(uploadUrl, offset, deadline);
        }

        // Check if this is the last chunk
        boolean isEof = (chunk.length < adjustedChunkSize);

        if (isEof) {
          // Send upload, finalize for the last chunk
          return sendUploadFinalize(uploadUrl, chunk.offset, chunk.data, chunk.length, deadline);
        }

        // Send intermediate chunk (upload command)
        sendChunk(uploadUrl, chunk.offset, chunk.data, chunk.length, deadline);

        // Successful chunk transmission! Update offset to next chunk
        offset = chunk.offset + chunk.length;
        attempt = 0; // Reset backoff attempts on progress

      } catch (UploadAlreadyFinalizedException uafe) {
        updateProgress(
            uploadRequest.getTotalBytes() > 0 ? uploadRequest.getTotalBytes() : offset,
            ResumableUploadProgressListener.State.COMPLETED);
        return (ResponseT) uafe.getResponse();
      } catch (Exception e) {
        checkDeadline(deadline);
        ErrorCategory category = getErrorCategory(e);

        if (category == ErrorCategory.CATEGORY_2_MISMATCH) {
          logger.log(Level.WARNING, "State mismatch detected. Triggering recovery...", e);
          updateProgress(offset, ResumableUploadProgressListener.State.RECOVERING);

          long serverOffset = 0;
          try {
            serverOffset = recoverOffset(uploadUrl, deadline);
          } catch (UploadAlreadyFinalizedException uafe) {
            updateProgress(
                uploadRequest.getTotalBytes() > 0 ? uploadRequest.getTotalBytes() : offset,
                ResumableUploadProgressListener.State.COMPLETED);
            return (ResponseT) uafe.getResponse();
          }

          logger.log(Level.INFO, "Recovery completed. Server received bytes: {0}", serverOffset);

          if (serverOffset == previousOffset) {
            attempt++;
            long delayMs = calculateBackoff(attempt);
            sleep(delayMs);
          } else {
            attempt = 0;
            previousOffset = serverOffset;
          }

          offset = serverOffset;
          // Loop will handle finding the chunk in cache or seeking/recreating the stream!
        } else if (category == ErrorCategory.CATEGORY_1_TRANSIENT) {
          attempt++;
          long delayMs = calculateBackoff(attempt);
          logger.log(
              Level.WARNING,
              "Transient error. Backing off for {0} ms (attempt {1})",
              new Object[] {delayMs, attempt});
          sleep(delayMs);
        } else {
          updateProgress(offset, ResumableUploadProgressListener.State.FAILED);
          throw e; // Fatal, bubble up
        }
      }
    }
  }

  private SessionInfo startSession(final Instant deadline) throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    HttpRequestFormatter<RequestT> requestFormatter = methodDescriptor.getRequestFormatter();

    GenericData tokenRequest = new GenericData();
    String requestBody = requestFormatter.getRequestBody(uploadRequest.getRequest());
    HttpContent initialContent;

    if (!Strings.isNullOrEmpty(requestBody)) {
      JSON_FACTORY.createJsonParser(requestBody).parse(tokenRequest);
      initialContent =
          new JsonHttpContent(JSON_FACTORY, tokenRequest)
              .setMediaType(new HttpMediaType("application/json; charset=utf-8"));
    } else {
      initialContent = new EmptyContent();
    }

    String path = "/resumable/upload" + requestFormatter.getPath(uploadRequest.getRequest());
    GenericUrl url = new GenericUrl(normalizeEndpoint(endpoint) + path);

    Map<String, List<String>> queryParams =
        requestFormatter.getQueryParamNames(uploadRequest.getRequest());
    for (Map.Entry<String, List<String>> queryParam : queryParams.entrySet()) {
      if (queryParam.getValue() != null) {
        url.set(queryParam.getKey(), queryParam.getValue());
      }
    }

    HttpRequest httpRequest = requestFactory.buildPostRequest(url, initialContent);
    configureTimeouts(httpRequest, deadline);

    for (Map.Entry<String, Object> entry : requestHeaders.getHeaders().entrySet()) {
      String key = entry.getKey();
      String value = (String) entry.getValue();

      if (isMetadataHeaderDenylisted(key)) {
        httpRequest.getHeaders().set("X-Goog-Upload-Header-" + key, value);
      } else {
        httpRequest.getHeaders().set(key, value);
      }
    }

    httpRequest.getHeaders().set("X-Goog-Upload-Protocol", "resumable");
    httpRequest.getHeaders().set("X-Goog-Upload-Command", "start");

    updateProgress(0, ResumableUploadProgressListener.State.NOT_STARTED);

    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      String status = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");
      if (!"active".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Failed to initiate resumable session: Status is not active")
            .build();
      }
      String uploadUrl = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-URL");
      if (Strings.isNullOrEmpty(uploadUrl)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Failed to initiate resumable session: Missing upload URL")
            .build();
      }

      String granularityStr =
          response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Chunk-Granularity");
      int granularity = 1;
      if (!Strings.isNullOrEmpty(granularityStr)) {
        try {
          granularity = Integer.parseInt(granularityStr);
        } catch (NumberFormatException e) {
          logger.log(
              Level.WARNING, "Failed to parse chunk granularity header: " + granularityStr, e);
        }
      }
      return new SessionInfo(uploadUrl, granularity);
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private void sendChunk(
      final String uploadUrl,
      final long offset,
      final byte[] data,
      final int length,
      final Instant deadline)
      throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    HttpContent payload = new ByteArrayContent("application/octet-stream", data, 0, length);

    GenericUrl url = new GenericUrl(uploadUrl);
    HttpRequest httpRequest = requestFactory.buildPostRequest(url, payload);
    configureTimeouts(httpRequest, deadline);

    httpRequest.getHeaders().set("X-Goog-Upload-Command", "upload");
    httpRequest.getHeaders().set("X-Goog-Upload-Offset", String.valueOf(offset));

    updateProgress(offset, ResumableUploadProgressListener.State.IN_PROGRESS);

    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      String status = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");
      if ("final".equalsIgnoreCase(status)) {
        InputStreamReader reader =
            new InputStreamReader(response.getContent(), StandardCharsets.UTF_8);
        ResponseT parsedResponse =
            methodDescriptor.getResponseParser().parse(reader, callOptions.getTypeRegistry());
        throw new UploadAlreadyFinalizedException(parsedResponse);
      }
      if (!"active".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Resumable upload chunk failed: Status is not active")
            .build();
      }
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private ResponseT sendUploadFinalize(
      final String uploadUrl,
      final long offset,
      final byte[] data,
      final int length,
      final Instant deadline)
      throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    HttpContent payload = new ByteArrayContent("application/octet-stream", data, 0, length);

    GenericUrl url = new GenericUrl(uploadUrl);
    HttpRequest httpRequest = requestFactory.buildPostRequest(url, payload);
    configureTimeouts(httpRequest, deadline);

    httpRequest.getHeaders().set("X-Goog-Upload-Command", "upload, finalize");
    httpRequest.getHeaders().set("X-Goog-Upload-Offset", String.valueOf(offset));

    updateProgress(offset, ResumableUploadProgressListener.State.IN_PROGRESS);

    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      String status = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");
      if (!"final".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Resumable upload finalize failed: Status is not final")
            .build();
      }

      InputStreamReader reader =
          new InputStreamReader(response.getContent(), StandardCharsets.UTF_8);
      ResponseT parsedResponse =
          methodDescriptor.getResponseParser().parse(reader, callOptions.getTypeRegistry());

      long finalProgressBytes =
          uploadRequest.getTotalBytes() > 0 ? uploadRequest.getTotalBytes() : offset + length;
      updateProgress(finalProgressBytes, ResumableUploadProgressListener.State.COMPLETED);

      return parsedResponse;
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private ResponseT sendFinalizeOnly(
      final String uploadUrl, final long offset, final Instant deadline) throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();

    GenericUrl url = new GenericUrl(uploadUrl);
    HttpRequest httpRequest = requestFactory.buildPostRequest(url, new EmptyContent());
    configureTimeouts(httpRequest, deadline);

    httpRequest.getHeaders().set("X-Goog-Upload-Command", "finalize");

    updateProgress(offset, ResumableUploadProgressListener.State.IN_PROGRESS);

    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      String status = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");
      if (!"final".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Resumable upload finalize failed: Status is not final")
            .build();
      }

      InputStreamReader reader =
          new InputStreamReader(response.getContent(), StandardCharsets.UTF_8);
      ResponseT parsedResponse =
          methodDescriptor.getResponseParser().parse(reader, callOptions.getTypeRegistry());

      long finalProgressBytes =
          uploadRequest.getTotalBytes() > 0 ? uploadRequest.getTotalBytes() : offset;
      updateProgress(finalProgressBytes, ResumableUploadProgressListener.State.COMPLETED);

      return parsedResponse;
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private long recoverOffset(final String uploadUrl, final Instant deadline) throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    GenericUrl url = new GenericUrl(uploadUrl);

    HttpRequest httpRequest = requestFactory.buildPostRequest(url, new EmptyContent());
    configureTimeouts(httpRequest, deadline);

    httpRequest.getHeaders().set("X-Goog-Upload-Command", "query");

    HttpResponse response = null;
    try {
      response = httpRequest.execute();
      String status = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");

      if ("final".equalsIgnoreCase(status)) {
        InputStreamReader reader =
            new InputStreamReader(response.getContent(), StandardCharsets.UTF_8);
        ResponseT parsedResponse =
            methodDescriptor.getResponseParser().parse(reader, callOptions.getTypeRegistry());
        throw new UploadAlreadyFinalizedException(parsedResponse);
      }
      if (!"active".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Query failed: Status is not active")
            .build();
      }

      String receivedSizeStr =
          response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Size-Received");
      if (Strings.isNullOrEmpty(receivedSizeStr)) {
        throw new HttpResponseException.Builder(
                response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Query failed: Missing size received header")
            .build();
      }

      return Long.parseLong(receivedSizeStr);
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private int readFully(final InputStream in, final byte[] b, final int len) throws IOException {
    int total = 0;
    while (total < len) {
      int result = in.read(b, total, len - total);
      if (result == -1) {
        break;
      }
      total += result;
    }
    return total == 0 && len > 0 ? -1 : total;
  }

  private long skipFully(final InputStream in, final long n) throws IOException {
    long total = 0;
    while (total < n) {
      long skipped = in.skip(n - total);
      if (skipped == 0) {
        int read = in.read();
        if (read == -1) {
          break;
        }
        skipped = 1;
      }
      total += skipped;
    }
    return total;
  }

  private void configureTimeouts(final HttpRequest request, final Instant deadline) {
    long remainingMs = Duration.between(Instant.now(), deadline).toMillis();
    if (remainingMs <= 0) {
      remainingMs = 1; // force timeout
    }
    request.setConnectTimeout((int) remainingMs);
    request.setReadTimeout((int) remainingMs);
  }

  private Instant calculateDeadline() {
    Duration timeout = callOptions.getTimeoutDuration();
    if (timeout != null && !timeout.isZero() && !timeout.isNegative()) {
      return Instant.now().plus(timeout);
    }
    return Instant.now().plus(Duration.ofMinutes(DEFAULT_DEADLINE_MINUTES));
  }

  private void checkDeadline(final Instant deadline) throws DeadlineExceededException {
    if (Instant.now().isAfter(deadline)) {
      throw (DeadlineExceededException)
          com.google.api.gax.rpc.ApiExceptionFactory.createException(
              "Resumable upload session exceeded the configured deadline.",
              null,
              HttpJsonStatusCode.of(com.google.api.gax.rpc.StatusCode.Code.DEADLINE_EXCEEDED),
              false);
    }
  }

  private ErrorCategory getErrorCategory(final Throwable t) {
    if (t instanceof HttpResponseException) {
      HttpResponseException e = (HttpResponseException) t;
      int statusCode = e.getStatusCode();
      String uploadStatus = e.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Status");
      if ("final".equalsIgnoreCase(uploadStatus)) {
        return ErrorCategory.CATEGORY_3_FATAL;
      }
      if (statusCode == HTTP_TOO_MANY_REQUESTS || statusCode >= HTTP_INTERNAL_ERROR) {
        return ErrorCategory.CATEGORY_1_TRANSIENT;
      }
      if (statusCode == HTTP_BAD_REQUEST
          || statusCode == HTTP_PRECONDITION_FAILED
          || statusCode == HTTP_RANGE_NOT_SATISFIABLE) {
        return ErrorCategory.CATEGORY_2_MISMATCH;
      }
      return ErrorCategory.CATEGORY_3_FATAL;
    }
    if (t instanceof IOException) {
      return ErrorCategory.CATEGORY_1_TRANSIENT;
    }
    return ErrorCategory.CATEGORY_3_FATAL;
  }

  private long calculateBackoff(final int attempt) {
    long baseDelay = DEFAULT_BACKOFF_BASE_MS;
    long maxDelay = DEFAULT_BACKOFF_MAX_MS;
    long delay = (long) (baseDelay * Math.pow(2, attempt));
    return Math.min(delay, maxDelay);
  }

  private void sleep(final long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void updateProgress(
      final long bytesUploaded, final ResumableUploadProgressListener.State state) {
    ResumableUploadProgressListener progressListener = uploadRequest.getProgressListener();
    if (progressListener != null) {
      progressListener.onProgress(
          new ResumableUploadStatus(bytesUploaded, uploadRequest.getTotalBytes(), state));
    }
  }

  private HttpRequestFactory getRequestFactory() {
    Credentials credentials = callOptions.getCredentials();
    if (credentials != null) {
      return httpTransport.createRequestFactory(new HttpCredentialsAdapter(credentials));
    }
    return httpTransport.createRequestFactory();
  }

  private boolean isMetadataHeaderDenylisted(final String key) {
    return "Content-Length".equalsIgnoreCase(key)
        || "Content-Type".equalsIgnoreCase(key)
        || "Content-Encoding".equalsIgnoreCase(key)
        || "Transfer-Encoding".equalsIgnoreCase(key);
  }

  private String normalizeEndpoint(final String rawEndpoint) {
    String normalized = rawEndpoint;
    if (!normalized.contains("://")) {
      normalized = "https://" + normalized;
    }
    if (normalized.charAt(normalized.length() - 1) != '/') {
      normalized += '/';
    }
    return normalized;
  }

  private Exception translateException(final HttpResponseException e) {
    HttpJsonApiExceptionFactory factory =
        new HttpJsonApiExceptionFactory(java.util.Collections.emptySet());
    return factory.create(e);
  }
}
