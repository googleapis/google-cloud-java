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

import static com.google.auth.oauth2.OAuth2Credentials.DEFAULT_EXPIRATION_MARGIN;
import static com.google.auth.oauth2.OAuth2Credentials.DEFAULT_REFRESH_MARGIN;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.auth.TestUtils;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Tests for {@link OAuth2CredentialsWithRefresh}. */
class OAuth2CredentialsWithRefreshTest {
  private static final AccessToken ACCESS_TOKEN = new AccessToken("accessToken", new Date());

  @Test
  void builder() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler refreshHandler =
        new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
          @Override
          public AccessToken refreshAccessToken() {
            return null;
          }
        };
    OAuth2CredentialsWithRefresh credential =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(ACCESS_TOKEN)
            .setRefreshHandler(refreshHandler)
            .build();

    assertEquals(ACCESS_TOKEN, credential.getAccessToken());
    assertEquals(refreshHandler, credential.getRefreshHandler());
  }

  @Test
  void builder_withRefreshAndExpirationMargins() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler refreshHandler =
        new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
          @Override
          public AccessToken refreshAccessToken() {
            return null;
          }
        };

    Duration refreshMargin = Duration.of(10, ChronoUnit.SECONDS);
    Duration expirationMargin = Duration.of(12, ChronoUnit.SECONDS);

    OAuth2CredentialsWithRefresh credential =
        (OAuth2CredentialsWithRefresh)
            OAuth2CredentialsWithRefresh.newBuilder()
                .setAccessToken(ACCESS_TOKEN)
                .setRefreshHandler(refreshHandler)
                .setRefreshMargin(refreshMargin)
                .setExpirationMargin(expirationMargin)
                .build();

    assertEquals(ACCESS_TOKEN, credential.getAccessToken());
    assertEquals(refreshMargin, credential.getRefreshMargin());
    assertEquals(expirationMargin, credential.getExpirationMargin());
    assertEquals(refreshHandler, credential.getRefreshHandler());
  }

  @Test
  void builder_onlyRefreshMarginSet() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler refreshHandler =
        new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
          @Override
          public AccessToken refreshAccessToken() {
            return null;
          }
        };

    Duration refreshMargin = Duration.of(10, ChronoUnit.SECONDS);

    OAuth2CredentialsWithRefresh credential =
        (OAuth2CredentialsWithRefresh)
            OAuth2CredentialsWithRefresh.newBuilder()
                .setAccessToken(ACCESS_TOKEN)
                .setRefreshHandler(refreshHandler)
                .setRefreshMargin(refreshMargin)
                .build();

    assertEquals(ACCESS_TOKEN, credential.getAccessToken());
    assertEquals(refreshMargin, credential.getRefreshMargin());
    assertEquals(DEFAULT_EXPIRATION_MARGIN, credential.getExpirationMargin());
    assertEquals(refreshHandler, credential.getRefreshHandler());
  }

  @Test
  void builder_onlyExpirationMarginSet() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler refreshHandler =
        new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
          @Override
          public AccessToken refreshAccessToken() {
            return null;
          }
        };

    Duration expirationMargin = Duration.of(12, ChronoUnit.SECONDS);
    OAuth2CredentialsWithRefresh credential =
        (OAuth2CredentialsWithRefresh)
            OAuth2CredentialsWithRefresh.newBuilder()
                .setAccessToken(ACCESS_TOKEN)
                .setRefreshHandler(refreshHandler)
                .setExpirationMargin(expirationMargin)
                .build();

    assertEquals(ACCESS_TOKEN, credential.getAccessToken());
    assertEquals(DEFAULT_REFRESH_MARGIN, credential.getRefreshMargin());
    assertEquals(expirationMargin, credential.getExpirationMargin());
    assertEquals(refreshHandler, credential.getRefreshHandler());
  }

  @Test
  void builder_noAccessToken() {
    OAuth2CredentialsWithRefresh.newBuilder()
        .setRefreshHandler(
            new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
              @Override
              public AccessToken refreshAccessToken() {
                return null;
              }
            })
        .build();
  }

  @Test
  void builder_noRefreshHandler_throws() {
    try {
      OAuth2CredentialsWithRefresh.newBuilder().setAccessToken(ACCESS_TOKEN).build();
      fail("Should fail as a refresh handler must be provided.");
    } catch (NullPointerException e) {
      // Expected.
    }
  }

  @Test
  void builder_noExpirationTimeInAccessToken_throws() {
    try {
      OAuth2CredentialsWithRefresh.newBuilder()
          .setAccessToken(new AccessToken("accessToken", null))
          .build();
      fail("Should fail as a refresh handler must be provided.");
    } catch (IllegalArgumentException e) {
      // Expected.
    }
  }

  @Test
  void refreshAccessToken_delegateToRefreshHandler() throws IOException {
    final AccessToken refreshedToken = new AccessToken("refreshedAccessToken", new Date());
    OAuth2CredentialsWithRefresh credentials =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(ACCESS_TOKEN)
            .setRefreshHandler(
                new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
                  @Override
                  public AccessToken refreshAccessToken() {
                    return refreshedToken;
                  }
                })
            .build();

    AccessToken accessToken = credentials.refreshAccessToken();

    assertEquals(refreshedToken, accessToken);
  }

  @Test
  void getRequestMetadata() throws IOException {
    URI uri = URI.create("http://googleapis.com/testapi/v1/foo");
    final AccessToken refreshedToken = new AccessToken("refreshedAccessToken", new Date());
    OAuth2CredentialsWithRefresh credentials =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(ACCESS_TOKEN)
            .setRefreshHandler(
                new OAuth2CredentialsWithRefresh.OAuth2RefreshHandler() {
                  @Override
                  public AccessToken refreshAccessToken() {
                    return refreshedToken;
                  }
                })
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(uri);

    TestUtils.assertContainsBearerToken(metadata, refreshedToken.getTokenValue());
  }
}
