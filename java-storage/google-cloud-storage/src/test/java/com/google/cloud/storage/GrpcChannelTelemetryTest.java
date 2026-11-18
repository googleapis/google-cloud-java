/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.storage;

import static com.google.common.truth.Truth.assertThat;

import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.storage.GrpcChannelTelemetry.TransportType;
import com.google.storage.v2.StorageSettings;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public final class GrpcChannelTelemetryTest {

  private CapturingLogHandler logHandler;
  private Level previousLevel;
  private boolean previousUseParentHandlers;

  @Before
  public void setUp() {
    logHandler = new CapturingLogHandler();
    previousLevel = GrpcChannelTelemetry.LOG.getLevel();
    previousUseParentHandlers = GrpcChannelTelemetry.LOG.getUseParentHandlers();
    GrpcChannelTelemetry.LOG.setLevel(Level.ALL);
    GrpcChannelTelemetry.LOG.setUseParentHandlers(false);
    GrpcChannelTelemetry.LOG.addHandler(logHandler);
  }

  @After
  public void tearDown() {
    GrpcChannelTelemetry.LOG.removeHandler(logHandler);
    GrpcChannelTelemetry.LOG.setLevel(previousLevel);
    GrpcChannelTelemetry.LOG.setUseParentHandlers(previousUseParentHandlers);
  }

  @Test
  public void detectTransportType_allCases() {
    assertThat(GrpcChannelTelemetry.detectTransportType(null)).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("")).isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("storage.googleapis.com:443"))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("https://storage.googleapis.com"))
        .isEqualTo(TransportType.CLOUD_PATH);
    assertThat(GrpcChannelTelemetry.detectTransportType("google-c2p:///storage.googleapis.com"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p-experimental:///storage.googleapis.com"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?foo=1&force-xds=true"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p-experimental:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com?other=force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com#force-xds"))
        .isEqualTo(TransportType.DIRECT_PATH);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage-direct.googleapis.com?force-xds#section"))
        .isEqualTo(TransportType.DIRECT_PATH_INTERCONNECT);
    assertThat(
            GrpcChannelTelemetry.detectTransportType(
                "google-c2p:///storage.googleapis.com#frag?force-xds=1"))
        .isEqualTo(TransportType.DIRECT_PATH);
  }

  @Test
  public void extractHost_and_isDirectPathInterconnectHost() {
    assertThat(
            GrpcChannelTelemetry.extractHost(
                "google-c2p:///storage-direct.googleapis.com?force-xds"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(
            GrpcChannelTelemetry.extractHost(
                "google-c2p-experimental:///storage-preprod-direct.sandbox.googleapis.com:443?force-xds"))
        .isEqualTo("storage-preprod-direct.sandbox.googleapis.com");
    assertThat(GrpcChannelTelemetry.extractHost("google-c2p:///storage.googleapis.com/path"))
        .isEqualTo("storage.googleapis.com");
    assertThat(GrpcChannelTelemetry.extractHost("google-c2p:///storage.googleapis.com#frag"))
        .isEqualTo("storage.googleapis.com");
    assertThat(GrpcChannelTelemetry.extractHost("storage-direct.googleapis.com:443"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(GrpcChannelTelemetry.extractHost("storage-direct.googleapis.com"))
        .isEqualTo("storage-direct.googleapis.com");
    assertThat(GrpcChannelTelemetry.extractHost(null)).isEmpty();
    assertThat(GrpcChannelTelemetry.extractHost("")).isEmpty();

    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("storage-direct.googleapis.com"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost("storage-direct.googleapis.com:443"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost(
                "storage-preprod-direct.sandbox.googleapis.com"))
        .isTrue();
    assertThat(
            GrpcChannelTelemetry.isDirectPathInterconnectHost(
                "storage-preprod-direct.sandbox.googleapis.com:443"))
        .isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("storage.googleapis.com"))
        .isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost("custom.example.com")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectHost(null)).isFalse();
  }

  @Test
  public void logChannelConfiguration_validConfigurations_logInfo() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "storage.googleapis.com:443", "storage.googleapis.com", false, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=CloudPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", "storage.googleapis.com", false, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=DirectPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-direct.googleapis.com?force-xds", null, true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("Configured gRPC transport. requested_transport_type=DirectPathInterconnect");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("authority=storage-direct.googleapis.com");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds", null, true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.INFO);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("authority=storage-preprod-direct.sandbox.googleapis.com");
  }

  @Test
  public void logChannelConfiguration_warnings() {
    // Priority 1: gRPC version does not support force-xds
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-direct.googleapis.com?force-xds", null, true, false);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("DirectPath over Interconnect requires a gRPC version supporting force-xds");

    // Priority 2: interconnectEnabled = true, but effectiveEndpoint is CloudPath or DirectPath
    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "storage.googleapis.com:443", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
                + " it.");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=CloudPath");

    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=DirectPath");

    // Priority 3: force-xds active, but authority is not a -direct host
    logHandler.clear();
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com?force-xds", "storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
                + " over Interconnect host");
  }

  @Test
  public void isDirectPathInterconnectEnabled_envPrecedence() {
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, "true")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, " TRUE ")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, "false")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, " FALSE ")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, "invalid")).isTrue();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(false, "invalid")).isFalse();
    assertThat(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(true, null)).isTrue();
  }

  @Test
  public void grpcStorageOptions_attemptDirectPathFalse_overridesDirectPathOverInterconnect()
      throws Exception {
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPath(false)
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();

    StorageSettings settings = options.getStorageSettings();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            settings.getTransportChannelProvider().withCredentials(options.getCredentials());

    assertThat(provider.canUseDirectPath()).isFalse();
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("storage.googleapis.com:443");

    if (!Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DISABLE_DIRECT_PATH"))) {
      GrpcStorageOptions enabledOptions =
          StorageOptions.grpc()
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
              .build();
      InstantiatingGrpcChannelProvider enabledProvider =
          (InstantiatingGrpcChannelProvider)
              enabledOptions
                  .getStorageSettings()
                  .getTransportChannelProvider()
                  .withCredentials(enabledOptions.getCredentials());
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(enabledProvider, true))
          .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");

      GrpcStorageOptions preprodOptions =
          StorageOptions.grpc()
              .setHost("https://storage-preprod.sandbox.googleapis.com")
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
              .build();
      InstantiatingGrpcChannelProvider preprodProvider =
          (InstantiatingGrpcChannelProvider)
              preprodOptions
                  .getStorageSettings()
                  .getTransportChannelProvider()
                  .withCredentials(preprodOptions.getCredentials());
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(preprodProvider, true))
          .isEqualTo("google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds");

      GrpcStorageOptions unauthenticatedOptions =
          StorageOptions.grpc()
              .setAttemptDirectPathXdsOverInterconnect(true)
              .setCredentials(NoCredentials.getInstance())
              .build();
      InstantiatingGrpcChannelProvider unauthenticatedProvider =
          (InstantiatingGrpcChannelProvider)
              unauthenticatedOptions.getStorageSettings().getTransportChannelProvider();
      assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(unauthenticatedProvider, true))
          .isEqualTo("storage.googleapis.com:443");
    }
  }

  private static final class CapturingLogHandler extends Handler {
    private final List<LogRecord> records = new ArrayList<>();

    @Override
    public void publish(LogRecord record) {
      records.add(record);
    }

    @Override
    public void flush() {}

    @Override
    public void close() {}

    void clear() {
      records.clear();
    }
  }
}
