/*
 * Copyright 2015 Google Inc. All Rights Reserved.
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
package com.google.datastore.v1beta3.client;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.protobuf.ProtoHttpContent;
import com.google.api.client.util.IOUtils;
import com.google.protobuf.MessageLite;
import com.google.rpc.Code;
import com.google.rpc.Status;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

/**
 * An RPC transport that sends protocol buffers over HTTP.
 */
class RemoteRpc {
  private static final Logger logger = Logger.getLogger(RemoteRpc.class.getName());

  private static final String API_FORMAT_VERSION_HEADER = "X-Goog-Api-Format-Version";
  private static final String API_FORMAT_VERSION = "2";

  private final HttpRequestFactory client;
  private final HttpRequestInitializer initializer;
  private final String url;
  private final AtomicInteger rpcCount = new AtomicInteger(0);

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
   * NOTE: The request could be an InputStream too, but the http client will need to
   * find its length, which will require buffering it anyways.
   *
   * @throws DatastoreException if the RPC fails.
   */
  public InputStream call(String methodName, MessageLite request) throws DatastoreException {
    logger.fine("remote datastore call " + methodName);

    long startTime = System.currentTimeMillis();
    try {
      HttpResponse httpResponse;
      try {
        rpcCount.incrementAndGet();
        ProtoHttpContent payload = new ProtoHttpContent(request);
        HttpRequest httpRequest = client.buildPostRequest(resolveURL(methodName), payload);
        httpRequest.getHeaders().put(API_FORMAT_VERSION_HEADER, API_FORMAT_VERSION);
        // Don't throw an HTTPResponseException on error. It converts the response to a String and
        // throws away the original, whereas we need the raw bytes to parse it as a proto.
        httpRequest.setThrowExceptionOnExecuteError(false);
        if (initializer != null) {
          initializer.initialize(httpRequest);
        }
        httpResponse = httpRequest.execute();
        if (!httpResponse.isSuccessStatusCode()) {
          throw makeException(url, methodName, httpResponse.getContent(),
              httpResponse.getContentType(), httpResponse.getContentCharset(), null,
              httpResponse.getStatusCode());
        }
        return httpResponse.getContent();
      } catch (IOException e) {
        throw makeException(url, methodName, Code.UNAVAILABLE, "I/O error", e);
      }
    } finally {
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.fine("remote datastore call " + methodName + " took " + elapsedTime + " ms");
    }
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
  
  public static DatastoreException makeException(String url, String methodName, Code code,
      String message, Throwable cause) {
    logger.fine("remote datastore call " + methodName + " against " + url  + " failed: " + message);
    return new DatastoreException(methodName, code, message, cause);
  }

  static DatastoreException makeException(String url, String methodName, InputStream content,
      String contentType, Charset contentCharset, Throwable cause, int httpStatusCode) {
    if (!contentType.equals("application/x-protobuf")) {
      String responseContent;
      try {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        IOUtils.copy(content, out);
        responseContent = out.toString(contentCharset.name());
      } catch (IOException e) {
        responseContent = "";
      }
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Non-protobuf error: %s. HTTP status code was %d.", responseContent, httpStatusCode),
          cause);
    }

    Status rpcStatus;
    try {
      rpcStatus = Status.parseFrom(content);
    } catch (IOException e) {
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Unable to parse Status protocol buffer: HTTP status code was %s.", httpStatusCode),
          e);
    }

    Code code = Code.forNumber(rpcStatus.getCode());
    if (code == null) {
      return makeException(url, methodName, Code.INTERNAL,
          String.format(
              "Invalid error code: %d. Message: %s.", rpcStatus.getCode(), rpcStatus.getMessage()),
          cause);
    } else if (code == Code.OK) {
      return makeException(url, methodName, Code.INTERNAL,
          String.format("Unexpected OK error code with HTTP status code of %d. Message: %s.",
              httpStatusCode, rpcStatus.getMessage()),
          cause);
    }

    return makeException(url, methodName, code, rpcStatus.getMessage(), cause);
  }
}
