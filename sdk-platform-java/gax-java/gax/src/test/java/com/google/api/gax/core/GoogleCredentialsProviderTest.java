/*
 * Copyright 2018 Google LLC
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
package com.google.api.gax.core;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.google.auth.Credentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.auth.oauth2.ServiceAccountJwtAccessCredentials;
import com.google.common.collect.ImmutableList;
import java.security.PrivateKey;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class GoogleCredentialsProviderTest {
  ServiceAccountCredentials CreateServiceAccountCredentials() {
    return ServiceAccountCredentials.newBuilder()
        .setClientId("fake-client-id")
        .setClientEmail("fake@example.com")
        .setPrivateKeyId("fake-private-key")
        .setPrivateKey(Mockito.mock(PrivateKey.class))
        .build();
  }

  @Test
  void serviceAccountReplacedWithJwtTokens() throws Exception {
    ServiceAccountCredentials serviceAccountCredentials = CreateServiceAccountCredentials();

    GoogleCredentialsProvider provider =
        GoogleCredentialsProvider.newBuilder()
            .setScopesToApply(ImmutableList.of("scope1", "scope2"))
            .setJwtEnabledScopes(ImmutableList.of("scope1"))
            .setOAuth2Credentials(serviceAccountCredentials)
            .build();

    Credentials credentials = provider.getCredentials();
    assertThat(credentials).isInstanceOf(ServiceAccountJwtAccessCredentials.class);
    ServiceAccountJwtAccessCredentials jwtCreds = (ServiceAccountJwtAccessCredentials) credentials;
    assertThat(jwtCreds.getClientId()).isEqualTo(serviceAccountCredentials.getClientId());
    assertThat(jwtCreds.getClientEmail()).isEqualTo(serviceAccountCredentials.getClientEmail());
    assertThat(jwtCreds.getPrivateKeyId()).isEqualTo(serviceAccountCredentials.getPrivateKeyId());
    assertThat(jwtCreds.getPrivateKey()).isEqualTo(serviceAccountCredentials.getPrivateKey());
    assertThat(jwtCreds.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void serviceAccountReplacedWithJwtTokens_setEmptyDomain() throws Exception {
    ServiceAccountCredentials serviceAccountCredentials =
        CreateServiceAccountCredentials().toBuilder().setUniverseDomain("").build();

    GoogleCredentialsProvider provider =
        GoogleCredentialsProvider.newBuilder()
            .setScopesToApply(ImmutableList.of("scope1", "scope2"))
            .setJwtEnabledScopes(ImmutableList.of("scope1"))
            .setOAuth2Credentials(serviceAccountCredentials)
            .build();

    Credentials credentials = provider.getCredentials();
    assertThat(credentials).isInstanceOf(ServiceAccountJwtAccessCredentials.class);
    ServiceAccountJwtAccessCredentials jwtCreds = (ServiceAccountJwtAccessCredentials) credentials;
    assertThat(jwtCreds.getClientId()).isEqualTo(serviceAccountCredentials.getClientId());
    assertThat(jwtCreds.getClientEmail()).isEqualTo(serviceAccountCredentials.getClientEmail());
    assertThat(jwtCreds.getPrivateKeyId()).isEqualTo(serviceAccountCredentials.getPrivateKeyId());
    assertThat(jwtCreds.getPrivateKey()).isEqualTo(serviceAccountCredentials.getPrivateKey());
    assertThat(jwtCreds.getUniverseDomain()).isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void serviceAccountReplacedWithJwtTokens_customUniverseDomain() throws Exception {
    ServiceAccountCredentials serviceAccountCredentials =
        CreateServiceAccountCredentials().toBuilder().setUniverseDomain("example.com").build();

    GoogleCredentialsProvider provider =
        GoogleCredentialsProvider.newBuilder()
            .setScopesToApply(ImmutableList.of("scope1", "scope2"))
            .setJwtEnabledScopes(ImmutableList.of("scope1"))
            .setOAuth2Credentials(serviceAccountCredentials)
            .build();

    Credentials credentials = provider.getCredentials();
    assertThat(credentials).isInstanceOf(ServiceAccountJwtAccessCredentials.class);
    ServiceAccountJwtAccessCredentials jwtCreds = (ServiceAccountJwtAccessCredentials) credentials;
    assertThat(jwtCreds.getClientId()).isEqualTo(serviceAccountCredentials.getClientId());
    assertThat(jwtCreds.getClientEmail()).isEqualTo(serviceAccountCredentials.getClientEmail());
    assertThat(jwtCreds.getPrivateKeyId()).isEqualTo(serviceAccountCredentials.getPrivateKeyId());
    assertThat(jwtCreds.getPrivateKey()).isEqualTo(serviceAccountCredentials.getPrivateKey());
    assertThat(jwtCreds.getUniverseDomain()).isEqualTo("example.com");
  }

  @Test
  void noJwtWithoutScopeMatch() throws Exception {
    ServiceAccountCredentials serviceAccountCredentials = CreateServiceAccountCredentials();

    GoogleCredentialsProvider provider =
        GoogleCredentialsProvider.newBuilder()
            .setScopesToApply(ImmutableList.of("scope1", "scope2"))
            .setJwtEnabledScopes(ImmutableList.of("other"))
            .setOAuth2Credentials(serviceAccountCredentials)
            .build();

    Credentials credentials = provider.getCredentials();
    assertThat(credentials).isInstanceOf(ServiceAccountCredentials.class);

    ServiceAccountCredentials serviceAccountCredentials2 = (ServiceAccountCredentials) credentials;
    assertThat(serviceAccountCredentials2.getClientId())
        .isEqualTo(serviceAccountCredentials.getClientId());
    assertThat(serviceAccountCredentials2.getClientEmail())
        .isEqualTo(serviceAccountCredentials.getClientEmail());
    assertThat(serviceAccountCredentials2.getPrivateKeyId())
        .isEqualTo(serviceAccountCredentials.getPrivateKeyId());
    assertThat(serviceAccountCredentials2.getPrivateKey())
        .isEqualTo(serviceAccountCredentials.getPrivateKey());
    assertThat(serviceAccountCredentials2.getScopes()).containsExactly("scope1", "scope2");
    assertThat(serviceAccountCredentials2.getUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void useJwtAccessWithScope() throws Exception {
    ServiceAccountCredentials serviceAccountCredentials = CreateServiceAccountCredentials();

    GoogleCredentialsProvider provider =
        GoogleCredentialsProvider.newBuilder()
            .setScopesToApply(ImmutableList.of("scope1", "scope2"))
            .setOAuth2Credentials(serviceAccountCredentials)
            .setUseJwtAccessWithScope(true)
            .build();

    Credentials credentials = provider.getCredentials();
    assertThat(credentials).isInstanceOf(ServiceAccountCredentials.class);

    ServiceAccountCredentials serviceAccountCredentials2 = (ServiceAccountCredentials) credentials;
    assertThat(serviceAccountCredentials2.getClientId())
        .isEqualTo(serviceAccountCredentials.getClientId());
    assertThat(serviceAccountCredentials2.getClientEmail())
        .isEqualTo(serviceAccountCredentials.getClientEmail());
    assertThat(serviceAccountCredentials2.getPrivateKeyId())
        .isEqualTo(serviceAccountCredentials.getPrivateKeyId());
    assertThat(serviceAccountCredentials2.getPrivateKey())
        .isEqualTo(serviceAccountCredentials.getPrivateKey());
    assertTrue(serviceAccountCredentials2.getUseJwtAccessWithScope());
    assertThat(serviceAccountCredentials2.getUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }
}
