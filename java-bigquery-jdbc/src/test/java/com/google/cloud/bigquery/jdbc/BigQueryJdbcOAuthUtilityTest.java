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
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.CALLS_REAL_METHODS;
import static org.mockito.Mockito.mockStatic;

import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.ExternalAccountCredentials;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

public class BigQueryJdbcOAuthUtilityTest extends BigQueryJdbcBaseTest {

  private static final int USER_AUTH_PORT = 53737;
  private static final String EXPECTED_USER_AUTH_URL =
      "https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=client_id&redirect_uri=http://localhost:"
          + USER_AUTH_PORT
          + "&scope=https://www.googleapis.com/auth/bigquery&state=test_state&access_type=offline&prompt=consent&login_hint=test_user&include_granted_scopes=true";

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
  public void testGetCredentialsForPreGeneratedTokenTPC() throws IOException {
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
  public void testGenerateUserAuthURL() {
    try {
      HashMap<String, String> authProperties = new HashMap<>();
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "client_id");
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "client_secret");

      UserAuthorizer userAuthorizer =
          BigQueryJdbcOAuthUtility.getUserAuthorizer(
              authProperties, new HashMap<String, String>(), USER_AUTH_PORT, null, null);

      String userId = "test_user";
      String state = "test_state";
      URI baseURI = URI.create("http://example.com/foo");

      URL authURL = userAuthorizer.getAuthorizationUrl(userId, state, baseURI);

      assertThat(authURL.toString()).isEqualTo(EXPECTED_USER_AUTH_URL);
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
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
              authProperties, overrideProperties, USER_AUTH_PORT, null, null);

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
  public void testServiceAccountJsonPreservesUniverseDomainUnlessExplicitlyOverridden()
      throws Exception {
    JsonObject saJson = new JsonObject();
    saJson.addProperty("type", "service_account");
    saJson.addProperty("project_id", "tpc-project");
    saJson.addProperty("private_key_id", "key-id-1");
    saJson.addProperty("private_key", fake_pkcs8_key);
    saJson.addProperty("client_email", "sa@tpc-project.iam.gserviceaccount.com");
    saJson.addProperty("client_id", "123456");
    saJson.addProperty("universe_domain", "apis-tpczero.goog");

    Path tempKeyFile = Files.createTempFile("tpc-sa-", ".json");
    try {
      Files.write(tempKeyFile, saJson.toString().getBytes(StandardCharsets.UTF_8));
      String url =
          "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
              + "ProjectId=tpc-project;OAuthType=0;OAuthPvtKeyPath="
              + tempKeyFile;
      DataSource ds = DataSource.fromUrl(url);
      Map<String, String> authProps = BigQueryJdbcOAuthUtility.parseOAuthProperties(ds, null);

      // 1. Omitted universeDomain (even when GOOGLE_CLOUD_UNIVERSE_DOMAIN is set to another domain)
      // must NOT overwrite a JSON credential's parsed universe_domain.
      try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
          mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
        urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn("other-tpc.goog");
        GoogleCredentials preserved =
            BigQueryJdbcOAuthUtility.getCredentials(
                authProps, Collections.emptyMap(), false, null, null);
        assertEquals("apis-tpczero.goog", preserved.getUniverseDomain());
      }

      // 2. Explicit universeDomain in overrideProperties DOES override JSON credential.
      Map<String, String> explicitOverrides =
          Collections.singletonMap(
              BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, "explicit-tpc.goog");
      GoogleCredentials overridden =
          BigQueryJdbcOAuthUtility.getCredentials(authProps, explicitOverrides, false, null, null);
      assertEquals("explicit-tpc.goog", overridden.getUniverseDomain());
    } finally {
      Files.deleteIfExists(tempKeyFile);
    }
  }

  @Test
  public void testNonJsonCredentialsUseEnvUniverseDomainFallback() throws Exception {
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn("apis-tpczero.goog");

      // PKCS#8 Service Account
      Map<String, String> saProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthServiceAccount().toString()), null);
      GoogleCredentials saCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              saProps, Collections.emptyMap(), false, null, null);
      assertEquals("apis-tpczero.goog", saCreds.getUniverseDomain());

      // Pre-generated Access Token
      Map<String, String> accessProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthToken().toString()), null);
      GoogleCredentials accessCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              accessProps, Collections.emptyMap(), false, null, null);
      assertEquals("apis-tpczero.goog", accessCreds.getUniverseDomain());

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
      assertEquals("apis-tpczero.goog", refreshCreds.getUniverseDomain());
    }
  }

  @Test
  public void testByoidPropertyCredentialsDeriveStsTokenUriFromUniverseDomain() throws Exception {
    String baseByoidUrl =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;OAuthType=4;ProjectId=p;"
            + "BYOID_AudienceUri=//iam.googleapis.com/locations/global/workforcePools/pool/providers/prov;"
            + "BYOID_CredentialSource={\"file\":\"/tmp/token.txt\"};";

    // 1. Explicit universeDomain in URL with BYOID_TokenUri omitted
    DataSource explicitTpcDs =
        DataSource.fromUrl(baseByoidUrl + "universeDomain=apis-tpczero.goog;");
    Map<String, String> explicitAuthProps =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(explicitTpcDs, null);
    assertEquals(
        "https://sts.apis-tpczero.goog/v1/token",
        explicitAuthProps.get(BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME));
    GoogleCredentials explicitByoidCreds =
        BigQueryJdbcOAuthUtility.getCredentials(
            explicitAuthProps, Collections.emptyMap(), false, null, null);
    assertThat(explicitByoidCreds).isInstanceOf(ExternalAccountCredentials.class);
    assertEquals(
        "https://sts.apis-tpczero.goog/v1/token",
        ((ExternalAccountCredentials) explicitByoidCreds).getTokenUrl());
    assertEquals("apis-tpczero.goog", explicitByoidCreds.getUniverseDomain());

    // 2. GOOGLE_CLOUD_UNIVERSE_DOMAIN env var fallback with universeDomain and BYOID_TokenUri
    // omitted
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn("env-tpc.goog");
      DataSource envTpcDs = DataSource.fromUrl(baseByoidUrl);
      Map<String, String> envAuthProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(envTpcDs, null);
      GoogleCredentials envByoidCreds =
          BigQueryJdbcOAuthUtility.getCredentials(
              envAuthProps, Collections.emptyMap(), false, null, null);
      assertEquals(
          "https://sts.env-tpc.goog/v1/token",
          ((ExternalAccountCredentials) envByoidCreds).getTokenUrl());
      assertEquals("env-tpc.goog", envByoidCreds.getUniverseDomain());
    }

    // 3. Explicit BYOID_TokenUri in URL overrides universeDomain derivation
    DataSource customTokenDs =
        DataSource.fromUrl(
            baseByoidUrl
                + "universeDomain=apis-tpczero.goog;"
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
    assertEquals("apis-tpczero.goog", customTokenCreds.getUniverseDomain());

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

  @Test
  public void testNullOverridePropertiesHandledSafelyAcrossAuthTypes() throws Exception {
    try (MockedStatic<BigQueryJdbcUrlUtility> urlUtil =
        mockStatic(BigQueryJdbcUrlUtility.class, CALLS_REAL_METHODS)) {
      urlUtil.when(BigQueryJdbcUrlUtility::getEnvUniverseDomain).thenReturn(null);

      // Service Account PKCS#8 with null overrideProperties
      Map<String, String> saProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthServiceAccount().toString()), null);
      GoogleCredentials saCreds =
          BigQueryJdbcOAuthUtility.getCredentials(saProps, null, false, null, null);
      assertEquals("googleapis.com", saCreds.getUniverseDomain());

      // Pre-generated Access Token with null overrideProperties
      Map<String, String> tokenProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(getUriOAuthToken().toString()), null);
      GoogleCredentials tokenCreds =
          BigQueryJdbcOAuthUtility.getCredentials(tokenProps, null, false, null, null);
      assertEquals("googleapis.com", tokenCreds.getUniverseDomain());

      // Pre-generated Refresh Token with null overrideProperties
      Map<String, String> refreshProps =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(
              DataSource.fromUrl(
                  "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                      + "ProjectId=MyProject;OAuthType=2;OAuthRefreshToken=rt;"
                      + "OAuthClientId=cid;OAuthClientSecret=csecret;"),
              null);
      GoogleCredentials refreshCreds =
          BigQueryJdbcOAuthUtility.getCredentials(refreshProps, null, false, null, null);
      assertEquals("googleapis.com", refreshCreds.getUniverseDomain());
    }
  }
}
