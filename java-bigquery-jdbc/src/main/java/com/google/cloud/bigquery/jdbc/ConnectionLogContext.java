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
  static final int INHERIT_VALUE = ALL_VALUE + 1;

  private final String connectionId;
  private volatile int levelValue;

  ConnectionLogContext(String connectionId, int levelValue) {
    this.connectionId = Objects.requireNonNull(connectionId, "connectionId cannot be null");
    this.levelValue = levelValue;
  }

  String connectionId() {
    return connectionId;
  }

  int levelValue() {
    return levelValue;
  }

  void setLevelValue(int levelValue) {
    this.levelValue = levelValue;
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
    return connectionId;
  }
}
