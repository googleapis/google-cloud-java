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
import static org.junit.jupiter.api.Assertions.assertSame;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.json.Json;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.auth.mtls.MtlsHttpTransportFactory;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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

  private final List<String> requestUrls = new ArrayList<>();
  private final List<String> authorizationHeaders = new ArrayList<>();
  private final AtomicReference<KeyStore> keyStoreUsed = new AtomicReference<>();
  private AgentIdentityUtils.CertInfo certInfo;

  @BeforeEach
  void setUp() throws Exception {
    String certPath =
        Paths.get(IamMtlsRoutingTest.class.getResource("/agent/agent_spiffe_cert.pem").toURI())
            .toString();
    String keyPath =
        Paths.get(IamMtlsRoutingTest.class.getResource("/agent/agent_spiffe_key.pem").toURI())
            .toString();
    AgentIdentityUtils.resetForTest();
    certInfo = AgentIdentityUtils.loadAndVerifyCredentials(certPath, keyPath);
    AgentIdentityUtils.resetForTest();
    assertNotNull(certInfo.getKeyStore());

    IamUtils.setMtlsTransportFactoryProvider(
        keyStore -> {
          keyStoreUsed.set(keyStore);
          return (HttpTransportFactory) this::newRecordingIamTransport;
        });
  }

  @AfterEach
  void tearDown() {
    IamUtils.resetForTest();
    AgentIdentityUtils.resetForTest();
  }

  private MockHttpTransport newRecordingIamTransport() {
    return new MockHttpTransport() {
      @Override
      public LowLevelHttpRequest buildRequest(String method, String url) {
        requestUrls.add(url);
        return new MockLowLevelHttpRequest(url) {
          @Override
          public LowLevelHttpResponse execute() {
            List<String> authorization = getHeaderValues("Authorization");
            authorizationHeaders.add(authorization.isEmpty() ? null : authorization.get(0));
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

  private ComputeEngineCredentials boundSource() {
    ComputeEngineCredentials.Builder builder =
        ComputeEngineCredentials.newBuilder()
            .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    builder.setAccessToken(
        new BoundAccessToken(
            BOUND_TOKEN, new Date(System.currentTimeMillis() + 3_600_000L), certInfo));
    return builder.build();
  }

  private ImpersonatedCredentials impersonated(String iamEndpointOverride) {
    return ImpersonatedCredentials.newBuilder()
        .setSourceCredentials(boundSource())
        .setTargetPrincipal(TARGET)
        .setScopes(Collections.singletonList(OAuth2Utils.CLOUD_PLATFORM_SCOPE))
        .setLifetime(300)
        .setHttpTransportFactory(OAuth2Utils.HTTP_TRANSPORT_FACTORY)
        .setIamEndpointOverride(iamEndpointOverride)
        .build();
  }

  private void assertSentOverMtlsWithBoundToken(String expectedUrl) {
    assertEquals(Collections.singletonList(expectedUrl), requestUrls);
    assertEquals(Collections.singletonList("Bearer " + BOUND_TOKEN), authorizationHeaders);
    assertSame(certInfo.getKeyStore(), keyStoreUsed.get());
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
  void impersonatedWithEndpointOverride_refreshUsesOverrideAndSignUsesMtlsEndpoint()
      throws Exception {
    String override =
        "https://us-east1-iamcredentials.example.com/v1/projects/-/serviceAccounts/"
            + TARGET
            + ":generateAccessToken";
    ImpersonatedCredentials credentials = impersonated(override);

    credentials.sign("data".getBytes(StandardCharsets.UTF_8));

    assertSentOverMtlsWithBoundToken(MTLS_BASE + TARGET + ":signBlob");
    // refreshAccessToken() keeps using the override and the configured transport, not mTLS.
    requestUrls.clear();
    keyStoreUsed.set(null);
    ImpersonatedCredentials withMockTransport =
        credentials.toBuilder()
            .setHttpTransportFactory((HttpTransportFactory) this::newRecordingIamTransport)
            .build();
    withMockTransport.refreshAccessToken();
    assertEquals(Collections.singletonList(override), requestUrls);
    assertEquals(null, keyStoreUsed.get());
  }

  @Test
  void computeEngineSign_boundToken_usesMtlsEndpoint() {
    ComputeEngineCredentials source = Mockito.spy(boundSource());
    Mockito.doReturn(SOURCE_ACCOUNT).when(source).getAccount();

    byte[] signature = source.sign("data".getBytes(StandardCharsets.UTF_8));

    assertEquals("signature", new String(signature, StandardCharsets.UTF_8));
    assertSentOverMtlsWithBoundToken(MTLS_BASE + SOURCE_ACCOUNT + ":signBlob");
  }

  @Test
  void mtlsTransportFactory_fromBoundTokenKeyStore_createsTransport() {
    assertNotNull(new MtlsHttpTransportFactory(certInfo.getKeyStore()).create());
  }
}
