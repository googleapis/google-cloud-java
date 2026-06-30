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

package com.google.api.gax.logging;

import com.google.api.core.InternalApi;
import com.google.common.base.Strings;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Message;
import com.google.protobuf.util.JsonFormat;
import java.util.Map;
import java.util.function.Consumer;
import org.slf4j.Logger;
import org.slf4j.event.Level;

/** Contains helper methods to log requests and responses */
@InternalApi
class Slf4jLoggingHelpers {

  static final Gson gson = new Gson();

  static Map<String, Object> messageToMapWithGson(Message message)
      throws InvalidProtocolBufferException {
    String json = JsonFormat.printer().print(message);
    return gson.fromJson(json, new TypeToken<Map<String, Object>>() {}.getType());
  }

  static void recordServiceRpcAndRequestHeaders(
      String serviceName,
      String rpcName,
      String endpoint,
      Map<String, String> requestHeaders,
      LogData.Builder logDataBuilder,
      LoggerProvider loggerProvider) {
    LoggingUtils.executeWithTryCatch(
        () -> {
          Logger logger = loggerProvider.getLogger();
          if (logger.isInfoEnabled()) {
            addIfNotEmpty(logDataBuilder::serviceName, serviceName);
            addIfNotEmpty(logDataBuilder::rpcName, rpcName);
            addIfNotEmpty(logDataBuilder::httpUrl, endpoint);
          }
          if (logger.isDebugEnabled()) {
            logDataBuilder.requestHeaders(requestHeaders);
          }
        });
  }

  private static void addIfNotEmpty(Consumer<String> setter, String value) {
    if (!Strings.isNullOrEmpty(value)) {
      setter.accept(value);
    }
  }

  static void recordResponseHeaders(
      Map<String, String> headers, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    LoggingUtils.executeWithTryCatch(
        () -> {
          Logger logger = loggerProvider.getLogger();
          if (logger.isDebugEnabled()) {
            logDataBuilder.responseHeaders(headers);
          }
        });
  }

  static <RespT> void recordResponsePayload(
      RespT message, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    LoggingUtils.executeWithTryCatch(
        () -> {
          Logger logger = loggerProvider.getLogger();
          if (logger.isDebugEnabled()) {
            if (!(message instanceof Message)) {
              // expect RespT to be Message type, otherwise do nothing and return
              return;
            }
            Map<String, Object> messageToMapWithGson = messageToMapWithGson((Message) message);

            logDataBuilder.responsePayload(messageToMapWithGson);
          }
        });
  }

  static void logResponse(
      String status, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    LoggingUtils.executeWithTryCatch(
        () -> {
          Logger logger = loggerProvider.getLogger();
          if (logger.isInfoEnabled()) {
            logDataBuilder.responseStatus(status);
          }
          if (logger.isInfoEnabled() && !logger.isDebugEnabled()) {
            Map<String, Object> responseData = logDataBuilder.build().toMapResponse();
            Slf4jUtils.log(logger, Level.INFO, responseData, "Received response");
          }
          if (logger.isDebugEnabled()) {
            Map<String, Object> responsedDetailsMap = logDataBuilder.build().toMapResponse();
            Slf4jUtils.log(logger, Level.DEBUG, responsedDetailsMap, "Received response");
          }
        });
  }

  static <RespT> void logRequest(
      RespT message, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    LoggingUtils.executeWithTryCatch(
        () -> {
          Logger logger = loggerProvider.getLogger();
          if (logger.isInfoEnabled() && !logger.isDebugEnabled()) {
            Slf4jUtils.log(
                logger, Level.INFO, logDataBuilder.build().toMapRequest(), "Sending request");
          }
          if (logger.isDebugEnabled()) {
            if (!(message instanceof Message)) {
              // expect RespT to be Message type, otherwise do nothing and return
              return;
            }
            Map<String, Object> messageToMapWithGson = messageToMapWithGson((Message) message);

            logDataBuilder.requestPayload(messageToMapWithGson);
            Map<String, Object> requestDetailsMap = logDataBuilder.build().toMapRequest();
            Slf4jUtils.log(logger, Level.DEBUG, requestDetailsMap, "Sending request");
          }
        });
  }

  private Slf4jLoggingHelpers() {}
}
