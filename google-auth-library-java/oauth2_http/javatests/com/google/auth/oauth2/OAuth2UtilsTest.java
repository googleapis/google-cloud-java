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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpHeaders;
import com.google.api.client.http.HttpResponseException;
import com.google.api.client.util.SecurityUtils;
import com.google.common.primitives.Bytes;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
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
    assertFalse(OAuth2Utils.isUnauthorizedException(null));
  }

  @Test
  void isUnauthorizedException_genericIOException_returnsFalse() {
    assertFalse(OAuth2Utils.isUnauthorizedException(new IOException("Network error")));
  }

  @Test
  void isUnauthorizedException_oauthException401_returnsTrue() {
    OAuthException ex = new OAuthException("invalid_client", "Unauthorized", null, 401);
    assertTrue(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_oauthExceptionNon401_returnsFalse() {
    OAuthException ex = new OAuthException("bad_request", "Bad Request", null, 400);
    assertFalse(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_httpResponseException401_returnsTrue() {
    HttpResponseException ex =
        new HttpResponseException.Builder(401, "Unauthorized", new HttpHeaders()).build();
    assertTrue(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_httpResponseExceptionNon401_returnsFalse() {
    HttpResponseException ex =
        new HttpResponseException.Builder(403, "Forbidden", new HttpHeaders()).build();
    assertFalse(OAuth2Utils.isUnauthorizedException(ex));
  }

  @Test
  void isUnauthorizedException_wrappedInExceptionChain_returnsTrue() {
    OAuthException oauthEx = new OAuthException("invalid_client", "Unauthorized", null, 401);
    IOException wrapped = new IOException("Wrapped failure", oauthEx);
    assertTrue(OAuth2Utils.isUnauthorizedException(wrapped));

    HttpResponseException httpEx =
        new HttpResponseException.Builder(401, "Unauthorized", new HttpHeaders()).build();
    IOException wrappedHttp = new IOException("Outer", new IOException("Inner", httpEx));
    assertTrue(OAuth2Utils.isUnauthorizedException(wrappedHttp));
  }

  @Test
  void isInvalidGrantException_null_returnsFalse() {
    assertFalse(OAuth2Utils.isInvalidGrantException(null));
  }

  @Test
  void isInvalidGrantException_genericIOException_returnsFalse() {
    assertFalse(OAuth2Utils.isInvalidGrantException(new IOException("Network error")));
  }

  @Test
  void isInvalidGrantException_oauthExceptionInvalidGrant_returnsTrue() {
    OAuthException ex = new OAuthException("invalid_grant", "Invalid grant", null, 400);
    assertTrue(OAuth2Utils.isInvalidGrantException(ex));
  }

  @Test
  void isInvalidGrantException_oauthExceptionOtherErrorCode_returnsFalse() {
    OAuthException ex = new OAuthException("invalid_request", "Bad Request", null, 400);
    assertFalse(OAuth2Utils.isInvalidGrantException(ex));
  }

  @Test
  void isInvalidGrantException_nestedInExceptionChain_returnsTrue() {
    OAuthException oauthEx = new OAuthException("invalid_grant", "Invalid grant", null, 400);
    IOException wrapped = new IOException("Outer", new IOException("Inner", oauthEx));
    assertTrue(OAuth2Utils.isInvalidGrantException(wrapped));
  }

  @Test
  void hasCertificateChanged_nullOrSameReference_returnsFalse() throws Exception {
    assertFalse(OAuth2Utils.hasCertificateChanged(null, null));
    KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
    ks.load(null, null);
    assertFalse(OAuth2Utils.hasCertificateChanged(ks, ks));
    assertTrue(OAuth2Utils.hasCertificateChanged(null, ks));
    assertTrue(OAuth2Utils.hasCertificateChanged(ks, null));
  }

  @Test
  void hasCertificateChanged_distinctKeyStoreInstances_comparesCertificates() {
    KeyStore ks1 = IdentityPoolCredentialsTest.createPopulatedKeyStore();
    KeyStore ks2 = IdentityPoolCredentialsTest.createPopulatedKeyStore();
    KeyStore ksRotated = IdentityPoolCredentialsTest.createRotatedPopulatedKeyStore();

    assertFalse(OAuth2Utils.hasCertificateChanged(ks1, ks2));
    assertTrue(OAuth2Utils.hasCertificateChanged(ks1, ksRotated));
  }

  @Test
  void hasCertificateChanged_sameCertificateDifferentPrivateKey_returnsTrue() throws Exception {
    byte[] certBytes = Files.readAllBytes(Paths.get("testresources/mtls/test_cert.pem"));
    byte[] key1Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key.pem"));
    byte[] key2Bytes = Files.readAllBytes(Paths.get("testresources/mtls/test_key_2.pem"));
    byte[] newlineBytes = "\n".getBytes(StandardCharsets.UTF_8);

    KeyStore ks1 =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(certBytes, newlineBytes, key1Bytes)));
    KeyStore ks2 =
        SecurityUtils.createMtlsKeyStore(
            new ByteArrayInputStream(Bytes.concat(certBytes, newlineBytes, key2Bytes)));

    assertTrue(OAuth2Utils.hasCertificateChanged(ks1, ks2));
  }

  @Test
  void hasCertificateChanged_uninitializedKeyStore_returnsTrue() throws Exception {
    KeyStore uninitialized1 = KeyStore.getInstance(KeyStore.getDefaultType());
    KeyStore uninitialized2 = KeyStore.getInstance(KeyStore.getDefaultType());

    assertTrue(OAuth2Utils.hasCertificateChanged(uninitialized1, uninitialized2));
  }
}
