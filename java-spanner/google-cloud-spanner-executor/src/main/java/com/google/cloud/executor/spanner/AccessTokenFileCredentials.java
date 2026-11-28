/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.executor.spanner;

import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.common.base.Preconditions;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.Date;
import org.apache.commons.io.FileUtils;

/**
 * {@link OAuth2Credentials} backed by a local file containing a raw OAuth2 bearer access token.
 *
 * <p>An external host process periodically refreshes and atomically replaces the token file before
 * the underlying OAuth2 token expires. Because the file contains only the raw token string without
 * expiry metadata, each read assigns a bounded synthetic lifetime so {@link OAuth2Credentials}
 * periodically re-reads the file via {@link #refreshAccessToken()}.
 */
final class AccessTokenFileCredentials extends OAuth2Credentials {

  private static final long serialVersionUID = 1L;

  /**
   * Assign a 15-minute synthetic lifetime to each file read. With {@link OAuth2Credentials}'s
   * default refresh/expiration margins (~3m45s / 3m), cached tokens are refreshed from disk roughly
   * every 11 minutes, well within a typical 1-hour OAuth2 access token lifetime.
   */
  static final Duration DEFAULT_SYNTHETIC_LIFETIME = Duration.ofMinutes(15);

  private final File tokenFile;
  private final Duration syntheticLifetime;

  AccessTokenFileCredentials(File tokenFile) {
    super(null);
    this.tokenFile = Preconditions.checkNotNull(tokenFile, "tokenFile");
    this.syntheticLifetime = DEFAULT_SYNTHETIC_LIFETIME;
  }

  AccessTokenFileCredentials(
      File tokenFile,
      Duration syntheticLifetime,
      Duration refreshMargin,
      Duration expirationMargin) {
    super(null, refreshMargin, expirationMargin);
    this.tokenFile = Preconditions.checkNotNull(tokenFile, "tokenFile");
    this.syntheticLifetime = Preconditions.checkNotNull(syntheticLifetime, "syntheticLifetime");
    Preconditions.checkArgument(
        !syntheticLifetime.isNegative(), "syntheticLifetime cannot be negative");
  }

  @Override
  public AccessToken refreshAccessToken() throws IOException {
    if (!tokenFile.isFile()) {
      throw new IOException(
          "Access token file does not exist or is not a regular file: " + tokenFile);
    }
    String token = FileUtils.readFileToString(tokenFile, StandardCharsets.UTF_8).trim();
    if (token.isEmpty()) {
      throw new IOException("Access token file is empty: " + tokenFile);
    }
    Date expirationTime = new Date(System.currentTimeMillis() + syntheticLifetime.toMillis());
    return new AccessToken(token, expirationTime);
  }
}
