/*
 * Copyright 2017 Google LLC
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
import com.google.api.client.http.HttpMethods;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.json.JsonHttpContent;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.JsonObjectParser;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.GenericData;
import com.google.auth.Credentials;
import com.google.auth.http.HttpCredentialsAdapter;
import com.google.auto.value.AutoValue;
import com.google.common.base.Strings;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

/** A runnable object that creates and executes an HTTP request. */
class HttpRequestRunnable<RequestT, ResponseT> implements Runnable {
  private final RequestT request;
  private final ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor;
  private final String endpoint;
  private final HttpJsonCallOptions httpJsonCallOptions;
  private final HttpTransport httpTransport;
  private final HttpJsonMetadata headers;
  private final ResultListener resultListener;

  private volatile boolean cancelled = false;

  HttpRequestRunnable(
      RequestT request,
      ApiMethodDescriptor<RequestT, ResponseT> methodDescriptor,
      String endpoint,
      HttpJsonCallOptions httpJsonCallOptions,
      HttpTransport httpTransport,
      HttpJsonMetadata headers,
      ResultListener resultListener) {
    this.request = request;
    this.methodDescriptor = methodDescriptor;
    this.endpoint = endpoint;
    this.httpJsonCallOptions = httpJsonCallOptions;
    this.httpTransport = httpTransport;
    this.headers = headers;
    this.resultListener = resultListener;
  }

  // Best effort cancellation without guarantees.
  // It will check if the task cancelled before each three sequential potentially time-consuming
  // operations:
  //   - request construction;
  //   - request execution (the most time consuming, taking);
  //   - response construction.
  void cancel() {
    cancelled = true;
  }

  @Override
  public void run() {
    RunnableResult.Builder result = RunnableResult.builder();
    HttpJsonMetadata.Builder trailers = HttpJsonMetadata.newBuilder();
    HttpResponse httpResponse = null;
    try {
      // Check if already cancelled before even creating a request
      if (cancelled) {
        return;
      }
      HttpRequest httpRequest = createHttpRequest();
      // Check if already cancelled before sending the request;
      if (cancelled) {
        return;
      }
      httpResponse = httpRequest.execute();

      // Check if already cancelled before trying to construct and read the response
      if (cancelled) {
        httpResponse.disconnect();
        return;
      }
      result.setResponseHeaders(
          HttpJsonMetadata.newBuilder().setHeaders(httpResponse.getHeaders()).build());
      result.setStatusCode(httpResponse.getStatusCode());
      result.setResponseContent(httpResponse.getContent());
      trailers.setStatusMessage(httpResponse.getStatusMessage());
    } catch (HttpResponseException e) {
      result.setStatusCode(e.getStatusCode());
      result.setResponseHeaders(HttpJsonMetadata.newBuilder().setHeaders(e.getHeaders()).build());
      result.setResponseContent(
          e.getContent() != null
              ? new ByteArrayInputStream(e.getContent().getBytes(StandardCharsets.UTF_8))
              : null);
      trailers.setStatusMessage(e.getStatusMessage());
      trailers.setException(e);
    } catch (Throwable e) {
      if (httpResponse != null) {
        trailers.setStatusMessage(httpResponse.getStatusMessage());
        result.setStatusCode(httpResponse.getStatusCode());
      } else {
        result.setStatusCode(400);
      }
      trailers.setException(e);
    } finally {
      // If cancelled, `close()` in HttpJsonClientCallImpl has already been invoked
      // and returned a DEADLINE_EXCEEDED error back so there is no need to set
      // a result back.
      if (!cancelled) {
        resultListener.setResult(result.setTrailers(trailers.build()).build());
      }
    }
  }

  HttpRequest createHttpRequest() throws IOException {
    GenericData tokenRequest = new GenericData();

    HttpRequestFormatter<RequestT> requestFormatter = methodDescriptor.getRequestFormatter();

    HttpRequestFactory requestFactory;
    Credentials credentials = httpJsonCallOptions.getCredentials();
    if (credentials != null) {
      requestFactory = httpTransport.createRequestFactory(new HttpCredentialsAdapter(credentials));
    } else {
      requestFactory = httpTransport.createRequestFactory();
    }

    JsonFactory jsonFactory = GsonFactory.getDefaultInstance();
    // Create HTTP request body.
    String requestBody = requestFormatter.getRequestBody(request);
    HttpContent jsonHttpContent;
    if (!Strings.isNullOrEmpty(requestBody)) {
      jsonFactory.createJsonParser(requestBody).parse(tokenRequest);
      jsonHttpContent =
          new JsonHttpContent(jsonFactory, tokenRequest)
              .setMediaType((new HttpMediaType("application/json; charset=utf-8")));
    } else {
      // Force underlying HTTP lib to set Content-Length header to avoid 411s.
      // See EmptyContent.java.
      jsonHttpContent = new EmptyContent();
    }

    // Populate URL path and query parameters.
    String normalizedEndpoint = normalizeEndpoint(endpoint);
    GenericUrl url = new GenericUrl(normalizedEndpoint + requestFormatter.getPath(request));
    Map<String, List<String>> queryParams = requestFormatter.getQueryParamNames(request);
    for (Entry<String, List<String>> queryParam : queryParams.entrySet()) {
      if (queryParam.getValue() != null) {
        url.set(queryParam.getKey(), queryParam.getValue());
      }
    }

    HttpRequest httpRequest = buildRequest(requestFactory, url, jsonHttpContent);

    for (Map.Entry<String, Object> entry : headers.getHeaders().entrySet()) {
      HttpHeadersUtils.setHeader(
          httpRequest.getHeaders(), entry.getKey(), (String) entry.getValue());
    }

    httpRequest.setParser(new JsonObjectParser(jsonFactory));

    return httpRequest;
  }

