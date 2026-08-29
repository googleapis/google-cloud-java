/*
 * Copyright 2021 Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.auth.TestUtils;
import java.io.IOException;
import org.junit.jupiter.api.Test;

/** Tests for {@link OAuthException}. */
final class OAuthExceptionTest {

  private static final String FULL_MESSAGE_FORMAT = "Error code %s: %s - %s";
  private static final String ERROR_DESCRIPTION_FORMAT = "Error code %s: %s";
  private static final String BASE_MESSAGE_FORMAT = "Error code %s";

  @Test
  void getMessage_fullFormat() {
    OAuthException e = new OAuthException("errorCode", "errorDescription", "errorUri");

    assertEquals("errorCode", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
    assertEquals("errorUri", e.getErrorUri());

    String expectedMessage =
        String.format(FULL_MESSAGE_FORMAT, "errorCode", "errorDescription", "errorUri");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void getMessage_descriptionFormat() {
    OAuthException e = new OAuthException("errorCode", "errorDescription", /* errorUri= */ null);

    assertEquals("errorCode", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
    assertNull(e.getErrorUri());

    String expectedMessage =
        String.format(ERROR_DESCRIPTION_FORMAT, "errorCode", "errorDescription");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void getMessage_baseFormat() {
    OAuthException e =
        new OAuthException("errorCode", /* errorDescription= */ null, /* errorUri= */ null);

    assertEquals("errorCode", e.getErrorCode());
    assertNull(e.getErrorDescription());
    assertNull(e.getErrorUri());

    String expectedMessage = String.format(BASE_MESSAGE_FORMAT, "errorCode");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void createFromHttpResponseException() throws IOException {
    OAuthException e =
        OAuthException.createFromHttpResponseException(
            TestUtils.buildHttpResponseException("errorCode", "errorDescription", "errorUri"));

    assertEquals("errorCode", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
    assertEquals("errorUri", e.getErrorUri());

    String expectedMessage =
        String.format(FULL_MESSAGE_FORMAT, "errorCode", "errorDescription", "errorUri");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void createFromHttpResponseException_descriptionFormat() throws IOException {
    OAuthException e =
        OAuthException.createFromHttpResponseException(
            TestUtils.buildHttpResponseException(
                "errorCode", "errorDescription", /* errorUri= */ null));

    assertEquals("errorCode", e.getErrorCode());
    assertEquals("errorDescription", e.getErrorDescription());
    assertNull(e.getErrorUri());

    String expectedMessage =
        String.format(ERROR_DESCRIPTION_FORMAT, "errorCode", "errorDescription");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void createFromHttpResponseException_baseFormat() throws IOException {
    OAuthException e =
        OAuthException.createFromHttpResponseException(
            TestUtils.buildHttpResponseException(
                "errorCode", /* errorDescription= */ null, /* errorUri= */ null));

    assertEquals("errorCode", e.getErrorCode());
    assertNull(e.getErrorDescription());
    assertNull(e.getErrorUri());

    String expectedMessage = String.format(BASE_MESSAGE_FORMAT, "errorCode");
    assertEquals(expectedMessage, e.getMessage());
  }

  @Test
  void createFromHttpResponseException_nullContent() throws IOException {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 401, /* statusMessage= */ "Unauthorized", new HttpHeaders())
            .setContent(null)
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_401", e.getErrorCode());
    assertEquals("Unauthorized", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(401, e.getHttpStatusCode());
  }

  @Test
  void createFromHttpResponseException_emptyContent() throws IOException {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 401, /* statusMessage= */ "Unauthorized", new HttpHeaders())
            .setContent("   ")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_401", e.getErrorCode());
    assertEquals("Unauthorized", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(401, e.getHttpStatusCode());
  }

  @Test
  void createFromHttpResponseException_nonJsonContent() throws IOException {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 502, /* statusMessage= */ "Bad Gateway", new HttpHeaders())
            .setContent("<html><body>Bad Gateway</body></html>")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_502", e.getErrorCode());
    assertEquals("Bad Gateway", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(502, e.getHttpStatusCode());
  }

  @Test
  void createFromHttpResponseException_missingErrorField() throws IOException {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 400, /* statusMessage= */ "Bad Request", new HttpHeaders())
            .setContent("{\"error_description\": \"some description\"}")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_400", e.getErrorCode());
    assertEquals("some description", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(400, e.getHttpStatusCode());
  }
}
