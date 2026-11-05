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

import com.google.bigtable.v2.SessionClientConfiguration;
import com.google.bigtable.v2.SessionDiversionConfiguration;
import com.google.bigtable.v2.SessionScopeDiversionConfiguration;

/**
 * The per-method diversion scopes this client implements, along with the single rule for resolving
 * a session load for each of them.
 *
 * <p>Two decisions depend on this rule: the per-RPC fork in {@code DivertingUnaryCallable}, and the
 * client wide "are sessions in use at all" decision in {@link ClientConfigurationManager}. They
 * must agree. If the client-wide check is the more permissive of the two, the client keeps session
 * pools alive and advertises session feature flags while never diverting a single request. Keeping
 * the scope list and the resolution rule in one place is what keeps them in sync.
 */
public enum SessionScope {
  READ_ROW("method:Bigtable.ReadRow", /* fallbackToGlobalSessionLoad= */ true),
  MUTATE_ROW("method:Bigtable.MutateRow", /* fallbackToGlobalSessionLoad= */ true),
  CHECK_AND_MUTATE_ROW(
      "method:Bigtable.CheckAndMutateRow", /* fallbackToGlobalSessionLoad= */ false),
  READ_MODIFY_WRITE_ROW(
      "method:Bigtable.ReadModifyWriteRow", /* fallbackToGlobalSessionLoad= */ false);

  private final String key;
  private final boolean fallbackToGlobalSessionLoad;

  SessionScope(String key, boolean fallbackToGlobalSessionLoad) {
    this.key = key;
    this.fallbackToGlobalSessionLoad = fallbackToGlobalSessionLoad;
  }

  /** The {@code method:<service>.<method>} key the server uses to address this scope. */
  public String getKey() {
    return key;
  }

  /**
   * Returns the fraction of this scope's traffic that should be served by sessions.
   *
   * <p>A {@link SessionDiversionConfiguration} is authoritative when present: the server only sends
   * the deprecated flat {@code session_load} to keep ReadRow and MutateRow working on older
   * clients, so this client ignores it entirely once a diversion configuration arrives.
   */
  @SuppressWarnings("deprecation")
  public float resolveSessionLoad(SessionClientConfiguration sessionConfig) {
    if (sessionConfig.hasSessionDiversionConfiguration()) {
      SessionDiversionConfiguration diversionConfig =
          sessionConfig.getSessionDiversionConfiguration();
      switch (diversionConfig.getDiversionStrategyCase()) {
        case GLOBAL_DIVERSION:
          return diversionConfig.getGlobalDiversion().getSessionLoad();
        case PER_SCOPE_DIVERSION:
          SessionScopeDiversionConfiguration scopeConfig =
              diversionConfig.getPerScopeDiversion().getScopeDiversionsMap().get(key);
          return scopeConfig != null ? scopeConfig.getSessionLoad() : 0f;
        default:
          return 0f;
      }
    }

    return fallbackToGlobalSessionLoad ? sessionConfig.getSessionLoad() : 0f;
  }

  /**
   * Returns true if the configuration routes a nonzero share of traffic to sessions for at least
   * one scope this client implements. Scopes the client does not serve are ignored: a diversion
   * entry for them cannot produce any session traffic, so it must not keep the session machinery
   * alive either.
   */
  public static boolean divertsAnyTraffic(SessionClientConfiguration sessionConfig) {
    for (SessionScope scope : values()) {
      if (scope.resolveSessionLoad(sessionConfig) > 0) {
        return true;
      }
    }
    return false;
  }
}
