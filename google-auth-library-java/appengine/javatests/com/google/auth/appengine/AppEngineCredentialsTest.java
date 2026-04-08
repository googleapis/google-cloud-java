/*
 * Copyright 2015, Google Inc. All rights reserved.
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
 *    * Neither the name of Google Inc. nor the names of its
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

package com.google.auth.appengine;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.BaseSerializationTest;
import com.google.auth.oauth2.GoogleCredentials;
import java.io.IOException;
import java.net.URI;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

/** Unit tests for AppEngineCredentials */
class AppEngineCredentialsTest extends BaseSerializationTest {

  private static final Collection<String> SCOPES =
      Collections.unmodifiableCollection(Arrays.asList("scope1", "scope2"));
  private static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");
  private static final String EXPECTED_ACCOUNT = "serviceAccount";

  @Test
  void constructor_usesAppIdentityService() throws IOException {
    String expectedAccessToken = "ExpectedAccessToken";

    MockAppIdentityService appIdentity = new MockAppIdentityService();
    appIdentity.setAccessTokenText(expectedAccessToken);
    Credentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(SCOPES)
            .setAppIdentityService(appIdentity)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    assertEquals(1, appIdentity.getGetAccessTokenCallCount());
    assertContainsBearerToken(metadata, expectedAccessToken);
  }

  @Test
  void refreshAccessToken_sameAs() throws IOException {
    String expectedAccessToken = "ExpectedAccessToken";

    MockAppIdentityService appIdentity = new MockAppIdentityService();
    appIdentity.setAccessTokenText(expectedAccessToken);
    appIdentity.setExpiration(new Date(System.currentTimeMillis() + 60L * 60L * 100L));
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(SCOPES)
            .setAppIdentityService(appIdentity)
            .build();
    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals(appIdentity.getAccessTokenText(), accessToken.getTokenValue());
    assertEquals(appIdentity.getExpiration(), accessToken.getExpirationTime());
  }

  @Test
  void getAccount_sameAs() {
    MockAppIdentityService appIdentity = new MockAppIdentityService();
    appIdentity.setServiceAccountName(EXPECTED_ACCOUNT);
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(SCOPES)
            .setAppIdentityService(appIdentity)
            .build();
    assertEquals(EXPECTED_ACCOUNT, credentials.getAccount());
  }

  @Test
  void sign_sameAs() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};
    MockAppIdentityService appIdentity = new MockAppIdentityService();
    appIdentity.setSignature(expectedSignature);
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(SCOPES)
            .setAppIdentityService(appIdentity)
            .build();
    assertArrayEquals(expectedSignature, credentials.sign(expectedSignature));
  }

  @Test
  void createScoped_clonesWithScopes() throws IOException {
    String expectedAccessToken = "ExpectedAccessToken";
    Collection<String> emptyScopes = Collections.emptyList();

    MockAppIdentityService appIdentity = new MockAppIdentityService();
    appIdentity.setAccessTokenText(expectedAccessToken);

    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    assertTrue(credentials.createScopedRequired());
    assertThrows(IOException.class, () -> credentials.getRequestMetadata(CALL_URI));
    assertEquals(0, appIdentity.getGetAccessTokenCallCount());

    GoogleCredentials scopedCredentials = credentials.createScoped(SCOPES);
    assertNotSame(credentials, scopedCredentials);

    Map<String, List<String>> metadata = scopedCredentials.getRequestMetadata(CALL_URI);

    assertEquals(1, appIdentity.getGetAccessTokenCallCount());
    assertContainsBearerToken(metadata, expectedAccessToken);
  }

  @Test
  void equals_true() {
    Collection<String> emptyScopes = Collections.emptyList();
    MockAppIdentityService appIdentity = new MockAppIdentityService();

    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    AppEngineCredentials otherCredentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    assertEquals(credentials, otherCredentials);
    assertEquals(otherCredentials, credentials);
  }

  @Test
  void equals_false_scopes() {
    Collection<String> emptyScopes = Collections.emptyList();
    Collection<String> scopes = Collections.singleton("SomeScope");
    MockAppIdentityService appIdentity = new MockAppIdentityService();

    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    AppEngineCredentials otherCredentials =
        AppEngineCredentials.newBuilder()
            .setScopes(scopes)
            .setAppIdentityService(appIdentity)
            .build();
    assertNotEquals(credentials, otherCredentials);
    assertNotEquals(otherCredentials, credentials);
  }

  @Test
  void toString_containsFields() {
    String expectedToString =
        String.format(
            "AppEngineCredentials{scopes=[%s], scopesRequired=%b, appIdentityServiceClassName=%s}",
            "SomeScope", false, MockAppIdentityService.class.getName());
    Collection<String> scopes = Collections.singleton("SomeScope");
    MockAppIdentityService appIdentity = new MockAppIdentityService();

    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(scopes)
            .setAppIdentityService(appIdentity)
            .build();

    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() {
    Collection<String> emptyScopes = Collections.emptyList();
    MockAppIdentityService appIdentity = new MockAppIdentityService();
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    AppEngineCredentials otherCredentials =
        AppEngineCredentials.newBuilder()
            .setScopes(emptyScopes)
            .setAppIdentityService(appIdentity)
            .build();
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    Collection<String> scopes = Collections.singleton("SomeScope");
    MockAppIdentityService appIdentity = new MockAppIdentityService();
    AppEngineCredentials credentials =
        AppEngineCredentials.newBuilder()
            .setScopes(scopes)
            .setAppIdentityService(appIdentity)
            .build();
    GoogleCredentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
  }

  private static void assertContainsBearerToken(Map<String, List<String>> metadata, String token) {
    assertNotNull(metadata);
    assertNotNull(token);
    String expectedValue = "Bearer " + token;
    List<String> authorizations = metadata.get("Authorization");
    assertNotNull(authorizations, "Authorization headers not found");
    assertTrue(authorizations.contains(expectedValue), "Bearer token not found");
  }
}
