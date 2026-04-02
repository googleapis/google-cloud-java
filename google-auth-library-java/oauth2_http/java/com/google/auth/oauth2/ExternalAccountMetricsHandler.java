/*
 * Copyright 2023 Google LLC
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

/**
 * A handler for generating the x-goog-api-client header value for BYOID external account
 * credentials.
 */
class ExternalAccountMetricsHandler implements java.io.Serializable {
  private static final String SOURCE_KEY = "source";
  private static final String IMPERSONATION_KEY = "sa-impersonation";
  private static final String CONFIG_LIFETIME_KEY = "config-lifetime";
  private static final String BYOID_METRICS_SECTION = "google-byoid-sdk";

  private final boolean configLifetime;
  private final boolean saImpersonation;
  private ExternalAccountCredentials credentials;

  /**
   * Constructor for the external account metrics handler.
   *
   * @param creds the {@code ExternalAccountCredentials} object to set the external account metrics
   *     options from.
   */
  ExternalAccountMetricsHandler(ExternalAccountCredentials creds) {
    this.saImpersonation = creds.getServiceAccountImpersonationUrl() != null;
    this.configLifetime =
        creds.getServiceAccountImpersonationOptions().customTokenLifetimeRequested;
    this.credentials = creds;
  }

  /**
   * Gets the external account metrics header value for the x-goog-api-client header.
   *
   * @return the header value.
   */
  String getExternalAccountMetricsHeader() {
    return String.format(
        "%s %s %s/%s %s/%s %s/%s",
        MetricsUtils.getLanguageAndAuthLibraryVersions(),
        BYOID_METRICS_SECTION,
        SOURCE_KEY,
        this.credentials.getCredentialSourceType(),
        IMPERSONATION_KEY,
        this.saImpersonation,
        CONFIG_LIFETIME_KEY,
        this.configLifetime);
  }
}
