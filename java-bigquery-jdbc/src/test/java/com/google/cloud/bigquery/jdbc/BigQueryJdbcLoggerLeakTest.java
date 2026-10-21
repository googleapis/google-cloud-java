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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;

/**
 * Regression tests for logger registration leaks.
 *
 * <p>Every {@code java.util.logging.Logger} keeps a list of its child loggers so that level changes
 * on a parent propagate downwards. {@code Logger.setParent} appends to that list under a single
 * JVM-wide lock, and the entry is never removed when the child becomes garbage unless something
 * else happens to call {@code LogManager.addLogger}. A JDBC object that creates its own logger
 * therefore leaves a permanent entry on the shared driver root logger and makes every later
 * creation scan a longer list. These tests assert that constructing driver objects does not grow
 * that list.
 */
public class BigQueryJdbcLoggerLeakTest {

  private static final int OBJECT_COUNT = 1_000;

  @Test
  public void testCreatingStatementsDoesNotRegisterChildLoggers() throws Exception {
    BigQueryConnection connection = mock(BigQueryConnection.class);
    doReturn("leak-test-connection").when(connection).getConnectionId();
    doReturn(BigQueryConnection.SessionState.empty()).when(connection).getSessionStateSnapshot();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    // Warm up so that any one-time, class-level logger is registered before we measure.
    new BigQueryStatement(connection);
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryStatement(connection);
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " statements must not register additional child loggers on the driver root logger");
  }

  @Test
  public void testCreatingDatabaseMetaDataDoesNotRegisterChildLoggers()
      throws ReflectiveOperationException {
    BigQueryConnection connection = mock(BigQueryConnection.class);
    doReturn("leak-test-connection").when(connection).getConnectionId();

    Logger rootLogger = BigQueryJdbcRootLogger.getRootLogger();
    new BigQueryDatabaseMetaData(connection);
    int childrenBefore = childLoggerCount(rootLogger);

    for (int i = 0; i < OBJECT_COUNT; i++) {
      new BigQueryDatabaseMetaData(connection);
    }

    assertEquals(
        childrenBefore,
        childLoggerCount(rootLogger),
        "Creating "
            + OBJECT_COUNT
            + " DatabaseMetaData objects must not register additional child loggers on the driver"
            + " root logger");
  }

  /**
   * Reads the JDK-internal {@code Logger.kids} list. This field is private to {@code java.logging},
   * so the surefire {@code argLine} opens {@code java.util.logging} to the test classpath.
   */
  private static int childLoggerCount(Logger logger) throws ReflectiveOperationException {
    Field kids = Logger.class.getDeclaredField("kids");
    kids.setAccessible(true);
    List<?> children = (List<?>) kids.get(logger);
    return children == null ? 0 : children.size();
  }
}
