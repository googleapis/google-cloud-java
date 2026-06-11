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
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiException;
import com.google.api.gax.rpc.DeadlineExceededException;
import com.google.api.gax.rpc.InputStreamProvider;
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
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Encapsulates the execution logic and state machine of the Resumable Upload protocol. */
final class HttpJsonResumableUploadCall<RequestT, ResponseT> {

  private static final Logger logger = Logger.getLogger(HttpJsonResumableUploadCall.class.getName());
  private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();

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

  private ResponseT runStateMachineInternal() throws Exception {
    Instant deadline = calculateDeadline();
    
    // Phase 1: Start Session (with retry)
    String uploadUrl = null;
    int attempt = 0;
    while (true) {
      try {
        checkDeadline(deadline);
        uploadUrl = startSession(deadline);
        break; // Success
      } catch (Exception e) {
        checkDeadline(deadline);
        ErrorCategory category = getErrorCategory(e);
        if (category == ErrorCategory.CATEGORY_1_TRANSIENT) {
          attempt++;
          long delayMs = calculateBackoff(attempt);
          logger.log(Level.WARNING, "Transient error starting session. Backing off for " + delayMs + " ms", e);
          sleep(delayMs);
        } else {
          throw e; // Fatal/Mismatch, bubble up
        }
      }
    }
    logger.log(Level.FINE, "Resumable session started. Upload URL: {0}", uploadUrl);

    long offset = 0;
    attempt = 0;
    long previousOffset = -1;

    // Phase 2 & 3 Loop: Transmit & Query Recovery
    while (true) {
      try {
        checkDeadline(deadline);
        return transmitRemaining(uploadUrl, offset, deadline);
      } catch (Exception e) {
        checkDeadline(deadline);
        ErrorCategory category = getErrorCategory(e);

        if (category == ErrorCategory.CATEGORY_2_MISMATCH) {
          logger.log(Level.WARNING, "State mismatch detected. Triggering recovery...", e);
          updateProgress(offset, ResumableUploadProgressListener.State.RECOVERING);
          
          offset = recoverOffset(uploadUrl, deadline);
          logger.log(Level.INFO, "Recovery completed. Server received bytes: {0}", offset);
          
          if (offset == previousOffset) {
            // No progress was made since last recovery. Wait with backoff to prevent slamming server.
            attempt++;
            long delayMs = calculateBackoff(attempt);
            sleep(delayMs);
          } else {
            attempt = 0; // Reset attempts on progress
            previousOffset = offset;
          }
        } else if (category == ErrorCategory.CATEGORY_1_TRANSIENT) {
          attempt++;
          long delayMs = calculateBackoff(attempt);
          logger.log(Level.WARNING, "Transient error. Backing off for {0} ms (attempt {1})", new Object[]{delayMs, attempt});
          sleep(delayMs);
        } else {
          updateProgress(offset, ResumableUploadProgressListener.State.FAILED);
          throw e; // Fatal, bubble up
        }
      }
    }
  }

  private String startSession(Instant deadline) throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    HttpRequestFormatter<RequestT> requestFormatter = methodDescriptor.getRequestFormatter();

    GenericData tokenRequest = new GenericData();
    String requestBody = requestFormatter.getRequestBody(uploadRequest.getRequest());
    HttpContent initialContent;

    if (!Strings.isNullOrEmpty(requestBody)) {
      JSON_FACTORY.createJsonParser(requestBody).parse(tokenRequest);
      initialContent = new JsonHttpContent(JSON_FACTORY, tokenRequest)
          .setMediaType(new HttpMediaType("application/json; charset=utf-8"));
    } else {
      initialContent = new EmptyContent();
    }

    // Resumable upload specific path modifier
    String path = "/resumable/upload" + requestFormatter.getPath(uploadRequest.getRequest());
    GenericUrl url = new GenericUrl(normalizeEndpoint(endpoint) + path);
    
    // Populate query parameters
    Map<String, List<String>> queryParams = requestFormatter.getQueryParamNames(uploadRequest.getRequest());
    for (Map.Entry<String, List<String>> queryParam : queryParams.entrySet()) {
      if (queryParam.getValue() != null) {
        url.set(queryParam.getKey(), queryParam.getValue());
      }
    }

    HttpRequest httpRequest = requestFactory.buildPostRequest(url, initialContent);
    configureTimeouts(httpRequest, deadline);

    // Set standard headers + merge custom metadata
    for (Map.Entry<String, Object> entry : requestHeaders.getHeaders().entrySet()) {
      String key = entry.getKey();
      String value = (String) entry.getValue();
      
      // Prefix metadata headers to prevent collision with physical request metadata
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
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Failed to initiate resumable session: Status is not active")
            .build();
      }
      String uploadUrl = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-URL");
      if (Strings.isNullOrEmpty(uploadUrl)) {
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Failed to initiate resumable session: Missing upload URL")
            .build();
      }
      return uploadUrl;
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private ResponseT transmitRemaining(String uploadUrl, long offset, Instant deadline) throws Exception {
    HttpRequestFactory requestFactory = getRequestFactory();
    
    InputStream stream = uploadRequest.getStreamProvider().get();
    if (offset > 0) {
      long skipped = stream.skip(offset);
      if (skipped < offset) {
        throw new IOException("Failed to skip stream bytes to offset: " + offset);
      }
    }

    // Wrap the stream in custom HttpContent that updates the progress listener
    HttpContent payload = new ProgressReportingHttpContent(
        stream, uploadRequest.getTotalBytes(), offset, uploadRequest.getProgressListener());

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
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Resumable upload failed: Status is not final")
            .build();
      }

      InputStreamReader reader = new InputStreamReader(response.getContent(), StandardCharsets.UTF_8);
      ResponseT parsedResponse = methodDescriptor.getResponseParser().parse(reader, callOptions.getTypeRegistry());
      
