/*
 * Copyright 2022 Google LLC
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

import static com.google.auth.Credentials.GOOGLE_DEFAULT_UNIVERSE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.GenericJson;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.util.Clock;
import com.google.auth.TestUtils;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test case for {@link ExternalAccountAuthorizedUserCredentials}. */
class ExternalAccountAuthorizedUserCredentialsTest extends BaseSerializationTest {

  private static final String AUDIENCE =
      "//iam.googleapis.com/locations/global/workforcePools/$WORKFORCE_POOL_ID/providers/$PROVIDER_ID";
  private static final String CLIENT_SECRET = "jakuaL9YyieakhECKL2SwZcu";
  private static final String CLIENT_ID = "ya29.1.AADtN_UtlxN3PuGAxrN2XQnZTVRvDyVWnYq4I6dws";
  private static final String REFRESH_TOKEN = "1/Tl6awhpFjkMkSJoj1xsli0H2eL5YsMgU_NKPY2TyGWY";
  private static final String ACCESS_TOKEN = "1/MkSJoj1xsli0AccessToken_NKPY2";
  private static final String TOKEN_URL = "https://sts.googleapis.com/v1/oauthtoken";
  private static final String TOKEN_INFO_URL = "https://sts.googleapis.com/v1/introspect";
  private static final String REVOKE_URL = "https://sts.googleapis.com/v1/revoke";
  private static final String QUOTA_PROJECT = "sample-quota-project-id";
  private static final String UNIVERSE_DOMAIN = "foo.bar";

  private static final String BASIC_AUTH =
      String.format(
          "Basic %s",
          Base64.getEncoder()
              .encodeToString(
                  String.format("%s:%s", CLIENT_ID, CLIENT_SECRET)
                      .getBytes(StandardCharsets.UTF_8)));

  private static final Collection<String> SCOPES = Collections.singletonList("dummy.scope");
  private static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");

  private MockExternalAccountAuthorizedUserCredentialsTransportFactory transportFactory;

  static InputStream writeExternalAccountUserCredentialStream(
      String clientId, String clientSecret, String refreshToken, String tokenUrl)
      throws IOException {
    GenericJson json = new GenericJson();
    if (clientId != null) {
      json.put("client_id", clientId);
    }
    if (clientSecret != null) {
      json.put("client_secret", clientSecret);
    }
    if (refreshToken != null) {
      json.put("refresh_token", refreshToken);
    }
    if (tokenUrl != null) {
      json.put("token_url", tokenUrl);
    }
    json.put("type", "external_account_authorized_user");
    return TestUtils.jsonToInputStream(json);
  }

  static class MockExternalAccountAuthorizedUserCredentialsTransportFactory
      implements HttpTransportFactory {

    MockStsTransport transport = new MockStsTransport();

    @Override
    public HttpTransport create() {
      return transport;
    }
  }

  @BeforeEach
  void setup() {
    transportFactory = new MockExternalAccountAuthorizedUserCredentialsTransportFactory();
  }

