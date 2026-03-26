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

package com.google.auth.oauth2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.json.webtoken.JsonWebSignature;
import com.google.api.client.json.webtoken.JsonWebToken;
import com.google.api.client.testing.http.FixedClock;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.client.util.Clock;
import com.google.api.client.util.Joiner;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.TestUtils;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.oauth2.GoogleCredentials.GoogleCredentialsInfo;
import com.google.common.collect.ImmutableSet;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.SignatureException;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.junit.jupiter.api.Test;

/** Test case for {@link ServiceAccountCredentials}. */
class ServiceAccountCredentialsTest extends BaseSerializationTest {

  static final String CLIENT_EMAIL =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr@developer.gserviceaccount.com";
  private static final String CLIENT_ID =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr.apps.googleusercontent.com";
  private static final String PRIVATE_KEY_ID = "d84a4fefcf50791d4a90f2d7af17469d6282df9d";
  static final String PRIVATE_KEY_PKCS8 =
      "-----BEGIN PRIVATE KEY-----\n"
          + "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBALX0PQoe1igW12i"
          + "kv1bN/r9lN749y2ijmbc/mFHPyS3hNTyOCjDvBbXYbDhQJzWVUikh4mvGBA07qTj79Xc3yBDfKP2IeyYQIFe0t0"
          + "zkd7R9Zdn98Y2rIQC47aAbDfubtkU1U72t4zL11kHvoa0/RuFZjncvlr42X7be7lYh4p3NAgMBAAECgYASk5wDw"
          + "4Az2ZkmeuN6Fk/y9H+Lcb2pskJIXjrL533vrDWGOC48LrsThMQPv8cxBky8HFSEklPpkfTF95tpD43iVwJRB/Gr"
          + "CtGTw65IfJ4/tI09h6zGc4yqvIo1cHX/LQ+SxKLGyir/dQM925rGt/VojxY5ryJR7GLbCzxPnJm/oQJBANwOCO6"
          + "D2hy1LQYJhXh7O+RLtA/tSnT1xyMQsGT+uUCMiKS2bSKx2wxo9k7h3OegNJIu1q6nZ6AbxDK8H3+d0dUCQQDTrP"
          + "SXagBxzp8PecbaCHjzNRSQE2in81qYnrAFNB4o3DpHyMMY6s5ALLeHKscEWnqP8Ur6X4PvzZecCWU9BKAZAkAut"
          + "LPknAuxSCsUOvUfS1i87ex77Ot+w6POp34pEX+UWb+u5iFn2cQacDTHLV1LtE80L8jVLSbrbrlH43H0DjU5AkEA"
          + "gidhycxS86dxpEljnOMCw8CKoUBd5I880IUahEiUltk7OLJYS/Ts1wbn3kPOVX3wyJs8WBDtBkFrDHW2ezth2QJ"
          + "ADj3e1YhMVdjJW5jqwlD/VNddGjgzyunmiZg0uOXsHXbytYmsA545S8KRQFaJKFXYYFo2kOjqOiC1T2cAzMDjCQ"
          + "==\n-----END PRIVATE KEY-----\n";
  static final String ACCESS_TOKEN = "1/MkSJoj1xsli0AccessToken_NKPY2";
  static final Collection<String> SCOPES = Collections.singletonList("dummy.scope");
  private static final Collection<String> DEFAULT_SCOPES =
      Collections.singletonList("dummy.default.scope");
  private static final String USER = "user@example.com";
  private static final String PROJECT_ID = "project-id";
  private static final Collection<String> EMPTY_SCOPES = Collections.emptyList();
  static final URI CALL_URI = URI.create("http://googleapis.com/testapi/v1/foo");
  private static final String JWT_AUDIENCE = "http://googleapis.com/";
  private static final HttpTransportFactory DUMMY_TRANSPORT_FACTORY =
      new MockTokenServerTransportFactory();
  public static final String DEFAULT_ID_TOKEN =
      "eyJhbGciOiJSUzI1NiIsImtpZCI6ImRmMzc1ODkwOGI3OTIyO"
          + "TNhZDk3N2EwYjk5MWQ5OGE3N2Y0ZWVlY2QiLCJ0eXAiOiJKV1QifQ.eyJhdWQiOiJodHRwczovL2Zvby5iYXIiL"
          + "CJhenAiOiIxMDIxMDE1NTA4MzQyMDA3MDg1NjgiLCJleHAiOjE1NjQ0NzUwNTEsImlhdCI6MTU2NDQ3MTQ1MSwi"
          + "aXNzIjoiaHR0cHM6Ly9hY2NvdW50cy5nb29nbGUuY29tIiwic3ViIjoiMTAyMTAxNTUwODM0MjAwNzA4NTY4In0"
          + ".redacted";
  private static final String QUOTA_PROJECT = "sample-quota-project-id";
  private static final int DEFAULT_LIFETIME_IN_SECONDS = 3600;
  private static final int INVALID_LIFETIME = 43210;
  private static final String JWT_ACCESS_PREFIX = "Bearer ";

