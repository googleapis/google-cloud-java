/*
 * Copyright 2024 Google LLC
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

import static com.google.auth.oauth2.OAuth2Utils.generateBasicAuthHeader;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/** Tests for {@link OAuth2Utils}. */
class OAuth2UtilsTest {

  @Test
  void testValidCredentials() {
    String username = "testUser";
    String password = "testPassword";
    String expectedHeader = "Basic dGVzdFVzZXI6dGVzdFBhc3N3b3Jk";

    String actualHeader = generateBasicAuthHeader(username, password);

    assertEquals(expectedHeader, actualHeader);
  }

  @Test
  void testEmptyUsername_throws() {
    String username = "";
    String password = "testPassword";

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          generateBasicAuthHeader(username, password);
        });
  }

  @Test
  void testEmptyPassword_throws() {
    String username = "testUser";
    String password = "";

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          generateBasicAuthHeader(username, password);
        });
  }

  @Test
  void testNullUsername_throws() {
    String username = null;
    String password = "testPassword";

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          generateBasicAuthHeader(username, password);
        });
  }

  @Test
  void testNullPassword_throws() {
    String username = "testUser";
    String password = null;

    assertThrows(
        IllegalArgumentException.class,
        () -> {
          generateBasicAuthHeader(username, password);
        });
  }

  @Test
  void isUnauthorizedException_null_returnsFalse() {
    org.junit.jupiter.api.Assertions.assertFalse(OAuth2Utils.isUnauthorizedException(null));
  }

  @Test
  void isUnauthorizedException_genericIOException_returnsFalse() {
    org.junit.jupiter.api.Assertions.assertFalse(
        OAuth2Utils.isUnauthorizedException(new java.io.IOException("Network error")));
  }

  @Test
  void isUnauthorizedException_oauthException401_returnsTrue() {
    OAuthException ex = new OAuthException("invalid_client", "Unauthorized", null, 401);
    org.junit.jupiter.api.Assertions.assertTrue(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_oauthExceptionNon401_returnsFalse() {
    OAuthException ex = new OAuthException("bad_request", "Bad Request", null, 400);
    org.junit.jupiter.api.Assertions.assertFalse(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_httpResponseException401_returnsTrue() {
    com.google.api.client.http.HttpResponseException ex =
        new com.google.api.client.http.HttpResponseException.Builder(
                401, "Unauthorized", new com.google.api.client.http.HttpHeaders())
            .build();
    org.junit.jupiter.api.Assertions.assertTrue(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_httpResponseExceptionNon401_returnsFalse() {
    com.google.api.client.http.HttpResponseException ex =
        new com.google.api.client.http.HttpResponseException.Builder(
                403, "Forbidden", new com.google.api.client.http.HttpHeaders())
            .build();
    org.junit.jupiter.api.Assertions.assertFalse(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_wrappedInExceptionChain_returnsTrue() {
    OAuthException oauthEx = new OAuthException("invalid_client", "Unauthorized", null, 401);
    java.io.IOException wrapped = new java.io.IOException("Wrapped failure", oauthEx);
    org.junit.jupiter.api.Assertions.assertTrue(OAuth2Utils.isUnauthorizedException(wrapped));

    com.google.api.client.http.HttpResponseException httpEx =
        new com.google.api.client.http.HttpResponseException.Builder(
                401, "Unauthorized", new com.google.api.client.http.HttpHeaders())
            .build();
    java.io.IOException wrappedHttp =
        new java.io.IOException("Outer", new java.io.IOException("Inner", httpEx));
    org.junit.jupiter.api.Assertions.assertTrue(OAuth2Utils.isUnauthorizedException(wrappedHttp));
  }
}
