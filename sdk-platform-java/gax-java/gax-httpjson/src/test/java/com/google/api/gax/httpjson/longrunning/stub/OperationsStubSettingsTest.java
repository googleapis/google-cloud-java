/*
 * Copyright 2026 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
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
package com.google.api.gax.httpjson.longrunning.stub;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.client.http.LowLevelHttpRequest;
import com.google.api.client.http.LowLevelHttpResponse;
import com.google.api.client.testing.http.MockHttpTransport;
import com.google.api.client.testing.http.MockLowLevelHttpRequest;
import com.google.api.client.testing.http.MockLowLevelHttpResponse;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.httpjson.longrunning.OperationsSettings;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.UnauthenticatedException;
import com.google.auth.Credentials;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.net.URI;
import java.time.Duration;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class OperationsStubSettingsTest {

  private static final String CUSTOM_UNIVERSE_DOMAIN = "example.com";

  @Test
  void defaultEndpoint_usesDefaultUniverseDomain() throws IOException {
    OperationsStubSettings stubSettings = OperationsStubSettings.newBuilder().build();
    assertThat(stubSettings.getServiceName()).isEqualTo("longrunning");
    assertThat(stubSettings.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThat(stubSettings.getEndpoint()).isEqualTo("longrunning.googleapis.com:443");

    OperationsSettings clientSettings = OperationsSettings.newBuilder().build();
    assertThat(clientSettings.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    assertThat(clientSettings.getEndpoint()).isEqualTo("longrunning.googleapis.com:443");
  }

  @Test
  void customUniverseDomain_resolvesEndpointDynamically() throws IOException {
    OperationsStubSettings stubSettings =
        OperationsStubSettings.newBuilder().setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN).build();
    assertThat(stubSettings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(stubSettings.getEndpoint()).isEqualTo("longrunning.example.com:443");

    OperationsSettings clientSettings =
        OperationsSettings.newBuilder().setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN).build();
    assertThat(clientSettings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(clientSettings.getEndpoint()).isEqualTo("longrunning.example.com:443");
  }

  @Test
  void customUniverseDomainAndExplicitEndpoint_preservesExplicitEndpoint() throws IOException {
    String explicitEndpoint = "myservice.example.com:443";
    OperationsStubSettings settings =
        OperationsStubSettings.newBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setEndpoint(explicitEndpoint)
            .build();
    assertThat(settings.getUniverseDomain()).isEqualTo(CUSTOM_UNIVERSE_DOMAIN);
    assertThat(settings.getEndpoint()).isEqualTo(explicitEndpoint);
  }

  @Test
  void toBuilder_recomputesDefaultEndpointWhenUniverseDomainChanges() throws IOException {
    OperationsStubSettings defaultSettings = OperationsStubSettings.newBuilder().build();
    OperationsStubSettings customSettings =
        defaultSettings.toBuilder().setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN).build();
    assertThat(customSettings.getEndpoint()).isEqualTo("longrunning.example.com:443");

    String explicitEndpoint = "myservice.example.com:443";
    OperationsStubSettings explicitSettings =
        OperationsStubSettings.newBuilder().setEndpoint(explicitEndpoint).build();
    OperationsStubSettings updatedExplicitSettings =
        explicitSettings.toBuilder().setUniverseDomain("other.example.com").build();
    assertThat(updatedExplicitSettings.getEndpoint()).isEqualTo(explicitEndpoint);
  }

  @Test
  void standaloneOperationsClient_customUniverseDomain_routesRequestToCustomUniverse()
      throws IOException {
    AtomicReference<String> capturedUrl = new AtomicReference<>();
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            capturedUrl.set(url);
            return new MockLowLevelHttpRequest() {
              @Override
              public LowLevelHttpResponse execute() {
                MockLowLevelHttpResponse response = new MockLowLevelHttpResponse();
                response.setStatusCode(200);
                response.setContentType("application/json; charset=UTF-8");
                response.setContent("{\"name\":\"operations/test-op\",\"done\":true}");
                return response;
              }
            };
          }
        };

    OperationsSettings settings =
        OperationsSettings.newBuilder()
            .setUniverseDomain(CUSTOM_UNIVERSE_DOMAIN)
            .setCredentialsProvider(
                FixedCredentialsProvider.create(
                    new UniverseDomainCredentials(CUSTOM_UNIVERSE_DOMAIN)))
            .setTransportChannelProvider(
                OperationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockTransport)
                    .build())
            .build();

    try (OperationsClient client = OperationsClient.create(settings)) {
      Operation operation = client.getOperation("operations/test-op");
      assertThat(operation.getName()).isEqualTo("operations/test-op");
      assertThat(operation.getDone()).isTrue();
    }

    assertThat(capturedUrl.get()).startsWith("https://longrunning.example.com:443/");
    assertThat(capturedUrl.get()).doesNotContain("googleapis.com");
  }

  @Test
  void standaloneOperationsClient_universeDomainMismatch_throwsBeforeSendingRequest()
      throws IOException {
    AtomicInteger requestCount = new AtomicInteger();
    MockHttpTransport mockTransport =
        new MockHttpTransport() {
          @Override
          public LowLevelHttpRequest buildRequest(String method, String url) {
            requestCount.incrementAndGet();
            return new MockLowLevelHttpRequest();
          }
        };

    OperationsSettings settings =
        OperationsSettings.newBuilder()
            .setCredentialsProvider(
                FixedCredentialsProvider.create(
                    new UniverseDomainCredentials(CUSTOM_UNIVERSE_DOMAIN)))
            .setTransportChannelProvider(
                OperationsSettings.defaultHttpJsonTransportProviderBuilder()
                    .setHttpTransport(mockTransport)
                    .build())
            .build();

    try (OperationsClient client = OperationsClient.create(settings)) {
      assertThrows(UnauthenticatedException.class, () -> client.getOperation("operations/test-op"));
    }

    assertThat(requestCount.get()).isEqualTo(0);
  }

  @Test
  void newBuilderWithNullClientContext_initializesRetryDefaultsWithoutMtlsEndpoint()
      throws IOException {
    OperationsStubSettings settings =
        OperationsStubSettings.newBuilder((ClientContext) null).build();
    assertThat(settings.getMtlsEndpoint()).isNull();
    assertThat(settings.listOperationsSettings().getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE);
    assertThat(settings.getOperationSettings().getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE);
    assertThat(settings.deleteOperationSettings().getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE);
    assertThat(settings.cancelOperationSettings().getRetryableCodes())
        .containsExactly(StatusCode.Code.UNAVAILABLE);
    assertThat(settings.getOperationSettings().getRetrySettings().getTotalTimeoutDuration())
        .isEqualTo(Duration.ofMillis(10000L));
  }

  private static final class UniverseDomainCredentials extends Credentials {
    private final String universeDomain;

    private UniverseDomainCredentials(String universeDomain) {
      this.universeDomain = universeDomain;
    }

    @Override
    public String getAuthenticationType() {
      return "OAuth2";
    }

    @Override
    public Map<String, List<String>> getRequestMetadata(URI uri) {
      return Collections.singletonMap(
          "Authorization", Collections.singletonList("Bearer test-token-value"));
    }

    @Override
    public boolean hasRequestMetadata() {
      return true;
    }

    @Override
    public boolean hasRequestMetadataOnly() {
      return true;
    }

    @Override
    public void refresh() {}

    @Override
    public String getUniverseDomain() {
      return universeDomain;
    }
  }
}
