/*
 * Copyright 2022 Google LLC
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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.client.json.GenericJson;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import org.junit.jupiter.api.Test;

/** Tests for {@link ExecutableResponse}. */
class ExecutableResponseTest {

  private static final String TOKEN_TYPE_OIDC = "urn:ietf:params:oauth:token-type:id_token";
  private static final String TOKEN_TYPE_SAML = "urn:ietf:params:oauth:token-type:saml2";
  private static final String ID_TOKEN = "header.payload.signature";
  private static final String SAML_RESPONSE = "samlResponse";

  private static final int EXECUTABLE_SUPPORTED_MAX_VERSION = 1;
  private static final int EXPIRATION_DURATION = 3600;

  @Test
  void constructor_successOidcResponse() throws IOException {
    ExecutableResponse response = new ExecutableResponse(buildOidcResponse());

    assertTrue(response.isSuccessful());
    assertTrue(response.isValid());
    assertEquals(EXECUTABLE_SUPPORTED_MAX_VERSION, response.getVersion());
    assertEquals(TOKEN_TYPE_OIDC, response.getTokenType());
    assertEquals(ID_TOKEN, response.getSubjectToken());
    assertEquals(
        Instant.now().getEpochSecond() + EXPIRATION_DURATION, (long) response.getExpirationTime());
  }

  @Test
  void constructor_successOidcResponseMissingExpirationTimeField_notExpired() throws IOException {
    GenericJson jsonResponse = buildOidcResponse();
    jsonResponse.remove("expiration_time");

    ExecutableResponse response = new ExecutableResponse(jsonResponse);

    assertTrue(response.isSuccessful());
    assertTrue(response.isValid());
    assertFalse(response.isExpired());
    assertEquals(EXECUTABLE_SUPPORTED_MAX_VERSION, response.getVersion());
    assertEquals(TOKEN_TYPE_OIDC, response.getTokenType());
    assertEquals(ID_TOKEN, response.getSubjectToken());
    assertNull(response.getExpirationTime());
  }

  @Test
  void constructor_successSamlResponse() throws IOException {
    ExecutableResponse response = new ExecutableResponse(buildSamlResponse());

    assertTrue(response.isSuccessful());
    assertTrue(response.isValid());
    assertEquals(EXECUTABLE_SUPPORTED_MAX_VERSION, response.getVersion());
    assertEquals(TOKEN_TYPE_SAML, response.getTokenType());
    assertEquals(SAML_RESPONSE, response.getSubjectToken());
    assertEquals(
        Instant.now().getEpochSecond() + EXPIRATION_DURATION, (long) response.getExpirationTime());
  }

  @Test
  void constructor_successSamlResponseMissingExpirationTimeField_notExpired() throws IOException {
    GenericJson jsonResponse = buildSamlResponse();
    jsonResponse.remove("expiration_time");

    ExecutableResponse response = new ExecutableResponse(jsonResponse);

    assertTrue(response.isSuccessful());
    assertTrue(response.isValid());
    assertFalse(response.isExpired());
    assertEquals(EXECUTABLE_SUPPORTED_MAX_VERSION, response.getVersion());
    assertEquals(TOKEN_TYPE_SAML, response.getTokenType());
    assertEquals(SAML_RESPONSE, response.getSubjectToken());
    assertNull(response.getExpirationTime());
  }

  @Test
  void constructor_validErrorResponse() throws IOException {
    ExecutableResponse response = new ExecutableResponse(buildErrorResponse());

    assertFalse(response.isSuccessful());
    assertFalse(response.isValid());
    assertFalse(response.isExpired());
    assertNull(response.getSubjectToken());
    assertNull(response.getTokenType());
    assertNull(response.getExpirationTime());
    assertEquals(EXECUTABLE_SUPPORTED_MAX_VERSION, response.getVersion());
    assertEquals("401", response.getErrorCode());
    assertEquals("Caller not authorized.", response.getErrorMessage());
  }

  @Test
  void constructor_errorResponseMissingCode_throws() throws IOException {
    GenericJson jsonResponse = buildErrorResponse();

    Object[] values = new Object[] {null, ""};
    for (Object value : values) {
      jsonResponse.put("code", value);
      try {
        new ExecutableResponse(jsonResponse);
        fail("Should not be able to continue without exception.");
      } catch (PluggableAuthException exception) {
        assertEquals(
            "Error code INVALID_EXECUTABLE_RESPONSE: The executable response must contain "
                + "`error` and `message` fields when unsuccessful.",
            exception.getMessage());
      }
    }
  }

  @Test
  void constructor_errorResponseMissingMessage_throws() throws IOException {
    GenericJson jsonResponse = buildErrorResponse();

    Object[] values = new Object[] {null, ""};
    for (Object value : values) {
      jsonResponse.put("message", value);

      try {
        new ExecutableResponse(jsonResponse);
        fail("Should not be able to continue without exception.");
      } catch (PluggableAuthException exception) {
        assertEquals(
            "Error code INVALID_EXECUTABLE_RESPONSE: The executable response must contain "
                + "`error` and `message` fields when unsuccessful.",
            exception.getMessage());
      }
    }
  }

