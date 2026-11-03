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
package com.google.cloud.bigtable.data.v2.internal.util;

import static com.google.common.truth.Truth.assertThat;

import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration.PerScopeDiversion;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;
import org.junit.jupiter.api.Test;

@SuppressWarnings("deprecation") // exercises the deprecated flat session_load on purpose
class SessionScopeTest {

  @Test
  void noDiversionConfig_fallbackScopesUseFlatSessionLoad() {
    SessionClientConfiguration config = sessionLoad(0.75f).build();

    assertThat(SessionScope.READ_ROW.resolveSessionLoad(config)).isEqualTo(0.75f);
    assertThat(SessionScope.MUTATE_ROW.resolveSessionLoad(config)).isEqualTo(0.75f);
  }

  @Test
  void noDiversionConfig_nonFallbackScopesIgnoreFlatSessionLoad() {
    SessionClientConfiguration config = sessionLoad(0.75f).build();

    assertThat(SessionScope.CHECK_AND_MUTATE_ROW.resolveSessionLoad(config)).isEqualTo(0f);
    assertThat(SessionScope.READ_MODIFY_WRITE_ROW.resolveSessionLoad(config)).isEqualTo(0f);
  }

  @Test
  void diversionConfigPresent_flatSessionLoadIsIgnoredEntirely() {
    // The server only sends the flat load for older clients. Once a diversion config arrives it is
    // authoritative, including for scopes it does not mention.
    SessionClientConfiguration config =
        sessionLoad(1.0f)
            .setSessionDiversionConfiguration(perScope("method:Bigtable.CheckAndMutateRow", 0.1f))
            .build();

    assertThat(SessionScope.CHECK_AND_MUTATE_ROW.resolveSessionLoad(config)).isEqualTo(0.1f);
    assertThat(SessionScope.READ_ROW.resolveSessionLoad(config)).isEqualTo(0f);
    assertThat(SessionScope.MUTATE_ROW.resolveSessionLoad(config)).isEqualTo(0f);
  }

  @Test
  void emptyDiversionConfig_resolvesToZeroForEveryScope() {
    // An unset oneof, e.g. a future strategy this client cannot parse.
    SessionClientConfiguration config =
        sessionLoad(1.0f)
            .setSessionDiversionConfiguration(SessionDiversionConfiguration.getDefaultInstance())
            .build();

    for (SessionScope scope : SessionScope.values()) {
      assertThat(scope.resolveSessionLoad(config)).isEqualTo(0f);
    }
    assertThat(SessionScope.divertsAnyTraffic(config)).isFalse();
  }

  @Test
  void globalDiversionAppliesToEveryScope() {
    SessionClientConfiguration config =
        SessionClientConfiguration.newBuilder()
            .setSessionDiversionConfiguration(
                SessionDiversionConfiguration.newBuilder()
                    .setGlobalDiversion(
                        SessionScopeDiversionConfiguration.newBuilder().setSessionLoad(0.5f)))
            .build();

    for (SessionScope scope : SessionScope.values()) {
      assertThat(scope.resolveSessionLoad(config)).isEqualTo(0.5f);
    }
  }

  /**
   * The client-wide "are sessions in use" check must not be more permissive than the per-RPC fork.
   * A diversion entry for a method this client never routes through a session cannot produce
   * session traffic, so it must not keep session pools and feature flags alive either.
   */
  @Test
  void unservedScope_doesNotCountAsDivertingTraffic() {
    SessionClientConfiguration config =
        SessionClientConfiguration.newBuilder()
            .setSessionDiversionConfiguration(perScope("method:Bigtable.MutateRows", 1.0f))
            .build();

    for (SessionScope scope : SessionScope.values()) {
      assertThat(scope.resolveSessionLoad(config)).isEqualTo(0f);
    }
    assertThat(SessionScope.divertsAnyTraffic(config)).isFalse();
  }

  @Test
  void divertsAnyTraffic_trueWhenAnyServedScopeDiverts() {
    assertThat(
            SessionScope.divertsAnyTraffic(
                SessionClientConfiguration.newBuilder()
                    .setSessionDiversionConfiguration(
                        perScope("method:Bigtable.ReadModifyWriteRow", 0.01f))
                    .build()))
        .isTrue();
    assertThat(SessionScope.divertsAnyTraffic(sessionLoad(0.25f).build())).isTrue();
    assertThat(SessionScope.divertsAnyTraffic(sessionLoad(0f).build())).isFalse();
  }

  private static SessionClientConfiguration.Builder sessionLoad(float load) {
    return SessionClientConfiguration.newBuilder().setSessionLoad(load);
  }

  private static SessionDiversionConfiguration perScope(String key, float load) {
    return SessionDiversionConfiguration.newBuilder()
        .setPerScopeDiversion(
            PerScopeDiversion.newBuilder()
                .putScopeDiversions(
                    key,
                    SessionScopeDiversionConfiguration.newBuilder().setSessionLoad(load).build()))
        .build();
  }
}
