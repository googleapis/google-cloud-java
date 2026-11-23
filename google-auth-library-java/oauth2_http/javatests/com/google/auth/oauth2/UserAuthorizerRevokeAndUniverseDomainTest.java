/*
 * Copyright 2026 Google LLC
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

import static com.google.auth.TestUtils.WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.Test;

/** Unit tests for {@link UserAuthorizer} revocation URI and universe domain behavior. */
class UserAuthorizerRevokeAndUniverseDomainTest {

  private static final String CLIENT_ID_VALUE = "test-client-id";
  private static final String CLIENT_SECRET = "test-client-secret";
  private static final String REFRESH_TOKEN = "test-refresh-token";
  private static final String ACCESS_TOKEN_VALUE = "test-access-token";
  private static final List<String> GRANTED_SCOPES = Arrays.asList("scope1", "scope2");
  private static final String GRANTED_SCOPES_STRING = String.join(" ", GRANTED_SCOPES);
  private static final List<String> DUMMY_SCOPES = Collections.singletonList("dummy_scope");
  private static final AccessToken ACCESS_TOKEN =
      AccessToken.newBuilder()
          .setTokenValue(ACCESS_TOKEN_VALUE)
          .setExpirationTime(new Date(504000300L))
          .setScopes(GRANTED_SCOPES)
          .build();
  private static final ClientId CLIENT_ID = ClientId.of(CLIENT_ID_VALUE, CLIENT_SECRET);
  private static final String USER_ID = "user@example.com";
  private static final String CODE = "test-auth-code";
  private static final URI BASE_URI = URI.create("http://example.com/foo");

