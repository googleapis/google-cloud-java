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

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ImpersonatedCredentials;
import com.google.auth.oauth2.UserAuthorizer;
import com.google.auth.oauth2.UserCredentials;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.security.PrivateKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class BigQueryJdbcOAuthUtilityTest extends BigQueryJdbcBaseTest {

  private static final int USER_AUTH_PORT = 53737;
  private static final String EXPECTED_USER_AUTH_URL =
      "https://accounts.google.com/o/oauth2/auth?response_type=code&client_id=client_id&redirect_uri=http://localhost:"
          + USER_AUTH_PORT
          + "&scope=https://www.googleapis.com/auth/bigquery&state=test_state&access_type=offline&prompt=consent&login_hint=test_user&include_granted_scopes=true";

  @Test
  public void testParseOAuthPropsForAuthType0KeyfileOnly() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "ProjectId=MyBigQueryProject;OAuthType=0;"
                + "OAuthPvtKeyPath=C:\\SecureFiles\\ServiceKeyFile.p12;",
            null);

    assertThat(result.get("OAuthType")).isEqualTo("GOOGLE_SERVICE_ACCOUNT");
    assertThat(result.get("OAuthPvtKeyPath")).isEqualTo("C:\\SecureFiles\\ServiceKeyFile.p12");
  }

  @Test
  public void testParseOAuthPropsForAuthType0ViaEmail() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "ProjectId=MyBigQueryProject;OAuthType=0;"
                + "OAuthServiceAcctEmail=dummytest@dummytest.iam.gserviceaccount.com;"
                + "OAuthPvtKey=RedactedKey;",
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
        BigQueryJdbcOAuthUtility.parseOAuthProperties(connectionString, null);
    Map<String, String> overrideProperties =
        BigQueryJdbcUrlUtility.parseOverrideProperties(connectionString, null);

    try {
      BigQueryJdbcOAuthUtility.getCredentials(oauthProperties, overrideProperties, null);
      Assert.fail();
    } catch (BigQueryJdbcRuntimeException e) {
      assertThat(e.getMessage()).contains("java.net.URISyntaxException");
    }
  }

  @Test
  public void testParseOAuthPropsForAuthType2() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;"
                + "OAuthAccessToken=RedactedToken;",
            null);

    assertThat(result.get("OAuthType")).isEqualTo("PRE_GENERATED_TOKEN");
    assertThat(result.get("OAuthAccessToken")).isEqualTo("RedactedToken");
  }

  @Test
  public void testParseOAuthPropsForAuthType3() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=3;ProjectId=MyBigQueryProject;",
            null);

    assertThat(result.get("OAuthType")).isEqualTo("APPLICATION_DEFAULT_CREDENTIALS");
  }

  @Test
  public void testParseOAuthPropsForDefaultAuthType() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "ProjectId=MyBigQueryProject;OAuthType=3",
            null);

    assertThat(result.get("OAuthType")).isEqualTo("APPLICATION_DEFAULT_CREDENTIALS");
  }

  @Test
  public void testGetCredentialsForPreGeneratedToken() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;"
                + "OAuthAccessToken=RedactedToken;",
            null);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(authProperties, Collections.EMPTY_MAP, null);
    assertThat(credentials).isNotNull();
  }

  @Test
  public void testGetCredentialsForPreGeneratedTokenTPC() throws IOException {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;"
                + "OAuthAccessToken=RedactedToken;"
                + "universeDomain=testDomain;",
            null);
    Map<String, String> stringStringMap = new HashMap<>();
    stringStringMap.put(
        BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, "testDomain");
    Map<String, String> overrideProperties = new HashMap<>(stringStringMap);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(authProperties, overrideProperties, null);
    assertThat(credentials.getUniverseDomain()).isEqualTo("testDomain");
  }

  @Test
  @Ignore // For running locally only similar to our other JDBC tests.
  public void testGetCredentialsForApplicationDefault() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=3;ProjectId=MyBigQueryProject;",
            null);

    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(authProperties, null, null);
    assertThat(credentials).isNotNull();
  }

  @Test
  public void testParseOAuthPropsForUserAuth() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=1;ProjectId=MyBigQueryProject;"
                + "OAuthClientId=client;OAuthClientSecret=secret;",
            null);

    assertThat(authProperties.get("OAuthType")).isEqualTo("GOOGLE_USER_ACCOUNT");
    assertThat(authProperties.get("OAuthClientId")).isEqualTo("client");
    assertThat(authProperties.get("OAuthClientSecret")).isEqualTo("secret");
  }

  @Test
  public void testGenerateUserAuthURL() {
    try {
      HashMap<String, String> authProperties = new HashMap<>();
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "client_id");
      authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "client_secret");

      UserAuthorizer userAuthorizer =
          BigQueryJdbcOAuthUtility.getUserAuthorizer(
              authProperties, new HashMap<String, String>(), USER_AUTH_PORT, null);

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
          BigQueryJdbcOAuthUtility.parseOAuthProperties(connectionString, null);
      Map<String, String> overrideProperties =
          BigQueryJdbcUrlUtility.parseOverrideProperties(connectionString, null);

      UserAuthorizer userAuthorizer =
          BigQueryJdbcOAuthUtility.getUserAuthorizer(
              authProperties, overrideProperties, USER_AUTH_PORT, null);

      assertThat(overrideTokenSeverURI).isEqualTo(userAuthorizer.toBuilder().getTokenServerUri());
    } catch (URISyntaxException e) {
      throw new RuntimeException(e);
    }
  }

  @Test
  public void testParseOAuthPropsForRefreshToken() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
                + "OAuthType=2;ProjectId=MyBigQueryProject;OAuthRefreshToken=token;"
                + "OAuthClientId=client;OAuthClientSecret=secret;",
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
          BigQueryJdbcOAuthUtility.parseOAuthProperties(connectionString, null);
      Map<String, String> overrideProperties =
          BigQueryJdbcUrlUtility.parseOverrideProperties(connectionString, null);

      UserCredentials userCredentials =
          BigQueryJdbcOAuthUtility.getPreGeneratedRefreshTokenCredentials(
              authProperties, overrideProperties, null);

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
            "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:433;OAuthType=4;"
                + "ProjectId=MyBigQueryProject;"
                + "BYOID_AudienceUri=//iam.googleapis.com/locations/global/workforcePools/pool-id/providers/provider-id;"
                + "BYOID_PoolUserProject=workforceProjectNumber;"
                + "BYOID_CredentialSource={\"file\": \"C:\\\\Token.txt\"};"
                + "BYOID_SA_Impersonation_Uri=testSA;"
                + "BYOID_SubjectTokenType=urn:ietf:params:oauth:tokentype:jwt;"
                + "BYOID_TokenUri=https://testuri.com/v1/token",
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
  public void testParseOAuthProperties_UserAccount_RequestDriveScopeEnabled() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=1;OAuthClientId=redactedClientId;OAuthClientSecret=redactedClientSecret;"
            + "RequestGoogleDriveScope=1;";
    Map<String, String> properties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(url, this.getClass().getName());
    assertEquals(
        String.valueOf(BigQueryJdbcOAuthUtility.AuthType.GOOGLE_USER_ACCOUNT),
        properties.get(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME));
    assertEquals(
        "redactedClientId", properties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME));
    assertEquals(
        "redactedClientSecret",
        properties.get(BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME));
    assertEquals(
        "1", properties.get(BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME));
  }

  @Test
  public void testParseOAuthProperties_UserAccount_RequestDriveScopeDisabled() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=1;OAuthClientId=redactedClientId;OAuthClientSecret=redactedClientSecret;"
            + "RequestGoogleDriveScope=0;";
    Map<String, String> properties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(url, this.getClass().getName());
    assertEquals(
        "0", properties.get(BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME));
  }

  @Test
  public void testParseOAuthProperties_UserAccount_RequestDriveScopeDefault() {
    String url =
        "jdbc:bigquery://https://www.googleapis.com/bigquery/v2:443;"
            + "OAuthType=1;OAuthClientId=redactedClientId;OAuthClientSecret=redactedClientSecret;";
    Map<String, String> properties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(url, this.getClass().getName());
    assertEquals(
        String.valueOf(BigQueryJdbcUrlUtility.DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE),
        properties.get(BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME));
  }

  @Test
  public void testGetUserAuthorizer_WithDriveScope() throws URISyntaxException {
    Map<String, String> authProperties = new HashMap<>();
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "redactedClientId");
    authProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "redactedClientSecret");
    authProperties.put(BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME, "1");

    UserAuthorizer authorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties, Collections.emptyMap(), 12345, this.getClass().getName());

    assertTrue(authorizer.getScopes().contains("https://www.googleapis.com/auth/bigquery"));
    assertTrue(authorizer.getScopes().contains("https://www.googleapis.com/auth/drive.readonly"));
    assertEquals(2, authorizer.getScopes().size());
  }

  @Test
  public void testGetUserAuthorizer_WithoutDriveScope() throws URISyntaxException {
    Map<String, String> authProperties = new HashMap<>();
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "redactedClientId");
    authProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "redactedClientSecret");
    authProperties.put(BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME, "0");

    UserAuthorizer authorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties, Collections.emptyMap(), 12345, this.getClass().getName());
    assertTrue(authorizer.getScopes().contains("https://www.googleapis.com/auth/bigquery"));
    assertFalse(authorizer.getScopes().contains("https://www.googleapis.com/auth/drive.readonly"));
    assertEquals(1, authorizer.getScopes().size());
  }

  @Test
  public void testGetUserAuthorizer_InvalidDriveScopeValue() throws URISyntaxException {
    Map<String, String> authProperties = new HashMap<>();
    authProperties.put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, "redactedClientId");
    authProperties.put(
        BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, "redactedClientSecret");
    authProperties.put(
        BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME, "invalid_value");
    UserAuthorizer authorizer =
        BigQueryJdbcOAuthUtility.getUserAuthorizer(
            authProperties, Collections.emptyMap(), 12345, this.getClass().getName());
    assertFalse(authorizer.getScopes().contains("https://www.googleapis.com/auth/drive.readonly"));
  }

  @Test
  public void testParseUserImpersonationDefault() {
    String connectionUri =
        getUriOAuthServiceAccount()
            .append("ServiceAccountImpersonationEmail", "impersonated")
            .toString();
    Map<String, String> result = BigQueryJdbcOAuthUtility.parseOAuthProperties(connectionUri, "");
    assertEquals(
        "impersonated",
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME));
    assertEquals(
        BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_SCOPES_VALUE,
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME));
    assertEquals(
        BigQueryJdbcUrlUtility.DEFAULT_OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_VALUE,
        result.get(BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME));
  }

  @Test
  public void testParseUserImpersonationNonDefault() {
    Map<String, String> result =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            getUriOAuthServiceAccount()
                .append("ServiceAccountImpersonationEmail", "impersonated")
                .append("ServiceAccountImpersonationScopes", "scopes")
                .append("ServiceAccountImpersonationTokenLifetime", 300)
                .toString(),
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
  public void testGetServiceAccountImpersonatedCredentials() {
    Map<String, String> authProperties =
        BigQueryJdbcOAuthUtility.parseOAuthProperties(
            getUriOAuthServiceAccount()
                .append("ServiceAccountImpersonationEmail", "impersonated")
                .toString(),
            "");
    GoogleCredentials credentials =
        BigQueryJdbcOAuthUtility.getCredentials(authProperties, Collections.EMPTY_MAP, null);
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
  public void testPrivateKeyFromP12File() {
    URL resource = BigQueryJdbcOAuthUtilityTest.class.getResource("/fake.p12");
    try {
      PrivateKey pk =
          BigQueryJdbcOAuthUtility.privateKeyFromP12File(
              Paths.get(resource.toURI()).toAbsolutePath().toString(), "notasecret");
      assertNotNull(pk);
    } catch (Exception e) {
      assertTrue(false);
    }
  }

  @Test
  public void testPrivateKeyFromP12File_missing_file() {
    PrivateKey pk = BigQueryJdbcOAuthUtility.privateKeyFromP12File("", "");
    assertNull(pk);
  }

  @Test
  public void testPrivateKeyFromP12File_wrong_password() {
    URL resource = BigQueryJdbcOAuthUtilityTest.class.getResource("/fake.p12");
    try {
      PrivateKey pk =
          BigQueryJdbcOAuthUtility.privateKeyFromP12File(
              Paths.get(resource.toURI()).toAbsolutePath().toString(), "fake");
      assertNull(pk);
    } catch (Exception e) {
      assertTrue(false);
    }
  }
}
