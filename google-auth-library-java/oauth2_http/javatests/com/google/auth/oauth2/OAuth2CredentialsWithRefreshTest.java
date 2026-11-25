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
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.auth.Credentials;
import com.google.auth.TestUtils;
import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.junit.jupiter.api.Test;

/** Tests for {@link OAuth2CredentialsWithRefresh}. */
class OAuth2CredentialsWithRefreshTest extends BaseSerializationTest {
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
    OAuth2CredentialsWithRefresh.Builder builder =
        OAuth2CredentialsWithRefresh.newBuilder().setRefreshHandler(() -> null);
    assertDoesNotThrow(builder::build);
  }

  @Test
  void builder_noRefreshHandler_throws() {
    OAuth2CredentialsWithRefresh.Builder builder =
        OAuth2CredentialsWithRefresh.newBuilder().setAccessToken(ACCESS_TOKEN);
    assertThrows(NullPointerException.class, builder::build);
  }

  @Test
  void builder_noExpirationTimeInAccessToken_throws() {
    OAuth2CredentialsWithRefresh.Builder builder =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(new AccessToken("accessToken", null));
    assertThrows(IllegalArgumentException.class, builder::build);
  }

  @Test
  void refreshAccessToken_delegateToRefreshHandler() throws IOException {
    final AccessToken refreshedToken = new AccessToken("refreshedAccessToken", new Date());
    OAuth2CredentialsWithRefresh credentials =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(ACCESS_TOKEN)
            .setRefreshHandler(() -> refreshedToken)
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
            .setRefreshHandler(() -> refreshedToken)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(uri);

    TestUtils.assertContainsBearerToken(metadata, refreshedToken.getTokenValue());
  }

  private static final AccessToken REFRESHED_TOKEN =
      new AccessToken("refreshedAccessToken", new Date());

  private static final class SerializableRefreshHandler
      implements OAuth2CredentialsWithRefresh.OAuth2RefreshHandler, Serializable {
    private static final long serialVersionUID = 1L;
    private final AccessToken refreshedToken;

    private SerializableRefreshHandler(AccessToken refreshedToken) {
      this.refreshedToken = refreshedToken;
    }

    @Override
    public AccessToken refreshAccessToken() {
      return refreshedToken;
    }

    @Override
    public boolean equals(Object obj) {
      if (!(obj instanceof SerializableRefreshHandler)) {
        return false;
      }
      SerializableRefreshHandler other = (SerializableRefreshHandler) obj;
      return Objects.equals(this.refreshedToken, other.refreshedToken);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(refreshedToken);
    }
  }

  private static OAuth2CredentialsWithRefresh.Builder createTestBuilder(
      OAuth2CredentialsWithRefresh.OAuth2RefreshHandler handler) {
    return OAuth2CredentialsWithRefresh.newBuilder()
        .setAccessToken(ACCESS_TOKEN)
        .setRefreshHandler(handler);
  }

  @Test
  void protectedConstructor() throws IOException {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler handler = () -> ACCESS_TOKEN;
    OAuth2CredentialsWithRefresh credentials =
        new OAuth2CredentialsWithRefresh(ACCESS_TOKEN, handler);

    assertEquals(ACCESS_TOKEN, credentials.getAccessToken());
    assertEquals(handler, credentials.getRefreshHandler());
    assertEquals(DEFAULT_REFRESH_MARGIN, credentials.getRefreshMargin());
    assertEquals(DEFAULT_EXPIRATION_MARGIN, credentials.getExpirationMargin());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());

    assertThrows(
        NullPointerException.class, () -> new OAuth2CredentialsWithRefresh(ACCESS_TOKEN, null));
    assertThrows(
        IllegalArgumentException.class,
        () -> new OAuth2CredentialsWithRefresh(new AccessToken("accessToken", null), handler));
  }

  @Test
  void builder_universeDomain() throws IOException {
    OAuth2CredentialsWithRefresh.Builder builder = createTestBuilder(() -> ACCESS_TOKEN);
    assertNull(builder.getUniverseDomain());

    builder.setUniverseDomain("example.com");
    assertEquals("example.com", builder.getUniverseDomain());
    assertEquals("example.com", builder.build().getUniverseDomain());
  }

  @Test
  void getUniverseDomain_defaultsToGoogleDefaultUniverse() throws IOException {
    assertEquals(
        Credentials.GOOGLE_DEFAULT_UNIVERSE,
        createTestBuilder(() -> ACCESS_TOKEN).build().getUniverseDomain());
    assertEquals(
        Credentials.GOOGLE_DEFAULT_UNIVERSE,
        createTestBuilder(() -> ACCESS_TOKEN).setUniverseDomain(null).build().getUniverseDomain());
    assertEquals(
        Credentials.GOOGLE_DEFAULT_UNIVERSE,
        createTestBuilder(() -> ACCESS_TOKEN).setUniverseDomain("").build().getUniverseDomain());
    assertEquals(
        Credentials.GOOGLE_DEFAULT_UNIVERSE,
        createTestBuilder(() -> ACCESS_TOKEN).setUniverseDomain("   ").build().getUniverseDomain());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    SerializableRefreshHandler handler = new SerializableRefreshHandler(REFRESHED_TOKEN);
    OAuth2CredentialsWithRefresh credentials = createTestBuilder(handler).build();

    OAuth2CredentialsWithRefresh deserialized = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserialized);
    assertEquals(credentials.hashCode(), deserialized.hashCode());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, deserialized.getUniverseDomain());
    assertEquals(REFRESHED_TOKEN, deserialized.refreshAccessToken());
    TestUtils.assertContainsBearerToken(
        deserialized.getRequestMetadata(URI.create("http://googleapis.com/testapi/v1/foo")),
        REFRESHED_TOKEN.getTokenValue());
  }

  @Test
  void serialize_preservesCustomUniverseDomain() throws IOException, ClassNotFoundException {
    SerializableRefreshHandler handler = new SerializableRefreshHandler(REFRESHED_TOKEN);
    OAuth2CredentialsWithRefresh credentials =
        createTestBuilder(handler).setUniverseDomain("example.com").build();

    OAuth2CredentialsWithRefresh deserialized = serializeAndDeserialize(credentials);
    assertEquals("example.com", deserialized.getUniverseDomain());
  }

  @Test
  void deserialize_missingOrBlankUniverseDomain_defaultsToGoogleDefaultUniverse()
      throws IOException, ClassNotFoundException {
    SerializableRefreshHandler handler = new SerializableRefreshHandler(REFRESHED_TOKEN);
    OAuth2CredentialsWithRefresh expected = createTestBuilder(handler).build();

    // Simulate deserializing streams written before universeDomain existed or with blank values.
    for (String rawUniverseDomain : new String[] {null, "", "   "}) {
      OAuth2CredentialsWithRefresh credentials = createTestBuilder(handler).build();
      credentials.universeDomain = rawUniverseDomain;

      OAuth2CredentialsWithRefresh deserialized = serializeAndDeserialize(credentials);
      assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, deserialized.getUniverseDomain());
      assertEquals(expected, deserialized);
    }
  }

  @Test
  void equals_true() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler handler = () -> ACCESS_TOKEN;
    OAuth2CredentialsWithRefresh custom =
        createTestBuilder(handler).setUniverseDomain("example.com").build();
    OAuth2CredentialsWithRefresh sameCustom =
        createTestBuilder(handler).setUniverseDomain("example.com").build();

    assertEquals(custom, custom);
    assertEquals(custom, sameCustom);
    assertEquals(sameCustom, custom);
    assertEquals(custom.hashCode(), sameCustom.hashCode());

    OAuth2CredentialsWithRefresh noToken =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setRefreshHandler(handler)
            .setUniverseDomain("example.com")
            .build();
    OAuth2CredentialsWithRefresh sameNoToken =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setRefreshHandler(handler)
            .setUniverseDomain("example.com")
            .build();
    assertEquals(noToken, sameNoToken);
    assertEquals(noToken.hashCode(), sameNoToken.hashCode());

    // Explicit default universe domain equals unset, null, empty, and blank values.
    OAuth2CredentialsWithRefresh explicitDefault =
        createTestBuilder(handler).setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE).build();
    assertEquals(explicitDefault, createTestBuilder(handler).build());
    assertEquals(explicitDefault, createTestBuilder(handler).setUniverseDomain(null).build());
    assertEquals(explicitDefault, createTestBuilder(handler).setUniverseDomain("").build());
    assertEquals(explicitDefault, createTestBuilder(handler).setUniverseDomain("   ").build());
  }

  @Test
  void equals_false() {
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler handler = () -> ACCESS_TOKEN;
    OAuth2CredentialsWithRefresh.OAuth2RefreshHandler otherHandler = () -> ACCESS_TOKEN;
    AccessToken otherToken =
        new AccessToken("otherAccessToken", new Date(ACCESS_TOKEN.getExpirationTime().getTime()));

    OAuth2CredentialsWithRefresh baseline =
        createTestBuilder(handler).setUniverseDomain("example.com").build();
    OAuth2CredentialsWithRefresh differentToken =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setAccessToken(otherToken)
            .setRefreshHandler(handler)
            .setUniverseDomain("example.com")
            .build();
    OAuth2CredentialsWithRefresh differentHandler =
        createTestBuilder(otherHandler).setUniverseDomain("example.com").build();
    OAuth2CredentialsWithRefresh differentUniverse =
        createTestBuilder(handler).setUniverseDomain("other.example.com").build();

    assertNotEquals(baseline, null);
    assertNotEquals(baseline, "not-a-credential");
    assertNotEquals(baseline, differentToken);
    assertNotEquals(baseline, differentHandler);
    assertNotEquals(baseline, differentUniverse);

    // Without an initial access token, distinct refresh handlers must still compare unequal.
    OAuth2CredentialsWithRefresh noToken =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setRefreshHandler(handler)
            .setUniverseDomain("example.com")
            .build();
    OAuth2CredentialsWithRefresh noTokenOtherHandler =
        OAuth2CredentialsWithRefresh.newBuilder()
            .setRefreshHandler(otherHandler)
            .setUniverseDomain("example.com")
            .build();
    assertNotEquals(noToken, noTokenOtherHandler);
  }
}
