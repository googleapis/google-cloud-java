/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.OAuth2Credentials;
import com.google.cloud.spanner.spi.v1.SpannerRpc;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.sdk.OpenTelemetrySdk;
import io.opentelemetry.sdk.common.CompletableResultCode;
import io.opentelemetry.sdk.metrics.InstrumentType;
import io.opentelemetry.sdk.metrics.SdkMeterProvider;
import io.opentelemetry.sdk.metrics.data.AggregationTemporality;
import io.opentelemetry.sdk.metrics.data.MetricData;
import io.opentelemetry.sdk.metrics.export.MetricExporter;
import io.opentelemetry.sdk.testing.exporter.InMemoryMetricReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class BuiltInOpenTelemetryMetricsProviderTest {

  @Test
  public void testGenerateClientHashWithSimpleUid() {
    String clientUid = "testClient";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithEmptyUid() {
    String clientUid = "";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithNullUid() {
    String clientUid = null;
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithLongUid() {
    String clientUid = "aVeryLongUniqueClientIdentifierThatIsUnusuallyLong";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testGenerateClientHashWithSpecialCharacters() {
    String clientUid = "273d60f2-5604-42f1-b687-f5f1b975fd07@2316645@test#";
    verifyHash(BuiltInMetricsProvider.generateClientHash(clientUid));
  }

  @Test
  public void testApiTracerFactoryDoesNotSetBuiltInMetricsProject() {
    SpannerOptions options = newTestOptions();
    try {
      options.getApiTracerFactory(/* isAdminClient= */ false, /* isEmulatorEnabled= */ false);

      assertNull(options.builtInMetricsProvider.getProjectId());
    } finally {
      options.builtInMetricsProvider.reset();
    }
  }

  @Test
  public void testBuiltInOpenTelemetryDoesNotSetMetricsProject() {
    SpannerOptions options = newTestOptions();
    try {
      options.getBuiltInOpenTelemetry();

      assertNull(options.builtInMetricsProvider.getProjectId());
    } finally {
      options.builtInMetricsProvider.reset();
    }
  }

  @Test
  public void testInitializeBuiltInMetricsUsesDatabaseProject() {
    SpannerOptions options = newTestOptions();
    try {
      options.initializeBuiltInMetrics(DatabaseId.of("database-project", "i", "d"));
      options.initializeBuiltInMetrics(DatabaseId.of("other-project", "i", "d"));

      assertEquals("database-project", options.builtInMetricsProvider.getProjectId());
    } finally {
      options.builtInMetricsProvider.reset();
    }
  }

  @Test
  public void testDifferentCredentialsUseIsolatedExporters() throws Exception {
    Credentials credsA =
        OAuth2Credentials.create(new AccessToken("token-a", new Date(Long.MAX_VALUE)));
    Credentials credsB =
        OAuth2Credentials.create(new AccessToken("token-b", new Date(Long.MAX_VALUE)));
    SpannerOptions optionsA = newTestOptionsBuilder().setCredentials(credsA).build();
    SpannerOptions optionsB = newTestOptionsBuilder().setCredentials(credsB).build();
    assertNotSame(optionsA.builtInMetricsProvider, optionsB.builtInMetricsProvider);

    CapturingBuiltInMetricsProvider providerA = new CapturingBuiltInMetricsProvider();
    CapturingBuiltInMetricsProvider providerB = new CapturingBuiltInMetricsProvider();
    optionsA.builtInMetricsProvider = providerA;
    optionsB.builtInMetricsProvider = providerB;
    try {
      OpenTelemetry otelA = optionsA.getBuiltInOpenTelemetry();
      OpenTelemetry otelB = optionsB.getBuiltInOpenTelemetry();
      assertNotNull(otelA);
      assertNotNull(otelB);
      assertNotSame(otelA, otelB);

      assertEquals(1, providerA.createdExporters.size());
      assertEquals(1, providerB.createdExporters.size());
      assertSame(
          credsA,
          providerA
              .createdExporters
              .get(0)
              .getMetricServiceClient()
              .getSettings()
              .getCredentialsProvider()
              .getCredentials());
      assertSame(
          credsB,
          providerB
              .createdExporters
              .get(0)
              .getMetricServiceClient()
              .getSettings()
              .getCredentialsProvider()
              .getCredentials());
    } finally {
      providerA.reset();
      providerB.reset();
    }
  }

  @Test
  public void testDifferentMonitoringHostsUseIsolatedExporters() {
    SpannerOptions optionsA =
        newTestOptionsBuilder().setMonitoringHost("monitoring-a.example:443").build();
    SpannerOptions optionsB =
        newTestOptionsBuilder().setMonitoringHost("monitoring-b.example:443").build();
    assertNotSame(optionsA.builtInMetricsProvider, optionsB.builtInMetricsProvider);

    CapturingBuiltInMetricsProvider providerA = new CapturingBuiltInMetricsProvider();
    CapturingBuiltInMetricsProvider providerB = new CapturingBuiltInMetricsProvider();
    optionsA.builtInMetricsProvider = providerA;
    optionsB.builtInMetricsProvider = providerB;
    try {
      assertNotNull(optionsA.getBuiltInOpenTelemetry());
      assertNotNull(optionsB.getBuiltInOpenTelemetry());

      assertEquals(
          "monitoring-a.example:443",
          providerA.createdExporters.get(0).getMetricServiceClient().getSettings().getEndpoint());
      assertEquals(
          "monitoring-b.example:443",
          providerB.createdExporters.get(0).getMetricServiceClient().getSettings().getEndpoint());
    } finally {
      providerA.reset();
      providerB.reset();
    }
  }

  @Test
  public void testDifferentUniverseDomainsUseIsolatedExporters() {
    SpannerOptions optionsA =
        newTestOptionsBuilder().setUniverseDomain("universe-a.example").build();
    SpannerOptions optionsB =
        newTestOptionsBuilder().setUniverseDomain("universe-b.example").build();
    assertNotSame(optionsA.builtInMetricsProvider, optionsB.builtInMetricsProvider);

    CapturingBuiltInMetricsProvider providerA = new CapturingBuiltInMetricsProvider();
    CapturingBuiltInMetricsProvider providerB = new CapturingBuiltInMetricsProvider();
    optionsA.builtInMetricsProvider = providerA;
    optionsB.builtInMetricsProvider = providerB;
    try {
      assertNotNull(optionsA.getBuiltInOpenTelemetry());
      assertNotNull(optionsB.getBuiltInOpenTelemetry());

      assertEquals(
          "universe-a.example",
          providerA
              .createdExporters
              .get(0)
              .getMetricServiceClient()
              .getSettings()
              .getUniverseDomain());
      assertEquals(
          "monitoring.universe-a.example:443",
          providerA.createdExporters.get(0).getMetricServiceClient().getSettings().getEndpoint());
      assertEquals(
          "universe-b.example",
          providerB
              .createdExporters
              .get(0)
              .getMetricServiceClient()
              .getSettings()
              .getUniverseDomain());
      assertEquals(
          "monitoring.universe-b.example:443",
          providerB.createdExporters.get(0).getMetricServiceClient().getSettings().getEndpoint());
    } finally {
      providerA.reset();
      providerB.reset();
    }
  }

  @Test
  public void testDifferentClientsHaveIsolatedFallbackProjectAndClientUid() {
    SpannerOptions optionsA = newTestOptions();
    SpannerOptions optionsB = newTestOptions();
    try {
      optionsA.initializeBuiltInMetrics(DatabaseId.of("project-a", "i", "d"));
      optionsB.initializeBuiltInMetrics(DatabaseId.of("project-b", "i", "d"));

      assertEquals("project-a", optionsA.builtInMetricsProvider.getProjectId());
      assertEquals("project-b", optionsB.builtInMetricsProvider.getProjectId());

      String uidA =
          optionsA
              .builtInMetricsProvider
              .createClientAttributes()
              .get(BuiltInMetricsConstant.CLIENT_UID_KEY.getKey());
      String uidB =
          optionsB
              .builtInMetricsProvider
              .createClientAttributes()
              .get(BuiltInMetricsConstant.CLIENT_UID_KEY.getKey());
      assertNotNull(uidA);
      assertNotNull(uidB);
      assertNotEquals(uidA, uidB);
      assertEquals(
          BuiltInMetricsProvider.generateClientHash(uidA),
          optionsA
              .builtInMetricsProvider
              .createResourceAttributes("project-a")
              .get(BuiltInMetricsConstant.CLIENT_HASH_KEY));
      assertEquals(
          BuiltInMetricsProvider.generateClientHash(uidB),
          optionsB
              .builtInMetricsProvider
              .createResourceAttributes("project-b")
              .get(BuiltInMetricsConstant.CLIENT_HASH_KEY));
    } finally {
      optionsA.builtInMetricsProvider.reset();
      optionsB.builtInMetricsProvider.reset();
    }
  }

  @Test
  public void testSpannerCloseShutsDownOnlyClosedClientsExporterAndIsIdempotent() {
    SpannerOptions optionsA = newTestOptions();
    SpannerOptions optionsB = newTestOptions();
    CapturingBuiltInMetricsProvider providerA = new CapturingBuiltInMetricsProvider();
    CapturingBuiltInMetricsProvider providerB = new CapturingBuiltInMetricsProvider();
    optionsA.builtInMetricsProvider = providerA;
    optionsB.builtInMetricsProvider = providerB;
    SpannerImpl spannerA = new SpannerImpl(mock(SpannerRpc.class), optionsA);
    SpannerImpl spannerB = new SpannerImpl(mock(SpannerRpc.class), optionsB);
    try {
      assertNotNull(optionsA.getBuiltInOpenTelemetry());
      assertNotNull(optionsB.getBuiltInOpenTelemetry());
      SpannerCloudMonitoringExporter exporterA = providerA.createdExporters.get(0);
      SpannerCloudMonitoringExporter exporterB = providerB.createdExporters.get(0);
      assertTrue(providerA.hasShutdownHook());
      assertTrue(providerB.hasShutdownHook());
      assertFalse(exporterA.getMetricServiceClient().isShutdown());
      assertFalse(exporterB.getMetricServiceClient().isShutdown());

      spannerA.close();

      assertTrue(exporterA.getMetricServiceClient().isShutdown());
      assertFalse(providerA.hasShutdownHook());
      assertNull(providerA.getOpenTelemetry());
      assertFalse(exporterB.getMetricServiceClient().isShutdown());
      assertTrue(providerB.hasShutdownHook());
      assertNotNull(providerB.getOpenTelemetry());

      // Closing the provider again is idempotent.
      providerA.close();
      assertFalse(providerA.hasShutdownHook());
    } finally {
      if (!spannerB.isClosed()) {
        spannerB.close();
      }
      providerA.reset();
      providerB.reset();
    }
    assertTrue(providerB.createdExporters.get(0).getMetricServiceClient().isShutdown());
    assertFalse(providerB.hasShutdownHook());
  }

  @Test
  public void testReuseSpannerOptionsAfterCloseCreatesFreshOpenTelemetry() {
    SpannerOptions options = newTestOptions();
    CapturingBuiltInMetricsProvider provider = new CapturingBuiltInMetricsProvider();
    options.builtInMetricsProvider = provider;
    try {
      options.initializeBuiltInMetrics(DatabaseId.of("project-first", "i", "d"));
      String firstUid =
          provider.createClientAttributes().get(BuiltInMetricsConstant.CLIENT_UID_KEY.getKey());
      OpenTelemetry firstOtel = options.getBuiltInOpenTelemetry();
      assertNotNull(firstOtel);
      SpannerCloudMonitoringExporter firstExporter = provider.createdExporters.get(0);

      new SpannerImpl(mock(SpannerRpc.class), options).close();

      assertTrue(firstExporter.getMetricServiceClient().isShutdown());
      assertNull(provider.getProjectId());
      assertFalse(provider.hasShutdownHook());

      options.initializeBuiltInMetrics(DatabaseId.of("project-second", "i", "d"));
      String secondUid =
          provider.createClientAttributes().get(BuiltInMetricsConstant.CLIENT_UID_KEY.getKey());
      OpenTelemetry secondOtel = options.getBuiltInOpenTelemetry();
      assertNotNull(secondOtel);
      assertNotSame(firstOtel, secondOtel);
      assertNotEquals(firstUid, secondUid);
      assertEquals("project-second", provider.getProjectId());
      assertTrue(provider.hasShutdownHook());
      assertFalse(provider.createdExporters.get(1).getMetricServiceClient().isShutdown());
    } finally {
      provider.reset();
    }
  }

  @Test
  public void testToBuilderCreatesIsolatedBuiltInMetricsProvider() {
    SpannerOptions optionsA = newTestOptions();
    SpannerOptions optionsB = optionsA.toBuilder().build();
    try {
      assertNotSame(optionsA.builtInMetricsProvider, optionsB.builtInMetricsProvider);
      optionsA.initializeBuiltInMetrics(DatabaseId.of("project-a", "i", "d"));
      assertEquals("project-a", optionsA.builtInMetricsProvider.getProjectId());
      assertNull(optionsB.builtInMetricsProvider.getProjectId());
    } finally {
      optionsA.builtInMetricsProvider.reset();
      optionsB.builtInMetricsProvider.reset();
    }
  }

  @Test
  public void testConcurrentCloseWaitsForInLockCreationAndShutsDownCreatedProvider()
      throws Exception {
    CountDownLatch exporterEntered = new CountDownLatch(1);
    CountDownLatch allowExporterFinish = new CountDownLatch(1);
    List<SpannerCloudMonitoringExporter> createdExporters = new ArrayList<>();
    BuiltInMetricsProvider provider =
        new BuiltInMetricsProvider() {
          @Override
          MetricExporter createExporter(
              Supplier<String> fallbackProjectIdSupplier,
              Map<String, String> clientAttributes,
              @Nullable Credentials credentials,
              @Nullable String monitoringHost,
              String universeDomain)
              throws IOException {
            if (createdExporters.isEmpty()) {
              exporterEntered.countDown();
              try {
                assertTrue(allowExporterFinish.await(5L, TimeUnit.SECONDS));
              } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new IOException(e);
              }
            }
            SpannerCloudMonitoringExporter exporter =
                (SpannerCloudMonitoringExporter)
                    super.createExporter(
                        fallbackProjectIdSupplier,
                        clientAttributes,
                        credentials,
                        monitoringHost,
                        universeDomain);
            createdExporters.add(exporter);
            return exporter;
          }
        };

    Credentials creds =
        OAuth2Credentials.create(new AccessToken("token", new Date(Long.MAX_VALUE)));
    AtomicReference<OpenTelemetry> createdOtel = new AtomicReference<>();
    Thread creator =
        new Thread(
            () ->
                createdOtel.set(
                    provider.getOrCreateOpenTelemetry("p", creds, null, "googleapis.com")));
    Thread closer = new Thread(provider::close);
    try {
      creator.start();
      assertTrue(exporterEntered.await(5L, TimeUnit.SECONDS));
      closer.start();
      long waitStart = System.nanoTime();
      while (closer.getState() != Thread.State.BLOCKED
          && TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - waitStart) < 5L) {
        Thread.yield();
      }
      assertEquals(Thread.State.BLOCKED, closer.getState());
      allowExporterFinish.countDown();
      creator.join(5000L);
      closer.join(5000L);
      assertFalse(creator.isAlive());
      assertFalse(closer.isAlive());
      assertNotNull(createdOtel.get());
      assertEquals(1, createdExporters.size());
      assertTrue(createdExporters.get(0).getMetricServiceClient().isShutdown());
      assertFalse(provider.hasShutdownHook());
      assertNull(provider.getOpenTelemetry());

      OpenTelemetry reopened =
          provider.getOrCreateOpenTelemetry("p", creds, null, "googleapis.com");
      assertNotNull(reopened);
      assertNotSame(createdOtel.get(), reopened);
      assertTrue(provider.hasShutdownHook());
      assertFalse(createdExporters.get(1).getMetricServiceClient().isShutdown());
    } finally {
      allowExporterFinish.countDown();
      provider.reset();
    }
  }

  @Test
  public void testEnableGrpcMetricsNoOpsWhenExporterCreationThrowsIOException() {
    BuiltInMetricsProvider provider =
        new BuiltInMetricsProvider() {
          @Override
          MetricExporter createExporter(
              Supplier<String> fallbackProjectIdSupplier,
              Map<String, String> clientAttributes,
              @Nullable Credentials credentials,
              @Nullable String monitoringHost,
              String universeDomain)
              throws IOException {
            throw new IOException("simulated exporter failure");
          }
        };
    InstantiatingGrpcChannelProvider.Builder channelProviderBuilder =
        InstantiatingGrpcChannelProvider.newBuilder();
    Credentials creds =
        OAuth2Credentials.create(new AccessToken("token", new Date(Long.MAX_VALUE)));

    provider.enableGrpcMetrics(channelProviderBuilder, "p", creds, null, "googleapis.com");
    assertNull(channelProviderBuilder.getChannelConfigurator());
    assertNull(provider.getOpenTelemetry());
    assertFalse(provider.hasShutdownHook());

    provider.enableGrpcMetrics(channelProviderBuilder, null);
    assertNull(channelProviderBuilder.getChannelConfigurator());
  }

  @Test
  public void testInjectedOpenTelemetrySurvivesCloseAndClosesOnReset() {
    BuiltInMetricsProvider provider = new BuiltInMetricsProvider();
    InMemoryMetricReader reader = InMemoryMetricReader.create();
    OpenTelemetrySdk injected =
        OpenTelemetrySdk.builder()
            .setMeterProvider(SdkMeterProvider.builder().registerMetricReader(reader).build())
            .build();
    try {
      provider.setOpenTelemetry(injected);
      injected.getMeter("test-meter").counterBuilder("test_counter").build().add(1L);

      provider.close();

      assertNull(provider.getOpenTelemetry());
      assertFalse(reader.collectAllMetrics().isEmpty());

      provider.setOpenTelemetry(injected);
      provider.reset();

      assertNull(provider.getOpenTelemetry());
      assertTrue(reader.collectAllMetrics().isEmpty());
    } finally {
      injected.close();
    }
  }

  @Test
  public void testBoundedSpannerCloseReturnsWithinTimeoutWhenExporterBlocks() throws Exception {
    CountDownLatch exportInvoked = new CountDownLatch(1);
    CompletableResultCode blockingExportResult = new CompletableResultCode();
    CompletableResultCode blockingShutdownResult = new CompletableResultCode();
    MetricExporter blockingExporter =
        new MetricExporter() {
          @Override
          public CompletableResultCode export(Collection<MetricData> metrics) {
            exportInvoked.countDown();
            return blockingExportResult;
          }

          @Override
          public CompletableResultCode flush() {
            return CompletableResultCode.ofSuccess();
          }

          @Override
          public CompletableResultCode shutdown() {
            return blockingShutdownResult;
          }

          @Override
          public AggregationTemporality getAggregationTemporality(InstrumentType instrumentType) {
            return AggregationTemporality.CUMULATIVE;
          }
        };

    SpannerOptions options = newTestOptions();
    BuiltInMetricsProvider provider =
        new BuiltInMetricsProvider() {
          @Override
          MetricExporter createExporter(
              Supplier<String> fallbackProjectIdSupplier,
              Map<String, String> clientAttributes,
              @Nullable Credentials credentials,
              @Nullable String monitoringHost,
              String universeDomain) {
            return blockingExporter;
          }
        };
    options.builtInMetricsProvider = provider;
    SpannerImpl spanner = new SpannerImpl(mock(SpannerRpc.class), options);
    try {
      OpenTelemetry otel = options.getBuiltInOpenTelemetry();
      assertNotNull(otel);
      assertTrue(provider.hasShutdownHook());
      // Record a point so PeriodicMetricReader.shutdown() must invoke export(...) on final flush.
      otel.getMeter(BuiltInMetricsConstant.METER_NAME)
          .counterBuilder("test_counter")
          .build()
          .add(1L);

      long startNanos = System.nanoTime();
      spanner.close(200L, TimeUnit.MILLISECONDS);
      long elapsedMillis = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - startNanos);

      assertTrue(
          "Expected final flush export to be invoked", exportInvoked.await(2L, TimeUnit.SECONDS));
      assertTrue(
          "Expected bounded close to return within 2s, took " + elapsedMillis + "ms",
          elapsedMillis < 2000L);
      assertFalse(provider.hasShutdownHook());
      assertNull(provider.getOpenTelemetry());
    } finally {
      blockingExportResult.succeed();
      blockingShutdownResult.succeed();
      provider.reset();
    }
  }

  private void verifyHash(String hash) {
    // Check if the hash length is 6
    assertEquals(hash.length(), 6);
    // Check if the hash is in the range [000000, 0003ff]
    long hashValue = Long.parseLong(hash, 16); // Convert hash from hex to decimal
    assertTrue(hashValue >= 0 && hashValue <= 0x3FF);
  }

  private SpannerOptions newTestOptions() {
    return newTestOptionsBuilder().build();
  }

  private SpannerOptions.Builder newTestOptionsBuilder() {
    return SpannerOptions.newBuilder()
        .setProjectId("host-project")
        // The builder picks up SPANNER_EMULATOR_HOST from the environment, and building with an
        // emulator host replaces the credentials below with NoCredentials. Built-in metrics are
        // disabled for a client without credentials, so leave the emulator out of these tests.
        .setEmulatorHost(null)
        .setCredentials(
            OAuth2Credentials.create(new AccessToken("test-token", new Date(Long.MAX_VALUE))));
  }

  private static final class CapturingBuiltInMetricsProvider extends BuiltInMetricsProvider {
    private final List<SpannerCloudMonitoringExporter> createdExporters = new ArrayList<>();

    @Override
    MetricExporter createExporter(
        Supplier<String> fallbackProjectIdSupplier,
        Map<String, String> clientAttributes,
        @Nullable Credentials credentials,
        @Nullable String monitoringHost,
        String universeDomain)
        throws IOException {
      SpannerCloudMonitoringExporter exporter =
          (SpannerCloudMonitoringExporter)
              super.createExporter(
                  fallbackProjectIdSupplier,
                  clientAttributes,
                  credentials,
                  monitoringHost,
                  universeDomain);
      createdExporters.add(exporter);
      return exporter;
    }
  }
}
