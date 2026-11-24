/*
 * Copyright 2026, Google Inc. All rights reserved.
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNotSame;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.api.client.http.HttpResponseException;
import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.GenericJson;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.Credentials;
import com.google.auth.ServiceAccountSigner.SigningException;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests that IAM Credentials calls authenticated with a certificate-bound agent identity token go
 * to the mTLS endpoint, over a transport built from the certificate the token was bound to, with
 * that token.
 */
class IamMtlsRoutingTest {

  private static final String TARGET = "target@project.iam.gserviceaccount.com";
  private static final String SOURCE_ACCOUNT = "agent@project.iam.gserviceaccount.com";
  private static final String BOUND_TOKEN = "bound-token";
  private static final String MTLS_BASE =
      "https://iamcredentials.mtls.googleapis.com/v1/projects/-/serviceAccounts/";

  @TempDir Path tempDir;

  private final List<String> requestUrls = new ArrayList<>();
  private final List<String> authorizationHeaders = new ArrayList<>();
  private final List<String> quotaProjectHeaders = new ArrayList<>();
  // KeyStore of the transport that actually executed each IAM request (null for default transport).
  private final List<KeyStore> requestKeyStores = new ArrayList<>();
  private final Deque<MockLowLevelHttpResponse> queuedIamResponses = new ArrayDeque<>();
  private final AtomicInteger metadataTokenRequests = new AtomicInteger();
  private String nextMetadataAccessToken = "refreshed-bound-token";
  private int metadataTokenStatusCode = HttpStatusCodes.STATUS_CODE_OK;
  private AgentIdentityUtils.CertInfo certInfo;

  // Subclasses DefaultHttpTransportFactory so IamUtils.resolveCallTarget treats it as the default
  // transport factory while still keeping metadata and non-mTLS IAM requests in memory.
  private final HttpTransportFactory defaultRecordingTransportFactory =
      new OAuth2Utils.DefaultHttpTransportFactory() {
        @Override
        public HttpTransport create() {
          return newDefaultTransport();
        }
      };

  @BeforeEach
  void setUp() throws Exception {
    String certPath = resourcePath("/agent/agent_spiffe_cert.pem");
    String keyPath = resourcePath("/agent/agent_spiffe_key.pem");
    AgentIdentityUtils.resetForTest();
    certInfo = AgentIdentityUtils.loadAndVerifyCredentials(certPath, keyPath);
    AgentIdentityUtils.resetForTest();
    AgentIdentityUtils.setEnvironmentProvider(new TestEnvironmentProvider());
    AgentIdentityUtils.setPropertyProvider(new TestPropertyProvider());
    AgentIdentityUtils.setWellKnownDir(tempDir.resolve("no-spiffe").toString());
    assertNotNull(certInfo.getKeyStore());

    // Record keyStore only when a request actually executes on the returned mTLS transport, not
    // when the factory is created.
    IamUtils.setMtlsTransportFactoryProvider(
        keyStore -> (HttpTransportFactory) () -> newRecordingIamTransport(keyStore));
  }

  @AfterEach
  void tearDown() {
    IamUtils.resetForTest();
    AgentIdentityUtils.resetForTest();
  }

  private static String resourcePath(String resource) throws Exception {
    return Paths.get(IamMtlsRoutingTest.class.getResource(resource).toURI()).toString();
  }