  @Test
  void constructor_successResponseMissingVersionField_throws() throws IOException {
    GenericJson jsonResponse = buildOidcResponse();
    jsonResponse.remove("version");

    try {
      new ExecutableResponse(jsonResponse);
      fail("Should not be able to continue without exception.");
    } catch (PluggableAuthException exception) {
      assertEquals(
          "Error code INVALID_EXECUTABLE_RESPONSE: The executable response is missing the "
              + "`version` field.",
          exception.getMessage());
    }
  }

  @Test
  void constructor_successResponseMissingSuccessField_throws() throws Exception {
    GenericJson jsonResponse = buildOidcResponse();
    jsonResponse.remove("success");

    try {
      new ExecutableResponse(jsonResponse);
      fail("Should not be able to continue without exception.");
    } catch (PluggableAuthException exception) {
      assertEquals(
          "Error code INVALID_EXECUTABLE_RESPONSE: The executable response is missing the "
              + "`success` field.",
          exception.getMessage());
    }
  }

  @Test
  void constructor_successResponseMissingTokenTypeField_throws() throws IOException {
    GenericJson jsonResponse = buildOidcResponse();
    jsonResponse.remove("token_type");

    try {
      new ExecutableResponse(jsonResponse);
      fail("Should not be able to continue without exception.");
    } catch (PluggableAuthException exception) {
      assertEquals(
          "Error code INVALID_EXECUTABLE_RESPONSE: The executable response is missing the "
              + "`token_type` field.",
          exception.getMessage());
    }
  }

  @Test
  void constructor_samlResponseMissingSubjectToken_throws() throws IOException {
    GenericJson jsonResponse = buildSamlResponse();

    Object[] values = new Object[] {null, ""};
    for (Object value : values) {
      jsonResponse.put("saml_response", value);

      try {
        new ExecutableResponse(jsonResponse);
        fail("Should not be able to continue without exception.");
      } catch (PluggableAuthException exception) {
        assertEquals(
            "Error code INVALID_EXECUTABLE_RESPONSE: The executable response does not "
                + "contain a valid token.",
            exception.getMessage());
      }
    }
  }

  @Test
  void constructor_oidcResponseMissingSubjectToken_throws() throws IOException {
    GenericJson jsonResponse = buildOidcResponse();

    Object[] values = new Object[] {null, ""};
    for (Object value : values) {
      jsonResponse.put("id_token", value);

      try {
        new ExecutableResponse(jsonResponse);
        fail("Should not be able to continue without exception.");
      } catch (PluggableAuthException exception) {
        assertEquals(
            "Error code INVALID_EXECUTABLE_RESPONSE: The executable response does not "
                + "contain a valid token.",
            exception.getMessage());
      }
    }
  }

  @Test
  void isExpired() throws IOException {
    GenericJson jsonResponse = buildOidcResponse();

    BigDecimal[] values =
        new BigDecimal[] {
          BigDecimal.valueOf(Instant.now().getEpochSecond() - 1000),
          BigDecimal.valueOf(Instant.now().getEpochSecond() + 1000)
        };
    boolean[] expectedResults = new boolean[] {true, false};

    for (int i = 0; i < values.length; i++) {
      jsonResponse.put("expiration_time", values[i]);

      ExecutableResponse response = new ExecutableResponse(jsonResponse);

      assertEquals(expectedResults[i], response.isExpired());
    }
  }

  private static GenericJson buildOidcResponse() {
    GenericJson json = new GenericJson();
    json.setFactory(OAuth2Utils.JSON_FACTORY);
    json.put("version", EXECUTABLE_SUPPORTED_MAX_VERSION);
    json.put("success", true);
    json.put("token_type", TOKEN_TYPE_OIDC);
    json.put("id_token", ID_TOKEN);
    json.put("expiration_time", Instant.now().getEpochSecond() + EXPIRATION_DURATION);
    return json;
  }

  private static GenericJson buildSamlResponse() {
    GenericJson json = new GenericJson();
    json.setFactory(OAuth2Utils.JSON_FACTORY);
    json.put("version", EXECUTABLE_SUPPORTED_MAX_VERSION);
    json.put("success", true);
    json.put("token_type", TOKEN_TYPE_SAML);
    json.put("saml_response", "samlResponse");
    json.put("expiration_time", Instant.now().getEpochSecond() + EXPIRATION_DURATION);
    return json;
  }

  private static GenericJson buildErrorResponse() {
    GenericJson json = new GenericJson();
    json.setFactory(OAuth2Utils.JSON_FACTORY);
    json.put("version", EXECUTABLE_SUPPORTED_MAX_VERSION);
    json.put("success", false);
    json.put("code", "401");
    json.put("message", "Caller not authorized.");
    return json;
  }
}
