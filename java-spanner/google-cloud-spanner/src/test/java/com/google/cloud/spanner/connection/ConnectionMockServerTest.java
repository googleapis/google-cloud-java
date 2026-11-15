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

package com.google.cloud.spanner.connection;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import com.google.cloud.spanner.AbortedException;
import com.google.cloud.spanner.DatabaseClient;
import com.google.cloud.spanner.DatabaseId;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ConnectionMockServerTest extends AbstractMockServerTest {

  @Test
  public void testCommitAbortedWithRetryAbortsInternallyDisabledReleasesSession() throws Exception {
    try (Connection connection = createConnection()) {
      connection.setAutocommit(false);
      connection.setRetryAbortsInternally(false);
      connection.getDialect();

      DatabaseClient dbClient =
          connection.getSpanner().getDatabaseClient(DatabaseId.of("proj", "inst", "db"));
      Field muxField = dbClient.getClass().getDeclaredField("multiplexedSessionDatabaseClient");
      muxField.setAccessible(true);
      Object muxClient = muxField.get(dbClient);
      Method getReleased = muxClient.getClass().getDeclaredMethod("getNumSessionsReleased");
      getReleased.setAccessible(true);
      AtomicLong numSessionsReleased = (AtomicLong) getReleased.invoke(muxClient);
      long releasedBefore = numSessionsReleased.get();

      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      mockSpanner.abortNextStatement();
      assertThrows(AbortedException.class, connection::commit);

      assertEquals(releasedBefore + 1L, numSessionsReleased.get());

      // Starting and committing a subsequent transaction succeeds cleanly.
      assertEquals(1L, connection.executeUpdate(INSERT_STATEMENT));
      connection.commit();
      assertEquals(releasedBefore + 2L, numSessionsReleased.get());
    }
  }
}
