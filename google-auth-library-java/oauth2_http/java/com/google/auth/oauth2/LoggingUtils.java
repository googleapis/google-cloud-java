/*
 * Copyright 2025 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google LLC nor the names of its
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

package com.google.auth.oauth2;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.util.GenericData;
import java.util.Map;
import java.util.logging.Level;

class LoggingUtils {

  static final String GOOGLE_SDK_JAVA_LOGGING = "GOOGLE_SDK_JAVA_LOGGING";
  private static EnvironmentProvider environmentProvider =
      SystemEnvironmentProvider.getInstance(); // this may be reset for testing purpose

  private static boolean loggingEnabled = isLoggingEnabled();

  // expose this setter only for testing purposes
  static void setEnvironmentProvider(EnvironmentProvider provider) {
    environmentProvider = provider;
    // Recalculate LOGGING_ENABLED after setting the new provider
    loggingEnabled = isLoggingEnabled();
  }

  static boolean isLoggingEnabled() {
    String enableLogging = environmentProvider.getEnv(GOOGLE_SDK_JAVA_LOGGING);
    return "true".equalsIgnoreCase(enableLogging);
  }

  static void logRequest(HttpRequest request, LoggerProvider loggerProvider, String message) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.logRequest(request, loggerProvider, message);
    }
  }

  static void logResponse(HttpResponse response, LoggerProvider loggerProvider, String message) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.logResponse(response, loggerProvider, message);
    }
  }

  static void logResponsePayload(
      GenericData genericData, LoggerProvider loggerProvider, String message) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.logResponsePayload(genericData, loggerProvider, message);
    }
  }

  // generic log method to use when not logging standard request, response and payload
  static void log(
      LoggerProvider loggerProvider, Level level, Map<String, Object> contextMap, String message) {
    if (loggingEnabled) {
      Slf4jLoggingHelpers.log(loggerProvider, level, contextMap, message);
    }
  }

  private LoggingUtils() {}
}
