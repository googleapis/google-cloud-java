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
import org.jspecify.annotations.NullMarked;

/** Interface for an Google OIDC token provider. This type represents a google issued OIDC token. */
@NullMarked
public interface IdTokenProvider {

  /**
   * Enum of various credential-specific options to apply to the token.
   *
   * <p><b>ComputeEngineCredentials</b>
   *
   * <ul>
   *   <li>FORMAT_FULL
   *   <li>LICENSES_TRUE
   *   <li>DISABLE_BOUND_ID_TOKEN
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
    INCLUDE_EMAIL("includeEmail"),
    /**
     * Requests an ID token that is not bound to the workload's agent identity certificate.
     *
     * <p>This option is only supported by {@link ComputeEngineCredentials}; other {@link
     * IdTokenProvider} implementations do not request bound ID tokens and ignore this option.
     *
     * <p>When an agent identity certificate is available, {@link ComputeEngineCredentials} requests
     * certificate-bound ID tokens by default. A bound ID token is only accepted by targets that
     * authenticate the caller over mTLS with the same certificate. Pass this option for targets
     * that are called over standard (non-mTLS) HTTPS, for example a Cloud Run service reached
     * through its {@code *.run.app} URL or a custom domain.
     *
     * <p>Unlike the {@code GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN=false} environment variable, which
     * globally disables certificate-bound access tokens and ID tokens across the entire process,
     * this option applies per call (or per {@link IdTokenCredentials} instance) and leaves access
     * tokens and other ID token requests bound. If this option is not set, the library binds the ID
     * token whenever an agent identity certificate is available and token binding is not globally
     * disabled by {@code GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN=false}.
     */
    DISABLE_BOUND_ID_TOKEN("disableBoundIdToken");

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
