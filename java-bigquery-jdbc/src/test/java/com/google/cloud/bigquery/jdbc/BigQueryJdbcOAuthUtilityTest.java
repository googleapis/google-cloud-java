/*
 * Copyright 2023 Google LLC
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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.ExternalAccountCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.gson.JsonObject;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class BigQueryJdbcOAuthUtilityTest extends BigQueryJdbcBaseTest {

  private static final int USER_AUTH_PORT = 53737;
  private static final URI USER_AUTH_CALLBACK_URI =
      URI.create("http://127.0.0.1:" + USER_AUTH_PORT);

  @Test
  public void testParseOAuthPropsWithSpecialChars() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyProject;OAuthType=0;OAuthServiceAcctEmail=dummy@email.com;"
                    + "OAuthPvtKey=Key+With+Plus;"),
            null);
    assertEquals("Key+With+Plus", result.get("OAuthPvtKey"));
  }

  @Test
  public void testParseOAuthPropsForAuthType0KeyfileOnly() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=0;"
                    + "OAuthPvtKeyPath=C:\\SecureFiles\\ServiceKeyFile.p12;"),
            null);

    assertThat(result.get("OAuthType")).isEqualTo("GOOGLE_SERVICE_ACCOUNT");
    assertThat(result.get("OAuthPvtKeyPath")).isEqualTo("C:\\SecureFiles\\ServiceKeyFile.p12");
  }

  @Test
  public void testParseOAuthPropsForAuthType0ViaEmail() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=0;"
                    + "OAuthServiceAcctEmail=dummytest@dummytest.iam.gserviceaccount.com;"
                    + "OAuthPvtKey=RedactedKey;"),
            null);

    assertThat(result.get("OAuthType")).isEqualTo("GOOGLE_SERVICE_ACCOUNT");
    assertThat(result.get("OAuthServiceAcctEmail"))
        .isEqualTo("dummytest@dummytest.iam.gserviceaccount.com");
    assertThat(result.get("OAuthPvtKey")).isEqualTo("RedactedKey");
  }

  @Test
  public void testInvalidTokenUriForAuthType0() {
    String connectionString =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "ProjectId=MyBigQueryProject;OAuthType=0;"
            + "OAuthServiceAcctEmail=dummytest@dummytest.iam.gserviceaccount.com;"
            + "OAuthPvtKey="
            + fake_pkcs8_key
            + ";"
            + "EndpointOverrides=OAuth2=brokenuri{};";
    Map<String, String> oauthProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(DataSource.fromUrl(connectionString), null);
    Map<String, String> overrideProperties =
        DataSource.fromUrl(connectionString).getOverrideProperties();

    try {
      BigQueryJdbcOAuthUtility.getCredentials(
          oauthProperties, overrideProperties, false, null, null);
      Assertions.fail();
    } catch (BigQueryJdbcRuntimeException e) {
      assertThat(e.getMessage()).contains("Validation failure");
    }
  }

  @Test
  public void testParseOAuthPropsForAuthType2() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;ProjectId=MyBigQueryProject;"
                    + "OAuthAccessToken=RedactedToken;"),
            null);

    assertThat(result.get("OAuthType")).isEqualTo("PRE_GENERATED_TOKEN");
    assertThat(result.get("OAuthAccessToken")).isEqualTo("RedactedToken");
  }

  @Test
  public void testParseOAuthPropsForAuthType3() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=3;ProjectId=MyBigQueryProject;"),
            null);

    assertThat(result.get("OAuthType")).isEqualTo("APPLICATION_DEFAULT_CREDENTIALS");
  }

  @Test
  public void testParseOAuthPropsForDefaultAuthType() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=3"),
            null);

    assertThat(result.get("OAuthType")).isEqualTo("APPLICATION_DEFAULT_CREDENTIALS");
  }

  @Test
  public void testGetCredentialsForPreGeneratedToken() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;ProjectId=MyBigQueryProject;"
                    + "OAuthAccessToken=RedactedToken;"),
            null);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, Collections.EMPTY_MAP, false, null, null);
    assertThat(credentials).isNotNull();
  }

  @Test
  public void testGetCredentialsForPreGeneratedTokenCustomUniverseDomain() throws IOException {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;ProjectId=MyBigQueryProject;"
                    + "OAuthAccessToken=RedactedToken;"
                    + "universeDomain=testDomain;"),
            null);
    Map<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put(
        BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, "testDomain");
    Map<String, String> overrideProperties = new HashMap<>(stringStringMap);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, overrideProperties, false, null, null);
    assertThat(credentials.getUniverseDomain()).isEqualTo("testDomain");
  }

  @Test
  @Disabled // For running locally only similar to our other JDBC tests.
  public void testGetCredentialsForApplicationDefault() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=3;ProjectId=MyBigQueryProject;"),
            null);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(authProperties, null, false, null, null);
    assertThat(credentials).isNotNull();
  }

  @Test
  public void testParseOAuthPropsForUserAuth() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=1;ProjectId=MyBigQueryProject;"
                    + "OAuthClientId=client;OAuthClientSecret=secret;"),
            null);

    assertThat(authProperties.get("OAuthType")).isEqualTo("GOOGLE_USER_ACCOUNT");
    assertThat(authProperties.get("OAuthClientId")).isEqualTo("client");
    assertThat(authProperties.get("OAuthClientSecret")).isEqualTo("secret");
  }

  @Test
  public void testParseOAuthPropsForUserAuthDefault() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=1;ProjectId=MyBigQueryProject;"),
            null);

    assertThat(authProperties.get("OAuthType")).isEqualTo("GOOGLE_USER_ACCOUNT");
    assertThat(authProperties.get("OAuthClientId"))
        .isEqualTo(BigQueryJdbcUrlUtility.DEFAULT_OAUTH_CLIENT_ID);
    assertThat(authProperties.get("OAuthClientSecret"))
        .isEqualTo(BigQueryJdbcUrlUtility.DEFAULT_OAUTH_CLIENT_SECRET);
  }

  @Test
  public void testGenerateUserAuthURL() throws Exception {
    HashMap<String, String> authProperties = new HashMap<>();
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "client_id");
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "client_secret");

    UserAuthorizer userAuthorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties,
            new HashMap<String, String>(),
            false,
            USER_AUTH_CALLBACK_URI,
            null,
            null);

    URL authURL =
        userAuthorizer.getAuthorizationUrl(
            "test_user", "test_state", URI.create("http://example.com/foo"));
    Map<String, String> params = parseQueryParams(authURL.toURI().getRawQuery());

    assertThat(authURL.getProtocol()).isEqualTo("https");
    assertThat(authURL.getHost()).isEqualTo("accounts.google.com");
    assertThat(authURL.getPath()).isEqualTo("/o/oauth2/auth");
    assertThat(params.get("response_type")).isEqualTo("code");
    assertThat(params.get("client_id")).isEqualTo("client_id");
    assertThat(params.get("redirect_uri")).isEqualTo("http://127.0.0.1:" + USER_AUTH_PORT);
    assertThat(params.get("scope")).isEqualTo("https://www.googleapis.com/auth/bigquery");
    assertThat(params.get("state")).isEqualTo("test_state");
    assertThat(params.get("access_type")).isEqualTo("offline");
    assertThat(params.get("prompt")).isEqualTo("consent");
    assertThat(params.get("login_hint")).isEqualTo("test_user");
    assertThat(params.get("include_granted_scopes")).isEqualTo("true");
    assertThat(params.get("code_challenge_method")).isEqualTo("S256");
    assertThat(params.get("code_challenge")).matches("^[A-Za-z0-9_-]{43}$");

    UserAuthorizer driveScopeAuthorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties, Collections.emptyMap(), true, USER_AUTH_CALLBACK_URI, null, null);
    URL driveAuthUrl =
        driveScopeAuthorizer.getAuthorizationUrl("test_user", "test_state", URI.create(""));
    Map<String, String> driveParams = parseQueryParams(driveAuthUrl.toURI().getRawQuery());
    assertThat(driveParams.get("scope"))
        .isEqualTo(
            "https://www.googleapis.com/auth/bigquery"
                + " https://www.googleapis.com/auth/drive.readonly");
  }

  @Test
  public void testGetUserAuthorizer_configuresRfc7636Pkce() throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();

    AtomicReference<Map<String, String>> capturedTokenParams = new AtomicReference<>();
    HttpTransportFactory transportFactory =
        createMockTokenTransport(capturedTokenParams, null, null);

    UserAuthorizer userAuthorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties,
            Collections.emptyMap(),
            false,
            USER_AUTH_CALLBACK_URI,
            transportFactory,
            null);

    URL authUrl = userAuthorizer.getAuthorizationUrl("user", "state_val", URI.create(""));
    Map<String, String> authParams = parseQueryParams(authUrl.toURI().getRawQuery());
    String codeChallenge = authParams.get("code_challenge");
    assertThat(authParams.get("code_challenge_method")).isEqualTo("S256");
    assertThat(codeChallenge).matches("^[A-Za-z0-9_-]{43}$");

    UserCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentialsFromCode(
            userAuthorizer, "sample_code", Collections.emptyMap(), transportFactory, null);
    assertThat(credentials.getAccessToken().getTokenValue()).isEqualTo("mock_access_token");
    assertThat(credentials.getUniverseDomain()).isEqualTo("googleapis.com");
    assertThat(credentials.toBuilder().getHttpTransportFactory()).isEqualTo(transportFactory);

    Map<String, String> tokenParams = capturedTokenParams.get();
    assertThat(tokenParams).isNotNull();
    String codeVerifier = tokenParams.get("code_verifier");
    assertThat(codeVerifier).isNotNull();
    assertThat(codeVerifier).matches("^[A-Za-z0-9._~-]{43,128}$");
    assertThat(computeS256Challenge(codeVerifier)).isEqualTo(codeChallenge);

    UserCredentials unchangedCredentials =
        BigQueryJdbcOAuthUtility.getCredentialsFromCode(
            userAuthorizer, "sample_code", Collections.emptyMap(), null, null);
    assertThat(unchangedCredentials.getUniverseDomain()).isEqualTo("googleapis.com");

    UserCredentials universeOnlyCredentials =
        BigQueryJdbcOAuthUtility.getCredentialsFromCode(
            userAuthorizer,
            "sample_code",
            Collections.singletonMap(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
                "explicit-universe.example.com"),
            null,
            null);
    assertThat(universeOnlyCredentials.getUniverseDomain())
        .isEqualTo("explicit-universe.example.com");
  }

  @Test
  public void testGenerateUserAuthURLOverrideOauthEndpoint() {
    try {

      URI overrideTokenSeverURI = new URI("https://oauth2-gsprivateall.p.googleapis.com/token");
      String connectionString =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId=MyBigQueryProject;OAuthType=1;"
              + "OAuthClientId=client;OAuthClientSecret=secret;"
              + "EndpointOverrides=OAuth2="
              + overrideTokenSeverURI
              + ";";
      Map<String, String> authProperties =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(DataSource.fromUrl(connectionString), null);
      Map<String, String> overrideProperties =
          DataSource.fromUrl(connectionString).getOverrideProperties();

      UserAuthorizer userAuthorizer =
          BigQueryJdbcOAuthUtility.getUserAuthorizer(
              authProperties, overrideProperties, false, USER_AUTH_CALLBACK_URI, null, null);

      assertThat(overrideTokenSeverURI).isEqualTo(userAuthorizer.toBuilder().getTokenServerUri());
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testParseOAuthPropsForRefreshToken() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=2;ProjectId=MyBigQueryProject;OAuthRefreshToken=token;"
                    + "OAuthClientId=client;OAuthClientSecret=secret;"),
            null);

    assertThat(authProperties.get("OAuthType")).isEqualTo("PRE_GENERATED_TOKEN");
    assertThat(authProperties.get("OAuthRefreshToken")).isEqualTo("token");
    assertThat(authProperties.get("OAuthClientId")).isEqualTo("client");
    assertThat(authProperties.get("OAuthClientSecret")).isEqualTo("secret");
  }

  @Test
  public void testParseOverridePropsForRefreshTokenAuth() {
    try {

      String connectionString =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId=MyBigQueryProject;OAuthType=2;OAuthRefreshToken=token;"
              + "OAuthClientId=client;OAuthClientSecret=secret;"
              + "EndpointOverrides=Oauth2=https://oauth2-private.p.googleapis.com/token;";

      Map<String, String> authProperties =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(DataSource.fromUrl(connectionString), null);
      Map<String, String> overrideProperties =
          DataSource.fromUrl(connectionString).getOverrideProperties();

      UserCredentials userCredentials =
          BigQueryJdbcOAuthUtility.getPreGeneratedRefreshTokenCredentials(
              authProperties, overrideProperties, null, null);

      assertThat(userCredentials.toBuilder().getTokenServerUri())
          .isEqualTo(URI.create("https://oauth2-private.p.googleapis.com/token"));

    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testParseBYOIDProps() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:433;OAuthType=4;"
                    + "ProjectId=MyBigQueryProject;"
                    + "BYOID_AudienceUri=//iam.googleapis.com/locations/global/workforcePools/pool-id/providers/provider-id;"
                    + "BYOID_PoolUserProject=workforceProjectNumber;"
                    + "BYOID_CredentialSource={\"file\": \"C:\\\\Token.txt\"};"
                    + "BYOID_SA_Impersonation_Uri=testSA;"
                    + "BYOID_SubjectTokenType=urn:ietf:params:oauth:tokentype:jwt;"
                    + "BYOID_TokenUri=https://testuri.com/v1/token"),
            null);

    assertThat(result.get("BYOID_AudienceUri"))
        .isEqualTo(
            "//iam.googleapis.com/locations/global/workforcePools/pool-id/providers/provider-id");
    assertThat(result.get("BYOID_PoolUserProject")).isEqualTo("workforceProjectNumber");
    assertThat(result.get("BYOID_CredentialSource")).isEqualTo("{\"file\": \"C:\\\\Token.txt\"}");
    assertThat(result.get("BYOID_SA_Impersonation_Uri")).isEqualTo("testSA");
    assertThat(result.get("BYOID_SubjectTokenType"))
        .isEqualTo("urn:ietf:params:oauth:tokentype:jwt");
    assertThat(result.get("BYOID_TokenUri")).isEqualTo("https://testuri.com/v1/token");
  }

  @Test
  public void testParseUserImpersonationDefault() {
    String connectionUri =
        getUriOAuthServiceAccount()
            .append("ServiceAccountImpersonationEmail", "impersonated")
            .toString();
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(DataSource.fromUrl(connectionUri), "");
    assertEquals(
        "impersonated",
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME));
    assertEquals(
        BigQueryJdbcOAuthUtility.BIGQUERY_SCOPE,
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME));
    assertEquals(
        BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_VALUE,
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME));
  }

  @Test
  public void testParseUserImpersonationNonDefault() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                getUriOAuthServiceAccount()
                    .append("ServiceAccountImpersonationEmail", "impersonated")
                    .append("ServiceAccountImpersonationScopes", "scopes")
                    .append("ServiceAccountImpersonationTokenLifetime", 300)
                    .toString()),
            "");
    assertEquals(
        "impersonated",
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME));
    assertEquals(
        "scopes", result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME));
    assertEquals(
        "300",
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME));
  }

  @Test
  public void testParseUserImpersonationForADC() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "OAuthType=3;ProjectId=MyBigQueryProject;"
                    + "ServiceAccountImpersonationEmail=impersonated@email.com;"),
            "");

    assertEquals("APPLICATION_DEFAULT_CREDENTIALS", result.get("OAuthType"));
    assertEquals(
        "impersonated@email.com",
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME));
  }

  @Test
  public void testGetServiceAccountImpersonatedCredentialsForADC() throws Exception {
    GoogleCredentials dummySourceCredentials = GoogleCredentials.newBuilder().build();

    try (org.mockito.MockedStatic<GoogleCredentials> mockedCreds =
        org.mockito.Mockito.mockStatic(GoogleCredentials.class)) {
      mockedCreds.when(GoogleCredentials::getApplicationDefault).thenReturn(dummySourceCredentials);

      Map<String, String> authProperties =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(
                  "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                      + "OAuthType=3;ProjectId=MyBigQueryProject;"
                      + "ServiceAccountImpersonationEmail=impersonated@email.com;"),
              "");

      GoogleCredentials credentials =
          BigQueryJdbcOAuthUtility.getCredentials(
              authProperties, java.util.Collections.EMPTY_MAP, false, null, null);

      assertThat(credentials).isInstanceOf(ImpersonatedCredentials.class);
      assertThat(((ImpersonatedCredentials) credentials).getSourceCredentials())
          .isEqualTo(dummySourceCredentials);
    }
  }

  @Test
  public void testGetServiceAccountImpersonatedCredentials() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                getUriOAuthServiceAccount()
                    .append("ServiceAccountImpersonationEmail", "impersonated")
                    .toString()),
            "");
    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, Collections.EMPTY_MAP, false, null, null);
    assertThat(credentials).isInstanceOf(ImpersonatedCredentials.class);
  }

  @Test
  public void testPrivateKeyFromPkcs8() {
    PrivateKey pk = BigQueryJdbcOAuthUtility.privateKeyFromPkcs8(fake_pkcs8_key);
    assertNotNull(pk);
  }

  @Test
  public void testPrivateKeyFromPkcs8_wrong() {
    PrivateKey pk = BigQueryJdbcOAuthUtility.privateKeyFromPkcs8("");
    assertNull(pk);
  }

  // Command to generate key:
  // keytool -genkey -alias privatekey -keyalg RSA -keysize 2048 -storepass notasecret \
  //   -keypass  notasecret -storetype pkcs12 -keystore ./fake.p12
  @Test
  public void testPrivateKeyFromP12Bytes() {
    URL resource = BigQueryJdbcOAuthUtilityTest.class.getResource("/fake.p12");
    try {
      PrivateKey pk =
          BigQueryJdbcOAuthUtility.privateKeyFromP12Bytes(
              Files.readAllBytes(Paths.get(resource.toURI())), "notasecret");
      assertNotNull(pk);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testPrivateKeyFromP12Bytes_wrong_password() {
    URL resource = BigQueryJdbcOAuthUtilityTest.class.getResource("/fake.p12");
    try {
      PrivateKey pk =
          BigQueryJdbcOAuthUtility.privateKeyFromP12Bytes(
              Files.readAllBytes(Paths.get(resource.toURI())), "fake");
      assertNull(pk);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testGetCredentialsPropagatesHttpTransportFactory() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=0;"
                    + "OAuthServiceAcctEmail=dummytest@dummytest.iam.gserviceaccount.com;"
                    + "OAuthPvtKey="
                    + fake_pkcs8_key
                    + ";"),
            null);

    HttpTransportFactory dummyFactory = () -> null;

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, Collections.emptyMap(), false, dummyFactory, null);

    assertThat(credentials).isInstanceOf(ServiceAccountCredentials.class);
    assertThat(((ServiceAccountCredentials) credentials).toBuilder().getHttpTransportFactory())
        .isEqualTo(dummyFactory);
  }

  @Test
  public void testGetImpersonatedCredentialsPropagatesHttpTransportFactory() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=0;"
                    + "OAuthServiceAcctEmail=dummytest@dummytest.iam.gserviceaccount.com;"
                    + "OAuthPvtKey="
                    + fake_pkcs8_key
                    + ";"
                    + "ServiceAccountImpersonationEmail=impersonated@email.com;"),
            null);

    HttpTransportFactory dummyFactory = () -> null;

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, Collections.emptyMap(), false, dummyFactory, null);

    assertThat(credentials).isInstanceOf(ImpersonatedCredentials.class);
    assertThat(((ImpersonatedCredentials) credentials).toBuilder().getHttpTransportFactory())
        .isEqualTo(dummyFactory);
  }

  @Test
  public void testGetPreGeneratedRefreshTokenCredentialsPropagatesHttpTransportFactory() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            DataSource.fromUrl(
                "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                    + "ProjectId=MyBigQueryProject;OAuthType=2;"
                    + "OAuthRefreshToken=dummy_refresh_token;OAuthClientId=dummy_client_id;OAuthClientSecret=dummy_client_secret;"),
            null);

    HttpTransportFactory dummyFactory = () -> null;

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(
            authProperties, Collections.emptyMap(), false, dummyFactory, null);

    assertThat(credentials).isInstanceOf(UserCredentials.class);
    assertThat(((UserCredentials) credentials).toBuilder().getHttpTransportFactory())
        .isEqualTo(dummyFactory);
  }

  @Test
  public void testOpenLoopbackServerSocket_bindsLoopbackAndFallsBackToIpv6() throws Exception {
    try (ServerSocket serverSocket = BigQueryJdbcOAuthCallbackServer.openLoopbackServerSocket()) {
      assertThat(serverSocket.getInetAddress().isLoopbackAddress()).isTrue();
      assertThat(serverSocket.getInetAddress().isAnyLocalAddress()).isFalse();
    }

    InetAddress ipv4Loopback = InetAddress.getByAddress(new byte[] {127, 0, 0, 1});
    InetAddress ipv6Loopback =
        InetAddress.getByAddress(new byte[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1});
    assertThat(
            BigQueryJdbcOAuthCallbackServer.buildLoopbackCallbackUri(ipv4Loopback, USER_AUTH_PORT))
        .isEqualTo(URI.create("http://127.0.0.1:" + USER_AUTH_PORT));
    assertThat(
            BigQueryJdbcOAuthCallbackServer.buildLoopbackCallbackUri(ipv6Loopback, USER_AUTH_PORT))
        .isEqualTo(URI.create("http://[::1]:" + USER_AUTH_PORT));

    AtomicReference<InetAddress> fallbackBoundAddress = new AtomicReference<>();
    AtomicInteger capturedBacklog = new AtomicInteger();
    try (ServerSocket unboundIpv6Socket = new ServerSocket()) {
      ServerSocket fallbackResult =
          BigQueryJdbcOAuthCallbackServer.openLoopbackServerSocket(
              (address, backlog) -> {
                if (!(address instanceof Inet6Address)) {
                  throw new IOException("IPv4 loopback unavailable");
                }
                fallbackBoundAddress.set(address);
                capturedBacklog.set(backlog);
                return unboundIpv6Socket;
              });
      assertThat(fallbackResult).isSameInstanceAs(unboundIpv6Socket);
      assertThat(fallbackBoundAddress.get()).isEqualTo(ipv6Loopback);
      assertThat(capturedBacklog.get()).isEqualTo(8);
    }

    IOException ipv4Error = new IOException("IPv4 bind failed");
    IOException ipv6Error = new IOException("IPv6 bind failed");
    IOException combined =
        assertThrows(
            IOException.class,
            () ->
                BigQueryJdbcOAuthCallbackServer.openLoopbackServerSocket(
                    (address, backlog) -> {
                      throw (address instanceof Inet6Address) ? ipv6Error : ipv4Error;
                    }));
    assertThat(combined).isSameInstanceAs(ipv4Error);
    assertThat(combined.getSuppressed()).asList().containsExactly(ipv6Error);
  }

  @Test
  public void testUserAuthFlow_exchangesUrlEncodedCodeWithValidState() throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();
    AtomicReference<Map<String, String>> capturedTokenParams = new AtomicReference<>();
    AtomicReference<ServerSocket> capturedServerSocket = new AtomicReference<>();
    AtomicBoolean closedBeforeTokenExchange = new AtomicBoolean(false);

    HttpTransportFactory transportFactory =
        createMockTokenTransport(
            capturedTokenParams,
            null,
            () -> closedBeforeTokenExchange.set(capturedServerSocket.get().isClosed()));

    AtomicReference<CompletableFuture<String>> rawHttpResponseFuture = new AtomicReference<>();
    AtomicReference<String> capturedState = new AtomicReference<>();
    AtomicReference<String> capturedChallenge = new AtomicReference<>();

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
            authProperties,
            Collections.singletonMap(
                BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
                "explicit-universe.example.com"),
            false,
            transportFactory,
            null,
            capturingSocketSupplier(capturedServerSocket),
            authUri -> {
              Map<String, String> params = parseQueryParams(authUri.getRawQuery());
              URI redirectUri = URI.create(params.get("redirect_uri"));
              capturedState.set(params.get("state"));
              capturedChallenge.set(params.get("code_challenge"));
              rawHttpResponseFuture.set(
                  runAsyncClient(
                      () ->
                          sendHttpRequest(
                              redirectUri,
                              callbackGetRequest(
                                  redirectUri,
                                  "/?state="
                                      + params.get("state")
                                      + "&code=4%2F0A+raw%2Bencoded"))));
            },
            5000,
            2000);

    assertThat(credentials).isInstanceOf(UserCredentials.class);
    assertThat(credentials.getUniverseDomain()).isEqualTo("explicit-universe.example.com");
    assertThat(closedBeforeTokenExchange.get()).isTrue();
    assertThat(capturedServerSocket.get().isClosed()).isTrue();
    assertThat(capturedState.get()).matches("^[A-Za-z0-9_-]{43}$");
    assertThat(capturedTokenParams.get().get("code")).isEqualTo("4/0A+raw+encoded");
    assertThat(computeS256Challenge(capturedTokenParams.get().get("code_verifier")))
        .isEqualTo(capturedChallenge.get());

    String rawResponse = rawHttpResponseFuture.get().get(5, TimeUnit.SECONDS);
    assertValidHttpResponse(rawResponse, "HTTP/1.1 200 OK");
    assertThat(rawResponse).contains("Thank you for using JDBC Driver for Google BigQuery!");
  }

  @Test
  public void testUserAuthFlow_supportsHttp10QueryVariantsAndAbortedResponseWrite()
      throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();
    AtomicReference<Map<String, String>> capturedTokenParams = new AtomicReference<>();
    HttpTransportFactory transportFactory =
        createMockTokenTransport(capturedTokenParams, null, null);
    AtomicReference<ServerSocket> capturedServerSocket = new AtomicReference<>();
    AtomicReference<CompletableFuture<Void>> clientFuture = new AtomicReference<>();

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
            authProperties,
            Collections.emptyMap(),
            false,
            transportFactory,
            null,
            capturingSocketSupplier(capturedServerSocket),
            authUri -> {
              Map<String, String> params = parseQueryParams(authUri.getRawQuery());
              URI redirectUri = URI.create(params.get("redirect_uri"));
              String rawRequest =
                  "GET /?flag&&state=" + params.get("state") + "&code=http10_code HTTP/1.0\n\n";
              clientFuture.set(
                  runAsyncClient(
                      () -> {
                        try (Socket socket =
                            new Socket(redirectUri.getHost(), redirectUri.getPort())) {
                          socket.setSoLinger(true, 0);
                          socket
                              .getOutputStream()
                              .write(rawRequest.getBytes(StandardCharsets.US_ASCII));
                          socket.getOutputStream().flush();
                        }
                        return null;
                      }));
            },
            5000,
            2000);

    clientFuture.get().get(5, TimeUnit.SECONDS);
    assertThat(credentials).isInstanceOf(UserCredentials.class);
    assertThat(credentials.getUniverseDomain()).isEqualTo("googleapis.com");
    assertThat(capturedTokenParams.get().get("code")).isEqualTo("http10_code");
    assertThat(capturedServerSocket.get().isClosed()).isTrue();
  }

  @Test
  public void testParseOAuthQueryParameters_preservesLiteralPlusAndRejectsMalformedPercentEncoding()
      throws Exception {
    assertThat(BigQueryJdbcOAuthCallbackServer.parseOAuthQueryParameters(null)).isEmpty();
    assertThat(BigQueryJdbcOAuthCallbackServer.parseOAuthQueryParameters("")).isEmpty();

    Map<String, String> decoded =
        BigQueryJdbcOAuthCallbackServer.parseOAuthQueryParameters(
            "state=st+1%2B2&code=4%2F0A+raw%2Bencoded%20space");
    assertThat(decoded.get("state")).isEqualTo("st+1+2");
    assertThat(decoded.get("code")).isEqualTo("4/0A+raw+encoded space");

    for (String malformedQuery :
        new String[] {
          "state=ok&code=bad_%ZZ_raw_token",
          "state=ok&code=trailing_percent_%",
          "bad_%2_key=raw_token"
        }) {
      BigQueryJdbcOAuthCallbackServer.HttpCallbackException ex =
          assertThrows(
              BigQueryJdbcOAuthCallbackServer.HttpCallbackException.class,
              () -> BigQueryJdbcOAuthCallbackServer.parseOAuthQueryParameters(malformedQuery));
      assertThat(ex.getMessage())
          .isEqualTo("Malformed query parameter encoding in OAuth callback.");
      assertThat(ex.getCause()).isNull();
      assertThat(ex.getMessage()).doesNotContain("raw_token");
      assertThat(ex.getMessage()).doesNotContain("trailing_percent");
    }
  }

  @Test
  public void testUserAuthCallback_rejectsInvalidStateCodeAndDuplicates() throws Exception {
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> callbackGetRequest(redirectUri, "/"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> callbackGetRequest(redirectUri, "/?"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?code=some_code&scope=bigquery"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> callbackGetRequest(redirectUri, "/?state=&code=some_code"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=wrong_state&code=some_code&scope=bigquery"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=wrong_state&error=access_denied"),
        false,
        "Missing or invalid state parameter in OAuth callback.");
    assertTerminalCallbackAbortsImmediately(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=" + authParams.get("state")),
        "Could not retrieve the authorization code from OAuth callback.");
    assertTerminalCallbackAbortsImmediately(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=" + authParams.get("state") + "&code="),
        "Could not retrieve the authorization code from OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(
                redirectUri, "/?state=" + authParams.get("state") + "&code=first&code=second"),
        false,
        "Duplicate OAuth callback parameter: code");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(
                redirectUri,
                "/?state="
                    + authParams.get("state")
                    + "&state="
                    + authParams.get("state")
                    + "&code=first"),
        false,
        "Duplicate OAuth callback parameter: state");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(
                redirectUri, "/?state=" + authParams.get("state") + "&error=err1&error=err2"),
        false,
        "Duplicate OAuth callback parameter: error");
  }

  @Test
  public void testUserAuthCallback_handlesAndSanitizesOAuthErrorParameter() throws Exception {
    assertTerminalCallbackAbortsImmediately(
        (redirectUri, authParams) ->
            callbackGetRequest(
                redirectUri, "/?state=" + authParams.get("state") + "&error=access_denied"),
        "OAuth authorization failed: access_denied");
    assertTerminalCallbackAbortsImmediately(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=" + authParams.get("state") + "&error="),
        "OAuth authorization failed: unknown_error");

    StringBuilder longError = new StringBuilder("bad%22err%20val%0A");
    for (int i = 0; i < 70; i++) {
      longError.append('x');
    }
    StringBuilder expectedSanitized = new StringBuilder("bad_err_val_");
    while (expectedSanitized.length() < 64) {
      expectedSanitized.append('x');
    }
    assertTerminalCallbackAbortsImmediately(
        (redirectUri, authParams) ->
            callbackGetRequest(
                redirectUri, "/?state=" + authParams.get("state") + "&error=" + longError),
        "OAuth authorization failed: " + expectedSanitized);
  }

  @Test
  public void testUserAuthCallback_ignoresPreconnectProbesAndFaviconBeforeValidCallback()
      throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();
    AtomicReference<Map<String, String>> capturedTokenParams = new AtomicReference<>();
    HttpTransportFactory transportFactory =
        createMockTokenTransport(capturedTokenParams, null, null);
    AtomicReference<CompletableFuture<String[]>> intermediateResponsesFuture =
        new AtomicReference<>();

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
            authProperties,
            Collections.emptyMap(),
            false,
            transportFactory,
            null,
            BigQueryJdbcOAuthCallbackServer::openLoopbackServerSocket,
            authUri -> {
              Map<String, String> params = parseQueryParams(authUri.getRawQuery());
              URI redirectUri = URI.create(params.get("redirect_uri"));
              String host = redirectUri.getHost();
              int port = redirectUri.getPort();
              String state = params.get("state");
              intermediateResponsesFuture.set(
                  runAsyncClient(
                      () -> {
                        try (Socket emptyPreconnect = new Socket(host, port)) {
                          // Immediate clean EOF preconnect.
                        }
                        try (Socket resetPreconnect = new Socket(host, port)) {
                          resetPreconnect.setSoLinger(true, 0);
                        }
                        try (Socket slowDrip = new Socket(host, port)) {
                          slowDrip.setSoTimeout(40);
                          OutputStream out = slowDrip.getOutputStream();
                          InputStream in = slowDrip.getInputStream();
                          for (int i = 0; i < 30; i++) {
                            try {
                              out.write('G');
                              out.flush();
                            } catch (IOException serverClosed) {
                              break;
                            }
                            try {
                              if (in.read() == -1) {
                                break;
                              }
                            } catch (SocketTimeoutException continueDripping) {
                              // Drip the next byte until the server closes at readDeadlineNanos.
                            } catch (IOException serverClosed) {
                              break;
                            }
                          }
                        }
                        String headerLine =
                            "X-Extra-Padding: 0123456789abcdef0123456789abcdef0123456789abcdef\r\n";
                        StringBuilder cookieHeavyFavicon = new StringBuilder(25000);
                        cookieHeavyFavicon
                            .append("GET /favicon.ico HTTP/1.1\r\nHost: ")
                            .append(host)
                            .append("\r\n");
                        while (cookieHeavyFavicon.length() < 24000) {
                          cookieHeavyFavicon.append(headerLine);
                        }
                        cookieHeavyFavicon.append("\r\n");
                        String faviconResp =
                            sendHttpRequest(redirectUri, cookieHeavyFavicon.toString());
                        String optionsProbeResp =
                            sendHttpRequest(
                                redirectUri,
                                "OPTIONS / HTTP/1.1\r\nHost: " + host + ":" + port + "\r\n\r\n");
                        String missingStateProbeResp =
                            sendHttpRequest(
                                redirectUri,
                                callbackGetRequest(redirectUri, "/?code=unverified_probe_code"));
                        String wrongStateErrorProbeResp =
                            sendHttpRequest(
                                redirectUri,
                                callbackGetRequest(
                                    redirectUri, "/?state=wrong_state&error=access_denied"));

                        int oversizedHeaderTarget =
                            BigQueryJdbcOAuthCallbackServer.MAX_HTTP_HEADER_BYTES + 4096;
                        StringBuilder largeHeaders = new StringBuilder(oversizedHeaderTarget + 256);
                        largeHeaders
                            .append("GET /?state=")
                            .append(state)
                            .append("&code=after_preconnect HTTP/1.1\r\nHost: ")
                            .append(host)
                            .append("\r\n");
                        while (largeHeaders.length() < oversizedHeaderTarget) {
                          largeHeaders.append(headerLine);
                        }
                        largeHeaders.append("\r\n");
                        String successResp = sendHttpRequest(redirectUri, largeHeaders.toString());
                        return new String[] {
                          faviconResp,
                          optionsProbeResp,
                          missingStateProbeResp,
                          wrongStateErrorProbeResp,
                          successResp
                        };
                      }));
            },
            5000,
            200);

    assertThat(credentials).isInstanceOf(UserCredentials.class);
    String[] responses = intermediateResponsesFuture.get().get(5, TimeUnit.SECONDS);
    assertValidHttpResponse(responses[0], "HTTP/1.1 404 Not Found");
    assertValidHttpResponse(responses[1], "HTTP/1.1 400 Bad Request");
    assertValidHttpResponse(responses[2], "HTTP/1.1 400 Bad Request");
    assertValidHttpResponse(responses[3], "HTTP/1.1 400 Bad Request");
    assertValidHttpResponse(responses[4], "HTTP/1.1 200 OK");
    assertThat(capturedTokenParams.get().get("code")).isEqualTo("after_preconnect");
  }

  @Test
  public void testUserAuthCallback_enforcesDeadlinesAndBrowserLaunchFailureCleanup()
      throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();

    AtomicReference<ServerSocket> browserErrorSocket = new AtomicReference<>();
    BigQueryJdbcRuntimeException browserLaunchEx =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                    authProperties,
                    Collections.emptyMap(),
                    false,
                    null,
                    null,
                    capturingSocketSupplier(browserErrorSocket),
                    authUri -> {
                      throw new IOException("Browser launch failed");
                    },
                    1000,
                    500));
    assertThat(browserLaunchEx.getCause()).isInstanceOf(IOException.class);
    assertThat(browserLaunchEx.getCause().getMessage()).isEqualTo("Browser launch failed");
    assertThat(browserErrorSocket.get().isClosed()).isTrue();

    AtomicReference<ServerSocket> eofSocket = new AtomicReference<>();
    BigQueryJdbcRuntimeException eofTimeoutEx =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                    authProperties,
                    Collections.emptyMap(),
                    false,
                    null,
                    null,
                    capturingSocketSupplier(eofSocket),
                    authUri -> {
                      URI redirectUri =
                          URI.create(parseQueryParams(authUri.getRawQuery()).get("redirect_uri"));
                      try (Socket empty =
                          new Socket(redirectUri.getHost(), redirectUri.getPort())) {
                        // Queued synchronously in backlog before overallDeadlineNanos starts.
                      }
                    },
                    120,
                    60));
    assertThat(eofTimeoutEx.getCause()).isInstanceOf(SocketTimeoutException.class);
    assertThat(eofTimeoutEx.getCause().getMessage())
        .isEqualTo("Timed out waiting for OAuth authorization callback.");
    assertThat(eofSocket.get().isClosed()).isTrue();

    AtomicReference<ServerSocket> stalledSocket = new AtomicReference<>();
    CountDownLatch wrotePartialBytes = new CountDownLatch(1);
    CountDownLatch releaseStalledClient = new CountDownLatch(1);
    AtomicReference<CompletableFuture<Void>> stalledClientFuture = new AtomicReference<>();
    try {
      BigQueryJdbcRuntimeException stalledEx =
          assertThrows(
              BigQueryJdbcRuntimeException.class,
              () ->
                  BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                      authProperties,
                      Collections.emptyMap(),
                      false,
                      null,
                      null,
                      capturingSocketSupplier(stalledSocket),
                      authUri -> {
                        URI redirectUri =
                            URI.create(parseQueryParams(authUri.getRawQuery()).get("redirect_uri"));
                        stalledClientFuture.set(
                            runAsyncClient(
                                () -> {
                                  try (Socket slow =
                                      new Socket(redirectUri.getHost(), redirectUri.getPort())) {
                                    slow.getOutputStream()
                                        .write(
                                            "GET /?state=partial"
                                                .getBytes(StandardCharsets.US_ASCII));
                                    slow.getOutputStream().flush();
                                    wrotePartialBytes.countDown();
                                    releaseStalledClient.await(5, TimeUnit.SECONDS);
                                  }
                                  return null;
                                }));
                        try {
                          assertThat(wrotePartialBytes.await(5, TimeUnit.SECONDS)).isTrue();
                        } catch (InterruptedException e) {
                          Thread.currentThread().interrupt();
                          throw new IOException("Interrupted waiting for partial request write", e);
                        }
                      },
                      120,
                      500));
      assertThat(stalledEx.getCause()).isInstanceOf(SocketTimeoutException.class);
      assertThat(stalledEx.getCause().getMessage())
          .isEqualTo("Timed out waiting for OAuth authorization callback.");
      assertThat(stalledSocket.get().isClosed()).isTrue();
    } finally {
      releaseStalledClient.countDown();
      if (stalledClientFuture.get() != null) {
        stalledClientFuture.get().get(5, TimeUnit.SECONDS);
      }
    }
    AtomicReference<ServerSocket> rejectedThenTimedOutSocket = new AtomicReference<>();
    BigQueryJdbcRuntimeException rejectedTimeoutEx =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                    authProperties,
                    Collections.emptyMap(),
                    false,
                    null,
                    null,
                    capturingSocketSupplier(rejectedThenTimedOutSocket),
                    authUri -> {
                      URI redirectUri =
                          URI.create(parseQueryParams(authUri.getRawQuery()).get("redirect_uri"));
                      try (Socket probe =
                          new Socket(redirectUri.getHost(), redirectUri.getPort())) {
                        probe
                            .getOutputStream()
                            .write(
                                callbackGetRequest(redirectUri, "/?state=wrong")
                                    .getBytes(StandardCharsets.US_ASCII));
                        probe.getOutputStream().flush();
                      }
                    },
                    250,
                    250));
    assertThat(rejectedTimeoutEx.getCause()).isInstanceOf(SocketTimeoutException.class);
    assertThat(rejectedTimeoutEx.getCause().getMessage())
        .isEqualTo(
            "Timed out waiting for OAuth authorization callback. Last rejected callback request: "
                + "Missing or invalid state parameter in OAuth callback.");
    assertThat(rejectedThenTimedOutSocket.get().isClosed()).isTrue();
  }

  @Test
  public void testUserAuthCallback_rejectsOversizedTruncatedAndMalformedRequestLines()
      throws Exception {
    StringBuilder oversizedQuery =
        new StringBuilder(BigQueryJdbcOAuthCallbackServer.MAX_HTTP_REQUEST_LINE_BYTES + 256);
    oversizedQuery.append("GET /?pad=");
    for (int i = 0; i < BigQueryJdbcOAuthCallbackServer.MAX_HTTP_REQUEST_LINE_BYTES; i++) {
      oversizedQuery.append('a');
    }
    oversizedQuery.append(" HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n");

    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> oversizedQuery.toString(),
        false,
        "OAuth callback HTTP request line exceeded maximum length.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "G\rET /?code=abc HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n",
        false,
        "Invalid bare CR in OAuth callback HTTP request line.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "GET /\r\n\r\n",
        false,
        "Invalid HTTP request line on OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "POST /?code=abc HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n",
        false,
        "Invalid HTTP request line on OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "GET ?code=abc HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n",
        false,
        "Invalid HTTP request line on OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "GET /?code=abc HTTP/2.0\r\nHost: 127.0.0.1\r\n\r\n",
        false,
        "Invalid HTTP request line on OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            "GET http://example.com/?code=abc HTTP/1.1\r\nHost: 127.0.0.1\r\n\r\n",
        false,
        "Invalid HTTP request line on OAuth callback.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> callbackGetRequest(redirectUri, "//example.com/?code=abc"),
        false,
        "Unexpected URI format in OAuth callback request.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> callbackGetRequest(redirectUri, "/?code=abc#frag"),
        false,
        "Unexpected URI format in OAuth callback request.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) ->
            callbackGetRequest(redirectUri, "/?state=%ZZ&code=unlogged_token_val"),
        false,
        "Malformed URI in OAuth callback request.");
    assertUnverifiedCallbackIgnoredUntilTimeout(
        (redirectUri, authParams) -> "GET /?code=incomplete",
        true,
        "Incomplete OAuth callback HTTP request line.");
  }

  @Test
  public void testUserAuthFlow_failsFastWhenDesktopBrowseUnsupported() throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();

    try (MockedStatic<GraphicsEnvironment> mockedGraphics =
            Mockito.mockStatic(GraphicsEnvironment.class);
        MockedStatic<Desktop> mockedDesktop = Mockito.mockStatic(Desktop.class)) {
      Desktop desktop = Mockito.mock(Desktop.class);

      mockedGraphics.when(GraphicsEnvironment::isHeadless).thenReturn(true);
      assertThat(BigQueryJdbcOAuthUtility.isDesktopBrowseSupported()).isFalse();

      mockedGraphics.when(GraphicsEnvironment::isHeadless).thenReturn(false);
      mockedDesktop.when(Desktop::isDesktopSupported).thenReturn(false);
      assertThat(BigQueryJdbcOAuthUtility.isDesktopBrowseSupported()).isFalse();

      mockedDesktop.when(Desktop::isDesktopSupported).thenReturn(true);
      mockedDesktop.when(Desktop::getDesktop).thenReturn(desktop);
      Mockito.when(desktop.isSupported(Desktop.Action.BROWSE)).thenReturn(false);
      assertThat(BigQueryJdbcOAuthUtility.isDesktopBrowseSupported()).isFalse();

      BigQueryJdbcRuntimeException ex =
          assertThrows(
              BigQueryJdbcRuntimeException.class,
              () ->
                  BigQueryJdbcOAuthUtility.getCredentials(
                      authProperties, Collections.emptyMap(), false, null, null));
      assertThat(ex.getMessage()).isEqualTo("User auth only supported in desktop environments");

      Mockito.when(desktop.isSupported(Desktop.Action.BROWSE)).thenReturn(true);
      assertThat(BigQueryJdbcOAuthUtility.isDesktopBrowseSupported()).isTrue();

      AtomicReference<Map<String, String>> capturedTokenParams = new AtomicReference<>();
      HttpTransportFactory transportFactory =
          createMockTokenTransport(capturedTokenParams, null, null);
      AtomicReference<String> capturedAuthScope = new AtomicReference<>();
      AtomicReference<CompletableFuture<String>> callbackResponseFuture = new AtomicReference<>();
      Mockito.doAnswer(
              invocation -> {
                URI authUri = invocation.getArgument(0);
                Map<String, String> params = parseQueryParams(authUri.getRawQuery());
                capturedAuthScope.set(params.get("scope"));
                URI redirectUri = URI.create(params.get("redirect_uri"));
                callbackResponseFuture.set(
                    runAsyncClient(
                        () ->
                            sendHttpRequest(
                                redirectUri,
                                callbackGetRequest(
                                    redirectUri,
                                    "/?state="
                                        + params.get("state")
                                        + "&code=desktop_browse_code"))));
                return null;
              })
          .when(desktop)
          .browse(Mockito.any(URI.class));

      GoogleCredentials credentials =
          BigQueryJdbcOAuthUtility.getCredentials(
              authProperties, Collections.emptyMap(), false, transportFactory, null);
      assertThat(credentials).isInstanceOf(UserCredentials.class);
      assertThat(credentials.getUniverseDomain()).isEqualTo("googleapis.com");
      assertThat(capturedAuthScope.get()).isEqualTo("https://www.googleapis.com/auth/bigquery");
      assertThat(capturedTokenParams.get().get("code")).isEqualTo("desktop_browse_code");
      assertValidHttpResponse(
          callbackResponseFuture.get().get(5, TimeUnit.SECONDS), "HTTP/1.1 200 OK");

      GoogleCredentials driveCredentials =
          BigQueryJdbcOAuthUtility.getCredentials(
              authProperties, Collections.emptyMap(), true, transportFactory, null);
      assertThat(driveCredentials).isInstanceOf(UserCredentials.class);
      assertThat(capturedAuthScope.get())
          .isEqualTo(
              "https://www.googleapis.com/auth/bigquery"
                  + " https://www.googleapis.com/auth/drive.readonly");
      assertValidHttpResponse(
          callbackResponseFuture.get().get(5, TimeUnit.SECONDS), "HTTP/1.1 200 OK");
    }
  }

  @FunctionalInterface
  private interface CallbackRequestBuilder {
    String build(URI redirectUri, Map<String, String> authQueryParams);
  }

  private static final class SingleAcceptLoopbackServerSocket extends ServerSocket {
    private boolean acceptedFirstConnection;

    private SingleAcceptLoopbackServerSocket() throws IOException {
      super(0, 8, InetAddress.getByAddress(new byte[] {127, 0, 0, 1}));
    }

    @Override
    public Socket accept() throws IOException {
      if (!acceptedFirstConnection) {
        acceptedFirstConnection = true;
        return super.accept();
      }
      throw new SocketTimeoutException("Simulated accept timeout after first connection");
    }
  }

  private static Map<String, String> defaultUserAuthProperties() {
    return BigQueryJdbcOAuthUtility.parseOAuthProperties(
        DataSource.fromUrl(getUriOAuthUserAccount().toString()), null);
  }

  private static BigQueryJdbcOAuthCallbackServer.ServerSocketSupplier capturingSocketSupplier(
      AtomicReference<ServerSocket> socketRef) {
    return () -> {
      ServerSocket socket = BigQueryJdbcOAuthCallbackServer.openLoopbackServerSocket();
      socketRef.set(socket);
      return socket;
    };
  }

  private static String callbackGetRequest(URI redirectUri, String target) {
    return "GET "
        + target
        + " HTTP/1.1\r\nHost: "
        + redirectUri.getHost()
        + ":"
        + redirectUri.getPort()
        + "\r\n\r\n";
  }

  private static String computeS256Challenge(String verifier) throws NoSuchAlgorithmException {
    return Base64.getUrlEncoder()
        .withoutPadding()
        .encodeToString(
            MessageDigest.getInstance("SHA-256")
                .digest(verifier.getBytes(StandardCharsets.US_ASCII)));
  }

  private static void assertTerminalCallbackAbortsImmediately(
      CallbackRequestBuilder requestBuilder, String expectedExactMessage) throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();
    AtomicInteger tokenCalls = new AtomicInteger();
    HttpTransportFactory transportFactory =
        createMockTokenTransport(new AtomicReference<>(), tokenCalls, null);
    AtomicReference<ServerSocket> capturedSocket = new AtomicReference<>();
    AtomicReference<CompletableFuture<String>> rawResponseFuture = new AtomicReference<>();

    BigQueryJdbcRuntimeException ex =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                    authProperties,
                    Collections.emptyMap(),
                    false,
                    transportFactory,
                    null,
                    capturingSocketSupplier(capturedSocket),
                    authUri -> {
                      Map<String, String> params = parseQueryParams(authUri.getRawQuery());
                      URI redirectUri = URI.create(params.get("redirect_uri"));
                      String rawRequest = requestBuilder.build(redirectUri, params);
                      rawResponseFuture.set(
                          runAsyncClient(() -> sendHttpRequest(redirectUri, rawRequest)));
                    },
                    5000,
                    2000));

    assertThat(ex.getMessage()).isEqualTo(expectedExactMessage);
    assertThat(ex.getCause()).isNull();
    assertThat(tokenCalls.get()).isEqualTo(0);
    assertValidHttpResponse(
        rawResponseFuture.get().get(5, TimeUnit.SECONDS), "HTTP/1.1 400 Bad Request");
    assertThat(capturedSocket.get().isClosed()).isTrue();
  }

  private static void assertUnverifiedCallbackIgnoredUntilTimeout(
      CallbackRequestBuilder requestBuilder,
      boolean shutdownOutputAfterWrite,
      String expectedRejectedReason)
      throws Exception {
    Map<String, String> authProperties = defaultUserAuthProperties();
    AtomicInteger tokenCalls = new AtomicInteger();
    HttpTransportFactory transportFactory =
        createMockTokenTransport(new AtomicReference<>(), tokenCalls, null);
    AtomicReference<ServerSocket> capturedSocket = new AtomicReference<>();
    AtomicReference<CompletableFuture<String>> rawResponseFuture = new AtomicReference<>();

    BigQueryJdbcRuntimeException ex =
        assertThrows(
            BigQueryJdbcRuntimeException.class,
            () ->
                BigQueryJdbcOAuthUtility.getGoogleUserAccountCredentials(
                    authProperties,
                    Collections.emptyMap(),
                    false,
                    transportFactory,
                    null,
                    () -> {
                      ServerSocket socket = new SingleAcceptLoopbackServerSocket();
                      capturedSocket.set(socket);
                      return socket;
                    },
                    authUri -> {
                      Map<String, String> params = parseQueryParams(authUri.getRawQuery());
                      URI redirectUri = URI.create(params.get("redirect_uri"));
                      String rawRequest = requestBuilder.build(redirectUri, params);
                      rawResponseFuture.set(
                          runAsyncClient(
                              () -> {
                                try (Socket socket =
                                    new Socket(redirectUri.getHost(), redirectUri.getPort())) {
                                  socket.setSoTimeout(3000);
                                  OutputStream out = socket.getOutputStream();
                                  out.write(rawRequest.getBytes(StandardCharsets.US_ASCII));
                                  out.flush();
                                  if (shutdownOutputAfterWrite) {
                                    socket.shutdownOutput();
                                  }
                                  return readUtf8Stream(socket.getInputStream());
                                }
                              }));
                    },
                    5000,
                    2000));

    String expectedTimeoutMessage =
        "Timed out waiting for OAuth authorization callback. Last rejected callback request: "
            + expectedRejectedReason;
    assertThat(ex.getMessage())
        .isEqualTo(
            "Failed to establish connection using User Account authentication\n"
                + expectedTimeoutMessage);
    assertThat(ex.getCause()).isInstanceOf(SocketTimeoutException.class);
    assertThat(ex.getCause().getMessage()).isEqualTo(expectedTimeoutMessage);
    assertThat(tokenCalls.get()).isEqualTo(0);
    assertValidHttpResponse(
        rawResponseFuture.get().get(5, TimeUnit.SECONDS), "HTTP/1.1 400 Bad Request");
    assertThat(capturedSocket.get().isClosed()).isTrue();
  }

  @FunctionalInterface
  private interface ThrowingSupplier<T> {
    T get() throws Exception;
  }

  private static <T> CompletableFuture<T> runAsyncClient(ThrowingSupplier<T> action) {
    CompletableFuture<T> future = new CompletableFuture<>();
    Thread thread =
        new Thread(
            () -> {
              try {
                future.complete(action.get());
              } catch (Throwable t) {
                future.completeExceptionally(t);
              }
            });
    thread.setDaemon(true);
    thread.start();
    return future;
  }

  private static HttpTransportFactory createMockTokenTransport(
      AtomicReference<Map<String, String>> capturedParams,
      AtomicInteger callCount,
      Runnable beforeExchangeHook) {
    MockHttpTransport transport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            return new MockLowLevelHttpRequest(url) {
              @Override
              public LowLevelHttpResponse execute() throws IOException {
                if (beforeExchangeHook != null) {
                  beforeExchangeHook.run();
                }
                if (callCount != null) {
                  callCount.incrementAndGet();
                }
                capturedParams.set(parseQueryParams(getContentAsString()));
                return new MockLowLevelHttpResponse()
                    .setStatusCode(200)
                    .setContentType(Json.MEDIA_TYPE)
                    .setContent(
                        "{\"access_token\":\"mock_access_token\","
                            + "\"refresh_token\":\"mock_refresh_token\","
                            + "\"expires_in\":3600,"
                            + "\"token_type\":\"Bearer\"}");
              }
            };
          }
        };
    return () -> transport;
  }

  private static Map<String, String> parseQueryParams(String rawQuery) throws IOException {
    Map<String, String> params = new HashMap<>();
    if (rawQuery == null || rawQuery.isEmpty()) {
      return params;
    }
    for (String pair : rawQuery.split("&")) {
      String[] kv = pair.split("=", 2);
      String key = URLDecoder.decode(kv[0], StandardCharsets.UTF_8.name());
      String value = kv.length > 1 ? URLDecoder.decode(kv[1], StandardCharsets.UTF_8.name()) : "";
      params.put(key, value);
    }
    return params;
  }

  private static String sendHttpRequest(URI redirectUri, String rawRequest) throws IOException {
    try (Socket socket = new Socket(redirectUri.getHost(), redirectUri.getPort())) {
      socket.setSoTimeout(3000);
      OutputStream out = socket.getOutputStream();
      out.write(rawRequest.getBytes(StandardCharsets.US_ASCII));
      out.flush();
      return readUtf8Stream(socket.getInputStream());
    }
  }

  private static String readUtf8Stream(InputStream in) throws IOException {
    ByteArrayOutputStream responseBytes = new ByteArrayOutputStream();
    byte[] buf = new byte[1024];
    int n;
    while ((n = in.read(buf)) != -1) {
      responseBytes.write(buf, 0, n);
    }
    return new String(responseBytes.toByteArray(), StandardCharsets.UTF_8);
  }

  private static void assertValidHttpResponse(String rawResponse, String expectedStatusLine) {
    assertThat(rawResponse).startsWith(expectedStatusLine + "\r\n");
    int headerEnd = rawResponse.indexOf("\r\n\r\n");
    assertThat(headerEnd).isGreaterThan(0);
    String headers = rawResponse.substring(0, headerEnd) + "\r\n";
    String body = rawResponse.substring(headerEnd + 4);
    int expectedLength = body.getBytes(StandardCharsets.UTF_8).length;
    assertThat(headers).contains("\r\nContent-Length: " + expectedLength + "\r\n");
    assertThat(headers).contains("\r\nCache-Control: no-store\r\n");
    assertThat(headers).contains("\r\nX-Content-Type-Options: nosniff\r\n");
    assertThat(headers).contains("\r\nContent-Security-Policy: default-src 'none'\r\n");
    assertThat(headers).contains("\r\nConnection: close\r\n");
  }

  @Test
  public void testServiceAccountJsonNeverOverriddenByEnvOrExplicitUniverseDomain()
      throws Exception {
    JsonObject saJson = new JsonObject();
    saJson.addProperty("type", "service_account");
    saJson.addProperty("project_id", "custom-universe-project");
    saJson.addProperty("private_key_id", "key-id-1");
    saJson.addProperty("private_key", fake_pkcs8_key);
    saJson.addProperty("client_email", "sa@custom-universe-project.iam.gserviceaccount.com");
    saJson.addProperty("client_id", "123456");
    saJson.addProperty("universe_domain", "custom-universe.example.com");

    Path tempKeyFile = Files.createTempFile("custom-universe-sa-", ".json");
    try {
      Files.write(tempKeyFile, saJson.toString().getBytes(StandardCharsets.UTF_8));
      String url =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId=custom-universe-project;OAuthType=0;OAuthPvtKeyPath="
              + tempKeyFile;
      DataSource ds = DataSource.fromUrl(url);
      Map<String, String> authProps = BigQueryJdbcOAuthUtility.parseOAuthProperties(ds, null);

      // 1. Omitted universeDomain (even when GOOGLE_CLOUD_UNIVERSE_DOMAIN is set to another domain)
      // must NOT overwrite a JSON credential's parsed universe_domain.
      try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
          mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
        urlUtil
            .when(BigQueryJdbcUrlUtility::getEnvUniverseDomain)
            .thenReturn("other-universe.example.com");
        GoogleCredentials preserved =
            BigQueryJdbcOAuthUtility.getCredentials(
                authProps, Collections.emptyMap(), false, null, null);
        assertEquals("custom-universe.example.com", preserved.getUniverseDomain());
      }

      // 2. Explicit universeDomain in overrideProperties also does NOT override JSON credential.
      Map<String, String> explicitOverrides =
          Collections.singletonMap(
              BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
              "explicit-universe.example.com");
      GoogleCredentials overridden =
          BigQueryJdbcOAuthUtility.getCredentials(authProps, explicitOverrides, false, null, null);
      assertEquals("custom-universe.example.com", overridden.getUniverseDomain());
    } finally {
      Files.deleteIfExists(tempKeyFile);
    }
  }

  @Test
  public void testNonJsonCredentialsIgnoreEnvUniverseDomainAndUseExplicitOnly() throws Exception {
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil
          .when(BigQueryJdbcUrlUtility::getEnvUniverseDomain)
          .thenReturn("custom-universe.example.com");

      // PKCS#8 Service Account
      Map<String, String> saProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthServiceAccount().toString()), null);
      GoogleCredentials saCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              saProps, Collections.emptyMap(), false, null, null);
      assertEquals("googleapis.com", saCreds.getUniverseDomain());

      // Pre-generated Access Token
      Map<String, String> accessProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthToken().toString()), null);
      GoogleCredentials accessCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              accessProps, Collections.emptyMap(), false, null, null);
      assertEquals("googleapis.com", accessCreds.getUniverseDomain());

      // Pre-generated Refresh Token
      Map<String, String> refreshProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(
                  "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                      + "ProjectId=MyProject;OAuthType=2;OAuthRefreshToken=rt;"
                      + "OAuthClientId=cid;OAuthClientSecret=csecret;"),
              null);
      GoogleCredentials refreshCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              refreshProps, Collections.emptyMap(), false, null, null);
      assertEquals("googleapis.com", refreshCreds.getUniverseDomain());

      // User Account (OAuthType=1)
      Map<String, String> userProps = defaultUserAuthProperties();
      HttpTransportFactory userTransport =
          createMockTokenTransport(new AtomicReference<>(), null, null);
      UserAuthorizer userAuthorizer =
          BigQueryJdbcOAuthUtility.getUserAuthorizer(
              userProps,
              Collections.emptyMap(),
              false,
              USER_AUTH_CALLBACK_URI,
              userTransport,
              null);
      UserCredentials userCreds =
          BigQueryJdbcOAuthUtility.getCredentialsFromCode(
              userAuthorizer, "auth_code", Collections.emptyMap(), userTransport, null);
      assertEquals("googleapis.com", userCreds.getUniverseDomain());

      // Explicit overrideProperties applies to non-JSON credentials
      Map<String, String> explicitOverrides =
          Collections.singletonMap(
              BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
              "explicit-universe.example.com");
      assertEquals(
          "explicit-universe.example.com",
          BigQueryJdbcOAuthUtility.getCredentials(saProps, explicitOverrides, false, null, null)
              .getUniverseDomain());
      assertEquals(
          "explicit-universe.example.com",
          BigQueryJdbcOAuthUtility.getCredentialsFromCode(
                  userAuthorizer, "auth_code", explicitOverrides, userTransport, null)
              .getUniverseDomain());
    }
  }

  @Test
  public void testByoidPropertyCredentialsDeriveStsTokenUriFromUniverseDomain() throws Exception {
    String baseByoidUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=4;ProjectId=p;"
            + "BYOID_AudienceUri=//iam.googleapis.com/locations/global/workforcePools/pool/providers/prov;"
            + "BYOID_CredentialSource={\"file\":\"/tmp/token.txt\"};";

    // 1. Explicit universeDomain in URL with BYOID_TokenUri omitted
    DataSource explicitUniverseDomainDs =
        DataSource.fromUrl(baseByoidUrl + "universeDomain=custom-universe.example.com;");
    Map<String, String> explicitAuthProps =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(explicitUniverseDomainDs, null);
    assertEquals(
        "https://sts.custom-universe.example.com/v1/token",
        explicitAuthProps.get(BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME));
    GoogleCredentials explicitByoidCreds =
        BigQueryJdbcOAuthUtility.getCredentials(
            explicitAuthProps, Collections.emptyMap(), false, null, null);
    assertThat(explicitByoidCreds).isInstanceOf(ExternalAccountCredentials.class);
    assertEquals(
        "https://sts.custom-universe.example.com/v1/token",
        ((ExternalAccountCredentials) explicitByoidCreds).getTokenUrl());
    assertEquals("custom-universe.example.com", explicitByoidCreds.getUniverseDomain());

    // 2. GOOGLE_CLOUD_UNIVERSE_DOMAIN env var does NOT affect synthesized BYOID credentials when
    // universeDomain and BYOID_TokenUri are omitted
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil
          .when(BigQueryJdbcUrlUtility::getEnvUniverseDomain)
          .thenReturn("env-universe.example.com");
      DataSource envUniverseDomainDs = DataSource.fromUrl(baseByoidUrl);
      Map<String, String> envAuthProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(envUniverseDomainDs, null);
      GoogleCredentials envByoidCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              envAuthProps, Collections.emptyMap(), false, null, null);
      assertEquals(
          "https://sts.googleapis.com/v1/token",
          ((ExternalAccountCredentials) envByoidCreds).getTokenUrl());
      assertEquals("googleapis.com", envByoidCreds.getUniverseDomain());
    }

    // 3. Explicit BYOID_TokenUri in URL overrides universeDomain derivation
    DataSource customTokenDs =
        DataSource.fromUrl(
            baseByoidUrl
                + "universeDomain=custom-universe.example.com;"
                + "BYOID_TokenUri=https://custom-sts.example.com/v1/token;");
    Map<String, String> customTokenAuthProps =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(customTokenDs, null);
    assertEquals(
        "https://custom-sts.example.com/v1/token",
        customTokenAuthProps.get(BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME));
    GoogleCredentials customTokenCreds =
        BigQueryJdbcOAuthUtility.getCredentials(
            customTokenAuthProps, Collections.emptyMap(), false, null, null);
    assertEquals(
        "https://custom-sts.example.com/v1/token",
        ((ExternalAccountCredentials) customTokenCreds).getTokenUrl());
    assertEquals("custom-universe.example.com", customTokenCreds.getUniverseDomain());

    // 4. Default GDU (no universeDomain, no env var, no BYOID_TokenUri) resolves sts.googleapis.com
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(null);
      DataSource defaultGduDs = DataSource.fromUrl(baseByoidUrl);
      Map<String, String> defaultGduProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(defaultGduDs, null);
      GoogleCredentials defaultGduCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              defaultGduProps, Collections.emptyMap(), false, null, null);
      assertEquals(
          "https://sts.googleapis.com/v1/token",
          ((ExternalAccountCredentials) defaultGduCreds).getTokenUrl());
      assertEquals("googleapis.com", defaultGduCreds.getUniverseDomain());
    }
  }
}
