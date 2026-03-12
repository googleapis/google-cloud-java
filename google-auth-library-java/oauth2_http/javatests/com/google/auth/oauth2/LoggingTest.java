/*
 * Copyright 2025 Google LLC
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

import static com.google.auth.TestUtils.getDefaultExpireTime;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.DEFAULT_IMPERSONATION_URL;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.IMMUTABLE_SCOPES_LIST;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.IMPERSONATED_CLIENT_EMAIL;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.TOKEN_WITH_EMAIL;
import static com.google.auth.oauth2.ImpersonatedCredentialsTest.VALID_LIFETIME;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.ACCESS_TOKEN;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.CALL_URI;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.CLIENT_EMAIL;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.DEFAULT_ID_TOKEN;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.SCOPES;
import static com.google.auth.oauth2.ServiceAccountCredentialsTest.createDefaultBuilder;
import static com.google.auth.oauth2.UserCredentialsTest.CLIENT_ID;
import static com.google.auth.oauth2.UserCredentialsTest.CLIENT_SECRET;
import static com.google.auth.oauth2.UserCredentialsTest.REFRESH_TOKEN;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ch.qos.logback.classic.spi.ILoggingEvent;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.json.webtoken.JsonWebToken.Payload;
import com.google.api.client.util.ArrayMap;
import com.google.auth.TestUtils;
import com.google.auth.oauth2.ComputeEngineCredentialsTest.MockMetadataServerTransportFactory;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.KeyValuePair;

/**
 * This class contains tests for logging events in each credentials workflow Tests are copied from
 * credentials test classes with addition of test logging appender setup and test logic for logging.
 * This duplicates tests setups, but centralizes logging test setup in this class.
 */
class LoggingTest {

  private TestAppender setupTestLogger(Class<?> clazz) {
    TestAppender testAppender = new TestAppender();
    testAppender.start();
    Logger logger = LoggerFactory.getLogger(clazz);
    ((ch.qos.logback.classic.Logger) logger).addAppender(testAppender);
    return testAppender;
  }

  @BeforeAll
  static void setup() {
    // mimic GOOGLE_SDK_JAVA_LOGGING = true
    TestEnvironmentProvider testEnvironmentProvider = new TestEnvironmentProvider();
    testEnvironmentProvider.setEnv(LoggingUtils.GOOGLE_SDK_JAVA_LOGGING, "true");
    LoggingUtils.setEnvironmentProvider(testEnvironmentProvider);
  }

  @Test
  void userCredentials_getRequestMetadata_fromRefreshToken_hasAccessToken() throws IOException {
    TestAppender testAppender = setupTestLogger(UserCredentials.class);
    MockTokenServerTransportFactory transportFactory = new MockTokenServerTransportFactory();
    transportFactory.transport.addClient(CLIENT_ID, CLIENT_SECRET);
    transportFactory.transport.addRefreshToken(REFRESH_TOKEN, ACCESS_TOKEN);
    UserCredentials userCredentials =
        UserCredentials.newBuilder()
            .setClientId(CLIENT_ID)
            .setClientSecret(CLIENT_SECRET)
            .setRefreshToken(REFRESH_TOKEN)
            .setHttpTransportFactory(transportFactory)
            .build();

    Map<String, List<String>> metadata = userCredentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);

