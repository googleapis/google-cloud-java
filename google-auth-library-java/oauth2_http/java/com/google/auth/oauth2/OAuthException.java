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

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonParser;
import java.util.Map;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

/**
 * Encapsulates the standard OAuth error response. See
 * https://tools.ietf.org/html/rfc6749#section-5.2.
 */
@NullMarked
class OAuthException extends GoogleAuthException {

  // Matches the computed value in released versions so previously serialized instances still load.
  private static final long serialVersionUID = -5276727039237496975L;

  private final String errorCode;
  @Nullable private final String errorDescription;
  @Nullable private final String errorUri;
  private final int httpStatusCode;

  OAuthException(String errorCode, @Nullable String errorDescription, @Nullable String errorUri) {
    this(errorCode, errorDescription, errorUri, 0);
  }

  OAuthException(
      String errorCode,
      @Nullable String errorDescription,
      @Nullable String errorUri,
      int httpStatusCode) {
    this.errorCode = checkNotNull(errorCode);
    this.errorDescription = errorDescription;
    this.errorUri = errorUri;
    this.httpStatusCode = httpStatusCode;
  }

  @Override
  public String getMessage() {
    // Fully specified message will have the format Error code %s: %s - %s.
    StringBuilder sb = new StringBuilder("Error code " + errorCode);
    if (errorDescription != null) {
      sb.append(": ").append(errorDescription);
    }
    if (errorUri != null) {
      sb.append(" - ").append(errorUri);
    }
    return sb.toString();
  }

  String getErrorCode() {
    return errorCode;
  }

  @Nullable String getErrorDescription() {
    return errorDescription;
  }

  @Nullable String getErrorUri() {
    return errorUri;
  }

  int getHttpStatusCode() {
    return httpStatusCode;
  }

  static OAuthException createFromHttpResponseException(HttpResponseException e) {
    String content = e.getContent();
    if (content == null || content.trim().isEmpty()) {
      // When the HTTP error response has no body, synthesize "http_error_<status>" as the
      // required non-null errorCode and pass e.getStatusMessage() as errorDescription.
      OAuthException oauthException =
          new OAuthException(
              "http_error_" + e.getStatusCode(), e.getStatusMessage(), null, e.getStatusCode());
      oauthException.initCause(e);
      return oauthException;
    }
    try {
      JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser(content);
      GenericJson errorResponse = parser.parseAndClose(GenericJson.class);
      if (errorResponse == null) {
        OAuthException oauthException =
            new OAuthException(
                "http_error_" + e.getStatusCode(), e.getStatusMessage(), null, e.getStatusCode());
        oauthException.initCause(e);
        return oauthException;
      }
      return createFromJsonErrorResponse(errorResponse, content, e);
    } catch (Exception parseException) {
      // Non-JSON response body (e.g. HTML/text from a proxy): preserve the status code and raw
      // body rather than failing with a JSON parse error.
      OAuthException oauthException =
          new OAuthException("http_error_" + e.getStatusCode(), content, null, e.getStatusCode());
      oauthException.initCause(e);
      return oauthException;
    }
  }

  /**
   * Extracts OAuth error fields from a parsed JSON error response body.
   *
   * <p>OAuth, STS, and IAM endpoints can return JSON error bodies in two schemas:
   *
   * <ol>
   *   <li>RFC 6749 Section 5.2 OAuth 2.0 format, where {@code "error"} is a top-level String:
   *       {@code {"error": "invalid_grant", "error_description": "...", "error_uri": "..."}}
   *   <li>Google API Standard Error format ({@code google.rpc.Status} / AIP-193), returned by
   *       GFE/STS/IAM on mTLS or HTTP 401/403 authentication errors, where {@code "error"} is a
   *       nested JSON object: {@code {"error": {"code": 401, "status": "UNAUTHENTICATED",
   *       "message": "..."}}}
   * </ol>
   */
  private static OAuthException createFromJsonErrorResponse(
      GenericJson errorResponse, String content, HttpResponseException e) {
    String errorCode = null;
    String errorDescription = null;
    Object rawError = errorResponse.get("error");
    if (rawError instanceof String) {
      errorCode = (String) rawError;
    } else if (rawError instanceof Map) {
      Map<?, ?> errorMap = (Map<?, ?>) rawError;
      if (errorMap.get("status") instanceof String) {
        errorCode = (String) errorMap.get("status");
      }
      if (errorMap.get("message") instanceof String) {
        errorDescription = (String) errorMap.get("message");
      }
    }
    if (errorCode == null) {
      errorCode = "http_error_" + e.getStatusCode();
    }
    // Prefer top-level "error_description" (RFC 6749) when present; otherwise fall back to
    // nested "error.message", top-level "message", or the HTTP status message / raw body.
    String errorUri = null;
    if (errorResponse.get("error_description") instanceof String) {
      errorDescription = (String) errorResponse.get("error_description");
    } else if (errorDescription == null && errorResponse.get("message") instanceof String) {
      errorDescription = (String) errorResponse.get("message");
    }
    if (errorDescription == null && !(rawError instanceof String)) {
      errorDescription =
          errorResponse.isEmpty() && e.getStatusMessage() != null ? e.getStatusMessage() : content;
    }
    if (errorResponse.get("error_uri") instanceof String) {
      errorUri = (String) errorResponse.get("error_uri");
    }
    OAuthException oauthException =
        new OAuthException(errorCode, errorDescription, errorUri, e.getStatusCode());
    oauthException.initCause(e);
    return oauthException;
  }
}
