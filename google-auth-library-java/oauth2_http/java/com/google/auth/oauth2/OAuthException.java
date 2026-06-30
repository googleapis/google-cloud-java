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
import java.io.IOException;
import javax.annotation.Nullable;

/**
 * Encapsulates the standard OAuth error response. See
 * https://tools.ietf.org/html/rfc6749#section-5.2.
 */
class OAuthException extends GoogleAuthException {

  private final String errorCode;
  @Nullable private final String errorDescription;
  @Nullable private final String errorUri;

  OAuthException(String errorCode, @Nullable String errorDescription, @Nullable String errorUri) {
    this.errorCode = checkNotNull(errorCode);
    this.errorDescription = errorDescription;
    this.errorUri = errorUri;
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

  @Nullable
  String getErrorDescription() {
    return errorDescription;
  }

  @Nullable
  String getErrorUri() {
    return errorUri;
  }

  static OAuthException createFromHttpResponseException(HttpResponseException e)
      throws IOException {
    JsonParser parser = OAuth2Utils.JSON_FACTORY.createJsonParser((e).getContent());
    GenericJson errorResponse = parser.parseAndClose(GenericJson.class);

    String errorCode = (String) errorResponse.get("error");
    String errorDescription = null;
    String errorUri = null;
    if (errorResponse.containsKey("error_description")) {
      errorDescription = (String) errorResponse.get("error_description");
    }
    if (errorResponse.containsKey("error_uri")) {
      errorUri = (String) errorResponse.get("error_uri");
    }
    return new OAuthException(errorCode, errorDescription, errorUri);
  }
}