  @Test
  void builder_allFields() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setUniverseDomain(UNIVERSE_DOMAIN)
            .build();

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(ACCESS_TOKEN, credentials.getAccessToken().getTokenValue());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(UNIVERSE_DOMAIN, credentials.getUniverseDomain());
  }

  @Test
  void builder_minimumRequiredFieldsForRefresh() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .build();

    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertNull(credentials.getAudience());
    assertNull(credentials.getTokenInfoUrl());
    assertNull(credentials.getRevokeUrl());
    assertNull(credentials.getAccessToken());
    assertNull(credentials.getQuotaProjectId());
  }

  @Test
  void builder_accessTokenOnly() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAccessToken(AccessToken.newBuilder().setTokenValue(ACCESS_TOKEN).build())
            .build();

    assertEquals(ACCESS_TOKEN, credentials.getAccessToken().getTokenValue());
    assertNull(credentials.getAudience());
    assertNull(credentials.getTokenUrl());
    assertNull(credentials.getTokenInfoUrl());
    assertNull(credentials.getRevokeUrl());
    assertNull(credentials.getClientId());
    assertNull(credentials.getClientSecret());
    assertNull(credentials.getRefreshToken());
    assertNull(credentials.getQuotaProjectId());
  }

  @Test
  void builder_credentialConstructor() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    ExternalAccountAuthorizedUserCredentials otherCredentials = credentials.toBuilder().build();

    assertEquals(AUDIENCE, otherCredentials.getAudience());
    assertEquals(CLIENT_ID, otherCredentials.getClientId());
    assertEquals(CLIENT_SECRET, otherCredentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, otherCredentials.getRefreshToken());
    assertEquals(TOKEN_URL, otherCredentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, otherCredentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, otherCredentials.getRevokeUrl());
    assertEquals(QUOTA_PROJECT, otherCredentials.getQuotaProjectId());
  }

  @Test
  void builder_accessTokenWithMissingRefreshFields() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAccessToken(AccessToken.newBuilder().setTokenValue(ACCESS_TOKEN).build())
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setClientId(CLIENT_ID)
            .build();

    assertEquals(ACCESS_TOKEN, credentials.getAccessToken().getTokenValue());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertNull(credentials.getAudience());
    assertNull(credentials.getTokenInfoUrl());
    assertNull(credentials.getRevokeUrl());
    assertNull(credentials.getClientSecret());
    assertNull(credentials.getQuotaProjectId());
  }

  @Test
  void builder_accessAndRefreshTokenNull_throws() {
    ExternalAccountAuthorizedUserCredentials.Builder builder =
        ExternalAccountAuthorizedUserCredentials.newBuilder();
    IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void builder_missingTokenUrl_throws() {
    ExternalAccountAuthorizedUserCredentials.Builder builder =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setRefreshToken(REFRESH_TOKEN)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET);
    IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void builder_missingClientId_throws() {
    ExternalAccountAuthorizedUserCredentials.Builder builder =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setClientSecret(CLIENT_SECRET);
    IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void builder_missingClientSecret_throws() {
    ExternalAccountAuthorizedUserCredentials.Builder builder =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setClientId(CLIENT_ID);
    IllegalStateException exception = assertThrows(IllegalStateException.class, builder::build);
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void builder_missingUniverseDomain_defaults() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(ACCESS_TOKEN, credentials.getAccessToken().getTokenValue());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void toBuilder_allFields() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, new Date()))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setUniverseDomain(UNIVERSE_DOMAIN)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials = credentials.toBuilder().build();

    assertEquals(credentials, secondCredentials);
  }

  @Test
  void toBuilder_missingUniverseDomain_defaults() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, new Date()))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials = credentials.toBuilder().build();

    assertEquals(credentials, secondCredentials);
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, secondCredentials.getUniverseDomain());
  }

  @Test
  void fromJson_allFields() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(
            buildJsonCredentials(), OAuth2Utils.HTTP_TRANSPORT_FACTORY);

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(UNIVERSE_DOMAIN, credentials.getUniverseDomain());
  }

  @Test
  void fromJson_minimumRequiredFieldsForRefresh() throws IOException {
    GenericJson json = new GenericJson();
    json.put("client_id", CLIENT_ID);
    json.put("client_secret", CLIENT_SECRET);
    json.put("refresh_token", REFRESH_TOKEN);
    json.put("token_url", TOKEN_URL);

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(json, OAuth2Utils.HTTP_TRANSPORT_FACTORY);

    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertNull(credentials.getAudience());
    assertNull(credentials.getTokenInfoUrl());
    assertNull(credentials.getRevokeUrl());
    assertNull(credentials.getAccessToken());
    assertNull(credentials.getQuotaProjectId());
  }

  @Test
  void fromJson_accessTokenOnly_notSupported() {
    GenericJson json = new GenericJson();
    json.put("access_token", ACCESS_TOKEN);

    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () ->
                ExternalAccountAuthorizedUserCredentials.fromJson(
                    json, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void fromJson_missingRefreshToken_throws() {
    GenericJson json = buildJsonCredentials();
    json.remove("refresh_token");
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () ->
                ExternalAccountAuthorizedUserCredentials.fromJson(
                    json, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void fromJson_missingTokenUrl_throws() {
    GenericJson json = buildJsonCredentials();
    json.remove("token_url");
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () ->
                ExternalAccountAuthorizedUserCredentials.fromJson(
                    json, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void fromJson_missingClientId_throws() {
    GenericJson json = buildJsonCredentials();
    json.remove("client_id");
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () ->
                ExternalAccountAuthorizedUserCredentials.fromJson(
                    json, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void fromJson_missingClientSecret_throws() {
    GenericJson json = buildJsonCredentials();
    json.remove("client_secret");
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class,
            () ->
                ExternalAccountAuthorizedUserCredentials.fromJson(
                    json, OAuth2Utils.HTTP_TRANSPORT_FACTORY));
    assertEquals(
        "ExternalAccountAuthorizedUserCredentials must be initialized with "
            + "an access token or fields to enable refresh: "
            + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
        exception.getMessage());
  }

  @Test
  void fromJson_missingUniverseDomain_defaults() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("universe_domain");

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(json, OAuth2Utils.HTTP_TRANSPORT_FACTORY);

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void fromStream_allFields() throws IOException {
    GenericJson json = buildJsonCredentials();

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromStream(TestUtils.jsonToInputStream(json));

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
  }

  @Test
  void fromStream_minimumRequiredFieldsForRefresh() throws IOException {
    GenericJson json = new GenericJson();
    json.put(
        "type", GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType());
    json.put("client_id", CLIENT_ID);
    json.put("client_secret", CLIENT_SECRET);
    json.put("refresh_token", REFRESH_TOKEN);
    json.put("token_url", TOKEN_URL);

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromStream(TestUtils.jsonToInputStream(json));

    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertNull(credentials.getAudience());
    assertNull(credentials.getTokenInfoUrl());
    assertNull(credentials.getRevokeUrl());
    assertNull(credentials.getAccessToken());
    assertNull(credentials.getQuotaProjectId());
  }

  @Test
  void fromStream_accessTokenOnly_notSupported() throws IOException {
    GenericJson json = new GenericJson();
    json.put("access_token", ACCESS_TOKEN);
    json.put(
        "type", GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType());
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals(
          "ExternalAccountAuthorizedUserCredentials must be initialized with "
              + "an access token or fields to enable refresh: "
              + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
          exception.getMessage());
    }
  }

  @Test
  void fromStream_missingRefreshToken_throws() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("refresh_token");
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals(
          "ExternalAccountAuthorizedUserCredentials must be initialized with "
              + "an access token or fields to enable refresh: "
              + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
          exception.getMessage());
    }
  }

  @Test
  void fromStream_missingTokenUrl_throws() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("token_url");
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals(
          "ExternalAccountAuthorizedUserCredentials must be initialized with "
              + "an access token or fields to enable refresh: "
              + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
          exception.getMessage());
    }
  }

  @Test
  void fromStream_missingClientId_throws() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("client_id");
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals(
          "ExternalAccountAuthorizedUserCredentials must be initialized with "
              + "an access token or fields to enable refresh: "
              + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
          exception.getMessage());
    }
  }

  @Test
  void fromStream_missingClientSecret_throws() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("client_secret");
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      IllegalStateException exception =
          assertThrows(
              IllegalStateException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals(
          "ExternalAccountAuthorizedUserCredentials must be initialized with "
              + "an access token or fields to enable refresh: "
              + "('refresh_token', 'token_url', 'client_id', 'client_secret').",
          exception.getMessage());
    }
  }

  @Test
  void fromStream_missingUniverseDomain_defaults() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.remove("universe_domain");

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromStream(TestUtils.jsonToInputStream(json));

    assertEquals(AUDIENCE, credentials.getAudience());
    assertEquals(CLIENT_ID, credentials.getClientId());
    assertEquals(CLIENT_SECRET, credentials.getClientSecret());
    assertEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    assertEquals(TOKEN_URL, credentials.getTokenUrl());
    assertEquals(TOKEN_INFO_URL, credentials.getTokenInfoUrl());
    assertEquals(REVOKE_URL, credentials.getRevokeUrl());
    assertEquals(QUOTA_PROJECT, credentials.getQuotaProjectId());
    assertEquals(GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void fromStream_invalidInputStream_throws() throws IOException {
    GenericJson json = buildJsonCredentials();
    json.put("audience", new HashMap<>());
    try (InputStream credentialsStream = TestUtils.jsonToInputStream(json)) {
      CredentialFormatException e =
          assertThrows(
              CredentialFormatException.class,
              () -> ExternalAccountAuthorizedUserCredentials.fromStream(credentialsStream));
      assertEquals("Invalid input stream provided.", e.getMessage());
    }
  }

  @Test
  void createScoped_noChange() {
    ExternalAccountAuthorizedUserCredentials externalAccountAuthorizedUserCredentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setTokenUrl(TOKEN_URL)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .build();
    assertSame(
        externalAccountAuthorizedUserCredentials,
        externalAccountAuthorizedUserCredentials.createScoped(SCOPES));
  }

  @Test
  void createScopedRequired_false() {
    ExternalAccountAuthorizedUserCredentials externalAccountAuthorizedUserCredentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setTokenUrl(TOKEN_URL)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .build();
    assertFalse(externalAccountAuthorizedUserCredentials.createScopedRequired());
  }

  @Test
  void getRequestMetadata() throws IOException {
    GoogleCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, transportFactory.transport.getAccessToken());
    validateAuthHeader(transportFactory.transport.getRequest());
  }

  @Test
  void getRequestMetadata_withQuotaProjectId() throws IOException {
    GoogleCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    assertTrue(metadata.containsKey(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY));
    assertEquals(
        Collections.singletonList(QUOTA_PROJECT),
        metadata.get(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY));

    validateAuthHeader(transportFactory.transport.getRequest());
  }

  @Test
  void getRequestMetadata_withAccessToken() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setHttpTransportFactory(transportFactory)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void refreshAccessToken() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    AccessToken accessToken = credentials.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());
    validateAuthHeader(transportFactory.transport.getRequest());
  }

  @Test
  void refreshAccessToken_withRefreshTokenRotation() throws IOException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    transportFactory.transport.addRefreshTokenSequence("aNewRefreshToken");

    AccessToken accessToken = credentials.refreshAccessToken();

    assertEquals(transportFactory.transport.getAccessToken(), accessToken.getTokenValue());
    // Validate new refresh token was set.
    assertEquals("aNewRefreshToken", credentials.getRefreshToken());
    assertNotEquals(REFRESH_TOKEN, credentials.getRefreshToken());
    validateAuthHeader(transportFactory.transport.getRequest());
  }

  @Test
  void refreshAccessToken_genericAuthError_throws() throws IOException {
    transportFactory.transport.addResponseErrorSequence(
        TestUtils.buildHttpResponseException(
            "invalid_request", "Invalid request.", /* errorUri= */ null));

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    OAuthException e = assertThrows(OAuthException.class, credentials::refreshAccessToken);
    assertEquals("invalid_request", e.getErrorCode());
    assertEquals("Invalid request.", e.getErrorDescription());
  }

  @Test
  void refreshAccessToken_genericIOError_throws() throws IOException {
    transportFactory.transport.addResponseErrorSequence(new IOException(""));

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    assertThrows(IOException.class, credentials::refreshAccessToken);
  }

  @Test
  void refreshAccessToken_missingRefreshFields_throws() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setTokenUrl(TOKEN_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setHttpTransportFactory(transportFactory)
            .build();

    assertThrows(IllegalStateException.class, credentials::refreshAccessToken);
  }

  @Test
  void hashCode_sameCredentials() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    assertEquals(credentials, secondCredentials);
    assertEquals(secondCredentials, credentials);
    assertEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void hashCode_differentCredentials() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .build();

    // Second credentials have an access token set.
    ExternalAccountAuthorizedUserCredentials secondCredentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void hashCode_differentCredentialsWithCredentialsFile() throws IOException {
    // Optional fields that can be specified in the credentials file.
    List<String> fields = Arrays.asList("audience", "revoke_url", "quota_project_id");

    // Credential initialized with all fields.
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    for (String field : fields) {
      // Build credential with one of these fields missing.
      GenericJson json = buildJsonCredentials();
      json.remove(field);

      ExternalAccountAuthorizedUserCredentials secondCredentials =
          ExternalAccountAuthorizedUserCredentials.fromJson(json, transportFactory);
      assertNotEquals(secondCredentials, credentials);
      assertNotEquals(credentials, secondCredentials);
      assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
    }
  }

  @Test
  void equals_differentCredentials() throws IOException {
    UserCredentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(URI.create(TOKEN_URL))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.fromJson(buildJsonCredentials(), transportFactory);

    assertNotEquals(userCredentials, credentials);
    assertNotEquals(credentials, userCredentials);
  }

  @Test
  void equals_differentAudience() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setAudience("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentClientId() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setClientId("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentClientSecret() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setClientSecret("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentRefreshToken() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setRefreshToken("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentTokenUrl() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setTokenUrl("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentTokenInfoUrl() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setTokenInfoUrl("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentRevokeUrl() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setRevokeUrl("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentAccessToken() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, new Date()))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setAccessToken(new AccessToken("different", new Date())).build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentQuotaProjectId() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setQuotaProjectId("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentTransportFactory() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY).build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void equals_differentUniverseDomain() {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(UNIVERSE_DOMAIN)
            .build();

    ExternalAccountAuthorizedUserCredentials secondCredentials =
        credentials.toBuilder().setUniverseDomain("different").build();

    assertNotEquals(secondCredentials, credentials);
    assertNotEquals(credentials, secondCredentials);
    assertNotEquals(credentials.hashCode(), secondCredentials.hashCode());
  }

  @Test
  void toString_expectedFormat() {
    AccessToken accessToken = new AccessToken(ACCESS_TOKEN, new Date());
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(accessToken)
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(transportFactory)
            .build();

    String expectedToString =
        String.format(
            "ExternalAccountAuthorizedUserCredentials{requestMetadata=%s, temporaryAccess=%s, "
                + "clientId=%s, clientSecret=%s, refreshToken=%s, tokenUrl=%s, tokenInfoUrl=%s, "
                + "revokeUrl=%s, audience=%s, transportFactoryClassName=%s, quotaProjectId=%s}",
            ImmutableMap.of(
                AuthHttpConstants.AUTHORIZATION,
                ImmutableList.of(OAuth2Utils.BEARER_PREFIX + accessToken.getTokenValue())),
            accessToken,
            CLIENT_ID,
            CLIENT_SECRET,
            REFRESH_TOKEN,
            TOKEN_URL,
            TOKEN_INFO_URL,
            REVOKE_URL,
            AUDIENCE,
            transportFactory.getClass().getName(),
            QUOTA_PROJECT);

    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    ExternalAccountAuthorizedUserCredentials credentials =
        ExternalAccountAuthorizedUserCredentials.newBuilder()
            .setAudience(AUDIENCE)
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setTokenUrl(TOKEN_URL)
            .setTokenInfoUrl(TOKEN_INFO_URL)
            .setRevokeUrl(REVOKE_URL)
            .setAccessToken(new AccessToken(ACCESS_TOKEN, /* expirationTime= */ null))
            .setQuotaProjectId(QUOTA_PROJECT)
            .build();

    ExternalAccountAuthorizedUserCredentials deserializedCredentials =
        serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(Clock.SYSTEM, deserializedCredentials.clock);
  }

  static GenericJson buildJsonCredentials() {
    GenericJson json = new GenericJson();
    json.put(
        "type", GoogleCredentialsInfo.EXTERNAL_ACCOUNT_AUTHORIZED_USER_CREDENTIALS.getFileType());
    json.put("audience", AUDIENCE);
    json.put("refresh_token", REFRESH_TOKEN);
    json.put("client_id", CLIENT_ID);
    json.put("client_secret", CLIENT_SECRET);
    json.put("token_url", TOKEN_URL);
    json.put("token_info_url", TOKEN_INFO_URL);
    json.put("revoke_url", REVOKE_URL);
    json.put("quota_project_id", QUOTA_PROJECT);
    json.put("universe_domain", UNIVERSE_DOMAIN);
    return json;
  }

  private static void validateAuthHeader(MockLowLevelHttpRequest request) {
    Map<String, List<String>> headers = request.getHeaders();
    List<String> authHeader = headers.get("authorization");

    assertEquals(BASIC_AUTH, authHeader.iterator().next());
    assertEquals(1, authHeader.size());
  }
}
