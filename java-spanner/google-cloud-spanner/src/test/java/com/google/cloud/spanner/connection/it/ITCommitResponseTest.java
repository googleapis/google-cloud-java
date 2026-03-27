/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.spanner.connection.it;

import static com.google.cloud.spanner.testing.EmulatorSpannerHelper.isUsingEmulator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeFalse;

import com.google.cloud.spanner.KeySet;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.ParallelIntegrationTest;
import com.google.cloud.spanner.ResultSet;
import com.google.cloud.spanner.Statement;
import com.google.cloud.spanner.connection.ITAbstractSpannerTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@Category(ParallelIntegrationTest.class)
@RunWith(JUnit4.class)
public class ITCommitResponseTest extends ITAbstractSpannerTest {
  @Override
  public void appendConnectionUri(StringBuilder uri) {
    uri.append(";autocommit=false");
  }

  @Override
  public boolean doCreateDefaultTestTable() {
    return true;
  }

  @Before
  public void clearTestData() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(Mutation.delete("TEST", KeySet.all()));
      connection.commit();
    }
  }

  @Test
  public void testDefaultNoCommitStats() {
    try (ITConnection connection = createConnection()) {
      connection.bufferedWrite(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      connection.commit();
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertFalse(connection.getCommitResponse().hasCommitStats());
    }
  }

  @Test
  public void testReturnCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.setReturnCommitStats(true);
      connection.bufferedWrite(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      connection.commit();
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertTrue(connection.getCommitResponse().hasCommitStats());
      assertEquals(2L, connection.getCommitResponse().getCommitStats().getMutationCount());
    }
  }

  @Test
  public void testReturnCommitStatsUsingSql() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.execute(Statement.of("SET RETURN_COMMIT_STATS=TRUE"));
      connection.bufferedWrite(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      connection.commit();
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertTrue(connection.getCommitResponse().hasCommitStats());
      assertEquals(2L, connection.getCommitResponse().getCommitStats().getMutationCount());
      try (ResultSet resultSet =
          connection.execute(Statement.of("SHOW VARIABLE COMMIT_RESPONSE")).getResultSet()) {
        assertTrue(resultSet.next());
        assertNotNull(resultSet.getTimestamp("COMMIT_TIMESTAMP"));
        assertEquals(2L, resultSet.getLong("MUTATION_COUNT"));
        assertFalse(resultSet.next());
      }
    }
  }

  @Test
  public void testAutocommitDefaultNoCommitStats() {
    try (ITConnection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.write(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertFalse(connection.getCommitResponse().hasCommitStats());
    }
  }

  @Test
  public void testAutocommitReturnCommitStats() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.setAutocommit(true);
      connection.setReturnCommitStats(true);
      connection.write(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertTrue(connection.getCommitResponse().hasCommitStats());
      assertEquals(2L, connection.getCommitResponse().getCommitStats().getMutationCount());
    }
  }

  @Test
  public void testAutocommitReturnCommitStatsUsingSql() {
    assumeFalse("Emulator does not return commit statistics", isUsingEmulator());
    try (ITConnection connection = createConnection()) {
      connection.execute(Statement.of("SET AUTOCOMMIT=TRUE"));
      connection.execute(Statement.of("SET RETURN_COMMIT_STATS=TRUE"));
      connection.write(
          Mutation.newInsertBuilder("TEST").set("ID").to(1L).set("NAME").to("TEST").build());
      assertNotNull(connection.getCommitResponse());
      assertNotNull(connection.getCommitResponse().getCommitTimestamp());
      assertTrue(connection.getCommitResponse().hasCommitStats());
      assertEquals(2L, connection.getCommitResponse().getCommitStats().getMutationCount());
      try (ResultSet resultSet =
          connection.execute(Statement.of("SHOW VARIABLE COMMIT_RESPONSE")).getResultSet()) {
        assertTrue(resultSet.next());
        assertNotNull(resultSet.getTimestamp("COMMIT_TIMESTAMP"));
        assertEquals(2L, resultSet.getLong("MUTATION_COUNT"));
        assertFalse(resultSet.next());
      }
    }
  }
}
