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

package com.google.cloud.bigquery.jdbc;

import java.nio.file.Path;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.LogRecord;

/**
 * Carries per-connection logging identity and threshold across threads and unproxied {@code
 * ResultSet} log records without colliding with user or library {@code String} log parameters.
 */
final class ConnectionLogContext {
  static final int OFF_VALUE = Level.OFF.intValue();
  static final int ALL_VALUE = Level.ALL.intValue();

  private final String connectionId;
  private final Path preConnectDir;
  private final boolean explicitLevel;
  private volatile int levelValue;

  ConnectionLogContext(String connectionId, int levelValue) {
    this(
        Objects.requireNonNull(connectionId, "connectionId cannot be null"),
        levelValue,
        null,
        true);
  }

  private ConnectionLogContext(
      String connectionId, int levelValue, Path preConnectDir, boolean explicitLevel) {
    this.connectionId = connectionId;
    this.levelValue = levelValue;
    this.preConnectDir = preConnectDir;
    this.explicitLevel = explicitLevel;
  }

  static ConnectionLogContext unregistered(String connectionId) {
    return new ConnectionLogContext(
        Objects.requireNonNull(connectionId, "connectionId cannot be null"),
        ALL_VALUE,
        null,
        false);
  }

  static ConnectionLogContext preConnect(int levelValue, Path preConnectDir) {
    return new ConnectionLogContext(null, levelValue, preConnectDir, true);
  }

  String connectionId() {
    return connectionId;
  }

  Path preConnectDir() {
    return preConnectDir;
  }

  boolean hasExplicitLevel() {
    return explicitLevel;
  }

  int levelValue() {
    return levelValue;
  }

  void setLevelValue(int levelValue) {
    this.levelValue = levelValue;
  }

  boolean isLoggable(Level level) {
    if (level == null || levelValue == OFF_VALUE) {
      return false;
    }
    if (levelValue == ALL_VALUE) {
      return true;
    }
    return level.intValue() >= levelValue;
  }

  static ConnectionLogContext extractFromParameters(LogRecord record) {
    if (record == null) {
      return null;
    }
    Object[] params = record.getParameters();
    if (params != null && params.length > 0 && params[0] instanceof ConnectionLogContext) {
      return (ConnectionLogContext) params[0];
    }
    return null;
  }

  @Override
  public String toString() {
    return connectionId != null ? connectionId : "NO_CONN";
  }
}
