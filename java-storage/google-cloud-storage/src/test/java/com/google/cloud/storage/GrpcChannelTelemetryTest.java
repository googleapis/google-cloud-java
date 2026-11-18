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
import static com.google.common.truth.Truth.assertWithMessage;
import static org.junit.Assume.assumeFalse;

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
    Object[][] cases = {
      {null, TransportType.CLOUD_PATH},
      {"", TransportType.CLOUD_PATH},
      {"storage.googleapis.com:443", TransportType.CLOUD_PATH},
      {"https://storage.googleapis.com", TransportType.CLOUD_PATH},
      {"google-c2p:///storage.googleapis.com", TransportType.DIRECT_PATH},
      {"google-c2p-experimental:///storage.googleapis.com", TransportType.DIRECT_PATH},
      {
        "google-c2p:///storage-direct.googleapis.com?force-xds",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {
        "google-c2p:///storage-direct.googleapis.com?foo=1&force-xds=true",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {
        "google-c2p-experimental:///storage-direct.googleapis.com?force-xds",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {"google-c2p:///storage.googleapis.com?other=force-xds", TransportType.DIRECT_PATH},
      {"google-c2p:///storage.googleapis.com#force-xds", TransportType.DIRECT_PATH},
      {
        "google-c2p:///storage-direct.googleapis.com?force-xds#section",
        TransportType.DIRECT_PATH_INTERCONNECT
      },
      {"google-c2p:///storage.googleapis.com#frag?force-xds=1", TransportType.DIRECT_PATH}
    };
    for (Object[] c : cases) {
      String endpoint = (String) c[0];
      TransportType expected = (TransportType) c[1];
      assertWithMessage("endpoint=%s", endpoint)
          .that(GrpcChannelTelemetry.detectTransportType(endpoint))
          .isEqualTo(expected);
    }
  }

  @Test
  public void extractHost_extractsNormalizedServerAddress() {
    String[][] cases = {
      {"google-c2p:///storage-direct.googleapis.com?force-xds", "storage-direct.googleapis.com"},
      {
        "google-c2p-experimental:///storage-preprod-direct.sandbox.googleapis.com:443?force-xds",
        "storage-preprod-direct.sandbox.googleapis.com"
      },
      {"google-c2p:///storage.googleapis.com/path", "storage.googleapis.com"},
      {"google-c2p:///storage.googleapis.com#frag", "storage.googleapis.com"},
      {"storage-direct.googleapis.com:443", "storage-direct.googleapis.com"},
      {"storage-direct.googleapis.com", "storage-direct.googleapis.com"},
      {null, ""},
      {"", ""}
    };
    for (String[] c : cases) {
      assertWithMessage("input=%s", c[0])
          .that(GrpcChannelTelemetry.extractHost(c[0]))
          .isEqualTo(c[1]);
    }
  }

  @Test
  public void isDirectPathInterconnectHost_matchesDirectHostsOnly() {
    Object[][] cases = {
      {"storage-direct.googleapis.com", true},
      {"storage-direct.googleapis.com:443", true},
      {"storage-preprod-direct.sandbox.googleapis.com", true},
      {"storage-preprod-direct.sandbox.googleapis.com:443", true},
      {"storage.googleapis.com", false},
      {"custom.example.com", false},
      {null, false}
    };
    for (Object[] c : cases) {
      String host = (String) c[0];
      boolean expected = (Boolean) c[1];
      assertWithMessage("host=%s", host)
          .that(GrpcChannelTelemetry.isDirectPathInterconnectHost(host))
          .isEqualTo(expected);
    }
  }

  @Test
  public void logChannelConfiguration_validConfigurations_logInfo() {
    Object[][] cases = {
      {"storage.googleapis.com:443", false, "CloudPath", "storage.googleapis.com"},
      {"google-c2p:///storage.googleapis.com", false, "DirectPath", "storage.googleapis.com"},
      {
        "google-c2p:///storage-direct.googleapis.com?force-xds",
        true,
        "DirectPathInterconnect",
        "storage-direct.googleapis.com"
      },
      {
        "google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds",
        true,
        "DirectPathInterconnect",
        "storage-preprod-direct.sandbox.googleapis.com"
      }
    };
    for (int i = 0; i < cases.length; i++) {
      String endpoint = (String) cases[i][0];
      boolean interconnectEnabled = (Boolean) cases[i][1];
      String expectedTransport = (String) cases[i][2];
      String expectedAuthority = (String) cases[i][3];
      GrpcChannelTelemetry.logChannelConfiguration(endpoint, interconnectEnabled, true);
      LogRecord record = logHandler.records.get(i);
      assertWithMessage(endpoint).that(record.getLevel()).isEqualTo(Level.INFO);
      assertWithMessage(endpoint)
          .that(record.getMessage())
          .contains("Configured gRPC transport. requested_transport_type=" + expectedTransport);
      assertWithMessage(endpoint)
          .that(record.getMessage())
          .contains("authority=" + expectedAuthority);
    }
  }

  @Test
  public void logChannelConfiguration_unsupportedGrpcForceXds_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage-direct.googleapis.com?force-xds", true, false);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("DirectPath over Interconnect requires a gRPC version supporting force-xds");
  }

  @Test
  public void logChannelConfiguration_interconnectOverriddenByCloudPath_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration("storage.googleapis.com:443", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is enabled, but the effective endpoint does not request"
                + " it.");
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=CloudPath");
  }

  @Test
  public void logChannelConfiguration_interconnectOverriddenByDirectPath_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains("requested_transport_type=DirectPath");
  }

  @Test
  public void logChannelConfiguration_nonDirectAuthorityWithForceXds_logsWarning() {
    GrpcChannelTelemetry.logChannelConfiguration(
        "google-c2p:///storage.googleapis.com?force-xds", true, true);
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
    assertThat(logHandler.records.get(0).getMessage())
        .contains(
            "DirectPath over Interconnect is active, but the channel authority is not a DirectPath"
                + " over Interconnect host");
  }

  @Test
  public void isDirectPathInterconnectEnabled_envPrecedence() {
    Object[][] cases = {
      {false, "true", true},
      {false, " TRUE ", true},
      {true, "false", false},
      {true, " FALSE ", false},
      {true, "invalid", true},
      {false, "invalid", false},
      {true, null, true}
    };
    for (Object[] c : cases) {
      boolean builderOption = (Boolean) c[0];
      String envValue = (String) c[1];
      boolean expected = (Boolean) c[2];
      assertWithMessage("builder=%s, env=%s", builderOption, envValue)
          .that(GrpcChannelTelemetry.isDirectPathInterconnectEnabled(builderOption, envValue))
          .isEqualTo(expected);
    }
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
    assertThat(logHandler.records).hasSize(1);
    assertThat(logHandler.records.get(0).getLevel()).isEqualTo(Level.WARNING);
  }

  @Test
  public void grpcStorageOptions_directPathOverInterconnect_resolvesProdDirectTarget()
      throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options
                .getStorageSettings()
                .getTransportChannelProvider()
                .withCredentials(options.getCredentials());
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("google-c2p:///storage-direct.googleapis.com?force-xds");
  }

  @Test
  public void grpcStorageOptions_directPathOverInterconnect_resolvesPreprodDirectTarget()
      throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setHost("https://storage-preprod.sandbox.googleapis.com")
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(GoogleCredentials.create(new AccessToken("fake-token", null)))
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options
                .getStorageSettings()
                .getTransportChannelProvider()
                .withCredentials(options.getCredentials());
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("google-c2p:///storage-preprod-direct.sandbox.googleapis.com?force-xds");
  }

  @Test
  public void grpcStorageOptions_noCredentials_fallsBackToCloudPath() throws Exception {
    assumeDirectPathNotDisabledByEnv();
    GrpcStorageOptions options =
        StorageOptions.grpc()
            .setAttemptDirectPathXdsOverInterconnect(true)
            .setCredentials(NoCredentials.getInstance())
            .build();
    InstantiatingGrpcChannelProvider provider =
        (InstantiatingGrpcChannelProvider)
            options.getStorageSettings().getTransportChannelProvider();
    assertThat(GrpcChannelTelemetry.resolveEffectiveTarget(provider, true))
        .isEqualTo("storage.googleapis.com:443");
  }

  private static void assumeDirectPathNotDisabledByEnv() {
    assumeFalse(Boolean.parseBoolean(System.getenv("GOOGLE_CLOUD_DISABLE_DIRECT_PATH")));
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
  }
}
