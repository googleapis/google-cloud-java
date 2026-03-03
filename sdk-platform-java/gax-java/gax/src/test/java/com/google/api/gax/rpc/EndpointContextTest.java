/*
 * Copyright 2023 Google LLC
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
package com.google.api.gax.rpc;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.api.gax.core.NoCredentialsProvider;
import com.google.api.gax.rpc.internal.EnvironmentProvider;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.api.gax.rpc.testing.FakeMtlsProvider;
import com.google.auth.Credentials;
import com.google.auth.mtls.MtlsProvider;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.common.truth.Truth;
import io.grpc.Status;
import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class EndpointContextTest {
  private static final String DEFAULT_ENDPOINT = "test.googleapis.com:443";
  private static final String DEFAULT_MTLS_ENDPOINT = "test.mtls.googleapis.com:443";
  private EndpointContext.Builder defaultEndpointContextBuilder;
  private StatusCode statusCode;

  @BeforeEach
  void setUp() throws IOException {
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);
    defaultEndpointContextBuilder =
        EndpointContext.newBuilder()
            .setServiceName("test")
            .setUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint(DEFAULT_ENDPOINT)
            .setMtlsEndpoint(DEFAULT_MTLS_ENDPOINT)
            .setMtlsProvider(mtlsProvider);
    statusCode = Mockito.mock(StatusCode.class);
    Mockito.when(statusCode.getCode()).thenReturn(StatusCode.Code.UNAUTHENTICATED);
    Mockito.when(statusCode.getTransportCode()).thenReturn(Status.Code.UNAUTHENTICATED);
  }

  @Test
  void mtlsEndpointResolver_switchToMtlsAllowedIsFalse() throws IOException {
    boolean throwExceptionForGetKeyStore = false;
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(
            FakeMtlsProvider.createTestMtlsKeyStore(), "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = false;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "auto" : "true");
    Truth.assertThat(
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess))
        .isEqualTo(DEFAULT_ENDPOINT);
  }

  @Test
  void mtlsEndpointResolver_switchToMtlsAllowedIsTrue_mtlsUsageAuto() throws IOException {
    boolean throwExceptionForGetKeyStore = false;
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(
            FakeMtlsProvider.createTestMtlsKeyStore(), "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = true;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "auto" : "true");
    Truth.assertThat(
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess))
        .isEqualTo(DEFAULT_MTLS_ENDPOINT);
  }

  @Test
  void mtlsEndpointResolver_switchToMtlsAllowedIsTrue_mtlsUsageAlways() throws IOException {
    boolean throwExceptionForGetKeyStore = false;
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(
            FakeMtlsProvider.createTestMtlsKeyStore(), "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = true;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "always" : "true");
    Truth.assertThat(
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess))
        .isEqualTo(DEFAULT_MTLS_ENDPOINT);
  }

  @Test
  void mtlsEndpointResolver_switchToMtlsAllowedIsTrue_mtlsUsageNever() throws IOException {
    boolean throwExceptionForGetKeyStore = false;
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(
            FakeMtlsProvider.createTestMtlsKeyStore(), "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = true;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "never" : "true");
    Truth.assertThat(
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess))
        .isEqualTo(DEFAULT_ENDPOINT);
  }

  @Test
  void mtlsEndpointResolver_switchToMtlsAllowedIsTrue_useCertificateIsFalse_nullMtlsKeystore()
      throws IOException {
    boolean throwExceptionForGetKeyStore = false;
    MtlsProvider mtlsProvider = new FakeMtlsProvider(null, "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = true;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "auto" : "false");
    Truth.assertThat(
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess))
        .isEqualTo(DEFAULT_ENDPOINT);
  }

  @Test
  void mtlsEndpointResolver_getKeyStore_throwsIOException() throws IOException {
    boolean throwExceptionForGetKeyStore = true;
    MtlsProvider mtlsProvider = new FakeMtlsProvider(null, "", throwExceptionForGetKeyStore);
    boolean switchToMtlsEndpointAllowed = true;
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "auto" : "true");
    assertThrows(
        IOException.class,
        () ->
            defaultEndpointContextBuilder.mtlsEndpointResolver(
                DEFAULT_ENDPOINT,
                DEFAULT_MTLS_ENDPOINT,
                switchToMtlsEndpointAllowed,
                mtlsProvider,
                certificateBasedAccess));
  }

  @Test
  void endpointContextBuild_noUniverseDomain_usesClientSettingsEndpoint() throws IOException {
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setClientSettingsEndpoint(DEFAULT_ENDPOINT).build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_noUniverseDomain_usesTransportChannelProviderEndpoint()
      throws IOException {
    String transportChannelProviderEndpoint = "random.endpoint.com:443";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(null)
            .setTransportChannelProviderEndpoint(transportChannelProviderEndpoint)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint())
        .isEqualTo(transportChannelProviderEndpoint);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_noUniverseDomain_overrideUsesTransportChannelProviderEndpoint()
      throws IOException {
    String transportChannelProviderEndpoint = "random.endpoint.com";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(DEFAULT_ENDPOINT)
            .setTransportChannelProviderEndpoint(transportChannelProviderEndpoint)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint())
        .isEqualTo(transportChannelProviderEndpoint);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_emptyStringUniverseDomain_throwsIllegalArgumentException() {
    EndpointContext.Builder endpointContextBuilder =
        defaultEndpointContextBuilder.setUniverseDomain("");
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, endpointContextBuilder::build);
    Truth.assertThat(exception.getMessage())
        .isEqualTo("The universe domain value cannot be empty.");
  }

  @Test
  void endpointContextBuild_GDUUniverseDomain() throws IOException {
    EndpointContext endpointContext = defaultEndpointContextBuilder.build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_nonGDUUniverseDomain() throws IOException {
    String universeDomain = "random.com";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setUniverseDomain(universeDomain).build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(endpointContext.resolvedUniverseDomain()).isEqualTo(universeDomain);
  }

  @Test
  void endpointContextBuild_noUniverseDomain_noEndpoints() throws IOException {
    String expectedEndpoint = "random.googleapis.com:443";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setServiceName("random")
            .setClientSettingsEndpoint(null)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(expectedEndpoint);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_mtlsConfigured_GDU() throws IOException {
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "always" : "true");
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(null)
            .setTransportChannelProviderEndpoint(null)
            .setSwitchToMtlsEndpointAllowed(true)
            .setMtlsProvider(mtlsProvider)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_MTLS_ENDPOINT);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_mtlsConfigured_nonGDU_throwsIllegalArgumentException()
      throws IOException {
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);
    CertificateBasedAccess certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "always" : "true");
    EndpointContext.Builder endpointContextBuilder =
        defaultEndpointContextBuilder
            .setUniverseDomain("random.com")
            .setClientSettingsEndpoint(null)
            .setTransportChannelProviderEndpoint(null)
            .setSwitchToMtlsEndpointAllowed(true)
            .setMtlsProvider(mtlsProvider)
            .setCertificateBasedAccess(certificateBasedAccess);
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, endpointContextBuilder::build);
    Truth.assertThat(exception.getMessage())
        .isEqualTo("mTLS is not supported in any universe other than googleapis.com");
  }

  @Test
  void endpointContextBuild_gdchFlow_setUniverseDomain() throws IOException {
    EndpointContext.Builder endpointContextBuilder =
        defaultEndpointContextBuilder.setUsingGDCH(true);
    IllegalArgumentException exception =
        assertThrows(IllegalArgumentException.class, endpointContextBuilder::build);
    Truth.assertThat(exception.getMessage())
        .isEqualTo("Universe domain configuration is incompatible with GDC-H");
  }

  @Test
  void endpointContextBuild_gdchFlow_noUniverseDomain_noCustomEndpoint() throws IOException {
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setUniverseDomain(null)
            .setUsingGDCH(true)
            .setClientSettingsEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  @Test
  void endpointContextBuild_gdchFlow_noUniverseDomain_customEndpoint() throws IOException {
    String clientSettingsEndpoint = "random.endpoint.com:443";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setUniverseDomain(null)
            .setUsingGDCH(true)
            .setClientSettingsEndpoint(clientSettingsEndpoint)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(clientSettingsEndpoint);
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(Credentials.GOOGLE_DEFAULT_UNIVERSE);
  }

  // This Universe Domain should match the `GOOGLE_CLOUD_UNIVERSE_DOMAIN` Env Var
  // For this test running locally or in CI, check that the Env Var is set properly.
  // This test should only run when the maven profile `EnvVarTest` is enabled.
  @Test
  void endpointContextBuild_universeDomainEnvVarSet() throws IOException {
    String envVarUniverseDomain = "random.com";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setUniverseDomain(null)
            .setClientSettingsEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo("test.random.com:443");
    Truth.assertThat(endpointContext.resolvedUniverseDomain()).isEqualTo(envVarUniverseDomain);
  }

  // This Universe Domain should match the `GOOGLE_CLOUD_UNIVERSE_DOMAIN` Env Var
  // For this test running locally or in CI, check that the Env Var is set properly.
  // This test should only run when the maven profile `EnvVarTest` is enabled.
  @Test
  void endpointContextBuild_multipleUniverseDomainConfigurations_clientSettingsHasPriority()
      throws IOException {
    // This test has `GOOGLE_CLOUD_UNIVERSE_DOMAIN` = `random.com`
    String clientSettingsUniverseDomain = "clientSettingsUniverseDomain.com";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setUniverseDomain(clientSettingsUniverseDomain)
            .setClientSettingsEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedEndpoint())
        .isEqualTo("test.clientSettingsUniverseDomain.com:443");
    // Client Settings Universe Domain (if set) takes priority
    Truth.assertThat(endpointContext.resolvedUniverseDomain())
        .isEqualTo(clientSettingsUniverseDomain);
  }

  @Test
  void endpointContextBuild_shouldUseS2A_tlsEndpoint() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(false);
    EndpointContext endpointContext = defaultEndpointContextBuilder.build();
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isTrue();
    Truth.assertThat(endpointContext.resolvedEndpoint()).isEqualTo(DEFAULT_ENDPOINT);
  }

  @Test
  void hasValidUniverseDomain_gdchFlow_anyCredentials() throws IOException {
    Credentials noCredentials = NoCredentialsProvider.create().getCredentials();
    Credentials validCredentials = Mockito.mock(Credentials.class);
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setUniverseDomain(null).setUsingGDCH(true).build();
    endpointContext.validateUniverseDomain(noCredentials, statusCode);
    endpointContext.validateUniverseDomain(validCredentials, statusCode);
  }

  @Test
  void hasValidUniverseDomain_noCredentials_inGDU() throws IOException {
    Credentials noCredentials = NoCredentialsProvider.create().getCredentials();
    EndpointContext endpointContext = defaultEndpointContextBuilder.build();
    endpointContext.validateUniverseDomain(noCredentials, statusCode);
  }

  @Test
  void hasValidUniverseDomain_noCredentials_nonGDU() throws IOException {
    Credentials noCredentials = NoCredentialsProvider.create().getCredentials();
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setUniverseDomain("test.com").build();
    assertThrows(
        UnauthenticatedException.class,
        () -> endpointContext.validateUniverseDomain(noCredentials, statusCode));
  }

  @Test
  void hasValidUniverseDomain_credentialsInGDU_configInGDU() throws IOException {
    Credentials credentials = Mockito.mock(Credentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    EndpointContext endpointContext = defaultEndpointContextBuilder.build();
    endpointContext.validateUniverseDomain(credentials, statusCode);
  }

  // Non-GDU Universe Domain could be any domain, but this test refers uses `test.com`
  @Test
  void hasValidUniverseDomain_credentialsNonGDU_configInGDU() throws IOException {
    Credentials credentials = Mockito.mock(Credentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn("test.com");
    EndpointContext endpointContext = defaultEndpointContextBuilder.build();
    assertThrows(
        UnauthenticatedException.class,
        () -> endpointContext.validateUniverseDomain(credentials, statusCode));
  }

  // Non-GDU Universe Domain could be any domain, but this test refers uses `test.com`
  @Test
  void hasValidUniverseDomain_credentialsNonGDU_configNonGDU() throws IOException {
    Credentials credentials = Mockito.mock(Credentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn("test.com");
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setUniverseDomain("test.com").build();
    endpointContext.validateUniverseDomain(credentials, statusCode);
  }

  // Non-GDU Universe Domain could be any domain, but this test refers uses `test.com`
  @Test
  void hasValidUniverseDomain_credentialsInGDU_configNonGDU() throws IOException {
    Credentials credentials = Mockito.mock(Credentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    EndpointContext endpointContext =
        defaultEndpointContextBuilder.setUniverseDomain("test.com").build();
    assertThrows(
        UnauthenticatedException.class,
        () -> endpointContext.validateUniverseDomain(credentials, statusCode));
  }

  // (TODO: b/349488459) - Disable automatic requests to MDS until 01/2025
  // Test is to ensure that no validation is being run for ComputeEngineCredentials
  @Test
  void hasValidUniverseDomain_computeEngineCredentials_noValidationOnUniverseDomain()
      throws IOException {
    Credentials credentials = Mockito.mock(ComputeEngineCredentials.class);
    Mockito.when(credentials.getUniverseDomain()).thenReturn(Credentials.GOOGLE_DEFAULT_UNIVERSE);
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            // Set a custom Universe Domain that doesn't match
            .setUniverseDomain("test.com")
            .build();
    assertDoesNotThrow(() -> endpointContext.validateUniverseDomain(credentials, statusCode));
  }

  @Test
  void shouldUseS2A_envVarNotSet_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("false");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_UsingGDCH_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(true);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_customEndpointSetViaClientSettings_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("test.endpoint.com:443")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_customEndpointSetViaTransportChannelProvider_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("test.endpoint.com:443")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_mtlsEndpointNull_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(false)
            .setMtlsEndpoint(null);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_mtlsEndpointEmpty_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setMtlsEndpoint("")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_mtlsEndpointNotGoogleDefaultUniverse_returnsFalse() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setMtlsEndpoint("test.mtls.abcd.com:443")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isFalse();
  }

  @Test
  void shouldUseS2A_success() throws IOException {
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
    Mockito.when(envProvider.getenv(EndpointContext.S2A_ENV_ENABLE_USE_S2A)).thenReturn("true");
    defaultEndpointContextBuilder =
        defaultEndpointContextBuilder
            .setEnvProvider(envProvider)
            .setResolvedUniverseDomain(Credentials.GOOGLE_DEFAULT_UNIVERSE)
            .setClientSettingsEndpoint("")
            .setTransportChannelProviderEndpoint("")
            .setUsingGDCH(false);
    Truth.assertThat(defaultEndpointContextBuilder.shouldUseS2A()).isTrue();
  }

  @Test
  void endpointContextBuild_resolvesPortAndServerAddress() throws IOException {
    String endpoint = "http://localhost:7469";
    EndpointContext endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(endpoint)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedServerAddress()).isEqualTo("localhost");

    endpoint = "localhost:7469";
    endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(endpoint)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedServerAddress()).isEqualTo("localhost");

    endpoint = "test.googleapis.com:443";
    endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(endpoint)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedServerAddress()).isEqualTo("test.googleapis.com");

    // IPv6 literal with port
    endpoint = "[2001:db8::1]:443";
    endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(endpoint)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedServerAddress()).isEqualTo("2001:db8::1");

    // Bare IPv6 literal (no port)
    endpoint = "2001:db8::1";
    endpointContext =
        defaultEndpointContextBuilder
            .setClientSettingsEndpoint(endpoint)
            .setTransportChannelProviderEndpoint(null)
            .build();
    Truth.assertThat(endpointContext.resolvedServerAddress()).isEqualTo("2001:db8::1");
  }
}
