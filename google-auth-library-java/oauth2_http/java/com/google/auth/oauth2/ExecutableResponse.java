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

import com.google.api.client.json.GenericJson;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Nullable;

/**
 * Encapsulates response values for the 3rd party executable response (e.g. OIDC, SAML, error
 * responses).
 */
class ExecutableResponse {

  private static final String SAML_SUBJECT_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:saml2";

  private final int version;
  private final boolean success;

  @Nullable private Long expirationTime;
  @Nullable private String tokenType;
  @Nullable private String subjectToken;
  @Nullable private String errorCode;
  @Nullable private String errorMessage;

  ExecutableResponse(GenericJson json) throws IOException {
    if (!json.containsKey("version")) {
      throw new PluggableAuthException(
          "INVALID_EXECUTABLE_RESPONSE", "The executable response is missing the `version` field.");
    }

    if (!json.containsKey("success")) {
      throw new PluggableAuthException(
          "INVALID_EXECUTABLE_RESPONSE", "The executable response is missing the `success` field.");
    }

    this.version = parseIntField(json.get("version"));
    this.success = (boolean) json.get("success");

    if (success) {
      if (!json.containsKey("token_type")) {
        throw new PluggableAuthException(
            "INVALID_EXECUTABLE_RESPONSE",
            "The executable response is missing the `token_type` field.");
      }

      this.tokenType = (String) json.get("token_type");

      if (json.containsKey("expiration_time")) {
        this.expirationTime = parseLongField(json.get("expiration_time"));
      }

      if (SAML_SUBJECT_TOKEN_TYPE.equals(tokenType)) {
        this.subjectToken = (String) json.get("saml_response");
      } else {
        this.subjectToken = (String) json.get("id_token");
      }
      if (subjectToken == null || subjectToken.isEmpty()) {
        throw new PluggableAuthException(
            "INVALID_EXECUTABLE_RESPONSE",
            "The executable response does not contain a valid token.");
      }
    } else {
      // Error response must contain both an error code and message.
      this.errorCode = (String) json.get("code");
      this.errorMessage = (String) json.get("message");
      if (errorCode == null
          || errorCode.isEmpty()
          || errorMessage == null
          || errorMessage.isEmpty()) {
        throw new PluggableAuthException(
            "INVALID_EXECUTABLE_RESPONSE",
            "The executable response must contain `error` and `message` fields when unsuccessful.");
      }
    }
  }

  /**
   * Returns the version of the executable output. Only version `1` is currently supported. This is
   * useful for future changes to the expected output format.
   *
   * @return The version of the JSON output.
   */
  int getVersion() {
    return this.version;
  }

  /**
   * Returns the status of the response.
   *
   * <p>When this is true, the response will contain the 3rd party token for a sign in / refresh
   * operation. When this is false, the response should contain an additional error code and
   * message.
   *
   * @return Whether the `success` field in the executable response is true.
   */
  boolean isSuccessful() {
    return this.success;
  }

  /** Returns true if the subject token is expired, false otherwise. */
  boolean isExpired() {
    return this.expirationTime != null && this.expirationTime <= Instant.now().getEpochSecond();
  }

  /** Returns whether the execution was successful and returned an unexpired token. */
  boolean isValid() {
    return isSuccessful() && !isExpired();
  }

  /** Returns the subject token expiration time in seconds (Unix epoch time). */
  @Nullable
  Long getExpirationTime() {
    return this.expirationTime;
  }

  /**
   * Returns the 3rd party subject token type.
   *
   * <p>Possible valid values:
   *
   * <ul>
   *   <li>urn:ietf:params:oauth:token-type:id_token
   *   <li>urn:ietf:params:oauth:token-type:jwt
   *   <li>urn:ietf:params:oauth:token-type:saml2
   * </ul>
   *
   * @return The 3rd party subject token type for success responses, null otherwise.
   */
  @Nullable
  String getTokenType() {
    return this.tokenType;
  }

  /** Returns the subject token if the execution was successful, null otherwise. */
  @Nullable
  String getSubjectToken() {
    return this.subjectToken;
  }

  /** Returns the error code if the execution was unsuccessful, null otherwise. */
  @Nullable
  String getErrorCode() {
    return this.errorCode;
  }

  /** Returns the error message if the execution was unsuccessful, null otherwise. */
  @Nullable
  String getErrorMessage() {
    return this.errorMessage;
  }

  private static int parseIntField(Object field) {
    if (field instanceof String) {
      return Integer.parseInt((String) field);
    }
    if (field instanceof BigDecimal) {
      return ((BigDecimal) field).intValue();
    }
    return (int) field;
  }

  private static long parseLongField(Object field) {
    if (field instanceof String) {
      return Long.parseLong((String) field);
    }
    if (field instanceof BigDecimal) {
      return ((BigDecimal) field).longValue();
    }
    return (long) field;
  }
}
