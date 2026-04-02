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

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.google.cloud.bigquery.telemetry.ErrorTypeUtil.ErrorType;
import com.google.gson.JsonParseException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import org.junit.jupiter.api.Test;

public class ErrorTypeUtilTest {

  @Test
  public void testGetClientErrorType_Timeout() {
    assertEquals(
        ErrorType.CLIENT_TIMEOUT, ErrorTypeUtil.getClientErrorType(new SocketTimeoutException()));
  }

  @Test
  public void testGetClientErrorType_ConnectionError() {
    assertEquals(
        ErrorType.CLIENT_CONNECTION_ERROR,
        ErrorTypeUtil.getClientErrorType(new ConnectException()));
  }

  @Test
  public void testGetClientErrorType_ResponseDecodeError() {
    assertEquals(
        ErrorType.CLIENT_RESPONSE_DECODE_ERROR,
        ErrorTypeUtil.getClientErrorType(new JsonParseException("")));
  }

  @Test
  public void testGetClientErrorType_RequestError() {
    assertEquals(
        ErrorType.CLIENT_REQUEST_ERROR,
        ErrorTypeUtil.getClientErrorType(new IllegalArgumentException()));
  }

  @Test
  public void testGetClientErrorType_UnknownError() {
    assertEquals(ErrorType.CLIENT_UNKNOWN_ERROR, ErrorTypeUtil.getClientErrorType(new Exception()));
  }

  @Test
  public void testErrorTypeToString() {
    assertEquals("CLIENT_TIMEOUT", ErrorType.CLIENT_TIMEOUT.toString());
    assertEquals("CLIENT_CONNECTION_ERROR", ErrorType.CLIENT_CONNECTION_ERROR.toString());
  }
}
