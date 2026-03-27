/*
 * Copyright 2019, Google LLC
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

import java.io.IOException;
import java.util.List;

/** Interface for an Google OIDC token provider. This type represents a google issued OIDC token. */
public interface IdTokenProvider {

  /**
   * Enum of various credential-specific options to apply to the token.
   *
   * <p><b>ComputeEngineCredentials</b>
   *
   * <ul>
   *   <li>FORMAT_FULL
   *   <li>LICENSES_TRUE
   * </ul>
   *
   * <br>
   * <b>ImpersonatedCredential</b>
   *
   * <ul>
   *   <li>INCLUDE_EMAIL
   * </ul>
   */
  public enum Option {
    FORMAT_FULL("formatFull"),
    LICENSES_TRUE("licensesTrue"),
    INCLUDE_EMAIL("includeEmail");

    private final String option;

    private Option(String option) {
      this.option = option;
    }

    public String getOption() {
      return option;
    }
  }

  /**
   * Returns a Google OpenID Token with the provided audience field.
   *
   * @param targetAudience List of audiences the issued ID Token should be valid for. targetAudience
   *     accepts a single string value (multiple audiences are not supported)
   * @param options List of Credential specific options for for the token. For example, an IDToken
   *     for a ComputeEngineCredential can return platform specific claims if
   *     "ComputeEngineCredentials.ID_TOKEN_FORMAT_FULL" is provided as a list option.
   * @throws IOException if token creation fails
   * @return IdToken object which includes the raw id_token, expiration and audience.
   */
  IdToken idTokenWithAudience(String targetAudience, List<Option> options) throws IOException;
}
