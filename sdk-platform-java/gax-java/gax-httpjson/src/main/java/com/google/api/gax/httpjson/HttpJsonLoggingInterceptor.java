/*
 * Copyright 2025 Google LLC
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

import static com.google.api.gax.logging.LoggingUtils.logRequest;
import static com.google.api.gax.logging.LoggingUtils.logResponse;
import static com.google.api.gax.logging.LoggingUtils.recordResponseHeaders;
import static com.google.api.gax.logging.LoggingUtils.recordResponsePayload;
import static com.google.api.gax.logging.LoggingUtils.recordServiceRpcAndRequestHeaders;

import com.google.api.core.InternalApi;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCall.SimpleForwardingHttpJsonClientCall;
import com.google.api.gax.httpjson.ForwardingHttpJsonClientCallListener.SimpleForwardingHttpJsonClientCallListener;
import com.google.api.gax.logging.LogData;
import com.google.api.gax.logging.LoggerProvider;
import java.util.HashMap;
import java.util.Map;

@InternalApi
public class HttpJsonLoggingInterceptor implements HttpJsonClientInterceptor {

  private static final LoggerProvider LOGGER_PROVIDER =
      LoggerProvider.forClazz(HttpJsonLoggingInterceptor.class);

  @Override
  public <ReqT, RespT> HttpJsonClientCall<ReqT, RespT> interceptCall(
      ApiMethodDescriptor<ReqT, RespT> method,
      HttpJsonCallOptions callOptions,
      HttpJsonChannel next) {

    String endpoint = ((ManagedHttpJsonChannel) next).getEndpoint();

    return new SimpleForwardingHttpJsonClientCall<ReqT, RespT>(next.newCall(method, callOptions)) {

      LogData.Builder logDataBuilder = LogData.builder();

      @Override
      public void start(
          HttpJsonClientCall.Listener<RespT> responseListener, HttpJsonMetadata headers) {
        recordServiceRpcAndRequestHeaders(
            null, // service name is not available for http requests
            method.getFullMethodName(),
            endpoint,
            httpJsonMetadataToMap(headers),
            logDataBuilder,
            LOGGER_PROVIDER);

        Listener<RespT> forwardingResponseListener =
            new SimpleForwardingHttpJsonClientCallListener<RespT>(responseListener) {

              @Override
              public void onHeaders(HttpJsonMetadata responseHeaders) {
                recordResponseHeaders(
                    httpJsonMetadataToMap(responseHeaders), logDataBuilder, LOGGER_PROVIDER);
                super.onHeaders(responseHeaders);
              }

              @Override
              public void onMessage(RespT message) {
                recordResponsePayload(message, logDataBuilder, LOGGER_PROVIDER);
                super.onMessage(message);
              }

              @Override
              public void onClose(int statusCode, HttpJsonMetadata trailers) {
                logResponse(String.valueOf(statusCode), logDataBuilder, LOGGER_PROVIDER);
                super.onClose(statusCode, trailers);
              }
            };
        super.start(forwardingResponseListener, headers);
      }

      @Override
      public void sendMessage(ReqT message) {
        logRequest(message, logDataBuilder, LOGGER_PROVIDER);
        super.sendMessage(message);
      }
    };
  }

  // Helper methods for logging,

  private static Map<String, String> httpJsonMetadataToMap(HttpJsonMetadata headers) {
    Map<String, String> headersMap = new HashMap<>();
    headers.getHeaders().forEach((key, value) -> headersMap.put(key, value.toString()));
    return headersMap;
  }
}
