/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.datastore.utils;

import com.google.api.client.http.*;
import com.google.api.client.http.protobuf.ProtoHttpContent;
import com.google.api.client.util.IOUtils;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.protobuf.MessageLite;
import com.google.rpc.Code;
import com.google.rpc.Status;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * An RPC transport that sends protocol buffers over HTTP.
 *
 * <p>This class is thread-safe.
 */
class RemoteRpc {
  private static final Logger logger = Logger.getLogger(RemoteRpc.class.getName());

  @VisibleForTesting static final String API_FORMAT_VERSION_HEADER = "X-Goog-Api-Format-Version";
  private static final String API_FORMAT_VERSION = "2";

  @VisibleForTesting static final String X_GOOG_REQUEST_PARAMS_HEADER = "x-goog-request-params";

  private final HttpRequestFactory client;
  private final HttpRequestInitializer initializer;
  private final String url;
  private final AtomicInteger rpcCount = new AtomicInteger(0);
  // Not final - so it can be set/reset in Unittests
  private static boolean enableE2EChecksum =
      Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DATASTORE_HTTP_ENABLE_E2E_CHECKSUM"));

  RemoteRpc(HttpRequestFactory client, HttpRequestInitializer initializer, String url) {
    this.client = client;
    this.initializer = initializer;
    this.url = url;
    try {
      resolveURL("dummyRpc");
    } catch (Exception e) {
      throw new IllegalArgumentException(
          "Unable to construct RemoteRpc due to unsupported url: <" + url + ">", e);
    }
  }

  /**
   * Makes an RPC call using the client. Logs how long it took and any exceptions.
   *
   * <p>NOTE: The request could be an InputStream too, but the http client will need to find its
   * length, which will require buffering it anyways.
   *
   * @throws com.google.datastore.utils.DatastoreException if the RPC fails.
   */
  public InputStream call(
      String methodName, MessageLite request, String projectId, String databaseId)
      throws com.google.datastore.utils.DatastoreException {
    logger.fine("remote datastore call " + methodName);

    long startTime = System.currentTimeMillis();
    try {
      HttpResponse httpResponse;
      try {
        rpcCount.incrementAndGet();
        ProtoHttpContent payload = new ProtoHttpContent(request);
        HttpRequest httpRequest = client.buildPostRequest(resolveURL(methodName), payload);
        setHeaders(request, httpRequest, projectId, databaseId);
        // Don't throw an HTTPResponseException on error. It converts the response to a String and
        // throws away the original, whereas we need the raw bytes to parse it as a proto.
        httpRequest.setThrowExceptionOnExecuteError(false);
        // Datastore requests typically time out after 60s; set the read timeout to slightly longer
        // than that by default (can be overridden via the HttpRequestInitializer).
        httpRequest.setReadTimeout(65 * 1000);
        if (initializer != null) {
          initializer.initialize(httpRequest);
        }
        httpResponse = httpRequest.execute();
        if (!httpResponse.isSuccessStatusCode()) {
          try (InputStream content = httpResponse.getContent()) {
            throw makeException(
                url,
                methodName,
                content,
                httpResponse.getContentType(),
                httpResponse.getContentCharset(),
                null,
                httpResponse.getStatusCode());
          }
        }
        InputStream inputStream = httpResponse.getContent();
        return inputStream;
      } catch (SocketTimeoutException e) {
        throw makeException(url, methodName, Code.DEADLINE_EXCEEDED, "Deadline exceeded", e);
      } catch (IOException e) {
        throw makeException(url, methodName, Code.UNAVAILABLE, "I/O error", e);
      }
    } finally {
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.fine("remote datastore call " + methodName + " took " + elapsedTime + " ms");
    }
  }

  @VisibleForTesting
  void setHeaders(
      MessageLite request, HttpRequest httpRequest, String projectId, String databaseId) {
    httpRequest.getHeaders().put(API_FORMAT_VERSION_HEADER, API_FORMAT_VERSION);
    StringBuilder builder = new StringBuilder("project_id=");
    builder.append(projectId);
    if (!Strings.isNullOrEmpty(databaseId)) {
      builder.append("&database_id=");
      builder.append(databaseId);
    }
    httpRequest.getHeaders().put(X_GOOG_REQUEST_PARAMS_HEADER, builder.toString());
  }

  @VisibleForTesting
  HttpRequestFactory getClient() {
    return client;
  }

  @VisibleForTesting
  static void setSystemEnvE2EChecksum(boolean enableE2EChecksum) {
    RemoteRpc.enableE2EChecksum = enableE2EChecksum;
  }

  void resetRpcCount() {
    rpcCount.set(0);
  }

  int getRpcCount() {
    return rpcCount.get();
  }

  public String getUrl() {
    return url;
  }

  GenericUrl resolveURL(String path) {
    return new GenericUrl(url + ":" + path);
  }

  HttpRequestFactory getHttpRequestFactory() {
    return client;
  }

  public static com.google.datastore.utils.DatastoreException makeException(
      String url, String methodName, Code code, String message, Throwable cause) {
    logger.fine("remote datastore call " + methodName + " against " + url + " failed: " + message);
    return new com.google.datastore.utils.DatastoreException(methodName, code, message, cause);
  }

  static DatastoreException makeException(
      String url,
      String methodName,
      InputStream content,
      String contentType,
      Charset contentCharset,
      Throwable cause,
      int httpStatusCode) {
    if (!contentType.equals("application/x-protobuf")) {
      String responseContent;
      try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtils.copy(content, out, false);
        responseContent = out.toString(contentCharset.name());
      } catch (IOException e) {
        responseContent = "";
      }
      return makeException(
          url,
          methodName,
          Code.INTERNAL,
          String.format(
              "Non-protobuf error: %s. HTTP status code was %d.", responseContent, httpStatusCode),
          cause);
    }

    Status rpcStatus;
    try {
      rpcStatus = Status.parseFrom(content);
    } catch (IOException e) {
      return makeException(
          url,
          methodName,
          Code.INTERNAL,
          String.format(
              "Unable to parse Status protocol buffer: HTTP status code was %s.", httpStatusCode),
          e);
    }

    Code code = Code.forNumber(rpcStatus.getCode());
    if (code == null) {
      return makeException(
          url,
          methodName,
          Code.INTERNAL,
          String.format(
              "Invalid error code: %d. Message: %s.", rpcStatus.getCode(), rpcStatus.getMessage()),
          cause);
    } else if (code == Code.OK) {
      // We can end up here because there was no response body (and we successfully parsed an
      // empty Status message). This may happen for 401s in particular due to special handling
      // in low-level HTTP libraries.
      if (httpStatusCode == HttpStatusCodes.STATUS_CODE_UNAUTHORIZED) {
        return makeException(url, methodName, Code.UNAUTHENTICATED, "Unauthenticated.", cause);
      }
      return makeException(
          url,
          methodName,
          Code.INTERNAL,
          String.format(
              "Unexpected OK error code with HTTP status code of %d. Message: %s.",
              httpStatusCode, rpcStatus.getMessage()),
          cause);
    }

    return makeException(url, methodName, code, rpcStatus.getMessage(), cause);
  }
}