      updateProgress(uploadRequest.getTotalBytes() > 0 ? uploadRequest.getTotalBytes() : offset, 
          ResumableUploadProgressListener.State.COMPLETED);
      
      return parsedResponse;
    } finally {
      if (response != null) {
        response.disconnect();
      }
    }
  }

  private long recoverOffset(String uploadUrl, Instant deadline) throws Exception {
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
        // Already finalized, query command behaves like final
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Query returned final status. Re-executing state machine...")
            .build();
      }
      if (!"active".equalsIgnoreCase(status)) {
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
            .setMessage("Query failed: Status is not active")
            .build();
      }
      
      String receivedSizeStr = response.getHeaders().getFirstHeaderStringValue("X-Goog-Upload-Size-Received");
      if (Strings.isNullOrEmpty(receivedSizeStr)) {
        throw new HttpResponseException.Builder(response.getStatusCode(), response.getStatusMessage(), response.getHeaders())
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

  private void configureTimeouts(HttpRequest request, Instant deadline) {
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
    return Instant.now().plus(Duration.ofMinutes(10)); // Default deadline of 10 mins
  }

  private void checkDeadline(Instant deadline) throws DeadlineExceededException {
    if (Instant.now().isAfter(deadline)) {
      throw (DeadlineExceededException) com.google.api.gax.rpc.ApiExceptionFactory.createException(
          "Resumable upload session exceeded the configured deadline.",
          null,
          HttpJsonStatusCode.of(com.google.api.gax.rpc.StatusCode.Code.DEADLINE_EXCEEDED),
          false);
    }
  }

  private ErrorCategory getErrorCategory(Throwable t) {
    if (t instanceof HttpResponseException) {
      int statusCode = ((HttpResponseException) t).getStatusCode();
      if (statusCode == 429 || statusCode >= 500) {
        return ErrorCategory.CATEGORY_1_TRANSIENT;
      }
      if (statusCode == 400 || statusCode == 412 || statusCode == 416) {
        return ErrorCategory.CATEGORY_2_MISMATCH;
      }
      return ErrorCategory.CATEGORY_3_FATAL;
    }
    if (t instanceof IOException) {
      return ErrorCategory.CATEGORY_1_TRANSIENT;
    }
    return ErrorCategory.CATEGORY_3_FATAL;
  }

  private long calculateBackoff(int attempt) {
    long baseDelay = 500; // 500ms
    long maxDelay = 30000; // 30s
    long delay = (long) (baseDelay * Math.pow(2, attempt));
    return Math.min(delay, maxDelay);
  }

  private void sleep(long ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }

  private void updateProgress(long bytesUploaded, ResumableUploadProgressListener.State state) {
    ResumableUploadProgressListener progressListener = uploadRequest.getProgressListener();
    if (progressListener != null) {
      progressListener.onProgress(new ResumableUploadStatus(bytesUploaded, uploadRequest.getTotalBytes(), state));
    }
  }

  private HttpRequestFactory getRequestFactory() {
    Credentials credentials = callOptions.getCredentials();
    if (credentials != null) {
      return httpTransport.createRequestFactory(new HttpCredentialsAdapter(credentials));
    }
    return httpTransport.createRequestFactory();
  }

  private boolean isMetadataHeaderDenylisted(String key) {
    // Standard body-related headers that must be prefixed when uploading session metadata
    return "Content-Length".equalsIgnoreCase(key)
        || "Content-Type".equalsIgnoreCase(key)
        || "Content-Encoding".equalsIgnoreCase(key)
        || "Transfer-Encoding".equalsIgnoreCase(key);
  }

  private String normalizeEndpoint(String rawEndpoint) {
    String normalized = rawEndpoint;
    if (!normalized.contains("://")) {
      normalized = "https://" + normalized;
    }
    if (normalized.charAt(normalized.length() - 1) != '/') {
      normalized += '/';
    }
    return normalized;
  }

  private Exception translateException(HttpResponseException e) {
    // Return standard GAX Exception or original depending on status code
    HttpJsonApiExceptionFactory factory = new HttpJsonApiExceptionFactory(java.util.Collections.emptySet());
    return factory.create(e);
  }

  /** Custom HttpContent class that streams data and reports progress callbacks. */
  private static final class ProgressReportingHttpContent implements HttpContent {
    private final InputStream stream;
    private final long totalLength;
    private final long initialOffset;
    private final ResumableUploadProgressListener progressListener;

    ProgressReportingHttpContent(
        InputStream stream,
        long totalLength,
        long initialOffset,
        ResumableUploadProgressListener progressListener) {
      this.stream = stream;
      this.totalLength = totalLength;
      this.initialOffset = initialOffset;
      this.progressListener = progressListener;
    }

    @Override
    public long getLength() throws IOException {
      // Return -1 to force chunked transfer encoding as the length of the remaining stream
      // might be different from physical Content-Length, or if totalLength is unknown.
      return -1;
    }

    @Override
    public String getType() {
      return "application/octet-stream";
    }

    @Override
    public boolean retrySupported() {
      // Handled by our state machine recreating the stream via streamProvider
      return false;
    }

    @Override
    public void writeTo(OutputStream out) throws IOException {
      byte[] buffer = new byte[65536]; // 64KB buffer
      int len;
      long bytesUploaded = initialOffset;
      while ((len = stream.read(buffer)) != -1) {
        out.write(buffer, 0, len);
        out.flush();
        bytesUploaded += len;
        if (progressListener != null) {
          progressListener.onProgress(
              new ResumableUploadStatus(
                  bytesUploaded, totalLength, ResumableUploadProgressListener.State.IN_PROGRESS));
        }
      }
    }
  }
}
