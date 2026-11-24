/*
 * Copyright 2019, Google LLC
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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.HttpStatusCodes;
import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.auth.Credentials;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/** Test case for {@link IdTokenCredentials}. */
class IdTokenCredentialsTest extends BaseSerializationTest {

  private TestEnvironmentProvider envProvider;

  @BeforeEach
  void setUp() {
    envProvider = new TestEnvironmentProvider();
    AgentIdentityUtils.setEnvironmentProvider(envProvider);
    envProvider.setEnv(AgentIdentityUtils.GOOGLE_API_ENABLE_RUNTIME_BOUND_TOKEN, "false");
  }

  @AfterEach
  void tearDown() {
    AgentIdentityUtils.resetForTest();
  }

  @Test
  void hashCode_equals() throws IOException {
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    IdTokenCredentials otherCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    otherCredential.refresh();
    assertEquals(tokenCredential, tokenCredential.toBuilder().build());
    assertEquals(tokenCredential.hashCode(), otherCredential.hashCode());
  }

  @Test
  void toString_equals() throws IOException {
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();

    IdTokenCredentials otherCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    otherCredential.refresh();

    assertEquals(tokenCredential.toString(), otherCredential.toString());
  }

  @Test
  void serialize() throws IOException, ClassNotFoundException {

    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setIdToken(ComputeEngineCredentialsTest.STANDARD_ID_TOKEN);
    ComputeEngineCredentials credentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    String targetAudience = "https://foo.bar";
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(credentials)
            .setTargetAudience(targetAudience)
            .build();
    tokenCredential.refresh();
    IdTokenCredentials deserializedCredentials = serializeAndDeserialize(tokenCredential);
    assertEquals(tokenCredential, deserializedCredentials);
  }

  @Test
  void getUniverseDomain_serviceAccountProvider_defaultUniverse() throws IOException {
    ServiceAccountCredentials serviceAccountCredentials =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail("client@example.com")
            .setPrivateKey(JwtCredentialsTest.getPrivateKey())
            .build();
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(serviceAccountCredentials)
            .setTargetAudience("https://foo.bar")
            .build();

    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, tokenCredential.getUniverseDomain());
  }

  @Test
  void getUniverseDomain_serviceAccountProvider_customUniverse() throws IOException {
    ServiceAccountCredentials serviceAccountCredentials =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail("client@example.com")
            .setPrivateKey(JwtCredentialsTest.getPrivateKey())
            .setUniverseDomain("example.com")
            .build();
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(serviceAccountCredentials)
            .setTargetAudience("https://foo.bar")
            .build();

    assertEquals("example.com", tokenCredential.getUniverseDomain());
  }

  @Test
  void getUniverseDomain_impersonatedProvider_delegatesToSource() throws IOException {
    ServiceAccountCredentials sourceCredentials =
        ServiceAccountCredentials.newBuilder()
            .setClientEmail("source@example.com")
            .setPrivateKey(JwtCredentialsTest.getPrivateKey())
            .setUniverseDomain("example.com")
            .build();
    ImpersonatedCredentials impersonatedCredentials =
        ImpersonatedCredentials.newBuilder()
            .setSourceCredentials(sourceCredentials)
            .setTargetPrincipal("target@example.com")
            .setScopes(Collections.singletonList("https://www.googleapis.com/auth/cloud-platform"))
            .build();
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(impersonatedCredentials)
            .setTargetAudience("https://foo.bar")
            .build();

    assertEquals("example.com", tokenCredential.getUniverseDomain());
  }

  @Test
  void getUniverseDomain_computeEngineProvider_lazyLookup() throws IOException {
    AtomicInteger universeDomainRequests = new AtomicInteger();
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport =
        new MockMetadataServerTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) throws IOException {
            if (url.equals(ComputeEngineCredentials.getUniverseDomainUrl())) {
              universeDomainRequests.incrementAndGet();
              return new MockLowLevelHttpRequest(url) {
                @Override
                public LowLevelHttpResponse execute() {
                  return new MockLowLevelHttpResponse()
                      .setStatusCode(HttpStatusCodes.STATUS_CODE_OK)
                      .setContent("example.com");
                }
              };
            }
            return super.buildRequest(method, url);
          }
        };
    ComputeEngineCredentials computeCredentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(computeCredentials)
            .setTargetAudience("https://foo.bar")
            .build();

    assertEquals(0, universeDomainRequests.get());
    assertEquals("example.com", tokenCredential.getUniverseDomain());
    assertEquals(1, universeDomainRequests.get());
    assertEquals("example.com", tokenCredential.getUniverseDomain());
    assertEquals(1, universeDomainRequests.get());
  }

  @Test
  void getUniverseDomain_computeEngineProvider_propagatesIoException() {
    ComputeEngineCredentialsTest.MockMetadataServerTransportFactory transportFactory =
        new ComputeEngineCredentialsTest.MockMetadataServerTransportFactory();
    transportFactory.transport.setStatusCode(501);
    ComputeEngineCredentials computeCredentials =
        ComputeEngineCredentials.newBuilder().setHttpTransportFactory(transportFactory).build();

    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(computeCredentials)
            .setTargetAudience("https://foo.bar")
            .build();

    assertThrows(IOException.class, tokenCredential::getUniverseDomain);
  }

  @Test
  void getUniverseDomain_nonCredentialsProvider_defaultsToGoogleDefaultUniverse()
      throws IOException {
    IdTokenProvider customProvider =
        new IdTokenProvider() {
          @Override
          public IdToken idTokenWithAudience(String targetAudience, List<Option> options) {
            return null;
          }
        };
    IdTokenCredentials tokenCredential =
        IdTokenCredentials.newBuilder()
            .setIdTokenProvider(customProvider)
            .setTargetAudience("https://foo.bar")
            .build();

    assertEquals(Credentials.GOOGLE_DEFAULT_UNIVERSE, tokenCredential.getUniverseDomain());
  }
}
