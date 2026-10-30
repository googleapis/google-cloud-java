/*
 * Copyright 2016 Google LLC
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
package com.google.api.gax.grpc;

import static com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.GCE_PRODUCTION_NAME_AFTER_2016;
import static com.google.api.gax.util.TimeConversionTestUtils.testDurationMethod;
import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.withSettings;

import com.google.api.core.ApiFunction;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.Builder;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider.HardBoundTokenTypes;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannel;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.internal.EnvironmentProvider;
import com.google.api.gax.rpc.mtls.AbstractMtlsTransportChannelTest;
import com.google.api.gax.rpc.mtls.CertificateBasedAccess;
import com.google.api.gax.rpc.testing.FakeMtlsProvider;
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.mtls.CertificateSourceUnavailableException;
import com.google.auth.mtls.MtlsProvider;
import com.google.auth.oauth2.CloudShellCredentials;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.SecureSessionAgent;
import com.google.auth.oauth2.SecureSessionAgentConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import io.grpc.CallCredentials;
import io.grpc.ChannelCredentials;
import io.grpc.CompositeChannelCredentials;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.alts.ComputeEngineChannelBuilder;
import io.grpc.auth.MoreCallCredentials;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.security.GeneralSecurityException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.stream.Collectors;
import org.jspecify.annotations.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

class InstantiatingGrpcChannelProviderTest extends AbstractMtlsTransportChannelTest {
  private static final String DEFAULT_ENDPOINT = "test.googleapis.com:443";
  private static final String API_KEY_HEADER_VALUE = "fake_api_key_2";
  private static final String API_KEY_AUTH_HEADER_KEY = "x-goog-api-key";
  private static String originalOSName;
  private ComputeEngineCredentials computeEngineCredentials;
  private CertificateBasedAccess certificateBasedAccess;

  @BeforeAll
  public static void setupClass() {
    originalOSName = System.getProperty("os.name");
  }

  @BeforeEach
  public void setup() throws IOException {
    computeEngineCredentials =
        mock(ComputeEngineCredentials.class, Mockito.withSettings().withoutAnnotations());
    certificateBasedAccess =
        new CertificateBasedAccess(
            name -> name.equals("GOOGLE_API_USE_MTLS_ENDPOINT") ? "never" : "false");
  }

  @AfterEach
  public void cleanup() {
    System.setProperty("os.name", originalOSName);
  }

  @Test
  void testEndpoint() {
    String endpoint = "localhost:8080";
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder();
    builder.setEndpoint(endpoint);
    assertEquals(builder.getEndpoint(), endpoint);

    InstantiatingGrpcChannelProvider provider = builder.build();
    assertEquals(provider.getEndpoint(), endpoint);
  }

  @Test
  void testEndpointNoPort() {
    assertThrows(
        IllegalArgumentException.class,
        () -> InstantiatingGrpcChannelProvider.newBuilder().setEndpoint("localhost"));
  }

  @Test
  void testEndpointBadPort() {
    assertThrows(
        IllegalArgumentException.class,
        () -> InstantiatingGrpcChannelProvider.newBuilder().setEndpoint("localhost:abcd"));
  }

  @Test
  void testKeepAlive() {
    final long millis = 15;
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder();
    Function<Duration, InstantiatingGrpcChannelProvider> javaTimeProviderSupplier =
        jt ->
            builder
                .setKeepAliveTimeDuration(jt)
                .setKeepAliveTimeoutDuration(jt)
                .setKeepAliveWithoutCalls(Boolean.TRUE)
                .build();
    Function<org.threeten.bp.Duration, InstantiatingGrpcChannelProvider> threetenProviderSupplier =
        tt ->
            builder
                .setKeepAliveTime(tt)
                .setKeepAliveTimeout(tt)
                .setKeepAliveWithoutCalls(Boolean.TRUE)
                .build();
    testDurationMethod(
        millis,
        javaTimeProviderSupplier,
        threetenProviderSupplier,
        c -> c.getKeepAliveTimeDuration(),
        c -> c.getKeepAliveTime());
    testDurationMethod(
        millis,
        javaTimeProviderSupplier,
        threetenProviderSupplier,
        c -> c.getKeepAliveTimeoutDuration(),
        c -> c.getKeepAliveTimeout());
    assertEquals(
        Boolean.TRUE,
        javaTimeProviderSupplier
            .apply(java.time.Duration.ofMillis(millis))
            .getKeepAliveWithoutCalls());
    assertEquals(
        Boolean.TRUE,
        threetenProviderSupplier
            .apply(org.threeten.bp.Duration.ofMillis(millis))
            .getKeepAliveWithoutCalls());
  }

  @Test
  void testMaxInboundMetadataSize() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().setMaxInboundMetadataSize(4096).build();
    assertThat(provider.getMaxInboundMetadataSize()).isEqualTo(4096);
  }

  @Test
  void testCpuPoolSize() {
    // happy path
    Builder builder = InstantiatingGrpcChannelProvider.newBuilder().setProcessorCount(2);
    builder.setChannelsPerCpu(2.5);
    assertEquals(5, builder.getPoolSize());

    // User specified max
    builder = builder.setProcessorCount(50);
    builder.setChannelsPerCpu(100, 10);
    assertEquals(10, builder.getPoolSize());

    // Sane default maximum
    builder.setChannelsPerCpu(200);
    assertEquals(100, builder.getPoolSize());
  }

  @Test
  void testWithPoolSize() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("localhost:8080");
    assertThat(provider.acceptsPoolSize()).isTrue();

    // Make sure we can create channels OK.
    provider.getTransportChannel().shutdownNow();

    provider = provider.withPoolSize(2);
    provider.getTransportChannel().shutdownNow();
  }

  @Test
  void testToBuilder() {
    java.time.Duration keepaliveTime = java.time.Duration.ofSeconds(1);
    java.time.Duration keepaliveTimeout = java.time.Duration.ofSeconds(2);
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        builder -> {
          throw new UnsupportedOperationException();
        };
    Map<String, ?> directPathServiceConfig = ImmutableMap.of("loadBalancingConfig", "pick_first");
    List<InstantiatingGrpcChannelProvider.HardBoundTokenTypes> hardBoundTokenTypes =
        new ArrayList<>();
    hardBoundTokenTypes.add(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS);
    hardBoundTokenTypes.add(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.MTLS_S2A);

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setProcessorCount(2)
            .setEndpoint("fake.endpoint:443")
            .setMaxInboundMessageSize(12345678)
            .setMaxInboundMetadataSize(4096)
            .setKeepAliveTimeDuration(keepaliveTime)
            .setKeepAliveTimeoutDuration(keepaliveTimeout)
            .setKeepAliveWithoutCalls(Boolean.TRUE)
            .setChannelConfigurator(channelConfigurator)
            .setChannelsPerCpu(2.5)
            .setDirectPathServiceConfig(directPathServiceConfig)
            .setAllowHardBoundTokenTypes(hardBoundTokenTypes)
            .build();

    InstantiatingGrpcChannelProvider.Builder builder = provider.toBuilder();

    assertThat(builder.getEndpoint()).isEqualTo("fake.endpoint:443");
    assertThat(builder.getMaxInboundMessageSize()).isEqualTo(12345678);
    assertThat(builder.getMaxInboundMetadataSize()).isEqualTo(4096);
    assertThat(builder.getKeepAliveTimeDuration()).isEqualTo(keepaliveTime);
    assertThat(builder.getKeepAliveTimeoutDuration()).isEqualTo(keepaliveTimeout);
    assertThat(builder.getChannelConfigurator()).isEqualTo(channelConfigurator);
    assertThat(builder.getPoolSize()).isEqualTo(5);
    assertThat(builder.build().directPathServiceConfig).isEqualTo(directPathServiceConfig);
  }

  @Test
  void testWithInterceptors() throws Exception {
    testWithInterceptors(1);
  }

  @Test
  void testWithInterceptorsAndMultipleChannels() throws Exception {
    testWithInterceptors(5);
  }

  private void testWithInterceptors(int numChannels) throws Exception {
    final GrpcInterceptorProvider interceptorProvider =
        mock(GrpcInterceptorProvider.class, Mockito.withSettings().withoutAnnotations());

    InstantiatingGrpcChannelProvider channelProvider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEndpoint("localhost:8080")
            .setPoolSize(numChannels)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setInterceptorProvider(interceptorProvider)
            .build();

    Mockito.verify(interceptorProvider, Mockito.never()).getInterceptors();
    channelProvider.getTransportChannel().shutdownNow();
    Mockito.verify(interceptorProvider, Mockito.times(numChannels)).getInterceptors();
  }

  @Test
  void testChannelConfigurator() throws IOException {
    final int numChannels = 5;

    // Create a mock configurator that will insert mock channels
    @SuppressWarnings("unchecked")
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        mock(ApiFunction.class, Mockito.withSettings().withoutAnnotations());

    ArgumentCaptor<ManagedChannelBuilder<?>> channelBuilderCaptor =
        ArgumentCaptor.forClass(ManagedChannelBuilder.class);

    ManagedChannelBuilder<?> swappedBuilder =
        mock(ManagedChannelBuilder.class, Mockito.withSettings().withoutAnnotations());
    ManagedChannel fakeChannel = mock(ManagedChannel.class);
    Mockito.when(swappedBuilder.build()).thenReturn(fakeChannel);

    Mockito.when(channelConfigurator.apply(channelBuilderCaptor.capture()))
        .thenReturn(swappedBuilder);

    // Invoke the provider
    InstantiatingGrpcChannelProvider.newBuilder()
        .setCertificateBasedAccess(certificateBasedAccess)
        .setEndpoint("localhost:8080")
        .setHeaderProvider(mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
        .setExecutor(mock(Executor.class))
        .setChannelConfigurator(channelConfigurator)
        .setPoolSize(numChannels)
        .build()
        .getTransportChannel();

    // Make sure that the provider passed in a configured channel
    assertThat(channelBuilderCaptor.getValue()).isNotNull();
    // And that it was replaced with the mock
    Mockito.verify(swappedBuilder, Mockito.times(numChannels)).build();
  }

  @Test
  void testWithGCECredentials() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("localhost:8080");

    assertThat(provider.needsCredentials()).isTrue();
    if (InstantiatingGrpcChannelProvider.isOnComputeEngine()) {
      provider = provider.withCredentials(ComputeEngineCredentials.create());
    } else {
      provider = provider.withCredentials(CloudShellCredentials.create(3000));
    }
    assertThat(provider.needsCredentials()).isFalse();

    provider.getTransportChannel().shutdownNow();
  }

  @Test
  void testDirectPathXdsDisableByDefault() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().setAttemptDirectPath(true).build();

    assertThat(provider.isDirectPathXdsEnabled()).isFalse();
  }

  @Test
  void testDirectPathDisallowNullCredentials() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();

    assertThat(provider.isCredentialDirectPathCompatible()).isFalse();
  }

  @Test
  void testDirectPathWithGDUEndpoint() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXds()
            .setEndpoint(DEFAULT_ENDPOINT)
            .build();
    assertThat(provider.canUseDirectPathWithUniverseDomain()).isTrue();
  }

  @Test
  void testDirectPathWithNonGDUEndpoint() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXds()
            .setEndpoint("test.random.com:443")
            .build();
    assertThat(provider.canUseDirectPathWithUniverseDomain()).isFalse();
  }

  @Test
  void testDirectPathXdsEnabled() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXds()
            .setEndpoint(DEFAULT_ENDPOINT)
            .build();

    assertThat(provider.isDirectPathXdsEnabled()).isTrue();
  }

  @Test
  void testWithNonGCECredentials() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelBuilder -> {
          // Clients with non-GCE credentials will not attempt DirectPath.
          assertThat(channelBuilder instanceof ComputeEngineChannelBuilder).isFalse();
          return channelBuilder;
        };

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setChannelConfigurator(channelConfigurator)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("localhost:8080");

    assertThat(provider.needsCredentials()).isTrue();
    provider = provider.withCredentials(CloudShellCredentials.create(3000));
    assertThat(provider.needsCredentials()).isFalse();

    provider.getTransportChannel().shutdownNow();
  }

  @Test
  void testWithDirectPathDisabled() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelBuilder -> {
          // Clients without setting attemptDirectPath flag will not attempt DirectPath
          assertThat(channelBuilder instanceof ComputeEngineChannelBuilder).isFalse();
          return channelBuilder;
        };

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(false)
            .setChannelConfigurator(channelConfigurator)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("localhost:8080");

    assertThat(provider.needsCredentials()).isTrue();
    provider = provider.withCredentials(ComputeEngineCredentials.create());
    assertThat(provider.needsCredentials()).isFalse();

    provider.getTransportChannel().shutdownNow();
  }

  @Test
  void testWithNoDirectPathFlagSet() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelBuilder -> {
          // Clients without setting attemptDirectPath flag will not attempt DirectPath
          assertThat(channelBuilder instanceof ComputeEngineChannelBuilder).isFalse();
          return channelBuilder;
        };

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setChannelConfigurator(channelConfigurator)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("localhost:8080");

    assertThat(provider.needsCredentials()).isTrue();
    provider = provider.withCredentials(ComputeEngineCredentials.create());
    assertThat(provider.needsCredentials()).isFalse();

    provider.getTransportChannel().shutdownNow();
  }

  @Test
  void testWithIPv6Address() throws IOException {
    ScheduledExecutorService executor = new ScheduledThreadPoolExecutor(1);
    executor.shutdown();

    TransportChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build()
            .withExecutor((Executor) executor)
            .withHeaders(Collections.<String, String>emptyMap())
            .withEndpoint("[::1]:8080");
    assertThat(provider.needsEndpoint()).isFalse();

    // Make sure we can create channels OK.
    provider.getTransportChannel().shutdownNow();
  }

  // Test that if ChannelPrimer is provided, it is called during creation
  @Test
  void testWithPrimeChannel() throws IOException {
    // create channelProvider with different pool sizes to verify ChannelPrimer is called the
    // correct number of times
    for (int poolSize = 1; poolSize < 5; poolSize++) {
      final ChannelPrimer mockChannelPrimer =
          mock(ChannelPrimer.class, Mockito.withSettings().withoutAnnotations());

      InstantiatingGrpcChannelProvider provider =
          InstantiatingGrpcChannelProvider.newBuilder()
              .setEndpoint("localhost:8080")
              .setPoolSize(poolSize)
              .setHeaderProvider(
                  mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
              .setExecutor(mock(Executor.class))
              .setChannelPrimer(mockChannelPrimer)
              .setCertificateBasedAccess(certificateBasedAccess)
              .build();

      provider.getTransportChannel().shutdownNow();

      // every channel in the pool should call primeChannel during creation.
      Mockito.verify(mockChannelPrimer, Mockito.times(poolSize))
          .primeChannel(Mockito.any(ManagedChannel.class));
    }
  }

  @Test
  void testWithDefaultDirectPathServiceConfig() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();

    ImmutableMap<String, ?> defaultServiceConfig = provider.directPathServiceConfig;

    List<Map<String, ?>> lbConfigs = getAsObjectList(defaultServiceConfig, "loadBalancingConfig");
    assertThat(lbConfigs).hasSize(1);
    Map<String, ?> lbConfig = lbConfigs.get(0);
    assertThat(lbConfig.keySet()).containsExactly("pick_first");
  }

  private static @Nullable Map<String, ?> getAsObject(Map<String, ?> json, String key) {
    Object mapObject = json.get(key);
    if (mapObject == null) {
      return null;
    }
    return checkObject(mapObject);
  }

  @SuppressWarnings("unchecked")
  private static Map<String, ?> checkObject(Object json) {
    checkArgument(json instanceof Map, "Invalid json object representation: %s", json);
    for (Map.Entry<Object, Object> entry : ((Map<Object, Object>) json).entrySet()) {
      checkArgument(entry.getKey() instanceof String, "Key is not string");
    }
    return (Map<String, ?>) json;
  }

  private static List<Map<String, ?>> getAsObjectList(Map<String, ?> json, String key) {
    Object listObject = json.get(key);
    if (listObject == null) {
      return null;
    }
    return checkListOfObjects(listObject);
  }

  @SuppressWarnings("unchecked")
  private static List<Map<String, ?>> checkListOfObjects(Object listObject) {
    checkArgument(listObject instanceof List, "Passed object is not a list");
    List<Map<String, ?>> list = new ArrayList<>();
    for (Object object : ((List<Object>) listObject)) {
      list.add(checkObject(object));
    }
    return list;
  }

  @Test
  void testWithCustomDirectPathServiceConfig() {
    ImmutableMap<String, Object> pickFirstStrategy =
        ImmutableMap.<String, Object>of("round_robin", ImmutableMap.of());
    ImmutableMap<String, Object> childPolicy =
        ImmutableMap.<String, Object>of(
            "childPolicy", ImmutableList.of(pickFirstStrategy), "foo", "bar");
    ImmutableMap<String, Object> customLbPolicy =
        ImmutableMap.<String, Object>of("my_custom_lb", childPolicy);
    Map<String, Object> passedServiceConfig = new HashMap<>();
    passedServiceConfig.put("loadBalancingConfig", ImmutableList.of(customLbPolicy));

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setDirectPathServiceConfig(passedServiceConfig)
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();

    ImmutableMap<String, ?> defaultServiceConfig = provider.directPathServiceConfig;
    assertThat(defaultServiceConfig).isEqualTo(passedServiceConfig);
  }

  @Override
  protected Object getMtlsObjectFromTransportChannel(
      MtlsProvider provider, CertificateBasedAccess certificateBasedAccess)
      throws IOException, GeneralSecurityException {
    InstantiatingGrpcChannelProvider channelProvider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setEndpoint("localhost:8080")
            .setMtlsProvider(provider)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .build();
    return channelProvider.createMtlsChannelCredentials();
  }

  private InstantiatingGrpcChannelProvider.Builder
      createChannelProviderBuilderForDirectPathLogTests() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setHeaderProvider(mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
        .setExecutor(mock(Executor.class))
        .setEndpoint("localhost:8080");
  }

  private void createAndCloseTransportChannel(InstantiatingGrpcChannelProvider provider)
      throws Exception {
    TransportChannel transportChannel = provider.getTransportChannel();
    transportChannel.close();
    transportChannel.awaitTermination(10, TimeUnit.SECONDS);
  }

  @Test
  void
      testLogDirectPathMisconfig_AttemptDirectPathNotSetAndAttemptDirectPathXdsSetViaBuilder_warns()
          throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        createChannelProviderBuilderForDirectPathLogTests()
            .setAttemptDirectPathXds()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    createAndCloseTransportChannel(provider);
    assertThat(logHandler.getAllMessages())
        .contains(
            "DirectPath is misconfigured. The DirectPath XDS option was set, but the"
                + " attemptDirectPath option was not. Please set both the attemptDirectPath and"
                + " attemptDirectPathXds options.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfig_AttemptDirectPathNotSetAndAttemptDirectPathXdsSetViaEnv_warns()
      throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);

    InstantiatingGrpcChannelProvider provider =
        createChannelProviderBuilderForDirectPathLogTests()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    createAndCloseTransportChannel(provider);
    assertThat(logHandler.getAllMessages())
        .contains(
            "Env var GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS was found and set to TRUE, but DirectPath"
                + " was not enabled for this client. If this is intended for this client, please"
                + " note that this is a misconfiguration and set the attemptDirectPath option as"
                + " well.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfig_shouldNotLogInTheBuilder() {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider.newBuilder()
        .setAttemptDirectPathXds()
        .setAttemptDirectPath(true)
        .setCertificateBasedAccess(certificateBasedAccess)
        .build();

    assertThat(logHandler.getAllMessages()).isEmpty();
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfigWrongCredential() throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPathXds()
            .setAttemptDirectPath(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEnvProvider(envProvider)
            .build();

    TransportChannel transportChannel = provider.getTransportChannel();

    assertThat(logHandler.getAllMessages())
        .contains(
            "DirectPath is misconfigured. Please make sure the credential is an instance of"
                + " com.google.auth.oauth2.ComputeEngineCredentials .");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);

    transportChannel.close();
    transportChannel.awaitTermination(10, TimeUnit.SECONDS);
  }

  @Test
  void testLogDirectPathMisconfigNotOnGCE() throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPathXds()
            .setAttemptDirectPath(true)
            .setAllowNonDefaultServiceAccount(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEnvProvider(envProvider)
            .build();

    TransportChannel transportChannel = provider.getTransportChannel();

    if (!InstantiatingGrpcChannelProvider.isOnComputeEngine()) {
      assertThat(logHandler.getAllMessages())
          .contains(
              "DirectPath is misconfigured. DirectPath is only available in a GCE environment.");
    }
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);

    transportChannel.close();
    transportChannel.awaitTermination(10, TimeUnit.SECONDS);
  }

  @Test
  public void canUseDirectPath_happyPath() throws IOException {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()));
    Truth.assertThat(builder.isDirectPathBoundTokenEnabled()).isFalse();
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();

    // verify this info is passed correctly to transport channel
    TransportChannel transportChannel = provider.getTransportChannel();
    Truth.assertThat(((GrpcTransportChannel) transportChannel).isDirectPath()).isTrue();
    transportChannel.shutdownNow();
  }

  @Test
  public void canUseDirectPath_boundTokenNotEnabledWithNonComputeCredentials() {
    System.setProperty("os.name", "Linux");
    Credentials credentials = mock(Credentials.class, Mockito.withSettings().withoutAnnotations());
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAllowHardBoundTokenTypes(Collections.singletonList(HardBoundTokenTypes.ALTS))
            .setCredentials(credentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    Truth.assertThat(builder.isDirectPathBoundTokenEnabled()).isFalse();
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_happyPathWithBoundToken() throws IOException {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    // verify the credentials gets called and returns a non-null builder.
    Mockito.when(computeEngineCredentials.toBuilder())
        .thenReturn(ComputeEngineCredentials.newBuilder());
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setAllowHardBoundTokenTypes(Collections.singletonList(HardBoundTokenTypes.ALTS))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()));
    Truth.assertThat(builder.isDirectPathBoundTokenEnabled()).isTrue();
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();

    // verify this info is passed correctly to transport channel
    TransportChannel transportChannel = provider.getTransportChannel();
    Truth.assertThat(((GrpcTransportChannel) transportChannel).isDirectPath()).isTrue();
    transportChannel.shutdownNow();
  }

  @Test
  public void canUseDirectPath_directPathEnvVarDisabled() throws IOException {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("true");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()));
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();

    // verify this info is passed correctly to transport channel
    TransportChannel transportChannel = provider.getTransportChannel();
    Truth.assertThat(((GrpcTransportChannel) transportChannel).isDirectPath()).isFalse();
    transportChannel.shutdownNow();
  }

  @Test
  public void canUseDirectPath_directPathEnvVarNotSet_attemptDirectPathIsTrue() {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider = name -> null;
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();
  }

  @Test
  public void canUseDirectPath_directPathEnvVarNotSet_attemptDirectPathIsFalse() {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider = name -> null;
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(false)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_nonComputeCredentials() {
    System.setProperty("os.name", "Linux");
    Credentials credentials = mock(Credentials.class, Mockito.withSettings().withoutAnnotations());
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(credentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_attemptDirectPathXdsOverInterconnect_bypassesGceCheck() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(credentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");
    Truth.assertThat(provider.canUseDirectPath()).isTrue();
  }

  @Test
  public void
      canUseDirectPath_attemptDirectPathXdsOverInterconnect_directPathDisabled_returnsFalse() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(false)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(credentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void
      canUseDirectPath_attemptDirectPathXdsOverInterconnect_nonGDUUniverseDomain_returnsFalse() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(credentials)
            .setEndpoint("test.random.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void getTransportChannel_storageTarget_withInterconnect()
      throws IOException, InterruptedException {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    final java.util.concurrent.atomic.AtomicReference<String> capturedTarget =
        new java.util.concurrent.atomic.AtomicReference<>();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelBuilder -> {
          capturedTarget.set(extractTargetFromChannelBuilder(channelBuilder));
          return channelBuilder;
        };

    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(credentials)
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider)
            .setChannelConfigurator(channelConfigurator);

    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");

    InstantiatingGrpcChannelProvider configuredProvider =
        (InstantiatingGrpcChannelProvider)
            provider
                .withHeaders(Collections.<String, String>emptyMap())
                .withEndpoint("storage.googleapis.com:443");

    TransportChannel transportChannel = configuredProvider.getTransportChannel();
    transportChannel.shutdownNow();
    transportChannel.awaitTermination(5, TimeUnit.SECONDS);

    Truth.assertThat(capturedTarget.get())
        .contains("google-c2p:///storage-direct.googleapis.com?force-xds");
  }

  @Test
  public void
      getTransportChannel_storageTarget_withInterconnectAndNullCredentials_fallsBackToCloudPath()
          throws IOException, InterruptedException {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    final java.util.concurrent.atomic.AtomicReference<String> capturedTarget =
        new java.util.concurrent.atomic.AtomicReference<>();
    ApiFunction<ManagedChannelBuilder, ManagedChannelBuilder> channelConfigurator =
        channelBuilder -> {
          capturedTarget.set(extractTargetFromChannelBuilder(channelBuilder));
          return channelBuilder;
        };

    // Interconnect accepts any service credentials but, like standard DirectPath, requires some:
    // the channel credentials carry the call credentials, so without them the channel uses
    // CloudPath.
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(null)
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider)
            .setChannelConfigurator(channelConfigurator);

    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");

    InstantiatingGrpcChannelProvider configuredProvider =
        (InstantiatingGrpcChannelProvider)
            provider
                .withHeaders(Collections.<String, String>emptyMap())
                .withEndpoint("storage.googleapis.com:443");

    Truth.assertThat(configuredProvider.isCredentialDirectPathCompatible()).isFalse();
    Truth.assertThat(configuredProvider.canUseDirectPath()).isFalse();

    TransportChannel transportChannel = configuredProvider.getTransportChannel();
    transportChannel.shutdownNow();
    transportChannel.awaitTermination(5, TimeUnit.SECONDS);

    Truth.assertThat(capturedTarget.get()).isEqualTo("storage.googleapis.com:443");
  }

  private static final String INTERCONNECT_CREDENTIALS_REQUIRED_MESSAGE =
      "DirectPath over Interconnect is misconfigured. Credentials are required; without them the"
          + " channel falls back to CloudPath.";
  private static final String INTERCONNECT_DIRECT_PATH_NOT_ENABLED_MESSAGE =
      "DirectPath over Interconnect is misconfigured. The attemptDirectPathXdsOverInterconnect"
          + " option or the "
          + InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT
          + " environment variable was set, but DirectPath is not enabled for this client. Please"
          + " set the attemptDirectPath option as well, and make sure "
          + InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH
          + " is not set to true.";

  /**
   * Builds the provider's transport channel off GCE and returns the misconfiguration log records,
   * at every level, that building it produced.
   */
  private FakeLogHandler logDirectPathMisconfigOffGce(
      InstantiatingGrpcChannelProvider.Builder builder) throws Exception {
    System.setProperty("os.name", "Not Linux");
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    try {
      createAndCloseTransportChannel(
          builder.setCertificateBasedAccess(certificateBasedAccess).build());
    } finally {
      InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
    }
    return logHandler;
  }

  private static EnvironmentProvider envProviderWithDirectPathEnabled() {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    return envProvider;
  }

  @Test
  void logDirectPathMisconfig_interconnectWithoutCredentials_warnsCredentialsRequired()
      throws Exception {
    FakeLogHandler logHandler =
        logDirectPathMisconfigOffGce(
            createChannelProviderBuilderForDirectPathLogTests()
                .setAttemptDirectPath(true)
                .setAttemptDirectPathXdsOverInterconnect(true)
                .setEnvProvider(envProviderWithDirectPathEnabled()));

    // Interconnect runs off GCE, so its misconfigurations are warnings there, unlike standard
    // DirectPath's.
    assertThat(logHandler.levelsOf(INTERCONNECT_CREDENTIALS_REQUIRED_MESSAGE))
        .containsExactly(Level.WARNING);
    // The standard DirectPath message would wrongly ask for ComputeEngineCredentials.
    assertThat(logHandler.getAllMessages())
        .doesNotContain(
            "DirectPath is misconfigured. Please make sure the credential is an instance of "
                + ComputeEngineCredentials.class.getName()
                + " .");
  }

  @Test
  void logDirectPathMisconfig_interconnectWithoutAttemptDirectPath_warns() throws Exception {
    FakeLogHandler logHandler =
        logDirectPathMisconfigOffGce(
            createChannelProviderBuilderForDirectPathLogTests()
                .setAttemptDirectPathXdsOverInterconnect(true)
                .setEnvProvider(envProviderWithDirectPathEnabled()));

    assertThat(logHandler.levelsOf(INTERCONNECT_DIRECT_PATH_NOT_ENABLED_MESSAGE))
        .containsExactly(Level.WARNING);
  }

  @Test
  void logDirectPathMisconfig_interconnectEnvVarWithoutAttemptDirectPath_warns() throws Exception {
    EnvironmentProvider envProvider = envProviderWithDirectPathEnabled();
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn("true");

    FakeLogHandler logHandler =
        logDirectPathMisconfigOffGce(
            createChannelProviderBuilderForDirectPathLogTests().setEnvProvider(envProvider));

    assertThat(logHandler.levelsOf(INTERCONNECT_DIRECT_PATH_NOT_ENABLED_MESSAGE))
        .containsExactly(Level.WARNING);
  }

  @Test
  void logDirectPathMisconfig_interconnectWithDirectPathKillSwitch_warns() throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("true");

    // Storage, Bigtable and Spanner also set the xDS option alongside attemptDirectPath.
    FakeLogHandler logHandler =
        logDirectPathMisconfigOffGce(
            createChannelProviderBuilderForDirectPathLogTests()
                .setAttemptDirectPath(true)
                .setAttemptDirectPathXds()
                .setAttemptDirectPathXdsOverInterconnect(true)
                .setEnvProvider(envProvider));

    // The kill switch disables DirectPath as a whole; the message names it as a possible cause.
    assertThat(logHandler.levelsOf(INTERCONNECT_DIRECT_PATH_NOT_ENABLED_MESSAGE))
        .containsExactly(Level.WARNING);
    // The xDS message would wrongly report that attemptDirectPath was not set.
    assertThat(logHandler.getAllMessages())
        .doesNotContain(
            "DirectPath is misconfigured. The DirectPath XDS option was set, but the"
                + " attemptDirectPath option was not. Please set both the attemptDirectPath and"
                + " attemptDirectPathXds options.");
  }

  @Test
  void logDirectPathMisconfig_offGceWithoutInterconnect_logsAtFine() throws Exception {
    // Standard DirectPath keeps its off-GCE level; only Interconnect misconfigurations warn.
    FakeLogHandler logHandler =
        logDirectPathMisconfigOffGce(
            createChannelProviderBuilderForDirectPathLogTests()
                .setAttemptDirectPathXds()
                .setEnvProvider(envProviderWithDirectPathEnabled()));

    assertThat(
            logHandler.levelsOf(
                "DirectPath is misconfigured. The DirectPath XDS option was set, but the"
                    + " attemptDirectPath option was not. Please set both the attemptDirectPath and"
                    + " attemptDirectPathXds options."))
        .containsExactly(Level.FINE);
  }

  @Test
  public void canUseDirectPath_isNotOnComputeEngine_invalidOsNameSystemProperty() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_isNotOnComputeEngine_invalidSystemProductName() {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "testing");
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_isNotOnComputeEngine_unableToGetSystemProductName() {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider = new InstantiatingGrpcChannelProvider(builder, "");
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_nonGDUUniverseDomain() {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    String nonGDUEndpoint = "test.random.com:443";
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(nonGDUEndpoint)
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  void providerInitializedWithNonConflictingHeaders_retainsHeaders() {
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setHeaderProvider(getHeaderProviderWithApiKeyHeader())
            .setEndpoint("test.random.com:443");

    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(1, provider.headersWithDuplicatesRemoved.size());
    assertEquals(
        API_KEY_HEADER_VALUE, provider.headersWithDuplicatesRemoved.get(API_KEY_AUTH_HEADER_KEY));
  }

  @Test
  void providersInitializedWithConflictingApiKeyCredentialHeaders_removesDuplicates() {
    String correctApiKey = "fake_api_key";
    ApiKeyCredentials apiKeyCredentials = ApiKeyCredentials.create(correctApiKey);
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(apiKeyCredentials)
            .setHeaderProvider(getHeaderProviderWithApiKeyHeader())
            .setEndpoint("test.random.com:443");

    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(0, provider.headersWithDuplicatesRemoved.size());
    assertNull(provider.headersWithDuplicatesRemoved.get(API_KEY_AUTH_HEADER_KEY));
  }

  @Test
  void providersInitializedWithConflictingNonApiKeyCredentialHeaders_doesNotRemoveDuplicates() {
    String authProvidedHeader = "Bearer token";
    Map<String, String> header = new HashMap<>();
    header.put(AuthHttpConstants.AUTHORIZATION, authProvidedHeader);
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(computeEngineCredentials)
            .setHeaderProvider(FixedHeaderProvider.create(header))
            .setEndpoint("test.random.com:443");

    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(1, provider.headersWithDuplicatesRemoved.size());
    assertEquals(
        authProvidedHeader,
        provider.headersWithDuplicatesRemoved.get(AuthHttpConstants.AUTHORIZATION));
  }

  @Test
  void buildProvider_handlesNullHeaderProvider() {
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder().setEndpoint("test.random.com:443");

    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(0, provider.headersWithDuplicatesRemoved.size());
  }

  @Test
  void buildProvider_handlesNullCredentialsMetadataRequest() throws IOException {
    Credentials credentials = mock(Credentials.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(credentials.getRequestMetadata()).thenReturn(null);
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setHeaderProvider(getHeaderProviderWithApiKeyHeader())
            .setEndpoint("test.random.com:443");

    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(1, provider.headersWithDuplicatesRemoved.size());
    assertEquals(
        API_KEY_HEADER_VALUE, provider.headersWithDuplicatesRemoved.get(API_KEY_AUTH_HEADER_KEY));
  }

  @Test
  void buildProvider_handlesErrorRetrievingCredentialsMetadataRequest() throws IOException {
    Credentials credentials = mock(Credentials.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(credentials.getRequestMetadata())
        .thenThrow(new IOException("Error getting request metadata"));
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setHeaderProvider(getHeaderProviderWithApiKeyHeader())
            .setEndpoint("test.random.com:443");
    InstantiatingGrpcChannelProvider provider = builder.build();

    assertEquals(1, provider.headersWithDuplicatesRemoved.size());
    assertEquals(
        API_KEY_HEADER_VALUE, provider.headersWithDuplicatesRemoved.get(API_KEY_AUTH_HEADER_KEY));
  }

  private FixedHeaderProvider getHeaderProviderWithApiKeyHeader() {
    Map<String, String> header = new HashMap<>();
    header.put(API_KEY_AUTH_HEADER_KEY, API_KEY_HEADER_VALUE);
    return FixedHeaderProvider.create(header);
  }

  @Test
  void createPlaintextToS2AChannelCredentials_emptyPlaintextAddress_returnsNull() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    assertThat(provider.createPlaintextToS2AChannelCredentials("")).isNull();
  }

  @Test
  void createPlaintextToS2AChannelCredentials_success() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    assertThat(provider.createPlaintextToS2AChannelCredentials("localhost:8080")).isNotNull();
  }

  @Test
  void createMtlsToS2AChannelCredentials_missingAllFiles_throws() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    assertThat(provider.createMtlsToS2AChannelCredentials(null, null, null)).isNull();
  }

  @Test
  void createMtlsToS2AChannelCredentials_missingRootFile_throws() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    File privateKey = new File("src/test/resources/client_key.pem");
    File certChain = new File("src/test/resources/client_cert.pem");
    assertThat(provider.createMtlsToS2AChannelCredentials(null, privateKey, certChain)).isNull();
  }

  @Test
  void createMtlsToS2AChannelCredentials_missingKeyFile_throws() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    File trustBundle = new File("src/test/resources/root_cert.pem");
    File certChain = new File("src/test/resources/client_cert.pem");
    assertThat(provider.createMtlsToS2AChannelCredentials(trustBundle, null, certChain)).isNull();
  }

  @Test
  void createMtlsToS2AChannelCredentials_missingCertChainFile_throws() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    File trustBundle = new File("src/test/resources/root_cert.pem");
    File privateKey = new File("src/test/resources/client_key.pem");
    assertThat(provider.createMtlsToS2AChannelCredentials(trustBundle, privateKey, null)).isNull();
  }

  @Test
  void createMtlsToS2AChannelCredentials_success() throws IOException {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();
    File trustBundle = new File("src/test/resources/root_cert.pem");
    File privateKey = new File("src/test/resources/client_key.pem");
    File certChain = new File("src/test/resources/client_cert.pem");
    assertEquals(
        provider.createMtlsToS2AChannelCredentials(trustBundle, privateKey, certChain).getClass(),
        TlsChannelCredentials.class);
  }

  @Test
  void createS2ASecuredChannelCredentials_bothS2AAddressesNull_returnsNull() {
    InstantiatingGrpcChannelProvider.resetS2AChannelCredentials();
    SecureSessionAgent s2aConfigProvider =
        mock(SecureSessionAgent.class, Mockito.withSettings().withoutAnnotations());
    SecureSessionAgentConfig config = SecureSessionAgentConfig.createBuilder().build();
    Mockito.when(s2aConfigProvider.getConfig()).thenReturn(config);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setS2AConfigProvider(s2aConfigProvider)
            .build();
    assertThat(provider.createS2ASecuredChannelCredentials()).isNull();
  }

  @Test
  void
      createS2ASecuredChannelCredentials_mtlsS2AAddressNull_returnsPlaintextToS2AS2AChannelCredentials() {
    InstantiatingGrpcChannelProvider.resetS2AChannelCredentials();
    SecureSessionAgent s2aConfigProvider =
        mock(SecureSessionAgent.class, Mockito.withSettings().withoutAnnotations());
    SecureSessionAgentConfig config =
        SecureSessionAgentConfig.createBuilder().setPlaintextAddress("localhost:8080").build();
    Mockito.when(s2aConfigProvider.getConfig()).thenReturn(config);
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setS2AConfigProvider(s2aConfigProvider)
            .build();
    assertThat(provider.createS2ASecuredChannelCredentials()).isNotNull();
    assertThat(logHandler.getAllMessages())
        .contains(
            "Cannot establish an mTLS connection to S2A because autoconfig endpoint did not return"
                + " a mtls address to reach S2A.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void
      createTwoS2ASecuredChannelCredentials_mtlsS2AAddressNull_returnsSamePlaintextToS2AS2AChannelCredentials() {
    InstantiatingGrpcChannelProvider.resetS2AChannelCredentials();
    SecureSessionAgent s2aConfigProvider =
        mock(SecureSessionAgent.class, Mockito.withSettings().withoutAnnotations());
    SecureSessionAgentConfig config =
        SecureSessionAgentConfig.createBuilder().setPlaintextAddress("localhost:8080").build();
    Mockito.when(s2aConfigProvider.getConfig()).thenReturn(config);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setS2AConfigProvider(s2aConfigProvider)
            .build();
    assertThat(provider.createS2ASecuredChannelCredentials()).isNotNull();
    InstantiatingGrpcChannelProvider provider2 =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setS2AConfigProvider(s2aConfigProvider)
            .build();
    assertThat(provider2.createS2ASecuredChannelCredentials()).isNotNull();
    assertEquals(provider.getS2AChannelCredentials(), provider2.getS2AChannelCredentials());
  }

  @Test
  void createS2ASecuredChannelCredentials_returnsPlaintextToS2AS2AChannelCredentials() {
    InstantiatingGrpcChannelProvider.resetS2AChannelCredentials();
    SecureSessionAgent s2aConfigProvider =
        mock(SecureSessionAgent.class, Mockito.withSettings().withoutAnnotations());
    SecureSessionAgentConfig config =
        SecureSessionAgentConfig.createBuilder()
            .setMtlsAddress("localhost:8080")
            .setPlaintextAddress("localhost:8080")
            .build();
    Mockito.when(s2aConfigProvider.getConfig()).thenReturn(config);
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setS2AConfigProvider(s2aConfigProvider)
            .build();
    assertThat(provider.createS2ASecuredChannelCredentials()).isNotNull();
    assertThat(logHandler.getAllMessages())
        .contains(
            "Cannot establish an mTLS connection to S2A because MTLS to MDS credentials do not"
                + " exist on filesystem, falling back to plaintext connection to S2A");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_useS2AFalse() {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(false)
            .setAllowHardBoundTokenTypes(
                Collections.singletonList(
                    InstantiatingGrpcChannelProvider.HardBoundTokenTypes.MTLS_S2A))
            .setCredentials(computeEngineCredentials);
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isFalse();
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_hardBoundTokenTypesEmpty() {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(true)
            .setAllowHardBoundTokenTypes(new ArrayList<>())
            .setCredentials(computeEngineCredentials);
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isFalse();
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_nullCreds() {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(true)
            .setAllowHardBoundTokenTypes(
                Collections.singletonList(
                    InstantiatingGrpcChannelProvider.HardBoundTokenTypes.MTLS_S2A))
            .setCredentials(null);
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isFalse();
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_notComputeEngineCreds() {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(true)
            .setAllowHardBoundTokenTypes(
                Collections.singletonList(
                    InstantiatingGrpcChannelProvider.HardBoundTokenTypes.MTLS_S2A))
            .setCredentials(CloudShellCredentials.create(3000));
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isFalse();
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_mtlsS2ANotInList() {
    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(true)
            .setAllowHardBoundTokenTypes(
                Collections.singletonList(
                    InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS))
            .setCredentials(computeEngineCredentials);
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isFalse();
  }

  @Test
  void isMtlsS2AHardBoundTokensEnabled_mtlsS2ATokenAllowedInList() {
    List<InstantiatingGrpcChannelProvider.HardBoundTokenTypes> allowHardBoundTokenTypes =
        new ArrayList<>();
    allowHardBoundTokenTypes.add(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.MTLS_S2A);
    allowHardBoundTokenTypes.add(InstantiatingGrpcChannelProvider.HardBoundTokenTypes.ALTS);

    InstantiatingGrpcChannelProvider.Builder providerBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setUseS2A(true)
            .setAllowHardBoundTokenTypes(allowHardBoundTokenTypes)
            .setCredentials(computeEngineCredentials);
    Truth.assertThat(providerBuilder.isMtlsS2AHardBoundTokensEnabled()).isTrue();
  }

  @Test
  void testDefaultBuilderNeedsBackgroundExecutor() {
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().build();

    assertThat(provider.needsBackgroundExecutor()).isTrue();
  }

  @Test
  void testSettingBackgroundExecutor() {
    ScheduledExecutorService mockExecutor =
        Mockito.mock(ScheduledExecutorService.class, Mockito.withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().setBackgroundExecutor(mockExecutor).build();

    assertThat(provider.getBackgroundExecutor()).isEqualTo(mockExecutor);
  }

  private static String extractTargetFromChannelBuilder(ManagedChannelBuilder<?> channelBuilder) {
    Object target = extractDelegateField(channelBuilder, "target");
    return target != null ? (String) target : channelBuilder.toString();
  }

  private static ChannelCredentials extractChannelCredentialsFromChannelBuilder(
      ManagedChannelBuilder<?> channelBuilder) {
    return (ChannelCredentials) extractDelegateField(channelBuilder, "channelCredentials");
  }

  /**
   * Reads {@code fieldName} from the ManagedChannelImplBuilder that the Netty builder delegates to,
   * or returns null when either the delegate or the field cannot be found.
   */
  private static @Nullable Object extractDelegateField(
      ManagedChannelBuilder<?> channelBuilder, String fieldName) {
    try {
      Class<?> nettyBuilderClass = channelBuilder.getClass();
      java.lang.reflect.Field delegateField = null;
      while (nettyBuilderClass != null && delegateField == null) {
        try {
          delegateField = nettyBuilderClass.getDeclaredField("delegate");
        } catch (NoSuchFieldException e) {
          try {
            delegateField = nettyBuilderClass.getDeclaredField("managedChannelImplBuilder");
          } catch (NoSuchFieldException e2) {
            nettyBuilderClass = nettyBuilderClass.getSuperclass();
          }
        }
      }
      if (delegateField != null) {
        delegateField.setAccessible(true);
        Object delegate = delegateField.get(channelBuilder);
        Class<?> delegateClass = delegate.getClass();
        Field field = null;
        while (delegateClass != null && field == null) {
          try {
            field = delegateClass.getDeclaredField(fieldName);
          } catch (NoSuchFieldException e) {
            delegateClass = delegateClass.getSuperclass();
          }
        }
        if (field != null) {
          field.setAccessible(true);
          return field.get(delegate);
        }
      }
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  @Test
  void testLogDirectPathMisconfigXdsSetDirectPathNotSet() throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPathXds()
            .setAttemptDirectPath(false)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class, Mockito.withSettings().withoutAnnotations()))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEnvProvider(envProvider)
            .build();

    try {
      provider.getTransportChannel();
    } catch (Exception e) {
      // ignore
    }

    assertThat(logHandler.getAllMessages())
        .contains(
            "DirectPath is misconfigured. The DirectPath XDS option was set, but the"
                + " attemptDirectPath option was not. Please set both the attemptDirectPath and"
                + " attemptDirectPathXds options.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfigDirectPathSetXdsNotSet() throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.setLevel(Level.FINE);
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class, Mockito.withSettings().withoutAnnotations()))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEnvProvider(envProvider)
            .build();

    try {
      provider.getTransportChannel();
    } catch (Exception e) {
      // ignore
    }

    assertThat(logHandler.getAllMessages())
        .contains(
            "DirectPath is enabled, but DirectPath xDS is not. Please note that DirectPath will"
                + " soon require xDS to be enabled. Please set the attemptDirectPathXds option.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void canUseDirectPath_interconnectEnabledButDirectPathDisabled_fallsBackToCloudPath()
      throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(false)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    Truth.assertThat(provider.canUseDirectPath()).isFalse();
    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder)).isEqualTo(DEFAULT_ENDPOINT);
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo(DEFAULT_ENDPOINT);
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void canUseDirectPath_interconnectAndDirectPathEnabledButNonGduUniverse_fallsBackToCloudPath()
      throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage-direct.some-other-universe.com:443")
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    Truth.assertThat(provider.canUseDirectPath()).isFalse();
    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("storage-direct.some-other-universe.com:443");
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo("storage-direct.some-other-universe.com:443");
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void
      createChannelBuilder_directPathOverInterconnect_storageEndpoint_rewritesTargetWithoutAuthorityOverride()
          throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage.googleapis.com:443")
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo("storage-direct.googleapis.com");
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void
      createChannelBuilder_directPathOverInterconnect_storagePreprodSandboxEndpoint_rewritesTargetWithoutAuthorityOverride()
          throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage-preprod.sandbox.googleapis.com:443")
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds");
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority())
          .isEqualTo("storage-preprod-direct.sandbox.googleapis.com");
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void
      createChannelBuilder_directPathOverInterconnect_bigtableEndpoint_rewritesTargetWithoutAuthorityOverride()
          throws Exception {
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    // Test with bigtable.googleapis.com:443 (rewritten to bigtable-direct)
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("bigtable.googleapis.com:443")
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("google-c2p:///bigtable-direct.googleapis.com?force-xds");
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo("bigtable-direct.googleapis.com");
    } finally {
      channel.shutdownNow();
    }

    // Also test if endpoint already has -direct infix
    InstantiatingGrpcChannelProvider directProvider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("bigtable-direct.googleapis.com:443")
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setEnvProvider(envProvider)
            .build();

    ManagedChannelBuilder<?> directChannelBuilder = directProvider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(directChannelBuilder))
        .isEqualTo("google-c2p:///bigtable-direct.googleapis.com?force-xds");
    Truth.assertThat(extractAuthorityFromChannelBuilder(directChannelBuilder)).isNull();
    ManagedChannel directChannel = (ManagedChannel) directChannelBuilder.build();
    try {
      Truth.assertThat(directChannel.authority()).isEqualTo("bigtable-direct.googleapis.com");
    } finally {
      directChannel.shutdownNow();
    }
  }

  @Test
  void createChannelBuilder_directPathXdsOnGce_doesNotRewriteHost() throws Exception {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");

    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXds()
            .setAttemptDirectPathXdsOverInterconnect(false)
            .setCredentials(computeEngineCredentials)
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class));

    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("google-c2p:///storage.googleapis.com");
    Truth.assertThat(extractAuthorityFromChannelBuilder(channelBuilder)).isNull();
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo("storage.googleapis.com");
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void canUseDirectPath_interconnectEnabledViaEnvVar_bypassesGceCheckAndRewritesTarget()
      throws Exception {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn("true");

    // 1. Builder option not set (null)
    InstantiatingGrpcChannelProvider.Builder unsetBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setAttemptDirectPath(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider unsetProvider =
        new InstantiatingGrpcChannelProvider(unsetBuilder, "not-gce-product-name");

    Truth.assertThat(unsetProvider.isDirectPathXdsEnabled()).isTrue();
    Truth.assertThat(unsetProvider.canUseDirectPath()).isTrue();
    ManagedChannelBuilder<?> unsetChannelBuilder = unsetProvider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(unsetChannelBuilder))
        .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");
    ManagedChannel unsetChannel = (ManagedChannel) unsetChannelBuilder.build();
    try {
      Truth.assertThat(unsetChannel.authority()).isEqualTo("storage-direct.googleapis.com");
    } finally {
      unsetChannel.shutdownNow();
    }

    // 2. Builder option explicitly false (simulating GrpcStorageOptions default), env var overrides
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn(" TRUE ");
    InstantiatingGrpcChannelProvider.Builder falseBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(false)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider falseProvider =
        new InstantiatingGrpcChannelProvider(falseBuilder, "not-gce-product-name");

    Truth.assertThat(falseProvider.isDirectPathXdsEnabled()).isTrue();
    Truth.assertThat(falseProvider.canUseDirectPath()).isTrue();
    ManagedChannelBuilder<?> falseChannelBuilder = falseProvider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(falseChannelBuilder))
        .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");
    ManagedChannel falseChannel = (ManagedChannel) falseChannelBuilder.build();
    try {
      Truth.assertThat(falseChannel.authority()).isEqualTo("storage-direct.googleapis.com");
    } finally {
      falseChannel.shutdownNow();
    }
  }

  @Test
  void
      canUseDirectPath_interconnectDisabledViaEnvVar_overridesBuilderOptionAndFallsBackToCloudPath()
          throws Exception {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn("false");

    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setAttemptDirectPath(true)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()))
            .setExecutor(mock(Executor.class))
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, "not-gce-product-name");

    Truth.assertThat(provider.isDirectPathXdsEnabled()).isFalse();
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    Truth.assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("storage.googleapis.com:443");
    ManagedChannel channel = (ManagedChannel) channelBuilder.build();
    try {
      Truth.assertThat(channel.authority()).isEqualTo("storage.googleapis.com:443");
    } finally {
      channel.shutdownNow();
    }
  }

  @Test
  void canUseDirectPath_interconnectEnabledViaEnvVar_respectsDirectPathKillSwitch() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn("true");

    // Case 1: setAttemptDirectPath(false)
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider.Builder disabledOptionBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setAttemptDirectPath(false)
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider disabledOptionProvider =
        new InstantiatingGrpcChannelProvider(disabledOptionBuilder, "not-gce-product-name");
    Truth.assertThat(disabledOptionProvider.canUseDirectPath()).isFalse();

    // Case 2: GOOGLE_CLOUD_DISABLE_DIRECT_PATH=true
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("true");
    InstantiatingGrpcChannelProvider.Builder disabledEnvBuilder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setCredentials(credentials)
            .setAttemptDirectPath(true)
            .setEndpoint("storage.googleapis.com:443")
            .setEnvProvider(envProvider);
    InstantiatingGrpcChannelProvider disabledEnvProvider =
        new InstantiatingGrpcChannelProvider(disabledEnvBuilder, "not-gce-product-name");
    Truth.assertThat(disabledEnvProvider.canUseDirectPath()).isFalse();
  }

  @Test
  void canUseDirectPath_interconnectInvalidOrEmptyEnvVar_fallsBackToBuilderOption() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());

    for (String envVal : new String[] {"", "   ", "invalid", "1", "0"}) {
      when(envProvider.getenv(
              InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
          .thenReturn(envVal);

      InstantiatingGrpcChannelProvider.Builder enabledBuilder =
          InstantiatingGrpcChannelProvider.newBuilder()
              .setCertificateBasedAccess(certificateBasedAccess)
              .setCredentials(credentials)
              .setAttemptDirectPath(true)
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setEndpoint("storage.googleapis.com:443")
              .setEnvProvider(envProvider);
      InstantiatingGrpcChannelProvider enabledProvider =
          new InstantiatingGrpcChannelProvider(enabledBuilder, "not-gce-product-name");
      Truth.assertThat(enabledProvider.canUseDirectPath()).isTrue();

      InstantiatingGrpcChannelProvider.Builder disabledBuilder =
          InstantiatingGrpcChannelProvider.newBuilder()
              .setCertificateBasedAccess(certificateBasedAccess)
              .setCredentials(credentials)
              .setAttemptDirectPath(true)
              .setAttemptDirectPathXdsOverInterconnect(false)
              .setEndpoint("storage.googleapis.com:443")
              .setEnvProvider(envProvider);
      InstantiatingGrpcChannelProvider disabledProvider =
          new InstantiatingGrpcChannelProvider(disabledBuilder, "not-gce-product-name");
      Truth.assertThat(disabledProvider.canUseDirectPath()).isFalse();
    }
  }

  /**
   * Returns a builder for a DirectPath-enabled provider as configured off GCE, with the
   * Interconnect environment variable set to {@code interconnectEnvValue} (unset when null).
   */
  private InstantiatingGrpcChannelProvider.Builder directPathProviderBuilder(
      @Nullable Credentials credentials, @Nullable String interconnectEnvValue) {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, withSettings().withoutAnnotations());
    when(envProvider.getenv(InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    when(envProvider.getenv(
            InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_ENABLE_XDS_OVER_INTERCONNECT))
        .thenReturn(interconnectEnvValue);
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setCertificateBasedAccess(certificateBasedAccess)
        .setAttemptDirectPath(true)
        .setCredentials(credentials)
        .setEndpoint("storage.googleapis.com:443")
        .setEnvProvider(envProvider)
        .setHeaderProvider(mock(HeaderProvider.class, withSettings().withoutAnnotations()));
  }

  /** Returns an off-GCE provider with DirectPath over Interconnect enabled by builder option. */
  private InstantiatingGrpcChannelProvider interconnectProvider(
      @Nullable Credentials credentials, @Nullable String interconnectEnvValue) {
    return new InstantiatingGrpcChannelProvider(
        directPathProviderBuilder(credentials, interconnectEnvValue)
            .setAttemptDirectPathXdsOverInterconnect(true),
        "not-gce-product-name");
  }

  /**
   * Returns the channel credentials wrapped by a DirectPath channel's {@link
   * CompositeChannelCredentials}. GoogleDefaultChannelCredentials and the Interconnect credentials
   * both attach the call credentials this way, so the inner type tells them apart.
   */
  private static ChannelCredentials innerChannelCredentials(ChannelCredentials channelCredentials) {
    assertThat(channelCredentials).isInstanceOf(CompositeChannelCredentials.class);
    return ((CompositeChannelCredentials) channelCredentials).getChannelCredentials();
  }

  private static CallCredentials callCredentialsOf(ChannelCredentials channelCredentials) {
    assertThat(channelCredentials).isInstanceOf(CompositeChannelCredentials.class);
    return ((CompositeChannelCredentials) channelCredentials).getCallCredentials();
  }

  /**
   * Returns the {@link Credentials} that {@link MoreCallCredentials#from} wrapped into {@code
   * callCredentials}, read from the wrapper's {@code creds} field. The ALTS hard-bound token
   * credential is wrapped the same way, so only the identity of the wrapped instance tells which
   * credential a channel carries.
   */
  private static Credentials credentialsWrappedBy(CallCredentials callCredentials)
      throws ReflectiveOperationException {
    assertThat(callCredentials)
        .isInstanceOf(
            MoreCallCredentials.from(mock(Credentials.class, withSettings().withoutAnnotations()))
                .getClass());
    Field credsField = callCredentials.getClass().getDeclaredField("creds");
    credsField.setAccessible(true);
    return (Credentials) credsField.get(callCredentials);
  }

  @Test
  void createDirectPathChannelCredentials_interconnect_usesTlsWithCallCredentials()
      throws Exception {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        interconnectProvider(credentials, /* interconnectEnvValue= */ null);

    ChannelCredentials channelCredentials = provider.createDirectPathChannelCredentials();

    assertThat(innerChannelCredentials(channelCredentials))
        .isInstanceOf(TlsChannelCredentials.class);
    // The call credentials stay on the channel credentials so the RLS control channel inherits
    // them.
    assertThat(credentialsWrappedBy(callCredentialsOf(channelCredentials)))
        .isSameInstanceAs(credentials);
  }

  // The builder option is unset; the variable is trimmed and matched case-insensitively.
  @ParameterizedTest
  @ValueSource(strings = {"true", "TRUE", " True "})
  void createDirectPathChannelCredentials_interconnectEnvVar_usesTls(String envValue) {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(
            directPathProviderBuilder(credentials, envValue), "not-gce-product-name");

    ChannelCredentials channelCredentials = provider.createDirectPathChannelCredentials();

    assertThat(innerChannelCredentials(channelCredentials))
        .isInstanceOf(TlsChannelCredentials.class);
  }

  @Test
  void createDirectPathChannelCredentials_interconnectInvalidEnvVar_fallsBackToBuilderOption() {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider enabledProvider = interconnectProvider(credentials, "yes");
    InstantiatingGrpcChannelProvider disabledProvider =
        new InstantiatingGrpcChannelProvider(
            directPathProviderBuilder(credentials, "yes")
                .setAttemptDirectPathXdsOverInterconnect(false),
            "not-gce-product-name");

    ChannelCredentials enabledCredentials = enabledProvider.createDirectPathChannelCredentials();
    ChannelCredentials disabledCredentials = disabledProvider.createDirectPathChannelCredentials();

    assertThat(innerChannelCredentials(enabledCredentials))
        .isInstanceOf(TlsChannelCredentials.class);
    assertThat(innerChannelCredentials(disabledCredentials))
        .isNotInstanceOf(TlsChannelCredentials.class);
  }

  @Test
  void createDirectPathChannelCredentials_interconnectEnvFalse_usesGoogleDefault() {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    // The environment variable overrides the builder option, so this is standard DirectPath.
    InstantiatingGrpcChannelProvider provider = interconnectProvider(credentials, "false");

    ChannelCredentials channelCredentials = provider.createDirectPathChannelCredentials();

    assertThat(innerChannelCredentials(channelCredentials))
        .isNotInstanceOf(TlsChannelCredentials.class);
  }

  @Test
  void createDirectPathChannelCredentials_interconnectIgnoresAltsCallCredentials()
      throws Exception {
    when(computeEngineCredentials.toBuilder()).thenReturn(ComputeEngineCredentials.newBuilder());
    InstantiatingGrpcChannelProvider.Builder builder =
        directPathProviderBuilder(computeEngineCredentials, /* interconnectEnvValue= */ null)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setAllowHardBoundTokenTypes(Collections.singletonList(HardBoundTokenTypes.ALTS));
    assertThat(builder.isDirectPathBoundTokenEnabled()).isTrue();
    // build() is what creates altsCallCredentials, from a copy of the credentials.
    InstantiatingGrpcChannelProvider provider = builder.build();

    ChannelCredentials channelCredentials = provider.createDirectPathChannelCredentials();

    assertThat(innerChannelCredentials(channelCredentials))
        .isInstanceOf(TlsChannelCredentials.class);
    // Hard-bound tokens need an ALTS connection, so the channel carries the original credentials
    // alone: neither the hard-bound copy nor GoogleDefaultChannelCredentials' pair of both.
    assertThat(credentialsWrappedBy(callCredentialsOf(channelCredentials)))
        .isSameInstanceAs(computeEngineCredentials);
  }

  @Test
  void createDirectPathChannelCredentials_directPath_usesGoogleDefault() throws Exception {
    when(computeEngineCredentials.toBuilder()).thenReturn(ComputeEngineCredentials.newBuilder());
    InstantiatingGrpcChannelProvider withoutBoundTokens =
        directPathProviderBuilder(computeEngineCredentials, /* interconnectEnvValue= */ null)
            .build();
    InstantiatingGrpcChannelProvider withBoundTokens =
        directPathProviderBuilder(computeEngineCredentials, /* interconnectEnvValue= */ null)
            .setAllowHardBoundTokenTypes(Collections.singletonList(HardBoundTokenTypes.ALTS))
            .build();

    ChannelCredentials withoutBoundTokensCredentials =
        withoutBoundTokens.createDirectPathChannelCredentials();
    ChannelCredentials withBoundTokensCredentials =
        withBoundTokens.createDirectPathChannelCredentials();

    // GoogleDefaultChannelCredentials wraps its own TLS/ALTS negotiator, not TlsChannelCredentials.
    assertThat(innerChannelCredentials(withoutBoundTokensCredentials))
        .isNotInstanceOf(TlsChannelCredentials.class);
    assertThat(credentialsWrappedBy(callCredentialsOf(withoutBoundTokensCredentials)))
        .isSameInstanceAs(computeEngineCredentials);
    assertThat(innerChannelCredentials(withBoundTokensCredentials))
        .isNotInstanceOf(TlsChannelCredentials.class);
    // With ALTS hard-bound tokens, GoogleDefaultChannelCredentials pairs both call credentials in
    // a CallCredentials type of its own.
    assertThat(callCredentialsOf(withBoundTokensCredentials))
        .isNotInstanceOf(MoreCallCredentials.from(computeEngineCredentials).getClass());
  }

  @Test
  void createChannelBuilder_interconnectWithMtlsProvider_usesTlsWithoutClientCert()
      throws Exception {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, withSettings().withoutAnnotations());
    when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    when(mtlsCertificateBasedAccess.getWorkloadCertPath()).thenReturn("/path/to/workload/cert.pem");
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(
            directPathProviderBuilder(credentials, /* interconnectEnvValue= */ null)
                .setAttemptDirectPathXdsOverInterconnect(true)
                .setCertificateBasedAccess(mtlsCertificateBasedAccess)
                .setMtlsProvider(mtlsProvider),
            "not-gce-product-name");

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();
    ChannelCredentials inner =
        innerChannelCredentials(extractChannelCredentialsFromChannelBuilder(channelBuilder));

    // DirectPath channels never present the client certificate, Interconnect included; both
    // accessors are null unless TlsChannelCredentials was built with a client identity.
    assertThat(inner).isInstanceOf(TlsChannelCredentials.class);
    assertThat(((TlsChannelCredentials) inner).getKeyManagers()).isNull();
    assertThat(((TlsChannelCredentials) inner).getCertificateChain()).isNull();
    // Consequently the pool does not track the workload certificate for rotation either.
    TransportChannel transportChannel = provider.getTransportChannel();
    try {
      ChannelPool pool = (ChannelPool) ((GrpcTransportChannel) transportChannel).getChannel();
      assertThat(pool.getWorkloadCertPath()).isNull();
    } finally {
      transportChannel.shutdownNow();
    }
  }

  @Test
  void createChannelBuilder_interconnectWithoutCredentials_usesCloudPathClientCert()
      throws Exception {
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, withSettings().withoutAnnotations());
    when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(
            directPathProviderBuilder(/* credentials= */ null, /* interconnectEnvValue= */ null)
                .setAttemptDirectPathXdsOverInterconnect(true)
                .setCertificateBasedAccess(mtlsCertificateBasedAccess)
                .setMtlsProvider(mtlsProvider),
            "not-gce-product-name");

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();

    // Without credentials the channel is CloudPath, which presents the client certificate.
    assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("storage.googleapis.com:443");
    ChannelCredentials channelCredentials =
        extractChannelCredentialsFromChannelBuilder(channelBuilder);
    assertThat(channelCredentials).isInstanceOf(TlsChannelCredentials.class);
    assertThat(((TlsChannelCredentials) channelCredentials).getKeyManagers()).isNotNull();
  }

  @Test
  void createChannelBuilder_interconnect_usesTlsChannelCredentials() throws IOException {
    Credentials credentials = mock(Credentials.class, withSettings().withoutAnnotations());
    InstantiatingGrpcChannelProvider provider =
        interconnectProvider(credentials, /* interconnectEnvValue= */ null);

    ManagedChannelBuilder<?> channelBuilder = provider.createChannelBuilder();

    assertThat(extractTargetFromChannelBuilder(channelBuilder))
        .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");
    assertThat(innerChannelCredentials(extractChannelCredentialsFromChannelBuilder(channelBuilder)))
        .isInstanceOf(TlsChannelCredentials.class);
  }

  @Test
  void createChannel_whenDirectPathEnabled_ignoresWorkloadCertPath() throws Exception {
    System.setProperty("os.name", "Linux");
    EnvironmentProvider envProvider =
        mock(EnvironmentProvider.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(
            envProvider.getenv(
                InstantiatingGrpcChannelProvider.DIRECT_PATH_ENV_DISABLE_DIRECT_PATH))
        .thenReturn("false");
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    Mockito.when(mtlsCertificateBasedAccess.getWorkloadCertPath())
        .thenReturn("/path/to/workload/cert.pem");
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);

    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(mtlsCertificateBasedAccess)
            .setMtlsProvider(mtlsProvider)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setEnvProvider(envProvider)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()));
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();

    TransportChannel transportChannel = provider.getTransportChannel();
    try {
      ChannelPool pool = (ChannelPool) ((GrpcTransportChannel) transportChannel).getChannel();
      assertThat(pool.getWorkloadCertPath()).isNull();
    } finally {
      transportChannel.shutdownNow();
    }
  }

  @Test
  void createChannel_whenMtlsActive_passesWorkloadCertPathToChannelPool() throws Exception {
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    Mockito.when(mtlsCertificateBasedAccess.getWorkloadCertPath())
        .thenReturn("/path/to/workload/cert.pem");
    MtlsProvider mtlsProvider =
        new FakeMtlsProvider(FakeMtlsProvider.createTestMtlsKeyStore(), "", false);

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(mtlsCertificateBasedAccess)
            .setMtlsProvider(mtlsProvider)
            .setAttemptDirectPath(false)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .build();

    TransportChannel transportChannel = provider.getTransportChannel();
    try {
      ChannelPool pool = (ChannelPool) ((GrpcTransportChannel) transportChannel).getChannel();
      assertThat(pool.getWorkloadCertPath()).isEqualTo("/path/to/workload/cert.pem");
    } finally {
      transportChannel.shutdownNow();
    }
  }

  @Test
  void createChannelBuilder_whenMtlsActiveAndKeyStoreNull_throwsIOException() {
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    MtlsProvider mtlsProviderWithNullKeyStore = new FakeMtlsProvider(null, "", false);

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(mtlsCertificateBasedAccess)
            .setMtlsProvider(mtlsProviderWithNullKeyStore)
            .setAttemptDirectPath(false)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .build();

    IOException thrown = assertThrows(IOException.class, provider::createChannelBuilder);
    assertThat(thrown).hasMessageThat().contains("Failed to initialize mTLS channel credentials");
  }

  @Test
  void createChannelBuilder_whenDefaultMtlsProviderThrowsIOException_propagatesIOException()
      throws Exception {
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    IOException expected = new IOException("Corrupt PEM file");
    Mockito.when(mtlsCertificateBasedAccess.createDefaultMtlsProvider()).thenThrow(expected);

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(mtlsCertificateBasedAccess)
            .setAttemptDirectPath(false)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .build();

    IOException thrown = assertThrows(IOException.class, provider::createChannelBuilder);
    assertThat(thrown).isSameInstanceAs(expected);
  }

  @Test
  void
      createChannelBuilder_whenDefaultMtlsProviderThrowsCertificateSourceUnavailable_fallsBackWithoutMtls()
          throws Exception {
    CertificateBasedAccess mtlsCertificateBasedAccess =
        mock(CertificateBasedAccess.class, Mockito.withSettings().withoutAnnotations());
    Mockito.when(mtlsCertificateBasedAccess.useMtlsClientCertificate()).thenReturn(true);
    Mockito.when(mtlsCertificateBasedAccess.createDefaultMtlsProvider())
        .thenThrow(new CertificateSourceUnavailableException("No certificates on disk"));

    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(mtlsCertificateBasedAccess)
            .setAttemptDirectPath(false)
            .setEndpoint(DEFAULT_ENDPOINT)
            .setHeaderProvider(
                mock(HeaderProvider.class, Mockito.withSettings().withoutAnnotations()))
            .build();

    assertThat(provider.createChannelBuilder()).isNotNull();
  }

  private static class FakeLogHandler extends Handler {

    List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
      records.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() throws SecurityException {}

    List<String> getAllMessages() {
      return records.stream().map(LogRecord::getMessage).collect(Collectors.toList());
    }

    List<Level> levelsOf(String message) {
      return records.stream()
          .filter(record -> record.getMessage().equals(message))
          .map(LogRecord::getLevel)
          .collect(Collectors.toList());
    }
  }

  private static String extractAuthorityFromChannelBuilder(
      ManagedChannelBuilder<?> channelBuilder) {
    try {
      Object current = channelBuilder;
      while (current != null) {
        Class<?> clazz = current.getClass();
        java.lang.reflect.Field field = null;
        while (clazz != null) {
          try {
            field = clazz.getDeclaredField("authority");
            break;
          } catch (NoSuchFieldException e) {
            try {
              field = clazz.getDeclaredField("authorityOverride");
              break;
            } catch (NoSuchFieldException e2) {
              try {
                field = clazz.getDeclaredField("overrideAuthority");
                break;
              } catch (Exception ignored) {
                // Expected if neither field exists on this class; continue scanning superclasses.
              }
            }
            clazz = clazz.getSuperclass();
          }
        }
        if (field != null) {
          field.setAccessible(true);
          Object val = field.get(current);
          if (val instanceof String && !((String) val).isEmpty()) {
            return (String) val;
          }
        }
        Class<?> unwrapClass = current.getClass();
        java.lang.reflect.Field delegateField = null;
        while (unwrapClass != null && delegateField == null) {
          try {
            delegateField = unwrapClass.getDeclaredField("delegate");
          } catch (NoSuchFieldException e) {
            try {
              delegateField = unwrapClass.getDeclaredField("managedChannelImplBuilder");
            } catch (NoSuchFieldException e2) {
              unwrapClass = unwrapClass.getSuperclass();
            }
          }
        }
        if (delegateField != null) {
          delegateField.setAccessible(true);
          Object next = delegateField.get(current);
          if (next != null && next != current) {
            current = next;
            continue;
          }
        }
        break;
      }
      return null;
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
