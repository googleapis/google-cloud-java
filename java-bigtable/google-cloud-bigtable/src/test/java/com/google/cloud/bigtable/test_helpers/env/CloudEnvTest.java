/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.bigtable.test_helpers.env;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.bigtable.v2.ClientConfiguration;
import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration.PerScopeDiversion;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;
import com.google.bigtable.v2.TelemetryConfiguration;
import com.google.cloud.bigtable.data.v2.internal.compat.DisabledShim;
import com.google.cloud.bigtable.data.v2.internal.compat.ShimImpl;
import com.google.cloud.bigtable.data.v2.internal.util.ClientConfigurationManager;
import com.google.cloud.bigtable.data.v2.internal.util.SessionScope;
import org.junit.jupiter.api.Test;

class CloudEnvTest {

  private static ShimImpl shimWithConfig(ClientConfiguration config) {
    ClientConfigurationManager configManager = mock(ClientConfigurationManager.class);
    when(configManager.getClientConfiguration()).thenReturn(config);
    ShimImpl shim = mock(ShimImpl.class);
    when(shim.getConfigManager()).thenReturn(configManager);
    return shim;
  }

  @Test
  void emulatorEnv_sessionsDisabled() {
    assertThat(EmulatorEnv.createBundled().isSessionsEnabled()).isFalse();
  }

  @Test
  void disabledShim_sessionsDisabled() {
    assertThat(CloudEnv.isSessionsEnabled(new DisabledShim())).isFalse();
  }

  @Test
  void defaultClientConfig_sessionsDisabled() {
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(ClientConfiguration.getDefaultInstance())))
        .isFalse();
  }

  @Test
  void nonSessionConfigOverride_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setTelemetryConfiguration(
                TelemetryConfiguration.newBuilder()
                    .setDebugTagLevel(TelemetryConfiguration.Level.INFO))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }

  @Test
  void zeroGlobalSessionLoad_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setGlobalDiversion(
                                SessionScopeDiversionConfiguration.newBuilder()
                                    .setSessionLoad(0.0f))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }

  @Test
  void positiveGlobalSessionLoad_sessionsEnabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setGlobalDiversion(
                                SessionScopeDiversionConfiguration.newBuilder()
                                    .setSessionLoad(1.0f))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isTrue();
  }

  @Test
  void perScopeServedMethod_sessionsEnabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setPerScopeDiversion(
                                PerScopeDiversion.newBuilder()
                                    .putScopeDiversions(
                                        SessionScope.READ_ROW.getKey(),
                                        SessionScopeDiversionConfiguration.newBuilder()
                                            .setSessionLoad(0.5f)
                                            .build()))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isTrue();
  }

  @Test
  void perScopeUnservedMethod_sessionsDisabled() {
    ClientConfiguration config =
        ClientConfiguration.newBuilder()
            .setSessionConfiguration(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        SessionDiversionConfiguration.newBuilder()
                            .setPerScopeDiversion(
                                PerScopeDiversion.newBuilder()
                                    .putScopeDiversions(
                                        "method:Bigtable.UnknownMethod",
                                        SessionScopeDiversionConfiguration.newBuilder()
                                            .setSessionLoad(1.0f)
                                            .build()))))
            .build();
    assertThat(CloudEnv.isSessionsEnabled(shimWithConfig(config))).isFalse();
  }
}