  private HttpRequest buildRequest(
      HttpRequestFactory requestFactory, GenericUrl url, HttpContent jsonHttpContent)
      throws IOException {
    // A workaround to support PATCH request. This assumes support of "X-HTTP-Method-Override"
    // header on the server side, which GCP services usually do.
    //
    // Long story short, the problems is as follows: gax-httpjson depends on NetHttpTransport class
    // from google-http-client, which depends on JDK standard java.net.HttpUrlConnection, which does
    // not support PATCH http method.
    //
    // It is a won't fix for JDK8: https://bugs.openjdk.java.net/browse/JDK-8207840.
    // A corresponding google-http-client issue:
    // https://github.com/googleapis/google-http-java-client/issues/167
    //
    // In JDK11 there is java.net.http.HttpRequest with PATCH method support but, gax-httpjson must
    // remain compatible with Java 8.
    //
    // Using "X-HTTP-Method-Override" header is probably the cleanest way to fix it. Other options
    // would be: hideous reflection hacks (not a safe option in a generic library, which
    // gax-httpjson is), writing own implementation of HttpUrlConnection (fragile and a lot of
    // work), depending on v2.ApacheHttpTransport (it has many extra dependencies, does not support
    // mtls etc).
    String actualHttpMethod = methodDescriptor.getHttpMethod();
    String originalHttpMethod = actualHttpMethod;
    if (HttpMethods.PATCH.equals(actualHttpMethod)) {
      actualHttpMethod = HttpMethods.POST;
    }
    HttpRequest httpRequest = requestFactory.buildRequest(actualHttpMethod, url, jsonHttpContent);
    if (originalHttpMethod != null && !originalHttpMethod.equals(actualHttpMethod)) {
      HttpHeadersUtils.setHeader(
          httpRequest.getHeaders(), "X-HTTP-Method-Override", originalHttpMethod);
    }

    java.time.Duration timeout = httpJsonCallOptions.getTimeoutDuration();
    if (timeout != null) {
      long timeoutMs = timeout.toMillis();

      // Read timeout is the timeout between reading two data packets and not total timeout
      // HttpJsonClientCallsImpl implements a deadlineCancellationExecutor to cancel the
      // RPC when it exceeds the RPC timeout
      if (shouldUpdateTimeout(httpRequest.getReadTimeout(), timeoutMs)) {
        httpRequest.setReadTimeout((int) timeoutMs);
      }

      // Connect timeout is the time allowed for establishing the connection.
      // This is updated to match the RPC timeout as we do not want a shorter
      // connect timeout to preemptively throw a ConnectExcepetion before
      // we've reached the RPC timeout
      if (shouldUpdateTimeout(httpRequest.getConnectTimeout(), timeoutMs)) {
        httpRequest.setConnectTimeout((int) timeoutMs);
      }
    }
    return httpRequest;
  }

  private boolean shouldUpdateTimeout(int currentTimeoutMs, long newTimeoutMs) {
    return currentTimeoutMs > 0
        && currentTimeoutMs < newTimeoutMs
        && newTimeoutMs < Integer.MAX_VALUE;
  }

  // This will be frequently executed, so avoiding using regexps if not necessary.
  private String normalizeEndpoint(String rawEndpoint) {
    String normalized = rawEndpoint;
    // Set protocol as https by default if not set explicitly
    if (!normalized.contains("://")) {
      normalized = "https://" + normalized;
    }

    if (normalized.charAt(normalized.length() - 1) != '/') {
      normalized += '/';
    }

    return normalized;
  }

  @FunctionalInterface
  interface ResultListener {
    void setResult(RunnableResult result);
  }

  @AutoValue
  abstract static class RunnableResult {
    @Nullable
    abstract HttpJsonMetadata getResponseHeaders();

    abstract int getStatusCode();

    @Nullable
    abstract InputStream getResponseContent();

    abstract HttpJsonMetadata getTrailers();

    public static Builder builder() {
      return new AutoValue_HttpRequestRunnable_RunnableResult.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {

      public abstract Builder setResponseHeaders(HttpJsonMetadata newResponseHeaders);

      public abstract Builder setStatusCode(int newStatusCode);

      public abstract Builder setResponseContent(InputStream newResponseContent);

      public abstract Builder setTrailers(HttpJsonMetadata newTrailers);

      public abstract RunnableResult build();
    }
  }
}
