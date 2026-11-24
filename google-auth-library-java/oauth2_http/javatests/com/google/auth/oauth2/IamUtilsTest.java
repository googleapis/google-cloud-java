/*
 * Copyright 2024, Google Inc. All rights reserved.
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.CredentialTypeForMetrics;
import com.google.auth.Credentials;
import com.google.auth.RequestMetadataCallback;
import com.google.auth.ServiceAccountSigner;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import com.google.common.collect.ImmutableMap;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectOutputStream;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.mockito.Mockito;

class IamUtilsTest {

  private static final String CLIENT_EMAIL =
      "36680232662-vrd7ji19qe3nelgchd0ah2csanun6bnr@developer.gserviceaccount.com";

  private ServiceAccountCredentials credentials;

  @BeforeEach
  void setup() throws IOException {
    // Mock this call for the Credentials because the IAM SignBlob RPC requires an access token. The
    // call is initialized with HttpCredentialsAdapter which will make a call to get the access
    // token
    credentials =
        Mockito.mock(ServiceAccountCredentials.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(credentials.getRequestMetadata(Mockito.any())).thenReturn(ImmutableMap.of());
    Mockito.when(credentials.getUniverseDomain()).thenReturn("googleapis.com");
  }

  @Test
  void sign_success_noRetry() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    assertEquals(1, transportFactory.getTransport().getNumRequests());
  }

  // The SignBlob RPC will retry up to three times before it gives up. This test will return two
  // 5xx status codes before returning a success. This test covers the cases where the number of
  // retry attempts is below the configured retry attempt count bounds (3 attempts).
  @Test
  void sign_retryTwoTimes_success() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    // Expect that three requests are made (2 failures which are retries + 1 final requests which
    // resulted in a successful response)
    assertEquals(3, transportFactory.getTransport().getNumRequests());
  }

  // The rpc will retry up to three times before it gives up. This test will enqueue three failed
  // status codes + messages before returning a success. After the third retry attempt, the request
  // will try one last time and the result will be reported back to the user.
  @Test
  void sign_retryThreeTimes_success() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "Server Error");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    byte[] signature =
        IamUtils.sign(
            CLIENT_EMAIL,
            credentials,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            transportFactory.getTransport(),
            expectedSignature,
            ImmutableMap.of());
    assertArrayEquals(expectedSignature, signature);

    // Expect that three requests are made (3 failures which are retried + 1 final request which
    // resulted the final success response)
    assertEquals(4, transportFactory.getTransport().getNumRequests());
  }

  // The rpc will retry up to three times before it gives up. This test will enqueue four failed
  // status codes + messages before returning a success. After the third retry attempt, the request
  // will try one last time and the result will be reported back to the user.
  @Test
  void sign_retryThreeTimes_exception() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVICE_UNAVAILABLE, "Unavailable");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_SERVER_ERROR, "Server Error");
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_BAD_GATEWAY, "Bad Gateway");
    transportFactory.getTransport().addStatusCodeAndMessage(HttpStatusCodes.STATUS_CODE_OK, "");

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transportFactory.getTransport(),
                    expectedSignature,
                    ImmutableMap.of()));
    assertTrue(exception.getMessage().contains("Failed to sign the provided bytes"));
    assertTrue(
        exception
            .getCause()
            .getMessage()
            .contains("Unexpected Error code 502 trying to sign provided bytes"));

    // Expect that three requests are made (3 failures which are retried + 1 final request which
    // resulted in another failed response)
    assertEquals(4, transportFactory.getTransport().getNumRequests());
  }

  @Test
  void sign_4xxError_noRetry_exception() {
    byte[] expectedSignature = {0xD, 0xE, 0xA, 0xD};

    MockIAMCredentialsServiceTransportFactory transportFactory =
        new MockIAMCredentialsServiceTransportFactory();
    transportFactory.getTransport().setSignedBlob(expectedSignature);
    transportFactory.getTransport().setTargetPrincipal(CLIENT_EMAIL);
    transportFactory
        .getTransport()
        .addStatusCodeAndMessage(
            HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Failed to sign the provided bytes");

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transportFactory.getTransport(),
                    expectedSignature,
                    ImmutableMap.of()));
    assertTrue(exception.getMessage().contains("Failed to sign the provided bytes"));
    assertTrue(
        exception
            .getCause()
            .getMessage()
            .contains("Error code 401 trying to sign provided bytes:"));

    // Only one request will have been made for a 4xx error (no retries)
    assertEquals(1, transportFactory.getTransport().getNumRequests());
  }

  /**
   * {@code HttpURLConnection} discards the body of a 401 response to a request sent in streaming
   * mode (every POST with content), so the response has no content. The error must surface as an
   * {@link IOException} with the status code, not a {@link NullPointerException}.
   */
  @Test
  void sign_4xxErrorWithEmptyBody_throwsSigningExceptionWithStatusCode() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED)
                    .setReasonPhrase("Unauthorized"))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertTrue(exception.getCause() instanceof IOException);
    assertEquals(
        "Error code 401 trying to sign provided bytes: Unauthorized",
        exception.getCause().getMessage());
  }

  @Test
  void getIdToken_4xxErrorWithEmptyBody_throwsIOExceptionWithStatusCode() throws IOException {
    // IAM's 401 carries a Bearer challenge without an error parameter, so HttpCredentialsAdapter
    // doesn't refresh and retry.
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED)
                    .setReasonPhrase("Unauthorized")
                    .addHeader("WWW-Authenticate", "Bearer realm=\"https://accounts.google.com/\""))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals("Error code 401 trying to getIDToken: Unauthorized", exception.getMessage());
    Mockito.verify(credentials, Mockito.never()).refresh();
  }

  @Test
  void getIdToken_4xxErrorWithJsonBody_includesServerMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setContentType("application/json")
                    .setContent("{\"error\": {\"code\": 403, \"message\": \"Permission denied\"}}"))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals("Error code 403 trying to getIDToken: Permission denied", exception.getMessage());
  }

  @Test
  void sign_4xxErrorWithEmptyStringBody_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED)
                    .setReasonPhrase("Unauthorized")
                    .setContent(""))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertEquals(
        "Error code 401 trying to sign provided bytes: Unauthorized",
        exception.getCause().getMessage());
  }

  @Test
  void sign_4xxErrorWithEmptyBodyAndNoReasonPhrase_usesFallbackMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertEquals(
        "Error code 401 trying to sign provided bytes: (no error details in the response)",
        exception.getCause().getMessage());
  }

  @Test
  void getIdToken_4xxErrorWithEmptyBodyAndEmptyReasonPhrase_usesFallbackMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setReasonPhrase(""))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals(
        "Error code 403 trying to getIDToken: (no error details in the response)",
        exception.getMessage());
  }

  @Test
  void sign_4xxErrorWithJsonBody_includesServerMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setContentType("application/json")
                    .setContent("{\"error\": {\"code\": 403, \"message\": \"Permission denied\"}}"))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertEquals(
        "Error code 403 trying to sign provided bytes: Permission denied",
        exception.getCause().getMessage());
  }

  @Test
  void sign_4xxErrorWithJsonNullBody_usesStatusMessage() {
    // A JSON null body parses to Data.nullOf(GenericData.class), not a Java null, and has no
    // "error.message" field, so it falls back to the HTTP status message with the status code.
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED)
                    .setReasonPhrase("Unauthorized")
                    .setContentType("application/json")
                    .setContent("null"))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertTrue(exception.getCause() instanceof IOException);
    assertEquals(
        "Error code 401 trying to sign provided bytes: Unauthorized",
        exception.getCause().getMessage());
  }

  @Test
  void sign_4xxErrorWithHtmlBody_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setReasonPhrase("Forbidden")
                    .setContentType("text/html")
                    .setContent("<html><body><h1>403 Forbidden</h1></body></html>"))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertTrue(exception.getCause() instanceof IOException);
    assertEquals(
        "Error code 403 trying to sign provided bytes: Forbidden",
        exception.getCause().getMessage());
  }

  @Test
  void sign_4xxErrorWithEmptyJsonObject_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED)
                    .setReasonPhrase("Unauthorized")
                    .setContentType("application/json")
                    .setContent("{}"))
            .build();

    ServiceAccountSigner.SigningException exception =
        assertThrows(
            ServiceAccountSigner.SigningException.class,
            () ->
                IamUtils.sign(
                    CLIENT_EMAIL,
                    credentials,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE,
                    transport,
                    new byte[] {0xD, 0xE, 0xA, 0xD},
                    ImmutableMap.of()));
    assertTrue(exception.getCause() instanceof IOException);
    assertEquals(
        "Error code 401 trying to sign provided bytes: Unauthorized",
        exception.getCause().getMessage());
  }

  @Test
  void getIdToken_4xxErrorWithHtmlBody_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setReasonPhrase("Forbidden")
                    .setContentType("text/html")
                    .setContent("<html><body><h1>403 Forbidden</h1></body></html>"))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals("Error code 403 trying to getIDToken: Forbidden", exception.getMessage());
  }

  @Test
  void getIdToken_4xxErrorWithJsonMissingMessage_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setReasonPhrase("Forbidden")
                    .setContentType("application/json")
                    .setContent("{\"error\": {\"code\": 403}}"))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals("Error code 403 trying to getIDToken: Forbidden", exception.getMessage());
  }

  @Test
  void getIdToken_4xxErrorWithJsonEmptyMessage_usesStatusMessage() {
    MockHttpTransport transport =
        new MockHttpTransport.Builder()
            .setLowLevelHttpResponse(
                new MockLowLevelHttpResponse()
                    .setStatusCode(HttpStatusCodes.STATUS_CODE_FORBIDDEN)
                    .setReasonPhrase("Forbidden")
                    .setContentType("application/json")
                    .setContent("{\"error\": {\"code\": 403, \"message\": \"\"}}"))
            .build();

    IOException exception =
        assertThrows(
            IOException.class,
            () ->
                IamUtils.getIdToken(
                    CLIENT_EMAIL,
                    credentials,
                    transport,
                    "https://example.com",
                    false,
                    ImmutableMap.of(),
                    CredentialTypeForMetrics.SERVICE_ACCOUNT_CREDENTIALS_AT,
                    Credentials.GOOGLE_DEFAULT_UNIVERSE));
    assertEquals("Error code 403 trying to getIDToken: Forbidden", exception.getMessage());
  }

  private static AgentIdentityUtils.CertInfo loadAgentCertInfo() throws Exception {
    String certPath =
        Paths.get(IamUtilsTest.class.getResource("/agent/agent_spiffe_cert.pem").toURI())
            .toString();
    String keyPath =
        Paths.get(IamUtilsTest.class.getResource("/agent/agent_spiffe_key.pem").toURI()).toString();
    AgentIdentityUtils.resetForTest();
    try {
      return AgentIdentityUtils.loadAndVerifyCredentials(certPath, keyPath);
    } finally {
      AgentIdentityUtils.resetForTest();
    }
  }

  private static ComputeEngineCredentials computeEngineCredentialsWithToken(AccessToken token) {
    ComputeEngineCredentials.Builder builder =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(MockMetadataServerTransport::new);
    builder.setAccessToken(token);
    return builder.build();
  }

  private static Date oneHourFromNow() {
    return new Date(System.currentTimeMillis() + 3_600_000L);
  }

  @Test
  void resolveBoundTokenCallTarget_boundToken_usesMtlsEndpointCertificateAndToken()
      throws Exception {
    AgentIdentityUtils.CertInfo certInfo = loadAgentCertInfo();
    assertNotNull(certInfo.getKeyStore());
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), certInfo));
    HttpTransportFactory defaultFactory = MockHttpTransport::new;
    HttpTransportFactory mtlsFactory = MockHttpTransport::new;
    AtomicReference<KeyStore> keyStoreUsed = new AtomicReference<>();

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            defaultFactory,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> {
              keyStoreUsed.set(keyStore);
              return mtlsFactory;
            });

    assertTrue(target.usesMtls());
    assertEquals("mtls.googleapis.com", target.endpointDomain);
    assertSame(mtlsFactory, target.transportFactory);
    assertSame(certInfo.getKeyStore(), keyStoreUsed.get());
    Map<String, List<String>> metadata =
        target.credentials.getRequestMetadata(
            URI.create("https://iamcredentials.mtls.googleapis.com"));
    assertEquals(Collections.singletonList("Bearer bound-token"), metadata.get("Authorization"));
  }

  @Test
  void resolveBoundTokenCallTarget_boundToken_pinnedCredentialsStartWithTokenAndKeepIt()
      throws Exception {
    AgentIdentityUtils.CertInfo certInfo = loadAgentCertInfo();
    BoundAccessToken token = new BoundAccessToken("bound-token", oneHourFromNow(), certInfo);
    ComputeEngineCredentials source = computeEngineCredentialsWithToken(token);

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            MockHttpTransport::new,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> MockHttpTransport::new);

    GoogleCredentials pinned = (GoogleCredentials) target.credentials;
    assertNotSame(source, pinned);
    // Seeded with the bound token, so the first use doesn't go through a refresh.
    assertSame(token, pinned.getAccessToken());
    // A refresh (for example when the token becomes stale) keeps the same bound token.
    pinned.refresh();
    assertSame(token, pinned.getAccessToken());
  }

  @Test
  void resolveBoundTokenCallTarget_boundTokenWithQuotaProject_preservesQuotaProjectHeader()
      throws Exception {
    AgentIdentityUtils.CertInfo certInfo = loadAgentCertInfo();
    ComputeEngineCredentials.Builder builder =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(MockMetadataServerTransport::new)
            .setQuotaProjectId("quota-project");
    builder.setAccessToken(new BoundAccessToken("bound-token", oneHourFromNow(), certInfo));
    ComputeEngineCredentials source = builder.build();

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            MockHttpTransport::new,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> MockHttpTransport::new);

    URI uri = URI.create("https://iamcredentials.mtls.googleapis.com");
    Map<String, List<String>> syncMetadata = target.credentials.getRequestMetadata(uri);
    assertEquals(
        Collections.singletonList("Bearer bound-token"), syncMetadata.get("Authorization"));
    assertEquals(
        Collections.singletonList("quota-project"), syncMetadata.get("x-goog-user-project"));

    AtomicReference<Map<String, List<String>>> asyncMetadata = new AtomicReference<>();
    target.credentials.getRequestMetadata(
        uri,
        MoreExecutors.directExecutor(),
        new RequestMetadataCallback() {
          @Override
          public void onSuccess(Map<String, List<String>> metadata) {
            asyncMetadata.set(metadata);
          }

          @Override
          public void onFailure(Throwable exception) {
            throw new AssertionError("Unexpected failure", exception);
          }
        });
    assertNotNull(asyncMetadata.get());
    assertEquals(
        Collections.singletonList("Bearer bound-token"), asyncMetadata.get().get("Authorization"));
    assertEquals(
        Collections.singletonList("quota-project"), asyncMetadata.get().get("x-goog-user-project"));
  }

  private static String writeAgentCertConfig(Path tempDir, String certResource, String keyResource)
      throws Exception {
    Path configPath = tempDir.resolve("certificate_config.json");
    Map<String, Object> workload = new HashMap<>();
    workload.put(
        "cert_path", Paths.get(IamUtilsTest.class.getResource(certResource).toURI()).toString());
    workload.put(
        "key_path", Paths.get(IamUtilsTest.class.getResource(keyResource).toURI()).toString());
    Map<String, Object> certConfigs = new HashMap<>();
    certConfigs.put("workload", workload);
    Map<String, Object> config = new HashMap<>();
    config.put("cert_configs", certConfigs);
    Files.write(
        configPath, OAuth2Utils.JSON_FACTORY.toString(config).getBytes(StandardCharsets.UTF_8));
    return configPath.toString();
  }

  private static void configureAgentCertEnv(Path tempDir, String certResource, String keyResource)
      throws Exception {
    String configPath = writeAgentCertConfig(tempDir, certResource, keyResource);
    TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, configPath);
    AgentIdentityUtils.resetForTest();
    AgentIdentityUtils.setEnvironmentProvider(envProvider);
    AgentIdentityUtils.setPropertyProvider(new TestPropertyProvider());
    AgentIdentityUtils.setWellKnownDir(tempDir.resolve("no-spiffe").toString());
  }

  private static MockHttpTransport newMetadataTokenTransport(
      AtomicReference<String> nextToken, AtomicInteger requestCount) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() throws IOException {
            requestCount.incrementAndGet();
            GenericJson refreshContents = new GenericJson();
            refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);
            refreshContents.put("access_token", nextToken.get());
            refreshContents.put("expires_in", 3600);
            refreshContents.put("token_type", "Bearer");
            return new MockLowLevelHttpResponse()
                .setContentType(Json.MEDIA_TYPE)
                .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                .setContent(refreshContents.toPrettyString());
          }
        };
      }
    };
  }

  @Test
  void resolveBoundTokenCallTarget_nullInitialToken_refreshesAndUsesMtls(@TempDir Path tempDir)
      throws Exception {
    configureAgentCertEnv(tempDir, "/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    try {
      AtomicInteger metadataRequests = new AtomicInteger();
      MockHttpTransport metadataTransport =
          newMetadataTokenTransport(new AtomicReference<>("minted-bound-token"), metadataRequests);
      ComputeEngineCredentials source =
          ComputeEngineCredentials.newBuilder()
              .setHttpTransportFactory(() -> metadataTransport)
              .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
              .build();
      assertNull(source.getAccessToken());
      AtomicReference<KeyStore> keyStoreUsed = new AtomicReference<>();

      IamUtils.IamCallTarget target =
          IamUtils.resolveBoundTokenCallTarget(
              source,
              MockHttpTransport::new,
              Credentials.GOOGLE_DEFAULT_UNIVERSE,
              keyStore -> {
                keyStoreUsed.set(keyStore);
                return MockHttpTransport::new;
              });

      assertEquals(1, metadataRequests.get());
      assertTrue(target.usesMtls());
      assertNotNull(keyStoreUsed.get());
      assertSame(
          ((BoundAccessToken) source.getAccessToken()).getCertInfo().getKeyStore(),
          keyStoreUsed.get());
      Map<String, List<String>> metadata =
          target.credentials.getRequestMetadata(
              URI.create("https://iamcredentials.mtls.googleapis.com"));
      assertEquals(
          Collections.singletonList("Bearer minted-bound-token"), metadata.get("Authorization"));
    } finally {
      AgentIdentityUtils.resetForTest();
    }
  }

  @Test
  void resolveBoundTokenCallTarget_certificateRotation_isolatesInFlightTargetAndSwitchesNextCall(
      @TempDir Path tempDir) throws Exception {
    configureAgentCertEnv(tempDir, "/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    try {
      AtomicReference<String> nextToken = new AtomicReference<>("bound-token-a");
      AtomicInteger metadataRequests = new AtomicInteger();
      MockHttpTransport metadataTransport = newMetadataTokenTransport(nextToken, metadataRequests);
      ComputeEngineCredentials source =
          ComputeEngineCredentials.newBuilder()
              .setHttpTransportFactory(() -> metadataTransport)
              .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
              .build();
      AtomicReference<KeyStore> keyStoreUsed = new AtomicReference<>();

      IamUtils.IamCallTarget targetA =
          IamUtils.resolveBoundTokenCallTarget(
              source,
              MockHttpTransport::new,
              Credentials.GOOGLE_DEFAULT_UNIVERSE,
              keyStore -> {
                keyStoreUsed.set(keyStore);
                return MockHttpTransport::new;
              });
      KeyStore keyStoreA = keyStoreUsed.get();
      assertNotNull(keyStoreA);
      assertEquals(1, keyStoreA.getCertificateChain("alias").length);
      assertEquals(1, metadataRequests.get());

      // Rotate the certificate on disk and simulate a concurrent refresh on source before targetA
      // sends its request.
      configureAgentCertEnv(
          tempDir, "/agent/agent_spiffe_cert_chain.pem", "/agent/agent_spiffe_key.pem");
      nextToken.set("bound-token-b");
      source.refresh();
      assertEquals("bound-token-b", source.getAccessToken().getTokenValue());
      assertEquals(2, metadataRequests.get());

      URI uri = URI.create("https://iamcredentials.mtls.googleapis.com");
      assertEquals(
          Collections.singletonList("Bearer bound-token-a"),
          targetA.credentials.getRequestMetadata(uri).get("Authorization"));

      // Subsequent IAM calls pick up Cert B and token B together without extra refreshes.
      IamUtils.IamCallTarget targetB =
          IamUtils.resolveBoundTokenCallTarget(
              source,
              MockHttpTransport::new,
              Credentials.GOOGLE_DEFAULT_UNIVERSE,
              keyStore -> {
                keyStoreUsed.set(keyStore);
                return MockHttpTransport::new;
              });
      assertEquals(2, metadataRequests.get());
      KeyStore keyStoreB = keyStoreUsed.get();
      assertNotNull(keyStoreB);
      assertNotSame(keyStoreA, keyStoreB);
      assertEquals(2, keyStoreB.getCertificateChain("alias").length);
      assertEquals(
          Collections.singletonList("Bearer bound-token-b"),
          targetB.credentials.getRequestMetadata(uri).get("Authorization"));
    } finally {
      AgentIdentityUtils.resetForTest();
    }
  }

  @Test
  void refreshAndResolveRetryTarget_concurrentRefreshAlreadyCompleted_reusesRefreshedToken(
      @TempDir Path tempDir) throws Exception {
    configureAgentCertEnv(tempDir, "/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    try {
      AtomicReference<String> nextToken = new AtomicReference<>("bound-token-a");
      AtomicInteger metadataRequests = new AtomicInteger();
      MockHttpTransport metadataTransport = newMetadataTokenTransport(nextToken, metadataRequests);
      ComputeEngineCredentials source =
          ComputeEngineCredentials.newBuilder()
              .setHttpTransportFactory(() -> metadataTransport)
              .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
              .build();

      IamUtils.IamCallTarget targetA =
          IamUtils.resolveCallTarget(
              source, OAuth2Utils.HTTP_TRANSPORT_FACTORY, Credentials.GOOGLE_DEFAULT_UNIVERSE);
      assertTrue(targetA.usesMtls());
      assertEquals(1, metadataRequests.get());

      // Another thread rotates and refreshes source to token B before this thread enters 401 retry.
      configureAgentCertEnv(
          tempDir, "/agent/agent_spiffe_cert_chain.pem", "/agent/agent_spiffe_key.pem");
      nextToken.set("bound-token-b");
      source.refresh();
      assertEquals(2, metadataRequests.get());

      IamUtils.IamCallTarget retryTarget =
          IamUtils.refreshAndResolveRetryTarget(
              source,
              OAuth2Utils.HTTP_TRANSPORT_FACTORY,
              Credentials.GOOGLE_DEFAULT_UNIVERSE,
              targetA);

      assertNotNull(retryTarget);
      assertTrue(retryTarget.usesMtls());
      // Reused the already-refreshed token without making a third metadata request.
      assertEquals(2, metadataRequests.get());
      assertEquals(
          Collections.singletonList("Bearer bound-token-b"),
          retryTarget
              .credentials
              .getRequestMetadata(URI.create("https://iamcredentials.mtls.googleapis.com"))
              .get("Authorization"));
      assertEquals(
          2,
          ((MtlsHttpTransportFactory) retryTarget.transportFactory)
              .getKeyStore()
              .getCertificateChain("alias")
              .length);
    } finally {
      AgentIdentityUtils.resetForTest();
    }
  }

  @Test
  void resolveBoundTokenCallTarget_unboundToken_usesDefaultTarget() throws Exception {
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(new AccessToken("unbound-token", oneHourFromNow()));
    HttpTransportFactory defaultFactory = MockHttpTransport::new;

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            defaultFactory,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> {
              throw new AssertionError("mTLS transport must not be created");
            });

    assertFalse(target.usesMtls());
    assertSame(source, target.credentials);
    assertSame(defaultFactory, target.transportFactory);
    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, target.endpointDomain);
  }

  @Test
  void resolveBoundTokenCallTarget_boundTokenWithoutKeyStore_usesDefaultTarget() throws Exception {
    AgentIdentityUtils.CertInfo loaded = loadAgentCertInfo();
    AgentIdentityUtils.CertInfo withoutKey =
        new AgentIdentityUtils.CertInfo(loaded.getCertificate(), loaded.getCertContent());
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), withoutKey));

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            MockHttpTransport::new,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> {
              throw new AssertionError("mTLS transport must not be created");
            });

    assertFalse(target.usesMtls());
    assertSame(source, target.credentials);
  }

  @Test
  void resolveBoundTokenCallTarget_nonDefaultUniverse_usesDefaultTarget() throws Exception {
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), loadAgentCertInfo()));

    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            source,
            MockHttpTransport::new,
            "example.com",
            keyStore -> {
              throw new AssertionError("mTLS transport must not be created");
            });

    assertFalse(target.usesMtls());
    assertEquals("example.com", target.endpointDomain);
  }

  @Test
  void resolveBoundTokenCallTarget_notComputeEngineCredentials_usesDefaultTarget()
      throws Exception {
    IamUtils.IamCallTarget target =
        IamUtils.resolveBoundTokenCallTarget(
            credentials,
            MockHttpTransport::new,
            Credentials.GOOGLE_DEFAULT_UNIVERSE,
            keyStore -> {
              throw new AssertionError("mTLS transport must not be created");
            });

    assertFalse(target.usesMtls());
    assertSame(credentials, target.credentials);
  }

  @Test
  void resolveCallTarget_defaultTransportAndBoundToken_usesMtlsTransportFactory() throws Exception {
    AgentIdentityUtils.CertInfo certInfo = loadAgentCertInfo();
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), certInfo));

    IamUtils.IamCallTarget target =
        IamUtils.resolveCallTarget(
            source, OAuth2Utils.HTTP_TRANSPORT_FACTORY, Credentials.GOOGLE_DEFAULT_UNIVERSE);

    assertTrue(target.usesMtls());
    assertTrue(target.transportFactory instanceof MtlsHttpTransportFactory);
    assertSame(
        certInfo.getKeyStore(), ((MtlsHttpTransportFactory) target.transportFactory).getKeyStore());
  }

  @Test
  void resolveCallTarget_customTransportFactory_usesDefaultTarget() throws Exception {
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), loadAgentCertInfo()));
    HttpTransportFactory customFactory = MockHttpTransport::new;

    IamUtils.IamCallTarget target =
        IamUtils.resolveCallTarget(source, customFactory, Credentials.GOOGLE_DEFAULT_UNIVERSE);

    assertFalse(target.usesMtls());
    assertSame(customFactory, target.transportFactory);
  }

  @Test
  void resolveCallTarget_pinnedTokenCredentials_isNotSerializable() throws Exception {
    ComputeEngineCredentials source =
        computeEngineCredentialsWithToken(
            new BoundAccessToken("bound-token", oneHourFromNow(), loadAgentCertInfo()));

    IamUtils.IamCallTarget target =
        IamUtils.resolveCallTarget(
            source, OAuth2Utils.HTTP_TRANSPORT_FACTORY, Credentials.GOOGLE_DEFAULT_UNIVERSE);

    try (ObjectOutputStream out = new ObjectOutputStream(new ByteArrayOutputStream())) {
      assertThrows(NotSerializableException.class, () -> out.writeObject(target.credentials));
    }
  }
}
