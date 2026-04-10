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

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Lightweight MDC implementation for the BigQuery JDBC driver using InheritableThreadLocal.
 * Allocates a dedicated, independent InheritableThreadLocal object per concrete BigQueryConnection
 * instance.
 */
public class BigQueryJdbcMdc {
  private static final AtomicLong nextId = new AtomicLong(1);
  private static final ConcurrentHashMap<BigQueryConnection, InheritableThreadLocal<String>>
      instanceLocals = new ConcurrentHashMap<>();
  private static final ConcurrentHashMap<BigQueryConnection, String> instanceIds =
      new ConcurrentHashMap<>();

  /** Allocates an exclusive InheritableThreadLocal and registers the connection mapping. */
  private static final InheritableThreadLocal<String> currentConnectionId =
      new InheritableThreadLocal<>();

  public static void registerInstance(BigQueryConnection connection, String id) {
    if (connection != null) {
      String cleanId =
          instanceIds.computeIfAbsent(
              connection,
              k -> {
                String digits = (id != null) ? id.replaceAll("[^0-9]", "") : "";
                String numericPart =
                    digits.isEmpty() ? String.valueOf(nextId.getAndIncrement()) : digits;
                return "JdbcConnection-" + numericPart;
              });

      currentConnectionId.set(cleanId);
      InheritableThreadLocal<String> threadLocal =
          instanceLocals.computeIfAbsent(connection, k -> new InheritableThreadLocal<>());
      threadLocal.set(cleanId);
    }
  }

  /** Retrieves the connection ID mapped to a specific BigQueryConnection instance. */
  public static String getConnectionId(BigQueryConnection connection) {
    if (connection != null) {
      InheritableThreadLocal<String> local = instanceLocals.get(connection);
      if (local != null) {
        String val = local.get();
        if (val != null) {
          return val;
        }
      }
      return instanceIds.get(connection);
    }
    return null;
  }

  /**
   * Returns the connection ID carried by any registered active connection on the current thread.
   */
  public static String getConnectionId() {
    return currentConnectionId.get();
  }

  /** Clears the connection ID context from all active connection contexts on the current thread. */
  public static void removeInstance(BigQueryConnection connection) {
    if (connection != null) {
      InheritableThreadLocal<String> local = instanceLocals.remove(connection);
      if (local != null) {
        local.remove();
      }
      instanceIds.remove(connection);
    }
  }

  public static void clear() {
    currentConnectionId.remove();
    for (InheritableThreadLocal<String> local : instanceLocals.values()) {
      local.remove();
    }
    instanceLocals.clear();
    instanceIds.clear();
  }
}