  private void configureAgentCertConfig(String certResource, String keyResource) throws Exception {
    Path configPath = tempDir.resolve("certificate_config.json");
    Map<String, Object> workload = new HashMap<>();
    workload.put("cert_path", resourcePath(certResource));
    workload.put("key_path", resourcePath(keyResource));
    Map<String, Object> certConfigs = new HashMap<>();
    certConfigs.put("workload", workload);
    Map<String, Object> config = new HashMap<>();
    config.put("cert_configs", certConfigs);
    Files.write(
        configPath, OAuth2Utils.JSON_FACTORY.toString(config).getBytes(StandardCharsets.UTF_8));

    TestEnvironmentProvider envProvider = new TestEnvironmentProvider();
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_CERTIFICATE_CONFIG, configPath.toString());
    AgentIdentityUtils.resetForTest();
    AgentIdentityUtils.setEnvironmentProvider(envProvider);
    AgentIdentityUtils.setPropertyProvider(new TestPropertyProvider());
    AgentIdentityUtils.setWellKnownDir(tempDir.resolve("no-spiffe").toString());
  }

  private void resetRecordedRequests() {
    requestUrls.clear();
    authorizationHeaders.clear();
    quotaProjectHeaders.clear();
    requestKeyStores.clear();
    queuedIamResponses.clear();
    metadataTokenRequests.set(0);
  }

  private void enqueueIamError(int statusCode, String reasonPhrase, String wwwAuthenticateHeader) {
    MockLowLevelHttpResponse errorResponse =
        new MockLowLevelHttpResponse().setStatusCode(statusCode).setReasonPhrase(reasonPhrase);
    if (wwwAuthenticateHeader != null) {
      errorResponse.addHeader("WWW-Authenticate", wwwAuthenticateHeader);
    }
    queuedIamResponses.add(errorResponse);
  }

  private MockHttpTransport newDefaultTransport() {
    MockHttpTransport nonMtlsIamTransport = newRecordingIamTransport(/* mtlsKeyStore= */ null);
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
        if (url.equals(ComputeEngineCredentials.getDefaultServiceAccountUrl())) {
          return new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() {
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setContent(SOURCE_ACCOUNT);
            }
          };
        }
        if (url.startsWith(ComputeEngineCredentials.getTokenServerEncodedUrl())) {
          return new MockLowLevelHttpRequest(url) {
            @Override
            public LowLevelHttpResponse execute() throws IOException {
              metadataTokenRequests.incrementAndGet();
              if (metadataTokenStatusCode != HttpStatusCodes.STATUS_CODE_OK) {
                return new MockLowLevelHttpResponse()
                    .setStatusCode(metadataTokenStatusCode)
                    .setContent("Metadata token error");
              }
              GenericJson refreshContents = new GenericJson();
              refreshContents.setFactory(OAuth2Utils.JSON_FACTORY);
              refreshContents.put("access_token", nextMetadataAccessToken);
              refreshContents.put("expires_in", 3600);
              refreshContents.put("token_type", "Bearer");
              return new MockLowLevelHttpResponse()
                  .setContentType(Json.MEDIA_TYPE)
                  .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                  .setContent(refreshContents.toPrettyString());
            }
          };
        }
        return nonMtlsIamTransport.buildRequest(method, url);
      }
    };
  }

  private MockHttpTransport newRecordingIamTransport(KeyStore mtlsKeyStore) {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        return new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() {
            requestUrls.add(url);
            requestKeyStores.add(mtlsKeyStore);
            List<String> authorization = getHeaderValues("Authorization");
            authorizationHeaders.add(authorization.isEmpty() ? null : authorization.get(0));
            List<String> quotaProject = getHeaderValues("x-goog-user-project");
            quotaProjectHeaders.add(quotaProject.isEmpty() ? null : quotaProject.get(0));
            MockLowLevelHttpResponse queued = queuedIamResponses.poll();
            if (queued != null) {
              return queued;
            }
            String content;
            if (url.endsWith(":generateAccessToken")) {
              content =
                  "{\"accessToken\": \"impersonated\", \"expireTime\": \"2099-01-01T00:00:00Z\"}";
            } else if (url.endsWith(":signBlob")) {
              content =
                  "{\"signedBlob\": \""
                      + Base64.getEncoder()
                          .encodeToString("signature".getBytes(StandardCharsets.UTF_8))
                      + "\"}";
            } else {
              content = "{\"token\": \"" + ComputeEngineCredentialsTest.STANDARD_ID_TOKEN + "\"}";
            }
            return new MockLowLevelHttpResponse()
                .setContentType(Json.MEDIA_TYPE)
                .setContent(content);
          }
        };
      }
    };
  }

  private ComputeEngineCredentials boundSource(String quotaProjectId) {
    ComputeEngineCredentials.Builder builder =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(defaultRecordingTransportFactory)
            .setQuotaProjectId(quotaProjectId)
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    builder.setAccessToken(
        new BoundAccessToken(
            BOUND_TOKEN, new Date(System.currentTimeMillis() + 3_600_000L), certInfo));
    return builder.build();
  }

  private ImpersonatedCredentials impersonated(String iamEndpointOverride) {
    return impersonated(iamEndpointOverride, null);
  }

  private ImpersonatedCredentials impersonated(String iamEndpointOverride, String quotaProjectId) {
    return ImpersonatedCredentials.newBuilder()
        .setSourceCredentials(boundSource(quotaProjectId))
        .setTargetPrincipal(TARGET)
        .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
        .setLifetime(300)
        .setHttpTransportFactory(defaultRecordingTransportFactory)
        .setIamEndpointOverride(iamEndpointOverride)
        .build();
  }

  private void assertSentOverMtlsWithBoundToken(String expectedUrl) {
    assertEquals(Collections.singletonList(expectedUrl), requestUrls);
    assertEquals(Collections.singletonList("Bearer " + BOUND_TOKEN), authorizationHeaders);
    assertEquals(1, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
  }

  @Test
  void impersonatedRefreshAccessToken_boundSource_usesMtlsEndpoint() throws Exception {
    AccessToken token = impersonated(null).refreshAccessToken();

    assertEquals("impersonated", token.getTokenValue());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateAccessToken");
  }

  @Test
  void impersonatedSign_boundSource_usesMtlsEndpoint() {
    byte[] signature = impersonated(null).sign("data".getBytes(StandardCharsets.UTF_8));

    assertEquals("signature", new String(signature, StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":signBlob");
  }

  @Test
  void impersonatedIdTokenWithAudience_boundSource_usesMtlsEndpoint() throws Exception {
    IdToken idToken = impersonated(null).idTokenWithAudience("https://example.com", null);

    assertNotNull(idToken);
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");
  }

  @Test
  void impersonatedWithEndpointOverride_refreshUsesOverrideAndSignAndIdTokenUseMtlsEndpoint()
      throws Exception {
    String override =
        "https://us-east1-iamcredentials.example.com/v1/projects/-/serviceAccounts/"
            + TARGET
            + ":generateAccessToken";
    ImpersonatedCredentials credentials = impersonated(override);

    credentials.sign("data".getBytes(StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":signBlob");

    resetRecordedRequests();
    credentials.idTokenWithAudience("https://example.com", null);
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");

    // refreshAccessToken() keeps using the override and the default-typed transport, not mTLS.
    resetRecordedRequests();
    credentials.refreshAccessToken();
    assertEquals(Collections.singletonList(override), requestUrls);
    assertEquals(Collections.singletonList("Bearer " + BOUND_TOKEN), authorizationHeaders);
    assertEquals(Collections.singletonList(null), requestKeyStores);
  }

  @Test
  void computeEngineSign_boundToken_usesMtlsEndpoint() {
    byte[] signature = boundSource(null).sign("data".getBytes(StandardCharsets.UTF_8));

    assertEquals("signature", new String(signature, StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + SOURCE_ACCOUNT + ":signBlob");
  }

  @Test
  void allMtlsIamCalls_boundSourceWithQuotaProject_preserveQuotaProjectHeader() throws Exception {
    String quotaProject = "agent-quota-project";
    ImpersonatedCredentials credentials = impersonated(null, quotaProject);

    credentials.refreshAccessToken();
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateAccessToken");
    assertEquals(Collections.singletonList(quotaProject), quotaProjectHeaders);

    resetRecordedRequests();
    credentials.sign("data".getBytes(StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":signBlob");
    assertEquals(Collections.singletonList(quotaProject), quotaProjectHeaders);

    resetRecordedRequests();
    credentials.idTokenWithAudience("https://example.com", null);
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");
    assertEquals(Collections.singletonList(quotaProject), quotaProjectHeaders);

    resetRecordedRequests();
    boundSource(quotaProject).sign("data".getBytes(StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + SOURCE_ACCOUNT + ":signBlob");
    assertEquals(Collections.singletonList(quotaProject), quotaProjectHeaders);
  }

  @Test
  void refreshAccessToken_boundSource401_refreshesAndRetriesOnceOverRotatedCert() throws Exception {
    configureAgentCertConfig("/agent/agent_spiffe_cert_chain.pem", "/agent/agent_spiffe_key.pem");
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");

    AccessToken token = impersonated(null).refreshAccessToken();

    assertEquals("impersonated", token.getTokenValue());
    assertEquals(1, metadataTokenRequests.get());
    String expectedUrl = MTLS_BASE + TARGET + ":generateAccessToken";
    assertEquals(Arrays.asList(expectedUrl, expectedUrl), requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNotNull(requestKeyStores.get(1));
    assertNotSame(certInfo.getKeyStore(), requestKeyStores.get(1));
    assertEquals(2, requestKeyStores.get(1).getCertificateChain("alias").length);
  }

  @Test
  void idTokenWithAudience_boundSource401_refreshesAndRetriesOnceOverRotatedCert()
      throws Exception {
    configureAgentCertConfig("/agent/agent_spiffe_cert_chain.pem", "/agent/agent_spiffe_key.pem");
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED,
        "Unauthorized",
        "Bearer realm=\"https://accounts.google.com/\"");

    IdToken idToken = impersonated(null).idTokenWithAudience("https://example.com", null);

    assertNotNull(idToken);
    assertEquals(1, metadataTokenRequests.get());
    String expectedUrl = MTLS_BASE + TARGET + ":generateIdToken";
    assertEquals(Arrays.asList(expectedUrl, expectedUrl), requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNotNull(requestKeyStores.get(1));
    assertNotSame(certInfo.getKeyStore(), requestKeyStores.get(1));
    assertEquals(2, requestKeyStores.get(1).getCertificateChain("alias").length);
  }

  @Test
  void refreshAccessTokenAndIdToken_boundSource401WithUnchangedToken_failsFastAfterSingleRefresh()
      throws Exception {
    configureAgentCertConfig("/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    nextMetadataAccessToken = BOUND_TOKEN;
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");

    IOException refreshEx =
        assertThrows(IOException.class, () -> impersonated(null).refreshAccessToken());
    assertTrue(refreshEx.getCause() instanceof HttpResponseException);
    assertEquals(1, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateAccessToken");

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    IOException idTokenEx =
        assertThrows(
            IOException.class,
            () -> impersonated(null).idTokenWithAudience("https://example.com", null));
    assertEquals("Error code 401 trying to getIDToken: Unauthorized", idTokenEx.getMessage());
    assertEquals(1, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");
  }

  @Test
  void refreshAccessTokenAndIdToken_boundSource403_doesNotRefreshOrRetry() {
    enqueueIamError(HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Forbidden", null);

    assertThrows(IOException.class, () -> impersonated(null).refreshAccessToken());
    assertEquals(0, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateAccessToken");

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_FORBIDDEN, "Forbidden", null);
    IOException idTokenEx =
        assertThrows(
            IOException.class,
            () -> impersonated(null).idTokenWithAudience("https://example.com", null));
    assertEquals("Error code 403 trying to getIDToken: Forbidden", idTokenEx.getMessage());
    assertEquals(0, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");
  }

  @Test
  void refreshAccessTokenAndIdToken_boundSource401Twice_retriesAtMostOnce() throws Exception {
    configureAgentCertConfig("/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");

    IOException refreshEx =
        assertThrows(IOException.class, () -> impersonated(null).refreshAccessToken());
    assertTrue(refreshEx.getCause() instanceof HttpResponseException);
    assertEquals(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED,
        ((HttpResponseException) refreshEx.getCause()).getStatusCode());
    assertEquals(1, refreshEx.getSuppressed().length);
    assertEquals(1, metadataTokenRequests.get());
    String refreshUrl = MTLS_BASE + TARGET + ":generateAccessToken";
    assertEquals(Arrays.asList(refreshUrl, refreshUrl), requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNotNull(requestKeyStores.get(1));

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    IOException idTokenEx =
        assertThrows(
            IOException.class,
            () -> impersonated(null).idTokenWithAudience("https://example.com", null));
    assertEquals("Error code 401 trying to getIDToken: Unauthorized", idTokenEx.getMessage());
    assertEquals(1, metadataTokenRequests.get());
    String idTokenUrl = MTLS_BASE + TARGET + ":generateIdToken";
    assertEquals(Arrays.asList(idTokenUrl, idTokenUrl), requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNotNull(requestKeyStores.get(1));
  }

  @Test
  void refreshAccessTokenAndIdToken_boundSource401ToUnboundToken_retriesOnceOnDefaultEndpoint() {
    // setUp leaves agent cert configuration absent, so source.refresh() mints an unbound token.
    String defaultBase = "https://iamcredentials.googleapis.com/v1/projects/-/serviceAccounts/";
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");

    assertThrows(IOException.class, () -> impersonated(null).refreshAccessToken());
    assertEquals(1, metadataTokenRequests.get());
    assertEquals(
        Arrays.asList(
            MTLS_BASE + TARGET + ":generateAccessToken",
            defaultBase + TARGET + ":generateAccessToken"),
        requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNull(requestKeyStores.get(1));

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    IOException idTokenEx =
        assertThrows(
            IOException.class,
            () -> impersonated(null).idTokenWithAudience("https://example.com", null));
    assertEquals("Error code 401 trying to getIDToken: Unauthorized", idTokenEx.getMessage());
    assertEquals(1, metadataTokenRequests.get());
    assertEquals(
        Arrays.asList(
            MTLS_BASE + TARGET + ":generateIdToken", defaultBase + TARGET + ":generateIdToken"),
        requestUrls);
    assertEquals(
        Arrays.asList("Bearer " + BOUND_TOKEN, "Bearer " + nextMetadataAccessToken),
        authorizationHeaders);
    assertEquals(2, requestKeyStores.size());
    assertSame(certInfo.getKeyStore(), requestKeyStores.get(0));
    assertNull(requestKeyStores.get(1));
  }

  @Test
  void refreshAccessTokenAndIdToken_boundSource401WhenRefreshFails_surfacesOriginal401()
      throws Exception {
    configureAgentCertConfig("/agent/agent_spiffe_cert.pem", "/agent/agent_spiffe_key.pem");
    metadataTokenStatusCode = HttpStatusCodes.STATUS_CODE_SERVER_ERROR;
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");

    IOException refreshEx =
        assertThrows(IOException.class, () -> impersonated(null).refreshAccessToken());
    assertTrue(refreshEx.getCause() instanceof HttpResponseException);
    assertEquals(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED,
        ((HttpResponseException) refreshEx.getCause()).getStatusCode());
    assertEquals(1, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateAccessToken");

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    IOException idTokenEx =
        assertThrows(
            IOException.class,
            () -> impersonated(null).idTokenWithAudience("https://example.com", null));
    assertEquals("Error code 401 trying to getIDToken: Unauthorized", idTokenEx.getMessage());
    assertEquals(1, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":generateIdToken");
  }

  @Test
  void sign_boundSource401_doesNotRetryPinnedToken() {
    enqueueIamError(
        HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", "Bearer error=\"invalid_token\"");
    assertThrows(
        SigningException.class,
        () -> impersonated(null).sign("data".getBytes(StandardCharsets.UTF_8)));
    assertEquals(0, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":signBlob");

    resetRecordedRequests();
    enqueueIamError(HttpStatusCodes.STATUS_CODE_UNAUTHORIZED, "Unauthorized", null);
    assertThrows(
        SigningException.class,
        () -> boundSource(null).sign("data".getBytes(StandardCharsets.UTF_8)));
    assertEquals(0, metadataTokenRequests.get());
    assertSentOverMtlsWithBoundToken(MTLS_BASE + SOURCE_ACCOUNT + ":signBlob");
  }

  @Test
  void mtlsTransportFactory_fromBoundTokenKeyStore_createsTransport() {
    assertNotNull(new MtlsHttpTransportFactory(certInfo.getKeyStore()).create());
  }
}