  @Test
  void build_defaultsToGduUniverseAndRevokeUri() {
    UserAuthorizer authorizer =
        UserAuthorizer.newBuilder().setClientId(CLIENT_ID).setScopes(DUMMY_SCOPES).build();

    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, authorizer.getUniverseDomain());
    assertEquals(OAuth2Utils.TOKEN_REVOKE_URI, authorizer.getTokenRevokeUri());
  }

  @Test
  void revokeAuthorization_customTokenRevokeUri_postsToCustomUri() throws IOException {
    List<String> requestedUrls = new ArrayList<>();
    HttpTransportFactory recordingTransportFactory =
        () ->
            new MockHttpTransport() {
              @Override
              public LowLevelHttpRequest buildRequest(String method, String url) {
                requestedUrls.add(url);
                return new MockLowLevelHttpRequest(url) {
                  @Override
                  public LowLevelHttpResponse execute() {
                    return new MockLowLevelHttpResponse().setStatusCode(200);
                  }
                };
              }
            };

    TokenStore tokenStore = new MemoryTokensStorage();
    URI customTokenServerUri = URI.create("https://sts.testdomain.org/v1/oauthtoken");
    URI customRevokeUri = URI.create("https://sts.testdomain.org/v1/revoke");
    UserAuthorizer authorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(tokenStore)
            .setHttpTransportFactory(recordingTransportFactory)
            .setTokenServerUri(customTokenServerUri)
            .setTokenRevokeUri(customRevokeUri)
            .setUniverseDomain("testdomain.org")
            .build();

    UserCredentials initialCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID_VALUE)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setAccessToken(ACCESS_TOKEN)
            .build();
    authorizer.storeCredentials(USER_ID, initialCredentials);

    authorizer.revokeAuthorization(USER_ID);

    assertEquals(Collections.singletonList(customRevokeUri.toString()), requestedUrls);
    assertNull(tokenStore.load(USER_ID));
  }

  @Test
  void revokeAuthorization_externalIdpRevokeUriOnNonDefaultUniverse_postsToIdpUri()
      throws IOException {
    List<String> requestedUrls = new ArrayList<>();
    HttpTransportFactory recordingTransportFactory =
        () ->
            new MockHttpTransport() {
              @Override
              public LowLevelHttpRequest buildRequest(String method, String url) {
                requestedUrls.add(url);
                return new MockLowLevelHttpRequest(url) {
                  @Override
                  public LowLevelHttpResponse execute() {
                    return new MockLowLevelHttpResponse().setStatusCode(200);
                  }
                };
              }
            };

    URI externalIdpRevokeUri = URI.create("https://idp.example.com/oauth2/v1/revoke");
    UserAuthorizer authorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(new MemoryTokensStorage())
            .setHttpTransportFactory(recordingTransportFactory)
            .setTokenServerUri(URI.create("https://idp.example.com/oauth2/v1/token"))
            .setTokenRevokeUri(externalIdpRevokeUri)
            .setUniverseDomain("testdomain.org")
            .build();

    authorizer.storeCredentials(
        USER_ID,
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID_VALUE)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setAccessToken(ACCESS_TOKEN)
            .build());

    authorizer.revokeAuthorization(USER_ID);

    assertEquals(Collections.singletonList(externalIdpRevokeUri.toString()), requestedUrls);
  }

  @Test
  void revokeAuthorization_customTokenServerUriWithoutRevokeUri_throwsAndDoesNotCallGdu()
      throws IOException {
    List<String> requestedUrls = new ArrayList<>();
    HttpTransportFactory recordingTransportFactory =
        () ->
            new MockHttpTransport() {
              @Override
              public LowLevelHttpRequest buildRequest(String method, String url) {
                requestedUrls.add(url);
                return new MockLowLevelHttpRequest(url);
              }
            };

    TokenStore tokenStore = new MemoryTokensStorage();
    UserAuthorizer authorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(tokenStore)
            .setHttpTransportFactory(recordingTransportFactory)
            .setTokenServerUri(WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI)
            .build();

    assertNull(authorizer.getTokenRevokeUri());
    authorizer.storeCredentials(
        USER_ID,
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID_VALUE)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setAccessToken(ACCESS_TOKEN)
            .build());

    assertThrows(IllegalStateException.class, () -> authorizer.revokeAuthorization(USER_ID));
    assertTrue(requestedUrls.isEmpty());
    assertNotNull(tokenStore.load(USER_ID));
  }

  @Test
  void revokeAuthorization_nonDefaultUniverseWithoutRevokeUri_throwsAndDoesNotCallGdu()
      throws IOException {
    List<String> requestedUrls = new ArrayList<>();
    HttpTransportFactory recordingTransportFactory =
        () ->
            new MockHttpTransport() {
              @Override
              public LowLevelHttpRequest buildRequest(String method, String url) {
                requestedUrls.add(url);
                return new MockLowLevelHttpRequest(url);
              }
            };

    TokenStore tokenStore = new MemoryTokensStorage();
    UserAuthorizer authorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(tokenStore)
            .setHttpTransportFactory(recordingTransportFactory)
            .setUniverseDomain("testdomain.org")
            .build();

    assertNull(authorizer.getTokenRevokeUri());
    authorizer.storeCredentials(
        USER_ID,
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID_VALUE)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setAccessToken(ACCESS_TOKEN)
            .build());

    assertThrows(IllegalStateException.class, () -> authorizer.revokeAuthorization(USER_ID));
    assertTrue(requestedUrls.isEmpty());
    assertNotNull(tokenStore.load(USER_ID));
  }

  @Test
  void build_nonDefaultUniverseWithGduTokenRevokeUri_throwsIllegalArgumentException() {
    List<URI> gduRevokeUris =
        Arrays.asList(
            OAuth2Utils.TOKEN_REVOKE_URI,
            URI.create("https://sts.googleapis.com/v1/revoke"),
            URI.create("https://OAUTH2.GOOGLEAPIS.COM./revoke"),
            URI.create("https://googleapis.com/revoke"));

    for (URI gduRevokeUri : gduRevokeUris) {
      UserAuthorizer.Builder builder =
          UserAuthorizer.newBuilder()
              .setClientId(CLIENT_ID)
              .setScopes(DUMMY_SCOPES)
              .setUniverseDomain("testdomain.org")
              .setTokenRevokeUri(gduRevokeUri);
      assertThrows(IllegalArgumentException.class, builder::build);
    }

    URI nonGduSubstringHost = URI.create("https://oauth2.googleapis.com.example.com/revoke");
    UserAuthorizer allowedAuthorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setUniverseDomain("testdomain.org")
            .setTokenRevokeUri(nonGduSubstringHost)
            .build();
    assertEquals(nonGduSubstringHost, allowedAuthorizer.getTokenRevokeUri());
  }

  @Test
  void toBuilder_handlesTokenRevokeUriAndUniverseDomain() {
    URI customRevokeUri = URI.create("https://sts.testdomain.org/v1/revoke");
    UserAuthorizer customAuthorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setUniverseDomain("testdomain.org")
            .setTokenRevokeUri(customRevokeUri)
            .build();

    UserAuthorizer clonedCustom = customAuthorizer.toBuilder().build();
    assertEquals("testdomain.org", clonedCustom.getUniverseDomain());
    assertEquals(customRevokeUri, clonedCustom.getTokenRevokeUri());

    UserAuthorizer gduDefault =
        UserAuthorizer.newBuilder().setClientId(CLIENT_ID).setScopes(DUMMY_SCOPES).build();
    assertEquals(OAuth2Utils.TOKEN_REVOKE_URI, gduDefault.getTokenRevokeUri());

    UserAuthorizer clonedGduDefault = gduDefault.toBuilder().build();
    assertEquals(OAuth2Utils.TOKEN_REVOKE_URI, clonedGduDefault.getTokenRevokeUri());

    UserAuthorizer switchedTokenServer =
        gduDefault.toBuilder()
            .setTokenServerUri(WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI)
            .build();
    assertNull(switchedTokenServer.getTokenRevokeUri());
    assertThrows(
        IllegalStateException.class, () -> switchedTokenServer.revokeAuthorization(USER_ID));

    UserAuthorizer switchedUniverse =
        gduDefault.toBuilder().setUniverseDomain("testdomain.org").build();
    assertNull(switchedUniverse.getTokenRevokeUri());
    assertThrows(IllegalStateException.class, () -> switchedUniverse.revokeAuthorization(USER_ID));

    UserAuthorizer gduExplicitStsRevoke =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenServerUri(WORKFORCE_IDENTITY_FEDERATION_TOKEN_SERVER_URI)
            .setTokenRevokeUri(URI.create("https://sts.googleapis.com/v1/revoke"))
            .build();
    assertThrows(
        IllegalArgumentException.class,
        () -> gduExplicitStsRevoke.toBuilder().setUniverseDomain("testdomain.org").build());
  }

  @Test
  void getCredentials_and_getCredentialsFromCode_propagateUniverseDomain() throws IOException {
    TokenStore tokenStore = new MemoryTokensStorage();
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID_VALUE, CLIENT_SECRET);
    transportFactory.transport.addAuthorizationCode(
        CODE, REFRESH_TOKEN, ACCESS_TOKEN_VALUE, GRANTED_SCOPES_STRING, null);

    UserAuthorizer customUniverseAuthorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(tokenStore)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain("testdomain.org")
            .build();

    UserCredentials fromCode = customUniverseAuthorizer.getCredentialsFromCode(CODE, BASE_URI);
    assertEquals("testdomain.org", fromCode.getUniverseDomain());
    assertTrue(fromCode.isExplicitUniverseDomain());

    customUniverseAuthorizer.storeCredentials(USER_ID, fromCode);
    UserCredentials loaded = customUniverseAuthorizer.getCredentials(USER_ID);
    assertNotNull(loaded);
    assertEquals("testdomain.org", loaded.getUniverseDomain());
    assertTrue(loaded.isExplicitUniverseDomain());

    UserAuthorizer defaultAuthorizer =
        UserAuthorizer.newBuilder()
            .setClientId(CLIENT_ID)
            .setScopes(DUMMY_SCOPES)
            .setTokenStore(tokenStore)
            .setHttpTransportFactory(transportFactory)
            .build();
    UserCredentials defaultLoaded = defaultAuthorizer.getCredentials(USER_ID);
    assertNotNull(defaultLoaded);
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, defaultLoaded.getUniverseDomain());
    assertFalse(defaultLoaded.isExplicitUniverseDomain());
  }
}
