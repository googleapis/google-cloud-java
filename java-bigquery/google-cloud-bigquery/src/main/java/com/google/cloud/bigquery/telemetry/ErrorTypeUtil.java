/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigquery.telemetry;

import com.google.api.core.BetaApi;

/**
 * Utility class for identifying exception types for telemetry tracking. TODO: this class should get
 * replaced with gax version when ready work tracked in
 * https://github.com/googleapis/google-cloud-java/issues/12105
 */
@BetaApi
class ErrorTypeUtil {

  enum ErrorType {
    CLIENT_TIMEOUT,
    CLIENT_CONNECTION_ERROR,
    CLIENT_REQUEST_ERROR,
    CLIENT_RESPONSE_DECODE_ERROR,
    CLIENT_UNKNOWN_ERROR;

    @Override
    public String toString() {
      return name();
    }
  }

  static boolean isClientTimeout(Exception e) {
    return e instanceof java.net.SocketTimeoutException;
  }

  static boolean isClientConnectionError(Exception e) {
    return e instanceof java.net.ConnectException
        || e instanceof java.net.UnknownHostException
        || e instanceof javax.net.ssl.SSLHandshakeException
        || e instanceof java.nio.channels.UnresolvedAddressException;
  }

  static boolean isClientResponseDecodeError(Exception e) {
    return e instanceof com.google.gson.JsonParseException;
  }

  static boolean isClientRequestError(Exception e) {
    return e instanceof java.lang.IllegalArgumentException;
  }

  static ErrorType getClientErrorType(Exception e) {
    if (isClientTimeout(e)) {
      return ErrorType.CLIENT_TIMEOUT;
    } else if (isClientConnectionError(e)) {
      return ErrorType.CLIENT_CONNECTION_ERROR;
    } else if (isClientResponseDecodeError(e)) {
      return ErrorType.CLIENT_RESPONSE_DECODE_ERROR;
    } else if (isClientRequestError(e)) {
      return ErrorType.CLIENT_REQUEST_ERROR;
    } else {
      return ErrorType.CLIENT_UNKNOWN_ERROR;
    }
  }
}