  static ServiceAccountCredentials.Builder createDefaultBuilderWithToken(String accessToken)
      throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, accessToken);
    return createDefaultBuilder().setHttpTransportFactory(transportFactory);
  }

  private static ServiceAccountCredentials.Builder createDefaultBuilderWithScopes(
      Collection<String> scopes) throws IOException {
    return createDefaultBuilder().setScopes(scopes);
  }

  private static ServiceAccountCredentials.Builder createDefaultBuilderWithKey(
      PrivateKey privateKey) {
    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setProjectId(PROJECT_ID)
            .setQuotaProjectId(QUOTA_PROJECT)
            .setHttpTransportFactory(new MockHttpTransportFactory());

    return builder;
  }

  static ServiceAccountCredentials.Builder createDefaultBuilder() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    return createDefaultBuilderWithKey(privateKey);
  }

  @Test
  void setLifetime() throws IOException {
    ServiceAccountCredentials.Builder builder = createDefaultBuilder();
    assertEquals(DEFAULT_LIFETIME_IN_SECONDS, builder.getLifetime());
    assertEquals(DEFAULT_LIFETIME_IN_SECONDS, builder.build().getLifetime());

    builder.setLifetime(4000);
    assertEquals(4000, builder.getLifetime());
    assertEquals(4000, builder.build().getLifetime());

    builder.setLifetime(0);
    assertEquals(DEFAULT_LIFETIME_IN_SECONDS, builder.build().getLifetime());
  }

  @Test
  void setLifetime_invalid_lifetime() throws IOException, IllegalStateException {
    try {
      createDefaultBuilder().setLifetime(INVALID_LIFETIME).build();
      fail(
          String.format(
              "Should throw exception with message containing '%s'",
              "lifetime must be less than or equal to 43200"));
    } catch (IllegalStateException expected) {
      assertTrue(expected.getMessage().contains("lifetime must be less than or equal to 43200"));
    }
  }

  @Test
  void createWithCustomLifetime() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().build();
    credentials = credentials.createWithCustomLifetime(4000);
    assertEquals(4000, credentials.getLifetime());
  }

  @Test
  void createdScoped_clones() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    ServiceAccountCredentials credentials =
        createDefaultBuilderWithKey(privateKey)
            .setServiceAccountUser(USER)
            .setScopes(SCOPES)
            .build();
    List<String> newScopes = Arrays.asList("scope1", "scope2");

    ServiceAccountCredentials newCredentials =
        (ServiceAccountCredentials) credentials.createScoped(newScopes);

    assertEquals(CLIENT_ID, newCredentials.getClientId());
    assertEquals(CLIENT_EMAIL, newCredentials.getClientEmail());
    assertEquals(privateKey, newCredentials.getPrivateKey());
    assertEquals(PRIVATE_KEY_ID, newCredentials.getPrivateKeyId());
    assertArrayEquals(newScopes.toArray(), newCredentials.getScopes().toArray());
    assertEquals(USER, newCredentials.getServiceAccountUser());
    assertEquals(PROJECT_ID, newCredentials.getProjectId());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, newCredentials.getUniverseDomain());

    assertArrayEquals(
        SCOPES.toArray(), ((ServiceAccountCredentials) credentials).getScopes().toArray());
  }

  @Test
  void createdDelegated_clones() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    ServiceAccountCredentials credentials =
        createDefaultBuilderWithKey(privateKey)
            .setScopes(SCOPES)
            .setServiceAccountUser(USER)
            .build();
    String newServiceAccountUser = "stranger@other.org";

    ServiceAccountCredentials newCredentials =
        (ServiceAccountCredentials) credentials.createDelegated(newServiceAccountUser);

    assertEquals(CLIENT_ID, newCredentials.getClientId());
    assertEquals(CLIENT_EMAIL, newCredentials.getClientEmail());
    assertEquals(privateKey, newCredentials.getPrivateKey());
    assertEquals(PRIVATE_KEY_ID, newCredentials.getPrivateKeyId());
    assertArrayEquals(SCOPES.toArray(), newCredentials.getScopes().toArray());
    assertEquals(newServiceAccountUser, newCredentials.getServiceAccountUser());
    assertEquals(PROJECT_ID, newCredentials.getProjectId());
    assertEquals(QUOTA_PROJECT, newCredentials.getQuotaProjectId());

    assertEquals(USER, ((ServiceAccountCredentials) credentials).getServiceAccountUser());
  }

  @Test
  void createAssertion_correct() throws IOException {
    List<String> scopes = Arrays.asList("scope1", "scope2");
    ServiceAccountCredentials.Builder builder = createDefaultBuilderWithScopes(scopes);
    ServiceAccountCredentials credentials = builder.setServiceAccountUser(USER).build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion = credentials.createAssertion(jsonFactory, currentTimeMillis);

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(CLIENT_EMAIL, payload.getIssuer());
    assertEquals(OAuth2Utils.TOKEN_SERVER_URI.toString(), payload.getAudience());
    assertEquals(currentTimeMillis / 1000, (long) payload.getIssuedAtTimeSeconds());
    assertEquals(currentTimeMillis / 1000 + 3600, (long) payload.getExpirationTimeSeconds());
    assertEquals(USER, payload.getSubject());
    assertEquals(Joiner.on(' ').join(scopes), payload.get("scope"));
  }

  @Test
  void createAssertion_defaultScopes_correct() throws IOException {
    List<String> defaultScopes = Arrays.asList("scope1", "scope2");
    ServiceAccountCredentials.Builder builder = createDefaultBuilder();
    builder.setScopes(null, defaultScopes).setServiceAccountUser(USER);

    assertEquals(2, builder.getDefaultScopes().size());
    ServiceAccountCredentials credentials = builder.build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion = credentials.createAssertion(jsonFactory, currentTimeMillis);

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(CLIENT_EMAIL, payload.getIssuer());
    assertEquals(OAuth2Utils.TOKEN_SERVER_URI.toString(), payload.getAudience());
    assertEquals(currentTimeMillis / 1000, (long) payload.getIssuedAtTimeSeconds());
    assertEquals(currentTimeMillis / 1000 + 3600, (long) payload.getExpirationTimeSeconds());
    assertEquals(USER, payload.getSubject());
    assertEquals(Joiner.on(' ').join(defaultScopes), payload.get("scope"));
  }

  @Test
  void createAssertion_custom_lifetime() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().setLifetime(4000).build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion = credentials.createAssertion(jsonFactory, currentTimeMillis);

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(currentTimeMillis / 1000 + 4000, (long) payload.getExpirationTimeSeconds());
  }

  @Test
  void createAssertionForIdToken_correct() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    ServiceAccountCredentials credentials =
        createDefaultBuilder()
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setServiceAccountUser(USER)
            .setProjectId(PROJECT_ID)
            .build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion =
        credentials.createAssertionForIdToken(currentTimeMillis, null, "https://foo.com/bar");

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(CLIENT_EMAIL, payload.getIssuer());
    assertEquals("https://foo.com/bar", (String) (payload.getUnknownKeys().get("target_audience")));
    assertEquals(currentTimeMillis / 1000, (long) payload.getIssuedAtTimeSeconds());
    assertEquals(currentTimeMillis / 1000 + 3600, (long) payload.getExpirationTimeSeconds());
    assertEquals(USER, payload.getSubject());
  }

  @Test
  void createAssertionForIdToken_custom_lifetime() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().setLifetime(4000).build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion =
        credentials.createAssertionForIdToken(currentTimeMillis, null, "https://foo.com/bar");

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(currentTimeMillis / 1000 + 4000, (long) payload.getExpirationTimeSeconds());
  }

  @Test
  void createAssertionForIdToken_incorrect() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setServiceAccountUser(USER)
            .setProjectId(PROJECT_ID)
            .build();

    JsonFactory jsonFactory = OAuth2Utils.JSON_FACTORY;
    long currentTimeMillis = Clock.SYSTEM.currentTimeMillis();
    String assertion =
        credentials.createAssertionForIdToken(currentTimeMillis, null, "https://foo.com/bar");

    JsonWebSignature signature = JsonWebSignature.parse(jsonFactory, assertion);
    JsonWebToken.Payload payload = signature.getPayload();
    assertEquals(CLIENT_EMAIL, payload.getIssuer());
    assertNotEquals(
        "https://bar.com/foo", (String) (payload.getUnknownKeys().get("target_audience")));
    assertEquals(currentTimeMillis / 1000, (long) payload.getIssuedAtTimeSeconds());
    assertEquals(currentTimeMillis / 1000 + 3600, (long) payload.getExpirationTimeSeconds());
    assertEquals(USER, payload.getSubject());
  }

  @Test
  void createdScoped_withAud_noUniverse_jwtWithScopesDisabled_accessToken() throws IOException {
    GoogleCredentials credentials = createDefaultBuilderWithToken(ACCESS_TOKEN).build();

    // No aud, no scopes gives an exception.
    try {
      credentials.getRequestMetadata(null);
      fail("Should not be able to get token without scopes");
    } catch (IOException e) {
      assertTrue(
          e.getMessage().contains("Scopes and uri are not configured for service account"),
          "expected to fail with exception");
    }

    GoogleCredentials scopedCredentials = credentials.createScoped(SCOPES);
    assertEquals(false, credentials.isExplicitUniverseDomain());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
    Map<String, List<String>> metadata = scopedCredentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void createdScoped_withUniverse_selfSignedJwt() throws IOException {
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setUniverseDomain("foo.bar").build();

    try {
      credentials.getRequestMetadata(null);
      fail("Should not be able to get token without scopes");
    } catch (IOException e) {
      assertTrue(
          e.getMessage().contains("Scopes and uri are not configured for service account"),
          "expected to fail with exception");
    }

    GoogleCredentials scopedCredentials = credentials.createScoped("dummy.scope");
    Map<String, List<String>> metadata = scopedCredentials.getRequestMetadata(null);
    verifyJwtAccess(metadata, "dummy.scope");

    // Recreate to avoid jwt caching.
    scopedCredentials = credentials.createScoped("dummy.scope2");
    assertEquals(true, scopedCredentials.isExplicitUniverseDomain());
    assertEquals("foo.bar", scopedCredentials.getUniverseDomain());
    metadata = scopedCredentials.getRequestMetadata(CALL_URI);
    verifyJwtAccess(metadata, "dummy.scope2");

    // Recreate to avoid jwt caching.
    scopedCredentials =
        credentials.createScoped(
            Collections.<String>emptyList(), Arrays.asList("dummy.default.scope"));
    metadata = scopedCredentials.getRequestMetadata(null);
    verifyJwtAccess(metadata, "dummy.default.scope");

    // Recreate to avoid jwt caching.
    scopedCredentials =
        credentials.createScoped(
            Collections.<String>emptyList(), Arrays.asList("dummy.default.scope2"));
    metadata = scopedCredentials.getRequestMetadata(CALL_URI);
    verifyJwtAccess(metadata, "dummy.default.scope2");
  }

  @Test
  void noScopes_withUniverse_selfSignedJwt() throws IOException {
    GoogleCredentials credentials = createDefaultBuilder().setUniverseDomain("foo.bar").build();

    try {
      credentials.getRequestMetadata(null);
      fail("Should not be able to get token without scopes");
    } catch (IOException e) {
      assertTrue(
          e.getMessage().contains("Scopes and uri are not configured for service account"),
          "expected to fail with exception");
    }

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertNull(((ServiceAccountCredentials) credentials).getSelfSignedJwtCredentialsWithScope());
    verifyJwtAccess(metadata, null);
  }

  @Test
  void createdScoped_defaultScopes() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();

    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID, SCOPES, DEFAULT_SCOPES);
    assertEquals(1, credentials.getDefaultScopes().size());
    assertEquals("dummy.default.scope", credentials.getDefaultScopes().toArray()[0]);

    credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            DEFAULT_SCOPES,
            transportFactory,
            null);
    assertEquals(1, credentials.getDefaultScopes().size());
    assertEquals("dummy.default.scope", credentials.getDefaultScopes().toArray()[0]);

    credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            DEFAULT_SCOPES,
            transportFactory,
            null,
            "service_account_user");
    assertEquals(1, credentials.getDefaultScopes().size());
    assertEquals("dummy.default.scope", credentials.getDefaultScopes().toArray()[0]);
  }

  @Test
  void createScopedRequired_emptyScopes() throws IOException {
    GoogleCredentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID, EMPTY_SCOPES);

    assertTrue(credentials.createScopedRequired());
  }

  @Test
  void createScopedRequired_nonEmptyScopes() throws IOException {
    GoogleCredentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID, SCOPES);

    assertFalse(credentials.createScopedRequired());
  }

  @Test
  void createScopedRequired_nonEmptyDefaultScopes() throws IOException {
    GoogleCredentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID, null, SCOPES);

    assertFalse(credentials.createScopedRequired());
  }

  @Test
  void fromJSON_getProjectId() throws IOException {
    GenericJson json = writeServiceAccountJson(PROJECT_ID, null, null);

    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromJson(json, new MockTokenServerTransportFactory());
    assertEquals(PROJECT_ID, credentials.getProjectId());
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void fromJSON_Universe_getUniverseDomain() throws IOException {
    GenericJson json = writeServiceAccountJson(PROJECT_ID, null, "foo.bar");

    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromJson(json, new MockTokenServerTransportFactory());
    assertEquals("foo.bar", credentials.getUniverseDomain());
  }

  @Test
  void fromJSON_getProjectIdNull() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GenericJson json = writeServiceAccountJson(null, null, null);

    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromJson(json, transportFactory);
    assertNull(credentials.getProjectId());
  }

  @Test
  void fromJSON_hasAccessToken() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GenericJson json = writeServiceAccountJson(PROJECT_ID, null, null);

    GoogleCredentials credentials = ServiceAccountCredentials.fromJson(json, transportFactory);

    credentials = credentials.createScoped(SCOPES);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void fromJSON_withUniverse_selfSignedJwt() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GenericJson json = writeServiceAccountJson(PROJECT_ID, null, "foo.bar");

    GoogleCredentials credentials = ServiceAccountCredentials.fromJson(json, transportFactory);

    credentials = credentials.createScoped(SCOPES);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(null);
    verifyJwtAccess(metadata, "dummy.scope");
  }

  @Test
  void fromJSON_tokenServerUri() throws IOException {
    final String tokenServerUri = "https://foo.com/bar";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GenericJson json = writeServiceAccountJson(PROJECT_ID, null, null);
    json.put("token_uri", tokenServerUri);
    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromJson(json, transportFactory);
    assertEquals(URI.create(tokenServerUri), credentials.getTokenServerUri());
  }

  @Test
  void fromJson_hasQuotaProjectId() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GenericJson json = writeServiceAccountJson(PROJECT_ID, QUOTA_PROJECT, null);
    GoogleCredentials credentials = ServiceAccountCredentials.fromJson(json, transportFactory);
    credentials = credentials.createScoped(SCOPES);

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    assertTrue(metadata.containsKey(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY));
    assertEquals(
        metadata.get(GoogleCredentials.QUOTA_PROJECT_ID_HEADER_KEY),
        Collections.singletonList(QUOTA_PROJECT));
  }

  @Test
  void getRequestMetadata_hasAccessToken() throws IOException {
    GoogleCredentials credentials =
        createDefaultBuilderWithToken(ACCESS_TOKEN).setScopes(SCOPES).build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void getRequestMetadata_customTokenServer_hasAccessToken() throws IOException {
    final URI TOKEN_SERVER = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    transportFactory.transport.setTokenServerUri(TOKEN_SERVER);
    OAuth2Credentials credentials =
        createDefaultBuilder()
            .setScopes(SCOPES)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(TOKEN_SERVER)
            .build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);

    // verify header
    Map<String, List<String>> accessTokenRequestHeader =
        transportFactory.transport.getRequest().getHeaders();
    com.google.auth.oauth2.TestUtils.validateMetricsHeader(accessTokenRequestHeader, "at", "sa");
  }

  @Test
  void getUniverseDomain_defaultUniverse() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().build();
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, credentials.getUniverseDomain());
  }

  @Test
  void refreshAccessToken_refreshesToken() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();
    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
    credentials.refresh();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken2);
  }

  @Test
  void refreshAccessToken_tokenExpiry() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();
    credentials.clock = new FixedClock(0L);

    AccessToken accessToken = credentials.refreshAccessToken();
    assertEquals(ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(3600 * 1000L, accessToken.getExpirationTimeMillis().longValue());

    // Test for large expires_in values (should not overflow).
    transport.setExpiresInSeconds(3600 * 1000);
    accessToken = credentials.refreshAccessToken();
    assertEquals(ACCESS_TOKEN, accessToken.getTokenValue());
    assertEquals(3600 * 1000 * 1000L, accessToken.getExpirationTimeMillis().longValue());
  }

  @Test
  void refreshAccessToken_IOException_Retry() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();
    ;

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    transport.addResponseErrorSequence(new IOException());
    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
    credentials.refresh();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken2);
  }

  @Test
  void refreshAccessToken_retriesServerErrors() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    MockLowLevelHttpResponse response500 = new MockLowLevelHttpResponse().setStatusCode(500);
    MockLowLevelHttpResponse response503 = new MockLowLevelHttpResponse().setStatusCode(503);
    transport.addResponseSequence(response500, response503);
    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
    credentials.refresh();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken2);
  }

  @Test
  void refreshAccessToken_retriesTimeoutAndThrottled() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    MockLowLevelHttpResponse response408 = new MockLowLevelHttpResponse().setStatusCode(408);
    MockLowLevelHttpResponse response429 = new MockLowLevelHttpResponse().setStatusCode(429);
    transport.addResponseSequence(response408, response429);
    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
    credentials.refresh();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken2);
  }

  @Test
  void refreshAccessToken_defaultRetriesDisabled() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder()
            .setScopes(SCOPES)
            .setHttpTransportFactory(transportFactory)
            .build()
            .createWithCustomRetryStrategy(false);

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    MockLowLevelHttpResponse response408 = new MockLowLevelHttpResponse().setStatusCode(408);
    MockLowLevelHttpResponse response429 = new MockLowLevelHttpResponse().setStatusCode(429);
    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);

    try {
      transport.addResponseSequence(response408, response429);
      credentials.refresh();
      fail("Should not be able to use credential without exception.");
    } catch (GoogleAuthException ex) {
      assertTrue(ex.getMessage().contains("Error getting access token for service account: 408"));
      assertTrue(ex.isRetryable());
      assertEquals(0, ex.getRetryCount());
    }
  }

  @Test
  void refreshAccessToken_maxRetries_maxDelay() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), ACCESS_TOKEN);

    MockLowLevelHttpResponse response408 = new MockLowLevelHttpResponse().setStatusCode(408);
    MockLowLevelHttpResponse response429 = new MockLowLevelHttpResponse().setStatusCode(429);
    MockLowLevelHttpResponse response500 = new MockLowLevelHttpResponse().setStatusCode(500);
    MockLowLevelHttpResponse response503 = new MockLowLevelHttpResponse().setStatusCode(503);

    Instant start = Instant.now();
    try {
      transport.addResponseSequence(response408, response429, response500, response503);
      credentials.refresh();
      fail("Should not be able to use credential without exception.");
    } catch (GoogleAuthException ex) {
      Instant finish = Instant.now();
      long timeElapsed = Duration.between(start, finish).toMillis();

      // we expect max retry time of 7 sec +/- jitter
      assertTrue(timeElapsed > 5500 && timeElapsed < 10000);
      assertTrue(ex.getMessage().contains("Error getting access token for service account: 503"));
      assertTrue(ex.isRetryable());
      assertEquals(3, ex.getRetryCount());
      assertTrue(ex.getCause() instanceof HttpResponseException);
    }
  }

  @Test
  void refreshAccessToken_RequestFailure_retried() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), ACCESS_TOKEN);

    IOException error = new IOException("Invalid grant: Account not found");
    MockLowLevelHttpResponse response503 = new MockLowLevelHttpResponse().setStatusCode(503);

    Instant start = Instant.now();
    try {
      transport.addResponseSequence(response503);
      transport.addResponseErrorSequence(error, error, error);
      credentials.refresh();
      fail("Should not be able to use credential without exception.");
    } catch (GoogleAuthException ex) {
      Instant finish = Instant.now();
      long timeElapsed = Duration.between(start, finish).toMillis();

      // we expect max retry time of 7 sec +/- jitter
      assertTrue(timeElapsed > 5500 && timeElapsed < 10000);
      assertTrue(
          ex.getMessage()
              .contains("Error getting access token for service account: Invalid grant"));
      assertTrue(ex.isRetryable());
      assertEquals(3, ex.getRetryCount());
      assertTrue(ex.getCause() instanceof IOException);
    }
  }

  @Test
  void refreshAccessToken_4xx_5xx_NonRetryableFails() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    for (int status = 400; status < 600; status++) {
      if (OAuth2Utils.TOKEN_ENDPOINT_RETRYABLE_STATUS_CODES.contains(status)) {
        continue;
      }

      MockLowLevelHttpResponse mockResponse = new MockLowLevelHttpResponse().setStatusCode(status);
      try {
        transport.addResponseSequence(mockResponse);
        transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
        credentials.refresh();
        fail("Should not be able to use credential without exception.");
      } catch (GoogleAuthException ex) {
        assertFalse(ex.isRetryable());
        assertEquals(0, ex.getRetryCount());
      }
    }
  }

  @Test
  void idTokenWithAudience_oauthFlow_targetAudienceMatchesAudClaim() throws IOException {
    String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    // verify access token request metrics headers
    Map<String, List<String>> accessTokenRequestHeader =
        transportFactory.transport.getRequest().getHeaders();
    com.google.auth.oauth2.TestUtils.validateMetricsHeader(accessTokenRequestHeader, "at", "sa");

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    assertEquals(DEFAULT_ID_TOKEN, tokenCredential.getAccessToken().getTokenValue());
    assertEquals(DEFAULT_ID_TOKEN, tokenCredential.getIdToken().getTokenValue());

    // ID Token's aud claim is `https://foo.bar`
    assertEquals(
        targetAudience,
        tokenCredential.getIdToken().getJsonWebSignature().getPayload().getAudience());

    // verify ID token request metrics headers
    Map<String, List<String>> idTokenRequestHeader =
        transportFactory.transport.getRequest().getHeaders();
    com.google.auth.oauth2.TestUtils.validateMetricsHeader(idTokenRequestHeader, "it", "sa");
  }

  @Test
  void idTokenWithAudience_oauthFlow_targetAudienceDoesNotMatchAudClaim() throws IOException {
    String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken1);

    String targetAudience = "differentAudience";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    // ID Token's aud claim is `https://foo.bar`
    assertNotEquals(
        targetAudience,
        tokenCredential.getIdToken().getJsonWebSignature().getPayload().getAudience());
  }

  @Test
  void idTokenWithAudience_iamFlow_targetAudienceMatchesAudClaim() throws IOException {
    String nonGDU = "test.com";
    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory(nonGDU);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory.getTransport().setIdToken(DEFAULT_ID_TOKEN);
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    ServiceAccountCredentials credentials =
        createDefaultBuilder()
            .setScopes(SCOPES)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(nonGDU)
            .build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    assertEquals(DEFAULT_ID_TOKEN, tokenCredential.getAccessToken().getTokenValue());
    assertEquals(DEFAULT_ID_TOKEN, tokenCredential.getIdToken().getTokenValue());

    // ID Token's aud claim is `https://foo.bar`
    assertEquals(
        targetAudience,
        tokenCredential.getIdToken().getJsonWebSignature().getPayload().getAudience());
  }

  @Test
  void idTokenWithAudience_iamFlow_targetAudienceDoesNotMatchAudClaim() throws IOException {
    String nonGDU = "test.com";
    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory(nonGDU);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory.getTransport().setIdToken(DEFAULT_ID_TOKEN);
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    ServiceAccountCredentials credentials =
        createDefaultBuilder()
            .setScopes(SCOPES)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(nonGDU)
            .build();

    String targetAudience = "differentAudience";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    // ID Token's aud claim is `https://foo.bar`
    assertNotEquals(
        targetAudience,
        tokenCredential.getIdToken().getJsonWebSignature().getPayload().getAudience());
  }

  @Test
  void idTokenWithAudience_oauthEndpoint_non2XXStatusCode() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.setError(new IOException("404 Not Found"));
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    String targetAudience = "audience";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();

    // Ensure that a non 2xx status code returns an exception and doesn't continue execution
    assertThrows(IOException.class, tokenCredential::refresh);
  }

  @Test
  void idTokenWithAudience_iamEndpoint_non2XXStatusCode() throws IOException {
    String universeDomain = "test.com";
    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory(universeDomain);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory.getTransport().setIdToken(DEFAULT_ID_TOKEN);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_NOT_FOUND, "Not Found");
    ServiceAccountCredentials credentials =
        createDefaultBuilder()
            .setScopes(SCOPES)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain(universeDomain)
            .build();

    String targetAudience = "audience";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();

    // Ensure that a non 2xx status code returns an exception and doesn't continue execution
    // Non 2xx status codes will be returned as HttpResponseException
    assertThrows(IOException.class, tokenCredential::refresh);
  }

  @Test
  void getScopes_nullReturnsEmpty() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().build();
    Collection<String> scopes = credentials.getScopes();

    assertNotNull(scopes);
    assertTrue(scopes.isEmpty());
  }

  @Test
  void getAccount_sameAs() throws IOException {
    ServiceAccountCredentials credentials = createDefaultBuilder().build();
    assertEquals(CLIENT_EMAIL, credentials.getAccount());
  }

  @Test
  void sign_sameAs()
      throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException {
    byte[] toSign = {0xD, 0xE, 0xA, 0xD};
    ServiceAccountCredentials credentials = createDefaultBuilder().build();

    byte[] signedBytes = credentials.sign(toSign);
    Signature signature = Signature.getInstance(OAuth2Utils.SIGNATURE_ALGORITHM);
    signature.initSign(credentials.getPrivateKey());
    signature.update(toSign);

    assertArrayEquals(signature.sign(), signedBytes);
  }

  @Test
  void equals_true() throws IOException {
    final URI tokenServer = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            transportFactory,
            tokenServer);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            transportFactory,
            tokenServer);
    assertTrue(credentials.equals(otherCredentials));
    assertTrue(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_clientId() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            "otherClientId",
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_email() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            "otherEmail",
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_super() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
                CLIENT_ID,
                CLIENT_EMAIL,
                PRIVATE_KEY_PKCS8,
                PRIVATE_KEY_ID,
                SCOPES,
                serverTransportFactory,
                tokenServer1)
            .toBuilder()
            .setUniverseDomain("universe.com")
            .build();
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_keyId() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            "otherId",
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_scopes() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            ImmutableSet.<String>of(),
            serverTransportFactory,
            tokenServer1);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_transportFactory() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    MockHttpTransportFactory httpTransportFactory = new MockHttpTransportFactory();
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            httpTransportFactory,
            tokenServer1);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void equals_false_tokenServer() throws IOException {
    final URI tokenServer1 = URI.create("https://foo1.com/bar");
    final URI tokenServer2 = URI.create("https://foo2.com/bar");
    MockTokenServerTransportFactory serverTransportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer1);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            serverTransportFactory,
            tokenServer2);
    assertFalse(credentials.equals(otherCredentials));
    assertFalse(otherCredentials.equals(credentials));
  }

  @Test
  void toString_containsFields() throws IOException {
    final URI tokenServer = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();

    ServiceAccountCredentials.Builder builder =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES, DEFAULT_SCOPES)
            .setHttpTransportFactory(transportFactory)
            .setTokenServerUri(tokenServer)
            .setServiceAccountUser(USER)
            .setQuotaProjectId(QUOTA_PROJECT);

    OAuth2Credentials credentials = ServiceAccountCredentials.fromPkcs8(PRIVATE_KEY_PKCS8, builder);
    String expectedToString =
        String.format(
            "ServiceAccountCredentials{quotaProjectId=%s, universeDomain=%s, isExplicitUniverseDomain=false, clientId=%s, clientEmail=%s, "
                + "privateKeyId=%s, transportFactoryClassName=%s, tokenServerUri=%s, scopes=%s, defaultScopes=%s, "
                + "serviceAccountUser=%s, lifetime=3600, useJwtAccessWithScope=false, defaultRetriesEnabled=true}",
            QUOTA_PROJECT,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_ID,
            MockTokenServerTransportFactory.class.getName(),
            tokenServer,
            SCOPES,
            DEFAULT_SCOPES,
            USER);
    assertEquals(expectedToString, credentials.toString());
  }

  @Test
  void hashCode_equals() throws IOException {
    final URI tokenServer = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
                CLIENT_ID,
                CLIENT_EMAIL,
                PRIVATE_KEY_PKCS8,
                PRIVATE_KEY_ID,
                SCOPES,
                transportFactory,
                tokenServer)
            .createWithQuotaProject(QUOTA_PROJECT)
            .toBuilder()
            .setUniverseDomain("universe.com")
            .build();
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
                CLIENT_ID,
                CLIENT_EMAIL,
                PRIVATE_KEY_PKCS8,
                PRIVATE_KEY_ID,
                SCOPES,
                transportFactory,
                tokenServer)
            .createWithQuotaProject(QUOTA_PROJECT)
            .toBuilder()
            .setUniverseDomain("universe.com")
            .build();
    assertEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void hashCode_not_equals_quota() throws IOException {
    final URI tokenServer = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    OAuth2Credentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            transportFactory,
            tokenServer);
    OAuth2Credentials otherCredentials =
        ServiceAccountCredentials.fromPkcs8(
                CLIENT_ID,
                CLIENT_EMAIL,
                PRIVATE_KEY_PKCS8,
                PRIVATE_KEY_ID,
                SCOPES,
                transportFactory,
                tokenServer)
            .createWithQuotaProject("some_quota");
    assertNotEquals(credentials.hashCode(), otherCredentials.hashCode());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {
    final URI tokenServer = URI.create("https://foo.com/bar");
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    ServiceAccountCredentials credentials =
        ServiceAccountCredentials.fromPkcs8(
            CLIENT_ID,
            CLIENT_EMAIL,
            PRIVATE_KEY_PKCS8,
            PRIVATE_KEY_ID,
            SCOPES,
            transportFactory,
            tokenServer);

    ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    try (ObjectOutputStream output = new ObjectOutputStream(bytes)) {
      output.writeObject(credentials);
      String s = output.toString();
    }
    ServiceAccountCredentials deserializedCredentials = serializeAndDeserialize(credentials);
    assertEquals(credentials, deserializedCredentials);
    assertEquals(credentials.hashCode(), deserializedCredentials.hashCode());
    assertEquals(credentials.toString(), deserializedCredentials.toString());
    assertSame(deserializedCredentials.clock, Clock.SYSTEM);
    assertEquals(
        MockTokenServerTransportFactory.class,
        deserializedCredentials.toBuilder().getHttpTransportFactory().getClass());
  }

  @Test
  void fromStream_nullTransport_throws() throws IOException {
    InputStream stream = new ByteArrayInputStream("foo".getBytes());
    try {
      ServiceAccountCredentials.fromStream(stream, null);
      fail("Should throw if HttpTransportFactory is null");
    } catch (NullPointerException expected) {
      // Expected
    }
  }

  @Test
  void fromStream_nullStream_throws() throws IOException {
    MockHttpTransportFactory transportFactory = new MockHttpTransportFactory();
    try {
      ServiceAccountCredentials.fromStream(null, transportFactory);
      fail("Should throw if InputStream is null");
    } catch (NullPointerException expected) {
      // Expected
    }
  }

  @Test
  void fromStream_providesToken() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    InputStream serviceAccountStream =
        writeServiceAccountStream(CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID);

    GoogleCredentials credentials =
        ServiceAccountCredentials.fromStream(serviceAccountStream, transportFactory);

    assertNotNull(credentials);
    credentials = credentials.createScoped(SCOPES);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);
  }

  @Test
  void fromStream_noClientId_throws() throws IOException {
    InputStream serviceAccountStream =
        writeServiceAccountStream(null, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "client_id");
  }

  @Test
  void fromStream_noClientEmail_throws() throws IOException {
    InputStream serviceAccountStream =
        writeServiceAccountStream(CLIENT_ID, null, PRIVATE_KEY_PKCS8, PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "client_email");
  }

  @Test
  void getIdTokenWithAudience_badEmailError_issClaimTraced() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    transport.setError(new IOException("Invalid grant: Account not found"));
    ServiceAccountCredentials credentials =
        createDefaultBuilder().setScopes(SCOPES).setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();

    String expectedErrorMessage = String.format("iss: %s", CLIENT_EMAIL);

    try {
      tokenCredential.refresh();
      fail("Should not be able to use credential without exception.");
    } catch (IOException expected) {
      assertTrue(expected.getMessage().contains(expectedErrorMessage));
    }
  }

  @Test
  void fromStream_noPrivateKey_throws() throws IOException {
    InputStream serviceAccountStream =
        writeServiceAccountStream(CLIENT_ID, CLIENT_EMAIL, null, PRIVATE_KEY_ID);

    testFromStreamException(serviceAccountStream, "private_key");
  }

  @Test
  void fromStream_noPrivateKeyId_throws() throws IOException {
    InputStream serviceAccountStream =
        writeServiceAccountStream(CLIENT_ID, CLIENT_EMAIL, PRIVATE_KEY_PKCS8, null);

    testFromStreamException(serviceAccountStream, "private_key_id");
  }

  @Test
  void getUriForSelfSignedJWT() {
    assertNull(ServiceAccountCredentials.getUriForSelfSignedJWT(null));

    URI uri = URI.create("https://compute.googleapis.com/compute/v1/projects/");
    URI expected = URI.create("https://compute.googleapis.com/");
    assertEquals(expected, ServiceAccountCredentials.getUriForSelfSignedJWT(uri));
  }

  @Test
  void getUriForSelfSignedJWT_noHost() {
    URI uri = URI.create("file:foo");
    URI expected = URI.create("file:foo");
    assertEquals(expected, ServiceAccountCredentials.getUriForSelfSignedJWT(uri));
  }

  @Test
  void getUriForSelfSignedJWT_forStaticAudience_returnsURI() {
    URI uri = URI.create("compute.googleapis.com");
    URI expected = URI.create("compute.googleapis.com");
    assertEquals(expected, ServiceAccountCredentials.getUriForSelfSignedJWT(uri));
  }

  @Test
  void getRequestMetadata_setsQuotaProjectId() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, "unused-client-secret");
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setServiceAccountUser(USER)
            .setProjectId(PROJECT_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setHttpTransportFactory(transportFactory)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertTrue(metadata.containsKey("x-goog-user-project"));
    List<String> headerValues = metadata.get("x-goog-user-project");
    assertEquals(1, headerValues.size());
    assertEquals("my-quota-project-id", headerValues.get(0));
  }

  @Test
  void getRequestMetadata_noQuotaProjectId() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, "unused-client-secret");
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setServiceAccountUser(USER)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(transportFactory)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertFalse(metadata.containsKey("x-goog-user-project"));
  }

  @Test
  void getRequestMetadata_withCallback() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, "unused-client-secret");
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setProjectId(PROJECT_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setHttpTransportFactory(transportFactory)
            .build();

    final Map<String, List<String>> plainMetadata = credentials.getRequestMetadata();
    final AtomicBoolean success = new AtomicBoolean(false);
    credentials.getRequestMetadata(
        null,
        null,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            assertEquals(plainMetadata, metadata);
            success.set(true);
          }

          @Override
          public void onFailure(Throwable exception) {
            fail("Should not throw a failure.");
          }
        });

    assertTrue(success.get(), "Should have run onSuccess() callback");
  }

  @Test
  void getRequestMetadata_withScopes_withUniverseDomain_SelfSignedJwt() throws IOException {
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, "unused-client-secret");
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);

    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(transportFactory)
            .setUniverseDomain("foo.bar")
            .build();

    final Map<String, List<String>> plainMetadata = credentials.getRequestMetadata();
    final AtomicBoolean success = new AtomicBoolean(false);
    credentials.getRequestMetadata(
        null,
        null,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            assertEquals(plainMetadata, metadata);
            success.set(true);
          }

          @Override
          public void onFailure(Throwable exception) {
            fail("Should not throw a failure.");
          }
        });

    assertTrue(success.get(), "Should have run onSuccess() callback");
  }

  @Test
  void getRequestMetadata_withScopes_selfSignedJWT() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(new MockTokenServerTransportFactory())
            .setUseJwtAccessWithScope(true)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertNotNull(((ServiceAccountCredentials) credentials).getSelfSignedJwtCredentialsWithScope());
    verifyJwtAccess(metadata, "dummy.scope");

    // Verify credentialType is correctly set. This is used for token usage metrics.
    // Self signed jwt flow doesn’t call any token endpoint, thus no token request metrics.
    assertEquals(
        CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_JWT,
        credentials.getMetricsCredentialType());
  }

  @Test
  void refreshAccessToken_withDomainDelegation_selfSignedJWT_disabled() throws IOException {
    final String accessToken1 = "1/MkSJoj1xsli0AccessToken_NKPY2";
    final String accessToken2 = "2/MkSJoj1xsli0AccessToken_NKPY2";
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    MockTokenServerTransport transport = transportFactory.transport;
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(SCOPES)
            .setServiceAccountUser(USER)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(transportFactory)
            .setUseJwtAccessWithScope(true)
            .build();

    transport.addServiceAccount(CLIENT_EMAIL, accessToken1);
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, accessToken1);

    try {
      verifyJwtAccess(metadata, "dummy.scope");
      fail("jwt access should fail with ServiceAccountUser");
    } catch (Exception ex) {
      // expected
    }

    transport.addServiceAccount(CLIENT_EMAIL, accessToken2);
    credentials.refresh();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), accessToken2);
  }

  @Test
  void getRequestMetadata_withAudience_selfSignedJWT() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(new MockTokenServerTransportFactory())
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    assertNull(((ServiceAccountCredentials) credentials).getSelfSignedJwtCredentialsWithScope());
    verifyJwtAccess(metadata, null);
  }

  @Test
  void getRequestMetadata_withDefaultScopes_selfSignedJWT() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setScopes(null, SCOPES)
            .setProjectId(PROJECT_ID)
            .setHttpTransportFactory(new MockTokenServerTransportFactory())
            .setUseJwtAccessWithScope(true)
            .build();

    Map<String, List<String>> metadata = credentials.getRequestMetadata(null);
    verifyJwtAccess(metadata, "dummy.scope");
  }

  @Test
  void getRequestMetadataWithCallback_selfSignedJWT() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setProjectId(PROJECT_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setHttpTransportFactory(new MockTokenServerTransportFactory())
            .setUseJwtAccessWithScope(true)
            .setScopes(SCOPES)
            .build();

    final AtomicBoolean success = new AtomicBoolean(false);
    credentials.getRequestMetadata(
        CALL_URI,
        null,
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            try {
              verifyJwtAccess(metadata, "dummy.scope");
            } catch (IOException e) {
              fail("Should not throw a failure");
            }
            success.set(true);
          }

          @Override
          public void onFailure(Throwable exception) {
            fail("Should not throw a failure.");
          }
        });

    assertTrue(success.get(), "Should have run onSuccess() callback");
  }

  @Test
  void createScopes_existingAccessTokenInvalidated() throws IOException {
    PrivateKey privateKey = OAuth2Utils.privateKeyFromPkcs8(PRIVATE_KEY_PKCS8);
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addServiceAccount(CLIENT_EMAIL, ACCESS_TOKEN);
    GoogleCredentials credentials =
        ServiceAccountCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientEmail(CLIENT_EMAIL)
            .setPrivateKey(privateKey)
            .setPrivateKeyId(PRIVATE_KEY_ID)
            .setProjectId(PROJECT_ID)
            .setQuotaProjectId("my-quota-project-id")
            .setHttpTransportFactory(transportFactory)
            .setScopes(SCOPES)
            .build();
    TestUtils.assertContainsBearerToken(credentials.getRequestMetadata(CALL_URI), ACCESS_TOKEN);

    // Calling createScoped() again will invalidate the existing access token and calling
    // `refresh()` is required to get a new Access Token.
    credentials = credentials.createScoped("RANDOM_SCOPES");
    AccessToken newAccessToken = credentials.getAccessToken();
    assertNull(newAccessToken);
  }

  private void verifyJwtAccess(Map<String, List<String>> metadata, String expectedScopeClaim)
      throws IOException {
    assertNotNull(metadata);
    List<String> authorizations = metadata.get(AuthHttpConstants.AUTHORIZATION);
    assertNotNull(authorizations, "Authorization headers not found");
    String assertion = null;
    for (String authorization : authorizations) {
      if (authorization.startsWith(JWT_ACCESS_PREFIX)) {
        assertNull(assertion, "Multiple bearer assertions found");
        assertion = authorization.substring(JWT_ACCESS_PREFIX.length());
      }
    }
    assertNotNull(assertion, "Bearer assertion not found");
    JsonWebSignature signature =
        JsonWebSignature.parse(GsonFactory.getDefaultInstance(), assertion);
    assertEquals(CLIENT_EMAIL, signature.getPayload().getIssuer());
    assertEquals(CLIENT_EMAIL, signature.getPayload().getSubject());
    if (expectedScopeClaim != null) {
      assertEquals(expectedScopeClaim, signature.getPayload().get("scope"));
      assertFalse(signature.getPayload().containsKey("aud"));
    } else {
      assertEquals(JWT_AUDIENCE, signature.getPayload().getAudience());
      assertFalse(signature.getPayload().containsKey("scope"));
    }
    assertEquals(PRIVATE_KEY_ID, signature.getHeader().getKeyId());
  }

  static GenericJson writeServiceAccountJson(
      String projectId, String quotaProjectId, String universeDomain) {
    return writeServiceAccountJson(
        CLIENT_ID,
        CLIENT_EMAIL,
        PRIVATE_KEY_PKCS8,
        PRIVATE_KEY_ID,
        projectId,
        quotaProjectId,
        universeDomain);
  }

  static GenericJson writeServiceAccountJson(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      String projectId,
      String quotaProjectId,
      String universeDomain) {
    GenericJson json = new GenericJson();
    if (clientId != null) {
      json.put("client_id", clientId);
    }
    if (clientEmail != null) {
      json.put("client_email", clientEmail);
    }
    if (privateKeyPkcs8 != null) {
      json.put("private_key", privateKeyPkcs8);
    }
    if (privateKeyId != null) {
      json.put("private_key_id", privateKeyId);
    }
    if (projectId != null) {
      json.put("project_id", projectId);
    }
    if (quotaProjectId != null) {
      json.put("quota_project_id", quotaProjectId);
    }
    if (universeDomain != null) {
      json.put("universe_domain", universeDomain);
    }
    json.put("type", GoogleCredentialsInfo.SERVICE_ACCOUNT_CREDENTIALS.getFileType());
    return json;
  }

  static InputStream writeServiceAccountStream(
      String clientId, String clientEmail, String privateKeyPkcs8, String privateKeyId)
      throws IOException {
    return writeServiceAccountStream(clientId, clientEmail, privateKeyPkcs8, privateKeyId, null);
  }

  static InputStream writeServiceAccountStream(
      String clientId,
      String clientEmail,
      String privateKeyPkcs8,
      String privateKeyId,
      String universeDomain)
      throws IOException {
    GenericJson json =
        writeServiceAccountJson(
            clientId, clientEmail, privateKeyPkcs8, privateKeyId, null, null, universeDomain);
    return TestUtils.jsonToInputStream(json);
  }

  private static void testFromStreamException(InputStream stream, String expectedMessageContent) {
    try {
      ServiceAccountCredentials.fromStream(stream, DUMMY_TRANSPORT_FACTORY);
      fail(
          String.format(
              "Should throw exception with message containing '%s'", expectedMessageContent));
    } catch (IOException expected) {
      assertTrue(expected.getMessage().contains(expectedMessageContent));
    }
  }
}
