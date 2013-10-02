/*
 * Copyright 2013 Google Inc. All Rights Reserved.
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
package com.google.api.services.datastore.client;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.protobuf.ProtoHttpContent;
import com.google.protobuf.MessageLite;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

/**
 * An RPC transport that sends protocol buffers over HTTP.
 *
 */
class RemoteRpc {
  private static final Logger logger = Logger.getLogger(RemoteRpc.class.getName());

  private final HttpRequestFactory client;
  private final HttpRequestInitializer initializer;
  private final String url;
  private int rpcCount = 0;

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
  InputStream call(String methodName, MessageLite request) throws DatastoreException {
    logger.fine("remote datastore call " + methodName);

    long startTime = System.currentTimeMillis();
    try {
      HttpResponse httpResponse;
      try {
        rpcCount++;
        ProtoHttpContent payload = new ProtoHttpContent(request);
        HttpRequest httpRequest = client.buildPostRequest(resolveURL(methodName), payload);
        if (initializer != null) {
          initializer.initialize(httpRequest);
        }
        httpResponse = httpRequest.execute();
        return httpResponse.getContent();
      } catch (HttpResponseException e) {
        throw makeException(url, methodName, e.getStatusCode(), e.getContent(), e);
      } catch (IOException e) {
        throw makeException(url, methodName, HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE,
            "I/O error", e);
      }
    } finally {
      long elapsedTime = System.currentTimeMillis() - startTime;
      logger.fine("remote datastore call " + methodName + " took " + elapsedTime + " ms");
    }
  }

  void resetRpcCount() {
    rpcCount = 0;
  }

  int getRpcCount() {
    return rpcCount;
  }

  String getUrl() {
    return url;
  }

  GenericUrl resolveURL(String path) {
    return new GenericUrl(url + "/" + path);
  }

  HttpRequestFactory getHttpRequestFactory() {
    return client;
  }

  static DatastoreException makeException(
      String url, String methodName, int code, String message, Throwable cause) {
    logger.fine("remote datastore call " + methodName + " against " + url  + " failed: " + message);
    return new DatastoreException(methodName, code, message, cause);
  }
}