    assertEquals(3, testAppender.events.size());
    assertEquals(
        "Sending request to refresh access token", testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.payload")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals(
        "Received response for refresh access token", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload for access token", testAppender.events.get(2).getMessage());
    assertEquals(4, testAppender.events.get(2).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(2).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("access_token")
              || kvp.key.equals("refresh_token")
              || kvp.key.equals("token_type")
              || kvp.key.equals("expires_in"));
    }
    testAppender.stop();
  }

  boolean isValidJson(String jsonString) {
    try {
      JsonParser.parseString(jsonString);
      return true;
    } catch (JsonSyntaxException e) {
      return false;
    }
  }

  @Test
  void serviceAccountCredentials_getRequestMetadata_hasAccessToken() throws IOException {
    TestAppender testAppender = setupTestLogger(ServiceAccountCredentials.class);
    GoogleCredentials credentials =
        ServiceAccountCredentialsTest.createDefaultBuilderWithToken(ACCESS_TOKEN)
            .setScopes(SCOPES)
            .build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);
    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);

    assertEquals(3, testAppender.events.size());

    assertEquals(
        "Sending request to refresh access token", testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.payload")) {
        // ensure correctly formatted as JSON
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals(
        "Received response for refresh access token", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload", testAppender.events.get(2).getMessage());
    assertEquals(3, testAppender.events.get(2).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(2).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("access_token")
              || kvp.key.equals("token_type")
              || kvp.key.equals("expires_in"));
    }
    testAppender.stop();
  }

  @Test
  void serviceAccountCredentials_idTokenWithAudience_iamFlow_targetAudienceMatchesAudClaim()
      throws IOException {
    TestAppender testAppender = setupTestLogger(ServiceAccountCredentials.class);
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

    assertEquals(3, testAppender.events.size());

    assertEquals("Sending request to get ID token", testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.headers") || kvp.key.equals("request.payload")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals("Received response for ID token request", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload", testAppender.events.get(2).getMessage());
    assertEquals(1, testAppender.events.get(2).getKeyValuePairs().size());
    testAppender.stop();
  }

  @Test()
  void impersonatedCredentials_refreshAccessToken_success()
      throws IOException, IllegalStateException {
    TestAppender testAppender = setupTestLogger(ImpersonatedCredentials.class);
    MockIAMCredentialsServiceTransportFactory mockTransportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    mockTransportFactory.getTransport().setTargetPrincipal(IMPERSONATED_CLIENT_EMAIL);
    mockTransportFactory.getTransport().setAccessToken(ACCESS_TOKEN);
    mockTransportFactory.getTransport().setExpireTime(getDefaultExpireTime());
    mockTransportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    ImpersonatedCredentials targetCredentials =
        ImpersonatedCredentials.create(
            ImpersonatedCredentialsTest.getSourceCredentials(),
            IMPERSONATED_CLIENT_EMAIL,
            null,
            IMMUTABLE_SCOPES_LIST,
            VALID_LIFETIME,
            mockTransportFactory);

    assertEquals(ACCESS_TOKEN, targetCredentials.refreshAccessToken().getTokenValue());
    assertEquals(
        DEFAULT_IMPERSONATION_URL, mockTransportFactory.getTransport().getRequest().getUrl());

    assertEquals(3, testAppender.events.size());

    assertEquals(
        "Sending request to refresh access token", testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.payload")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals(
        "Received response for refresh access token", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload for access token", testAppender.events.get(2).getMessage());
    assertEquals(2, testAppender.events.get(2).getKeyValuePairs().size());

    testAppender.stop();
  }

  @Test
  void idTokenWithAudience_withEmail() throws IOException {
    TestAppender testAppender = setupTestLogger(IamUtils.class);
    MockIAMCredentialsServiceTransportFactory mockTransportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    mockTransportFactory.getTransport().setTargetPrincipal(IMPERSONATED_CLIENT_EMAIL);
    mockTransportFactory.getTransport().setAccessToken(ACCESS_TOKEN);
    mockTransportFactory.getTransport().setExpireTime(getDefaultExpireTime());
    mockTransportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    ImpersonatedCredentials targetCredentials =
        ImpersonatedCredentials.create(
            ImpersonatedCredentialsTest.getSourceCredentials(),
            IMPERSONATED_CLIENT_EMAIL,
            null,
            IMMUTABLE_SCOPES_LIST,
            VALID_LIFETIME,
            mockTransportFactory);

    mockTransportFactory.getTransport().setIdToken(TOKEN_WITH_EMAIL);

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(targetCredentials)
            .setTargetAudience(targetAudience)
            .setOptions(Arrays.asList(IdTokenProvider.Option.INCLUDE_EMAIL))
            .build();
    tokenCredential.refresh();
    assertEquals(TOKEN_WITH_EMAIL, tokenCredential.getAccessToken().getTokenValue());
    Payload p = tokenCredential.getIdToken().getJsonWebSignature().getPayload();
    assertTrue(p.containsKey("email"));

    assertEquals(3, testAppender.events.size());

    assertEquals("Sending request to get ID token", testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.headers") || kvp.key.equals("request.payload")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals("Received response for ID token request", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload for ID token request", testAppender.events.get(2).getMessage());
    assertEquals(1, testAppender.events.get(2).getKeyValuePairs().size());

    testAppender.stop();
  }

  @Test
  void sign_sameAs() throws IOException {
    TestAppender testAppender = setupTestLogger(IamUtils.class);
    MockIAMCredentialsServiceTransportFactory mockTransportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    mockTransportFactory.getTransport().setTargetPrincipal(IMPERSONATED_CLIENT_EMAIL);
    mockTransportFactory.getTransport().setAccessToken(ACCESS_TOKEN);
    mockTransportFactory.getTransport().setExpireTime(getDefaultExpireTime());
    mockTransportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    ImpersonatedCredentials targetCredentials =
        ImpersonatedCredentials.create(
            ImpersonatedCredentialsTest.getSourceCredentials(),
            IMPERSONATED_CLIENT_EMAIL,
            null,
            IMMUTABLE_SCOPES_LIST,
            VALID_LIFETIME,
            mockTransportFactory);

    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    mockTransportFactory.getTransport().setTargetPrincipal(IMPERSONATED_CLIENT_EMAIL);
    mockTransportFactory.getTransport().setSignedBlob(expectedSignature);

    assertArrayEquals(expectedSignature, targetCredentials.sign(expectedSignature));

    assertEquals(3, testAppender.events.size());

    assertEquals(
        "Sending request to get signature to sign the blob",
        testAppender.events.get(0).getMessage());
    assertEquals(4, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.payload")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.headers") || kvp.key.equals("request.payload")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals(
        "Received response for signature to sign the blob",
        testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    assertEquals("Response payload for sign blob", testAppender.events.get(2).getMessage());
    assertEquals(1, testAppender.events.get(2).getKeyValuePairs().size());

    testAppender.stop();
  }

  @Test
  void getRequestMetadata_hasAccessToken() throws IOException {
    TestAppender testAppender = setupTestLogger(ComputeEngineCredentials.class);
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    transportFactory.transport.setServiceAccountEmail("SA_CLIENT_EMAIL");
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();
    Map<String, List<String>> metadata = credentials.getRequestMetadata(CALL_URI);

    TestUtils.assertContainsBearerToken(metadata, ACCESS_TOKEN);

    assertEquals(3, testAppender.events.size());

    ILoggingEvent accessTokenRequest = testAppender.events.get(0);
    assertEquals("Sending request to refresh access token", accessTokenRequest.getMessage());
    assertEquals(3, accessTokenRequest.getKeyValuePairs().size());
    for (KeyValuePair kvp : accessTokenRequest.getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.headers")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    ILoggingEvent accessTokenResponse = testAppender.events.get(1);
    assertEquals("Received response for refresh access token", accessTokenResponse.getMessage());
    assertEquals(3, accessTokenResponse.getKeyValuePairs().size());
    for (KeyValuePair kvp : accessTokenResponse.getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }
    ILoggingEvent accessTokenPayload = testAppender.events.get(2);
    assertEquals("Response payload for access token", accessTokenPayload.getMessage());
    assertEquals(3, accessTokenPayload.getKeyValuePairs().size());

    testAppender.stop();
  }

  @Test
  @SuppressWarnings("unchecked")
  void idTokenWithAudience_full() throws IOException {
    TestAppender testAppender = setupTestLogger(ComputeEngineCredentials.class);
    MockMetadataServerTransportFactory transportFactory = new MockMetadataServerTransportFactory();
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .setOptions(Arrays.asList(IdTokenProvider.Option.FORMAT_FULL))
            .build();
    tokenCredential.refresh();
    Payload p = tokenCredential.getIdToken().getJsonWebSignature().getPayload();
    assertTrue(p.containsKey("google"), "Full ID Token format not provided");
    ArrayMap<String, ArrayMap> googleClaim = (ArrayMap<String, ArrayMap>) p.get("google");
    assertTrue(googleClaim.containsKey("compute_engine"));

    assertEquals(3, testAppender.events.size());

    assertEquals("Sending request to get ID token", testAppender.events.get(0).getMessage());
    assertEquals(3, testAppender.events.get(0).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(0).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("request.headers")
              || kvp.key.equals("request.method")
              || kvp.key.equals("request.url"));
      if (kvp.key.equals("request.headers")) {
        assertTrue(isValidJson((String) kvp.value));
      }
    }
    assertEquals("Received response for ID token request", testAppender.events.get(1).getMessage());
    assertEquals(3, testAppender.events.get(1).getKeyValuePairs().size());
    for (KeyValuePair kvp : testAppender.events.get(1).getKeyValuePairs()) {
      assertTrue(
          kvp.key.equals("response.headers")
              || kvp.key.equals("response.status")
              || kvp.key.equals("response.status.message"));
    }

    assertEquals("Response Payload for ID token", testAppender.events.get(2).getMessage());
    assertEquals(1, testAppender.events.get(2).getKeyValuePairs().size());
    assertEquals("idToken", testAppender.events.get(2).getKeyValuePairs().get(0).key);
    assertEquals(
        ComputeEngineCredentialsTest.FULL_ID_TOKEN,
        testAppender.events.get(2).getKeyValuePairs().get(0).value);
    testAppender.stop();
  }
}
