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
import java.util.Map;

@InternalApi
public class LoggingUtils {

  private static boolean loggingEnabled = isLoggingEnabled();
  static final String GOOGLE_SDK_JAVA_LOGGING = "GOOGLE_SDK_JAVA_LOGGING";

  static boolean isLoggingEnabled() {
    String enableLogging = System.getenv(GOOGLE_SDK_JAVA_LOGGING);
    return "true".equalsIgnoreCase(enableLogging);
  }

  /**
   * Sets logDataBuilder with service name, rpc name, endpoint and request headers based on logging
   * level
   *
   * @param serviceName
   * @param rpcName
   * @param endpoint
   * @param requestHeaders
   * @param logDataBuilder
   * @param loggerProvider
   */
  public static void recordServiceRpcAndRequestHeaders(
      String serviceName,
      String rpcName,
      String endpoint,
      Map<String, String> requestHeaders,
      LogData.Builder logDataBuilder,
      LoggerProvider loggerProvider) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.recordServiceRpcAndRequestHeaders(
          serviceName, rpcName, endpoint, requestHeaders, logDataBuilder, loggerProvider);
    }
  }

  /**
   * Sets logDataBuilder with response headers based on logging level
   *
   * @param headers
   * @param logDataBuilder
   * @param loggerProvider
   */
  public static void recordResponseHeaders(
      Map<String, String> headers, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.recordResponseHeaders(headers, logDataBuilder, loggerProvider);
    }
  }

  /**
   * Sets logDataBuilder with respond payload based on logging level
   *
   * @param message
   * @param logDataBuilder
   * @param loggerProvider
   * @param <RespT>
   */
  public static <RespT> void recordResponsePayload(
      RespT message, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.recordResponsePayload(message, logDataBuilder, loggerProvider);
    }
  }

  /**
   * Log response based on logging level configured
   *
   * @param status
   * @param logDataBuilder
   * @param loggerProvider
   */
  public static void logResponse(
      String status, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.logResponse(status, logDataBuilder, loggerProvider);
    }
  }

  /**
   * Log request based on logging level configured
   *
   * @param message
   * @param logDataBuilder
   * @param loggerProvider
   * @param <RespT>
   */
  public static <RespT> void logRequest(
      RespT message, LogData.Builder logDataBuilder, LoggerProvider loggerProvider) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.logRequest(message, logDataBuilder, loggerProvider);
    }
  }

  public static void executeWithTryCatch(ThrowingRunnable action) {
    try {
      action.run();
    } catch (Throwable t) {
      // let logging exceptions fail silently
    }
  }

  @FunctionalInterface
  public interface ThrowingRunnable {
    void run() throws Throwable;
  }
}
