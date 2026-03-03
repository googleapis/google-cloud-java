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
import com.google.auth.ApiKeyCredentials;
import com.google.auth.Credentials;
import com.google.auth.http.AuthHttpConstants;
import com.google.auth.mtls.MtlsProvider;
import com.google.auth.oauth2.CloudShellCredentials;
import com.google.auth.oauth2.ComputeEngineCredentials;
import com.google.auth.oauth2.SecureSessionAgent;
import com.google.auth.oauth2.SecureSessionAgentConfig;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.truth.Truth;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.TlsChannelCredentials;
import io.grpc.alts.ComputeEngineChannelBuilder;
import java.io.File;
import java.io.IOException;
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
import java.util.logging.LogRecord;
import java.util.stream.Collectors;
import javax.annotation.Nullable;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    computeEngineCredentials = Mockito.mock(ComputeEngineCredentials.class);
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
    Map<String, ?> directPathServiceConfig = ImmutableMap.of("loadbalancingConfig", "grpclb");
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
    final GrpcInterceptorProvider interceptorProvider = Mockito.mock(GrpcInterceptorProvider.class);

    InstantiatingGrpcChannelProvider channelProvider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setEndpoint("localhost:8080")
            .setPoolSize(numChannels)
            .setHeaderProvider(Mockito.mock(HeaderProvider.class))
            .setExecutor(Mockito.mock(Executor.class))
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
        Mockito.mock(ApiFunction.class);

    ArgumentCaptor<ManagedChannelBuilder<?>> channelBuilderCaptor =
        ArgumentCaptor.forClass(ManagedChannelBuilder.class);

    ManagedChannelBuilder<?> swappedBuilder = Mockito.mock(ManagedChannelBuilder.class);
    ManagedChannel fakeChannel = Mockito.mock(ManagedChannel.class);
    Mockito.when(swappedBuilder.build()).thenReturn(fakeChannel);

    Mockito.when(channelConfigurator.apply(channelBuilderCaptor.capture()))
        .thenReturn(swappedBuilder);

    // Invoke the provider
    InstantiatingGrpcChannelProvider.newBuilder()
        .setCertificateBasedAccess(certificateBasedAccess)
        .setEndpoint("localhost:8080")
        .setHeaderProvider(Mockito.mock(HeaderProvider.class))
        .setExecutor(Mockito.mock(Executor.class))
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
      final ChannelPrimer mockChannelPrimer = Mockito.mock(ChannelPrimer.class);

      InstantiatingGrpcChannelProvider provider =
          InstantiatingGrpcChannelProvider.newBuilder()
              .setEndpoint("localhost:8080")
              .setPoolSize(poolSize)
              .setHeaderProvider(Mockito.mock(HeaderProvider.class))
              .setExecutor(Mockito.mock(Executor.class))
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
    Map<String, ?> grpclb = getAsObject(lbConfig, "grpclb");
    List<Map<String, ?>> childPolicies = getAsObjectList(grpclb, "childPolicy");
    assertThat(childPolicies).hasSize(1);
    Map<String, ?> childPolicy = childPolicies.get(0);
    assertThat(childPolicy.keySet()).containsExactly("pick_first");
  }

  @Nullable
  private static Map<String, ?> getAsObject(Map<String, ?> json, String key) {
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
    ImmutableMap<String, Object> grpcLbPolicy =
        ImmutableMap.<String, Object>of("grpclb", childPolicy);
    Map<String, Object> passedServiceConfig = new HashMap<>();
    passedServiceConfig.put("loadBalancingConfig", ImmutableList.of(grpcLbPolicy));

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
            .setHeaderProvider(Mockito.mock(HeaderProvider.class))
            .setExecutor(Mockito.mock(Executor.class))
            .build();
    return channelProvider.createMtlsChannelCredentials();
  }

  private InstantiatingGrpcChannelProvider.Builder
      createChannelProviderBuilderForDirectPathLogTests() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setHeaderProvider(Mockito.mock(HeaderProvider.class))
        .setExecutor(Mockito.mock(Executor.class))
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
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        createChannelProviderBuilderForDirectPathLogTests()
            .setAttemptDirectPathXds()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    createAndCloseTransportChannel(provider);
    assertThat(logHandler.getAllMessages())
        .contains(
            "DirectPath is misconfigured. The DirectPath XDS option was set, but the attemptDirectPath option was not. Please set both the attemptDirectPath and attemptDirectPathXds options.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfig_AttemptDirectPathNotSetAndAttemptDirectPathXdsSetViaEnv_warns()
      throws Exception {
    FakeLogHandler logHandler = new FakeLogHandler();
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);

    InstantiatingGrpcChannelProvider provider =
        createChannelProviderBuilderForDirectPathLogTests()
            .setCertificateBasedAccess(certificateBasedAccess)
            .build();
    createAndCloseTransportChannel(provider);
    assertThat(logHandler.getAllMessages())
        .contains(
            "Env var GOOGLE_CLOUD_ENABLE_DIRECT_PATH_XDS was found and set to TRUE, but DirectPath was not enabled for this client. If this is intended for "
                + "this client, please note that this is a misconfiguration and set the attemptDirectPath option as well.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void testLogDirectPathMisconfig_shouldNotLogInTheBuilder() {
    FakeLogHandler logHandler = new FakeLogHandler();
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
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPathXds()
            .setAttemptDirectPath(true)
            .setHeaderProvider(Mockito.mock(HeaderProvider.class))
            .setExecutor(Mockito.mock(Executor.class))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
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
    InstantiatingGrpcChannelProvider.LOG.addHandler(logHandler);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setAttemptDirectPathXds()
            .setAttemptDirectPath(true)
            .setAllowNonDefaultServiceAccount(true)
            .setHeaderProvider(Mockito.mock(HeaderProvider.class))
            .setExecutor(Mockito.mock(Executor.class))
            .setEndpoint(DEFAULT_ENDPOINT)
            .setCertificateBasedAccess(certificateBasedAccess)
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
            .setHeaderProvider(Mockito.mock(HeaderProvider.class));
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
    Credentials credentials = Mockito.mock(Credentials.class);
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
            .setHeaderProvider(Mockito.mock(HeaderProvider.class));
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
            .setHeaderProvider(Mockito.mock(HeaderProvider.class));
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
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(true)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isTrue();
  }

  @Test
  public void canUseDirectPath_directPathEnvVarNotSet_attemptDirectPathIsFalse() {
    System.setProperty("os.name", "Linux");
    InstantiatingGrpcChannelProvider.Builder builder =
        InstantiatingGrpcChannelProvider.newBuilder()
            .setCertificateBasedAccess(certificateBasedAccess)
            .setAttemptDirectPath(false)
            .setCredentials(computeEngineCredentials)
            .setEndpoint(DEFAULT_ENDPOINT);
    InstantiatingGrpcChannelProvider provider =
        new InstantiatingGrpcChannelProvider(builder, GCE_PRODUCTION_NAME_AFTER_2016);
    Truth.assertThat(provider.canUseDirectPath()).isFalse();
  }

  @Test
  public void canUseDirectPath_nonComputeCredentials() {
    System.setProperty("os.name", "Linux");
    Credentials credentials = Mockito.mock(Credentials.class);
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
  public void canUseDirectPath_isNotOnComputeEngine_invalidOsNameSystemProperty() {
    System.setProperty("os.name", "Not Linux");
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
    EnvironmentProvider envProvider = Mockito.mock(EnvironmentProvider.class);
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
    Credentials credentials = Mockito.mock(Credentials.class);
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
    Credentials credentials = Mockito.mock(Credentials.class);
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
    SecureSessionAgent s2aConfigProvider = Mockito.mock(SecureSessionAgent.class);
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
    SecureSessionAgent s2aConfigProvider = Mockito.mock(SecureSessionAgent.class);
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
            "Cannot establish an mTLS connection to S2A because autoconfig endpoint did not return a mtls address to reach S2A.");
    InstantiatingGrpcChannelProvider.LOG.removeHandler(logHandler);
  }

  @Test
  void
      createTwoS2ASecuredChannelCredentials_mtlsS2AAddressNull_returnsSamePlaintextToS2AS2AChannelCredentials() {
    InstantiatingGrpcChannelProvider.resetS2AChannelCredentials();
    SecureSessionAgent s2aConfigProvider = Mockito.mock(SecureSessionAgent.class);
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
    SecureSessionAgent s2aConfigProvider = Mockito.mock(SecureSessionAgent.class);
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
            "Cannot establish an mTLS connection to S2A because MTLS to MDS credentials do not exist on filesystem, falling back to plaintext connection to S2A");
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
    ScheduledExecutorService mockExecutor = Mockito.mock(ScheduledExecutorService.class);
    InstantiatingGrpcChannelProvider provider =
        InstantiatingGrpcChannelProvider.newBuilder().setBackgroundExecutor(mockExecutor).build();

    assertThat(provider.getBackgroundExecutor()).isEqualTo(mockExecutor);
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
  }
}
