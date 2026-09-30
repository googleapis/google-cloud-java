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
import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.auth.TestUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamClass;
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
  void createFromHttpResponseException_nullContent() {
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
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_emptyContent() {
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
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_nonJsonContent() {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 502, /* statusMessage= */ "Bad Gateway", new HttpHeaders())
            .setContent("<html><body>Bad Gateway</body></html>")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_502", e.getErrorCode());
    assertEquals("<html><body>Bad Gateway</body></html>", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(502, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_missingErrorField() {
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
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_googleApiJsonErrorObject() {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 401, /* statusMessage= */ null, new HttpHeaders())
            .setContent(
                "{\"error\": {\"code\": 401, \"message\": \"Request had invalid authentication"
                    + " credentials.\", \"status\": \"UNAUTHENTICATED\"}}")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("UNAUTHENTICATED", e.getErrorCode());
    assertEquals("Request had invalid authentication credentials.", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(401, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_jsonLiteralNull() {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 500,
                /* statusMessage= */ "Internal Server Error",
                new HttpHeaders())
            .setContent("null")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_500", e.getErrorCode());
    assertEquals("Internal Server Error", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(500, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_emptyJsonObject_fallsBackToStatusMessage() {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 401, /* statusMessage= */ "Unauthorized", new HttpHeaders())
            .setContent("{}")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_401", e.getErrorCode());
    assertEquals("Unauthorized", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(401, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_topLevelMessage_extractsMessage() {
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 400, /* statusMessage= */ "Bad Request", new HttpHeaders())
            .setContent("{\"message\": \"Certificate expired\"}")
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_400", e.getErrorCode());
    assertEquals("Certificate expired", e.getErrorDescription());
    assertNull(e.getErrorUri());
    assertEquals(400, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_nullErrorField_fallsBackToContent() {
    String content = "{\"error\": null}";
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 400, /* statusMessage= */ "Bad Request", new HttpHeaders())
            .setContent(content)
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_400", e.getErrorCode());
    assertEquals(content, e.getErrorDescription());
    assertEquals(400, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_arrayErrorField_fallsBackToContent() {
    String content = "{\"error\": []}";
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 400, /* statusMessage= */ "Bad Request", new HttpHeaders())
            .setContent(content)
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_400", e.getErrorCode());
    assertEquals(content, e.getErrorDescription());
    assertEquals(400, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void createFromHttpResponseException_errorObjectWithoutMessage_fallsBackToContent() {
    String content = "{\"error\": {\"code\": 400}}";
    HttpResponseException httpException =
        new HttpResponseException.Builder(
                /* statusCode= */ 400, /* statusMessage= */ "Bad Request", new HttpHeaders())
            .setContent(content)
            .build();

    OAuthException e = OAuthException.createFromHttpResponseException(httpException);

    assertEquals("http_error_400", e.getErrorCode());
    assertEquals(content, e.getErrorDescription());
    assertEquals(400, e.getHttpStatusCode());
    assertSame(httpException, e.getCause());
  }

  @Test
  void serialVersionUID_matchesReleasedUidAndRoundTrips() throws Exception {
    assertEquals(
        -5276727039237496975L,
        ObjectStreamClass.lookup(OAuthException.class).getSerialVersionUID());

    OAuthException original =
        new OAuthException("invalid_client", "Certificate mismatch", "https://example.com", 401);
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    try (ObjectOutputStream oos = new ObjectOutputStream(baos)) {
      oos.writeObject(original);
    }
    OAuthException deserialized;
    try (ObjectInputStream ois =
        new ObjectInputStream(new ByteArrayInputStream(baos.toByteArray()))) {
      deserialized = (OAuthException) ois.readObject();
    }
    assertEquals("invalid_client", deserialized.getErrorCode());
    assertEquals("Certificate mismatch", deserialized.getErrorDescription());
    assertEquals("https://example.com", deserialized.getErrorUri());
    assertEquals(401, deserialized.getHttpStatusCode());
  }
}
