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

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Lightweight MDC implementation for the BigQuery JDBC driver using InheritableThreadLocal.
 */
class BigQueryJdbcMdc {
  private static final InheritableThreadLocal<String> currentConnectionId =
      new InheritableThreadLocal<>();

  /** Sets the current connection context on the executing thread. */
  static MdcCloseable registerInstance(String connectionId) {
    if (connectionId != null) {
      currentConnectionId.set(connectionId);
    }
    return () -> clear();
  }

  /**
   * Returns the connection ID carried by any registered active connection on the current thread.
   */
  static String getConnectionId() {
    return currentConnectionId.get();
  }

  static void clear() {
    currentConnectionId.remove();
  }

  /**
   * Functional interface that extends AutoCloseable to avoid throwing checked exceptions in
   * try-with-resources.
   */
  @FunctionalInterface
  interface MdcCloseable extends AutoCloseable {
    @Override
    void close();
  }
}
