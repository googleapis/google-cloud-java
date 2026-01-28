/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.jdbc.utils.URIBuilder;

public class BigQueryJdbcBaseTest {

  // This is a fake pkcs8 key generated specifically for unittests
  protected static final String fake_pkcs8_key =
      "-----BEGIN PRIVATE KEY-----\n"
          + //
          "MIIBUwIBADANBgkqhkiG9w0BAQEFAASCAT0wggE5AgEAAkEAnt6w5AMZBvOecsJ9\n"
          + //
          "4TeVz+GpAtBnTqkxWfxLJykkvb+V/3IhXr5Zw40y47RdoRly/QDFJz3Ac+nmwCSP\n"
          + //
          "8QW3GQIDAQABAkBPmdrd1COFFSnN7F9wKg65QyMQ0uUAR8v/f2cUbwwGuhwdMuGZ\n"
          + //
          "DPwgVZySxFKort7TfPru6NzbACL3EFAl9y9RAiEA7XPq5Tu+LOw4/CZFABykguBV\n"
          + //
          "8rYC+F72+GqkhvlGhZUCIQCrR2/zGIKqJSTKfQhKOteP7cx5dWrumHYNuC5InOGC\n"
          + //
          "dQIgM6bzgcntJHh+LNtmRw/z+UQzbgiJvN1re7426+VtocECIE7ejFxicviqNfDP\n"
          + //
          "9ltIES8Dj152hRDtP589qoJhSy5pAiAJot/kBQD8yFYMU1X02oi+6f8QqXxcHwZX\n"
          + //
          "2wK1Zawz/A==\n"
          + //
          "-----END PRIVATE KEY-----";

  protected static URIBuilder getBaseUri() {
    return new URIBuilder("jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;");
  }

  protected static URIBuilder getBaseUri(int authType) {
    return getBaseUri().append("OAuthType", authType);
  }

  protected static URIBuilder getBaseUri(int authType, String projectId) {
    return getBaseUri(authType).append("PROJECT_ID", projectId);
  }

  protected static URIBuilder getUriOAuthServiceAccount() {
    return getBaseUri()
        .append("OAuthType", 0)
        .append("OAuthServiceAcctEmail", "service@account")
        .append("OAuthPvtKey", fake_pkcs8_key);
  }

  protected static URIBuilder getUriOAuthUserAccount() {
    return getBaseUri()
        .append("OAuthType", 1)
        .append("OAuthClientId", "client@id")
        .append("OAuthClientSecret", "client_secret");
  }

  protected static URIBuilder getUriOAuthToken() {
    return getBaseUri().append("OAuthType", 2).append("OAuthAccessToken", "RedactedToken");
  }

  protected static URIBuilder getUriOAuthApplicationDefault() {
    return getBaseUri().append("OAuthType", 3);
  }

  protected static URIBuilder getUriOAuthExternal() {
    return getBaseUri().append("OAuthType", 4).append("OAuthPvtKey", fake_pkcs8_key);
  }
}
